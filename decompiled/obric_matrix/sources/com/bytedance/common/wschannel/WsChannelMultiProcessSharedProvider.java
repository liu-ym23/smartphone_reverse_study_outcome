package com.bytedance.common.wschannel;

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
import android.os.Build;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f3322i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Uri f3323j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static UriMatcher f3324k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f3325l = false;
    private static volatile boolean m = false;
    private static c n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f3326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Object> f3327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f3328h;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3329f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3330g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ WsChannelMultiProcessSharedProvider f3331h;

        a(WsChannelMultiProcessSharedProvider r1, String r2, String r3) {
            this.f3331h = r1;
            this.f3329f = r2;
            this.f3330g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            WsChannelMultiProcessSharedProvider r0 = this.f3331h;
            WsChannelMultiProcessSharedProvider.c(r0, WsChannelMultiProcessSharedProvider.k(r0.getContext(), this.f3329f, this.f3330g));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f3332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ContentValues f3333b;

        private b(Context r2) {
            this.f3333b = new ContentValues();
            this.f3332a = r2.getApplicationContext();
        }

        /* synthetic */ b(Context r1, a r2) {
            this(r1);
        }

        public synchronized void a() {
            monitor-enter(this);
            this.f3332a.getContentResolver().insert(WsChannelMultiProcessSharedProvider.k(this.f3332a, "key", WsConstants.KEY_CONNECTION_TYPE), this.f3333b);     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public synchronized void b() {
            monitor-enter(this);
            a();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public b c(String r2, boolean r3) {
            this.f3333b.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public b d(String r2, String r3) {
            this.f3333b.put(r2, r3);
            return this;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f3334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SharedPreferences f3336c;

        private c(Context r3) {
            boolean r0 = false;
            this.f3335b = false;
            if (com.bytedance.common.wschannel.u.c.i(r3) == true) goto L5;
        L7:
            this.f3335b = r0;
            Context r4 = r3.getApplicationContext();
            this.f3334a = r4;
            this.f3336c = a(r4.getApplicationContext(), "wschannel_multi_process_config", 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.e() == false) goto L7;
            r0 = true;
            goto L7
        }

        /* synthetic */ c(Context r1, a r2) {
            this(r1);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public b b() {
            return new b(this.f3334a, null);
        }

        public boolean c(String r8, boolean r9) {
        L8:
            return r9;
        L3:
            if (this.f3335b == false) goto L7;
            return this.f3336c.getBoolean(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.h(this.f3334a.getContentResolver().query(WsChannelMultiProcessSharedProvider.k(this.f3334a, r8, TypedValues.Custom.S_BOOLEAN), null, null, null, null), r9);
        }

        public long d(String r8, long r9) {
        L8:
            return r9;
        L3:
            if (this.f3335b == false) goto L7;
            return this.f3336c.getLong(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.g(this.f3334a.getContentResolver().query(WsChannelMultiProcessSharedProvider.k(this.f3334a, r8, "long"), null, null, null, null), r9);
        }

        public String e(String r8, String r9) {
        L8:
            return r9;
        L3:
            if (this.f3335b == false) goto L7;
            return this.f3336c.getString(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.f(this.f3334a.getContentResolver().query(WsChannelMultiProcessSharedProvider.k(this.f3334a, r8, TypedValues.Custom.S_STRING), null, null, null, null), r9);
        }
    }

    static {
    }

    public WsChannelMultiProcessSharedProvider() {
        this.f3327g = new ConcurrentHashMap();
        this.f3328h = new Object();
    }

    @Proxy("monitorLifeCycle")
    @TargetClass(scope = Scope.SELF, value = "com.bytedance.common.wschannel.WsChannelSdk2")
    public static void a(Context r1) {
        d(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.matrix.r.c.c.h("monitorLifeCycle error", th);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences b(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ void c(WsChannelMultiProcessSharedProvider r0, Uri r1) {
        r0.s(r1);
    }

    static /* synthetic */ void d(Context r0) {
        n.g(r0);
    }

    static /* synthetic */ boolean e() {
        return f3325l;
    }

    static /* synthetic */ String f(Cursor r0, String r1) {
        return p(r0, r1);
    }

    static /* synthetic */ long g(Cursor r0, long r1) {
        return l(r0, r1);
    }

    static /* synthetic */ boolean h(Cursor r0, boolean r1) {
        return j(r0, r1);
    }

    private Runnable i(String r2, String r3) {
        return new a(this, r2, r3);
    }

    private static boolean j(Cursor r1, boolean r2) {
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

    public static final synchronized Uri k(Context r3, String r4, String r5) {
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
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f3323j     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            q(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            r3 = 0
            monitor-exit(r0)
            return r3
        L1f:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f3323j     // Catch: java.lang.Throwable -> L33
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.k(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    private static long l(Cursor r1, long r2) {
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

    private synchronized SharedPreferences m() {
        monitor-enter(this);
        SharedPreferences r0 = this.f3326f;     // Catch: Throwable -> L14
        if (r0 != null) goto L12;
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        Context r2 = getContext().getApplicationContext();     // Catch: Throwable -> L14
        if (r1 < 11) goto L8;
        int r3 = 4;
    L9:
        SharedPreferences r4 = b(r2, "wschannel_multi_process_config", r3);     // Catch: Throwable -> L14
        this.f3326f = r4;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L8:
        r3 = 0;
        goto L9
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized c n(Context r3) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (n != null) goto L7;
        n = new c(r3, null);     // Catch: Throwable -> L10
    L7:
        c r4 = n;     // Catch: Throwable -> L10
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r4;
    }

    public static String o(Context r5, String r6) {
        if (r5 != null) goto L5;
    L14:
        return null;
    L5:
        if (com.bytedance.common.utility.k.c(r6) == true) goto L14;
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

    private static String p(Cursor r1, String r2) {
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

    private static void q(Context r3) {
        if (TextUtils.isEmpty(f3322i) == false) goto L6;
        f3322i = o(r3, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f3322i) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", f3322i);
    L10:
        UriMatcher r4 = new UriMatcher(-1);
        f3324k = r4;
        r4.addURI(f3322i, "*/*", 65536);
        f3323j = Uri.parse("content://" + f3322i);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    private void r() {
        if (m == true) goto L23;
        Object r0 = this.f3328h;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (m == true) goto L18;
        SharedPreferences r1 = m();     // Catch: Throwable -> L20
        if (r1 != null) goto L13;
        m = true;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L13:
        Iterator<Map.Entry<String, ?>> r2 = r1.getAll().entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<String, ?> r3 = r2.next();     // Catch: Throwable -> L20
        String r4 = r3.getKey();     // Catch: Throwable -> L20
        Object r5 = r3.getValue();     // Catch: Throwable -> L20
        this.f3327g.put(r4, r5);     // Catch: Throwable -> L20
        goto L15
    L17:
        m = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    }

    private void s(Uri r2) {
        getContext().getContentResolver().notifyChange(r2, null);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        if (r3 == null) goto L4;
        f3322i = r3.authority;
    L4:
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        if (f3324k.match(r1) != 65536) goto L8;
        m().edit().clear().commit();     // Catch: Exception -> L9
        this.f3327g.clear();     // Catch: Exception -> L9
        s(k(getContext(), "key", WsConstants.KEY_CONNECTION_TYPE));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r1);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + f3322i + ".item";
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"NewApi"})
    public Uri insert(Uri r11, ContentValues r12) {
        if (f3324k.match(r11) != 65536) goto L66;
        r();     // Catch: Exception -> L67
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L67
        Iterator<Map.Entry<String, Object>> r13 = r12.valueSet().iterator();     // Catch: Exception -> L67
        SharedPreferences.Editor r2 = null;
    L7:
        if (r13.hasNext() == false) goto L53;
        Map.Entry<String, Object> r3 = r13.next();     // Catch: Exception -> L67
        Object r4 = r3.getValue();     // Catch: Exception -> L67
        String r5 = r3.getKey();     // Catch: Exception -> L67
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r5 + " value = " + r4.toString());     // Catch: Exception -> L67
    L12:
        boolean r6 = false;
        if (r4 != null) goto L16;
        this.f3327g.remove(r5);     // Catch: Exception -> L67
    L15:
        r6 = true;
    L21:
        if (r6 == false) goto L7;
        if (Logger.debug() == true) goto L25;
    L29:
        if (r2 != null) goto L31;
        r2 = m().edit();     // Catch: Exception -> L67
    L31:
        if (r4 != null) goto L34;
        r2.remove(r5);     // Catch: Exception -> L67
        Runnable r7 = null;
    L49:
        if (r7 == null) goto L7;
        r1.add(r7);     // Catch: Exception -> L67
        goto L7
    L34:
        if ((r4 instanceof String) == false) goto L38;
        r2.putString(r5, (String) r4);     // Catch: Exception -> L67
        String r8 = TypedValues.Custom.S_STRING;
    L36:
        r7 = i(r5, r8);     // Catch: Exception -> L67
        goto L49
    L38:
        if ((r4 instanceof Boolean) == false) goto L41;
        r2.putBoolean(r5, ((Boolean) r4).booleanValue());     // Catch: Exception -> L67
        r8 = TypedValues.Custom.S_BOOLEAN;
        goto L36
    L41:
        if ((r4 instanceof Long) == false) goto L44;
        r2.putLong(r5, ((Long) r4).longValue());     // Catch: Exception -> L67
        r8 = "long";
        goto L36
    L44:
        if ((r4 instanceof Integer) == false) goto L47;
        r2.putInt(r5, ((Integer) r4).intValue());     // Catch: Exception -> L67
        r8 = TypedValues.Custom.S_INT;
        goto L36
    L47:
        if ((r4 instanceof Float) == false) goto L52;
        r2.putFloat(r5, ((Float) r4).floatValue());     // Catch: Exception -> L67
        r8 = TypedValues.Custom.S_FLOAT;
        goto L36
    L52:
        throw new IllegalArgumentException("Unsupported type " + r11);     // Catch: Exception -> L67
    L25:
        if (("MultiProcessShareProvider reallly insert key = " + r5 + " value = " + r4) == null) goto L27;
        String r9 = r4.toString();     // Catch: Exception -> L67
    L28:
        Logger.v("PushService", r9);     // Catch: Exception -> L67
        goto L29
    L27:
        r9 = "null";
        goto L28
    L16:
        Object r10 = this.f3327g.get(r5);     // Catch: Exception -> L67
        if (r10 != null) goto L19;
    L20:
        this.f3327g.put(r5, r4);     // Catch: Exception -> L67
        goto L15
    L19:
        if (r10.equals(r4) == true) goto L21;
    L53:
        if (r2 != null) goto L56;
        return null;
    L56:
        if (Build.VERSION.SDK_INT <= 8) goto L58;
        r2.apply();     // Catch: Exception -> L67
    L59:
        Iterator r14 = r1.iterator();     // Catch: Exception -> L67
    L61:
        if (r14.hasNext() == false) goto L64;
        ((Runnable) r14.next()).run();     // Catch: Exception -> L67
        goto L61
    L58:
        r2.commit();     // Catch: Exception -> L67
    L64:
        return null;
    L66:
        throw new IllegalArgumentException("Unsupported uri " + r11);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (com.bytedance.common.wschannel.u.c.i(getContext()) == false) goto L5;
        f3325l = true;
    L5:
        a(getContext());
        if (f3324k == null) goto L16;
    L15:
        return true;
    L16:
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L12
    L10:
        q(getContext());     // Catch: Exception -> L12
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r4, String[] r5, String r6, String[] r7, String r8) {
        if (f3324k.match(r4) != 65536) goto L54;
        ?? r9 = 0;
        int r10 = 1;
        if ("all".equals(r4.getPathSegments().get(1)) == false) goto L34;
        Map<String, ?> r3 = m().getAll();     // Catch: Exception -> L55
        MatrixCursor r11 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r12 = r3.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        boolean r13 = r12.hasNext();     // Catch: Exception -> L33
        r9 = r13;
        if (r13 == false) goto L56;
        Map.Entry<String, ?> r14 = r12.next();     // Catch: Exception -> L33
        String r15 = r14.getKey();     // Catch: Exception -> L33
        Object r16 = r14.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r0 = r11.newRow();     // Catch: Exception -> L33
        boolean r1 = r16 instanceof String;     // Catch: Exception -> L33
        String r2 = TypedValues.Custom.S_STRING;
        if (r1 == true) goto L31;
        if ((r16 instanceof Boolean) == false) goto L23;
        r2 = TypedValues.Custom.S_BOOLEAN;
        if (((Boolean) r16).booleanValue() == false) goto L20;
        int r17 = 1;
    L21:
        r16 = Integer.valueOf(r17);     // Catch: Exception -> L33
        goto L31
    L20:
        r17 = 0;
        goto L21
    L23:
        if ((r16 instanceof Integer) == false) goto L26;
        r2 = TypedValues.Custom.S_INT;
        goto L31
    L26:
        if ((r16 instanceof Long) == false) goto L29;
        r2 = "long";
        goto L31
    L29:
        if ((r16 instanceof Float) == false) goto L31;
        r2 = TypedValues.Custom.S_FLOAT;
    L31:
        r0.add(r15);     // Catch: Exception -> L33
        r0.add(r16);     // Catch: Exception -> L33
        r0.add(r2);     // Catch: Exception -> L33
    L56:
        return r11;
    L33:
        r9 = r11;
        goto L69
    L34:
        String r18 = r4.getPathSegments().get(0);     // Catch: Exception -> L55
        r();     // Catch: Exception -> L55
        if (this.f3327g.containsKey(r18) == true) goto L37;
        return null;
    L37:
        MatrixCursor r19 = new MatrixCursor(new String[]{r18});     // Catch: Exception -> L55
        Object r20 = this.f3327g.get(r18);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r21 = r19.newRow();     // Catch: Exception -> L50
        if ((r20 instanceof Boolean) == false) goto L46;
        if (((Boolean) r20).booleanValue() == true) goto L44;
        r10 = 0;
    L44:
        r20 = Integer.valueOf(r10);     // Catch: Exception -> L50
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r18 + " value = " + r20.toString());     // Catch: Exception -> L50
    L48:
        r21.add(r20);     // Catch: Exception -> L50
        r11 = r19;
        r9 = r21;
    L50:
        r9 = r19;
    L69:
        return r9;
    L54:
        throw new IllegalArgumentException("Unsupported uri " + r4);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }
}
