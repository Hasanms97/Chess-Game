package Piece;

import Movements.KingMovement;
import PieceRule.KingRule;

public class King extends Piece{

    public King(Color color, String symbol, Spot position){
        super(color, symbol, position, new KingMovement(), new KingRule());
    }
}
