package org.soulmate.interview;

public class P67 {

    public int strToInt(String str) {
        if (str == null)
            return 0;

        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        int len = chars.length;

        boolean isBlank = true, isBegin = false;
        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            if (isBlank) {
                if (!Character.isSpaceChar(ch) && !Character.isDigit(ch) && ch != '+' && ch != '-')
                    break;
                if (ch == '+' || ch == '-' || Character.isDigit(ch)) {
                    if (Character.isDigit(ch) && ch != '0') {
                        builder.append(ch);
                        isBegin = true;
                    } else {
                        builder.append(ch);
                    }
                    isBlank = false;
                }
                continue;
            } else if (Character.isDigit(ch)) {
                if (isBegin) {
                    builder.append(ch);
                } else if (ch != '0') {
                    builder.append(ch);
                    isBegin = true;
                }
                continue;
            }
            break;
        }

        len = builder.length();
        if (len > 0) {
            char zero = builder.charAt(0);
            if (Character.isDigit(zero) || (len > 1 && zero == '+')) {
                if (len > 13)
                    return Integer.MAX_VALUE;
                long l = Long.parseLong(builder.toString());
                return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;

            } else if (len > 1) {
                if (len > 13)
                    return Integer.MIN_VALUE;
                long l = Long.parseLong(builder.toString());
                return l < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) l;
            }
        }

        return 0;
    }
}
