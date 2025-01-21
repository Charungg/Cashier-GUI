import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodOptions implements ActionListener {

    private final JPanel foodOptions = new JPanel();

    public foodOptions(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        foodOptions.setBounds(panelsWidth,topAndBotPanelsHeight,panelsWidth,middlePanelsHeight);
        foodOptions.setBackground(Color.DARK_GRAY);

        JLabel text = new JLabel("foodOptions");

        foodOptions.add(text);
        frame.add(foodOptions);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
