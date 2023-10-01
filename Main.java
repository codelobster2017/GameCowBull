import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game = null;

        while (game == null) {
            System.out.println("""
                    Выберите игру:
                    Угадай цифры        - int
                    Русский алфавит     - ru
                    Английски алфавит   - en
                    """);
            String gameString = scanner.nextLine();
            switch (gameString) {
                case "ru" -> game = new RuGame();
                case "en" -> game = new EnGame();
                case "int" -> game = new NumberGame();
                default -> System.out.println("Что-то ты неправильно ввел");
            }
        }

        System.out.println("Введи длину слова: ");
        int sizeWord = scanner.nextInt();
        System.out.println("Введи число попыток: ");
        int maxTry = scanner.nextInt();

        System.out.println("""
                Введи:
                start   - новая игра
                restart - перезапуск
                stop    - остановка
                history - посмотреть историю игры
                """);

        game.start(sizeWord, maxTry);

        if (game.getGameStatus() != GameStatus.STOP) {
            while (game.getGameStatus() != GameStatus.WIN && game.getGameStatus() != GameStatus.LOSE && game.getGameStatus() != GameStatus.STOP) {
                String answer = game.command(scanner.nextLine());
                System.out.println("answer = " + answer);
            }
            System.out.println("game.getGameStatus() = " + game.getGameStatus());
        }

    }
}



