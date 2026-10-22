package d.b.u.z;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.g;
import com.bytedance.common.utility.k;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.obric.matrix.common_api.INetworkApi;
import d.b.u.d0.c;
import d.b.u.e;
import d.b.u.r;
import d.b.u.w.j;
import java.util.LinkedHashMap;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class b implements j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ l[] f15129h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f15130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f15131g;

    static final class a extends q implements kotlin.n0.c.a<Gson> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f15132f = null;

        static {
            f15132f = new a();
        }

        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Gson invoke() {
            return new Gson();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Gson invoke() {
            return invoke();
        }
    }

    static {
        f15129h = new l[]{e0.g(new y(e0.b(b.class), "mGson", "getMGson()Lcom/google/gson/Gson;"))};
    }

    public b(e r2) {
        o.g(r2, "mConfiguration");
        this.f15131g = r2;
        this.f15130f = i.b(a.f15132f);
    }

    private final Uri F() {
        com.ss.android.ug.bus.a r0 = com.ss.android.ug.bus.b.a(d.b.u.w.b.class);
        o.b(r0, "UgBusFramework.getServic…:class.java\n            )");
        d.b.u.c0.a.d r1 = ((d.b.u.w.b) r0).e();
        Uri r3 = Uri.parse(this.f15131g.f15029g).buildUpon().appendPath("v2/bytesync/api/pipeline").appendQueryParameter(WsConstants.KEY_DEVICE_ID, r1.f15019a).appendQueryParameter(WsConstants.KEY_APP_ID, this.f15131g.f15023a).appendQueryParameter(WsConstants.KEY_PLATFORM, BDLocationException.ERROR_TIMEOUT).build();
        o.b(r3, "Uri.parse(mConfiguration…(\"platform\", \"0\").build()");
        return r3;
    }

    private final String M(String r6, com.bytedance.sync.v2.j.e r7, boolean r8, String r9, boolean r10) {
        byte[] r0 = ((com.bytedance.sync.v2.f.e) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.e.class)).s(r7);
        if (r0 == null) goto L31;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r8 == false) goto L24;
        byte[] r11 = g.d(r0);     // Catch: Exception -> L20
        if (r11 == null) goto L24;
        if (r11.length != 0) goto L11;
        boolean r3 = true;
    L13:
        if ((!r3) == false) goto L24;
        int r2 = r0.length;     // Catch: Exception -> L20
        int r4 = r11.length;     // Catch: Exception -> L20
        Integer r12 = com.bytedance.sync.v2.l.a.f6160a.c(r7);     // Catch: Exception -> L20
        if (r12 == null) goto L17;
        int r13 = r12.intValue();     // Catch: Exception -> L20
    L18:
        r.e(r2, r4, r13);     // Catch: Exception -> L20
        r1.put("Accept-Encoding", "gzip");     // Catch: Exception -> L20
        r1.put("Content-Encoding", "gzip");     // Catch: Exception -> L20
        r0 = r11;
        goto L24
    L17:
        r13 = -1;
        goto L18
    L11:
        r3 = false;
    L20:
        e = move-exception;
        throw new com.bytedance.common.utility.a(0, e.getMessage());
    L24:
        if (k.c(r9) == true) goto L26;
        r1.put(INetworkApi.CONTENT_TYPE, r9);
    L26:
        g.a r5 = new g.a();
        r5.f3274a = false;
        Pair<String, String> r14 = c.a(r10);
        if (r14 == null) goto L30;
        Object r15 = r14.first;
        o.b(r15, "first");
        Object r16 = r14.second;
        o.b(r16, "second");
        r1.put(r15, r16);
    L30:
        return g.f().h(r6, r0, r1, r5);
    L31:
        return null;
    }

    @Override // d.b.u.w.j
    public com.bytedance.sync.v2.j.e b0(Context r8, com.bytedance.sync.v2.j.e r9) {
        Uri r0 = F();     // Catch: Throwable -> L4
        d.b.u.b0.b r10 = d.b.u.b0.b.g(r8);     // Catch: Throwable -> L4
        o.b(r10, "SyncSettings.inst(context)");     // Catch: Throwable -> L4
        boolean r4 = r10.f().a();     // Catch: Throwable -> L4
        byte[] r7 = Base64.decode(M(r0.toString(), r9, r4, "application/octet-stream", false), 0);     // Catch: Throwable -> L4
        return ((com.bytedance.sync.v2.f.e) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.e.class)).I(r7);
    L4:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
        return null;
    }
}
