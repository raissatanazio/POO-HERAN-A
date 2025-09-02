public class CampoDeBatalha {
    public static void main(String[] args) {
        // Criando os personagens
        Mago merlin = new Mago("merlin");
        Arqueiro alec = new Arqueiro("alec");
        Guerreiro zoro = new Guerreiro("zoro");
        Lobisomem luke = new Lobisomem("luke");
        
        // Array de todos os personagens para o uivo do lobisomem
        Personagem[] todosPersonagens = {merlin, alec, zoro, luke};
        
        System.out.println("🎯 === INÍCIO DA BATALHA ÉPICA ===");
        System.out.println("🔮 " + merlin.getNome());
        System.out.println("🏹 " + alec.getNome());
        System.out.println("⚔️ " + zoro.getNome());
        System.out.println("🐺 " + luke.getNome());
        System.out.println("===============================\n");
        
        // Status iniciais
        System.out.println("=== STATUS INICIAIS ===");
        merlin.mostrarStatus();
        alec.mostrarStatus();
        zoro.mostrarStatus();
        luke.mostrarStatus();
        
        System.out.println("\n⚔️ === ROUND 1 ===");
        
        // merlin ativa a Marca de Caim
        merlin.ativarMarcadeCaim();
        
        // alec usa Chuva de Flechas no merlin
        System.out.println();
        alec.chuvaDeFlechas(merlin);
        
        // zoro usa Santoryu no Lobisomem
        System.out.println();
        zoro.santoryu(luke);
        
        // Luke usa Uivo em todos
        System.out.println();
        luke.uivar(todosPersonagens);
        
        System.out.println("\n=== STATUS APÓS ROUND 1 ===");
        merlin.mostrarStatus();
        alec.mostrarStatus();
        zoro.mostrarStatus();
        luke.mostrarStatus();
        
        System.out.println("\n⚔️ === ROUND 2 ===");
        
        // merlin lança Bola de Fogo no zoro
        System.out.println();
        merlin.lancarBolaDeFogo(zoro);
        
        // alec recarrega flechas e ataca o Luke
        System.out.println();
        alec.recarregarFlechas(10);
        alec.atacar(luke);
        
        // zoro descansa para recuperar vigor
        System.out.println();
        zoro.descansar();
        
        // Luke morde o alec
        System.out.println();
        luke.mordida(alec);
        
        System.out.println("\n=== STATUS APÓS ROUND 2 ===");
        merlin.mostrarStatus();
        alec.mostrarStatus();
        zoro.mostrarStatus();
        luke.mostrarStatus();
        
        System.out.println("\n⚔️ === ROUND 3 ===");
        
        // merlin medita para recuperar mana
        System.out.println();
        merlin.meditar();
        
        // alec usa combate corpo a corpo no zoro
        System.out.println();
        alec.usarFlechaParaCombateCorpoACorpo(zoro);
        
        // zoro usa Golpe de Espada no Luke
        System.out.println();
        zoro.golpeDeEspada(luke);
        
        // Luke se transforma (se tiver fúria suficiente)
        System.out.println();
        if (luke.getFuria() >= 50) {
            luke.transformar();
        } else {
            luke.uivar(todosPersonagens);
        }
        
        System.out.println("\n=== STATUS FINAIS ===");
        merlin.mostrarStatus();
        alec.mostrarStatus();
        zoro.mostrarStatus();
        luke.mostrarStatus();
        
        System.out.println("\n🎯 === FIM DA BATALHA ===");
        
        // Verificando vencedor
        System.out.println("📊 RESULTADO FINAL:");
        System.out.println("🔮 merlin: " + (merlin.estaVivo() ? "VIVO" : "DERROTADO"));
        System.out.println("🏹 alec: " + (alec.estaVivo() ? "VIVO" : "DERROTADO"));
        System.out.println("⚔️ zoro: " + (zoro.estaVivo() ? "VIVO" : "DERROTADO"));
        System.out.println("🐺 Luke: " + (luke.estaVivo() ? "VIVO" : "DERROTADO"));
        
        // Contando sobreviventes
        int sobreviventes = 0;
        if (merlin.estaVivo()) sobreviventes++;
        if (alec.estaVivo()) sobreviventes++;
        if (zoro.estaVivo()) sobreviventes++;
        if (luke.estaVivo()) sobreviventes++;
        
        if (sobreviventes == 1) {
            System.out.println("\n🏆 TEMOS UM VENCEDOR!");
        } else if (sobreviventes > 1) {
            System.out.println("\n🤝 BATALHA EMPATADA! " + sobreviventes + " sobreviventes.");
        } else {
            System.out.println("\n💀 TODOS FORAM DERROTADOS!");
        }
    }
}