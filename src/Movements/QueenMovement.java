package Movements;

import Piece.Spot;
import java.util.ArrayList;

public class QueenMovement extends MovementStrategy{
    @Override
    public ArrayList<Spot> allPossibleMoves(Spot[][]spots, Spot position) {
        ArrayList<Spot> possibleMoves = new ArrayList<Spot>();

        RookMovement rookMovement = new RookMovement();
        BishopMovement bishopMovement = new BishopMovement();

        possibleMoves.addAll(rookMovement.allPossibleMoves(spots,position));
        possibleMoves.addAll(bishopMovement.allPossibleMoves(spots,position));

        return possibleMoves;
    }
}
