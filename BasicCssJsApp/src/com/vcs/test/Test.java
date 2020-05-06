package com.vcs.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		List list =new ArrayList();
		Student student=null;
		
		for(int i=0;i<=100000;i++){
			
			student=new Student();
			
			student.setSno(""+i);
			student.setSname("vcs"+i);
			
			list.add(student);
		}
	}

}
