package com.bytedance.push.settings.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<com.bytedance.push.settings.a, SharedPreferences.OnSharedPreferenceChangeListener> f5516b;

    class a implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.push.settings.a f5518b;

        a(g r1, String r2, com.bytedance.push.settings.a r3) {
            this.f5517a = r2;
            this.f5518b = r3;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences r1, String r2) {
            if (TextUtils.equals(this.f5517a, r2) == false) goto L6;
            this.f5518b.a();
            return;
        }
    }

    g(Context r2, String r3) {
        this.f5516b = new ConcurrentHashMap();
        this.f5515a = f(r2, r3, 0);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences f(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private void g(Exception r1) {
    }

    @Override // com.bytedance.push.settings.storage.i
    public boolean a(String r2) {
        return getBoolean(r2, false);
    }

    @Override // com.bytedance.push.settings.storage.i
    public String b(String r2) {
        return getString(r2, null);
    }

    @Override // com.bytedance.push.settings.storage.i
    public long c(String r3) {
        return getLong(r3, 0);
    }

    @Override // com.bytedance.push.settings.storage.i
    public boolean contains(String r1) {
        return this.f5515a.contains(r1);
    }

    @Override // com.bytedance.push.settings.storage.i
    public int d(String r2) {
        return getInt(r2, 0);
    }

    @Override // com.bytedance.push.settings.storage.i
    public float e(String r2) {
        return getFloat(r2, 0.0f);
    }

    @Override // com.bytedance.push.settings.storage.i
    public SharedPreferences.Editor edit() {
        return this.f5515a.edit();
    }

    @Override // com.bytedance.push.settings.storage.i
    public boolean getBoolean(String r2, boolean r3) {
        return this.f5515a.getBoolean(r2, r3);
    L4:
        e = move-exception;
        g(e);
        return r3;
    }

    @Override // com.bytedance.push.settings.storage.i
    public float getFloat(String r2, float r3) {
        return this.f5515a.getFloat(r2, r3);
    L4:
        e = move-exception;
        g(e);
        return r3;
    }

    @Override // com.bytedance.push.settings.storage.i
    public int getInt(String r2, int r3) {
        return this.f5515a.getInt(r2, r3);
    L4:
        e = move-exception;
        g(e);
        return r3;
    }

    @Override // com.bytedance.push.settings.storage.i
    public long getLong(String r2, long r3) {
        return this.f5515a.getLong(r2, r3);
    L4:
        e = move-exception;
        g(e);
        return r3;
    }

    @Override // com.bytedance.push.settings.storage.i
    public String getString(String r2, String r3) {
        return this.f5515a.getString(r2, r3);
    L4:
        e = move-exception;
        g(e);
        return r3;
    }

    @Override // com.bytedance.push.settings.storage.i
    public void registerValChanged(Context r1, String r2, String r3, com.bytedance.push.settings.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        a r5 = new a(this, r2, r4);
        this.f5516b.put(r4, r5);
        this.f5515a.registerOnSharedPreferenceChangeListener(r5);
    }

    @Override // com.bytedance.push.settings.storage.i
    public void unregisterValChanged(com.bytedance.push.settings.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        SharedPreferences.OnSharedPreferenceChangeListener r3 = this.f5516b.remove(r2);
        if (r3 == null) goto L8;
        this.f5515a.unregisterOnSharedPreferenceChangeListener(r3);
        return;
    }
}
