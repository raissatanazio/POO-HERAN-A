public class Lobisomem extends Personagem {
    private boolean transformado;
    private int furia;
    private boolean quatroCabecas; // Nova transformação
    
    public Lobisomem(String nome) {
        super(nome);
        this.transformado = false;
        this.quatroCabecas = false;
        this.furia = 0;
        setVida(100); // 
        setAtaque(16);
        setDefesa(0);
    }

    public boolean isTransformado() {
        return transformado;
    }

    public boolean isQuatroCabecas() {
        return quatroCabecas;
    }

    public int getFuria() {
        return furia;
    }

    public void aumentarFuria(int valor) {
        this.furia += valor;
        if (furia >= 40 && !quatroCabecas) {
            invocarQuatroCabecas();
        } else if (furia >= 20 && !transformado) {
            transformar();
        }
    }

    // Transformação básica
    public void transformar() {
        transformado = true;
        setAtaque(getAtaque() + 10);
        System.out.println("🌕 " + getNome() + " se TRANSFORMOU em LOBISOMEM!");
        System.out.println("   ⚡ Ataque aumentado para " + getAtaque() + "!");
    }

    // Transformação das 4 Cabeças (Fúria 40+)
    public void invocarQuatroCabecas() {
        quatroCabecas = true;
        transformado = true; // Também fica transformado
        setAtaque(getAtaque() * 4); // Ataque 4 vezes mais forte
        
        System.out.println("👹🔥 " + getNome() + " INVOCOU 4 CABEÇAS DEMONÍACAS!");
        System.out.println("   💀 ATAQUE QUADRUPLICADO: " + getAtaque() + " de poder!");
        System.out.println("   🌪️  FÚRIA MAXIMIZADA: " + getFuria() + "/100");
    }

    // Mordida feroz - agora com 4 cabeças!
     public void mordida(Personagem alvo) {
        int dano = getAtaque() + (transformado ? 10 : 5);
        alvo.setVida(alvo.getVida() - dano);
        aumentarFuria(10);

        System.out.println("🐺 " + getNome() + " mordeu " + alvo.getNome() + " causando " + dano + " de dano!");
        System.out.println("   Fúria atual: " + getFuria());
    }

    // Uivo das 4 cabeças 
    public void uivar(Personagem[] inimigos) {
        int multiplicadorUivo = quatroCabecas ? 4 : 1;
        
        System.out.println("📢 " + getNome() + " soltou um UIVO " + 
                          (quatroCabecas ? "APOCALÍPTICO" : "ATERRORIZANTE") + "!");
        
        // Efeito nos inimigos
        int inimigosAfetados = 0;
        for (Personagem inimigo : inimigos) {
            if (inimigo != null && inimigo.estaVivo()) {
                int danoUivo = 10 * multiplicadorUivo;
                inimigo.setVida(inimigo.getVida() - danoUivo);
                System.out.println("   💫 " + inimigo.getNome() + " sofreu " + danoUivo + " de dano sonoro!");
                inimigosAfetados++;
            }
        }
        
        aumentarFuria(5 * multiplicadorUivo);
        System.out.println("   🔥 Fúria: " + getFuria());
        System.out.println("   💀 " + inimigosAfetados + " inimigos afetados!");
    }

    // Ataque especial das 4 cabeças
    public void ataqueApocaliptico(Personagem alvo) {
        if (quatroCabecas) {
            int danoTotal = 0;
            System.out.println("👹🌪️ " + getNome() + " usa ATAQUE APOCALÍPTICO das 4 CABEÇAS!");
            
            for (int i = 1; i <= 4; i++) {
                int danoCabeca = getAtaque() / 2;
                alvo.setVida(alvo.getVida() - danoCabeca);
                danoTotal += danoCabeca;
                System.out.println("   👹 Cabeça " + i + ": " + danoCabeca + " de dano!");
            }
            
            System.out.println("   💥 DANO TOTAL: " + danoTotal + " em " + alvo.getNome() + "!");
        } else {
            System.out.println("❌ Precisa das 4 cabeças para usar este ataque!");
            mordida(alvo);
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        if (quatroCabecas && getFuria() >= 10) {
            ataqueApocaliptico(alvo);
        } else {
            mordida(alvo);
        }
    }

    @Override
    public void mostrarStatus() {
        super.mostrarStatus();
        System.out.println("🔥 Fúria: " + getFuria() + "/100");
        if (quatroCabecas) {
            System.out.println("👹 4 CABEÇAS DEMONÍACAS - Ataque 4x mais forte!");
        } else if (transformado) {
            System.out.println("🌕 Forma Lobisomem");
        } else {
            System.out.println("😐 Forma humana");
        }
        System.out.println("⚔️ Ataque: " + getAtaque() + " (base 16)");
    }

    @Override
    public void receberDano(Personagem atacante) {
        int dano = atacante.getAtaque(); // Defesa 0
        setVida(getVida() - dano);
        
        System.out.println("💥 " + getNome() + " recebeu " + dano + " de dano de " + atacante.getNome() + "!");
        
        //ganha mais fúria quando machucado
        aumentarFuria(dano * 2);
        System.out.println("   😠 Fúria aumenta para: " + getFuria());
    }
}