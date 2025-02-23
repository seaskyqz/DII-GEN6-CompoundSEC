import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class AccessControl {
    private Set<String> authorizedStudents;

    public AccessControl() {
        this.authorizedStudents = new HashSet<>(Arrays.asList("S001", "S002"));
    }

    public boolean validateAccess(String studentID) {
        return authorizedStudents.contains(studentID);
    }

    public void grantAccess(String studentID) {
        authorizedStudents.add(studentID);
    }

    public void revokeAccess(String studentID) {
        authorizedStudents.remove(studentID);
    }
}