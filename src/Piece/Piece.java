package Piece;

import Game.Board;
import Movements.MovementStrategy;
import PieceRule.PiecesRule;

public abstract class Piece {

    protected final Color color;
    protected final String symbol;
    protected Spot position;
    protected Board board;
    protected PiecesRule piecesRule;
    protected MovementStrategy movementStrategy;




    public Piece(Color color, String symbol, Spot position,MovementStrategy movementStrategy, PiecesRule piecesRule) {
        this.color = color;
        this.symbol = symbol;
        this.position = position;
        this.movementStrategy = movementStrategy;
        this.piecesRule = piecesRule;
    }

    public Color getColor() {
        return color;
    }
    public String getSymbol() {
        return symbol;
    }
    public Spot getPosition() {
        return position;
    }
    public int getRow()
    {
        return position.getRow();
    }
    public int getColumn()
    {
        return position.column;
    }
    public void setPosition(Spot position) {
        this.position = position;
    }
    public PiecesRule getPiecesRule() {
        return piecesRule;
    }
    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
}
