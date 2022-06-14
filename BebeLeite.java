/*
 * Consome leite da geladeira
 */
package geladeiraonipresente;

/**
 *
 * @author Marcos
 */
public class BebeLeite extends Thread {
    
    private Geladeira geladeira;
    private boolean executor;
    
    public BebeLeite(Geladeira geladeira)
    {
        this.geladeira = geladeira;
        this.executor = true;
    }
    
    public void beber()
    {
        if(geladeira.temLeite()) {
            this.geladeira.setLeite(this.geladeira.getListrosLeite() - 1);
            System.out.println("Bebeu 1 litro de leite!");
        } else {
            System.out.println("Sem leite para beber...");
        }
    }
    
    @Override
    public void run()
    {
        while(this.executor) {
            this.beber();   
        }
    }
    
    public void kill()
    {
        this.executor = false;
        this.stop();
    }
}
