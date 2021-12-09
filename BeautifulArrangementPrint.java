package backtrack;

public class BeautifulArrangementPrint {
	static int res =0;
    public static int countArrangement(int n) {
        
        int[] perm=new int[n+1];
        countArrangementUtil(perm,n,1,1);
        return res;
    }
     public static void countArrangementUtil(int[] perm, int n,int pos, int v)
     {
         if(pos>n) 
         {
             for(int j=0;j<perm.length;++j)
             {
            	 System.out.print(perm[j]+",");
             }
             System.out.println();
             ++res;
         }
         
         for(int i =1;i<=n;++i)
         {
             if(isSafe(perm,pos,i))
             {
                 perm[pos]=i;
                 countArrangementUtil(perm,n,pos+1,i+1);
                 perm[pos]=0;
             }
         }
     
     }
    public static boolean isSafe(int perm[],int pos,int val)
    {
        for(int j=0;j<perm.length;++j)
        {
            if(perm[j]==val)
                return false;
        }
        if(pos<perm.length && perm[pos]==0 && 
          (pos%val==0 || val%pos==0))
            return true;
        else
            return false;
    }
    

	public static void main(String[] args) {
		System.out.println(countArrangement(5));
	}

}
