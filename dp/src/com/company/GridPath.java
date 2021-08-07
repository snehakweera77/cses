import java.io.*;
import java.util.StringTokenizer;

public class GridPath {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int n = fsr.nextInt();
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            String s = fsr.nextLine();
            char[] cArr = s.toCharArray();
            int j = 0;
            for (char c : cArr) {
                if (c == '.') {
                    if (i > 0)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                    if (j > 0)
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
                }
                else
                    dp[i][j] = 0;
                j++;
            }
        }
        System.out.println(dp[n - 1][n - 1]);
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
