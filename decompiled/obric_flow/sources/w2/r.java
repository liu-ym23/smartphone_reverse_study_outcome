package w2;

import android.widget.FrameLayout;
import com.bytedance.ai.ex.widget.WidgetRenderService$createWidget$context$1;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.widget.models.OAppletWrap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22707c;
    public final String d;
    public WidgetInfo e;
    public final FrameLayout f;
    public final WidgetRenderService$createWidget$context$1 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f22708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f22709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f22710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OAppletWrap f22711k;

    public r(String r5, String r10, String r11, String r12, WidgetInfo r13, FrameLayout r14, WidgetRenderService$createWidget$context$1 r15, Map r16, LinkedHashMap r17, Map r18, OAppletWrap r19) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        this.f22705a = r5;
        this.f22706b = r10;
        this.f22707c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f22708h = r16;
        this.f22709i = r17;
        this.f22710j = r18;
        this.f22711k = r19;
    }

    public final String a() {
        WidgetInfo r5 = this.e;
        if (r5 == null) goto L5;
        String r10 = r5.getMixtureCardId();
    L6:
        if (r10 == null) goto L12;
        if (r10.length() == 0) goto L12;
        return r10;
    L12:
        return this.f22705a;
    L5:
        r10 = null;
        goto L6
    }
}
