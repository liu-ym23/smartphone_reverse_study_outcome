package vb;

import android.net.Uri;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import xc.e;
import yb.b;
import yb.c;
import yb.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.ies.bullet.interaction.predefine.fileLoader.a f22567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f22568b = null;

    static {
        f22568b = new ConcurrentHashMap();
    }

    public static void a(Uri r10, List r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "matchRule");
        if (r11.isEmpty() == true) goto L5;
    L7:
        String r5 = a.a.b(r10, "predefine_config");
        if (r5 != null) goto L10;
    L9:
        ArrayList r12 = null;
    L22:
        Iterator r13 = r11.iterator();
    L24:
        if (r13.hasNext() == false) goto L46;
        String r14 = (String) r13.next();
        if (r12 == null) goto L33;
        if (r12.contains(r14) != true) goto L33;
        c r15 = new c(-1, r14, "", true);
        HashMap r16 = b.f23241a;
        d r17 = (d) r16.get(r10.toString());
        if (r17 != null) goto L32;
        r17 = new d();
    L32:
        r17.f23245a.add(r15);
        r16.put(r10.toString(), r17);
    L33:
        com.bytedance.ies.bullet.interaction.predefine.fileLoader.a r18 = f22567a;
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("fileLoader");
        r18 = null;
    L37:
        r18.a(r14, r10.toString());
        goto L24
    L46:
        return;
    L10:
        ConcurrentHashMap r19 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r20 = (e) yc.a.a(e.class, "default_bid");
        if (r20 == null) goto L13;
        xb.d r21 = (xb.d) r20.a(xb.d.class);
    L14:
        int r22 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPredefine", g.d("getWasmDisableConfig configKey:", r5, ",wasmDisableList:null"), null, 12);
        if (r21 == null) goto L17;
        JSONArray r23 = r21.f23011a.optJSONArray(r5);
    L18:
        if (r23 == null) goto L9;
        JSONArray r24 = r21.f23011a.optJSONArray(r5);
        if (r24 == null) goto L9;
        r12 = ym.a.c(r24);
        goto L22
    L17:
        r23 = null;
        goto L18
    L13:
        r21 = null;
        goto L14
    L5:
        if (f22567a != null) goto L7;
    }

    public static void b(xb.c r5, Uri r10) {
        HashMap r11 = b.f23241a;
        Intrinsics.checkNotNullParameter(r10.toString(), "<set-?>");
        d r12 = new d();
        b.f23241a.put(r10.toString(), r12);
        Boolean r13 = Boolean.TRUE;
        Boolean r14 = r5.f23010c;
        boolean r15 = Intrinsics.areEqual(r14, r13);
        ArrayList r16 = r12.f23245a;
        if (r15 == false) goto L6;
        com.bytedance.ies.bullet.interaction.predefine.fileLoader.a r17 = new com.bytedance.ies.bullet.interaction.predefine.fileLoader.a(r5);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        f22567a = r17;
        r16.clear();
        return;
    L6:
        Intrinsics.areEqual(r14, r13);
        r16.clear();
    }
}
