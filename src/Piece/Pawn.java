package Piece;

import Movements.PawnMovement;
import PieceRule.PawnRule;

public class Pawn extends Piece{
    public Pawn(Color color, String symbol, Spot position) {
        super(color, symbol, position, new PawnMovement(), new PawnRule());
    }
}
