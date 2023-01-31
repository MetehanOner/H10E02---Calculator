package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {
    private final List<String> history = new ArrayList<>();
    private static final Pattern INPUT_VALIDATION_PATTERN = Pattern.compile("^-?(0|[1-9]\\d*)[\\+x÷%-](0|[1-9]\\d*)$");

    public @NonNull String evaluate(@NonNull String input) {
         
        if (!Logic.INPUT_VALIDATION_PATTERN.matcher(input).matches()) {
            return "INVALID INPUT";
        }
        history.add("Input: " + input + System.lineSeparator());

        Pattern p0 = Pattern.compile("^-?(0|[1-9]\\d*)([\\+x÷%-])(0|[1-9]\\d*)$");

        Matcher m = p0.matcher(input);

        String fnum0 = m.group(1);
        String snum0 = m.group(3);

        long fnum = Long.parseLong(fnum0);
        long snum = Long.parseLong(snum0);

        long result = 0;

        try {
            result = switch (m.group(2)) {
                case "+" -> sum(fnum, snum);
                case "-" -> sub(fnum, snum);
                case "x" -> mul(fnum, snum);
                case "÷" -> div(fnum, snum);
                case "%" -> modulo(fnum, snum);
            };
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        String sResult = String.valueOf(result);

        // TODO Task 1.1 - 1.5: Implement input handling and output calculation.
        history.add("Result: " + sResult + System.lineSeparator());
        return sResult;
    }

    private @NonNull long sum(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber + secondNumber;
    }

    private @NonNull long sub(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber - secondNumber;
    }

    private @NonNull long mul(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber * secondNumber;
    }

    private @NonNull long div(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber / secondNumber;
    }

    private @NonNull long modulo(@NonNull long firstNumber, @NonNull long secondNumber) {
        return firstNumber % secondNumber;
    }

    public @NonNull List<String> getHistory() {
        return List.copyOf(history);
    }

}
