import java.io.*;
import java.util.StringTokenizer;

public class BookShop {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int n = fsr.nextInt();
        int x = fsr.nextInt();
        int[] price = new int[n + 1];
        int[] pages = new int[n + 1];
        for (int i = 1; i <= n; i++)
            price[i] = fsr.nextInt();
        for (int i = 1; i <= n; i++)
            pages[i] = fsr.nextInt();
        int[][] dp = new int[n + 1][x + 1];
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                if (price[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i]] + pages[i]);
            }
        }
        System.out.println(dp[n][x]);
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
