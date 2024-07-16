public class ProcessorType {
    private final int frequencyProcessor;
    private final int numberOfCoresProcessor;

    private final String manufacturerProcessor;
    private final int weightProcessor;


    public ProcessorType(int frequency,
                         int numberOfCoresProcessor,
                         String manufacturerProcessor,
                         int weightProcessor) {
        this.frequencyProcessor = frequency;
        this.numberOfCoresProcessor = numberOfCoresProcessor;
        this.manufacturerProcessor = manufacturerProcessor;
        this.weightProcessor = weightProcessor;
    }

    public int getFrequencyProcessor() {
        return frequencyProcessor;
    }

    public int getNumberOfCoresProcessor() {
        return numberOfCoresProcessor;
    }

    public String getManufacturerProcessor() {
        return manufacturerProcessor;
    }

    public int getWeightProcessor() {
        return weightProcessor;
    }

    @Override
    public String toString() {
        return "Процессор: " + "\n" +
                getFrequencyProcessor() + "\n" +
                getNumberOfCoresProcessor() + "\n" +
                getManufacturerProcessor() + "\n" +
                getWeightProcessor() + " грамм.";

    }
}
