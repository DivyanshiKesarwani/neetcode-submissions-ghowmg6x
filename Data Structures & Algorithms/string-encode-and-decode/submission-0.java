
class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs)
        {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length())
        {
            int hashIndex = str.indexOf('#', i);

            int length = Integer.parseInt(str.substring(i, hashIndex));//integer.parse to convert from "4" to 4

            String word = str.substring(hashIndex + 1, hashIndex + 1 + length);

            result.add(word);

            i = hashIndex + 1 + length;
        }

        return result;
    }
}