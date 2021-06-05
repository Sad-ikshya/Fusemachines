package com.fuse.financeManagement.utils;

import java.util.List;

public class ListManipulator<T> {
	
	public List<T> getLimitedData(List<T> dataList,int fromIndex,int pageLimit) {
		int listSize = dataList.size();
		
		if(listSize>pageLimit&& fromIndex<listSize) {
			int upperLimit=fromIndex+pageLimit;
			return dataList.subList(fromIndex,upperLimit);
		}
		
		return dataList;
	}
}
