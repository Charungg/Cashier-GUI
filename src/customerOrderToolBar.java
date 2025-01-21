import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerOrderToolBar implements ActionListener {

    private final JPanel customerOrderToolBar = new JPanel();

    public customerOrderToolBar(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight){
        customerOrderToolBar.setBounds(0,0,panelsWidth,topAndBotPanelsHeight);
        customerOrderToolBar.setBackground(Color.DARK_GRAY);

        JLabel text = new JLabel("customerOrderToolBar");

        customerOrderToolBar.add(text);
        frame.add(customerOrderToolBar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
