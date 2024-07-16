public class ScreenType {
    private final int diagonalScreen;
    private final String typeScreen;
    private final int weightScreen;

    public ScreenType(int diagonalScreen, String typeScreen, int weightScreen) {
        this.diagonalScreen = diagonalScreen;
        this.typeScreen = typeScreen;
        this.weightScreen = weightScreen;
    }

    public int getDiagonalScreen() {
        return diagonalScreen;
    }

    public String getTypeScreen() {
        return typeScreen;
    }

    public int getWeightScreen() {
        return weightScreen;
    }

    @Override
    public String toString() {
        return "Экран: " + "\n" +
                getDiagonalScreen() + "\n" +
                getTypeScreen() + "\n" +
                getWeightScreen() + " грамм.";
    }
}
