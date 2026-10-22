package wn;

import ai.j0;
import android.text.TextUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.widgets.LynxEngineAssem;
import com.bytedance.ai.model.widgets.LynxViewFloatingPage;
import com.bytedance.ai.model.widgets.RelaxEngineAssem;
import com.bytedance.ai.model.widgets.RelaxViewFloatingPageV2;
import com.bytedance.ai.model.widgets.WebEngineAssem;
import com.bytedance.ai.model.widgets.WebViewFloatingPageV2;
import com.obric.common.animation.R$id;
import com.obric.flow.cardlistpage.ui.popup.OPopoverLayout;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import ko.r;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static float a(float r5) {
        if (r5 > 0.04045f) goto L6;
        return r5 / 12.92f;
    L6:
        return (float) Math.pow((r5 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float r5) {
        if (r5 > 0.0031308f) goto L6;
        return r5 * 12.92f;
    L6:
        return (float) ((Math.pow(r5, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static final com.bytedance.ai.model.widgets.a c(AppletRuntime r5, PageInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "appletRuntime");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        if (r10.getPageType() != PageType.FLOATING_VIEW) goto L19;
        String r11 = f(r5.f2197h, r10);
        Lazy r12 = v0.e.f;
        com.bytedance.android.anniex.base.service.f.g().getClass();
        Intrinsics.checkNotNullParameter(r5, "appletRuntime");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        Intrinsics.checkNotNullParameter(r11, "renderType");
        RenderType[] r13 = RenderType.f2230a;
        if (Intrinsics.areEqual(r11, "lynx") == false) goto L9;
        return new LynxViewFloatingPage(r5, r10);
    L9:
        if (Intrinsics.areEqual(r11, "relax") == false) goto L13;
        return new RelaxViewFloatingPageV2(r5, r10);
    L13:
        if (Intrinsics.areEqual(r11, "webview") == true) goto L15;
        return null;
    L15:
        return new WebViewFloatingPageV2(r5, r10);
    L19:
        return new com.bytedance.ai.model.widgets.c(r5, r10);
    }

    public static final com.bytedance.ai.model.widgets.a d(com.bytedance.ai.model.widgets.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof com.bytedance.ai.model.widgets.c) == false) goto L5;
        com.bytedance.ai.model.widgets.c r10 = (com.bytedance.ai.model.widgets.c) r5;
    L6:
        if (r10 == null) goto L21;
        String r11 = r5.h();
        RenderType[] r12 = RenderType.f2230a;
        if (Intrinsics.areEqual(r11, "webview") == false) goto L12;
        Reflection.getOrCreateKotlinClass(WebEngineAssem.class);
        return r5;
    L12:
        if (Intrinsics.areEqual(r11, "lynx") == false) goto L16;
        Reflection.getOrCreateKotlinClass(LynxEngineAssem.class);
        return r5;
    L16:
        if (Intrinsics.areEqual(r11, "relax") == false) goto L20;
        Reflection.getOrCreateKotlinClass(RelaxEngineAssem.class);
        return r5;
    L20:
        throw new IllegalStateException("Don't support this renderType " + r5.h() + " yet");
    L21:
        return r5;
    L5:
        r10 = null;
        goto L6
    }

    public static com.bytedance.ies.bullet.secure.f e() {
        return (com.bytedance.ies.bullet.secure.f) com.bytedance.ies.bullet.secure.f.f5904c.getValue();
    }

    public static final String f(Applet r5, PageInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "applet");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        List r11 = r5.G;
        Page r12 = null;
        Object r13 = null;
        if (r11 == null) goto L11;
        Iterator r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((Page) r15).pageId(), r10.getPageName()) == false) goto L6;
        r13 = r15;
    L10:
        r12 = (Page) r13;
    L11:
        if (r12 == null) goto L17;
        String r16 = r12.getRenderType();
        if (r16 == null) goto L17;
        return r16;
    L17:
        return r5.f2268o;
    }

    public static int j(float r10, int r11, int r12) {
        if (r11 != r12) goto L4;
        return r11;
    L4:
        float r5 = ((r11 >> 24) & 255) / 255.0f;
        float r13 = ((r12 >> 24) & 255) / 255.0f;
        float r14 = a(((r11 >> 16) & 255) / 255.0f);
        float r15 = a(((r11 >> 8) & 255) / 255.0f);
        float r16 = a((r11 & 255) / 255.0f);
        float r17 = a(((r12 >> 16) & 255) / 255.0f);
        float r18 = a(((r12 >> 8) & 255) / 255.0f);
        float r19 = a((r12 & 255) / 255.0f);
        float r20 = j0.b(r13, r5, r10, r5);
        float r21 = j0.b(r17, r14, r10, r14);
        float r22 = j0.b(r18, r15, r10, r15);
        float r23 = j0.b(r19, r16, r10, r16);
        float r24 = b(r21) * 255.0f;
        float r25 = b(r22) * 255.0f;
        float r26 = b(r23) * 255.0f;
        return Math.round(r26) | (((Math.round(r24) << 16) | (Math.round(r20 * 255.0f) << 24)) | (Math.round(r25) << 8));
    }

    public static final String k(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return yu.a.a(Reflection.getOrCreateKotlinClass(r5.getClass())) + '@' + r5.hashCode();
    }

    public static final wu.c l(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new wu.c(Reflection.getOrCreateKotlinClass(r5.getClass()));
    }

    public static boolean m(String r5, ArrayList r10, ArrayList r11) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        if (td.d.d(r10) == true) goto L23;
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L23;
        if (r5.contains((String) r12.next()) == false) goto L9;
        return true;
    L23:
        String r13 = new URI(r5).getPath();     // Catch: Throwable -> L22
        if (td.d.d(r11) == true) goto L21;
        Iterator r14 = r11.iterator();     // Catch: Throwable -> L22
    L17:
        if (r14.hasNext() == false) goto L21;
        if (((Pattern) r14.next()).matcher(r13).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    public static ArrayList n(String r5, JSONObject r10) {
        JSONArray r11 = r10.optJSONArray(r5);     // Catch: Exception -> L16
        if (r11 == null) goto L15;
        if (r11.length() == 0) goto L15;
        int r12 = r11.length();     // Catch: Exception -> L16
        ArrayList r13 = new ArrayList(r12);     // Catch: Exception -> L16
        int r14 = 0;
    L9:
        if (r14 >= r12) goto L14;
        String r15 = r11.getString(r14);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r15) == true) goto L13;
        r13.add(r15);     // Catch: Exception -> L16
    L13:
        r14 = r14 + 1;
        goto L9
    L14:
        return r13;
    L15:
        return null;
    }

    public static ArrayList o(String r5, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(r5);     // Catch: Exception -> L20
        if (r11 != null) goto L6;
    L9:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        return null;
    L12:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L20
        Iterator<String> r14 = r11.keys();     // Catch: Exception -> L20
    L13:
        if (r14.hasNext() == false) goto L19;
        String r15 = r14.next();     // Catch: Exception -> L20
        if (r11.optInt(r15) != 1) goto L13;
        r13.add(r15);     // Catch: Exception -> L20
        goto L13
    L19:
        return r13;
    L6:
        if (r11.length() == 0) goto L9;
        r12 = false;
    L20:
        return null;
    }

    public static final com.obric.oui.animation.easy.d p(OPopoverLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r10 = r5.getTag(R$id.view_property_spring_animator_key);
        if ((r10 instanceof com.obric.oui.animation.easy.d) == false) goto L5;
        com.obric.oui.animation.easy.d r11 = (com.obric.oui.animation.easy.d) r10;
    L6:
        if (r11 != null) goto L9;
        com.obric.oui.animation.easy.d r12 = new com.obric.oui.animation.easy.d(r5);
        r5.setTag(R$id.view_property_spring_animator_key, r12);
        return r12;
    L9:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public abstract void g(r r5, com.bytedance.lynx.media.b r10);

    public abstract void i(r r5, go.a r10);
}
