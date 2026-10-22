package xq;

import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import av.i;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.bytedance.ai.bridge.method.calendar.remote.CalDavResponse$HrefRelation;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import com.bytedance.ai.utils.c;
import com.bytedance.common.utility.Logger;
import com.obric.oui.blur.BlurToken;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.internal.http.StatusLine;
import org.xmlpull.v1.XmlPullParser;
import td.d;
import u1.e;
import u1.f;
import w1.g;
import w1.m;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap f23210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f23211b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f23212c = false;
    public static boolean d = false;
    public static String e;

    public static ArrayList a(XmlPullParser r5) {
        Intrinsics.checkNotNullParameter(r5, "parser");
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = r5.getDepth();
        int r12 = r5.getEventType();
    L4:
        if (r12 != 3) goto L14;
        if (r5.getDepth() != r11) goto L14;
        ArrayList r13 = new ArrayList(CollectionsKt.h(r10));
        Iterator r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        Intrinsics.checkNotNullParameter((Property$NodeInfo) r14.next(), "name");
        r13.add(new g());
        goto L10
    L12:
        return r13;
    L14:
        if (r12 != 2) goto L18;
        if (r5.getDepth() != (r11 + 1)) goto L18;
        r10.add(new Property$NodeInfo(r5.getNamespace(), r5.getName()));
    L18:
        r12 = r5.next();
        goto L4
    }

    public static void b(XmlPullParser r13, e0 r14, Function2 r15) {
        Intrinsics.checkNotNullParameter(r13, "parser");
        Intrinsics.checkNotNullParameter(r14, "location");
        Intrinsics.checkNotNullParameter(r15, "callback");
        int r5 = r13.getDepth();
        ArrayList r10 = new ArrayList();
        int r11 = r13.getEventType();
        e0 r12 = null;
        StatusLine r16 = null;
        ArrayList r17 = null;
        e0 r18 = null;
    L4:
        if (r11 == 3) goto L6;
    L63:
        if (r11 != 2) goto L94;
        if (r13.getDepth() != (r5 + 1)) goto L94;
        Property$NodeInfo r19 = x1.b.a(r13);
        if (Intrinsics.areEqual(r19, e.g) == false) goto L78;
        String r20 = r13.nextText();
        Intrinsics.checkNotNull(r20);
        if (StringsKt.P(r20, "/") == true) goto L76;
        Intrinsics.checkNotNull(r20);
        int r21 = StringsKt.q(r20, ':', 0, 6);
        if (r21 == (-1)) goto L76;
        Intrinsics.checkNotNull(r20);     // Catch: IndexOutOfBoundsException -> L95
        if (Intrinsics.areEqual(r20.substring(r21, r21 + 3), "://") == true) goto L76;
    L75:
        r20 = d.b("./", r20);
    L76:
        r12 = r14.j(r20);
        goto L94
    L78:
        if (Intrinsics.areEqual(r19, e.f22225c) == false) goto L86;
        r16 = StatusLine.parse(r13.nextText());     // Catch: ProtocolException -> L81
    L81:
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        t0.d r22 = c.f2846a;
        if (r22 == null) goto L84;
        r22.w("CalDavClient", "Invalid status line, treating as HTTP error 500");
    L84:
        r16 = new StatusLine(Protocol.HTTP_1_1, 500, "Invalid status line");
        goto L94
    L86:
        if (Intrinsics.areEqual(r19, u1.g.f22236c) == false) goto L89;
        r10.add(ym.a.d(r13));
        goto L94
    L89:
        if (Intrinsics.areEqual(r19, g.f22685a) == false) goto L92;
        r17 = a(r13);
        goto L94
    L92:
        if (Intrinsics.areEqual(r19, e.d) == false) goto L94;
        r18 = e0.h(r13.nextText());
    L94:
        r11 = r13.next();
        goto L4
    L6:
        if (r13.getDepth() != r5) goto L63;
        if (r12 == null) goto L59;
        ArrayList r110 = new ArrayList();
        Iterator r23 = r10.iterator();
    L11:
        if (r23.hasNext() == false) goto L15;
        Object r24 = r23.next();
        if ((((u1.g) r24).f22238b.code / 100) != 2) goto L11;
        r110.add(r24);
        goto L11
    L15:
        ArrayList r25 = new ArrayList(CollectionsKt.h(r110));
        Iterator r111 = r110.iterator();
    L17:
        if (r111.hasNext() == false) goto L19;
        r25.add(((u1.g) r111.next()).f22237a);
        goto L17
    L19:
        m r112 = (m) CollectionsKt.firstOrNull(CollectionsKt.l(r25, m.class));
        if (r112 != null) goto L22;
    L24:
        e0 r113 = com.lynx.jsbridge.a.p(r12);
        e0 r26 = com.lynx.jsbridge.a.p(r14);
        Intrinsics.checkNotNullParameter(r113, "url1");
        Intrinsics.checkNotNullParameter(r26, "url2");
        if (Intrinsics.areEqual(r113, r26) == false) goto L27;
        boolean r114 = true;
    L31:
        if (r114 == false) goto L34;
        CalDavResponse$HrefRelation r115 = CalDavResponse$HrefRelation.f1810a;
    L58:
        r15.mo2invoke(new f(r14, r12, r16, r10, r17, r18), r115);
        return;
    L34:
        if (Intrinsics.areEqual(r14.f20640b, r12.f20640b) == true) goto L36;
    L57:
        r115 = CalDavResponse$HrefRelation.f1812c;
        goto L58
    L36:
        if (Intrinsics.areEqual(r14.e, r12.e) == false) goto L57;
        if (r14.f != r12.f) goto L57;
        ArrayList r116 = r14.g;
        int r27 = r116.size();
        if (Intrinsics.areEqual(r116.get(r27 - 1), "") == false) goto L42;
        r27 = r27 - 1;
    L42:
        CalDavResponse$HrefRelation r28 = CalDavResponse$HrefRelation.f1812c;
        ArrayList r29 = r12.g;
        if (r29.size() <= r27) goto L56;
        Iterable r30 = RangesKt.until(0, r27);
        if ((r30 instanceof Collection) == true) goto L47;
    L49:
        Iterator r31 = r30.iterator();
    L51:
        if (r31.hasNext() == false) goto L55;
        int r32 = ((IntIterator) r31).nextInt();
        if (Intrinsics.areEqual(r116.get(r32), r29.get(r32)) == true) goto L51;
    L55:
        r115 = CalDavResponse$HrefRelation.f1811b;
        goto L58
    L47:
        if (((Collection) r30).isEmpty() == false) goto L49;
    L56:
        r115 = r28;
        goto L58
    L27:
        d0 r117 = r113.f();
        r117.f20629h = null;
        Uri r118 = Uri.parse(r117.a().f20644j);
        d0 r33 = r26.f();
        r33.f20629h = null;
        Uri r34 = Uri.parse(r33.a().f20644j);
        r114 = Intrinsics.areEqual(new URI(r118.getScheme(), r118.getSchemeSpecificPart(), r118.getFragment()), new URI(r34.getScheme(), r34.getSchemeSpecificPart(), r34.getFragment()));     // Catch: URISyntaxException -> L30
    L30:
        r114 = false;
        goto L31
    L22:
        if (r112.f22696a.contains(m.f22695c) == false) goto L24;
        r12 = com.lynx.jsbridge.a.i(r12);
        goto L24
    L59:
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        t0.d r119 = c.f2846a;
        if (r119 == null) goto L122;
        r119.w("CalDavClient", "Ignoring XML response element without valid href");
        return;
    }

    public static final boolean c() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L12;
        Boolean r12 = r11.o0();
        if (r12 != null) goto L9;
        return false;
    L9:
        return r12.booleanValue();
    L12:
        return false;
    L10:
        return false;
    }

    public static final boolean d(com.bytedance.ies.bullet.core.e r5) {
        Integer r10 = null;
        if (r5 == null) goto L7;
        rd.b r11 = r5.e;
        if (r11 == null) goto L7;
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter("web_domain_party", STGroup.DICT_KEY);
        vd.a r12 = new vd.a(r10, 2);
        r12.j(r11, "web_domain_party", null);
        r10 = (Integer) r12.f22372b;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r10.intValue() == 1) goto L13;
        return true;
    L13:
        return false;
    }

    public static final boolean e() {
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r10 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r10 == null) goto L8;
        com.bytedance.ies.bullet.service.base.d r11 = (com.bytedance.ies.bullet.service.base.d) r10.f6163b.getValue();
        if (r11 != null) goto L7;
        return true;
    L7:
        return r11.H;
    L8:
        return true;
    }

    public static final void f() {
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r10 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r10 == null) goto L6;
        com.bytedance.ies.bullet.service.base.d r11 = (com.bytedance.ies.bullet.service.base.d) r10.f6163b.getValue();
        return;
    }

    public static final boolean g() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L12;
        Boolean r12 = r11.q();
        if (r12 != null) goto L9;
        return true;
    L9:
        return r12.booleanValue();
    L12:
        return true;
    L10:
        return true;
    }

    public static final boolean h() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L12;
        Boolean r12 = r11.P();
        if (r12 != null) goto L9;
        return true;
    L9:
        return r12.booleanValue();
    L12:
        return true;
    L10:
        return true;
    }

    public static final boolean i() {
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r10 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r10 == null) goto L8;
        com.bytedance.ies.bullet.service.base.d r11 = (com.bytedance.ies.bullet.service.base.d) r10.f6163b.getValue();
        if (r11 != null) goto L7;
        return true;
    L7:
        return r11.g;
    L8:
        return true;
    }

    public static final ArrayList j(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        ArrayList r10 = new ArrayList();
        if ((r5 instanceof ViewGroup) == false) goto L8;
        ViewGroup r11 = (ViewGroup) r5;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        int r14 = r13 + 1;
        r10.addAll(j(r11.getChildAt(r13)));
        r13 = r14;
    L10:
        return r10;
    L8:
        if ((r5 instanceof EditText) == false) goto L10;
        r10.add(r5);
        goto L10
    }

    public static final boolean k() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L12;
        Boolean r12 = r11.d0();
        if (r12 != null) goto L9;
        return true;
    L9:
        return r12.booleanValue();
    L12:
        return true;
    L10:
        return true;
    }

    public static String l() {
        String r5 = f23211b;
        if (TextUtils.isEmpty(r5) == true) goto L5;
        return r5;
    L5:
        String r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L13
        StringBuilder r12 = new StringBuilder(32);     // Catch: Throwable -> L19
    L8:
        int r13 = r11.read();     // Catch: Throwable -> L19
        if (r13 <= 0) goto L11;
        r12.append((char) r13);     // Catch: Throwable -> L19
        goto L8
    L11:
        r10 = r12.toString();     // Catch: Throwable -> L19
    L12:
        td.c.j(r11);
        f23211b = r10;
        if (r10 != null) goto L18;
        return "";
    L18:
        return r10;
    L13:
        r11 = null;
        goto L12
    }

    public static String m() {
        String r5 = e;
        if (com.bytedance.common.utility.b.b(r5) == true) goto L5;
        return r5;
    L5:
        String r10 = null;
        Process.myPid();     // Catch: Exception -> L8
        throw null;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L21
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L27
    L12:
        int r13 = r11.read();     // Catch: Throwable -> L27
        if (r13 <= 0) goto L16;
        r12.append((char) r13);     // Catch: Throwable -> L27
        goto L12
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.d("Process", "get processName = " + r12.toString());     // Catch: Throwable -> L27
    L18:
        r10 = r12.toString();     // Catch: Throwable -> L27
    L34:
        r11.close();     // Catch: Exception -> L26
    L24:
        e = r10;
        return r10;
    L22:
        if (r11 == null) goto L24;
    L21:
        r11 = null;
        goto L22
    }

    public static ConcurrentHashMap n(BlurToken r5) {
        ConcurrentHashMap r10 = f23210a;
        if (r10 == null) goto L5;
    L15:
        return r10;
    L5:
        monitor-enter(b.class);
        r10 = f23210a;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        ConcurrentHashMap r11 = i.n(Float.class, r5);     // Catch: Throwable -> L9
        f23210a = r11;     // Catch: Throwable -> L9
        r10 = r11;
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static final boolean o() {
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r10 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r10 == null) goto L8;
        com.bytedance.ies.bullet.service.base.d r11 = (com.bytedance.ies.bullet.service.base.d) r10.f6163b.getValue();
        if (r11 != null) goto L7;
        return true;
    L7:
        return r11.e;
    L8:
        return true;
    }

    public static final void p(View r5) {
        Intrinsics.checkNotNullParameter(r5, "rootView");
        ArrayList r10 = j(r5);
        Object r11 = r5.getContext().getSystemService("input_method");
        if (r11 == null) goto L12;
        InputMethodManager r12 = (InputMethodManager) r11;
        Iterator r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        EditText r14 = (EditText) r13.next();
        if (r12.isActive(r14) == false) goto L6;
        r12.hideSoftInputFromWindow(r14.getWindowToken(), 0);
        goto L6
    L10:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final boolean q() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L12;
        Boolean r12 = r11.F0();
        if (r12 != null) goto L9;
        return true;
    L9:
        return r12.booleanValue();
    L12:
        return true;
    L10:
        return true;
    }

    public static final String r(KClass r5, wu.a r10, wu.a r11) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r11, "scopeQualifier");
        if (r10 == null) goto L6;
        String r12 = r10.getValue();
        if (r12 == null) goto L6;
    L8:
        return yu.a.a(r5) + ':' + r12 + ':' + r11;
    L6:
        r12 = "";
        goto L8
    }

    public static final boolean s() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L12;
        Boolean r12 = r11.d();
        if (r12 != null) goto L9;
        return true;
    L9:
        return r12.booleanValue();
    L12:
        return true;
    L10:
        return true;
    }

    public static final boolean t() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L12;
        Boolean r12 = r11.f0();
        if (r12 != null) goto L9;
        return true;
    L9:
        return r12.booleanValue();
    L12:
        return true;
    L10:
        return true;
    }

    public static OkHttpGlideModule u(String r5) {
        Class<?> r10 = Class.forName(r5);     // Catch: ClassNotFoundException -> L27
        Object r11 = r10.getDeclaredConstructor(null).newInstance(null);     // Catch: InvocationTargetException -> L11 NoSuchMethodException -> L13 IllegalAccessException -> L15 InstantiationException -> L17
    L6:
        if ((r11 instanceof OkHttpGlideModule) == false) goto L10;
        return (OkHttpGlideModule) r11;
    L10:
        throw new RuntimeException("Expected instanceof GlideModule, but found: " + r11);
    L15:
        e = move-exception;
        v(r10, e);
        throw null;
    L17:
        e = move-exception;
        v(r10, e);
        throw null;
    L13:
        e = move-exception;
        v(r10, e);
        throw null;
    L11:
        e = move-exception;
        v(r10, e);
        throw null;
    L27:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find GlideModule implementation", e);
    }

    public static void v(Class r5, ReflectiveOperationException r10) {
        throw new RuntimeException(androidx.constraintlayout.motion.widget.a.l(r5, "Unable to instantiate GlideModule implementation for "), r10);
    }
}
