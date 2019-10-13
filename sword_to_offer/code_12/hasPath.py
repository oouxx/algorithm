def has_path(matrix, rows, cols, string):
    if matrix is None or rows < 1 or cols < 1 or string is None:
        return
    visited = [False] * (rows * cols)
    path_length = 0
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if has_path_core(matrix, rows, cols, i, j, string, visited,
                             path_length):
                return True
    del visited
    return False


def has_path_core(matrix, rows, cols, row, col, string, visited, path_length):
    if path_length == len(string):
        return True
    has_a_path = False
    if 0 <= row < rows and 0 <= col < cols and not visited[
            row * cols + col] and matrix[row][col] == string[path_length]:
        path_length += 1
        visited[row * cols + col] = True
        has_a_path = has_path_core(
            matrix, rows, cols, row - 1, col,
            string, visited, path_length) or has_path_core(
                matrix, rows, cols, row + 1, col,
                string, visited, path_length) or has_path_core(
                    matrix, rows, cols, row, col - 1, string,
                    visited, path_length) or has_path_core(
                        matrix, rows, cols, row, col + 1, string, visited,
                        path_length)

        if not has_a_path:
            path_length -= 1
            visited[row * cols + col] = False

    return has_a_path


if __name__ == "__main__":
    matrix = [["1", "2", "3"], ["4", "5", "6"], ["7", "8", "9"]]
    result = has_path(matrix, 3, 3, "1256")
    print(result)
