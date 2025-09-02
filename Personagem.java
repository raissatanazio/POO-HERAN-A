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
            System.out.println("VELÓRIO CONFIRMADO.");
        }
    }

    boolean estaVivo() {
        return getVida() > 0;
    }

     public void atacar(Personagem alvo){
        int dano = this.getAtaque() - alvo.getDefesa();
        if(dano < 0) dano = 1;
        alvo.setVida(alvo.getVida() - dano);
        System.out.println(this.getNome() + "ATACOU" + alvo.getNome() + "CAUSANDO" + dano + "DE DANO!");
    }

      public void receberDano(Personagem atacante) {
        int dano = atacante.getAtaque() - this.getDefesa(); 
        if (dano < 1) dano = 1;
        this.vida -= dano;
        System.out.println("💥 " + getNome() + " recebeu " + dano + " de dano de " + atacante.getNome() + "!");
    
}

    void mostrarStatus() {
        System.out.println(getNome() + " [Nível " + getNivel() + "] - Vida: " + getVida() + "/100");
}
}