class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                
                boolean operatorFound = false;

                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }

                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop(); // remove the '('
               }
                if (!operatorFound) return true;

            } else {
               
                if (ch != ' ') st.push(ch);
            }
        }
        return false; 
        
    }
}

