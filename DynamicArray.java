/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */
    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[RESIZE_FACTOR * this.underlying.length]; //changed the number 2 to Resize_Factor to solve the implementation problem and use the Resize_Factor declaration to grow the array. 
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy = this.occupancy + 1; //Add one to the elements that are already stored, meaning once another element is added, add 1 so that occupanmcy will equal the total number of elements in the array.
    } // method add

    /**
     * method to find the position of an element in the underlying array
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     * Search for the string and if it is the current index being checked stop the loop it is a match.
     * No need to check the full array length because those slots are empty, or unused slots. Using occupancy will check every element that was already added and stored in a slot with valid strings.
     * Make sure to use a portion of the array and record the first match.
     * Ignore the other matches, take the first match since by default index will not be -1 because it is found.
     */
    public int indexOf(String string) {
        int index = -1; //default if the first occurrance is not found.
        //record the first position found index from the serached strings.
        for (int i = 0; i < this.occupancy; i++){ 
            if (index == -1 && string.equals(this.underlying[i])){ 
                index = i;
            }
        }
    return index;
    } // method indexOf

    /** Method to tell if a string exists in the underlying array */
    public boolean contains(String string) {
        boolean found = false; //int in search method defaults to -1 if not found
        if (this.indexOf(string) != -1) { //Found something
            found = true;
        }
        return found;
    }

    /** Method to count how many times a string appears in the underlying array*/
    public int countOf(String string) {
        int count = 0; //set the counter up, begin at 0.
        for (int i = 0; this.occupancy; i++) { //increase the count for the checked elements in the occupancy list.
            count = count + 1; //increase the count by 1.
        }
        return count;
    }
    /** method to remove items from the underlying array
     * Make sure you remove the items within bounds of the array.
     * Shifting to the left to remove element after an element has been added to a stored slot.
     * Avoids gaps in between when a shift happens. A shift will duplicate a position leaving an empty slot after.
     */
    public String remove(int index) {
        String removed = null; //null if the index is out of bounds.
        if (index >= 0 && index < this.occupancy) { //remove a slot that exists, make sure index is 0 or greater and only checked by the elements that have been filled, not the whole array.
            removed = this.underlying[index]; //remove a value.
            for (int i = index; i < this.occupancy - 1; i++) { //shift to the left.
                this.underlying[i] = this.underlying[i+1]; 
            } 
        } return index;
    }

    /** overload remove */ 
    public String remove(String string) {
        return "James on the street talking trash about your hotel";
    }

    /** Complete this method */
    public String toString() {
        return "to be done shortly"; // blatant violation of magic values clause
                                     // serves as reminder to finish this method
    }

} // class DynamicArray