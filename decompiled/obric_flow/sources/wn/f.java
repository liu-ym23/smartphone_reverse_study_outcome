package wn;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.flow.cardlistpage.R$dimen;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import mt.z;
import org.json.JSONObject;
import org.koin.androidx.scope.ComponentActivityExtKt$registerScopeForLifecycle$1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f22890a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f22891b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f22892c = 3;

    public static final String a(PageInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = r5.getPageUrl();
        if (r10 == null) goto L21;
        if (r10.length() == 0) goto L21;
        String r11 = r5.getPageUrl();
        Intrinsics.checkNotNull(r11);
        ReadableMap r12 = r5.getPageSettings();
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        u0.a r13 = s0.a.f21800c;
        if (r13 != null) goto L10;
    L12:
        if (r12 == null) goto L19;
        Uri.Builder r14 = Uri.parse(r11).buildUpon();
        ReadableMapKeySetIterator r15 = r12.keySetIterator();
    L15:
        if (r15.hasNextKey() == false) goto L18;
        String r16 = r15.nextKey();
        r14.appendQueryParameter(r16, r12.getString(r16));
        goto L15
    L18:
        return r14.build().toString();
    L19:
        return r11;
    L10:
        if (r13.f22199j != true) goto L12;
    L21:
        return r5.getPageUrl();
    }

    public static void c(Uri r5, String r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(r13, "bid");
        x r14 = new x("bdx_monitor_xpool_create_view");
        r14.f6027j = new ad.a(r5);
        JSONObject r15 = com.lynx.tasm.utils.d.k(NotificationCompat.CATEGORY_STATUS, r10);
        if (r12 == null) goto L5;
        r15.put("failed_message", r12);
    L5:
        r15.put("max_count", 3);
        r15.put("remaining_count", 3 - r11);
        r14.e = r15;
        tc.c r16 = tc.c.f22119c;
        i r17 = (i) tc.c.f22119c.a(i.class, r13);
        if (r17 == null) goto L9;
        ((com.bytedance.ies.bullet.service.monitor.i) r17).d(r14);
        return;
    }

    public static final int d(MiniAppWidgetCardModel r5, Context r10) {
        String r11 = r5.getConfig().get("heightPx");
        Float r12 = null;
        if (r11 == null) goto L12;
        Integer r13 = StringsKt.toIntOrNull(r11);
        if (r13 == null) goto L12;
        if (r13.intValue() > 0) goto L10;
        r13 = null;
    L10:
        if (r13 == null) goto L12;
        return r13.intValue();
    L12:
        String r14 = r5.getConfig().get("heightDp");
        if (r14 == null) goto L21;
        Float r15 = StringsKt.toFloatOrNull(r14);
        if (r15 == null) goto L21;
        if (r15.floatValue() <= 0.0f) goto L19;
        r12 = r15;
    L19:
        if (r12 == null) goto L21;
        return RangesKt.coerceAtLeast((int) (r12.floatValue() * r10.getResources().getDisplayMetrics().density), 1);
    L21:
        int r16 = r10.getResources().getDimensionPixelSize(R$dimen.card_height);
        int r17 = r10.getResources().getDimensionPixelSize(R$dimen.normal_space_new);
        int r18 = RangesKt.coerceAtLeast((int) Math.ceil(RangesKt.coerceAtLeast(r5.getSpanY(), 1) / 2.0f), 1);
        return RangesKt.coerceAtLeast((RangesKt.coerceAtLeast(r18 - 1, 0) * r17) + (r16 * r18), r16);
    }

    public static final obric.flow.miniappwidget.c e(MiniAppWidgetCardModel r16, Context r17) {
        String r5 = r16.getId();
        String r10 = r16.getInstanceId();
        obric.flow.miniappwidget.f r15 = new obric.flow.miniappwidget.f(r16.getAppletId(), r16.getWidgetId(), r16.getTitle(), r16.getSpanX(), r16.getSpanY(), r16.getDefinitionId(), null, null, l(r16.getExtras()), 1760);
        Map<String, String> r11 = r16.getConfig();
        String r12 = r16.getDefinitionId();
        String r13 = r11.get("darkMode");
        if (r13 == null) goto L8;
        Boolean r14 = StringsKt.toBooleanStrictOrNull(r13);
        if (r14 == null) goto L8;
        boolean r18 = r14.booleanValue();
    L7:
        boolean r19 = r18;
        String r20 = r11.get("cornerRadius");
        if (r20 == null) goto L12;
        Float r21 = StringsKt.toFloatOrNull(r20);
    L13:
        String r22 = r11.get("paddingLeft");
        if (r22 == null) goto L16;
        Integer r23 = StringsKt.toIntOrNull(r22);
    L17:
        String r24 = r11.get("paddingTop");
        if (r24 == null) goto L20;
        Integer r25 = StringsKt.toIntOrNull(r24);
    L21:
        String r110 = r11.get("paddingRight");
        if (r110 == null) goto L24;
        Integer r111 = StringsKt.toIntOrNull(r110);
    L25:
        String r112 = r11.get("paddingBottom");
        if (r112 == null) goto L28;
        Integer r113 = StringsKt.toIntOrNull(r112);
    L29:
        if (r23 != null) goto L34;
        if (r25 != null) goto L34;
        if (r111 != null) goto L34;
        if (r113 != null) goto L34;
        Rect r26 = null;
    L47:
        String r27 = r11.get("backgroundColor");
        if (r27 != null) goto L75;
        Integer r114 = null;
    L63:
        String r28 = r11.get("elevation");
        if (r28 == null) goto L66;
        Float r115 = StringsKt.toFloatOrNull(r28);
    L67:
        Map r29 = l(r11);
        if (StringsKt.isBlank(r12) == true) goto L74;
        if (r29.containsKey("definitionId") == true) goto L74;
        r29 = MapsKt.plus(r29, TuplesKt.to("definitionId", r12));
    L74:
        return new obric.flow.miniappwidget.c(r5, r10, r15, new obric.flow.miniappwidget.e(r19, r21, r26, r114, r115, r29));
    L66:
        r115 = null;
        goto L67
    L75:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L52
        if (StringsKt.P(r27, "#") == false) goto L54;
        int r30 = Color.parseColor(r27);     // Catch: Throwable -> L52
    L55:
        Object r31 = Result.m124constructorimpl(Integer.valueOf(r30));     // Catch: Throwable -> L52
    L59:
        if (Result.m130isFailureimpl(r31) == false) goto L61;
        r31 = null;
    L61:
        r114 = (Integer) r31;
        goto L63
    L54:
        r30 = Integer.parseInt(r27);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r31 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L34:
        int r118 = 0;
        if (r23 == null) goto L37;
        int r32 = r23.intValue();
    L38:
        if (r25 == null) goto L40;
        int r33 = r25.intValue();
    L41:
        if (r111 == null) goto L43;
        int r119 = r111.intValue();
    L44:
        if (r113 == null) goto L46;
        r118 = r113.intValue();
    L46:
        r26 = new Rect(r32, r33, r119, r118);
        goto L47
    L43:
        r119 = 0;
        goto L44
    L40:
        r33 = 0;
        goto L41
    L37:
        r32 = 0;
        goto L38
    L28:
        r113 = null;
        goto L29
    L24:
        r111 = null;
        goto L25
    L20:
        r25 = null;
        goto L21
    L16:
        r23 = null;
        goto L17
    L12:
        r21 = null;
    L8:
        r18 = ym.a.h(r17);
        goto L7
    }

    public static void f(Uri r5, String r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(r13, "bid");
        x r14 = new x("bdx_monitor_xpool_fetch_view");
        r14.f6027j = new ad.a(r5);
        JSONObject r15 = new JSONObject();
        r15.put(NotificationCompat.CATEGORY_STATUS, r10);
        r15.put("identifier", r12);
        r15.put("max_count", 3);
        r15.put("remaining_count", 3 - r11);
        r14.e = r15;
        tc.c r16 = tc.c.f22119c;
        i r17 = (i) tc.c.f22119c.a(i.class, r13);
        if (r17 == null) goto L6;
        ((com.bytedance.ies.bullet.service.monitor.i) r17).d(r14);
        return;
    }

    public static z g(Callable r5) {
        Object r10 = r5.call();     // Catch: Throwable -> L4
        io.reactivex.internal.functions.e.d(r10, "Scheduler Callable result can't be null");     // Catch: Throwable -> L4
        return (z) r10;
    L4:
        th = move-exception;
        throw io.reactivex.internal.util.d.d(th);
    }

    public static final org.koin.core.scope.a h(ComponentCallbacks r5, LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "owner");
        final org.koin.core.scope.a r11 = ug.a.g(r5).b(h.k(r5), h.l(r5), r5);
        org.koin.androidx.scope.a r12 = new org.koin.androidx.scope.a(r10);
        Intrinsics.checkNotNullParameter(r12, "callback");
        r11.g.add(r12);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "scope");
        r10.getLifecycle().addObserver(new ComponentActivityExtKt$registerScopeForLifecycle$1(r11));
        return r11;
    }

    public static void i() {
        int r5 = hl.b.f17337b;
    }

    public static boolean j(List r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (r5.size() == 0) goto L7;
        return false;
    }

    public static void k(Throwable r5) {
        if (r5 != null) goto L5;
        r5 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L23:
        r5.printStackTrace();
        Thread r10 = Thread.currentThread();
        r10.getUncaughtExceptionHandler().uncaughtException(r10, r5);
        return;
    L5:
        if ((r5 instanceof OnErrorNotImplementedException) == true) goto L23;
        if ((r5 instanceof MissingBackpressureException) == true) goto L23;
        if ((r5 instanceof IllegalStateException) == true) goto L23;
        if ((r5 instanceof NullPointerException) == true) goto L23;
        if ((r5 instanceof IllegalArgumentException) == true) goto L23;
        if ((r5 instanceof CompositeException) == true) goto L23;
        r5 = new UndeliverableException(r5);
        goto L23
    }

    public static final LinkedHashMap l(Map r5) {
        LinkedHashMap r10 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));
        Iterator r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getKey(), (String) r12.getValue());
        goto L4
    L6:
        return r10;
    }

    public abstract void b(Matrix r5, float r10, float r11, float r12, float r13, float r14, float r15);
}
