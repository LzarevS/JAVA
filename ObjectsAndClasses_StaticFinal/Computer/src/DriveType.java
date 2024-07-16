public class DriveType {
    private final String typeDrive;
    private final int memoryDrive;
    private final int weightDrive;

    public DriveType(String typeDrive, int memoryDrive, int weightDrive) {
        this.typeDrive = typeDrive;
        this.memoryDrive = memoryDrive;
        this.weightDrive = weightDrive;
    }

    public String getTypeDrive() {
        return typeDrive;
    }

    public int getMemoryDrive() {
        return memoryDrive;
    }

    public int getWeightDrive() {
        return weightDrive;
    }

    @Override
    public String toString() {
        return "Накопитель информации: " + "\n" +
                getTypeDrive() + "\n" +
                getMemoryDrive() + "\n" +
                getWeightDrive() + " грамм.";
    }
}
