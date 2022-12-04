import java.util.ArrayList;

public class Personagem {

    public int id;
    private Jogador jogador;
    private String nome;
    private String classe;
    private String raca;
    private String antecedente;
    private int nivel;
    private int xp;
    private int destreza;
    private int forca;
    private int constituicao;
    private int sabedoria;
    private int inteligencia;
    private int carisma;
    private int modDestreza;
    private int modForca;
    private int modConstituicao;
    private int modSabedoria;
    private int modInteligencia;
    private int modCarisma;
    private int pvAtual;
    private int pvMax;
    private ArrayList<Item> itens = new ArrayList<>();
    private Arma arma;
    private Armadura armadura;

    public Personagem(String nome, String classe, String raca, String antecedente, int nivel, int xp){
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.antecedente = antecedente;
        this.nivel = nivel;
        this.xp = xp;
    }

    public void gerarAtributos(){
        this.destreza = (int)(Math.random() * 16) + 3;
        this.forca = (int)(Math.random() * 16) + 3;
        this.constituicao = (int)(Math.random() * 16) + 3;
        this.sabedoria = (int)(Math.random() * 16) + 3;
        this.inteligencia = (int)(Math.random() * 16) + 3;
        this.carisma = (int)(Math.random() * 16) + 3;
    }

    public void calcModificadores(){
        this.modDestreza = (this.destreza - 10) / 2;
        this.modForca = (this.forca - 10) / 2;
        this.modConstituicao = (this.constituicao - 10) / 2;
        this.modSabedoria = (this.sabedoria - 10) / 2;
        this.modInteligencia = (this.inteligencia - 10) / 2;
        this.modCarisma = (this.carisma - 10) / 2;
    }

    public void mostraInfo(){
        System.out.println("Nome: " + this.nome + "\tNivel: " + this.nivel + "\t\tJogador: " + this.jogador.getNome());
        System.out.println("Classe:" + this.classe + "\tRaca:" + this.raca + "\tAntecedente" + this.antecedente);
        System.out.println("Forca: " + this.forca + "\t\t" + this.modForca);
        System.out.println("Destreza: " + this.destreza + "\t\t" + this.modDestreza);
        System.out.println("Constituicao: " + this.constituicao + "\t\t" + this.modConstituicao);
        System.out.println("Sabedoria: " + this.sabedoria + "\t\t" + this.modSabedoria);
        System.out.println("Inteligencia: " + this.inteligencia + "\t\t" + this.modInteligencia);
        System.out.println("Carisma: " + this.carisma + "\t\t" + this.modCarisma);
        System.out.println("Arma: " + this.getArma().getNome() + "\t Armadura: " + this.getArmadura().getNome());
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getPvAtual() {
        return pvAtual;
    }

    public void setPvAtual(int pvAtual) {
        this.pvAtual = pvAtual;
    }

    public int getPvMax() {
        return pvMax;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

    public int getModDestreza() {
        return modDestreza;
    }

    public int getModForca() {
        return modForca;
    }

    public int getModConstituicao() {
        return modConstituicao;
    }

    public int getModSabedoria() {
        return modSabedoria;
    }

    public int getModInteligencia() {
        return modInteligencia;
    }

    public int getModCarisma() {
        return modCarisma;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
