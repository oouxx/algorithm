class Solution(object):
    def movingCount(self, threshold, rows, cols):
        if rows <= 0 or cols <= 0 or threshold < 0:
            return 0
        # 构建布尔矩阵防止重复
        visited_matrix = [False] * (rows * cols)
        print(self.movingCountCore(visited_matrix, rows, cols, 0, 0, threshold))
        del visited_matrix

    def movingCountCore(self, visited_matrix, rows, cols, row, col, threshold):
        count = 0
        if self.check(visited_matrix, rows, cols, row, col, threshold):
            visited_matrix[row * cols + col] = True

            count = 1 + self.movingCountCore(visited_matrix, rows, cols, row - 1, col, threshold) + \
                    self.movingCountCore(visited_matrix, rows, cols, row, col - 1, threshold) + \
                    self.movingCountCore(visited_matrix, rows, cols, row + 1, col, threshold) + \
                    self.movingCountCore(visited_matrix, rows, cols, row, col + 1, threshold)

        return count

    def check(self, visited_matrix, rows, cols, row, col, threshold):
        if 0 <= row < rows and 0 <= col < cols and self.get_digit_sum(row) + self.get_digit_sum(
                col) <= threshold and not \
                visited_matrix[row * cols + col]:
            return True
        return False

    def get_digit_sum(self, number):
        sum = 0
        while number > 0:
            sum += number % 10
            number = number // 10
        return sum


s = Solution()
s.movingCount(5, 10, 10)
