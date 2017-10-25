package utilsPckg;

public class MyMainCls {
	
	public static void main(String[] aaa)
	{
		/****************************************************
		 * This class is entry point of framework
		 ****************************************************/
		
		CreatingThreads startExec = new CreatingThreads();
		
		//Navigate to method who is responsible for creating threads
		startExec.startExecution();
	}
}
