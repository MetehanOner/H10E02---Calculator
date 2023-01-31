package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

        Pattern pirasa = Pattern.compile("^-?(0|[1-9]\\d*)([\\+x÷%-])(0|[1-9]\\d*)$");

        Matcher m = INPUT_VALIDATION_PATTERN.matcher(input);
        m.matches();
        m.groupCount();

        String fnum_init = m.group(1);
        String snum_init = m.group(3);

        String controlString = m.group(2);

        long fn = Long.parseLong(fnum_init);
        long sn = Long.parseLong(snum_init);

        long result = fn;
        if (Objects.equals(controlString, "+")) {
            result = sum(fn, sn);
        } else if (Objects.equals(controlString, "-")) {
            result = sub(fn, sn);
        } else if (Objects.equals(controlString, "x")) {
            result = mul(fn, sn);
        } else if (Objects.equals(controlString, "÷")) {
            try {
                result = div(fn, sn);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } else if (Objects.equals(m.group(2), "%")) {
            try {
                result = modulo(fn, sn);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
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
