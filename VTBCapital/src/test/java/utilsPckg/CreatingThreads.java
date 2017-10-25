package utilsPckg;

import testCasePckg.Controller;

public class CreatingThreads {

	public CreatingThreads(){
		//Before starting we are defining or telling on which browser which ip port will work
		// as 'ipBrowserConfig()' method is static hence we are calling direct by class name.
		UtillityClass UtilObj = new UtillityClass();
		UtilObj.ipBrowserConfig();
	}
	
	public void startExecution(){
		// Only three threads has been created, as we have only IE, FF and GC requirement
		// They are static
		ImplementsRunnable1 rc1 = new ImplementsRunnable1();
		Thread t1 = new Thread(rc1, "1");
		t1.start();
		
		ImplementsRunnable2 rc2 = new ImplementsRunnable2();
		Thread t2 = new Thread(rc2,"2");
		t2.start();
		
		ImplementsRunnable3 rc3 = new ImplementsRunnable3();
		Thread t3 = new Thread(rc3,"3");
		t3.start();
		
		ImplementsRunnableAndroid rc4 = new ImplementsRunnableAndroid();
		Thread t4 = new Thread(rc4,"4");
		t4.start();
	}
}


class ImplementsRunnable1 implements Runnable {

	public void run(){
		try{
			Controller obj1 = new Controller();
			Thread.sleep(2000);
			System.out.println("Thread Name: -"+Thread.currentThread().getName());
			obj1.getDriver(Thread.currentThread().getName());
			obj1.controllerMethod();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

class ImplementsRunnable2 implements Runnable {

	public void run(){
		try{
			Controller obj1 = new Controller();
			Thread.sleep(2000);
			System.out.println("Thread Name: -"+Thread.currentThread().getName());
			obj1.getDriver(Thread.currentThread().getName());
			obj1.controllerMethod();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

class ImplementsRunnable3 implements Runnable {
	
	public void run(){
		try{
			Controller obj1 = new Controller();
			Thread.sleep(2000);
			System.out.println("Thread Name: -"+Thread.currentThread().getName());
			obj1.getDriver(Thread.currentThread().getName());
			obj1.controllerMethod();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}


class ImplementsRunnableAndroid implements Runnable {
	
	public void run(){
		try{
			Controller obj1 = new Controller();
			Thread.sleep(2000);
			System.out.println("Thread Name: -"+Thread.currentThread().getName());
			obj1.getDriver(Thread.currentThread().getName());
			obj1.controllerMethod();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}