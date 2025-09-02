public class CampoDeBatalha{
    public static void main(String[] args){
        Mago merlin = new Mago("Merlin");
        Arqueiro alec = new Arqueiro("Alec");

        merlin.estaVivo();
        alec.estaVivo();
        merlin.atacar(alec);
        merlin.lancarBolaDeFogo(alec);
        alec.chuvaDeFlechas(merlin);
        alec.usarFlechaParaCombateCorpoACorpo(merlin);
        alec.atacar(merlin);
        merlin.atacar(alec);
        merlin.ativarMarcadeCaim();
        alec.atacar(merlin);
        merlin.receberAtaque(alec, 15);
        merlin.mostrarStatus();
    }
}