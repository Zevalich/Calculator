import java.util.Scanner;

public class Runner {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("---> Добро пожаловать в калькулятор!");
            System.out.println("---> для выхода введите \"Выход\"");
            System.out.println("---> для продолжения нажмите любую клавишу.");
            if(scanner.next().equalsIgnoreCase("выход")){
                break;
            }
            double x = getNumber();
            char operation = getOperation();
            double y = getNumber();
            double result = calculate(x, y, operation);
            System.out.println("---> результат: " + result);
        }
    }
    public static double getNumber(){
        System.out.println("---> введите число: ");
        double number;
        if(scanner.hasNextDouble()){
            number = scanner.nextDouble();
        }else{
            System.out.println("---> ошибка, введите число: ");
            scanner.next();
            number = getNumber();
        }
        return number;
    }
    public static char getOperation(){
        System.out.println("---> введите операцию: ");
        char oper;
        if(scanner.hasNext()){
            oper = scanner.next().charAt(0);
        }else{
            System.out.println("---> ошибка, введите еще раз: ");
            scanner.next();
            oper = getOperation();
        }
        return oper;
    }
    public static double calculate(double x,double y, char operation){
        double result = 0;
        switch (operation){
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '/':
                if(y == 0){
                    System.out.println("---> ошибка, деление на 0");
                }else {
                    result = x / y;
                }
                break;
            case '*':
                result = x * y;
                break;
            default:
                System.out.println("---> оператор не найден");
                result = calculate(x, y, getOperation());
        }
        return result;
    }
}
