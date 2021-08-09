import java.util.Scanner;

object Harvest{


	def main (args:Array [String]):Unit={
		
		var weeks_per_month=4
		var days_per_week=7
		val harvest_table=Array.ofDim[Float](weeks_per_month,days_per_week)

		var max:Float=0
		var min:Float=0
    		var range : Float=0
    		var average : Float=0
    		var medium : Float=0
    		var total : Float=0
	
		//Store harvest data according to month

		for( x <- 0 to weeks_per_month-1 ){
      
        		for(y <- 0 to days_per_week-1 ){
            			print("Enter Haravest amount for\tweek-"+ (x+1) + " day- "+ (y+1) +" ")
             			var amount=scala.io.StdIn.readInt()
            			harvest_table(x)(y)=amount;
            			total=total+amount
          
        		}
    		}
		
		println("---------------------------------------------------------")

		//display harvest table
		
		println("\t\tday 01\tday 02\tday 03\tday 04\tday 05\tday 06\tday 07\ttotal")
		for( x <- 0 to weeks_per_month-1 ){
      			print("week "+(x+1)+"\t\t")
			var per_week_tot:Float=0;
        		for(y <- 0 to days_per_week-1 ){
            			print(harvest_table(x)(y)+"\t")
				per_week_tot=per_week_tot+harvest_table(x)(y)
        		}
			print(per_week_tot+"\n")
    		}

		//total

		println("---------------------------------------------------------")
		
		println("Total amount : "+total)

		//Average 
		
		println("---------------------------------------------------------")
		
		average=total/28

		println("Average : "+average)
		
		//sort all harvest data

		var sorted_table= new Array[Float](28)
    
    		var i=0
    		for(x<- 0 to weeks_per_month-1 ){
      
        		for(y<- 0 to days_per_week-1){
          			sorted_table(i)=harvest_table(x)(y)
          			i=i+1
        		}
        
    		}
    
    		var temp : Float=0
    		for(j<- 0 to 27){
        
        		for(k<- (0+j) to 27){
          			if(sorted_table(j)>sorted_table(k)){
            				temp=sorted_table(k)
            				sorted_table(k)=sorted_table(j)
            				sorted_table(j)=temp
         	 		}
      			} 
    		}


		//get min
		
		println("---------------------------------------------------------")
		
		min=sorted_table(0)

		println("Min : "+min)

		for( x <- 0 to weeks_per_month-1 ){
      
        		for(y <- 0 to days_per_week-1 ){
            			
				if(harvest_table(x)(y)==min){
					println("week-"+(x+1)+" day-"+(y+1))
				}
          
        		}
    		}
		
		//get max
		
		println("---------------------------------------------------------")
		
		max=sorted_table(27)

		println("Max : "+max)

		for( x <- 0 to weeks_per_month-1 ){
      
        		for(y <- 0 to days_per_week-1 ){
            			
				if(harvest_table(x)(y)==max){
					println("week-"+(x+1)+" day-"+(y+1))
				}
          
        		}
    		}

		//get range
		
		println("---------------------------------------------------------")
		
		range=max-min

		println("Range : "+range)

		//get medium
		
		println("---------------------------------------------------------")
		
		medium=(sorted_table(13)+sorted_table(14))/2

		println("Medium : "+medium)

	}
}