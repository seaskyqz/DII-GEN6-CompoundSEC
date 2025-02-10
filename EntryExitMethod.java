interface EntryExitMethod {
    void authenticateEntryExit();
}

class RFID implements EntryExitMethod {
    @Override
    public void authenticateEntryExit() {
        System.out.println("Student uses RFID card to enter/exit.");
    }
}

class QRCode implements EntryExitMethod {
    @Override
    public void authenticateEntryExit() {
        System.out.println("Student uses QR code to enter/exit.");
    }
}

class MobileApp implements EntryExitMethod {
    @Override
    public void authenticateEntryExit() {
        System.out.println("Student uses Mobile App to enter/exit.");
    }
}

abstract class SchoolEntryExit {
    protected EntryExitMethod entryExitMethod;

    public SchoolEntryExit(EntryExitMethod entryExitMethod) {
        this.entryExitMethod = entryExitMethod;
    }

    abstract void performEntryExit();
}

class StudentEntryExit extends SchoolEntryExit {
    public StudentEntryExit(EntryExitMethod entryExitMethod) {
        super(entryExitMethod);
    }

    @Override
    void performEntryExit() {
        System.out.print("Student: ");
        entryExitMethod.authenticateEntryExit();
    }
}