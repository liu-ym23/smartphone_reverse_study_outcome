package s8;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.ui.image.v;
import com.lynx.tasm.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f21835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f21836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f21837c;
    public final f d;
    public final i8.a e;
    public final i4.a f;
    public final AtomicLong g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f21838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21839i;

    public a(Context r5, Looper r10, f r11, i4.a r12, i8.a r13, e r14) {
        this.f21837c = new Object();
        this.g = new AtomicLong(0);
        this.f21839i = false;
        this.f21836b = r5.getApplicationContext();
        WeakHandler r15 = new WeakHandler(r10, this);
        this.f21835a = r15;
        this.d = r11;
        this.f = r12;
        this.e = r13;
        this.f21838h = r14;
        r14.a(this);
        r15.post(new v(26, this, r14));
    }

    public final void a(int r5, String r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
        r11.put(WsConstants.KEY_LP_CONNECT_STATUS, r5);     // Catch: Exception -> L4
        this.e.b(r10, r11);     // Catch: Exception -> L4
        return;
    }

    public final void b(IWsApp r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r5 = WsChannelService.f4020c;
        if (r10 != null) goto L8;
        int r11 = Integer.MIN_VALUE;
    L10:
        if (this.f21838h.isEnable() == false) goto L39;
        IWsChannelClient r12 = (IWsChannelClient) ((ConcurrentHashMap) this.f.f17502b).get(Integer.valueOf(((SsWsApp) r10).f4000b));     // Catch: Throwable -> L26
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L26
        IWsApp r13 = (IWsApp) ((ConcurrentHashMap) this.f.d).get(Integer.valueOf(r11));     // Catch: Throwable -> L20
        if (r12 != null) goto L16;
    L28:
        if (r12 != null) goto L30;
        a(1, WsConstants.LP_CM_DOONPARAMECHANGE_CLIENT_NULL);     // Catch: Throwable -> L20
    L31:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L20
        return;
    L30:
        a(0, WsConstants.LP_CM_DOONPARAMECHANGE_HAS_CONNECT);     // Catch: Throwable -> L20
        goto L31
    L16:
        if (r10.equals(r13) == true) goto L18;
    L22:
        ((ConcurrentHashMap) this.f.d).put(Integer.valueOf(r11), r10);     // Catch: Throwable -> L20
        this.d.e((ConcurrentHashMap) this.f.d);     // Catch: Throwable -> L20
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L20
        r12.onParameterChange(f(r10), ((SsWsApp) r10).f3999a);     // Catch: Throwable -> L26
        a(99, WsConstants.LP_CM_DOONPARAMECHANGE_CHANGE);     // Catch: Throwable -> L26
        return;
    L18:
        if (r12.isConnected() == false) goto L22;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        return;
    L39:
        return;
    L8:
        r11 = ((SsWsApp) r10).f4000b;
        goto L10
    }

    public final void c(boolean r5) {
        if (r5 == false) goto L33;
        Map r10 = this.d.a();
        if (this.f21838h.isEnable() == false) goto L46;
        if (r10 == null) goto L47;
        Iterator r11 = r10.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L48;
        IWsApp r12 = (IWsApp) r11.next();
        if (r12 == null) goto L8;
        e(r12);
        a(98, WsConstants.LP_CM_TRYCONNECT_DOREGISTER);
        goto L8
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L33:
        Object r13 = this.f21837c;     // Catch: Throwable -> L27
        monitor-enter(r13);     // Catch: Throwable -> L27
        Iterator r14 = ((ConcurrentHashMap) this.f.f17502b).entrySet().iterator();     // Catch: Throwable -> L21
    L17:
        if (r14.hasNext() == false) goto L23;
        IWsChannelClient r15 = (IWsChannelClient) ((Map.Entry) r14.next()).getValue();     // Catch: Throwable -> L21
        if (r15 == null) goto L17;
        r15.destroy();     // Catch: Throwable -> L21
        goto L17
    L23:
        ((ConcurrentHashMap) this.f.f17502b).clear();     // Catch: Throwable -> L21
        monitor-exit(r13);     // Catch: Throwable -> L21
        ((ConcurrentHashMap) this.f.d).clear();     // Catch: Throwable -> L27
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    }

    public final byte[] d() {
        HashMap r5 = new HashMap();
        byte[] r10 = new byte[0];
        if (this.f21839i == false) goto L5;
        String r11 = "0";
    L6:
        r5.put("IsBackground", r11);
        ArrayList r12 = new ArrayList();
        Iterator r13 = r5.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        WsChannelMsg.MsgHeader r15 = new WsChannelMsg.MsgHeader();
        r15.f4012a = (String) r14.getKey();
        r15.f4013b = (String) r14.getValue();
        r12.add(r15);
        goto L8
    L10:
        WsChannelMsg r16 = new WsChannelMsg();
        r16.f4011j = Integer.MAX_VALUE;
        r16.f4006a = 0;
        r16.f4007b = 1008601;
        r16.f4008c = 9000;
        r16.d = 4;
        r16.e = r12;
        r16.f = "pb";
        r16.g = "pb";
        r16.f4009h = r10;
        r16.f4010i = null;
        return n8.a.f20211a.b(r16);
    L5:
        r11 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        goto L6
    }

    public final void e(IWsApp r10) {
        int r5 = WsChannelService.f4020c;
        if (r10 != null) goto L5;
        int r11 = Integer.MIN_VALUE;
    L6:
        int r12 = 1;
        if (this.f21838h.isEnable() == true) goto L11;
        a(1, WsConstants.LP_CM_DOREGISTERCHANNEL_DISABLE);
        return;
    L11:
        monitor-enter(WsChannelService.class);
        IWsApp r13 = (IWsApp) ((ConcurrentHashMap) this.f.d).get(Integer.valueOf(r11));     // Catch: Throwable -> L19
        IWsChannelClient r14 = (IWsChannelClient) ((ConcurrentHashMap) this.f.f17502b).get(Integer.valueOf(r11));     // Catch: Throwable -> L19
        if (r13 != null) goto L15;
    L21:
        if (r13 != null) goto L24;
        ((ConcurrentHashMap) this.f.d).put(Integer.valueOf(r11), r10);     // Catch: Throwable -> L19
        this.d.e((ConcurrentHashMap) this.f.d);     // Catch: Throwable -> L19
    L23:
        boolean r15 = true;
        boolean r16 = false;
    L25:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L19
        if (r15 == true) goto L28;
        if (r16 == false) goto L65;
        b(r10);
        return;
    L65:
        a(0, WsConstants.LP_CM_DOREGISTERCHANNEL_HAS_CONNECT);
        return;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d("WsChannelService", "tryOpenConnection");
    L30:
        Object r17 = this.f21837c;
        monitor-enter(r17);
        IWsChannelClient r18 = (IWsChannelClient) ((ConcurrentHashMap) this.f.f17502b).get(Integer.valueOf(((SsWsApp) r10).f4000b));     // Catch: Throwable -> L35
        if (r18 != null) goto L37;
        i8.b r19 = new i8.b(((SsWsApp) r10).f4000b, this.e, this.f21835a);     // Catch: Throwable -> L35
        r19.init(this.f21836b, r19);     // Catch: Throwable -> L35
        ((ConcurrentHashMap) this.f.f17502b).put(Integer.valueOf(((SsWsApp) r10).f4000b), r19);     // Catch: Throwable -> L35
        r18 = r19;
    L37:
        monitor-exit(r17);     // Catch: Throwable -> L35
        if (r18.isConnected() == false) goto L76;
        SocketState r20 = (SocketState) ((ConcurrentHashMap) this.f.f17503c).get(Integer.valueOf(((SsWsApp) r10).f4000b));
        Logger.d("WsChannelService", "state = " + r20);
        if (r20 == null) goto L78;
        this.e.d(r20);     // Catch: Throwable -> L69
        int r21 = r20.f3997b;     // Catch: Throwable -> L69
        if (2 != r21) goto L46;
    L49:
        a(r12, WsConstants.LP_CM_TRYOPENCONNECTION_HAS_CONNECT);     // Catch: Throwable -> L69
        return;
    L46:
        if (4 != r21) goto L48;
        r12 = 0;
        goto L49
    L48:
        r12 = 99;
    L81:
        return;
    L78:
        return;
    L76:
    L54:
        th = move-exception;
        th.printStackTrace();
        return;
    L52:
        if (Logger.debug() == false) goto L56;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + ((SsWsApp) r10).f4000b);     // Catch: Throwable -> L54
    L56:
        r18.openConnection(f(r10), ((SsWsApp) r10).f3999a);     // Catch: Throwable -> L54
        a(99, WsConstants.LP_CM_TRYOPENCONNECTION_OPEN);     // Catch: Throwable -> L54
        return;
    L35:
        th = move-exception;
        throw th;
    L24:
        r16 = true;
        r15 = false;
        goto L25
    L15:
        if (r10.equals(r13) == false) goto L21;
        if (r14 == null) goto L23;
        r15 = false;
        r16 = false;
    L19:
        th = move-exception;
        throw th;
    L5:
        r11 = ((SsWsApp) r10).f4000b;
        goto L6
    }

    public final HashMap f(IWsApp r13) {
        HashMap r5 = new HashMap();
        SsWsApp r14 = (SsWsApp) r13;
        r5.put(WsConstants.KEY_APP_KEY, r14.f4004j);
        td.e.f(r14.f4003i, r5, WsConstants.KEY_FPID, 2, WsConstants.KEY_SDK_VERSION);
        r5.put(WsConstants.KEY_PLATFORM, 0);
        r5.put("app_version", Integer.valueOf(r14.g));
        r5.put(WsConstants.KEY_APP_ID, Integer.valueOf(r14.d));
        r5.put(WsConstants.KEY_DEVICE_ID, r14.e);
        r5.put(WsConstants.KEY_INSTALL_ID, r14.f);
        r5.put(WsConstants.KEY_CHANNEL_ID, Integer.valueOf(r14.f4000b));
        String r10 = r14.f4001c;
        Context r11 = this.f21836b;
        if (r10 != null) goto L6;
        Bundle r12 = new Bundle();
        r12.putString("param_name", "extra");
        r8.a.a(r11, "wschannel_param_null", r12);
        r10 = "";
    L6:
        if (((c5.a) g8.g.d(r11).f17073b).b(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false) == false) goto L17;
        String[] r15 = r10.split("&");
        if (this.f21839i == false) goto L10;
        String r16 = "0";
    L11:
        String r17 = "is_background=".concat(r16);
        if (r15.length > 0) goto L14;
    L16:
        r10 = r17;
        goto L17
    L14:
        if (TextUtils.isEmpty(r15[0]) == true) goto L16;
        r10 = k.j(r10, "&", r17);
        goto L17
    L10:
        r16 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L17:
        r5.put("extra", r10);
        if (r14.e != null) goto L21;
        Bundle r18 = new Bundle();
        r18.putString("param_name", WsConstants.KEY_DEVICE_ID);
        r8.a.a(r11, "wschannel_param_null", r18);
    L21:
        if (r14.f != null) goto L24;
        Bundle r19 = new Bundle();
        r19.putString("param_name", "install_id");
        r8.a.a(r11, "wschannel_param_null", r19);
    L24:
        if (com.bytedance.common.utility.b.b(r14.f4004j) == false) goto L26;
        Bundle r110 = new Bundle();
        r110.putString("param_name", WsConstants.KEY_APP_KEY);
        r8.a.a(r11, "wschannel_param_null", r110);
    L26:
        return r5;
    }
}
