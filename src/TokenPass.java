public class TokenPass {
    private int [] board;
    private int currentPlayer;
    private int playerCount;
    public TokenPass (int playerCount)
    {
        this.playerCount = playerCount;
        board = new int[playerCount];
        for(int i = 0; i < playerCount; i++)
        {
            board[i] = 1 + (int) (10 * Math.random());
            currentPlayer = (int) (playerCount *  Math.random());
        }
    }

    public void printBoard()
    {
        String output = "";

        for(int i = 0; i < playerCount; i++)
        {
            output = output + "Player " + i + ": " + board [i];
        }
        System.out.println(output);
    }

    public void distributeCurrentPlayerTokens()
    {
        int d = board [currentPlayer];
        board [currentPlayer] = 0;
        for (int i = 0; i < d; i++)
        {
            board[(currentPlayer+i)%4]++;
        }
    }

    public int gameOver()
    {
        int win = 0;
        for (int i = 0; i < board.length; i++)
        {
            if (board[i] == 0)
            {
                return i;
            }
        }
        return board.length-1;
    }

    public void nextPlayer()
    {
        currentPlayer++;
    }
}
