using System;
using System.Linq;

public static class IsbnVerifier
{
    public static int[] GetNumbers(string number) {
        return number
            .Replace("-", "")
            .Select(ch => {
                if (ch.Equals('X'))
                {
                    return 10;
                }
                else {
                    var success = int.TryParse(ch.ToString(), out var res);
                    if (success)
                    {
                        return res;
                    }
                    else
                    {
                        return -1;
                    }
                }
        }).ToArray();
    }

    public static bool IsValid(string number)
    {
        var xIndex = number.IndexOf("X");
        if (String.IsNullOrEmpty(number))
        {
            return false;
        }
        if (xIndex == -1 && number.Length < 10)
        {
            return false;
        }
        if (0 < xIndex && xIndex < number.Length - 1)
        {
            return false;
        }
        var digits = GetNumbers(number);
        if (digits.Length != 10)
        {
            return false;
        }
        if (digits.Where(d => d == -1).ToArray().Length != 0)
        {
            return false;
        }
        var sum = 0;
        for(var i = 0; i < 10; i++)
        {
            sum += (10 - i) * digits[i];
        }
        return sum % 11 == 0;
    }
}