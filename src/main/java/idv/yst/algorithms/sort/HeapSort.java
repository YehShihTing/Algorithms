package idv.yst.algorithms.sort;

import java.util.List;

import com.google.common.collect.Lists;

public class HeapSort {

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
		System.out.println("sortedList:" + new HeapSort().sort(orgList));
	}

	public List<Integer> sort(List<Integer> orgList) {
		List<Integer> result = orgList;
		for (int i = (orgList.size() >> 1) - 1; i >= 0; i--) {
			maxHeapify(result, i, orgList.size() - 1);
		}
		for (int i = orgList.size() - 1; i >= 0; i--) {
			swap(result, 0, i);
			maxHeapify(result, 0, i - 1);
		}
		return result;
	}

	private void maxHeapify(List<Integer> result, int start, int end) {
		int li = (start << 1) + 1;
		int ri = li + 1;
		int cMax = li;
		if (li > end)
			return;
		if (ri <= end && result.get(ri) > result.get(li)) {
			cMax = ri;
		}
		if (result.get(cMax) > result.get(start)) {
			swap(result, cMax, start);
			maxHeapify(result, cMax, end);
		}
	}

	private void swap(List<Integer> list, int i1, int i2) {
		list.add(i1, list.get(i2));
		list.add(i2, list.remove(i1 + 1));
		list.remove(i2 + 1);
	}
}
