package w0;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.p;
import com.bytedance.ai.view.popup.AppletPopup;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22674b;

    public c(String r5, int r10) {
        this.f22673a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "pageId");
        this.f22674b = r5;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "pageId");
        this.f22674b = r5;
    }

    @Override // w0.j
    public final View b(PageInfo r12, com.bytedance.ai.model.k r13, com.bytedance.ai.model.k r14) {
        switch(this.f22673a) {
            case 0: goto L45;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r12, "pageInfo");
        if (r12.getPageName() != null) goto L7;
        r14.invoke("pageName is null");
    L44:
        return null;
    L7:
        t0.b r5 = p.f2294c;
        if (r5 == null) goto L10;
        Activity r10 = r5.currentActivity();
    L12:
        if ((r10 instanceof FragmentActivity) == false) goto L14;
        FragmentActivity r11 = (FragmentActivity) r10;
    L15:
        if (r11 != null) goto L17;
        r11 = null;
    L17:
        if (r11 == null) goto L43;
        StringBuilder r15 = new StringBuilder("AppletPopup#");
        String r16 = this.f22674b;
        r15.append(r16.hashCode());
        String r17 = r15.toString();
        Fragment r18 = r11.getSupportFragmentManager().findFragmentByTag(r17);
        String r19 = wn.f.a(r12);
        if ((r18 instanceof AppletPopup) == false) goto L26;
        Intrinsics.checkNotNullParameter("WebViewPopupPageV2", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L23;
        r110.d("WebViewPopupPageV2", "Applet showPopup, oldAppletPopup is AppletPopup");
    L23:
        AIFragmentBase r111 = ((AppletPopup) r18).f2858k;
        if (r111 == null) goto L42;
        r111.c();
    L42:
        r13.invoke(null);
        goto L44
    L26:
        String r20 = "Applet showPopup, oldAppletPopup[" + r18 + "] is not AppletPopup";
        Intrinsics.checkNotNullParameter("WebViewPopupPageV2", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L29;
        r21.d("WebViewPopupPageV2", r20);
    L29:
        if (r19 != null) goto L31;
    L34:
        Uri r22 = null;
    L35:
        boolean r23 = false;
        if (r22 == null) goto L38;
        r23 = r22.getBooleanQueryParameter("showSpeaker", false);
    L38:
        AppletPopup r24 = new AppletPopup();
        nh.b r112 = new nh.b();
        r112.d = this;
        r112.e = r11;
        r112.f20234b = r22;
        r112.f20235c = r23;
        r112.f20233a = r16;
        r112.f = r12;
        r112.g = r19;
        Intrinsics.checkNotNullParameter(r112, "listener");
        r24.K = r112;
        String r113 = "call appletPopup[" + r18 + "] show, tag=" + r17;
        Intrinsics.checkNotNullParameter("WebViewPopupPageV2", "tag");
        t0.d r114 = com.bytedance.ai.utils.c.f2846a;
        if (r114 == null) goto L41;
        r114.d("WebViewPopupPageV2", r113);
    L41:
        r24.show(r11.getSupportFragmentManager(), r17);
        goto L42
    L31:
        if (r19.length() == 0) goto L34;
        r22 = Uri.parse(r19);
        goto L35
    L43:
        r14.invoke("currentActivity is null");
        goto L44
    L14:
        r11 = null;
        goto L15
    L10:
        r10 = null;
        goto L12
    L45:
        Intrinsics.checkNotNullParameter(r12, "pageInfo");
        String r115 = wn.f.a(r12);
        t0.b r25 = p.f2294c;
        if (r25 == null) goto L50;
        Context r26 = r25.currentActivity();
        if (r26 == null) goto L50;
    L51:
        Bundle r116 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("appName", r12.getPageName()), TuplesKt.to("url", r115), TuplesKt.to("pageId", this.f22674b), TuplesKt.to("botId", r12.getBotId()), TuplesKt.to("fullScreen", Boolean.TRUE), TuplesKt.to("appletId", r12.getPackageName())});
        Intrinsics.checkNotNullParameter(r26, "context");
        t0.b r117 = p.f2294c;
        if (r117 == null) goto L54;
        r117.navigateApplet(r26, r116);
    L54:
        r13.invoke(null);
        return null;
    L50:
        r26 = s0.c.a();
        goto L51
    }
}
