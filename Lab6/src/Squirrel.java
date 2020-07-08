public class Squirrel extends Rodent
{
    private String tailColor;

    public Squirrel(String name, String tailColor)
    {
        super(name);
        this.tailColor = tailColor;
    }

    public void Eat(int amount)
    {
        super.Eat(amount);
        System.out.print("acorns");
        System.out.println();
    }

    @Override
    public void Walk(int amount)
    {
        super.Walk(amount);
        System.out.print("squirrelly");
        System.out.println();
    }
}
