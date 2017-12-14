package Extensions;

import java.util.ArrayList;

import Model.IItem;
import Model.RichRail;
import Model.Train;

public class HasObjectType {

	public static boolean hasTrain() {
		ArrayList<IItem> items = RichRail.getInstance().getAllItems();
		
		if(items.isEmpty()) {
			return false;
		}else {
			for(IItem i : items) {
				if(i instanceof Train) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
