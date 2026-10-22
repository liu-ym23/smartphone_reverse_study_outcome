package com.bytedance.common.wschannel;

import a.a;
import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    private static final String SP_CONFIG_NAME = "wschannel_multi_process_config";
    public static final String STRING_TYPE = "string";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    public static Uri sBaseUri = null;
    private static MultiProcessShared sInstance = null;
    private static boolean sIsRegisterInMainProcess = false;
    private static volatile boolean sLoadValuesInit = false;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
    private Map<String, Object> mContentValues;
    private SharedPreferences mSharedPreferences;
    private final Object sLoadValuesInitLock;

    public static class Editor {
        Context mContext;
        private ContentValues mValues;

        public /* synthetic */ Editor(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        public synchronized void apply() {
            monitor-enter(this);
            this.mContext.getContentResolver().insert(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, WsChannelMultiProcessSharedProvider.KEY, "type"), this.mValues);     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public void clear() {
            this.mContext.getContentResolver().delete(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, WsChannelMultiProcessSharedProvider.KEY, "type"), null, null);     // Catch: Throwable -> L4
            return;
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

        public Editor putBoolean(String r2, boolean r3) {
            this.mValues.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public Editor putFloat(String r2, float r3) {
            this.mValues.put(r2, Float.valueOf(r3));
            return this;
        }

        public Editor putInt(String r2, int r3) {
            this.mValues.put(r2, Integer.valueOf(r3));
            return this;
        }

        public Editor putLong(String r2, long r3) {
            this.mValues.put(r2, Long.valueOf(r3));
            return this;
        }

        public Editor putString(String r2, String r3) {
            this.mValues.put(r2, r3);
            return this;
        }

        public void remove(String r1) {
            this.mValues.putNull(r1);
        }

        private Editor(Context r2) {
            this.mValues = new ContentValues();
            this.mContext = r2.getApplicationContext();
        }
    }

    public static class MultiProcessShared {
        private Context mContext;
        private boolean mIsMainProcess;
        private SharedPreferences mSharedPreferences;

        public /* synthetic */ MultiProcessShared(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        public Editor edit() {
            return new Editor(this.mContext, null);
        }

        public boolean getBoolean(String r8, boolean r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getBoolean(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$700(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "boolean"), null, null, null, null), r9);
        }

        public float getFloat(String r8, float r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getFloat(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$600(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "float"), null, null, null, null), r9);
        }

        public int getInt(String r8, int r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getInt(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$800(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "integer"), null, null, null, null), r9);
        }

        public long getLong(String r8, long r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getLong(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$500(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, WsChannelMultiProcessSharedProvider.LONG_TYPE), null, null, null, null), r9);
        }

        public String getString(String r8, String r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getString(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$400(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "string"), null, null, null, null), r9);
        }

        private MultiProcessShared(Context r3) {
            boolean r0 = false;
            this.mIsMainProcess = false;
            if (Utils.isMainProcess(r3) == true) goto L5;
        L7:
            this.mIsMainProcess = r0;
            Context r4 = r3.getApplicationContext();
            this.mContext = r4;
            this.mSharedPreferences = r4.getApplicationContext().getSharedPreferences(WsChannelMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.access$300() == false) goto L7;
            r0 = true;
            goto L7
        }
    }

    public WsChannelMultiProcessSharedProvider() {
        this.mContentValues = new ConcurrentHashMap();
        this.sLoadValuesInitLock = new Object();
    }

    public static /* synthetic */ void access$000(WsChannelMultiProcessSharedProvider r0, Uri r1) {
        r0.notifyContentChanged(r1);
    }

    public static /* synthetic */ boolean access$300() {
        return sIsRegisterInMainProcess;
    }

    public static /* synthetic */ String access$400(Cursor r0, String r1) {
        return getStringValue(r0, r1);
    }

    public static /* synthetic */ long access$500(Cursor r0, long r1) {
        return getLongValue(r0, r1);
    }

    public static /* synthetic */ float access$600(Cursor r0, float r1) {
        return getFloatValue(r0, r1);
    }

    public static /* synthetic */ boolean access$700(Cursor r0, boolean r1) {
        return getBooleanValue(r0, r1);
    }

    public static /* synthetic */ int access$800(Cursor r0, int r1) {
        return getIntValue(r0, r1);
    }

    private Runnable createNotifyRunnable(final String r2, final String r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    public static Editor edit(Context r2) {
        return new Editor(r2, null);
    }

    private static boolean getBooleanValue(Cursor r1, boolean r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
        if (r1.moveToFirst() == false) goto L16;
        if (r1.getInt(0) <= 0) goto L9;
        r2 = true;
        goto L16
    L9:
        r2 = false;
    L16:
        r1.close();     // Catch: Exception -> L13
    L11:
        return r2;
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
            java.lang.Class<com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider> r0 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L23
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            if (r1 == 0) goto L19
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            goto L19
        L15:
            r3 = move-exception
            goto L37
        L17:
            r3 = move-exception
            goto L1d
        L19:
            init(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            goto L23
        L1d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            r3 = 0
            return r3
        L23:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L15
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            return r3
        L37:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.getContentUri(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    private static float getFloatValue(Cursor r1, float r2) {
        if (r1 != null) goto L11;
        return r2;
    L11:
        if (r1.moveToFirst() == false) goto L13;
        r2 = r1.getFloat(0);     // Catch: Throwable -> L9
    L13:
        r1.close();     // Catch: Exception -> L10
    L8:
        return r2;
    }

    private static int getIntValue(Cursor r1, int r2) {
        if (r1 != null) goto L11;
        return r2;
    L11:
        if (r1.moveToFirst() == false) goto L13;
        r2 = r1.getInt(0);     // Catch: Throwable -> L9
    L13:
        r1.close();     // Catch: Exception -> L10
    L8:
        return r2;
    }

    private static long getLongValue(Cursor r1, long r2) {
        if (r1 != null) goto L11;
        return r2;
    L11:
        if (r1.moveToFirst() == false) goto L13;
        r2 = r1.getLong(0);     // Catch: Throwable -> L9
    L13:
        r1.close();     // Catch: Exception -> L10
    L8:
        return r2;
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        monitor-enter(this);
        SharedPreferences r0 = this.mSharedPreferences;     // Catch: Throwable -> L8
        if (r0 != null) goto L10;
        SharedPreferences r1 = getContext().getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 4);     // Catch: Throwable -> L8
        this.mSharedPreferences = r1;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    L10:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized MultiProcessShared getMultiprocessShared(Context r3) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new MultiProcessShared(r3, null);     // Catch: Throwable -> L7
    L9:
        MultiProcessShared r4 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r4;
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

    private static String getStringValue(Cursor r1, String r2) {
        if (r1 != null) goto L11;
        return r2;
    L11:
        if (r1.moveToFirst() == false) goto L13;
        r2 = r1.getString(0);     // Catch: Throwable -> L9
    L13:
        r1.close();     // Catch: Exception -> L10
    L8:
        return r2;
    }

    private static void init(Context r3) {
        if (TextUtils.isEmpty(sShareAuthority) == false) goto L6;
        sShareAuthority = getProviderAuthority(r3, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(sShareAuthority) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", sShareAuthority);
    L10:
        UriMatcher r4 = new UriMatcher(-1);
        sMatcher = r4;
        r4.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    private void loadValues() {
        if (sLoadValuesInit == true) goto L24;
        Object r0 = this.sLoadValuesInitLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sLoadValuesInit == true) goto L20;
        SharedPreferences r1 = getMultiProcessSharedPreferences();     // Catch: Throwable -> L13
        if (r1 != null) goto L15;
        sLoadValuesInit = true;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        Iterator<Map.Entry<String, ?>> r2 = r1.getAll().entrySet().iterator();     // Catch: Throwable -> L13
    L17:
        if (r2.hasNext() == false) goto L19;
        Map.Entry<String, ?> r3 = r2.next();     // Catch: Throwable -> L13
        String r4 = r3.getKey();     // Catch: Throwable -> L13
        Object r5 = r3.getValue();     // Catch: Throwable -> L13
        this.mContentValues.put(r4, r5);     // Catch: Throwable -> L13
        goto L17
    L19:
        sLoadValuesInit = true;     // Catch: Throwable -> L13
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    }

    private void notifyContentChanged(Uri r2) {
        getContext().getContentResolver().notifyChange(r2, null);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        if (r3 == null) goto L4;
        sShareAuthority = r3.authority;
    L4:
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        if (sMatcher.match(r1) != 65536) goto L8;
        getMultiProcessSharedPreferences().edit().clear().commit();     // Catch: Exception -> L9
        this.mContentValues.clear();     // Catch: Exception -> L9
        notifyContentChanged(getContentUri(getContext(), KEY, "type"));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r1);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        return a.o(new StringBuilder("vnd.android.cursor.item/vnd."), sShareAuthority, ".item");
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"NewApi"})
    public Uri insert(Uri r10, ContentValues r11) {
        if (sMatcher.match(r10) != 65536) goto L58;
        loadValues();     // Catch: Exception -> L59
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L59
        Iterator<Map.Entry<String, Object>> r12 = r11.valueSet().iterator();     // Catch: Exception -> L59
        SharedPreferences.Editor r2 = null;
    L7:
        if (r12.hasNext() == false) goto L49;
        Map.Entry<String, Object> r3 = r12.next();     // Catch: Exception -> L59
        Object r4 = r3.getValue();     // Catch: Exception -> L59
        String r5 = r3.getKey();     // Catch: Exception -> L59
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r5 + " value = " + r4.toString());     // Catch: Exception -> L59
    L12:
        if (r4 == null) goto L13;
        Object r6 = this.mContentValues.get(r5);     // Catch: Exception -> L59
        if (r6 == null) goto L18;
        if (r6.equals(r4) == true) goto L7;
    L18:
        this.mContentValues.put(r5, r4);     // Catch: Exception -> L59
    L20:
        if (Logger.debug() == true) goto L22;
    L26:
        if (r2 != null) goto L28;
        r2 = getMultiProcessSharedPreferences().edit();     // Catch: Exception -> L59
    L28:
        if (r4 != null) goto L31;
        r2.remove(r5);     // Catch: Exception -> L59
        Runnable r7 = null;
    L45:
        if (r7 == null) goto L7;
        r1.add(r7);     // Catch: Exception -> L59
        goto L7
    L31:
        if ((r4 instanceof String) == false) goto L34;
        r2.putString(r5, (String) r4);     // Catch: Exception -> L59
        r7 = createNotifyRunnable(r5, "string");     // Catch: Exception -> L59
        goto L45
    L34:
        if ((r4 instanceof Boolean) == false) goto L37;
        r2.putBoolean(r5, ((Boolean) r4).booleanValue());     // Catch: Exception -> L59
        r7 = createNotifyRunnable(r5, "boolean");     // Catch: Exception -> L59
        goto L45
    L37:
        if ((r4 instanceof Long) == false) goto L40;
        r2.putLong(r5, ((Long) r4).longValue());     // Catch: Exception -> L59
        r7 = createNotifyRunnable(r5, LONG_TYPE);     // Catch: Exception -> L59
        goto L45
    L40:
        if ((r4 instanceof Integer) == false) goto L43;
        r2.putInt(r5, ((Integer) r4).intValue());     // Catch: Exception -> L59
        r7 = createNotifyRunnable(r5, "integer");     // Catch: Exception -> L59
        goto L45
    L43:
        if ((r4 instanceof Float) == false) goto L48;
        r2.putFloat(r5, ((Float) r4).floatValue());     // Catch: Exception -> L59
        r7 = createNotifyRunnable(r5, "float");     // Catch: Exception -> L59
        goto L45
    L48:
        throw new IllegalArgumentException("Unsupported type " + r10);     // Catch: Exception -> L59
    L22:
        if (("MultiProcessShareProvider reallly insert key = " + r5 + " value = " + r4) == null) goto L24;
        String r8 = r4.toString();     // Catch: Exception -> L59
    L25:
        Logger.v("PushService", r8);     // Catch: Exception -> L59
        goto L26
    L24:
        r8 = "null";
        goto L25
    L13:
        this.mContentValues.remove(r5);     // Catch: Exception -> L59
        goto L20
    L49:
        if (r2 != null) goto L51;
        return null;
    L51:
        r2.apply();     // Catch: Exception -> L59
        Iterator r9 = r1.iterator();     // Catch: Exception -> L59
    L53:
        if (r9.hasNext() == false) goto L56;
        ((Runnable) r9.next()).run();     // Catch: Exception -> L59
    L56:
        return null;
    L58:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (Utils.isMainProcess(getContext()) == false) goto L5;
        sIsRegisterInMainProcess = true;
    L5:
        WsChannelSdk2.monitorLifeCycle(getContext());
        if (sMatcher == null) goto L17;
    L16:
        return true;
    L17:
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L12;
        Logger.v("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L10
    L12:
        init(getContext());     // Catch: Exception -> L10
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r2, String[] r3, String r4, String[] r5, String r6) {
        if (sMatcher.match(r2) != 65536) goto L46;
        Object r7 = null;
        String r8 = null;
        if (ALL_TYPE.equals(r2.getPathSegments().get(1)) == false) goto L30;
        Map<String, ?> r1 = getMultiProcessSharedPreferences().getAll();     // Catch: Exception -> L47
        MatrixCursor r9 = new MatrixCursor(new String[]{KEY_COLUMN, VALUE_COLUMN, TYPE_COLUMN});     // Catch: Exception -> L47
        Iterator<Map.Entry<String, ?>> r10 = r1.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        r7 = r8;
        if (r10.hasNext() == false) goto L50;
        Map.Entry<String, ?> r11 = r10.next();     // Catch: Exception -> L18
        String r12 = r11.getKey();     // Catch: Exception -> L18
        Object r13 = r11.getValue();     // Catch: Exception -> L18
        MatrixCursor.RowBuilder r14 = r9.newRow();     // Catch: Exception -> L18
        String r0 = "string";
        if ((r13 instanceof String) == true) goto L28;
        if ((r13 instanceof Boolean) == false) goto L20;
        r0 = "boolean";
        r13 = Integer.valueOf(((Boolean) r13).booleanValue() ? 1 : 0);     // Catch: Exception -> L18
        goto L28
    L20:
        if ((r13 instanceof Integer) == false) goto L23;
        r0 = "integer";
        goto L28
    L23:
        if ((r13 instanceof Long) == false) goto L26;
        r0 = LONG_TYPE;
        goto L28
    L26:
        if ((r13 instanceof Float) == false) goto L28;
        r0 = "float";
    L28:
        r14.add(r12);     // Catch: Exception -> L18
        r14.add(r13);     // Catch: Exception -> L18
        r14.add(r0);     // Catch: Exception -> L18
        r8 = r12;
    L50:
        return r9;
    L18:
        r7 = r9;
        goto L61
    L30:
        String r15 = r2.getPathSegments().get(0);     // Catch: Exception -> L47
        loadValues();     // Catch: Exception -> L47
        if (this.mContentValues.containsKey(r15) == true) goto L33;
        return null;
    L33:
        MatrixCursor r16 = new MatrixCursor(new String[]{r15});     // Catch: Exception -> L47
        Object r17 = this.mContentValues.get(r15);     // Catch: Exception -> L37
        MatrixCursor.RowBuilder r18 = r16.newRow();     // Catch: Exception -> L37
        if ((r17 instanceof Boolean) == false) goto L39;
        r17 = Integer.valueOf(((Boolean) r17).booleanValue() ? 1 : 0);     // Catch: Exception -> L37
    L39:
        if (Logger.debug() == false) goto L41;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r15 + " value = " + r17.toString());     // Catch: Exception -> L37
    L41:
        r18.add(r17);     // Catch: Exception -> L37
        r9 = r16;
        r7 = r18;
    L37:
        r7 = r16;
    L61:
        return r7;
    L46:
        throw new IllegalArgumentException("Unsupported uri " + r2);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }
}
