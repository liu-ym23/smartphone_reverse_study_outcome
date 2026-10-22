package ug;

import ai.j0;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.koin.androidx.fragment.android.KoinFragmentFactory;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f22352a;

    public static Activity a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
    L4:
        if ((r5 instanceof Activity) == true) goto L6;
        if ((r5 instanceof ContextWrapper) == false) goto L10;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L4
    L10:
        return null;
    L6:
        return (Activity) r5;
    }

    public static Context b() {
        if (f22352a != null) goto L17;
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (f22352a == null) goto L13;
        monitor-exit(a.class);     // Catch: Throwable -> L10
        goto L17
    L13:
        throw new IllegalStateException("SettingsManager尚未被配置");     // Catch: Throwable -> L10
    L17:
        return f22352a;
    }

    public static String c(StringBuilder r5, String r10, String r11, String r12) {
        r5.append(r10);
        r5.append(r11);
        String r13 = r5.toString();
        Intrinsics.checkNotNullParameter(r12, "tag");
        return r13;
    }

    public static void d(com.bytedance.ies.bullet.core.e r10, Uri r11, String r12, boolean r13) {
        if (u8.a.q(r10) == false) goto L53;
        String r5 = u8.a.d(r10, "enable_preload");
        if (r5 != null) goto L9;
        r5 = "disable";
    L9:
        if (Intrinsics.areEqual(r5, "disable") == true) goto L54;
        String r14 = u8.a.d(r10, "delay_preload");
        if (r14 != null) goto L14;
        r14 = "0";
    L14:
        boolean r15 = Intrinsics.areEqual(r14, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        if (r15 == false) goto L17;
        if (r13 == true) goto L17;
        return;
    L17:
        if (r15 == true) goto L20;
        if (r13 == false) goto L20;
        return;
    L20:
        KitType r16 = null;
        if (r11 == null) goto L26;
        String r17 = r11.toString();
        if (r17 == null) goto L26;
    L25:
        String r18 = r17;
    L31:
        if (r18 != null) goto L33;
        return;
    L33:
        if (r18.length() == 0) goto L56;
        if (r10 == null) goto L52;
        zm.c r19 = f.f5397a;
        boolean r20 = Intrinsics.areEqual(r5, "all");
        String r21 = r10.getSessionId();
        ad.a r22 = r10.f5303q;
        if (r22 == null) goto L40;
        r16 = r22.b();
    L40:
        if (r16 != KitType.d) goto L43;
        PreloadType r23 = PreloadType.f4333a;
    L42:
        PreloadType r24 = r23;
        boolean r25 = Intrinsics.areEqual(u8.a.c(r10), "ttnet");
        String r26 = "";
        g r27 = new g("");
        String r28 = r10.f;
        if (r28 == null) goto L48;
        r26 = r28;
    L48:
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r27.f22838c = r26;
        r27.f22849r = r12;
        Unit r29 = Unit.INSTANCE;
        f.f(r18, r20, r21, r24, r25, "schema", r27);
        return;
    L43:
        r23 = PreloadType.f4334b;
        goto L42
    L52:
        return;
    L56:
        return;
    L26:
        if (r10 == null) goto L30;
        rd.b r30 = r10.e;
        if (r30 == null) goto L30;
        r17 = (String) new vd.a(r30, "url", null).f22372b;
    L30:
        r18 = null;
        goto L31
    L54:
        return;
    }

    public static void e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Npth.removeAttachUserData(new hd.a(r5, 1), CrashType.ALL);     // Catch: Throwable -> L5
        Npth.removeTag("bullet_url");     // Catch: Throwable -> L5
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L5
        com.bytedance.ies.bullet.service.base.b.d("uninjectBulletUrl", LogLevel.f5954b, "NpthHelper");     // Catch: Throwable -> L5
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.String] */
    public static void f(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Ref.ObjectRef r12 = new Ref.ObjectRef();     // Catch: Throwable -> L6
        r12.element = r5;     // Catch: Throwable -> L6
        if (r10 == false) goto L8;
        r12.element = new ad.a(Uri.parse(r5)).a();     // Catch: Throwable -> L6
    L8:
        Npth.addAttachUserData(new hd.a(r12, 0), CrashType.ALL);     // Catch: Throwable -> L6
        Npth.addTag("bullet_url", (String) r12.element);     // Catch: Throwable -> L6
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L6
        com.bytedance.ies.bullet.service.base.b.d("injectBulletUrl " + ((String) r12.element), LogLevel.f5954b, "NpthHelper");     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static final org.koin.core.a g(ComponentCallbacks r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof org.koin.core.component.a) == true) goto L7;
        org.koin.core.a r10 = su.a.f22013b;
        if (r10 == null) goto L9;
        return r10;
    L9:
        throw new IllegalStateException("KoinApplication has not been started");
    L7:
        return ((KoinFragmentFactory) ((org.koin.core.component.a) r5)).a();
    }

    public static JSONObject i(String r5, String r10, JSONObject r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r12 = r11.optJSONObject(r5);
        if (r12 != null) goto L9;
        return null;
    L9:
        return r12.optJSONObject(r10);
    }

    public static JSONArray j(JSONArray r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = r5.length();
        if (r10 != 0) goto L20;
        return r5;
    L20:
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L19
        int r12 = 0;
    L9:
        if (r12 >= r10) goto L18;
        Object r13 = r5.get(r12);     // Catch: Throwable -> L19
        if ((r13 instanceof JSONObject) == false) goto L14;
        r11.put(k((JSONObject) r13));     // Catch: Throwable -> L19
    L17:
        r12 = r12 + 1;
        goto L9
    L14:
        if ((r13 instanceof JSONArray) == false) goto L16;
        r11.put(j((JSONArray) r13));     // Catch: Throwable -> L19
        goto L17
    L16:
        r11.put(r13);     // Catch: Throwable -> L19
    L18:
        return r5;
    }

    public static JSONObject k(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r10 = r5.keys();
        if (r10 != null) goto L21;
        return r5;
    L21:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L20
    L9:
        if (r10.hasNext() == false) goto L19;
        String r12 = r10.next();     // Catch: Throwable -> L20
        Object r13 = r5.opt(r12);     // Catch: Throwable -> L20
        if ((r13 instanceof JSONObject) == true) goto L13;
        if ((r13 instanceof JSONArray) == true) goto L16;
        r11.put(r12, r13);     // Catch: Throwable -> L20
        goto L9
    L16:
        r11.put(r12, j((JSONArray) r13));     // Catch: Throwable -> L20
        goto L9
    L13:
        r11.put(r12, k((JSONObject) r13));     // Catch: Throwable -> L20
        goto L9
    L19:
        return r11;
    L20:
        return r5;
    }

    public static com.obric.common.oea.foundation.animation.spec.spring.b l(float r5, float r10) {
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r5, r10, 0);
    }

    public static com.obric.common.oea.foundation.animation.spec.spring.b m(Token$Bounce r5, Token$Duration r10) {
        Intrinsics.checkNotNullParameter(r5, "bounce");
        Intrinsics.checkNotNullParameter(r10, "duration");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r5.getDampingRatio(), r10.getStiffness(), 0);
    }

    public static final String n(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "cardTitle");
        Intrinsics.checkNotNullParameter(r11, "cardId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        if (StringsKt.isBlank(r5) == false) goto L8;
        if (r10 != null) goto L6;
        r5 = "";
        goto L8
    L6:
        r5 = r10;
    L8:
        if (StringsKt.isBlank(r5) == false) goto L11;
        r5 = "未命名Widget";
    L11:
        return j0.q(androidx.constraintlayout.motion.widget.a.y("ShowEditPopup(title=", r5, ", cardId=", r11, ", widgetId="), r12, ")");
    }

    public static final String o(com.obric.flow.cardlistpage.ui.component.popupdialog.e r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.c) == false) goto L6;
        com.obric.flow.cardlistpage.ui.component.popupdialog.c r10 = (com.obric.flow.cardlistpage.ui.component.popupdialog.c) r5;
        com.obric.flow.cardlistpage.ui.component.popupdialog.b r11 = r10.f11722b;
        return n(r11.f11720c, r10.f11723c.f11724a, r11.f11718a, String.valueOf(r11.f11719b));
    L6:
        if ((r5 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.d) == false) goto L10;
        return "ShowExternalLongClickPopup";
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
