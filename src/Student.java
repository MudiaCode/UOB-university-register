public record Student(int id, String name, String course, String module, int marks) {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", module='" + module + '\'' +
                ", marks=" + marks +
                '}';
    }
}
