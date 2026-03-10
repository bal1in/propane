package finalthing;

public class utils {
    public void insertionSort(int[] a) {
        //variables:
        //current - the item being compared
        //j - iterator for the while loop
        int current;
        int j = 0;

        //for loop that loops through the unsorted list, left to right
        //IMPORTANT: i is set to 1 instead of 0
        for(int i = 1; i<a.length; i++) {
            //set current to, well, the current item
            current = a[i];
            //set j to the current index
            j=i;

            //while you haven't reached the end of the list AND the next item is bigger than the current item
            while (j > 0 && a[j-1]>current){
                //set the new current item to the next item
                a[j] = a[j - 1] ;
                //subtract 1 from j (reads right to left)
                j--;
            }
            //whatever item caused the while loop to end, set that to the old current
            a[j] = current;
        }
        //output the sorted list
    }
    
    //method which checks if a value is entirely numbers
    public boolean checkInt(String in){
        //if it is all numbers, the conversion will succeed and true will be returned
        try{
            int t = Integer.parseInt(in);
            return true;
        }
        //if it is impossible catch the error and return false
        catch(NumberFormatException e){
            return false;
        }
    }
    
    //method which attempts to convert string to double
    public double tryInt(String in){
        //if it is all numbers, the conversion will succeed and true will be returned
        try{
            double t = Double.parseDouble(in);
            return t;
        }
        //if it is impossible catch the error and return false
        catch(NumberFormatException e){
            return 0;
        }
    }
}
