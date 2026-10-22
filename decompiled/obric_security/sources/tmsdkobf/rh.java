package tmsdkobf;

import android.os.PowerManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private il f483a;
    private SparseIntArray b;
    private z6 c;
    private PowerManager d;
    private SparseIntArray e;

    class a implements dl.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rh f484a;

        a(rh r1) {
            this.f484a = r1;
        }

        @Override // tmsdkobf.dl.g
        public void a() {
            il r0 = rh.a(this.f484a);
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (rh.a(this.f484a).b() > 0) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L8:
            Iterator r3 = rh.a(this.f484a).a().entrySet().iterator();     // Catch: Throwable -> L14
        L10:
            if (r3.hasNext() == false) goto L12;
            ((b) ((Map.Entry) r3.next()).getValue()).d = true;     // Catch: Throwable -> L14
            goto L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L14
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BitSet f485a;
        public int b;
        public String c;
        public boolean d;
        public int e;
        public int f;
        public int g;
        public long h;
        public String i;
        public String j;
        public boolean k;

        private b() {
            this.f485a = new BitSet();
            this.b = 0;
            this.c = "";
            this.d = false;
            this.g = 0;
            this.k = false;
        }

        /* synthetic */ b(a r1) {
            this();
        }
    }

    public rh(z6 r2, ql r3) {
        this.f483a = new il(200);
        this.b = new SparseIntArray();
        this.c = null;
        this.d = null;
        this.e = new SparseIntArray();
        this.c = r2;
        this.d = (PowerManager) rd.e().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L6
    L4:
        dl.b().a(new a(this));
    }

    static /* synthetic */ il a(rh r0) {
        return r0.f483a;
    }

    public int b(byte r3) {
        SparseIntArray r0 = this.e;
        monitor-enter(r0);
        int r2 = this.e.get(r3, -1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(int r9, int r10, long r11, String r13) {
        a(r9, r10, r11, r13, false, false);
    }

    public void a(int r10, int r11, long r12, String r14, boolean r15, boolean r16) {
        a(r10, r11, r12, r14, r15, r16, null);
    }

    public void a(int r1, int r2, long r3, String r5, boolean r6, boolean r7, String r8) {
        b r4 = new b(null);
        r4.c = r8;
        r4.k = r6;
        PowerManager r9 = this.d;
        if (r9 != null) goto L23;
    L5:
        il r10 = this.f483a;
        monitor-enter(r10);
        this.f483a.a(Integer.valueOf(r1), r4);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        if (r7 == false) goto L18;
        SparseIntArray r11 = this.b;
        monitor-enter(r11);
        this.b.append(r1, r2);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    L23:
        r9.isScreenOn();     // Catch: Throwable -> L22
        goto L5
    }

    public void a(int r1, int r2, String r3) {
        il r4 = this.f483a;
        monitor-enter(r4);
        b r0 = (b) this.f483a.b(Integer.valueOf(r2));     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        if (r0 == null) goto L14;
        r0.c = r3;
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void a(String r11, int r12, qg.n r13, int r14, int r15) {
        if (r13 == null) goto L18;
        ArrayList r0 = r13.k;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.size() <= 0) goto L25;
        int r1 = r13.k.size();
        Iterator r16 = r13.k.iterator();
    L9:
        if (r16.hasNext() == false) goto L26;
        pi r6 = (pi) r16.next();
        if (r6 == null) goto L9;
        int r4 = r6.f422a;
        int r5 = r6.b;
        if (r15 <= 0) goto L16;
        String r2 = String.format("%d/%d", new Object[]{Integer.valueOf(r15), Integer.valueOf(r1)});
    L17:
        a(r11, r4, r5, r6, r12, r14, r2);
        goto L9
    L16:
        r2 = null;
        goto L17
    L26:
        return;
    L25:
        return;
    }

    public void a(String r9, int r10, int r11, pi r12, int r13) {
        a(r9, r10, r11, r12, r13, 0, null);
    }

    public void a(String r1, int r2, int r3, pi r4, int r5, int r6, String r7) {
        il r8 = this.f483a;
        monitor-enter(r8);
        b r9 = (b) this.f483a.b(Integer.valueOf(r3));     // Catch: Throwable -> L27
        monitor-exit(r8);     // Catch: Throwable -> L27
        if (r9 != null) goto L8;
        return;
    L8:
        r9.b = r2;
        r9.f485a.set(r5, true);
        if (r7 == null) goto L12;
        r9.i = r7;
    L12:
        if (r5 != 41) goto L14;
    L22:
        r9.e = r6;
        z6 r0 = this.c;
        if (r0 == null) goto L25;
        r0.c(r2, r6);
    L25:
        r9.h = System.currentTimeMillis();
        return;
    L14:
        if (r5 == 33) goto L22;
        if (r5 != 52) goto L21;
        r9.f = r6;
        z6 r10 = this.c;
        if (r10 == null) goto L25;
        r10.b(r2, r6);
        goto L25
    L21:
        r9.g = r6;
    L27:
        th = move-exception;
        throw th;
    }

    public void a(String r8, int r9, int r10, int r11, int r12) {
        a(r8, r9, r10, r11, r12, null);
    }

    public void a(String r1, int r2, int r3, int r4, int r5, String r6) {
        il r7 = this.f483a;
        monitor-enter(r7);
        b r0 = (b) this.f483a.b(Integer.valueOf(r3));     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
        if (r0 != null) goto L8;
        return;
    L8:
        r0.b = r2;
        if (r6 == null) goto L11;
        r0.j = r6;
    L11:
        r0.f485a.set(r4, true);
        if (r4 != 41) goto L15;
        r0.e = r5;
    L18:
        r0.h = System.currentTimeMillis();
        return;
    L15:
        if (r4 != 52) goto L17;
        r0.f = r5;
        goto L18
    L17:
        r0.g = r5;
    L20:
        th = move-exception;
        throw th;
    }

    public boolean a(int r2) {
        return a(r2, true);
    }

    public boolean a(int r5, boolean r6) {
        il r0 = this.f483a;
        monitor-enter(r0);
        b r1 = (b) this.f483a.b(Integer.valueOf(r5));     // Catch: Throwable -> L60
        monitor-exit(r0);     // Catch: Throwable -> L60
        if (r1 != null) goto L9;
        return false;
    L9:
        il r2 = this.f483a;
        monitor-enter(r2);
        this.f483a.a(Integer.valueOf(r5));     // Catch: Throwable -> L57
        monitor-exit(r2);     // Catch: Throwable -> L57
        SparseIntArray r3 = this.b;
        monitor-enter(r3);
        this.b.delete(r5);     // Catch: Throwable -> L54
        monitor-exit(r3);     // Catch: Throwable -> L54
        boolean r7 = r1.f485a.get(50);
        r1.f485a.get(51);
        boolean r4 = r1.f485a.get(36);
        int r8 = r1.g;
        if (r8 == 0) goto L27;
        if (r4 == false) goto L21;
        r8 = -2700;
        goto L27
    L21:
        int r9 = j4.a(r8);
        if (r9 != (-50000)) goto L27;
        if (r1.d == false) goto L27;
        r8 = (r8 - r9) - 550000;
    L27:
        if (this.c != null) goto L29;
    L53:
        return r7;
    L29:
        if (r1.k == true) goto L53;
        int r10 = r1.b;
        if (r10 <= 10000) goto L36;
        if (r10 >= 20000) goto L36;
        r10 = r10 - 10000;
    L36:
        if (r10 == 999) goto L53;
        if (r10 == 794) goto L53;
        if (r10 == 797) goto L53;
        if (r10 == 782) goto L53;
        if (r8 == 0) goto L45;
        if (r6 == false) goto L53;
        if (TextUtils.isEmpty(r1.c) == true) goto L52;
        this.c.a(r10, r1.c, r8);
        goto L53
    L52:
        this.c.a(r10, r8);
        goto L53
    L45:
        if (TextUtils.isEmpty(r1.c) == true) goto L47;
        this.c.a(r10, r1.c, r8);
        goto L53
    L47:
        this.c.a(r10, r8);
    L54:
        th = move-exception;
        throw th;
    L57:
        th = move-exception;
        throw th;
    L60:
        th = move-exception;
        throw th;
    }

    public void a(byte r2) {
        SparseIntArray r0 = this.e;
        monitor-enter(r0);
        this.e.delete(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(byte r2, int r3) {
        SparseIntArray r0 = this.e;
        monitor-enter(r0);
        this.e.append(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean a() {
        SparseIntArray r0 = this.b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.b.size() <= 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }
}
