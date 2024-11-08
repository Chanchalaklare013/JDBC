//Find the first largest number
public class Sort 
{
    
    public static void main(String[] args)
    {
        int ar[]={2,3,4,7,6,8};
        for(int i=0;i<ar.length;i++)
        {
            for(int j=i+1;j<ar.length;j++)
            {
                if(ar[i]<ar[j])
                {
                    int temp=ar[i];
                    ar[i]=ar[j];
                    ar[j]=temp;
                }
            }
           // System.out.println(ar[i]);
        }
        System.out.println(ar[0]);
    }
    
}
