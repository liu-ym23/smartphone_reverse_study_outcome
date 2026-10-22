package com.obric.netdetect.Modules.IpProbe;

/* JADX INFO: loaded from: classes3.dex */
public class IpNative {
    public native int detectIpConflict(String r1, byte[] r2, int r3);

    public IpNative() {
    }

    static {
        System.loadLibrary("ping");
    }
}
