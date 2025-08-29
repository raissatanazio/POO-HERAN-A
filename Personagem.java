public class Personagem {
    private String nome;
    private int nivel;
    private int vida;
    private int ataque;
    private int defesa;

    public Personagem(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.vida = 100;
        this.ataque = 10;
        this.defesa = 5;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public int getVida() {
        return vida;
    }
    
    public int getAtaque() {
        return ataque;
    }
    
    public int getDefesa() {
        return defesa;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
        if (this.ataque < 1) {
            this.ataque = 1;
        }
    }
    
    public void setDefesa(int defesa) {
        this.defesa = defesa;
        if (this.defesa < 0) {
            this.defesa = 0;
        }
    }


}
