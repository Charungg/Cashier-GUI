import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerInformation implements ActionListener {

    private final JPanel customerInformation = new JPanel();

    public customerInformation(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        customerInformation.setBounds(0,topAndBotPanelsHeight+middlePanelsHeight,panelsWidth,topAndBotPanelsHeight);
        customerInformation.setBackground(Color.DARK_GRAY);

        JLabel text = new JLabel("customerInformation");

        customerInformation.add(text);
        frame.add(customerInformation);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
