package com.tencent.tmf.gm;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f31a;
    public static int b;
    public static int c;

    /* JADX INFO: renamed from: com.tencent.tmf.gm.a$a, reason: collision with other inner class name */
    public static class C0080a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32a;
        public byte[] b;

        public C0080a() {
        }
    }

    static {
        System.loadLibrary("tmf-gm");
        f31a = 1;
        b = 2;
        c = 3;
    }

    public static boolean a(byte[] r0, int r1) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (r0.length != r1) goto L10;
        return true;
    L10:
        return false;
    }
}
