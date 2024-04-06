public class Main {
    public static void main(String[] args) {
        ListTAD list = new ListTAD();
        list.addEnd(10);
        list.addEnd(30);
        list.addEnd(70);
        list.addEnd(90);
        list.addEnd(15);

        System.out.println(list.length());
        list.print();
        list.printReverse();
        System.out.println(list);

        list.addStart(69);
        System.out.println(list);

        list.add(6,99);
        System.out.println(list);

        list.removeEnd();
        System.out.println(list);

        list.removeStart();
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        list.change(2, 10000);
        System.out.println(list);

        System.out.println(list.find(30));
        System.out.println(list.find(11));

        System.out.println(list.getByPos(0));
        System.out.println(list.getByPos(99));

        list.clear();
        System.out.println(list);

    }
}