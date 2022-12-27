package publicadministration;

import data.Nif;

public class Citizen {
    // Represents all the information required for a citizen
    private Nif nif;
    private String name;
    private String address;
    private String mobileNumb;

    public Citizen(Nif nif, String name, String address, String mobileNumb) {
        this.nif = nif;
        this.name = name;
        this.address = address;
        this.mobileNumb = mobileNumb;
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

    public String getMobileNumb() {
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
