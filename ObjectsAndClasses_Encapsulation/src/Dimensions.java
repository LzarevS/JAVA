public  class Dimensions {
    private final double length;
    private final double width;
    private final double height;
    private double volume = 0 ;
    public Dimensions(double length, double width, double height, double volume) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
    }
    public double getVolume() {
        double volume = length * width * height;
        return volume;
    }

    public Dimensions setLength(double length) {
        return new Dimensions(length, width, height,volume);
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(length, width, height,volume);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(length, width, height,volume);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double volume() {
        return (length * width * height);
    }


    public String toString(){return "Длина " + length + "см.;" + "\n" + "Ширина " + width + "см.;"
            + "\n" + "Высота " + height + "см.;" + "\n" + "Объём " + volume() + "сm3.;";}
}
