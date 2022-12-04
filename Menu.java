import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    int op1; // Opção de ação
    int op2; // Opção de tabela
    int op3; // Opção sobre o preenchimento de atributos

    ArrayList<Personagem> personagens = new ArrayList<>();
    ArrayList<Jogador> jogadores = new ArrayList<>();
    ArrayList<Mundo> mundos = new ArrayList<>();
    String nome;
    String classe;
    String raca;
    String antecedente;
    int nivel;
    int xp;
    int atri;
    int vida;
    int aux1;



    public void callMenu(){
        Database database = new Database();
        database.connect();

        Jogador jogador1 = new Jogador("Mariana");
        Personagem personagem1 = new Personagem("Shump", "Barbaro", "Meio-Orc",  "Gladiador",5, 20000);
        personagem1.setDestreza(13);
        personagem1.setForca(17);
        personagem1.setConstituicao(15);
        personagem1.setInteligencia(7);
        personagem1.setSabedoria(13);
        personagem1.setCarisma(10);

        personagem1.calcModificadores();
        personagem1.setPvAtual(140);
        personagem1.setPvMax(150);


        database.insertJogador(jogador1);
        database.insertPersonagem(personagem1);
        database.researchPersonagem();
        database.deletePersonagem("Shump");


        boolean flag = true;
        while(flag) {
            System.out.println("1 - Cadastrar informacoes\n2 - Pesquisar informacoes\n3 - Atualizar informacoes\n4 - Deletar informacoes\n5 - Sair");
            op1 = in.nextInt();

            while (op1 < 0 || op1 > 5) {
                System.out.println("1 - Jogador\n2 - Personagem\n3 - Arma\n4 - Armadura\n5 - Mundo\n6 - Sair");
                op2 = in.nextInt();
                switch (op1) {
                    case 1 -> {
                        in.nextLine();
                        switch (op2) {
                            case 1 -> {
                                criarJogador();
                                break;
                            }
                            case 2 -> {
                                criarPersonagem();
                                break;
                            }
                            case 3 -> {
                                criarArma();
                                break;
                            }
                            case 4 -> {
                                criarArmadura();
                                break;
                            }
                            case 5 -> {
                                criarMundo();
                                break;
                            }
                            case 6 -> {
                                break;
                            }
                        }
                    }
                    case 2 -> {
                        switch (op2) {
                            case 1 -> {
                                buscarJogador();
                                break;
                            }
                            case 2 -> {
                                buscarPersonagem();
                                break;
                            }
                            case 3 -> {
                                buscarArma();
                                break;
                            }
                            case 4 -> {
                                buscarArmadura();
                                break;
                            }
                            case 5 -> {
                                buscarMundo();
                                break;
                            }
                            case 6 -> {
                                break;
                            }
                        }
                    }
                    case 3 -> {
                        switch (op2) {
                            case 1 -> {
                            }
                            case 2 -> {
                            }
                            case 3 -> {
                            }
                            case 4 -> {
                            }
                            case 5 -> {
                            }
                            case 6 -> {
                            }
                        }
                    }
                    case 4 -> {
                        switch (op2) {
                            case 1 -> {
                                deletarJogador();
                                break;
                            }
                            case 2 -> {
                                deletarPersonagem();
                                break;
                            }
                            case 3 -> {
                                deletarArma();
                                break;
                            }
                            case 4 -> {
                                deletarArmadura();
                                break;
                            }
                            case 5 -> {
                                deletarMundo();
                                break;
                            }
                            case 6 -> {
                                break;
                            }
                        }
                    }
                    case 5 -> {
                        flag = false;
                        break;
                        }
                    }
                }
            }


    }

    private Jogador criarJogador(){
        System.out.print("Digite o nome do jogador: ");
        nome = in.nextLine();
        Jogador jogador = new Jogador(nome);
        jogadores.add(jogador);

        return jogador;
    }

    private void buscarJogador() {
        System.out.println("Insira o nome do jogador (Em branco para retornar): ");
        nome = in.nextLine();

        boolean flag = true;

        while (flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Jogador j : jogadores) {
                if (j.getNome().equals(nome)) {
                    j.mostraInfo();
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println("Insira novamente o nome do jogador (Em branco para retornar):");
            }
        }
    }

    private void deletarJogador(){
        System.out.println("Insira o nome do personagem que será deletado (Em branco para retornar): ");
        in.nextLine();

        boolean flag = true;

        while(flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Jogador j : jogadores) {
                if (j.getNome().equals(nome)) {
                    jogadores.remove(j);
                    flag = false;
                    break;
                }
            }
        }
    }

    private Personagem criarPersonagem(){
        System.out.println("---- Entre com as informacoes do personagem ----");
        System.out.print("Nome: ");
        nome = in.nextLine();
        System.out.print("Classe: ");
        classe = in.nextLine();
        System.out.print("Raca: ");
        raca = in.nextLine();
        System.out.print("Antecedente: ");
        antecedente = in.nextLine();
        System.out.print("Nivel: ");
        nivel = in.nextInt();
        System.out.print("XP: ");
        xp = in.nextInt();
        Personagem p = new Personagem(nome, classe, raca, antecedente, nivel, xp);
        System.out.println("1 - Gerar atributos aleatoriamente\n2 - Cadastrar atributos manualmente");
        op3 = in.nextInt();
        if(op3 == 1)
            p.gerarAtributos();
        else{
            System.out.print("Forca: ");
            atri = in.nextInt();
            p.setForca(atri);
            System.out.print("Destreza: ");
            atri = in.nextInt();
            p.setDestreza(atri);
            System.out.print("Constituicao: ");
            atri = in.nextInt();
            p.setConstituicao(atri);
            System.out.print("Inteligencia: ");
            atri = in.nextInt();
            p.setInteligencia(atri);
            System.out.print("Sabedoria: ");
            atri = in.nextInt();
            p.setSabedoria(atri);
            System.out.print("Carisma: ");
            atri = in.nextInt();
            p.setCarisma(atri);
        }
        p.calcModificadores();
        System.out.println("Quais os pontos de vida maximo do seu personagem?");
        vida = in.nextInt();
        p.setPvMax(vida);
        System.out.println("Com quantos pontos de vida seu personagem atualmente?");
        vida = in.nextInt();
        p.setPvAtual(vida);

        personagens.add(p);

        return p;
    }

    private void buscarPersonagem() {
        System.out.println("Insira o nome do personagem (Em branco para retornar): ");
        nome = in.nextLine();

        boolean flag = true;

        while (flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Personagem p : personagens) {
                if (p.getNome().equals(nome)) {
                    p.mostraInfo();
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println("Insira novamente o nome do personagem (Em branco para retornar):");
            }
        }
    }

    private void deletarPersonagem(){
        System.out.println("Digite o nome de personagem que será deletado (Em branco para retornar):");
        in.nextLine();

        boolean flag = true;

        while(flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Personagem p : personagens) {
                if (p.getNome().equals(nome)) {
                    personagens.remove(p);
                    break;
                }
            }

            if(flag == true){
                System.out.println("Personagem não encontrado !");
            }
        }

    }

    private void criarArma(){
        System.out.println("Nome da arma: ");
        Arma a1 = new Arma();
        nome = in.nextLine();
        a1.setNome(nome);
        System.out.println("Tipo da arma: ");
        nome = in.nextLine();
        a1.setTipo(nome);
        System.out.println("Qual o dado de dano da arma?");
        in.nextLine();
        atri = in.nextInt();
        a1.setDano(atri);
        System.out.println("Entre com a descricao da arma");
        nome = in.nextLine();
        a1.setDescricao(nome);
        System.out.println("Quanto de municao a arma tem?");
        atri = in.nextInt();
        a1.setMunicao(atri);
        System.out.println("Qual o nome do personagem que possui a arma?");
        in.nextLine();

        boolean flag = true;
        while(flag){
            nome = in.nextLine();

            for (Personagem personagen : personagens) {
                if (Objects.equals(personagen.getNome(), nome)) {
                    personagen.setArma(a1);
                    flag = false;
                    break;
                }
            }

            if(flag == true)
                System.out.println("Arma não encontrada.");
        }
    }

    private void buscarArma() {
        System.out.println("Insira o nome do arma (Em branco para retornar): ");
        nome = in.nextLine();

        boolean flag = true;

        while (flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Personagem p : personagens) {
                if (p.getArma().getNome().equals(nome)) {
                    p.getArma().mostraInfo();
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println("Insira novamente o nome da arma (Em branco para retornar):");
            }
        }
    }


    private void deletarArma(){
        System.out.println("Entre com o nome da arma que deve ser deletada (Em branco para retornar):");
        in.nextLine();

        boolean flag = true;
        while(flag){
            nome = in.nextLine();

            if(nome.equals(""))
                return;

            for (Personagem p : personagens) {
                if (nome.equals(p.getArma().getNome())) {
                    p.setArma(null);
                    flag = false;
                    break;
                }
            }

            if(flag == true)
                System.out.println("Entre novamente com o nome da arma:");
        }
    }

    private void criarArmadura(){
        System.out.println("Nome da armadura: ");
        Armadura a2 = new Armadura();
        nome = in.nextLine();
        a2.setNome(nome);
        System.out.println("Tipo da armadura: ");
        nome = in.nextLine();
        a2.setTipo(nome);
        System.out.println("Digite 1 se for uma armadura magica e 2 se nao for");
        aux1 = in.nextInt();
        System.out.println("Entre com a descricao da armadura");
        nome = in.nextLine();
        a2.setDescricao(nome);
        System.out.println("Qual a CA base da armadura?");
        atri = in.nextInt();
        a2.setCa(atri);
        System.out.println("Qual o nome do personagem que possui a armadura?");
        in.nextLine();

        boolean flag = true;
        while(flag){
            nome = in.nextLine();

            for (Personagem personagen : personagens) {
                if (Objects.equals(personagen.getNome(), nome)) {
                    personagen.setArmadura(a2);
                    flag = false;
                    break;
                }
            }

            if(flag == true)
                System.out.println("Entre novamente com o nome do personagem que possui a armadura:");
        }
    }

    private void buscarArmadura() {
        System.out.println("Insira o nome da armadura (Em branco para retornar): ");
        nome = in.nextLine();

        boolean flag = true;

        while (flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Personagem p : personagens) {
                if (p.getArmadura().getNome().equals(nome)) {
                    p.getArmadura().mostraInfo();
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println("Insira novamente o nome da armadura (Em branco para retornar):");
            }
        }
    }

    private void deletarArmadura(){
        System.out.println("Entre com o nome da armadura que deve ser deletada (Em branco para retornar):");
        in.nextLine();

        boolean flag = true;
        while(flag){
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Personagem p : personagens) {
                if (nome.equals(p.getArmadura().getNome())) {
                    p.setArmadura(null);
                    flag = false;
                    break;
                }
            }

            if(flag == true)
                System.out.println("Entre novamente com o nome da armadura:");
        }
    }

    private void criarMundo(){
        Mundo mundo = new Mundo();
        System.out.println("Qual o nome do mundo?");
        nome = in.nextLine();
        mundo.setNomeMundo(nome);
        System.out.println("Qual o tipo do mundo?");
        nome = in.nextLine();
        mundo.setTipoMundo(nome);
        mundos.add(mundo);
    }

    private void buscarMundo() {
        System.out.println("Insira o nome do mundo (Em branco para retornar): ");
        nome = in.nextLine();

        boolean flag = true;

        while (flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Mundo m : mundos) {
                if (m.getNomeMundo().equals(nome)) {
                    m.mostraInfo();
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println("Insira novamente o nome do mundo (Em branco para retornar):");
            }
        }
    }

    private void deletarMundo(){
        System.out.println("Qual o nome do mundo que será deletado (Em branco para retornar):");
        in.nextLine();

        boolean flag = true;
        while(flag) {
            nome = in.nextLine();

            if (nome.equals(""))
                return;

            for (Mundo m : mundos) {
                if (m.getNomeMundo().equals(nome)){
                    mundos.remove(m);
                    flag = false;
                    break;
                }
            }

            if(flag == true)
                System.out.println("Entre novamente com o nome do mundo:");
        }
    }


}
