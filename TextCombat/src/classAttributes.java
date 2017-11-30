import java.util.HashMap;

public class classAttributes {
	
	HashMap<String, Boolean> mageEle;
	
	public  classAttributes() {
		
		mageEle = new HashMap<>();
		
		mageEle.put("fireWeak", false);
		mageEle.put("fireStrong", true);
		mageEle.put("iceWeak", false);
		mageEle.put("iceStrong", false);
		mageEle.put("arcaneWeak", false);
		mageEle.put("arcaneStrong", true);
		mageEle.put("windWeak", false);
		mageEle.put("windStrong", false);
	}
	
	public HashMap<String,Boolean> getMageEle() {
		
		return mageEle;
	}

}
