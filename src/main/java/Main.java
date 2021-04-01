import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static double[] getFilledArray(final int size, final double mod, final ElementGenerator elementGenerator) {
        double[] result = new double[size];

        for (int i = 0; i < size; i++) {
            result[i] = elementGenerator.process(i, mod);
        }

        return result;
    }

    public static void main(final String[] args) {
        final int arraysSize = 10;

        Scanner scanner = new Scanner(System.in);
        double modifier = scanner.nextDouble();
        scanner.close();

        // элемент = индекс плюс модификатор
        double[] firstArray = getFilledArray(arraysSize, modifier, (index, mod) -> index + mod);
        System.out.println(Arrays.toString(firstArray));

        // элемент = индекс, умноженный на модификатор
        double[] secondArray = getFilledArray(arraysSize, modifier, (index, mod) -> index * mod);
        System.out.println(Arrays.toString(secondArray));

        /*
         * элемент = {индекс, деленный пополам, плюс модификатор} - для четных индексов
         *          {квадрат индекса минис модификатор} - для нечетных
         */
        double[] thirdArray = getFilledArray(
                arraysSize,
                modifier,
                (index, mod) -> (index % 2 == 0) ? (index / 2.0 + mod) : (index * index - mod)
        );
        System.out.println(Arrays.toString(thirdArray));

        /*
         * элемент = { индекс плюс квадрат модификатора} - для индексов в диапазоне [0, 3)
         *          {модификатор в степени индекса (при положительном модификаторе)} - для индексов в диапазоне [3, 6)
         *          {индекс} - [6, ...)
         */
        double[] fourthArray = getFilledArray(
                arraysSize,
                modifier,
                (index, mod) -> {
                    if (index < 3) {
                        return index + mod * mod;
                    } else {
                        if (index < 6) {
                            double result = 1;
                            for (int i = 1; i <= index; i++) {
                                result *= mod;
                            }
                            return result;
                        } else {
                            return index;
                        }
                    }
                });
        System.out.println(Arrays.toString(fourthArray));

        /*
         * элемент = размер массива в степени модификатора (при положительном модификаторе)
         *          плюс индекс, деленное на размер массива
         */
        double[] fifthArray = getFilledArray(
                arraysSize,
                modifier,
                (index, mod) -> {
                    double result = 1;
                    for (int i = 0; i < mod; i++) {
                        result *= arraysSize;
                    }
                    return (result + index) / arraysSize;
                }
        );
        System.out.println(Arrays.toString(fifthArray));
    }

}
