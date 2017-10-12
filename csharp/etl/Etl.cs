using System;
using System.Collections.Generic;

public static class Etl
{
    public static IDictionary<string, int> Transform(IDictionary<int, IList<string>> old)
    {

        IDictionary<string, int> res = new Dictionary<string, int>();
        foreach (int val in old.Keys)
        {
            foreach(string key in old[val])
            {
                res.Add(key.ToLowerInvariant(), val);
            }
        }
        return res;
    }
}