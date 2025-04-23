package ir.ac.kntu.style;

import ir.ac.kntu.Level;
import ir.ac.kntu.SecureDocument;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecureDocumentTest {

    @Test
    public void testAccessAllowed_HighUser_HighDoc() {
        SecureDocument doc = new SecureDocument("Doc1", "Top Secret", Level.HIGH);
        assertEquals("Top Secret", doc.getContent(Level.HIGH));
    }

    @Test
    public void testAccessAllowed_HighUser_MediumDoc() {
        SecureDocument doc = new SecureDocument("Doc2", "Confidential", Level.MEDIUM);
        assertEquals("Confidential", doc.getContent(Level.HIGH));
    }

    @Test
    public void testAccessDenied_LowUser_HighDoc() {
        SecureDocument doc = new SecureDocument("Doc3", "Ultra Secret", Level.HIGH);
        assertEquals("You Don't Have Access", doc.getContent(Level.LOW));
    }

    @Test
    public void testAccessAllowed_MediumUser_MediumDoc() {
        SecureDocument doc = new SecureDocument("Doc4", "Medium Info", Level.MEDIUM);
        assertEquals("Medium Info", doc.getContent(Level.MEDIUM));
    }

    @Test
    public void testAccessDenied_LowUser_MediumDoc() {
        SecureDocument doc = new SecureDocument("Doc5", "Secret Info", Level.MEDIUM);
        assertEquals("You Don't Have Access", doc.getContent(Level.LOW));
    }

    @Test
    public void testAccessAllowed_HighUser_LowDoc() {
        SecureDocument doc = new SecureDocument("Doc6", "Public Info", Level.LOW);
        assertEquals("Public Info", doc.getContent(Level.HIGH));
    }

    @Test
    public void testAccessAllowed_LowUser_LowDoc() {
        SecureDocument doc = new SecureDocument("Doc7", "Basic Info", Level.LOW);
        assertEquals("Basic Info", doc.getContent(Level.LOW));
    }

    @Test
    public void testAccessDenied_MediumUser_HighDoc() {
        SecureDocument doc = new SecureDocument("Doc8", "Secret Strategy", Level.HIGH);
        assertEquals("You Don't Have Access", doc.getContent(Level.MEDIUM));
    }

    @Test
    public void testSetAndGetAccessLevel() {
        SecureDocument doc = new SecureDocument("Doc9", "Update Info", Level.LOW);
        doc.setAccessLevel(Level.HIGH);
        assertEquals(Level.HIGH, doc.getAccessLevel());
    }

    @Test
    public void testSetAndGetTitle() {
        SecureDocument doc = new SecureDocument("OldTitle", "Something", Level.MEDIUM);
        doc.setTitle("NewTitle");
        assertEquals("NewTitle", doc.getTitle());
    }
}
