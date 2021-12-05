public class PersonBuilder {

    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Имя не заполненно");
        } else {
            this.name = name;
            return this;
        }
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Фамилия не заполненно");
        } else {
            this.surname = surname;
            return this;
        }
    }


    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalStateException("Возраст не может принимать отрицательные значения");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        if (name != null || surname != null) {
            if (age >= 0) {
                person = new Person(name, surname, age);
            } else {
                person = new Person(name, surname);
            }
            person.setAddress(address);
        } else {
            throw new IllegalStateException("Поля \"Имя\" и/или \"Фамилия\" не заполненны");
        }
        return person;
    }
}
