package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<b4> f7223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<b4> f7225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    TelephonyManager f7226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private z3 f7227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f7228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    PhoneStateListener f7229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    SignalStrength f7230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f7231l;

    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback m;
    private boolean n;
    boolean o;
    StringBuilder p;
    private String q;
    private String r;
    String s;
    private t3 t;

    @SuppressLint({"NewApi"})
    class a extends TelephonyManager.CellInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c4 f7232a;

        a(c4 r1) {
            this.f7232a = r1;
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> r5) {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                long r0 = com.loc.a5.A()     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4 r2 = r4.f7232a     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                long r2 = com.loc.c4.a(r2)     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                long r0 = r0 - r2
                r2 = 500(0x1f4, double:2.47E-321)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 >= 0) goto L12
                return
            L12:
                com.loc.c4 r0 = r4.f7232a     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4.t(r0)     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4 r0 = r4.f7232a     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                android.telephony.CellLocation r0 = com.loc.c4.u(r0)     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4 r1 = r4.f7232a     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4.l(r1, r0)     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4 r0 = r4.f7232a     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                r0.m(r5)     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4 r5 = r4.f7232a     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                long r0 = com.loc.a5.A()     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                com.loc.c4.b(r5, r0)     // Catch: java.lang.Throwable -> L31 java.lang.SecurityException -> L3a
                return
            L31:
                r4 = move-exception
                java.lang.String r5 = "Cgi"
                java.lang.String r0 = "cellInfo"
                com.loc.s4.h(r4, r5, r0)
                return
            L3a:
                r5 = move-exception
                com.loc.c4 r4 = r4.f7232a
                java.lang.String r5 = r5.getMessage()
                r4.s = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.c4.a.onCellInfo(java.util.List):void");
        }
    }

    class b extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c4 f7233a;

        b(c4 r1) {
            this.f7233a = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> r5) {
            u4.c();     // Catch: Throwable -> L10
            if (c4.y(this.f7233a) == null) goto L6;
            c4.y(this.f7233a).p();     // Catch: Throwable -> L10
        L6:
            if ((a5.A() - c4.a(this.f7233a)) >= 500) goto L8;
            return;
        L8:
            CellLocation r0 = c4.u(this.f7233a);     // Catch: Throwable -> L10
            c4.l(this.f7233a, r0);     // Catch: Throwable -> L10
            this.f7233a.m(r5);     // Catch: Throwable -> L10
            c4.b(this.f7233a, a5.A());     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation r5) {
            u4.c();
            if ((a5.A() - c4.a(this.f7233a)) >= 500) goto L10;
            return;
        L10:
            c4.l(this.f7233a, r5);     // Catch: Throwable -> L7
            List<CellInfo> r6 = c4.x(this.f7233a);     // Catch: Throwable -> L7
            this.f7233a.m(r6);     // Catch: Throwable -> L7
            c4.b(this.f7233a, a5.A());     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int r1) {
            super.onDataConnectionStateChanged(r1);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState r2) {
            int r3 = r2.getState();     // Catch: Throwable -> L11
            if (r3 != 0) goto L5;
            this.f7233a.o(false, false);     // Catch: Throwable -> L11
            return;
        L5:
            if (r3 != 1) goto L13;
            this.f7233a.E();     // Catch: Throwable -> L11
            return;
        L13:
            return;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int r1) {
            super.onSignalStrengthChanged(r1);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            c4 r0 = this.f7233a;
            r0.f7230k = r2;
            if (c4.y(r0) == null) goto L12;
            c4.y(this.f7233a).p();     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    public c4(Context r5, Handler r6) {
        this.f7221b = false;
        this.f7222c = false;
        this.f7223d = new ArrayList();
        this.f7224e = null;
        this.f7225f = new ArrayList();
        this.f7226g = null;
        this.f7227h = null;
        this.f7228i = 0;
        this.f7229j = null;
        this.f7231l = new Object();
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.f7220a = r5;
        if (this.f7226g != null) goto L5;
        this.f7226g = (TelephonyManager) a5.g(r5, "phone");
    L5:
        J();
        z3 r0 = new z3(r5, "cellAge", r6);
        this.f7227h = r0;
        r0.c();
    }

    private void J() {
        if (this.f7226g != null) goto L5;
        return;
    L5:
        K();
    }

    private void K() {
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f7229j != null) goto L5;
        this.f7229j = new b(this);     // Catch: Exception -> L41
    L5:
        int r0 = 320;
        int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L41
        String r2 = "hasFineLocPerm";
        if (r1 >= 31) goto L9;
    L12:
        u4.c();     // Catch: Exception -> L41
        r0 = 336;
    L14:
        if (r1 < 17) goto L37;
        if (r1 < 31) goto L36;
        boolean r5 = true;
        if (this.f7220a.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L19;
        boolean r3 = true;
    L21:
        if (this.f7220a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L24;
        r5 = false;
    L24:
        if (r3 == false) goto L27;
        if (r5 == false) goto L27;
        r0 = r0 | 1024;     // Catch: Exception -> L41
    L27:
        u4.c();     // Catch: Exception -> L41
        if (r3 == false) goto L30;
        String r4 = "hasReadPhoneStatePerm";
    L31:
        this.q = r4;     // Catch: Exception -> L41
        if (r5 == true) goto L35;
        r2 = "hasNoFineLocPerm";
    L35:
        this.r = r2;     // Catch: Exception -> L41
        StringBuilder r6 = new StringBuilder("CgiManager | mLFLPerm = ");     // Catch: Exception -> L41
        r6.append(this.r);     // Catch: Exception -> L41
        r6.append(";mLRPSPerm = ");     // Catch: Exception -> L41
        r6.append(this.q);     // Catch: Exception -> L41
        u4.c();     // Catch: Exception -> L41
        goto L37
    L30:
        r4 = "hasNoReadPhoneStatePerm";
        goto L31
    L19:
        r3 = false;
        goto L21
    L36:
        u4.c();     // Catch: Exception -> L41
        r0 = r0 | 1024;     // Catch: Exception -> L41
    L37:
        PhoneStateListener r7 = this.f7229j;     // Catch: Exception -> L41
        if (r7 == null) goto L46;
        this.f7226g.listen(r7, r0);     // Catch: Exception -> L41
        return;
    L46:
        return;
    L9:
        if (this.f7220a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L11;
        this.r = "hasFineLocPerm";     // Catch: Exception -> L41
        goto L12
    L11:
        this.r = "hasNoFineLocPerm";     // Catch: Exception -> L41
        u4.c();     // Catch: Exception -> L41
        goto L14
    }

    private int L() {
        b4 r0 = z();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f7195l;
    }

    private CellLocation M() {
        TelephonyManager r0 = this.f7226g;
        if (r0 != null) goto L11;
    L10:
        return null;
    L11:
        CellLocation r1 = r0.getCellLocation();     // Catch: Throwable -> L6 SecurityException -> L8
        this.s = null;     // Catch: Throwable -> L6 SecurityException -> L8
        return r1;
    L8:
        e = move-exception;
        this.s = e.getMessage();
    L6:
        th = move-exception;
        this.s = null;
        s4.h(th, "CgiManager", "getCellLocation");
        goto L10
    }

    private boolean N() {
        if (this.o == false) goto L6;
        return false;
    L6:
        if ((a5.A() - this.f7228i) < 45000) goto L11;
        return true;
    L11:
        return false;
    }

    private CellLocation O() {
        if (this.f7226g != null) goto L7;
        return null;
    L7:
        return M();
    }

    @SuppressLint({"NewApi"})
    private List<CellInfo> P() {
    L18:
        th = move-exception;
        s4.h(th, "Cgi", "getNewCells");
        return null;
    L4:
        if (a5.J() >= 18) goto L6;
        return null;
    L6:
        TelephonyManager r1 = this.f7226g;     // Catch: Throwable -> L18
        if (r1 != null) goto L24;
        return null;
    L24:
        List<CellInfo> r2 = r1.getAllCellInfo();     // Catch: SecurityException -> L14 Throwable -> L18
        this.s = null;     // Catch: SecurityException -> L12 Throwable -> L18
    L17:
        return r2;
    L12:
        e = e;
    L16:
        this.s = e.getMessage();     // Catch: Throwable -> L18
    L14:
        e = e;
        r2 = null;
        goto L16
    }

    static /* synthetic */ long a(c4 r2) {
        return r2.f7228i;
    }

    static /* synthetic */ long b(c4 r0, long r1) {
        r0.f7228i = r1;
        return r1;
    }

    private static b4 c(int r1, boolean r2, int r3, int r4, int r5, int r6, int r7) {
        b4 r0 = new b4(r1, r2);
        r0.f7184a = r3;
        r0.f7185b = r4;
        r0.f7186c = r5;
        r0.f7187d = r6;
        r0.f7194k = r7;
        return r0;
    }

    private b4 d(CellInfoCdma r11, boolean r12) {
        if (r11 != null) goto L5;
    L21:
        return null;
    L5:
        if (r11.getCellIdentity() == null) goto L21;
        CellIdentityCdma r1 = r11.getCellIdentity();
        if (r1.getSystemId() <= 0) goto L21;
        if (r1.getNetworkId() < 0) goto L21;
        if (r1.getBasestationId() < 0) goto L21;
        CellIdentityCdma r0 = r11.getCellIdentity();
        String[] r10 = a5.x(this.f7226g);
        int r2 = 0;
        int r3 = Integer.parseInt(r10[0]);     // Catch: Throwable -> L18
        r2 = Integer.parseInt(r10[1]);     // Catch: Throwable -> L22
    L19:
        b4 r13 = c(2, r12, r3, r2, 0, 0, r11.getCellSignalStrength().getCdmaDbm());
        r13.f7191h = r0.getSystemId();
        r13.f7192i = r0.getNetworkId();
        r13.f7193j = r0.getBasestationId();
        r13.f7189f = r0.getLatitude();
        r13.f7190g = r0.getLongitude();
        r13.s = r11.getCellSignalStrength().getCdmaDbm();
        return r13;
    L18:
        r3 = 0;
        goto L19
    }

    @SuppressLint({"NewApi"})
    private static b4 e(CellInfoGsm r8, boolean r9) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.getCellIdentity() == null) goto L10;
        CellIdentityGsm r0 = r8.getCellIdentity();
        b4 r10 = c(1, r9, r0.getMcc(), r0.getMnc(), r0.getLac(), r0.getCid(), r8.getCellSignalStrength().getDbm());
        r10.o = r8.getCellIdentity().getBsic();
        r10.p = r8.getCellIdentity().getArfcn();
        r10.q = r8.getCellSignalStrength().getTimingAdvance();
        r10.s = r8.getCellSignalStrength().getDbm();
        return r10;
    L10:
        return null;
    }

    private static b4 f(CellInfoLte r8, boolean r9) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.getCellIdentity() == null) goto L13;
        CellIdentityLte r0 = r8.getCellIdentity();
        b4 r10 = c(3, r9, r0.getMcc(), r0.getMnc(), r0.getTac(), r0.getCi(), r8.getCellSignalStrength().getDbm());
        r10.o = r0.getPci();
        if (Build.VERSION.SDK_INT < 24) goto L9;
        r10.p = r0.getEarfcn();
    L9:
        r10.q = r8.getCellSignalStrength().getTimingAdvance();
        r10.s = r8.getCellSignalStrength().getDbm();
        return r10;
    L13:
        return null;
    }

    private static b4 g(CellInfoNr r14, boolean r15) {
        if (r14 != null) goto L4;
        return null;
    L4:
        if (r14.getCellIdentity() == null) goto L40;
        CellIdentityNr r0 = (CellIdentityNr) r14.getCellIdentity();
        int r1 = r0.getTac();
        int r3 = 0;
        if (r1 == Integer.MAX_VALUE) goto L9;
    L15:
        long r4 = r0.getNci();
        int r2 = Integer.parseInt(r0.getMccString());     // Catch: Throwable -> L21
        r3 = Integer.parseInt(r0.getMncString());     // Catch: Throwable -> L19
    L24:
        b4 r16 = c(5, r15, r2, r3, r0.getTac(), 0, ((CellSignalStrengthNr) r14.getCellSignalStrength()).getSsRsrp());
        r16.f7188e = r4;
        if (r1 <= 16777215) goto L27;
        r16.f7186c = SupportMenu.USER_MASK;
    L30:
        r16.o = r0.getPci();
        r16.p = r0.getNrarfcn();
        r16.s = r14.getCellSignalStrength().getDbm();
        return r16;
    L27:
        if (r1 <= 65535) goto L29;
        r16.f7186c = SupportMenu.USER_MASK;
        r16.q = r1;
        goto L30
    L29:
        r16.f7186c = r1;
    L19:
        th = th;
    L23:
        th.printStackTrace();
    L21:
        th = th;
        r2 = 0;
        goto L23
    L9:
        if ("HUAWEI".equals(Build.MANUFACTURER) == false) goto L15;
        r1 = w4.f(r0, "getHwTac", new Object[0]);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L40:
        return null;
    }

    private static b4 h(CellInfoWcdma r8, boolean r9) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.getCellIdentity() == null) goto L10;
        CellIdentityWcdma r0 = r8.getCellIdentity();
        b4 r10 = c(4, r9, r0.getMcc(), r0.getMnc(), r0.getLac(), r0.getCid(), r8.getCellSignalStrength().getDbm());
        r10.o = r0.getPsc();
        r10.p = r8.getCellIdentity().getUarfcn();
        r10.s = r8.getCellSignalStrength().getDbm();
        return r10;
    L10:
        return null;
    }

    private synchronized void j(CellLocation r6) {
        monitor-enter(this);
        String[] r0 = a5.x(this.f7226g);     // Catch: Throwable -> L23
        this.f7223d.clear();     // Catch: Throwable -> L23
        if ((r6 instanceof GsmCellLocation) == false) goto L16;
        GsmCellLocation r7 = (GsmCellLocation) r6;     // Catch: Throwable -> L23
        b4 r1 = new b4(1, true);     // Catch: Throwable -> L23
        r1.f7184a = a5.R(r0[0]);     // Catch: Throwable -> L23
        r1.f7185b = a5.R(r0[1]);     // Catch: Throwable -> L23
        r1.f7186c = r7.getLac();     // Catch: Throwable -> L23
        r1.f7187d = r7.getCid();     // Catch: Throwable -> L23
        SignalStrength r8 = this.f7230k;     // Catch: Throwable -> L23
        if (r8 == null) goto L12;
        int r9 = r8.getGsmSignalStrength();     // Catch: Throwable -> L23
        if (r9 != 99) goto L10;
        int r10 = Integer.MAX_VALUE;
    L11:
        r1.s = r10;     // Catch: Throwable -> L23
        goto L12
    L10:
        r10 = q(r9);     // Catch: Throwable -> L23
    L12:
        r1.r = false;     // Catch: Throwable -> L23
        this.f7227h.d(r1);     // Catch: Throwable -> L23
        this.f7223d.add(r1);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if ((r6 instanceof CdmaCellLocation) == false) goto L21;
        CdmaCellLocation r11 = (CdmaCellLocation) r6;     // Catch: Throwable -> L23
        b4 r2 = new b4(2, true);     // Catch: Throwable -> L23
        r2.f7184a = Integer.parseInt(r0[0]);     // Catch: Throwable -> L23
        r2.f7185b = Integer.parseInt(r0[1]);     // Catch: Throwable -> L23
        r2.f7189f = r11.getBaseStationLatitude();     // Catch: Throwable -> L23
        r2.f7190g = r11.getBaseStationLongitude();     // Catch: Throwable -> L23
        r2.f7191h = r11.getSystemId();     // Catch: Throwable -> L23
        r2.f7192i = r11.getNetworkId();     // Catch: Throwable -> L23
        r2.f7193j = r11.getBaseStationId();     // Catch: Throwable -> L23
        SignalStrength r12 = this.f7230k;     // Catch: Throwable -> L23
        if (r12 == null) goto L20;
        r2.s = r12.getCdmaDbm();     // Catch: Throwable -> L23
    L20:
        r2.r = false;     // Catch: Throwable -> L23
        this.f7227h.d(r2);     // Catch: Throwable -> L23
        this.f7223d.add(r2);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void l(c4 r0, CellLocation r1) {
        r0.j(r1);
    }

    public static boolean p(int r1) {
        if (r1 > 0) goto L4;
        return false;
    L4:
        if (r1 > 15) goto L10;
        return true;
    L10:
        return false;
    }

    private static int q(int r0) {
        return (r0 * 2) + NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
    }

    @SuppressLint({"NewApi"})
    private void s(boolean r5, boolean r6) {
        if (this.o == false) goto L5;
    L24:
        this.f7222c = false;
        TelephonyManager r7 = this.f7226g;
        if (r7 == null) goto L29;
        String r8 = r7.getNetworkOperator();
        this.f7224e = r8;
        if (TextUtils.isEmpty(r8) == true) goto L29;
        this.f7222c = true;
    L29:
        this.f7228i = a5.A();
        return;
    L5:
        if (this.f7226g == null) goto L24;
        if (Build.VERSION.SDK_INT < 29) goto L24;
        if (this.f7220a.getApplicationInfo().targetSdkVersion < 29) goto L24;
        if (this.m != null) goto L13;
        this.m = new a(this);
    L13:
        this.f7226g.requestCellInfoUpdate(r1.f().c(), this.m);
        if (r6 == true) goto L16;
        if (r5 == false) goto L24;
    L16:
        int r9 = 0;
    L18:
        if (this.n == true) goto L24;
        if (r9 >= 20) goto L24;
        Thread.sleep(5);     // Catch: Throwable -> L31
    L23:
        r9 = r9 + 1;
        goto L18
    }

    static /* synthetic */ boolean t(c4 r1) {
        r1.n = true;
        return true;
    }

    static /* synthetic */ CellLocation u(c4 r0) {
        return r0.O();
    }

    static /* synthetic */ List x(c4 r0) {
        return r0.P();
    }

    static /* synthetic */ t3 y(c4 r0) {
        return r0.t;
    }

    public final synchronized b4 A() {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.o == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList<b4> r0 = this.f7225f;     // Catch: Throwable -> L24
        if (r0.size() <= 0) goto L22;
        Iterator<b4> r1 = r0.iterator();     // Catch: Throwable -> L24
    L12:
        if (r1.hasNext() == false) goto L19;
        b4 r2 = r1.next();     // Catch: Throwable -> L24
        if (r2.n == false) goto L12;
        b4 r3 = r2.d();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r3;
    L19:
        b4 r4 = r0.get(0).d();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r4;
    L22:
        monitor-exit(this);
        return null;
    }

    public final int B() {
        int r0 = L();
        int r2 = 0;
        if (this.f7221b == false) goto L5;
        int r1 = 4;
    L6:
        int r3 = r0 | r1;
        if (this.f7222c == false) goto L10;
        r2 = 8;
    L10:
        return r3 | r2;
    L5:
        r1 = 0;
        goto L6
    }

    public final int C() {
        return L() & 3;
    }

    public final TelephonyManager D() {
        return this.f7226g;
    }

    final synchronized void E() {
        monitor-enter(this);
        this.s = null;     // Catch: Throwable -> L7
        this.f7223d.clear();     // Catch: Throwable -> L7
        this.f7225f.clear();     // Catch: Throwable -> L7
        this.f7221b = false;     // Catch: Throwable -> L7
        this.f7222c = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final String F() {
        return this.s;
    }

    public final String G() {
        return this.f7224e;
    }

    public final synchronized String H() {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (this.o == false) goto L6;
        E();     // Catch: Throwable -> L40
    L6:
        StringBuilder r0 = this.p;     // Catch: Throwable -> L40
        if (r0 != null) goto L9;
        this.p = new StringBuilder();     // Catch: Throwable -> L40
    L11:
        if (C() != 1) goto L17;
        int r1 = 1;
    L15:
        if (r1 >= this.f7223d.size()) goto L17;
        StringBuilder r3 = this.p;     // Catch: Throwable -> L40
        r3.append("#");     // Catch: Throwable -> L40
        r3.append(this.f7223d.get(r1).f7185b);     // Catch: Throwable -> L40
        StringBuilder r4 = this.p;     // Catch: Throwable -> L40
        r4.append("|");     // Catch: Throwable -> L40
        r4.append(this.f7223d.get(r1).f7186c);     // Catch: Throwable -> L40
        StringBuilder r5 = this.p;     // Catch: Throwable -> L40
        r5.append("|");     // Catch: Throwable -> L40
        r5.append(this.f7223d.get(r1).f7187d);     // Catch: Throwable -> L40
        r1 = r1 + 1;     // Catch: Throwable -> L40
    L17:
        int r2 = 1;
    L19:
        if (r2 >= this.f7225f.size()) goto L35;
        b4 r6 = this.f7225f.get(r2);     // Catch: Throwable -> L40
        int r7 = r6.f7195l;     // Catch: Throwable -> L40
        if (r7 != 1) goto L23;
    L32:
        StringBuilder r8 = this.p;     // Catch: Throwable -> L40
        r8.append("#");     // Catch: Throwable -> L40
        r8.append(r6.f7195l);     // Catch: Throwable -> L40
        StringBuilder r9 = this.p;     // Catch: Throwable -> L40
        r9.append("|");     // Catch: Throwable -> L40
        r9.append(r6.f7184a);     // Catch: Throwable -> L40
        StringBuilder r10 = this.p;     // Catch: Throwable -> L40
        r10.append("|");     // Catch: Throwable -> L40
        r10.append(r6.f7185b);     // Catch: Throwable -> L40
        StringBuilder r11 = this.p;     // Catch: Throwable -> L40
        r11.append("|");     // Catch: Throwable -> L40
        r11.append(r6.f7186c);     // Catch: Throwable -> L40
        StringBuilder r12 = this.p;     // Catch: Throwable -> L40
        r12.append("|");     // Catch: Throwable -> L40
        r12.append(r6.a());     // Catch: Throwable -> L40
    L33:
        r2 = r2 + 1;     // Catch: Throwable -> L40
        goto L19
    L23:
        if (r7 == 3) goto L32;
        if (r7 == 4) goto L32;
        if (r7 == 5) goto L32;
        if (r7 != 2) goto L33;
        StringBuilder r13 = this.p;     // Catch: Throwable -> L40
        r13.append("#");     // Catch: Throwable -> L40
        r13.append(r6.f7195l);     // Catch: Throwable -> L40
        StringBuilder r14 = this.p;     // Catch: Throwable -> L40
        r14.append("|");     // Catch: Throwable -> L40
        r14.append(r6.f7184a);     // Catch: Throwable -> L40
        StringBuilder r15 = this.p;     // Catch: Throwable -> L40
        r15.append("|");     // Catch: Throwable -> L40
        r15.append(r6.f7191h);     // Catch: Throwable -> L40
        StringBuilder r16 = this.p;     // Catch: Throwable -> L40
        r16.append("|");     // Catch: Throwable -> L40
        r16.append(r6.f7192i);     // Catch: Throwable -> L40
        StringBuilder r17 = this.p;     // Catch: Throwable -> L40
        r17.append("|");     // Catch: Throwable -> L40
        r17.append(r6.f7193j);     // Catch: Throwable -> L40
        goto L33
    L35:
        if (this.p.length() <= 0) goto L37;
        this.p.deleteCharAt(0);     // Catch: Throwable -> L40
    L37:
        String r18 = this.p.toString();     // Catch: Throwable -> L40
        monitor-exit(this);
        return r18;
    L9:
        r0.delete(0, r0.length());     // Catch: Throwable -> L40
        goto L11
    }

    public final boolean I() {
        TelephonyManager r1 = this.f7226g;     // Catch: Throwable -> L24
        if (r1 == null) goto L26;
        if (TextUtils.isEmpty(r1.getSimOperator()) == true) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(this.f7226g.getSimCountryIso()) == true) goto L26;
        return true;
    L26:
        int r2 = a5.e(a5.K(this.f7220a));     // Catch: Throwable -> L25
        if (r2 != 0) goto L14;
    L21:
        return true;
    L14:
        if (r2 == 4) goto L21;
        if (r2 == 2) goto L21;
        if (r2 == 5) goto L21;
        if (r2 == 3) goto L21;
        return false;
    L30:
        return false;
    }

    public final List<a3> i() {
        int r0 = Build.VERSION.SDK_INT;
        ArrayList r1 = new ArrayList();
        List<CellInfo> r8 = this.f7226g.getAllCellInfo();
        if (r0 < 17) goto L30;
        if (r8 == null) goto L30;
        Iterator<CellInfo> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L30;
        CellInfo r2 = r9.next();
        if ((r2 instanceof CellInfoCdma) == true) goto L10;
        if ((r2 instanceof CellInfoGsm) == true) goto L14;
        if ((r2 instanceof CellInfoLte) == true) goto L20;
        if (r0 < 18) goto L7;
        if ((r2 instanceof CellInfoWcdma) == false) goto L7;
        CellInfoWcdma r3 = (CellInfoWcdma) r2;
        CellIdentityWcdma r6 = r3.getCellIdentity();
        f3 r7 = new f3(r2.isRegistered(), true);
        r7.f7139f = String.valueOf(r6.getMcc());
        r7.f7140g = String.valueOf(r6.getMnc());
        r7.o = r6.getLac();
        r7.p = r6.getCid();
        r7.q = r6.getPsc();
        r7.f7142i = r3.getCellSignalStrength().getAsuLevel();
        r7.f7141h = r3.getCellSignalStrength().getDbm();
        Object r10 = r7;
        if (r0 >= 24) goto L29;
    L17:
        r1.add(r10);
        goto L7
    L29:
        r7.r = r6.getUarfcn();
        r10 = r7;
        goto L17
    L20:
        CellInfoLte r4 = (CellInfoLte) r2;
        CellIdentityLte r5 = r4.getCellIdentity();
        e3 r11 = new e3(r2.isRegistered());
        r11.f7139f = String.valueOf(r5.getMcc());
        r11.f7140g = String.valueOf(r5.getMnc());
        r11.q = r5.getPci();
        r11.f7142i = r4.getCellSignalStrength().getAsuLevel();
        r11.p = r5.getCi();
        r11.o = r5.getTac();
        r11.s = r4.getCellSignalStrength().getTimingAdvance();
        r11.f7141h = r4.getCellSignalStrength().getDbm();
        Object r12 = r11;
        if (r0 >= 24) goto L22;
    L11:
        r1.add(r12);
        goto L7
    L22:
        r11.r = r5.getEarfcn();
        r12 = r11;
        goto L11
    L14:
        CellInfoGsm r13 = (CellInfoGsm) r2;
        CellIdentityGsm r14 = r13.getCellIdentity();
        d3 r15 = new d3(r2.isRegistered(), true);
        r15.f7139f = String.valueOf(r14.getMcc());
        r15.f7140g = String.valueOf(r14.getMnc());
        r15.o = r14.getLac();
        r15.p = r14.getCid();
        r15.f7141h = r13.getCellSignalStrength().getDbm();
        r15.f7142i = r13.getCellSignalStrength().getAsuLevel();
        r10 = r15;
        if (r0 < 24) goto L17;
        r15.r = r14.getArfcn();
        r15.s = r14.getBsic();
        r10 = r15;
        goto L17
    L10:
        CellInfoCdma r16 = (CellInfoCdma) r2;
        CellIdentityCdma r17 = r16.getCellIdentity();
        c3 r18 = new c3(r2.isRegistered(), true);
        r18.r = r17.getLatitude();
        r18.s = r17.getLongitude();
        r18.o = r17.getSystemId();
        r18.p = r17.getNetworkId();
        r18.q = r17.getBasestationId();
        r18.f7142i = r16.getCellSignalStrength().getAsuLevel();
        r18.f7141h = r16.getCellSignalStrength().getCdmaDbm();
        r12 = r18;
    L30:
        return r1;
    }

    public final void k(t3 r1) {
        this.t = r1;
    }

    final synchronized void m(List<CellInfo> r10) {
        monitor-enter(this);
        ArrayList<b4> r0 = this.f7225f;     // Catch: Throwable -> L44
        if (r0 == null) goto L6;
        r0.clear();     // Catch: Throwable -> L44
    L6:
        if (r10 != null) goto L8;
    L42:
        monitor-exit(this);
        return;
    L8:
        if (r10.size() <= 0) goto L42;
        int r1 = 0;
    L12:
        if (r1 >= r10.size()) goto L35;
        CellInfo r2 = r10.get(r1);     // Catch: Throwable -> L44
        if (r2 == null) goto L34;
        b4 r4 = null;
        boolean r5 = r2.isRegistered();     // Catch: Throwable -> L44
        if ((r2 instanceof CellInfoCdma) == false) goto L19;
        r4 = d((CellInfoCdma) r2, r5);     // Catch: Throwable -> L44
    L32:
        if (r4 == null) goto L34;
        this.f7227h.d(r4);     // Catch: Throwable -> L44
        r4.m = (short) Math.min(65535, this.f7227h.r(r4));     // Catch: Throwable -> L44
        r4.r = true;     // Catch: Throwable -> L44
        this.f7225f.add(r4);     // Catch: Throwable -> L44
        goto L34
    L19:
        if ((r2 instanceof CellInfoGsm) == false) goto L22;
        r4 = e((CellInfoGsm) r2, r5);     // Catch: Throwable -> L44
        goto L32
    L22:
        if ((r2 instanceof CellInfoWcdma) == false) goto L25;
        r4 = h((CellInfoWcdma) r2, r5);     // Catch: Throwable -> L44
        goto L32
    L25:
        if ((r2 instanceof CellInfoLte) == false) goto L28;
        r4 = f((CellInfoLte) r2, r5);     // Catch: Throwable -> L44
        goto L32
    L28:
        if (Build.VERSION.SDK_INT < 29) goto L32;
        if ((r2 instanceof CellInfoNr) == false) goto L32;
        r4 = g((CellInfoNr) r2, r5);     // Catch: Throwable -> L44
    L34:
        r1 = r1 + 1;     // Catch: Throwable -> L44
        goto L12
    L35:
        this.f7221b = false;     // Catch: Throwable -> L44
        ArrayList<b4> r11 = this.f7225f;     // Catch: Throwable -> L44
        if (r11 != null) goto L38;
    L40:
        monitor-exit(this);
        return;
    L38:
        if (r11.size() <= 0) goto L40;
        this.f7221b = true;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    public final void n(boolean r3) {
        this.f7227h.g(r3);
        this.f7228i = 0;
        Object r4 = this.f7231l;
        monitor-enter(r4);
        monitor-exit(r4);     // Catch: Throwable -> L16
        TelephonyManager r5 = this.f7226g;
        if (r5 == null) goto L14;
        PhoneStateListener r0 = this.f7229j;
        if (r0 == null) goto L14;
        r5.listen(r0, 0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        s4.h(th, "CgiManager", "destroy");
    L14:
        this.f7229j = null;
        this.f7230k = null;
        this.f7226g = null;
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void o(boolean r2, boolean r3) {
        this.o = a5.m(this.f7220a);     // Catch: Throwable -> L9 SecurityException -> L12
        if (N() == false) goto L6;
        s(r2, r3);     // Catch: Throwable -> L9 SecurityException -> L12
        j(O());     // Catch: Throwable -> L9 SecurityException -> L12
        m(P());     // Catch: Throwable -> L9 SecurityException -> L12
    L6:
        if (this.o == false) goto L17;
        E();     // Catch: Throwable -> L9 SecurityException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        this.s = e.getMessage();
        return;
    L9:
        th = move-exception;
        s4.h(th, "CgiManager", "refresh");
    }

    public final void r() {
        boolean r0 = false;
    L27:
        u4.c();
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 31) goto L6;
        return;
    L6:
        if (this.f7220a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L8;
        String r1 = "hasFineLocPerm";
    L10:
        if (this.f7220a.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L12;
        String r2 = "hasReadPhoneStatePerm";
    L13:
        boolean r4 = true;
        if (TextUtils.isEmpty(this.r) == true) goto L19;
        if (this.r.equals(r1) == true) goto L19;
        r0 = true;
    L19:
        if (TextUtils.isEmpty(this.q) == false) goto L21;
    L23:
        r4 = r0;
    L24:
        if (r4 == false) goto L32;
        u4.c();     // Catch: Throwable -> L27
        K();     // Catch: Throwable -> L27
        return;
    L32:
        return;
    L21:
        if (this.q.equals(r2) == true) goto L23;
    L12:
        r2 = "hasNoReadPhoneStatePerm";
        goto L13
    L8:
        r1 = "hasNoFineLocPerm";
        goto L10
    }

    public final synchronized ArrayList<b4> v() {
        monitor-enter(this);
        ArrayList<b4> r0 = new ArrayList();     // Catch: Throwable -> L12
        ArrayList<b4> r1 = this.f7223d;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Iterator<b4> r2 = r1.iterator();     // Catch: Throwable -> L12
    L7:
        if (r2.hasNext() == false) goto L10;
        r0.add(r2.next().d());     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized ArrayList<b4> w() {
        monitor-enter(this);
        ArrayList<b4> r0 = new ArrayList();     // Catch: Throwable -> L12
        ArrayList<b4> r1 = this.f7225f;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Iterator<b4> r2 = r1.iterator();     // Catch: Throwable -> L12
    L7:
        if (r2.hasNext() == false) goto L10;
        r0.add(r2.next().d());     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized b4 z() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.o == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList<b4> r0 = this.f7223d;     // Catch: Throwable -> L15
        if (r0.size() <= 0) goto L13;
        b4 r1 = r0.get(0).d();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L13:
        monitor-exit(this);
        return null;
    }
}
