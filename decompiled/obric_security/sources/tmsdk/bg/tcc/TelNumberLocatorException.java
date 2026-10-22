package tmsdk.bg.tcc;

/* JADX INFO: loaded from: classes5.dex */
public class TelNumberLocatorException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private int error;

    public TelNumberLocatorException(int r3) {
        super("TelNumberLocator error" + Integer.toString(r3));
        this.error = r3;
    }

    public int getError() {
        return this.error;
    }
}
