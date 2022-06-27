public class AverageFunctor implements Functor<Integer, Double>{
    private Integer sum = 0;
    private Integer sizer = 0;
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
