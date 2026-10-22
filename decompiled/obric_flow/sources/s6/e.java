package s6;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f21831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f21832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21833c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ThreadGroup e;

    public e(boolean r5, int[] r10, String r11, int r12, ThreadGroup r13) {
        this.f21831a = r5;
        this.f21832b = r10;
        this.f21833c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int[] r5 = this.f21832b;
        boolean r10 = this.f21831a;
        int r11 = this.d;
        String r12 = this.f21833c;
        if (r10 == true) goto L22;
        int r13 = r5[0];
        if (r13 < f.f21834h) goto L22;
        if (f.g == false) goto L22;
        Thread[] r14 = new Thread[(r13 / 2) + r13];
        r5[0] = this.e.enumerate(r14);
        StringBuilder r15 = new StringBuilder();
        int r16 = 0;
    L10:
        int r17 = r5[0];
        if (r16 >= r17) goto L24;
        String r18 = r14[r16].getName();
        if (TextUtils.isEmpty(r18) == true) goto L15;
        r15.append(r18);
        r15.append(",");
    L15:
        r16 = r16 + 1;
        goto L10
    L24:
        i6.a.i().b(new j6.e(f.l(r11, r17, r12, r15.toString())));     // Catch: Throwable -> L20
        return;
    L28:
        return;
    L22:
        i6.a.i().b(new j6.e(f.l(r11, r5[0], r12, null)));     // Catch: Exception -> L21
        return;
    }
}
