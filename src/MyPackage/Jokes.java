package MyPackage;

public class Jokes
{
    private final String[] jokes = {
            "Why did the JavaScript boxer goto the chiropractor? \nBecause his backbone was angular from a knockout and required attention!",
            "Why did the C# developer fall asleep? \nBecause he didn't like Java.",
            "How do you make a Web App accessible? \nARIA kidding me?",
            "Why did the software company hire drama majors from Starbucks? \nBecause they needed JavaScript experts!",
    };

    private final int len = jokes.length;

    public String getJoke()
    {
        int idx = (int) (Math.random() * len);
        return jokes[idx];
    }
}
