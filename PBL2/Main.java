package Problem.PBL2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;


public class Main {

    public static void main(String[] args) {
        String StateName;
        String DistrictName;
        String CropName;
        int CropYear;
        CropData CData;
        LinkedList<States> StatesContainer = new LinkedList<>();
        
        String read = "";
        try{
            BufferedReader BR = new BufferedReader(new FileReader("C:/Users/PC/Documents/Semester3/Problem/PBL2/crop_production.csv"));
            BR.readLine();
            while((read=BR.readLine())!=null){
                String[] data = read.split(",");
                StateName = data[0].trim();
                DistrictName = data[1].trim();
                CropName = data[4].trim();
                CropYear = Integer.valueOf(data[2].trim());
                CData = new CropData(StateName, DistrictName, CropName, CropYear);
                States obj  = getState(StateName, StatesContainer);
                CropCount Crop = getCropCount(obj, CropName);
                Crop.Count++;
                obj.CD.add(CData);
            }
        }catch(Exception e){
            e.fillInStackTrace();
        }
        linkedQueue lq = new linkedQueue();
        lq.PlaceCropData(getState("Andaman and Nicobar Islands", StatesContainer));
        lq.printFifo();
        lq.PopularCrop(2006);
        lq.OldestCrop();
        lq.RecentCrop();
        System.out.println(lq.size());
        // //Question 2:- Which state is popular for which type of crop
        // System.out.println(getState("Arunachal Pradesh", StatesContainer).PopularCrop());
        // //Misc 1:- Printing particular State's Cropdata
        // getState("Andaman and Nicobar Islands", StatesContainer).PrintCropData();
        // //Misc 2:- Printing particular State's each Crop's count
        // getState("West Bengal", StatesContainer).PrintCropCount();
        
    }

    private static States getState(String Sname,LinkedList<States> container) {
            for(States s:container){
                if(s.State.equalsIgnoreCase(Sname)){
                    return s;
                }
            }
            States q = new States(Sname.trim());
            container.add(q);
            return q;
    }
    private static CropCount getCropCount(States s,String crop){
            for(CropCount cc: s.CC){
                if(cc.CropName.equalsIgnoreCase(crop))
                return cc;  
            }
            CropCount CropObj = new CropCount(crop);
            s.CC.push(CropObj);
            return CropObj;
    }
    
    
}
