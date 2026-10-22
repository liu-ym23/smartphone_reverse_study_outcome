package d.g.d.f.f;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16937b;

    public a(String r2, boolean r3) {
        o.f(r2, "baseTag");
        this.f16936a = r2;
        this.f16937b = r3;
    }

    public /* synthetic */ a(String r1, boolean r2, int r3, g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    @Override // d.g.d.f.f.b.a
    public void a(String r4, int r5, String r6, Throwable r7) {
        o.f(r6, NotificationCompat.CATEGORY_MESSAGE);
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        r6 = r4 + "-->" + r6;
    L13:
        if (this.f16937b == false) goto L15;
        StringBuilder r8 = new StringBuilder();
        r8.append('[');
        Thread r2 = Thread.currentThread();
        o.e(r2, "Thread.currentThread()");
        r8.append(r2.getName());
        r8.append("]|");
        r8.append(r6);
        r6 = r8.toString();
    L15:
        if (r5 != 1) goto L17;
        Log.v(this.f16936a, r6);
        return;
    L17:
        if (r5 != 2) goto L19;
        Log.d(this.f16936a, r6);
        return;
    L19:
        if (r5 != 4) goto L21;
        Log.i(this.f16936a, r6);
        return;
    L21:
        if (r5 != 8) goto L23;
        String r3 = this.f16936a;
        if (r7 != null) goto L32;
        Log.w(r3, r6);
        return;
    L32:
        Log.w(r3, r6, r7);
        return;
    L23:
        if (r5 != 16) goto L43;
        String r9 = this.f16936a;
        if (r7 != null) goto L28;
        Log.e(r9, r6);
        return;
    L28:
        Log.e(r9, r6, r7);
        return;
    L43:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
