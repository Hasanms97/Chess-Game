package PieceRule;

import Piece.Spot;

public class RookRule extends PiecesRule{

    @Override
    public boolean rule(Spot from, Spot to, Spot[][] spots) {
        return VerticalCheck(from,to,spots);
    }

}
