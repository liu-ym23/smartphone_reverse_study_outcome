package zm;

import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.util.LruCache;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.u0;
import com.lynx.tasm.ui.image.FlattenUIImage;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements oo.c, pt.p, ng.a, yq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f23549a;

    public /* synthetic */ z(Object r5) {
        this.f23549a = r5;
    }

    @Override // oo.c
    public void a() {
        Looper r5 = Looper.myLooper();
        Looper r10 = Looper.getMainLooper();
        FlattenUIImage r11 = (FlattenUIImage) this.f23549a;
        if (r5 != r10) goto L6;
        r11.invalidate();
        return;
    L6:
        FlattenUIImage.access$000(r11);
    }

    public void b(int r5) {
        com.bytedance.ies.bullet.core.e r10 = (com.bytedance.ies.bullet.core.e) ((WeakReference) this.f23549a).get();
        if (r10 == null) goto L6;
        r10.f5293c.e(r10, Integer.valueOf(2 - r5), null);
        return;
    }

    public void c(ai.p r5, l4.d r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "actionDispatcher");
        Intrinsics.checkNotNullParameter(r10, "expression");
        if (Intrinsics.areEqual(r10.a(), "c") == false) goto L19;
        String r12 = r10.b();
        if (r12 == null) goto L20;
        JavaOnlyMap r13 = new JavaOnlyMap();
        Object r14 = r10.c();
        if ((r14 instanceof Map) == false) goto L9;
        Map r15 = (Map) r14;
    L10:
        ug.d r16 = (ug.d) this.f23549a;
        if (r15 == null) goto L14;
        r13 = ((com.lynx.tasm.behavior.ui.utils.n) r16.e).m(r15, r11);
    L14:
        if (Intrinsics.areEqual("setData", r12) == false) goto L17;
        Intrinsics.checkNotNullParameter(r16, "airSolutionContext");
        Intrinsics.checkNotNullParameter(r13, "realArguments");
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.c("AirSolution_ActionDispatcher", "updateData: annieXLynxView: data: " + r13);
        ((LinkedHashMap) ((i4.a) r16.d).f17502b).putAll(r13);
        ((AnnieXLynxView) r5.f287b).updateData(r13);
        return;
    L17:
        r5.k(r12, r13, r16);
        return;
    L9:
        r15 = null;
        goto L10
    L20:
        return;
    }

    public void d(long r10) {
        long[] r5 = (long[]) this.f23549a;
        if (r5[0] != 0) goto L5;
        r5[0] = SystemClock.uptimeMillis();
    L5:
        r5[1] = r5[1] + 1;
        if (r10 >= r5[2]) goto L9;
        r5[2] = r10;
    L9:
        if (r10 <= r5[3]) goto L12;
        r5[3] = r10;
        return;
    }

    @Override // ng.a
    public void e(long r5) {
        ((mg.b) this.f23549a).d.put(AsyncTaskType.IO, Long.valueOf(r5));
    }

    public void f(String r12) {
        boolean r5 = r12.startsWith("--> POST");
        StringBuilder r11 = (StringBuilder) this.f23549a;
        if (r5 == false) goto L6;
        r11.setLength(0);
    L6:
        if (r12.startsWith("{") == false) goto L10;
        if (r12.endsWith("}") == false) goto L10;
    L13:
        int r10 = r12.length();
        StringBuilder r13 = new StringBuilder(r10);
        int r14 = 0;
    L14:
        char r15 = '\t';
        if (r14 >= r10) goto L49;
        int r16 = r14 + 1;
        char r17 = r12.charAt(r14);
        if (r17 == '\\') goto L18;
        r13.append(r17);
        r14 = r16;
        goto L14
    L18:
        r14 = r14 + 2;
        char r18 = r12.charAt(r16);
        if (r18 != 'u') goto L36;
        int r19 = 0;
        int r20 = 0;
    L22:
        if (r19 >= 4) goto L33;
        int r21 = r14 + 1;
        char r22 = r12.charAt(r14);
        switch(r22) {
            case 48: goto L31;
            case 49: goto L31;
            case 50: goto L31;
            case 51: goto L31;
            case 52: goto L31;
            case 53: goto L31;
            case 54: goto L31;
            case 55: goto L31;
            case 56: goto L31;
            case 57: goto L31;
            default: goto L25;
        };
    L25:
        switch(r22) {
            case 65: goto L30;
            case 66: goto L30;
            case 67: goto L30;
            case 68: goto L30;
            case 69: goto L30;
            case 70: goto L30;
            default: goto L26;
        };
    L26:
        switch(r22) {
            case 97: goto L29;
            case 98: goto L29;
            case 99: goto L29;
            case 100: goto L29;
            case 101: goto L29;
            case 102: goto L29;
            default: goto L28;
        };
    L29:
        r20 = (((r20 << 4) + 10) + r22) - 97;
    L32:
        r19 = r19 + 1;
        r14 = r21;
        goto L22
    L28:
        throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
    L30:
        r20 = (((r20 << 4) + 10) + r22) - 65;
        goto L32
    L31:
        r20 = ((r20 << 4) + r22) - 48;
        goto L32
    L33:
        r15 = (char) r20;
    L34:
        r13.append(r15);
        goto L14
    L36:
        if (r18 == 't') goto L34;
        if (r18 != 'r') goto L42;
        r15 = '\r';
        goto L34
    L42:
        if (r18 != 'n') goto L45;
        r15 = '\n';
        goto L34
    L45:
        if (r18 != 'f') goto L47;
        r15 = '\f';
        goto L34
    L47:
        r15 = r18;
        goto L34
    L49:
        String r110 = r13.toString();
        if (r110 != null) goto L52;
    L82:
        r12 = "";
    L83:
        r11.append(r12.concat("\n"));
        if (r12.startsWith("<-- END HTTP") == false) goto L104;
        c.m.i("HttpLogger", "" + r11.toString());
        return;
    L104:
        return;
    L52:
        if ("".equals(r110) == true) goto L82;
        StringBuilder r23 = new StringBuilder();
        int r24 = 0;
        char r25 = 0;
        int r26 = 0;
    L56:
        if (r24 >= r110.length()) goto L81;
        char r27 = r110.charAt(r24);
        if (r27 != ',') goto L60;
        r23.append(r27);
        if (r25 == '\\') goto L80;
        r23.append('\n');
        int r28 = 0;
    L78:
        if (r28 >= r26) goto L80;
        r23.append('\t');
        r28 = r28 + 1;
    L80:
        r24 = r24 + 1;
        r25 = r27;
        goto L56
    L60:
        if (r27 != '[') goto L62;
    L72:
        r23.append(r27);
        r23.append('\n');
        r26 = r26 + 1;
        int r29 = 0;
    L73:
        if (r29 >= r26) goto L80;
        r23.append('\t');
        r29 = r29 + 1;
        goto L73
    L62:
        if (r27 != ']') goto L64;
    L68:
        r23.append('\n');
        r26 = r26 - 1;
        int r30 = 0;
    L69:
        if (r30 >= r26) goto L71;
        r23.append('\t');
        r30 = r30 + 1;
    L71:
        r23.append(r27);
        goto L80
    L64:
        if (r27 == '{') goto L72;
        if (r27 == '}') goto L68;
    L81:
        r12 = r23.toString();
    L10:
        if (r12.startsWith("[") == false) goto L83;
        if (r12.endsWith("]") == false) goto L83;
        goto L13
    }

    @Override // pt.p
    public boolean test(Object r5) {
        return ((Class) this.f23549a).isInstance(r5);
    }

    public z(int r5) {
        switch(r5) {
            case 11: goto L7;
            case 12: goto L5;
            default: goto L3;
        };
    L3:
        this.f23549a = new LruCache(500);
        return;
    L5:
        Locale r10 = Locale.getDefault();
        org.threeten.bp.format.b r11 = org.threeten.bp.format.b.f;
        org.threeten.bp.format.s r12 = new org.threeten.bp.format.s();
        r12.g("d");
        this.f23549a = r12.q(r10);
        return;
    L7:
        this.f23549a = new ConcurrentHashMap();
    }

    public x a(LynxContext r10, b0 r11) {
        u0 r5 = r10.K;
        boolean r12 = true;
        if (r5 == null) goto L5;
        boolean r13 = r5.M;
    L6:
        if (r13 == false) goto L8;
        LruCache r14 = (LruCache) this.f23549a;
        x r15 = (x) r14.get(r11);
        if (r15 == null) goto L12;
        return r15;
    L12:
        x r16 = new x(r10, r11);
        q r17 = r11.f23464a.f23460b;
        if (r17.f23526q == false) goto L15;
    L25:
        r12 = false;
    L26:
        if (r12 == false) goto L28;
        r14.put(r11, r16);
    L28:
        return r16;
    L15:
        if (r17.f23527r == true) goto L25;
        Spanned r18 = (Spanned) r16.f23545a.getText();
        h[] r19 = (h[]) r18.getSpans(0, r18.length(), h.class);
        l[] r20 = (l[]) r18.getSpans(0, r18.length(), l.class);
        if (r19 != null) goto L20;
    L21:
        if (r20 == null) goto L26;
        if (r20.length != 0) goto L25;
    L20:
        if (r19.length != 0) goto L25;
    L8:
        return new x(r10, r11);
    L5:
        r13 = true;
        goto L6
    }
}
