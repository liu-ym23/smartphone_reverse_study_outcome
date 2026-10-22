package com.obric.matrix.push.o.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.matrix.r.c.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/push/cross_process/method/RegisterChannelMethod;", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessMethod;", "()V", "TAG", "", "getMethodName", "onMethodInvoke", "", "originPkgName", "args", "", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements com.obric.matrix.push.n.b.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9763a;

    /* JADX INFO: renamed from: com.obric.matrix.push.o.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/push/cross_process/method/RegisterChannelMethod$onMethodInvoke$1", "Lcom/obric/matrix/push/base/network/IRequestCallback;", "onResult", "", "ec", "", NotificationCompat.CATEGORY_MESSAGE, "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0278a implements com.obric.matrix.push.base.network.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.push.n.b.b f9765b;

        C0278a(String r1, com.obric.matrix.push.n.b.b r2) {
            this.f9764a = r1;
            this.f9765b = r2;
        }

        @Override // com.obric.matrix.push.base.network.c
        public void onResult(int r6, String r7) {
            if (r6 != 0) goto L22;
            JSONObject r1 = new JSONObject(r7);
            if (r1.optInt("code", -1) == 0) goto L7;
        L19:
            ArrayList r2 = new ArrayList();
            r2.add("failed");
            r2.add("server response error:" + r7);
            com.obric.matrix.push.n.b.b r8 = this.f9765b;
            if (r8 != null) goto L24;
        L25:
            com.obric.matrix.push.m.j.b.c(this.f9764a, r6);
            return;
        L24:
            r8.F(r2);
            goto L25
        L7:
            if (TextUtils.equals(r1.optString("message"), "success") == false) goto L19;
            JSONObject r3 = r1.optJSONObject("data");
            if (r3 == null) goto L25;
            String r4 = r3.optString(com.obric.matrix.push.p.b.h0.S());
            if (TextUtils.isEmpty(r4) == false) goto L28;
            r2 = new ArrayList();
            r2.add("failed");
            r2.add("server response error:" + r7);
            r8 = this.f9765b;
            if (r8 == null) goto L25;
        L28:
            com.obric.matrix.push.m.b.f9633a.B().d(this.f9764a);     // Catch: Throwable -> L27
        L13:
            ArrayList r9 = new ArrayList();
            r9.add("success");
            r9.add(r4);
            com.obric.matrix.push.n.b.b r0 = this.f9765b;
            if (r0 == null) goto L25;
            r0.F(r9);
            goto L25
        L22:
            r2 = new ArrayList();
            r2.add("failed");
            r2.add("errorCode:" + r6 + " errorMsg:" + r7);
            r8 = this.f9765b;
            if (r8 == null) goto L25;
            goto L24
        }
    }

    public a() {
        this.f9763a = "RegisterChannelMethod";
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public String a() {
        return "register_channel";
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public void b(String r8, List<Object> r9, com.obric.matrix.push.n.b.b r10) {
        o.f(r8, "originPkgName");
        e.a(this.f9763a, "on " + a() + " call, originPkgName is " + r8 + " args is " + r9);
        if (r9 != null) goto L5;
        return;
    L5:
        Object r7 = r9.get(0);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.String");
        String r3 = (String) r7;
        Object r11 = r9.get(1);
        Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.String");
        String r4 = (String) r11;
        com.obric.matrix.push.m.b r12 = com.obric.matrix.push.m.b.f9633a;
        com.obric.matrix.push.m.l.a r1 = r12.A();
        if (r12.d().c(r8) == false) goto L8;
        String r13 = BDLocationException.ERROR_TIMEOUT;
    L9:
        r1.a(r8, r3, r4, new C0278a(r8, r10), r13);
        return;
    L8:
        r13 = LocationInfoConst.ALLOW_USE_LOCATION;
        goto L9
    }
}
