package so;

import android.content.Intent;
import android.os.Bundle;
import com.obric.android.agilelogger.ALog;
import com.obric.android.agilelogger.utils.FormatUtils$TYPE;
import com.obric.android.alog.Alog;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FormatUtils$TYPE f21961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Throwable f21962c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f21963h;

    public a(int r5, FormatUtils$TYPE r10, Throwable r11, String r12, Object r13, String r14, long r15, long r16) {
        this.f21960a = r5;
        this.f21961b = r10;
        this.f21962c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f21963h = r16;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = ALog.access$400(this.f21960a);
        FormatUtils$TYPE r10 = this.f21961b;
        if (r10 != null) goto L8;
        Throwable r11 = this.f21962c;
        if (r11 == null) goto L29;
        com.lynx.tasm.behavior.utils.d.l(r11);
    L29:
        Alog r12 = mn.h.f;
        if (r12 == null) goto L33;
        r12.writeAsyncMsg(r5, this.f, this.d, this.g, this.f21963h);
        return;
    L33:
        return;
    L8:
        FormatUtils$TYPE r13 = FormatUtils$TYPE.BORDER;
        String r14 = this.d;
        if (r10 != r13) goto L11;
        bp.a.c(r13, r14);
        goto L29
    L11:
        FormatUtils$TYPE r15 = FormatUtils$TYPE.JSON;
        if (r10 != r15) goto L14;
        bp.a.c(r15, r14);
        goto L29
    L14:
        FormatUtils$TYPE r16 = FormatUtils$TYPE.BUNDLE;
        Object r17 = this.e;
        if (r10 != r16) goto L17;
        bp.a.b(r16, (Bundle) r17);
        goto L29
    L17:
        FormatUtils$TYPE r18 = FormatUtils$TYPE.INTENT;
        if (r10 != r18) goto L20;
        bp.a.a(r18, (Intent) r17);
        goto L29
    L20:
        FormatUtils$TYPE r19 = FormatUtils$TYPE.THROWABLE;
        if (r10 != r19) goto L23;
        to.a r20 = (to.a) bp.a.f966a.get(r19);
        r20.a((Throwable) r17);
        goto L29
    L23:
        FormatUtils$TYPE r21 = FormatUtils$TYPE.THREAD;
        if (r10 != r21) goto L26;
        to.a r22 = (to.a) bp.a.f966a.get(r21);
        r22.a((Thread) r17);
        goto L29
    L26:
        FormatUtils$TYPE r23 = FormatUtils$TYPE.STACKTRACE;
        if (r10 != r23) goto L29;
        to.a r24 = (to.a) bp.a.f966a.get(r23);
        r24.a((StackTraceElement[]) r17);
        goto L29
    }
}
