// this class is to get the position of 0 to define the operators

package Assignment;


import java.util.*;

public class getPosition 
{
	
	public static void uniformCost(String original, int rows, int column)
	{
		int col = column;
		int row = rows;
		System.out.println(original);
		
		String s="";
		String goal = "123456780";
		Queue<String> que =new LinkedList();
		HashMap<String, Integer> hset = new HashMap<String, Integer>();
		que.add(original);
		hset.put(original,0);
		int count=0;
		int maxCount=1;
		while(!que.isEmpty())
		{
			String parent = que.remove();
			System.out.println("Expanding children");
			
			displaymatrix(parent, hset.get(parent));
			if(parent.equalsIgnoreCase(goal))
				break;
			
		//	System.out.println("parent is "+parent);
		//	System.out.println("level of parent is "+hset.get(parent));
			int index = position(parent);
		//	System.out.println("index  "+index);
			//System.out.println(parent);
			maxCount--;
			
			s = right(parent, index, row ,col);
			if(!(s.equalsIgnoreCase(parent)))
			{
				if(!(hset.containsKey(s)))
				{
					//System.out.println("output right  "+s);
					que.add(s);
					displaymatrix(s, hset.get(parent)+1);
					hset.put(s,hset.get(parent)+1);
					maxCount++;
				}
			}
			
			s = left(parent, index, row ,col);
			if(!(s.equalsIgnoreCase(parent)) )
			{
				if(!(hset.containsKey(s)))
				{
					//System.out.println("output right  "+s);
					que.add(s);
					displaymatrix(s, hset.get(parent)+1);
					hset.put(s,hset.get(parent)+1);
					maxCount++;
				}
			}
			
			s = down(parent, index, row ,col);
	
			if(!(s.equalsIgnoreCase(parent)))
			{
				if(!(hset.containsKey(s)))
				{
					//System.out.println("output right  "+s);
					que.add(s);
					displaymatrix(s, hset.get(parent)+1);
					hset.put(s,hset.get(parent)+1);
					maxCount++;
				}
			}
			s = up(parent, index, row ,col);
			
			if(!(s.equalsIgnoreCase(parent)) && !(hset.containsKey(s)))
			{

					//System.out.println("output right  "+s);
					que.add(s);
					displaymatrix(s, hset.get(parent)+1);
					hset.put(s,hset.get(parent)+1);
					maxCount++;

			}
			count++;

		}
		
		System.out.println("Number of nodes expanded "+ count);
		System.out.println("Max count  "+maxCount);
		System.out.println("Max level  "+hset.get(goal));
	}
	
	public static void aManhat(String original, int rows, int column)
	{
		int col = column;
		int row = rows;
		int gn= 0;
		int maxCount=1;
		int count=0;
		
		//System.out.println(original);
		
		String s="";
		String goal = "123456780";
		String parent="";
		
		HashMap<String, Integer> tmap = new HashMap<String, Integer>();
		HashMap<String, Integer> tmapValue = new HashMap<String, Integer>();
		HashMap<String, Integer> tmapValuehn = new HashMap<String, Integer>();
		
		int hn = miscFunc.manhat(original, goal, row, col);
		//System.out.println("the manhatten distance  "+hn);
		tmap.put(original,gn+hn);
		tmapValue.put(original,gn);
		tmapValuehn.put(original,hn);
		
		while(true)
		{
			
			tmap = sortByValues(tmap);
			Set set2 = tmap.entrySet();
		    Iterator iterator2 = set2.iterator();	     
	        Map.Entry me2 = (Map.Entry)iterator2.next();
	        
		    parent = (String) me2.getKey();
		    //System.out.println("Parent is "+parent);
			gn = tmapValue.get(parent); 
			System.out.println("Expanding children");
			displaymatrix(parent, gn);
			
		//	System.out.println("no of misoplaced tile "+gn);
			if(parent.equalsIgnoreCase(goal))
				break;
			
			int fn = (int) me2.getValue();
		    
			
			int index = position(parent);
			//System.out.println("index  "+index);
			//System.out.println(parent);
			//maxCount--;
			
			s = right(parent, index, row ,col);
			if(!(s.equalsIgnoreCase(parent)))
			{	
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.manhat(s, goal, row, col);
				//	displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					tmapValuehn.put(s,hn);
					maxCount++;
				}
				

			}
			
			s = left(parent, index, row ,col);
			if(!(s.equalsIgnoreCase(parent)) )
			{
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.manhat(s, goal, row, col);
				//	displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					tmapValuehn.put(s,hn);
					maxCount++;
				}
			}
			
			s = down(parent, index, row ,col);
	
			if(!(s.equalsIgnoreCase(parent)))
			{
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.manhat(s, goal, row, col);
				//	displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					tmapValuehn.put(s,hn);
					maxCount++;
				}
			}
			s = up(parent, index, row ,col);
			
			if(!(s.equalsIgnoreCase(parent)))
			{
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.manhat(s, goal, row, col);
				//	displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					tmapValuehn.put(s,hn);
					maxCount++;
				}
			}
			tmap.remove(parent);
			tmapValue.remove(parent);
			maxCount--;
			
			count++;
		}
		
		System.out.println();

		System.out.println("the number of nodes Expanded "+ (count));
		System.out.println("the max size of the queue "+(maxCount));
		System.out.println("the level at which the solution was discovered "+ gn);
	}
	
	public static void aMisplace(String original, int rows, int column)
	{
		int col = column;
		int row = rows;
		int gn= 0;
		int maxCount=1;
		int count=0;
		
		//System.out.println(original);
		
		String s="";
		String goal = "123456780";
		String parent="";
		
		HashMap<String, Integer> tmap = new HashMap<String, Integer>();
		HashMap<String, Integer> tmapValue = new HashMap<String, Integer>();
		
		int hn = miscFunc.misplcasedTile(original, goal);
		
		tmap.put(original,gn+hn);
		tmapValue.put(original,gn);
		while(true)
		{
			
			tmap = sortByValues(tmap);
			Set set2 = tmap.entrySet();
		    Iterator iterator2 = set2.iterator();	     
	        Map.Entry me2 = (Map.Entry)iterator2.next();
	        
		    parent = (String) me2.getKey();
			//System.out.println("Parent is "+parent);
			//System.out.println("no of misoplaced tile "+hn);
			gn = tmapValue.get(parent); 
			int fn = (int) me2.getValue();
			System.out.println("Expanding children");
			displaymatrix(parent, gn);
			if(parent.equalsIgnoreCase(goal))
				break;
			
			
		    
			
			int index = position(parent);
			//System.out.println("index  "+index);
			//System.out.println(parent);
			maxCount--;
			
			s = right(parent, index, row ,col);
			if(!(s.equalsIgnoreCase(parent)))
			{	
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.misplcasedTile(s, goal);
					//displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					maxCount++;
				}
			}
			
			s = left(parent, index, row ,col);
			if(!(s.equalsIgnoreCase(parent)) )
			{
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.misplcasedTile(s, goal);
					//displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					maxCount++;
				}
			}
			
			s = down(parent, index, row ,col);
	
			if(!(s.equalsIgnoreCase(parent)))
			{
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.misplcasedTile(s, goal);
					//displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					maxCount++;
				}
			}
			s = up(parent, index, row ,col);
			
			if(!(s.equalsIgnoreCase(parent)))
			{
				if(!tmap.containsKey(s))
				{
					hn = miscFunc.misplcasedTile(s, goal);
					//displaymatrix(s, gn+1);
					tmap.put(s, hn+(gn+1));
					tmapValue.put(s, gn+1);
					maxCount++;
				}
			}
			tmap.remove(parent);
			tmapValue.remove(parent);

			count++;
		}
		
		System.out.println();
		
		System.out.println();System.out.println();
		Set set2 = tmapValue.entrySet();
	    Iterator iterator2 = set2.iterator();	     
        Map.Entry me2 = (Map.Entry)iterator2.next();
		System.out.println("the number of nodes Expanded "+ (count));
		System.out.println("the max size of the queue "+maxCount);
		System.out.println("the level at which the solution was discovered "+ gn);
	}
	
	private static HashMap sortByValues(HashMap map) 
	{ 
	       LinkedList list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() 
	       {
	            public int compare(Object o1, Object o2) 
	            {
	               return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) 
	       {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
	
	public static void displayMisplaced(HashMap hmap)
	{
		Set set2 = hmap.entrySet();
	      Iterator iterator2 = set2.iterator();
	      while(iterator2.hasNext()) {
	           Map.Entry me2 = (Map.Entry)iterator2.next();
	           System.out.print(me2.getKey() + ": ");
	           System.out.println(me2.getValue());
	      }
	}
	public static void display(Queue que)
	{
		for(int i=0;i<que.size();i++)
		{
			String n =(String) que.remove();
			System.out.println(n);
			que.add(n);
		}
	}
	
	public static int position(String s)
	{
		int pos=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == '0')
			 pos = i;
		}		
		return pos;
	}
	
	public static String right(String s, int pos, int r, int c)
	{
		String newS="";
		for(int i=0;i<c;i++)
		if((c*i)+(r-1)== pos)
			return s;
	
	    newS=miscFunc.swapRight(s, pos,++pos);
		return newS;	
	}
	
	public static String left(String s, int pos, int r, int c)
	{
		String newS="";
		for(int i=0;i<r;i++)
		if((c*i)== pos)
			return s;
	
	    newS=miscFunc.swapLeft(s, pos,--pos);
		return newS;	
	}
	public static String up(String s, int pos, int r, int c )
	{
		String newS="";
		for(int i=0;i<r;i++)
		if(((c*0)+i)== pos)
			return s;
	
	    newS=miscFunc.swapUp(s, pos,pos-c);
		return newS;	
	}
	public static String down(String s, int pos, int r, int c )
	{
		String newS="";
		for(int i=0;i<r;i++)
		if(((c*(r-1))+i)== pos)
			return s;
	
	    newS=miscFunc.swapDown(s, pos,pos+c);
		return newS;	
	}
	public static void displaymatrix(String s, int a)
	{
		System.out.println("-------------");
		for(int i=1;i<=s.length();i++)
		{
			if(i%3==0)
			{
				System.out.println("| "+s.charAt(i-1)+" |");
				System.out.print("|---|---|---|");
				System.out.println();
			}
			else
			{
				System.out.print("| "+s.charAt(i-1)+" ");
			}
			
		}
		System.out.println();
		System.out.println("Level "+ a );
		System.out.println();
	}
	
}
