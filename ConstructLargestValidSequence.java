package backtrack;

public class ConstructLargestValidSequence {

	 public static int[] constructDistancedSequence(int n)
	 {
		 int[] res = new int[2*n -1];
		 int count = 0;
	        boolean[] visited = new boolean[n + 1];
		 if(constructDistancedSequenceUtil(res,0,n,count,visited))
		 { 
			 for(int i=0;i<res.length;++i)
			 {
				 System.out.println(res[i]);
			 }
			 return res;		 
		 }
		 return null;
	 }
	
	private static boolean constructDistancedSequenceUtil(int[] res, int p, int n, int c,boolean[] visited) {
		// TODO Auto-generated method stub
		if(c==2*n-1)
			return true;
		
		for(int i=n;i>=1;--i)
		{
			if(i==1)
			{
				if(res[p]==0)
				{
					res[p]=i;
                    visited[i] = true;
					if(constructDistancedSequenceUtil(res, p+1, (n), c+1,visited))
					{
						return true;
					}
					else
					{
						res[p]=0;
					}
				}
			}
			if(isSafe(res,p,i,n,visited))
			{
				res[p]=i;	
				res[p+i]=i;
                visited[i] = true;
				if(constructDistancedSequenceUtil(res, p+1, n, c+2, visited))
				{
					return true;
				}
				else
				{
					res[p]=0;
					res[p+i]=0;
                    visited[i] = false;
				}
			}
			
		}
		return false;
	}

	private static boolean isSafe(int[] res, int pos, int val,int n,boolean[] visited) {
		// TODO Auto-generated method stub
		if(pos>=0 && pos<(2*n-1) && pos+val <(2*n-1) && !visited[val] && res[pos+val]==0)
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		constructDistancedSequence(3);

	}

}
