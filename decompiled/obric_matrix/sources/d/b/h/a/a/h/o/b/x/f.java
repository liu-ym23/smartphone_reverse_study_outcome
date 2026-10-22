package d.b.h.a.a.h.o.b.x;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements Callable<Void> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f13609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f13611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f13612j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private a.EnumC0360a f13613k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f13614l;
    private final WeakHandler m;

    static {
    }

    f(String r2, String r3, d r4, a.EnumC0360a r5, WeakHandler r6) {
        this.f13611i = new ArrayList();
        this.f13612j = new ArrayList();
        this.f13614l = 0;
        this.f13610h = r2;
        this.f13608f = r3;
        this.f13609g = r4;
        this.f13613k = r5;
        this.m = r6;
    }

    private String b(String r5) {
        StringBuilder r0 = new StringBuilder();
        if (d.b.h.a.a.h.o.b.x.k.d.b().get() == true) goto L5;
        this.f13614l = 1;
    L5:
        r0.append("https://");
        r0.append(r5);
        r0.append("/q?host=");
        r0.append(this.f13610h);
        r0.append("&");
        r0.append("aid=");
        r0.append(e.q().h().getAppId());
        r0.append("&");
        r0.append("okhttp_version=");
        r0.append(this.f13608f);
        r0.append("&");
        r0.append("p=");
        r0.append("android");
        r0.append("&");
        r0.append("source=");
        r0.append("tt-ok");
        r0.append("&");
        r0.append("f=");
        r0.append(this.f13614l);
        r0.append("&");
        r0.append("reason=");
        r0.append(this.f13613k.ordinal() - 1);
        if (this.f13609g.h().get() >= 3) goto L9;
        r0.append("&");
        r0.append("refresh_bkup_ip=");
        r0.append(LocationInfoConst.ALLOW_USE_LOCATION);
        this.f13609g.A();
    L9:
        return d.b.h.a.a.h.o.b.x.k.b.a(r0.toString(), r5);
    }

    private void c(String r4) {
        Logger.debug();
    L20:
        Logger.debug();
        return;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L20
        if (this.f13611i.size() <= 1) goto L15;
        JSONArray r5 = r0.optJSONArray("dns");     // Catch: JSONException -> L20
        if (r5 != null) goto L11;
        return;
    L11:
        int r1 = 0;
    L13:
        if (r1 >= r5.length()) goto L16;
        d(r5.optJSONObject(r1));     // Catch: JSONException -> L20
        r1 = r1 + 1;     // Catch: JSONException -> L20
    L16:
        JSONArray r3 = r0.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L20
        if (r3 == null) goto L25;
        e.q().C(r3);     // Catch: JSONException -> L20
        return;
    L25:
        return;
    L15:
        d(r0);     // Catch: JSONException -> L20
        goto L16
    }

    private void d(JSONObject r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        String r0 = r9.optString("host");
        Logger.debug();
        int r7 = r9.optInt("ttl");
        JSONArray r10 = r9.optJSONArray("ips");
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        if (r10 == null) goto L18;
        int r1 = 0;
    L8:
        if (r1 >= r10.length()) goto L18;
        String r2 = r10.optString(r1);
        if (d.b.h.a.a.h.o.b.x.k.c.d(r2) == false) goto L13;
        r6.add(r2);
    L16:
        r1 = r1 + 1;
        goto L8
    L13:
        if (d.b.h.a.a.h.o.b.x.k.c.c(r2) == false) goto L15;
        r5.add(r2);
        goto L16
    L15:
        Logger.debug();
    L18:
        if (this.f13611i.contains(r0) == true) goto L20;
        return;
    L20:
        if (r5.size() <= 0) goto L22;
    L23:
        a r11 = new a(r0, System.currentTimeMillis(), r5, r6, r7);
        this.f13609g.a(r0, r11);
        this.f13609g.u(r0);
        this.f13611i.remove(r0);
        return;
    L22:
        if (r6.size() > 0) goto L23;
    }

    public Void a() {
        String[] r0 = this.f13610h.split(",");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        String r3 = r0[r2];
        this.f13611i.add(r3);
        this.f13612j.add(r3);
        r2 = r2 + 1;
        goto L3
    L5:
        Logger.debug();
        String r4 = e.q().i();
        if (e.q().j().size() != 0) goto L9;
        this.f13609g.z();
    L9:
        if (d.b.h.a.a.h.o.b.x.k.a.a(r4) == true) goto L11;
    L15:
        String r5 = null;
    L16:
        if (r5 == null) goto L18;
        c(r5);
        this.f13609g.z();
    L30:
        Iterator<String> r6 = this.f13611i.iterator();
    L32:
        if (r6.hasNext() == false) goto L34;
        String r7 = r6.next();
        this.f13609g.u(r7);
        this.f13609g.s(r7);
        goto L32
    L34:
        Message r8 = Message.obtain();
        r8.obj = this;
        r8.what = 3;
        Bundle r9 = new Bundle();
        r9.putStringArrayList("httpdns_completed_hosts", (ArrayList) this.f13612j);
        r8.setData(r9);
        this.m.sendMessage(r8);
        Logger.debug();
        return null;
    L18:
        Iterator<String> r10 = e.q().j().iterator();
    L20:
        if (r10.hasNext() == false) goto L30;
        String r11 = r10.next();
        if (d.b.h.a.a.h.o.b.x.k.c.c(r11) == false) goto L24;
    L26:
        String r12 = b(r11);
        if (r12 == null) goto L25;
        c(r12);
    L25:
        Logger.debug();
        goto L20
    L24:
        if (d.b.h.a.a.h.o.b.x.k.c.d(r11) == true) goto L26;
    L11:
        if (this.f13609g.j().get() >= 2) goto L15;
        r5 = b(r4);
        if (r5 != null) goto L16;
        this.f13609g.b();
        goto L16
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return a();
    }
}
