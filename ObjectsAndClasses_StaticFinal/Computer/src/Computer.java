public class Computer {
   public final String vendor;
   public final String name;
    public  ProcessorType processor;
    public RAMType ram;
    public DriveType drive;
    public ScreenType screen;
    public KeyboardType keyboard;

    public int weight;



    public Computer ( String vendor,
                    String name,
                    ProcessorType processor,
                    RAMType ram, DriveType drive,
                    ScreenType screen,
                    KeyboardType keyboard ) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.drive = drive;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public ProcessorType getProcessorType() {
        return processor;
    }

    public void setProcessorType(ProcessorType processorType) {
        this.processor = processorType;
    }

    public RAMType getRamType() {
        return ram;
    }

    public void setRamType(RAMType ramType) {
        this.ram = ramType;
    }

    public DriveType getDriveType() {
        return drive;
    }

    public void setDriveType(DriveType driveType) {
        this.drive = driveType;
    }

    public ScreenType getScreenType() {
        return screen;
    }

    public void setScreenType(ScreenType screenType) {
        this.screen = screenType;
    }

    public KeyboardType getKeyboardType() {
        return keyboard;
    }

    public void setKeyboardType(KeyboardType keyboardType) {
        this.keyboard = keyboardType;
    }

    public int totalWeight (){
        weight = processor.getWeightProcessor() + ram.getWeightRAM() +
             drive.getWeightDrive() + screen.getWeightScreen() + keyboard.getWeightKeyboard();
        return weight;
    }




    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {

        return "Производитель: " + getVendor() + "\n" +
                "Название: " + getName() + "\n" +
                "Комплектующие: " + "\n" +
                 processor + "\n" +
                 ram + "\n" +
                 drive + "\n" +
                 screen + "\n" +
                 keyboard + "\n" +
                "Вес всего: " + totalWeight() + "\n";




    }


}
