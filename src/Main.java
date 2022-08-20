import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Хлеб", "Молоко", "Яблоки"};
        int[] prices = {100, 200, 300};

        //вывод всех товаров
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        // массив для хранения количества уже выбранных товаров
        int[] quantity = new int[3];
        int totalPay = 0;

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber;
            int productCount;


            try {

                if (parts.length != 2) {
                    System.out.println("Указано неверное значение! Пример ввода: 1 1");
                    continue;
                }

                productNumber = Integer.parseInt(parts[0]) - 1;
                productCount = Integer.parseInt(parts[1]);


                if ((productNumber + 1) > products.length || (productNumber + 1) <= 0) {
                    System.out.println("Номер продукта указан неверно, допустимо значение от 1 до " + products.length);
                    continue;
                }
                //if (productCount <= 0) {
                //System.out.println("Количество продуктов не может быть нулем или отрицательным");
                //continue;
                //}
            } catch (NumberFormatException e) {
                System.out.println("Данные введены некорректно! Пример правильного ввода: 1 1, вы ввели: " + input);
                continue;
            }

            if (productCount == 0) {
                quantity[productNumber] = 0;
            }
            quantity[productNumber] = productCount + quantity[productNumber];

            int total = productCount * prices[productNumber];
            totalPay = totalPay + total;

        }
        System.out.println("Ваша корзина: ");

        for (
                int i = 0;
                i < quantity.length; i++) {
            if (quantity[i] != 0) {
                System.out.println(products[i] + " " + quantity[i] + " шт " + prices[i] + " руб/шт " + (quantity[i] * prices[i]) + " руб в сумме");
            }
        }
        System.out.println("Итого: " + totalPay + " руб");
    }


}
