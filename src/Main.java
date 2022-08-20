import java.util.Arrays;
import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] products = {"Хлеб", "Молоко", "Яблоки"};
    int[] prices = {100, 200, 300};
    String[] priceThreeEqualsTwo = {"Молоко", "Яблоки"};

    //вывод всех товаров
    for (int i = 0; i < products.length; i++) {
      System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
    }


    int[] quantity = new int[3]; // массив для хранения количества уже выбранных товаров
    int totalPay = 0; // итоговая цена
    int discount = 0; // скидка на продукты по акции

    while (true) {
      System.out.println("Выберите товар и количество или введите `end`");
      String input = scanner.nextLine();
      if ("end".equals(input)) {
        break;
      }

      String[] parts = input.split(" ");
      int productNumber; //номер продукта
      int productCount; // количество продукта
      int total;
      int discountPrice = 0;


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
        if (productCount <= 0) {
          System.out.println("Количество продуктов не может быть нулем или отрицательным");
          continue;
        }
      } catch (NumberFormatException e) {
        System.out.println("Данные введены некорректно! Пример правильного ввода: 1 1, вы ввели: " + input);
        continue;
      }


      quantity[productNumber] = productCount + quantity[productNumber];

      // провереряем идет ли продукт по акции "3 по цене 2х"
      String checkingPromo = products[productNumber];
      if (Arrays.asList(priceThreeEqualsTwo).contains(checkingPromo)) {
        discountPrice = (productCount / 3) * prices[productNumber];
        productCount = productCount - (productCount / 3);
        total = productCount * prices[productNumber];

      } else {
        total = productCount * prices[productNumber];
      }

      discount += discountPrice;
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
    if (discount != 0) {
      System.out.println("Скидка на товар по акции: " + discount);
    }
    System.out.println("Итого к оплате: " + totalPay + " руб");
  }


}
