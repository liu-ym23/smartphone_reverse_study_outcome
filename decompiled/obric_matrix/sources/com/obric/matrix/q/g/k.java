package com.obric.matrix.q.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.matrix.w.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/base/network/ThirdCallInfoCache;", "", "()V", "callInfoCacheByAppid", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/matrix/base/network/CallInfo;", "addCallInfo", "", "request", "Lcom/obric/matrix/proto/Request;", "getCacheCallInfo", "appid", "removeCallInfoByPkg", "pkg", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f9865a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, f> f9866b = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/base/network/ThirdCallInfoCache$addCallInfo$1", "Lcom/obric/matrix/base/tunnel/IClientDiedCallback;", "onClientDiedAsync", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.q.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f9867a;

        a(b0 r1) {
            this.f9867a = r1;
        }

        @Override // com.obric.matrix.q.i.c
        public void a() {
            k r0 = k.f9865a;
            String r2 = this.f9867a.n;
            o.e(r2, "request.appPkg");
            r0.c(r2);
        }
    }

    static {
        f9865a = new k();
        f9866b = new ConcurrentHashMap();
    }

    private k() {
    }

    public final void a(b0 r12) {
        o.f(r12, "request");
        if (TextUtils.isEmpty(r12.f10198i) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r12.n) == true) goto L33;
        ConcurrentHashMap<String, f> r11 = f9866b;
        f r0 = r11.get(r12.f10198i);
        if (r0 != null) goto L10;
    L11:
        com.obric.matrix.q.i.a r2 = com.obric.matrix.q.i.a.f9901a;
        String r3 = r12.n;
        o.e(r3, "request.appPkg");
        com.obric.matrix.q.i.a.d(r2, r3, new a(r12), null, 4, null);
        long r6 = com.obric.matrix.r.e.b.f9938a.b(com.bytedance.mpaas.app.a.a(), r12.n);
        Context r4 = com.bytedance.mpaas.app.a.a();
        if (r4 == null) goto L16;
        PackageManager r5 = r4.getPackageManager();
        if (r5 == null) goto L16;
        ApplicationInfo r7 = r5.getApplicationInfo(r12.n, 128);
    L17:
        if (r7 == null) goto L22;
        Bundle r8 = r7.metaData;
        if (r8 == null) goto L22;
        String r9 = r8.getString("pvr.sdk.version");
        if (r9 == null) goto L22;
    L23:
        String r10 = r12.f10198i;
        o.e(r10, "request.appKey");
        String r13 = r12.n;
        o.e(r13, "request.appPkg");
        String r14 = r12.f10197h;
        o.e(r14, "request.sdkVersion");
        f r15 = new f(r10, r13, r6, r9, r14);
        String r1 = r12.f10198i;
        o.e(r1, "request.appKey");
        r11.put(r1, r15);
    L24:
        f r16 = r11.get(r12.f10198i);
        if (r16 != null) goto L27;
        return;
    L27:
        if (TextUtils.isEmpty(r16.a()) == false) goto L32;
        String r17 = r12.f10197h;
        o.e(r17, "request.sdkVersion");
        r16.e(r17);
        return;
    L32:
        return;
    L22:
        r9 = "";
    L16:
        r7 = null;
        goto L17
    L10:
        if (o.a(r0.b(), r12.n) == true) goto L24;
    }

    public final f b(String r1) {
        o.f(r1, "appid");
        return f9866b.get(r1);
    }

    public final void c(String r4) {
        o.f(r4, "pkg");
        ArrayList r3 = new ArrayList();
        Iterator<Map.Entry<String, f>> r0 = f9866b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, f> r1 = r0.next();
        if (o.a(r1.getValue().b(), r4) == false) goto L4;
        r3.add(r1.getKey());
        goto L4
    L8:
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        String r6 = (String) r5.next();
        f9866b.remove(r6);
        goto L10
    }
}
