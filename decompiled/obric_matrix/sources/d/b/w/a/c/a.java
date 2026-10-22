package d.b.w.a.c;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f15232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f15234c;

    public a(String r2) {
        this.f15232a = null;
        this.f15233b = null;
        this.f15234c = null;
        this.f15233b = r2;
    }

    protected b a(File r1) {
        return null;
    }

    public b b() {
        if (this.f15233b != null) goto L7;
        d.b.w.a.d.b.g("refresh and path null");
        return null;
    L7:
        if (this.f15234c != null) goto L9;
        this.f15234c = new File(this.f15233b);
    L9:
        b r0 = a(this.f15234c);
        this.f15232a = r0;
        return r0;
    }

    public String toString() {
        return "BaseStatFile{mPath='" + this.f15233b + "', mFile=" + this.f15234c + ", mLastInfo=" + this.f15232a + '}';
    }
}
