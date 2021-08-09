import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RemovalGame {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int n = fsr.nextInt();
        int[] x = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            x[i] = fsr.nextInt();
            sum += x[i];
        }
        long[][] dp = new long[n][n];
        for (int l = n-1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (l == r) {
                    dp[l][r] = x[l];
                } else {
                    dp[l][r] = Math.max(x[l]-dp[l+1][r],
                            x[r]-dp[l][r-1]);
                }
            }
        }
        System.out.println((sum + dp[0][n - 1]) / 2);
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
