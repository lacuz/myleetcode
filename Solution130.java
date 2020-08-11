import java.util.Arrays;

// 130. 被围绕的区域
// 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

// 示例:

// X X X X
// X O O X
// X X O X
// X O X X
// 运行你的函数后，矩阵变为：

// X X X X
// X X X X
// X X X X
// X O X X

// import java.util.*;

class Solution130{

        public static void main(String[] args){
            System.out.println("start");
            Solution130 s = new Solution130();
            char[][] data = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','X','X'},{'X','O','X','X'}};
            for(int i=0;i<data.length;i++){
                System.out.println(Arrays.toString(data[i]));
            }
            System.out.println();
            s.solve(data);
            for(int i=0;i<data.length;i++){
                System.out.println(Arrays.toString(data[i]));
            }
            
        }

        public void solve(char[][] board) {
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    //处于边界处于边界不处理
                    if(i==0 || i==board.length-1 || j==0 || j==board[i].length-1 || board[i][j] =='X' ){
                        continue;
                    }

                    int[][] flag = new int[board.length][board[0].length];
                    if(dfs(board, i, j,flag)){
                        board[i][j]='X';
                    }

                }
            }
        }

        //递归判断上下左右是否为X
        public boolean dfs(char[][] board,int i,int j,int[][] flag){
            if(flag[i][j]==1) return true;
            if(i==0 || i==board.length-1 || j==0 || j==board[i].length-1){
                return board[i][j]=='X';
            }else if(board[i][j]=='X'){
                return true;
            }
            flag[i][j] = 1;
           return dfs(board,i,j-1,flag) && dfs(board,i-1,j,flag) && dfs(board,i+1,j,flag) && dfs(board,i,j+1,flag);
             
        }
    }