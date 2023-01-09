package org.soulmate.offer;

public class I_20 {
    public boolean isNumber(String s) {

        return s.matches("^( )*(\\+|-)?(([0-9]+\\.)|([0-9]+\\.[0-9]+)|(\\.[0-9]+)|([0-9])+)((e|E)(\\+|-)?[0-9]+)?( )*$");
    }

}
