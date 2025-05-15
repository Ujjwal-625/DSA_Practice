import java.util.*;
import java.time.*;
import java.time.format.*;

public class LogFilter {

    static List<List<String>> filterLogs(String[][] logs) {
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String status = logs[i][2].toLowerCase();
            if (status.equals("error") || status.equals("critical")) {
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    temp.add(logs[i][j]);
                }
                ans.add(temp);
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        ans.sort((log1, log2) -> {
            LocalDateTime dt1 = LocalDateTime.parse(log1.get(0) + " " + log1.get(1), formatter);
            LocalDateTime dt2 = LocalDateTime.parse(log2.get(0) + " " + log2.get(1), formatter);
            return dt1.compareTo(dt2);
        });

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of logs : ");
        int n = sc.nextInt();
        String[][] logs = new String[n][4];

        System.out.println("Now enter the logs in format as below ");
        System.out.println("Date | Time | Status | Message");
        System.out.println("Example: 01-01-2023 14:00 ERROR failed");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if(j!=3)
                logs[i][j] = sc.next();
                else
                logs[i][j]=sc.nextLine();
            }
        }

        System.out.println("\nPrinting all logs:");
        for (int i = 0; i < n; i++) {
            System.out.println(String.join(" ", logs[i]));
        }

        System.out.println("\nPrinting Error and Critical logs (Sorted by Date & Time):");
        List<List<String>> filteredLogs = filterLogs(logs);
        for (List<String> log : filteredLogs) {
            System.out.println(String.join(" ", log));
        }

        sc.close();
    }
}
