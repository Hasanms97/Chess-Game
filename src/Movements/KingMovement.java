package Movements;
import Piece.Spot;

import java.util.ArrayList;

public class KingMovement extends MovementStrategy{
    @Override
    public ArrayList<Spot> allPossibleMoves(Spot[][]spots, Spot position) {
        ArrayList<Spot>possibleMoves = new ArrayList<Spot>();

        int maxRow = spots.length;
        int maxCol = spots.length;

        int curRow = position.getRow();
        int curCol = position.getColumn();

        if(curRow+1 < maxRow)
        {
            possibleMoves.add(new Spot(curRow+1,curCol));
            if(curCol+1 < maxCol)
            {
                possibleMoves.add(new Spot(curRow+1,curCol+1));
            }
            if(curCol-1 >= 0)
            {
                possibleMoves.add(new Spot(curRow+1,curCol-1));
            }
        }
        if(curRow-1 >= 0)
        {
            possibleMoves.add(new Spot(curRow-1,curCol));
            if(curCol+1 < maxCol)
            {
                possibleMoves.add(new Spot(curRow-1,curCol+1));
            }
            if(curCol-1 >= 0)
            {
                possibleMoves.add(new Spot(curRow-1,curCol-1));
            }
        }
        if(curCol-1 >= 0)
        {
            possibleMoves.add(new Spot(curRow,curCol-1));
        }
        if(curCol+1 < maxCol)
        {
            possibleMoves.add(new Spot(curRow,curCol+1));
        }


        return possibleMoves;
    }
}
