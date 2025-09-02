class Mago extends Personagem {
    private int magia;
    private boolean marcaAtiva;
    private int duracaoMarca;
    private final int BOLADEFOGO = 25;

    public Mago(String nome){
        super(nome); //super chama o contrutor da mãe
        this.magia = 100;
        this.marcaAtiva = false;
        this.duracaoMarca = 0;
        setVida(100);
        setAtaque(15);
        setDefesa(0);
    }

    public int getMagia(){
        return magia;
    }

    public void setMagia(int magia){
        this.magia = magia;
        if(this.magia < 0){
            magia = 0;
            System.out.println("Estou sem magia.... vamos resolver no diálogo?");
        } if(this.magia > 100){
            magia = 100;
        }
    }

    public boolean getMarcaAtiva(){
        return marcaAtiva;
    }
    //arma secreta

    public void ativarMarcadeCaim(){
        if(getMagia() >= 40){
            marcaAtiva = true;
            duracaoMarca = 3;
            setMagia(getMagia() - 40);
            System.out.println("🔮Mago(a)" + getNome() + " ativou a MARCA DE CAIM!");
            System.out.println("🪞 Os próximos ataques serão refletidos por " + duracaoMarca + " turnos!");
        } else {
            System.out.println("Magia insuficiente para ativar a Marca de Caim! (" + getMagia() + "/40)");
        }
    }

   @Override
    public void receberDano(Personagem atacante) {
        if (marcaAtiva && estaVivo()) {
            int dano = atacante.getAtaque() - this.getDefesa(); // ✅ CALCULA DANO
            if (dano < 1) dano = 1;

            // Reflete o dano para o atacante
            atacante.setVida(atacante.getVida() - dano);

            System.out.println("⚡ MARCA DE CAIM ATIVADA!");
            System.out.println("   🔮 " + atacante.getNome() + " sofreu " + dano + " de dano refletido!");
            System.out.println("   ❤️ " + getNome() + " permanece ileso!");

            duracaoMarca--;
            if (duracaoMarca <= 0) {
                marcaAtiva = false;
                System.out.println("   💨 A Marca de Caim se dissipou!");
            }
        } else {
            // ✅ USA O MÉTODO DA CLASSE PAI
            super.receberDano(atacante);
        }
    }

    public void lancarBolaDeFogo(Personagem alvo) {
        if (getMagia() >= BOLADEFOGO) {
            int dano = getAtaque() * 2; // Dano dobrado
            
            // ✅ CALCULA DANO CONSIDERANDO DEFESA
            int danoFinal = dano - alvo.getDefesa();
            if (danoFinal < 1) danoFinal = 1;
            
            alvo.setVida(alvo.getVida() - danoFinal);
            setMagia(getMagia() - BOLADEFOGO);
            
            System.out.println("🔥 " + getNome() + " lançou BOLA DE FOGO em " + alvo.getNome() + "!");
            System.out.println("   Causou " + danoFinal + " de dano incinerante!");
            System.out.println("   Mana gasta: " + BOLADEFOGO + " | Mana restante: " + getMagia());
        } else {
            System.out.println("💤 Mana insuficiente! Usando ataque normal...");
            atacar(alvo);
        }
    }



 @Override
    public void atacar(Personagem alvo) {
        int dano = getAtaque() - alvo.getDefesa();
        if (dano < 0) dano = 1;
        
        // Se o alvo for um Mago com Marca de Caim, ele vai usar receberAtaque
        if (alvo instanceof Mago) {
            Mago magoAlvo = (Mago) alvo;
            magoAlvo.receberDano(this);
        } else {
            alvo.setVida(alvo.getVida() - dano);
            System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + dano + " de dano!");
        }
    }


    //recuperar magia
    void meditar() {
        setMagia(getMagia() + 25);
        System.out.println(getNome() + " meditou e recuperou 25 de magia! Magia: " + getMagia() + "/100");
}

@Override
    void mostrarStatus() {
        super.mostrarStatus();
        System.out.println("🪄 Mana: " + getMagia() + "/100");
        if (marcaAtiva) {
            System.out.println("🔮 Marca de Caim ativa! (" + duracaoMarca + " turnos restantes)");
        }
    }

    void passarTurno() {
        if (marcaAtiva) {
            duracaoMarca--;
            if (duracaoMarca <= 0) {
                marcaAtiva = false;
                System.out.println("A Marca de Caim de " + getNome() + " se dissipou!");
            }
        }
    }
}

//Características da Marca de Caim:
//Custo: 40 de mana

//Duração: 2 turnos

//Efeito: Reflete 100% do dano recebido de volta ao atacante

//Visual: Mostra status especial quando ativa

//Estratégia: Ótima para contra-ataque e defesa