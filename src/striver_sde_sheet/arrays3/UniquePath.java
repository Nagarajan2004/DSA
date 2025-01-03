package striver_sde_sheet.arrays3;

public class UniquePath {

    private int dpApproach(int n, int m){
        int[][] dp = new int[n][m];

        //row
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        //col
        for(int i = 0; i < m; i++){
            dp[0][i] = 1;
        }

        for(int r = 1; r < n; r++){
            for(int c = 1; c < m; c++){
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }

        return dp[n-1][m-1];
    }

    private int combination(int n, int m){
        int path = 1;
        int r = n + m - 2; // 8
        int c = n - 1; // 2
        for(int i = 1; i <= c; i++){
            path = path * (r - c + i) / i;
        }
        return path;
    }

    public static void main(String[] args) {
        int n = 10, m = 10;

        UniquePath uniquePath = new UniquePath();

//        int paths = uniquePath.dpApproach(n, m);

        int paths = uniquePath.combination(n, m);

        System.out.println("paths = " + paths);
    }
}
