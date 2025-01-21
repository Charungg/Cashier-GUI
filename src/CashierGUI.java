import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierGUI extends JFrame implements ActionListener {

    private int screenWidth;
    private int screenHeight;
    private customerOrderToolBar customerOrderToolBar;
    private foodSearchToolBar foodSearchToolBar;
    private customerFoodOrder customerFoodOrder;
    private foodOptions foodOptions;
    private customerInformation customerInformation;
    private foodCategoryOptions foodCategoryOptions;

    private JMenuItem editFoodItem;

    CashierGUI(){
        acquireScreenSize();
        setupMenuBar();
        setUpGUIPanel();
        GUISetVisible();
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

    public void setUpGUIPanel(){
        this.setSize(screenWidth,screenHeight);

        final int panelsWidth = screenWidth/2;
        final int topAndBotPanelsHeight = (int)(Math.round(screenHeight * 0.2));
        final int middlePanelsHeight = (int)(Math.round(screenHeight * 0.6));
        System.out.println("PanelsWidth | topAndBotPanelsHeight | middlePanelsHeight \n " +
                            panelsWidth + " | " + topAndBotPanelsHeight + " | " + middlePanelsHeight);

        customerOrderToolBar = new customerOrderToolBar(this, panelsWidth, topAndBotPanelsHeight);

        foodSearchToolBar = new foodSearchToolBar(this, panelsWidth, topAndBotPanelsHeight);

        customerFoodOrder = new customerFoodOrder(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        foodCategoryOptions = new foodCategoryOptions(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        foodOptions = new foodOptions(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        customerInformation = new customerInformation(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

    }

    public void setupMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem orderHistoryItem = new JMenuItem("Order History");
        JMenuItem printOrderHistoryItem = new JMenuItem("Print Order History");
        JMenuItem customerHistoryItem = new JMenuItem("Customer History");
        JMenuItem saveDatabaseItem = new JMenuItem("Save Database");
        JMenuItem loadDatabaseItem = new JMenuItem("Load Database");
        fileMenu.add(orderHistoryItem);
        fileMenu.add(printOrderHistoryItem);
        fileMenu.add(customerHistoryItem);
        fileMenu.add(saveDatabaseItem);
        fileMenu.add(loadDatabaseItem);


        JMenu editMenu = new JMenu("Edit");
        JMenuItem editFoodItem = new JMenuItem("Food/Prices");
        JMenuItem editFoodModifiers = new JMenuItem("Food Modifiers");
        JMenuItem editDeliverTracker = new JMenuItem("Deliver Tracker");
        editMenu.add(editFoodItem);
        editMenu.add(editFoodModifiers);
        editMenu.add(editDeliverTracker);


        JMenu helpMenu = new JMenu("Help");
        JMenuItem howToUseItem = new JMenuItem("How to Use");
        helpMenu.add(howToUseItem);


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
    }


    public void GUISetVisible(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == editFoodItem){
//            System.out.println("Hello World");
//        }
    }
}
