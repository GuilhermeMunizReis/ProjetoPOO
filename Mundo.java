public class Mundo {
    private String nomeMundo;
    private String tipoMundo;

    public void mostraInfo(){
        System.out.println("Nome: " + this.nomeMundo + "\tTipo: " + this.tipoMundo);
    }

    public String getNomeMundo() {
        return nomeMundo;
    }

    public void setNomeMundo(String nomeMundo) {
        this.nomeMundo = nomeMundo;
    }

    public String getTipoMundo() {
        return tipoMundo;
    }

    public void setTipoMundo(String tipoMundo) {
        this.tipoMundo = tipoMundo;
    }
}

