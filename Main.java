/**10. Кофемашина. Необходимо вывести кофе, где стоимость больше 10, но меньше или равна 20,
        отсортированный по увеличению стоимости максимумом в 2 элемента.
        Сделать по поиск по стоимости.*/
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Coffee> coffees = List.of(
                new Coffee(20, 2, 10, 5),
                new Coffee(15, 7, 5, 10),
                new Coffee(10, 5, 0, 5),
                new Pirog(30, 2),
                new Pirog(35, 4)
        );

        List<Barista> barista = List.of(
                new Barista("Александр"),
                new Barista("Евгений"),
                new Barista("Григорий"),
                new Barista("Глеб"),
                new Barista("Антон")
        );

        StaticEda.Pribyl(coffees);
        StaticEda.Print(coffees);


        List<Printable> entities = Stream.concat(coffees.stream(), barista.stream())
                .toList();

        for (Printable entity : entities) {
            System.out.println(entity.getInfo());
        }


        DataProcessor<Coffee> dataProcessor = new DataProcessor<>(coffees);

        System.out.println();
        System.out.println("Необходимо вывести кофе, где стоимость больше 10, но меньше или равна 20,\n" +
                "отсортированный по увеличению стоимости максимумом в 2 элемента.\n" +
                "Сделать по поиск по стоимости.");
        System.out.println();
        try {
            List<AnotherCoffee> anotherCoffees = dataProcessor.getAnotherCoffees(10, 21);
            if (anotherCoffees.isEmpty()) {
                System.out.println("Нет данных");
            } else {
                for (AnotherCoffee anotherCoffee : anotherCoffees) {
                    System.out.println(anotherCoffee.getInfo());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            System.out.println(dataProcessor.searchCost(25));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
