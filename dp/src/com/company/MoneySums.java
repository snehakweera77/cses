import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MoneySums {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        int n = fsr.nextInt();
        int[] x = new int[n];
        int maxSum = n * 1000;
        for (int i = 0; i < n; i++)
            x[i] = fsr.nextInt();
        boolean[][] dp = new boolean[n + 1][maxSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxSum; j++) {
                dp[i][j] = dp[i - 1][j];
                int left = j - x[i - 1];
                if (left >= 0 && dp[i - 1][left])
                    dp[i][j] = true;
            }
        }
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 1; i <= maxSum; i++) {
            if (dp[n][i])
                pos.add(i);
        }
        System.out.println(pos.size());
        for (int i : pos)
            System.out.print(i + " ");
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
