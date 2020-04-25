package generics;

public class GenericsPair {
    public static void main(String[] args) {

        String str = "Helloworld";
        Integer i = 365;

        Pair pair = new Pair(str, i);
        System.out.println(pair.getFirst());
    }

}
class Pair<F,S>{
    F first;
    S second;

    public Pair(){}

    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }
}
