using System;
using System.Linq;

public enum Classification
{
    Perfect,
    Abundant,
    Deficient
}

public static class PerfectNumbers
{
    public static Classification Classify(int number)
    {
        var sumDivisors = (from i in Enumerable.Range(1, number - 1) where number % i == 0 select i).Sum();
        if (number == sumDivisors)
        {
            return Classification.Perfect;
        }
        else if (number < sumDivisors)
        {
            return Classification.Abundant;
        }
        return Classification.Deficient;
        
    }
}
