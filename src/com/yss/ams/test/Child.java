package com.yss.ams.test;

public class Child  extends Parent{
	public Child() {
		System.out.println("In Child construct!");
	}

	@Override
	public void a() {
		System.out.println("In Child!");
	}
	
	public static void main(String[] args) {
		Child child=new Child();
		Parent parent=(Parent)child;
		parent.a();
		System.out.println("================");
		child.a();;
	}

}
