import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class CoinCombinationI {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int n = fsr.nextInt();
        int x = fsr.nextInt();
        int[] dp = new int[x + 1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = fsr.nextInt();
        dp[0] = 1;
        long mod = 1000000007;

        for (int i = 1; i <= x; i++){
            for (int j = 0; j < n; j++) {
                if (coin[j] > i)
                    continue;
                dp[i] = dp[i] + dp[i - coin[j]];
                if (dp[i] > mod)
                    dp[i] -= mod;
            }
        }
        System.out.println(dp[x] % mod);
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
