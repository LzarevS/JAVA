public class Main {
    public static void main(String[] args) {

//             Elevator elevator = new Elevator(-3, 26);
//            while (true) {
//                System.out.print("Введите номер этажа: ");
//              int floor = new Scanner(System.in).nextInt();
//               elevator.move(floor);
//           }
        Dimensions dimensions = new Dimensions(1, 2, 3, 0);
        dimensions = dimensions.setLength(20.5);
        dimensions = dimensions.setWidth(10.6);
        dimensions = dimensions.setHeight(11.3);
        StorageCargoInformation cargoInformation = new StorageCargoInformation(500,
                "Улица", dimensions, "2A", true, true,
                100, 200, 300);

        cargoInformation = cargoInformation.setWeight(100);
        cargoInformation = cargoInformation.setAddress("Проспект");
        cargoInformation = cargoInformation.setRegistrationNumber("105");
        System.out.println(cargoInformation);

    }
}
