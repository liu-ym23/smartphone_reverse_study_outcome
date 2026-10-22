package xk;

import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.k;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.crash.util.g;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import l9.l;
import org.json.JSONObject;
import x4.e;
import zm.p;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f23152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f23153c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public a(long r5, String r10, Map r11, Map r12) {
        this.f23151a = 1;
        this.f23152b = r5;
        this.f23153c = r10;
        this.d = r11;
        this.e = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f23151a) {
            case 0: goto L17;
            default: goto L39;
        };
    L17:
        WebView r5 = (WebView) ((c) this.e).f23157a.get();
        if (r5 == null) goto L48;
        String r10 = this.f23153c;
        if (TextUtils.isEmpty(r10) == true) goto L49;
        CopyOnWriteArrayList r11 = (CopyOnWriteArrayList) ((z) this.d).f23549a;
        if (r11 == null) goto L32;
        Iterator r12 = r11.iterator();
    L26:
        if (r12.hasNext() == false) goto L32;
        TimeLineEvent r13 = (TimeLineEvent) r12.next();
        if (r13 == null) goto L26;
        if ("label_create_java_call".equals(r13.getLabel()) == false) goto L26;
        long r14 = r13.getElapsedTimestamp();
    L33:
        e r15 = new e();
        r15.f22965a = r10;
        r15.f22966b = 0;
        r15.f = r14;
        if (r14 == 0) goto L36;
        long r16 = this.f23152b;
        r15.g = r16;
        r15.e = r16 - r14;
    L36:
        k.d.m(r5, r15);
        return;
    L32:
        r14 = 0;
        goto L33
    L49:
        return;
    L48:
        return;
    L39:
        z8.c r17 = z8.c.c(n.f4057a, this.f23152b, this.f23153c);     // Catch: Throwable -> L38
        z8.c r18 = l.f().g(CrashType.DART, r17, null, false);     // Catch: Throwable -> L38
        Map r19 = (Map) this.d;
        if (r19 == null) goto L15;
        JSONObject r20 = r18.f23416a.optJSONObject("custom");     // Catch: Throwable -> L38
        if (r20 != null) goto L11;
        r20 = new JSONObject();     // Catch: Throwable -> L38
    L11:
        z8.c.m(r20, r19);     // Catch: Throwable -> L38
        Map r21 = (Map) this.e;     // Catch: Throwable -> L38
        if (r21 == null) goto L14;
        z8.c.m(r20, r21);     // Catch: Throwable -> L38
    L14:
        mh.e.g(r20, "custom", r17.f23416a);     // Catch: Throwable -> L38
    L15:
        mh.e.g(p.f(g.c(n.f4057a, Long.toHexString(new Random().nextLong()) + '-' + n.f4059c + '-' + Process.myPid() + "G")), "logcat", r18.f23416a);     // Catch: Throwable -> L38
        sj.k r22 = sj.k.g();     // Catch: Throwable -> L38
        JSONObject r23 = r18.f23416a;     // Catch: Throwable -> L38
        r22.getClass();     // Catch: Throwable -> L38
        sj.k.k(r23);     // Catch: Throwable -> L38
        return;
    }

    public a(c r5, String r10, z r11, long r12) {
        this.f23151a = 0;
        this.e = r5;
        this.f23153c = r10;
        this.d = r11;
        this.f23152b = r12;
    }
}
