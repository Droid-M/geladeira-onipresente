/*
 * Parente que pode repor o leite da geladeira
 */
package geladeiraonipresente;

import java.util.Random;

/**
 *
 * @author Marcos
 */
public class Parente extends Thread {
    
    protected Geladeira geladeira;
    Random gerador = new Random();
    private boolean executor;
    
    public Parente(Geladeira geladeira)
    {
        this.geladeira = geladeira;
        this.executor = true;
    }
    
    public void compraLeite() 
    {
        // Os parentes só irão comprar a quantidade de leite que falta para completar os 10 litros
        int novosLitros = this.gerador.nextInt(this.geladeira.maximo_litros_leite - this.geladeira.getListrosLeite()) + 1;
        this.geladeira.setLeite(
            this.geladeira.getListrosLeite() + novosLitros
        );
        System.out.format("Comprou %d litro de leite!\n", novosLitros);
    }
    
    @Override
    public void run()
    {
        while(this.executor) {
            System.out.print("");
            // Solução: A compra de leite só é permitida se a geladeira estiver sem leite e não tiver atingido o limite
            if(!this.geladeira.temLeite() && !this.geladeira.atingiuLimiteDeLeite()) {        
                this.compraLeite();
            }
        }
    }
    
    public void kill()
    {
        this.executor = false;
        this.stop();
    }
}
