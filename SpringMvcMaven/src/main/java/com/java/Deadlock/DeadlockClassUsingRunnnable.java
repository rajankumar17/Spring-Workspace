package com.java.Deadlock;

public class DeadlockClassUsingRunnnable{

	/**
	 * @param args
	 */
	public static Object lock1=new Object();
	public static Object lock2=new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread(new Thread1());
		Thread t2=new Thread(new Thread2());
		t1.start();
		t2.start();

	}
	
	private static class Thread1 implements Runnable{

		public void run() {
			synchronized (lock2) {
				System.out.println("holdig lock2");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("waiting for lock1");
				synchronized (lock1) {
					System.out.println("holding 2 and 1");
				}
			}}
		
	}
	private static class Thread2 implements Runnable{

		public void run() {
			synchronized (lock1) {
				System.out.println("holdig lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("waiting for lock2");
				synchronized (lock2) {
					System.out.println("holding 1 n 2");
				}
			}}
		
	}
	


}
