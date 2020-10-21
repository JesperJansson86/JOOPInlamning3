public class Tile {
    protected Position position = new Position();

    public Tile(){

    }
    public Tile(int pos){
        position.setPositionnumber(pos);
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
