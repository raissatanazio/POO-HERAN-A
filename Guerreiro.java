public class Guerreiro extends Personagem {
    private int vigor; 
    private final int GOLPE_DE_ESPADA = 20;
    private final int SANTORYU = 30;

    public Guerreiro(String nome) {
        super(nome);
        this.vigor = 100;
        setVida(100);
        setAtaque(18);
        setDefesa(0);
    }

    public int getVigor() {
        return vigor;
    }

    public void setVigor(int vigor) {
        this.vigor = vigor;
        if (this.vigor < 0) this.vigor = 0;
        if (this.vigor > 100) this.vigor = 100;
    }

    // Golpe poderoso com a lâmina
    public void golpeDeEspada(Personagem alvo) {
        if (vigor >= GOLPE_DE_ESPADA) {
            int dano = getAtaque() * 2;
            alvo.setVida(alvo.getVida() - dano);
            setVigor(vigor - GOLPE_DE_ESPADA);

            System.out.println("⚔️ " + getNome() + " usou GOLPE DE ESPADA em " + alvo.getNome() + " causando " + dano + " de dano!");
            System.out.println("   Vigor restante: " + getVigor());
        } else {
            System.out.println("❌ Vigor insuficiente para Golpe de Espada! (" + getVigor() + "/" + GOLPE_DE_ESPADA + ")");
            atacar(alvo);
        }
    }

    // Santoryu - Ataque das 3 Espadas
    public void santoryu(Personagem alvo) {
        if (vigor >= SANTORYU) {
            int danoTotal = 0;
            
            // Três golpes rápidos
            for (int i = 1; i <= 3; i++) {
                int dano = getAtaque() + 5;
                alvo.setVida(alvo.getVida() - dano);
                danoTotal += dano;
                System.out.println("   ⚡ Espada " + i + ": " + dano + " de dano!");
            }
            
            setVigor(vigor - SANTORYU);

            System.out.println("🌀 " + getNome() + " executa SANTORYU - TRÊS ESPADAS!");
            System.out.println("   💥 " + alvo.getNome() + " sofreu " + danoTotal + " de dano total!");
            System.out.println("   💪 Vigor restante: " + getVigor());
        } else {
            System.out.println("❌ Vigor insuficiente para Santoryu! (" + getVigor() + "/" + SANTORYU + ")");
            golpeDeEspada(alvo);
        }
    }

 
    public void descansar() {
        setVigor(vigor + 25);
        System.out.println("💤 " + getNome() + " descansou e recuperou 25 de vigor. Vigor: " + getVigor() + "/100");
    }

    @Override
    public void atacar(Personagem alvo) {
        
        int dano = getAtaque();
        alvo.setVida(alvo.getVida() - dano);

        System.out.println("🗡️ " + getNome() + " atacou " + alvo.getNome() + " causando " + dano + " de dano!");
        System.out.println("   💪 Vigor: " + getVigor()); 
    }

    @Override
    public void receberDano(Personagem atacante) {
        int dano = atacante.getAtaque();
        setVida(getVida() - dano);
        
        System.out.println("💥 " + getNome() + " recebeu " + dano + " de dano de " + atacante.getNome() + "!");
        System.out.println("   💪 Vigor: " + getVigor()); 
    }

    @Override
    public void mostrarStatus() {
        super.mostrarStatus();
        System.out.println("💪 Vigor: " + getVigor() + "/100");
        System.out.println("⚔️ Golpe de Espada: " + GOLPE_DE_ESPADA + " de vigor");
        System.out.println("🌀 Santoryu: " + SANTORYU + " de vigor (3 espadas)");
        System.out.println("💤 Descansar: Recupera 25 de vigor");
        System.out.println("🛡️ Defesa: 0 (estilo ofensivo puro)");
    }
}