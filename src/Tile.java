public class Tile {
    protected Position position = new Position();
    protected int displaynumber;
    public Tile(){

    }
    public Tile(int pos){
        position.setPositionnumber(pos);
        displaynumber=pos;
    }
    public Position getPosition() {
        return position;
    }


    public void setPosition(Position position) {
        this.position = position;
    }
}
