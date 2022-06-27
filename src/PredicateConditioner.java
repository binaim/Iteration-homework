import java.util.function.Predicate;

public class PredicateConditioner implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer > 2;
    }
}
