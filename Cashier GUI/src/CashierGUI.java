import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Note maybe make the top bar and bottom bar different size.
// So the top bar can be smaller than the bottom bar because food category will take a lot of space

public class CashierGUI extends JFrame implements ActionListener {

    private int screenWidth;
    private int screenHeight;

    private final JPanel customerOrderToolBar = new JPanel();

    private final JPanel foodSearchToolBar = new JPanel();

    private final JPanel customerFoodOrder = new JPanel();

    private final JPanel customerInformation = new JPanel();

    private final JPanel foodOptions = new JPanel();

    private final JPanel foodCategoryOptions = new JPanel();

    CashierGUI(){
        acquireScreenSize();
        setUpGUIPanelSizes();
        GUISetup();
    }

    public void acquireScreenSize(){
        // Laptop screen size = 1440 x 900 (But upscale by 2x to 2880x1800)

//        // Limitation:
//        // Doesn't work on multi-monitor setup.
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        screenWidth = (int) screenSize.getWidth();
//        screenHeight = (int) screenSize.getHeight();

        // Turns out the window bar takes some space from the resolution, so I have to take it into consideration
        Rectangle trueWindowSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        screenWidth = trueWindowSize.width;
        screenHeight = trueWindowSize.height;


        System.out.println("Screen size = " + screenWidth + " x " + screenHeight);
    }

    public void setUpGUIPanelSizes(){
        this.setSize(screenWidth,screenHeight);

        final int panelsWidth = screenWidth/2;
        final int topAndBotPanelsHeight = (int)(Math.round(screenHeight * 0.2));
        final int middlePanelsHeight = (int)(Math.round(screenHeight * 0.6));
        System.out.println("PanelsWidth | topAndBotPanelsHeight | middlePanelsHeight \n " +
                            panelsWidth + " | " + topAndBotPanelsHeight + " | " + middlePanelsHeight);

        customerOrderToolBar.setBounds(0,0,panelsWidth,topAndBotPanelsHeight);
        customerOrderToolBar.setBackground(Color.DARK_GRAY);

        foodSearchToolBar.setBounds(panelsWidth,0,panelsWidth,topAndBotPanelsHeight) ;
        foodSearchToolBar.setBackground(Color.GRAY);

        customerFoodOrder.setBounds(0,topAndBotPanelsHeight,panelsWidth,middlePanelsHeight);
        customerFoodOrder.setBackground(Color.lightGray);

        customerInformation.setBounds(0,panelsWidth+topAndBotPanelsHeight,panelsWidth,topAndBotPanelsHeight);
        customerInformation.setBackground(Color.DARK_GRAY);

        foodOptions.setBounds(panelsWidth,topAndBotPanelsHeight,panelsWidth,middlePanelsHeight);
        foodOptions.setBackground(Color.DARK_GRAY);
    }
    public void GUISetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);


        this.add(customerInformation);
        this.add(customerFoodOrder);
        this.add(foodSearchToolBar);
        this.add(customerOrderToolBar);
        this.add(foodOptions);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
