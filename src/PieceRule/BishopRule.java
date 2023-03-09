package PieceRule;

import Piece.Spot;

public class BishopRule extends PiecesRule {
    @Override
    public boolean rule(Spot from, Spot to, Spot[][] spots) {
        return DiognalCheck(from,to,spots);
    }
}
