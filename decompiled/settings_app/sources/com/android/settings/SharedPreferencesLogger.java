package com.android.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.android.internal.logging.MetricsLogger;
import com.android.settings.search.Index;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SharedPreferencesLogger implements SharedPreferences {
    private final Context mContext;
    private final String mTag;

    /* JADX INFO: renamed from: com.android.settings.SharedPreferencesLogger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AsyncPackageCheck extends AsyncTask<String, Void, Void> {
        final /* synthetic */ SharedPreferencesLogger this$0;

        private AsyncPackageCheck(SharedPreferencesLogger r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AsyncPackageCheck(SharedPreferencesLogger r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(String... r4) {
            String r0 = r4[0];
            String r5 = r4[1];
            PackageManager r1 = SharedPreferencesLogger.access$100(this.this$0).getPackageManager();
            ComponentName r2 = ComponentName.unflattenFromString(r5);     // Catch: Exception -> L13
            if (r5 == null) goto L14;
            if (r2 == null) goto L14;
            r5 = r2.getPackageName();     // Catch: Exception -> L13
        L14:
            r1.getPackageInfo(r5, 8192);     // Catch: PackageManager.NameNotFoundException -> L10
            SharedPreferencesLogger.access$200(this.this$0, r0, r5);     // Catch: PackageManager.NameNotFoundException -> L10
            return null;
        L10:
            SharedPreferencesLogger.access$300(this.this$0, r0, r5);
            return null;
        }
    }

    public class EditorLogger implements SharedPreferences.Editor {
        final /* synthetic */ SharedPreferencesLogger this$0;

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r1) {
            return this;
        }

        public EditorLogger(SharedPreferencesLogger r1) {
            this.this$0 = r1;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, String r3) {
            SharedPreferencesLogger.access$400(this.this$0, r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r3, Set<String> r4) {
            SharedPreferencesLogger.access$400(this.this$0, r3, TextUtils.join(",", r4));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            SharedPreferencesLogger.access$300(this.this$0, r2, String.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            SharedPreferencesLogger.access$300(this.this$0, r2, String.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            SharedPreferencesLogger.access$300(this.this$0, r2, String.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            SharedPreferencesLogger.access$300(this.this$0, r2, String.valueOf(r3));
            return this;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r1) {
        return false;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return null;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r1, boolean r2) {
        return r2;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r1, float r2) {
        return r2;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r1, int r2) {
        return r2;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r1, long r2) {
        return r2;
    }

    @Override // android.content.SharedPreferences
    public String getString(String r1, String r2) {
        return r2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r1, Set<String> r2) {
        return r2;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
    }

    static /* synthetic */ Context access$100(SharedPreferencesLogger r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$200(SharedPreferencesLogger r0, String r1, String r2) {
        r0.logPackageName(r1, r2);
    }

    static /* synthetic */ void access$300(SharedPreferencesLogger r0, String r1, String r2) {
        r0.logValue(r1, r2);
    }

    static /* synthetic */ void access$400(SharedPreferencesLogger r0, String r1, String r2) {
        r0.safeLogValue(r1, r2);
    }

    public SharedPreferencesLogger(Context r1, String r2) {
        this.mContext = r1;
        this.mTag = r2;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new EditorLogger(this);
    }

    private void logValue(String r3, String r4) {
        MetricsLogger.count(this.mContext, this.mTag + LibrarianImpl.Constants.SEPARATOR + r3 + Index.ENTRIES_SEPARATOR + r4, 1);
    }

    private void logPackageName(String r2, String r3) {
        MetricsLogger.count(this.mContext, this.mTag + LibrarianImpl.Constants.SEPARATOR + r2, 1);
    }

    private void safeLogValue(String r4, String r5) {
        new AsyncPackageCheck(this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{r4, r5});
    }
}
