package tmsdk.common.module.update;

import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Hashtable;
import tmsdkobf.a3;
import tmsdkobf.q8;
import tmsdkobf.ve;
import tmsdkobf.w6;
import tmsdkobf.y0;

/* JADX INFO: loaded from: classes5.dex */
class b {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Hashtable f64a;

    class a implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f65a;

        a(b r1) {
            this.f65a = r1;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r2, int r3, int r4, int r5, JceStruct r6) {
            q8.c("update_report", "onFinish() seqNo: " + r2 + " cmdId: " + r3 + " retCode: " + r4 + " dataRetCode: " + r5);
            if (r6 != null) goto L6;
            q8.c("update_report", "onFinish() null");
            return;
        }
    }

    private b() {
        this.f64a = new Hashtable();
    }

    public static synchronized b a() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (b != null) goto L7;
        b = new b();     // Catch: Throwable -> L10
    L7:
        b r1 = b;     // Catch: Throwable -> L10
        monitor-exit(b.class);
        return r1;
    }

    public void b() {
        q8.a("update_report", "report, size: " + this.f64a.size());
        if (this.f64a.size() != 0) goto L5;
        return;
    L5:
        y0 r4 = new y0();
        r4.f628a = new ArrayList(this.f64a.values());
        this.f64a.clear();
        q8.a("update_report", "before send shark");
        ve.e().a(109, r4, null, 0, new a(this));
    }

    public void a(UpdateInfo r4) {
        a3 r0 = new a3();
        int r1 = UpdateConfig.getFileIdByFileName(r4.fileName);
        r0.f85a = r1;
        String r2 = r4.url;
        if (r2 == null) goto L5;
        r0.d = r2;
    L5:
        r0.b = r4.checkSum;
        r0.c = r4.timestamp;
        r0.e = r4.success;
        r0.f = r4.downSize;
        r0.i = r4.downType;
        r0.j = r4.errorCode;
        r0.k = r4.downnetType;
        r0.l = r4.downNetName;
        r0.o = r4.errorMsg;
        r0.p = r4.rssi;
        r0.q = r4.sdcardStatus;
        r0.r = r4.fileSize;
        this.f64a.put(Integer.valueOf(r1), r0);
        q8.c("update_report", "configReport info: fileId=" + r0.f85a + " url=" + r0.d + " checkSum=" + r0.b + " timestamp=" + r0.c + " success=" + r0.e + " downSize=" + r0.f + " downType=" + r0.i + " errorCode=" + r0.j + " downnetType=" + r0.k + " downNetName=" + r0.l + " errorMsg=" + r0.o + " rssi=" + r0.p + " sdcardStatus=" + r0.q + " fileSize=" + r0.r);
    }
}
