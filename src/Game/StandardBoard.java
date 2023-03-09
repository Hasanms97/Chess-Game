package Game;

import Piece.*;
import PiecesSetup.*;

public class StandardBoard extends Board{
    public StandardBoard()
    {
        this.spots = new Spot[8][8];
        for(int x = 0; x < spots.length ;x++)
        {
            for(int z = 0; z < spots[x].length ;z++)
            {
                spots[x][z] = new Spot(x,z);
            }
        }
    }
    public void setMovementCounter(int counter)
    {
        this.movementCounter = counter;
    }
    public int getMovementCounter()
    {
        return this.movementCounter;
    }
    @Override
    public void initializePieces() {
         PiecesSetup obj = new StandardSetup();
         obj.setupPieces(getBoard());
    }
    @Override
    public void printBoard() {
        System.out.print("  ");
        for(int x = 0; x < spots.length ;x++)
        {
            System.out.print(" "+x + " ");
        }
        System.out.println();
        for(int x = 0; x < spots.length ;x++)
        {
            System.out.print(x +" ");
            for(int z = 0; z < spots[x].length ;z++)
            {
                if(spots[x][z].piece != null)
                {
                    System.out.print(" "+spots[x][z].piece.getSymbol()+" ");
                }
                else
                {
                    System.out.print(" □ ");
                }
            }
            System.out.println();
        }
    }

}
