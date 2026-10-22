package com.bytedance.monitor.collector;

/* JADX INFO: loaded from: classes3.dex */
public interface IHyperMonitor {

    public interface ILogInstance {
        void d(String r1, String r2);

        void e(String r1, String r2);

        long getNativeReference();

        void i(String r1, String r2);

        void v(String r1, String r2);

        void w(String r1, String r2);
    }

    ILogInstance getLogInstance();
}
