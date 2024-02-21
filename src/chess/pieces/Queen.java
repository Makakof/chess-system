package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece
{

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString()
    {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        // Movimentos da torre

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // MOvimentos do Bispo

        // above-left
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues((p.getRow() - 1),p.getColumn() - 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // above-right
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues((p.getRow() - 1),p.getColumn() + 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below-right
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues((p.getRow() + 1),p.getColumn() + 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below-left
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues((p.getRow() + 1),p.getColumn() - 1);
        }
        if(getBoard().positionExist(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }



        return mat;
    }
}
