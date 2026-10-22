package com.ss.android.account.group_onekey.c;

/* JADX INFO: loaded from: classes2.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f11766f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ d[] f11767g = null;

    static {
        d r1 = new d("REQUESTING", 1);
        f11766f = r1;
        f11767g = new d[]{new d("DEFAULT", 0), r1};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f11767g.clone();
    }
}
