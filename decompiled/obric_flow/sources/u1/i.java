package u1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w1.l;
import w1.m;
import w1.n;
import w1.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f22239a = null;

    static {
        int r5 = 6;
        int r10 = 8;
        int r11 = 7;
        int r12 = 5;
        int r13 = 3;
        int r14 = 4;
        int r15 = 2;
        int r16 = 1;
        int r17 = 0;
        f22239a = new LinkedHashMap();
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L5;
        r18.i("CalDavClient", "init PropertyFactory");
    L5:
        Property$NodeInfo r19 = w1.b.f22677b;
        w1.a r110 = new w1.a(r17);
        Property$NodeInfo r111 = w1.d.f22680b;
        w1.c r112 = new w1.c(0);
        Property$NodeInfo r113 = w1.e.f22681b;
        w1.a r114 = new w1.a(r16);
        Property$NodeInfo r115 = w1.f.f22683b;
        w1.a r116 = new w1.a(r15);
        Property$NodeInfo r117 = w1.i.f22688b;
        w1.a r118 = new w1.a(r14);
        Property$NodeInfo r119 = w1.h.f22686b;
        w1.a r20 = new w1.a(r13);
        Property$NodeInfo r120 = w1.j.f22690b;
        w1.a r21 = new w1.a(r12);
        Property$NodeInfo r121 = l.f22693b;
        w1.c r22 = new w1.c(1);
        Property$NodeInfo r122 = n.f22697b;
        w1.a r23 = new w1.a(r11);
        Property$NodeInfo r24 = o.f22699b;
        w1.a r25 = new w1.a(r10);
        Property$NodeInfo r26 = m.f22694b;
        List r27 = CollectionsKt.listOf(new j[]{r110, r112, r114, r116, r118, r20, r21, r22, r23, r25, new w1.a(r5)});
        Intrinsics.checkNotNullParameter(r27, "factories");
        Iterator r28 = r27.iterator();
    L7:
        if (r28.hasNext() == false) goto L12;
        j r29 = (j) r28.next();
        Intrinsics.checkNotNullParameter(r29, "parser");
        String r30 = "Registering " + r29.getClass().getName() + " for " + r29.a();
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        t0.d r31 = com.bytedance.ai.utils.c.f2846a;
        if (r31 == null) goto L11;
        r31.i("CalDavClient", r30);
    L11:
        f22239a.put(r29.a(), r29);
        goto L7
    }
}
