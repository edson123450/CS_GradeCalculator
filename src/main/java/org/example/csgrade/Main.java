package org.example.csgrade;

import org.example.csgrade.domain.AttendancePolicy;
import org.example.csgrade.domain.Evaluation;
import org.example.csgrade.domain.ExamResult;
import org.example.csgrade.domain.ExtraPointsPolicy;
import org.example.csgrade.domain.GradeCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Evaluation> evaluations = new ArrayList<>();

        System.out.println("=== CS-GradeCalculator ===");

        // Registrar evaluaciones
        System.out.print("¿Cuántas evaluaciones desea registrar? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Nota " + i + ": ");
            double grade = sc.nextDouble();
            System.out.print("Peso " + i + " (%): ");
            double weight = sc.nextDouble();

            evaluations.add(new Evaluation(grade, weight));
        }

        // Asistencia
        System.out.print("¿Cumplió asistencia mínima? (true/false): ");
        boolean hasAttendance = sc.nextBoolean();

        // Puntos extra
        System.out.print("¿Todos los docentes están de acuerdo en dar puntos extra? (true/false): ");
        boolean extra = sc.nextBoolean();

        GradeCalculator calculator =
                new GradeCalculator(new AttendancePolicy(), new ExtraPointsPolicy());

        ExamResult result = calculator.calculateFinalGrade(evaluations, hasAttendance, extra);

        System.out.println("\n--- Resultado Final ---");
        result.printDetail();
    }
}