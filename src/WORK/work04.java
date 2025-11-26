package WORK;
/**
 * 作者：张鹏烨
 * 2025/9/8
 **/
public class work04 {
    public static void main(String[] args) {
        int index = 0;
        int res[];
        int num1;
        int num2;
        int num3 = 0;
        char c;
        stack stack = new stack(10); // 数字栈
        stack stack1 = new stack(10); // 运算符栈
        String str = "3+4*13-2";

        while (index < str.length()) {
            char op = str.charAt(index);

            if (!isop(op)) { // 是数字（修正逻辑：isop为true表示非数字）
                // 从当前index开始提取数字
                res = find(str.substring(index));
                stack.add(res[0]); // 数字入栈
                index += res[1]; // 移动到数字后的位置
            } else { // 是运算符
                // 处理运算符栈：优先级高的先计算
                while (!stack1.isempty() && priority((char) stack1.peek()) >= priority(op)) {
                    num1 = stack.pop(); // 弹出栈顶数字（后入的）
                    num2 = stack.pop(); // 弹出下一个数字（先入的）
                    char operation = (char) stack1.pop(); // 弹出运算符
                    stack.add(operate(num2, num1, operation)); // 结果入栈
                }
                stack1.add(op); // 当前运算符入栈
                index++; // 移动到下一个字符
            }
        }

        // 处理剩余的运算符
        while (!stack1.isempty()) {
            num1 = stack.pop();
            num2 = stack.pop();
            char operation = (char) stack1.pop();
            stack.add(operate(num2, num1, operation));
        }

        System.out.println("计算结果: " + stack.pop()); // 最终结果
    }

    // 判断是否为运算符（+、-、*、/）
    public static boolean isop(char s) {
        return s == '+' || s == '-' || s == '*' || s == '/';
    }

    // 从子字符串中提取连续数字（返回数字值和长度）
    public static int[] find(String str) {
        int index = 0;
        String num = "";
        char c;

        while (index < str.length()) { // 增加边界判断，避免越界
            c = str.charAt(index);
            if (Character.isDigit(c)) {
                num += c;
                index++;
            } else {
                break;
            }
        }

        return new int[]{Integer.parseInt(num), index};
    }

    // 运算逻辑
    public static int operate(int num1, int num2, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("除数不能为0");
                }
                res = num1 / num2;
                break;
        }
        return res;
    }

    // 运算符优先级（*、/ 高于 +、-）
    public static int priority(char op) {
        if (op == '*' || op == '/') {
            return 1;
        } else {
            return 0;
        }
    }
}

class stack {
    int top = -1;
    int down = -1;
    int max;
    int[] arr;

    public stack(int max) {
        this.arr = new int[max];
        this.max = max;
    }

    // 入栈
    public void add(int i) {
        if (isfull()) {
            System.out.println("栈已经满了，无法继续添加");
            return;
        }
        top++;
        arr[top] = i;
    }

    // 出栈（返回栈顶元素并移除）
    public int pop() {
        if (isempty()) {
            throw new RuntimeException("栈为空，无法弹出元素");
        }
        int value = arr[top];
        top--;
        return value;
    }

    // 查看栈顶元素（不移除）
    public int peek() {
        if (isempty()) {
            throw new RuntimeException("栈为空，无法查看元素");
        }
        return arr[top];
    }

    public void show() {
        if (isempty()) {
            System.out.println("此栈为空栈");
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public boolean isempty() {
        return top == down;
    }

    public boolean isfull() {
        return top == max - 1;
    }
}

