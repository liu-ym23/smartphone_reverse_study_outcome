package com.obric.oui.dialog.v2.selection;

import a.a;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSelectionItemView extends ODialogListItemView {

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
        View r3 = getTrailingContainer().getChildAt(0);
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
        if (r8 != 0) goto L5;
        ImageView r9 = null;
    L13:
        if (r9 == null) goto L19;
        FrameLayout r2 = new FrameLayout(getContext());
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        r2.addView(r9, r3);
        ViewGroup.LayoutParams r10 = new ViewGroup.LayoutParams(a.d("Resources.getSystem()", 1, 32), -2);
        FrameLayout r6 = this.m;
        if (r6 == null) goto L17;
        ODialogListItemView.h(r6, r2, r10);
        return;
    L17:
        Intrinsics.m("trailingContainer");
        throw null;
    L19:
        getTrailingContainer().setVisibility(8);
        return;
    L5:
        if (r8 != 1) goto L7;
        r9 = new ImageView(getContext());
        Context r4 = r9.getContext();
        Intrinsics.e(r4, "context");
        r9.setImageDrawable(ResourcesCompat.getDrawable(r4.getResources(), R.drawable.oui_select_list_item_checker, null));
        goto L13
    L7:
        if (r8 != 2) goto L10;
        Context r5 = getContext();
        Intrinsics.e(r5, "context");
        r9 = new OCheckBox(r5);
        goto L13
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
        L.a("OSelectionItemView", "checkMark is not OCheckBox or ImageView");
    }
}
