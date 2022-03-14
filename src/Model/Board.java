package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String, Integer> players;

    public Board(int size){
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.players = new HashMap<>();
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Integer> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Integer> players) {
        this.players = players;
    }
}
