package Piece;

import Movements.BishopMovement;
import PieceRule.BishopRule;

public class Bishop extends Piece{

    public Bishop(Color color, String symbol, Spot position){
        super(color, symbol, position, new BishopMovement(), new BishopRule());
    }
}
