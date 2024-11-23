import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.YearMonth;
import java.lang.String;

public class Strings
{
     public static void main(String[] args)
     {
          Scanner scanner = new Scanner(System.in);

          //Ввод ФИО
          System.out.print("Введите фамилию по-русски: ");
          String lastName = scanner.nextLine();
          while (lastName == null)                            //проверка на ввод
          {
               System.out.print("Введите фамилию по-русски: ");
               lastName = scanner.nextLine();
          }
          System.out.print("Введите имя по-русски: ");
          String firstName = scanner.nextLine();
          while (firstName == null)
          {
               System.out.print("Введите имя по-русски: ");
               firstName = scanner.nextLine();
          }
          String patronymic = scanner.nextLine(); //у некоторых людей не бывает отчества

          // Ввод даты рождения
          int Date, Month, Year = 0, age = 0;
          try {
               System.out.print("Введите число рождения числом: ");
               Date = scanner.nextInt();
               while (Date == 0) //проверка на ввод
               {
                    System.out.print("Введите число рождения числом: ");
                    Date = scanner.nextInt();
               }
               System.out.print("Введите месяц рождения числом: ");
               Month = scanner.nextInt();
               while (Month == 0)
               {
                    System.out.print("Введите месяц рождения числом: ");
                    Month = scanner.nextInt();
               }
               System.out.print("Введите год рождения числом: ");
               Year = scanner.nextInt();
               while (Year == 0)
               {
                    System.out.print("Введите год рождения числом: ");
                    Year = scanner.nextInt();
               }
          }
          catch (InputMismatchException e) {System.out.println("Ошибка: " + e.getMessage());} //если пользователь введёт не число

          String gender = determineGender(patronymic); //вызов функции по определнию пола
          if (Year > 0)   //подсчёт возраста пользователя, только если ему удалось верно ввести дату и не выйти в exception
          {
               int Current_Year =  YearMonth.now().getYear(); //получаем из системы нынешний год
               age = Current_Year - Year;
          }
          String ageWithEnding = getAgeWithEnding(age); //вызов функции по определнию окончания слова "год"

          // Вывод результатов
          if (patronymic.isEmpty())
          {
               System.out.printf("Инициалы: %s %s.%n", lastName, firstName.charAt(0)); //если отчества нет
          }
          else {System.out.printf("Инициалы: %s %s.%s.%n", lastName, firstName.charAt(0), patronymic.charAt(0));}
          System.out.println("Пол: " + gender);
          System.out.println("Возраст: " + ageWithEnding);
     }

     private static String determineGender(String patronymic) {
          if (patronymic.endsWith("ов") || patronymic.endsWith("ич")) { //мужские отчества заканчиваются на эти буквы
               return "М";
          } else if (patronymic.endsWith("на")) {
               return "Ж"; //женские отчества заканчиваются на эти буквы
          } else {
               return "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ";
          }
     }

     private static String getAgeWithEnding(int age) {
          String ending; //записавается сюда окончание
          if (age % 10 == 1 && age % 100 != 11) {
               ending = "год";
          } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) { //вычисление окончания при разных случаях возраста
               ending = "года";
          } else {
               ending = "лет";
          }
          return age + " " + ending;
     }
}
