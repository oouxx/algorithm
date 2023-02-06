package dp

/*
dp[i][j] = dp[i][j-1] + dp[i-1][j] 0 <= i < m, 0 <= j < n
dp[0][0] = 1
dp[0][0...j] = 1
dp[0..i][0] = 1
*/
func UniquePathsWithObstacles(obstacleGrid [][]int) int {
	m := len(obstacleGrid)
	n := len(obstacleGrid[0])
	f := make([]int, m+1)
	if obstacleGrid[0][0] == 0 {
		f[0] = 1
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				f[j] = 0
				continue
			}
			if j-1 >= 0 && obstacleGrid[i][j-1] == 0 {
				f[j] += f[j-1]
			}
		}
	}
	return f[len(f)-1]
}
