public interface Game {
    void start(Integer sizeWord, Integer maxTry);

    Answer inputValue(String value);

    String command(String value);

    GameStatus getGameStatus();
}
