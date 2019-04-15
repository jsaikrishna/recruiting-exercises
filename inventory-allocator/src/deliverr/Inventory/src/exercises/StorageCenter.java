package exercises;

import java.util.*;

public class StorageCenter {
	String StorageCenterName;
	HashMap<String,Long> StorageCenterStock;
	
	public StorageCenter(String StorageCenterName) {
		this.StorageCenterName = StorageCenterName;
		this.StorageCenterStock = new LinkedHashMap<String, Long>(); // LinkedHashMap is used to maintain the order by how entered into map
	}
	
	public String getStorageCenterName() {
		return StorageCenterName;
	}
	public void setStorageCenterName(String storageCenterName) {
		this.StorageCenterName = storageCenterName;
	}


	public HashMap<String, Long> getStorageCenterStock() {
		return StorageCenterStock;
	}

	public void setStorageCenterStock(String itemName, Long itemQuantity) {
		this.StorageCenterStock.put(itemName, itemQuantity);
	}
	
	public long getStockCount(String itemName) {
		// getting the total number of items present for an item
		if(StorageCenterStock.containsKey(itemName))
			return (long) StorageCenterStock.get(itemName);
		return 0;
	}
	
	
	
}
