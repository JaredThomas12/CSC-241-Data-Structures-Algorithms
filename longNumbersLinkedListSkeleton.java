import java.util.*;
public class longNumbersLinkedListSkeleton{

    public static void main(String[] args) throws Exception
    {
            Scanner stdIn = new Scanner(System.in);
            String longNumber;
            LinkedList<LinkedList> mainList = new LinkedList<LinkedList>();
            LinkedList<Integer> sumList = new LinkedList<Integer>();
            int max = 0;
            int index = 0;

            while(true)
            {
                System.out.println("Enter the numbers you want to add, type stop if you are done entering numbers.");
                longNumber = stdIn.next();

                //removes 0's at the beginning of a number
                while(longNumber.substring(0, 1).equals("0"))
                {
                    longNumber = longNumber.substring(1, longNumber.length());
                }

                if(longNumber.equals("stop"))
                {
                    break;
                }
                if(max < longNumber.length())
                    max = longNumber.length();

                mainList.add(new LinkedList<>());
                //adds the longNumber directly to the mainList as the integer value the character represents.
                for(int i = longNumber.length(); i>0; i--)
                {
                    mainList.get(index).add((longNumber.charAt(i-1)-48));

                }

                index++;
            }

            int carry;

            int sum;
            for(int i = 0; i<max; i++)
            {
                carry = 0;
                sum = 0;
                for(int k = 0; k<mainList.size(); k++)
                {
                    //accumulator gets current values in the mainList, for examples 1's, 10's, 100's, there is a designated check so if a number has less digits than the max width
                    //that numbers linked list wont get iterated more than it needs to and wont cause an index out of bounds exception

                    if(i <= mainList.get(k).size()-1)
                        carry = carry + (int)mainList.get(k).get(i);

                }


                //checks to see how big the sumList is, if it is the same size as the amount of items added, initially both are 0, then it adds a value
                //they will both increase at a 1:1 ratio until a value greater than 10 appears and in that case the value will be integer divided and added
                //after the current link

                if (sumList.size()== i)
                {
                    sumList.add(i, carry%10);
                    if( carry>=10)
                        sumList.add(i+1, carry/10);
                    System.out.println(sumList);
                }
                else
                {

                    sum = sumList.get(i)+carry;
                    sumList.set(i,sum%10);

                    //checks to see if there is a value in the next link, if there is it changes the value since only the carry was kept in there previously
                    //if there isn't a value in the next link and the current carry value is bigger than 10 one is added
                    //if there is already an integer in the next link from a previous number that was greater than 10, this will simply replace that number with the new one
                    if( sum>=10 && sumList.size() == i+2)
                        sumList.set(i+1, sum/10);
                    else if(sum>=10)
                    {
                        sumList.add(i+1, sum/10);
                    }
                    System.out.println(sumList);
                }

            }
            System.out.print("\n\nThe total is: ");
            //prints each value while removing them from the end since the numbers were essentially backwards in the sumList
            for(int i = sumList.size(); i > 0; i--)
            {
                System.out.print(sumList.removeLast());
            }
        }
    }