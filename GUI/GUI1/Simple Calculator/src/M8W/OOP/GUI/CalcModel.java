package M8W.OOP.GUI;

public class CalcModel
{
    private static final int DEF_VAL = 1;

    private int currentvalue;

    public CalcModel()
    {
        this.reset();
    }

    public void reset()
    {
        currentvalue = DEF_VAL;
    }

    public void multiply(int value)
    {
        currentvalue *= value;
    }

    public void add(int value)
    {
        currentvalue += value;
    }

    public void setValue(String value)
    {
        currentvalue = Integer.parseInt(value);
    }

    public String getValue()
    {
        return Integer.toString(currentvalue);
    }
}
