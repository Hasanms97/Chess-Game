package Movements;
import Piece.Spot;
import java.util.ArrayList;

public class RookMovement extends MovementStrategy{

    @Override
    public ArrayList<Spot> allPossibleMoves(Spot[][]spots, Spot position) {
        ArrayList<Spot>possibleMoves = new ArrayList<Spot>();
        int maxRow = spots.length;
        int maxCol = spots.length;

        int curRow = position.getRow();
        int curCol = position.getColumn();

        //down
        for(int x = curRow+1; x < maxRow ;x++)
        {
            possibleMoves.add(new Spot(x,curCol));
        }

        //up
        for(int x = curRow-1; x >= 0 && x < maxCol ;x--)
        {
            possibleMoves.add(new Spot(x,curCol));
        }

        //right
        for(int x = curCol+1; x < maxCol ;x++)
        {
            possibleMoves.add(new Spot(curRow,x));
        }

        //left
        for(int x = curCol-1; x >= 0  && x < maxCol ;x--)
        {
            possibleMoves.add(new Spot(curRow,x));
        }

        return possibleMoves;

    }
}
