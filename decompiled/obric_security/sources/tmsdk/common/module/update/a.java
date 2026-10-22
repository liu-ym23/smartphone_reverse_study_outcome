package tmsdk.common.module.update;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.utils.Constants;
import com.qq.taf.jce.JceStruct;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.bg.tcc.TelNumberLocator;
import tmsdk.common.NumMarker;
import tmsdk.common.YellowPages;
import tmsdk.common.creator.BaseManagerC;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.qscanner.impl.AmScannerV2;
import tmsdkobf.a5;
import tmsdkobf.a6;
import tmsdkobf.b3;
import tmsdkobf.b6;
import tmsdkobf.c3;
import tmsdkobf.cg;
import tmsdkobf.e2;
import tmsdkobf.f;
import tmsdkobf.ff;
import tmsdkobf.g8;
import tmsdkobf.h1;
import tmsdkobf.h8;
import tmsdkobf.ic;
import tmsdkobf.of;
import tmsdkobf.p9;
import tmsdkobf.pd;
import tmsdkobf.pg;
import tmsdkobf.q8;
import tmsdkobf.qc;
import tmsdkobf.ua;
import tmsdkobf.ve;
import tmsdkobf.w6;
import tmsdkobf.x0;
import tmsdkobf.ye;
import tmsdkobf.yf;
import tmsdkobf.z4;
import tmsdkobf.za;

/* JADX INFO: loaded from: classes5.dex */
final class a extends BaseManagerC {
    private Context b;
    private String c;
    private AtomicBoolean d;
    private HashMap e;
    private tmsdk.common.module.update.b f;

    /* JADX INFO: renamed from: tmsdk.common.module.update.a$a, reason: collision with other inner class name */
    class C0091a implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f59a;
        final /* synthetic */ ICheckListener b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ a d;

        C0091a(a r1, long r2, ICheckListener r4, ArrayList r5) {
            this.d = r1;
            this.f59a = r2;
            this.b = r4;
            this.c = r5;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r7, int r8, int r9, int r10, JceStruct r11) {
            q8.a("UpdateMgr", "[Shark]onFinish-Cmd_CSConfInfo, elapsed time:[" + (System.currentTimeMillis() - this.f59a) + "]cmdId:[" + r8 + "]retCode:[" + r9 + "]dataRetCode: " + r10);
            q8.b("UpdateMgr", "[UpdateManager] disconnect for check update data");
            if (r11 != null) goto L6;
            q8.e("UpdateMgr", "null == resp");
            a.m2352$$Nest$ma(this.d, -205, this.b);
            return;
        L6:
            ic r12 = (ic) r11;
            if (r12 == null) goto L59;
            ArrayList r13 = r12.e;
            if (r13 == null) goto L59;
            if (r13.size() > 0) goto L15;
            q8.a("UpdateMgr", "size: 0, no available db");
            a.m2352$$Nest$ma(this.d, r9, this.b);
            return;
        L15:
            if (r9 != 0) goto L53;
            Iterator r14 = r12.e.iterator();
            int r15 = 0;
        L18:
            if (r14.hasNext() == false) goto L42;
            pd r0 = (pd) r14.next();
            if (r0 == null) goto L18;
            int r4 = r15 + 1;
            q8.a("UpdateMgr", "[" + r15 + "]resp::fileId:[" + r0.f418a + "]isIncreUpdate:[" + r0.e + "]");
            UpdateInfo r16 = new UpdateInfo();
            if (40458 == r0.f418a) goto L37;
            int r2 = UpdateConfig.getLargeMarkFileId();
            int r5 = r0.f418a;
            if (r2 == r5) goto L37;
            if (40801 == r5) goto L37;
            if (40800 == r5) goto L37;
            if (40461 == r5) goto L37;
            if (r0.e == false) goto L35;
            StringBuilder r3 = new StringBuilder().append(UpdateConfig.getFileNameByFileId(r0.f418a));
            String r6 = UpdateConfig.PATCH_SUFIX;
        L40:
            String r17 = r3.append(r6).toString();
        L41:
            r16.fileName = r17;
            r16.mFileID = r0.f418a;
            q8.a("UpdateMgr", "[" + r4 + "]resp::fileName:[" + r16.fileName + "]url:[" + r0.d + "]");
            r16.flag = UpdateConfig.getFlagByFileId(r0.f418a);
            r16.type = 0;
            r16.url = r0.d;
            r16.data1 = r0;
            r16.fileSize = r0.i;
            this.c.add(r16);
            r15 = r4;
            goto L18
        L35:
            r17 = UpdateConfig.getFileNameByFileId(r5);
        L37:
            if (r0.e == false) goto L39;
            r3 = new StringBuilder().append(UpdateConfig.intToString(r0.f418a));
            r6 = ".sdb.patch";
            goto L40
        L39:
            r3 = new StringBuilder().append(UpdateConfig.intToString(r0.f418a));
            r6 = ".sdb";
            goto L40
        L42:
            CheckResult r18 = new CheckResult();
            ff r19 = r12.c;
            String r110 = "";
            if (r19 == null) goto L45;
            String r111 = r19.f202a;
        L46:
            r18.mTitle = r111;
            if (r19 == null) goto L49;
            r110 = r19.b;
        L49:
            r18.mMessage = r110;
            r18.mUpdateInfoList = this.c;
            if (this.b == null) goto L52;
            q8.a("UpdateMgr", "[callback]onCheckFinished");
            this.b.onCheckFinished(r18);
        L52:
            q8.a("UpdateMgr", "title:[" + r18.mTitle + "]msg:[" + r18.mMessage + "]");
            return;
        L45:
            r111 = "";
            goto L46
        L53:
            q8.a("UpdateMgr", "failed, retCode: " + r9);
            if ((r9 % 20) != (-4)) goto L56;
            a r20 = this.d;
            ICheckListener r21 = this.b;
            int r22 = -206;
        L57:
            a.m2352$$Nest$ma(r20, r22, r21);
            return;
        L56:
            r20 = this.d;
            r21 = this.b;
            r22 = -999;
        L59:
            q8.e("UpdateMgr", "(SCConfInfo)resp.vecConfInfo empty");
            a.m2352$$Nest$ma(this.d, -205, this.b);
        }
    }

    class b implements a6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IUpdateListener f60a;
        final /* synthetic */ UpdateInfo b;
        final /* synthetic */ AtomicBoolean c;
        final /* synthetic */ a d;

        b(a r1, IUpdateListener r2, UpdateInfo r3, AtomicBoolean r4) {
            this.d = r1;
            this.f60a = r2;
            this.b = r3;
            this.c = r4;
        }

        @Override // tmsdkobf.a6.a
        public void a(Bundle r4) {
            int r0 = r4.getInt("key_errcode");
            if (this.f60a == null) goto L5;
            q8.a("UpdateMgr", "[callback]onUpdateEvent:[" + r0 + "]");
            this.f60a.onUpdateEvent(this.b, r0);
        L5:
            this.c.set(true);
            UpdateInfo r1 = this.b;
            r1.errorCode = r0;
            r1.errorMsg = r4.getString("key_errorMsg");
            this.b.downSize = r4.getInt("key_downSize");
            this.b.fileSize = r4.getInt("key_total");
            this.b.sdcardStatus = r4.getInt("key_sdcardstatus");
            this.b.downType = r4.getByte("key_downType");
        }

        @Override // tmsdkobf.a6.a
        public void b(Bundle r1) {
        }
    }

    class c implements b6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UpdateInfo f61a;
        final /* synthetic */ a b;

        c(a r1, UpdateInfo r2) {
            this.b = r1;
            this.f61a = r2;
        }

        @Override // tmsdkobf.b6.a
        public boolean a(String r8) {
            pd r0 = (pd) this.f61a.data1;
            if (r0 != null) goto L5;
            return true;
        L5:
            StringBuilder r2 = new StringBuilder("isMatch confSrc.md5Bin = ");
            byte[] r3 = r0.b;
            if (r3 != null) goto L8;
            String r4 = "null";
        L9:
            q8.b("UpdateMgr", r2.append(r4).toString());
            String r5 = c3.c(r0.b);
            int r1 = r0.l;
            if (r1 != 2) goto L36;
            StringBuilder r6 = new StringBuilder().append(new File(r8).getParentFile().getPath());
            String r7 = File.separator;
            String r9 = r6.append(r7).append("tempZip").append(r7).toString();
            File r10 = new File(r9);     // Catch: Exception -> L33
            if (r10.exists() == false) goto L15;
            a5.a(r10);     // Catch: Exception -> L33
        L15:
            pg.a(r8, r9);     // Catch: Exception -> L33
            File[] r11 = r10.listFiles();     // Catch: Exception -> L33
            if (r11 != null) goto L18;
        L32:
            return false;
        L18:
            if (r11.length == 0) goto L32;
            if (r11.length == 1) goto L24;
            return false;
        L24:
            if (r8.length() <= 8) goto L26;
            r8 = r8.substring(0, r8.length() - 8);     // Catch: Exception -> L33
        L27:
            File r12 = new File(r8);     // Catch: Exception -> L33
            if (r12.exists() == false) goto L30;
            r12.delete();     // Catch: Exception -> L33
        L30:
            a5.a(r11[0], r12);     // Catch: Exception -> L33
            a5.a(r10);     // Catch: Exception -> L33
        L41:
            if (TextUtils.isEmpty(r8) == false) goto L43;
            return false;
        L43:
            boolean r13 = a.m2353$$Nest$ma(this.b, r8, r5);
            q8.c(NumMarker.Tag, "DataMd5Cheker isMatch() isMth: " + r13);
            return r13;
        L26:
            r8 = r8 + ".tmp";     // Catch: Exception -> L33
        L33:
            e = move-exception;
            q8.a("UpdateMgr", "unzip num mark file failed", e);
            return false;
        L36:
            if (r1 != 1) goto L39;
            q8.b("UpdateMgr", "num mark file should not zip encrypt");
            return false;
        L39:
            q8.c("UpdateMgr", "normal num mark file");
            goto L41
        L8:
            r4 = Arrays.toString(r3);
            goto L9
        }
    }

    class d implements b6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UpdateInfo f62a;
        final /* synthetic */ a b;

        d(a r1, UpdateInfo r2) {
            this.b = r1;
            this.f62a = r2;
        }

        @Override // tmsdkobf.b6.a
        public boolean a(String r5) {
            q8.c("UpdateMgr", "isMatch filePath = " + r5);
            pd r0 = (pd) this.f62a.data1;
            if (r0 != null) goto L6;
            return true;
        L6:
            StringBuilder r2 = new StringBuilder("isMatch confSrc.md5Bin = ");
            byte[] r3 = r0.b;
            if (r3 != null) goto L9;
            String r4 = "null";
        L10:
            q8.c("UpdateMgr", r2.append(r4).toString());
            return a.m2354$$Nest$mb(this.b, r5, c3.c(r0.b));
        L9:
            r4 = Arrays.toString(r3);
            goto L10
        }
    }

    class e implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f63a;
        final /* synthetic */ long b;
        final /* synthetic */ AtomicReference c;
        final /* synthetic */ Object d;
        final /* synthetic */ a e;

        e(a r1, long r2, long r4, AtomicReference r6, Object r7) {
            this.e = r1;
            this.f63a = r2;
            this.b = r4;
            this.c = r6;
            this.d = r7;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r5, int r6, int r7, int r8, JceStruct r9) {
            q8.a("UpdateMgr", "[Shark]onFinish-Cmd_CSUpdateVirusInfos, elapsed time:[" + (System.currentTimeMillis() - this.f63a) + "]cmdId:[" + r6 + "]retCode:[" + r7 + "]dataRetCode: " + r8);
            q8.b("UpdateMgr", "[UpdateManager] disconnect for updateVirus");
            f.a(1320094, r7 + ";" + r8 + ";" + (System.currentTimeMillis() - this.b));
            if (r7 != 0) goto L24;
            if (r8 != 0) goto L24;
            if (r9 == null) goto L22;
            qc r10 = (qc) r9;
            cg r11 = r10.f441a;
            ArrayList r12 = r10.b;
            if (r11 != null) goto L11;
            String r13 = "UpdateMgr";
            String r14 = "SCUpdateVirusInfos.serverinfo is null!";
        L23:
            q8.e(r13, r14);
            this.c.set(-6);
        L31:
            Object r15 = this.d;
            monitor-enter(r15);
            this.d.notify();     // Catch: Throwable -> L36
            monitor-exit(r15);     // Catch: Throwable -> L36
            return;
        L36:
            th = move-exception;
            throw th;
        L11:
            if (r11.a() == false) goto L13;
            q8.e("UpdateMgr", "need update engine, donnot update virus base!");
            goto L31
        L13:
            if (r12 != null) goto L15;
        L20:
            q8.e("UpdateMgr", "no update info, virusInfoList: " + r12);
            goto L31
        L15:
            if (r12.size() <= 0) goto L20;
            String r16 = of.b(a.m2351$$Nest$fgetb(this.e), 1073741824);
            int r17 = AmScannerV2.a(a.m2351$$Nest$fgetb(this.e), r16, r11, r12);
            this.c.set(Integer.valueOf(r17));
            if (r17 == 0) goto L19;
            q8.e("UpdateMgr", "amf file error, delete:[" + r16 + "]");
            z4.a(r16);
        L19:
            q8.a("UpdateMgr", "native updateBase, size: " + r12.size() + " ret: " + r17);
            goto L31
        L22:
            r13 = "UpdateMgr";
            r14 = "SCUpdateVirusInfos is null!";
        L24:
            q8.e("UpdateMgr", "retCode != 0 || dataRetCode != 0");
            if ((r7 % 20) != (-4)) goto L27;
            AtomicReference r18 = this.c;
            int r19 = -206;
        L28:
            r18.set(Integer.valueOf(r19));
            if (r8 == 0) goto L31;
            this.c.set(-205);
            goto L31
        L27:
            r18 = this.c;
            r19 = -999;
            goto L28
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2351$$Nest$fgetb(a r0) {
        return r0.b;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2352$$Nest$ma(a r0, int r1, ICheckListener r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2353$$Nest$ma(a r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2354$$Nest$mb(a r0, String r1, String r2) {
        return r0.b(r1, r2);
    }

    a() {
        this.c = null;
        this.d = new AtomicBoolean(false);
        this.e = new HashMap();
    }

    private e2 b(long r3) {
        if (r3 != 4) goto L6;
    L15:
        return null;
    L6:
        if (r3 != 1073741824) goto L8;
    L18:
        Context r2 = this.b;
        return of.b(r2, of.b(r2, r3));
    L8:
        if (r3 == 2305843009213693952L) goto L18;
        if (r3 != 2) goto L14;
        return of.a(50001, of.b(this.b, r3));
    L14:
        if (r3 == Constants.SWAP_FEATURE_PROPERTY_SIZE_2G) goto L15;
        return of.a(this.b, r3);
    }

    private void c(UpdateInfo r7) {
        StringBuilder r0 = new StringBuilder().append(this.c);
        String r1 = File.separator;
        String r2 = r0.append(r1).append(r7.fileName).toString();
        pd r8 = (pd) r7.data1;
        if (r8 != null) goto L5;
        return;
    L5:
        int r3 = r8.l;
        if (r3 != 2) goto L28;
        String r6 = this.c + r1 + "zipTemp" + r1;
        File r4 = new File(r6);     // Catch: Exception -> L25
        if (r4.exists() == false) goto L11;
        a5.a(r4);     // Catch: Exception -> L25
    L11:
        pg.a(r2, r6);     // Catch: Exception -> L25
        File[] r9 = r4.listFiles();     // Catch: Exception -> L25
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.length != 0) goto L17;
        return;
    L17:
        if (r9.length == 1) goto L19;
        return;
    L19:
        File r5 = new File(r2);     // Catch: Exception -> L25
        if (r5.exists() == false) goto L22;
        r5.delete();     // Catch: Exception -> L25
    L22:
        a5.a(r9[0], r5);     // Catch: Exception -> L25
        a5.a(r4);     // Catch: Exception -> L25
    L33:
        if (r8.e == true) goto L35;
        c3.c(r8.b);
    L36:
        ua.a(ManagerCreatorC.getManager(p9.class));
        return;
    L35:
        c3.c(r8.f);
    L25:
        e = move-exception;
        q8.a("UpdateMgr", "unzip num mark file failed", e);
        return;
    L28:
        if (r3 != 1) goto L31;
        q8.b("UpdateMgr", "num mark file should not zip encrypt");
        return;
    L31:
        q8.c("UpdateMgr", "normal num mark file");
        goto L33
    }

    private void e(UpdateInfo r7) {
        StringBuilder r0 = new StringBuilder().append(this.c);
        String r1 = File.separator;
        String r2 = r0.append(r1).append(r7.fileName).toString();
        pd r8 = (pd) r7.data1;
        if (r8 != null) goto L5;
        return;
    L5:
        int r3 = r8.l;
        if (r3 != 2) goto L28;
        String r6 = this.c + r1 + "zipTemp" + r1;
        File r4 = new File(r6);     // Catch: Exception -> L25
        if (r4.exists() == false) goto L11;
        a5.a(r4);     // Catch: Exception -> L25
    L11:
        pg.a(r2, r6);     // Catch: Exception -> L25
        File[] r9 = r4.listFiles();     // Catch: Exception -> L25
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.length != 0) goto L17;
        return;
    L17:
        if (r9.length == 1) goto L19;
        return;
    L19:
        File r5 = new File(r2);     // Catch: Exception -> L25
        if (r5.exists() == false) goto L22;
        r5.delete();     // Catch: Exception -> L25
    L22:
        a5.a(r9[0], r5);     // Catch: Exception -> L25
        a5.a(r4);     // Catch: Exception -> L25
    L33:
        if (r8.e == true) goto L35;
        c3.c(r8.b);
    L36:
        YellowPages r10 = YellowPages.getInstance();
        if (r10 != null) goto L39;
        return;
    L39:
        if (r10.update(r2) == 0) goto L47;
        ua.a(ManagerCreatorC.getManager(p9.class));
        throw null;
    L47:
        return;
    L35:
        c3.c(r8.f);
    L25:
        e = move-exception;
        q8.a("UpdateMgr", "unzip num mark big file failed", e);
        return;
    L28:
        if (r3 != 1) goto L31;
        q8.b("UpdateMgr", "num mark big file should not zip encrypt");
        return;
    L31:
        q8.c("UpdateMgr", "normal num mark big file");
        goto L33
    }

    public void a(long r20, ICheckListener r22) {
        q8.a("UpdateMgr", "check-checkFlag:[" + r20 + "]");
        int r7 = 0;
        this.d.set(false);
        if (r22 == null) goto L5;
        q8.a("UpdateMgr", "[callback]onCheckStarted");
        r22.onCheckStarted();
    L5:
        long r2 = UpdateConfig.prepareCheckFlag(r20);
        ArrayList r8 = new ArrayList();
        if (ye.d().b() == true) goto L12;
        CheckResult r0 = new CheckResult();
        r0.mTitle = "Warning";
        r0.mMessage = "Expired! Please contact TMS(Tencent Mobile Secure) group.";
        r0.mUpdateInfoList = r8;
        if (r22 == null) goto L88;
        q8.a("UpdateMgr", "[callback]onCheckFinished--Licence Expired");
        r22.onCheckFinished(r0);
        return;
    L88:
        return;
    L12:
        if (this.d.get() == false) goto L17;
        if (r22 == null) goto L15;
        q8.a("UpdateMgr", "[callback]111onCheckCanceled");
        r22.onCheckCanceled();
    L15:
        a(0, r22);
        return;
    L17:
        ArrayList r1 = new ArrayList();
        long[] r9 = UpdateConfig.UPDATE_FLAGS;
        int r10 = r9.length;
        int r11 = 0;
    L18:
        if (r11 >= r10) goto L76;
        long r12 = r9[r11];
        if ((r12 & r2) == 0) goto L75;
        long r14 = UpdateConfig.UPDATA_FLAG_NUM_MARK;
        if (r12 != UpdateConfig.UPDATA_FLAG_NUM_MARK) goto L24;
    L23:
        r1.addAll(a(r14));
        goto L75
    L24:
        r14 = 2;
        if (r12 == 2) goto L23;
        r14 = 1152921504606846976L;
        if (r12 == 1152921504606846976L) goto L23;
        e2 r15 = b(r12);
        if (r15 != null) goto L33;
        q8.a("UpdateMgr", "confInfo == null");
        r15 = new e2();
        r15.f170a = UpdateConfig.getFileIdByFlag(r12);
        r15.b = new byte[r7];
        r15.c = r7;
    L35:
        if (r15.b != null) goto L38;
        r15.b = c3.a("");
    L38:
        if (r12 != 1073741824) goto L44;
        q8.a("UpdateMgr", "req::UpdateConfig.UPDATE_FLAG_VIRUS_BASE");
        StringBuilder r13 = new StringBuilder("req::fileId:[").append(r15.f170a).append("]timestamp:[").append(r15.c);
    L40:
        StringBuilder r16 = r13.append("]");
    L41:
        String r17 = r16.toString();
    L42:
        q8.a("UpdateMgr", r17);
    L74:
        r1.add(r15);
        goto L75
    L44:
        if (r12 != 2305843009213693952L) goto L47;
        q8.a("UpdateMgr", "req::UpdateConfig.UPDATE_FLAG_VIRUS_BASE_ENG");
        r13 = new StringBuilder("req::fileId:[").append(r15.f170a);
        goto L40
    L47:
        if (r12 != 4096) goto L50;
        r17 = "rule";
        goto L42
    L50:
        if (r12 != 8192) goto L53;
        r17 = "model";
        goto L42
    L53:
        if (r12 != 16384) goto L56;
        r17 = "dic";
        goto L42
    L56:
        if (r12 != UpdateConfig.UPDATE_FLAG_YELLOW_PAGE_OFFLINE_DATABASE) goto L59;
        r17 = "yellow page offline database";
        goto L42
    L59:
        if (r12 != UpdateConfig.UPDATE_FLAG_YELLOW_PAGE_OFFLINE_KEYWORDS) goto L62;
        r17 = "yellow page offline keywords";
        goto L42
    L62:
        if (r12 != 2048) goto L65;
        r17 = "replenish rule";
        goto L42
    L65:
        if (r12 != UpdateConfig.UPDATE_FLAG_VIRUS_WHITELIST) goto L69;
        StringBuilder r18 = new StringBuilder("hit why = ");
    L67:
        r16 = r18.append(r15.f170a);
        goto L41
    L69:
        if (r12 != UpdateConfig.UPDATE_FLAG_VIRUS_LANGUAGE_FILE) goto L72;
        r18 = new StringBuilder("hit language = ");
        goto L67
    L72:
        if (r12 != UpdateConfig.UPDATE_FLAG_SMS_CUSTOM_BLOCK_MODEL_V5) goto L74;
        r18 = new StringBuilder("hit v5 model = ");
        goto L67
    L33:
        q8.a("UpdateMgr", "confInfo != null");
    L75:
        r11 = r11 + 1;
        r7 = 0;
        goto L18
    L76:
        q8.e("UpdateMgr", "update confInfoList.size() = " + r1.size());
        x0 r19 = new x0();
        r19.f609a = r1;
        r19.b = 1;
        if (b3.c() == true) goto L79;
    L82:
        ic r110 = new ic();
        long r3 = System.currentTimeMillis();
        za r21 = ve.e();
        q8.a("UpdateMgr", "[Shark]Cmd_CSConfInfo, sendShark, guid:[" + r21.b() + "]");
        q8.a("UpdateMgr", "[UpdateManager] connect for  check update data");
        r21.a(108, r19, r110, 0, new C0091a(this, r3, r22, r8));
        return;
    L79:
        if (r19.c != null) goto L81;
        r19.c = new g8();
    L81:
        r19.c.b = h8.d().e();
        r19.c.f215a = h8.d().b();
        r19.c.c = h8.d().f();
        goto L82
    }

    public void addObserver(long r2, IUpdateObserver r4) {
        HashMap r0 = this.e;
        monitor-enter(r0);
        if (r4 != null) goto L11;
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        this.e.put(Long.valueOf(r2), new SoftReference(r4));     // Catch: Throwable -> L8
        goto L6
    }

    public void cancel() {
        this.d.set(true);
    }

    public void d(UpdateInfo r7) {
        HashMap r0 = this.e;
        monitor-enter(r0);
        Iterator r6 = this.e.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r6.next();     // Catch: Throwable -> L14
        if ((((Long) r1.getKey()).longValue() & r7.flag) == 0) goto L6;
        IUpdateObserver r2 = (IUpdateObserver) ((SoftReference) r1.getValue()).get();     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        r2.onChanged(r7);     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public String getFileSavePath() {
        return this.c;
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 1;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r1) {
        this.b = r1;
        this.c = r1.getFilesDir().getAbsolutePath();
        this.f = tmsdk.common.module.update.b.a();
    }

    public void removeObserver(long r2) {
        HashMap r0 = this.e;
        monitor-enter(r0);
        this.e.remove(Long.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean update(List r27, IUpdateListener r28) {
        List r2 = r27;
        q8.a("UpdateMgr", "update-updateInfoList:[" + r2 + "]updateListener:[" + r28 + "]");
        boolean r7 = false;
        this.d.set(false);
        if (r28 == null) goto L6;
        q8.a("UpdateMgr", "[callback]onUpdateStarted");
        r28.onUpdateStarted();
    L6:
        if (ye.d().b() == true) goto L10;
        if (r28 == null) goto L9;
        q8.a("UpdateMgr", "[callback]00onUpdateFinished");
        r28.onUpdateFinished();
    L9:
        return false;
    L10:
        String r8 = "[callback]onUpdateCanceled";
        if (this.d.get() == false) goto L15;
        if (r28 == null) goto L14;
        q8.a("UpdateMgr", "[callback]onUpdateCanceled");
        r28.onUpdateCanceled();
        q8.a("UpdateMgr", "[callback]11onUpdateFinished");
        r28.onUpdateFinished();
    L14:
        return false;
    L15:
        AtomicBoolean r9 = new AtomicBoolean(false);
        q8.a("UpdateMgr", "updateInfoList size: " + r27.size());
        int r10 = 1;
        int r11 = 0;
        boolean r12 = true;
    L17:
        if (r11 >= r27.size()) goto L156;
        r9.set(r7);
        UpdateInfo r13 = (UpdateInfo) r2.get(r11);
        if (r13 != null) goto L21;
        r11 = r11;
        String r25 = r8;
        boolean r14 = r7;
        int r15 = r10;
        String r16 = r25;
    L154:
        r11 = r11 + 1;
        r2 = r27;
        String r26 = r16;
        r10 = r15;
        r7 = r14;
        r8 = r26;
        goto L17
    L21:
        q8.a("UpdateMgr", "[" + r11 + "]updateInfo fileName:[" + r13.fileName + "]url:[" + r13.url + "]");
        if (r27.size() != r10) goto L25;
        if (r28 == null) goto L28;
        q8.a("UpdateMgr", "[callback]onProgressChanged:[" + r11 + "]");
        int r0 = 50;
    L27:
        r28.onProgressChanged(r13, r0);
    L28:
        long r17 = r13.flag;
        if (r17 == 1073741824) goto L117;
        if (r17 == 2305843009213693952L) goto L117;
        if (r17 != Constants.SWAP_FEATURE_PROPERTY_SIZE_2G) goto L37;
    L115:
        r8 = r8;
        r11 = r11;
        r12 = r12;
    L123:
        r12 = r12;
    L125:
        if (r9.get() == true) goto L148;
        d(r13);
        r15 = 1;
        r13.success = 1;
        int r1 = UpdateConfig.getLargeMarkFileId();
        int r18 = r13.mFileID;
        if (r1 != r18) goto L129;
        e2 r3 = b(UpdateConfig.getLargeMarkFileId());
    L145:
        if (r3 == null) goto L147;
        r13.checkSum = c3.a(r3.b);
        r13.timestamp = r3.c;
    L147:
        r14 = false;
    L149:
        this.f.a(r13);
        if (this.d.get() == true) goto L151;
        r16 = r8;
        goto L154
    L151:
        if (r28 == null) goto L156;
        q8.a("UpdateMgr", r8);
        r28.onUpdateCanceled();
        goto L156
    L129:
        int r19 = 40458;
        if (40458 != r18) goto L132;
    L131:
        r3 = b(r19);
        goto L145
    L132:
        r19 = 40800;
        if (40800 == r18) goto L131;
        int r110 = 40461;
        if (40461 != r18) goto L138;
    L137:
        r3 = of.c(r110, of.a(this.b, r110, ".sdb"));
        goto L145
    L138:
        r110 = 40801;
        if (40801 == r18) goto L137;
        if (50001 != r18) goto L144;
        r3 = of.a(50001, of.a(this.b, 50001, ".sdb"));
        goto L145
    L144:
        r3 = b(r13.flag);
        goto L145
    L148:
        r15 = 1;
        r14 = false;
        r13.success = 0;
        goto L149
    L37:
        if (r13.url == null) goto L115;
        b6 r111 = new b6(this.b);
        r111.b(this.c + LibrarianImpl.Constants.SEPARATOR);
        r111.a(r13.fileName);
        r111.a(new b(this, r28, r13, r9));
        r8 = r8;
        long r20 = r13.flag;
        if (r20 != UpdateConfig.UPDATA_FLAG_NUM_MARK) goto L43;
        b6.a r4 = new c(this, r13);
    L41:
        r11 = r11;
        r12 = r12;
    L73:
        q8.a("UpdateMgr", "before invoke httpGetFile.doGetFile()");
    L74:
        int r21 = r111.a(null, r13.url, false, r4);
        if (r21 == (-7)) goto L74;
        if (r9.get() == true) goto L84;
        if (r13.flag != 2) goto L84;
        if (r21 != 0) goto L84;
        a(r13);
    L84:
        if (r9.get() == true) goto L90;
        if (40458 != r13.mFileID) goto L90;
        if (r21 != 0) goto L90;
        c(r13);
    L90:
        if (r9.get() == true) goto L96;
        if (UpdateConfig.getLargeMarkFileId() != r13.mFileID) goto L96;
        if (r21 != 0) goto L96;
        b(r13);
    L96:
        if (r9.get() == true) goto L102;
        if (40800 != r13.mFileID) goto L102;
        if (r21 != 0) goto L102;
        c(r13);
    L102:
        if (r9.get() == true) goto L108;
        if (40461 != r13.mFileID) goto L108;
        if (r21 != 0) goto L108;
        e(r13);
    L108:
        if (r9.get() == false) goto L110;
    L113:
        if (r21 == 0) goto L123;
        r13.errorCode = r21;
    L122:
        r12 = false;
        goto L125
    L110:
        if (40801 != r13.mFileID) goto L113;
        if (r21 != 0) goto L113;
        e(r13);
        goto L113
    L43:
        if (r20 != 1152921504606846976L) goto L46;
        r4 = new d(this, r13);
        goto L41
    L46:
        if (r20 == UpdateConfig.UPDATE_FLAG_VIRUS_WHITELIST) goto L165;
    L71:
        r11 = r11;
        r12 = r12;
    L72:
        r4 = null;
        goto L73
    L165:
        Object r5 = r13.data1;     // Catch: Throwable -> L68
        if ((r5 instanceof pd) == false) goto L71;
        pd r6 = (pd) r5;     // Catch: Throwable -> L68
        String r22 = "";
        if (r6.b != null) goto L159;
        r12 = r12;
    L61:
        r11 = r11;
        f.a(1320112, r6.c + ";" + System.currentTimeMillis() + ";" + r22);     // Catch: Throwable -> L64
    L64:
        th = th;
    L70:
        q8.b("UpdateMgr", th);
        goto L72
    L159:
        StringBuilder r23 = new StringBuilder();     // Catch: Throwable -> L57
        byte[] r24 = r6.b;     // Catch: Throwable -> L57
        int r112 = r24.length;     // Catch: Throwable -> L57
        int r29 = 0;
    L52:
        if (r29 >= r112) goto L56;
        byte[] r210 = r24;
        int r211 = r112;
        r12 = r12;
        r23.append(String.format("%02X", new Object[]{Byte.valueOf(r24[r29])}));     // Catch: Throwable -> L66
        r29 = r29 + 1;     // Catch: Throwable -> L66
        r24 = r210;
        r112 = r211;
        r12 = r12;
    L66:
        th = th;
    L67:
        r11 = r11;
        goto L70
    L56:
        r12 = r12;
        r22 = r23.toString();     // Catch: Throwable -> L66
    L57:
        th = th;
        r12 = r12;
    L68:
        th = th;
        r11 = r11;
        r12 = r12;
    L117:
        int r30 = c(r10);
        r13.downType = 2;
        if (r30 == 0) goto L123;
        r9.set(r10);
        r13.errorCode = r30;
        if (r28 == null) goto L122;
        q8.a("UpdateMgr", "[callback]onUpdateEvent:[" + r30 + "]");
        r28.onUpdateEvent(r13, r30);
        goto L122
    L25:
        if (r28 == null) goto L28;
        q8.a("UpdateMgr", "[callback]onProgressChanged:[" + r11 + "]");
        r0 = (r11 * 100) / r27.size();
    L156:
        if (r28 == null) goto L158;
        q8.a("UpdateMgr", "[callback]onUpdateFinished");
        r28.onUpdateFinished();
        this.f.b();
    L158:
        return r12;
    }

    private void a(int r3, ICheckListener r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == 0) goto L7;
        q8.a("UpdateMgr", "[callback]onCheckEvent:[" + r3 + "]");
        r4.onCheckEvent(r3);
    L7:
        q8.a("UpdateMgr", "[callback]onCheckFinished--null");
        r4.onCheckFinished(null);
    }

    private e2 b(int r2) {
        e2 r1 = of.b(r2, of.a(this.b, r2, ".sdb"));
        if (r1 != null) goto L6;
        r1 = new e2();
        r1.f170a = r2;
        r1.b = new byte[0];
        r1.c = 0;
    L6:
        if (r1.b != null) goto L8;
        r1.b = c3.a("");
    L8:
        q8.c(NumMarker.Tag, "fileId:" + r1.f170a + " timestamp:" + r1.c + " pfutimestamp:" + r1.d + " version:" + r1.f);
        return r1;
    }

    private int c(int r21) {
        AtomicReference r10 = new AtomicReference(0);
        Context r2 = this.b;
        yf r3 = of.c(r2, of.b(r2, 1073741824));
        if (r3 == null) goto L23;
        r3.c = 3;
        r3.d = r21;
        if (b3.c() == true) goto L7;
    L10:
        h1 r13 = new h1();
        r13.f235a = r3;
        long r4 = System.currentTimeMillis();
        Object r19 = new Object();
        za r11 = ve.e();
        q8.a("UpdateMgr", "[Shark]Cmd_CSUpdateVirusInfos, sendShark, guid:[" + r11.b() + "]");
        r11.a(2006, r13, new qc(), 0, new e(this, r4, System.currentTimeMillis(), r10, r19), 180000);
        monitor-enter(r19);
        r19.wait();     // Catch: Throwable -> L14 Exception -> L16
    L19:
        monitor-exit(r19);     // Catch: Throwable -> L14
    L25:
        return ((Integer) r10.get()).intValue();
    L16:
        e = move-exception;
        q8.c("UpdateMgr", "SCAN_LOCK.wait(): " + e, e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r3.e != null) goto L9;
        r3.e = new g8();
    L9:
        r3.e.b = h8.d().e();
        r3.e.f215a = h8.d().b();
        r3.e.c = h8.d().f();
        goto L10
    L23:
        q8.e("UpdateMgr", "getVirusClientInfo return null!");
        r10.set(-2);
        goto L25
    }

    private List a(long r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != UpdateConfig.UPDATA_FLAG_NUM_MARK) goto L7;
        r0.add(b(40458));
        e2 r5 = b(UpdateConfig.getLargeMarkFileId());
    L5:
        r0.add(r5);
    L15:
        return r0;
    L7:
        if (r6 != 2) goto L9;
        r5 = of.a(50001, of.a(this.b, 50001, ".sdb"));
        goto L5
    L9:
        Context r7 = this.b;
        if (r6 != 1152921504606846976L) goto L14;
        r5 = of.c(40461, of.a(r7, 40461, ".sdb"));
        if (r5 == null) goto L15;
        q8.c("gjj", "fileId:" + r5.f170a + " timestamp:" + r5.c + " pfutimestamp:" + r5.d + " version:" + r5.f);
        goto L5
    L14:
        r5 = of.a(r7, r6);
        goto L5
    }

    private boolean b(String r3, String r4) {
        q8.c("UpdateMgr", "isYellowPageMd5Match() filePath:" + r3 + " md5FromUpdateInfo:" + r4);
        return a(of.c(40461, r3), r4);
    }

    private boolean a(e2 r4, String r5) {
        if (r4 != null) goto L6;
        q8.c("UpdateMgr", "isMd5Match() confInfoFromFile is null");
        return false;
    L6:
        byte[] r6 = r4.b;
        if (r6 != null) goto L9;
    L23:
        q8.c("UpdateMgr", "isMd5Match() confInfoFromFile.md5Bin is empty");
        return false;
    L9:
        if (r6.length == 0) goto L23;
        String r7 = c3.a(r6);
        if (r5 == null) goto L21;
        if (r7 == null) goto L21;
        q8.c("UpdateMgr", "isMd5Match() md5FromUpdateInfo:" + r5.toLowerCase() + " md5FromFileHeader:" + r7.toLowerCase());
        if (r5.toLowerCase().equals(r7.toLowerCase()) == true) goto L19;
        q8.c("UpdateMgr", "isMd5Match() md5FromUpdateInfo and md5FromFileHeader is not match");
        return false;
    L19:
        q8.c("UpdateMgr", "isMd5Match() = true");
        return true;
    L21:
        q8.c("UpdateMgr", "isMd5Match() md5FromUpdateInfo or md5FromFileHeader is null");
        return false;
    }

    private void b(UpdateInfo r7) {
        StringBuilder r0 = new StringBuilder().append(this.c);
        String r1 = File.separator;
        String r2 = r0.append(r1).append(r7.fileName).toString();
        pd r8 = (pd) r7.data1;
        if (r8 != null) goto L5;
        return;
    L5:
        int r3 = r8.l;
        if (r3 != 2) goto L28;
        String r6 = this.c + r1 + "zipTemp" + r1;
        File r4 = new File(r6);     // Catch: Exception -> L25
        if (r4.exists() == false) goto L11;
        a5.a(r4);     // Catch: Exception -> L25
    L11:
        pg.a(r2, r6);     // Catch: Exception -> L25
        File[] r9 = r4.listFiles();     // Catch: Exception -> L25
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.length != 0) goto L17;
        return;
    L17:
        if (r9.length == 1) goto L19;
        return;
    L19:
        File r5 = new File(r2);     // Catch: Exception -> L25
        if (r5.exists() == false) goto L22;
        r5.delete();     // Catch: Exception -> L25
    L22:
        a5.a(r9[0], r5);     // Catch: Exception -> L25
        a5.a(r4);     // Catch: Exception -> L25
    L33:
        if (r8.e == true) goto L35;
        c3.c(r8.b);
    L36:
        ua.a(ManagerCreatorC.getManager(p9.class));
        return;
    L35:
        c3.c(r8.f);
    L25:
        e = move-exception;
        q8.a("UpdateMgr", "unzip num mark big file failed", e);
        return;
    L28:
        if (r3 != 1) goto L31;
        q8.b("UpdateMgr", "num mark big file should not zip encrypt");
        return;
    L31:
        q8.c("UpdateMgr", "normal num mark big file");
        goto L33
    }

    private boolean a(String r1, String r2) {
        ua.a(ManagerCreatorC.getManager(p9.class));
        throw null;
    }

    private void a(UpdateInfo r4) {
        TelNumberLocator r0 = TelNumberLocator.getDefault(this.b);
        pd r1 = (pd) r4.data1;
        if (r1.e == false) goto L5;
        r0.patchLocation(this.c + File.separator + r4.fileName, c3.a(r1.b));
    L5:
        r0.reload();
    }
}
