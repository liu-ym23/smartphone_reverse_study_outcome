package com.bytedance.apm.util;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.Constant;
import com.bytedance.librarian.LibrarianImpl;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.common.util.ToolUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {
    private static String MONITOR_CONFIG_SP_NAME = "apm_config";
    public static String MONITOR_PROVIDER_SUFFIX = ".apm6";
    private static final String TAG = "MultiProcessSharedPref";
    private Application mApp;
    private ContentResolver mContentResolver;
    private Uri mDefaultUri;
    private String mUriString;

    /* JADX INFO: renamed from: com.bytedance.apm.util.MultiProcessSharedPreferences$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mPuts;
        final /* synthetic */ MultiProcessSharedPreferences this$0;

        private EditorImpl(MultiProcessSharedPreferences r1) {
            this.this$0 = r1;
            this.mClear = false;
            this.mPuts = new HashMap();
        }

        /* synthetic */ EditorImpl(MultiProcessSharedPreferences r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, String r3) {
            this.mPuts.put(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
            this.mPuts.put(r2, com.bytedance.apm6.util.ListUtils.toArray(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.mPuts.put(r2, Integer.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            this.mPuts.put(r2, Long.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.mPuts.put(r2, Float.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.mPuts.put(r2, Boolean.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r3) {
            this.mPuts.put(r3, null);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mPuts.clear();
            this.mClear = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.mClear == false) goto L5;
        L7:
            Bundle r0 = new Bundle();
            if (this.mClear == false) goto L10;
            r0.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r1 = new ArrayList(this.mPuts.size());
            Iterator<Map.Entry<String, Object>> r2 = this.mPuts.entrySet().iterator();
        L12:
            if (r2.hasNext() == false) goto L14;
            Map.Entry<String, Object> r3 = r2.next();
            r1.add(new SpPair(r3.getKey(), r3.getValue()));
            goto L12
        L14:
            r0.putParcelableArrayList("edit", r1);
            MultiProcessSharedPreferences.access$300(this.this$0).getContentResolver().call(MultiProcessSharedPreferences.access$100(this.this$0), MultiProcessSharedPreferences.access$200(this.this$0), "edit", r0);     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            Logger.e(MultiProcessSharedPreferences.TAG, "apply exception: ", e);
            return;
        L5:
            if (this.mPuts.isEmpty() == false) goto L7;
        }
    }

    static {
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return -1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return -1;
    }

    static /* synthetic */ Uri access$100(MultiProcessSharedPreferences r0) {
        return r0.mDefaultUri;
    }

    static /* synthetic */ String access$200(MultiProcessSharedPreferences r0) {
        return r0.mUriString;
    }

    static /* synthetic */ Application access$300(MultiProcessSharedPreferences r0) {
        return r0.mApp;
    }

    public MultiProcessSharedPreferences() {
    }

    public static Uri getSpUri(Context r3) {
        String r0 = r3.getPackageName();
        String r4 = ToolUtils.getProviderAuthority(r3, MultiProcessSharedPreferences.class.getName());
        if (TextUtils.isEmpty(r4) == false) goto L5;
        Uri r5 = Uri.parse("content://" + r0 + MONITOR_PROVIDER_SUFFIX);
    L9:
        return r5.buildUpon().appendPath(CloudControlInf.SP).appendPath(MONITOR_CONFIG_SP_NAME).build();
    L5:
        r5 = Uri.parse("content://" + r4);
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(TAG, "authority is " + r5);
        goto L9
    }

    private MultiProcessSharedPreferences(Application r2) {
        this.mApp = r2;
        Uri r3 = getSpUri(r2);
        this.mDefaultUri = r3;
        this.mUriString = r3.toString();
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d(TAG, "getSpUri is " + this.mDefaultUri);
        return;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        ArrayList<SpPair> r3 = getPairs(null, null);
        if (r3 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator<SpPair> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        SpPair r1 = r4.next();
        r0.put(r1.mKey, r1.mValue);
        goto L7
    L9:
        return r0;
    }

    @Override // android.content.SharedPreferences
    public String getString(String r1, String r2) {
        ArrayList<SpPair> r0 = getPairs(r1, r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) r0.get(0).mValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r2, Set<String> r3) {
        ArrayList<SpPair> r1 = getPairs(r2, r3);
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.get(0).mValue != null) goto L8;
        return null;
    L8:
        String[] r4 = (String[]) r1.get(0).mValue;
        HashSet r5 = new HashSet(r4.length);
        r5.addAll(Arrays.asList(r4));
        return r5;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r2, int r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).mValue;
        if ((r4 instanceof Integer) == false) goto L10;
        return ((Integer) r4).intValue();
    L10:
        if ((r4 instanceof String) == true) goto L12;
        return r3;
    L12:
        return Integer.decode((String) r4).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r2, long r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).mValue;
        if ((r4 instanceof Long) == false) goto L10;
        return ((Long) r4).longValue();
    L10:
        if ((r4 instanceof String) == true) goto L12;
        return r3;
    L12:
        return Long.decode((String) r4).longValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r2, float r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).mValue;
        if ((r4 instanceof Float) == false) goto L10;
        return ((Float) r4).floatValue();
    L10:
        if ((r4 instanceof String) == true) goto L12;
        return r3;
    L12:
        return Float.valueOf((String) r4).floatValue();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r2, boolean r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = r1.get(0).mValue;
        if ((r4 instanceof Boolean) == false) goto L10;
        return ((Boolean) r4).booleanValue();
    L10:
        if ((r4 instanceof String) == true) goto L12;
        return r3;
    L12:
        return Boolean.valueOf((String) r4).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r7) {
        if (this.mDefaultUri != null) goto L5;
        return false;
    L5:
        Bundle r1 = null;
        ContentResolver r3 = this.mApp.getContentResolver();     // Catch: Throwable -> L12
        Uri r4 = this.mDefaultUri;     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        String r6 = this.mUriString + LibrarianImpl.Constants.SEPARATOR + r7;     // Catch: Throwable -> L12
    L10:
        r1 = r3.call(r4, r6, "contains", null);     // Catch: Throwable -> L12
    L14:
        if (r1 != null) goto L16;
        return false;
    L16:
        if (r1.getBoolean("contains") == false) goto L22;
        return true;
    L22:
        return false;
    L9:
        r6 = this.mUriString;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Logger.e(Constant.TAG, "contains", th);
        goto L14
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new EditorImpl(this, null);
    }

    private ArrayList<SpPair> getPairs(String r8, Object r9) {
        Bundle r0 = new Bundle();
        if (r9 == null) goto L21;
        r0.putParcelable(CloudControlInf.SP, new SpPair(r8, r9));
    L21:
        ContentResolver r3 = this.mApp.getContentResolver();     // Catch: Exception -> L16
        Uri r4 = this.mDefaultUri;     // Catch: Exception -> L16
        if (r8 == null) goto L9;
        String r10 = this.mUriString + LibrarianImpl.Constants.SEPARATOR + r8;     // Catch: Exception -> L16
    L11:
        if (r9 != null) goto L14;
        r0 = null;
    L14:
        Bundle r11 = r3.call(r4, r10, "query", r0);     // Catch: Exception -> L16
    L17:
        if (r11 != null) goto L19;
        return null;
    L19:
        r11.setClassLoader(getClass().getClassLoader());
        return r11.getParcelableArrayList(CloudControlInf.SP);
    L9:
        r10 = this.mUriString;     // Catch: Exception -> L16
    L16:
        r11 = null;
        goto L17
    }

    public static SharedPreferences getSharedPreferences(Context r0) {
        return getProviderSharedPreferences(r0);
    }

    private static SharedPreferences getProviderSharedPreferences(Context r1) {
        if ((r1 instanceof Application) == false) goto L5;
        Application r2 = (Application) r1;
    L7:
        return new MultiProcessSharedPreferences(r2);
    L5:
        r2 = (Application) r1.getApplicationContext();
        goto L7
    }

    private synchronized android.util.Pair<SharedPreferences, String> parseMethod(Uri r7) {
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
        android.util.Pair<SharedPreferences, String> r1 = new android.util.Pair(r3, r0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mContentResolver = getContext().getContentResolver();
        return false;
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
        r6 = com.bytedance.apm6.util.ListUtils.toArray((Set) r6);
    L16:
        r0.add(new SpPair(r5, r6));
        r3.putParcelableArrayList(CloudControlInf.SP, r0);
        goto L17
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r4, String r5, Bundle r6) {
        if (r6 == null) goto L4;
        r6.setClassLoader(getClass().getClassLoader());
    L4:
        android.util.Pair<SharedPreferences, String> r0 = parseMethod(Uri.parse(r4));
        Object r1 = null;
        if (r0 != null) goto L8;
        return null;
    L8:
        if ("query".equals(r5) == false) goto L16;
        if (r6 == null) goto L14;
        SpPair r7 = (SpPair) r6.getParcelable(CloudControlInf.SP);
        if (r7 == null) goto L14;
        r1 = r7.mValue;
    L14:
        return querySP((SharedPreferences) r0.first, (String) r0.second, r1);
    L16:
        if ("contains".equals(r5) == false) goto L20;
        return containsSP((SharedPreferences) r0.first, (String) r0.second);
    L20:
        if ("edit".equals(r5) == false) goto L26;
        if (r6 == null) goto L26;
        editSP((SharedPreferences) r0.first, r6);     // Catch: Throwable -> L24
        long r8 = Binder.clearCallingIdentity();     // Catch: Throwable -> L24
        this.mContentResolver.notifyChange(Uri.parse(r4), null);     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(r8);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Logger.e(TAG, "edit", th);
    L26:
        return null;
    }

    private Bundle containsSP(SharedPreferences r2, String r3) {
        Bundle r1 = new Bundle();
        r1.putBoolean("contains", r2.contains(r3));
        return r1;
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
        r1.commit();
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
}
