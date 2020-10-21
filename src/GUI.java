import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
    private JPanel pMain = new JPanel();
    private JPanel pCenter = new JPanel();
    private JPanel pSouth = new JPanel();
    private JPanel pNorth = new JPanel();
    private JPanel tileGrid = new JPanel();
    private JButton buttonNewGame = new JButton("New Game");
    private List<JButton> buttons = new ArrayList<>();
    private List<ImageIcon> icons = new ArrayList<>();
    private List<Image> iconImages = new ArrayList<>();
    private Game game = new Game();
    private Color blue = new Color(104,147,196);



    public GUI(){
        addLogo();

        setLayout(new FlowLayout());
        add(pMain);
        pMain.setLayout(new BorderLayout());

        pMain.add(pNorth, BorderLayout.NORTH);
        pNorth.add(new JLabel("Arrange the tiles in numerical order"));

        pMain.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new GridLayout(4,4));
//        pCenter.setBackground(Color.RED);

//        startNewGame();
        assignButtons();

        pMain.add(pSouth, BorderLayout.SOUTH);
        pSouth.add(buttonNewGame);
        buttonNewGame.setPreferredSize(new Dimension(320,20));
        buttonNewGame.addActionListener(l -> startNewGame());

        setTitle("15 Game");
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void assignButtons(){
        pCenter.removeAll();
        for(int i = 0; i < 16; i++){
            int number = game.tiles[i].position.getPositionnumber();
            final int temp = number;
            JButton button = new JButton(number + "");
            button.setPreferredSize(new Dimension(80,80));
            button.addActionListener(l -> pressButton(temp));
            if(number == 16){
                button.setVisible(false);
            }
            else {
                button.setBackground(blue);
            }
            pCenter.add(button);
        }
        pCenter.revalidate();
        pCenter.repaint();
    }

    public void pressButton(int tileNr){
        game.moveTile(tileNr);
        assignButtons();
    }

    public void addLogo(){
        try {
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo16.png"))).getImage());
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo32.png"))).getImage());
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo64.png"))).getImage());
            iconImages.add(new ImageIcon(ImageIO.read(new File("img/logo128.png"))).getImage());
        } catch (IOException e){
            e.getStackTrace();
        }
        setIconImages(iconImages);
    }

    public void startNewGame(){
        game.startNewGame();
        assignButtons();
    }

    public static void main(String[] args){
        GUI gui = new GUI();
    }
}
