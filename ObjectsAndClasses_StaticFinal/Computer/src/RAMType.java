public class RAMType {
    private final String typeRAM;
    private final int volumeRAM;
    private final int weightRAM;

    public RAMType(String typeRAM, int volumeRAM, int weightRAM) {
        this.typeRAM = typeRAM;
        this.volumeRAM = volumeRAM;
        this.weightRAM = weightRAM;
    }

    public String getTypeRAM() {
        return typeRAM;
    }

    public int getVolumeRAM() {
        return volumeRAM;
    }

    public int getWeightRAM() {
        return weightRAM;
    }

    @Override
    public String toString() {
        return "Оперативная память: " + "\n" +
                getTypeRAM() + "\n" +
                getVolumeRAM() + "\n" +
                getWeightRAM() + " грамм.";
    }
}
