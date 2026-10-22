package com.tencent.jpegenc;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JpegEnc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f22a;

    static {
        System.loadLibrary("jpegenc-1.1");
        f22a = true;
    }

    public static int a(String r0, int r1, String r2) {
        return nativeDecEnc(r0, r1, r2);
    }

    private static native int nativeDecEnc(String r0, int r1, String r2);
}
