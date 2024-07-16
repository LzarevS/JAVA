
public class StorageCargoInformation {
    private final double weight;
    private final Dimensions dimensions;
    private final String address;
    private final boolean turnOver;
    private final String registrationNumber;
    private final boolean fragile;
    private final double length;
    private final double width;
    private final double height;

    public StorageCargoInformation(double weight, String address,
                                   Dimensions dimensions, String registrationNumber,
                                   boolean turnOver, boolean fragile, double length,
                                   double width, double height) {
        this.weight = weight;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.length = length;
        this.width = width;
        this.height = height;
        this.dimensions = dimensions;
        this.turnOver = turnOver;
        this.fragile = fragile;
    }

    public StorageCargoInformation setWeight(double weight) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public double getWeight() {
        return weight;
    }


    public StorageCargoInformation setAddress(String address) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public String getAddress() {
        return address;
    }

    public StorageCargoInformation setDimensions(Dimensions dimensions) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public StorageCargoInformation setRegistrationNumber(String registrationNumber) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public StorageCargoInformation setTurnOver(boolean turnOver) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public boolean canTurnOver() {
        return turnOver;
    }

    public StorageCargoInformation setFragile(boolean fragile) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public boolean isFragile() {
        return fragile;
    }

    public StorageCargoInformation setLength(double length) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public StorageCargoInformation setWidth(double width) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }

    public StorageCargoInformation setHeight(double height) {
        return new StorageCargoInformation(weight, address, dimensions,
                registrationNumber, turnOver, fragile, length, width, height);
    }


    public String toString() {
        return "Копия" + "\n" + "вес " + weight + " кг." + "\n" + "адрес " + address + "\n" + dimensions +
                "\n" + "регистрационный номер " + registrationNumber;
    }
}