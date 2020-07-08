package M8W.OOP.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController
{
    private CalcModel model;
    private CalcView view;

    public CalcController(CalcView view, CalcModel model)
    {
        this.view = view;
        this.model = model;

        //add listener for the view
        this.view.addAddListener(e -> {
            String userIn = view.getUserIn();
            model.add(Integer.parseInt(userIn));
            view.setTotal(model.getValue());
        });

        this.view.addMultListener(e -> {
            String userIn;
            userIn = view.getUserIn();
            model.multiply(Integer.parseInt(userIn));
            view.setTotal(model.getValue());
        });

        this.view.addClearListener(e -> {
            model.reset();
            view.reset();
        });
    }
}
