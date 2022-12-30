package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.util.Arrays;


public class DigitalSignature {
    private final byte[] signature;

    public DigitalSignature(byte[] code) throws NullArgumentException, WrongFormatException {
        if (code == null) throw new NullArgumentException("DigitalSignature is null");
        if (!correctFormat(code)) throw new WrongFormatException("DigitalSignature is not in the correct format");
        this.signature = code;
    }

    public byte[] getSignature() {
        return signature;
    }

    public boolean correctFormat(byte[] code) {
        if (code.length < 3) return false;
        return code.length <= 20;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature that = (DigitalSignature) o;
        return Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(signature);
    }

    @Override
    public String toString() {
        return "DigitalSignature{" + "signature=" + Arrays.toString(signature) + '}';
    }
}
