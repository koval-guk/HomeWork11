public class ListApp {
    public static void main(String[] args) {
        ThreadSafeList<Integer> list = new ThreadSafeList<>();

        Runnable runnable1 = () -> {
            list.add(11);
            list.add(12);
            list.add(13);
            list.add(111);
            list.add(14);
            list.add(15);
            System.out.println("size1 = " + list.size());
        };
        Runnable runnable2 = () -> {
            list.add(21);
            list.add(22);
            list.add(23);
            list.add(222);
            list.add(24);
            list.add(25);
            System.out.println("size2 = " + list.size());
        };
        try {
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        System.out.println("size = " + list.size());
            thread1.join();
            thread2.join();
         } catch (InterruptedException e)
         {
            System.out.println("Interrupt");
        }
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1000);
        list.add(4);
        list.add(5);
        System.out.println("get 5 = "+list.get(5));
        list.remove(3);
        list.remove(8);
        list.remove(13);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ;  ");
        }
        System.out.println();
        System.out.println("size = " + list.size());
    }
}
