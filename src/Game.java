import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    Tile[] tiles = new Tile[16];

    Game() {
        tiles = initiateStartingPositions(createStartingPositionsArray());
    }

    public static void main(String[] args) {

    }

    public int[] createStartingPositionsArray() {
        int[] arr = new int[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public Tile[] initiateStartingPositions(int[] intarray) {
        Tile[] newtiles = new Tile[16];
        for (int i = 0; i < 16; i++) {
            Tile t = new Tile(i + 1);
            int temp = intarray[i];
            newtiles[temp] = t;
            if (i == 15) newtiles[temp].setFree(true);
        }
        return newtiles;
    }


    public void swapTiles(int t1, int t2) {

        Tile temp = new Tile();
        temp = tiles[t1];
        tiles[t1] = tiles[t2];
        tiles[t2] = temp;

    }

    public void moveTile2(int tileNr, int width) {
        try {
            if (tiles[tileNr - 2].isFree() && tileNr % width != 1) {
                swapTiles(tileNr - 1, tileNr - 2);
                System.out.println("vänster");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr - width - 1].isFree()) {
                swapTiles(tileNr - 1, tileNr - width - 1);
                System.out.println("ner");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr].isFree() && tileNr % width != 0) {
                swapTiles(tileNr - 1, tileNr);
                System.out.println("höger");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr - 1 + width].isFree()) {
                swapTiles(tileNr - 1, tileNr + width - 1);
                System.out.println("upp");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
    }

    public boolean checkIfSolved() {
        for (int i = 0; i < 16; i++) {
            if (this.tiles[i].getDisplaynumber() != i + 1) {
                return false;
            }
        }
        return true;
    }

    public void startNewGame() {
        int[] list = generateValidList();
        tiles = initiateStartingPositions(list);
    }


    public int[] generateValidList() {
        int[] intArray;
        while (true) {
            int[] tempList = generateRandomList();
            if (validate(tempList)) {
                intArray = Arrays.copyOf(tempList, tempList.length);
                break;
            }
        }
        return intArray;
    }

    /*
    If the grid width is odd, then the number of inversions in a solvable situation is even.

If the grid width is even, and the blank is on an even row counting from the bottom (second-last, fourth-last etc),
then the number of inversions in a solvable situation is odd.

If the grid width is even, and the blank is on an odd row counting from the bottom (last, third-last, fifth-last etc)
then the number of inversions in a solvable situation is even.

Soure: https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
     */
    public static boolean validate(int[] intArr) {
        int inversions = countInversions(intArr);
        if (blankOnRowFromBottom(intArr) % 2 == 0 && inversions % 2 == 1) return true;
        if (blankOnRowFromBottom(intArr) % 2 == 1 && inversions % 2 == 0) return true;
        return false;
    }

    public int[] generateRandomList() {
        Random random = new Random();
        int temp;
        int[] list = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            checkList.add(i);
        }
        for (int i = 0; i < list.length; i++) {
            temp = random.nextInt(checkList.size());
            list[i] = checkList.get(temp);
            checkList.remove(temp);
        }
        return list;
    }

    public static int countInversions(int[] list) {
        int inversions = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 15) continue;
            for (int j = i; j < list.length; j++) {
                if (list[i] > list[j])
                    inversions++;
            }
        }

        return inversions;
    }

    public static int blankOnRowFromBottom(int[] list) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 15) {
                if (i > 11) result = 1;
                else if (i > 7) result = 2;
                else if (i > 3) result = 3;
                else result = 4;
            }
        }
        return result;
    }
}


