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

        Pattern p0 = Pattern.compile("^-?(0|[1-9]\\d*)([\\+x÷%-])(0|[1-9]\\d*)$");

        try {
            Matcher m = p0.matcher(input);
        } catch (IllegalStateException e) {
            //you caught exception so what?
            String s1 = (e.getMessage());
            String s2 = String.valueOf((p0.matcher(input)));
            String s3 = ("yavaş feridun abi yine mi?");
            String Combined = s1 + s2 + s3;
            throw new IllegalStateException(Combined);
        }

        //Matcher m = p0.matcher(input);
        /*
        String fnum0 = m.group(1);
        String snum0 = m.group(3);

        long fnum = Long.parseLong(fnum0);
        long snum = Long.parseLong(snum0);

        long result = Long.parseLong(input);

        try {
            Objects.equals(m.group(2), "+");
        } catch (IllegalStateException e) {
            //you caught exception so what?
            String s1 = (e.getMessage());
            String s2 = (m.group(2));
            String s3 = ("yavaş feridun abi yine mi?");
            String Combined = s1 + s2 + s3;
            throw new IllegalStateException(Combined);
        }

        if (Objects.equals(m.group(2), "+")) {
            result = sum(fnum, snum);
        } else if (Objects.equals(m.group(2), "-")) {
            result = sub(fnum, snum);
        } else if (Objects.equals(m.group(2), "x")) {
            result = mul(fnum, snum);
        } else if (Objects.equals(m.group(2), "÷")) {
            try {
                result = div(fnum, snum);
            } catch (ArithmeticException e) {
                //you caught exception so what?
                System.out.println(e.getMessage());
            }
        } else if (Objects.equals(m.group(2), "%")) {
            try {
                result = modulo(fnum, snum);
            } catch (ArithmeticException e) {
                //you caught exception so what?
                System.out.println(e.getMessage());
            }
        }

        String sResult = String.valueOf(result);

        // TODO Task 1.1 - 1.5: Implement input handling and output calculation.
        history.add("Result: " + sResult + System.lineSeparator());
        return sResult;

         */
        String sResult = String.valueOf(input);

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
