package com.sp.SpringCore;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
 
public class JavaCollect {
	private List<String> addressList;
    private Set<String> addressSet;
    private Map<Integer, String> addressMap;
    Properties addressProp;

    public List<String> getAddressList() {
    	System.out.println("--------------------1");
    	for (String ad : addressList) {
			System.out.println(ad);
		}
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	public Set<String> getAddressSet() {
		System.out.println("--------------------2");
    	for (String ad : addressSet) {
			System.out.println(ad);
		}
		return addressSet;
	}
	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
	public Map<Integer, String> getAddressMap() {
		System.out.println("--------------------3");
		for (int i = 1; i <= addressMap.size(); i++) {
			System.out.println(addressMap.get(i));
		}
		return addressMap;
	}
	public void setAddressMap(Map<Integer, String> addressMap) {
		this.addressMap = addressMap;
	}
	public Properties getAddressProp() {
		System.out.println("--------------------4");
		Enumeration<String> props = ((Enumeration<String>)addressProp.propertyNames());
		for (; props.hasMoreElements();) {
			String k=(String)props.nextElement();
			System.out.println(k+" : "+addressProp.getProperty(k) );
		}
		return addressProp;
	}
	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}
 
}