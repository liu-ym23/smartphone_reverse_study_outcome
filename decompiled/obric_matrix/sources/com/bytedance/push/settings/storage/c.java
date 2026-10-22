package com.bytedance.push.settings.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class c extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f5500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5501d;

    private final class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f5502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f5503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SharedPreferences.Editor f5504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f5505d;

        a(c r1, Context r2, SharedPreferences.Editor r3) {
            this.f5505d = r1;
            this.f5503b = new ConcurrentHashMap();
            this.f5502a = r2;
            this.f5504c = r3;
        }

        private void a() {
            Iterator<Map.Entry<String, String>> r0 = this.f5503b.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry<String, String> r1 = r0.next();
            String r2 = r1.getKey();
            String r3 = r1.getValue();
            PushProvider.a(this.f5502a, c.h(this.f5505d), r2, r3).run();
            goto L4
        L6:
            this.f5503b.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.f5504c.apply();
            a();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            throw new UnsupportedOperationException("clear not support");
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            boolean r0 = this.f5504c.commit();
            a();
            return r0;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.f5504c.putBoolean(r2, r3);
            if (r3 != this.f5505d.a(r2)) goto L5;
            this.f5503b.remove(r2);
        L6:
            return this;
        L5:
            this.f5503b.put(r2, TypedValues.Custom.S_BOOLEAN);
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.f5504c.putFloat(r2, r3);
            if (r3 != this.f5505d.e(r2)) goto L5;
            this.f5503b.remove(r2);
        L6:
            return this;
        L5:
            this.f5503b.put(r2, TypedValues.Custom.S_FLOAT);
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.f5504c.putInt(r2, r3);
            if (r3 != this.f5505d.d(r2)) goto L5;
            this.f5503b.remove(r2);
        L6:
            return this;
        L5:
            this.f5503b.put(r2, TypedValues.Custom.S_INT);
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r3, long r4) {
            this.f5504c.putLong(r3, r4);
            if (r4 != this.f5505d.c(r3)) goto L5;
            this.f5503b.remove(r3);
        L6:
            return this;
        L5:
            this.f5503b.put(r3, "long");
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, String r3) {
            this.f5504c.putString(r2, r3);
            if (TextUtils.equals(this.f5505d.b(r2), r3) == false) goto L5;
            this.f5503b.remove(r2);
        L6:
            return this;
        L5:
            this.f5503b.put(r2, TypedValues.Custom.S_STRING);
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r1, Set<String> r2) {
            throw new UnsupportedOperationException("not support putStringSet");
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r2) {
            this.f5504c.remove(r2);
            this.f5503b.remove(r2);
            return this;
        }
    }

    c(Context r1, String r2) {
        super(r1, r2);
        this.f5501d = r2;
        this.f5500c = r1;
    }

    static /* synthetic */ String h(c r0) {
        return r0.f5501d;
    }

    @Override // com.bytedance.push.settings.storage.g, com.bytedance.push.settings.storage.i
    public /* bridge */ /* synthetic */ SharedPreferences.Editor edit() {
        return i();
    }

    public a i() {
        return new a(this, this.f5500c, super.edit());
    }
}
