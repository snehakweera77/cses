import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimizingCoins {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int n = fsr.nextInt();
        int x = fsr.nextInt();
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = fsr.nextInt();
        dp[0] = 0;
        int temp = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (coin[j] <= i) {
                    temp = dp[i - coin[j]];
                    if ((temp + 1) < dp[i] && temp != Integer.MAX_VALUE )
                        dp[i] = temp + 1;
                }
            }
        }
        if (dp[x] >= Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(dp[x]);
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
