package ym;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static final int a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "otherVersion");
        List r11 = StringsKt.K(r5, new String[]{"."}, 0, 6);
        List r12 = StringsKt.K(r10, new String[]{"."}, 0, 6);
        int r13 = Math.max(r11.size(), r12.size());
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L20;
        String r15 = (String) CollectionsKt.getOrNull(r11, r14);
        if (r15 == null) goto L9;
        Integer r16 = StringsKt.toIntOrNull(r15);
        if (r16 == null) goto L9;
        int r17 = r16.intValue();
    L10:
        String r18 = (String) CollectionsKt.getOrNull(r12, r14);
        if (r18 == null) goto L15;
        Integer r19 = StringsKt.toIntOrNull(r18);
        if (r19 == null) goto L15;
        int r20 = r19.intValue();
    L16:
        if (r17 != r20) goto L18;
        r14 = r14 + 1;
        goto L3
    L18:
        return Intrinsics.compare(r17, r20);
    L15:
        r20 = 0;
    L9:
        r17 = 0;
        goto L10
    L20:
        return 0;
    }

    public static long b(float r5, float r10) {
        int r11 = Float.floatToRawIntBits(r5);
        long r12 = ((long) r11) << 32;
        return ((long) Float.floatToRawIntBits(r10)) | r12;
    }

    public static SsWsApp c(JSONObject r5) {
        SsWsApp r10 = new SsWsApp();
        if (r5 == null) goto L10;
        r10.f4000b = r5.optInt(WsConstants.KEY_CHANNEL_ID);
        r10.d = r5.optInt("app_id");
        r10.e = r5.optString(WsConstants.KEY_DEVICE_ID);
        r10.f = r5.optString("install_id");
        r10.g = r5.optInt("app_version");
        r10.f4002h = r5.optInt(WsConstants.KEY_PLATFORM);
        r10.f4003i = r5.optInt(WsConstants.KEY_FPID);
        r10.f4004j = r5.optString("app_kay");
        r10.f4001c = r5.optString("extra");
        JSONArray r11 = r5.optJSONArray("urls");
        ArrayList r12 = r10.f3999a;
        r12.clear();
        if (r11 == null) goto L10;
        int r13 = r11.length();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L10;
        r12.add(r11.optString(r14));
        r14 = r14 + 1;
    L10:
        return r10;
    }

    public static final com.bytedance.ies.bullet.preloadv2.e d() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.preloadv2.e.class, "cls");
        com.bytedance.ies.bullet.preloadv2.e r10 = (com.bytedance.ies.bullet.preloadv2.e) yc.a.a(com.bytedance.ies.bullet.preloadv2.e.class, "default_bid");
        if (r10 != null) goto L5;
        com.bytedance.ies.bullet.service.base.b.a(4, "getPreLoadV2Service fail", null);
    L5:
        return r10;
    }

    public static final JsonArray e(ReadableArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JsonArray r10 = new JsonArray();
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L19;
        ReadableType r13 = r5.getType(r12);
        if (r13 != null) goto L7;
        int r14 = -1;
    L8:
        switch(r14) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L18;
        };
    L10:
        r10.add(e(r5.getArray(r12)));
        goto L18
    L11:
        r10.add(f(r5.getMap(r12)));
        goto L18
    L12:
        r10.add(r5.getString(r12));
        goto L18
    L13:
        r10.add(Double.valueOf(r5.getDouble(r12)));
        goto L18
    L14:
        r10.add(Long.valueOf(r5.getLong(r12)));
        goto L18
    L15:
        r10.add(Integer.valueOf(r5.getInt(r12)));
        goto L18
    L16:
        r10.add(Boolean.valueOf(r5.getBoolean(r12)));
        goto L18
    L17:
        r10.add(JsonNull.INSTANCE);
    L18:
        r12 = r12 + 1;
        goto L3
    L7:
        r14 = i2.f.f17494a[r13.ordinal()];
        goto L8
    L19:
        return r10;
    }

    public static final JsonObject f(final ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        final JsonObject r10 = new JsonObject();
        Function1 r11 = new i2.e(r5, r10);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        ReadableMapKeySetIterator r12 = r5.keySetIterator();
    L4:
        if (r12.hasNextKey() == false) goto L11;
        String r13 = r12.nextKey();
        if (r13 == null) goto L4;
        if (StringsKt.isBlank(r13) == true) goto L4;
        r11.invoke(r13);
        goto L4
    L11:
        return r10;
    }

    public static final void g(Runnable r5, Throwable r10) {
        if (r10 == null) goto L4;
    L13:
        Throwable r11 = null;
    L14:
        if (r11 == null) goto L20;
        Logger.throwException(r11);
        return;
    L20:
        return;
    L4:
        if ((r5 instanceof Future) == false) goto L13;
        Future r12 = (Future) r5;
        if (r12.isDone() == false) goto L13;
        if (r12.isCancelled() == true) goto L13;
        r12.get();     // Catch: ExecutionException -> L11 Throwable -> L17
    L11:
        e = move-exception;
        r11 = e.getCause();
        goto L14
    }

    public static boolean h(String r10, ContainerType r11) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        if (StringsKt.isBlank(r10) == false) goto L8;
        Intrinsics.checkNotNullParameter("CanIUseUtils", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L7;
        r12.e("CanIUseUtils", "handle empty schema");
    L7:
        return false;
    L8:
        List r13 = StringsKt.J(r10, new char[]{'.'}, 0, 6);
        String r5 = (String) CollectionsKt.getOrNull(r13, 0);
        if (r5 != null) goto L11;
    L40:
        Intrinsics.checkNotNullParameter("CanIUseUtils", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L43;
        r14.e("CanIUseUtils", "API's scope name is empty");
    L43:
        return false;
    L11:
        if (r5.length() == 0) goto L40;
        String r15 = (String) CollectionsKt.getOrNull(r13, 1);
        if (r15 != null) goto L16;
    L36:
        Intrinsics.checkNotNullParameter("CanIUseUtils", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L39;
        r16.e("CanIUseUtils", "API's method name is empty");
    L39:
        return false;
    L16:
        if (r15.length() == 0) goto L36;
        if (r11 != null) goto L23;
        Intrinsics.checkNotNullParameter("CanIUseUtils", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L22;
        r17.e("CanIUseUtils", "Container type is null");
    L22:
        return false;
    L23:
        o1.a r18 = o1.i.f20397c.a(r5 + '.' + r15, r11);
        if (r18 != null) goto L30;
        String r19 = "Not found: " + r5 + '.' + r15 + " with container type: " + r11;
        Intrinsics.checkNotNullParameter("CanIUseUtils", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L28;
        r110.e("CanIUseUtils", r19);
    L28:
        return false;
    L30:
        if (r13.size() != 2) goto L32;
        return true;
    L32:
        ConcurrentHashMap r20 = o1.e.f20389a;
        Class<?> r21 = r18.getClass();
        Intrinsics.checkNotNullParameter(r21, "clazz");
        String r22 = "annotationData: " + ((o1.c) o1.e.f20389a.get(r21));
        Intrinsics.checkNotNullParameter("CanIUseUtils", "tag");
        t0.d r111 = com.bytedance.ai.utils.c.f2846a;
        if (r111 == null) goto L35;
        r111.d("CanIUseUtils", r22);
    L35:
        return false;
    }

    public static boolean i(int r5) {
        int r10 = Color.red(r5);
        int r11 = Color.green(r5);
        int r12 = Color.blue(r5);
        if (r10 != r11) goto L7;
        if (r10 != r12) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean j(int r10) {
        double r5 = ((double) ((r10 >> 16) & 255)) / 255.0d;
        double r11 = ((double) ((r10 >> 8) & 255)) / 255.0d;
        double r12 = l(r5);
        double r13 = l(r11);
        double r14 = r13 * 0.7152d;
        double r15 = l(((double) (r10 & 255)) / 255.0d) * 0.0722d;
        if ((r15 + (r14 + (r12 * 0.2126d))) >= 0.5d) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean k(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = r5.getSystemService("connectivity");
        if (r10 == null) goto L21;
        ConnectivityManager r11 = (ConnectivityManager) r10;
        Network r12 = r11.getActiveNetwork();
        if (r12 != null) goto L7;
        return false;
    L7:
        NetworkCapabilities r13 = r11.getNetworkCapabilities(r12);
        if (r13 != null) goto L11;
        return false;
    L11:
        if (r13.hasTransport(1) == false) goto L14;
    L19:
        return true;
    L14:
        if (r13.hasTransport(0) == true) goto L19;
        if (r13.hasTransport(3) == true) goto L19;
        return false;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public static double l(double r5) {
        if (r5 > 0.04045d) goto L7;
        return r5 / 12.92d;
    L7:
        return Math.pow((r5 + 0.055d) / 1.055d, 2.4d);
    }
}
