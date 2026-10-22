package ym;

import android.content.Context;
import android.util.Log;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.base.s;
import com.bytedance.ies.bullet.service.base.t;
import com.bytedance.ies.bullet.service.base.u;
import com.bytedance.ies.bullet.service.base.v;
import com.bytedance.ies.bullet.service.base.w;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.jsbridge.LynxResourceModule;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.http.StatusLine;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lsposed.hiddenapibypass.HiddenApiBypass;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final r a(JSONObject r33) {
        Intrinsics.checkNotNullParameter(r33, "<this>");
        JSONArray r5 = r33.optJSONArray("image");
        JSONArray r10 = r33.optJSONArray("font");
        JSONArray r11 = r33.optJSONArray("video");
        JSONArray r12 = r33.optJSONArray("gecko_channel");
        JSONArray r13 = r33.optJSONArray("js");
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        String r19 = "priority";
        if (r5 == null) goto L20;
        int r110 = r5.length();
        int r111 = 0;
    L5:
        if (r111 >= r110) goto L20;
        int r112 = r110;
        JSONObject r113 = r5.getJSONObject(r111);
        String r114 = r113.optString("url");
        if (r114 != null) goto L9;
    L10:
        JSONArray r21 = r12;
        ArrayList r22 = r16;
    L19:
        r111 = r111 + 1;
        r110 = r112;
        r5 = r5;
        r18 = r18;
        r13 = r13;
        r17 = r17;
        r12 = r21;
        r16 = r22;
        goto L5
    L9:
        if (r114.length() == 0) goto L10;
        String r115 = r113.optString("url");
        int r20 = r113.optInt("priority", 0);
        if (r20 == 0) goto L17;
        r21 = r12;
        r22 = r16;
        boolean r23 = false;
        if (r20 == 1) goto L16;
        int r24 = 3;
    L18:
        r14.add(new u(r115, r24, r113.optBoolean("serial", r23), r113.optBoolean("enableMemory", true)));
        goto L19
    L16:
        r24 = 2;
        goto L18
    L17:
        r24 = 1;
        r21 = r12;
        r22 = r16;
        r23 = false;
    L20:
        JSONArray r116 = r13;
        JSONArray r25 = r12;
        ArrayList r26 = r17;
        ArrayList r27 = r16;
        ArrayList r117 = r18;
        if (r10 == null) goto L37;
        int r28 = r10.length();
        int r29 = 0;
    L23:
        if (r29 >= r28) goto L37;
        JSONObject r118 = r10.getJSONObject(r29);
        String r119 = r118.optString("url");
        if (r119 == null) goto L36;
        if (r119.length() == 0) goto L36;
        String r210 = r118.optString("url");
        int r30 = r118.optInt("priority", 0);
        if (r30 == 0) goto L34;
        if (r30 == 1) goto L33;
        int r211 = 3;
    L35:
        r15.add(new s(r210, r211, r118.optBoolean("serial", false), r118.optBoolean("enableMemory", true), r118.optLong("expire", 600000)));
        goto L36
    L33:
        r211 = 2;
        goto L35
    L34:
        r211 = 1;
    L36:
        r29 = r29 + 1;
    L37:
        if (r11 == null) goto L58;
        int r31 = r11.length();
        int r32 = 0;
    L39:
        if (r32 >= r31) goto L58;
        JSONObject r34 = r11.getJSONObject(r32);
        String r35 = r34.optString("id");
        if (r35 != null) goto L43;
    L44:
        ArrayList r36 = r27;
    L57:
        r32 = r32 + 1;
        r27 = r36;
        goto L39
    L43:
        if (r35.length() == 0) goto L44;
        String r212 = r34.optString("id");
        boolean r213 = r34.optBoolean("h265", true);
        String r214 = r34.optString(LynxResourceModule.URI_KEY);
        JSONArray r37 = r34.getJSONArray("url");
        if (r37 == null) goto L49;
        ArrayList r38 = c(r37);
    L48:
        ArrayList r215 = r38;
        int r120 = r34.optInt("priority", 0);
        if (r120 == 0) goto L55;
        if (r120 == 1) goto L54;
        int r216 = 3;
    L56:
        w r39 = new w(r212, r213, r214, r215, r216, r34.optBoolean("serial", false), r34.optBoolean("enableMemory", true), r34.optLong("expire", 600000));
        r36 = r27;
        r36.add(r39);
        goto L57
    L54:
        r216 = 2;
        goto L56
    L55:
        r216 = 1;
        goto L56
    L49:
        r38 = new ArrayList();
    L58:
        ArrayList r40 = r27;
        if (r25 == null) goto L76;
        int r41 = r25.length();
        int r42 = 0;
    L61:
        if (r42 >= r41) goto L76;
        JSONArray r43 = r25;
        JSONObject r44 = r43.getJSONObject(r42);
        String r121 = r44.optString(LynxMonitorService.KEY_CHANNEL);
        if (r121 != null) goto L65;
    L66:
        ArrayList r45 = r26;
    L75:
        r42 = r42 + 1;
        r25 = r43;
        r26 = r45;
        goto L61
    L65:
        if (r121.length() == 0) goto L66;
        String r46 = r44.optString(LynxMonitorService.KEY_CHANNEL);
        int r47 = r44.optInt("priority", 0);
        if (r47 != 0) goto L70;
        int r48 = 1;
    L74:
        t r122 = new t(r46, r48);
        r45 = r26;
        r45.add(r122);
        goto L75
    L70:
        if (r47 == 1) goto L72;
        r48 = 3;
        goto L74
    L72:
        r48 = 2;
    L76:
        ArrayList r49 = r26;
        if (r116 == null) goto L93;
        int r50 = r116.length();
        int r51 = 0;
    L79:
        if (r51 >= r50) goto L93;
        JSONArray r52 = r116;
        JSONObject r53 = r52.getJSONObject(r51);
        String r123 = r53.optString("url");
        if (r123 != null) goto L83;
    L84:
        ArrayList r54 = r117;
    L92:
        r51 = r51 + 1;
        r116 = r52;
        r117 = r54;
        r19 = r19;
        goto L79
    L83:
        if (r123.length() == 0) goto L84;
        String r217 = r53.optString("url");
        int r124 = r53.optInt(r19, 0);
        if (r124 == 0) goto L90;
        if (r124 == 1) goto L89;
        boolean r125 = false;
        int r218 = 3;
    L91:
        v r126 = new v(r217, r218, r53.optBoolean("serial", r125), r53.optBoolean("enableMemory", true), r53.optString("memoryPriority"), r53.optLong("expire", 600000));
        r54 = r117;
        r54.add(r126);
        goto L92
    L89:
        r125 = false;
        r218 = 2;
        goto L91
    L90:
        r218 = 1;
        r125 = false;
    L93:
        ArrayList r55 = r117;
        if (r49.size() <= 1) goto L97;
        CollectionsKt.sortWith(r49, new ca.d(7));
    L97:
        if (r14.size() <= 1) goto L100;
        CollectionsKt.sortWith(r14, new ca.d(8));
    L100:
        if (r15.size() <= 1) goto L103;
        CollectionsKt.sortWith(r15, new ca.d(9));
    L103:
        if (r40.size() <= 1) goto L106;
        CollectionsKt.sortWith(r40, new ca.d(10));
    L106:
        return new r(r49, r14, r15, r40, r55);
    }

    public static String b(String r5, String r10) {
        return f4.b.b(androidx.constraintlayout.motion.widget.a.D(r5, "packageName", r10, Constant.APPID, "pkg:"), r5, "_id:", r10);
    }

    public static final ArrayList c(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r10 = new ArrayList();
        if (r5.length() <= 0) goto L12;
        int r11 = r5.length() - 1;
        if (r11 < 0) goto L12;
        int r12 = 0;
    L8:
        if ((r5.get(r12) instanceof String) == false) goto L10;
        Object r13 = r5.get(r12);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");
        r10.add((String) r13);
    L10:
        if (r12 == r11) goto L12;
        r12 = r12 + 1;
    L12:
        return r10;
    }

    public static u1.g d(XmlPullParser r15) {
        Intrinsics.checkNotNullParameter(r15, "parser");
        int r5 = r15.getDepth();
        LinkedList r10 = new LinkedList();
        int r11 = r15.getEventType();
        StatusLine r12 = null;
    L4:
        if (r11 != 3) goto L14;
        if (r15.getDepth() != r5) goto L14;
        if (r12 != null) goto L12;
        r12 = u1.g.d;
    L12:
        return new u1.g(r10, r12);
    L14:
        if (r11 != 2) goto L50;
        if (r15.getDepth() != (r5 + 1)) goto L50;
        Property$NodeInfo r13 = x1.b.a(r15);
        if (Intrinsics.areEqual(r13, u1.e.f) == false) goto L46;
        Intrinsics.checkNotNullParameter(r15, "parser");
        int r14 = r15.getDepth();
        LinkedList r16 = new LinkedList();
        int r17 = r15.getEventType();
    L20:
        if (r17 == 3) goto L22;
    L25:
        if (r17 != 2) goto L44;
        if (r15.getDepth() != (r14 + 1)) goto L44;
        r15.getDepth();
        Property$NodeInfo r18 = new Property$NodeInfo(r15.getNamespace(), r15.getName());
        LinkedHashMap r19 = u1.i.f22239a;
        Intrinsics.checkNotNullParameter(r18, "nodeInfo");
        Intrinsics.checkNotNullParameter(r15, "parser");
        u1.j r110 = (u1.j) u1.i.f22239a.get(r18);     // Catch: XmlPullParserException -> L33
        if (r110 == null) goto L37;
        u1.h r111 = r110.a(r15);     // Catch: XmlPullParserException -> L33
    L38:
        r15.getDepth();
        if (r111 == null) goto L41;
        r16.add(r111);
        goto L44
    L41:
        String r20 = "Ignoring unknown property " + r18;
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L44;
        r112.d("CalDavClient", r20);
    L37:
        r111 = null;
    L33:
        e = move-exception;
        String r113 = "Couldn't parse " + r18;
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        t0.d r114 = com.bytedance.ai.utils.c.f2846a;
        if (r114 == null) goto L37;
        r114.w("CalDavClient", r113, e);
    L44:
        r17 = r15.next();
        goto L20
    L22:
        if (r15.getDepth() != r14) goto L25;
        r10.addAll(r16);
        goto L50
    L46:
        if (Intrinsics.areEqual(r13, u1.e.f22225c) == false) goto L50;
        r12 = StatusLine.parse(r15.nextText());     // Catch: ProtocolException -> L49
    L49:
        r12 = u1.g.e;
    L50:
        r11 = r15.next();
        goto L4
    }

    public static final boolean e(String r10) {
        Object r5 = 0;
        if (r10 == null) goto L30;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "versionString");
        List r11 = StringsKt.J(r10, new char[]{'.'}, 0, 6);
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L13;
        Integer r14 = StringsKt.toIntOrNull((String) r13.next());
        if (r14 == null) goto L10;
        int r15 = r14.intValue();
    L11:
        r12.add(Integer.valueOf(r15));
        goto L6
    L10:
        r15 = 0;
        goto L11
    L13:
        if (r12.size() <= 0) goto L15;
        Object r16 = r12.get(0);
    L16:
        int r17 = ((Number) r16).intValue();
        if (1 >= r12.size()) goto L19;
        Object r18 = r12.get(1);
    L20:
        int r19 = ((Number) r18).intValue();
        if (2 >= r12.size()) goto L23;
        r5 = r12.get(2);
    L23:
        int r20 = ((Number) r5).intValue();
        if (r17 > 0) goto L29;
        if (r19 > 0) goto L29;
        if (r20 > 0) goto L29;
        return false;
    L29:
        return true;
    L19:
        r18 = r5;
        goto L20
    L15:
        r16 = r5;
        goto L16
    L30:
        return false;
    }

    public static void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "signature");
        HiddenApiBypass.addHiddenApiExemptions(new String[]{r5});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.w("BounceEdgeEffect", Intrinsics.stringPlus("Failed to bypass hidden API restrictions for ", r5), th);
    }

    public static String g(int r10, Throwable r11) {
        StackTraceElement[] r12 = r11.getStackTrace();
        StringBuilder r5 = new StringBuilder();
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L9;
        StackTraceElement r16 = r12[r14];
        r15 = r15 + 1;
        r5.append("\tat " + r16.getClassName());
        r5.append(".");
        r5.append(r16.getMethodName());
        r5.append("(");
        r5.append(r16.getFileName());
        r5.append(":");
        r5.append(r16.getLineNumber());
        r5.append(")\n");
        if (r15 > r10) goto L9;
        r14 = r14 + 1;
    L9:
        return r5.toString();
    }

    public static boolean h(Context r5) {
        if ((r5.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static final float i(float r5, float r10, float r11) {
        if (r10 != r11) goto L7;
        return 0.0f;
    L7:
        return (r5 - r10) / (r11 - r10);
    }
}
