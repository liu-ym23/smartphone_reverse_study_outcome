package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "invoke", "(Landroidx/window/sidecar/SidecarDisplayFeature;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SidecarAdapter$translate$checkedFeature$2 extends q implements l<SidecarDisplayFeature, Boolean> {
    public static final SidecarAdapter$translate$checkedFeature$2 INSTANCE = null;

    static {
        INSTANCE = new SidecarAdapter$translate$checkedFeature$2();
    }

    SidecarAdapter$translate$checkedFeature$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(SidecarDisplayFeature r1) {
        o.f(r1, "$this$require");
        if (r1.getRect().width() == 0) goto L5;
    L8:
        boolean r0 = true;
    L10:
        return Boolean.valueOf(r0);
    L5:
        if (r1.getRect().height() != 0) goto L8;
        r0 = false;
        goto L10
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(SidecarDisplayFeature r1) {
        return invoke2(r1);
    }
}
