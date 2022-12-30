package publicadministration;

import data.*;

import java.util.Date;

public class Citizen {
    // Represents all the information required for a citizen
    private final Nif nif;
    private final String name;
    private final String address;
    private final PhoneNumber mobileNumb;
    private Date nifDate;

    public Citizen(Nif nif, String name, String address, PhoneNumber mobileNumb, Date date) {
        this.nif = nif;
        this.name = name;
        this.address = address;
        this.mobileNumb = mobileNumb;
        this.nifDate = date;
    }
    public Date getnifDate(){
        return this.nifDate;
    }
    public Nif getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public PhoneNumber getMobileNumb() {
        return mobileNumb;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "nif=" + nif +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumb='" + mobileNumb + '\'' +
                '}';
    }
}
