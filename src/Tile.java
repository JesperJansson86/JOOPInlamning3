public class Tile {

    private int displaynumber;
   private boolean free;
    public int getDisplaynumber() {
        return displaynumber;
    }

    public void setDisplaynumber(int displaynumber) {
        this.displaynumber = displaynumber;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }



    public Tile() {

    }

    public Tile(int displaynumber) {
        setDisplaynumber(displaynumber);
    }

}
