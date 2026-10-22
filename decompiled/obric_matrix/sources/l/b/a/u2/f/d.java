package l.b.a.u2.f;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f21761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private char f21763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private StringBuffer f21764d;

    public d(String r2) {
        this(r2, ',');
    }

    public d(String r2, char r3) {
        this.f21764d = new StringBuffer();
        this.f21761a = r2;
        this.f21762b = -1;
        this.f21763c = r3;
    }

    public boolean a() {
        if (this.f21762b == this.f21761a.length()) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        if (this.f21762b != this.f21761a.length()) goto L6;
        return null;
    L6:
        int r0 = this.f21762b + 1;
        this.f21764d.setLength(0);
        boolean r2 = false;
        boolean r4 = false;
    L8:
        if (r0 == this.f21761a.length()) goto L25;
        char r5 = this.f21761a.charAt(r0);
        if (r5 != '\"') goto L13;
        if (r2 == true) goto L23;
        r4 = !r4;
    L23:
        this.f21764d.append(r5);
        r2 = false;
    L24:
        r0 = r0 + 1;
        goto L8
    L13:
        if (r2 == true) goto L23;
        if (r4 == true) goto L23;
        if (r5 != '\\') goto L20;
        this.f21764d.append(r5);
        r2 = true;
        goto L24
    L20:
        if (r5 == this.f21763c) goto L25;
        this.f21764d.append(r5);
    L25:
        this.f21762b = r0;
        return this.f21764d.toString();
    }
}
