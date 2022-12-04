public class Arma extends Item{
    private int dano;
    private int municao;

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Dano: " + this.dano);
    }

    // =============================== GETTERs e SETTERs ===============================

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getMunicao() {
        return municao;
    }

    public void setMunicao(int municao) {
        this.municao = municao;
    }
}
