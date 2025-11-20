package Sem1.Langdocs.Prog285bMap;

public class Com {
    private int myId;
    private int myCode;
    private double myCom;
    private double mySales;


    public Com(int id, int code, double sales) {
        myId = id;
        myCode = code;
        mySales = sales;
        myCom = 0;
    }

    public void calc() {
        if ((myCode==5)||(myCode==8)) {
            if           (mySales<=3500) myCom = mySales * 0.075;
            else myCom = ((mySales-5000)*0.085)+(5000*0.075);
        }
        if ((myCode==17)) {
            if           (mySales<=5000) myCom = mySales * 0.095;
            else myCom = ((mySales-5000)*0.095)+(3500*0.12);
        }
    }

    @Override
    public String toString() {
        return myId + "\t" + myCode + "\t" + myCom + "\t" + mySales +  "\t" + myCom;
    }


    public int getId() {return myId;}
    public int getCode() {return myCode;}
    public double getSales() {return mySales;}
    public double getcommision() {return myCom;}
}