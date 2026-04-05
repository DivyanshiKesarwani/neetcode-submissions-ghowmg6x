
//| Approach        | Time Complexity  | Space Complexity |
//| --------------- | ---------------- | ---------------- |
//| Sorting         | `O(n * k log k)` | `O(nk)`          |
//| Character Count | `O(n * k)`       | `O(nk)`          |

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

    //     List<List<String>> result = new ArrayList<>();
    //     boolean[] visited = new boolean[strs.length];

    //     for(int i = 0; i < strs.length; i++)
    //     {
    //         if(visited[i]) continue;

    //         List<String> group = new ArrayList<>();
    //         group.add(strs[i]);
    //         visited[i] = true;

    //         for(int j = i + 1; j < strs.length; j++)
    //         {
    //             if(!visited[j] && isAnagram(strs[i], strs[j]))
    //             {
    //                 group.add(strs[j]);
    //                 visited[j] = true;
    //             }
    //         }

    //         result.add(group);
    //     }

    //     return result;
    // }

    // public boolean isAnagram(String s, String t) {

    //     if(s.length() != t.length())
    //         return false;

    //     int[] count = new int[26];

    //     for(int i = 0; i < s.length(); i++)
    //     {
    //         count[s.charAt(i) - 'a']++;
    //         count[t.charAt(i) - 'a']--;
    //     }

    //     for(int val : count)
    //     {
    //         if(val != 0)
    //             return false;
    //     }

    //     return true;

   HashMap<String,ArrayList<String>>hm=new HashMap<>();
   for(String s:strs)
   {
        char arr[]=s.toCharArray();
        int arr1[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            arr1[s.charAt(i)-'a']++;
        }
        //Arrays.sort(arr);
        String key=Arrays.toString(arr1);

        if(!hm.containsKey(key))
        {
            hm.put(key,new ArrayList<>());
        }
        hm.get(key).add(s);
   }
   return new ArrayList<>(hm.values());
    }
}