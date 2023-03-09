package Game;

public class StandardChessGame extends ChessGameFactory{
    @Override
    public Board createBoard() {
        return new StandardBoard();
    }
}
