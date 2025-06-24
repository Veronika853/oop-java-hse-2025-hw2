public class GraduateStudent extends Student {
    private String thesisTitle;

    public GraduateStudent(String name, int id, String major, String thesisTitle) {
        super(name, id, major);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Тема диссертации: " + thesisTitle;
    }
}
