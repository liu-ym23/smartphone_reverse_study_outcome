package com.bytedance.lego.init.e;

/* JADX INFO: loaded from: classes.dex */
public class j implements Comparable<j> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f4891i;

    public int a(j r3) {
        if (r3 == null) goto L15;
        b r0 = this.f4891i;
        if (r0 == null) goto L17;
        int r2 = this.f4890h;
        int r1 = r3.f4890h;
        if (r2 <= r1) goto L10;
        return -1;
    L10:
        if (r2 >= r1) goto L14;
        return 1;
    L14:
        return r0.getClass().getSimpleName().compareTo(r3.f4891i.getClass().getSimpleName());
    L17:
        return 0;
    L15:
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(j r1) {
        return a(r1);
    }

    public String toString() {
        return "priority:" + this.f4890h + " taskClassName:" + this.f4891i.getClass().getSimpleName() + " mustRunInMainThread:" + this.f4889g;
    }
}
