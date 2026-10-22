package s8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.lynx.tasm.ui.image.v;
import java.net.ProtocolException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements i8.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicBoolean f21848h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.a f21850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f21851c;
    public a d;
    public final LinkedBlockingQueue e;
    public final ExecutorService f;
    public jm.a g;

    static {
        f21848h = new AtomicBoolean(true);
    }

    public g(Context r5, i4.a r10) {
        this.e = new LinkedBlockingQueue();
        ExecutorService r11 = Executors.newSingleThreadExecutor();
        this.f = r11;
        this.g = new jm.a(this, 10);
        this.f21849a = r5;
        this.f21850b = r10;
        this.f21851c = new p(r5);
        if (this.g != null) goto L10;
        this.g = new jm.a(this, 10);
    L10:
        r11.submit(this.g);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // i8.a
    public final void a() {
        ((b) this.f21851c.f23312b).mo1705a();
    }

    @Override // i8.a
    public final void b() {
        Intent r5 = new Intent();     // Catch: Throwable -> L4
        r5.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r5.setComponent(new ComponentName(this.f21849a, WsClientService.class));     // Catch: Throwable -> L4
        r5.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(((ConcurrentHashMap) this.f21850b.f17503c).values()));     // Catch: Throwable -> L4
        ((b) this.f21851c.f23312b).d(r5);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // i8.a
    public final void c(WsChannelMsg r10, boolean r11) {
        ComponentName r5 = r10.f4010i;
        if (r5 == null) goto L30;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r10.f4009h != null) goto L9;
        r10.f4009h = new byte[1];     // Catch: Throwable -> L7
    L9:
        byte[] r12 = r10.f4009h;     // Catch: Throwable -> L7
        if (r12 != null) goto L12;
        r12 = new byte[1];     // Catch: Throwable -> L7
    L12:
        Intent r13 = new Intent();     // Catch: Throwable -> L7
        r13.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L7
        r13.setComponent(r5);     // Catch: Throwable -> L7
        r13.putExtra(WsConstants.KEY_SEND_RESULT, r11);     // Catch: Throwable -> L7
        String r14 = null;
        if (r12.length == 0) goto L18;
        MessageDigest r15 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L7 Exception -> L25
        r15.update(r12);     // Catch: Throwable -> L7 Exception -> L25
        r14 = com.bytedance.common.utility.b.c(r15.digest());     // Catch: Throwable -> L7 Exception -> L25
    L18:
        r13.putExtra(WsConstants.KEY_PAYLOAD_MD5, r14);     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L21;
        Logger.d("WsChannelService", "send result = " + r11 + " payloadMd5 = " + r13.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L7
    L21:
        this.f21849a.startService(r13);     // Catch: Throwable -> L7
        return;
    }

    @Override // i8.a
    public final void d(SocketState r5) {
        ((ConcurrentHashMap) this.f21850b.f17503c).put(Integer.valueOf(r5.d), r5);
        Intent r10 = new Intent();     // Catch: Throwable -> L5
        r10.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L5
        r10.setComponent(new ComponentName(this.f21849a, WsClientService.class));     // Catch: Throwable -> L5
        r10.putExtra(WsConstants.KEY_CONNECTION, r5);     // Catch: Throwable -> L5
        ((b) this.f21851c.f23312b).d(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // i8.a
    public final void e(i8.b r5, int r10, JSONObject r11) {
        if (r11 == null) goto L19;
        r11.put(WsConstants.KEY_CHANNEL_ID, r10);     // Catch: JSONException -> L6
    L8:
        SocketState r12 = SocketState.c(r11);
        d(r12);
        if (((c5.a) g8.g.d(this.f21849a).f17073b).b(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false) == false) goto L13;
        a r13 = this.d;
        r13.getClass();
        r13.f21835a.post(new v(28, r13, r5));
    L13:
        if (Logger.debug() == false) goto L18;
        Logger.d("WsChannelService", "onConnection: state=" + r12.f3997b + " | type=" + r12.f3996a + " | error=" + r12.f);
        return;
    L18:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // i8.a
    public final void f(int r5, byte[] r10) {
        if (r10 == null) goto L21;
        i r11 = new i();     // Catch: Throwable -> L8
        r11.f21855a = r5;     // Catch: Throwable -> L8
        r11.f21856b = r10;     // Catch: Throwable -> L8
        this.e.offer(r11);     // Catch: Throwable -> L8
        f21848h.getAndSet(true);     // Catch: Throwable -> L8
        if (this.g != null) goto L19;
        this.g = new jm.a(this, 10);     // Catch: Throwable -> L8
    L19:
        this.f.submit(this.g);     // Catch: Throwable -> L12
    L22:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final void g(i r10) {
        i4.a r5 = this.f21850b;
        Context r11 = this.f21849a;
        if (r10 == null) goto L55;
        byte[] r12 = r10.f21856b;
        if (r12 == null) goto L60;
    L11:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L41;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L41:
        th.printStackTrace();
        return;
    L9:
        if (Logger.debug() == false) goto L13;
        Logger.d("WsChannelService", "data = " + t8.a.b(r12) + " data.length = " + r12.length);     // Catch: Throwable -> L11
    L13:
        WsChannelMsg r13 = n8.a.f20211a.a(r12);     // Catch: Throwable -> L11
        if (r13 == WsChannelMsg.f4005k) goto L56;
        r13.f4011j = r10.f21855a;     // Catch: Throwable -> L11
        r13.f4010i = new ComponentName(r11, WsChannelService.class);     // Catch: Throwable -> L11
        if (Logger.debug() == false) goto L19;
        Logger.d("WsChannelService", "version =  seqId = " + r13.f4006a + " logId = " + r13.f4007b + " wsChannelMsg = " + r13.toString());     // Catch: Throwable -> L11
    L19:
        ConcurrentHashMap r14 = (ConcurrentHashMap) r5.d;     // Catch: Throwable -> L11
        if (r14 != null) goto L22;
        return;
    L22:
        if (r14.size() <= 0) goto L58;
        Iterator r15 = ((ConcurrentHashMap) r5.d).entrySet().iterator();     // Catch: Throwable -> L11
    L25:
        if (r15.hasNext() == false) goto L61;
        IWsApp r16 = (IWsApp) ((Map.Entry) r15.next()).getValue();     // Catch: Throwable -> L11
        if (r16 == null) goto L25;
        if (((SsWsApp) r16).f4000b != r13.f4011j) goto L25;
        Intent r17 = new Intent();     // Catch: Throwable -> L35
        r17.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L35
        r17.setComponent(new ComponentName(r11, WsClientService.class));     // Catch: Throwable -> L35
        r17.putExtra("payload", r13);     // Catch: Throwable -> L35
        ((b) this.f21851c.f23312b).d(r17);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        goto L25
    L61:
        return;
    L58:
        return;
    L56:
        return;
    L60:
        return;
    }

    @Override // i8.a
    public final void b(String r5, JSONObject r10) {
        r10.put(WsConstants.KEY_PROGRESS, r5);     // Catch: Throwable -> L5
        Intent r11 = new Intent();     // Catch: Throwable -> L5
        r11.setAction(WsConstants.RECEIVE_PROGRESS_ACTION);     // Catch: Throwable -> L5
        r11.setComponent(new ComponentName(this.f21849a, WsClientService.class));     // Catch: Throwable -> L5
        r11.putExtra(WsConstants.KEY_PROGRESS, r10.toString());     // Catch: Throwable -> L5
        ((b) this.f21851c.f23312b).d(r11);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
