package com.obric.matrix.base.settings;

import com.obric.matrix.base.settings.appconfig.IAppSettings;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/base/settings/SystemAppSettingsManager;", "", "()V", "EMPTY_JSON", "", "getAppSetting", "packageName", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8886b = null;

    static {
        f8885a = new f();
        String r0 = new JSONObject().toString();
        o.e(r0, "JSONObject().toString()");
        f8886b = r0;
    }

    private f() {
    }

    public final String a(String r4) {
        o.f(r4, "packageName");
        Class<? extends IAppSettings> r3 = d.f8882a.a(r4);
        if (r3 != null) goto L23;
        com.obric.matrix.r.c.c.j("SystemAppSettingsManager", "Invalid config class for package: " + r4);
        return f8886b;
    L23:
        String r5 = ((IAppSettings) com.bytedance.news.common.settings.e.e(r3)).getAppConfig();     // Catch: Exception -> L20
        if (r5 != null) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if ((true ^ r2) == true) goto L17;
        r5 = null;
    L17:
        if (r5 != null) goto L25;
        return f8886b;
    L25:
        return r5;
    L9:
        if (k.q(r5) == true) goto L12;
        r2 = false;
    L20:
        e = move-exception;
        com.obric.matrix.r.c.c.g("SystemAppSettingsManager", "Failed to obtain app settings for " + r4, e);
        return f8886b;
    }
}
