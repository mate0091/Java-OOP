import java.lang.*;

public class Rodent
{
    protected int health;
    protected String name;

    protected final static int DEF_HEALTH = 100;

    public Rodent(String name)
    {
        this.name = name;
        this.health = DEF_HEALTH;
    }

    public void Eat(int amount)
    {
        if(health + amount > DEF_HEALTH)
        {
            health = DEF_HEALTH;
        }

        else
        {
            health += amount;
        }

        System.out.print(name + " is eating ");
    }

    public void Walk(int amount)
    {
        if(health - amount < 0) health = 0;
        else health -= amount;

        System.out.print(name + " walks ");
    }

    public void Shit(int amount)
    {
        System.out.print(name + " is shitting and has regain health " + "\n");
        health = DEF_HEALTH;
    }

    public int getHealth()
    {
        return health;
    }

    public void printHealth()
    {
        System.out.println(name + " health: " + health + "\n");
    }
}
