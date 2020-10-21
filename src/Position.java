public class Position {
    private int positionnumber;

    public int getPositionnumber() {
        return positionnumber;
    }

    public void setPositionnumber(int positionnumber) {
        this.positionnumber = positionnumber;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    boolean free;
    public Position(int pos){
        positionnumber=pos;
    }
}
