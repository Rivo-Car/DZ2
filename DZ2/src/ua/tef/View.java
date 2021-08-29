package ua.tef;

public class View {
	public static final String GREETING = "Добрый день! \n"
			+ "Выберите хотите ли вы выставить мин и макс: x - да, иначе - нет - ";
	public static final String INPUT_MIN = "Напишите минимум: ";
	public static final String INPUT_MAX = "Напишите максимум: ";
	public static final String INPUT_INT_DATA = "Угадайте число из отрезка ";
	public static final String ERROR_INPUT = "Hе из отрезка!";
    public static final String WRONG_INPUT = "Неправильный ответ! ";
    public static final String RIGHT_INPUT = "Правильный ответ = ";
	public static final String YOUR_INT = "Вы ввели: ";
	public static final String CONSOLE_ANSWER = "! Ваше число: ";
	public static final String COUNT = "Ваше число неудачных попыток: ";
	public static final String[] MORE_OR_LESS = {"Больше ответа! ", "Меньше ответа! "};	
	
	public static void printMessage(String message){
        System.out.print(message);
    }
	
	public static void println(String message) {
		System.out.println(message);
	}
}