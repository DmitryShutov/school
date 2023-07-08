public class Brackets {
    public static boolean isBalanced(String seq) {
        if (seq.length() < 2) {
            return false;
        }
        if (isRight(seq.charAt(0)) || isLeft(seq.charAt(seq.length() - 1))) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < seq.length(); i++) {
            char s = seq.charAt(i);
            if (haveToPop(stack, s)) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        return stack.size() == 0;
    }

    public static boolean haveToPop(Stack<Character> stack, char s) {
        return isRight(s) && stack.size() > 0 && isLeft(stack.peek());
    }

    public static boolean isLeft(char s) {
        return s == '(';
    }

    public static boolean isRight(char s) {
        return s == ')';
    }
}
