package xl;

import android.app.Activity;
import android.net.Uri;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends gj.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f23158b;

    public /* synthetic */ f(int r5) {
        this.f23158b = r5;
    }

    @Override // gj.a
    public final boolean a(String r5, Map r10, Activity r11) {
        switch(this.f23158b) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "extraInfo");
        if (r11 != null) goto L7;
        return false;
    L7:
        return com.bytedance.ies.bullet.base.b.d(r11, Uri.parse(r5));
    L8:
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "extraInfo");
        ConcurrentHashMap r12 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.d.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.d.class) != null) goto L12;
        return false;
    L12:
        throw new ClassCastException();
    }
}
