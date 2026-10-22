package w1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements u1.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22676a;

    public /* synthetic */ a(int r5) {
        this.f22676a = r5;
    }

    @Override // u1.j
    public final Property$NodeInfo a() {
        switch(this.f22676a) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L5;
        };
    L5:
        return o.f22699b;
    L7:
        return n.f22697b;
    L9:
        return m.f22694b;
    L11:
        return j.f22690b;
    L13:
        return i.f22688b;
    L15:
        return h.f22686b;
    L17:
        return f.f22683b;
    L19:
        return e.f22681b;
    L21:
        return b.f22677b;
    }

    @Override // u1.j
    public final u1.h a(XmlPullParser r5) {
        switch(this.f22676a) {
            case 0: goto L47;
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new o(x1.b.c(r5));
    L6:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new n(x1.b.c(r5));
    L8:
        Intrinsics.checkNotNullParameter(r5, "parser");
        m r10 = new m();
        int r11 = r5.getDepth();
        int r12 = r5.getEventType();
    L10:
        if (r12 != 3) goto L17;
        if (r5.getDepth() != r11) goto L17;
        r5.getDepth();
        return r10;
    L17:
        if (r12 != 2) goto L36;
        if (r5.getDepth() != (r11 + 1)) goto L36;
        Property$NodeInfo r13 = new Property$NodeInfo(r5.getNamespace(), r5.getName());
        Property$NodeInfo r14 = m.f22695c;
        if (Intrinsics.areEqual(r13, r14) == false) goto L23;
    L22:
        r13 = r14;
    L35:
        r10.f22696a.add(r13);
        goto L36
    L23:
        r14 = m.d;
        if (Intrinsics.areEqual(r13, r14) == true) goto L22;
        r14 = m.e;
        if (Intrinsics.areEqual(r13, r14) == true) goto L22;
        r14 = m.f;
        if (Intrinsics.areEqual(r13, r14) == true) goto L22;
        r14 = m.g;
        if (Intrinsics.areEqual(r13, r14) == false) goto L35;
    L36:
        r12 = r5.next();
        goto L10
    L37:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new j(x1.b.c(r5));
    L39:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new i(x1.b.c(r5));
    L41:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new h(x1.b.c(r5));
    L43:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new f(x1.b.c(r5));
    L45:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new e(x1.b.c(r5));
    L47:
        Intrinsics.checkNotNullParameter(r5, "parser");
        return new b(x1.b.c(r5));
    }
}
