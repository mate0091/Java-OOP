public class Mouse extends Rodent
{
    public Mouse(String name)
    {
        super(name);
    }
    public void Eat(int amount)
    {
        super.Eat(amount);
        System.out.print("cheese");
    }

    @Override
    public void Walk(int amount)
    {
        super.Walk(amount);
        System.out.print("mousely");
        Squeak();
        System.out.println();
    }

    private void Squeak()
    {
        System.out.print(" and squeaks");
    }
}
