package csd.starter;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);
        StringBuilder inputText = new StringBuilder();
        while (true) {
            String line = s.nextLine();
            inputText.append(line).append("to");
            if (line.equals("exit")) break;
        }
        String[] split = inputText.toString().split("to");
        boolean reserve = reserve(split[0], split[1]);
        PrintStream ps = new PrintStream(System.out);
        ps.print(reserve);
    }

    public static boolean reserve(String startTime, String endTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        if (startDate.after(endDate)) {
            return false;
        }
        return true;
    }
}
