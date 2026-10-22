package kotlin.s0.w.d.l0.f.z;

import java.util.LinkedList;
import java.util.List;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.f.o;
import kotlin.s0.w.d.l0.f.p;
import kotlin.z;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f20245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f20246b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20247a = null;

        static {
            int[] r0 = new int[o.c.EnumC0546c.values().length];
            r0[o.c.EnumC0546c.f20087g.ordinal()] = 1;
            r0[o.c.EnumC0546c.f20088h.ordinal()] = 2;
            r0[o.c.EnumC0546c.f20089i.ordinal()] = 3;
            f20247a = r0;
        }
    }

    public d(p r2, o r3) {
        kotlin.n0.d.o.f(r2, "strings");
        kotlin.n0.d.o.f(r3, "qualifiedNames");
        this.f20245a = r2;
        this.f20246b = r3;
    }

    private final z<List<String>, List<String>, Boolean> d(int r8) {
        LinkedList r0 = new LinkedList();
        LinkedList r1 = new LinkedList();
        boolean r2 = false;
    L4:
        if (r8 == (-1)) goto L17;
        o.c r9 = this.f20246b.u(r8);
        String r3 = this.f20245a.u(r9.z());
        o.c.EnumC0546c r4 = r9.w();
        kotlin.n0.d.o.c(r4);
        int r5 = a.f20247a[r4.ordinal()];
        if (r5 != 1) goto L8;
        r1.addFirst(r3);
    L15:
        r8 = r9.y();
        goto L4
    L8:
        if (r5 != 2) goto L10;
        r0.addFirst(r3);
        goto L15
    L10:
        if (r5 != 3) goto L15;
        r1.addFirst(r3);
        r2 = true;
        goto L15
    L17:
        return new z(r0, r1, Boolean.valueOf(r2));
    }

    @Override // kotlin.s0.w.d.l0.f.z.c
    public String a(int r11) {
        z<List<String>, List<String>, Boolean> r10 = d(r11);
        List<String> r0 = r10.a();
        String r12 = r.Z(r10.b(), ".", null, null, 0, null, null, 62, null);
        if (r0.isEmpty() == false) goto L6;
        return r12;
    L6:
        return r.Z(r0, "/", null, null, 0, null, null, 62, null) + '/' + r12;
    }

    @Override // kotlin.s0.w.d.l0.f.z.c
    public String b(int r1) {
        String r0 = this.f20245a.u(r1);
        kotlin.n0.d.o.e(r0, "strings.getString(index)");
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.f.z.c
    public boolean c(int r1) {
        return d(r1).d().booleanValue();
    }
}
