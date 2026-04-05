class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        HashMap<Character,Character>hm=new HashMap<>();
        hm.put('}','{');
        hm.put(')','(');
        hm.put(']','[');
        for(int i=0;i<s.length();i++)
        {
            char data=s.charAt(i);
            if(data=='{'||data=='['||data=='(')
            {
                stack.push(data);
            }
            else if(stack.isEmpty())
                {return false;}
            else{
                if(stack.peek() != hm.get(data))
                {return false;}
                stack.pop();

            }

        }
        return stack.isEmpty();
    }
}
