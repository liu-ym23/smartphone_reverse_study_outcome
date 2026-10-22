package com.loopj.android.http;

/* JADX INFO: loaded from: classes4.dex */
public interface LogInterface {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final int WTF = 8;

    void d(String r1, String r2);

    void d(String r1, String r2, Throwable r3);

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    int getLoggingLevel();

    void i(String r1, String r2);

    void i(String r1, String r2, Throwable r3);

    boolean isLoggingEnabled();

    void setLoggingEnabled(boolean r1);

    void setLoggingLevel(int r1);

    boolean shouldLog(int r1);

    void v(String r1, String r2);

    void v(String r1, String r2, Throwable r3);

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);

    void wtf(String r1, String r2);

    void wtf(String r1, String r2, Throwable r3);
}
