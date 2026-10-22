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
import com.bytedance.apm.util.ListUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MonitorContentProvider extends ContentProvider {
    public static String AUTHORITY;
    private final Map<String, SQLiteOpenHelper> mDBHelpers;

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    public MonitorContentProvider() {
        this.mDBHelpers = new HashMap();
    }

    private synchronized Pair<SQLiteDatabase, String> parseUri(Uri r5) {
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
        SQLiteOpenHelper r2 = this.mDBHelpers.get(r1);     // Catch: Throwable -> L23 Exception -> L28
        if (r2 == null) goto L15;
    L20:
        Pair<SQLiteDatabase, String> r3 = new Pair(r2.getWritableDatabase(), r7);     // Catch: Throwable -> L23 Exception -> L28
        monitor-exit(this);
        return r3;
        goto L26
    L15:
        if (r1.contains(DBHelper.DB_NAME) == false) goto L18;
        r2 = new DBHelper(getContext(), r1);     // Catch: Throwable -> L23 Exception -> L28
        this.mDBHelpers.put(r1, r2);     // Catch: Throwable -> L23 Exception -> L28
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

    private synchronized Pair<SharedPreferences, String> parseMethod(Uri r7) {
        monitor-enter(this);
        List<String> r8 = r7.getPathSegments();     // Catch: Throwable -> L17
        String r0 = null;
        if (r8 != null) goto L6;
    L15:
        monitor-exit(this);
        return null;
    L6:
        if (r8.size() < 2) goto L15;
        if (CloudControlInf.SP.equals(r8.get(0)) == false) goto L15;
        SharedPreferences r3 = getContext().getSharedPreferences(r8.get(1), 0);     // Catch: Throwable -> L17
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

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        AUTHORITY = getContext().getPackageName() + ".apm";
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Pair<SQLiteDatabase, String> r9 = parseUri(r10);
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

    private Bundle querySP(SharedPreferences r4, String r5, Object r6) {
        Bundle r3 = new Bundle();
        ArrayList<? extends Parcelable> r0 = new ArrayList();
        if (r5 != null) goto L9;
        Iterator<Map.Entry<String, ?>> r7 = r4.getAll().entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry<String, ?> r8 = r7.next();
        r0.add(new SpPair(r8.getKey(), r8.getValue()));
        goto L6
    L8:
        r3.putParcelableArrayList(CloudControlInf.SP, r0);
    L17:
        return r3;
    L9:
        Object r9 = r4.getAll().get(r5);
        if (r9 == null) goto L14;
        r6 = r9;
    L14:
        if ((r6 instanceof Set) == false) goto L16;
        r6 = ListUtils.toArray((Set) r6);
    L16:
        r0.add(new SpPair(r5, r6));
        r3.putParcelableArrayList(CloudControlInf.SP, r0);
        goto L17
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r3, String r4, Bundle r5) {
        if (r5 == null) goto L5;
        r5.setClassLoader(getClass().getClassLoader());
    L5:
        if ("getPid".equals(r3) == true) goto L7;
        Uri.parse(r3);
        Pair<SharedPreferences, String> r6 = parseMethod(Uri.parse(r3));
        Object r0 = null;
        if (r6 != null) goto L12;
        return null;
    L12:
        if ("query".equals(r4) == false) goto L20;
        if (r5 == null) goto L18;
        SpPair r7 = (SpPair) r5.getParcelable(CloudControlInf.SP);
        if (r7 == null) goto L18;
        r0 = r7.mValue;
    L18:
        return querySP((SharedPreferences) r6.first, (String) r6.second, r0);
    L20:
        if ("contains".equals(r4) == false) goto L24;
        return containsSP((SharedPreferences) r6.first, (String) r6.second);
    L24:
        if ("edit".equals(r4) == false) goto L27;
        if (r5 == null) goto L27;
        editSP((SharedPreferences) r6.first, r5);
    L27:
        return null;
    L7:
        return getPID();
    }

    private Bundle containsSP(SharedPreferences r2, String r3) {
        Bundle r1 = new Bundle();
        r1.putBoolean("contains", r2.contains(r3));
        return r1;
    }

    private Bundle getPID() {
        Bundle r2 = new Bundle();
        r2.putInt("Pid", Process.myPid());
        return r2;
    }

    private void editSP(SharedPreferences r2, Bundle r3) {
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
        if (r6.mValue == null) goto L13;
        edit(r1, r6.mKey, r6.mValue);
        goto L10
    L13:
        r1.remove(r6.mKey);
        goto L10
    L15:
        r1.apply();
    }

    private static void edit(SharedPreferences.Editor r2, String r3, Object r4) {
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

    @Override // android.content.ContentProvider
    public Uri insert(Uri r6, ContentValues r7) {
        Pair<SQLiteDatabase, String> r5 = parseUri(r6);
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
    public int delete(Uri r2, String r3, String[] r4) {
        Pair<SQLiteDatabase, String> r1 = parseUri(r2);
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
    public int update(Uri r2, ContentValues r3, String r4, String[] r5) {
        Pair<SQLiteDatabase, String> r1 = parseUri(r2);
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

    public static void execSQLForResolver(Context r6, Uri r7, String r8) {
        r6.getContentResolver().query(r7, null, r8, null, "execSQL");     // Catch: Exception -> L4
        return;
    }

    public static Cursor rawQueryForResolver(Context r6, Uri r7, String r8, String[] r9) {
        return r6.getContentResolver().query(r7, null, r8, r9, "rawQuery");
    L4:
        return null;
    }
}
