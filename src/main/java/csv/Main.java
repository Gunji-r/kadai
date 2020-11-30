package csv;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var users = new UserCsvReader().readUserCsv("users.csv");
        users.stream()
                .filter(i -> i.getCode().startsWith("m"))
                .map(u ->u.getName().toLowerCase())
                .sorted(Comparator.naturalOrder())
                .forEach(u ->System.out.println(u));

    }
}
