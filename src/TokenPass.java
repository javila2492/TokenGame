public class TokenPass
{
    int board[];
    int pCount;
    int currPlayer;
    int winner = -1;
    public TokenPass(int playerCount)
    {
        pCount = playerCount;
        board = new int[pCount];
        for(int i = 0; i < pCount; i++)
        {
            board[i] = (int) (Math.random() * 10) + 1;
        }
        currPlayer = (int) (Math.random() * (pCount - 1));
    }
    public void printBoard()
    {
        for(int i = 0; i < pCount; i++)
        {
            System.out.println("Player " + i + ": " + board[i] + " tokens");
        }
    }
    public void distributeCurrentPlayerTokens()
    {
        int time = board[currPlayer];
        for(int i = currPlayer; i < pCount; i++)
        {
            board[currPlayer]--;
            board[i]++;
            time--;
            if(board[currPlayer] == 0)
                winner = currPlayer;
            if(time == 0) {
                System.out.println("Round Over");
                break;
            }
            if(i == pCount - 1)
                i = -1;
        }
    }
    public void nextPlayer()
    {
        if(currPlayer == pCount - 1)
            currPlayer = 0;
        else
            currPlayer++;
    }
    public int gameOver()
    {
        return winner;
    }
}
