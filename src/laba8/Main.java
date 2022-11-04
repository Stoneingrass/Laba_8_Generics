package laba8;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Number> a1 = new SingleLinkedList<>(1.0, 3.0, 4.0);
        SingleLinkedList<Number> a2 = new SingleLinkedList<>(5,28,9,21, 5,2,9, 1);

        System.out.println("First set:");
        output(a1);
        System.out.println("Second set:");
        output(a2);

        System.out.println("Sets intersection:");
        output(getSetsIntersection(a1,a2));


        a1 = new SingleLinkedList<>(1, 1, 3, 4, 9, 5);
        a2 = new SingleLinkedList<>(5,28,9,21, 5,2,9, 1);

        System.out.println("First set:");
        output(a1);
        System.out.println("Second set:");
        output(a2);

        System.out.println("Sets intersection:");
        output(getSetsIntersection(a1,a2));

        SingleLinkedList<?>[] aa = new SingleLinkedList[] {
                new SingleLinkedList<>(1,25,2,3,5,26,5,3,5,10,9,7,4,3,3,56,646,345,345),
                new SingleLinkedList<>(3,2,6,7,9,5,4,6,7,8,9,4,3,365,57,46,7, 10),
                new SingleLinkedList<>(3,2,8,10,4,3,365,57,46,7),
                new SingleLinkedList<>(1,2,3,4,5,6,7,8,9,10)
        };

        System.out.println();
        int setI=0;
        for (SingleLinkedList<?> a: aa) {
            System.out.println("Set #" + ++setI);
            output(a);
        }

        System.out.println("Sets intersection:");
        output(getSetsIntersection(aa));
    }

    //finds intersection (common elements) for 2 sets
    static SingleLinkedList<Number> getSetsIntersection(SingleLinkedList<? extends Number> set1, SingleLinkedList<? extends Number> set2) {
        SingleLinkedList<Number> result = new SingleLinkedList<>();
        for (Object item1: set1.getList().toArray()) {
            for (Object item2: set2.getList().toArray()) {
                if(item1.equals(item2)) {
                    boolean isAdded = false;
                    for (Object item0: result.getList()) {
                        if (item0.equals(item1)) {
                            isAdded = true;
                            break;
                        }
                    }
                    if (isAdded) {
                        break;
                    }

                    result.getList().add((Number)item1);
                    break;
                }
            }
        }
        return result;
    }

    //finds intersection for many of sets
    @SafeVarargs
    static SingleLinkedList<Number> getSetsIntersection(SingleLinkedList<? extends Number>... sets) {
        SingleLinkedList<Number> result = getSetsIntersection(sets[0],sets[0]);
        for (SingleLinkedList<?> set: sets) {
            result = getSetsIntersection(result,set);
        }
        return result;
    }

    //outputs the set
    static void output(SingleLinkedList<? extends Number> list) {
        if(list.getList().size()==0) {
            System.out.println("Empty set.");
        }
        for (Object o: list.getList().toArray()) {
            System.out.print(o + "\t");
        }
        System.out.println();
    }
}