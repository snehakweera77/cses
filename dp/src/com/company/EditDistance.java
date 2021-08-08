import java.io.*;
import java.util.StringTokenizer;

public class EditDistance {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader fsr = new FastReader();
        String a = fsr.next();
        String b = fsr.next();
        int na = a.length();
        int nb = b.length();
        int[][] dp = new int[na + 1][nb + 1];
        for (int i = 0; i <= na; i++) {
            for (int j = 0; j <= nb; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        for (int i = 0; i <= na; i++) {
            for (int j = 0; j <= nb; j++){
                if (i > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                if (j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                if (i > 0 && j > 0) {
                    int temp = a.charAt(i - 1) != b.charAt(j - 1) ? 1 : 0;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + temp);
                }
            }
        }
        System.out.println(dp[na][nb]);
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
