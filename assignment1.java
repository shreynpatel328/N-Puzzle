package Assignment;
import java.io.*;
import java.util.*;

public class assignment1 
{
	public static ArrayList<Integer> init = new ArrayList<Integer>(); 
	public static void main(String args[]) throws IOException
	{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("------  Enter the choice ------------");
		System.out.println();
		System.out.println("   1.  Uniform Cost Search");
		System.out.println("   2.  A* Search Misplaced Tiles");
		System.out.println("   3.  A* Search Manhatten Distance");
		System.out.println();
		
		int choiceOfAlgo = Integer.parseInt(br.readLine());
		
		System.out.println("------  Enter your choice for the test cases -------");
		System.out.println();
		System.out.println("    1. Default test cases");
		System.out.println("    2. Enter your own test case");
		System.out.println();
		
		int choiceOfTest = Integer.parseInt(br.readLine());
		
		switch(choiceOfAlgo)
		{
			case 1: if(choiceOfTest == 1)
					{
						System.out.println("Which test you want to run");
						int choice = Integer.parseInt(br.readLine());
						if(choice == 1)
						{
							int r=3,c=3;
							test1();
							String initState = convert2String(init, 3,3);
							getPosition.uniformCost(initState,r, c);
							break;
						}
						if(choice == 2)
						{
							int r=3,c=3;
							test2();
							String initState = convert2String(init, 3,3);
							getPosition.uniformCost(initState,r, c);
							break;
						}
						if(choice == 3)
						{
							int r=3,c=3;
							test3();
							String initState = convert2String(init, 3,3);
							getPosition.uniformCost(initState,r, c);
							break;
						}
						if(choice == 4)
						{
							int r=3,c=3;
							test6();
							String initState = convert2String(init, 3,3);
							getPosition.uniformCost(initState,r, c);
							break;
						}
					}
					if(choiceOfTest == 2)
					{
						System.out.println("enter the row dimension");
						int r = Integer.parseInt(br.readLine());
						System.out.println("Enter the column dimension");
						int c = Integer.parseInt(br.readLine());
						
						System.out.println("Enter the state");
						for(int i=0;i<r;i++)
						{
							for(int j=0;j<c;j++)
							{
								init.add(Integer.parseInt(br.readLine()));
							}
						}
						String initState = convert2String(init, r,c);
						getPosition.uniformCost(initState,r, c);
						break;
					}
					
			case 2: if(choiceOfTest == 1)
					{
						System.out.println("Which test you want to run");
						int choice = Integer.parseInt(br.readLine());
						if(choice == 1)
						{
							int r=3,c=3;
							test1();
							String initState = convert2String(init, 3,3);
							getPosition.aMisplace(initState,r, c);
							break;
						}
						if(choice == 2)
						{
							int r=3,c=3;
							test2();
							String initState = convert2String(init, 3,3);
							getPosition.aMisplace(initState,r, c);
							break;
						}
						if(choice == 3)
						{
							int r=3,c=3;
							test3();
							String initState = convert2String(init, 3,3);
							getPosition.aMisplace(initState,r, c);
							break;
						}
						if(choice == 4)
						{
							int r=3,c=3;
							test6();
							String initState = convert2String(init, 3,3);
							getPosition.aMisplace(initState,r, c);
							break;
						}
					}
					if(choiceOfTest == 2)
					{
						System.out.println("enter the row dimension");
						int r = Integer.parseInt(br.readLine());
						System.out.println("Enter the column dimension");
						int c = Integer.parseInt(br.readLine());
						
						System.out.println("Enter the state");
						for(int i=0;i<r;i++)
						{
							for(int j=0;j<c;j++)
							{
								init.add(Integer.parseInt(br.readLine()));
							}
						}
						String initState = convert2String(init, r,c);
						getPosition.aMisplace(initState,r, c);
						break;
					}
					
		
				case 3: if(choiceOfTest == 1)
					{
						System.out.println("Which test you want to run");
						int choice = Integer.parseInt(br.readLine());
						if(choice == 1)
						{
							int r=3,c=3;
							test1();
							String initState = convert2String(init, 3,3);
							getPosition.aManhat(initState, r, c);
							break;
						}
						if(choice == 2)
						{
							int r=3,c=3;
							test2();
							String initState = convert2String(init, 3,3);
							getPosition.aManhat(initState, r, c);
							break;
						}
						if(choice == 3)
						{
							int r=3,c=3;
							test3();
							String initState = convert2String(init, 3,3);
							getPosition.aManhat(initState, r, c);
							break;
						}
						if(choice == 4)
						{
							int r=3,c=3;
							test6();
							String initState = convert2String(init, 3,3);
							getPosition.aManhat(initState, r, c);
							break;
						}
					}
					if(choiceOfTest == 2)
					{
						System.out.println("enter the row dimension");
						int r = Integer.parseInt(br.readLine());
						System.out.println("Enter the column dimension");
						int c = Integer.parseInt(br.readLine());
						
						System.out.println("Enter the state");
						for(int i=0;i<r;i++)
						{
							for(int j=0;j<c;j++)
							{
								init.add(Integer.parseInt(br.readLine()));
							}
						}
						String initState = convert2String(init, r,c);
						getPosition.aManhat(initState, r, c);
						break;
						
					}
					
				default: System.out.println("Sorry Wrong Input");	
			}
		
	}
	
	public static String convert2String(ArrayList init, int r, int c)
	{
		String initState="";
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				initState += init.get(c*i+j); 
			}
			
		}
		
		return initState;
	}
	
	public static void test1()
	{
		init.add(1);
		init.add(2);
		init.add(3);
		init.add(4);
		init.add(5);
		init.add(6);
		init.add(7);
		init.add(0);
		init.add(8);
	}
	public static void test2()
	{
		init.add(1);
		init.add(2);
		init.add(0);
		init.add(4);
		init.add(5);
		init.add(3);
		init.add(7);
		init.add(8);
		init.add(6);
	}
	public static  void test3()
	{
		init.add(0);
		init.add(1);
		init.add(2);
		init.add(4);
		init.add(5);
		init.add(3);
		init.add(7);	
		init.add(8);
		init.add(6);
	}
	public static void test4()
	{
		init.add(8);
		init.add(7);
		init.add(1);
		init.add(6);
		init.add(0);
		init.add(2);
		init.add(5);
		init.add(4);
		init.add(3);
	}
	
	public static void test6()
	{
		init.add(1);
		init.add(2);
		init.add(3);
		init.add(4);
		init.add(0);
		init.add(6);
		init.add(7);
		init.add(5);
		init.add(8);
	}
}
