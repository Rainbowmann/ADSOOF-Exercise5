public class Dictionary {
    private String[][] dictionary;
    private int size;
    private int count=0;
    private boolean state;
    private boolean rowFound;
    
    public Dictionary(){
        size=0;
        dictionary=new String[110][2];
    }
    public void add(String word1, String word2){
        dictionary[count][0]=word1;
        dictionary[count][1]=word2;
        size=size+2;
        count++;
    }
    public boolean contains(String word){
        state=false;
        for (String[] words : dictionary) {
            for (String item : words) {
                if (item!=null){
                   if (item.equals(word)) {
                    state=true;
                   } 
                }
            }
        }
        return state;
    }
    public String equiv(String word) throws NotFoundException {
        for (String[] words : dictionary){
            if (words[0]!=null){
                if (words[0].equals(word)){
                    return words[1];
                }
            } else {
                throw new NotFoundException(word);
            }
        }
        throw new NotFoundException(word);
    }
    public void remove(String word) throws NotFoundException{
        if (!contains(word)) {
            throw new NotFoundException(word);
        }
        String[][] result=new String[dictionary.length-1][dictionary[0].length];
        int resultIndex=0;
        for (String[] words : dictionary) {
            if (words[0]!=null) {
                if (!words[0].equals(word)) {
                    System.arraycopy(words, 0, result[resultIndex], 0, words.length);
                    resultIndex++;
                }
            }
        }
        dictionary=result;
    }
    public boolean same(String word1, String word2) throws NotFoundException{
        state=false;
        for (String[] words : dictionary){
            if (words[0]!=null){
                if (words[0].equals(word1) && words[1].equals(word2)){
                    state=true;
                }
            }
        }
        return state;
    }
    public int getSize(){
        return size;
    }
}
