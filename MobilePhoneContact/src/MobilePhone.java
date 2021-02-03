import java.util.ArrayList;

public class MobilePhone {
    private static ArrayList<Contact> myContact;
    private int myPhoneNumber;

    public MobilePhone(int myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println(contact.getName() + " is already in contacts");
            return false;
        } else
            this.myContact.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact.getName());
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " not found");
            return false;
        }
        this.myContact.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced by " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " not found");
            return false;
        }
        this.myContact.remove(foundPosition);
        System.out.println(contact.getName()+" is removed");
        return true;    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContact.size(); i++) { // for loop to compare all the elements
            Contact contact = this.myContact.get(i);  // we create a new instant which store i th element(name and phoneno.)
            if (contact.getName().equals(contactName)) { // we take the name of element and compare it with contactName
                return i;

            }
        }
        return -1;
    }

    private int findContact(Contact contact) {
        return myContact.indexOf(contact);
    }

    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
}

