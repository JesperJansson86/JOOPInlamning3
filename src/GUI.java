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
    private List<JButton> buttons = new ArrayList<>();
    private List<Image> icons = new ArrayList<Image>();
    private Game game = new Game();



    public GUI(){

        setLayout(new FlowLayout());
        add(pMain);
        pMain.setLayout(new BorderLayout());

        pMain.add(pNorth, BorderLayout.NORTH);
        pNorth.add(new JLabel("Arrange the tiles in numerical order"));

        pMain.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new GridLayout(4,4));
        pCenter.setBackground(Color.RED);

        assignButtons();
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

    public void assignButtons(){
        pCenter.removeAll();
        for(int i = 1; i <= 16; i++){
            for(int j = 0; j < game.tiles.length; j++){
                if(i == game.tiles[j].position.getPositionnumber()){
                    JButton button = new JButton(j+1 + "");
                    final int temp = j+1;
                    button.addActionListener(l -> pressButton( temp));
                    button.setPreferredSize(new Dimension(80,80));
                    if(j == 15){
                        button.setBackground(Color.RED);
                        button.setVisible(false);
                    }
                    else{
                        button.setBackground(Color.GREEN);
                    }
                    pCenter.add(button);
                }
            }
        }
        pCenter.revalidate();
        pCenter.repaint();
    }

    public void pressButton(int tileNr){
        game.moveTile(tileNr);
        assignButtons();
    }

    public void startNewGame(){
        game.startNewGame();
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
