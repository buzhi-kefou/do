package org.soulmate.offer;

public class I_5 {

    public String replaceSpace(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(charArray.length);
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }
}
