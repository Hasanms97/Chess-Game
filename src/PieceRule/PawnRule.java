package PieceRule;

import Piece.Spot;

public class PawnRule extends PiecesRule{
    @Override
    public boolean rule(Spot from, Spot to, Spot[][] spots) {
        return VerticalCheck(from,to,spots);
    }
}
