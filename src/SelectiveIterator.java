import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;

public class SelectiveIterator implements Iterator<Integer> {
    Vector<Integer> myVector;
    Predicate<Integer> predicate;
    Integer index=0;

    public SelectiveIterator(Vector<Integer> myVector, Predicate<Integer> predicate) {
        this.myVector = myVector;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {

        getValue();
        return  index < myVector.size();

    }

    public void getValue(){
        Integer element= myVector.get(index);
        if(predicate.test(element)){
            return;
        }
        else {
            index++;
            getValue();
        }
    }

    @Override
    public Integer next() {
        Integer element = myVector.get(index);
            index++;
            return element;

    }


    }

