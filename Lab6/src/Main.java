public class Main
{
    public static void main(String agrs[])
    {
        Rodent[] rodents = new Rodent[20];
        rodents[0] = new Squirrel("Jacksquirrel", "red");
        rodents[1] = new Hamster("Harry", "black");
        rodents[2] = new Mouse("Jerry");

        rodents[0].Eat(50);
        rodents[1].Eat(20);
        rodents[2].Eat(70);

        for (int i = 0; i < 3; i++)
        {
            rodents[i].printHealth();
        }

        rodents[0].Walk(70);
        rodents[1].Walk(10);
        rodents[2].Walk(15);

        for (int i = 0; i < 3; i++)
        {
            rodents[i].printHealth();
        }

        rodents[1].Shit(23);
    }
}
