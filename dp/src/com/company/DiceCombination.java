
import java.util.Arrays;
import java.util.Scanner;

public class DiceCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        long mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j > i)
                    continue;
                dp[i] = ((dp[i] + dp[i - j]) % mod) % mod;
            }
        }
        System.out.println(dp[n] % mod);
    }
}
