package tmsdk.fg.module.cleanV2;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.TMSDKContext;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.lang.MultiLangManager;
import tmsdk.common.module.update.CheckResult;
import tmsdk.common.module.update.ICheckListener;
import tmsdk.common.module.update.IUpdateListener;
import tmsdk.common.module.update.UpdateConfig;
import tmsdk.common.module.update.UpdateInfo;
import tmsdk.common.module.update.UpdateManager;
import tmsdk.common.tcc.QFile;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.ad;
import tmsdkobf.b0;
import tmsdkobf.bc;
import tmsdkobf.c2;
import tmsdkobf.ee;
import tmsdkobf.fd;
import tmsdkobf.gd;
import tmsdkobf.h8;
import tmsdkobf.hd;
import tmsdkobf.lk;
import tmsdkobf.mg;
import tmsdkobf.o;
import tmsdkobf.o4;
import tmsdkobf.o8;
import tmsdkobf.q8;
import tmsdkobf.ra;
import tmsdkobf.s6;
import tmsdkobf.tb;
import tmsdkobf.v3;
import tmsdkobf.ve;
import tmsdkobf.we;
import tmsdkobf.z3;

/* JADX INFO: loaded from: classes5.dex */
class a extends BaseManagerF implements s6 {
    gd b;
    gd c;
    gd d;
    hd e;
    HashMap f;
    MultiLangManager g;
    Context h;
    private final Object i;
    private final Object j;
    private final Object k;
    private h8.b l;
    b m;

    /* JADX INFO: renamed from: tmsdk.fg.module.cleanV2.a$a, reason: collision with other inner class name */
    class C0092a implements ICheckListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UpdateManager f69a;
        final /* synthetic */ a b;

        /* JADX INFO: renamed from: tmsdk.fg.module.cleanV2.a$a$a, reason: collision with other inner class name */
        class C0093a implements IUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0092a f70a;

            C0093a(C0092a r1) {
                this.f70a = r1;
            }

            @Override // tmsdk.common.module.update.IUpdateListener
            public void onProgressChanged(UpdateInfo r1, int r2) {
            }

            @Override // tmsdk.common.module.update.IUpdateListener
            public void onUpdateCanceled() {
            }

            @Override // tmsdk.common.module.update.IUpdateListener
            public void onUpdateEvent(UpdateInfo r1, int r2) {
                q8.c("clean_update", "update | onProgressChanged, errCode = " + r2);
            }

            @Override // tmsdk.common.module.update.IUpdateListener
            public void onUpdateFinished() {
                q8.c("clean_update", "update | onUpdateFinished");
            }

            @Override // tmsdk.common.module.update.IUpdateListener
            public void onUpdateStarted() {
            }
        }

        C0092a(a r1, UpdateManager r2) {
            this.b = r1;
            this.f69a = r2;
        }

        @Override // tmsdk.common.module.update.ICheckListener
        public void onCheckCanceled() {
        }

        @Override // tmsdk.common.module.update.ICheckListener
        public void onCheckEvent(int r1) {
        }

        @Override // tmsdk.common.module.update.ICheckListener
        public void onCheckFinished(CheckResult r3) {
            if (r3 != null) goto L5;
            q8.c("clean_update", "check | result == null");
            return;
        L5:
            this.f69a.update(r3.mUpdateInfoList, new C0093a(this));
        }

        @Override // tmsdk.common.module.update.ICheckListener
        public void onCheckStarted() {
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile RubbishHolder f71a;
        volatile ICleanTaskCallBack b;
        volatile int c;
        final boolean d;
        final boolean e;
        final AtomicBoolean f;
        final AtomicBoolean g;
        final /* synthetic */ a h;

        /* JADX INFO: renamed from: tmsdk.fg.module.cleanV2.a$b$a, reason: collision with other inner class name */
        class RunnableC0094a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f72a;

            RunnableC0094a(b r1) {
                this.f72a = r1;
            }

            private int a() {
                int r2 = 0;
                if (this.f72a.f71a.getmApkRubbishes() == null) goto L11;
                Iterator<RubbishEntity> r0 = this.f72a.f71a.getmApkRubbishes().iterator();
            L6:
                if (r0.hasNext() == false) goto L11;
                RubbishEntity r3 = r0.next();
                if (r3.getStatus() != 1) goto L6;
                r2 = r2 + r3.getRubbishKey().size();
            L11:
                if (this.f72a.f71a.getmSystemRubbishes() == null) goto L19;
                Iterator<Map.Entry<String, RubbishEntity>> r1 = this.f72a.f71a.getmSystemRubbishes().entrySet().iterator();
            L14:
                if (r1.hasNext() == false) goto L19;
                Map.Entry<String, RubbishEntity> r4 = r1.next();
                if (r4.getValue().getStatus() != 1) goto L14;
                r2 = r2 + r4.getValue().getRubbishKey().size();
            L19:
                if (this.f72a.f71a.getmInstallRubbishes() == null) goto L27;
                Iterator<Map.Entry<String, RubbishEntity>> r5 = this.f72a.f71a.getmInstallRubbishes().entrySet().iterator();
            L22:
                if (r5.hasNext() == false) goto L27;
                Map.Entry<String, RubbishEntity> r6 = r5.next();
                if (r6.getValue().getStatus() != 1) goto L22;
                r2 = r2 + r6.getValue().getRubbishKey().size();
            L27:
                if (this.f72a.f71a.getmUnInstallRubbishes() == null) goto L34;
                Iterator<Map.Entry<String, RubbishEntity>> r7 = this.f72a.f71a.getmUnInstallRubbishes().entrySet().iterator();
            L30:
                if (r7.hasNext() == false) goto L34;
                Map.Entry<String, RubbishEntity> r8 = r7.next();
                if (r8.getValue().getStatus() != 1) goto L30;
                r2 = r2 + r8.getValue().getRubbishKey().size();
            L34:
                return r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f72a.c = 0;
                if (this.f72a.b == null) goto L5;
                this.f72a.b.onCleanStarted();
            L5:
                int r0 = a();
                if (r0 <= 0) goto L76;
                if (this.f72a.f71a.getmApkRubbishes() == null) goto L25;
                Iterator<RubbishEntity> r1 = this.f72a.f71a.getmApkRubbishes().iterator();
            L11:
                if (r1.hasNext() == false) goto L25;
                RubbishEntity r3 = r1.next();
                if (this.f72a.f.get() == false) goto L21;
                if (this.f72a.g.get() == true) goto L21;
                if (this.f72a.b == null) goto L21;
            L18:
                this.f72a.b.onCleanCanceled();
                this.f72a.b();
                return;
            L21:
                if (r3.getStatus() != 1) goto L11;
                b r4 = this.f72a;
                b.m2356$$Nest$ma(r4, r3, r0, r4.d);
            L25:
                if (this.f72a.f71a.getmSystemRubbishes() == null) goto L44;
                Iterator<Map.Entry<String, RubbishEntity>> r2 = this.f72a.f71a.getmSystemRubbishes().entrySet().iterator();
            L28:
                if (r2.hasNext() == false) goto L44;
                Map.Entry<String, RubbishEntity> r5 = r2.next();
                if (this.f72a.f.get() == false) goto L37;
                if (this.f72a.g.get() == true) goto L37;
                if (this.f72a.b != null) goto L18;
            L37:
                if (r5.getValue().getStatus() != 1) goto L28;
                if (r5.getValue().getRubbishKey() == null) goto L41;
                b.m2357$$Nest$mb(this.f72a, r5.getValue(), r0, this.f72a.d);
                goto L28
            L41:
                return;
            L44:
                if (this.f72a.f71a.getmInstallRubbishes() == null) goto L60;
                Iterator<Map.Entry<String, RubbishEntity>> r6 = this.f72a.f71a.getmInstallRubbishes().entrySet().iterator();
            L47:
                if (r6.hasNext() == false) goto L60;
                Map.Entry<String, RubbishEntity> r7 = r6.next();
                if (this.f72a.f.get() == false) goto L56;
                if (this.f72a.g.get() == true) goto L56;
                if (this.f72a.b != null) goto L18;
            L56:
                if (r7.getValue().getStatus() != 1) goto L47;
                b.m2357$$Nest$mb(this.f72a, r7.getValue(), r0, this.f72a.d);
            L60:
                if (this.f72a.f71a.getmUnInstallRubbishes() == null) goto L76;
                Iterator<Map.Entry<String, RubbishEntity>> r8 = this.f72a.f71a.getmUnInstallRubbishes().entrySet().iterator();
            L63:
                if (r8.hasNext() == false) goto L76;
                Map.Entry<String, RubbishEntity> r9 = r8.next();
                if (this.f72a.f.get() == false) goto L72;
                if (this.f72a.g.get() == true) goto L72;
                if (this.f72a.b != null) goto L18;
            L72:
                if (r9.getValue().getStatus() != 1) goto L63;
                b.m2357$$Nest$mb(this.f72a, r9.getValue(), r0, this.f72a.d);
            L76:
                if (this.f72a.b == null) goto L106;
                b r10 = this.f72a;
                if (r10.e == true) goto L107;
                r10.b.onCleanFinished();
                this.f72a.b();
                return;
            L107:
                return;
            }
        }

        /* JADX INFO: renamed from: tmsdk.fg.module.cleanV2.a$b$b, reason: collision with other inner class name */
        class RunnableC0095b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f73a;

            RunnableC0095b(b r1) {
                this.f73a = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                Random r0 = new Random();     // Catch: Throwable -> L34
                if (this.f73a.f71a == null) goto L7;
                long r1 = this.f73a.f71a.getAllRubbishFileSize();     // Catch: Throwable -> L34
                if (r1 <= 0) goto L7;
                if (r1 >= 100000000) goto L12;
                int r2 = 5;
            L15:
                int r3 = 1;
            L16:
                if (r3 > r2) goto L28;
                if (this.f73a.f.get() == true) goto L20;
                Thread.sleep(r0.nextInt(100) + 180);     // Catch: Throwable -> L34
                if (this.f73a.b == null) goto L26;
                this.f73a.b.onCleanProcessChange((100 / r2) * r3, "");     // Catch: Throwable -> L34
            L26:
                r3 = r3 + 1;     // Catch: Throwable -> L34
                goto L16
            L20:
                if (this.f73a.b == null) goto L22;
                this.f73a.b.onCleanCanceled();     // Catch: Throwable -> L34
            L22:
                this.f73a.b();     // Catch: Throwable -> L34
            L28:
                if (this.f73a.f.get() == true) goto L43;
                this.f73a.g.set(true);     // Catch: Throwable -> L34
                if (this.f73a.b == null) goto L32;
                this.f73a.b.onCleanFinished();     // Catch: Throwable -> L34
            L32:
                this.f73a.b();     // Catch: Throwable -> L34
                return;
            L43:
                return;
            L12:
                if (r1 >= 1000000000) goto L14;
                r2 = 10;
                goto L15
            L14:
                r2 = 20;
            L7:
                r2 = 2;
            L34:
                th = move-exception;
                q8.b(CleanManager.TAG, th);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2356$$Nest$ma(b r0, RubbishEntity r1, int r2, boolean r3) {
            r0.a(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2357$$Nest$mb(b r0, RubbishEntity r1, int r2, boolean r3) {
            r0.b(r1, r2, r3);
        }

        protected b(a r2, RubbishHolder r3, ICleanTaskCallBack r4, boolean r5, boolean r6) {
            this.h = r2;
            this.f = new AtomicBoolean(false);
            this.g = new AtomicBoolean(false);
            this.f71a = r3;
            this.b = r4;
            this.d = r5;
            this.e = r6;
        }

        private int b(ContentResolver r2, File r3) {
            if (r3 != null) goto L14;
            return 0;
        L14:
        L11:
            e = move-exception;
            e.printStackTrace();
        L13:
            return 0;
        L6:
            if (new o4(r2, r3).a() == false) goto L8;
            return 1;
        L8:
            if (r3.delete() == false) goto L13;
            return 1;
        }

        protected void a() {
            this.f.set(true);
        }

        protected boolean c() {
            if (this.b != null) goto L6;
            return false;
        L6:
            we r0 = ve.f();
            r0.a(new RunnableC0094a(this), "clean_now");
            if (this.e == false) goto L11;
            r0.a(new RunnableC0095b(this), "clean_bg");
            return true;
        L11:
            return true;
        }

        private void a(RubbishEntity r5, int r6, boolean r7) {
            List<String> r0 = r5.getRubbishKey();     // Catch: Exception -> L25
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.size() <= 0) goto L34;
            String r1 = r0.get(0);     // Catch: Exception -> L25
            Iterator<String> r2 = r0.iterator();     // Catch: Exception -> L25
        L9:
            if (r2.hasNext() == false) goto L21;
            String r3 = r2.next();     // Catch: Exception -> L25
            if (r3 == null) goto L9;
            File r4 = new File(r3);     // Catch: Exception -> L25
            if (r7 == true) goto L16;
            b(TMSDKContext.getApplicaionContext().getContentResolver(), r4);     // Catch: Exception -> L25
        L19:
            this.c++;     // Catch: Exception -> L25
            goto L9
        L16:
            if (a.m2355$$Nest$smc() == true) goto L19;
            r4.delete();     // Catch: Exception -> L25
            goto L19
        L21:
            if (this.e == true) goto L23;
            this.b.onCleanProcessChange((this.c * 100) / r6, r1);     // Catch: Exception -> L25
        L23:
            r5.a();     // Catch: Exception -> L25
            return;
        L34:
            return;
        }

        private void b(RubbishEntity r5, int r6, boolean r7) {
            List<String> r0 = r5.getRubbishKey();     // Catch: Exception -> L17
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.size();     // Catch: Exception -> L17
            if (r1 <= 0) goto L20;
            String r2 = r0.get(0);     // Catch: Exception -> L17
            if (a.m2355$$Nest$smc() == true) goto L12;
            if (r7 == false) goto L11;
            b(r0);     // Catch: Exception -> L17
            goto L12
        L11:
            a(r0);     // Catch: Exception -> L17
        L12:
            this.c += r1;     // Catch: Exception -> L17
            if (this.e == true) goto L15;
            this.b.onCleanProcessChange((this.c * 100) / r6, r2);     // Catch: Exception -> L17
        L15:
            r5.a();     // Catch: Exception -> L17
            return;
        L20:
            return;
        }

        private void a(List r6) {
            ContentResolver r0 = TMSDKContext.getApplicaionContext().getContentResolver();
            int r1 = r6.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            String r3 = (String) r6.get(r2);
            if (r3 == null) goto L8;
            a(r0, new File(r3.trim()));
        L8:
            r2 = r2 + 1;
            goto L3
        }

        private void b(List r3) {
            Iterator r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L12;
            String r0 = (String) r4.next();
            if (TextUtils.isEmpty(r0) == true) goto L4;
            File r1 = new File(r0);
            if (r1.isDirectory() == true) goto L10;
            r1.delete();
            goto L4
        L10:
            a(r1, 0);
            goto L4
        }

        private void a(File r5, int r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            int r7 = r6 + 1;
            if (19 < r7) goto L23;
            File[] r0 = r5.listFiles();
            if (r0 != null) goto L14;
            r5.delete();
            return;
        L14:
            int r1 = r0.length;
            int r2 = 0;
        L15:
            if (r2 >= r1) goto L20;
            if (r0[r2].isDirectory() == false) goto L19;
            a(r0[r2], r7);
        L19:
            r0[r2].delete();
            r2 = r2 + 1;
            goto L15
        L20:
            r5.delete();
            return;
        L23:
            Runtime.getRuntime().exec("rm -rf " + r5.getPath());     // Catch: Exception -> L22
        L8:
            r5.delete();
        }

        protected void b() {
            this.f71a = null;
            this.b = null;
            this.h.m = null;
        }

        private int a(ContentResolver r6, File r7) {
            if (r7.getName().startsWith(LibrarianImpl.Constants.DOT) == false) goto L10;
            if (r7.isDirectory() == false) goto L7;
            new QFile(r7.getPath()).deleteAllChildren();
        L7:
            r7.delete();
            return 1;
        L10:
            if (r7.isDirectory() == false) goto L18;
            File[] r0 = r7.listFiles();
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L12:
            if (r2 >= r1) goto L15;
            r3 = r3 + a(r6, r0[r2]);
            r2 = r2 + 1;
            goto L12
        L15:
            if (r7.delete() == true) goto L21;
            return r3;
        L21:
            return r3 + 1;
        L18:
            return b(r6, r7);
        }
    }

    public static /* synthetic */ void $r8$lambda$sE59WrZLiwesg2k1Q4OUFTBg1iQ(a r0, boolean r1, IUpdateCallBack r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smc, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2355$$Nest$smc() {
        return c();
    }

    protected a() {
        this.i = new Object();
        this.j = new Object();
        this.k = new Object();
    }

    private boolean a(z3 r6) {
        lk r5 = (lk) mg.a(TMSDKContext.getApplicaionContext(), UpdateConfig.DEEPCLEAN_SDCARD_SCAN_RULE_NAME_V2_SDK, UpdateConfig.intToString(40415), new lk(), "UTF-8");
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.f338a == null) goto L16;
        List r7 = bc.a().a(r5.f338a);
        if (r6 == null) goto L11;
        r6.b(String.valueOf(40415));
    L11:
        if (r7.size() <= 10) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    private void b() {
        z3 r0 = new z3();
        if (r0.d() == true) goto L5;
    L8:
        r0.b(a(r0));
        return;
    L5:
        if (bc.a().d() == false) goto L8;
        if (r0.a(String.valueOf(40415)) == true) goto L8;
    }

    private static boolean c() {
        return false;
    }

    protected boolean addUninstallPkg(String r1) {
        if (b0.a() == false) goto L7;
        return false;
    L7:
        return bc.a().a(r1);
    }

    protected boolean cancelClean() {
        if (b0.a() == false) goto L5;
        return false;
    L5:
        b r0 = this.m;
        if (r0 != null) goto L8;
        return false;
    L8:
        r0.a();
        this.m = null;
        return true;
    }

    protected boolean cancelScan(int r4) {
        if (r4 == 0) goto L22;
        if (r4 != 1) goto L6;
        fd r3 = this.c;
        if (r3 != null) goto L24;
        return false;
    L24:
        r3.a();
        return true;
    L6:
        if (r4 != 2) goto L8;
        r3 = this.e;
        if (r3 != null) goto L24;
        return false;
    L8:
        if (r4 == 3) goto L10;
        return false;
    L10:
        r3 = this.d;
        if (r3 != null) goto L24;
        return false;
    L22:
        r3 = this.b;
        if (r3 != null) goto L24;
        return false;
    }

    protected boolean cleanRubbish(RubbishHolder r8, boolean r9, ICleanTaskCallBack r10) {
        if (b0.a() == false) goto L6;
        return false;
    L6:
        if (this.m == null) goto L8;
        return false;
    L8:
        if (r8 != null) goto L10;
        return false;
    L10:
        ad.e(21);
        b r0 = new b(this, r8, r10, true, r9);
        this.m = r0;
        return r0.c();
    }

    protected boolean cleanRubbishSlow(RubbishHolder r8, boolean r9, ICleanTaskCallBack r10) {
        if (b0.a() == false) goto L6;
        return false;
    L6:
        if (this.m == null) goto L8;
        return false;
    L8:
        if (r8 != null) goto L10;
        return false;
    L10:
        ad.e(22);
        b r0 = new b(this, r8, r10, false, r9);
        this.m = r0;
        return r0.c();
    }

    protected boolean delUninstallPkg(String r1) {
        if (b0.a() == false) goto L7;
        return false;
    L7:
        return bc.a().b(r1);
    }

    protected boolean easyScan(IScanTaskCallBack r12, ArrayList r13, Set r14, Set r15, boolean r16, boolean r17, int r18, boolean r19) {
        if (b0.a() == false) goto L6;
        return false;
    L6:
        if (this.c == null) goto L8;
        return false;
    L8:
        if (r16 == false) goto L10;
        int r1 = 120;
    L11:
        ad.e(r1);
        Object r2 = this.i;
        monitor-enter(r2);
        this.c = new gd(this, r13, r18);     // Catch: Throwable -> L16
        b();     // Catch: Throwable -> L16
        boolean r6 = this.g.isENG();     // Catch: Throwable -> L16
        tb.b(r6);     // Catch: Throwable -> L16
        ad r3 = new ad(2, r13, r6, true, r17, r19, r12);     // Catch: Throwable -> L16
        r3.b(r14);     // Catch: Throwable -> L16
        r3.a(r15);     // Catch: Throwable -> L16
        boolean r0 = this.c.b(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return r0;
    L16:
        th = move-exception;
        throw th;
    L10:
        r1 = 12;
        goto L11
    }

    protected AppGroupDesc getGroupInfo(int r2) {
        if (this.f != null) goto L5;
        this.f = o.a();
    L5:
        HashMap r1 = this.f;
        if (r1 != null) goto L8;
        return null;
    L8:
        return (AppGroupDesc) r1.get(Integer.valueOf(r2));
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 1;
    }

    protected void languageChange() {
        HashMap r0 = o.a();     // Catch: Throwable -> L12
        if (r0 == null) goto L8;
        HashMap r1 = this.f;     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
        this.f = r0;     // Catch: Throwable -> L12
        goto L8
    L7:
        r1.clear();     // Catch: Throwable -> L12
        this.f.putAll(r0);     // Catch: Throwable -> L12
    L8:
        MultiLangManager r2 = this.g;     // Catch: Throwable -> L12
        if (r2 == null) goto L15;
        tb.b(r2.isENG());     // Catch: Throwable -> L12
        return;
    L15:
        return;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        this.h = r2;
        o8.e().g();
        ra.a().b(ee.d());
        this.g = (MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class);
        this.l = new a$$ExternalSyntheticLambda0(this);
        h8.d().a(this.l);
        ad.e(1);
    }

    public void onDestroy() {
        if (this.l == null) goto L5;
        h8.d().b(this.l);
        this.l = null;
    L5:
        Object r0 = this.k;
        monitor-enter(r0);
        gd r2 = this.b;     // Catch: Throwable -> L34
        if (r2 == null) goto L10;
        r2.a();     // Catch: Throwable -> L34
        this.b.l();     // Catch: Throwable -> L34
        this.b = null;     // Catch: Throwable -> L34
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L34
        Object r3 = this.i;
        monitor-enter(r3);
        gd r1 = this.c;     // Catch: Throwable -> L31
        if (r1 == null) goto L16;
        r1.a();     // Catch: Throwable -> L31
        this.c.l();     // Catch: Throwable -> L31
        this.c = null;     // Catch: Throwable -> L31
    L16:
        monitor-exit(r3);     // Catch: Throwable -> L31
        Object r4 = this.j;
        monitor-enter(r4);
        hd r5 = this.e;     // Catch: Throwable -> L28
        if (r5 == null) goto L22;
        r5.a();     // Catch: Throwable -> L28
        this.e.l();     // Catch: Throwable -> L28
        this.e = null;     // Catch: Throwable -> L28
    L22:
        monitor-exit(r4);     // Catch: Throwable -> L28
        o8.e().a();
        gd r6 = this.d;
        if (r6 == null) goto L26;
        r6.a();
        this.d.l();
        this.d = null;
    L26:
        this.f = null;
        return;
    L28:
        th = move-exception;
        throw th;
    L31:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;
    }

    protected boolean scan4app(String r14, ArrayList r15, boolean r16, boolean r17, int r18, boolean r19, IScanTaskCallBack r20) {
        if (b0.a() == false) goto L6;
        return false;
    L6:
        if (this.e == null) goto L8;
        return false;
    L8:
        if (r16 == false) goto L10;
        int r3 = 130;
    L11:
        ad.e(r3);
        Object r4 = this.j;
        monitor-enter(r4);
        List r5 = new v3(false).a(r14);     // Catch: Throwable -> L29
        if (r5 != null) goto L16;
    L17:
        q8.b(CleanManager.TAG, "database is null , copy 2 db; ret=" + a(new z3()));     // Catch: Throwable -> L29
    L18:
        hd r2 = new hd(this, r15, r18);     // Catch: Throwable -> L29
        boolean r7 = this.g.isENG();     // Catch: Throwable -> L29
        tb.b(r7);     // Catch: Throwable -> L29
        if (TextUtils.equals(r14, new String(c2.f)) == false) goto L23;
        int r6 = 3;
    L26:
        ad r12 = new ad(r6, r15, r7, false, r17, r19, r20);     // Catch: Throwable -> L29
        r12.e(r14);     // Catch: Throwable -> L29
        boolean r1 = r2.b(r12);     // Catch: Throwable -> L29
        this.e = r2;     // Catch: Throwable -> L29
        monitor-exit(r4);     // Catch: Throwable -> L29
        return r1;
    L23:
        if (TextUtils.equals(r14, new String(c2.g)) == false) goto L25;
        r6 = 4;
        goto L26
    L25:
        r6 = 7;
        goto L26
    L16:
        if (r5.size() != 0) goto L18;
    L29:
        th = move-exception;
        throw th;
    L10:
        r3 = 13;
        goto L11
    }

    protected boolean scanDisk(IScanTaskCallBack r14, ArrayList r15, Set r16, Set r17, boolean r18, boolean r19, int r20, boolean r21) {
        if (b0.a() == false) goto L8;
        String r0 = CleanManager.TAG;
        String r1 = "scanDisk: isExpired";
    L5:
        q8.b(r0, r1);
        return false;
    L8:
        if (this.b == null) goto L10;
        r0 = CleanManager.TAG;
        r1 = "scanDisk: null!=mScanTaskDisk";
        goto L5
    L10:
        if (r18 == false) goto L12;
        int r2 = 110;
    L13:
        ad.e(r2);
        if (r16 == null) goto L19;
        Iterator r3 = r16.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        q8.b(CleanManager.TAG, "scanDisk whitePath: " + ((String) r3.next()));
    L19:
        Object r4 = this.k;
        monitor-enter(r4);
        gd r5 = new gd(this, r15, r20);     // Catch: Throwable -> L24
        b();     // Catch: Throwable -> L24
        boolean r7 = this.g.isENG();     // Catch: Throwable -> L24
        tb.b(r7);     // Catch: Throwable -> L24
        ad r12 = new ad(1, r15, r7, false, r19, r21, r14);     // Catch: Throwable -> L24
        r12.b(r16);     // Catch: Throwable -> L24
        r12.a(r17);     // Catch: Throwable -> L24
        boolean r6 = r5.b(r12);     // Catch: Throwable -> L24
        this.b = r5;     // Catch: Throwable -> L24
        monitor-exit(r4);     // Catch: Throwable -> L24
        return r6;
    L24:
        th = move-exception;
        throw th;
    L12:
        r2 = 11;
        goto L13
    }

    protected boolean updateRule(boolean r2, IUpdateCallBack r3) {
        if (b0.a() == false) goto L5;
        return false;
    L5:
        ad.e(31);
        return o8.e().a(r2, r3);
    L8:
        th = move-exception;
        q8.c(CleanManager.TAG, th);
        return false;
    }

    protected boolean updateRuleAndDatFile(final boolean r3, final IUpdateCallBack r4) {
        ad.e(32);
        ve.f().a(new a$$ExternalSyntheticLambda1(this, r3, r4), "updateDat");
        return true;
    }

    private /* synthetic */ void a(boolean r7, IUpdateCallBack r8) {
        updateRule(r7, r8);
        UpdateManager r0 = (UpdateManager) ManagerCreatorC.getManager(UpdateManager.class);     // Catch: Throwable -> L5
        r0.check(5188147870242439168L, new C0092a(this, r0), -1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        q8.c(CleanManager.TAG, th);
    }

    @Override // tmsdkobf.s6
    public void a(int r3) {
        if (r3 != 0) goto L5;
        Object r4 = this.k;
        monitor-enter(r4);
        this.b = null;     // Catch: Throwable -> L30
        monitor-exit(r4);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r3 != 1) goto L7;
        Object r5 = this.i;
        monitor-enter(r5);
        this.c = null;     // Catch: Throwable -> L22
        monitor-exit(r5);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L7:
        if (r3 == 2) goto L9;
        return;
    L9:
        Object r6 = this.j;
        monitor-enter(r6);
        this.e = null;     // Catch: Throwable -> L14
        monitor-exit(r6);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
