import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class contactmanager {
    Map<String,contact> contactlist=new ConcurrentHashMap<String,contact>();
    public void addcontact(String firstname,String lastname,String phoneNumber){
        contact contact=new contact(firstname,lastname,phoneNumber);
        validatecontact(contact);
        checkifcontactalreadyexist(contact);
        contactlist.put(generatekey(contact),contact);
    }

    private String generatekey(contact contact) {
        return String.format("%s %s",contact.getFirstname(),contact.getLastname());
    }
    public Collection<contact> getAllcontacts(){
        return contactlist.values();
    }
    private void checkifcontactalreadyexist(contact contact) {
        if(contactlist.containsKey(generatekey(contact))){
            throw new RuntimeException("contact already exists");
        }
    }

    private void validatecontact(contact contact) {
    contact.validatefirstname();
    contact.validatelastname();
    contact.validatephonenumber();
    }
}
