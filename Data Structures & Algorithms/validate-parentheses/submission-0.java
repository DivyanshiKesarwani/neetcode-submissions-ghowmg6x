class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();

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
                if((data=='}'&& stack.peek()!='{')||
                (data==']'&& stack.peek()!='[')||
                (data==')'&& stack.peek()!='('))
                {return false;}
                stack.pop();

            }

        }
        return stack.isEmpty();
    }
}
