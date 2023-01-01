package org.soulmate.offer;

public class I_58_I {

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        int left = -1, right = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isWhitespace(s.charAt(i))) {
                if (right != -1) {
                    if (left != -1)
                        stringBuilder.append(' ');
                    stringBuilder.append(s, i + 1, right);

                    left = i;
                    right = -1;
                }
            } else if (right == -1) {
                right = i + 1;
            }
        }

        if (right != -1) {
            if (left != -1)
                stringBuilder.append(' ');
            stringBuilder.append(s, 0, right);
        }

        return stringBuilder.toString();
    }
}
