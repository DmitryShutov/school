public class PostFixCalc {
    public Stack<Character> seq = new Stack<Character>();

    public Stack<Integer> resultStack = new Stack<Integer>();

    public int calc(String expr) {
        this.putToStack(expr);
        while (seq.peek() != '=') {
            char current = seq.pop();
            if (Character.isDigit(current)) {
                resultStack.push(Integer.parseInt(String.valueOf(current)));
                continue;
            }
            int first = resultStack.pop();
            int second = resultStack.pop();
            switch (current) {
                case '+':
                    resultStack.push(first + second);
                    continue;
                case '*':
                    resultStack.push(first * second);
                    continue;
                case '/':
                    resultStack.push(second / first);
                    continue;
                case '-':
                    resultStack.push(second - first);
            }
        }
        return resultStack.peek();
    }

    public void putToStack(String expr) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c != ' ') {
                seq.push(c);
            }
        }
    }
}
