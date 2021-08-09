import java.io.*;
import java.util.StringTokenizer;

public class TwoSetsII {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int n = fsr.nextInt();
        int[] x = new int[n];
        int target = n*(n+1)/2;
        int mod = 1000000007;
        if (target % 2 == 1) {
            System.out.println(0);
            return;
        }
        target /= 2;
        long[][] dp = new long[n][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                int left = j-i;
                if (left >= 0)
                    dp[i][j] = (dp[i][j] + dp[i-1][left]) % mod;

            }
        }
        System.out.println(dp[n - 1][target]);
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
