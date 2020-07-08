package M8W.games.tilegame;

import java.awt.*;

public class Launcher
{
    public static void main(String args[])
    {
        Game g = new Game(new Dimension(600, 400));

        g.start();
    }
}
