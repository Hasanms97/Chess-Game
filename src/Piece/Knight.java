package Piece;

import Movements.KnightMovement;
import PieceRule.KnightRule;

public class Knight extends Piece {
    public Knight(Color color, String symbol, Spot position){
        super(color, symbol, position, new KnightMovement(), new KnightRule());
    }
}
