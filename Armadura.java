public class Armadura extends Item {
    private int ca;

    @Override
    public void mostraInfo(){
        System.out.println("Classe de Armadura: " + this.ca);
    }
    // =============================== GETTERs e SETTERs ===============================

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }
}
