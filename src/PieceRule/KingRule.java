package PieceRule;

import Piece.Spot;

public class KingRule extends PiecesRule{

    @Override
    public boolean rule(Spot from, Spot to, Spot[][] spots) {
        if(from.getRow() == to.getRow() || from.getColumn() == to.getColumn())
        {
            return VerticalCheck(from,to,spots);
        }
        else
        {
            return DiognalCheck(from,to,spots);
        }
    }
}
