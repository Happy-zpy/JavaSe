package com.data.recursion.maze;
import javax.swing.*;
import java.awt.*;

/**
 * 作者：张鹏烨
 * 2025/9/10
 **/
public class maze02 extends JFrame {
    private static final int CELL_SIZE = 50; // 每个单元格的大小
    private static int[][] maze;
    private static int rows = 8;
    private static int cols = 7;
    private MazePanel mazePanel;

    public maze02() {
        setTitle("迷宫寻路可视化");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 创建迷宫面板
        mazePanel = new MazePanel(rows,cols);
        mazePanel.setPreferredSize(new Dimension(cols * CELL_SIZE, rows * CELL_SIZE));
        add(mazePanel);

        pack();
        setLocationRelativeTo(null); // 窗口居中
        setVisible(true);

        // 启动寻路线程
        new Thread(() -> {
            try {
                Thread.sleep(5000); // 延迟1秒开始，让用户看清初始状态
                mazePanel.sway(1, 1);
                // 从(1,1)开始寻路
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(maze02::new);
    }
    }

class MazePanel extends JPanel{
    private static final int CELL_SIZE = 50;
    private static final Color PATH_COLOR = Color.WHITE;       // 0: 未探索路径
    private static final Color WALL_COLOR = Color.BLACK;       // 1: 墙壁
    private static final Color EXPLORED_COLOR = Color.GREEN;   // 2: 已探索的有效路径
    private static final Color DEAD_END_COLOR = Color.RED;     // 3: 死路
    private static final Color START_COLOR = Color.BLUE;       // 起点
    private static final Color END_COLOR = Color.ORANGE;
    int[][]arr;
    int rows;
    int cols;
    public MazePanel(int rows,int cols) {
        this.rows = rows;
        this.cols = cols;
        arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < cols; i++) {
            arr[0][i] = 1;
            arr[7][i] = 1;
        }
        for (int i = 0; i < rows; i++) {
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
    }
    boolean sway(int i,int j){
        if(i == 6 && j == 5){
            arr[i][j] = 2;
            return true;
        }
        if(arr[i][j] == 0){
            arr[i][j] = 2;
            if(sway(i-1,j)){
                return true;
            }
            else if(sway(i,j + 1)){
                return true;
            }
            else if(sway(i + 1,j)){
                return true;
            } else if (sway(i,j - 1)) {
                return true;

            }
            else
            {
                arr[i][j] = 3;
                return false;
            }}
        repaint();
        return false;


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 根据单元格状态设置颜色
                switch (arr[i][j]) {
                    case 0:
                        g.setColor(PATH_COLOR);
                        break;
                    case 1:
                        g.setColor(WALL_COLOR);
                        break;
                    case 2:
                        g.setColor(EXPLORED_COLOR);
                        break;
                    case 3:
                        g.setColor(DEAD_END_COLOR);
                        break;}
                    g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1);
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
    private void updateMaze() throws InterruptedException {
        SwingUtilities.invokeLater(this::repaint);
        Thread.sleep(300); // 延迟300ms，让用户看清每一步
    }
}