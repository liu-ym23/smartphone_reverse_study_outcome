package ul;

import ai.q0;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.ttnet.INetworkApi;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import fi.i;
import java.io.BufferedInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ta.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GeckoGlobalConfig.ENVType f22370b;

    public f(String r5, GeckoGlobalConfig.ENVType r10) {
        Intrinsics.checkNotNullParameter(r5, "lane");
        Intrinsics.checkNotNullParameter(r10, "env");
        this.f22369a = r5;
        this.f22370b = r10;
    }

    @Override // ta.b
    public final ta.c a(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L19:
        return null;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        LinkedHashMap r5 = new LinkedHashMap();
        Pair r12 = com.bytedance.frameworks.baselib.network.http.util.c.c(r10, r5);
        String r13 = (String) r12.first;
        String r14 = (String) r12.second;
        ArrayList r15 = a();
        if (r11 == null) goto L10;
        byte[] r16 = r11.getBytes(Charset.forName("UTF-8"));
    L11:
        fi.g r17 = new fi.g("application/json", r16, new String[0]);
        INetworkApi r18 = (INetworkApi) com.bytedance.ttnet.utils.d.c(INetworkApi.class, r13);
        if (r18 == null) goto L19;
        q0 r19 = r18.postBody(204800, r14, r5, r17, r15).execute();
        bi.e r110 = r19.f290a;
        HashMap r20 = new HashMap();
        List r111 = (List) r110.d;
        ArrayList r21 = new ArrayList(CollectionsKt.h(r111));
        Iterator r112 = r111.iterator();
    L15:
        if (r112.hasNext() == false) goto L17;
        bi.c r22 = (bi.c) r112.next();
        r20.put(r22.f915a, r22.f916b);
        r21.add(Unit.INSTANCE);
        goto L15
    L17:
        String r113 = (String) r19.f291b;
        bi.e r23 = r19.f290a;
        return new ta.c(r20, r113, r23.f930b, (String) r23.f931c);
    L10:
        r16 = null;
        goto L11
    }

    @Override // ta.b
    public final void c(String r10, na.b r11) {
        if (TextUtils.isEmpty(r10) == true) goto L44;
        LinkedHashMap r5 = new LinkedHashMap();
        Pair r12 = com.bytedance.frameworks.baselib.network.http.util.c.c(r10, r5);
        String r13 = (String) r12.first;
        String r14 = (String) r12.second;
        ArrayList r15 = a();
        INetworkApi r16 = (INetworkApi) com.bytedance.ttnet.utils.d.c(INetworkApi.class, r13);
        if (r16 == null) goto L34;
        ai.c r17 = r16.downloadFile(false, 52428800, r14, r5, r15, null);
        int r18 = 0;
        BufferedInputStream r19 = null;
        q0 r20 = r17.execute();     // Catch: Throwable -> L26 Exception -> L28
        int r21 = r20.f290a.f930b;     // Catch: Throwable -> L26 Exception -> L28
        BufferedInputStream r22 = new BufferedInputStream(((i) r20.f291b).c());     // Catch: Exception -> L24 Throwable -> L26
        byte[] r23 = new byte[4096];     // Catch: Throwable -> L16 Exception -> L18
    L12:
        int r24 = r22.read(r23, 0, 4096);     // Catch: Throwable -> L16 Exception -> L18
        if (r24 == (-1)) goto L22;
        r11.d.write(r23, 0, r24);     // Catch: Throwable -> L16 Exception -> L18
        r11.b(r24);     // Catch: Throwable -> L16 Exception -> L18
    L22:
        com.bytedance.geckox.utils.d.c(r22);
        return;
    L18:
        e = e;
        r19 = r22;
    L31:
        throw new RuntimeException("downloadFile failed, code: " + r21 + ", url: " + r10 + ", caused by: " + e.getMessage(), e);     // Catch: Throwable -> L26
    L16:
        th = th;
        r19 = r22;
    L32:
        com.bytedance.geckox.utils.d.c(r19);
        throw th;
    L24:
        e = e;
        r18 = r21;
    L29:
        r21 = r18;
    L28:
        e = e;
    L26:
        th = th;
        goto L32
    L34:
        return;
    }

    public final ArrayList a() {
        ArrayList r5 = new ArrayList();
        int r10 = e.f22368a[this.f22370b.ordinal()];
        String r11 = this.f22369a;
        if (r10 != 1) goto L5;
        r5.add(new bi.c("x-use-boe", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
        if (TextUtils.isEmpty(r11) == false) goto L14;
    L16:
        return r5;
    L14:
        if (StringsKt.P(r11, "boe_") == false) goto L16;
        r5.add(new bi.c("x-tt-env", r11));
        goto L16
    L5:
        if (r10 != 2) goto L16;
        if (StringsKt.P(r11, "ppe_") == false) goto L16;
        r5.add(new bi.c("x-use-ppe", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
        r5.add(new bi.c("x-tt-env", r11));
        return r5;
    }
}
