/**
 * Функциональный интерфейс для генерации эл-ов массива.
 */
@FunctionalInterface
public interface ElementGenerator {
    double process(final int index, final double modifier);
}
