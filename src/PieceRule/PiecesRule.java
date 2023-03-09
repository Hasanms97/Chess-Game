package PieceRule;

import Piece.Spot;

public abstract class PiecesRule {

    public abstract boolean rule(Spot from, Spot to, Spot[][]spots);
    public  boolean VerticalCheck(Spot from, Spot to, Spot[][] spots)
    {
        if (from.getColumn() == to.getColumn()) {
            if (from.getRow() < to.getRow()) {
                for (int x = from.getRow() + 1; x <= to.getRow() - 1; x++) {
                    if (spots[x][from.getColumn()].getPiece() != null) {
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            } else {
                int counter = Math.abs(to.getRow() - from.getRow());
                for (int x = 1; x < counter; x++) {
                    if (spots[from.getRow() - x][from.getColumn()].getPiece() != null) {
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            }
        } else if (from.getRow() == to.getRow()) {
            if (from.getColumn() > to.getColumn()) {
                for (int x = from.getColumn() + 1; x <= to.getColumn() - 1; x++) {
                    if (spots[from.getRow()][x].getPiece() != null) {
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            } else {
                int counter = Math.abs(from.getColumn() - to.getColumn());
                for (int x = 1; x < counter; x++) {
                    if (spots[from.getRow()][from.getColumn() - x].piece != null) { //edited to too from
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public  boolean DiognalCheck(Spot from, Spot to, Spot[][] spots) {
        int differenceInRows = Math.abs(from.getRow() - to.getRow());
        //from down to up left
        if(from.getRow() > to.getRow())
        {
            if(from.getColumn() > to.getColumn())
            {
                for(int x = 1; x < differenceInRows ;x++)
                {
                    if(spots[from.getRow()-x][from.getColumn()-x].getPiece() != null)
                    {
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            }
            else if(from.getColumn() < to.getColumn())
            {
                for(int x = 1; x < differenceInRows ;x++)
                {
                    if(spots[from.getRow()-x][from.getColumn()+x].getPiece() != null)
                    {
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            }
        }
        else if(from.getRow() < to.getRow())
        {
            if(from.getColumn() < to.getColumn())
            {
                for(int x = 1; x < differenceInRows ;x++)
                {
                    if(spots[from.getRow()+x][from.getColumn()+x].getPiece() != null)
                    {
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            }
            else if(from.getColumn() > to.getColumn())
            {
                for(int x = 1; x < differenceInRows ;x++)
                {
                    if(spots[from.getRow()+x][from.getColumn()-x].getPiece() != null)
                    {
                        return false;
                    }
                }
                if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() != from.getPiece().getColor()) {
                    return true;
                } else if (spots[to.getRow()][to.getColumn()].getPiece() != null && spots[to.getRow()][to.getColumn()].getPiece().getColor() == from.getPiece().getColor()) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
