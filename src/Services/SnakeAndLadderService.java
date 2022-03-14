package Services;

import Model.Board;
import Model.Ladder;
import Model.Player;
import Model.Snake;

import java.util.*;

public class SnakeAndLadderService {

    private static final int finalPoint = 100;
    private Board board;

    public SnakeAndLadderService(){
        this.board = new Board(finalPoint);
        List<Snake> snakeList = new ArrayList<>();
        snakeList.add(new Snake(99, 54));
        snakeList.add(new Snake(70, 55));
        snakeList.add(new Snake(52, 42));
        snakeList.add(new Snake(25, 2));
        snakeList.add(new Snake(95, 72));
        board.setSnakes(snakeList);

        List<Ladder> ladderList = new ArrayList<>();
        ladderList.add(new Ladder(6, 24));
        ladderList.add(new Ladder(11, 40));
        ladderList.add(new Ladder(60, 85));
        ladderList.add(new Ladder(46, 90));
        ladderList.add(new Ladder(17, 69));
        board.setLadders(ladderList);

        Map<String, Integer> playerList = new HashMap<>();
        playerList.put("Tarun",0);
        playerList.put("Richa",0);
        board.setPlayers(playerList);
    }

    public boolean isGameCompleted(int playerPosition){
        return finalPoint == playerPosition;
    }

    public int currentPostion(int playerPosition, int value){
        int newPosition = playerPosition + value;

        if(newPosition > finalPoint){
            return playerPosition;
        }

        for(Snake snake : board.getSnakes()){
            if(snake.getStart() == newPosition){
                newPosition =  snake.getEnd();
            }
        }

        for(Ladder ladder : board.getLadders()){
            if(ladder.getStart() == newPosition){
                newPosition =  ladder.getEnd();
            }
        }
        return newPosition;
    }

    public void startGame(){
        System.out.println("***************************************************");
        System.out.println("******** Welcome to the Snake and Ladder Game******");
        System.out.println("***************************************************");
        System.out.println("********        Player 1 = Tarun             ******");
        System.out.println("********        Player 2 = Richa             ******");
        System.out.println("***************************************************");
        Scanner sc = new Scanner(System.in);
        int currentPlayer = -1;
        int diceValue = 0;
        Map<String, Integer> boardPlayers = board.getPlayers();
        String rPress;
        do{
            System.out.println(currentPlayer == -1 ? "\nTarun your turn" : "\nRicha your turn");
            System.out.println("Press r to roll the dice");
            rPress = sc.next();
            diceValue = DiceService.roll();

            if(currentPlayer == -1){
                System.out.println("Tarun current position : " + boardPlayers.get("Tarun"));
                int currentPostion = currentPostion(boardPlayers.get("Tarun"), diceValue);
                boardPlayers.put("Tarun",currentPostion);
                System.out.println("Tarun new Position:"+boardPlayers.get("Tarun"));
                System.out.println("Richa Position:"+boardPlayers.get("Richa"));
                System.out.println("-------------------------");
                if(isGameCompleted(boardPlayers.get("Tarun"))){
                    System.out.println("Congratulations Tarun!, you won the game");
                    return;
                }
            }
            else{
                System.out.println("Richa current position : " + boardPlayers.get("Richa"));
                int currentPostion = currentPostion(boardPlayers.get("Richa"), diceValue);
                boardPlayers.put("Richa",currentPostion);
                System.out.println("Richa new Position:"+boardPlayers.get("Richa"));
                System.out.println("Tarun Position:"+boardPlayers.get("Tarun"));
                System.out.println("-------------------------");
                if(isGameCompleted(boardPlayers.get("Richa"))){
                    System.out.println("Congratulations Richa! you won the game");
                    return;
                }
            }
            currentPlayer = -currentPlayer;

        }while("r".equals(rPress));
    }
}
