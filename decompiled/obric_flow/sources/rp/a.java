package rp;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f21792a;

    public a() {
        if (f21792a != 0) goto L8;
        Intrinsics.checkNotNullParameter("OEA_FOUNDATION", "tag");
        Intrinsics.checkNotNullParameter("init, SDK_BUILD_NO: [20260124-11:14:11|3|6edddd9|20260123-11:35:17_Feature:[FEAT_FW_BLUR]Add the setBlendColors interface to all Blur methods.]", "msg");
        if (b.f21793a == null) goto L7;
        b("OEA_FOUNDATION", "init, SDK_BUILD_NO: [20260124-11:14:11|3|6edddd9|20260123-11:35:17_Feature:[FEAT_FW_BLUR]Add the setBlendColors interface to all Blur methods.]");
        goto L8
    L7:
        b("OEA_FOUNDATION", "init, SDK_BUILD_NO: [20260124-11:14:11|3|6edddd9|20260123-11:35:17_Feature:[FEAT_FW_BLUR]Add the setBlendColors interface to all Blur methods.]");
    L8:
        f21792a++;
    }

    public static void a(String r5, Throwable r10) {
        StringBuilder r11 = androidx.constraintlayout.motion.widget.a.D("SmoothCornerHelper", "tag", r5, "msg", "SmoothCornerHelper->");
        r11.append(r5);
        Log.e("OEA_SDK", r11.toString(), r10);
    }

    public static void b(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Log.i("OEA_SDK", r5 + "->" + r10);
    }
}
