package com.bytedance.apm.core;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MonitorSharedPreferences implements SharedPreferences {
    private static int sTargetPID = -1;
    private Application mApp;
    private Uri mDefaultUri;
    private String mUriString;

    /* JADX INFO: renamed from: com.bytedance.apm.core.MonitorSharedPreferences$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mPuts;
        final /* synthetic */ MonitorSharedPreferences this$0;

        private EditorImpl(MonitorSharedPreferences r1) {
            this.this$0 = r1;
            this.mClear = false;
            this.mPuts = new HashMap();
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
            MonitorSharedPreferences.access$300(this.this$0).getContentResolver().call(MonitorSharedPreferences.access$100(this.this$0), MonitorSharedPreferences.access$200(this.this$0), "edit", r0);     // Catch: Exception -> L17
            return;
        L21:
            return;
        L5:
            if (this.mPuts.isEmpty() == false) goto L7;
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
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.mPuts.put(r2, Boolean.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.mPuts.put(r2, Float.valueOf(r3));
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
        public SharedPreferences.Editor putString(String r2, String r3) {
            this.mPuts.put(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
            this.mPuts.put(r2, ListUtils.toArray(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r3) {
            this.mPuts.put(r3, null);
            return this;
        }

        public /* synthetic */ EditorImpl(MonitorSharedPreferences r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    private MonitorSharedPreferences(Application r3, String r4) {
        this.mApp = r3;
        String r5 = "content://" + r3.getPackageName() + ".apm/sp/" + r4;
        this.mUriString = r5;
        this.mDefaultUri = Uri.parse(r5);
    }

    public static /* synthetic */ Uri access$100(MonitorSharedPreferences r0) {
        return r0.mDefaultUri;
    }

    public static /* synthetic */ String access$200(MonitorSharedPreferences r0) {
        return r0.mUriString;
    }

    public static /* synthetic */ Application access$300(MonitorSharedPreferences r0) {
        return r0.mApp;
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

    private static int getProviderPID(Context r4) {
        Bundle r5 = r4.getContentResolver().call(Uri.parse("content://" + r4.getPackageName() + ".apm"), "getPid", null, null);     // Catch: Exception -> L8
        if (r5 == null) goto L7;
        return r5.getInt("Pid", -1);
    L7:
        return -1;
    }

    public static SharedPreferences getProviderSharedPreferences(Context r1, String r2) {
        if ((r1 instanceof Application) == false) goto L5;
        Application r3 = (Application) r1;
    L7:
        return new MonitorSharedPreferences(r3, r2);
    L5:
        r3 = (Application) r1.getApplicationContext();
        goto L7
    }

    public static SharedPreferences getSharedPreferences(Context r1, String r2) {
        if (isProviderProcess(r1) == false) goto L7;
        return r1.getSharedPreferences(r2, 0);
    L7:
        return getProviderSharedPreferences(r1, r2);
    }

    public static boolean isProviderProcess(Context r2) {
        if (sTargetPID != (-1)) goto L6;
        sTargetPID = getProviderPID(r2);
    L6:
        if (sTargetPID != Process.myPid()) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r6) {
        Bundle r1 = null;
        ContentResolver r2 = this.mApp.getContentResolver();     // Catch: Exception -> L14
        Uri r3 = this.mDefaultUri;     // Catch: Exception -> L14
        if (r6 == null) goto L6;
        String r5 = this.mUriString + LibrarianImpl.Constants.SEPARATOR + r6;     // Catch: Exception -> L14
    L7:
        r1 = r2.call(r3, r5, "contains", null);     // Catch: Exception -> L14
        goto L8
    L6:
        r5 = this.mUriString;     // Catch: Exception -> L14
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
        return new EditorImpl(this, null);
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
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }
}
