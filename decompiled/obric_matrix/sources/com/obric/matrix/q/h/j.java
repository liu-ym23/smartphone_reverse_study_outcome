package com.obric.matrix.q.h;

import android.os.Build;
import com.obric.matrix.r.e.m;
import com.obric.matrix.r.e.n;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/base/system/SystemInfoUtils;", "", "()V", "TAG", "", "reportSystemInfo", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9884a = null;

    static {
        f9884a = new j();
    }

    private j() {
    }

    public static /* synthetic */ void a() {
        c();
    }

    private static final void c() {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L21
        m r2 = m.f9945a;     // Catch: Exception -> L21
        String r3 = r2.a();     // Catch: Exception -> L21
        int r4 = 0;
        if (r3 != null) goto L6;
    L9:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        r3 = n.f9946a.a();     // Catch: Exception -> L21
    L12:
        r1.put("pico_sn", r3);     // Catch: Exception -> L21
        r1.put("pico_os_version", Build.DISPLAY);     // Catch: Exception -> L21
        if (r2.f() == false) goto L15;
        int r7 = 1;
    L16:
        r1.put("system_is_oversea", r7);     // Catch: Exception -> L21
        r1.put("system_country_code", r2.c());     // Catch: Exception -> L21
        if (n.f9946a.c() == false) goto L19;
        r4 = 1;
    L19:
        r1.put("system_is_business_device", r4);     // Catch: Exception -> L21
        com.obric.matrix.r.c.e.a("SystemInfoUtils", "system info = " + r1);     // Catch: Exception -> L21
        com.obric.matrix.ostracker_api.b.g("matrix_event_pico_system_info", r1);     // Catch: Exception -> L21
        com.obric.matrix.q.f.a.f9854a.a("matrix_event_pico_system_info", r1, new JSONObject(), new JSONObject());     // Catch: Exception -> L21
        return;
    L15:
        r7 = 0;
        goto L16
    L6:
        if (r3.length() == 0) goto L9;
        r6 = false;
    }

    public final void b() {
        com.bytedance.common.utility.m.c.c(a.f9868f);
    }
}
