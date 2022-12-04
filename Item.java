public class Item {
    private static int idCont;

    private int id;
    private String nome;
    private String tipo;

    private String descricao;

    public void mostraInfo(){
        System.out.println("Nome: " + this.nome + "\tTipo:" + this.tipo);
        System.out.println("Descricao:" + this.descricao);
    }

    // =============================== Construtor ===============================
    public Item() {
        idCont++;
        this.id = this.idCont;
        System.out.println("AQI");
    }
    // =============================== GETTERs e SETTERs ===============================

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

