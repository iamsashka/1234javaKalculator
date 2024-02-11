import java.util.Scanner; // Импорт класса Scanner для ввода данных с консоли
import static java.lang.Math.*; // Импорт статических методов класса Math для математических операций

public class Main {
    private static final double EARTH_RADIUS = 6371; // Константа, определяющая радиус Земли в километрах

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для ввода данных с консоли

        System.out.println("Введите широту и долготу первого места, где ваш друг ест пиццу:");
        double Shirota1 = scanner.nextDouble(); // Ввод широты первого места
        double Dolgota1 = scanner.nextDouble(); // Ввод долготы первого места

        System.out.println("Введите широту и долготу второго места, где ваш друг ест суши:");
        double Shirota2 = scanner.nextDouble(); // Ввод широты второго места
        double Dolgota2 = scanner.nextDouble(); // Ввод долготы второго места

        double distance = calculateDistance(Shirota1, Dolgota1, Shirota2, Dolgota2); // Вызов метода calculateDistance для расчета расстояния между двумя местами
        System.out.printf("Расстояние между двумя местами, где вашими друзьями: %.2f км%n", distance); // Вывод расстояния на консоль с двумя знаками после запятой
    }

    private static double calculateDistance(double Shirota1, double Dolgota1, double Shirota2, double Dolgota2) {
        Shirota1 = toRadians(Shirota1); // Преобразование градусов широты первого места в радианы
        Dolgota1 = toRadians(Dolgota1); // Преобразование градусов долготы первого места в радианы
        Shirota2 = toRadians(Shirota2); // Преобразование градусов широты второго места в радианы
        Dolgota2 = toRadians(Dolgota2); // Преобразование градусов долготы второго места в радианы

        double Raznostshirot = Shirota2 - Shirota1; // Расчет разности широт
        double Raznostdolgot = Dolgota2 - Dolgota1; // Расчет разности долгот

        double a = sin(Raznostshirot / 2) * sin(Raznostshirot / 2) + // Расчет аргумента функции ар cotangens
                cos(Shirota1) * cos(Shirota2) * sin(Raznostdolgot / 2) * sin(Raznostdolgot / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a)); // Расчет расстояния по формуле Гаверсина

        return EARTH_RADIUS * c; // Возвращение результата в километрах
    }
}