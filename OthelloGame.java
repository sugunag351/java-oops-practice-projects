import java.util.*;
public class OthelloGame
{
    final static int player1Symbol = 1;
    final static int player2Symbol = 2;

    public static void main(String[] args) {
        OthelloBoard b = new OthelloBoard();
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        boolean p1Turn = true;
        while(n > 0) {
            int x = s.nextInt();
            int y = s.nextInt();
            boolean ans = false;
            if(p1Turn) {
                ans = b.move(player1Symbol, x, y);
            }
            else {
                ans = b.move(player2Symbol, x, y);
            }
            if(ans) {
                b.print();
                p1Turn = !p1Turn;
                n--;
            }
            else {
                System.out.println(ans);
            }
        }
    }
}




class OthelloBoard {

    private int board[][];
    final static int player1Symbol = 1;
    final static int player2Symbol = 2;

    public OthelloBoard() {
        board = new int[8][8];
        board[3][3] = player1Symbol;
        board[3][4] = player2Symbol;
        board[4][3] = player2Symbol;
        board[4][4] = player1Symbol;
    }

    //print the board
    public void print() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //check the validation of placing symbol in that coordinate(x,y)
    public boolean move(int symbol, int x, int y){

        if(x<0 || x>7 || y<0 || y>7 || board[x][y]!=0)
        {
            return false;
        }
        int oppSymbol= (symbol==player1Symbol) ? player2Symbol : player1Symbol;
        boolean ans=false;
        //check total 8 directions
        int xDir[]={-1,-1,0,1,1,1,0,-1};
        int yDir[]={0,1,1,1,0,-1,-1,-1};
        int xStep,yStep;
        for(int i=0;i<xDir.length;i++)
        {
            xStep=xDir[i];
            yStep=yDir[i];
            int tx=x;
            int ty=y;
            tx=tx+xStep;
            ty=ty+yStep;
            int tempx=x;
            int tempy=y;
            if(((tx>=0 && tx<=7) && (ty>=0 && ty<=7)) && (board[tx][ty]==0 || board[tx][ty]==symbol))
            {
                continue;
            }
            else
            {
                while(((tx>=0 && tx<=7) && (ty>=0 && ty<=7)) && board[tx][ty]==oppSymbol)
                {
                    tx=tx+xStep;
                    ty=ty+yStep;
                }
                if(((tx>=0 && tx<=7) && (ty>=0 && ty<=7)) && board[tx][ty]==symbol)
                {
                    ans=true;
                    board[tempx][tempy]=symbol;
                    tempx+=xStep;
                    tempy+=yStep;
                    while(((tempx>=0 && tempx<=7 )&&(tempy>=0 && tempy<=7)) && board[tempx][tempy]==oppSymbol)
                    {
                        board[tempx][tempy]=symbol;
                        tempx+=xStep;
                        tempy+=yStep;
                    }
                }
            }
        }
        return ans;
    }
}

