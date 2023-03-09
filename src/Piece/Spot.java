package Piece;

import java.util.Objects;

public class Spot {

    int row;
    int column;
    public Piece piece;

    public Spot( int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public void put(Piece piece) {
        setPiece(piece);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getColumn() {
        return column;
    }
    public void removePiece(Spot position)
    {
        position.setPiece(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return row == spot.row && column == spot.column;
    }
}
