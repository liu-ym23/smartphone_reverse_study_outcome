package com.facebook.common.time;

/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f6625a = null;

    static {
        f6625a = new c();
    }

    private c() {
    }

    public static c a() {
        return f6625a;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
