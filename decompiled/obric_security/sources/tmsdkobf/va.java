package tmsdkobf;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tmsdk.common.CallerIdent;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class va {
    private static int[] p;
    private static Object q;
    private static va r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sa f572a;
    private HashMap b;
    private Set c;
    private j5 d;
    private j5 e;
    private NetworkInfo.State f;
    private NetworkInfo.State g;
    private te.a h;
    private a7 i;
    private ConcurrentHashMap j;
    private SparseIntArray k;
    private Handler l;
    private HandlerThread m;
    private Handler.Callback n;
    private HashSet o;

    class a implements te.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f573a;

        a(va r1) {
            this.f573a = r1;
        }
    }

    class b implements a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f574a;

        b(va r1) {
            this.f574a = r1;
        }

        @Override // tmsdkobf.a7
        public Cif a(int r4, long r5, int r7, JceStruct r8) {
            if (r7 == 11052) goto L6;
            r8.b("ProfileUpload", "cmdId != ECmd.Cmd_SCProfilePushCmd : " + r7);
            return null;
        L6:
            r8.d("ProfileUpload", "recv profile full upload push");
            mc r9 = (mc) r8;
            if (r9 != null) goto L10;
            r8.d("ProfileUpload", "profilePush == null");
            return null;
        L10:
            r8.d("ProfileUpload", "profilePush.profileID : " + r9.f350a + " profilePush.profileCmd : " + r9.b);
            int r6 = r9.b;
            if (r6 == 1) goto L17;
            if (r6 == 2) goto L15;
        L20:
            return null;
        L15:
            if (r9.f350a != 2) goto L20;
            va.m2454$$Nest$fgeta(this.f574a).a(false);
            goto L20
        L17:
            va.m2458$$Nest$ma(this.f574a, r9.f350a, 0);
            if (r9.f350a != 2) goto L20;
            va.m2454$$Nest$fgeta(this.f574a).a(true);
            ra.a().a(r9.f350a);
            goto L20
        }
    }

    class c implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f575a;

        c(va r1) {
            this.f575a = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r4) {
            switch(r4.what) {
                case 1: goto L23;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L24;
            };
        L5:
            va.m2455$$Nest$fgetc(this.f575a).clear();
            goto L24
        L6:
            xd r5 = (xd) r4.obj;
            va.m2461$$Nest$ma(this.f575a, r5);
            goto L24
        L7:
            va.m2462$$Nest$mb(this.f575a);
            goto L24
        L8:
            ua.a(r4.obj);
            va.m2459$$Nest$ma(this.f575a, null);
            goto L24
        L9:
            qa.a r6 = (qa.a) r4.obj;
            va.m2464$$Nest$mc(this.f575a, r6);
            goto L24
        L10:
            xa r7 = (xa) r4.obj;
            va.m2460$$Nest$ma(this.f575a, r7);
            goto L24
        L11:
            int r3 = r4.arg1;
            new Bundle().putInt("profile.id", r3);
            goto L24
        L12:
            int r8 = r4.arg1;
            va.m2456$$Nest$fgetk(this.f575a).delete(r8);
            goto L24
        L13:
            int r9 = r4.arg1;
            ArrayList r0 = this.f575a.b(r9);
            if (r0 != null) goto L16;
        L21:
            ta.a("ProfileUpload", "get full upload jce");
            return true;
        L16:
            if (r0.size() <= 0) goto L21;
            byte[] r1 = ta.a(ta.a(r9, 0, r0));
            if (r1 == null) goto L24;
            va.m2456$$Nest$fgetk(this.f575a).put(r9, r1.length);
            goto L24
        L23:
            int r10 = r4.arg1;
            va.m2463$$Nest$mc(this.f575a, r10);
        L24:
            return true;
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q6.c f576a;
        public wa b;

        public d(q6.c r1, wa r2) {
            this.f576a = r1;
            this.b = r2;
        }
    }

    class e implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        qa.a f577a;
        final /* synthetic */ va b;

        public e(va r1, qa.a r2) {
            this.b = r1;
            this.f577a = r2;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r9, int r10, int r11, int r12, JceStruct r13) {
            xd r7 = new xd(r9, r10, r11, r12, r13, this.f577a);
            Message.obtain(va.m2457$$Nest$fgetl(this.b), 9, r7).sendToTarget();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgeta, reason: not valid java name */
    static /* bridge */ /* synthetic */ sa m2454$$Nest$fgeta(va r0) {
        return r0.f572a;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2455$$Nest$fgetc(va r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetk, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m2456$$Nest$fgetk(va r0) {
        return r0.k;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetl, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2457$$Nest$fgetl(va r0) {
        return r0.l;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2458$$Nest$ma(va r0, int r1, long r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2459$$Nest$ma(va r0, c5 r1) {
        r0.a(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2460$$Nest$ma(va r0, xa r1) {
        r0.a(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2461$$Nest$ma(va r0, xd r1) {
        r0.a(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2462$$Nest$mb(va r0) {
        r0.b();
    }

    /* JADX INFO: renamed from: -$$Nest$mc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2463$$Nest$mc(va r0, int r1) {
        r0.c(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2464$$Nest$mc(va r0, qa.a r1) {
        r0.c(r1);
    }

    static {
        q = new Object();
    }

    private va() {
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new j5("profile4", 43200000, 24);
        this.e = new j5("profile2", 43200000, 3);
        NetworkInfo.State r0 = NetworkInfo.State.UNKNOWN;
        this.f = r0;
        this.g = r0;
        this.h = new a(this);
        this.i = new b(this);
        this.j = new ConcurrentHashMap();
        this.k = new SparseIntArray();
        this.n = new c(this);
        this.o = new HashSet();
        this.f572a = sa.b();
        HandlerThread r1 = ((bf) qd.a(4)).b("profile upload task queue");
        this.m = r1;
        r1.start();
        this.l = new Handler(this.m.getLooper(), this.n);
        ve.e().a(11052, new mc(), 0, this.i);
        NetworkInfo r2 = ((ConnectivityManager) TMSDKContext.getApplicaionContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L5
    L6:
        if (r2 == null) goto L8;
        NetworkInfo.State r3 = r2.getState();
    L9:
        this.f = r3;
        this.g = r3;
        a(30000);
        p = new int[6];
        int r5 = 1;
    L11:
        if (r5 >= 5) goto L13;
        p[r5] = 0;
        r5 = r5 + 1;
        goto L11
    L13:
        return;
    L8:
        r3 = NetworkInfo.State.DISCONNECTED;
    L5:
        r2 = null;
        goto L6
    }

    private void a(c5 r1) {
    }

    private void c(qa.a r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        qa r0 = qa.b();
        int r1 = r7.b;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L19;
        r0.b(r7.c);
        StringBuilder r6 = new StringBuilder("popFirst success! taskID : ");
    L10:
        ta.a("ProfileUpload", r6.append(r7.c).toString());
        return;
    L19:
        return;
    L12:
        if (r7.a() != null) goto L14;
        return;
    L14:
        int r2 = r7.a().f193a;
        ta.a("ProfileUpload", "+++onSharkSuccess");
        p[r2] = 0;
        byte[] r3 = r0.b(r7.c);
        sa r8 = this.f572a;
        if (r3 == null) goto L17;
        r8.a(r2, r3.length);
        r6 = new StringBuilder("popFirst success! taskID : ");
        goto L10
    L17:
        int r9 = r8.e(r2);
        r6 = new StringBuilder("popFirst fail! queueQuantity : ").append(r9).append(" taskID : ");
        goto L10
    }

    public ArrayList b(int r1) {
        d r0 = (d) this.j.get(Integer.valueOf(r1));
        if (r0 == null) goto L9;
        q6.c r2 = r0.f576a;
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.a();
    L9:
        return null;
    }

    private j5 a(int r2) {
        if (r2 == 2) goto L11;
        if (r2 == 4) goto L9;
        return null;
    L9:
        return this.d;
    L11:
        return this.e;
    }

    private void b(qa.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ta.a("ProfileUpload", "---onSharkFail");
        int[] r0 = p;
        int r2 = r6.d;
        int r3 = r0[r2] + 1;
        r0[r2] = r3;
        if (r3 <= 1) goto L8;
        r0[r2] = 0;
        ta.a("ProfileUpload", "err more than 1,wait next upload task");
        return;
    L8:
        ta.a("ProfileUpload", "resend");
        a(p[r6.d] * ActivityLifecycleObserver.BACKGROUND_DELAY_SECOND);
    }

    private void c(int r9) {
        d r0 = (d) this.j.get(Integer.valueOf(r9));
        if (r0 == null) goto L13;
        q6.c r1 = r0.f576a;
        if (r1 == null) goto L13;
        ArrayList r7 = r1.a();
        if (r7 != null) goto L11;
        ta.a("ProfileUpload", "get full upload profile null,can't full upload");
        return;
    L11:
        a(CallerIdent.getIdent(1, 4294967296L), r9, 0, r7);
        return;
    L13:
        ta.a("ProfileUpload", "profileID " + r9 + " callback null,can't full upload");
    }

    public static va a() {
        if (r != null) goto L15;
        Object r0 = q;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (r != null) goto L9;
        r = new va();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return r;
    }

    private void b() {
        ta.a("ProfileUpload", "uploadTask");
        List r0 = qa.b().a();
        if (r0 != null) goto L5;
    L45:
        String r14 = "uploadTask no more task";
    L16:
        r8.e("ProfileUpload", r14);
        return;
    L5:
        if (r0.size() == 0) goto L45;
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        if (this.c.contains(Integer.valueOf(((qa.a) r2.next()).c)) == false) goto L9;
        r2.remove();
        goto L9
    L14:
        if (r0.size() != 0) goto L18;
        r14 = "all task is uploading";
        goto L16
    L18:
        Iterator r3 = r0.iterator();
        boolean r4 = false;
    L20:
        if (r3.hasNext() == false) goto L32;
        qa.a r5 = (qa.a) r3.next();
        if (r5 == null) goto L20;
        if (r5.a() == null) goto L20;
        int r6 = r5.a().f193a;
        if (r5.a().e == 0) goto L20;
        int r7 = this.k.get(r6);
        int r8 = this.f572a.e(r6);
        if (r8 <= r7) goto L20;
        if (r7 <= 0) goto L20;
        ta.a("ProfileUpload", "queue more than full,then full upload. queue : " + r8 + " quantity : " + r7);
        a(r6, 0);
        r4 = true;
        goto L20
    L32:
        if (r4 == false) goto L34;
        return;
    L34:
        Iterator r1 = r0.iterator();
    L36:
        if (r1.hasNext() == false) goto L44;
        qa.a r9 = (qa.a) r1.next();
        if (r9.a() != null) goto L39;
        if (r9.b == 1) goto L42;
        ta.a("ProfileUpload", "ProfileQueueTask neither force push nor upload profile");
        goto L36
    L42:
        ua.a(this.b.remove(Integer.valueOf(r9.c)));
        c(r9);
        goto L36
    L39:
        this.c.add(Integer.valueOf(r9.c));
        f1 r10 = r9.a();
        ta.a("ProfileUpload", "send : profileID " + r10.f193a + " actionID " + r10.e + " lastVerifyKey " + r10.b + " presentVerifyKey " + r10.c + " taskID " + r9.c);
        ve.e().a(1051, r10, new oc(), 16, new e(this, r9), 90000);
        goto L36
    }

    private void a(qa.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ta.a("ProfileUpload", "---onSharkFail");
        int[] r0 = p;
        int r2 = r6.d;
        int r3 = r0[r2] + 1;
        r0[r2] = r3;
        if (r3 <= 2) goto L19;
        r0[r2] = 0;
        if (r2 > 0) goto L9;
        return;
    L9:
        if (r2 >= 5) goto L22;
        j5 r1 = a(r2);
        if (r1 != null) goto L14;
        a(r6.d, 0);
        return;
    L14:
        if (r1.a() == false) goto L16;
        r1.b();
        a(r6.d, 0);
        String r5 = "err more than 2,full upload";
    L17:
        ta.a("ProfileUpload", r5);
        return;
    L16:
        r5 = "err more than 2,full upload,freq ctrl,ignore this";
        goto L17
    L22:
        return;
    L19:
        ta.a("ProfileUpload", "resend");
        a(p[r6.d] * ActivityLifecycleObserver.BACKGROUND_DELAY_SECOND);
    }

    private void a(xd r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        qa.a r0 = r10.f;
        int r1 = r10.d;
        int r2 = r10.c;
        if (r0 != null) goto L7;
        return;
    L7:
        ArrayList r3 = new ArrayList();
        f1 r4 = r0.a();
        if (r4 == null) goto L17;
        ArrayList r5 = r4.d;
        if (r5 == null) goto L17;
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        byte[] r7 = (byte[]) r6.next();
        if (r4.f193a != 4) goto L13;
        r3.add(z7.a(r7, new b8(), false));
    L17:
        r8.a("TrafficCorrection", "ProfileUpload-retCode:[" + r2 + "]dataRetCode[" + r1 + "]");
        HashSet r8 = this.o;
        monitor-enter(r8);
        HashSet r9 = new HashSet(this.o);     // Catch: Throwable -> L46
        monitor-exit(r8);     // Catch: Throwable -> L46
        Iterator r11 = r9.iterator();
        if (r11.hasNext() == true) goto L44;
        this.c.remove(Integer.valueOf(r0.c));
        if (r0.a() == null) goto L26;
        StringBuilder r12 = new StringBuilder("recv profile resp retCode : ").append(r2).append(" dataRetCode : ").append(r1).append(" profileID : ").append(r0.a().f193a).append(" actionID : ").append(r0.a().e).append(" lastVerifyKey ").append(r0.a().b).append(" presentVerifyKey ").append(r0.a().c).append(" taskID ").append(r0.c);
    L27:
        ta.a("ProfileUpload", r12.toString());
        if (r2 == 0) goto L30;
        if (r2 <= 0) goto L59;
        b(r0);
        return;
    L59:
        return;
    L30:
        if (r1 == (-1)) goto L40;
        if (r1 != 0) goto L60;
        JceStruct r13 = r10.e;
        if (r13 == null) goto L39;
        oc r14 = (oc) r13;
        if (r14.b != 0) goto L38;
        c(r0);
    L38:
        ta.a("ProfileUpload", "recv profile resp SCReportProfile retcode : " + r14.b);
        return;
    L39:
        c(r0);
        ta.a("ProfileUpload", "null == sharkOnFinish.resp");
        return;
    L60:
        return;
    L40:
        a(r0);
        return;
    L26:
        r12 = new StringBuilder("recv profile resp retCode : ").append(r2).append(" dataRetCode : ").append(r1);
        goto L27
    L44:
        ua.a(r11.next());
        throw null;
    L46:
        th = move-exception;
        throw th;
    }

    private void a(xa r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        f1 r0 = ta.a(r13.f617a, r13.b, r13.c);
        ta.a("ProfileUpload", "profileEnqueue");
        int r1 = r0.f193a;
        int r3 = r0.e;
        qa r4 = qa.b();
        int r6 = 0;
        if (this.f572a.a(r0) == false) goto L8;
        if (r3 == 0) goto L8;
        ta.a("ProfileUpload", "ingnore this, the same as the last upload task");
        int r2 = -1;
    L24:
        int r7 = 0;
        r6 = r2;
    L25:
        d r5 = (d) this.j.get(Integer.valueOf(r1));
        if (r5 == null) goto L30;
        wa r8 = r5.b;
        if (r8 == null) goto L30;
        r8.a(r13.b, r13.c, r6, r7);
    L30:
        b();
        return;
    L8:
        byte[] r9 = ta.a(r0);
        if (r9 != null) goto L11;
    L23:
        r2 = -2;
        goto L24
    L11:
        if (r9.length == 0) goto L23;
        r7 = r9.length;
        if (r3 != 0) goto L16;
        r4.a(r1);
        this.f572a.a(r1);
    L16:
        long r10 = r4.a(r9, r1);
        ta.a("ProfileUpload", "profileEnqueue taskID : " + r10);
        if (r10 >= 0) goto L19;
        ta.a("ProfileUpload", "pushLast fail!!!");
        r6 = -3;
        goto L25
    L19:
        this.f572a.b(r1, r9.length);
        if (r3 != 0) goto L22;
        this.k.put(r1, r9.length);
    L22:
        this.f572a.c(r0);
        goto L25
    }

    public boolean a(long r3, int r5, int r6, ArrayList r7) {
        if (r5 > 0) goto L5;
    L12:
        return false;
    L5:
        if (r5 >= 5) goto L12;
        if (this.j.get(Integer.valueOf(r5)) != null) goto L10;
        return false;
    L10:
        ta.a("ProfileUpload", "profileUpload  profileID : " + r5 + " profileActionID : " + r6);
        Message.obtain(this.l, 5, new xa(r5, r6, r7, null)).sendToTarget();
        return true;
    }

    public void a(long r1, int r3, q6.c r4, wa r5, int r6) {
        d r2 = new d(r4, r5);
        if (((d) this.j.put(Integer.valueOf(r3), r2)) != null) goto L6;
        this.k.put(r3, r6);
        return;
    }

    private void a(int r2, long r3) {
        r8.a("ProfileUpload", "sendUploadFullProfileMsgToHandler");
        Message r4 = Message.obtain(this.l, 1, r2, 0);
        this.l.removeMessages(1);
        this.l.sendMessageDelayed(r4, 5000);
    }

    private void a(long r3) {
        if (this.g.compareTo(NetworkInfo.State.CONNECTED) != 0) goto L5;
        this.l.removeMessages(8);
        this.l.sendEmptyMessageDelayed(8, r3);
        return;
    L5:
        ta.a("ProfileUpload", "no network");
    }
}
