package com.obric.matrix.opush.base.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.settings.storage.i;

/* JADX INFO: loaded from: classes2.dex */
public class PushLocalSettings$$SettingImpl implements PushLocalSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f9243a;

    public PushLocalSettings$$SettingImpl(Context r1, i r2) {
        this.f9243a = r2;
    }

    @Override // com.obric.matrix.opush.base.settings.PushLocalSettings
    public void a(long r2) {
        i r1 = this.f9243a;
        if (r1 == null) goto L6;
        SharedPreferences.Editor r3 = r1.edit();
        r3.putLong("last_de_duplication_timestamp", r2);
        r3.apply();
        return;
    }

    @Override // com.obric.matrix.opush.base.settings.PushLocalSettings
    public void b(long r2) {
        i r1 = this.f9243a;
        if (r1 == null) goto L6;
        SharedPreferences.Editor r3 = r1.edit();
        r3.putLong("last_request_update_device_timestamp", r2);
        r3.apply();
        return;
    }

    @Override // com.obric.matrix.opush.base.settings.PushLocalSettings
    public long c() {
        i r0 = this.f9243a;
        if (r0 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r0.contains("last_de_duplication_timestamp") == false) goto L7;
        return this.f9243a.c("last_de_duplication_timestamp");
    }

    @Override // com.obric.matrix.opush.base.settings.PushLocalSettings
    public long d() {
        i r0 = this.f9243a;
        if (r0 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r0.contains("last_request_update_device_timestamp") == false) goto L7;
        return this.f9243a.c("last_request_update_device_timestamp");
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void registerValChanged(Context r1, String r2, String r3, com.bytedance.push.settings.a r4) {
        i r0 = this.f9243a;
        if (r0 == null) goto L6;
        r0.registerValChanged(r1, r2, r3, r4);
        return;
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void unregisterValChanged(com.bytedance.push.settings.a r1) {
        i r0 = this.f9243a;
        if (r0 == null) goto L6;
        r0.unregisterValChanged(r1);
        return;
    }
}
