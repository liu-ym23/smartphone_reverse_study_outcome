package d.b.h.a.a.h.o.b.x;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j implements Callable<Void> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f13616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WeakHandler f13617h;

    public j(String r1, d r2, WeakHandler r3) {
        this.f13615f = r1;
        this.f13616g = r2;
        this.f13617h = r3;
    }

    public Void a() {
        long r0 = System.currentTimeMillis();
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        InetAddress[] r2 = InetAddress.getAllByName(this.f13615f);     // Catch: UnknownHostException -> L19
        int r3 = r2.length;     // Catch: UnknownHostException -> L19
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L13;
        InetAddress r5 = r2[r4];     // Catch: UnknownHostException -> L19
        if ((r5 instanceof Inet4Address) == false) goto L9;
        r9.add(r5.getHostAddress());     // Catch: UnknownHostException -> L19
    L12:
        r4 = r4 + 1;     // Catch: UnknownHostException -> L19
        goto L4
    L9:
        if ((r5 instanceof Inet6Address) == false) goto L11;
        r10.add(r5.getHostAddress());     // Catch: UnknownHostException -> L19
        goto L12
    L11:
        Logger.debug();     // Catch: UnknownHostException -> L19
        goto L12
    L13:
        Logger.debug();     // Catch: UnknownHostException -> L19
        if (r9.size() <= 0) goto L16;
    L17:
        a r11 = new a(this.f13615f, System.currentTimeMillis(), r9, r10, e.q().p().get());     // Catch: UnknownHostException -> L19
        this.f13616g.f(this.f13615f, r11);     // Catch: UnknownHostException -> L19
    L22:
        if (e.q().s().get() == true) goto L36;
        Message r6 = Message.obtain();
        r6.obj = this;
        r6.what = 1;
        Bundle r7 = new Bundle();
        r7.putString("localdns_completed_host", this.f13615f);
        r6.setData(r7);
        this.f13617h.sendMessage(r6);
        Logger.debug();
        long r8 = System.currentTimeMillis() - r0;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L34
        r1.put("host", this.f13615f);     // Catch: JSONException -> L34
        if (r9.size() == 0) goto L28;
    L31:
        r1.put("status", "succeed");     // Catch: JSONException -> L34
        ArrayList r12 = new ArrayList();     // Catch: JSONException -> L34
        r12.addAll(r10);     // Catch: JSONException -> L34
        r12.addAll(r9);     // Catch: JSONException -> L34
        Object r13 = r12;
    L30:
        r1.put("result", r13);     // Catch: JSONException -> L34
        r1.put("rtt", r8);     // Catch: JSONException -> L34
        Logger.debug();     // Catch: JSONException -> L34
        goto L36
    L28:
        if (r10.size() != 0) goto L31;
        r1.put("status", "failed");     // Catch: JSONException -> L34
        r13 = "";
    L34:
        e = move-exception;
        e.printStackTrace();
    L36:
        this.f13616g.y(this.f13615f);
        return null;
    L16:
        if (r10.size() <= 0) goto L22;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return a();
    }
}
