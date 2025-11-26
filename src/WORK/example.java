package WORK;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
/**
 * 作者：张鹏烨
 * 2025/9/10
 **/

public class example extends JFrame {
    private static final int CELL_SIZE = 50; // 每个单元格的大小
    private static int[][] maze;
    private static int rows = 8;
    private static int cols = 7;
    private MazePanel mazePanel;

    // 单元格状态的颜色表示
    private static final Color PATH_COLOR = Color.WHITE;       // 0: 未探索路径
    private static final Color WALL_COLOR = Color.BLACK;       // 1: 墙壁
    private static final Color EXPLORED_COLOR = Color.GREEN;   // 2: 已探索的有效路径
    private static final Color DEAD_END_COLOR = Color.RED;     // 3: 死路
    private static final Color START_COLOR = Color.BLUE;       // 起点
    private static final Color END_COLOR = Color.ORANGE;       // 终点

    public example() {
        initializeMaze();

        // 设置窗口
        setTitle("迷宫寻路可视化");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 创建迷宫面板
        mazePanel = new MazePanel();
        mazePanel.setPreferredSize(new Dimension(cols * CELL_SIZE, rows * CELL_SIZE));
        add(mazePanel);

        pack();
        setLocationRelativeTo(null); // 窗口居中
        setVisible(true);

        // 启动寻路线程
        new Thread(() -> {
            try {
                Thread.sleep(1000); // 延迟1秒开始，让用户看清初始状态
                findPath(1, 1); // 从(1,1)开始寻路
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // 初始化迷宫
    private void initializeMaze() {
        maze = new int[rows][cols];

        // 初始化所有单元格为路径
        for (int i = 0; i < rows; i++) {
            Arrays.fill(maze[i], 0);
        }

        // 设置边界墙壁
        for (int i = 0; i < cols; i++) {
            maze[0][i] = 1;
            maze[rows-1][i] = 1;
        }
        for (int i = 0; i < rows; i++) {
            maze[i][0] = 1;
            maze[i][cols-1] = 1;
        }

        // 添加内部墙壁
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[5][3] = 1;
        maze[5][4] = 1;
        maze[5][5] = 1;
    }

    // 寻路算法：上->右->下->左
    private boolean findPath(int row, int col) throws InterruptedException {
        // 到达终点(rows-2, cols-2)
        if (row == rows - 2 && col == cols - 2) {
            maze[row][col] = 2;
            updateMaze();
            return true;
        }

        // 如果当前位置是可走的路径
        if (maze[row][col] == 0) {
            // 标记为已探索
            maze[row][col] = 2;
            updateMaze();

            // 向上探索
            if (findPath(row - 1, col)) {
                return true;
            }

            // 向右探索
            if (findPath(row, col + 1)) {
                return true;
            }

            // 向下探索
            if (findPath(row + 1, col)) {
                return true;
            }

            // 向左探索
            if (findPath(row, col - 1)) {
                return true;
            }

            // 如果四个方向都走不通，标记为死路
            maze[row][col] = 3;
            updateMaze();
            return false;
        }

        // 如果是墙壁、已探索或死路，返回false
        return false;
    }

    // 更新迷宫显示
    private void updateMaze() throws InterruptedException {
        SwingUtilities.invokeLater(() -> mazePanel.repaint());
        Thread.sleep(300); // 延迟300ms，让用户看清每一步
    }

    // 绘制迷宫的面板
    private class MazePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 根据单元格状态设置颜色
                    switch (maze[i][j]) {
                        case 0: g.setColor(PATH_COLOR); break;
                        case 1: g.setColor(WALL_COLOR); break;
                        case 2: g.setColor(EXPLORED_COLOR); break;
                        case 3: g.setColor(DEAD_END_COLOR); break;
                    }

                    // 绘制单元格
                    g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1);

                    // 标记起点和终点
                    if (i == 1 && j == 1) {
                        g.setColor(START_COLOR);
                        g.fillOval(j * CELL_SIZE + 10, i * CELL_SIZE + 10,
                                CELL_SIZE - 20, CELL_SIZE - 20);
                    }
                    if (i == rows - 2 && j == cols - 2) {
                        g.setColor(END_COLOR);
                        g.fillOval(j * CELL_SIZE + 10, i * CELL_SIZE + 10,
                                CELL_SIZE - 20, CELL_SIZE - 20);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 在事件调度线程中创建GUI
        SwingUtilities.invokeLater(example::new);
    }
}
