import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RemovingDigit {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        CoinCombinationII.FastReader fsr = new CoinCombinationII.FastReader();
        int n = fsr.nextInt();
        int x = fsr.nextInt();
        int[] dp = new int[x + 1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = fsr.nextInt();
        dp[0] = 1;
        int mod = 1000000007;
        Arrays.sort(coin);
        for (int c : coin){
            for (int i = 0; i <= x - c; ++i)
                dp[i + c] = (dp[i + c] + dp[i]) % mod;
        }


        /*for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= x; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
                if (dp[j] > mod)
                    dp[j] -= mod;
            }
        }*/
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
