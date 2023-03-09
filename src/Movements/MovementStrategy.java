package Movements;

import Piece.Spot;

import java.util.ArrayList;

public abstract class MovementStrategy {
    public abstract ArrayList<Spot> allPossibleMoves(Spot[][]spots,Spot position);
    public boolean isValidMove(Spot from, Spot to, Spot[][] spots)
    {
        ArrayList<Spot>possibleMoves =  from.piece.getMovementStrategy().allPossibleMoves(spots,from);
        if(possibleMoves.contains(to) == true)
        {
            boolean isMoveValied = from.piece.getPiecesRule().rule(from, to, spots);
            if(isMoveValied == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        return false;
    }

    public boolean isTherePossibleMoves(Spot from,Spot[][]spots)
    {
        ArrayList<Spot>possibleMoves = from.getPiece().getMovementStrategy().allPossibleMoves(spots,from);

        for(int x = 0; x < possibleMoves.size() ;x++)
        {
            if(from.getPiece().getPiecesRule().rule(from,possibleMoves.get(x),spots) == true)
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Spot> legalMoves(Spot from, Spot[][]spots)
    {
        ArrayList<Spot> moves = new ArrayList<Spot>();
        ArrayList<Spot> possbileMoves = from.getPiece().getMovementStrategy().allPossibleMoves(spots,from);

        for(int x = 0; x < possbileMoves.size() ;x++)
        {
            if(isValidMove(from,possbileMoves.get(x),spots) == true)
            {
                moves.add(possbileMoves.get(x));
            }
        }
        return moves;
    }
}
