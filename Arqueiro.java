public class Arqueiro extends Personagem {
    private int flechas;
    private final int PRECISAO = 3;
    private final int AGILIDADE = 3; //final = valor constante

    public Arqueiro(String nome){
        super(nome); //super chama o contrutor da mãe
        this.flechas = 25;
        setVida(100);
        setAtaque(12);
        setDefesa(0);
    }
    public int getFlechas() {
        return flechas;
    }

    public void setFlechas(int flechas) {
        this.flechas = flechas;
        if (this.flechas < 0) this.flechas = 0;
    }

   @Override
    public void atacar(Personagem alvo) {
        if(flechas <= 0) {
            usarFlechaParaCombateCorpoACorpo(alvo);
            return;
        }
        
        int danoBase = getAtaque() + PRECISAO;
        int dano = danoBase - alvo.getDefesa(); // ✅ CALCULA DANO CORRETAMENTE
        if(dano < 1) dano = 1;
        
        flechas--;

        boolean acertoCritico = Math.random() < 0.15;
        if(acertoCritico) {
            dano *= 2; 
            System.out.println("☠️ ACERTO CRÍTICO!");
        }
        
        // USA O MÉTODO DA CLASSE MÃE
        super.atacar(alvo); // chama o ataque base que já calcula dano
        System.out.println("🏹 " + getNome() + " atirou uma flecha em " + alvo.getNome() + 
                         " causando " + dano + " de dano !!" + 
                         (acertoCritico ? "(CRÍTICO!!)" : ""));
        System.out.println("   Flechas restantes: " + flechas);
    }

    public void chuvaDeFlechas(Personagem alvo) {
        if(flechas < 3) {
            System.out.println("❌ Flechas insuficientes! Partindo para ataque alternativo");
            atirarEmObjetosAoRedor(alvo);
            return;
        }
        
        System.out.println("🌧️ " + getNome() + " usa CHUVA DE FLECHAS! ");
        flechas -= 3;

        int danoTotal = 0;
        for (int i = 0; i < 3; i++) {
            int dano = (getAtaque() + PRECISAO) - alvo.getDefesa();
            if (dano < 1) dano = 1;
            danoTotal += dano;
            alvo.receberDano(this); // ✅ DANO DIRETO
        }
        
        System.out.println("   " + alvo.getNome() + " recebeu " + danoTotal + " de dano!");
        System.out.println("   Flechas restantes: " + flechas);
    }


    public void atirarEmObjetosAoRedor(Personagem alvo){
        System.out.println("💥 " + getNome() + " atira em objetos ao redor!");
        
        // dano por objetos caindo
        int danoObjetos = 8 + AGILIDADE;
        alvo.receberDano(this);
        
        //bônus defensivo temporário
        int defesaExtra = 5;
        setDefesa(getDefesa() + defesaExtra);
        
        System.out.println("   Objetos caem sobre " + alvo.getNome() + " causando " + danoObjetos + " de dano!");
        System.out.println("   " + getNome() + " ganha +" + defesaExtra + " de defesa temporária!");
        System.out.println("   Defesa atual: " + getDefesa());
    }

    public void usarFlechaParaCombateCorpoACorpo(Personagem alvo){
        System.out.println("🤺⚔️ " + getNome() + " usa flechas para combate corpo a corpo!!");

        int dano = (getAtaque() / 2) + AGILIDADE;
        // Verifica se o alvo é um Mago com Marca de Caim ativa
         if (alvo instanceof Mago) {
        Mago magoAlvo = (Mago) alvo;
        if (magoAlvo.getMarcaAtiva()) {
            System.out.println("⚡ Ataque bloqueado pela Marca de Caim!");
            System.out.println("   " + getNome() + " sofre " + dano + " de dano refletido!");
            this.setVida(this.getVida() - dano);
            return;
        }
    }//só executa se não houver Marca de Caim
        alvo.receberDano(this);
        System.out.println("Golpe rápido com flecha causa " + dano + " de dano em " + alvo.getNome());
    }

    public void recarregarFlechas(int quantidade) {
        flechas += quantidade;
        System.out.println("📦 " + getNome() + " recarregou " + quantidade + " flechas!");
        System.out.println("   Total de flechas: " + flechas);
    }

    @Override
    public void mostrarStatus() {
        super.mostrarStatus();
        System.out.println("🏹 Flechas: " + flechas);
        System.out.println("🎯 Precisão: +" + PRECISAO + " de dano");
        System.out.println("🌀 Agilidade: +" + AGILIDADE + " em habilidades");
    }

    public boolean temFlechas() {
        return flechas > 0;
    }

    public boolean podeUsarChuvaDeFlechas() {
        return flechas >= 3;
    }

    public boolean podeUsarBarragemDefensiva() {
        return flechas >= 2;
    }
}
    
    

