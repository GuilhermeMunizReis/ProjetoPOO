import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection connection; // objeto para conexão com o servidor do MySQL
    Statement statement; // objeto para preparar consultas (SELECT)
    ResultSet result; // objeto para executar consultas (SELECT)
    PreparedStatement pst; // objetos para querys de manipulação dinâmica (INSERT, UPDATE, DELETE)

    static final String user = "root";
    static final String password = "coladmin!";
    static final String database = "rpg";
    //static final String url = "jdbc:mysql://localhost:3306/" + database+ "?allowPublicKeyRetrieval=true&useSSL=false";
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false?allowPublicKeyRetrieval=true&useSSL=false";
    private boolean check = false;

    // ---- Método de conexão ----
    public void connect(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao feita com sucesso "+connection);
        }catch(SQLException e){
            System.out.println("Erro de conexao: "+e.getMessage());
        }
    }

    // ---- Método de inserção ----
    public boolean insertPersonagem(Personagem personagem){
        connect();
        String sql = "INSERT INTO Personagem(nome, classe, raca, antecedente, nivel, xp, destreza, forca, constituicao, sabedoria, " +
                "inteligencia, carisma, modDestreza, modForca, modConstituicao, modSabedoria, modInteligencia, modCarisma," +
                "pvAtual, pvMax, movimento, movimentoMax, Jogador_idJogador) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, personagem.getNome());
            pst.setString(2, personagem.getClasse());
            pst.setString(3, personagem.getRaca());
            pst.setString(4, personagem.getAntecedente());
            pst.setInt(5, personagem.getNivel());
            pst.setInt(7, personagem.getDestreza());
            pst.setInt(8, personagem.getForca());
            pst.setInt(9, personagem.getConstituicao());
            pst.setInt(10, personagem.getSabedoria());
            pst.setInt(11, personagem.getInteligencia());
            pst.setInt(12, personagem.getCarisma());
            pst.setInt(13, personagem.getModDestreza());
            pst.setInt(14, personagem.getModForca());
            pst.setInt(15, personagem.getModConstituicao());
            pst.setInt(16, personagem.getModSabedoria());
            pst.setInt(17, personagem.getModInteligencia());
            pst.setInt(18, personagem.getModCarisma());
            pst.setInt(19, personagem.getPvAtual());
            pst.setInt(20, personagem.getPvMax());
            pst.setInt(23, personagem.getJogador().getId());
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao "+e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }

    public boolean insertJogador(Jogador jogador){
        connect();
        String sql = "INSERT INTO Jogador (idJogador, nomeJogador) VALUES (?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, jogador.getId());
            pst.setString(2, jogador.getNome());
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao "+e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }

    // ---- Método de busca ----
    public ArrayList<Personagem> researchPersonagem(){
        connect();
        ArrayList<Personagem> personagens = new ArrayList<>();
        String sql = "SELECT * FROM Personagem";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Personagem persTemp = new Personagem(result.getString("nome"), result.getString("classe"),
                        result.getString("raca"), result.getString("antecedente"), result.getInt("nivel"), result.getInt("xp"));
                persTemp.id = result.getInt("idPersonagem");
                System.out.println("ID: "+persTemp.id);
                System.out.println("Nome: "+persTemp.getNome());
                System.out.println("Classe: "+persTemp.getClasse());
                System.out.println("Raca: "+persTemp.getRaca());
                System.out.println("Antecedente: "+persTemp.getAntecedente());
                System.out.println("Nivel: "+persTemp.getNivel());
                System.out.println("XP: "+persTemp.getXp());
                System.out.println("-----------------------------------");
                personagens.add(persTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
        }finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }

        return personagens;
    }

    // ---- Método de atualização ----
    public boolean updatePersonagem(int id, String nome){
        connect();
        String sql = "UPDATE Personagem SET nome=? WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }

    // ---- Método de exclusão ----
    public boolean deletePersonagem(String nome){
        connect();
        String sql = "DELETE FROM Personagem WHERE nome=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
}

