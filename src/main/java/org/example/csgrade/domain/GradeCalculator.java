import java.util.List;

public class GradeCalculator {

    private final AttendancePolicy attendancePolicy;
    private final ExtraPointsPolicy extraPointsPolicy;

    public GradeCalculator(AttendancePolicy attendancePolicy, ExtraPointsPolicy extraPointsPolicy) {
        this.attendancePolicy = attendancePolicy;
        this.extraPointsPolicy = extraPointsPolicy;
    }

    public ExamResult calculateFinalGrade(
            List<Evaluation> evaluations,
            boolean hasReachedMinimumClasses,
            boolean allYearsTeachers
    ) {

        // 1. Validaciones RF/RNF
        if (evaluations.size() == 0)
            throw new IllegalArgumentException("Debe haber al menos 1 evaluación.");
        if (evaluations.size() > 10)
            throw new IllegalArgumentException("Máximo 10 evaluaciones permitidas.");

        // 2. Calcular nota ponderada
        double sum = 0;
        for (Evaluation e : evaluations) {
            sum += e.getGrade() * (e.getWeight() / 100.0);
        }

        // 3. Asistencia
        if (!attendancePolicy.hasMinimumAttendance(hasReachedMinimumClasses)) {
            return new ExamResult(0, sum, false, false);
        }

        // 4. Puntos extra
        double finalGrade = extraPointsPolicy.applyExtraPoints(sum, allYearsTeachers);

        return new ExamResult(finalGrade, sum, true, allYearsTeachers);
    }
}