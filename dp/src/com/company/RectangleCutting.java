import java.io.*;
import java.util.StringTokenizer;

public class RectangleCutting {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int a = fsr.nextInt();
        int b = fsr.nextInt();
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i != j) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j]+dp[i-k][j]+1);
                    }
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[i][j-k]+1);
                    }
                }
            }

        }
        System.out.println(dp[a][b]);
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
