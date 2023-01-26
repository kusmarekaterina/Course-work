import java.util.Objects;

public class FullName {
    private final String name;
    private final String surname;
    private final String patronymic;

    public FullName (String surname, String name,  String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() {return name;}

    public String getSurname() { return surname;}

    public String getPatronymic() {return patronymic;}

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(name, fullName.name) && Objects.equals(surname, fullName.surname) && Objects.equals(patronymic, fullName.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic);
    }
}
