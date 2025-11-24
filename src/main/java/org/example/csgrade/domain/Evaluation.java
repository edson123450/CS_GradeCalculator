public class Evaluation {
    private final double grade;   // nota
    private final double weight;  // peso en porcentaje

    public Evaluation(double grade, double weight) {
        this.grade = grade;
        this.weight = weight;
    }

    public double getGrade() { return grade; }
    public double getWeight() { return weight; }
}
