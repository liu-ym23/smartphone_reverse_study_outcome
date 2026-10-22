package d.b.h.a.a.k;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f13798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f13799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f13800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f13801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f13802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f13803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String[] f13804i;

    public b(boolean r1, boolean r2, String[] r3, String[] r4, String[] r5, String[] r6, String[] r7, String[] r8, String[] r9) {
        this.f13796a = r1;
        this.f13797b = r2;
        this.f13798c = r3;
        this.f13799d = r4;
        this.f13800e = r5;
        this.f13801f = r6;
        this.f13802g = r7;
        this.f13803h = r8;
        this.f13804i = r9;
    }

    public boolean a() {
        return this.f13797b;
    }

    public boolean b() {
        return this.f13796a;
    }

    public String[] c() {
        return this.f13804i;
    }

    public String[] d() {
        return this.f13800e;
    }

    public String[] e() {
        return this.f13799d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L31:
        return false;
    L8:
        if (b.class != r5.getClass()) goto L31;
        b r6 = (b) r5;
        if (this.f13796a != r6.f13796a) goto L30;
        if (this.f13797b != r6.f13797b) goto L30;
        if (Arrays.equals(this.f13798c, r6.f13798c) == false) goto L30;
        if (Arrays.equals(this.f13799d, r6.f13799d) == false) goto L30;
        if (Arrays.equals(this.f13800e, r6.f13800e) == false) goto L30;
        if (Arrays.equals(this.f13801f, r6.f13801f) == false) goto L30;
        if (Arrays.equals(this.f13802g, r6.f13802g) == false) goto L30;
        if (Arrays.equals(this.f13803h, r6.f13803h) == false) goto L30;
        if (Arrays.equals(this.f13804i, r6.f13804i) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public String[] f() {
        return this.f13801f;
    }

    public String[] g() {
        return this.f13802g;
    }

    public String[] h() {
        return this.f13798c;
    }

    public String[] i() {
        return this.f13803h;
    }
}
