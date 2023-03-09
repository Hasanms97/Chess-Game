package Game;

public class ChessGame {

    private Board board;

    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public ChessGame(ChessGameFactory chessGameFactory) {
        this.board = chessGameFactory.createBoard();
    }
}
