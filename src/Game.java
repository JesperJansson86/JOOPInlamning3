import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    int width =4;
    int totalTiles = width*width;
    Tile[] tiles = new Tile[totalTiles];

    Game() {
        tiles = initiateStartingPositions(createStartingPositionsArray());
    }

    public void setWidth(int width){
        this.width = width;
        totalTiles = width * width;
        tiles = initiateStartingPositions(createStartingPositionsArray());
    }

    public static void main(String[] args) {

    }

    private int[] createStartingPositionsArray() {
        int[] arr = new int[totalTiles];
        for (int i = 0; i < totalTiles; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private Tile[] initiateStartingPositions(int[] intarray) {
        Tile[] newtiles = new Tile[totalTiles];
        for (int i = 0; i < totalTiles; i++) {
            Tile t = new Tile(i + 1);
            int temp = intarray[i];
            newtiles[temp] = t;
            if (i == totalTiles-1) newtiles[temp].setFree(true);
        }
        return newtiles;
    }


    private void swapTiles(int t1, int t2) {

        Tile temp = new Tile();
        temp = tiles[t1];
        tiles[t1] = tiles[t2];
        tiles[t2] = temp;

    }

    public void moveTile2(int tileNr) {
        try {
            if (tiles[tileNr - 2].isFree() && tileNr % width != 1) {
                swapTiles(tileNr - 1, tileNr - 2);
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr - width - 1].isFree()) {
                swapTiles(tileNr - 1, tileNr - width - 1);
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr].isFree() && tileNr % width != 0) {
                swapTiles(tileNr - 1, tileNr);
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr - 1 + width].isFree()) {
                swapTiles(tileNr - 1, tileNr + width - 1);
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
    }

    public boolean checkIfSolved() {
        for (int i = 0; i < totalTiles; i++) {
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


    private int[] generateValidList() {
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
    private boolean validate(int[] intArr) {
        int inversions = countInversions(intArr);
        if (width % 2 == 0) {
            if (blankOnRowFromBottom(intArr) % 2 == 0 && inversions % 2 == 1) return true;
            if (blankOnRowFromBottom(intArr) % 2 == 1 && inversions % 2 == 0) return true;
        } else {
            if(inversions % 2 == 0) return true;
        }

        return false;
    }

    private int[] generateRandomList() {
        Random random = new Random();
        int temp;
        int[] array = new int[totalTiles];
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i <= totalTiles-1; i++) {
            checkList.add(i);
        }
        for (int i = 0; i < array.length; i++) {
            temp = random.nextInt(checkList.size());
            array[i] = checkList.get(temp);
            checkList.remove(temp);
        }
        return array;
    }

    private int countInversions(int[] list) {
        int inversions = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == totalTiles - 1) continue;
            for (int j = i; j < list.length; j++) {
                if (list[i] > list[j])
                    inversions++;
            }
        }

        return inversions;
    }

    private int blankOnRowFromBottom(int[] list) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == totalTiles-1) {
                result = (((totalTiles -1 ) - i) / width) + 1;
            }
        }
        return result;
    }
}


