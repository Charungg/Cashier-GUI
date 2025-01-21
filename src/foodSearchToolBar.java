import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodSearchToolBar implements ActionListener {

    private final JPanel foodSearchToolBar = new JPanel();

    public foodSearchToolBar(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight){
        foodSearchToolBar.setBounds(panelsWidth,0,panelsWidth,topAndBotPanelsHeight) ;
        foodSearchToolBar.setBackground(Color.GRAY);

        JLabel text = new JLabel("foodSearchToolBar");

        foodSearchToolBar.add(text);
        frame.add(foodSearchToolBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
