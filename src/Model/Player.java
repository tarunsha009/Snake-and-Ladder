package Model;

public class Player {
    private String name;
    private int position;

    public Player(String name, int id){
        this.name = name;
        this.position = id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
