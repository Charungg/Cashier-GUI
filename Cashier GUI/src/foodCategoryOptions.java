import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodCategoryOptions implements ActionListener {

    private final JPanel foodCategoryOptions = new JPanel();

    public foodCategoryOptions(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        foodCategoryOptions.setBounds(panelsWidth,topAndBotPanelsHeight+middlePanelsHeight,panelsWidth,topAndBotPanelsHeight);
        foodCategoryOptions.setBackground(Color.lightGray);

        JLabel text = new JLabel("foodCategoryOptions");

        foodCategoryOptions.add(text);
        frame.add(foodCategoryOptions);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
