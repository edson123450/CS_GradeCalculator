public class ExtraPointsPolicy {

    public double applyExtraPoints(double currentGrade, boolean allYearsTeachers) {
        if (allYearsTeachers) {
            return currentGrade + 1; // por ejemplo +1 punto
        }
        return currentGrade;
    }
}