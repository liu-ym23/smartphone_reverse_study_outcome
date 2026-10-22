package xl;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.lynx.tasm.utils.k;
import com.obric.launcher.widget.R$anim;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements IHostRouterDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend
    public final boolean closeView(cj.d r5, String r10, boolean r11) {
        String r12 = null;
        if (r5 != null) goto L40;
        Activity r13 = null;
    L6:
        if (r13 == null) goto L13;
        ConcurrentHashMap r14 = com.ivy.ivykit.api.bridge.b.f9471a;     // Catch: Exception -> L39
        Intrinsics.checkNotNullParameter(nl.d.class, "clazz");     // Catch: Exception -> L39
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.d.class) == null) goto L13;
        throw new ClassCastException();     // Catch: Exception -> L39
    L13:
        if ((r13 instanceof FragmentActivity) == false) goto L15;
        FragmentActivity r15 = (FragmentActivity) r13;     // Catch: Exception -> L39
    L17:
        if (r15 == null) goto L22;
        FragmentManager r16 = r15.getSupportFragmentManager();     // Catch: Exception -> L39
        if (r16.getBackStackEntryCount() <= 0) goto L22;
        r16.popBackStackImmediate();     // Catch: Exception -> L39
        return true;
    L22:
        if (r5 == null) goto L24;
        com.bytedance.ies.bullet.core.e r17 = (com.bytedance.ies.bullet.core.e) r5.a(com.bytedance.ies.bullet.core.e.class);     // Catch: Exception -> L39
    L25:
        if (r10 != null) goto L27;
    L28:
        if (r17 == null) goto L31;
        r10 = r17.getSessionId();     // Catch: Exception -> L39
    L31:
        if (k.o(r10) == false) goto L33;
        r12 = r10;
    L33:
        if (r12 == null) goto L38;
        Activity r18 = dn.a.F(r5, r12);     // Catch: Exception -> L39
        if (r18 == null) goto L38;
        r18.finish();     // Catch: Exception -> L39
        r18.overridePendingTransition(R$anim.slide_in_left, R$anim.slide_out_right);     // Catch: Exception -> L39
        return true;
    L38:
        return false;
    L27:
        if (r10.length() != 0) goto L31;
    L24:
        r17 = null;
        goto L25
    L15:
        r15 = null;
        goto L17
    L40:
        r13 = r5.mo118c();     // Catch: Exception -> L39
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend
    public final boolean openSchema(cj.d r5, String r10, Map r11, Context r12) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r11, "extraParams");
        Iterator r13 = provideRouteOpenHandlerList(r5).iterator();
        gj.a r14 = null;
        gj.a r15 = null;
    L4:
        if (r13.hasNext() == false) goto L11;
        gj.a r16 = (gj.a) r13.next();
        if (r15 != null) goto L8;
        r14 = r16;
    L8:
        if (r15 == null) goto L10;
        r15.f17101a = r16;
    L10:
        r16.getClass();
        r15 = r16;
        goto L4
    L11:
        boolean r17 = false;
        if (r14 != null) goto L14;
        return false;
    L14:
        if (r17 == true) goto L25;
        if (r14 == null) goto L25;
        if (r5 == null) goto L18;
        Activity r18 = r5.mo118c();     // Catch: Throwable -> L24
    L19:
        r17 = r14.a(r10, r11, r18);     // Catch: Throwable -> L24
        if (r17 == true) goto L25;
        r14 = r14.f17101a;     // Catch: Throwable -> L24
    L24:
        r14 = null;
        goto L14
    L18:
        r18 = null;
    L25:
        return r17;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend
    public final gj.a provideRouteOpenExceptionHandler(cj.d r5) {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend
    public final List provideRouteOpenHandlerList(cj.d r5) {
        return CollectionsKt.listOf(new gj.a[]{new f(0), new f(1)});
    }
}
