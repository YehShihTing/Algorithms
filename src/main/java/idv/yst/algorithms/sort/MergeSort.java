package idv.yst.algorithms.sort;

import java.util.List;

import com.google.common.collect.Lists;

public class MergeSort {

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
		System.out.println("sortedList:" + new MergeSort().sort(orgList));
	}

	public List<Integer> sort(List<Integer> orgList) {
		if (orgList.size() < 2) {
			return orgList;
		}
		return merge(sort(orgList.subList(0, orgList.size() / 2)),
				sort(orgList.subList(orgList.size() / 2, orgList.size())));
	}

	private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
		List<Integer> mergedList = Lists.newLinkedList();
		int list1Index = 0, list2Index = 0;
		while (list1Index < list1.size() || list2Index < list2.size()) {
			if (list1Index == list1.size()) {
				mergedList.add(list2.get(list2Index++));
			} else if (list2Index == list2.size()) {
				mergedList.add(list1.get(list1Index++));
			} else {
				if (list1.get(list1Index) <= list2.get(list2Index)) {
					mergedList.add(list1.get(list1Index++));
				} else {
					mergedList.add(list2.get(list2Index++));
				}
			}
		}
		return mergedList;
	}
}
