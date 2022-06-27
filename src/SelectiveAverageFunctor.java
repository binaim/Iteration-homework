public class SelectiveAverageFunctor implements Functor<Double, Double>{

    Integer sum = 0;
    Integer sizer = 0;
    @Override
    public void compute(Integer element) {
        sum += element;
        sizer++;
    }

    @Override
    public Double getValue() {
        return Double.valueOf(sum/sizer);
    }
}
