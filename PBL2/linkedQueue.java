package Problem.PBL2;

import java.util.LinkedList;

public class linkedQueue {
    private Node head = new Node(null);
    private int size;
    private static class Node{
        Object CropYear;
        LinkedList<CropData> Cdata = new LinkedList<>() ;
        LinkedList<CropCount> Ccount = new LinkedList<>();
        Node next = this;
        Node prev = this;
        Node(Object y){
            this.CropYear = y;
        }
        Node(Object y,Node next,Node prev){
            this.CropYear = y;
            this.next = next;
            this.prev = prev;
        }
      
    }
    public void PlaceCropData(States s){
        Node p;
        CropCount Count;
        for(CropData c: s.CD){
            p = containsYear(c.Cyear);
            p.Cdata.add(c);
            Count = ContainsCrop(p.Ccount,c.Cname);
            Count.Count++;    
    }
}
    public void RecentCrop(){
        if(this.isEmpty()){
            System.out.println("Insert the State's data first!");
            return;
        }
        Node p = this.head.next;
        int recentYear = (int)p.CropYear;
        while(p!=head){
             if((int)p.CropYear>recentYear){
                recentYear = (int)p.CropYear;
             }
             p=p.next;
        }
        p = this.head.next;
        while(p!=head){
            if((int)p.CropYear==recentYear){
               System.out.println("The recent crop for the current State is "+p.Cdata.getLast().Cname);
               return;
            }
            p=p.next;
        }
    }
    public void OldestCrop(){
        if(this.isEmpty()){
            System.out.println("Insert the State's data first!");
            return;
        }
        Node p = this.head.next;
        int OldestYear = (int)p.CropYear;
        while(p!=head){
             if((int)p.CropYear<OldestYear){
                OldestYear = (int)p.CropYear;
             }
             p=p.next;
        }
        p = this.head.next;
        System.out.println(OldestYear);
        while(p!=head){
            if((int)p.CropYear==OldestYear){
               System.out.println("The Oldest Crop for the current State is "+p.Cdata.getFirst().Cname);
               return;
            }
            p=p.next;
        }
    }
    public void PopularCrop(int y){
        if(this.isEmpty()){
            System.out.println("Insert the data first!");
            return;
        }
        Node p = this.head.next;
        while(p!=head){
            if((int)p.CropYear==y){
                System.out.println(CalculatePopular(p).CropName+" is the popular crop of year "+p.CropYear+" for the current state, There are "+CalculatePopular(p).Count+" of these crops.");
                return;
            }
            p=p.next;
        }
        System.out.println("There's no data of year "+y+" for the current State");
    }
    private CropCount CalculatePopular(Node p){
        CropCount pop = p.Ccount.peek();
        for(CropCount c:p.Ccount){
            if(c.Count>pop.Count){
                pop = c;
            }
        }
        return pop;
        
    }
    private Node containsYear(int y){
        if(this.isEmpty()){
            this.head.prev.next = new Node(y,head,head.prev);
            head.prev = head.prev.next;
            this.size++;
            return this.head.next;
        }
        Node p = this.head.next;
        while(p!=head){
            if((int)p.CropYear==y){
                return p;
            }
            p=p.next;
        }
        p.prev.next = new Node(y,p,p.prev);
        p.prev = p.prev.next;
        this.size++;
        return p.prev.next;
    }
    public CropCount ContainsCrop(LinkedList<CropCount> cc,String Cname){
        for(CropCount count:cc){
            if(count.CropName.equalsIgnoreCase(Cname)){
                return count;
            }
        }
        CropCount count = new CropCount(Cname);
        cc.add(count);
        return count;
    }
    
    public void add(Object obj){
        this.head.prev.next = new Node(obj,head,head.prev);
        head.prev = head.prev.next;
        size++;
    }
    // public void addAtFirst(Object ele){
    //     this.head.next = new Node(ele,head.next,head);
    //     head.next.next.prev = head.next;
    //     size++;
    // }
    
    // public Object first(){
    //     if(this.size==0){
    //         throw new IllegalStateException();
    //     }
    //     return head.next.CropYear;
    // }
    public Object remove(){
        if(this.size==0){
            throw new IllegalStateException();
        }
        Object temp = this.head.next.CropYear;
        this.head.next = head.next.next;
        head.next.prev = head;
        this.size--;
        return temp;
    }
    public boolean isEmpty(){
        return (this.size==0);
    }
    public int size(){
        return this.size;
    }
    public void printFifo(){
        for(Node p=this.head.next;p!=head;p=p.next){
            System.out.println("-------------------"+p.CropYear+"'s Crop Data------------------------------");
                for(CropData c:p.Cdata){
                    System.out.println(c);
                }
            System.out.println("-------------------"+p.CropYear+"'s Crop Count------------------------------");
                for(CropCount c:p.Ccount){
                    System.out.println(c);
                }

        }
    }
}
