package PieceRule;

import Piece.Spot;

public class KnightRule extends PiecesRule{
    @Override
    public boolean rule(Spot from, Spot to, Spot[][] spots) {
        if(to.getPiece().getColor() != from.getPiece().getColor())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
