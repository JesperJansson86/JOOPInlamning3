import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
    private JPanel pMain = new JPanel();
    private JPanel pCenter = new JPanel();
    private JPanel pSouth = new JPanel();
    private JPanel pNorth = new JPanel();
    private JPanel tileGrid = new JPanel();
    private JButton buttonNewGame = new JButton("New Game");
    private List<JButton> tiles = new ArrayList<>();
    private List<Image> icons = new ArrayList<Image>();



    public GUI(){

        setLayout(new FlowLayout());
        add(pMain);
        pMain.setLayout(new BorderLayout());

        pMain.add(pNorth, BorderLayout.NORTH);
        pNorth.add(new JLabel("Arrange the tiles in numerical order"));

        pMain.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new GridLayout(4,4));
        for(int i = 1; i <= 16; i++){
            JButton tile = new JButton(i + "");
            tile.setPreferredSize(new Dimension(80,80));
            tiles.add(tile);
            //tile.addActionListener(l -> moveTile());
        }
        for(JButton tile : tiles){
            pCenter.add(tile);
        }
        //startNewGame();

        pMain.add(pSouth, BorderLayout.SOUTH);
        pSouth.add(buttonNewGame);
        buttonNewGame.setPreferredSize(new Dimension(320,20));
        //buttonNewGame.addActionListener(l -> startNewGame());

        setTitle("15 Game");
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        setMinimumSize(this.getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
