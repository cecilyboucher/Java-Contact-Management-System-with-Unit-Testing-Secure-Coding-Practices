import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact = new Contact("C12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
    }

    // Test adding a contact
    @Test
    public void testAddContact() {
        Contact newContact = new Contact("C67890", "Jane", "Smith", "0987654321", "456 Oak St");
        contactService.addContact(newContact);
        assertEquals("Jane", newContact.getFirstName());
        assertEquals("Smith", newContact.getLastName());
    }

    // Test adding a duplicate contact ID
    @Test
    public void testAddContactWithDuplicateId() {
        Contact duplicateContact = new Contact("C12345", "Alice", "Jones", "5551234567", "789 Pine St");
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(duplicateContact));
    }

    // Test deleting a contact
    @Test
    public void testDeleteContact() {
        contactService.deleteContact("C12345");
        assertNull(contactService.getContact("C12345"));
    }

    // Test updating a contact's first name
    @Test
    public void testUpdateFirstName() {
        contactService.updateFirstName("C12345", "NewName");
        assertEquals("NewName", contact.getFirstName());
    }

    // Test updating a contact's last name
    @Test
    public void testUpdateLastName() {
        contactService.updateLastName("C12345", "NewLastName");
        assertEquals("NewLastName", contact.getLastName());
    }

    // Test updating a contact's phone number
    @Test
    public void testUpdatePhone() {
        contactService.updatePhone("C12345", "0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    // Test updating a contact's address
    @Test
    public void testUpdateAddress() {
        contactService.updateAddress("C12345", "789 Oak St");
        assertEquals("789 Oak St", contact.getAddress());
    }

    // Test updating a non-existent contact
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () ->
            contactService.updateFirstName("C99999", "NotFound"));
    }
}
