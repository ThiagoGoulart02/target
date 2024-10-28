import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            menu();
            try {
                option = in.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Voce digitou uma String inves de um numero. ");
                System.out.println("Finalizando o programa. ");
            }

            switch (option) {
                case 0:
                    System.out.println("Fechando o programa...");
                    break;
                case 1:
                    System.out.print("Escolha um número: ");
                    option = in.nextInt();
                    if (fibonacci(option)) {
                        System.out.println();
                        System.out.println("Pertence a sequencia de Fibonacci: " + option);
                    } else {
                        System.out.println();
                        System.out.println("Nao pertence a sequencia de Fibonacci: " + option);
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Escolha uma String: ");
                    String text = in.next();
                    int num = verifyString(text);
                    if (num == 0) {
                        System.out.println();
                        System.out.println("Nao possui a letra A na seguinte String: " + text);
                    } else {
                        System.out.println();
                        System.out.println("Possui a letra A na seguinte String: " + text + ", " +
                                "contagem de vezes que aparece: " + num);
                    }
                    in.nextLine();
                    break;
                case 3:
                    sum();
                    break;
                case 4:
                    lampSwitch();
                    break;
                default:
                    System.out.println("Essa opcao nao existe.");
            }
        } while (option != 0);
    }

    public static void menu() {
        System.out.println();
        System.out.println("[0] - Fechar programa");
        System.out.println("[1] - Fibonacci");
        System.out.println("[2] - Verifica se uma String possui a letra A");
        System.out.println("[3] - Exericio da soma");
        System.out.println("[4] - Exericio de descobrir a logica e completar o elemento");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }

    public static boolean fibonacci(int num) {
        if (num < 0) {
            return false;
        }

        int v1 = 0;
        int v2 = 1;

        while (v2 < num) {
            int temp = v1 + v2;
            v1 = v2;
            v2 = temp;
        }

        return v2 == num || num == 0;
    }

    public static int verifyString(String text) {
        int num = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.toUpperCase().charAt(i) == 'A') {
                num++;
            }
        }
        return num;
    }

    public static void sum() {
        int index = 12;
        int sum = 0;
        int k = 1;

        while (k < index) {
            k++;
            sum = sum + k;
        }
        System.out.println("Valor da variavel soma: " + sum);
    }

    public static void findLogic() {
        System.out.println("a) A soma do numero por 2: [1, 3, 5, 7, 9, 11, ...]");
        System.out.println("b) O dobro do numero anterior: [2, 4, 8, 16, 32, 64, 128, 256, ...]");
        System.out.println("c) Sequencia de numeros ao quadrado: [0, 1, 4, 9, 16, 25, 36, 49, 64, ...]");
        System.out.println("d) Sequencia de numeros pares ao quadrado: [4, 16, 36, 64, 100, 144, ...]");
        System.out.println("e) Sequencia de Fibonacci: [0, 1, 1, 2, 3, 5, 8, 13, 21, ...]");
        System.out.println("f) Não consegui descobrir a logica. ");
    }

    public static void lampSwitch() {
        System.out.println("Para a solução desse desafio, deveremos observar o calor da lampada. ");
        System.out.println("Passo 1: Deixar um dos interruptores acesso por um tempo, por exemplo, o primeiro interruptor. ");
        System.out.println("Passo 2: Desligar o primeiro interruptor e acender o segundo. ");
        System.out.println("Passo 3: Verificar o estado das lampadas: ");
        System.out.println(" - Se estiver ligada, vai ser do interruptor 2");
        System.out.println(" - Se estiver desligada, porém quente, será do interruptor 1");
        System.out.println(" - Se estiver desligada e na temperatura normal, será do interruptor 3");
    }
}