package com.obric.oui.selection;

import a.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSelectionSheetItemView extends OListItemGeneral {

    @Metadata
    public static final class Companion {

        @Metadata
        public static final enum CheckStyle extends Enum<CheckStyle> {
            public static final /* synthetic */ CheckStyle[] b = null;

            static {
                b = new CheckStyle[]{new CheckStyle("NONE", 0), new CheckStyle("ICON", 1), new CheckStyle("CHECKBOX", 2)};
            }

            public static CheckStyle valueOf(String r1) {
                return (CheckStyle) Enum.valueOf(CheckStyle.class, r1);
            }

            public static CheckStyle[] values() {
                return (CheckStyle[]) b.clone();
            }
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[Companion.CheckStyle.values().length];
            r0[1] = 1;
            r0[2] = 2;
            r0[0] = 3;
        }
    }

    private final View getCheckMark() {
        View r3 = getMTrailingElement().getChildAt(0);
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L7:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.getChildAt(0);
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    public final void setCheckStyle(@NotNull Companion.CheckStyle r7) {
        Intrinsics.f(r7, "style");
        int r8 = r7.ordinal();
        ImageView r0 = null;
        if (r8 != 0) goto L5;
    L12:
        if (r0 == null) goto L14;
        FrameLayout r9 = new FrameLayout(getContext());
        r9.setLayoutParams(new FrameLayout.LayoutParams(a.d("Resources.getSystem()", 1, 32), a.d("Resources.getSystem()", 1, 24)));
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        r9.addView(r0, r1);
        setTrailingView(r9);
        return;
    L14:
        getMTrailingElement().setVisibility(8);
        return;
    L5:
        if (r8 != 1) goto L7;
        ImageView r10 = new ImageView(getContext());
        Context r3 = r10.getContext();
        Intrinsics.e(r3, "context");
        r10.setImageDrawable(ResourcesCompat.getDrawable(r3.getResources(), R.drawable.o_ic_radio_tick_checked, null));
        r0 = r10;
        goto L12
    L7:
        if (r8 != 2) goto L10;
        Context r11 = getContext();
        Intrinsics.e(r11, "context");
        r0 = new OCheckBox(r11);
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void setChecked(boolean r2) {
        View r1 = getCheckMark();
        if ((r1 instanceof OCheckBox) == false) goto L6;
        ((OCheckBox) r1).setChecked(r2);
        return;
    L6:
        if ((r1 instanceof ImageView) == false) goto L12;
        ImageView r3 = (ImageView) r1;
        if (r2 == false) goto L10;
        int r4 = 0;
    L11:
        r3.setVisibility(r4);
        return;
    L10:
        r4 = 4;
        goto L11
    L12:
        L.a("OSelectionSheetItemView", "checkMark is not OCheckBox or ImageView");
    }

    public final void setIcon(@Nullable Drawable r1) {
        setContentImage(r1);
    }

    public final void setTitle(@NotNull String r2) {
        Intrinsics.f(r2, "str");
        setTitleString(r2);
    }
}
