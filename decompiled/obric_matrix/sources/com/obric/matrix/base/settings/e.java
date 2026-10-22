package com.obric.matrix.base.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/base/settings/SettingsNotifier;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "notifyByBroadcast", "", "packageName", "", "receiver", "notifyByContentResolver", "notifyConfigUpdated", "broadcastMap", "Ljava/util/concurrent/ConcurrentHashMap;", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8884a;

    public e(Context r2) {
        o.f(r2, "context");
        this.f8884a = r2;
    }

    private final void a(String r3, String r4) {
        com.obric.matrix.r.c.c.j("SettingsNotifier", "notifyByBroadcast package=" + r3 + ", receiver=" + r4);
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(r3, r4));
        r0.setAction("com.obric.matrix.systemapp.settings.update.action");
        this.f8884a.sendBroadcast(r0, "com.obric.matrix.permission.RECEIVE_SETTINGS_UPDATE");
    }

    private final void b() {
        com.obric.matrix.r.c.c.j("SettingsNotifier", "notifyByContentResolver");
        Uri r0 = Uri.parse("content://com.obric.matrix.systemapp.settings.provider/get_app_settings");
        this.f8884a.getContentResolver().notifyChange(r0, null);
    }

    public final void c(ConcurrentHashMap<String, String> r3) {
        o.f(r3, "broadcastMap");
        b();
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r4.next();
        a(r0.getKey(), r0.getValue());
        goto L4
    }
}
