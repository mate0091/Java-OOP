package M8W.games.tilegame;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{
    public Dimension dim;

    private Thread thread;
    private boolean isRunning = false;
    private GameDisplay display;
    private BufferStrategy bs;
    private Graphics g;

    public Game(Dimension dim)
    {
        this.dim = dim;
    }

    @Override
    public void run()
    {
        init();

        //Game loop
        while (isRunning)
        {
            update();
            render();
        }
    }

    public synchronized void start()
    {
        if(isRunning) return;
        thread = new Thread(this);
        display = new GameDisplay(dim);
        isRunning = true;
        thread.run();
    }

    public synchronized void stop()
    {
        if(!isRunning) return;

        try
        {
            thread.join();
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void init()
    {

    }

    private void update()
    {

    }

    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        g.clearRect(0, 0, dim.width, dim.height);

        //draw


        g.fillRect(0, 0, dim.width, dim.height);

        //end drawing
        bs.show();
        g.dispose();
    }
}
