class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}

//     s z h z i z v
// s   1 1 1 1 1 1 1
// y   1 1 1 1 1 1 1
// h   1 1 2 2 2 2 2
// y   1 1 2 2 2 2 2
// i   1 1 2 2 3 3 3
// y   1 1 2 2 3 3 3
// v   1 1 2 2 3 3 4

//     s a b c e f
// a   0 1 1 1 1 1
// e   0 1 1 1 2 2
// c   0 1 1 2 2 2
// f   0 1 1 2 2 3

//     a b c e e
// a   1 1 1 1 1
// e   1 1 1 2 2
// e   1 1 1 2 3
// c   1 1 2 2 3


