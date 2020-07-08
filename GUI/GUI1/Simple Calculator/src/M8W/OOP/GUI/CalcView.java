package M8W.OOP.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcView extends JFrame
{
    private static final int DEF_VALUE = 1;

    //Components:
    private JTextField userInTxt;
    private JTextField totalTxt;
    private JButton multiplyBtn;
    private JButton addBtn;
    private JButton clearBtn;

    private CalcModel model;

    public CalcView(CalcModel model)
    {
        this.model = model;
        this.model.setValue(Integer.toString(DEF_VALUE));

        //init components
        userInTxt = new JTextField(5);
        totalTxt = new JTextField(20);
        multiplyBtn = new JButton("Multiply");
        addBtn = new JButton("Add");
        clearBtn = new JButton("Clear");

        totalTxt.setText(this.model.getValue());
        totalTxt.setEditable(false);

        JPanel content = new JPanel(new FlowLayout());
        //content.setLayout(new FlowLayout());

        content.add(new JLabel("Input"));
        content.add(userInTxt);
        content.add(multiplyBtn);
        content.add(addBtn);
        content.add(new JLabel("Total"));
        content.add(totalTxt);
        content.add(clearBtn);

        setContentPane(content);

        super.pack();
        super.setTitle("Multiply Add app");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        super.setSize(new Dimension(270, 200));
    }

    public void reset()
    {
        this.totalTxt.setText(Integer.toString(DEF_VALUE));
    }

    public String getUserIn()
    {
        return this.userInTxt.getText();
    }

    public void setTotal(String total)
    {
        this.totalTxt.setText(total);
    }

    public void addMultListener(ActionListener mulistener)
    {
        this.multiplyBtn.addActionListener(mulistener);
    }

    public void addAddListener(ActionListener addlistener)
    {
        this.addBtn.addActionListener(addlistener);
    }

    public void addClearListener(ActionListener clearlistener)
    {
        this.clearBtn.addActionListener(clearlistener);
    }
}
