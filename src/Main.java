import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        boolean exception = false;
        Stack<Integer> stack = new Stack<>(); //Инициализация стэка с типом Integer
        String inputs = new String();
        String[] list = new String[]{};
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите последовательность чисел: ");
        for(;;) {
            exception = false;
            inputs = sc.nextLine(); //Ввод строки
            list = inputs.split(" "); //Деление элементов строки по пробелам
            for (int i = 0; i < list.length; i++) {
                try {
                    stack.push(Integer.valueOf(list[i])); // Кладём в стэк эллементы
                } catch (NumberFormatException e) { // Если встречается элемент не int то просим ввести числа снова
                    exception=true;
                    stack.clear(); //отчистка стэка
                    System.out.println("Не все эллементы числа!\nВведите аккуратнее ещё раз: ");
                    break; //завершение внесения элл-ов в стэк и начало нового цикла
                }

            }
            if (!exception) { //2 часть программы выполняется только если не было ошибки
                inputs = "";
                int size = stack.size(); //Берём размер стэка заранее так как в процессе извлечения он будет меняться
                for (int i = 0; i < size; i++) {
                    inputs += (stack.pop() + " ");// Извлечение элементов из стэка с записью в строку ч/з пробел
                }
                System.out.println(inputs); //вывод итоговой строки
                break; //завершение работы программы
            }
        }

    }
}