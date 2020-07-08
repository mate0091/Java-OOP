package M8W.games.tilegame;

import javax.swing.*;
import java.awt.*;

public class GameDisplay extends JFrame
{
    private Dimension dim;
    private Canvas canvas;

    public GameDisplay(int width, int height)
    {
        this.dim = new Dimension(width, height);
        setFrameDefaults();
    }

    public GameDisplay(Dimension d)
    {
        this.dim = d;
        setFrameDefaults();
    }

    public GameDisplay()
    {
        this(600, 600);
    }

    private void setFrameDefaults()
    {
        setTitle("Tile game");
        setSize(this.dim);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        this.canvas = new Canvas();

        this.canvas.setPreferredSize(dim);
        this.canvas.setMaximumSize(dim);
        this.canvas.setMaximumSize(dim);

        this.add(canvas);
        this.pack();
    }

    public Canvas getCanvas()
    {
        return canvas;
    }
}
