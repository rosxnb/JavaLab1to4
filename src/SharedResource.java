class Resource
{
    private int sharedResource = 0;

    public synchronized void accessResource(String threadName)
    {
        for (int i = 1; i <= 5; i++)
        {
            sharedResource++;
            System.out.println(threadName + " modified the resource. New value: " + sharedResource);

            try
            {
                Thread.sleep(100); // Simulating some processing time
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class SharedResourceThread extends Thread
{
    private final Resource resource;
    private final String threadName;

    public SharedResourceThread(Resource resource, String threadName)
    {
        this.resource = resource;
        this.threadName = threadName;
    }

    @Override
    public void run()
    {
        resource.accessResource(threadName);
    }
}

public class SharedResource
{
    public static void main(String[] args)
    {
        Resource sharedResourceObject = new Resource();

        // Creating two threads sharing the same resource
        SharedResourceThread threadA = new SharedResourceThread(sharedResourceObject, "Thread A");
        SharedResourceThread threadB = new SharedResourceThread(sharedResourceObject, "Thread B");

        // Start the threads
        threadA.start();
        threadB.start();

        try
        {
            threadA.join();
            threadB.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}
