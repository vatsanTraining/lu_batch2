package com.example.demo;

import java.lang.reflect.Method;

import com.example.demo.stereotypes.MyBean;

public class MyAnnotationProcessor {

	public static void main(String[] args) {

		
		MyService obj = new MyService();
		
		  Class cls = obj.getClass();
		  
		  MyBean bean = (MyBean) cls.getAnnotation(MyBean.class);
		  
		  String objName = bean.name();
		  
		  System.out.println(objName);
		  
		  String scopeName = bean.scope();

		  System.out.println(scopeName);
		  
		  try {
			Method method = cls.getMethod("show");
			
			MyBean bean2 = (MyBean)method.getAnnotation(MyBean.class);
			
			System.out.println(bean2.name());
			System.out.println(bean2.scope());
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		  
		  
		  
	}

}
