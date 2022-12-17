import java.util.Comparator;
import java.util.List;
import java.util.Optional;
public class DataProcessor<T extends Coffee> {
    List<T> coffees;

    public DataProcessor(List<T> coffees) {
        this.coffees = coffees;
    }

    public List<AnotherCoffee> getAnotherCoffees(int from, int to) throws Exception {
        if (from > to) {
            throw new MyException("Нижняя граница больше верхней");
        }
        return coffees.stream()
                .filter(coffee -> coffee.getCost() > from && coffee.getCost() < to)
                .sorted(Comparator.comparing(Coffee::getCost).reversed())
                .limit(2)
                .map(coffee -> new AnotherCoffee(coffee.getId(), coffee.getCost()))
                .toList();


    }

    public String searchCost(int currentCost) throws Exception {
        if (currentCost < 0) {
            throw new MyException("Стоимость меньше 0");
        }
        Optional<AnotherCoffee> coffeeOptional = coffees.stream()
                .map(coffee -> new AnotherCoffee(coffee.getId(), coffee.getCost()))
                .filter(coffee -> coffee.getCost() == currentCost)
                .findFirst();

        if (coffeeOptional.isPresent()) {
            return coffeeOptional.get().getInfo();
        } else {
            return "Нет данных";
        }
    }
}


