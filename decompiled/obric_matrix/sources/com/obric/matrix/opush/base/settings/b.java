package com.obric.matrix.opush.base.settings;

import android.content.ContentResolver;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.push.settings.e;
import com.obric.matrix.opush.g.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/opush/base/settings/PushSettingsService;", "Lcom/obric/matrix/opush/base/settings/IPushSettingsService;", "()V", "HOST_APP_LIST", "", "TAG", "hostAppMap", "", "getAppHostCount", "", "getHostAppList", "pkgName", "getLocalSettings", "Lcom/obric/matrix/opush/base/settings/PushLocalSettings;", "isHostAppList", "", "putHostAppList", "", "token", "readAppMap", "removeHostAppList", "writeAppMap", "appMap", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f9246c;

    public b() {
        this.f9244a = "PushSettingsService";
        this.f9245b = "host_app_list";
    }

    private final Map<String, String> g() {
        String r0 = Settings.Secure.getString(com.bytedance.mpaas.app.a.b().getContentResolver(), this.f9245b);
        LinkedHashMap r1 = new LinkedHashMap();
        if (TextUtils.isEmpty(r0) == false) goto L15;
        return r1;
    L15:
        c r2 = c.f9427a;     // Catch: Throwable -> L12
        o.e(r0, "oldAppListStr");     // Catch: Throwable -> L12
        String r3 = r2.b(r0);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == true) goto L14;
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L12
        Iterator<String> r5 = r4.keys();     // Catch: Throwable -> L12
        o.e(r5, "jsonObject.keys()");     // Catch: Throwable -> L12
    L9:
        if (r5.hasNext() == false) goto L14;
        String r6 = r5.next();     // Catch: Throwable -> L12
        o.e(r6, "key");     // Catch: Throwable -> L12
        String r7 = r4.optString(r6, "");     // Catch: Throwable -> L12
        o.e(r7, "jsonObject.optString(key, \"\")");     // Catch: Throwable -> L12
        r1.put(r6, r7);     // Catch: Throwable -> L12
    L14:
        return r1;
    L12:
        th = move-exception;
        com.obric.matrix.r.c.c.f(this.f9244a, "readAppMap, e=" + th);
        goto L14
    }

    private final void h(Map<String, String> r5) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();     // Catch: Throwable -> L8
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r6.next();     // Catch: Throwable -> L8
        r0.put(r1.getKey(), r1.getValue());     // Catch: Throwable -> L8
        goto L4
    L6:
        ContentResolver r7 = com.bytedance.mpaas.app.a.b().getContentResolver();     // Catch: Throwable -> L8
        String r2 = this.f9245b;     // Catch: Throwable -> L8
        c r3 = c.f9427a;     // Catch: Throwable -> L8
        String r4 = r0.toString();     // Catch: Throwable -> L8
        o.e(r4, "jsonObject.toString()");     // Catch: Throwable -> L8
        Settings.Secure.putString(r7, r2, r3.a(r4));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.obric.matrix.r.c.c.f(this.f9244a, "writeAppMap, e=" + th);
    }

    @Override // com.obric.matrix.opush.base.settings.a
    public PushLocalSettings a() {
        Object r1 = e.b(com.bytedance.mpaas.app.a.b(), PushLocalSettings.class);
        o.e(r1, "obtain(LaunchApplication…ocalSettings::class.java)");
        return (PushLocalSettings) r1;
    }

    @Override // com.obric.matrix.opush.base.settings.a
    public void b(String r3) {
        o.f(r3, "pkgName");
        Map<String, String> r0 = g();
        if (r0.containsKey(r3) == false) goto L9;
        r0.remove(r3);
        Map<String, String> r1 = this.f9246c;
        if (r1 == null) goto L7;
        String r4 = r1.remove(r3);
    L7:
        h(r0);
        return;
    }

    @Override // com.obric.matrix.opush.base.settings.a
    public boolean c(String r2) {
        o.f(r2, "pkgName");
        Map<String, String> r0 = this.f9246c;
        if (r0 == null) goto L7;
        o.c(r0);
    L6:
        return r0.containsKey(r2);
    L7:
        r0 = g();
        this.f9246c = r0;
        goto L6
    }

    @Override // com.obric.matrix.opush.base.settings.a
    public void d(String r3, String r4) {
        o.f(r3, "pkgName");
        o.f(r4, "token");
        Map<String, String> r0 = g();
        if (r0.containsKey(r3) == true) goto L5;
    L7:
        r0.put(r3, r4);
        Map<String, String> r1 = this.f9246c;
        if (r1 == null) goto L10;
        String r5 = r1.put(r3, r4);
    L10:
        h(r0);
        return;
    L5:
        if (o.a(r0.get(r3), r4) == false) goto L7;
    }

    @Override // com.obric.matrix.opush.base.settings.a
    public int e() {
        Map<String, String> r0 = this.f9246c;
        if (r0 == null) goto L7;
        o.c(r0);
    L6:
        return r0.size();
    L7:
        r0 = g();
        this.f9246c = r0;
        goto L6
    }

    @Override // com.obric.matrix.opush.base.settings.a
    public String f(String r2) {
        o.f(r2, "pkgName");
        Map<String, String> r0 = this.f9246c;
        if (r0 != null) goto L5;
        r0 = g();
    L5:
        String r1 = r0.get(r2);
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    }
}
