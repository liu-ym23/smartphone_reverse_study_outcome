package kotlin.s0.w.d.l0.l.b;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f20843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.c f20844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.m f20845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.g f20846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.h f20847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.a f20848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.b.g0.f f20849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d0 f20850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final w f20851i;

    public m(k r2, kotlin.s0.w.d.l0.f.z.c r3, kotlin.s0.w.d.l0.c.m r4, kotlin.s0.w.d.l0.f.z.g r5, kotlin.s0.w.d.l0.f.z.h r6, kotlin.s0.w.d.l0.f.z.a r7, kotlin.s0.w.d.l0.l.b.g0.f r8, d0 r9, List<kotlin.s0.w.d.l0.f.s> r10) {
        kotlin.n0.d.o.f(r2, "components");
        kotlin.n0.d.o.f(r3, "nameResolver");
        kotlin.n0.d.o.f(r4, "containingDeclaration");
        kotlin.n0.d.o.f(r5, "typeTable");
        kotlin.n0.d.o.f(r6, "versionRequirementTable");
        kotlin.n0.d.o.f(r7, "metadataVersion");
        kotlin.n0.d.o.f(r10, "typeParameters");
        this.f20843a = r2;
        this.f20844b = r3;
        this.f20845c = r4;
        this.f20846d = r5;
        this.f20847e = r6;
        this.f20848f = r7;
        this.f20849g = r8;
        String r11 = "Deserializer for \"" + r4.getName() + '\"';
        if (r8 == null) goto L6;
        String r12 = r8.c();
        if (r12 == null) goto L6;
    L7:
        this.f20850h = new d0(this, r9, r10, r11, r12);
        this.f20851i = new w(this);
        return;
    L6:
        r12 = "[container not found]";
        goto L7
    }

    public static /* synthetic */ m b(m r7, kotlin.s0.w.d.l0.c.m r8, List r9, kotlin.s0.w.d.l0.f.z.c r10, kotlin.s0.w.d.l0.f.z.g r11, kotlin.s0.w.d.l0.f.z.h r12, kotlin.s0.w.d.l0.f.z.a r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = r7.f20844b;
    L5:
        kotlin.s0.w.d.l0.f.z.c r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r11 = r7.f20846d;
    L8:
        kotlin.s0.w.d.l0.f.z.g r4 = r11;
        if ((r14 & 16) == 0) goto L11;
        r12 = r7.f20847e;
    L11:
        kotlin.s0.w.d.l0.f.z.h r5 = r12;
        if ((r14 & 32) == 0) goto L15;
        r13 = r7.f20848f;
    L15:
        return r7.a(r8, r9, r3, r4, r5, r13);
    }

    public final m a(kotlin.s0.w.d.l0.c.m r13, List<kotlin.s0.w.d.l0.f.s> r14, kotlin.s0.w.d.l0.f.z.c r15, kotlin.s0.w.d.l0.f.z.g r16, kotlin.s0.w.d.l0.f.z.h r17, kotlin.s0.w.d.l0.f.z.a r18) {
        kotlin.n0.d.o.f(r13, "descriptor");
        kotlin.n0.d.o.f(r14, "typeParameterProtos");
        kotlin.n0.d.o.f(r15, "nameResolver");
        kotlin.n0.d.o.f(r16, "typeTable");
        kotlin.s0.w.d.l0.f.z.h r2 = r17;
        kotlin.n0.d.o.f(r2, "versionRequirementTable");
        kotlin.n0.d.o.f(r18, "metadataVersion");
        k r3 = this.f20843a;
        if (kotlin.s0.w.d.l0.f.z.i.b(r18) == true) goto L7;
        r2 = this.f20847e;
    L7:
        return new m(r3, r15, r13, r16, r2, r18, this.f20849g, this.f20850h, r14);
    }

    public final k c() {
        return this.f20843a;
    }

    public final kotlin.s0.w.d.l0.l.b.g0.f d() {
        return this.f20849g;
    }

    public final kotlin.s0.w.d.l0.c.m e() {
        return this.f20845c;
    }

    public final w f() {
        return this.f20851i;
    }

    public final kotlin.s0.w.d.l0.f.z.c g() {
        return this.f20844b;
    }

    public final kotlin.s0.w.d.l0.m.n h() {
        return this.f20843a.u();
    }

    public final d0 i() {
        return this.f20850h;
    }

    public final kotlin.s0.w.d.l0.f.z.g j() {
        return this.f20846d;
    }

    public final kotlin.s0.w.d.l0.f.z.h k() {
        return this.f20847e;
    }
}
