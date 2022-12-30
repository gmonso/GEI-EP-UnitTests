package publicadministration;

import data.Nif;
import data.PhoneNumber;

public class Citizen {
    // Represents all the information required for a citizen
    private final Nif nif;
    private final String name;
    private final String address;
    private final PhoneNumber mobileNumb;

    public Citizen(Nif nif, String name, String address, PhoneNumber mobileNumb) {
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
