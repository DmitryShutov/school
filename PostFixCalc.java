public class PostFixCalc {
    public Stack<Character> seq = new Stack<Character>();

    public Stack<Integer> resultStack = new Stack<Integer>();

    public int calc(String expr) {
        this.putToStack(expr);
        while (seq.peek() != '=') {
            char current = seq.pop();
            if (Character.isDigit(current)) {
                resultStack.push(Integer.parseInt(String.valueOf(current)));
            }
            if (current == '+') {
                int first = resultStack.pop();
                int second = resultStack.pop();
                resultStack.push(first + second);
            }
            if (current == '*') {
                int first = resultStack.pop();
                int second = resultStack.pop();
                resultStack.push(first * second);
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
