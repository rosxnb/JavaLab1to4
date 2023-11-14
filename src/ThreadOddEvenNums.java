public class ThreadOddEvenNums
{
    public static final int SLEEP = 1000;
    public static final Runnable OddRunner = () -> {
        try
        {
            for (int i = 1; i <= 10; i += 2)
            {
                System.out.print(Thread.currentThread());
                System.out.println(" -- Odd number: " + i);
                Thread.sleep(SLEEP);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("OddRunner interrupted with exception");
        }
    };

    public static final Runnable EvenRunner = () -> {
        try
        {
            Thread.sleep(100);
            for (int i = 2; i <= 10; i += 2)
            {
                System.out.print(Thread.currentThread());
                System.out.println(" -- Even number: " + i);
                Thread.sleep(SLEEP + 300);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("EvenRunner interrupted with exception");
        }
    };

    public static void main(String[] args)
    {
        Thread oddPrinter = new Thread(ThreadOddEvenNums.OddRunner);
        Thread evenPrinter = new Thread(ThreadOddEvenNums.EvenRunner);

        oddPrinter.start();
        evenPrinter.start();
    }
}
