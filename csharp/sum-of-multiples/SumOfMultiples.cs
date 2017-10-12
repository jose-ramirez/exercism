using System;
using System.Collections.Generic;

public static class SumOfMultiples
{
    public static int Sum(IEnumerable<int> multiples, int max)
    {
		int total = 0;

        if (multiples == null || !multiples.GetEnumerator().MoveNext())
        {
            return 0;
        }
        else
        {
			for(int i = 1; i < max; i++)
			{
				foreach(int m1 in multiples)
				{
					if(i % m1 == 0)
					{
						total += i;
						break;
					}
				}
			}
            
        }
		return total;
    }
}