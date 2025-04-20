class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            minHeap.add(new Cell(i, 0, heightMap[i][0]));
            minHeap.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            minHeap.add(new Cell(0, j, heightMap[0][j]));
            minHeap.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[] directions = {-1, 0, 1, 0, -1}; // Directions for up, left, down, right
        int trappedWater = 0;

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            
            // Check the four neighboring directions
            for (int i = 0; i < 4; i++) {
                int newRow = cell.x + directions[i];
                int newCol = cell.y + directions[i + 1];

                // Skip out-of-bounds or already visited cells
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }

                // Calculate trapped water if the neighboring cell is lower than the current cell
                if (heightMap[newRow][newCol] < cell.height) {
                    trappedWater += cell.height - heightMap[newRow][newCol];
                }

                // Add the neighbor cell to the heap with updated height (water level)
                visited[newRow][newCol] = true;
                minHeap.add(new Cell(newRow, newCol, Math.max(cell.height, heightMap[newRow][newCol])));
            }
        }

        return trappedWater;
    }

    // Helper class to store a cell's row, column, and height
    private static class Cell {
        int x, y, height;
        Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
