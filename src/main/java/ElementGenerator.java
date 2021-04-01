/**
 * Функциональный интерфейс для генерации эл-ов массива.
 */
@FunctionalInterface
public interface ElementGenerator {
    double process(int index, double modifier);
}
