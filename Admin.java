class Admin {
    private AccessControl accessControl;

    public Admin(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public void grantAccess(String studentID) {
        accessControl.grantAccess(studentID);
        System.out.println("Access granted to " + studentID);
    }

    public void revokeAccess(String studentID) {
        accessControl.revokeAccess(studentID);
        System.out.println("Access revoked from " + studentID);
    }
}