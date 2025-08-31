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

    @Override
    public void atacar(Personagem alvo){
        if(flechas <= 0){
            usarFlechaParaCombateCorpoACorpo(alvo);
            return;
        }
        int danoBase = getAtaque() + PRECISAO;
        int dano = danoBase - alvo.getDefesa();
        if(dano < 1){
            dano = 1;

            flechas--;
      

    boolean acertoCritico = Math.random() < 0.15;
    if(acertoCritico){
        dano *= 2; 
        System.out.println("☠️ ACERTO CRÍTICO!");
    }
    alvo.setVida(alvo.getVida() - dano);
    System.out.println("🏹 " + getNome() + " atirou uma flecha em " + alvo.getNome() + " causando " + dano + " de dano !!" + (acertoCritico? "(CRÍTICO!!)" : "" ));
    System.out.println(" Flechas restantes: " + flechas);

}
    public void chuvaDeFlechas(Personagem alvo){
        if(flechas < 3){
            System.out.println("❌Flechas insuficientes! Partindo para ataque alternativo");
            atirarEmObjetosAoRedor(alvo);
            return;
        } else {
            System.out.println("🌧️ " + getNome() + " usa CHUVA DE FLECHAS! ");
            flechas -= 3;

            int danoTotal = 0;
            for (int i = 0; i < 3; i++) {
            int dano = (getAtaque() + PRECISAO) - alvo.getDefesa();
            if (dano < 1) dano = 1;
            danoTotal += dano;
            alvo.setVida(alvo.getVida() - dano);
        }
        System.out.println("   " + alvo.getNome() + " recebeu " + danoTotal + " de dano!");
        System.out.println("   Flechas restantes: " + flechas);
    }

        }

    }
    }

}
