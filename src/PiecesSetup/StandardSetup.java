package PiecesSetup;

import Piece.*;

public class StandardSetup  extends PiecesSetup{
    @Override
    public void setupPieces(Spot[][] spots) {
        {

            for (int x = 0; x < 8; x++) {
                spots[1][x].put(new Pawn(Color.BLACK,"♟︎",spots[1][x]));
                spots[6][x].put(new Pawn(Color.WHITE,"♙",spots[6][x]));
            }

            spots[7][3].put(new Queen(Color.WHITE,"♕",spots[7][3]));
            spots[0][3].put(new Pawn(Color.BLACK,"♛",spots[0][3]));

            King bk = new King(Color.BLACK, "♚",spots[0][4]);
            King wk = new King(Color.WHITE, "♔", spots[7][4]);

            spots[0][4].put(bk);
            spots[7][4].put(wk);

            spots[0][0].put(new Rook(Color.BLACK,"♜",spots[0][0]));
            spots[0][7].put(new Rook(Color.BLACK,"♜",spots[0][7]));
            spots[7][0].put(new Rook(Color.WHITE,"♖",spots[7][0]));
            spots[7][7].put(new Rook(Color.WHITE,"♖",spots[7][7]));




            spots[0][2].put(new Bishop(Color.BLACK,"♝",spots[0][2]));



            spots[0][1].put(new Knight(Color.BLACK,"♞",spots[0][1]));
            spots[0][6].put(new Knight(Color.BLACK,"♞",spots[0][6]));
            spots[7][1].put(new Knight(Color.WHITE,"♘",spots[7][1]));
            spots[7][6].put(new Knight(Color.WHITE,"♘",spots[7][6]));

            spots[0][2].put(new Bishop(Color.BLACK,"♝",spots[0][2]));
            spots[0][5].put(new Bishop(Color.BLACK,"♝",spots[0][5]));
            spots[7][2].put(new Bishop(Color.WHITE,"♗",spots[7][2]));
            spots[7][5].put(new Bishop(Color.WHITE,"♗",spots[7][5]));

        }
    }
}
