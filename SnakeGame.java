import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeGame {
    public char[][] snakeBoard = null;
    Queue<Cell> q = new LinkedList<Cell>();
    Queue<Cell> food = new LinkedList<Cell>();

    public SnakeGame(int row,int col){
        this.snakeBoard = new char[row][col];
        this.q.add(new Cell(0,0));
        this.snakeBoard[1][0] = 'X';
        this.snakeBoard[2][2] = 'X';
        this.snakeBoard[3][4] = 'X';
        this.snakeBoard[5][2] = 'X';
        this.snakeBoard[4][5] = 'X';
    }

    public void snakeMove(int row,int col){
        if(row>=0 && row< snakeBoard.length && col>=0 && col< snakeBoard.length) {
            if(snakeBoard[row][col] == '.'){
                System.out.println("Game Over");
                System.exit(0);
            }

            q.add(new Cell(row,col));

            if(snakeBoard[row][col]!='X'){
                Cell cell = q.poll();
                int r = cell.getRow();
                int c = cell.getCol();
                snakeBoard[r][c] = '\0';
            }
            snakeBoard[row][col] = '.';

            if(snakeBoard[row][col] == 'X'){
                snakeBoard[row][col] = '.';
            }

            //moveForwardAndPrint(row,col);

            while(!q.isEmpty()){
                printSnakeBoard();
                System.out.println("Enter direction:");
                Scanner sc = new Scanner(System.in);
                char direction = sc.next().charAt(0);
                if (direction == 'U') {
                    snakeMove(--row, col);
                }
                else if (direction == 'D') {
                    snakeMove(++row, col);
                }
                else if (direction == 'L') {
                    snakeMove(row, --col);
                }
                else if (direction == 'R') {
                    snakeMove(row, ++col);
                }
                else{
                    System.out.println("Enter Valid Direction");
                }
            }

        }
        else{
            System.out.println("Game Over");
            System.exit(0);
        }
    }


    /*public void moveForwardAndPrint(int row,int col){
        snakeBoard[row][col] = '.';
        printSnakeBoard();
    }*/

    public void printSnakeBoard(){
        for(char[] charArr:snakeBoard){
            for(int j=0;j<snakeBoard[0].length;j++){
                System.out.print(charArr[j]);
            }
            System.out.println();
        }
    }

}
