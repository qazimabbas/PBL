package Problem.PBL2;

import java.util.LinkedList;
import java.util.Stack;

public class States {
    String State;
    LinkedList<CropData> CD = new LinkedList<CropData>();
    Stack<CropCount> CC = new Stack<CropCount>();
    States(String s){
        this.State = s;
    }
    private void SortStack(){
        Stack<CropCount> temp = new Stack<CropCount>();
        while(!CC.isEmpty()){
            CropCount obj = CC.pop();
            while(!temp.isEmpty() && temp.peek().Count>obj.Count){
                CC.push(temp.pop());
            }
            temp.push(obj);
        }
        CC = temp;
    }
    public String PopularCrop(){
        this.SortStack();
        return "The State " +State+" is popular for : " +CC.getLast().CropName+" Crop, There are "+CC.getLast().Count+" "+CC.getLast().CropName+" Crops cultivated in this state.\n";
    }
    public void PrintCropData(){
        System.out.println("\n-------------------------------"+this.State+" State's Crop Data--------------------------");
        for(CropData c: this.CD){
            System.out.println(c);
        }
    }
    public void PrintCropCount(){
        System.out.println("\n-------------------------------"+this.State+" State's Crop Count--------------------------");
        this.SortStack();
        for(CropCount cc: this.CC){
            System.out.println(cc+"\n");
        }
    }
    


    
}
