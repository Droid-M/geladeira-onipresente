/*
 * Geladeira que será gerida pela família
 */
package geladeiraonipresente;

/**
 *
 * @author Marcos
 */
public class Geladeira {
    public final int maximo_litros_leite = 10;
    protected int litrosLeite;
    
    public Geladeira(int litrosDeLeiteIniciais)
    {
        this.litrosLeite = litrosDeLeiteIniciais;
    }
    
    public Geladeira()
    {
        this.litrosLeite = this.maximo_litros_leite;
    }
    
    public int getListrosLeite()
    {
        return this.litrosLeite;
    }
    
    public boolean temLeite()
    {
        return this.litrosLeite > 0;
    }
    
    public void setLeite(int litros)
    {
        this.litrosLeite = litros;
        this.checaCapacidadeDeLeite();
    }
    
    protected void checaCapacidadeDeLeite()
    {
        if(this.litrosLeite == this.maximo_litros_leite)
            System.out.println("Limite máximo de leite atingido! Não insira mais litros");
        else if(this.litrosLeite > this.maximo_litros_leite)
            System.out.println("Erro! Limite máximo de leite excedido!");
    }
    
    public boolean atingiuLimiteDeLeite()
    {
        return this.litrosLeite >= this.maximo_litros_leite;
    }
}
