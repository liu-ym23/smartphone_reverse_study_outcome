package com.bytedance.apm.battery.dao;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.core.SpPair;
import com.bytedance.apm.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class MonitorContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, SQLiteOpenHelper> f1301f;

    public MonitorContentProvider() {
        this.f1301f = new HashMap();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private Bundle b(SharedPreferences r1, String r2) {
        Bundle r0 = new Bundle();
        r0.putBoolean("contains", r1.contains(r2));
        return r0;
    }

    private static void c(SharedPreferences.Editor r2, String r3, Object r4) {
        if ((r4 instanceof String) == false) goto L6;
        r2.putString(r3, (String) r4);
        return;
    L6:
        if ((r4 instanceof Integer) == false) goto L9;
        r2.putInt(r3, ((Integer) r4).intValue());
        return;
    L9:
        if ((r4 instanceof Long) == false) goto L12;
        r2.putLong(r3, ((Long) r4).longValue());
        return;
    L12:
        if ((r4 instanceof Float) == false) goto L15;
        r2.putFloat(r3, ((Float) r4).floatValue());
        return;
    L15:
        if ((r4 instanceof Boolean) == false) goto L18;
        r2.putBoolean(r3, ((Boolean) r4).booleanValue());
        return;
    L18:
        if ((r4 instanceof String[]) == false) goto L26;
        r2.putStringSet(r3, new HashSet(Arrays.asList((String[]) r4)));
        return;
    }

    private void d(SharedPreferences r2, Bundle r3) {
        SharedPreferences.Editor r1 = r2.edit();
        if (r3.getBoolean("clear") == false) goto L5;
        r1.clear();
    L5:
        ArrayList r4 = r3.getParcelableArrayList("edit");
        if (r4 != null) goto L8;
        return;
    L8:
        Iterator r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        SpPair r6 = (SpPair) r5.next();
        Object r0 = r6.f1471g;
        String r7 = r6.f1470f;
        if (r0 == null) goto L13;
        c(r1, r7, r0);
        goto L10
    L13:
        r1.remove(r7);
        goto L10
    L15:
        r1.apply();
    }

    private Bundle e() {
        Bundle r2 = new Bundle();
        r2.putInt("Pid", Process.myPid());
        return r2;
    }

    private synchronized Pair<SharedPreferences, String> f(Uri r7) {
        monitor-enter(this);
        List<String> r8 = r7.getPathSegments();     // Catch: Throwable -> L17
        String r0 = null;
        if (r8 != null) goto L6;
    L15:
        monitor-exit(this);
        return null;
    L6:
        if (r8.size() < 2) goto L15;
        if ("sp".equals(r8.get(0)) == false) goto L15;
        SharedPreferences r3 = a(getContext(), r8.get(1), 0);     // Catch: Throwable -> L17
        if (r8.size() <= 2) goto L12;
        r0 = r8.get(2);     // Catch: Throwable -> L17
    L12:
        Pair<SharedPreferences, String> r1 = new Pair(r3, r0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    private synchronized Pair<SQLiteDatabase, String> g(Uri r5) {
        monitor-enter(this);
        List<String> r6 = r5.getPathSegments();     // Catch: Throwable -> L23 Exception -> L28
        if (r6 == null) goto L26;
        if (r6.size() < 2) goto L26;
        String r1 = r6.get(0);     // Catch: Throwable -> L23 Exception -> L28
        String r7 = r6.get(1);     // Catch: Throwable -> L23 Exception -> L28
        if (r1 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        SQLiteOpenHelper r2 = this.f1301f.get(r1);     // Catch: Throwable -> L23 Exception -> L28
        if (r2 == null) goto L15;
    L20:
        Pair<SQLiteDatabase, String> r3 = new Pair(r2.getWritableDatabase(), r7);     // Catch: Throwable -> L23 Exception -> L28
        monitor-exit(this);
        return r3;
        goto L26
    L15:
        if (r1.contains("apm_monitor_t1.db") == false) goto L18;
        r2 = new b(getContext(), r1);     // Catch: Throwable -> L23 Exception -> L28
        this.f1301f.put(r1, r2);     // Catch: Throwable -> L23 Exception -> L28
        goto L20
    L18:
        monitor-exit(this);
        return null;
    L23:
        th = move-exception;
        throw th;
    L26:
        monitor-exit(this);
        return null;
    }

    private Bundle h(SharedPreferences r4, String r5, Object r6) {
        Bundle r3 = new Bundle();
        ArrayList<? extends Parcelable> r0 = new ArrayList();
        Map<String, ?> r7 = r4.getAll();
        if (r5 != null) goto L8;
        Iterator<Map.Entry<String, ?>> r8 = r7.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        Map.Entry<String, ?> r9 = r8.next();
        r0.add(new SpPair(r9.getKey(), r9.getValue()));
    L16:
        r3.putParcelableArrayList("sp", r0);
        return r3;
    L8:
        Object r10 = r7.get(r5);
        if (r10 == null) goto L13;
        r6 = r10;
    L13:
        if ((r6 instanceof Set) == false) goto L15;
        r6 = i.e((Set) r6);
    L15:
        r0.add(new SpPair(r5, r6));
        goto L16
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r3, String r4, Bundle r5) {
        if (r5 == null) goto L5;
        r5.setClassLoader(getClass().getClassLoader());
    L5:
        if ("getPid".equals(r3) == true) goto L7;
        Uri.parse(r3);
        Pair<SharedPreferences, String> r6 = f(Uri.parse(r3));
        Object r0 = null;
        if (r6 != null) goto L12;
        return null;
    L12:
        if ("query".equals(r4) == false) goto L20;
        if (r5 == null) goto L18;
        SpPair r7 = (SpPair) r5.getParcelable("sp");
        if (r7 == null) goto L18;
        r0 = r7.f1471g;
    L18:
        return h((SharedPreferences) r6.first, (String) r6.second, r0);
    L20:
        if ("contains".equals(r4) == false) goto L24;
        return b((SharedPreferences) r6.first, (String) r6.second);
    L24:
        if ("edit".equals(r4) == false) goto L27;
        if (r5 == null) goto L27;
        d((SharedPreferences) r6.first, r5);
    L27:
        return null;
    L7:
        return e();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r2, String r3, String[] r4) {
        Pair<SQLiteDatabase, String> r1 = g(r2);
        if (r1 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r0 = (SQLiteDatabase) r1.first;
        if (r0 != null) goto L11;
        return -1;
    L11:
        return r0.delete((String) r1.second, r3, r4);
    L10:
        return -1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r6, ContentValues r7) {
        Pair<SQLiteDatabase, String> r5 = g(r6);
        if (r5 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r1 = (SQLiteDatabase) r5.first;
        if (r1 != null) goto L14;
        return null;
    L14:
        long r2 = r1.insert((String) r5.second, null, r7);     // Catch: Throwable -> L13
        if (r2 < 0) goto L12;
        return ContentUris.withAppendedId(r6, r2);
    L12:
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String r0 = getContext().getPackageName() + ".apm";
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Pair<SQLiteDatabase, String> r9 = g(r10);
        if (r9 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r2 = (SQLiteDatabase) r9.first;
        if (r2 != null) goto L9;
        return null;
    L9:
        if (TextUtils.equals(r14, "rawQuery") == false) goto L13;
        return r2.rawQuery(r12, r13);
    L13:
        if (TextUtils.equals(r14, "execSQL") == false) goto L21;
        String[] r15 = r12.split(";");
        int r16 = r15.length;
        int r17 = 0;
    L15:
        if (r17 >= r16) goto L20;
        String r18 = r15[r17];
        if (TextUtils.isEmpty(r18) == true) goto L19;
        r2.execSQL(r18);
    L19:
        r17 = r17 + 1;
        goto L15
    L20:
        return null;
    L21:
        SQLiteQueryBuilder r1 = new SQLiteQueryBuilder();
        r1.setTables((String) r9.second);
        return r1.query(r2, r11, r12, r13, null, null, r14);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r2, ContentValues r3, String r4, String[] r5) {
        Pair<SQLiteDatabase, String> r1 = g(r2);
        if (r1 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r0 = (SQLiteDatabase) r1.first;
        if (r0 != null) goto L11;
        return -1;
    L11:
        return r0.update((String) r1.second, r3, r4, r5);
    L10:
        return -1;
    }
}
