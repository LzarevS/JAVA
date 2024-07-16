public class KeyboardType {
    private final String typeKeyboard;
    private final String backlightKeyboard;
    private final int weightKeyboard;

    public KeyboardType(String typeKeyboard, String backlightKeyboard, int weightKeyboard) {
        this.typeKeyboard = typeKeyboard;
        this.backlightKeyboard = backlightKeyboard;
        this.weightKeyboard = weightKeyboard;
    }

    public String getTypeKeyboard() {
        return typeKeyboard;
    }

    public String getBacklightKeyboard() {
        return backlightKeyboard;
    }

    public int getWeightKeyboard() {
        return weightKeyboard;
    }

    @Override
    public String toString() {
        return "Клавиатура: " + "\n" +
                getTypeKeyboard() + "\n" +
                backlightKeyboard + "\n" +
                getWeightKeyboard() + " грамм.";

    }
}
