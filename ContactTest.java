import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test valid contact creation
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("C12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("C12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test invalid contact ID (too long)
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test invalid first name (too long)
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C12345", "ThisNameIsWayTooLong", "Doe", "1234567890", "123 Main St"));
    }

    // Test invalid phone number (not 10 digits)
    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C12345", "John", "Doe", "12345", "123 Main St"));
    }

    // Test invalid address (too long)
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C12345", "John", "Doe", "1234567890", "This address is way too long to be valid in this context"));
    }

    // Test valid update for first name
    @Test
    public void testValidUpdateFirstName() {
        Contact contact = new Contact("C12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    // Test invalid update for first name (too long)
    @Test
    public void testInvalidUpdateFirstName() {
        Contact contact = new Contact("C12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("ThisNameIsWayTooLong"));
    }

    // Test valid update for last name
    @Test
    public void testValidUpdateLastName() {
        Contact contact = new Contact("C12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith",
