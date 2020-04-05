package avle_dbII_proj1;

public class Frame {
	private String content; //holds the file content
	private Boolean dirty; //true if content of block changes, need to be writen to disk when this frame is taken out
	private Boolean pinned; //true if there is a request to keep this block in memory and not take it out; false means it can be taken out
	private Integer blockId; //id of block stored in this frame; can use -1 to indicate that the frame is empty with no blocks

	//constructor
	public Frame(String ccontent, Boolean cdirty, Boolean cpinned, Integer cblockId) {
		content = ccontent;
		dirty = cdirty;
		pinned = cpinned;
		blockId = cblockId;
	}








}