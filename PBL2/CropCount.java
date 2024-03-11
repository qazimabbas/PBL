package Problem.PBL2;


public class CropCount {
    String CropName;
    int Count;
    CropCount(String cn){
        this.CropName = cn;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("There are "+this.Count+" "+CropName+" Crops.");
        return sb.toString();
    }
    
}
