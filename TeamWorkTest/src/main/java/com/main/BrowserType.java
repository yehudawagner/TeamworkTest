package com.main;

public enum BrowserType {
FireFox, Chrom;
static public BrowserType convertFromString(String str){
	if(str.equals("FireFox")){
		return BrowserType.FireFox;
	}
	if(str.equals("Chrom")){
		return BrowserType.Chrom;
	}
	
	
	
	return null;
}
}
