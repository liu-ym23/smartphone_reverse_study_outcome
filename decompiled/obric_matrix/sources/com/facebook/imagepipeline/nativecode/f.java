package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f6760a;

    static {
        f6760a = (e) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();     // Catch: Throwable -> L4
        return;
    }

    public static e a() {
        return f6760a;
    }
}
