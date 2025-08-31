public class Arqueiro extends Personagem {
    private int flechas;
    private final int PRECISAO = 3;
    private final int AGILIDADE = 3; //final = valor constante

    public Arqueiro(String nome){
        super(nome); //super chama o contrutor da mãe
        this.flechas = 25;
        setVida(100);
        setAtaque(12);
        setDefesa(10);
    }
    public int getFlechas() {
        return flechas;
    }

    public void setFlechas(int flechas) {
        this.flechas = flechas;
        if (this.flechas < 0) this.flechas = 0;
    }

}
