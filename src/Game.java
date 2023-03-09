import Game.Board;
import Game.ChessGame;
import Game.StandardChessGame;
import Piece.Color;
import Piece.Piece;
import Piece.Spot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private Color turn;
    private Board board;
    private ChessGame chessGame;


    public Game() {
        chessGame = new ChessGame(new StandardChessGame());
        board = chessGame.getBoard();
        chessGame.getBoard().initializePieces();;
        turn = Color.WHITE;
    }

    public Spot[][] getBoard()
    {
        return board.getBoard();
    }
    public void setTurn(Color turn) {
        this.turn = turn;
    }
    public Color getTurn() {
        return turn;
    }

    public void nextTurn(Color color)
    {
        if(color == Color.BLACK)
        {
            setTurn(Color.WHITE);
        }
        else
        {
            setTurn(Color.BLACK);
        }
    }
    public  Spot readUserInput(Scanner sc)
    {
        try {
            String input = sc.next();
            String row = Character.toString(input.charAt(0));
            String column = Character.toString(input.charAt(1));

            int rowI = Integer.parseInt(row);
            int columnI = Integer.parseInt(column);

            Spot obj = board.getSpot(rowI,columnI);
            return obj;
        }
        catch (RuntimeException e) {
            System.out.println("Error reading ChessPosition. Valid values are from 0 to 7.");
            System.out.print("Enter position in a correct from: ");
            return null;
        }

    }

    private boolean validateSourcePosition(Spot position) {
        if (position.getPiece() == null) {
            System.out.println("There is no piece on source position");
            System.out.println("Enter start point again: ");
            return false;
        }
        if (getTurn() != position.getPiece().getColor()) {
            System.out.println("The chosen piece is not yours");
            System.out.println("Enter start point again: ");
            return false;
        }
        if (!position.getPiece().getMovementStrategy().isTherePossibleMoves(position,board.getBoard())) {
            System.out.println("There is no possible moves for the chosen piece");
            System.out.println("Enter start point again: ");
            return false;
        }
        return true;
    }
    private boolean validateTargetPosition(Spot from, Spot to) {
        if (from.getPiece().getMovementStrategy().allPossibleMoves(board.getBoard(),from.getPiece().getPosition()).contains(to) != true) {
            System.out.println("The chosen piece can't move to target position");
            System.out.println("Enter end point again: ");
            return false;
        }
        else {
            return true;
        }
    }
    public boolean performChessMove(Spot from, Spot to) {

        if(from.getClass().getName() == "Piece.King")
        {
            ArrayList<Spot>kingMovements = filterKingMovements(from.getPiece().getColor());
            if(kingMovements.contains(to) == false)
            {
                System.out.println("King can not move to the given direction!");
                System.out.println("Enter end point again: ");
                return false;
            }
            else
            {
                move(from,to);
                return true;
            }
        }

        move(from,to);
        return true;
    }
    public void move(Spot from, Spot to)
    {
        to.setPiece(from.getPiece());
        from.getPiece().setPosition(to);
        from.removePiece(from);
    }
    public Spot getKingPosition(Color color)
    {
        Spot[][]spots = board.getBoard();
        for(int x = 0; x < spots.length ;x++)
        {
            for(int z = 0; z < spots[x].length ;z++)
            {
                if(spots[x][z].getPiece() != null && spots[x][z].getPiece().getColor() == color && spots[x][z].getPiece().getClass().getName() == "Piece.King" )
                {
                    return spots[x][z];
                }
            }
        }
        return null;
    }
    public boolean testCheck(Color color)
    {
        Spot kingPosition = getKingPosition(color);
        Spot[][]spots = board.getBoard();

        for(int x = 0; x < spots.length ;x++)
        {
            for(int z = 0; z < spots[x].length ;z++)
            {                                                                                                                                           //Spot from, Spot to, Spot[][] spots
                if(spots[x][z].getPiece() != null && spots[x][z].getPiece().getColor() != color && spots[x][z].getPiece().getMovementStrategy().isValidMove(spots[x][z],kingPosition,spots))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public ArrayList<Spot>filterKingMovements(Color color)
    {
        Spot kingPosition = getKingPosition(color);
        Spot[][]spots = board.getBoard();
        ArrayList<Spot>kingMoves = kingPosition.getPiece().getMovementStrategy().legalMoves(kingPosition,spots);
        ArrayList<Spot>allMovments = new ArrayList<Spot>();

        for(int x = 0; x < spots.length ;x++)
        {
            for(int z = 0; z < spots[x].length ;z++)
            {
                if(spots[x][z].getPiece() != null && spots[x][z].getPiece().getColor() != color)
                {
                    allMovments.addAll(spots[x][z].getPiece().getMovementStrategy().allPossibleMoves(getBoard(),spots[x][z]));
                }
            }
        }

        for(int x = 0; x < kingMoves.size() ;x++)
        {
            if(allMovments.contains(kingMoves.get(x)))
            {
                kingMoves.remove(x);
            }
        }

        return kingMoves;
    }
    public boolean testCheckMate(Color color)
    {
        Spot kingPosition = getKingPosition(color);
        Spot[][]spots = board.getBoard();

        if(testCheck(color) == true)
        {
            ArrayList<Spot> kingLegalMoves =  filterKingMovements(color);
            if(kingLegalMoves.size() == 0)
            {
                return true;
            }
        }

        return false;
    }
    public Color swapColor(Color color)
    {
        if(color == Color.BLACK)
        {
            return Color.WHITE;
        }
        else
        {
            return Color.BLACK;
        }
    }
    public boolean gameOver(Color color)
    {
        if(testCheck(color) == true)
        {
            System.out.println("Check " + color.toString());
            if(testCheckMate(color) == true)
            {
                System.out.println("Checkmate" + color.toString());
                return true;
            }
        }
        else if(board.getMovementCounter() >= 50)
        {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
    public void start()
    {
        Scanner sc =  new Scanner(System.in);
        while(true)
        {

            board.printBoard();
            System.out.println("\n\n");
            System.out.println("Turn: " + getTurn().toString());


            System.out.print("Enter start point: ");
            Spot from = null;
            while(true)
            {
                from = readUserInput(sc);
                if(from != null && validateSourcePosition(from))
                {
                    break;
                }
            }

            System.out.print("\nEnter end point: ");
            Spot to = null;
            while(true)
            {
                to = readUserInput(sc);
                if(to != null && validateTargetPosition(from,to))
                {
                    break;
                }
            }

            while (true)
            {
                if(performChessMove(from,to))
                {
                    break;
                }
            }

            if(gameOver(swapColor(getTurn())))
            {
                break;
            }
            nextTurn(getTurn());
            board.setMovementCounter(board.getMovementCounter()+1);
        }
    }
}
