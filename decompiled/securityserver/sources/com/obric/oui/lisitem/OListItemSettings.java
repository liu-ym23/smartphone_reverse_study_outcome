package com.obric.oui.lisitem;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.securityserver.R;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OListItemSettings extends OListItemGeneral {
    public String A;
    public FrameLayout y;
    public OUIFrameLayout z;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[ListItemHeightMode.values().length];
            r0[0] = 1;
            r0[1] = 2;
        }
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return 0;
    }

    @NotNull
    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.z;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("contentImgBackground");
        throw null;
    }

    @NotNull
    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.y;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mTitleInfo");
        throw null;
    }

    @NotNull
    public final SettingsTrailingView getSettingsTrailingView() {
        return null;
    }

    @Nullable
    public final String getTrailingTextString() {
        return this.A;
    }

    public final void setContentImgBackground(@NotNull OUIFrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.z = r2;
    }

    @Deprecated
    public final void setImageView(@Nullable Drawable r1) {
        throw null;
    }

    public final void setListItemHeightMode(@NotNull ListItemHeightMode r2) {
        Intrinsics.f(r2, "mode");
        int r3 = r2.ordinal();
        if (r3 != 0) goto L5;
        getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_large);
    L11:
        throw null;
    L5:
        if (r3 != 1) goto L7;
        getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_middle);
        goto L11
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final void setListItemSettingsEnabled(boolean r2) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r2);
        if (r2 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    public final void setMTitleInfo(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.y = r2;
    }

    public final void setTrailingText(@NotNull String r1) {
        Intrinsics.f(r1, "text");
        throw null;
    }

    public final void setTrailingTextString(@Nullable String r1) {
        this.A = r1;
        i();
        String r2 = this.A;
        if (r2 == null) goto L5;
        setTrailingText(r2);
    L5:
        setTrailingView(null);
    }

    public final void setTrailingViewMinWidth(int r3) {
        ViewGroup.LayoutParams r0 = getMTrailingElement().getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        FrameLayout r2 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) r0).matchConstraintMinWidth = r3;
        r2.setLayoutParams(r0);
        return;
    }
}
