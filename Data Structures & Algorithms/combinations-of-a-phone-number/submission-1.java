class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        if (digits.length() == 0)
            return ans;

        String[] map = {
                "",     //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };

        backtrack(digits, 0, curr, ans, map);

        return ans;
    }

    public void backtrack(String digits,
                          int idx,
                          StringBuilder curr,
                          List<String> ans,
                          String[] map) {

        if (idx == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            curr.append(letters.charAt(i));

            backtrack(digits, idx + 1, curr, ans, map);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}