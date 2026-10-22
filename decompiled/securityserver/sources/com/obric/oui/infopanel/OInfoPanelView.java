package com.obric.oui.infopanel;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.ViewExtensionsKt;
import d.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OInfoPanelView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;

    @NotNull
    public final ViewGroup getCustomContainer() {
        return null;
    }

    @NotNull
    public final ImageView getTopBannerView() {
        throw null;
    }

    @NotNull
    public final ImageView getTopImgView() {
        b.b("Resources.getSystem()", 1, 32);
        throw null;
    }

    public final void setDesc(@Nullable CharSequence r1) {
        if (r1 != null) goto L6;
        ViewExtensionsKt.d(null);
        throw null;
    L6:
        throw null;
    }

    public final void setInsetTopImg(int r1) {
        getTopBannerView().setImageResource(r1);
    }

    public final void setScrollableDesc(@Nullable CharSequence r1) {
        setDesc(r1);
        getViewTreeObserver().addOnGlobalLayoutListener(null);
    }

    public final void setTitle(@NotNull CharSequence r1) {
        Intrinsics.f(r1, "title");
        throw null;
    }

    public final void setUnInsetImg(int r1) {
        getTopImgView().setImageResource(r1);
    }
}
