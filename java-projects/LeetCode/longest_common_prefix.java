class Solution {
    public String longestCommonPrefix(String[] strs) {
       
        int locationOfShortest = -1;
        int shortestLength = 123456789;
        String prefix = "";

        //terminate/give only answer if the list is empty or has only one element
        if(strs.length == 1){
            return strs[0];
        }

        if(strs.length == 0){
            return prefix;
        }

        //find the length of the shortest word
        for (int i = 0; i < strs.length; i++){
            if(strs[i].length() < shortestLength){
                locationOfShortest = i;
                shortestLength = strs[i].length();
            }
        }
      
        //go letter by letter for prefix
        for(int i = 0; i <= shortestLength; i++){
            prefix = strs[locationOfShortest].substring(0,i);
            for(int j = 0; j < strs.length; j++){
                if (!strs[j].startsWith(prefix)){
                    return strs[locationOfShortest].substring(0,i-1);
                }
            }
        }
        return prefix;
    }
}
