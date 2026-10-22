package xk;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.k;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.salamander.anniex.b0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import x4.e;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f23154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f23155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f23156c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ c f;

    public b(c r5, String r10, z r11, int r12, String r13, long r14) {
        this.f = r5;
        this.f23154a = r10;
        this.f23155b = r11;
        this.f23156c = r12;
        this.d = r13;
        this.e = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r5 = this.f;
        WebView r10 = (WebView) r5.f23157a.get();
        if (r10 == null) goto L29;
        String r11 = this.f23154a;
        if (TextUtils.isEmpty(r11) == true) goto L30;
        CopyOnWriteArrayList r12 = (CopyOnWriteArrayList) this.f23155b.f23549a;
        if (r12 == null) goto L17;
        Iterator r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L17;
        TimeLineEvent r14 = (TimeLineEvent) r13.next();
        if (r14 == null) goto L11;
        if ("label_create_java_call".equals(r14.getLabel()) == false) goto L11;
        long r15 = r14.getElapsedTimestamp();
    L18:
        e r16 = new e();
        r16.f22965a = r11;
        int r17 = this.f23156c;
        r16.f22966b = c.e(r5, r17);
        String r18 = this.d;
        r16.f22967c = r18;
        r16.f = r15;
        if (r15 == 0) goto L21;
        long r19 = this.e;
        r16.g = r19;
        r16.e = r19 - r15;
    L21:
        k r110 = k.d;
        r110.m(r10, r16);
        b0 r20 = new b0(10, (byte) 0);
        r20.d = r11;
        r20.f7246b = c.e(r5, r17);
        r20.f7247c = r18;
        r110.i(r10, r20);
        return;
    L17:
        r15 = 0;
        goto L18
    L30:
        return;
    }
}
