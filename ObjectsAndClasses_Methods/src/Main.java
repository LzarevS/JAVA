public class Main {

    public static void main(String[] args) {
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 40, 1, 50);
        vasyaBasket.add("Хлеб", 30, 2, 0.5);
        vasyaBasket.print("Корзина Васи");
        System.out.println();

        Basket mashaBasket = new Basket();
        mashaBasket.add("Молоко", 40, 3, 50);
        mashaBasket.add("Хлеб", 80, 1, 3);
        mashaBasket.print("Корзина Маши");
        System.out.println();

        Basket katyaBasket = new Basket();
        katyaBasket.add("Cтул", 200, 4, 2);
        katyaBasket.add("Cтол", 500, 1, 10);
        katyaBasket.print("Корзина Кати");

        //  System.out.println(Basket.getTotalCost()); //Общая сумма стоймости  всех товаров в корзинах
        //  System.out.println(Basket.getTotalCountItems());//Сумма всех товаров в корзинах
        //  System.out.println(Basket.getOverageBasketPrice());// Средняя цена всех товаров
        // System.out.println(Basket.getOveragePrice());// Средняя цена одной корзины
    }
}