//Sample Input
// 13 15 16 16 19 20 20 21 22 22 25 25 25 25 30 33 33 35 5 35 35 36 40 45 46 52 70
import java.util.Arrays;
import java.util.Scanner;


public class Binning {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        String s=sc.nextLine();
//        String value[]=s.split(" ");
//
//        int len=value.length;
        System.out.println("Enter the Length of the DataSet :");
        int len=sc.nextInt(); 
        System.out.println("Enter the Values of the DataSet :");
        
        int vi[]=new int[len];
        for(int i=0;i<len;i++){
            vi[i]=sc.nextInt();
        }
//        Arrays.sort(vi);
        //System.out.println(len);
        //int n=len;
         System.out.println("Enter Bin Size :");
        int d=sc.nextInt();
        float p=(float)len/d;                                       
        //System.out.println(p);
        if(p-(int)p>0&&p-(int)p<1){
            p=len/d+1;
            //System.out.println(p);
        }
        int m=(int) p;
        //System.out.println(m);
        int a[][]=new int[m][d];
        int i=0,c=0;
        for(int j=0;j<m;j++){
            if(j==m-1){
                a[j]=new int[len-c];
            }
            for(int k=0;k<d&&c<len;k++){
                a[j][k]=vi[i];
                i++;
                c++;
            }
        }
        c=0;
        int ll=0;
        double avg[]=new double[m];
        int median[]=new int[m];
        for(int j=0;j<m;j++){
            for(int k=0;k<d&&c<len;k++){
                //System.out.print(a[j][k]+" ");
                avg[j]+=a[j][k];
                if(j!=m-1){
                ll++;}
                c++;
            }
            if(j==m-1){
                 avg[j]=Math.floor(((float)avg[j]/(len-ll)));   
            }
            else{
            avg[j]=Math.floor((float)avg[j]/d);
            }
            //System.out.println("");
        }
         System.out.println("Smoothing by Bin Mean");
         c=0;
        for(int k=0;k<m;k++){
            for(int j=0;j<d&&c<len;j++){
            System.out.print((int)avg[k]+" ");
            c++;
            }
            System.out.println("");
        }
        c=0;
         System.out.println("Smoothing by Bin Median");
         int even=d;
        for(int k=0;k<m;k++){
            for(int j=0;j<d&&c<len;j++){
            if(k==m-1){
                even=a[k].length;
            }
            if(even%2==0){
                int term=(d/2+1)/2;
                median[k]=a[k][term-1];
            }
            else{
                int term=(d+1)/2;
                median[k]=a[k][term-1];
            }
            System.out.print(median[k]+" ");
            c++;
            }
            System.out.println("");
        }
        c=0;
         System.out.println("Smoothing by Bin Boundaries");
        for(int j=0;j<m;j++){
            for(int q=0;q<d&&c<len;q++){
                if((a[j][q]-a[j][0])<=(a[j][a[j].length-1]-a[j][q])){
                    a[j][q]=a[j][0];
                    System.out.print(a[j][q]+" ");
                }
                else{
                    a[j][q]=a[j][a[j].length-1];
                    System.out.print(a[j][q]+" ");
                }
                c++;
            }
            System.out.println("");
        }    
    }
    
}
