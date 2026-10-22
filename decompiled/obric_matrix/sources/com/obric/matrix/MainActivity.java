package com.obric.matrix;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.account_api.IAccount;
import com.obric.matrix.account_api.OAccount;
import com.obric.matrix.base.settings.iconfig.IMatrixAuthConfig;
import com.obric.matrix.base.settings.iconfig.IMatrixConfig;
import com.obric.matrix.base.settings.iconfig.IMatrixPlatformSdkConfig;
import com.obric.matrix.base.settings.iconfig.IMatrixSdkConfig;
import com.obric.matrix.base.ui.CommonEmptyActivity;
import com.obric.matrix.location_api.ILocationServiceDebug;
import com.obric.matrix.push_api.IPush;
import com.obric.matrix.ws_api.IWs;
import com.obric.matrix.ws_api.IWsDebug;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J&\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0003J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0011H\u0014J+\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0011H\u0014J\b\u0010-\u001a\u00020\u0011H\u0003J\b\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u0011H\u0002J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\n\u00103\u001a\u0004\u0018\u000104H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/matrix/MainActivity;", "Lcom/obric/matrix/base/ui/CommonEmptyActivity;", "()V", "didListener", "com/obric/matrix/MainActivity$didListener$1", "Lcom/obric/matrix/MainActivity$didListener$1;", "infoTxtView", "Landroid/widget/TextView;", "sdPermissionCheckText", "textViewAccount", "textViewForDid", "textViewForHotFixText", "textViewForSdkSettings", "textViewForSettings", "textViewForWs", "textViewPush", "checkSdPermission", "", "cleanSysBgProcess", "getLastKnownLocationSafely", "Landroid/location/Location;", "locationManager", "Landroid/location/LocationManager;", "provider", "", "initTeaTracker", "locationServiceDebug", "Lcom/obric/matrix/location_api/ILocationServiceDebug;", "logLocationProviderSnapshot", "providers", "", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "requestSystemSingleLocation", "setInfo", "showWsMsgInput", "testLoopException", "wsService", "Lcom/obric/matrix/ws_api/IWs;", "wsServiceDebug", "Lcom/obric/matrix/ws_api/IWsDebug;", "Companion", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"SetTextI18n"})
public final class MainActivity extends CommonEmptyActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f8302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f8303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f8304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f8305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f8306l;
    private TextView m;
    private TextView n;
    private TextView o;
    private final a p;
    private TextView q;
    public Map<Integer, View> r;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/MainActivity$didListener$1", "Lcom/obric/matrix/dataanalysis/DeviceIdManager$DeviceIdListener;", "onDeviceIdReady", "", "deviceId", "", "onInstallIdReady", "installId", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.dataanalysis.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MainActivity f8307a;

        a(MainActivity r1) {
            this.f8307a = r1;
        }

        @Override // com.obric.matrix.dataanalysis.h.b
        public void a(String r1) {
            kotlin.n0.d.o.f(r1, "installId");
        }

        @Override // com.obric.matrix.dataanalysis.h.b
        public void b(String r2) {
            kotlin.n0.d.o.f(r2, "deviceId");
            MainActivity.L(this.f8307a);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8308f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8309g;

        a0(EditText r1, EditText r2) {
            this.f8308f = r1;
            this.f8309g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.g(OAccount.INSTANCE, this.f8308f.getText().toString(), this.f8309g.getText().toString(), null, null, 12, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/MainActivity$initTeaTracker$1", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.matrix.ostracker_api.a {
        b() {
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r2) {
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "the did from the onDeviceIdLoaded callback is " + r2);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r2) {
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "the installId from the onInstallIdLoaded callback is " + r2);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8310f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8311g;

        b0(EditText r1, EditText r2) {
            this.f8310f = r1;
            this.f8311g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.i(OAccount.INSTANCE, this.f8310f.getText().toString(), this.f8311g.getText().toString(), null, null, 12, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8312f;

        c(MainActivity r1) {
            this.f8312f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IWsDebug r4 = MainActivity.P(this.f8312f);
            if (r4 == null) goto L6;
            byte[] r2 = "123".getBytes(kotlin.u0.d.f21429a);
            kotlin.n0.d.o.e(r2, "this as java.lang.String).getBytes(charset)");
            r4.generateWsMsg(20319, 1, r2);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8313f;

        c0(EditText r1) {
            this.f8313f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.a(OAccount.INSTANCE, this.f8313f.getText().toString(), null, null, 6, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8314f;

        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/matrix/MainActivity$onCreate$11$1", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "onWsChannelMsg", "", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "onWsConnectEvent", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements com.obric.matrix.ws_api.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MainActivity f8315a;

            a(MainActivity r1) {
                this.f8315a = r1;
            }

            public static /* synthetic */ void e(MainActivity r0, WsChannelMsg r1) {
                f(r0, r1);
            }

            private static final void f(MainActivity r3, WsChannelMsg r4) {
                kotlin.n0.d.o.f(r3, "this$0");
                kotlin.n0.d.o.f(r4, "$wsChannelMsg");
                TextView r5 = MainActivity.G(r3);
                if (r5 == null) goto L7;
                StringBuilder r0 = new StringBuilder();
                r0.append("收到长链消息：service=");
                r0.append(r4.s());
                r0.append(", payload=");
                byte[] r6 = r4.i();
                kotlin.n0.d.o.e(r6, "wsChannelMsg.payload");
                r0.append(new String(r6, kotlin.u0.d.f21429a));
                r5.setText(r0.toString());
                return;
            }

            @Override // com.obric.matrix.ws_api.a
            public void a(com.bytedance.common.wschannel.r.b r1, JSONObject r2) {
                kotlin.n0.d.o.f(r1, "connectEvent");
            }

            @Override // com.obric.matrix.ws_api.a
            public void b(com.bytedance.common.wschannel.j r1) {
                com.obric.matrix.ws_api.a.C0289a.b(this, r1);
            }

            @Override // com.obric.matrix.ws_api.a
            public void c() {
                com.obric.matrix.ws_api.a.C0289a.a(this);
            }

            @Override // com.obric.matrix.ws_api.a
            public void d(final WsChannelMsg r2) {
                kotlin.n0.d.o.f(r2, "wsChannelMsg");
                final MainActivity r1 = this.f8315a;
                r1.runOnUiThread(new com.obric.matrix.f(r1, r2));
            }
        }

        d(MainActivity r1) {
            this.f8314f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IWs r0 = MainActivity.O(this.f8314f);
            if (r0 == null) goto L5;
            r0.registerListener(new a(this.f8314f));
        L5:
            TextView r3 = MainActivity.G(this.f8314f);
            if (r3 == null) goto L10;
            r3.setText("已注册监听");
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8316f;

        d0(MainActivity r1) {
            this.f8316f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MainActivity.K(this.f8316f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8317f;

        e(MainActivity r1) {
            this.f8317f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TextView r0 = MainActivity.G(this.f8317f);
            if (r0 == null) goto L11;
            StringBuilder r1 = new StringBuilder();
            r1.append("格式：service_method=action \n");
            IWsDebug r3 = MainActivity.P(this.f8317f);
            if (r3 == null) goto L8;
            String r4 = r3.getSubscriber();
        L9:
            r1.append(r4);
            r0.setText(r1.toString());
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8318f;

        e0(MainActivity r1) {
            this.f8318f = r1;
            super(0);
        }

        private static final void a(MainActivity r3) {
            kotlin.n0.d.o.f(r3, "this$0");
            com.obric.matrix.base.env.d.f8838a.h(true, "boe_pico");
            com.obric.matrix.base.env.f.f8844a.i(r3);
        }

        public static /* synthetic */ void b(MainActivity r0) {
            a(r0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final MainActivity r1 = this.f8318f;
            com.bytedance.common.utility.m.c.c(new com.obric.matrix.i(r1));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8319f;

        f(MainActivity r1) {
            this.f8319f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.q.e.a.f9851a.a("WS_MSG_KEVA_REPO");
            IWsDebug r0 = MainActivity.P(this.f8319f);
            if (r0 == null) goto L5;
            r0.clearWsMsgSubscriberIPCCallback();
        L5:
            TextView r1 = MainActivity.G(this.f8319f);
            if (r1 == null) goto L14;
            StringBuilder r2 = new StringBuilder();
            r2.append("格式：service_method=action \n");
            IWsDebug r3 = MainActivity.P(this.f8319f);
            if (r3 == null) goto L11;
            String r4 = r3.getSubscriber();
        L12:
            r2.append(r4);
            r1.setText(r2.toString());
            return;
        L11:
            r4 = null;
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class f0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f0 f8320f = null;

        static {
            f8320f = new f0();
        }

        f0() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.q.f.a.f9854a.a("test_for_initiation", null, null, null);
            com.obric.matrix.ostracker_api.b.g("app_launch_test", new JSONObject());
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "the did from the TeaTrackerManager.getDeviceId() after click the button is " + com.obric.matrix.ostracker_api.b.c());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8321f;

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/MainActivity$onCreate$14$1", "Lcom/obric/matrix/push_api/IPushInterceptor;", "onMessageIntercept", "", "message", "Lcom/obric/matrix/push_api/Message;", "onNotificationIntercept", "notification", "Lcom/obric/matrix/push_api/Notification;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements com.obric.matrix.push_api.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MainActivity f8322a;

            a(MainActivity r1) {
                this.f8322a = r1;
            }

            public static /* synthetic */ void c(MainActivity r0, com.obric.matrix.push_api.d r1) {
                e(r0, r1);
            }

            public static /* synthetic */ void d(MainActivity r0, com.obric.matrix.push_api.e r1) {
                f(r0, r1);
            }

            private static final void e(MainActivity r2, com.obric.matrix.push_api.d r3) {
                kotlin.n0.d.o.f(r2, "this$0");
                kotlin.n0.d.o.f(r3, "$message");
                TextView r4 = MainActivity.H(r2);
                if (r4 == null) goto L7;
                r4.setText(" recv message id = " + r3.f9815a);
                return;
            }

            private static final void f(MainActivity r2, com.obric.matrix.push_api.e r3) {
                kotlin.n0.d.o.f(r2, "this$0");
                kotlin.n0.d.o.f(r3, "$notification");
                TextView r4 = MainActivity.H(r2);
                if (r4 == null) goto L7;
                r4.setText(" recv notification id = " + r3.f9819a);
                return;
            }

            @Override // com.obric.matrix.push_api.b
            public boolean a(final com.obric.matrix.push_api.e r3) {
                kotlin.n0.d.o.f(r3, "notification");
                com.obric.matrix.r.c.c.j("MatrixPush", "Push Notification Intercept, " + r3);
                final MainActivity r2 = this.f8322a;
                r2.runOnUiThread(new com.obric.matrix.h(r2, r3));
                return false;
            }

            @Override // com.obric.matrix.push_api.b
            public boolean b(final com.obric.matrix.push_api.d r3) {
                kotlin.n0.d.o.f(r3, "message");
                com.obric.matrix.r.c.c.j("MatrixPush", "Push Message Intercept, " + r3);
                final MainActivity r2 = this.f8322a;
                r2.runOnUiThread(new com.obric.matrix.g(r2, r3));
                return false;
            }
        }

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/MainActivity$onCreate$14$2", "Lcom/obric/matrix/push_api/IPushShowListener;", "onPushShow", "", "id", "", "pkgName", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b implements com.obric.matrix.push_api.c {
            b() {
            }

            @Override // com.obric.matrix.push_api.c
            public void a(String r1, String r2) {
                kotlin.n0.d.o.f(r1, "id");
                kotlin.n0.d.o.f(r2, "pkgName");
                com.obric.matrix.r.c.c.j("MatrixPush", "Push Show");
            }
        }

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/MainActivity$onCreate$14$3", "Lcom/obric/matrix/push_api/IPushClickListener;", "onPushClick", "", "id", "", "pkgName", "intent", "Landroid/content/Intent;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class c implements com.obric.matrix.push_api.a {
            c() {
            }

            @Override // com.obric.matrix.push_api.a
            public void a(String r1, String r2, Intent r3) {
                kotlin.n0.d.o.f(r1, "id");
                kotlin.n0.d.o.f(r2, "pkgName");
                com.obric.matrix.r.c.c.j("MatrixPush", "Push Click");
            }
        }

        g(MainActivity r1) {
            this.f8321f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).registerPushInterceptor(new a(this.f8321f));
            ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).registerPushShowListener(new b());
            ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).registerPushClickListener(new c());
            Intent r1 = new Intent(this.f8321f, MainActivity.class);
            ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).showNotification(new com.obric.matrix.push_api.e(UUID.randomUUID().toString(), this.f8321f.getPackageName(), "Matrix", "push showNotificaiton method，show small icon", null, 0, null, null, null, ""), r1);
            ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).showNotification(new com.obric.matrix.push_api.e(UUID.randomUUID().toString(), this.f8321f.getPackageName(), "Matrix", "push showNotificaiton method，show large icon", null, 2, null, null, null, ""), r1);
            ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).showNotification(new com.obric.matrix.push_api.e(UUID.randomUUID().toString(), this.f8321f.getPackageName(), "Matrix", "push showNotificaiton method，show badge icon", null, 3, null, null, null, ""), r1);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class g0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8323f;

        g0(MainActivity r1) {
            this.f8323f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TextView r1 = MainActivity.D(this.f8323f);
            if (r1 == null) goto L7;
            r1.setText(new com.obric.matrix.m().a());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class h extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f8324f = null;

        static {
            f8324f = new h();
        }

        h() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.bytedance.news.common.settings.e.g(true);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class h0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8325f;

        h0(MainActivity r1) {
            this.f8325f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TextView r1 = MainActivity.C(this.f8325f);
            if (r1 == null) goto L7;
            r1.setText(com.obric.matrix.ostracker_api.b.c());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class i extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8326f;

        i(MainActivity r1) {
            this.f8326f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Object r0 = com.bytedance.news.common.settings.e.e(IMatrixConfig.class);
            kotlin.n0.d.o.e(r0, "obtain(IMatrixConfig::class.java)");
            IMatrixConfig r1 = (IMatrixConfig) r0;
            String r2 = "matrixConfigStr = " + r1.getMatrixConfigStr() + "<br>autoPollingInterval = " + r1.getMatrixConfig().b() + "<br>npthDefaultAnrCheckInterval = " + r1.getMatrixConfig().c() + "<br>";
            Log.d("Matrix-MainActivity-log", "getSettings matrixConfig = " + r2);
            Object r3 = com.bytedance.news.common.settings.e.e(IMatrixAuthConfig.class);
            kotlin.n0.d.o.e(r3, "obtain(IMatrixAuthConfig::class.java)");
            IMatrixAuthConfig r4 = (IMatrixAuthConfig) r3;
            String r5 = "matrixAuthConfigStr = " + r4.getMatrixAuthConfigStr() + "<br>authPkgWhiteMap = " + r4.getMatrixAuthConfig().f() + "<br>authPkgWhiteMapNew = " + r4.getMatrixAuthConfig().g() + "<br>authCmdGroupMap = " + r4.getMatrixAuthConfig().c() + "<br>authCmdGroupList = " + r4.getMatrixAuthConfig().b() + "<br>authCmdGroupPermissionMap = " + r4.getMatrixAuthConfig().d() + "<br>";
            Log.d("Matrix-MainActivity-log", "getSettings matrixAuthConfig = " + r5);
            Object r6 = com.bytedance.news.common.settings.e.e(IMatrixPlatformSdkConfig.class);
            kotlin.n0.d.o.e(r6, "obtain(IMatrixPlatformSdkConfig::class.java)");
            String r7 = "xrSdkRequiredRomVerMap = " + ((IMatrixPlatformSdkConfig) r6).getMatrixPlatformSdkConfig().b();
            Log.d("Matrix-MainActivity-log", "getSettings matrixPlatformSdkConfig = " + r7);
            String r8 = "\n                <strong>matrixConfig</strong>\n                <br>\n                " + r2 + "\n                <br>\n                <strong>matrixAuthConfig</strong>\n                <br>\n                " + r5 + "\n                <br>\n                <strong>matrixPlatformSdkConfig</strong>\n                <br>\n                " + r7 + "\n                ";
            TextView r9 = MainActivity.F(this.f8326f);
            if (r9 == null) goto L7;
            r9.setText(Html.fromHtml(r8, 0));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class i0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8327f;

        i0(MainActivity r1) {
            this.f8327f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MainActivity.N(this.f8327f);     // Catch: Throwable -> L5
            throw null;
        L5:
            th = move-exception;
            com.obric.matrix.r.c.c.h("testLoopException error ", th);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class j extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8328f;

        j(MainActivity r1) {
            this.f8328f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Object r0 = com.bytedance.news.common.settings.e.e(IMatrixSdkConfig.class);
            kotlin.n0.d.o.e(r0, "obtain(IMatrixSdkConfig::class.java)");
            IMatrixSdkConfig r1 = (IMatrixSdkConfig) r0;
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "all config = " + r1.getMatrixSdkConfigStr() + " \n");
            String r2 = "\n                <strong>all config</strong>\n                <br>\n                " + r1.getMatrixSdkConfigStr() + "\n                <br>\n                ";
            TextView r3 = MainActivity.E(this.f8328f);
            if (r3 == null) goto L7;
            r3.setText(Html.fromHtml(r2, 0));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class j0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8329f;

        j0(MainActivity r1) {
            this.f8329f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MainActivity.M(this.f8329f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class k extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final k f8330f = null;

        static {
            f8330f = new k();
        }

        k() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LinkedHashMap r7 = new LinkedHashMap();
            com.obric.matrix.q.b.a.d(r7);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "test CmdHandlerFinder injectCmdHandler: " + r7);
            LinkedHashMap r8 = new LinkedHashMap();
            LinkedHashMap r1 = new LinkedHashMap();
            ConcurrentHashMap r2 = new ConcurrentHashMap();
            com.obric.matrix.q.b.a.b(r8);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "test cmd2Ifs: " + r8);
            com.obric.matrix.q.b.a.c(r1);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "test cmd2Func: " + r1);
            Iterator r9 = r8.entrySet().iterator();
        L4:
            if (r9.hasNext() == false) goto L8;
            Map.Entry r3 = (Map.Entry) r9.next();
            String r4 = (String) r3.getKey();
            String r5 = (String) r3.getValue();
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init forEach cmd: " + r4);
            Object r6 = Class.forName(r5 + "__ICmdHandlerImplProxy").getMethod("getSingleInstance", new Class[0]).invoke(null, new Object[0]);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init forEach cmdHandlerImpl: " + r6);
            if ((r6 instanceof com.obric.matrix.q.b.d) == false) goto L4;
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init forEach cmdHandlerImpl is ICmdHandler");
            r2.put(Integer.valueOf(Integer.parseInt(r4)), r6);
            goto L4
        L8:
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init cmd2ICmdHandler: " + r2);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class k0 extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8331f;

        k0(MainActivity r1) {
            this.f8331f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ILocationServiceDebug r0 = MainActivity.I(this.f8331f);
            if (r0 == null) goto L6;
            r0.openMockActivity();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class l extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final l f8332f = null;

        static {
            f8332f = new l();
        }

        l() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LinkedHashMap r7 = new LinkedHashMap();
            LinkedHashMap r0 = new LinkedHashMap();
            ConcurrentHashMap r1 = new ConcurrentHashMap();
            com.obric.matrix.q.b.a.b(r7);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "test cmd2Ifs: " + r7);
            com.obric.matrix.q.b.a.c(r0);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "test cmd2Func: " + r0);
            Iterator r8 = r7.entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L8;
            Map.Entry r2 = (Map.Entry) r8.next();
            String r3 = (String) r2.getKey();
            String r4 = (String) r2.getValue();
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init forEach cmd: " + r3);
            Object r5 = Class.forName(r4 + "__ICmdHandlerImplProxy").getMethod("getSingleInstance", new Class[0]).invoke(null, new Object[0]);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init forEach cmdHandlerImpl: " + r5);
            if ((r5 instanceof com.obric.matrix.q.b.d) == false) goto L4;
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init forEach cmdHandlerImpl is ICmdHandler");
            r1.put(Integer.valueOf(Integer.parseInt(r3)), r5);
            goto L4
        L8:
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "init cmd2ICmdHandler: " + r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/MainActivity$requestSystemSingleLocation$1$1", "Landroid/location/LocationListener;", "onLocationChanged", "", LocationMonitorConst.LOCATION, "Landroid/location/Location;", "onProviderDisabled", "provider", "", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class l0 implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f8333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f8334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LocationManager f8335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f8336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f8337e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8338f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<String> f8339g;

        l0(Handler r1, Runnable r2, LocationManager r3, String r4, long r5, MainActivity r7, List<String> r8) {
            this.f8333a = r1;
            this.f8334b = r2;
            this.f8335c = r3;
            this.f8336d = r4;
            this.f8337e = r5;
            this.f8338f = r7;
            this.f8339g = r8;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r6) {
            kotlin.n0.d.o.f(r6, LocationMonitorConst.LOCATION);
            this.f8333a.removeCallbacks(this.f8334b);
            this.f8335c.removeUpdates(this);
            com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "requestSystemSingleLocation success, provider=" + this.f8336d + ", cost=" + (System.currentTimeMillis() - this.f8337e) + "ms, location=" + r6);
            MainActivity r7 = this.f8338f;
            LocationManager r0 = this.f8335c;
            List<String> r1 = this.f8339g;
            StringBuilder r2 = new StringBuilder();
            r2.append("success from ");
            r2.append(this.f8336d);
            MainActivity.J(r7, r0, r1, r2.toString());
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r2) {
            kotlin.n0.d.o.f(r2, "provider");
            com.obric.matrix.r.c.c.s("Matrix-MainActivity-log", "requestSystemSingleLocation onProviderDisabled: " + r2);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class m extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8340f;

        m(MainActivity r1) {
            this.f8340f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MainActivity.A(this.f8340f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class n extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8341f;

        n(MainActivity r1) {
            this.f8341f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TextView r1 = MainActivity.B(this.f8341f);
            if (r1 == null) goto L6;
            r1.setText(OAccount.INSTANCE.getAccountInfo().toString());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class o extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final o f8342f = null;

        static {
            f8342f = new o();
        }

        o() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OAccount.INSTANCE.forceUpdateAccount();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class p extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8343f;

        p(MainActivity r1) {
            this.f8343f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OAccount r0 = OAccount.INSTANCE;
            if (r0.getAccountInfo() != null) goto L5;
        L10:
            r0.login(this.f8343f, null);
            return;
        L5:
            if (r0.getAccountInfo().f() == false) goto L10;
            Intent r1 = new Intent("com.obric.account.action.OBRIC_ACCOUNT_ACTION");     // Catch: Exception -> L8
            r1.setPackage("com.obric.account");     // Catch: Exception -> L8
            r1.putExtra("destination", "account_main");     // Catch: Exception -> L8
            r1.addFlags(268435456);     // Catch: Exception -> L8
            ActivityOptionsCompat r2 = ActivityOptionsCompat.makeCustomAnimation(this.f8343f, android.R.anim.slide_in_left, android.R.anim.slide_out_right);     // Catch: Exception -> L8
            kotlin.n0.d.o.e(r2, "makeCustomAnimation(\n   …ght\n                    )");     // Catch: Exception -> L8
            ContextCompat.startActivity(this.f8343f, r1, r2.toBundle());     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            Toast.makeText(this.f8343f, e.toString(), 0).show();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class q extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8344f;

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ MainActivity f8345f;

            a(MainActivity r1) {
                this.f8345f = r1;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
                invoke2();
                return kotlin.f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(this.f8345f, "登出成功", 0).show();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, kotlin.f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ MainActivity f8346f;

            b(MainActivity r1) {
                this.f8346f = r1;
                super(2);
            }

            public final void a(int r3, String r4) {
                kotlin.n0.d.o.f(r4, "errorMsg");
                Toast.makeText(this.f8346f, "登出失败:(" + r3 + ')' + r4, 0).show();
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ kotlin.f0 invoke(Integer r1, String r2) {
                a(r1.intValue(), r2);
                return kotlin.f0.f18324a;
            }
        }

        q(MainActivity r1) {
            this.f8344f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OAccount.INSTANCE.logout(new a(this.f8344f), new b(this.f8344f));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class r extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8347f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8348g;

        r(EditText r1, EditText r2) {
            this.f8347f = r1;
            this.f8348g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.c(OAccount.INSTANCE, this.f8347f.getText().toString(), this.f8348g.getText().toString(), null, null, 12, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class s extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8349f;

        s(EditText r1) {
            this.f8349f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.f(OAccount.INSTANCE, this.f8349f.getText().toString(), null, null, 6, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class t extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8350f;

        t(EditText r1) {
            this.f8350f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.b(OAccount.INSTANCE, this.f8350f.getText().toString(), null, null, 6, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class u extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8351f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8352g;

        u(EditText r1, EditText r2) {
            this.f8351f = r1;
            this.f8352g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.h(OAccount.INSTANCE, this.f8351f.getText().toString(), this.f8352g.getText().toString(), null, null, 12, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class v extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MainActivity f8353f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8354g;

        v(MainActivity r1, EditText r2) {
            this.f8353f = r1;
            this.f8354g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OAccount r0 = OAccount.INSTANCE;
            String r1 = this.f8353f.getPackageName();
            kotlin.n0.d.o.e(r1, "this.packageName");
            IAccount.a.e(r0, r1, this.f8354g.getText().toString(), 24, null, null, 24, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class w extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8356g;

        w(EditText r1, EditText r2) {
            this.f8355f = r1;
            this.f8356g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OAccount.INSTANCE.quickLogin(this.f8355f.getText().toString(), this.f8356g.getText().toString(), null, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class x extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final x f8357f = null;

        static {
            f8357f = new x();
        }

        x() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.o.f9232a.b();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class y extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8359g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ EditText f8360h;

        y(EditText r1, EditText r2, EditText r3) {
            this.f8358f = r1;
            this.f8359g = r2;
            this.f8360h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            IAccount.a.d(OAccount.INSTANCE, this.f8358f.getText().toString(), this.f8359g.getText().toString(), this.f8360h.getText().toString(), null, null, 24, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class z extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f8361f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8362g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ EditText f8363h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ MainActivity f8364i;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "ticket", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<String, kotlin.f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ EditText f8365f;

            a(EditText r1) {
                this.f8365f = r1;
                super(1);
            }

            public final void a(String r2) {
                kotlin.n0.d.o.f(r2, "ticket");
                this.f8365f.setText(r2);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1) {
                a(r1);
                return kotlin.f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, kotlin.f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ MainActivity f8366f;

            b(MainActivity r1) {
                this.f8366f = r1;
                super(2);
            }

            public final void a(int r2, String r3) {
                Toast.makeText(this.f8366f, r2 + " | " + r3, 0).show();
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ kotlin.f0 invoke(Integer r1, String r2) {
                a(r1.intValue(), r2);
                return kotlin.f0.f18324a;
            }
        }

        z(EditText r1, EditText r2, EditText r3, MainActivity r4) {
            this.f8361f = r1;
            this.f8362g = r2;
            this.f8363h = r3;
            this.f8364i = r4;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.f0 invoke() {
            invoke2();
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OAccount.INSTANCE.verifySmsCode(this.f8361f.getText().toString(), this.f8362g.getText().toString(), 4, new a(this.f8363h), new b(this.f8364i));
        }
    }

    static {
    }

    public MainActivity() {
        this.r = new LinkedHashMap();
        this.p = new a(this);
    }

    public static final /* synthetic */ void A(MainActivity r0) {
        r0.R();
    }

    public static final /* synthetic */ TextView B(MainActivity r0) {
        return r0.o;
    }

    public static final /* synthetic */ TextView C(MainActivity r0) {
        return r0.f8303i;
    }

    public static final /* synthetic */ TextView D(MainActivity r0) {
        return r0.f8302h;
    }

    public static final /* synthetic */ TextView E(MainActivity r0) {
        return r0.f8306l;
    }

    public static final /* synthetic */ TextView F(MainActivity r0) {
        return r0.f8305k;
    }

    public static final /* synthetic */ TextView G(MainActivity r0) {
        return r0.f8304j;
    }

    public static final /* synthetic */ TextView H(MainActivity r0) {
        return r0.n;
    }

    public static final /* synthetic */ ILocationServiceDebug I(MainActivity r0) {
        return r0.a0();
    }

    public static final /* synthetic */ void J(MainActivity r0, LocationManager r1, List r2, String r3) {
        r0.b0(r1, r2, r3);
    }

    public static final /* synthetic */ void K(MainActivity r0) {
        r0.d0();
    }

    public static final /* synthetic */ void L(MainActivity r0) {
        r0.f0();
    }

    public static final /* synthetic */ void M(MainActivity r0) {
        r0.h0();
    }

    public static final /* synthetic */ void N(MainActivity r0) {
        r0.k0();
        throw null;
    }

    public static final /* synthetic */ IWs O(MainActivity r0) {
        return r0.l0();
    }

    public static final /* synthetic */ IWsDebug P(MainActivity r0) {
        return r0.m0();
    }

    private final void Q() {
        TextView r0 = this.q;
        if (r0 == null) goto L10;
        StringBuilder r1 = new StringBuilder();
        r1.append("是否有sd 卡权限 = ");
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L7;
        boolean r3 = true;
    L8:
        r1.append(r3);
        r0.setText(r1.toString());
        return;
    L7:
        r3 = false;
        goto L8
    L10:
        kotlin.n0.d.o.v("sdPermissionCheckText");
        throw null;
    }

    private final void R() {
        Class<?> r4 = Class.forName("android.app.ActivityManagerSmtBase");     // Catch: Throwable -> L4
        Object r0 = r4.newInstance();     // Catch: Throwable -> L4
        r4.getMethod("clearAllBg", new Class[0]).invoke(r0, new Object[0]);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.matrix.r.c.c.h("registerActivityLifeCycleObserver error ", th);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void S(MainActivity r2) {
        r2.z();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    @SuppressLint({"MissingPermission"})
    private final Location T(LocationManager r2, String r3) {
        return r2.getLastKnownLocation(r3);
    L4:
        th = move-exception;
        com.obric.matrix.r.c.c.g("Matrix-MainActivity-log", "requestSystemSingleLocation getLastKnownLocation error, provider=" + r3, th);
        return null;
    }

    private final void U() {
        com.obric.matrix.ostracker_api.b.g("app_launch_test", new JSONObject());
        com.obric.matrix.ostracker_api.b.a(new b());
        com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "the did from the TeaTrackerManager.getDeviceId() is " + com.obric.matrix.ostracker_api.b.c());
    }

    public static /* synthetic */ void V(String r0, long r1, MainActivity r3, LocationManager r4, List r5, kotlin.n0.d.d0 r6) {
        e0(r0, r1, r3, r4, r5, r6);
    }

    public static /* synthetic */ void W(MainActivity r0, Button r1, CompoundButton r2, boolean r3) {
        c0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void X(MainActivity r0, EditText r1, EditText r2, EditText r3, AlertDialog.Builder r4, DialogInterface r5, int r6) {
        i0(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void Y(MainActivity r0) {
        g0(r0);
    }

    public static /* synthetic */ void Z(DialogInterface r0, int r1) {
        j0(r0, r1);
    }

    private final ILocationServiceDebug a0() {
        ILocationServiceDebug r2 = (ILocationServiceDebug) com.bytedance.news.common.service.manager.d.a(ILocationServiceDebug.class);
        if (r2 != null) goto L5;
        com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "can find locationServiceDebug!");
    L5:
        return r2;
    }

    @SuppressLint({"MissingPermission"})
    private final void b0(LocationManager r6, List<String> r7, String r8) {
        com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "requestSystemSingleLocation snapshot[" + r8 + "], isLocationEnabled=" + r6.isLocationEnabled() + ", allProviders=" + r6.getAllProviders() + ", enabledProviders=" + r6.getProviders(true));
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        String r0 = (String) r9.next();
        if (r6.getAllProviders().contains(r0) == false) goto L7;
        com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "requestSystemSingleLocation snapshot[" + r8 + "], provider=" + r0 + ", enabled=" + r6.isProviderEnabled(r0) + ", lastKnown=" + T(r6, r0));
        goto L4
    L7:
        com.obric.matrix.r.c.c.s("Matrix-MainActivity-log", "requestSystemSingleLocation snapshot[" + r8 + "], provider=" + r0 + " not found");
        goto L4
    }

    private static final void c0(MainActivity r1, Button r2, CompoundButton r3, boolean r4) {
        kotlin.n0.d.o.f(r1, "this$0");
        kotlin.n0.d.o.f(r2, "$locationMockPageBtn");
        com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "mock location onCheckedChanged isChecked = " + r4);
        ILocationServiceDebug r5 = r1.a0();
        if (r5 == null) goto L5;
        r5.setMockEnable(r4);
    L5:
        r2.setEnabled(r4);
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [T, com.obric.matrix.MainActivity$l0] */
    @SuppressLint({"MissingPermission"})
    private final void d0() {
        boolean r1 = true;
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        boolean r0 = true;
    L7:
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L11;
        r1 = false;
    L11:
        if (r0 == true) goto L17;
        if (r1 == true) goto L17;
        com.obric.matrix.r.c.c.f("Matrix-MainActivity-log", "requestSystemSingleLocation: no location permission");
        String r2 = "未授予定位权限";
    L14:
        Toast r3 = Toast.makeText(this, r2, 0);
    L15:
        r3.show();
        return;
    L17:
        Object r4 = getSystemService(LocationMonitorConst.LOCATION);
        if ((r4 instanceof LocationManager) == false) goto L20;
        LocationManager r14 = (LocationManager) r4;
    L21:
        if (r14 != null) goto L23;
        com.obric.matrix.r.c.c.f("Matrix-MainActivity-log", "requestSystemSingleLocation: LocationManager is null");
        r2 = "LocationManager is null";
        goto L14
    L23:
        final List<String> r15 = kotlin.i0.r.j(new String[]{"gps", "network", "fused", "passive"});
        b0(r14, r15, "before request");
        Iterator<T> r16 = r15.iterator();
    L25:
        if (r16.hasNext() == false) goto L48;
        final String r9 = (String) r16.next();
        if (r14.getAllProviders().contains(r9) == false) goto L28;
        if (r14.isProviderEnabled(r9) == false) goto L32;
        final long r17 = System.currentTimeMillis();
        Handler r8 = new Handler(Looper.getMainLooper());
        final kotlin.n0.d.d0 r5 = new kotlin.n0.d.d0();
        final LocationManager r6 = r14;
        Runnable r7 = new com.obric.matrix.a(r9, r17, this, r6, r15, r5);
        r5.f18431f = new l0(r8, r7, r14, r9, r17, this, r15);
        com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", "requestSystemSingleLocation start, provider=" + r9 + ", lastKnown=" + T(r14, r9));     // Catch: Throwable -> L44
        T r10 = r5.f18431f;     // Catch: Throwable -> L44
        if (r10 == 0) goto L39;
        r14.requestSingleUpdate(r9, (LocationListener) r10, Looper.getMainLooper());     // Catch: Throwable -> L44
        Runnable r11 = r7;
        Handler r12 = r8;
        r12.postDelayed(r11, 20000);     // Catch: Throwable -> L42
    L42:
        th = th;
    L46:
        r12.removeCallbacks(r11);
        com.obric.matrix.r.c.c.g("Matrix-MainActivity-log", "requestSystemSingleLocation error, provider=" + r9, th);
        goto L25
    L39:
        r11 = r7;
        r12 = r8;
        kotlin.n0.d.o.v("listener");     // Catch: Throwable -> L42
        throw null;
    L44:
        th = th;
        r11 = r7;
        r12 = r8;
        goto L46
    L32:
        StringBuilder r13 = new StringBuilder();
        String r18 = "requestSystemSingleLocation: provider disabled, provider=";
    L29:
        r13.append(r18);
        r13.append(r9);
        com.obric.matrix.r.c.c.s("Matrix-MainActivity-log", r13.toString());
        goto L25
    L28:
        r13 = new StringBuilder();
        r18 = "requestSystemSingleLocation: provider not found, provider=";
        goto L29
    L48:
        r3 = Toast.makeText(this, "已触发系统定位请求，查看日志 Matrix-MainActivity-log", 0);
        goto L15
    L20:
        r14 = null;
        goto L21
    L5:
        r0 = false;
        goto L7
    }

    private static final void e0(String r3, long r4, MainActivity r6, LocationManager r7, List r8, kotlin.n0.d.d0 r9) {
        kotlin.n0.d.o.f(r3, "$provider");
        kotlin.n0.d.o.f(r6, "this$0");
        kotlin.n0.d.o.f(r8, "$providers");
        kotlin.n0.d.o.f(r9, "$listener");
        com.obric.matrix.r.c.c.f("Matrix-MainActivity-log", "requestSystemSingleLocation timeout, provider=" + r3 + ", cost=" + (System.currentTimeMillis() - r4) + "ms, lastKnown=" + r6.T(r7, r3));
        StringBuilder r5 = new StringBuilder();
        r5.append("timeout from ");
        r5.append(r3);
        r6.b0(r7, r8, r5.toString());
        T r10 = r9.f18431f;
        if (r10 == 0) goto L6;
        r7.removeUpdates((LocationListener) r10);
        return;
    L6:
        kotlin.n0.d.o.v("listener");
        throw null;
    }

    private final void f0() {
        runOnUiThread(new com.obric.matrix.d(this));
    }

    private static final void g0(MainActivity r3) {
        kotlin.n0.d.o.f(r3, "this$0");
        String r0 = ("当前信息:isBoe = " + com.obric.matrix.base.env.d.f8838a.e() + '\n') + "did = " + com.obric.matrix.ostracker_api.b.c() + '\n';
        StringBuilder r2 = new StringBuilder();
        r2.append(r0);
        r2.append("长连接状态 = ");
        IWs r1 = r3.l0();
        if (r1 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r1.isConnected());
    L6:
        r2.append(r4);
        r2.append('\n');
        String r5 = r2.toString() + "matrix_is_oversea = false";
        TextView r6 = r3.m;
        if (r6 == null) goto L11;
        r6.setText(r5);
        return;
    L11:
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void h0() {
        LinearLayout r0 = new LinearLayout(this);
        r0.setOrientation(1);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        final EditText r5 = new EditText(this);
        r5.setHint("输入 ServiceId");
        r5.setInputType(2);
        r0.addView(r5);
        final EditText r6 = new EditText(this);
        r6.setHint("输入 MethodId");
        r6.setInputType(2);
        r0.addView(r6);
        final EditText r7 = new EditText(this);
        r7.setHint("输入 payload");
        r7.setInputType(2);
        r0.addView(r7);
        final AlertDialog.Builder r1 = new AlertDialog.Builder(this);
        r1.setTitle("输入");
        r1.setView(r0);
        r1.setPositiveButton("OK", new com.obric.matrix.c(this, r5, r6, r7, r1));
        r1.setNegativeButton("Cancel", com.obric.matrix.e.f9093f);
        r1.show();
    }

    private static final void i0(MainActivity r0, EditText r1, EditText r2, EditText r3, AlertDialog.Builder r4, DialogInterface r5, int r6) {
        kotlin.n0.d.o.f(r0, "this$0");
        kotlin.n0.d.o.f(r1, "$input");
        kotlin.n0.d.o.f(r2, "$input2");
        kotlin.n0.d.o.f(r3, "$input3");
        kotlin.n0.d.o.f(r4, "$this_apply");
        IWsDebug r7 = r0.m0();     // Catch: Exception -> L18
        if (r7 == null) goto L22;
        String r8 = r1.getText().toString();     // Catch: Exception -> L18
        byte[] r9 = null;
        if (r8 == null) goto L8;
        Integer r10 = Integer.valueOf(Integer.parseInt(r8));     // Catch: Exception -> L18
    L9:
        int r11 = r10.intValue();     // Catch: Exception -> L18
        String r12 = r2.getText().toString();     // Catch: Exception -> L18
        if (r12 == null) goto L12;
        Integer r13 = Integer.valueOf(Integer.parseInt(r12));     // Catch: Exception -> L18
    L13:
        int r14 = r13.intValue();     // Catch: Exception -> L18
        String r15 = r3.getText().toString();     // Catch: Exception -> L18
        if (r15 == null) goto L16;
        r9 = r15.getBytes(kotlin.u0.d.f21429a);     // Catch: Exception -> L18
        kotlin.n0.d.o.e(r9, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L18
    L16:
        r7.generateWsMsg(r11, r14, r9);     // Catch: Exception -> L18
        return;
    L12:
        r13 = null;
        goto L13
    L8:
        r10 = null;
        goto L9
    L22:
        return;
    L18:
        Toast.makeText(r4.getContext().getApplicationContext(), "输入错误", 0).show();
    }

    private static final void j0(DialogInterface r0, int r1) {
        r0.cancel();
    }

    private final void k0() {
        throw new RuntimeException("test");
    }

    private final IWs l0() {
        return (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);
    }

    private final IWsDebug m0() {
        return (IWsDebug) com.bytedance.news.common.service.manager.d.a(IWsDebug.class);
    }

    @Override // com.obric.matrix.base.ui.CommonEmptyActivity
    public View m(int r3) {
        Map<Integer, View> r0 = this.r;
        View r1 = r0.get(Integer.valueOf(r3));
        if (r1 != null) goto L9;
        View r2 = findViewById(r3);
        if (r2 == null) goto L7;
        r0.put(Integer.valueOf(r3), r2);
        return r2;
    L7:
        return null;
    L9:
        return r1;
    }

    @Override // com.obric.matrix.base.ui.CommonEmptyActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        com.obric.matrix.o.f9232a.a();
        Log.d("Matrix-MainActivity-log", "onCreate:  matrix getSHA256 = " + com.obric.matrix.r.e.k.b(this, getPackageName()));
        this.m = v("");
        n("ppe 环境设置", PpeSettingsActivity.class);
        this.q = v("");
        Q();
        o("cleanSysBgProcess", "", new m(this));
        o("启动crash 测试 delete file ", "", x.f8357f);
        o("系统 API 定位测试", "", new d0(this));
        r("一建切换 BOE", R.id.matrix_btn_switch_boe, new e0(this));
        o("app_launch_test埋点上报", "", f0.f8320f);
        o("test_hotfix", "", new g0(this));
        o("update_device_id", "", new h0(this));
        o("测试抛出异常", "", new i0(this));
        o("模拟接收一个长链消息", "", new j0(this));
        r("模拟接收一个service=20319的长链消息", R.id.matrix_btn_mock_ws_msg, new c(this));
        o("监听长链消息", "", new d(this));
        r("查看长链消息的订阅记录", R.id.matrix_btn_get_ws_msg_subscribe_record, new e(this));
        r("一键清除长链消息的订阅记录", R.id.matrix_btn_clear_ws_msg_subscribe_record, new f(this));
        this.f8304j = v("");
        this.n = v("");
        n("Push功能测试", PushBadgeTestActivity.class);
        o("PushSDK", "", new g(this));
        o("Update Settings", "", h.f8324f);
        o("get Settings", "", new i(this));
        this.f8305k = v("");
        o("get sdk settings", "", new j(this));
        this.f8306l = v("");
        o("test CmdHandler register", "", k.f8330f);
        o("test CmdHandler unregister", "", l.f8332f);
        this.o = v("");
        o("刷新账号信息", "", new n(this));
        o("强制刷新账号信息", "", o.f8342f);
        o("系统账号登录", "", new p(this));
        o("系统账号登出", "", new q(this));
        EditText r0 = t();
        r0.setHint("mobile num");
        EditText r2 = t();
        r2.setHint("password");
        o("login with password", "", new r(r0, r2));
        v("");
        EditText r1 = t();
        r1.setHint("init password");
        o("set init password", "", new s(r1));
        v("");
        EditText r3 = t();
        r3.setHint("check password");
        o("check password", "", new t(r3));
        v("");
        EditText r4 = t();
        r4.setHint("old password");
        EditText r5 = t();
        r5.setHint("new password");
        o("update password", "", new u(r4, r5));
        v("");
        EditText r6 = t();
        r6.setHint("mobile num");
        o("send sms code", "", new v(this, r6));
        v("");
        EditText r8 = t();
        r8.setHint("sms code");
        o("quick login", "", new w(r6, r8));
        v("");
        EditText r9 = t();
        r9.setHint("sms code");
        EditText r10 = t();
        r10.setHint("new password");
        o("reset password", "", new y(r6, r9, r10));
        v("");
        EditText r11 = t();
        r11.setHint("sms code");
        EditText r12 = t();
        r12.setHint("ticket");
        o("check sms code", "", new z(r6, r11, r12, this));
        v("");
        EditText r13 = t();
        r13.setHint("reset password");
        o("ticket reset password", "", new a0(r12, r13));
        v("");
        EditText r14 = t();
        r14.setHint("new password");
        o("verify password", "", new b0(r6, r14));
        v("");
        EditText r15 = t();
        r15.setHint("phone");
        o("check phone num registered", "", new c0(r15));
        v("");
        this.f8302h = v(new com.obric.matrix.m().a());
        String r16 = com.obric.matrix.ostracker_api.b.c();
        if (r16 != null) goto L5;
        r16 = "";
    L5:
        this.f8303i = v(r16);
        Switch r17 = u("开启定位 mock");
        final Button r18 = o("打开定位 mock 页面", "", new k0(this));
        ILocationServiceDebug r19 = a0();
        if (r19 == null) goto L8;
        boolean r20 = r19.isMockEnable();
    L9:
        r18.setEnabled(r20);
        r17.setChecked(r20);
        r17.setOnCheckedChangeListener(new com.obric.matrix.b(this, r18));
        U();
        return;
    L8:
        r20 = false;
        goto L9
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.obric.matrix.dataanalysis.h.f9059i.a().v(this.p);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        kotlin.n0.d.o.f(r3, "permissions");
        kotlin.n0.d.o.f(r4, "grantResults");
        super.onRequestPermissionsResult(r2, r3, r4);
        if (r2 == 111) goto L5;
        return;
    L5:
        if (r4.length != 0) goto L7;
        boolean r1 = true;
    L9:
        if ((!r1) == true) goto L11;
    L13:
        String r5 = "onRequestPermissionsResult: 当用户拒绝授予权限时执行的代码";
    L14:
        com.obric.matrix.r.c.c.b("Matrix-MainActivity-log", r5);
        return;
    L11:
        if (r4[0] != 0) goto L13;
        r5 = "onRequestPermissionsResult: 当用户授予权限时执行的代码";
        goto L14
    L7:
        r1 = false;
        goto L9
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        f0();
        com.obric.matrix.dataanalysis.h.f9059i.a().l(this.p);
    }

    @Override // android.app.Activity
    protected void onStop() {
        S(this);
    }

    public void z() {
        super.onStop();
    }
}
