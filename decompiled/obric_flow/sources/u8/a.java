package u8;

import ai.j0;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.forest.postprocessor.g;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.forest.d;
import com.bytedance.ies.bullet.service.sdk.b;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.salamander.anniex.n;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.utils.j;
import com.lynx.tasm.utils.k;
import com.obric.flow.cardlistpage.ui.TransparentDialogActivity;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import org.koin.androidx.fragment.android.KoinFragmentFactory;
import rc.f;
import td.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22264a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f22265b = false;

    public static g a(w r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        if ((r5 instanceof g) == false) goto L5;
        g r10 = (g) r5;
    L6:
        if (r10 != null) goto L8;
    L12:
        return null;
    L8:
        if (r10.D == false) goto L12;
        if (r10.o() == null) goto L12;
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    public static String b(Uri r5) {
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        String r12 = r5.getQueryParameter("forest_download_engine");     // Catch: Throwable -> L6
    L9:
        Object r13 = Result.m124constructorimpl(r12);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r13) == true) goto L16;
        r10 = r13;
    L16:
        String r14 = (String) r10;
        if (r14 != null) goto L22;
        return "ttnet";
    L22:
        return r14;
    L8:
        r12 = null;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static String c(e r5) {
        String r10 = d(r5, "forest_download_engine");
        if (r10 != null) goto L6;
        return "ttnet";
    L6:
        return r10;
    }

    public static String d(e r5, String r10) {
        if (r5 == null) goto L9;
        rd.e r11 = r5.g;
        if (r11 == null) goto L11;
        LinkedHashMap r12 = ((b) r11.f21723a).f6143o;
        if (r12 != null) goto L8;
        return null;
    L8:
        return (String) r12.get(r10);
    L11:
        return null;
    L9:
        return null;
    }

    public static String e(com.bytedance.ies.bullet.forest.e r5, f r10) {
        if (r10 == null) goto L4;
        e r11 = (e) r10.b(e.class);
    L6:
        return r5.forestDownloadEngine(r11);
    L4:
        r11 = null;
        goto L6
    }

    public static String f(LynxResourceRequest$LynxResourceType r5) {
        if (r5 != null) goto L4;
        int r10 = -1;
    L6:
        if (r10 != 1) goto L8;
        return "external_js";
    L8:
        if (r10 != 4) goto L10;
        return "component";
    L10:
        if (r10 == 5) goto L13;
        return "sub_resource";
    L13:
        return "template";
    L4:
        r10 = d.f5396a[r5.ordinal()];
        goto L6
    }

    public static String g(Throwable r5, StringBuilder r10) {
        return androidx.room.jarjarred.org.antlr.runtime.a.x(r5, r10);
    }

    public static String h(rd.e r5, String r10) {
        if (r5 == null) goto L7;
        LinkedHashMap r11 = ((b) r5.f21723a).f6143o;
        if (r11 != null) goto L6;
        return null;
    L6:
        return (String) r11.get(r10);
    L7:
        return null;
    }

    public static void i(String r5, n r10, s9.b r11) {
        JSONObject r12 = new JSONObject();
        Uri r13 = Uri.parse(r5);
        r12.put("url", r5);
        r12.put("cdn_domain", r13.getHost());
        r12.put("cdn_path", r13.getPath());
        r12.put("http_status", r10.f7268b);
        r12.put("error_message", r10.f7269c);
        if (r11 != null) goto L6;
        j.g("geckosdk_cdn_stats", r12);
        return;
    L6:
        r12.put("server_ip", r11.f21858a);
        String r14 = r11.f21868o;
        if (r14 != null) goto L9;
    L12:
        String r15 = r11.s;
        if (r15 == null) goto L24;
        if (r15.length() == 0) goto L24;
        JSONObject r16 = new JSONObject(r15);
        Object r17 = r16.opt("x-tt-trace-tag");
        if (r17 == null) goto L20;
        r12.put("x_tt_trace_tag", r17);
    L20:
        Object r18 = r16.opt("x-response-cache");
        if (r18 == null) goto L24;
        r12.put("x_response_cache", r18);
    L24:
        if (r11.f21866m != 0) goto L28;
        r12.put("timing_dns", r11.f21860c);
        r12.put("timing_connect", r11.d);
        r12.put("timing_send", r11.f);
        r12.put("timing_ssl", r11.e);
        r12.put("timing_wait", r11.f21862i);
        r12.put("timing_receive", r11.g);
        r12.put("timing_total", r11.f21863j);
        r12.put("download_duration", r11.f21863j - r11.f);
        String r19 = String.valueOf(r11.f21861h);
        if (r19.length() <= 0) goto L28;
        r12.put("timing_isSocketReused", r19);
    L28:
        j.g("geckosdk_cdn_stats", r12);
        return;
    L9:
        if (r14.length() == 0) goto L12;
        r12.put("request_log", r11.f21868o);
        r12.put(WsConstants.ERROR_CODE, new JSONObject(r11.f21868o).optLong("net_error"));
        goto L12
    }

    public static boolean j(rd.e r5) {
        if (k.o(h(r5, LynxMonitorService.KEY_CHANNEL)) == false) goto L7;
        if (k.o(h(r5, "bundle")) == false) goto L7;
        return true;
    L7:
        if (k.o(h(r5, "prefix")) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static final kotlinx.serialization.json.j k(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof kotlinx.serialization.json.j) == false) goto L5;
        kotlinx.serialization.json.j r10 = (kotlinx.serialization.json.j) r5;
    L6:
        if (r10 == null) goto L9;
        return r10;
    L9:
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.getOrCreateKotlinClass(r5.getClass()));
    L5:
        r10 = null;
        goto L6
    }

    public static Scene l(LynxResourceRequest$LynxResourceType r5) {
        if (r5 != null) goto L4;
        int r10 = -1;
    L5:
        switch(r10) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            default: goto L7;
        };
    L7:
        return Scene.f4350j;
    L9:
        return Scene.e;
    L11:
        return Scene.f4348h;
    L13:
        return Scene.f4349i;
    L15:
        return Scene.g;
    L17:
        return Scene.f4345a;
    L19:
        return Scene.f4347c;
    L21:
        return Scene.f;
    L23:
        return Scene.d;
    L25:
        return Scene.f4346b;
    L4:
        r10 = d.f5396a[r5.ordinal()];
        goto L5
    }

    public static boolean m(Uri r5) {
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        if (r5 == null) goto L10;
        String r12 = r5.getQueryParameter("loader_name");     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        String r13 = r12.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L8
    L11:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L8
    L15:
        if (Result.m130isFailureimpl(r14) == true) goto L19;
        r10 = r14;
    L19:
        return Intrinsics.areEqual(r10, "forest");
    L10:
        r13 = null;
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static boolean n(e r5) {
        if (k.o(d(r5, LynxMonitorService.KEY_CHANNEL)) == false) goto L7;
        if (k.o(d(r5, "bundle")) == false) goto L7;
        return true;
    L7:
        if (k.o(d(r5, "prefix")) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean o(rd.e r5) {
        String r10 = h(r5, "loader_name");
        if (r10 == null) goto L5;
        String r11 = r10.toLowerCase(Locale.ROOT);
    L7:
        return Intrinsics.areEqual(r11, "forest");
    L5:
        r11 = null;
        goto L7
    }

    public static String p(com.bytedance.ies.bullet.forest.e r5, f r10) {
        if (r10 == null) goto L4;
        e r11 = (e) r10.b(e.class);
    L6:
        return r5.sessionID(r11);
    L4:
        r11 = null;
        goto L6
    }

    public static boolean q(e r5) {
        String r10 = d(r5, "loader_name");
        if (r10 == null) goto L5;
        String r11 = r10.toLowerCase(Locale.ROOT);
    L7:
        return Intrinsics.areEqual(r11, "forest");
    L5:
        r11 = null;
        goto L7
    }

    public static void r(File r5, String r10, ZipOutputStream r11) {
        int r12 = 0;
        if (r5.isDirectory() == false) goto L11;
        StringBuilder r13 = j0.u(r10);
        r13.append(r5.getName());
        r13.append(File.separator);
        String r14 = r13.toString();
        if (r5.exists() == false) goto L53;
        File[] r15 = r5.listFiles();
    L9:
        if (r12 >= r15.length) goto L55;
        r(r15[r12], r14, r11);
        r12 = r12 + 1;
        goto L9
    L55:
        return;
    L53:
        return;
    L11:
        System.out.println("compress：" + r10 + r5.getName());
        if (r5.exists() == false) goto L54;
        InputStream r16 = null;
        InputStream r17 = new FileInputStream(r5);     // Catch: Throwable -> L32 Exception -> L34
    L48:
        BufferedInputStream r18 = new BufferedInputStream(r17);     // Catch: Throwable -> L28 Exception -> L30
        r11.putNextEntry(new ZipEntry(r10 + r5.getName()));     // Catch: Throwable -> L22 Exception -> L24
        byte[] r19 = new byte[8192];     // Catch: Throwable -> L22 Exception -> L24
    L18:
        int r20 = r18.read(r19, 0, 8192);     // Catch: Throwable -> L22 Exception -> L24
        if (r20 == (-1)) goto L26;
        r11.write(r19, 0, r20);     // Catch: Throwable -> L22 Exception -> L24
    L26:
        c.j(r18);
        c.j(r17);
        return;
    L24:
        e = e;
    L25:
        r16 = r17;
    L42:
    L38:
        th = th;
        r17 = r16;
    L23:
        r16 = r18;
    L40:
        c.j(r16);
        c.j(r17);
        throw th;
    L37:
        throw new RuntimeException(e);     // Catch: Throwable -> L38
    L22:
        th = th;
        goto L23
    L30:
        e = e;
        r18 = null;
    L28:
        th = th;
    L34:
        e = e;
        r18 = null;
    L32:
        th = th;
        r17 = null;
        goto L40
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static void s(String r10, String... r11) {
        File r5 = new File(r10);
        FileOutputStream r12 = new FileOutputStream(r5);     // Catch: Throwable -> L29 Exception -> L31
        CheckedOutputStream r13 = new CheckedOutputStream(r12, new CRC32());     // Catch: Throwable -> L25 Exception -> L27
    L43:
        ZipOutputStream r14 = new ZipOutputStream(r13);     // Catch: Throwable -> L19 Exception -> L22
        int r15 = r11.length;     // Catch: Throwable -> L11 Exception -> L13
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L17;
        String r17 = r11[r16];     // Catch: Throwable -> L11 Exception -> L13
        File r18 = new File(r17);     // Catch: Throwable -> L11 Exception -> L13
        if (r18.exists() == false) goto L16;
        r(r18, "", r14);     // Catch: Throwable -> L11 Exception -> L13
        r16 = r16 + 1;     // Catch: Throwable -> L11 Exception -> L13
        goto L7
    L16:
        throw new RuntimeException(r17 + "not exist！");     // Catch: Throwable -> L11 Exception -> L13
    L17:
        c.j(r14);
        c.j(r13);
        c.j(r12);
        return;
    L13:
        Exception e = e;
    L34:
        throw new RuntimeException(e);     // Catch: Throwable -> L11
    L22:
        e = e;
    L24:
        e = e;
    L19:
        th = th;
        Closeable r19 = null;
        CheckedOutputStream r20 = r13;
    L21:
        th = th;
        ?? r21 = r20;
    L35:
        c.j(r19);
        c.j(r21);
        c.j(r12);
        throw th;
    L27:
        e = e;
    L25:
        th = th;
        r20 = null;
        r19 = null;
        goto L21
    L11:
        th = th;
        r21 = r5;
    L31:
        e = e;
    L29:
        th = th;
        r20 = null;
        r12 = null;
        r19 = null;
        goto L21
    }

    public static boolean t(com.bytedance.ies.bullet.forest.e r5, f r10) {
        if (r10 == null) goto L4;
        e r11 = (e) r10.b(e.class);
    L6:
        return r5.useForest(r11);
    L4:
        r11 = null;
        goto L6
    }

    public static String u(File r5) {
        String[] r10 = r5.getName().split("\\.");
        if (r10.length > 1) goto L7;
        return "";
    L7:
        return r10[r10.length - 2];
    }

    public static final org.koin.core.scope.a v(ComponentCallbacks r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof org.koin.android.scope.a) == false) goto L6;
        return ((org.koin.android.scope.a) r5).t();
    L6:
        if ((r5 instanceof org.koin.core.component.a) == true) goto L15;
        org.koin.core.a r10 = su.a.f22013b;
        if (r10 == null) goto L13;
        return r10.f20999a.d;
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    L15:
        return ((KoinFragmentFactory) ((org.koin.core.component.a) r5)).a().f20999a.d;
    }

    public static synchronized void w() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f22264a == false) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        System.loadLibrary("bdzstd");     // Catch: Throwable -> L11
        f22264a = true;     // Catch: Throwable -> L11
        monitor-exit(a.class);
    }

    public static void x(Context r5, String r10, String r11, Bitmap r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "appName");
        Intent r13 = new Intent(r5, TransparentDialogActivity.class);
        r13.putExtra("extra_action", "extra_action_go_app_market_dialog");
        r13.putExtra("extra_app_market_package_name", r10);
        r13.putExtra("extra_app_market_app_name", r11);
        r13.putExtra("extra_app_market_app_icon", r12);
        r13.addFlags(268435456);
        r5.startActivity(r13);
    }

    public static void y(Context r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r12, "source");
        Intent r13 = new Intent(r5, TransparentDialogActivity.class);
        r13.putExtra("extra_action", "extra_action_go_privacy_policy_network_dialog");
        r13.putExtra("extra_web_view_url", r10);
        r13.putExtra("extra_web_view_title", r11);
        r13.putExtra("extra_privacy_policy_source", r12);
        r13.addFlags(268435456);
        r5.startActivity(r13);
    }
}
