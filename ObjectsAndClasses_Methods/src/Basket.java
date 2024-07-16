public class Basket {

    private static int count = 0;
    private static int basketCount = 0;
    private String items = "";
    private int totalPrice = 0;
    private double totalWeight = 0;
    private int limit;
    private static int totalCost = 0; //стоймость товаров во всех корзинах
    private static int totalCountItems = 0; //количество товаров во всех корзинах
    private static double overageBasketPrice = 0; // средняя цена товаров во всех корзинах
    private static double overagePrice = 0; // средняя стоймость корзины
    private static int finalBasketInformation;

    public Basket() {
        increaseCount(1);
        basketCount = basketCount + 1;
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int limit) {
        this();
        this.items = this.items + items;
        this.limit = limit;
        this.totalPrice = this.totalPrice + totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void increaseTotalCost(int price) {
        Basket.totalCost = Basket.totalCost + count + price;
    }

    public static void increaseTotalCountItems(int totalCountItems) {
        Basket.totalCountItems = totalCountItems + totalCountItems;
    }

    public void add(String name, int price) {
        add(name, price, 1, 0);
    }

    public void add(String name, int price, int count, double weight) {

        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " + count + " шт."
                + " Стоимость составляет " + price + " рублей; ";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        totalCost = totalCost + count * price;
        totalCountItems = totalCountItems + count;
    }


    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
        totalCost = 0;
        totalCountItems = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public static double getTotalCost(int totalCost) {
        return Basket.totalCost;
    }

    public static int getTotalCount() {
        return basketCount;
    }

    public static double getTotalCountItems(double totalCountItems) {
        return Basket.totalCountItems;
    }

    public static double getOverageBasketPrice() {
        overageBasketPrice = totalCost / totalCountItems;
        return overageBasketPrice;
    }

    public static double getOveragePrice() {
        overagePrice = totalCost / basketCount;
        return overagePrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общая стоимость товаров в корзине " + totalPrice + " рублей;");
            System.out.println("Общий вес товаров в корзине " + totalWeight + " кг;");
            System.out.println();
            System.out.println("Общая сумма стоймости  всех товаров в корзинах " + totalCost + " рублей;");
            System.out.println("Количество товаров во всех  корзинах " + totalCountItems + " шт.;");
            System.out.println("Средняя цена  всех товаров в корзинах " + getOverageBasketPrice() + " рублей.;");
            System.out.println("Средняя цена  всех товаров в одной корзинe " + getOveragePrice() + " рублей.;");
        }
    }
}
