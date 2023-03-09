package Piece;

import Movements.MovementStrategy;
import Movements.QueenMovement;
import PieceRule.PiecesRule;
import PieceRule.QueenRule;

public class Queen extends Piece{
    public Queen(Color color, String symbol, Spot position) {
        super(color, symbol, position, new QueenMovement(), new QueenRule());
    }

}