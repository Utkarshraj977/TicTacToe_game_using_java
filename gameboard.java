
import java.util.Scanner;

class TicTacToe{
    static char board[][];

    public TicTacToe(){
        board=new char[3][3];
        initiatboard();
    }

    void initiatboard(){
        for(int k=0;k<board.length*board.length;k++){
            board[k/board.length][k%board.length]=' ';
        }
    }

    static void printboard(){
        System.out.println("--------------");
        for(int k=0;k<board.length*board[0].length;k++){
            if((k%board.length)==0){
                System.out.print(" | ");
            }
             System.out.print( board[k/board.length][k%board.length] +" | ");
            if((k%board.length)==2){
                System.out.println();
                System.out.println("--------------");
            }
        }
    }
   static void placesign(int row,int col,char sign){
        if((row>=0 && row<=2) && (col>=0 && col<=2)){
           board[row][col]=sign;
        }else{
            System.out.println("Invalid position !");
        }
    }
    static boolean checkwin(){
        //row checking
        for(int i=0;i<=2;i++){
          if(board[0][i]!=' ' && (board[0][i]==board[1][i]) && (board[1][i]==board[2][i])){
              return true;
          }
        }
        //column checking
        for(int i=0;i<=2;i++){
            if(board[i][0]!=' ' && (board[i][0]==board[i][1]) && (board[i][1]==board[i][2])){
                return true;
            }
        }
        //diagonal checking
        if(board[0][0]!=' ' && ((board[0][0] == board[1][1]) && (board[1][1]==board[2][2]))){
            return true;
        }
        //second row checking
        if(board[0][2]!=' ' && ((board[0][2]==board[2][0]) && board[2][0]==board[1][1])){
            return true;
        }
        return false;
    }
    //check full 
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}

//for human player vs human player
class Humanplayer{
    String name;
    char sign;
    public Humanplayer(String name,char sign){
        this.name=name;
        this.sign=sign;
    }

    void makemove(){
        Scanner sc=new Scanner(System.in);
        int row,col;
        do{
            System.out.println(name +", Enter row and column:");
            row=sc.nextInt();
            col=sc.nextInt();
            TicTacToe.placesign(row, col, sign);
        }while(isvalidmove(row, col));
    }
    boolean isvalidmove(int row,int col){
        if((row>=0 && row<=2) && (col>=0 && col<=2)){
            if(TicTacToe.board[row][col]==' '){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

public class gameboard {
    public static void main(String args[]){
           TicTacToe t=new TicTacToe();
           Humanplayer p1=new Humanplayer("bob",'X'); 
           Humanplayer p2=new Humanplayer("babita",'O'); 

           Humanplayer cp=p1;
           while(true){
                TicTacToe.printboard();
                System.out.println(cp.name +"turn");
                cp.makemove();
                if(TicTacToe.checkwin()){
                    TicTacToe.printboard();
                    System.out.println(cp.name +"has won ");
                    break;
                }else if (TicTacToe.isBoardFull()) {
                    TicTacToe.printboard();
                    System.out.println("It's a draw!");
                    break;
                }
                cp=(cp==p1) ? p2 :p1;
            }
    }
}

