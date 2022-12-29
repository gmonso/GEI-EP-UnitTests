package data;

public class PhoneNumber {
    private String number;
    public PhoneNumber(String number){
        this.number = number;
    }
    public void setNumber(String num){
        this.number = num;
    }
    public String getNumber() {
        return this.number;
    }
    public String toString(){
        return "Phone Number: " + this.number;
    }
}
