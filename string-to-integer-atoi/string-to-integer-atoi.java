class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int idx = 0;
        
        while (idx < len && s.charAt(idx) == ' ') {
            idx++;
        }
        if (idx == len) {
            return 0;
        }

        
        int sign = 1;
        char c = s.charAt(idx);
        if (c == '-' || c == '+') {
            if (c == '-') {
                sign = -1;
            }
            idx++;
        }

        int result = 0;

        while (idx < len && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            idx++;
        }

        return sign * result;
    }
}