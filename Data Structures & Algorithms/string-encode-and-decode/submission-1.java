
class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb=new StringBuilder();
        for(String s:strs)
        {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();//4#neet3#you
    }

    public List<String> decode(String str) {
        int i=0;
       ArrayList<String>result=new ArrayList<>();
    while(i < str.length())
        {
            int hashIndex = str.indexOf('#', i);//1
            int length=Integer.parseInt(str.substring(i,hashIndex));//0
            result.add(str.substring(hashIndex+1,hashIndex+1+length));
            i=hashIndex+1+length;//update i 
        }
        return result;
    }
}