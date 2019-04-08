public class Configuration {

    private String config;
    private int score;


    public Configuration(String config, int score) {
        this.config = config;
        this.score = score;

    }

    public String getStringConfig() {
        return config;
    }

    public int getScore() {
        return score;
    }
}
