package androidx.core.view;

import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.m;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class ViewKt$ancestors$1 extends m implements l<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = null;

    static {
        INSTANCE = new ViewKt$ancestors$1();
    }

    ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewParent invoke2(ViewParent r1) {
        o.f(r1, "p0");
        return r1.getParent();
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ ViewParent invoke(ViewParent r1) {
        return invoke2(r1);
    }
}
