package geladeiraonipresente;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class GeladeiraOnipresente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random gerador = new Random();
        Geladeira geladeira = new Geladeira(); // Geladeira inicia com 10 litros de leite
        Parente pai = new Parente(geladeira);
        Parente mae = new Parente(geladeira);
        Parente tio = new Parente(geladeira);
        BebeLeite bebeLeite = new BebeLeite(geladeira);
        
        pai.start();
        mae.start();
        tio.start();
        bebeLeite.start();
        
        for(int i = 0; i < 20; i++) {
            try {
                bebeLeite.sleep(gerador.nextInt(10) * 1000); //Dorme entre 0 e 3 segundos
            } catch (InterruptedException ex) {
                // Apenas para casos especiais (irrelevante para o problema principal):
                Logger.getLogger(GeladeiraOnipresente.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("ERRO NA EXECUÇÃO!");
            }
            System.out.format("\n----Laço %d----\n", i);
        }
        
        pai.kill();
        mae.kill();
        tio.kill();
        bebeLeite.kill();
    }
    
}
