package idv.yst.algorithms.sort;

import java.util.List;

import com.google.common.collect.Lists;

public class QuickSort {

	public static void main(String[] args) {
		List<Integer> orgList = Lists.newArrayList();
		orgList.add(38);
		orgList.add(27);
		orgList.add(43);
		orgList.add(3);
		orgList.add(9);
		orgList.add(82);
		orgList.add(10);
		System.out.println("orgList:" + orgList);
		System.out.println("sortedList:" + new QuickSort().sort(orgList));
	}

	public List<Integer> sort(List<Integer> orgList) {
		if (orgList.size() < 2) {
			return orgList;
		}
		List<Integer> lowList = Lists.newLinkedList();
		List<Integer> highList = Lists.newLinkedList();
		List<Integer> resultList = Lists.newLinkedList();
		int pivot = orgList.remove(0);
		for (Integer i : orgList) {
			if (i <= pivot) {
				lowList.add(i);
			} else {
				highList.add(i);
			}
		}
		resultList.addAll(sort(lowList));
		resultList.add(pivot);
		resultList.addAll(sort(highList));
		return resultList;
	}
}
