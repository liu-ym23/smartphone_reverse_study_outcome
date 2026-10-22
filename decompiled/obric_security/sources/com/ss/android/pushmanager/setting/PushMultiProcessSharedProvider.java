package com.ss.android.pushmanager.setting;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.message.util.ToolUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class PushMultiProcessSharedProvider extends ContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_APP_STATE = "current_app_state";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    public static final String SP_CONFIG_NAME = "push_multi_process_config";
    public static final String STRING_TYPE = "string";
    private static final String TAG = "PushMultiProcessSharedP";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    public static Uri sBaseUri = null;
    private static MultiProcessShared sInstance = null;
    private static boolean sIsRegisterInMainProcess = false;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
    private Map<String, Object> mContentValues;
    private Handler mHandler;
    private SharedPreferences mSharedPreferences;

    /* JADX INFO: renamed from: com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Editor {
        Context mContext;
        private ContentValues mValues;

        /* synthetic */ Editor(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Editor(Context r2) {
            this.mValues = new ContentValues();
            this.mContext = r2.getApplicationContext();
        }

        public synchronized void apply() {
            monitor-enter(this);
            this.mContext.getContentResolver().insert(PushMultiProcessSharedProvider.getContentUri(this.mContext, PushMultiProcessSharedProvider.KEY, "type"), this.mValues);     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public synchronized void commit() {
            monitor-enter(this);
            apply();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public Editor putString(String r2, String r3) {
            this.mValues.put(r2, r3);
            return this;
        }

        public Editor putLong(String r2, long r3) {
            this.mValues.put(r2, Long.valueOf(r3));
            return this;
        }

        public Editor putBoolean(String r2, boolean r3) {
            this.mValues.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public Editor putInt(String r2, int r3) {
            this.mValues.put(r2, Integer.valueOf(r3));
            return this;
        }

        public Editor putFloat(String r2, float r3) {
            this.mValues.put(r2, Float.valueOf(r3));
            return this;
        }

        public void remove(String r1) {
            this.mValues.putNull(r1);
        }

        public void clear() {
            this.mContext.getContentResolver().delete(PushMultiProcessSharedProvider.getContentUri(this.mContext, PushMultiProcessSharedProvider.KEY, "type"), null, null);     // Catch: Throwable -> L4
            return;
        }
    }

    public static class MultiProcessShared {
        private Context mContext;
        private boolean mIsMainProcess;
        private SharedPreferences mSharedPreferences;

        /* synthetic */ MultiProcessShared(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private MultiProcessShared(Context r3) {
            boolean r0 = false;
            this.mIsMainProcess = false;
            if (ToolUtils.isMainProcess(r3) == true) goto L5;
        L7:
            this.mIsMainProcess = r0;
            Context r4 = r3.getApplicationContext();
            this.mContext = r4;
            this.mSharedPreferences = r4.getApplicationContext().getSharedPreferences(PushMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
            if (Logger.debug() == false) goto L11;
            Logger.d("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (PushMultiProcessSharedProvider.access$200() == false) goto L7;
            r0 = true;
            goto L7
        }

        public Editor edit() {
            return new Editor(this.mContext, null);
        }

        public String getString(String r8, String r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getString(r8, r9);
        L7:
            return PushMultiProcessSharedProvider.access$300(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, r8, "string"), null, null, null, null), r9);
        }

        public long getLong(String r8, long r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getLong(r8, r9);
        L7:
            return PushMultiProcessSharedProvider.access$400(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, r8, "long"), null, null, null, null), r9);
        }

        public float getFloat(String r8, float r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getFloat(r8, r9);
        L7:
            return PushMultiProcessSharedProvider.access$500(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, r8, "float"), null, null, null, null), r9);
        }

        public boolean getBoolean(String r8, boolean r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getBoolean(r8, r9);
        L7:
            return PushMultiProcessSharedProvider.access$600(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, r8, "boolean"), null, null, null, null), r9);
        }

        public int getInt(String r8, int r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getInt(r8, r9);
        L7:
            return PushMultiProcessSharedProvider.access$700(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, r8, "integer"), null, null, null, null), r9);
        }

        public boolean isApplicationActive() {
            if (this.mIsMainProcess == false) goto L7;
            return isApplicationActiveInMainProcess();
        L7:
            return getBoolean(PushMultiProcessSharedProvider.KEY_APP_STATE, false);
        }

        private boolean isApplicationActiveInMainProcess() {
            return ActivityLifecycleObserver.getIns().isApplicationActive();
        }
    }

    static {
    }

    public PushMultiProcessSharedProvider() {
        this.mContentValues = new ConcurrentHashMap();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ boolean access$200() {
        return sIsRegisterInMainProcess;
    }

    static /* synthetic */ String access$300(Cursor r0, String r1) {
        return getStringValue(r0, r1);
    }

    static /* synthetic */ long access$400(Cursor r0, long r1) {
        return getLongValue(r0, r1);
    }

    static /* synthetic */ float access$500(Cursor r0, float r1) {
        return getFloatValue(r0, r1);
    }

    static /* synthetic */ boolean access$600(Cursor r0, boolean r1) {
        return getBooleanValue(r0, r1);
    }

    static /* synthetic */ int access$700(Cursor r0, int r1) {
        return getIntValue(r0, r1);
    }

    private void notifyContentChanged(Uri r2) {
        getContext().getContentResolver().notifyChange(r2, null);
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        monitor-enter(this);
        SharedPreferences r0 = this.mSharedPreferences;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        SharedPreferences r1 = getContext().getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 4);     // Catch: Throwable -> L10
        this.mSharedPreferences = r1;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    private static void init(Context r3) throws IllegalStateException {
        String r4 = getProviderAuthority(r3, PushMultiProcessSharedProvider.class.getName());
        sShareAuthority = r4;
        if (TextUtils.isEmpty(r4) == true) goto L10;
        if (Logger.debug() == false) goto L7;
        Logger.d("MultiProcessSharedProvider", sShareAuthority);
    L7:
        UriMatcher r5 = new UriMatcher(-1);
        sMatcher = r5;
        r5.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L10:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    public static String getProviderAuthority(Context r5, String r6) {
        if (r5 != null) goto L5;
    L14:
        return null;
    L5:
        if (StringUtils.isEmpty(r6) == true) goto L14;
        ProviderInfo[] r7 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r1 = r7.length;     // Catch: Exception -> L15
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        ProviderInfo r3 = r7[r2];     // Catch: Exception -> L15
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (ToolUtils.isMainProcess(getContext()) == false) goto L6;
        sIsRegisterInMainProcess = true;
    L6:
        if (sMatcher == null) goto L17;
    L15:
        wakeupMainProcess();
        return true;
    L17:
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L12
    L10:
        init(getContext());     // Catch: Exception -> L12
        loadValues();     // Catch: Exception -> L12
        goto L15
    }

    private void wakeupMainProcess() {
        if (ToolUtils.isMainProcess(getContext()) == true) goto L11;
        Intent r0 = new Intent();     // Catch: Throwable -> L6
        r0.setAction("com.ss.android.message");     // Catch: Throwable -> L6
        r0.putExtra("start_by", "PushMultiProcessSharedProvider");     // Catch: Throwable -> L6
        r0.setPackage(getContext().getPackageName());     // Catch: Throwable -> L6
        getContext().getApplicationContext().startService(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        if (sMatcher.match(r1) != 65536) goto L7;
        return 0;
    L7:
        throw new IllegalArgumentException("Unsupported uri " + r1);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r9, ContentValues r10) {
        if (sMatcher.match(r9) != 65536) goto L56;
        Iterator<Map.Entry<String, Object>> r11 = r10.valueSet().iterator();     // Catch: Exception -> L57
        SharedPreferences.Editor r1 = null;
    L7:
        if (r11.hasNext() == false) goto L51;
        Map.Entry<String, Object> r2 = r11.next();     // Catch: Exception -> L57
        Object r3 = r2.getValue();     // Catch: Exception -> L57
        String r4 = r2.getKey();     // Catch: Exception -> L57
        if (Logger.debug() == false) goto L12;
        Logger.d("PushService", "MultiProcessShareProvider insert key = " + r4 + " value = " + r3.toString());     // Catch: Exception -> L57
    L12:
        boolean r5 = true;
        if (r3 != null) goto L15;
        this.mContentValues.remove(r4);     // Catch: Exception -> L57
    L22:
        if (r5 == false) goto L7;
        if (Logger.debug() == true) goto L26;
    L30:
        if (r1 != null) goto L32;
        r1 = getMultiProcessSharedPreferences().edit();     // Catch: Exception -> L57
    L32:
        if (r3 == null) goto L33;
        if ((r3 instanceof String) == true) goto L36;
        if ((r3 instanceof Boolean) == true) goto L39;
        if ((r3 instanceof Long) == true) goto L42;
        if ((r3 instanceof Integer) == true) goto L45;
        if ((r3 instanceof Float) == false) goto L50;
        r1.putFloat(r4, ((Float) r3).floatValue());     // Catch: Exception -> L57
        notifyContentChanged(getContentUri(getContext(), r4, "float"));     // Catch: Exception -> L57
        goto L7
    L50:
        throw new IllegalArgumentException("Unsupported type " + r9);     // Catch: Exception -> L57
    L45:
        r1.putInt(r4, ((Integer) r3).intValue());     // Catch: Exception -> L57
        notifyContentChanged(getContentUri(getContext(), r4, "integer"));     // Catch: Exception -> L57
        goto L7
    L42:
        r1.putLong(r4, ((Long) r3).longValue());     // Catch: Exception -> L57
        notifyContentChanged(getContentUri(getContext(), r4, "long"));     // Catch: Exception -> L57
        goto L7
    L39:
        r1.putBoolean(r4, ((Boolean) r3).booleanValue());     // Catch: Exception -> L57
        notifyContentChanged(getContentUri(getContext(), r4, "boolean"));     // Catch: Exception -> L57
        goto L7
    L36:
        r1.putString(r4, (String) r3);     // Catch: Exception -> L57
        notifyContentChanged(getContentUri(getContext(), r4, "string"));     // Catch: Exception -> L57
        goto L7
    L33:
        r1.remove(r4);     // Catch: Exception -> L57
        goto L7
    L26:
        if (("MultiProcessShareProvider reallly insert key = " + r4 + " value = " + r3) == null) goto L28;
        String r6 = r3.toString();     // Catch: Exception -> L57
    L29:
        Logger.d("PushService", r6);     // Catch: Exception -> L57
        goto L30
    L28:
        r6 = "null";
        goto L29
    L15:
        Object r7 = this.mContentValues.get(r4);     // Catch: Exception -> L57
        if (r7 != null) goto L18;
    L21:
        this.mContentValues.put(r4, r3);     // Catch: Exception -> L57
        goto L22
    L18:
        if (r7.equals(r3) == false) goto L21;
        r5 = false;
        goto L22
    L51:
        if (r1 != null) goto L53;
        return null;
    L53:
        r1.apply();     // Catch: Exception -> L57
    L54:
        return null;
    L56:
        throw new IllegalArgumentException("Unsupported uri " + r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r4, String[] r5, String r6, String[] r7, String r8) {
        if (sMatcher.match(r4) != 65536) goto L58;
        Object r9 = null;
        String r10 = null;
        int r11 = 1;
        if ("all".equals(r4.getPathSegments().get(1)) == false) goto L34;
        Map<String, ?> r3 = getMultiProcessSharedPreferences().getAll();     // Catch: Exception -> L59
        MatrixCursor r12 = new MatrixCursor(new String[]{KEY_COLUMN, VALUE_COLUMN, TYPE_COLUMN});     // Catch: Exception -> L59
        Iterator<Map.Entry<String, ?>> r13 = r3.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        r9 = r10;
        if (r13.hasNext() == false) goto L62;
        Map.Entry<String, ?> r14 = r13.next();     // Catch: Exception -> L33
        String r15 = r14.getKey();     // Catch: Exception -> L33
        Object r16 = r14.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r17 = r12.newRow();     // Catch: Exception -> L33
        String r2 = "string";
        if ((r16 instanceof String) == true) goto L31;
        if ((r16 instanceof Boolean) == false) goto L23;
        r2 = "boolean";
        if (((Boolean) r16).booleanValue() == false) goto L20;
        int r18 = 1;
    L21:
        r16 = Integer.valueOf(r18);     // Catch: Exception -> L33
        goto L31
    L20:
        r18 = 0;
        goto L21
    L23:
        if ((r16 instanceof Integer) == false) goto L26;
        r2 = "integer";
        goto L31
    L26:
        if ((r16 instanceof Long) == false) goto L29;
        r2 = "long";
        goto L31
    L29:
        if ((r16 instanceof Float) == false) goto L31;
        r2 = "float";
    L31:
        r17.add(r15);     // Catch: Exception -> L33
        r17.add(r16);     // Catch: Exception -> L33
        r17.add(r2);     // Catch: Exception -> L33
        r10 = r15;
    L62:
        return r12;
    L33:
        r9 = r12;
        goto L73
    L34:
        String r19 = r4.getPathSegments().get(0);     // Catch: Exception -> L59
        boolean r20 = StringUtils.equal(r19, KEY_APP_STATE);     // Catch: Exception -> L59
        if (this.mContentValues.containsKey(r19) == true) goto L38;
        if (r20 == true) goto L38;
        return null;
    L38:
        MatrixCursor r1 = new MatrixCursor(new String[]{r19});     // Catch: Exception -> L59
        if (r20 == false) goto L41;
        Object r21 = Boolean.valueOf(ActivityLifecycleObserver.getIns().isApplicationActive());     // Catch: Exception -> L54
    L42:
        MatrixCursor.RowBuilder r22 = r1.newRow();     // Catch: Exception -> L54
        if ((r21 instanceof Boolean) == false) goto L50;
        if (((Boolean) r21).booleanValue() == true) goto L48;
        r11 = 0;
    L48:
        r21 = Integer.valueOf(r11);     // Catch: Exception -> L54
    L50:
        if (Logger.debug() == false) goto L52;
        Logger.d("PushService", "MultiProcessShareProvider reallly get key = " + r19 + " value = " + r21.toString());     // Catch: Exception -> L54
    L52:
        r22.add(r21);     // Catch: Exception -> L54
        r12 = r1;
        r9 = r22;
        goto L62
    L41:
        r21 = this.mContentValues.get(r19);     // Catch: Exception -> L54
    L54:
        r9 = r1;
    L73:
        return r9;
    L58:
        throw new IllegalArgumentException("Unsupported uri " + r4);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }

    private void loadValues() {
        SharedPreferences r0 = getMultiProcessSharedPreferences();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r1 = r0.getAll().entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, ?> r2 = r1.next();
        String r3 = r2.getKey();
        Object r4 = r2.getValue();
        this.mContentValues.put(r3, r4);
        goto L7
    }

    private static String getStringValue(Cursor r1, String r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getString(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    private static boolean getBooleanValue(Cursor r1, boolean r2) {
        if (r1 != null) goto L19;
        return r2;
    L19:
    L13:
        if (r1 != null) goto L17;
    L15:
        return r2;
    L17:
        r1.close();     // Catch: Exception -> L16
        goto L15
    L5:
        if (r1.moveToFirst() == false) goto L10;
        if (r1.getInt(0) <= 0) goto L9;
        r2 = true;
        goto L10
    L9:
        r2 = false;
    L10:
        if (r1 == null) goto L15;
        goto L15
    }

    private static int getIntValue(Cursor r1, int r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getInt(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    private static long getLongValue(Cursor r1, long r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getLong(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    private static float getFloatValue(Cursor r1, float r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getFloat(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    public static Editor edit(Context r2) {
        return new Editor(r2, null);
    }

    public static synchronized MultiProcessShared getMultiprocessShared(Context r3) {
        monitor-enter(PushMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new MultiProcessShared(r3, null);     // Catch: Throwable -> L10
    L7:
        MultiProcessShared r4 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(PushMultiProcessSharedProvider.class);
        return r4;
    }

    public static final synchronized Uri getContentUri(Context r3, String r4, String r5) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider> r0 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            init(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            r3 = 0
            return r3
        L1f:
            android.net.Uri r3 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L33
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            return r3
        L33:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.getContentUri(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }
}
