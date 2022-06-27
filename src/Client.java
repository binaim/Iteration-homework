import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Client {
    public static void main(String[] args) {
        MyVector myVector = new MyVector();
        myVector.addAll(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));

        //Complete External Standard java
        Integer sum = 0;
        for(Integer element : myVector){
        sum += element;
        }
        System.out.println("The external java standard o/p:" + sum);

        //1. Internal Complete W/sum Functor
        Integer sum1 = myVector.doAll(new SumFunctor());
        System.out.println("The Internal sum complete w/sum functor:" + sum1);

        //1.b Internal complete w/average functor

        Double sum1b = myVector.doAll(new AverageFunctor());
        System.out.println("The Internal complete w/ average functor:" + sum1b);

        //2 External Selective w/sum functor
        SumFunctor selectiveSumFunctor = new SumFunctor();
        PredicateConditioner selectivePredicator = new PredicateConditioner();

        for(Integer element : myVector){
            if(selectivePredicator.test(element)){
                selectiveSumFunctor.compute(element);
            }
        }

        Integer sum2 = selectiveSumFunctor.getValue();
        System.out.println("The External Selective w/sum functor:" + sum2);


        //2b External Selective w/average Functor
        SelectiveAverageFunctor selectiveAverageFunctor = new SelectiveAverageFunctor();
        for(Integer element : myVector){

            if(selectivePredicator.test(element)){
                selectiveAverageFunctor.compute(element);
            }
        }
        Double selectedAverage = selectiveAverageFunctor.getValue();
        System.out.println("The Internal selective w/average functor:" + selectedAverage);

        //3 selective Optional
        Integer sum3 = myVector.doAll(new SumFunctor(), new PredicateConditioner());
        System.out.println("The Internal Selective Optional:" + sum3);


        //4 selective + Iterable
        View v1 = new View(myVector, (x->x>2));
        Integer sum4=0;

        for (Integer element: myVector){
            sum4 += element;
        }
        System.out.println("The selective + Iterable optional:" + sum4);

    }

}
