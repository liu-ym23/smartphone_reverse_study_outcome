package tmsdkobf;

import tmsdk.common.TMServiceFactory;

/* JADX INFO: loaded from: classes5.dex */
public class j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p6 f283a;
    private int b;
    private long c;
    private int d;
    private long e;
    private long f;

    public j5(String r4, long r5, int r7) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        p6 r6 = TMServiceFactory.getPreferenceService("freq_ctrl_" + r4);
        this.f283a = r6;
        this.b = r7;
        this.c = r5;
        this.d = r6.getInt("times_now", this.d);
        this.e = this.f283a.getLong("time_span_start", this.e);
        this.f = this.f283a.getLong("time_span_end", this.f);
        this.f283a.putInt("times", r7);
        this.f283a.putLong("time_span", r5);
    }

    public boolean a() {
        if (this.e != 0) goto L5;
        return true;
    L5:
        long r2 = System.currentTimeMillis();
        if (this.d >= this.b) goto L8;
    L11:
        return true;
    L8:
        if (r2 >= this.f) goto L11;
        return false;
    }

    public void b() {
        long r0 = System.currentTimeMillis();
        if (this.e != 0) goto L6;
    L7:
        a(r0);
        a(0);
    L8:
        a(this.d + 1);
        return;
    L6:
        if (r0 < this.f) goto L8;
        goto L7
    }

    private void a(long r3) {
        this.e = r3;
        this.f = this.c + r3;
        this.f283a.putLong("time_span_start", r3);
        this.f283a.putLong("time_span_end", this.f);
    }

    private void a(int r2) {
        this.d = r2;
        this.f283a.putInt("times_now", r2);
    }
}
