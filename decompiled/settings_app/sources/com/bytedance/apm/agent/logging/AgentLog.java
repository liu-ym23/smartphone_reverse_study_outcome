package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes3.dex */
public interface AgentLog {
    public static final int AUDIT = 6;
    public static final int DEBUG = 5;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final int VERBOSE = 4;
    public static final int WARNING = 2;

    void audit(String r1);

    void debug(String r1);

    void error(String r1);

    void error(String r1, Throwable r2);

    int getLevel();

    void info(String r1);

    void setLevel(int r1);

    void verbose(String r1);

    void warning(String r1);
}
