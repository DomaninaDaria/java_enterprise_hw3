package java_dz_3;

public class Message {
    private final String language;
    private final String greeting;

    public Message(String language, String text) {
        this.language = language;
        this.greeting = text;
    }

    public String getLanguage() {
        return language;
    }

    public String getGreeting() {
        return greeting;
    }
}
