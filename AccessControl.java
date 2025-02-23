import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class AccessControl {
    private static Set<String> authorizedStudents = new HashSet<>(Arrays.asList("S001", "S002"));
    public static boolean validateAccess(String studentID) {
        return authorizedStudents.contains(studentID);
    }
}