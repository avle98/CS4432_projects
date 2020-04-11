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
    public BufferPool (Integer poolSize) {
        //build the array given the input argument
        ArrayList<Frame> bufferArray = new ArrayList<Frame>();
        //go over each frame and initialize this frame
        for (Integer i=1; i<poolSize+1; i++) {
            Frame eachFrame = new Frame(i);
            bufferArray.add(eachFrame);
        }
        buffers = bufferArray;
    }

    //method2: return buffer number (slot number in array) holding this block
    //takes blockId as input
    public Integer getBufNum (Integer blockId) {
        Integer bufNum = -1; //not available
        //search if a certain block (file) is available in the buffer pool
        for (Integer i=1; i<this.buffers.size()+1; i++) {
            if (this.buffers.get(i).getBlockId() == blockId) {
                bufNum = i; // available
            }
        }
        return bufNum;
    }

    //method3: return content of a given blockId if block is present
    //takes blockId as input
    public Integer getBlockId (Integer blockId) {
        return this.buffers.get(getBufNum(blockId)).getBlockId();
    }

    //method4: read block (file) from disk and bring it to the buffer pool
    //takes array list of files and blockId as input
    public void bringToBufferPool (ArrayList<Frame> files, Integer blockId) {
        //read the block (file) from disk and if blockId in buffer pool
        if (getBufNum(blockId) == -1) {
            //search for blockId in files array (memory) with same blockId
            for (Integer i=0; i<files.size(); i++) {
                if (files(i).getBlockId() == blockId) {
                    //if there's an empty frame, add it to empty frame in buffer pool
                    if (this.getArrayNum() != -1) {
                        this.buffers.set(getArrayNum(), files.get(i));
                    }
                    //if there is no empty frame, take one out and return it back to disk
                    else {
                        this.buffers.set(1, files.get(i))
                    }
                }
            }
        }
    }

    //method5: search and return a number in the array for an empty frame
    public Integer getArrayNum () {
        Integer arrayNum = -1; //full frame
        for (Integer i=0; i<this.buffers.size(); i++) {
            Integer thisBlockId = this.buffers.get(i).getBlockId();
            if (thisBlockId == -1) {
                arrayNum = i;
            }
        }
        return arrayNum;
    }

}

