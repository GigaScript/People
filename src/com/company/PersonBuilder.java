package com.company;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше 0, Вы указали возраст " + age);
        } else if (age > 140) {
            throw new IllegalArgumentException("Возраст не может быть больше 140, Вы указали возраст " + age);
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name == null || name.length() < 1 || name.equals(" ")) {
            throw new IllegalStateException("Имя не указано, или слишком короткое, длина должна быть от 1 символа и не пробел" +
                    "\n Вы указали " + name);
        } else if (surname == null || surname.length() < 1 || surname.equals(" ")) {
            throw new IllegalStateException("Фамилия не указана, или слишком короткая, длина должна быть от 1 символа и не пробел" +
                    "\n Вы указали " + surname);
        }
        return new Person(name, surname, age, address);
    }
}
