package l.b.c.c.a;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import l.b.h.g;

/* JADX INFO: loaded from: classes2.dex */
public class b extends BasicPermission {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21870g;

    public b(String r1, String r2) {
        super(r1, r2);
        this.f21869f = r2;
        this.f21870g = a(r2);
    }

    private int a(String r3) {
        StringTokenizer r2 = new StringTokenizer(g.f(r3), " ,");
        int r4 = 0;
    L4:
        if (r2.hasMoreTokens() == false) goto L26;
        String r0 = r2.nextToken();
        if (r0.equals("threadlocalecimplicitlyca") == true) goto L7;
        if (r0.equals("ecimplicitlyca") == true) goto L10;
        if (r0.equals("threadlocaldhdefaultparams") == true) goto L13;
        if (r0.equals("dhdefaultparams") == true) goto L16;
        if (r0.equals("acceptableeccurves") == true) goto L19;
        if (r0.equals("additionalecparameters") == true) goto L22;
        if (r0.equals("all") == false) goto L4;
        r4 = r4 | 63;
        goto L4
    L22:
        r4 = r4 | 32;
        goto L4
    L19:
        r4 = r4 | 16;
        goto L4
    L16:
        r4 = r4 | 8;
        goto L4
    L13:
        r4 = r4 | 4;
        goto L4
    L10:
        r4 = r4 | 2;
        goto L4
    L7:
        r4 = r4 | 1;
        goto L4
    L26:
        if (r4 == 0) goto L29;
        return r4;
    L29:
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == false) goto L14;
        b r6 = (b) r5;
        if (this.f21870g != r6.f21870g) goto L13;
        if (getName().equals(r6.getName()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.f21869f;
    }

    public int hashCode() {
        return getName().hashCode() + this.f21870g;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission r4) {
        if ((r4 instanceof b) == true) goto L6;
        return false;
    L6:
        if (getName().equals(r4.getName()) == true) goto L8;
        return false;
    L8:
        int r3 = this.f21870g;
        int r5 = ((b) r4).f21870g;
        if ((r3 & r5) != r5) goto L12;
        return true;
    L12:
        return false;
    }
}
