public class Hamster extends Rodent
{
    private String color;
    public Hamster(String name, String color)
    {
        super(name);
        this.color = color;
    }
    @Override
    public void Eat(int amount)
    {
        super.Eat(amount);
        System.out.print("seeds");
        System.out.println();
    }

    @Override
    public void Walk(int amount)
    {
        super.Walk(amount);
        System.out.print("hamsterly");
        System.out.println();
    }
}
