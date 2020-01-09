
package simulation2;
import java.util.Scanner;

public class Simulation2 {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
       
        int D[],n;
        float FQ[],prob[],CP[],from[],to[];
        D = new int[10];
        FQ = new float[10];
        prob= new float[10];
        CP= new float[10];
        from= new float[10];
        to =new float[10];
        
        
        
        
        System.out.println("Enter number of Demands\n");
        n=in.nextInt();
        System.out.println("\nEnter Demand        Frequency\n");
        
        int SF=0;
        for(int i=0 ; i<n ; i++)
        { 
            System.out.printf("[%d]:  \n",i+1);
            D[i]=in.nextInt();
            FQ[i]= in.nextFloat();
            SF+=FQ[i];
         
        }
        
       
        
        for(int i=0 ; i<n ; i++)
        {
           prob[i]=FQ[i]/SF;
  
        }
        
        
        CP[0]=prob[0];
        for(int i=1 ; i<n ; i++){
          
           {
            CP[i]= prob[i]+CP[i-1];
           }
        
        }
        
        from[0] =1;
        to[0] = CP[0]*100;
        for(int i=1 ; i<n ; i++){
            from[i]= (to[i-1])+1;
            to[i]= CP[i]*100;
         
      
        }
        
     
       System.out.println("\nDemand \t    Frequency \t  Probability \t   Cum Probability \tfrom \t        to\n");
       
      
        for(int i=0 ; i<n ; i++){
      
           System.out.printf("%4d \t      ",D[i]);
           System.out.printf("%2.2f \t ",FQ[i]);
           System.out.printf("%8.2f \t",prob[i]);
           System.out.printf("%12.2f \t\t",CP[i]);
           System.out.printf("%.2f \t\t",from[i]);
           System.out.printf("%.2f \n",to[i]);
           
          
       
      
      }
       
       
       
       
        int D2[],n2;
        float FQ2[],prob2[],CP2[],from2[],to2[];
        D2 = new int[10];
        FQ2 = new float[10];
        prob2= new float[10];
        CP2= new float[10];
        from2= new float[10];
        to2 =new float[10];
        
        
        System.out.println("\n\nEnter number of Lead times\n");
        n2=in.nextInt();
        System.out.println("\nEnter Lead Time        Frequency\n");
        
        int SF2=0;
        for(int i=0 ; i<n2 ; i++)
        { 
            System.out.printf("[%d]:  \n",i+1);
            D2[i]=in.nextInt();
            FQ2[i]= in.nextFloat();
            SF2+=FQ2[i];
         
        }
        
       
        
        for(int i=0 ; i<n2 ; i++)
        {
           prob2[i]=FQ2[i]/SF2;
  
        }
        
        
        CP2[0]=prob2[0];
        for(int i=1 ; i<n2 ; i++){
          
           {
            CP2[i]= prob2[i]+CP2[i-1];
           }
        
        }
        
        from2[0] =1;
        to2[0] = CP2[0]*100;
        for(int i=1 ; i<n2 ; i++){
            from2[i]= (to2[i-1])+1;
            to2[i]= CP2[i]*100;
         
      
        }
        
      
       System.out.println("\n\nLeadTime\tFrequency\tProbability \tCum Prob \tfrom \t    to\n");
    
       
       for(int i=0 ; i<n2 ; i++){
      
           System.out.printf("%4d \t\t",D2[i]);
           System.out.printf("  %.2f \t\t",FQ2[i]);
           System.out.printf("  %.2f \t",prob2[i]);
           System.out.printf("         %.2f \t",CP2[i]);
           System.out.printf("       %.2f \t",from2[i]);
           System.out.printf("%.2f \n",to2[i]);
           
          
       
      
      }
       
       int OQ,ROP,days;
       System.out.println("\n\nEnter Order Quantity and Reorderpoint\n");
       OQ=in.nextInt();
       ROP = in.nextInt();
       System.out.println("\nEnter the number of days for the simultaion\n");
       days=in.nextInt();
       int DRN[] = new int[days];
       int LTRN[] = new int[days];
       
       System.out.println("\n Enter Random number for Demand \n");
       
       for(int i=0 ; i<days ; i++)
      {
         DRN[i]= in.nextInt();
        
         
      }
       
        System.out.println("\n Enter Random number for lead time\n");
       
       for(int i=0 ; i<days ; i++)
      {
        
         LTRN[i]= in.nextInt();
         
      }
       
      float sOpen=0,OC=0,HC=0,LSC=0;
      System.out.println("\n Enter number of days the store is open in year \n");
       sOpen= in.nextFloat();
      
      System.out.println("\n Enter Order cost per order \n");
       OC=in.nextFloat();
       
        System.out.println("\n Enter holding cost per year \n");
        HC=in.nextFloat();
        
       float DHC=HC/sOpen;
        
        
        System.out.println("\n Enter lost sale cost per year \n");
          LSC=in.nextFloat();
          
          int BI[],EI[],DeFi[];
          BI= new int[days];
          EI= new int[days];
          DeFi= new int [days];
          
          
      
     for(int i=0 ; i<days ; i++)
     {
          
         for(int j=0 ; j<days ; j++)
        {
                    if(DRN[i] >= from[j] && DRN[i] <= to[j])
                       {
                         DeFi[i] = D[j];
                       }
       
        }
     }
          
         
     
       
       
      
       int RNA[]= new int[days];
       
       for(int i=0 ; i<days ; i++)
      {
          if(LTRN[i]!=0)
             {
               RNA[i]=LTRN[i];
               
             }
          
          else 
              RNA[i]=0;
        
      }
     
       
      
       
       
       
       
         int leadT[]= new int[days];
       for(int i=0 ; i<days ; i++){
          
           for(int j=0 ; j<days ; j++)
        {
           
        if(RNA[i]>= from2[j] && RNA[i]<=to2[j])
           {
           
            leadT[i]=D2[j];
           
           }
         
         
         
         }
       
       
       
      }
       
       
       int order[]= new int [days];
       
       for(int i=0 ; i<days ; i++){
          if(leadT[i]!=0){
          order[i]=1;
          }
           else
              order[i]=0;
       }
       
      
     
       
       int unitR[]= new int [days+5];
        
        unitR[0]=0;
      int x;
        for(int i =1 ; i<days ; i++){
          if(leadT[i]!=0){
            
              x=leadT[i];
              for(int z=x ; z>=0 ; z--)
              {
                   
                  unitR[i]=0;
                  i++;
              }
               unitR[i]=OQ;
          }
            
       else
           unitR[i]=0;
       
     }
       
       
      
      BI[0]=10;
       for(int i=1 ; i<=days-1 ; i++)
        {
          if(unitR[i]==0) {   
             BI[i]=BI[i-1]-DeFi[i-1];
          }
          
          else
              BI[i]=OQ;
          
        }
       
       EI[0]=BI[0]-DeFi[0];
       for(int i=1 ; i<=days-1 ; i++){
           
           if(BI[i]<=DeFi[i]){
               EI[i]=0;
           }
           
           
          else 
           EI[i]= BI[i]-DeFi[i];
       
       
       }
       
       
       
       int LS[]= new int[days];
       
       for(int i=0 ; i<days ; i++){
       
           if(DeFi[i]> BI[i] ){
             LS[i] = DeFi[i]-BI[i];
           
           }
         
           else 
               LS[i]=0;
       
       
       }
       
      
      
      
      System.out.println("\n\nDay \t     unit Rec \t      beg inv \t          RN \t         Demand \tEnding in \t  lostS \t order \t       ran \t   lead time \n");
       

         for(int i=0 ; i<days ; i++){
       int j=i+1;
      
       System.out.println("\n\n"+j+"\t\t  "+unitR[i]+"\t\t  "+ BI[i]+"\t\t    "+ DRN[i]+"\t\t     " + DeFi[i]+"\t\t   "+EI[i]+"\t\t  "+LS[i]+"\t\t  "+order[i]+"\t\t  "+RNA[i]+"\t\t  "+leadT[i]+"\n\n");
       
       
       }
         
       
         
         
         
         
         
      float EndI=0,LoS=0,NOP=0;
      for(int i=0 ; i<days ; i++){
      
          EndI+=EI[i];
      
      
      }
      
      
      for(int i=0 ; i<days ; i++){
      
          LoS+=LS[i];
      
      
      }
      
      
      for(int i=0 ; i<days ; i++){
      
          NOP+=order[i];
      
      
      }
         
         
         
         
         
      float AEI=EndI/days;
         System.out.printf("\n\nAverage Ending Inventory = %.2f \t", AEI);
         
         
         float ALoS=LoS/days;
         System.out.printf("\n\nAverage Lost Sales = %.2f \t", ALoS);
         
          float ANOP=NOP/days;
         System.out.printf("\n\nAverage Number of orders placed = %.2f  \t", ANOP);
         
         float Doc=ANOP*OC;
         System.out.printf("\n\nDaily Order Cost = %.2f  \t",Doc);
         
         
         
         
         float Dhc=AEI*DHC;
         System.out.printf("\n\nDaily Holding Cost = %.2f \t",Dhc);
         
         
       
          float Dsc=ALoS*LSC;
         System.out.printf("\n\nDaily Stockout Cost = %.2f \t",Dsc);
         
         float TC= Doc+Dhc+Dsc;
         
        
         System.out.printf("\n\nTotal Daily inventory Cost = %.2f \t",TC);
       
      
    }
    
}
