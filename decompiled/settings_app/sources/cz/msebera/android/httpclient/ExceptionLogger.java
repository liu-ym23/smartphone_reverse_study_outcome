package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes5.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = null;
    public static final ExceptionLogger STD_ERR = null;

    void log(Exception r1);

    static {
        NO_OP = new AnonymousClass1();
        STD_ERR = new AnonymousClass2();
    }
}
