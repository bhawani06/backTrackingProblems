package backtrack;

public class BeautifulArrangement {
    static int res =0;
    public static int countArrangement(int n) {
        
        boolean[] vis=new boolean[n+1];
        countArrangementUtil(n,1,vis);
        return res;
    }
     public static  void countArrangementUtil(int n,int pos, boolean vis[])
     {
         if(pos>n) 
         {
        	 
             ++res;
         }
         
         for(int i =1;i<=n;++i)
         {
             if(isSafe(pos,i,vis))
             {
                 vis[i]=true;
                 countArrangementUtil(n,pos+1,vis);
                 vis[i]=false;
             }
         }
     
     }
    public static boolean isSafe(int pos,int val, boolean[]vis)
    {
        if( (pos%val==0 || val%pos==0) &&vis[val]== false)
            return true;
        else
            return false;
    }
	public static void main(String[] args) {
		System.out.println(countArrangement(5));
	}

}
