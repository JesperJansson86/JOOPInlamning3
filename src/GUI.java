import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI extends JFrame {
    private JPanel pMain = new JPanel();
    private JPanel pCenter = new JPanel();
    private JPanel pSouth = new JPanel();
    private JPanel pNorth = new JPanel();
    private JPanel tileGrid = new JPanel();
    private JLabel labelNorth = new JLabel("Arrange the tiles in numerical order");
    private JButton buttonNewGame = new JButton("New Game");
    private List<JButton> buttons = new ArrayList<>();
    private List<ImageIcon> icons = new ArrayList<>();
    private List<Image> iconImages = new ArrayList<>();
    private Game game = new Game();
    private Color blue = new Color(104, 147, 196);

    public GUI() {
        addLogo();

        setLayout(new FlowLayout());
        add(pMain);
        pMain.setLayout(new BorderLayout());
        //North
        pMain.add(pNorth, BorderLayout.NORTH);
        pNorth.add(labelNorth);
        //Center
        pMain.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new GridLayout(4, 4));
        sliderMoved();
        //TestCase
         game.moveTile2(game.totalTiles - 1);
        assignButtons();

        //South
        pMain.add(pSouth, BorderLayout.SOUTH);
        pSouth.add(buttonNewGame);
        buttonNewGame.addActionListener(l -> startNewGame());

        setTitle("15 Game");
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        buttonNewGame.setPreferredSize(new Dimension(this.getWidth(), 20));
        //setResizable(false);
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
        pack();
    }

    public void sliderMoved(){
        game.setWidth(5);
        pCenter.removeAll();
        pCenter.setLayout(new GridLayout(game.width, game.width));
    }

    public void assignButtons() {
        pCenter.removeAll();
        for(int i = 0; i < game.totalTiles; i++){
            int number = game.tiles[i].getDisplaynumber();
            final int temp = i + 1;
            JButton button = new JButton(number + "!");
            button.setPreferredSize(new Dimension(80, 80));
            button.addActionListener(l -> pressButton(temp));
            if (number == game.totalTiles) {
                button.setVisible(false);
            } else {
                button.setBackground(blue);
            }
            if(game.checkIfSolved()) {
                button.setEnabled(false);
            }
            pCenter.add(button);
        }
        pCenter.revalidate();
        pCenter.repaint();
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
