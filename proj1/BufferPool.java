package avle_dbII_proj1;

import java.util.ArrayList;

//object in your Java program which represents the entire available buffer
public class BufferPool {
    private ArrayList <Frame> buffers; //size of this array is decided at run time;
    // program should take an input argument that decides the size of this array

    //constructor
    public BufferPool(ArrayList <Frame> listOfFrames) {
        buffers = listOfFrames;
    }

    //getters
    public ArrayList<Frame> getBuffers() {
        return this.buffers;
    }

    //setters
    public void setBuffers(ArrayList<Frame> listOfFrames) {
        this.buffers = listOfFrames;
    }


    //method1: public method to initialize()
    //build the array given the input argument
    //go over each frame and initialize this frame
    public BufferPool (Integer poolSize) {
        ArrayList<Frame> bufferArray = new ArrayList<Frame>();
        for (Integer i=1; i<poolSize+1; i++) {
            Frame eachFrame = new Frame(i);
            bufferArray.add(eachFrame);
        }
        buffers = bufferArray
    }

    //method2: search if a certain block (file) is available in the buffer pool
    //takes blockId as input
    //returns buffer number (slot number in the array) holding this block (or -1 if not available)


    //method3: used if the needed blockId is not in the buffer pool
    //read the block (file) from disk and bring it to the buffer pool (in an empty frame)


    //method4: search and give you back a number in the array for an empty frame (if any)


    //method5: if there are no empty frames in the buffer pool, then take one out and return it back to disk (if possible)

}

