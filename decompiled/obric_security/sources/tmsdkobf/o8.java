package tmsdkobf;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.saf.DocumentFile;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.qq.taf.jce.JceStruct;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.TMServiceFactory;
import tmsdk.common.tcc.ApkSAFScanner;
import tmsdk.common.tcc.DeepCleanSAFEngine;
import tmsdk.fg.module.cleanV2.IUpdateCallBack;

/* JADX INFO: loaded from: classes5.dex */
public class o8 {
    private static o8 l;
    static final Object m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private za f387a;
    private Object b;
    private Handler c;
    private HandlerThread d;
    private z3 e;
    IUpdateCallBack f;
    a7 g;
    private ArrayList h;
    private ArrayList i;
    w6 j;
    private volatile boolean k;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o8 f388a;

        a(o8 r1, Looper r2) {
            this.f388a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            int r0 = r11.what;
            if (r0 != 1) goto L5;
            Object r12 = r11.obj;
            if (r12 == null) goto L44;
            ab r13 = (ab) r12;
            fc r1 = (fc) r13.d;
            q8.c("rubbish_rule", "get rubbish group count = " + r1.f198a.size());
            List r2 = o8.m2421$$Nest$ma(this.f388a, r1.f198a);
            if (o8.m2416$$Nest$fgete(this.f388a).d() == true) goto L32;
            o8.m2416$$Nest$fgete(this.f388a).b(true);
        L32:
            o8.m2416$$Nest$fgete(this.f388a).b(String.valueOf(40415));
            l5 r9 = new l5();
            r9.f324a = new ArrayList();
            Iterator r3 = r2.iterator();
        L34:
            if (r3.hasNext() == false) goto L36;
            String r4 = (String) r3.next();
            m5 r5 = new m5();
            r5.f346a = r4;
            r5.d = 0;
            r9.f324a.add(r5);
            goto L34
        L36:
            o8.m2413$$Nest$fgeta(this.f388a).a(r13.f92a, r13.b, r13.c, r9);
            return;
        L44:
            return;
        L5:
            if (r0 != 2) goto L7;
            o8.m2422$$Nest$mb(this.f388a);
            return;
        L7:
            if (r0 != 3) goto L9;
            o8.m2423$$Nest$md(this.f388a);
            return;
        L9:
            if (r0 != 4) goto L45;
            ArrayList r14 = ee.d().b(ee.d().c());
            if (r14.isEmpty() == false) goto L14;
            q8.c("ListNetService", "it doesn't need update");
        L15:
            Object r15 = o8.m2414$$Nest$fgetb(this.f388a);
            monitor-enter(r15);
            IUpdateCallBack r6 = this.f388a.f;     // Catch: Throwable -> L22
            if (r6 == null) goto L20;
            r6.updateEnd(0);     // Catch: Throwable -> L22
            this.f388a.f = null;     // Catch: Throwable -> L22
        L20:
            monitor-exit(r15);     // Catch: Throwable -> L22
            return;
        L22:
            th = move-exception;
            throw th;
        L14:
            q8.c("ListNetService", "maybe something update");
            ee.d().c(r14);
            goto L15
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o8 f389a;

        b(o8 r1) {
            this.f389a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            o8 r0 = this.f389a;
            o8.m2418$$Nest$fputh(r0, o8.m2424$$Nest$mf(r0));
            o8.m2425$$Nest$mh(this.f389a);
        }
    }

    class c implements a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o8 f390a;

        c(o8 r1) {
            this.f390a = r1;
        }

        @Override // tmsdkobf.a7
        public Cif a(int r1, long r2, int r4, JceStruct r5) {
            if (r4 != 13652) goto L16;
            Object r3 = o8.m2414$$Nest$fgetb(this.f390a);
            monitor-enter(r3);
            IUpdateCallBack r6 = this.f390a.f;     // Catch: Throwable -> L17
            if (r6 == null) goto L10;
            r6.updateEnd(0);     // Catch: Throwable -> L17
            this.f390a.f = null;     // Catch: Throwable -> L17
        L10:
            if (r5 != null) goto L14;
            q8.c("ListNetService", "push == null");     // Catch: Throwable -> L17
            monitor-exit(r3);     // Catch: Throwable -> L17
            return null;
        L14:
            q8.c("ListNetService", "listener push");     // Catch: Throwable -> L17
            o8.m2416$$Nest$fgete(this.f390a).b(System.currentTimeMillis());     // Catch: Throwable -> L17
            monitor-exit(r3);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L16:
            return null;
        }
    }

    class d implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o8 f391a;

        d(o8 r1) {
            this.f391a = r1;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r3, int r4, int r5, int r6, JceStruct r7) {
            q8.c("ListNetService", "onFinish() seqNo: " + r3 + " cmdId: " + r4 + " retCode: " + r5 + " dataRetCode: " + r6);
            if (r5 != 0) goto L20;
            q8.c("ListNetService", "upload onFinish()");
            Object r8 = o8.m2414$$Nest$fgetb(this.f391a);
            monitor-enter(r8);
            IUpdateCallBack r1 = this.f391a.f;     // Catch: Throwable -> L17
            if (r1 == null) goto L9;
            r1.updateEnd(0);     // Catch: Throwable -> L17
            this.f391a.f = null;     // Catch: Throwable -> L17
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L17
            o8.m2416$$Nest$fgete(this.f391a).a(System.currentTimeMillis());
            ab r9 = new ab();
            Message r0 = o8.m2415$$Nest$fgetc(this.f391a).obtainMessage();
            r9.c = r4;
            r9.f92a = r3;
            r9.d = r7;
            r0.obj = r9;
            r0.what = 1;
            o8.m2415$$Nest$fgetc(this.f391a).sendMessage(r0);
            ArrayList r10 = o8.m2417$$Nest$fgeth(this.f391a);
            if (r10 != null) goto L13;
        L16:
            o8.m2416$$Nest$fgete(this.f391a).a(true);
            o8.m2420$$Nest$fputk(this.f391a, false);
            return;
        L13:
            if (r10.size() == 0) goto L16;
            o8.m2415$$Nest$fgetc(this.f391a).sendEmptyMessage(2);
            return;
        L17:
            th = move-exception;
            throw th;
        L20:
            Object r11 = o8.m;
            monitor-enter(r11);
            o8 r12 = this.f391a;     // Catch: Throwable -> L34
            o8.m2419$$Nest$fputi(r12, null);     // Catch: Throwable -> L34
            o8.m2418$$Nest$fputh(r12, null);     // Catch: Throwable -> L34
            o8.m2420$$Nest$fputk(r12, false);     // Catch: Throwable -> L34
            monitor-exit(r11);     // Catch: Throwable -> L34
            Object r13 = o8.m2414$$Nest$fgetb(this.f391a);
            monitor-enter(r13);
            IUpdateCallBack r14 = this.f391a.f;     // Catch: Throwable -> L31
            if (r14 == null) goto L29;
            r14.updateEnd(0);     // Catch: Throwable -> L31
            this.f391a.f = null;     // Catch: Throwable -> L31
        L29:
            monitor-exit(r13);     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            throw th;
        L34:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgeta, reason: not valid java name */
    static /* bridge */ /* synthetic */ za m2413$$Nest$fgeta(o8 r0) {
        return r0.f387a;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2414$$Nest$fgetb(o8 r0) {
        return r0.b;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2415$$Nest$fgetc(o8 r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fgete, reason: not valid java name */
    static /* bridge */ /* synthetic */ z3 m2416$$Nest$fgete(o8 r0) {
        return r0.e;
    }

    /* JADX INFO: renamed from: -$$Nest$fgeth, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2417$$Nest$fgeth(o8 r0) {
        return r0.h;
    }

    /* JADX INFO: renamed from: -$$Nest$fputh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2418$$Nest$fputh(o8 r0, ArrayList r1) {
        r0.h = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputi, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2419$$Nest$fputi(o8 r0, ArrayList r1) {
        r0.i = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputk, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2420$$Nest$fputk(o8 r0, boolean r1) {
        r0.k = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2421$$Nest$ma(o8 r0, List r1) {
        return r0.a(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2422$$Nest$mb(o8 r0) {
        r0.b();
    }

    /* JADX INFO: renamed from: -$$Nest$md, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2423$$Nest$md(o8 r0) {
        r0.d();
    }

    /* JADX INFO: renamed from: -$$Nest$mf, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2424$$Nest$mf(o8 r0) {
        return r0.f();
    }

    /* JADX INFO: renamed from: -$$Nest$mh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2425$$Nest$mh(o8 r0) {
        r0.h();
    }

    static {
        m = new Object();
    }

    private o8() {
        this.g = new c(this);
        this.j = new d(this);
        this.k = false;
        this.f387a = ve.e();
        this.b = new Object();
        this.e = new z3();
        HandlerThread r0 = ve.f().b("networkSharkThread");
        this.d = r0;
        r0.start();
        this.c = new a(this, this.d.getLooper());
    }

    private void b() {
        this.i = null;
        ArrayList r0 = this.h;
        if (r0 == null) goto L14;
        int r1 = r0.size();
        q8.c("ListNetService", "get sdcard rubbish path !");
        int r2 = 0;
        if (r1 <= 50) goto L10;
        this.i = new ArrayList();
    L7:
        if (r2 >= 50) goto L9;
        this.i.add((String) this.h.get(r2));
        r2 = r2 + 1;
        goto L7
    L9:
        this.h.removeAll(this.i);
        goto L14
    L10:
        if (r1 <= 0) goto L12;
        ArrayList r3 = (ArrayList) this.h.clone();
        this.i = r3;
        this.h.removeAll(r3);
        goto L14
    L12:
        this.k = false;
        return;
    L14:
        Object r4 = m;
        monitor-enter(r4);
        ArrayList r5 = this.i;     // Catch: Throwable -> L30
        if (r5 != null) goto L21;
        monitor-exit(r4);     // Catch: Throwable -> L30
        return;
    L21:
        if (r5.size() >= 1) goto L24;
        monitor-exit(r4);     // Catch: Throwable -> L30
        return;
    L24:
        monitor-exit(r4);     // Catch: Throwable -> L30
        g1 r6 = new g1();
        r6.f208a = this.i;
        if (r6.b != null) goto L28;
        r6.b = new g8();
    L28:
        g8 r7 = r6.b;
        r7.b = h8.d().e();
        g8 r8 = r6.b;
        r8.f215a = h8.d().b();
        g8 r9 = r6.b;
        r9.c = h8.d().f();
        this.f387a.a(3652, r6, new fc(), 0, this.j);
        return;
    L30:
        th = move-exception;
        throw th;
    }

    private ArrayList c() {
        if (TextUtils.equals(Environment.getExternalStorageState(), "unmounted") == false) goto L5;
        return null;
    L5:
        File r0 = Environment.getExternalStorageDirectory();
        String r2 = r0.getAbsolutePath();
        File[] r1 = r0.listFiles();
        HashSet r3 = new HashSet();
        if (r1 != null) goto L8;
        return null;
    L8:
        int r4 = r1.length;
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L17;
        File r7 = r1[r6];
        if (r7.isDirectory() == false) goto L15;
        r3.add(r7.getAbsolutePath().substring(r2.length()).toLowerCase());
        ArrayList r8 = a(r2, r7, 1);
        if (r8 == null) goto L15;
        r3.addAll(r8);
    L15:
        r6 = r6 + 1;
        goto L9
    L17:
        if (ve.f581a == false) goto L50;
        List<DocumentFile> r5 = DeepCleanSAFEngine.getDocumenFiles("/A%E2%80%8Bndroid%2Fdata");
        if (r5 == null) goto L50;
        ArrayList r9 = new ArrayList();
        Iterator<DocumentFile> r10 = r5.iterator();
    L22:
        if (r10.hasNext() == false) goto L25;
        a(r10.next(), ApkSAFScanner.ANDROID_DATA.toLowerCase(), r9, 0);
        goto L22
    L25:
        if (r9.isEmpty() == true) goto L50;
        r3.addAll(r9);
    L50:
        ArrayList r11 = TMServiceFactory.getSystemInfoService().getInstalledApp(89, 2);     // Catch: Throwable -> L46
        if (r11 == null) goto L49;
        if (r11.isEmpty() == true) goto L49;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L46
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L46
    L33:
        if (r13.hasNext() == false) goto L43;
        m r14 = (m) r13.next();     // Catch: Throwable -> L46
        if (r14 == null) goto L37;
        String r15 = r14.k();     // Catch: Throwable -> L46
    L39:
        if (TextUtils.isEmpty(r15) == true) goto L33;
        r12.add("/android/data/" + r15);     // Catch: Throwable -> L46
        goto L33
    L37:
        r15 = null;
        goto L39
    L43:
        if (r12.isEmpty() == true) goto L49;
        r3.addAll(r12);     // Catch: Throwable -> L46
    L49:
        return new ArrayList(r3);
    L46:
        th = move-exception;
        q8.b("ListNetService", th);
        goto L49
    }

    private void d() {
        ve.f().a(new b(this), "getDirUpLoad");
    }

    public static o8 e() {
        if (l != null) goto L6;
        l = new o8();
    L6:
        return l;
    }

    private ArrayList f() {
        q8.c("ListNetService", "get sd card !!: : ");
        return c();
    }

    private void h() {
        if (this.k == false) goto L5;
        return;
    L5:
        this.k = true;
        this.c.sendEmptyMessage(2);
    }

    public void a() {
        l = null;
        this.d.quit();
        this.f = null;
    }

    public synchronized void g() {
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
            this = this;
            monitor-enter(r5)
            tmsdkobf.za r0 = r5.f387a     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lb
            tmsdkobf.za r0 = tmsdkobf.ve.e()     // Catch: java.lang.Throwable -> L30
            r5.f387a = r0     // Catch: java.lang.Throwable -> L30
        Lb:
            tmsdkobf.za r0 = r5.f387a     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L22
            r1 = 0
            r2 = 13652(0x3554, float:1.913E-41)
            r0.a(r2, r1)     // Catch: java.lang.Throwable -> L30
            tmsdkobf.za r0 = r5.f387a     // Catch: java.lang.Throwable -> L30
            tmsdkobf.fc r3 = new tmsdkobf.fc     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            tmsdkobf.a7 r4 = r5.g     // Catch: java.lang.Throwable -> L30
            r0.a(r2, r3, r1, r4)     // Catch: java.lang.Throwable -> L30
            goto L2e
        L22:
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            java.lang.String r1 = "registerSharkePush failed"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            throw r0     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
        L2a:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L30
        L2e:
            monitor-exit(r5)
            return
        L30:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tmsdkobf.o8.g():void");
    }

    private ArrayList a(String r7, File r8, int r9) {
        if (3 != r9) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        File[] r10 = r8.listFiles();
        if (r10 != null) goto L8;
        return null;
    L8:
        int r1 = r10.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L16;
        File r3 = r10[r2];
        if (r3.isDirectory() == false) goto L15;
        r0.add(r3.getAbsolutePath().substring(r7.length()).toLowerCase());
        ArrayList r4 = a(r7, r3, r9 + 1);
        if (r4 == null) goto L15;
        r0.addAll(r4);
    L15:
        r2 = r2 + 1;
        goto L9
    L16:
        return r0;
    }

    private List a(List r1) {
        return bc.a().a(r1);
    }

    private void a(DocumentFile r6, String r7, ArrayList r8, int r9) {
        if (r9 <= 2) goto L5;
        return;
    L5:
        if (r6 == null) goto L14;
        if (r7 == null) goto L18;
        DocumentFile[] r10 = r6.listFiles();
        int r0 = r10.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L19;
        DocumentFile r2 = r10[r1];
        if (r2.isDirectory() == false) goto L13;
        String r3 = r7 + LibrarianImpl.Constants.SEPARATOR + r2.getName().toLowerCase();
        r8.add(r3);
        a(r2, r3, r8, r9 + 1);
    L13:
        r1 = r1 + 1;
        goto L9
    L19:
        return;
    L18:
        return;
    }

    public synchronized boolean a(boolean r13, IUpdateCallBack r14) {
        monitor-enter(this);
        q8.c("ListNetService", "uploadSoftwareAndDirs");     // Catch: Throwable -> L34
        this.f = r14;     // Catch: Throwable -> L34
        boolean r15 = !TextUtils.equals(h8.d().c(), h8.d().a("_soft"));     // Catch: Throwable -> L34
        if (r15 == false) goto L8;
        h8.d().d("_soft");     // Catch: Throwable -> L34
    L8:
        if (bc.a().d() == false) goto L27;
        q8.c("ListNetService", "moreThanTenRules");     // Catch: Throwable -> L34
        if (r13 == false) goto L12;
        int r16 = 180000;
    L13:
        long r4 = r16;
        long r6 = System.currentTimeMillis() - this.e.a();     // Catch: Throwable -> L34
        long r8 = System.currentTimeMillis() - this.e.b();     // Catch: Throwable -> L34
        if (r15 == false) goto L16;
    L17:
        this.e.a(false);     // Catch: Throwable -> L34
    L19:
        if (r8 <= r4) goto L22;
        ee.d().e();     // Catch: Throwable -> L34
    L22:
        if (0 == this.e.a()) goto L24;
    L28:
        this.c.sendEmptyMessage(4);     // Catch: Throwable -> L34
        if (this.e.c() == true) goto L31;
        this.c.sendEmptyMessage(3);     // Catch: Throwable -> L34
    L31:
        tmsdkobf.d.a();     // Catch: Throwable -> L34
        q8.c("ListNetService", "uploadSoftwareAndDirs guid:" + this.f387a.b());     // Catch: Throwable -> L34
        monitor-exit(this);
        return true;
    L24:
        if (0 != this.e.b()) goto L28;
        z3 r17 = this.e;     // Catch: Throwable -> L34
    L26:
        r17.b(false);     // Catch: Throwable -> L34
        goto L28
    L16:
        if (r6 <= r4) goto L19;
    L12:
        r16 = 86400000;
        goto L13
    L27:
        q8.c("ListNetService", "moreThanTenRules else");     // Catch: Throwable -> L34
        this.e.a(false);     // Catch: Throwable -> L34
        ee.d().e();     // Catch: Throwable -> L34
        r17 = this.e;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }
}
