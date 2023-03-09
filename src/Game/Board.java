package Game;

import Piece.Piece;
import Piece.Spot;

public abstract class Board {


    protected  Spot[][] spots;
    int movementCounter;
    public abstract void initializePieces();
    public abstract void printBoard();
    public Spot[][] getBoard() {
        return spots;
    }

    public void setMovementCounter(int movementCounter) {
        this.movementCounter = movementCounter;
    }

    public int getMovementCounter() {
        return movementCounter;
    }

    public Spot getSpot(int row, int column)
    {
        return spots[row][column];
    }
    public boolean positionExist(Spot spot)
    {
        if((spot.getRow() >= 0 && spot.getRow() < getBoard().length ) && (spot.getColumn() >= 0 && spot.getColumn() < getBoard()[0].length))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isTherePiece(Spot spot)
    {
        if(spot.piece == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Piece getPiece(Spot spot)
    {
        return spots[spot.getRow()][spot.getColumn()].getPiece();
    }

}
