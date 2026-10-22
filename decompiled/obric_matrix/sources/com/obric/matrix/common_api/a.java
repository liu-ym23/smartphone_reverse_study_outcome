package com.obric.matrix.common_api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/common_api/Env;", "", "(Ljava/lang/String;I)V", "BOE", "PPE", "RELEASE", "common_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8946f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f8947g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f8948h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ a[] f8949i = null;

    static {
        f8946f = new a("BOE", 0);
        f8947g = new a("PPE", 1);
        f8948h = new a("RELEASE", 2);
        f8949i = a();
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ a[] a() {
        return new a[]{f8946f, f8947g, f8948h};
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f8949i.clone();
    }
}
