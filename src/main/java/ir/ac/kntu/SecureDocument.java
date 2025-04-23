package ir.ac.kntu;

public class SecureDocument {
    private String title;
    private String content;
    private Level accessLevel;

    public SecureDocument(String doc1, String topSecret, Level level) {
        setTitle(doc1);
        setContent(topSecret);
        setAccessLevel(level);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent(Level userAccessLevel) {
        if (Level.getLevel(userAccessLevel) >= Level.getLevel(accessLevel)) {
            return content;
        }
        return "You Don't Have Access";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Level getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Level accessLevel) {
        this.accessLevel = accessLevel;
    }
}
