package main.leetcode;

public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int leftIdx = 0, rightIdx = 0;

        while(leftIdx < name.length() && rightIdx < typed.length()) {

            if(name.charAt(leftIdx) == typed.charAt(rightIdx)) {
                leftIdx++;
                rightIdx++;
            } else if(leftIdx >0 && name.charAt(leftIdx - 1) == typed.charAt(rightIdx)){
                rightIdx++;
            } else {
                return false;
            }
        }
        // check
        if(rightIdx < typed.length()) {
            for(int i = rightIdx; i < typed.length(); i++) {
                if(name.charAt(leftIdx -1) != typed.charAt(i)) {
                    return false;
                }
            }
        }

        return leftIdx == name.length();
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        boolean ans = longPressedName.isLongPressedName("alex", "aaleex");
        System.out.println(ans);

        ans = longPressedName.isLongPressedName("saeed", "ssaaedd");
        System.out.println(ans);

        ans = longPressedName.isLongPressedName("leelee", "lleeelee");
        System.out.println(ans);

        ans = longPressedName.isLongPressedName("laiden", "laiden");
        System.out.println(ans);

        ans = longPressedName.isLongPressedName("vtkgn", "vttkgnn");
        System.out.println(ans);

        ans = longPressedName.isLongPressedName("alex", "aaleexa");
        System.out.println(ans);

        ans = longPressedName.isLongPressedName("a", "b");
        System.out.println(ans);
    }
}