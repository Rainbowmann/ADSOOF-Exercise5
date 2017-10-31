import java.util.*;

class DictionaryTest2
{
 public static void main(String[] args)
 {
  Dictionary dict = new Dictionary();
  Random rand = new Random();
  char ch='a';
  for(int i=0; i<100; i++)
     {
      String word1=""+ch+rand.nextInt(10);
      String word2=""+ch+rand.nextInt(10);
      if(ch=='z')
         ch='a';
      else
         ch++;
      dict.add(word1,word2);
     }
  Scanner in = new Scanner(System.in);
  String str;
  do {
      System.out.print(": ");
      str=in.nextLine();
      String[] strs=str.split(" +");
      try {
           if(strs[0].equals("a"))
              dict.add(strs[1],strs[2]);
           else if(strs[0].equals("c"))
              System.out.println(dict.contains(strs[1]));
           else if(strs[0].equals("e"))
              System.out.println(dict.equiv(strs[1]));
           else if(strs[0].equals("r"))
              dict.remove(strs[1]);
           else if(strs[0].equals("s"))
              System.out.println(dict.same(strs[1],strs[2]));
           else if(strs[0].equals("n"))
              System.out.println(dict.getSize());
           else if(strs[0].equals("q"))
              break;
           else
              {
               System.out.println();
               System.out.println("a word1 word2 : adds word2 as equivalent to word1");
               System.out.println("c word : tests whether word has an equivalent");
               System.out.println("e word : gives equivalent of word");
               System.out.println("r word : removes equivalent of word");
               System.out.println("s word1 word2 : tests whether word2 is equivalent to word1");
               System.out.println("n : gives total number of words");
               System.out.println("q : quits");
               System.out.println();
              }
           }
      catch(NotFoundException e)
           {
            System.out.println("? "+e.getMessage());
           }
     }
  while(true);
 }
}
