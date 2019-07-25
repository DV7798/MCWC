
import java.util.*;

public class Min_Max {
    
    public static void min_max(ArrayList ar,int min,int max,int new_min,int new_max)
    {
        
        /*
        dataset(size:20) = 10 12 3 6 5 25 17 100 1000 98 11 27 78 33 9 18 23 44 690 200
        */
            int len=ar.size();
            ArrayList v=new ArrayList(len);
            
            float new_v=0;
            
            float d=max-min;
            float new_d=new_max-new_min;
            float div=new_d/d;
            
            for(int i=0;i<len;i++)
            {
                new_v=(float)(div*(float)((int)ar.get(i)-(float)min))+(float)new_min;
                //System.out.print(new_v+",");
                v.add(new_v);
            }

            System.out.println("DataSet after Min-Max Normalization is ");
        
            for(int i=0;i<len;i++)
            {
                System.out.println(ar.get(i)+" -> "+v.get(i));
            }    
        
    }
    
    public static void z_score(ArrayList ar,int v) {
        float vc;
        int sum=0;
        for(int i=0;i<ar.size();i++){
            sum+=(int)ar.get(i);
        }
        float abar=(float)sum/ar.size();
        //System.out.println(abar+" ladl")
        float sa=0;
        float sigA;
        for(int i=0;i<ar.size();i++){
            sa+=((int)ar.get(i)-abar)*((int)ar.get(i)-abar);
        }
        sigA=(float) Math.pow(sa/ar.size(), 0.5);
        vc=(v-abar)/sigA;
        System.out.println(v+" -> "+vc);
    }
    
    public static void decimal(ArrayList ar) {
        int j=Integer.toString((int)ar.get(ar.size()-1)).length();
        //System.out.println("l:"+j);
        double vc[]=new double[ar.size()];
        for(int i=0;i<ar.size();i++){
            vc[i]=(float)((int)ar.get(i))/(Math.pow(10,j+1));
            System.out.println(ar.get(i)+" -> "+vc[i]);
        }        
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the Length of the DataSet");
        int len=sc.nextInt();
        
        ArrayList ar=new ArrayList(len);
        
        int n,max=0,min=999;
        System.out.println("Enter the Values of the DataSet");
        for(int i=0;i<len;i++)
        {
            System.out.println("Enter the value "+(i+1)+" :");
            n=sc.nextInt();
            ar.add(n);
            if(max<n)
                max=n;
            if(min>n)
                min=n;
        }
        
        System.out.println("Enter the Range :");
        System.out.println("Min: ");
        int new_min=sc.nextInt();
        System.out.println("Max: ");
        int new_max=sc.nextInt();
        
        System.out.println("New min & max = "+new_min+","+new_max+"    min & max = "+min+","+max);
        
        min_max(ar,min,max,new_min,new_max);
        
        System.out.println("Z-Score Normalization is :");
        
        for(int i=0;i<len;i++)
        {
            z_score(ar,(int)ar.get(i));
        }
        
        System.out.println("Decimal Scaled Normaliztion is :");
        decimal(ar);
        
    }
    
}
