package com.obric.matrix.q.h;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/base/system/PackageAction;", "", "description", "", "(Ljava/lang/String;ILjava/lang/String;)V", "ADDED", "REMOVED", "UPDATED", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f9876f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f9877g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f9878h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ e[] f9879i = null;

    static {
        f9876f = new e("ADDED", 0, "ADDED");
        f9877g = new e("REMOVED", 1, "REMOVED");
        f9878h = new e("UPDATED", 2, "UPDATED");
        f9879i = a();
    }

    private e(String r1, int r2, String r3) {
        super(r1, r2);
    }

    private static final /* synthetic */ e[] a() {
        return new e[]{f9876f, f9877g, f9878h};
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) f9879i.clone();
    }
}
