public class UniversityMember implements Person {
    String name;
    int id;

    public UniversityMember(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getDetails() {
        return "Человек из университета";
    }

    public Integer getId() {
        return id;
    }
}
