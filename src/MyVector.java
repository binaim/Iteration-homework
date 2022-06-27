import java.util.Iterator;
import java.util.Vector;

public class MyVector extends Vector<Integer> {


    <R> R doAll(Functor functor){
        Iterator<Integer> myVecIterator = this.iterator();
        while(myVecIterator.hasNext()){
            functor.compute(myVecIterator.next());
        }
        return (R) functor.getValue();
    }


    <R> R doAll(Functor functor, PredicateConditioner predicator){

        Iterator<Integer> myIterator = this.iterator();

        while(myIterator.hasNext()){

            Integer temp = myIterator.next();
            if(predicator.test(temp)){functor.compute(temp);}

        }
        return (R) functor.getValue();
    }
}
