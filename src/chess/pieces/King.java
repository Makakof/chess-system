package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

import java.awt.event.WindowStateListener;

public class King extends ChessPiece {

    private ChessMatch chessMatch;
    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString()
    {
        return "K";
    }

    private boolean canMove(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position)
    {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves()
    {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //above-left
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //above-right
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below-left
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below-right
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Special move castling
        if(getMoveCount() == 0 && chessMatch.getCheck())
        {
            // Minor castling
            Position positionRookOne = new Position(position.getRow(), position.getColumn() + 3);
            if(testRookCastling(positionRookOne))
            {
                Position emptyHouseOne = new Position(position.getRow(), position.getColumn() + 1);
                Position emptyHouseTwo = new Position(position.getRow(), position.getColumn() + 2);
                if(getBoard().piece(emptyHouseOne) == null && getBoard().piece(emptyHouseTwo) == null)
                {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // Major castling
            Position positionRookTwo = new Position(position.getRow(), position.getColumn() - 4);
            if(testRookCastling(positionRookTwo))
            {
                Position emptyHouseOne = new Position(position.getRow(), position.getColumn() - 1);
                Position emptyHouseTwo = new Position(position.getRow(), position.getColumn() - 2);
                Position emptyHouseThree = new Position(position.getRow(), position.getColumn() - 3);
                if(getBoard().piece(emptyHouseOne) == null && getBoard().piece(emptyHouseTwo) == null
                        && getBoard().piece(emptyHouseThree) == null)
                {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }
        return mat;
    }
}
