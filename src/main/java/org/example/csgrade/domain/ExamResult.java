public class ExamResult {
    private final double finalGrade;
    private final double partialGrade;
    private final boolean attendanceOk;
    private final boolean extraPointsApplied;

    public ExamResult(double finalGrade, double partialGrade,
                      boolean attendanceOk, boolean extraPointsApplied) {
        this.finalGrade = finalGrade;
        this.partialGrade = partialGrade;
        this.attendanceOk = attendanceOk;
        this.extraPointsApplied = extraPointsApplied;
    }

    public void printDetail() {
        System.out.println("Detalle del cálculo:");
        System.out.println(" - Nota parcial: " + partialGrade);
        System.out.println(" - Asistencia mínima: " + (attendanceOk ? "Sí" : "No"));
        System.out.println(" - Puntos extra: " + (extraPointsApplied ? "Aplicados" : "No aplicados"));
        System.out.println(" - Nota final: " + finalGrade);
    }

    public double getFinalGrade() { return finalGrade; }
}