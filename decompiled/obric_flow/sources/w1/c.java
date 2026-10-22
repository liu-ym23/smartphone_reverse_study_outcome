package w1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements u1.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22679a;

    public /* synthetic */ c(int r5) {
        this.f22679a = r5;
    }

    public static void b(XmlPullParser r5, k r10) {
        Intrinsics.checkNotNullParameter(r5, "parser");
        Intrinsics.checkNotNullParameter(r10, "list");
        XmlPullParserFactory r11 = x1.b.f22944a;
        Property$NodeInfo r12 = u1.e.g;
        LinkedList r13 = r10.f22692a;
        Intrinsics.checkNotNullParameter(r5, "parser");
        Intrinsics.checkNotNullParameter(r12, "node");
        Intrinsics.checkNotNullParameter(r13, "list");
        int r14 = r5.getDepth();
        int r15 = r5.getEventType();
    L4:
        if (r15 == 3) goto L7;
        if (r15 == 1) goto L7;
    L9:
        if (r15 != 2) goto L15;
        if (r5.getDepth() != (r14 + 1)) goto L15;
        if (Intrinsics.areEqual(x1.b.a(r5), r12) == false) goto L15;
        r13.add(r5.nextText());
    L15:
        r15 = r5.next();
    L7:
        if (r5.getDepth() != r14) goto L9;
    }

    @Override // u1.j
    public final Property$NodeInfo a() {
        switch(this.f22679a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return l.f22693b;
    L7:
        return d.f22680b;
    }

    @Override // u1.j
    public final u1.h a(XmlPullParser r5) {
        switch(this.f22679a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "parser");
        l r10 = new l();
        b(r5, r10);
        return r10;
    L6:
        Intrinsics.checkNotNullParameter(r5, "parser");
        d r11 = new d();
        b(r5, r11);
        return r11;
    }
}
