public class GetNames extends Thread {
    public static void main(String[] args) {
        GetNames getNames = new GetNames();
        getNames.setName("getNames");
        getNames.start();
        ThreadGroup threadGroup = currentThread().getThreadGroup();
        int i = threadGroup.activeCount();
        Thread[] threads = new Thread[i];
        threadGroup.enumerate(threads);
        for (int j = 0; j < i; j++) {
            System.out.println(threads[j].getName());
            System.out.println(threads[j].getPriority());
            threads[j].interrupt();

        }

    }
}