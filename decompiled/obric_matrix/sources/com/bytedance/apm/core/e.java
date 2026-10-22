package com.bytedance.apm.core;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.apm.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class e implements SharedPreferences {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f1472d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f1473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f1475c;

    static /* synthetic */ class a {
    }

    private class b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private HashMap<String, Object> f1477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f1478c;

        private b(e r1) {
            this.f1478c = r1;
            this.f1476a = false;
            this.f1477b = new HashMap();
        }

        /* synthetic */ b(e r1, a r2) {
            this(r1);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.f1476a == false) goto L5;
        L7:
            Bundle r0 = new Bundle();
            if (this.f1476a == false) goto L10;
            r0.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r1 = new ArrayList(this.f1477b.size());
            Iterator<Map.Entry<String, Object>> r2 = this.f1477b.entrySet().iterator();
        L12:
            if (r2.hasNext() == false) goto L14;
            Map.Entry<String, Object> r3 = r2.next();
            r1.add(new SpPair(r3.getKey(), r3.getValue()));
            goto L12
        L14:
            r0.putParcelableArrayList("edit", r1);
            e.d(this.f1478c).getContentResolver().call(e.b(this.f1478c), e.c(this.f1478c), "edit", r0);     // Catch: Exception -> L17
            return;
        L21:
            return;
        L5:
            if (this.f1477b.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f1477b.clear();
            this.f1476a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.f1477b.put(r2, Boolean.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.f1477b.put(r2, Float.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.f1477b.put(r2, Integer.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            this.f1477b.put(r2, Long.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, String r3) {
            this.f1477b.put(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
            this.f1477b.put(r2, i.e(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r3) {
            this.f1477b.put(r3, null);
            return this;
        }
    }

    static {
    }

    private e(Application r3, String r4) {
        this.f1473a = r3;
        String r5 = "content://" + r3.getPackageName() + ".apm/sp/" + r4;
        this.f1474b = r5;
        this.f1475c = Uri.parse(r5);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ Uri b(e r0) {
        return r0.f1475c;
    }

    static /* synthetic */ String c(e r0) {
        return r0.f1474b;
    }

    static /* synthetic */ Application d(e r0) {
        return r0.f1473a;
    }

    private ArrayList<SpPair> e(String r7, Object r8) {
        Bundle r0 = new Bundle();
        if (r8 == null) goto L21;
        r0.putParcelable("sp", new SpPair(r7, r8));
    L21:
        ContentResolver r3 = this.f1473a.getContentResolver();     // Catch: Exception -> L16
        Uri r4 = this.f1475c;     // Catch: Exception -> L16
        if (r7 == null) goto L9;
        String r6 = this.f1474b + "/" + r7;     // Catch: Exception -> L16
    L11:
        if (r8 != null) goto L14;
        r0 = null;
    L14:
        Bundle r9 = r3.call(r4, r6, "query", r0);     // Catch: Exception -> L16
    L17:
        if (r9 != null) goto L19;
        return null;
    L19:
        r9.setClassLoader(e.class.getClassLoader());
        return r9.getParcelableArrayList("sp");
    L9:
        r6 = this.f1474b;     // Catch: Exception -> L16
    L16:
        r9 = null;
        goto L17
    }

    private static int f(Context r4) {
        Bundle r5 = r4.getContentResolver().call(Uri.parse("content://" + r4.getPackageName() + ".apm"), "getPid", null, null);     // Catch: Exception -> L8
        if (r5 == null) goto L7;
        return r5.getInt("Pid", -1);
    L7:
        return -1;
    }

    static SharedPreferences g(Context r1, String r2) {
        if ((r1 instanceof Application) == true) goto L7;
        r1 = r1.getApplicationContext();
    L7:
        return new e((Application) r1, r2);
    }

    public static SharedPreferences h(Context r1, String r2) {
        if (i(r1) == false) goto L7;
        return a(r1, r2, 0);
    L7:
        return g(r1, r2);
    }

    public static boolean i(Context r2) {
        if (f1472d != (-1)) goto L6;
        f1472d = f(r2);
    L6:
        if (f1472d != Process.myPid()) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r6) {
        Bundle r1 = null;
        ContentResolver r2 = this.f1473a.getContentResolver();     // Catch: Exception -> L14
        Uri r3 = this.f1475c;     // Catch: Exception -> L14
        if (r6 == null) goto L6;
        String r5 = this.f1474b + "/" + r6;     // Catch: Exception -> L14
    L7:
        r1 = r2.call(r3, r5, "contains", null);     // Catch: Exception -> L14
        goto L8
    L6:
        r5 = this.f1474b;     // Catch: Exception -> L14
    L8:
        if (r1 != null) goto L10;
    L12:
        return false;
    L10:
        if (r1.getBoolean("contains") == false) goto L12;
        return true;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, null);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        ArrayList<SpPair> r3 = e(null, null);
        if (r3 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator<SpPair> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        SpPair r1 = r4.next();
        r0.put(r1.f1470f, r1.f1471g);
        goto L7
    L9:
        return r0;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r2, boolean r3) {
        ArrayList<SpPair> r1 = e(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).f1471g;
        if ((r4 instanceof Boolean) == false) goto L11;
        Boolean r5 = (Boolean) r4;
    L9:
        return r5.booleanValue();
    L11:
        if ((r4 instanceof String) == false) goto L13;
        r5 = Boolean.valueOf((String) r4);
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r2, float r3) {
        ArrayList<SpPair> r1 = e(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).f1471g;
        if ((r4 instanceof Float) == false) goto L11;
        Float r5 = (Float) r4;
    L9:
        return r5.floatValue();
    L11:
        if ((r4 instanceof String) == false) goto L13;
        r5 = Float.valueOf((String) r4);
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r2, int r3) {
        ArrayList<SpPair> r1 = e(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).f1471g;
        if ((r4 instanceof Integer) == false) goto L11;
        Integer r5 = (Integer) r4;
    L9:
        return r5.intValue();
    L11:
        if ((r4 instanceof String) == false) goto L13;
        r5 = Integer.decode((String) r4);
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r2, long r3) {
        ArrayList<SpPair> r1 = e(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).f1471g;
        if ((r4 instanceof Long) == false) goto L11;
        Long r5 = (Long) r4;
    L9:
        return r5.longValue();
    L11:
        if ((r4 instanceof String) == false) goto L13;
        r5 = Long.decode((String) r4);
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public String getString(String r1, String r2) {
        ArrayList<SpPair> r0 = e(r1, r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) r0.get(0).f1471g;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r2, Set<String> r3) {
        ArrayList<SpPair> r1 = e(r2, r3);
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.get(0).f1471g != null) goto L8;
        return null;
    L8:
        String[] r4 = (String[]) r1.get(0).f1471g;
        HashSet r5 = new HashSet(r4.length);
        r5.addAll(Arrays.asList(r4));
        return r5;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }
}
