package com.obric.matrix.opush.d.g;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.mpaas.app.AppInfo;
import com.obric.matrix.ws_api.IWs;
import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.u;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002J&\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\bH\u0002J \u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\rH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0002J(\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020-H\u0016J\u001a\u00100\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\u001aH\u0002J\u001a\u00102\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u00103\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020-H\u0002J\u0010\u00104\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020-H\u0002J\u0010\u00105\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020-H\u0002J(\u00106\u001a\u0002072\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002J(\u0010:\u001a\u0002072\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002J\"\u0010<\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0018\u0010?\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0016J&\u0010@\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010A\u001a\u00020\b2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\u0014H\u0002J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010G\u001a\u00020\u001fH\u0016J0\u0010H\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J\"\u0010I\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010J\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J(\u0010K\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010L\u001a\u00020M2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\bH\u0002J(\u0010N\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010L\u001a\u00020M2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\bH\u0002J(\u0010O\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010L\u001a\u00020M2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\u000bH\u0016J\u0010\u0010S\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010T\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020VH\u0002J\u0018\u0010W\u001a\u00020\u001f2\u0006\u0010X\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020-H\u0002J\u0010\u0010Z\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010[\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\f\u0010\\\u001a\u00020\u0014*\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/obric/matrix/opush/base/message/PushMsgHandlerService;", "Lcom/obric/matrix/opush/base/message/IPushMsgHandleService;", "()V", "TAG", "", "TAG_PICO_TO_OCEAN", "crossProcessServiceByUser", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/matrix/push/common/cross_process/CrossProcessService;", "lastDeDuplicationTimestamp", "", "pendingReceiptIdsByListId", "", "buildFallbackReceiptContext", "Lcom/obric/matrix/opush/base/message/ReceiptContext;", "msgId", "buildReceipt", "Lkotlin/Pair;", "Lcom/obric/matrix/opush/base/message/ReceiptInfo;", "Lcom/obric/matrix/o/push/Receipt;", "message", "Lcom/obric/matrix/o/push/Message;", "receiptCode", "receiptContext", "checkMessageValid", "Lcom/obric/matrix/o/push/PushMessageBody;", "createUserHandle", "Landroid/os/UserHandle;", "userId", "dispatchOfflineMessages", "", "offlineMessages", "flushPendingReceipts", "getContextForUser", "Landroid/content/Context;", "context", "Landroid/app/Application;", "pkgName", "dispatchType", "getCrossProcessServiceForUser", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessService;", "handleExpiredHistoryMsg", "handleIncomingPushMessage", "messageBytes", "", "handleMessage", "payloadType", "handleNotification", "pushMessageBody", "handlePassThrough", "handlePong", "handleReceiptAck", "handleReceiptListAck", "isPassThoughSupportBinder", "", "targetPkg", "action", "isPassThoughSupportProvider", "authority", "onHandlePushClick", "intent", "Landroid/content/Intent;", "onHandlePushShow", "onReceivePushEvent", "sentResultCode", WsConstants.KEY_EXTRA, "persistAndSend", "receiptInfo", "receipt", "persistArriveReceiptInline", "resendPendingReceipts", "sendBroadcastByUser", "sendClickReceipt", "sendDeleteReceipt", "sendMessageByBinder", "transparentMsg", "Lcom/obric/matrix/o/push/TransData;", "sendMessageByBroadcast", "sendMessageByProvider", "sendNotificationDisabledReceipt", "sendPing", "heartbeatCount", "sendReceipt", "sendReceiptListToWs", "receiptList", "Lcom/obric/matrix/o/push/ReceiptList;", "sendReceiptToWs", "receiptId", WsConstants.KEY_PAYLOAD, "sendRepeatReceipt", "sendShowReceipt", "toReceipt", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e implements com.obric.matrix.opush.d.g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, com.obric.matrix.push.n.b.a> f9314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<String>> f9315e;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/opush/base/message/PushMsgHandlerService$checkMessageValid$1", "Lcom/obric/matrix/opush/base/network/IRequestCallback;", "onResult", "", "ec", "", NotificationCompat.CATEGORY_MESSAGE, "", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.opush.base.network.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f9316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.v.a.g f9317b;

        a(e r1, com.obric.matrix.v.a.g r2) {
            this.f9316a = r1;
            this.f9317b = r2;
        }

        @Override // com.obric.matrix.opush.base.network.b
        public void onResult(int r5, String r6) {
            com.obric.matrix.opush.c.f9247a.h(e.n(this.f9316a), "unregisterAppToken, ec= " + r5 + ", msg= " + r6);
            if (r5 != 0) goto L6;
            com.obric.matrix.opush.d.e.b r7 = com.obric.matrix.opush.d.b.f9251a.d();
            String r4 = this.f9317b.o;
            kotlin.n0.d.o.e(r4, "message.pkg_name");
            r7.d(r4);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/o/push/Message;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<com.obric.matrix.v.a.g, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f9318f = null;

        static {
            f9318f = new b();
        }

        b() {
            super(1);
        }

        public final CharSequence a(com.obric.matrix.v.a.g r1) {
            kotlin.n0.d.o.f(r1, "it");
            String r0 = r1.m;
            kotlin.n0.d.o.e(r0, "it.msg_id");
            return r0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(com.obric.matrix.v.a.g r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f9319f;

        c(e r1) {
            this.f9319f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long r0 = System.currentTimeMillis();
            com.obric.matrix.opush.d.g.b.f9305a.a(r0 - ((long) com.obric.matrix.opush.f.b.G.i()));
            e.p(this.f9319f, r0);
            com.obric.matrix.opush.d.b.f9251a.u().a().a(r0);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f9320f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<com.obric.matrix.v.a.g> f9321g;

        d(e r1, List<com.obric.matrix.v.a.g> r2) {
            this.f9320f = r1;
            this.f9321g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            e.l(this.f9320f, this.f9321g);
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.opush.d.g.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0250e extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f9322f;

        C0250e(String r1) {
            this.f9322f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.opush.d.g.h.f9360a.a(this.f9322f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<String> f9323f;

        f(List<String> r1) {
            this.f9323f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Iterator<T> r2 = this.f9323f.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            String r0 = (String) r2.next();
            com.obric.matrix.opush.d.g.h.f9360a.a(r0);
            goto L4
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f9324f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9325g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Intent f9326h;

        g(String r1, String r2, Intent r3) {
            this.f9324f = r1;
            this.f9325g = r2;
            this.f9326h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.opush.d.b r0 = com.obric.matrix.opush.d.b.f9251a;
            r0.c().a(this.f9324f, this.f9325g);
            r0.s().a(this.f9324f, this.f9325g, this.f9326h);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class h extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f9327f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9328g;

        h(String r1, String r2) {
            this.f9327f = r1;
            this.f9328g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.opush.d.b r0 = com.obric.matrix.opush.d.b.f9251a;
            r0.c().c(this.f9327f, this.f9328g);
            r0.s().b(this.f9327f, this.f9328g);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class i extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f9329f;

        i(e r1) {
            this.f9329f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            e.m(this.f9329f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class j extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.opush.d.g.f f9330f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9331g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f9332h;

        j(com.obric.matrix.opush.d.g.f r1, e r2, String r3) {
            this.f9330f = r1;
            this.f9331g = r2;
            this.f9332h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.opush.d.g.f r0 = this.f9330f;     // Catch: Throwable -> L10
            if (r0 != null) goto L5;
            r0 = e.i(this.f9331g, this.f9332h);     // Catch: Throwable -> L10
        L5:
            u r1 = e.k(this.f9331g, r0, com.obric.matrix.opush.f.b.G.l());     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            return;
        L8:
            com.obric.matrix.opush.d.g.i r2 = (com.obric.matrix.opush.d.g.i) r1.a();     // Catch: Throwable -> L10
            com.obric.matrix.v.a.k r3 = (com.obric.matrix.v.a.k) r1.b();     // Catch: Throwable -> L10
            e.o(this.f9331g, r2, r3);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            com.obric.matrix.opush.c.f9247a.d(e.n(this.f9331g), "sendClickReceipt error", th);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class k extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.opush.d.g.f f9333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9334g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f9335h;

        k(com.obric.matrix.opush.d.g.f r1, e r2, String r3) {
            this.f9333f = r1;
            this.f9334g = r2;
            this.f9335h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.opush.d.g.f r0 = this.f9333f;     // Catch: Throwable -> L10
            if (r0 != null) goto L5;
            r0 = e.i(this.f9334g, this.f9335h);     // Catch: Throwable -> L10
        L5:
            u r1 = e.k(this.f9334g, r0, com.obric.matrix.opush.f.b.G.m());     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            return;
        L8:
            com.obric.matrix.opush.d.g.i r2 = (com.obric.matrix.opush.d.g.i) r1.a();     // Catch: Throwable -> L10
            com.obric.matrix.v.a.k r3 = (com.obric.matrix.v.a.k) r1.b();     // Catch: Throwable -> L10
            e.o(this.f9334g, r2, r3);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            com.obric.matrix.opush.c.f9247a.d(e.n(this.f9334g), "sendDeleteReceipt error", th);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class l extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f9336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.v.a.g f9337g;

        l(e r1, com.obric.matrix.v.a.g r2) {
            this.f9336f = r1;
            this.f9337g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            u r0 = e.j(this.f9336f, this.f9337g, com.obric.matrix.opush.f.b.G.n());     // Catch: Throwable -> L7
            if (r0 != null) goto L5;
            return;
        L5:
            com.obric.matrix.opush.d.g.i r1 = (com.obric.matrix.opush.d.g.i) r0.a();     // Catch: Throwable -> L7
            com.obric.matrix.v.a.k r2 = (com.obric.matrix.v.a.k) r0.b();     // Catch: Throwable -> L7
            e.o(this.f9336f, r1, r2);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            com.obric.matrix.opush.c.f9247a.d(e.n(this.f9336f), "sendNotificationDisabledReceipt error", th);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class m extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f9338f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.opush.d.g.i f9339g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.v.a.k f9340h;

        m(e r1, com.obric.matrix.opush.d.g.i r2, com.obric.matrix.v.a.k r3) {
            this.f9338f = r1;
            this.f9339g = r2;
            this.f9340h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            e.o(this.f9338f, this.f9339g, this.f9340h);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/o/push/Receipt;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class n extends kotlin.n0.d.q implements kotlin.n0.c.l<com.obric.matrix.v.a.k, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final n f9341f = null;

        static {
            f9341f = new n();
        }

        n() {
            super(1);
        }

        public final CharSequence a(com.obric.matrix.v.a.k r1) {
            String r0 = r1.f10122l;
            kotlin.n0.d.o.e(r0, "it.receipt_id");
            return r0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(com.obric.matrix.v.a.k r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/o/push/Receipt;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class o extends kotlin.n0.d.q implements kotlin.n0.c.l<com.obric.matrix.v.a.k, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final o f9342f = null;

        static {
            f9342f = new o();
        }

        o() {
            super(1);
        }

        public final CharSequence a(com.obric.matrix.v.a.k r1) {
            String r0 = r1.f10121k;
            kotlin.n0.d.o.e(r0, "it.msg_id");
            return r0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(com.obric.matrix.v.a.k r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/o/push/Receipt;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class p extends kotlin.n0.d.q implements kotlin.n0.c.l<com.obric.matrix.v.a.k, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final p f9343f = null;

        static {
            f9343f = new p();
        }

        p() {
            super(1);
        }

        public final CharSequence a(com.obric.matrix.v.a.k r1) {
            String r0 = r1.f10122l;
            kotlin.n0.d.o.e(r0, "it.receipt_id");
            return r0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(com.obric.matrix.v.a.k r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class q extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f9344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.v.a.g f9345g;

        q(e r1, com.obric.matrix.v.a.g r2) {
            this.f9344f = r1;
            this.f9345g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            u r0 = e.j(this.f9344f, this.f9345g, com.obric.matrix.opush.f.b.G.o());     // Catch: Throwable -> L7
            if (r0 != null) goto L5;
            return;
        L5:
            com.obric.matrix.opush.d.g.i r1 = (com.obric.matrix.opush.d.g.i) r0.a();     // Catch: Throwable -> L7
            com.obric.matrix.v.a.k r2 = (com.obric.matrix.v.a.k) r0.b();     // Catch: Throwable -> L7
            e.o(this.f9344f, r1, r2);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            com.obric.matrix.opush.c.f9247a.d(e.n(this.f9344f), "sendRepeatReceipt error", th);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class r extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.opush.d.g.f f9346f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9347g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f9348h;

        r(com.obric.matrix.opush.d.g.f r1, e r2, String r3) {
            this.f9346f = r1;
            this.f9347g = r2;
            this.f9348h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.opush.d.g.f r0 = this.f9346f;     // Catch: Throwable -> L10
            if (r0 != null) goto L5;
            r0 = e.i(this.f9347g, this.f9348h);     // Catch: Throwable -> L10
        L5:
            u r1 = e.k(this.f9347g, r0, com.obric.matrix.opush.f.b.G.p());     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            return;
        L8:
            com.obric.matrix.opush.d.g.i r2 = (com.obric.matrix.opush.d.g.i) r1.a();     // Catch: Throwable -> L10
            com.obric.matrix.v.a.k r3 = (com.obric.matrix.v.a.k) r1.b();     // Catch: Throwable -> L10
            e.o(this.f9347g, r2, r3);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            com.obric.matrix.opush.c.f9247a.d(e.n(this.f9347g), "sendShowReceipt error", th);
        }
    }

    public e() {
        this.f9312b = "PushMsgHandleService";
        this.f9313c = "PicoToOcean";
        this.f9314d = new ConcurrentHashMap();
        this.f9315e = new ConcurrentHashMap();
    }

    private final void A(com.obric.matrix.v.a.g r1) {
        U(r1);
        C(r1);
    }

    private final void B(byte[] r2) {
        ProtoAdapter<com.obric.matrix.v.a.g> r0 = com.obric.matrix.v.a.g.t;
        if (r0 == null) goto L5;
        com.obric.matrix.v.a.g r3 = r0.decode(r2);
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        A(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void C(com.obric.matrix.v.a.g r10) {
        u<com.obric.matrix.v.a.g, com.obric.matrix.v.a.j> r11 = t(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        com.obric.matrix.v.a.g r0 = r11.c();
        com.obric.matrix.v.a.j r12 = r11.d();
        Integer r1 = r0.q;
        if (r1 == null) goto L12;
        if (r1.intValue() != 2) goto L12;
        D(r0, r12);
        return;
    L12:
        if (r1 != null) goto L15;
    L17:
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "handleMessage error, msg_type is not Notification or PassThrough, [" + r0.q + ']', null, 4, null);
        return;
    L15:
        if (r1.intValue() != 1) goto L17;
        E(r0, r12);
    }

    private final void D(com.obric.matrix.v.a.g r14, com.obric.matrix.v.a.j r15) {
        if (r15 == null) goto L4;
        com.obric.matrix.v.a.h r0 = r15.f10112a;
    L5:
        if (r0 != null) goto L8;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "handleNotification error, msg_body is not Notification", null, 4, null);
        return;
    L8:
        com.obric.matrix.opush.c r7 = com.obric.matrix.opush.c.f9247a;
        r7.h(this.f9312b, "handleNotification, msg_id= " + r14.m + ", pkg_name= " + r14.o);
        if (kotlin.n0.d.o.a(r15.f10115d, this.f9313c) == false) goto L11;
    L16:
        com.obric.matrix.opush.d.b r16 = com.obric.matrix.opush.d.b.f9251a;
        com.obric.matrix.opush.d.h.a r2 = r16.q();
        String r3 = r14.o;
        kotlin.n0.d.o.e(r3, "message.pkg_name");
        if (r2.a(r3) == true) goto L20;
        r7.h(this.f9312b, "handleNotification skip show, notifications disabled, msg_id=" + r14.m + ", pkg_name=" + r14.o);
        T(r14);
        return;
    L20:
        r16.q().b(r14, r0);
        return;
    L11:
        if (r0.f10110d.f10047b == true) goto L16;
        com.obric.matrix.opush.d.e.b r17 = com.obric.matrix.opush.d.b.f9251a.d();
        String r4 = r14.o;
        kotlin.n0.d.o.e(r4, "message.pkg_name");
        if (r17.c(r4) == true) goto L16;
        com.obric.matrix.opush.c.e(r7, this.f9312b, "handleNotification error, lack of token", null, 4, null);
        M(this, r14, com.obric.matrix.opush.f.b.G.x(), null, 4, null);
        return;
    L4:
        r0 = null;
        goto L5
    }

    private final void E(com.obric.matrix.v.a.g r10, com.obric.matrix.v.a.j r11) {
        if (r11 == null) goto L4;
        com.obric.matrix.v.a.o r0 = r11.f10113b;
    L5:
        if (r0 != null) goto L8;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "handlePassThrough error, msg_body is not TransparentMsg", null, 4, null);
        return;
    L8:
        int r1 = r0.f10174b;
        Integer r2 = r10.n;
        if (r2 != null) goto L11;
        int r3 = 0;
    L12:
        com.obric.matrix.opush.c r4 = com.obric.matrix.opush.c.f9247a;
        r4.h(this.f9312b, "handlePassThrough, msg_id= " + r10.m + ", pkg_name= " + r10.o + " method= " + r1 + " userId=" + r3);
        if (kotlin.n0.d.o.a(r11.f10115d, this.f9313c) == true) goto L18;
        com.obric.matrix.opush.d.e.b r12 = com.obric.matrix.opush.d.b.f9251a.d();
        String r5 = r10.o;
        kotlin.n0.d.o.e(r5, "message.pkg_name");
        if (r12.c(r5) == true) goto L18;
        com.obric.matrix.opush.c.e(r4, this.f9312b, "handlePassThrough error, lack of token", null, 4, null);
        M(this, r10, com.obric.matrix.opush.f.b.G.x(), null, 4, null);
        return;
    L18:
        Application r13 = com.bytedance.mpaas.app.a.b();
        if (r1 != 0) goto L21;
        kotlin.n0.d.o.e(r13, "context");
        R(r10, r0, r13, r3);
        return;
    L21:
        if (r1 != 1) goto L23;
        kotlin.n0.d.o.e(r13, "context");
        String r6 = r10.o;
        kotlin.n0.d.o.e(r6, "message.pkg_name");
        if (J(r13, r6, r10.o + ".push.provider", r3) == false) goto L36;
        S(r13, r10, r0, r3);
        return;
    L36:
        return;
    L23:
        if (r1 == 2) goto L26;
        com.obric.matrix.opush.c.e(r4, this.f9312b, "handlePassThrough error, method is not 0, 1, 2, [" + r1 + ']', null, 4, null);
        return;
    L26:
        kotlin.n0.d.o.e(r13, "context");
        String r7 = r10.o;
        kotlin.n0.d.o.e(r7, "message.pkg_name");
        if (I(r13, r7, r10.o + ".action.CROSS_PROCESS", r3) == false) goto L34;
        Q(r10, r0, r13, r3);
        return;
    L34:
        return;
    L11:
        r3 = r2.intValue();
        goto L12
    L4:
        r0 = null;
        goto L5
    }

    private final void F(byte[] r8) {
        com.obric.matrix.opush.c r0 = com.obric.matrix.opush.c.f9247a;     // Catch: Throwable -> L25
        r0.h(this.f9312b, "handlePong");     // Catch: Throwable -> L25
        ProtoAdapter<com.obric.matrix.v.a.f> r1 = com.obric.matrix.v.a.f.f10075l;     // Catch: Throwable -> L25
        Long r2 = null;
        if (r1 == null) goto L5;
        com.obric.matrix.v.a.f r9 = r1.decode(r8);     // Catch: Throwable -> L25
    L6:
        if (r9 != null) goto L8;
        return;
    L8:
        List<com.obric.matrix.v.a.g> r3 = r9.f10081k;     // Catch: Throwable -> L25
        if (r3 != null) goto L12;
        r3 = kotlin.i0.r.g();     // Catch: Throwable -> L25
    L12:
        if ((!r3.isEmpty()) == false) goto L14;
        r0.h(this.f9312b, "handlePong, offlineMessageCount= " + r3.size());     // Catch: Throwable -> L25
        com.obric.matrix.opush.g.h.f9431a.c(new d(this, r3));     // Catch: Throwable -> L25
    L14:
        com.obric.matrix.v.a.i r10 = (com.obric.matrix.v.a.i) com.obric.matrix.r.e.e.a(new String(r9.f10080j.E(), kotlin.u0.d.f21429a), com.obric.matrix.v.a.i.class);     // Catch: Throwable -> L25
        IWs r4 = (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);     // Catch: Throwable -> L25
        if (r4 == null) goto L20;
        if (r10 == null) goto L18;
        long r5 = r10.a();     // Catch: Throwable -> L25
    L19:
        r4.onPondReceive(r5);     // Catch: Throwable -> L25
        goto L20
    L18:
        r5 = 0;
    L20:
        String r6 = this.f9312b;     // Catch: Throwable -> L25
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L25
        r7.append("handlePong, heartbeatCount= ");     // Catch: Throwable -> L25
        if (r10 == null) goto L23;
        r2 = Long.valueOf(r10.a());     // Catch: Throwable -> L25
    L23:
        r7.append(r2);     // Catch: Throwable -> L25
        r7.append(", offlineMessageCount= ");     // Catch: Throwable -> L25
        r7.append(r3.size());     // Catch: Throwable -> L25
        r0.h(r6, r7.toString());     // Catch: Throwable -> L25
        return;
    L5:
        r9 = null;
    L25:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "handlePong error", th);
    }

    private final void G(byte[] r5) {
        ProtoAdapter<com.obric.matrix.v.a.l> r0 = com.obric.matrix.v.a.l.m;     // Catch: Throwable -> L13
        if (r0 == null) goto L5;
        com.obric.matrix.v.a.l r6 = r0.decode(r5);     // Catch: Throwable -> L13
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        String r7 = r6.f10141l;     // Catch: Throwable -> L13
        if (r7 != null) goto L11;
        return;
    L11:
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "handleReceiptAck, receipt_id= " + r7);     // Catch: Throwable -> L13
        com.obric.matrix.opush.g.h.f9431a.c(new C0250e(r7));     // Catch: Throwable -> L13
        return;
    L5:
        r6 = null;
    L13:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "handleReceiptAck error", th);
    }

    private final void H(byte[] r7) {
        ProtoAdapter<com.obric.matrix.v.a.n> r0 = com.obric.matrix.v.a.n.f10162k;     // Catch: Throwable -> L20
        if (r0 == null) goto L5;
        com.obric.matrix.v.a.n r8 = r0.decode(r7);     // Catch: Throwable -> L20
    L6:
        if (r8 != null) goto L8;
        return;
    L8:
        String r9 = r8.f10167j;     // Catch: Throwable -> L20
        if (r9 != null) goto L11;
        return;
    L11:
        com.obric.matrix.opush.c r1 = com.obric.matrix.opush.c.f9247a;     // Catch: Throwable -> L20
        r1.h(this.f9312b, "handleReceiptListAck, receipt_list_id= " + r9);     // Catch: Throwable -> L20
        List<String> r2 = this.f9315e.remove(r9);     // Catch: Throwable -> L20
        if (r2 != null) goto L15;
        r2 = kotlin.i0.r.g();     // Catch: Throwable -> L20
    L15:
        if (r2.isEmpty() == false) goto L18;
        com.obric.matrix.opush.c.j(r1, this.f9312b, "handleReceiptListAck, no pending receipts mapped, receipt_list_id= " + r9, null, 4, null);     // Catch: Throwable -> L20
        return;
    L18:
        com.obric.matrix.opush.g.h.f9431a.c(new f(r2));     // Catch: Throwable -> L20
        return;
    L5:
        r8 = null;
    L20:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "handleReceiptListAck error", th);
    }

    private final boolean I(Application r7, String r8, String r9, int r10) {
        PackageManager r11 = x(r7, r10, "", r8, "binder_support").getPackageManager();     // Catch: Throwable -> L4
        Intent r12 = new Intent();     // Catch: Throwable -> L4
        r12.setPackage(r8);     // Catch: Throwable -> L4
        r12.setAction(r9);     // Catch: Throwable -> L4
        List<ResolveInfo> r13 = r11.queryIntentServices(r12, 131072);     // Catch: Throwable -> L4
        kotlin.n0.d.o.e(r13, "mPkg.queryIntentServices…PackageManager.MATCH_ALL)");     // Catch: Throwable -> L4
        return !r13.isEmpty();
    L4:
        th = move-exception;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "pass though support service error: " + th, null, 4, null);
        return false;
    }

    private final boolean J(Application r8, String r9, String r10, int r11) {
        ProviderInfo[] r12 = x(r8, r11, "", r9, "provider_support").getPackageManager().getPackageInfo(r9, 8).providers;     // Catch: Throwable -> L9
        kotlin.n0.d.o.e(r12, "mPackageInfo.providers");     // Catch: Throwable -> L9
        int r13 = r12.length;     // Catch: Throwable -> L9
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L17;
        if (kotlin.n0.d.o.a(r12[r14].authority, r10) == true) goto L16;
        r14 = r14 + 1;
        goto L4
    L16:
        return true;
    L17:
        return false;
    L9:
        th = move-exception;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "pass though support provider error: " + th, null, 4, null);
        return false;
    }

    public static /* synthetic */ com.obric.matrix.push.n.b.a K(e r0, Application r1, int r2, String r3, String r4, Integer r5) {
        return z(r0, r1, r2, r3, r4, r5);
    }

    private final void L(com.obric.matrix.v.a.g r3, int r4, String r5) {
        com.obric.matrix.opush.d.d.b r2 = com.obric.matrix.opush.d.b.f9251a.c();
        String r0 = r3.m;
        kotlin.n0.d.o.e(r0, "message.msg_id");
        String r6 = r3.o;
        kotlin.n0.d.o.e(r6, "message.pkg_name");
        r2.d(r0, r6, r4, r5);
    }

    static /* synthetic */ void M(e r0, com.obric.matrix.v.a.g r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = com.obric.matrix.opush.f.b.G.y();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.L(r1, r2, r3);
    }

    private final void N(com.obric.matrix.opush.d.g.i r2, com.obric.matrix.v.a.k r3) {
        com.obric.matrix.opush.d.g.h.f9360a.c(r2);
        W(r2.i(), r3.encode());
    }

    private final void O(com.obric.matrix.v.a.g r11) {
        u<com.obric.matrix.opush.d.g.i, com.obric.matrix.v.a.k> r0 = r(r11, com.obric.matrix.opush.f.b.G.k());     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "persistArriveReceiptInline failed, build arrive receipt failed, msg_id=" + r11.m + ", app_id=" + r11.f10092j + ", pkg_name=" + r11.o + ", req_id=" + r11.f10094l + ", push_token=" + r11.f10093k, null, 4, null);     // Catch: Throwable -> L11
        return;
    L7:
        com.obric.matrix.opush.d.g.i r12 = r0.a();     // Catch: Throwable -> L11
        if (com.obric.matrix.opush.d.g.h.f9360a.c(r12) >= 0) goto L15;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "persistArriveReceiptInline failed, insert receipt db failed, receipt_id=" + r12.i() + ", receipt_code=" + r12.h() + ", msg_id=" + r12.f() + ", app_id=" + r12.a() + ", req_id=" + r12.k() + ", push_token=" + r12.g() + ", session_id=" + r12.m() + ", did=" + r12.d() + ", req_ts=" + r12.l(), null, 4, null);     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L11:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "persistArriveReceiptInline error", th);
    }

    private final void P(Application r9, Intent r10, int r11, String r12, String r13) {
        if (r11 > 0) goto L13;
        r9.sendBroadcast(r10);
        return;
    L13:
        v.a r0 = v.f21457g;     // Catch: Throwable -> L7
        Object r1 = Context.class.getMethod("sendBroadcastAsUser", new Class[]{Intent.class, UserHandle.class}).invoke(r9, new Object[]{r10, u(r11)});     // Catch: Throwable -> L7
        v.b(r1);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = v.d(r1);
        if (r2 == null) goto L15;
        com.obric.matrix.opush.c.f9247a.i(this.f9312b, "sendBroadcastAsUser failed, fallback to sendBroadcast, msgId=" + r12 + " pkgName=" + r13 + " userId=" + r11 + " dispatchType=broadcast", r2);
        r9.sendBroadcast(r10);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        v.a r3 = v.f21457g;
        r1 = w.a(th);
        v.b(r1);
        goto L9
    }

    private final void Q(com.obric.matrix.v.a.g r6, com.obric.matrix.v.a.o r7, Application r8, int r9) {
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "pass though msg by binder, userId=" + r9);     // Catch: Throwable -> L5
        ArrayList<Object> r1 = new ArrayList();     // Catch: Throwable -> L5
        r1.add(r6.m);     // Catch: Throwable -> L5
        r1.add(r7.f10173a);     // Catch: Throwable -> L5
        r1.add(Integer.valueOf(r9));     // Catch: Throwable -> L5
        String r10 = r6.m;     // Catch: Throwable -> L5
        kotlin.n0.d.o.e(r10, "message.msg_id");     // Catch: Throwable -> L5
        String r2 = r6.o;     // Catch: Throwable -> L5
        kotlin.n0.d.o.e(r2, "message.pkg_name");     // Catch: Throwable -> L5
        com.obric.matrix.push.n.b.d.c r11 = y(r8, r9, r10, r2);     // Catch: Throwable -> L5
        String r12 = r6.o;     // Catch: Throwable -> L5
        kotlin.n0.d.o.e(r12, "message.pkg_name");     // Catch: Throwable -> L5
        r11.b(r12, ".action.MESSAGE_EVENT", r1, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "pass though aidl error: ", th);
    }

    private final void R(com.obric.matrix.v.a.g r10, com.obric.matrix.v.a.o r11, Application r12, int r13) {
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "pass though msg by broadcast, userId=" + r13);     // Catch: Throwable -> L4
        Intent r5 = new Intent();     // Catch: Throwable -> L4
        r5.setPackage(r10.o);     // Catch: Throwable -> L4
        r5.setAction(r10.o + ".action.MESSAGE_EVENT");     // Catch: Throwable -> L4
        r5.putExtra("pass_though_data", r11.f10173a);     // Catch: Throwable -> L4
        r5.putExtra("msg_id", r10.m);     // Catch: Throwable -> L4
        r5.putExtra("user_id", r13);     // Catch: Throwable -> L4
        String r7 = r10.m;     // Catch: Throwable -> L4
        kotlin.n0.d.o.e(r7, "message.msg_id");     // Catch: Throwable -> L4
        String r8 = r10.o;     // Catch: Throwable -> L4
        kotlin.n0.d.o.e(r8, "message.pkg_name");     // Catch: Throwable -> L4
        P(r12, r5, r13, r7, r8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "pass though broadcast error: ", th);
    }

    private final void S(Application r8, com.obric.matrix.v.a.g r9, com.obric.matrix.v.a.o r10, int r11) {
        ContentProviderClient r0 = null;
        String r4 = r9.m;     // Catch: Throwable -> L6
        kotlin.n0.d.o.e(r4, "message.msg_id");     // Catch: Throwable -> L6
        String r5 = r9.o;     // Catch: Throwable -> L6
        kotlin.n0.d.o.e(r5, "message.pkg_name");     // Catch: Throwable -> L6
        Context r12 = x(r8, r11, r4, r5, "provider");     // Catch: Throwable -> L6
        Uri r1 = Uri.parse("content://" + r9.o + ".push.provider");     // Catch: Throwable -> L6
        kotlin.n0.d.o.e(r1, "parse(this)");     // Catch: Throwable -> L6
        r0 = r12.getContentResolver().acquireUnstableContentProviderClient(r1);     // Catch: Throwable -> L6
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "pass though msg by provider, userId=" + r11);     // Catch: Throwable -> L6
        ContentResolver r13 = r12.getContentResolver();     // Catch: Throwable -> L6
        Bundle r6 = new Bundle();     // Catch: Throwable -> L6
        r6.putString("msg_id", r9.m);     // Catch: Throwable -> L6
        r6.putString("pass_though_data", r10.f10173a);     // Catch: Throwable -> L6
        r6.putInt("user_id", r11);     // Catch: Throwable -> L6
        f0 r14 = f0.f18324a;     // Catch: Throwable -> L6
        r13.call(r1, ".action.MESSAGE_EVENT", "", r6);     // Catch: Throwable -> L6
        if (r0 == null) goto L10;
    L5:
        r0.close();
        return;
    L10:
        return;
    L6:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "pass though provider error: ", th);     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
        return;
    L11:
        th = move-exception;
        if (r0 == null) goto L14;
        r0.close();
    L14:
        throw th;
    }

    private final void U(com.obric.matrix.v.a.g r4) {
        u<com.obric.matrix.opush.d.g.i, com.obric.matrix.v.a.k> r5 = r(r4, com.obric.matrix.opush.f.b.G.k());     // Catch: Throwable -> L7
        if (r5 != null) goto L5;
        return;
    L5:
        com.obric.matrix.opush.d.g.i r0 = r5.a();     // Catch: Throwable -> L7
        com.obric.matrix.v.a.k r6 = r5.b();     // Catch: Throwable -> L7
        com.obric.matrix.opush.g.h.f9431a.c(new m(this, r0, r6));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "sendReceipt error", th);
    }

    private final void V(com.obric.matrix.v.a.m r20) {
        com.obric.matrix.base.env.d r2 = com.obric.matrix.base.env.d.f8838a;     // Catch: Throwable -> L26
        if (r2.e() == false) goto L6;
        int r3 = 16778981;
    L7:
        WsChannelMsg.b r5 = WsChannelMsg.b.c(1);     // Catch: Throwable -> L26
        r5.j(r3);     // Catch: Throwable -> L26
        r5.e(1);     // Catch: Throwable -> L26
        r5.h("7");     // Catch: Throwable -> L26
        r5.f(r20.encode());     // Catch: Throwable -> L26
        WsChannelMsg r4 = r5.b();     // Catch: Throwable -> L26
        IWs r6 = (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);     // Catch: Throwable -> L26
        int r7 = 0;
        String r8 = null;
        if (r6 != null) goto L21;
        com.obric.matrix.opush.c r9 = com.obric.matrix.opush.c.f9247a;     // Catch: Throwable -> L26
        String r10 = this.f9312b;     // Catch: Throwable -> L26
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L26
        r11.append("sendReceiptListToWs failed, IWs service is null, receipt_list_id=");     // Catch: Throwable -> L26
        r11.append(r20.f10154j);     // Catch: Throwable -> L26
        r11.append(", payload_type=7, service_id=");     // Catch: Throwable -> L26
        r11.append(r3);     // Catch: Throwable -> L26
        r11.append(", is_boe=");     // Catch: Throwable -> L26
        r11.append(r2.e());     // Catch: Throwable -> L26
        r11.append(", count=");     // Catch: Throwable -> L26
        List<com.obric.matrix.v.a.k> r12 = r20.f10155k;     // Catch: Throwable -> L26
        if (r12 == null) goto L12;
        r7 = r12.size();     // Catch: Throwable -> L26
    L12:
        r11.append(r7);     // Catch: Throwable -> L26
        r11.append(", receipt_ids=");     // Catch: Throwable -> L26
        List<com.obric.matrix.v.a.k> r13 = r20.f10155k;     // Catch: Throwable -> L26
        if (r13 == null) goto L15;
        String r14 = kotlin.i0.r.Z(r13, null, null, null, 0, null, n.f9341f, 31, null);     // Catch: Throwable -> L26
    L16:
        r11.append(r14);     // Catch: Throwable -> L26
        r11.append(", msg_ids=");     // Catch: Throwable -> L26
        List<com.obric.matrix.v.a.k> r15 = r20.f10155k;     // Catch: Throwable -> L26
        if (r15 == null) goto L19;
        r8 = kotlin.i0.r.Z(r15, null, null, null, 0, null, o.f9342f, 31, null);     // Catch: Throwable -> L26
    L19:
        r11.append(r8);     // Catch: Throwable -> L26
        com.obric.matrix.opush.c.e(r9, r10, r11.toString(), null, 4, null);     // Catch: Throwable -> L26
        return;
    L15:
        r14 = null;
        goto L16
    L21:
        r6.sendWsMessage(r4, null);     // Catch: Throwable -> L26
        com.obric.matrix.opush.c r16 = com.obric.matrix.opush.c.f9247a;     // Catch: Throwable -> L26
        String r17 = this.f9312b;     // Catch: Throwable -> L26
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L26
        r18.append("sendReceiptListToWs success, count= ");     // Catch: Throwable -> L26
        List<com.obric.matrix.v.a.k> r19 = r20.f10155k;     // Catch: Throwable -> L26
        if (r19 == null) goto L24;
        r7 = r19.size();     // Catch: Throwable -> L26
    L24:
        r18.append(r7);     // Catch: Throwable -> L26
        r18.append(" receipt_list_id=");     // Catch: Throwable -> L26
        r18.append(r20.f10154j);     // Catch: Throwable -> L26
        r16.h(r17, r18.toString());     // Catch: Throwable -> L26
        String r21 = this.f9312b;     // Catch: Throwable -> L26
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L26
        r22.append("sendReceiptListToWs success, receiptList= ");     // Catch: Throwable -> L26
        List<com.obric.matrix.v.a.k> r23 = r20.f10155k;     // Catch: Throwable -> L26
        kotlin.n0.d.o.e(r23, "receiptList.receipt_list");     // Catch: Throwable -> L26
        r22.append(kotlin.i0.r.Z(r23, null, null, null, 0, null, p.f9343f, 31, null));     // Catch: Throwable -> L26
        r16.h(r21, r22.toString());     // Catch: Throwable -> L26
        return;
    L6:
        r3 = 33555625;
    L26:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "sendReceiptListToWs error", th);
    }

    private final void W(String r11, byte[] r12) {
        com.obric.matrix.base.env.d r0 = com.obric.matrix.base.env.d.f8838a;     // Catch: Throwable -> L12
        if (r0.e() == false) goto L5;
        int r1 = 16778981;
    L6:
        WsChannelMsg.b r3 = WsChannelMsg.b.c(1);     // Catch: Throwable -> L12
        r3.j(r1);     // Catch: Throwable -> L12
        r3.e(1);     // Catch: Throwable -> L12
        r3.h("4");     // Catch: Throwable -> L12
        r3.f(r12);     // Catch: Throwable -> L12
        WsChannelMsg r2 = r3.b();     // Catch: Throwable -> L12
        IWs r4 = (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);     // Catch: Throwable -> L12
        if (r4 != null) goto L10;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "sendReceiptToWs failed, IWs service is null, receipt_id=" + r11 + ", payload_type=4, payload_size=" + r12.length + ", service_id=" + r1 + ", is_boe=" + r0.e(), null, 4, null);     // Catch: Throwable -> L12
        return;
    L10:
        r4.sendWsMessage(r2, null);     // Catch: Throwable -> L12
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "sendReceiptToWs success, receipt_id= " + r11);     // Catch: Throwable -> L12
        return;
    L5:
        r1 = 33555625;
    L12:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "sendReceiptToWs error", th);
    }

    private final void X(com.obric.matrix.v.a.g r3) {
        com.obric.matrix.opush.g.h.f9431a.c(new q(this, r3));
    }

    private final com.obric.matrix.v.a.k Y(com.obric.matrix.opush.d.g.i r3) {
        com.obric.matrix.v.a.k.a r2 = new com.obric.matrix.v.a.k.a();
        r2.q(Integer.valueOf(r3.p()));
        r2.f(r3.e());
        r2.e(r3.d());
        r2.n(Long.valueOf(r3.m()));
        r2.a(Integer.valueOf(r3.a()));
        r2.g(r3.f());
        r2.j(r3.i());
        r2.i(Integer.valueOf(r3.h()));
        r2.k(r3.j());
        r2.l(r3.k());
        r2.h(r3.g());
        r2.o(r3.n());
        r2.p(Long.valueOf(r3.o()));
        r2.m(Long.valueOf(r3.l()));
        r2.c(r3.b());
        r2.d(r3.c());
        com.obric.matrix.v.a.k r4 = r2.b();
        kotlin.n0.d.o.e(r4, "Builder()\n            .v…del)\n            .build()");
        return r4;
    }

    public static final /* synthetic */ com.obric.matrix.opush.d.g.f i(e r0, String r1) {
        return r0.q(r1);
    }

    public static final /* synthetic */ u j(e r0, com.obric.matrix.v.a.g r1, int r2) {
        return r0.r(r1, r2);
    }

    public static final /* synthetic */ u k(e r0, com.obric.matrix.opush.d.g.f r1, int r2) {
        return r0.s(r1, r2);
    }

    public static final /* synthetic */ void l(e r0, List r1) {
        r0.v(r1);
    }

    public static final /* synthetic */ void m(e r0) {
        r0.w();
    }

    public static final /* synthetic */ String n(e r0) {
        return r0.f9312b;
    }

    public static final /* synthetic */ void o(e r0, com.obric.matrix.opush.d.g.i r1, com.obric.matrix.v.a.k r2) {
        r0.N(r1, r2);
    }

    public static final /* synthetic */ void p(e r0, long r1) {
        r0.f9311a = r1;
    }

    private final com.obric.matrix.opush.d.g.f q(String r17) {
        String r0 = com.obric.matrix.ostracker_api.b.c();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return new com.obric.matrix.opush.d.g.f(0, null, r0, 0, 0, r17, null, null, null, 0, 987, null);
    }

    private final u<com.obric.matrix.opush.d.g.i, com.obric.matrix.v.a.k> r(com.obric.matrix.v.a.g r2, int r3) {
        com.obric.matrix.opush.d.g.f r4 = com.obric.matrix.opush.d.g.g.f9359a.c(r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return s(r4, r3);
    }

    private final u<com.obric.matrix.opush.d.g.i, com.obric.matrix.v.a.k> s(com.obric.matrix.opush.d.g.f r34, int r35) {
        String r4 = r34.d();
        com.obric.matrix.opush.f.b r0 = com.obric.matrix.opush.f.b.G;
        String r2 = "arrive";
        if (r35 != r0.k()) goto L6;
    L20:
        String r3 = r4 + '-' + r2;
        String r5 = "";
        if (r35 != r0.n()) goto L23;
        String r12 = r0.q();
    L24:
        int r6 = r34.j();
        String r7 = r34.c();
        String r1 = r34.b();
        if (r1.length() != 0) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == false) goto L34;
        String r9 = com.obric.matrix.ostracker_api.b.c();
        if (r9 == null) goto L33;
        r5 = r9;
    L33:
        String r10 = r5;
    L35:
        long r11 = r34.h();
        int r13 = r34.a();
        String r15 = r34.e();
        String r14 = r34.f();
        String r16 = r34.i();
        long r22 = System.currentTimeMillis();
        long r25 = r34.g();
        String r17 = AppInfo.getInstatnce().getVersionCode().toString();
        String r18 = com.obric.matrix.opush.g.d.f9428a.a();
        com.obric.matrix.v.a.k.a r19 = new com.obric.matrix.v.a.k.a();
        r19.q(Integer.valueOf(r6));
        r19.f(r7);
        r19.e(r10);
        r19.n(Long.valueOf(r11));
        r19.a(Integer.valueOf(r13));
        r19.g(r4);
        r19.j(r3);
        r19.i(Integer.valueOf(r35));
        r19.k(r12);
        r19.l(r14);
        r19.h(r15);
        r19.o(r16);
        r19.p(Long.valueOf(r22));
        r19.m(Long.valueOf(r25));
        r19.c(r17);
        r19.d(r18);
        return a0.a(new com.obric.matrix.opush.d.g.i(0, r3, r4, r13, r6, r7, r10, r11, r35, r12, r14, r15, r16, r22, r25, r17, r18, 1, null), r19.b());
    L34:
        r10 = r1;
        goto L35
    L27:
        r8 = false;
        goto L28
    L23:
        r12 = "";
        goto L24
    L6:
        if (r35 != r0.p()) goto L9;
        r2 = "show";
        goto L20
    L9:
        if (r35 != r0.l()) goto L12;
        r2 = "click";
        goto L20
    L12:
        if (r35 != r0.m()) goto L15;
        r2 = "delete";
        goto L20
    L15:
        if (r35 != r0.n()) goto L18;
        r2 = "disabled";
        goto L20
    L18:
        if (r35 != r0.o()) goto L20;
        r2 = "repeat";
        goto L20
    }

    private final u<com.obric.matrix.v.a.g, com.obric.matrix.v.a.j> t(com.obric.matrix.v.a.g r17) {
        Integer r0 = r17.f10088f;
        if (r0 != null) goto L6;
    L7:
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, this.f9312b, "checkMessageValid error, version is not 1, [" + r17.f10088f + " msg_id=" + r17.m + ']', null, 4, null);
        return null;
    L6:
        if (r0.intValue() != 1) goto L7;
        com.obric.matrix.opush.c r10 = com.obric.matrix.opush.c.f9247a;
        r10.h(this.f9312b, "checkMessageValid, msg_id= " + r17.m + ", pkg_name= " + r17.o + " req_id=" + r17.f10094l);
        com.obric.matrix.opush.g.e r1 = com.obric.matrix.opush.g.e.f9429a;
        k.h r2 = r17.r;
        if (r2 == null) goto L12;
        byte[] r3 = r2.E();
    L13:
        com.obric.matrix.v.a.j r4 = (com.obric.matrix.v.a.j) com.obric.matrix.r.e.e.a(new String(r1.a(r3), kotlin.u0.d.f21429a), com.obric.matrix.v.a.j.class);
        com.obric.matrix.opush.g.d r5 = com.obric.matrix.opush.g.d.f9428a;
        String r6 = r17.o;
        kotlin.n0.d.o.e(r6, "message.pkg_name");
        if (r5.h(r6) == true) goto L18;
        com.obric.matrix.opush.c.e(r10, this.f9312b, "checkMessageValid error, target pkg no exists, [" + r17.o + ']', null, 4, null);
        M(this, r17, com.obric.matrix.opush.f.b.G.w(), null, 4, null);
        com.obric.matrix.opush.d.i.a r7 = com.obric.matrix.opush.d.b.f9251a.t();
        String r8 = r17.o;
        kotlin.n0.d.o.e(r8, "message.pkg_name");
        r7.a(r8, r17.f10093k, new a(this, r17));
        return null;
    L18:
        if (r4 == null) goto L20;
        String r9 = r4.f10115d;
    L22:
        if (kotlin.n0.d.o.a(r9, this.f9313c) == true) goto L35;
        com.obric.matrix.opush.g.b r11 = com.obric.matrix.opush.g.b.f9424a;
        Context r12 = com.bytedance.mpaas.app.a.a();
        String r13 = r17.o;
        kotlin.n0.d.o.e(r13, "message.pkg_name");
        String r14 = r11.c(r12, r13);
        if (kotlin.n0.d.o.a(r17.p, r14) == true) goto L35;
        int r15 = com.obric.matrix.opush.f.b.G.v();
        v.a r16 = v.f21457g;     // Catch: Throwable -> L28
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L28
        r18.put("message_cert", r17.p);     // Catch: Throwable -> L28
        r18.put("local_cert", r14);     // Catch: Throwable -> L28
        Object r19 = r18.toString();     // Catch: Throwable -> L28
        v.b(r19);     // Catch: Throwable -> L28
    L31:
        if (v.f(r19) == false) goto L33;
        r19 = null;
    L33:
        L(r17, r15, (String) r19);
        return null;
    L28:
        th = move-exception;
        v.a r20 = v.f21457g;
        r19 = w.a(th);
        v.b(r19);
    L35:
        com.obric.matrix.opush.d.g.b r21 = com.obric.matrix.opush.d.g.b.f9305a;
        String r22 = r17.m;
        kotlin.n0.d.o.e(r22, "message.msg_id");
        com.obric.matrix.opush.d.g.c r23 = r21.b(r22);
        if (r23 == null) goto L42;
        r10.b(this.f9312b, "historyMsgInfo is not null for " + r17.m + " , historyMsgInfo.timeStamp is " + r23.a());
        if ((System.currentTimeMillis() - r23.a()) >= com.obric.matrix.opush.f.b.G.i()) goto L41;
        com.obric.matrix.opush.c.e(r10, this.f9312b, "on push repeated:" + r17.m, null, 4, null);
        X(r17);
        com.obric.matrix.opush.d.d.b r24 = com.obric.matrix.opush.d.b.f9251a.c();
        String r25 = r17.m;
        kotlin.n0.d.o.e(r25, "message.msg_id");
        r24.b(r25);
        return null;
    L41:
        r10.b(this.f9312b, "historyMsgInfo is not null for " + r17.m + " , and System.currentTimeMillis() - historyMsgInfo.timeStamp >= PushServiceConstants.MESSAGE_DEDUPLICATION_TIME_WINDOW_IN_MS");
    L42:
        r10.b(this.f9312b, "insert it to db");
        String r26 = r17.m;
        kotlin.n0.d.o.e(r26, "message.msg_id");
        r21.c(r26, System.currentTimeMillis());
        return new u(r17, r4);
    L20:
        r9 = null;
        goto L22
    L12:
        r3 = null;
        goto L13
    }

    private final UserHandle u(int r8) {
        Class<?> r0 = Class.forName("android.os.UserHandle");
        v.a r3 = v.f21457g;     // Catch: Throwable -> L8
        Object r4 = r0.getMethod("of", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(r8)});     // Catch: Throwable -> L8
        if (r4 == null) goto L7;
        Object r5 = (UserHandle) r4;     // Catch: Throwable -> L8
        v.b(r5);     // Catch: Throwable -> L8
    L11:
        if (v.d(r5) == null) goto L15;
        Object r9 = r0.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(r8)});
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.os.UserHandle");
        r5 = (UserHandle) r9;
    L15:
        return (UserHandle) r5;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.os.UserHandle");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        v.a r6 = v.f21457g;
        r5 = w.a(th);
        v.b(r5);
        goto L11
    }

    private final void v(List<com.obric.matrix.v.a.g> r14) {
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "dispatchOfflineMessages, offlineMessages= " + kotlin.i0.r.Z(r14, null, null, null, 0, null, b.f9318f, 31, null));
        Iterator<T> r0 = r14.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.obric.matrix.v.a.g r1 = (com.obric.matrix.v.a.g) r0.next();
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "handlePong, offlineMessageId= " + r1.m);     // Catch: Throwable -> L8
        O(r1);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "handle offline message error, msgId=" + r1.m, th);
        goto L4
    L10:
        w();
        Iterator<T> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        C((com.obric.matrix.v.a.g) r15.next());
        goto L12
    }

    private final void w() {
        List<com.obric.matrix.opush.d.g.i> r0 = com.obric.matrix.opush.d.g.h.f9360a.b();     // Catch: Throwable -> L18
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        com.obric.matrix.opush.c.f9247a.b(this.f9312b, "flushPendingReceipts, count= " + r0.size());     // Catch: Throwable -> L18
        int r1 = com.obric.matrix.opush.f.b.G.j();     // Catch: Throwable -> L18
        int r2 = 0;
    L6:
        if (r2 >= r0.size()) goto L26;
        int r3 = kotlin.r0.e.f(r2 + r1, r0.size());     // Catch: Throwable -> L18
        List<com.obric.matrix.opush.d.g.i> r4 = r0.subList(r2, r3);     // Catch: Throwable -> L18
        com.obric.matrix.opush.d.g.i r5 = (com.obric.matrix.opush.d.g.i) kotlin.i0.r.P(r4);     // Catch: Throwable -> L18
        String r6 = UUID.randomUUID().toString();     // Catch: Throwable -> L18
        kotlin.n0.d.o.e(r6, "randomUUID().toString()");     // Catch: Throwable -> L18
        com.obric.matrix.v.a.m.a r7 = new com.obric.matrix.v.a.m.a();     // Catch: Throwable -> L18
        r7.g(Integer.valueOf(r5.p()));     // Catch: Throwable -> L18
        r7.c(r5.e());     // Catch: Throwable -> L18
        r7.b(r5.d());     // Catch: Throwable -> L18
        r7.f(Long.valueOf(r5.m()));     // Catch: Throwable -> L18
        r7.e(r6);     // Catch: Throwable -> L18
        ArrayList r8 = new ArrayList(kotlin.i0.r.q(r4, 10));     // Catch: Throwable -> L18
        Iterator<T> r9 = r4.iterator();     // Catch: Throwable -> L18
    L10:
        if (r9.hasNext() == false) goto L12;
        r8.add(Y((com.obric.matrix.opush.d.g.i) r9.next()));     // Catch: Throwable -> L18
        goto L10
    L12:
        r7.d(r8);     // Catch: Throwable -> L18
        com.obric.matrix.v.a.m r10 = r7.a();     // Catch: Throwable -> L18
        ConcurrentHashMap<String, List<String>> r11 = this.f9315e;     // Catch: Throwable -> L18
        ArrayList r12 = new ArrayList(kotlin.i0.r.q(r4, 10));     // Catch: Throwable -> L18
        Iterator<T> r13 = r4.iterator();     // Catch: Throwable -> L18
    L14:
        if (r13.hasNext() == false) goto L16;
        r12.add(((com.obric.matrix.opush.d.g.i) r13.next()).i());     // Catch: Throwable -> L18
        goto L14
    L16:
        r11.put(r6, r12);     // Catch: Throwable -> L18
        kotlin.n0.d.o.e(r10, "receiptList");     // Catch: Throwable -> L18
        V(r10);     // Catch: Throwable -> L18
        r2 = r3;
        goto L6
    L26:
        return;
    L18:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d(this.f9312b, "flushPendingReceipts error", th);
    }

    private final Context x(Application r9, int r10, String r11, String r12, String r13) {
        if (r10 > 0) goto L17;
        return r9;
    L17:
        v.a r0 = v.f21457g;     // Catch: Throwable -> L9
        Object r1 = Context.class.getMethod("createContextAsUser", new Class[]{UserHandle.class, Integer.TYPE}).invoke(r9, new Object[]{u(r10), 0});     // Catch: Throwable -> L9
        if (r1 == null) goto L8;
        Object r2 = (Context) r1;     // Catch: Throwable -> L9
        v.b(r2);     // Catch: Throwable -> L9
    L11:
        Throwable r3 = v.d(r2);
        if (r3 != null) goto L14;
        Object r14 = r2;
    L16:
        return (Context) r14;
    L14:
        com.obric.matrix.opush.c.f9247a.i(this.f9312b, "createContextAsUser failed, fallback to current user context, msgId=" + r11 + " pkgName=" + r12 + " userId=" + r10 + " dispatchType=" + r13, r3);
        r14 = r9;
        goto L16
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        v.a r4 = v.f21457g;
        r2 = w.a(th);
        v.b(r2);
        goto L11
    }

    private final com.obric.matrix.push.n.b.d.c y(final Application r10, final int r11, final String r12, final String r13) {
        if (r11 <= 0) goto L4;
        com.obric.matrix.push.n.b.a r9 = this.f9314d.computeIfAbsent(Integer.valueOf(r11), new com.obric.matrix.opush.d.g.a(this, r10, r11, r12, r13));
        kotlin.n0.d.o.e(r9, "crossProcessServiceByUse…(targetContext)\n        }");
        return r9;
    L4:
        return com.obric.matrix.push.n.a.f9741a.a(r10);
    }

    private static final com.obric.matrix.push.n.b.a z(e r7, Application r8, int r9, String r10, String r11, Integer r12) {
        kotlin.n0.d.o.f(r7, "this$0");
        kotlin.n0.d.o.f(r8, "$context");
        kotlin.n0.d.o.f(r10, "$msgId");
        kotlin.n0.d.o.f(r11, "$pkgName");
        kotlin.n0.d.o.f(r12, "it");
        return new com.obric.matrix.push.n.b.a(r7.x(r8, r9, r10, r11, "binder_cache"));
    }

    public void T(com.obric.matrix.v.a.g r3) {
        kotlin.n0.d.o.f(r3, "message");
        com.obric.matrix.opush.g.h.f9431a.c(new l(this, r3));
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void a(String r2, String r3) {
        kotlin.n0.d.o.f(r2, "msgId");
        kotlin.n0.d.o.f(r3, "pkgName");
        com.obric.matrix.opush.g.h.f9431a.c(new h(r2, r3));
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void b() {
        if (this.f9311a != 0) goto L5;
        this.f9311a = com.obric.matrix.opush.d.b.f9251a.u().a().c();
    L5:
        com.obric.matrix.opush.c r0 = com.obric.matrix.opush.c.f9247a;
        r0.b(this.f9312b, "handleExpiredHistoryMsg , lastDeDuplicationTimestamp is " + this.f9311a + " , System.currentTimeMillis() - lastDeDuplicationTimestamp is " + (System.currentTimeMillis() - this.f9311a));
        if ((System.currentTimeMillis() - this.f9311a) < com.obric.matrix.opush.f.b.G.i()) goto L9;
        r0.b(this.f9312b, "handleExpiredHistoryMsg , try delete expired history msg info");
        com.obric.matrix.opush.g.h.f9431a.c(new c(this));
        return;
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void c(String r2, String r3, Intent r4) {
        kotlin.n0.d.o.f(r2, "msgId");
        kotlin.n0.d.o.f(r3, "pkgName");
        com.obric.matrix.opush.g.h.f9431a.c(new g(r2, r3, r4));
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void d(String r3, byte[] r4) {
        kotlin.n0.d.o.f(r3, "payloadType");
        kotlin.n0.d.o.f(r4, "message");
        int r0 = r3.hashCode();
        if (r0 == 51) goto L24;
        if (r0 == 56) goto L20;
        if (r0 == 53) goto L16;
        if (r0 == 54) goto L12;
        return;
    L12:
        if (r3.equals("6") == false) goto L32;
        B(r4);
        return;
    L32:
        return;
    L16:
        if (r3.equals("5") == false) goto L33;
        G(r4);
        return;
    L33:
        return;
    L20:
        if (r3.equals("8") == false) goto L34;
        H(r4);
        return;
    L34:
        return;
    L24:
        if (r3.equals("3") == false) goto L35;
        F(r4);
        return;
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void e(String r2, String r3, com.obric.matrix.opush.d.g.f r4) {
        kotlin.n0.d.o.f(r2, "msgId");
        kotlin.n0.d.o.f(r3, "pkgName");
        com.obric.matrix.opush.g.h.f9431a.c(new j(r4, this, r2));
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void f(String r2, String r3, com.obric.matrix.opush.d.g.f r4) {
        kotlin.n0.d.o.f(r2, "msgId");
        kotlin.n0.d.o.f(r3, "pkgName");
        com.obric.matrix.opush.g.h.f9431a.c(new k(r4, this, r2));
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void g(String r2, String r3, com.obric.matrix.opush.d.g.f r4) {
        kotlin.n0.d.o.f(r2, "msgId");
        kotlin.n0.d.o.f(r3, "pkgName");
        com.obric.matrix.opush.g.h.f9431a.c(new r(r4, this, r2));
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void h() {
        com.obric.matrix.opush.g.h.f9431a.c(new i(this));
    }

    @Override // com.obric.matrix.opush.d.g.d
    public void sendPing(long r5) {
        String r0 = "";
        v.a r1 = v.f21457g;     // Catch: Throwable -> L16
        com.obric.matrix.v.a.e.a r2 = new com.obric.matrix.v.a.e.a();     // Catch: Throwable -> L16
        r2.g(1);     // Catch: Throwable -> L16
        r2.d("");     // Catch: Throwable -> L16
        String r3 = com.obric.matrix.ostracker_api.b.c();     // Catch: Throwable -> L16
        if (r3 == null) goto L7;
        r0 = r3;
    L7:
        r2.c(r0);     // Catch: Throwable -> L16
        r2.e(Long.valueOf(r5));     // Catch: Throwable -> L16
        r2.b(AppInfo.getInstatnce().getVersionCode());     // Catch: Throwable -> L16
        com.obric.matrix.v.a.e r4 = r2.a();     // Catch: Throwable -> L16
        WsChannelMsg.b r6 = WsChannelMsg.b.c(1);     // Catch: Throwable -> L16
        if (com.obric.matrix.base.env.d.f8838a.e() == false) goto L10;
        int r7 = 16778981;
    L11:
        r6.j(r7);     // Catch: Throwable -> L16
        r6.e(1);     // Catch: Throwable -> L16
        r6.h("2");     // Catch: Throwable -> L16
        r6.f(r4.encode());     // Catch: Throwable -> L16
        WsChannelMsg r8 = r6.b();     // Catch: Throwable -> L16
        IWs r9 = (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);     // Catch: Throwable -> L16
        if (r9 == null) goto L14;
        r9.sendWsMessage(r8, null);     // Catch: Throwable -> L16
    L14:
        com.obric.matrix.opush.c.f9247a.h(this.f9312b, "sendPing success, heartbeatCount= " + r5);     // Catch: Throwable -> L16
        v.b(f0.f18324a);     // Catch: Throwable -> L16
        return;
    L10:
        r7 = 33555625;
    L16:
        th = move-exception;
        v.a r10 = v.f21457g;
        v.b(w.a(th));
    }
}
