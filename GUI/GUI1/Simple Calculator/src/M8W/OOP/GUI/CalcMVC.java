package M8W.OOP.GUI;

public class CalcMVC
{
    public static void main(String args[])
    {
        CalcModel model = new CalcModel();
        CalcView view = new CalcView(model);
        CalcController controller = new CalcController(view, model);
    }
}
