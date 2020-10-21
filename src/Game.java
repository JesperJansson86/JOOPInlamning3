import java.util.Arrays;

public class Game {
    Tile[] tiles = new Tile[16];

    public static void main(String[] args) {
        Game hej = new Game();
        hej.run();
    }

    public void run() {
        tiles = initiatepositions();
        printMe();
        moveTile(15);
//        Position t = new Position(2);
//        tiles[15].setPosition(t);
        printMe();

    }

    public static Tile[] initiatepositions() {
        Tile t1 = new Tile(1);
        Tile t2 = new Tile(2);
        Tile t3 = new Tile(3);
        Tile t4 = new Tile(4);
        Tile t5 = new Tile(5);
        Tile t6 = new Tile(6);
        Tile t7 = new Tile(7);
        Tile t8 = new Tile(8);
        Tile t9 = new Tile(9);
        Tile t10 = new Tile(10);
        Tile t11 = new Tile(11);
        Tile t12 = new Tile(12);
        Tile t13 = new Tile(13);
        Tile t14 = new Tile(14);
        Tile t15 = new Tile(15);
        Tile t16 = new Tile(16);
        t16.position.setFree(true);
        Tile[] tileArr = new Tile[]{t1, t2, t3, t4,
                t5, t6, t7, t8,
                t9, t10, t11, t12,
                t13, t14, t15, t16};
        return tileArr;
    }

    public void printMe() {
        for (int i = 0; i < tiles.length - 1; ) {
            System.out.println();
            for (int j = 0; j < 4; j++, i++) {
                System.out.print(tiles[i].getPosition() + " ");
            }
        }
    }

    public void swap(int t1, int t2) {
        int one = t1;
        int two = t2;
        Tile temp = new Tile();
        temp.setPosition(tiles[one].getPosition());
        tiles[one].setPosition(tiles[two].getPosition());
        tiles[two].setPosition(temp.getPosition());


    }

    public void moveTile(int tileNr) {
        switch (tileNr) {
            case 1: {
                if (tiles[1].getPosition().free) swap(0, 1);
                if (tiles[4].getPosition().free) swap(0, 4);
            }
            case 2: {if (tiles[0].getPosition().free) swap(1, 0);
                if (tiles[2].getPosition().free) swap(1, 2);
                if (tiles[5].getPosition().free) swap(1, 5);
            }
            case 3: {  if (tiles[1].getPosition().free) swap(2, 1);
                if (tiles[3].getPosition().free) swap(2, 3);
                if (tiles[6].getPosition().free) swap(2, 6);
            }
            case 4: {if (tiles[2].getPosition().free) swap(3, 2);
                if (tiles[7].getPosition().free) swap(3, 7);

            }
            case 5: {     if (tiles[0].getPosition().free) swap(4, 0);
                         if (tiles[5].getPosition().free) swap(4, 5);
                         if (tiles[8].getPosition().free) swap(4, 8);
            }
            case 6: {if (tiles[1].getPosition().free) swap(5, 1);
                if (tiles[4].getPosition().free) swap(5, 4);
                if (tiles[6].getPosition().free) swap(5, 6);
                if (tiles[9].getPosition().free) swap(5, 9);
            }
            case 7: {if (tiles[2].getPosition().free) swap(6, 2);
                if (tiles[5].getPosition().free) swap(6, 5);
                if (tiles[7].getPosition().free) swap(6, 7);
                if (tiles[10].getPosition().free) swap(6, 10);
            }
            case 8: {if (tiles[3].getPosition().free) swap(7, 3);
                if (tiles[6].getPosition().free) swap(7, 6);
                if (tiles[11].getPosition().free) swap(7, 11);
            }
            case 9: {
                if (tiles[4].getPosition().free) swap(8, 4);
                if (tiles[9].getPosition().free) swap(8, 9);
                if (tiles[12].getPosition().free) swap(8, 12);
            }
            case 10: {if (tiles[5].getPosition().free) swap(9, 5);
                     if (tiles[8].getPosition().free) swap(9, 8);
                     if (tiles[10].getPosition().free) swap(9, 10);
                      if (tiles[13].getPosition().free) swap(9, 13);
            }
            case 11: {if (tiles[6].getPosition().free) swap(10, 6);
                    if (tiles[9].getPosition().free) swap(10, 9);
                    if (tiles[11].getPosition().free) swap(10, 11);
                    if (tiles[14].getPosition().free) swap(10, 14);
            }
            case 12: {if (tiles[7].getPosition().free) swap(11, 7);
                    if (tiles[10].getPosition().free) swap(11, 10);
                    if (tiles[15].getPosition().free) swap(11, 15);
            }
            case 13: {
                if (tiles[13].getPosition().free) swap(12, 13);
                if (tiles[8].getPosition().free) swap(12, 8);

            }
            case 14: {
                    if (tiles[14].getPosition().free) swap(13, 14);
                    if (tiles[12].getPosition().free) swap(13, 12);
                    if (tiles[9].getPosition().free) swap(13, 9);

            }
            case 15: {
                if (tiles[15].getPosition().free) swap(14, 15);
                if (tiles[13].getPosition().free) swap(14, 13);
                if (tiles[10].getPosition().free) swap(14, 10);

            }
            case 16: {
                if (tiles[11].getPosition().free) swap(15, 11);
                if (tiles[14].getPosition().free) swap(15, 14);



        }
    }
}}


