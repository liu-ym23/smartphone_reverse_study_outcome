package com.obric.matrix.opush.e.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.matrix.opush.c;
import com.obric.matrix.push.n.b.d.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/opush/cross_process/method/RegisterChannelMethod;", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessMethod;", "()V", "TAG", "", "getMethodName", "maskToken", "token", "onMethodInvoke", "", "originPkgName", "args", "", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9407a;

    /* JADX INFO: renamed from: com.obric.matrix.opush.e.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\r"}, d2 = {"com/obric/matrix/opush/cross_process/method/RegisterChannelMethod$onMethodInvoke$1", "Lcom/obric/matrix/opush/base/network/IRequestCallback;", "onCallback", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "args", "", "", "onResult", "ec", "", NotificationCompat.CATEGORY_MESSAGE, "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0254a implements com.obric.matrix.opush.base.network.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f9408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.push.n.b.b f9410c;

        C0254a(a r1, String r2, com.obric.matrix.push.n.b.b r3) {
            this.f9408a = r1;
            this.f9409b = r2;
            this.f9410c = r3;
        }

        private final void a(com.obric.matrix.push.n.b.b r7, List<String> r8) {
            v.a r0 = v.f21457g;     // Catch: Throwable -> L8
            if (r7 == null) goto L5;
            r7.F(r8);     // Catch: Throwable -> L8
            Object r9 = f0.f18324a;     // Catch: Throwable -> L8
        L6:
            v.b(r9);     // Catch: Throwable -> L8
        L10:
            a r6 = this.f9408a;
            Throwable r10 = v.d(r9);
            if (r10 == null) goto L16;
            c.e(c.f9247a, a.c(r6), "onCallback error: " + r10, null, 4, null);
            return;
        L16:
            return;
        L5:
            r9 = null;
        L8:
            th = move-exception;
            v.a r11 = v.f21457g;
            r9 = w.a(th);
            v.b(r9);
            goto L10
        }

        @Override // com.obric.matrix.opush.base.network.b
        public void onResult(int r7, String r8) {
            if (r7 != 0) goto L15;
            JSONObject r9 = new JSONObject(r8);
            if (r9.optInt("code", -1) != 0) goto L13;
            JSONObject r10 = r9.optJSONObject("data");
            if (r10 == null) goto L20;
            String r11 = r10.optString(com.obric.matrix.opush.f.b.G.z());
            c.f9247a.b(a.c(this.f9408a), "registerAppToken success, packageName is " + this.f9409b + " token is " + a.d(this.f9408a, r11));
            if (TextUtils.isEmpty(r11) == false) goto L18;
            ArrayList r12 = new ArrayList();
            r12.add("failed");
            StringBuilder r0 = new StringBuilder();
        L14:
            r0.append("server response error:");
            r0.append(r8);
            r12.add(r0.toString());
            a(this.f9410c, r12);
            return;
        L18:
            com.obric.matrix.opush.base.settings.a r13 = com.obric.matrix.opush.d.b.f9251a.u();     // Catch: Throwable -> L17
            String r1 = this.f9409b;     // Catch: Throwable -> L17
            o.e(r11, "token");     // Catch: Throwable -> L17
            r13.d(r1, r11);     // Catch: Throwable -> L17
        L11:
            ArrayList r14 = new ArrayList();
            r14.add("success");
            r14.add(r11);
            a(this.f9410c, r14);
            return;
        L20:
            return;
        L13:
            r12 = new ArrayList();
            r12.add("failed");
            r0 = new StringBuilder();
            goto L14
        L15:
            ArrayList r2 = new ArrayList();
            r2.add("failed");
            r2.add("errorCode:" + r7 + " errorMsg:" + r8);
            a(this.f9410c, r2);
        }
    }

    public a() {
        this.f9407a = "RegisterChannelMethod";
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.f9407a;
    }

    public static final /* synthetic */ String d(a r0, String r1) {
        return r0.e(r1);
    }

    private final String e(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        return "";
    L13:
        if (r5.length() > 8) goto L15;
        return "***";
    L15:
        StringBuilder r1 = new StringBuilder();
        String r4 = r5.substring(0, 4);
        o.e(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        r1.append(r4);
        r1.append("***");
        String r6 = r5.substring(r5.length() - 4);
        o.e(r6, "this as java.lang.String).substring(startIndex)");
        r1.append(r6);
        return r1.toString();
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public String a() {
        return "register_channel";
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public void b(String r11, List<Object> r12, com.obric.matrix.push.n.b.b r13) {
        o.f(r11, "originPkgName");
        com.obric.matrix.r.c.c.b(this.f9407a, "on " + a() + " call, originPkgName is " + r11);
        if (r12 != null) goto L5;
        return;
    L5:
        int r0 = 0;
        Object r1 = r12.get(0);
        Objects.requireNonNull(r1, "null cannot be cast to non-null type kotlin.String");
        String r5 = (String) r1;
        Object r2 = r12.get(1);
        Objects.requireNonNull(r2, "null cannot be cast to non-null type kotlin.String");
        String r6 = (String) r2;
        if (r12.size() <= 2) goto L13;
        Object r14 = r12.get(2);
        if ((r14 instanceof Integer) == false) goto L10;
        Integer r15 = (Integer) r14;
    L11:
        if (r15 == null) goto L13;
        r0 = r15.intValue();
        goto L13
    L10:
        r15 = null;
    L13:
        int r7 = r0;
        com.obric.matrix.opush.d.b r16 = com.obric.matrix.opush.d.b.f9251a;
        com.obric.matrix.opush.d.i.a r3 = r16.t();
        if (r16.d().c(r11) == false) goto L16;
        String r17 = BDLocationException.ERROR_TIMEOUT;
    L17:
        r3.b(r11, r5, r6, r7, new C0254a(this, r11, r13), r17);
        return;
    L16:
        r17 = LocationInfoConst.ALLOW_USE_LOCATION;
        goto L17
    }
}
