package main.leetcode;

public class GoalParserInterpretation {
    public static String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(", "").replaceAll("\\)", "");
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }
}
