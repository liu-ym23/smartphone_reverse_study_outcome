package z5;

import ai.j0;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.p;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.g;
import com.bytedance.ies.bullet.base.utils.logger.b;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.obric.oui.color.d;
import com.obric.oui.graphic.BlendMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import kotlin.jvm.internal.Intrinsics;
import l9.m;
import md.c;
import mh.e;
import org.json.JSONArray;
import org.json.JSONObject;
import w8.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f23397a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f23398b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f23399c = null;
    public static File d = null;
    public static String e = null;
    public static String f = "0";
    public static Long g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f23400h = "disable";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f23401i = "None";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f23402j = "None";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f23403k = "None";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f23404l = "None";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f23405m = "None";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Context f23406n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f23407o;

    public static AbsPopupFragment a(c r10, t9.a r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        AbsPopupFragment r5 = new AbsPopupFragment();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r5.f6065c = r10;
        r5.d = r11;
        b r12 = new b();
        String r13 = r10.f20064a;
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        ArrayList r14 = r12.f5260a;
        r14.add(new com.bytedance.ies.bullet.base.utils.logger.c("session_id", r13));
        Uri r15 = r5.i().f20066c;
        if (r15 == null) goto L6;
        String r16 = r15.getQueryParameter("__bullet_trident_call_id");
        if (r16 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r16, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r16, r14);
        r5.f = r12;
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "init " + r5.getClass(), "XPopup");
        r5.e = new f(r5);
        return r5;
    L6:
        r16 = "";
        goto L7
    }

    public static String b() {
        long r5 = Long.parseLong(f.trim());     // Catch: Throwable -> L8
        Long r10 = Long.valueOf(r5);     // Catch: Throwable -> L8
        if (r5 < 1048576) goto L7;
        return Long.valueOf(r5 / 1048576).toString() + "MB";
    L7:
        return r10.toString() + "KB";
    L8:
        return "0";
    }

    public static void c(File r5, CrashType r10) {
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_crash_with_custom_files"}) == 1) goto L25;
        if (r10 != CrashType.ANR) goto L8;
        File r11 = null;
    L9:
        if (r11 != null) goto L11;
    L13:
        Iterator r12 = ((ListMap) p.f.f211c).a(r10).iterator();     // Catch: Throwable -> L22
        if (r12.hasNext() == true) goto L17;
        return;
    L17:
        if (r12.next() != null) goto L20;
        throw null;     // Catch: Throwable -> L22
    L20:
        throw new ClassCastException();     // Catch: Throwable -> L22
    L11:
        if (r11.exists() == false) goto L13;
        return;
    L8:
        r11 = new File(r5, "external_files");     // Catch: Throwable -> L22
        goto L9
    L26:
        return;
    }

    public static void d(String r5, JSONObject r10) {
        z8.c.l(r10, "filters", "has_exit_info", "true");
        Properties r11 = new Properties();
        r11.load(new StringReader(r5));     // Catch: Throwable -> L6
    L4:
        z8.c.l(r10, "filters", "exit_reason", r11.getProperty("reason", NotificationCompat.CATEGORY_ERROR));
        z8.c.l(r10, "filters", "exit_sub_reason", r11.getProperty("sub_reason", NotificationCompat.CATEGORY_ERROR));
        z8.c.l(r10, "filters", "exit_status", r11.getProperty(NotificationCompat.CATEGORY_STATUS, NotificationCompat.CATEGORY_ERROR));
    }

    public static boolean e() {
        m r5 = m.a();
        if (r5.f19576a != (-1)) goto L5;
        return false;
    L5:
        if ((SystemClock.uptimeMillis() - r5.f19576a) <= 5000) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean f(String r10) {
        boolean r5 = false;
        File r11 = null;
    L9:
        th = th;
    L61:
        f23400h = "upload exception";     // Catch: Throwable -> L56
        th.printStackTrace();     // Catch: Throwable -> L56
        Log.e("NPTH_CFG", "corefile upload failed:" + th);     // Catch: Throwable -> L56
        if (r11 == null) goto L54;
        cl.a.C(r11);
    L54:
        Log.d("NPTH_CFG", "corefile del success:false");
    L55:
        return r5;
    L56:
        th = move-exception;
        if (r11 == null) goto L59;
        cl.a.C(r11);
    L59:
        Log.d("NPTH_CFG", "corefile del success:false");
        throw th;
    L4:
        if (f23397a == true) goto L12;
        if (o() == false) goto L12;
        Log.d("NPTH_CFG", "init again");     // Catch: Throwable -> L9
        f23400h = "init again";     // Catch: Throwable -> L9
        k();     // Catch: Throwable -> L9
    L12:
        if (r10 != null) goto L16;
        f23400h = "uuid null";     // Catch: Throwable -> L9
        Log.d("NPTH_CFG", "corefile del success:false");
        return false;
    L16:
        e = r10;     // Catch: Throwable -> L9
        Context r12 = n.f4057a;     // Catch: Throwable -> L9
        f23406n = r12;     // Catch: Throwable -> L9
        f23399c = g.g(r12);     // Catch: Throwable -> L9
        File r13 = new File(g.b(f23406n), "/".concat(r10));     // Catch: Throwable -> L9
        f23398b = r13;     // Catch: Throwable -> L9
        if (r13.exists() == true) goto L21;
        f23400h = "dir not exist";     // Catch: Throwable -> L9
        Log.d("NPTH_CFG", "corefile del success:false");
        return false;
    L21:
        Log.d("NPTH_CFG", "upload corefile start ");     // Catch: Throwable -> L9
        n();     // Catch: Throwable -> L9
        if ("0".equals(f) == false) goto L27;
        f23400h = "coresize is null";     // Catch: Throwable -> L9
        Log.d("NPTH_CFG", "corefile del success:false");
        return false;
    L27:
        if (l() == true) goto L29;
    L48:
        if (r11 == null) goto L50;
        cl.a.C(r11);
    L50:
        Log.d("NPTH_CFG", "corefile del success:" + r5);
        goto L55
    L29:
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "upload_core_dump"}) == 1) goto L34;
        f23400h = "corefile not upload";     // Catch: Throwable -> L9
        cl.a.C(f23398b);     // Catch: Throwable -> L9
        Log.d("NPTH_CFG", "corefile del success:false");
        return false;
    L34:
        if (m() == false) goto L47;
        File r14 = new File(new File(g.h(n.f4057a), x8.a.f).getAbsolutePath() + "/coredump.zip");     // Catch: Throwable -> L9
        cl.a.v(f23398b.getAbsolutePath(), r14.getAbsolutePath());     // Catch: Throwable -> L38
        g = Long.valueOf(r14.length());     // Catch: Throwable -> L38
    L40:
        r5 = com.bytedance.crash.upload.b.m(r14, r10);     // Catch: Throwable -> L45
        if (r5 == false) goto L43;
        f23400h = "success";     // Catch: Throwable -> L45
    L44:
        r11 = r14;
        goto L48
    L43:
        f23400h = "corefile upload failed";     // Catch: Throwable -> L45
        goto L44
    L38:
        th = move-exception;
        f23400h = "zip file exception";     // Catch: Throwable -> L45
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L45
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L45
    L45:
        th = th;
        r11 = r14;
        goto L61
    L47:
        f23400h = "network is not wifi";     // Catch: Throwable -> L9
        f23405m = "not support network";     // Catch: Throwable -> L9
        goto L48
    }

    public static boolean g(JSONArray r10) {
    L18:
        th = move-exception;
        th.printStackTrace();
    L20:
        return false;
    L4:
        if (Build.BRAND.isEmpty() == false) goto L6;
        return false;
    L6:
        String[] r11 = r10.optString(2).split(",");     // Catch: Throwable -> L18
        if ("none".equals(r11[0]) == false) goto L10;
        return false;
    L10:
        if ("all".equals(r11[0]) == false) goto L12;
        return true;
    L12:
        int r5 = r11.length;     // Catch: Throwable -> L18
        int r12 = 0;
    L13:
        if (r12 >= r5) goto L20;
        if (Build.BRAND.equals(r11[r12]) == true) goto L16;
        r12 = r12 + 1;
        goto L13
    L16:
        return true;
    }

    public static String h() {
        long r5 = Long.parseLong(f.trim());     // Catch: Throwable -> L69
        if (r5 < 1048576) goto L67;
        long r10 = r5 / 1048576;     // Catch: Throwable -> L69
        Long r11 = Long.valueOf(r10);     // Catch: Throwable -> L69
        if (r10 <= 1) goto L11;
        if (r10 > 10) goto L11;
        return "1~10MB";
    L11:
        if (r10 <= 10) goto L17;
        if (r10 > 30) goto L17;
        return "10~30MB";
    L17:
        if (r10 <= 30) goto L23;
        if (r10 > 50) goto L23;
        return "30~50MB";
    L23:
        if (r10 <= 50) goto L29;
        if (r10 > 100) goto L29;
        return "50~100MB";
    L29:
        if (r10 <= 100) goto L35;
        if (r10 > 200) goto L35;
        return "101~200MB";
    L35:
        if (r10 <= 200) goto L41;
        if (r10 > 300) goto L41;
        return "201~300MB";
    L41:
        if (r10 <= 300) goto L47;
        if (r10 > 400) goto L47;
        return "301~400MB";
    L47:
        if (r10 <= 400) goto L53;
        if (r10 > 500) goto L53;
        return "401~500MB";
    L53:
        if (r10 <= 500) goto L59;
        if (r10 > 1000) goto L59;
        return "501MB~1GB";
    L59:
        if (r10 <= 1000) goto L62;
        return "size > 1GB";
    L62:
        if (r10 >= 1) goto L65;
        return "size < 1MB";
    L65:
        return r11.toString();
    L67:
        return "10kb~1MB";
    L69:
        return "0";
    }

    public static String i() {
        Long r5 = g;     // Catch: Throwable -> L8
        if (r5.longValue() < 1048576) goto L7;
        return Long.valueOf(r5.longValue() / 1048576).toString() + "MB";
    L7:
        return r5.toString() + "KB";
    L8:
        return "0";
    }

    public static com.obric.oui.material.c[] j(com.obric.oui.material.c[] r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "baseConfigs");
        int r5 = Color.alpha(r12);
        float[] r10 = new float[3];
        Color.colorToHSV(r12, r10);
        r10[1] = Math.max(0.0f, r10[1] - 0.1f);
        int r13 = (Color.HSVToColor(r10) & ViewCompat.MEASURED_SIZE_MASK) | (r5 << 24);
        int r14 = Color.argb(102, Color.red(r13), Color.green(r13), Color.blue(r13));
        ArrayList r15 = new ArrayList(r11.length);
        int r16 = r11.length;
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L9;
        com.obric.oui.material.c r18 = r11[r17];
        com.obric.oui.material.c r19 = r18.a();
        r19.f13611c = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, BlendMode.SRC_OVER), new com.obric.oui.color.a(-3355444, BlendMode.OVERLAY), new com.obric.oui.color.a(r13, BlendMode.PLUS_DARKER)};
        d r20 = r18.e;
        if (r20 != null) goto L7;
        d r21 = null;
    L8:
        r19.e = r21;
        r15.add(r19);
        r17 = r17 + 1;
        goto L3
    L7:
        r21 = new d(r20.f12423a, r14, r20.f12425c);
        goto L8
    L9:
        Object[] r110 = r15.toArray(new com.obric.oui.material.c[0]);
        if (r110 == null) goto L14;
        return (com.obric.oui.material.c[]) r110;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static void k() {
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_coredump"}) == 1) goto L5;
        return;
    L5:
        if (f23397a == true) goto L53;
        Context r5 = n.f4057a;
        f23406n = r5;
        if (r5 == null) goto L50;
        File r10 = g.b(r5);
        if (r10.exists() == true) goto L46;
        r10.mkdirs();
    L46:
        File r11 = new File(new File(g.h(f23406n), g.f4181a), "core.config");     // Catch: Throwable -> L16
        d = r11;     // Catch: Throwable -> L16
        if (r11.exists() == true) goto L18;
        d.createNewFile();     // Catch: Throwable -> L16
    L18:
        boolean r12 = n.h();     // Catch: Throwable -> L16
        boolean r13 = "true".equals(null);     // Catch: Throwable -> L16
        if (r12 == true) goto L47;
        if (r13 == true) goto L47;
    L24:
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "upload_core_dump"}) != 1) goto L26;
        boolean r14 = o();     // Catch: Throwable -> L16
    L33:
        if (r14 == false) goto L51;
        Log.d("NPTH_CFG", "init corefile");
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_async_coredump"}) != 1) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == false) goto L40;
        int r16 = NativeImpl.b(1);
    L41:
        f23397a = true;
        f23400h = "init";
        if (r16 >= 0) goto L52;
        f23400h = "init failed";
        return;
    L52:
        return;
    L40:
        r16 = NativeImpl.b(0);
        goto L41
    L37:
        r15 = false;
        goto L38
    L51:
        return;
    L26:
        if (d.exists() == false) goto L28;
        cl.a.C(d);     // Catch: Throwable -> L16
    L28:
        f23400h = "not enable upload";     // Catch: Throwable -> L16
    L29:
        r14 = false;
    L47:
        cl.a.u("1#all#all#null#lib#SIG#0#0#7#", d, false);     // Catch: Throwable -> L16 IOException -> L45
        r14 = true;
    L16:
        th = move-exception;
        th.printStackTrace();
        f23400h = "config init exception";
        goto L29
    L50:
        return;
    }

    public static boolean l() {
        File[] r5 = f23398b.listFiles();
        if (r5 != null) goto L6;
        Log.e("NPTH_CFG", "upload corefile coreDirs == null");
        return false;
    L6:
        int r10 = r5.length;
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L21;
        File r12 = r5[r11];
    L18:
        th = move-exception;
        th.printStackTrace();
    L20:
        r11 = r11 + 1;
        goto L7
    L10:
        if (r12.getName().startsWith("core-") == false) goto L20;
        if (r12.length() <= 0) goto L20;
        f23401i = "dump_elf_header_ok";     // Catch: Throwable -> L18
        if (Long.parseLong(f.trim()) != r12.length()) goto L20;
        f23401i = "dump_success";     // Catch: Throwable -> L18
        return true;
    L21:
        return false;
    }

    public static boolean m() {
        if ("wifi".equals(com.bytedance.ies.bullet.base.utils.b.c(f23406n)) == false) goto L7;
        f23405m = "wifi";
        return true;
    L7:
        if (IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(f23404l) == false) goto L14;
        Log.d("NPTH_CFG", "network upload");
        if ("5g".equals(com.bytedance.ies.bullet.base.utils.b.c(f23406n)) == false) goto L11;
    L12:
        f23405m = "mobile network";
        return true;
    L11:
        if ("4g".equals(com.bytedance.ies.bullet.base.utils.b.c(f23406n)) == true) goto L12;
        return false;
    L14:
        return false;
    }

    public static void n() {
        if (f23399c == null) goto L53;
        File r5 = new File(f23399c, j0.q(new StringBuilder("/"), e, "/tombstone.txt"));
        StringBuilder r10 = new StringBuilder();
        if (r5.exists() == true) goto L8;
        return;
    L8:
        if (r5.length() <= 0) goto L51;
        BufferedReader r11 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L26
    L38:
        String r12 = r11.readLine();     // Catch: Throwable -> L15
        if (r12 == null) goto L24;
        if (r12.startsWith("coresize:") == true) goto L14;
        if (r12.startsWith("dump tooks:") == true) goto L19;
        if (r12.endsWith("sync_start") == false) goto L38;
        f23403k = r12;     // Catch: Throwable -> L15
        goto L38
    L19:
        f23402j = r12.substring(r12.indexOf(":") + 1, r12.indexOf(XPath.NOT));     // Catch: Throwable -> L15
        f23401i = r12.substring(r12.indexOf("(") + 1, r12.indexOf(")"));     // Catch: Throwable -> L15
        goto L38
    L14:
        r10.append(r12.substring(9));     // Catch: Throwable -> L15
        r10.append('\n');     // Catch: Throwable -> L15
        f = r10.toString();     // Catch: Throwable -> L15
        goto L38
    L24:
        com.bytedance.android.anniex.base.service.f.h(r11);
        return;
    L15:
        th = th;
    L36:
        io.reactivex.exceptions.a.l("tombstone read failed." + th);     // Catch: Throwable -> L30
        com.bytedance.android.anniex.base.service.f.h(r11);
        return;
    L30:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r11);
        throw th;
    L26:
        th = th;
        r11 = null;
        goto L36
    L51:
        return;
    }

    public static boolean o() {
        JSONArray r5 = e.f(l9.c.e(), new String[]{"custom_event_settings", "npth_simple_setting", "enable_coredump_config"});     // Catch: Throwable -> L26
        if (r5 != null) goto L7;
    L36:
        f23400h = "config init null";     // Catch: Throwable -> L26
        return false;
    L7:
        if (r5.length() >= 10) goto L36;
        String[] r10 = r5.optString(1).split(",");     // Catch: Throwable -> L34
        if ("none".equals(r10[0]) == false) goto L14;
    L39:
        f23400h = "config write exception";
        return false;
    L14:
        if ("all".equals(r10[0]) == true) goto L21;
        int r11 = r10.length;     // Catch: Throwable -> L34
        int r12 = 0;
    L17:
        if (r12 >= r11) goto L39;
        if (Build.VERSION.SDK_INT == Integer.parseInt(r10[r12])) goto L21;
        r12 = r12 + 1;     // Catch: Throwable -> L26
        goto L17
    L21:
        if (g(r5) == false) goto L39;
        StringBuffer r13 = new StringBuffer("");     // Catch: Throwable -> L26
        boolean r14 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(r5.optString(0));     // Catch: Throwable -> L26
        int r15 = 0;
    L24:
        if (r15 >= r5.length()) goto L28;
        r13.append(r5.optString(r15) + "#");     // Catch: Throwable -> L26
        r15 = r15 + 1;     // Catch: Throwable -> L26
        goto L24
    L28:
        cl.a.u(r13.toString(), d, false);     // Catch: Throwable -> L26
        if (d.length() <= 1) goto L31;
        f23400h = "upload config ok";     // Catch: Throwable -> L26
    L31:
        f23404l = r5.optString(8);     // Catch: Throwable -> L26
        return r14;
    L34:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L39
    }

    public static void p(VectorDrawable r5, int r10) {
        Field r11 = VectorDrawable.class.getDeclaredField("mVectorState");
        r11.setAccessible(true);
        Object r12 = r11.get(r5);
        Field r13 = r12.getClass().getDeclaredField("mVGTargetsMap");
        r13.setAccessible(true);
        Object r14 = r13.get(r12);
        if (r14 == null) goto L15;
        Object r15 = ((ArrayMap) r14).get("primary_shape");
        if (r15 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r15.getClass().getSimpleName(), "VFullPath") == false) goto L16;
        Field r16 = Class.forName("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        r16.setAccessible(true);
        Object r17 = r16.get(r15);
        if (r17 == null) goto L12;
        Method r18 = Class.forName("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        r18.setAccessible(true);
        r18.invoke(null, new Object[]{(Long) r17, Integer.valueOf(r10)});
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
    }

    public static void q(AnimatedVectorDrawable r5, int r10) {
        Field r11 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        r11.setAccessible(true);
        Object r12 = r11.get(r5);
        Field r13 = r12.getClass().getDeclaredField("mVectorDrawable");
        if (r13 == null) goto L16;
        r13.setAccessible(true);
        Object r14 = r13.get(r12);
        if (r14 != null) goto L8;
    L6:
        r14 = null;
    L9:
        VectorDrawable r15 = (VectorDrawable) r14;
        if (r15 == null) goto L14;
        p(r15, r10);
        return;
    L14:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r14 instanceof VectorDrawable) == false) goto L6;
    L16:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }

    public abstract void r(m6.a r5);
}
