package Piece;
import Movements.RookMovement;
import PieceRule.RookRule;

public class Rook extends Piece{
    public Rook(Color color, String symbol, Spot position){
        super(color, symbol, position, new RookMovement(), new RookRule());
    }
}
