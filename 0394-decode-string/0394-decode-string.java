
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int repeatCount = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                while (repeatCount-- > 0) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
