package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.aop.ProxtAop;

public class BlogServiceProxy implements InvocationHandler{
	private ProxtAop ProxtAop;
	//������Ķ���
	private Object obj;
	
	//����ͨ������������obj��ֵ
	public BlogServiceProxy(Object obj,ProxtAop ProxtAop ) {
		super();
		this.obj = obj;
		this.ProxtAop = ProxtAop;
	}

	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
//		System.out.println("before��ǰ�Ĳ���");
		ProxtAop.before();
		Object result = method.invoke(obj, args);
		ProxtAop.after();
//		System.out.println("after�Ժ�Ĳ���");
		
		return result;
	}

	
}
