import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class StaticEda {
    public static void Pribyl(List<Coffee> coffees) {
        List<Integer> stringOfCofW = coffees.stream()
                .map(Coffee::getWater)
                .distinct()
                .toList();
        List<Integer> stringOfCofZ = coffees.stream()
                .map(Coffee::getZerna)
                .distinct()
                .toList();
        List<Integer> SebCof = new ArrayList<>();
        for (int i = 0; i < stringOfCofZ.size(); i++) {
            if (coffees.get(i).getClass() != Pirog.class) {
                int x = stringOfCofW.get(i) + stringOfCofZ.get(i);
                SebCof.add(x);
            }
        }

        List<Integer> CofCost = coffees.stream()
                .map(Coffee::getCost)
                .distinct()
                .toList();
        List<Integer> PribCof = new ArrayList<>();
        for (int i = 0; i < CofCost.size(); i++) {
            if (coffees.get(i).getClass() != Pirog.class) {
                int y = CofCost.get(i) - SebCof.get(i);
                PribCof.add(y);
            }
        }

        int maxCof = 0;
        int minCof = 87654;
        int maxInd = -1;
        int minInd = 1567;
        for (int i = 0; i < PribCof.size(); i++) {
            if(coffees.get(i).getClass() != Pirog.class) {
                if (PribCof.get(i) > maxCof) {
                    maxCof = PribCof.get(i);
                    maxInd = i;
                }
                if (PribCof.get(i) < minCof) {
                    minCof = PribCof.get(i);
                    minInd = i;
                }
            }
        }
        System.out.println("Самое прибыльное кофе: кофе " + maxInd);
        System.out.println("Самое малоприбыльное кофе: кофе " + minInd);

        int result = 0;
        for (int i = 0; i < PribCof.size(); i++) {
            if (coffees.get(i).getClass() != Pirog.class) {
                result += PribCof.get(i);
            }
        }
        result = result / 3;
        System.out.println("Средняя прибыль: " + result);
    }

    public static void Print(List<Coffee> coffees) {
        List<Integer> maxEd = new ArrayList<>();
        List<Integer> maxPrib = new ArrayList<>();
        List<Integer> CofW = coffees.stream()
                .map(Coffee::getWater)
                .distinct()
                .toList();
        List<Integer> CofZ = coffees.stream()
                .map(Coffee::getZerna)
                .distinct()
                .toList();
        List<Integer> SebCoff = new ArrayList<>();
        for (int i = 0; i < CofW.size(); i++) {
            if (coffees.get(i).getClass() != Pirog.class) {
                int z = CofW.get(i) + CofZ.get(i);
                SebCoff.add(z);
            }
        }
        List<Integer> Zak = coffees.stream()
                .map(Coffee::getZakaz)
                .distinct()
                .toList();
        List<Integer> CofCost = coffees.stream()
                .map(Coffee::getCost)
                .distinct()
                .toList();
        for (int i = 0; i < coffees.size(); i++) {
            if (coffees.get(i).getClass() != Pirog.class) {
                int a = CofCost.get(i) - SebCoff.get(i);
                maxEd.add(a);
                int b = maxEd.get(i) * Zak.get(i);
                maxPrib.add(b);
            }
        }
        for (int i = 0; i < coffees.size(); i++) {
            if (coffees.get(i).getClass() != Pirog.class) {
                if (maxEd.get(i) != 0) {
                    System.out.printf("Кофе %d: прибыль с единицы - %d, прибыль с партии - %d\n", i, maxEd.get(i), maxPrib.get(i));
                }
            }
        }
    }
}

