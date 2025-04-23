package ir.ac.kntu;

public enum Level {
    HIGH, MEDIUM, LOW;
    public static int getLevel(Level level){
        return switch (level) {
            case HIGH -> 2;
            case MEDIUM -> 1;
            case LOW -> 0;
        };
    }
}
