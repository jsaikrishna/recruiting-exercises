package exercises;

import java.util.*;


public class TestCases {
	HashMap<String,Long> inputOrder;
	@SuppressWarnings("rawtypes")
	List<HashMap> output_list;
	
	public TestCases() {
		this.inputOrder = new LinkedHashMap<>();
		this.output_list = new ArrayList<>();
	}
	
	@SuppressWarnings({ "rawtypes" })
	public boolean testCase1() {
		
		// input: { apple: 1 }, [{ name: owd, inventory: { apple: 1 } }]
		// Output: [{ owd: { apple: 1 } }]
		
		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();
		
		// Adding Input Order
		inputOrder.put("apple", (long) 1);
		
		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 1);
		StorageCenterList.add(owd);
		
		InventoryAllocator ia = new InventoryAllocator();
		
		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		
		//Adding the desired output
				//System.out.println("Hi");
				Map<String, HashMap<String, Long>> desiredMap = new LinkedHashMap<String, HashMap<String, Long>>();
				HashMap<String, Long> temp_map=new LinkedHashMap<>();
				temp_map.put("apple", (long) 1);
				desiredMap.put("owd", temp_map);
				output_list.add((HashMap) desiredMap);
				
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean testCase2() {

		// input: { apple: 1 }, [{ name: owd, inventory: { apple: 0 } }]
		// Output: []
		
		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 1);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 0);
		StorageCenterList.add(owd);

		InventoryAllocator ia = new InventoryAllocator();

		//Adding the desired output


		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		if(output_list.equals(result_list))
			return true;
		return false;
	}

	@SuppressWarnings("rawtypes")
	public boolean testCase3() {
		
		// input: { apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]
		// Output: [{ dm: { apple: 5 }}, { owd: { apple: 5 } }]

		
		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 10);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 5);
		StorageCenterList.add(owd);

		StorageCenter dm = new StorageCenter("dm");
		dm.setStorageCenterStock("apple",(long) 5);
		StorageCenterList.add(dm);

		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		
		//Adding the desired output

		Map<String, HashMap<String, Long>> desiredMap = new LinkedHashMap<String, HashMap<String, Long>>();
		HashMap<String, Long> temp_map=new LinkedHashMap<>();
		temp_map.put("apple", (long) 5);
		desiredMap.put("owd", temp_map);
		output_list.add((HashMap) desiredMap);

		Map<String, HashMap<String, Long>> desiredMap2 = new LinkedHashMap<String, HashMap<String, Long>>();
		HashMap<String, Long> temp_map2=new LinkedHashMap<>();
		temp_map2.put("apple", (long) 5);
		desiredMap2.put("dm", temp_map);
		output_list.add((HashMap) desiredMap2);
		
		//System.out.println(output_list.size());
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean testCase4() {

		// input: { apple: 3 }, [{ name: owd, inventory: { apple: 1 } }, { name: dm, inventory: { apple: 1 }}]
		// Output: []

		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 3);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 1);
		StorageCenterList.add(owd);

		StorageCenter dm = new StorageCenter("dm");
		dm.setStorageCenterStock("apple",(long) 1);
		StorageCenterList.add(dm);

		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean testCase5() {

		// input: { apple: 0 }, [{ name: owd, inventory: { apple: 1 } }, { name: dm, inventory: { apple: 1 }}]
		// Output: []
		
		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 0);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 1);
		StorageCenterList.add(owd);

		StorageCenter dm = new StorageCenter("dm");
		dm.setStorageCenterStock("apple",(long) 1);
		StorageCenterList.add(dm);

		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public boolean testCase6() {
		
		// input: { apple: 5, banana: 5, orange: 20 }, [{ name: owd, inventory: { apple: 5, banana: 5, orange:10 } }, { name: dm, inventory: { apple: 5, banana: 5, orange:10 }}]
		// Output: [{ owd: { apple: 5, banana: 5, orange: 10 }}, { dm: {orange: 10 } }]

		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 5);
		inputOrder.put("banana", (long) 5);
		inputOrder.put("orange", (long) 20);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 5);
		owd.setStorageCenterStock("banana",(long) 5);
		owd.setStorageCenterStock("orange",(long) 10);
		StorageCenterList.add(owd);
		
		StorageCenter dm = new StorageCenter("dm");
		dm.setStorageCenterStock("apple",(long) 5);
		dm.setStorageCenterStock("banana",(long) 5);
		dm.setStorageCenterStock("orange",(long) 10);
		StorageCenterList.add(dm);

		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		//Adding the desired output
		Map<String, HashMap<String, Long>> desiredMap = new LinkedHashMap<String, HashMap<String, Long>>();
		HashMap<String, Long> temp_map=new LinkedHashMap<>();
		temp_map.put("apple", (long) 5);
		temp_map.put("banana", (long) 5);
		temp_map.put("orange", (long) 10);
		desiredMap.put("owd", temp_map);
		output_list.add((HashMap) desiredMap);
		
		Map<String, HashMap<String, Long>> desiredMap2 = new LinkedHashMap<String, HashMap<String, Long>>();
		HashMap<String, Long> temp_map2=new LinkedHashMap<>();
		temp_map2.put("orange", (long) 10);
		desiredMap2.put("dm", temp_map2);
		output_list.add((HashMap) desiredMap2);

		//System.out.println(output_list.size());
		
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	
	@SuppressWarnings("rawtypes")
	public boolean testCase7() {
		
		// input: { apple: 3}, [{ name: owd, inventory: { apple: 2 } }, { name: dm, inventory: { apple: 4, banana: 2}}]
				// Output: [{ owd: { apple: 2 }}, { dm: {apple: 4 } }]

		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 3);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 2);
		StorageCenterList.add(owd);
		
		StorageCenter dm = new StorageCenter("dm");
		dm.setStorageCenterStock("apple",(long) 4);
		dm.setStorageCenterStock("banana",(long) 2);
		StorageCenterList.add(dm);
		
		
		StorageCenter gd = new StorageCenter("gd");
		gd.setStorageCenterStock("orange",(long) 3);
		StorageCenterList.add(gd);
	
		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		
		//Adding the desired output
		Map<String, HashMap<String, Long>> desiredMap = new LinkedHashMap<String, HashMap<String, Long>>();
		HashMap<String, Long> temp_map=new LinkedHashMap<>();
		temp_map.put("apple", (long) 2);
		desiredMap.put("owd", temp_map);
		output_list.add((HashMap) desiredMap);
		
		Map<String, HashMap<String, Long>> desiredMap2 = new LinkedHashMap<String, HashMap<String, Long>>();
		HashMap<String, Long> temp_map2=new LinkedHashMap<>();
		temp_map2.put("apple", (long) 3);
		desiredMap2.put("dm", temp_map2);
		output_list.add((HashMap) desiredMap2);

		//System.out.println(output_list.size());
		
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean testCase8() {

		// input: { apple: 3}, [{ name: owd, inventory: { apple: 4 } }, { name: dm, inventory: { banana: 2 }}]
		// Output: [{ owd: { apple: 4 }}]
		
		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 3);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 4);
		StorageCenterList.add(owd);
		
		StorageCenter dm = new StorageCenter("dm");
		dm.setStorageCenterStock("banana",(long) 2);
		StorageCenterList.add(dm);
		
		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		//Adding the desired output
		Map<String, HashMap<String, Long>> desiredMap = new LinkedHashMap<String, HashMap<String, Long>>();
		HashMap<String, Long> temp_map=new LinkedHashMap<>();
		temp_map.put("apple", (long) 4);
		desiredMap.put("owd", temp_map);
		output_list.add((HashMap) desiredMap);
	

		//System.out.println(output_list.size());
		
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean testCase9() {
		// input: { apple: 0}, [{ name: owd, inventory: { apple: 0 } }]
		// Output: []

		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 0);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 0);
		StorageCenterList.add(owd);
		
		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		
		if(output_list.equals(result_list))
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean testCase10() {

		// input: { apple: 4}, [{ name: owd, inventory: { apple: 2 } }, { name: dm, inventory: { banana: 2 }}]
		// Output: []
		
		inputOrder = new LinkedHashMap<>();
		output_list = new ArrayList<>();

		// Adding Input Order
		inputOrder.put("apple", (long) 4);

		// Adding StorageCenter Data/Inventory Data
		List<StorageCenter> StorageCenterList = new ArrayList<>();
		
		StorageCenter owd = new StorageCenter("owd");
		owd.setStorageCenterStock("apple",(long) 2);
		StorageCenterList.add(owd);
		
		StorageCenter dm = new StorageCenter("dm");
		dm.setStorageCenterStock("banana",(long) 2);
		StorageCenterList.add(dm);
		
		InventoryAllocator ia = new InventoryAllocator();

		List<HashMap> result_list = ia.findCheapShipment(inputOrder, StorageCenterList);
		//System.out.println(result_list.size());
		
		if(output_list.equals(result_list))
			return true;
		return false;
	}

	public static void main(String[] args) {
		TestCases tcs = new TestCases();
		System.out.println("testCase1: " + tcs.testCase1());
		System.out.println("testCase2: " + tcs.testCase2());
		System.out.println("testCase3: " + tcs.testCase3());
		System.out.println("testCase4: " +  tcs.testCase4());
		System.out.println("testCase5: " +  tcs.testCase5());
		System.out.println("testCase6: " +  tcs.testCase6());
		System.out.println("testCase7: " +  tcs.testCase7());
		System.out.println("testCase8: " +  tcs.testCase8());
		System.out.println("testCase9: " +  tcs.testCase9());
		System.out.println("testCase10: " +  tcs.testCase10());
	}
}
