package Problem.PBL2;

public class CropData {
    String SName;
    String District;
    String Cname;
    int Cyear;
    CropData(String s,String d,String c,int y){
        this.SName = s;
        this.District = d;
        this.Cname = c;
        this.Cyear = y;
    }
    public String StateName(){
        return this.SName;
    }
    public String DistrictName(){
        return this.District;
    }
    public String CropName(){
        return this.Cname;
    }
    public int CropYear(){
        return this.Cyear;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("StateName : "+SName+" District : "+District+" CropName : "+Cname+" CropYear : "+Cyear);
        return sb.toString();
    }

    
}
