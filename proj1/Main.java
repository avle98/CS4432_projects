package avle_dbII_proj1;

public class Main {

    public static void main(String[] args) {

        //1) Calling the program
        //a. Create BufferPool class with "n" slots in the "buffers" array
        //b. Do all proper initializations; all frames are empty
        //c. print "THE PROGRAM IS READY FOR THE NEXT COMMAND"

        //2) GET command: "Get k"
        //User needs to print the content of record #k from the file
        //a. Call a Get() function in the buffer pool class
        //Calculate which block (file) contains this record
        //b. Function should scan the "buffers" array to figure out whether or not the desired file is in memory
        //Call the corresponding method in the "BufferPool" class
            //Case 1: Block (file) is in memory
            //Find desired record (40 bytes only) and return it to be printed on screen.
            //Case 2: Block is not in memory, but empty buffers in buffer pool array
            //Read right file from disk, copy its content to an empty buffer frame. Once file is in memory, call the functions used in case #1
            //Case 3: Block is not in memory, buffer pool array is full (no empty frames) but some frames can be taken out
            //Search for a frame that can be taken out
            //Case 4: Block is not in memory, buffer pool array is full (no empty frames), no frames taken out
            //Print message


        //3) SET command: "Set k <string of 40 bytes>
        //User needs to set the content of record #k to the given string
        //a. All of the work in command #1 applies to have the desired block (file) in memory
        //b. Change the content of the record to new string.
        //c. Set the "dirty" flag to "true"


        //4) PIN command: "Pin BID"
        //User wants to pin specific block (BID) in memory
        //a. BID is a block (file) number not record number
            //Case 1: Block is already in buffer pool
            //Set "pinned" flag to True. If it is already set, then do nothing.
            //Case 2: Block is not in memory, buffer pool is either empty slots or you can take out a block
            //Bring the BID to memory and set the "pinned" flag to "true"
            //Case 3: Block is not in memory, buffer pool is full and no blocks can be taken out
            //Print message

        //5) UNPIN command: "Unpin BID"
        //User wants to unpin specific block (BID) in memory
        //Notice that BID is a block (file) number not record number
            //Case 1: Block is in the buffer pool
            //Set "pinned" flag to "false" if not that already
            //Case 2: Block is not in memory
            //Print message


    }
}
