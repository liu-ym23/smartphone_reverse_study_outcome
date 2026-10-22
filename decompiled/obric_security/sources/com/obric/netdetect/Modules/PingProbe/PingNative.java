package com.obric.netdetect.Modules.PingProbe;

/* JADX INFO: loaded from: classes3.dex */
public class PingNative {
    public native int ping(String r1, int r2);

    public PingNative() {
    }

    static {
        System.loadLibrary("ping");
    }
}
