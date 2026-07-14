class Solution:
    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a

    def subsequencePairCount(self, nums):
        MOD = 10**9 + 7
        MAX = 200

        dp = [[0] * (MAX + 1) for _ in range(MAX + 1)]
        dp[0][0] = 1

        for x in nums:
            ndp = [row[:] for row in dp]

            for g1 in range(MAX + 1):
                for g2 in range(MAX + 1):
                    if dp[g1][g2] == 0:
                        continue

                    ng1 = x if g1 == 0 else self.gcd(g1, x)
                    ng2 = x if g2 == 0 else self.gcd(g2, x)

                    ndp[ng1][g2] = (ndp[ng1][g2] + dp[g1][g2]) % MOD
                    ndp[g1][ng2] = (ndp[g1][ng2] + dp[g1][g2]) % MOD

            dp = ndp

        ans = 0
        for g in range(1, MAX + 1):
            ans = (ans + dp[g][g]) % MOD

        return ans
