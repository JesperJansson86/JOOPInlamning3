import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class GUI extends JFrame {
    protected boolean test;
    private int testWidth = 4;
    private JPanel pMain = new JPanel();
    private JPanel pCenter = new JPanel();
    private JPanel pSouth = new JPanel();
    private JPanel pNorth = new JPanel();
    private JPanel pWest = new JPanel();
    private JPanel tileGrid = new JPanel();
    private JLabel labelNorth = new JLabel("Arrange the tiles in numerical order");
    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 3, 9, 4);
    private JButton buttonNewGame = new JButton("New Game");
    private List<JButton> buttons = new ArrayList<>();
    private List<ImageIcon> icons = new ArrayList<>();
    private List<Image> iconImages = new ArrayList<>();
    private Game game = new Game();
    private Color blue = new Color(104, 147, 196);

    public GUI(boolean test, int width){
        this.test = test;
        testWidth = width;
        run();
    }

    public GUI() {
        run();
    }

    public void run(){
        addLogo();

        setLayout(new FlowLayout());
        add(pMain);
        pMain.setLayout(new BorderLayout());
        //North
        pMain.add(pNorth, BorderLayout.NORTH);
        pNorth.add(labelNorth);
        //South
        pMain.add(pSouth, BorderLayout.SOUTH);
        pSouth.setLayout(new GridLayout(4, 4));

        //Testcase
        if(test) {
            sliderMoved(testWidth);
            game.moveTile2(game.totalTiles - 1);
        }
        assignButtons();

        //West
        pMain.add(pWest, BorderLayout.WEST);

        //Center
        pMain.add(pCenter, BorderLayout.CENTER);
        pCenter.add(new JLabel("Grid Width:"));
        fixSlider();
        pCenter.add(slider);
        pCenter.add(buttonNewGame);
        buttonNewGame.addActionListener(l -> startNewGame());

        setTitle("15 Game");
        setVisible(true);
        setLocation(0,0);
        pack();
        buttonNewGame.setPreferredSize(new Dimension(120, 20));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void startNewGame(){
        game.startNewGame();
        assignButtons();
        labelNorth.setText("Arrange the tiles in numerical order");
    }

    public void pressButton(int tileNr) {
        game.moveTile2(tileNr);
        for (int i = 0; i < game.tiles.length; i++) {
        }
        assignButtons();
        if (game.checkIfSolved()) {
            labelNorth.setText("Congratulations!");
            return;
        }
    }

    public void sliderMoved(int sliderValue){
        game.setWidth(sliderValue);
        pSouth.removeAll();
        pSouth.setLayout(new GridLayout(game.width, game.width));
        assignButtons();
    }

    public void assignButtons() {
        pSouth.removeAll();
        for(int i = 0; i < game.totalTiles; i++){
            int number = game.tiles[i].getDisplaynumber();
            final int temp = i + 1;
            JButton button = new JButton(number + "");
            button.setPreferredSize(new Dimension(499 / game.width, 499/game.width));
            button.addActionListener(l -> pressButton(temp));
            if (number == game.totalTiles) {
                button.setVisible(false);
            } else {
                button.setBackground(blue);
            }
            if(game.checkIfSolved()) {
                if(!test)
                    button.setEnabled(false);
            }
            pSouth.add(button);
        }

        pSouth.revalidate();
        pSouth.repaint();
    }

    private void fixSlider(){
        slider.addChangeListener(l -> sliderMoved(slider.getValue()));
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
    }

    public void addLogo() {
        try {
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo16.png"))).getImage());
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo32.png"))).getImage());
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo64.png"))).getImage());
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo128.png"))).getImage());
        } catch (IOException e) {
            e.getStackTrace();
        }
        setIconImages(iconImages);
    }
}
