package s6;

import android.R;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.sdk.xbridge.cn.utils.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.metadata.internal.metadata.ProtoBuf$Modality;
import kotlinx.metadata.internal.protobuf.r;
import kotlinx.metadata.internal.protobuf.s;
import okhttp3.m;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.YearMonth;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements s, kj.c, com.bytedance.sdk.xbridge.cn.utils.a, ug.c, g, i, yq.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f21825b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21826a;

    public /* synthetic */ b(int r5) {
        this.f21826a = r5;
    }

    public static final m c(b r5, String r10) {
        m r11 = new m(r10);
        m.f20699c.put(r10, r11);
        return r11;
    }

    public static com.obric.oui.color.a[] f(com.obric.oui.color.a[] r12, com.obric.oui.color.a[] r13, float r14) {
        Intrinsics.checkNotNullParameter(r12, "fromConfigs");
        Intrinsics.checkNotNullParameter(r13, "toConfigs");
        int[] r5 = cs.b.d;
        com.obric.oui.color.a r10 = com.obric.oui.color.a.f12397c;
        Intrinsics.checkNotNullParameter(r12, "from");
        Intrinsics.checkNotNullParameter(r13, "to");
        ArrayList r11 = new ArrayList(r12.length);
        int r15 = r12.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        com.obric.oui.color.a r17 = r12[r16];
        r11.add(new com.obric.oui.color.b(r17.f12398a, r17.f12399b));
        r16 = r16 + 1;
        goto L3
    L5:
        Object[] r18 = r11.toArray(new com.obric.oui.color.b[0]);
        if (r18 == null) goto L58;
        com.obric.oui.color.b[] r19 = (com.obric.oui.color.b[]) r18;
        ArrayList r20 = new ArrayList(r13.length);
        int r21 = r13.length;
        int r22 = 0;
    L8:
        if (r22 >= r21) goto L10;
        com.obric.oui.color.a r23 = r13[r22];
        r20.add(new com.obric.oui.color.b(r23.f12398a, r23.f12399b));
        r22 = r22 + 1;
        goto L8
    L10:
        Object[] r110 = r20.toArray(new com.obric.oui.color.b[0]);
        if (r110 == null) goto L56;
        com.obric.oui.color.b[] r111 = (com.obric.oui.color.b[]) r110;
        float r112 = Math.max(0.0f, Math.min(1.0f, r14));
        if (r112 > 0.0f) goto L19;
        com.obric.oui.color.b[] r113 = new com.obric.oui.color.b[r19.length];
        int r114 = 0;
    L16:
        if (r114 >= r19.length) goto L46;
        com.obric.oui.color.b r24 = r19[r114];
        r113[r114] = new com.obric.oui.color.b(r24.f12400a, r24.f12401b);
        r114 = r114 + 1;
    L46:
        ArrayList r115 = new ArrayList(r113.length);
        int r116 = r113.length;
        int r25 = 0;
    L47:
        if (r25 >= r116) goto L49;
        com.obric.oui.color.b r26 = r113[r25];
        r115.add(new com.obric.oui.color.a(r26.f12400a, r26.f12401b));
        r25 = r25 + 1;
        goto L47
    L49:
        Object[] r117 = r115.toArray(new com.obric.oui.color.a[0]);
        if (r117 == null) goto L54;
        return (com.obric.oui.color.a[]) r117;
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L19:
        if (r112 < 1.0f) goto L25;
        com.obric.oui.color.b[] r118 = new com.obric.oui.color.b[r111.length];
        int r119 = 0;
    L22:
        if (r119 >= r111.length) goto L24;
        com.obric.oui.color.b r27 = r111[r119];
        r118[r119] = new com.obric.oui.color.b(r27.f12400a, r27.f12401b);
        r119 = r119 + 1;
        goto L22
    L24:
        r113 = r118;
        goto L46
    L25:
        int r28 = Math.max(r19.length, r111.length);
        if (r28 != 0) goto L28;
        r113 = new com.obric.oui.color.b[0];
        goto L46
    L28:
        com.obric.oui.color.b[] r120 = com.obric.oui.color.b.a(r19, r28);
        com.obric.oui.color.b[] r121 = com.obric.oui.color.b.a(r111, r28);
        com.obric.oui.color.b[] r29 = new com.obric.oui.color.b[r28];
        int r30 = 0;
    L29:
        if (r30 >= r28) goto L45;
        com.obric.oui.color.b r31 = r120[r30];
        com.obric.oui.color.b r32 = r121[r30];
        float r33 = Math.max(0.0f, Math.min(1.0f, r112));
        if (r33 > 0.0f) goto L34;
        com.obric.oui.color.b r34 = new com.obric.oui.color.b(r31.f12400a, r31.f12401b);
    L44:
        r29[r30] = r34;
        r30 = r30 + 1;
        goto L29
    L34:
        if (r33 < 1.0f) goto L36;
        r34 = new com.obric.oui.color.b(r32.f12400a, r32.f12401b);
        goto L44
    L36:
        int r122 = ColorUtils.blendARGB(r31.f12400a, r32.f12400a, r33);
        int r35 = r31.f12401b;
        int r36 = r32.f12401b;
        if (r35 != r36) goto L40;
    L43:
        r34 = new com.obric.oui.color.b(r122, r35);
        goto L44
    L40:
        if (r33 < 0.5f) goto L43;
        r35 = r36;
        goto L43
    L45:
        r113 = r29;
        goto L46
    L56:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L58:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static cs.a g(com.obric.oui.color.a[] r30, com.obric.oui.color.a[] r31, com.obric.oui.color.a r32, com.obric.oui.color.a r33, com.obric.oui.color.a r34, com.obric.oui.color.a r35) {
        Intrinsics.checkNotNullParameter(r30, "normal");
        Intrinsics.checkNotNullParameter(r31, "disabled");
        Intrinsics.checkNotNullParameter(r32, "pressedOverlay");
        Intrinsics.checkNotNullParameter(r33, "hoveredOverlay");
        Intrinsics.checkNotNullParameter(r34, "activatedOverlay");
        Intrinsics.checkNotNullParameter(r35, "checkedOverlay");
        int[] r10 = cs.b.d;
        com.obric.oui.color.a r11 = new com.obric.oui.color.a(0, r32.f12399b);
        com.obric.oui.color.a[] r19 = cs.b.a(r30, r11);
        com.obric.oui.color.a[] r18 = cs.b.a(r31, r11);
        com.obric.oui.color.a[] r17 = cs.b.a(r30, r34);
        com.obric.oui.color.a[] r16 = cs.b.a(r30, r35);
        com.obric.oui.color.a[] r14 = cs.b.a(r30, r32);
        com.obric.oui.color.a[] r15 = cs.b.a(r30, r33);
        return new cs.a(new cs.b(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new com.obric.oui.color.a[][]{r16, r16, r17, r17, r14, r15, r16, r17, r18, r19}, r30));
    }

    public static /* synthetic */ cs.a h(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, com.obric.oui.color.a r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        com.obric.oui.color.a[] r5 = r10;
    L6:
        com.obric.oui.color.a r14 = com.obric.oui.color.a.f12397c;
        return g(r10, r5, r12, r14, r14, r14);
    L5:
        r5 = r11;
        goto L6
    }

    public static String i(String r5) {
        if (StringsKt.P(r5, "TLS_") == false) goto L10;
        StringBuilder r10 = new StringBuilder("SSL_");
        if (r5 == null) goto L8;
        r10.append(r5.substring(4));
        return r10.toString();
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L10:
        if (StringsKt.P(r5, "SSL_") == false) goto L17;
        StringBuilder r11 = new StringBuilder("TLS_");
        if (r5 == null) goto L15;
        r11.append(r5.substring(4));
        return r11.toString();
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L17:
        return r5;
    }

    @Override // com.bytedance.sdk.xbridge.cn.utils.a
    public void a(String r5) {
        int r10 = this.f21826a;
        Intrinsics.checkNotNullParameter(r5, "msg");
        switch(r10) {
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        Log.i("BDXBridgeKit", r5.toString());
        return;
    L6:
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.c(LogLevel.f5954b, r5);
    }

    @Override // yq.c
    public CharSequence b(DayOfWeek r5) {
        return r5.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }

    @Override // ug.c
    public Object create(Class r5) {
        if (r5 != wb.a.class) goto L7;
        return new wb.a();
    L7:
        if (r5 != wb.b.class) goto L11;
        return new wb.b();
    L11:
        if (r5 == com.bytedance.ies.bullet.base.settings.b.class) goto L13;
        return null;
    L13:
        return new com.bytedance.ies.bullet.base.settings.b();
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        return YearMonth.from(r5);
    }

    public synchronized m e(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "javaName");     // Catch: Throwable -> L8
        LinkedHashMap r10 = m.f20699c;     // Catch: Throwable -> L8
        m r11 = (m) r10.get(r5);     // Catch: Throwable -> L8
        if (r11 != null) goto L11;
        r11 = (m) r10.get(i(r5));     // Catch: Throwable -> L8
        if (r11 != null) goto L10;
        r11 = new m(r5);     // Catch: Throwable -> L8
    L10:
        r10.put(r5, r11);     // Catch: Throwable -> L8
    L11:
        monitor-exit(this);
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.metadata.internal.protobuf.s
    public r findValueByNumber(int r5) {
        return ProtoBuf$Modality.valueOf(r5);
    }

    public b() {
        this.f21826a = 15;
        Math.ceil(20.0d);
    }
}
