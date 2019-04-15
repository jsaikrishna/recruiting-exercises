package exercises;

import java.util.*;

public class InventoryAllocator {
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> findCheapShipment(HashMap<String,Long> inputOrder, List<StorageCenter> warehouseList){
		
		ArrayList<HashMap> result = new ArrayList<HashMap>();
		Map<String, HashMap<String,Long>> resultMap = new LinkedHashMap<>();
		
		
		// checking if input order and warehouse if empty
		if(warehouseList.size() == 0 || inputOrder.size() == 0)
			return result;
		
		
		for(String itemName : inputOrder.keySet()) {
			long itemQuantity = inputOrder.get(itemName);
			
			if(itemQuantity > 0) {
				// iterating over all warehouses for items
				for(int i=0;i<warehouseList.size();i++) {
					StorageCenter wareHouse = warehouseList.get(i);
					// checking if the warehouse is empty or not
					if(wareHouse.getStorageCenterStock().size() != 0) {
						String wareHouseName = wareHouse.getStorageCenterName();	
						long itemCount = wareHouse.getStockCount(itemName);
					
						if(itemCount <= 0)
							continue;
						if(itemQuantity <= 0)
							break;
						else if(itemCount >= itemQuantity) {
							// if available available count is greater than or equal to the required item quantity
							itemQuantity = 0;
							HashMap<String,Long> current_map = resultMap.getOrDefault(wareHouseName, new LinkedHashMap<>());
							current_map.put(itemName, itemCount);
							resultMap.put(wareHouseName, current_map);
							break;
							
						}
						else {
							// if available item quantity is less than the required item quantity
							itemQuantity = itemQuantity - itemCount;
							HashMap<String,Long> current_map = resultMap.getOrDefault(wareHouseName, new LinkedHashMap<>());
							current_map.put(itemName, itemCount);
							resultMap.put(wareHouseName, current_map);
							
						}
					}
				}
			}
			if(itemQuantity!=0) {
				// If there are not enough items available in storage center
				result.clear();
				return result;
			}
		}
		
		// Here adding all results in a final result list
		for(String storageCenterName : resultMap.keySet()) {
			HashMap<String,HashMap<String,Long>> temp_map = new LinkedHashMap<>();
			temp_map.put(storageCenterName, resultMap.get(storageCenterName));
			result.add(temp_map);
		}
		
		return result;
		
	}

}
