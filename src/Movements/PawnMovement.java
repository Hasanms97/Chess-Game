package Movements;

import Piece.Color;
import Piece.Spot;

import java.util.ArrayList;

public class PawnMovement extends MovementStrategy{

    int counter = 0;
    @Override
    public ArrayList<Spot> allPossibleMoves(Spot[][]spots, Spot position) {
        ArrayList<Spot>possibleMoves = new ArrayList<Spot>();

        int maxRow = spots.length;
        int maxCol = spots.length;

        int curRow = position.getRow();
        int curCol = position.getColumn();


        if (position.getPiece().getColor() == Color.BLACK) {
            if (counter < 2) {
                if(curRow+2  < maxRow)
                {
                    possibleMoves.add(new Spot(curRow+2,curCol));
                }
            }

            if (curRow+1 < 8) {
                possibleMoves.add(new Spot(curRow+1,curCol));
            }

            if (curCol+1 < maxCol && curRow+1 < maxRow) {
                possibleMoves.add(new Spot(curRow+1,curCol+1));
            }

            if (curCol-1 >= 0 && curRow+1 < maxRow) {
                possibleMoves.add(new Spot(curRow+1,curCol-1));
            }
        }

        if (position.getPiece().getColor() == Color.WHITE) {
            if (counter < 2) {
                if(curRow-2  >= 0)
                {
                    possibleMoves.add(new Spot(curRow-2,curCol));
                }
            }

            if (maxRow-1 >= 0) {
                possibleMoves.add(new Spot(curRow-1,curCol));
            }

            if (curCol+1 < maxCol && maxRow-1 >= 0) {
                possibleMoves.add(new Spot(curRow-1,curCol+1));
            }

            if (curCol-1 >= 0 && maxRow-1 >= 0) {
                possibleMoves.add(new Spot(curRow-1,curCol-1));
            }
        }
        counter++;
        return possibleMoves;
    }
}
