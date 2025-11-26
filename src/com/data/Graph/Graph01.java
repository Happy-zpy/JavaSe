package com.data.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * author zpy
 * 2025/10/30
 */
public class Graph01 {
    private int edgeCount;
    private final ArrayList<String> list;
    private final int[][] adjacencyMatrix;
    private final boolean[] visited;

    public Graph01(int n) {
        adjacencyMatrix = new int[n][n];
        visited = new boolean[n];
        list = new ArrayList<>();
    }

    public void insert(String s){
        list.add(s);
    }

    /**
     *
     * @param index
     * @return 若果存在就返回对应的下标,否则返回-1
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < list.size(); i++) {
            if(adjacencyMatrix[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1,int v2){
        for (int i = v2 + 1; i < list.size(); i++) {
            if(adjacencyMatrix[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    public void dfs(boolean[] visited, int i){
        System.out.println(list.get(i) + "->");
        visited[i] = true;
        int v = getFirstNeighbor(i);
        while (v != -1){
            if(!visited[v]){
                dfs(visited, v);
            }
            v = getNextNeighbor(i, v);
        }
    }

    public void dfs(){
        for (int i = 0; i < size(); i++) {
            dfs(visited, i);
        }
    }
    //广度优先
    private void bfs(boolean[] visited, int i){
        int u;//队列头节点对应的下标
        int w;//邻接节点
        //队列的访问顺序
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(list.get(i) + "->");
        visited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u = (Integer)queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if(!visited[w]){
                    System.out.println(list.get(w) + "->");
                    visited[w] = true;
                    queue.addLast(w);
                }
                //以u为前驱节点，找w下一个节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs(){
        for (int i = 0; i < list.size(); i++) {
            bfs(visited, i);
        }
    }

    public void addEdge(int v1,int v2,int weight) {
        if (adjacencyMatrix[v1][v2] == 0) {
            adjacencyMatrix[v1][v2] = weight;
            edgeCount++;
            return;
        }
        System.out.println(adjacencyMatrix[v1][v2] + "已经存在无需加入");
    }

    public int size(){
        return list.size();
    }

    public int getEdgeCount(){
        return edgeCount;
    }

}
