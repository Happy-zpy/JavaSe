package com.data.HuffmanTree.Haffuman;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 霍夫曼编码实现
 * 作者：张鹏烨
 * 2025/9/30
 **/
@SuppressWarnings({"all"})
public class HuffumanCode {

    public static void FileUnZip(String srcpath,String destpath){
        ObjectInputStream ois = null;
        FileOutputStream oos = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(srcpath));
            oos = (new FileOutputStream(destpath));
            byte[] b = (byte[]) ois.readObject();
            Map<Byte,String> map = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(map,b);
            oos.write(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                ois.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void Filezip(String srcpath,String destpath){
        FileInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
           ois  = new FileInputStream(srcpath);
           oos = new ObjectOutputStream(new FileOutputStream(destpath));
           byte[] b = ois.readAllBytes();
            Map<Byte, String> huffmanCodes = getHuffmanCodes(b);
           byte[] bytes = huffmanZip(b);
           oos.writeObject(bytes);
           oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                ois.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static byte[] huffmanZip(byte[] originalBytes) {
        Map<Byte, String> huffmanCodes = getHuffmanCodes(originalBytes);
        return zip(originalBytes, huffmanCodes);
    }

    public static Map<Byte, String> getHuffmanCodes(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            throw new IllegalArgumentException("输入字节数组不能为空");
        }
        Node root = buildHuffmanTree(bytes);
        return generateCodes(root);
    }

    public static Node buildHuffmanTree(byte[] bytes) {
        Map<Byte, Integer> freqMap = new HashMap<>();
        for (byte b : bytes) {
            freqMap.put(b, freqMap.getOrDefault(b, 0) + 1);
        }

        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : freqMap.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(nodes);
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        return pq.poll();
    }


    public static byte[] decode(Map<Byte, String> huffCode, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean isLastByte = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToString(huffmanBytes[i], !isLastByte));
        }

        Map<String, Byte> codeToByteMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCode.entrySet()) {
            codeToByteMap.put(entry.getValue(), entry.getKey());
        }

        List<Byte> byteList = new ArrayList<>();
        int i = 0;
        while (i < stringBuilder.length()) {
            int count = 1;
            boolean found = false;
            Byte b = null;

            while ( !found) {
                String code = stringBuilder.substring(i, i + count);
                b = codeToByteMap.get(code);
                if (b != null) {
                    found = true;
                } else {
                    count++;
                }
            }

            if (!found) {
                throw new RuntimeException("解码失败，找不到匹配的霍夫曼编码: " + stringBuilder.substring(i, Math.min(i + 10, stringBuilder.length())));
            }

            byteList.add(b);
            i += count;
        }

        // 转换为字节数组
        byte[] result = new byte[byteList.size()];
        for (int j = 0; j < result.length; j++) {
            result[j] = byteList.get(j);
        }
        return result;
    }

    public static Map<Byte, String> getHuffmanCodes(String str) {
        Node root = buildHuffmanTree(str);
        return generateCodes(root);
    }


    private static Map<Byte, String> generateCodes(Node root) {

        Map<Byte, String> huffmanCodes = new HashMap<>();
        StringBuilder codeBuilder = new StringBuilder();
        generateCode(root.left, "0", codeBuilder, huffmanCodes);
        generateCode(root.right, "1", codeBuilder, huffmanCodes);

        return huffmanCodes;
    }

    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        if (bytes == null || bytes.length == 0 || huffmanCodes == null || huffmanCodes.isEmpty()) {
            throw new IllegalArgumentException("压缩参数不能为空");
        }

        StringBuilder codeBuilder = new StringBuilder();
        for (byte b : bytes) {
            String code = huffmanCodes.get(b);
            if (code == null) {
                throw new IllegalArgumentException("字节 " + b + " 无对应霍夫曼编码");
            }
            codeBuilder.append(code);
        }

        int byteCount = (codeBuilder.length() + 7) / 8;
        byte[] result = new byte[byteCount];
        int index = 0;

        for (int i = 0; i < codeBuilder.length(); i += 8) {
            int endIndex = Math.min(i + 8, codeBuilder.length());
            String binaryStr = codeBuilder.substring(i, endIndex);
            result[index] = (byte) Integer.parseInt(binaryStr, 2);
            index++;
        }

        return result;
    }

    private static String byteToString(byte b, boolean isComplete) {
        int temp = b;
        if (isComplete) {
            temp |= 256;
        }
        String binaryStr = Integer.toBinaryString(temp);
        if (isComplete) {
            return binaryStr.substring(binaryStr.length() - 8);
        } else {
            return binaryStr;
        }
    }

    private static List<Node> createNodes(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : bytes) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }

        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    private static void generateCode(Node node, String code, StringBuilder codeBuilder, Map<Byte, String> huffmanCodes) {
        if (node == null) {
            return;
        }

        StringBuilder currentBuilder = new StringBuilder(codeBuilder);
        currentBuilder.append(code);
        if (node.data != null) {
            huffmanCodes.put(node.data, currentBuilder.toString());
        } else {
            generateCode(node.left, "0", currentBuilder, huffmanCodes);
            generateCode(node.right, "1", currentBuilder, huffmanCodes);
        }
    }

    public static Node buildHuffmanTree(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("输入字符串不能为空");
        }

        List<Node> nodes = createNodes(str);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nodes);
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            priorityQueue.add(parent);
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        String testStr = "this is a test of huffman coding";
        System.out.println("原始字符串: " + testStr);
        System.out.println("原始字节长度: " + testStr.getBytes(StandardCharsets.UTF_8).length);

        try {
            // 构建霍夫曼树
            Node root = buildHuffmanTree(testStr);
            System.out.println("\n霍夫曼树前序遍历:");
            root.preorder();

            // 生成霍夫曼编码
            Map<Byte, String> huffmanCodes = getHuffmanCodes(testStr);
            System.out.println("\n霍夫曼编码表: " + huffmanCodes);

            // 压缩
            byte[] originalBytes = testStr.getBytes(StandardCharsets.UTF_8);
            byte[] compressedBytes = zip(originalBytes, huffmanCodes);
            System.out.println("\n压缩后的字节数组: " + Arrays.toString(compressedBytes));
            System.out.println("压缩后字节长度: " + compressedBytes.length);

            // 解压缩
            byte[] decodedBytes = decode(huffmanCodes, compressedBytes);
            String decodedStr = new String(decodedBytes, StandardCharsets.UTF_8);
            System.out.println("\n解压缩后的字符串: " + decodedStr);
            String s = "D:\\kk.jpg";
            String destpath = "D:\\jj.zip";
            Filezip(s,destpath);
            String s1 = "D:\\i.jpg";
            FileUnZip(destpath,s1);

        } catch (Exception e) {
            System.err.println("处理过程中发生错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{data=" + (data == null ? "null" : (char) (byte) data) + ", weight=" + weight + "}";
    }

    /**
     * 前序遍历
     */
    public void preorder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }

    @Override
    public int compareTo(Node other) {
        return this.weight - other.weight; // 按权重升序排列
    }
}
