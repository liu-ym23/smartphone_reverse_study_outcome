package uj;

import b0.g;
import com.bytedance.crash.CrashType;
import com.bytedance.ies.bullet.service.base.x;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.security.MessageDigest;
import java.util.ArrayList;
import jg.k;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import nu.j;
import okhttp3.e0;
import okhttp3.internal.Util;
import org.json.JSONArray;
import org.json.JSONObject;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.d;
import org.threeten.bp.temporal.i;
import r0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c, gc.a, bi.a, xn.a, l.b, kj.b, i {
    public a(JSONObject r5, CrashType r10) {
        if (r10 != CrashType.LAUNCH) goto L5;
        ((JSONArray) r5.opt("data")).optJSONObject(0);
    L5:
        r5.optJSONObject("header");
    }

    public static String h(String r17, int r18, int r19, String r20, boolean r21, boolean r22, boolean r23, boolean r24, int r25) {
        boolean r5 = false;
        if ((r25 & 1) == 0) goto L5;
        int r10 = 0;
    L7:
        if ((r25 & 2) == 0) goto L9;
        int r11 = r17.length();
    L11:
        if ((r25 & 8) == 0) goto L13;
        boolean r12 = false;
    L15:
        if ((r25 & 16) == 0) goto L17;
        boolean r13 = false;
    L19:
        if ((r25 & 32) == 0) goto L21;
        boolean r14 = false;
    L23:
        if ((r25 & 64) != 0) goto L26;
        r5 = r24;
    L26:
        Intrinsics.checkNotNullParameter(r17, "$this$canonicalize");
        Intrinsics.checkNotNullParameter(r20, "encodeSet");
        int r15 = r10;
    L27:
        if (r15 >= r11) goto L86;
        int r16 = r17.codePointAt(r15);
        int r110 = 32;
        int r111 = 128;
        if (r16 < 32) goto L44;
        if (r16 == 127) goto L44;
        if (r16 < 128) goto L34;
        if (r5 == false) goto L44;
    L34:
        if (StringsKt.f(r20, (char) r16) == true) goto L44;
        if (r16 != 37) goto L40;
        if (r12 == false) goto L44;
        if (r13 == false) goto L40;
        if (j(r15, r11, r17) == false) goto L44;
    L40:
        if (r16 != 43) goto L43;
        if (r14 == true) goto L44;
    L43:
        r15 = r15 + Character.charCount(r16);
    L44:
        j r26 = new j();
        r26.a0(r10, r15, r17);
        j r27 = null;
    L45:
        if (r15 >= r11) goto L99;
        int r112 = r17.codePointAt(r15);
        if (r12 == true) goto L49;
    L56:
        if (r112 != 43) goto L62;
        if (r14 == false) goto L62;
        if (r12 == false) goto L60;
        String r113 = "+";
    L61:
        r26.b0(r113);
    L83:
        r15 = r15 + Character.charCount(r112);
        r110 = 32;
        r111 = 128;
        goto L45
    L60:
        r113 = "%2B";
    L62:
        if (r112 < r110) goto L77;
        if (r112 == 127) goto L77;
        if (r112 < r111) goto L67;
        if (r5 == false) goto L77;
    L67:
        if (StringsKt.f(r20, (char) r112) == true) goto L77;
        if (r112 != 37) goto L75;
        if (r12 == false) goto L77;
        if (r13 == false) goto L75;
        if (j(r15, r11, r17) == false) goto L77;
    L75:
        r26.c0(r112);
    L77:
        if (r27 != null) goto L79;
        r27 = new j();
    L79:
        r27.c0(r112);
    L81:
        if (r27.y() == true) goto L83;
        byte r114 = r27.readByte();
        int r115 = r114 & UByte.MAX_VALUE;
        r26.T(37);
        char[] r116 = e0.f20638k;
        r26.T(r116[(r115 >> 4) & 15]);
        r26.T(r116[r114 & 15]);
        goto L81
    L49:
        if (r112 == 9) goto L83;
        if (r112 == 10) goto L83;
        if (r112 == 12) goto L83;
        if (r112 == 13) goto L83;
    L99:
        return r26.M();
    L86:
        return r17.substring(r10, r11);
    L21:
        r14 = r23;
        goto L23
    L17:
        r13 = r22;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public static int i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "scheme");
        int r10 = r5.hashCode();
        if (r10 == 3213448) goto L11;
        if (r10 == 99617003) goto L8;
    L13:
        return -1;
    L8:
        if (r5.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L13;
        return 443;
    L11:
        if (r5.equals("http") == false) goto L13;
        return 80;
    }

    public static boolean j(int r5, int r10, String r11) {
        int r12 = r5 + 2;
        if (r12 < r10) goto L5;
    L11:
        return false;
    L5:
        if (r11.charAt(r5) != '%') goto L11;
        if (Util.parseHexDigit(r11.charAt(r5 + 1)) == (-1)) goto L11;
        if (Util.parseHexDigit(r11.charAt(r12)) == (-1)) goto L11;
        return true;
    }

    public static String k(String r10, int r11, int r12, int r13, boolean r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        if ((r13 & 4) == 0) goto L11;
        r14 = false;
    L11:
        Intrinsics.checkNotNullParameter(r10, "$this$percentDecode");
        int r15 = r11;
    L12:
        if (r15 >= r12) goto L35;
        char r5 = r10.charAt(r15);
        if (r5 == '%') goto L19;
        if (r5 != '+') goto L18;
        if (r14 == true) goto L19;
    L18:
        r15 = r15 + 1;
    L19:
        j r16 = new j();
        r16.a0(r11, r15, r10);
    L20:
        if (r15 >= r12) goto L55;
        int r17 = r10.codePointAt(r15);
        if (r17 != 37) goto L29;
        int r18 = r15 + 2;
        if (r18 >= r12) goto L29;
        int r19 = Util.parseHexDigit(r10.charAt(r15 + 1));
        int r20 = Util.parseHexDigit(r10.charAt(r18));
        if (r19 == (-1)) goto L32;
        if (r20 == (-1)) goto L32;
        r16.T((r19 << 4) + r20);
        r15 = Character.charCount(r17) + r18;
    L32:
        r16.c0(r17);
        r15 = r15 + Character.charCount(r17);
    L29:
        if (r17 != 43) goto L32;
        if (r14 == false) goto L32;
        r16.T(32);
        r15 = r15 + 1;
        goto L20
    L55:
        return r16.M();
    L35:
        return r10.substring(r11, r12);
    }

    public static ArrayList l(String r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toQueryNamesAndValues");
        ArrayList r5 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 > r10.length()) goto L15;
        int r12 = StringsKt.q(r10, Typography.amp, r11, 4);
        if (r12 != (-1)) goto L8;
        r12 = r10.length();
    L8:
        int r13 = StringsKt.q(r10, '=', r11, 4);
        if (r13 == (-1)) goto L13;
        if (r13 > r12) goto L13;
        r5.add(r10.substring(r11, r13));
        r5.add(r10.substring(r13 + 1, r12));
    L14:
        r11 = r12 + 1;
    L13:
        r5.add(r10.substring(r11, r12));
        r5.add(null);
        goto L14
    L15:
        return r5;
    }

    public static void m(ArrayList r10, StringBuilder r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$toQueryString");
        Intrinsics.checkNotNullParameter(r11, "out");
        IntProgression r5 = RangesKt.step(RangesKt.until(0, r10.size()), 2);
        int r12 = r5.getFirst();
        int r13 = r5.getLast();
        int r14 = r5.getStep();
        if (r14 < 0) goto L6;
        if (r12 <= r13) goto L7;
        return;
    L7:
        String r15 = (String) r10.get(r12);
        String r16 = (String) r10.get(r12 + 1);
        if (r12 <= 0) goto L10;
        r11.append(Typography.amp);
    L10:
        r11.append(r15);
        if (r16 == null) goto L13;
        r11.append('=');
        r11.append(r16);
    L13:
        if (r12 == r13) goto L19;
        r12 = r12 + r14;
        goto L7
    L19:
        return;
    L6:
        if (r12 >= r13) goto L7;
    }

    @Override // l.b
    public boolean a(float r5) {
        throw new IllegalStateException("not implemented");
    }

    @Override // l.b
    public v.a b() {
        throw new IllegalStateException("not implemented");
    }

    @Override // l.b
    public boolean c(float r5) {
        return false;
    }

    @Override // r0.c
    public Object create() {
        return new g(MessageDigest.getInstance("SHA-256"));
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(d r5) {
        return ZonedDateTime.from(r5);
    }

    @Override // gc.a
    public void e(wc.g r5, ug.d r10) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r10, "info");
        tc.c r11 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.base.i r12 = (com.bytedance.ies.bullet.service.base.i) tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.i.class, r5.f22855y);
        if (r12 == null) goto L18;
        x r13 = new x((String) r10.f22357b);
        k r14 = r5.f22846o;
        if (r14 == null) goto L7;
        ad.a r15 = (ad.a) r14.b(ad.a.class);
    L8:
        if (r15 == null) goto L10;
        r13.f6027j = r15;
        r13.f6023b = (String) r10.f22358c;
    L16:
        r13.f6024c = null;
        r13.e = (JSONObject) r10.f;
        r13.f = (JSONObject) r10.d;
        r13.f6026i = (Boolean) r10.e;
        r13.g = null;
        r13.f6025h = (JSONObject) r10.g;
        ((com.bytedance.ies.bullet.service.monitor.i) r12).d(r13);
        return;
    L10:
        JSONObject r16 = (JSONObject) r10.f;
        if (r16 == null) goto L14;
        String r17 = r16.getString("res_url");
        if (r17 == null) goto L14;
    L15:
        r13.f6023b = r17;
    L14:
        r17 = (String) r10.f22358c;
        goto L15
    L7:
        r15 = null;
        goto L8
    }

    @Override // l.b
    public float f() {
        return 0.0f;
    }

    @Override // l.b
    public float g() {
        return 1.0f;
    }

    @Override // bi.a
    public bi.b get() {
        return new r9.c(17);
    }

    @Override // l.b
    public boolean isEmpty() {
        return true;
    }
}
