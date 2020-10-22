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
        int one = t1 + 1;
        int two = t2 + 1;
        Tile temp = new Tile();
        temp = tiles[t1];
        tiles[t1]=tiles[t2];
        tiles[t2]=temp;
//        tiles[t1].position.setPositionnumber(16);
//        tiles[t2].position.setPositionnumber(one);
//        tiles[t1].displaynumber=two;
//        tiles[t2].displaynumber=one;
//        tiles[t1].position.setFree(true);
//        tiles[t2].position.setFree(false);

    }
    public void moveTile2(int tileNr, int width){
        try {
            if (tiles[tileNr - 2].position.free) swap(tileNr - 1, tileNr - 2);
            if (tiles[tileNr - width - 1].position.free) swap(tileNr - 1, tileNr - width - 1);
            if (tiles[tileNr].position.free) swap(tileNr - 1, tileNr);
            if (tiles[tileNr - 1 + width].position.free) swap(tileNr - 1, tileNr + width - 1);
        }catch (IndexOutOfBoundsException e){
            //Så här får en inte göra
        }
    }


    public void moveTile(int tileNr) {
        switch (tileNr) {
            case 1: {
                if (tiles[1].getPosition().free) swap(0, 1);
                if (tiles[4].getPosition().free) swap(0, 4);
                break;
            }
            case 2: {
                if (tiles[0].getPosition().free) swap(1, 0);
                if (tiles[2].getPosition().free) swap(1, 2);
                if (tiles[5].getPosition().free) swap(1, 5);
                break;
            }
            case 3: {
                if (tiles[1].getPosition().free) swap(2, 1);
                if (tiles[3].getPosition().free) swap(2, 3);
                if (tiles[6].getPosition().free) swap(2, 6);
                break;
            }
            case 4: {
                if (tiles[2].getPosition().free) swap(3, 2);
                if (tiles[7].getPosition().free) swap(3, 7);
                break;

            }
            case 5: {
                if (tiles[0].getPosition().free) swap(4, 0);
                if (tiles[5].getPosition().free) swap(4, 5);
                if (tiles[8].getPosition().free) swap(4, 8);
                break;
            }
            case 6: {
                if (tiles[1].getPosition().free) swap(5, 1);
                if (tiles[4].getPosition().free) swap(5, 4);
                if (tiles[6].getPosition().free) swap(5, 6);
                if (tiles[9].getPosition().free) swap(5, 9);
                break;
            }
            case 7: {
                if (tiles[2].getPosition().free) swap(6, 2);
                if (tiles[5].getPosition().free) swap(6, 5);
                if (tiles[7].getPosition().free) swap(6, 7);
                if (tiles[10].getPosition().free) swap(6, 10);
                break;
            }
            case 8: {
                if (tiles[3].getPosition().free) swap(7, 3);
                if (tiles[6].getPosition().free) swap(7, 6);
                if (tiles[11].getPosition().free) swap(7, 11);
                break;
            }
            case 9: {
                if (tiles[4].getPosition().free) swap(8, 4);
                if (tiles[9].getPosition().free) swap(8, 9);
                if (tiles[12].getPosition().free) swap(8, 12);
                break;
            }
            case 10: {
                if (tiles[5].getPosition().free) swap(9, 5);
                if (tiles[8].getPosition().free) swap(9, 8);
                if (tiles[10].getPosition().free) swap(9, 10);
                if (tiles[13].getPosition().free) swap(9, 13);
                break;
            }
            case 11: {
                if (tiles[6].getPosition().free) swap(10, 6);
                if (tiles[9].getPosition().free) swap(10, 9);
                if (tiles[11].getPosition().free) swap(10, 11);
                if (tiles[14].getPosition().free) swap(10, 14);
                break;
            }
            case 12: {
                if (tiles[7].getPosition().free) swap(11, 7);
                if (tiles[10].getPosition().free) swap(11, 10);
                if (tiles[15].getPosition().free) swap(11, 15);
                break;
            }
            case 13: {
                if (tiles[13].getPosition().free) swap(12, 13);
                if (tiles[8].getPosition().free) swap(12, 8);
                break;

            }
            case 14: {
                if (tiles[14].getPosition().free) swap(13, 14);
                if (tiles[12].getPosition().free) swap(13, 12);
                if (tiles[9].getPosition().free) swap(13, 9);
                break;

            }
            case 15: {
                if (tiles[15].getPosition().free) swap(14, 15);
                if (tiles[13].getPosition().free) swap(14, 13);
                if (tiles[10].getPosition().free) swap(14, 10);
                break;

            }
            case 16: {
                if (tiles[11].getPosition().free) swap(15, 11);
                if (tiles[14].getPosition().free) swap(15, 14);
                break;
            }
        }
        System.out.println("Move done.");
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


