import java.io.*;
import java.util.StringTokenizer;

public class ArrayDescription {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int mod = 1000000007;
        int n = fsr.nextInt();
        int m = fsr.nextInt();
        int[][] dp = new int[n][m + 1];
        int x = fsr.nextInt();
        if (x == 0) {
            for (int i = 0; i <= m; i++)
                dp[0][i] = 1;
        }
        else
            dp[0][x] = 1;
        for (int i = 1; i < n; i++) {
            x = fsr.nextInt();
            if (x == 0) {
                for (int j = 1; j <= m; j++) {
                    int[] arr = {j-1,j,j+1};
                    for (int k : arr) {
                        if (k >= 1 && k <= m)
                            dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
                    }
                }
            } else {
                int[] arr = {x-1,x,x+1};
                for (int k : arr) {
                    if (k >= 1 && k <= m)
                        dp[i][x] = (dp[i][x] + dp[i-1][k]) % mod;
                }
            }
        }
        int ans = 0;
        for (int j = 1; j <= m; j++)
            ans = (ans + dp[n-1][j]) % mod;
        System.out.println(ans);
    }
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
