import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;

public class View implements Iterable<Integer>{

    Vector<Integer> myVector;
    Predicate<Integer> predicate;

    public View(Vector<Integer> myVector, Predicate<Integer> predicate) {
        this.myVector = myVector;
        this.predicate = predicate;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SelectiveIterator(myVector,predicate);
    }
}
