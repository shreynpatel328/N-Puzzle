package Assignment;

public class miscFunc 
{
	public static int misplcasedTile(String a, String b)
	{
		int index=0;
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i) != b.charAt(i))
			{
				index++;
			}			
		}	
		return index;
		
	}
	
	public static int manhat(String a, String b, int r, int c )
	{
		int sum=0;
		int x1=0;
		int x2=0;
		int y1=0;
		int y2=0;
		for(int i=0;i<a.length();i++)
		{
			if(!(a.charAt(i) == b.charAt(i)))
			{
				for(int j=0;j<b.length();j++)
				{
					if(a.charAt(i) == b.charAt(j))
					{
						x1 = i/r;
						y1 = i%c;
						x2 = j/r;
						y2 = j%c;
						sum += Math.abs((x2-x1))+ Math.abs((y2-y1));
					}
				}
			}
		}
		
		return sum;
		
	}
	
	public static String swapRight(String s, int pos1, int pos2)
	{
		String temp="";

		if(pos1 < s.length() && pos2<s.length())
		{
			for(int i=0;i<pos1;i++)
			{
				temp += s.charAt(i);
			}
			
			temp +=s.charAt(pos2);
			temp +=s.charAt(pos1);
			
			for(int i=pos2+1;i<s.length();i++)
			{
				temp += s.charAt(i);
			}
			
			s=temp;
			
		}
		else
		{
			System.out.println("Somehting wrong in the position in right swap - Misc Function");
		}
		
		return s;
		
	}
	
	public static String swapLeft(String s, int pos1, int pos2)
	{
		String temp="";

		if(pos1 < s.length() && pos2<s.length())
		{
			for(int i=0;i<pos2;i++)
			{
				temp += s.charAt(i);
			}
			
			temp +=s.charAt(pos1);
			temp +=s.charAt(pos2);
			
			for(int i=pos1+1;i<s.length();i++)
			{
				temp += s.charAt(i);
			}
			
			s=temp;
			
		}
		else
		{
			System.out.println("Somehting wrong in the position in lefts swap - Misc Function");
		}
		
		return s;
		
	}
	
	public static String swapUp(String s, int pos1, int pos2)
	{
		String temp="";

		if(pos1 < s.length() && pos2<s.length())
		{
			for(int i=0;i<pos2;i++)
			{
				temp += s.charAt(i);
			}
			
			temp +=s.charAt(pos1);
			
			
			for(int i=pos2+1;i<pos1;i++)
			{
				temp += s.charAt(i);
			}
			temp +=s.charAt(pos2);
			
			for(int i=pos1+1;i<s.length();i++)
			{
				temp += s.charAt(i);
			}
			s=temp;
			
		}
		else
		{
			System.out.println("Somehting wrong in the position in up swap - Misc Function");
		}
		
		return s;
		
	}
	
	public static String swapDown(String s, int pos1, int pos2)
	{
		String temp="";

		if(pos1 < s.length() && pos2<s.length())
		{
			for(int i=0;i<pos1;i++)
			{
				temp += s.charAt(i);
			}
			
			temp +=s.charAt(pos2);
			
			
			for(int i=pos1+1;i<pos2;i++)
			{
				temp += s.charAt(i);
			}
			temp +=s.charAt(pos1);
			
			for(int i=pos2+1;i<s.length();i++)
			{
				temp += s.charAt(i);
			}
			s=temp;
			
		}
		else
		{
			System.out.println("Somehting wrong in the position in up swap - Misc Function");
		}
		
		return s;
		
	}
}
