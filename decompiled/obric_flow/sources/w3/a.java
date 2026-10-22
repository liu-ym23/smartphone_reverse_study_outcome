package w3;

import com.bytedance.android.anniex.container.m;
import kotlin.jvm.internal.Intrinsics;
import r3.b;
import r3.c;
import r3.d;
import ym.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f22712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f22713c;
    public Object d;
    public Object e;

    public a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.f22712b = r5;
        if (r5.f21654c.getBoolean("bundle_annie_x_flow", false) == false) goto L5;
        Object r10 = new com.bytedance.android.anniex.lite.container.a(r5);
    L6:
        this.f22713c = r10;
        this.d = r5.f21648j;
        return;
    L5:
        r10 = new com.bytedance.android.anniex.container.k(r5);
        goto L6
    }

    public a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.f22712b = r5;
        this.d = new m(r5);
        this.e = r5.f21651j;
    }
}
