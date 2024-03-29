package bagproblem

/*
01背包问题

dp[i][j]表示将前i件物品装进限重为j的背包可以获得的最大价值, 0<=i<=N, 0<=j<=W]

那么我们可以将dp[0][0...W]初始化为0，表示将前0个物品（即没有物品）装入书包的最大价值为0。那么当 i > 0 时dp[i][j]有两种情况：

不装入第i件物品，即dp[i−1][j]；
装入第i件物品（前提是能装下），即dp[i−1][j−w[i]] + v[i]。

dp[i][j] = max(dp[i−1][j], dp[i−1][j−w[i]]+v[i]) // j >= w[i]

由上述状态转移方程可知，dp[i][j]的值只与dp[i-1][0,...,j-1]有关，所以我们可以采用动态规划常用的方法（滚动数组）对空间进行优化（即去掉dp的第一维）。需要注意的是，为了防止上一层循环的dp[0,...,j-1]被覆盖，循环的时候 j 只能逆向枚举（空间优化前没有这个限制）
*/

/*
完全背包问题
与01背包问题不同的是，每种物品可以装无限多次

dp[i][j] = max(dp[i-1][j], dp[i][j-w[i]] + v[i]) // j >= w[i]
和01背包问题类似，也可进行空间优化，优化后不同点在于这里的 j 只能正向枚举而01背包只能逆向枚举，因为这里的max第二项是dp[i]而01背包是dp[i-1]，即这里就是需要覆盖而01背包需要避免覆盖
*/
