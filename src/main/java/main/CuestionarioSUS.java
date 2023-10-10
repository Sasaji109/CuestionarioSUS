package main;
import java.util.Random;

public class CuestionarioSUS {

        public static void main(String[] args) {
            int numCuestionarios = 100;
            int[] respuestasBase = {3, 4, 3, 3, 3, 2, 2, 4, 4, 3}; // Respuestas base

            Random random = new Random();
            double[] puntuacionesTotales = new double[numCuestionarios]; // Array para almacenar las puntuaciones

            for (int i = 0; i < numCuestionarios; i++) {
                int[] respuestasVariadas = new int[10];

                for (int j = 0; j < 10; j++) {
                    int respuestaBase = respuestasBase[j];
                    int variacion = random.nextInt(3) - 1; // Genera -1, 0 o 1 como variación
                    int respuestaVariada = respuestaBase + variacion;

                    // Asegurarse de que la respuesta variada esté en el rango de 1 a 5
                    respuestaVariada = Math.min(5, Math.max(1, respuestaVariada));

                    respuestasVariadas[j] = respuestaVariada;
                }

                double puntuacionSUS = calcularPuntuacionSUS(respuestasVariadas);

                puntuacionesTotales[i] = puntuacionSUS;
                System.out.println("Cuestionario " + (i + 1) + ": Puntuación SUS = " + puntuacionSUS);
            }

            // Calcular la media de todas las puntuaciones
            double sumaTotal = 0;
            for (double puntuacion : puntuacionesTotales) {
                sumaTotal += puntuacion;
            }
            double media = sumaTotal / numCuestionarios;

            System.out.println("Puntuación media de los cuestionarios: " + media);
        }

        private static double calcularPuntuacionSUS(int[] respuestas) {
            int sumaImpares = 0;
            int sumaPares = 0;
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    sumaImpares += respuestas[i];
                } else {
                    sumaPares += (5 - respuestas[i]); // Calcular inversa
                }
            }
            return (sumaImpares + sumaPares) * 2.5;
        }

}

