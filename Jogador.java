public class Jogador {
    private int id;
    private static int cont = 0;
    private String nome;

    public Jogador(String nome){
        cont++;
        this.id = cont;
        this.nome = nome;
    }

    public void mostraInfo(){
        System.out.println("Nome: " + this.nome + "\tId: " + this.id);
    }

    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
}
