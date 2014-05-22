package com.mobile.utils;

import java.io.UnsupportedEncodingException;


public final class Tools {

	public static String alert(String msg){
		return "<script language='javascript'>window.alert('"+msg+"');</script>";
	}
	
	public static String location(String path){
		return "<script language='javascript'>window.location='"+path+"';</script>";
	}
	
	public static String back(){
		return "<script language='javascript'>window.history.back();</script>";
	}
	
	public static String toUTF8(String str){
		try {
			return new String( str.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
