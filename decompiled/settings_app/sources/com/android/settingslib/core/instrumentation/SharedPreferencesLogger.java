package com.android.settingslib.core.instrumentation;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesLogger implements SharedPreferences {
    private static final String LOG_TAG = "SharedPreferencesLogger";
    private final Context mContext;
    private final int mMetricCategory;
    private final MetricsFeatureProvider mMetricsFeature;
    private final Set<String> mPreferenceKeySet;
    private final String mTag;

    /* JADX INFO: renamed from: com.android.settingslib.core.instrumentation.SharedPreferencesLogger$1, reason: invalid class name */
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
        protected Void doInBackground2(String... r5) {
            String r0 = r5[0];
            String r6 = r5[1];
            PackageManager r2 = SharedPreferencesLogger.access$100(this.this$0).getPackageManager();
            ComponentName r3 = ComponentName.unflattenFromString(r6);     // Catch: Exception -> L12
            if (r6 == null) goto L13;
            r6 = r3.getPackageName();     // Catch: Exception -> L12
        L13:
            r2.getPackageInfo(r6, 4194304);     // Catch: PackageManager.NameNotFoundException -> L9
            this.this$0.logPackageName(r0, r6);     // Catch: PackageManager.NameNotFoundException -> L9
            return null;
        L9:
            SharedPreferencesLogger.access$200(this.this$0, r0, r6, true);
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
            SharedPreferencesLogger.access$300(this.this$0, r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r3, Set<String> r4) {
            SharedPreferencesLogger.access$300(this.this$0, r3, TextUtils.join(",", r4));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.this$0.logValue(r2, Integer.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            this.this$0.logValue(r2, Long.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.this$0.logValue(r2, Float.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.this$0.logValue(r2, Boolean.valueOf(r3));
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

    static /* synthetic */ void access$200(SharedPreferencesLogger r0, String r1, Object r2, boolean r3) {
        r0.logValue(r1, r2, r3);
    }

    static /* synthetic */ void access$300(SharedPreferencesLogger r0, String r1, String r2) {
        r0.safeLogValue(r1, r2);
    }

    public SharedPreferencesLogger(Context r2, String r3, MetricsFeatureProvider r4) {
        this(r2, r3, r4, 0);
    }

    public SharedPreferencesLogger(Context r1, String r2, MetricsFeatureProvider r3, int r4) {
        this.mContext = r1;
        this.mTag = r2;
        this.mMetricsFeature = r3;
        this.mMetricCategory = r4;
        this.mPreferenceKeySet = new ConcurrentSkipListSet();
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new EditorLogger(this);
    }

    protected void logValue(String r2, Object r3) {
        logValue(r2, r3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.android.settingslib.core.instrumentation.MetricsFeatureProvider] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void logValue(String r7, Object r8, boolean r9) {
        String r0 = buildPrefKey(this.mTag, r7);
        if (r9 == false) goto L5;
    L8:
        ?? r1 = -2147483648(0xffffffff80000000, float:-0.0);
        r1 = -2147483648(0xffffffff80000000, float:-0.0);
        if ((r8 instanceof Long) == false) goto L18;
        Long r10 = (Long) r8;
        if (r10.longValue() <= 2147483647L) goto L14;
    L12:
        r1 = 2147483647(0x7fffffff, float:NaN);
    L35:
        this.mMetricsFeature.changed(this.mMetricCategory, r7, r1);
        return;
    L14:
        if (r10.longValue() < (-2147483648L)) goto L35;
        r1 = r10.intValue();
        goto L35
    L18:
        if ((r8 instanceof Integer) == false) goto L21;
        r1 = ((Integer) r8).intValue();
        goto L35
    L21:
        if ((r8 instanceof Boolean) == false) goto L24;
        r1 = ((Boolean) r8).booleanValue();
        goto L35
    L24:
        if ((r8 instanceof Float) == false) goto L33;
        float r11 = ((Float) r8).floatValue();
        if (r11 > 2.1474836E9f) goto L12;
        if (r11 < (-2.1474836E9f)) goto L35;
        r1 = (int) r11;
        goto L35
    L33:
        if ((r8 instanceof String) == true) goto L41;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Tried to log unloggable object=" + r8);
        return;
    L41:
        r1 = Integer.parseInt((String) r8);     // Catch: NumberFormatException -> L37
    L37:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Tried to log unloggable object=" + r8);
        return;
    L5:
        if (this.mPreferenceKeySet.contains(r0) == true) goto L8;
        this.mPreferenceKeySet.add(r0);
    }

    void logPackageName(String r7, String r8) {
        this.mMetricsFeature.action(this.mMetricCategory, 853, 0, r7 + ":" + r8, 0);
    }

    private void safeLogValue(String r4, String r5) {
        new AsyncPackageCheck(this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{r4, r5});
    }

    public static String buildPrefKey(String r1, String r2) {
        return r1 + LibrarianImpl.Constants.SEPARATOR + r2;
    }
}
