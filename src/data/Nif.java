package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

final public class Nif {
    private final String nif;

    public Nif(String code) throws NullArgumentException, WrongFormatException {
        if (code == null) throw new NullArgumentException("Nif is null");
        if (!correctFormat(code)) throw new WrongFormatException("Nif is not in the correct format");
        this.nif = code;
    }

    public String getNif() {
        return nif;
    }

    public boolean correctFormat(String code) {
        if (code.length() != 9) return false;
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(code.charAt(i))) return false;
        }
        return Character.isLetter(code.charAt(8));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif);
    }

    @Override
    public int hashCode() {
        return nif.hashCode();
    }

    @Override
    public String toString() {
        return "Nif{" + "nif ciudadano='" + nif + '\'' + '}';
    }

}
