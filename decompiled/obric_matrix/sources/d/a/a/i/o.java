package d.a.a.i;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a[] f12455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12456b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f12457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final char[] f12458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f12459c;

        a(String r1, int r2) {
            this.f12457a = r1;
            this.f12458b = r1.toCharArray();
            this.f12459c = r2;
        }
    }

    public o(int r4) {
        this.f12456b = r4 - 1;
        this.f12455a = new a[r4];
        a("$ref", 0, 4, 1185263);
        a("@type", 0, 5, 62680954);
    }

    private static String c(String r2, int r3, int r4) {
        char[] r0 = new char[r4];
        r2.getChars(r3, r4 + r3, r0, 0);
        return new String(r0);
    }

    public String a(String r3, int r4, int r5, int r6) {
        int r0 = this.f12456b & r6;
        a r1 = this.f12455a[r0];
        if (r1 == null) goto L15;
        if (r6 != r1.f12459c) goto L13;
        if (r5 != r1.f12458b.length) goto L13;
        if (r3.regionMatches(r4, r1.f12457a, 0, r5) == false) goto L13;
        return r1.f12457a;
    L13:
        return c(r3, r4, r5);
    L15:
        if (r5 == r3.length()) goto L18;
        r3 = c(r3, r4, r5);
    L18:
        String r7 = r3.intern();
        this.f12455a[r0] = new a(r7, r6);
        return r7;
    }

    public String b(char[] r4, int r5, int r6, int r7) {
        int r0 = this.f12456b & r7;
        a r1 = this.f12455a[r0];
        if (r1 == null) goto L20;
        boolean r2 = false;
        if (r7 == r1.f12459c) goto L7;
    L15:
        if (r2 == false) goto L19;
        return r1.f12457a;
    L19:
        return new String(r4, r5, r6);
    L7:
        if (r6 != r1.f12458b.length) goto L15;
        int r3 = 0;
    L9:
        if (r3 >= r6) goto L14;
        if (r4[r5 + r3] != r1.f12458b[r3]) goto L15;
        r3 = r3 + 1;
        goto L9
    L14:
        r2 = true;
        goto L15
    L20:
        String r8 = new String(r4, r5, r6).intern();
        this.f12455a[r0] = new a(r8, r7);
        return r8;
    }
}
