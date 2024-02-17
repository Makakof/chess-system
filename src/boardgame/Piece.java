package boardgame;

public class Piece
{
    protected Position position;
    private Board board;

    public Piece(Board board)
    {
        this.board = board;
        // Poderia colocar -> position = null porém por padrão o Java ja preenche com o valor nulo
    }

    protected Board getBoard()
    {
        return board;
    }

}
