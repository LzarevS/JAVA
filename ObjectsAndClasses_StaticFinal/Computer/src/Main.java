
public class Main {
    public static void main(String[] args) {
        Computer computer;
        computer = new Computer(
                "Apple",
                "MacBook Pro 13",
                new ProcessorType(
                        3,
                        16,
                        "Apple Silicon",
                        200),
                new RAMType(
                        "DDR4",
                        8,
                        100),
                new DriveType(
                        "SSD",
                        2048,
                        150),
                new ScreenType(
                        13, //можно сделать переменую double
                        "IPS",
                        300),
                new KeyboardType(
                        "ISO",
                        "Backlight",
                        250));

        computer.setProcessorType(new ProcessorType(
                5,
                20,
                "Dell",
                300)); //Сеттер на изминение информации

        Computer computer1;
        computer1 = new Computer(
                "HP",
                "ProBook",
                new ProcessorType(
                        4,
                        16,
                        "HP",
                        125),
                new RAMType(
                        "DDR3",
                        6,
                        50),
                new DriveType(
                        "SSD",
                        512,
                        150),
                new ScreenType(
                        15,
                        "HP3",
                        320),
                new KeyboardType(
                        "HP",
                        "no backlight",
                        125)

        );

        System.out.println(computer);
        System.out.println(computer1);
    }


}

