import java.util.*;

class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        Stack<Character> stack = new Stack<Character>();

        while (sc.hasNext()) {
            String input = sc.next();
            char[] arr = input.toCharArray();
            System.out.println(isValidate(input, map, stack, arr));
            stack.clear();
        }

    }

    private static boolean isValidate(String input, HashMap<Character, Character> map, Stack<Character> stack, char[] arr) {
        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty() == false && stack.peek().equals(map.get(arr[i]))) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }
        return stack.empty();

    }
}


