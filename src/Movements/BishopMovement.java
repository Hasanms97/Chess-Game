package Movements;

import Piece.Spot;
import java.util.ArrayList;

public class BishopMovement extends MovementStrategy {
    @Override
    public ArrayList<Spot> allPossibleMoves(Spot[][]spots, Spot position) {
        ArrayList<Spot>possibleMoves = new ArrayList<Spot>();


        int maxRow = spots.length;
        int maxCol = spots.length;

        int curRow = position.getRow();
        int curCol = position.getColumn();


        //down-right
        for(int x = 1; x <= maxRow ;x++)
        {
            if(curRow+x < maxRow && curCol+x < maxCol)
            {
                possibleMoves.add(new Spot(curRow+x,curCol+x));
            }
        }

        //down-left
        for(int x = 1; x <= maxRow ;x++)
        {
            if(curRow+x < maxRow && curCol-x >= 0)
            {
                possibleMoves.add(new Spot(curRow+x,curCol-x));
            }
        }

        //up-right
        for(int x = 1; x <= maxRow ;x++)
        {
            if(curRow-x >= 0 && curCol+x < maxCol)
            {
                possibleMoves.add(new Spot(curRow-x,curCol+x));
            }
        }

        //up-left
        for(int x = 1; x <= maxRow ;x++)
        {
            if(curRow-x >= 0 && curCol-x >= 0)
            {
                possibleMoves.add(new Spot(curRow-x,curCol-x));
            }
        }

        return possibleMoves;
    }
}
