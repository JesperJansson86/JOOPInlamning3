import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    Tile[] tiles = new Tile[16];

    Game(){
        tiles = initiatepositions();
    }

    public static void main(String[] args) {
        Game hej = new Game();
        hej.run();
    }

    public void run() {
        tiles = initiatepositions();
        printMe();
        moveTile2(15,4);
        moveTile2(14,4);
        moveTile2(13,4);
        moveTile2(9,4);
        moveTile2(10,4);
        moveTile2(10,4);
        moveTile2(9,4);
        moveTile2(13,4);


        tiles[0].position.setFree(true);
        printMe();

//        for (int i = 0; i < tiles.length; i++) {
//            System.out.print(tiles[i].getPosition().getPositionnumber()+" ,");
//        }


    }
public Tile[] initiatepositions2(List list){
    Tile[] newtiles = new Tile[16];
        for (int i = 1; i <= 16; i++) {
        Tile t = new Tile(i);
        int temp = (int)list.get(i);
        newtiles[temp]=t;
        if (i==16) newtiles[temp].position.setFree(true);
    }
        return newtiles;
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
                System.out.print(tiles[i].position.getPositionnumber() + " ");
            }
        }
    }

    public void swap(int t1, int t2) {

        Tile temp = new Tile();
        temp = tiles[t1];
        tiles[t1] = tiles[t2];
        tiles[t2] = temp;

    }

    public void moveTile2(int tileNr, int width) {
        try {
            if (tiles[tileNr - 2].position.free&&tileNr % width != 1) {
                swap(tileNr - 1, tileNr - 2);
                System.out.println("vänster");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr - width - 1].position.free) {
                swap(tileNr - 1, tileNr - width - 1);
                System.out.println("ner");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr].position.free&&tileNr % width != 0) {
                swap(tileNr - 1, tileNr);
                System.out.println("höger");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
        try {
            if (tiles[tileNr - 1 + width].position.free) {
                swap(tileNr - 1, tileNr + width - 1);
                System.out.println("upp");
            }
        } catch (IndexOutOfBoundsException e) { /*ofarligt fel*/ }
    }


    public void startNewGame(){
        int[] list = generateValidList();
        for(int i = 0; i < tiles.length; i++){
            tiles[i].position.setPositionnumber(list[i]);
        }
    }

    public int[] generateValidList(){
        int[] list;
        while(true){
            int[] tempList = generateRandomList();
            if(validate(tempList)) {
                list = Arrays.copyOf(tempList, tempList.length);
                break;
            }
        }
        return list;
    }

    /*
    If the grid width is odd, then the number of inversions in a solvable situation is even.

If the grid width is even, and the blank is on an even row counting from the bottom (second-last, fourth-last etc),
then the number of inversions in a solvable situation is odd.

If the grid width is even, and the blank is on an odd row counting from the bottom (last, third-last, fifth-last etc)
then the number of inversions in a solvable situation is even.

Soure: https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
     */
    public static boolean validate(int[] list){
        int inversions = countInversions(list);
        if(blankOnRowFromBottom(list) % 2 == 0 && inversions % 2 == 1) return true;
        if(blankOnRowFromBottom(list) % 2 == 1 && inversions % 2 == 0) return true;
        return false;
    }

    public int[] generateRandomList(){
        Random random = new Random();
        int temp;
        int[] list = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        List<Integer> checkList = new ArrayList<>();
        for(int i = 0; i <= 15; i++){
            checkList.add(i);
        }
        for(int i = 0; i < list.length; i++){
            temp = random.nextInt(checkList.size());
            list[i] = checkList.get(temp);
            checkList.remove(temp);
        }
        return list;
    }

    public static int countInversions(int[] list){
        int inversions = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] == 15) continue;
            for(int j = i; j < list.length; j++){
                if(list[i] > list[j])
                    inversions++;
            }
        }

        return inversions;
    }

    public static int blankOnRowFromBottom(int[] list){
        int result = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] == 15){
                if(i > 11) result = 1;
                else if(i > 7) result = 2;
                else if(i > 3) result = 3;
                else result = 4;
            }
        }
        return result;
    }
}


