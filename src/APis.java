import Services.NewSnakeAndLadderService;
import Services.SnakeAndLadderService;

public class APis {

    public static void main(String[] args) {

        NewSnakeAndLadderService service = new NewSnakeAndLadderService();
        service.startGame();
//        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
//        snakeAndLadderService.startGame();
    }
}
