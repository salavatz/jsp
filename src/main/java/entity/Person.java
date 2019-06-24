package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String name; //required
    private LocalDate birthDate; //required
    private String email; //required
    private String phone; //optinal

    private Person(Builder builder) {
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(email, person.email) &&
                Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, email, phone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class Builder {
        private final String name; //required
        private final LocalDate birthDate; //required
        private final String email; //required
        private String phone; //optinal

        public Builder(String name, LocalDate birthDate, String email) {
            this.name = name;
            this.birthDate = birthDate;
            this.email = email;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
