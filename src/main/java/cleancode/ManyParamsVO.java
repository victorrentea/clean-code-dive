package cleancode;

//@Embeddable
class FullName {
    private final String firstName;
    private final String lastName;

    public FullName(String firstName, String lastName) {
        if (firstName == null || lastName == null) throw new IllegalArgumentException();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String concatenated() {
        return firstName + " " + lastName.toUpperCase();
    }
}


public class ManyParamsVO {
    public static void main(String[] args) {
        Address address = new Address("St. Albergue", "Paris", 99);
        FullName fullName = new FullName("John", "Doe");
        new ManyParamsVO().placeOrder(fullName, address);
    }

    public void placeOrder(FullName fullName, Address address) {
        if (fullName == null) throw new IllegalArgumentException();

        System.out.println("Some Logic for " +
                fullName.getFirstName() + " " + fullName.getLastName().toUpperCase());
    }
}

class AnotherClass {
    public void otherMethod(FullName fullName, int x) {
        if (fullName == null) throw new IllegalArgumentException();

        System.out.println("Another distant Logic");
    }
}


// over the hills and far away ...
//HOLY ENTITY
class Person {
    private FullName fullName;

    public Person(FullName fullName) {
        if (fullName == null) throw new IllegalArgumentException();
        // TODO think: is this sufficient enforcing ?
    }

    public FullName getFullName() {
        return fullName;
    }

}

class PersonService {
    public void f(Person person) {
        String fullName = person.getFullName().concatenated();
        String fullName2 = person.getFullName().concatenated();
        String fullName3 = person.getFullName().concatenated();
        String fullName4 = person.getFullName().concatenated();
        String fullName5 = person.getFullName().concatenated();
        System.out.println(fullName);
    }
}