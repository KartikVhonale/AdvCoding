

public class Grid2 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {5, 6, 7}, {4,7,5}};
        printmat(grid);
        tabulation(grid);
    }
    public static void tabulation(int[][] grid){
        int n=grid.length,m=grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
       
        for(int j= m-1; j>=0 ; j--){
            for(int i= n-1; i>=0; i--){
                if(j==m-1) {
                    dp[i][j]=grid[i][j];
                }
                else if(i==n-1){
                    dp[i][j]=Math.max( dp[i][j+1], dp[i-1][j+1] )+grid[i][j];
                }
                else if(i==0){
                    dp[i][j]=Math.max( dp[i][j+1], dp[i+1][j+1] )+grid[i][j];
                }
                else{
                    dp[i][j]=Math.max( dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]) )+grid[i][j];
                }
            }
        }
        int maxi=Integer.MIN_VALUE;
        printmat(dp);
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,dp[i][0]);
        }
        System.out.println(maxi);
    }
    public static void printmat(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("___________________");
    }
}