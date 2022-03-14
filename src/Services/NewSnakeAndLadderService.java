package Services;

import Model.*;

import java.util.*;

public class NewSnakeAndLadderService {

    private static final int finalPoint = 100;
    private NewBoard board;

    public NewSnakeAndLadderService(){
        this.board = new NewBoard(finalPoint);
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

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Tarun",0));
        playerList.add(new Player("Richa",0));
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
        List<Player> playerList = board.getPlayers();
        String rPress;
        do{
            System.out.println(currentPlayer == -1 ? "\nTarun your turn" : "\nRicha your turn");
            System.out.println("Press r to roll the dice");
            rPress = sc.next();
            diceValue = DiceService.roll();

            if(currentPlayer == -1){
                System.out.println("Tarun current position : " + playerList.get(0).getPosition());
                int currentPostion = currentPostion(playerList.get(0).getPosition(), diceValue);
                playerList.get(0).setPosition(currentPostion);
                System.out.println("Tarun new Position:"+playerList.get(0).getPosition());
                System.out.println("Richa Position:"+playerList.get(1).getPosition());
                System.out.println("-------------------------");
                if(isGameCompleted(playerList.get(0).getPosition())){
                    System.out.println("Congratulations Tarun!, you won the game");
                    return;
                }
            }
            else{
                System.out.println("Richa current position : " + playerList.get(1).getPosition());
                int currentPostion = currentPostion(playerList.get(1).getPosition(), diceValue);
                playerList.get(1).setPosition(currentPostion);
                System.out.println("Richa new Position:"+playerList.get(1).getPosition());
                System.out.println("Tarun Position:"+playerList.get(0).getPosition());
                System.out.println("-------------------------");
                if(isGameCompleted(playerList.get(1).getPosition())){
                    System.out.println("Congratulations Richa! you won the game");
                    return;
                }
            }
            currentPlayer = -currentPlayer;

        }while("r".equals(rPress));
    }
}
