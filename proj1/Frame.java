package avle_dbII_proj1;

import java.util.Arrays;

//object in your Java program to hold one file (one block)
public class Frame {
    private String content; //holds the file content
    private Boolean dirty; //true if content of block changes, need to be written to disk when this frame is taken out
    private Boolean pinned; //true if there is a request to keep this block in memory, do not take it out; false if it can be taken out
    private Integer blockId; //id of block stored in this frame; can use -1 to indicate that the frame is empty with no blocks

    public Frame(String ccontent, Boolean cdirty, Boolean cpinned, Integer cblockId) {
        content = ccontent;
        dirty = cdirty;
        pinned = cpinned;
        blockId = cblockId;
    }

    //getters
    public String getContent() {
        return content;
    }
    public Boolean getDirty() {
        return dirty;
    }
    public Boolean getPinned() {
        return pinned;
    }
    public Integer getBlockId() {
        return blockId;
    }

    //setters
    public Integer setContent(String inContent) {
        this.content = inContent;
        return 1;
    }
    public void setDirty(Boolean inDirty) {
        this.dirty = inDirty;
    }
    public void setPinned(Boolean inPinned) {
        this.pinned = inPinned;
    }
    public void setBlockId(Integer inBlockId) {
        this.blockId = inBlockId;
    }


    //method1: return a specific record in this block (record number i)
    //take an input of record number (i)
    //return the content of this record (string of 40 bytes)
    public String getRecord(int i) {
        Integer beginIndex = i*1024;
        Integer endIndex = beginIndex + 40;
        String recordContent = this.content.substring(beginIndex, endIndex);
        return recordContent;
    }

    //method2: update a specific record to the new content
    //take the record number and the new content (40bytes)
    //if content changes, the dirty flag should be set
    public void updateRecord(Integer recordNum, String newContent) {
        Integer beginIndex = recordNum * 1024;
        Integer endIndex = beginIndex + 40;
        String oldContent = this.content.substring(beginIndex, endIndex);
        if (oldContent != newContent) {
            this.dirty = true;
        }
        this.content.replace(oldContent, newContent);
    }

    //method3: initialize() method to initialize an empty frame
    //content = 40byte char of c's, dirty and pinned = false, blockId = -1
    public Frame(Integer i) {
        char[] contentArray = new char[40];
        Arrays.fill(contentArray, 'c');
        content = new String(contentArray);
        dirty = false;
        pinned = false;
        blockId = -1;
    }


}

