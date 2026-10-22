package com.obric.oui.lisitem;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.securityserver.R;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import d.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OCardListItem extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public boolean b;
    public ColorStateList c;
    public int e;
    public int f;

    /* JADX INFO: renamed from: com.obric.oui.lisitem.OCardListItem$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 implements View.OnLayoutChangeListener {
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r0 = OCardListItem.i;
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.lisitem.OCardListItem$2, reason: invalid class name */
    @Metadata
    public final class AnonymousClass2 implements OSwipeLayout.SwipeListener {
        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public final void a() {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public final void b() {
            throw null;
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public final void c() {
            throw null;
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public final void onClose() {
            throw null;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @NotNull
    public final FrameLayout getCardContainer() {
        return null;
    }

    public final int getCardPosition() {
        return this.e;
    }

    public final int getCardType() {
        return this.f;
    }

    @NotNull
    public final OUILinearLayout getContentContainer() {
        return null;
    }

    @Nullable
    public final View getCustomEndView() {
        throw null;
    }

    @Nullable
    public final View getCustomStartView() {
        throw null;
    }

    @Nullable
    public final OCheckBoxLayout getEndCheckBox() {
        if ((getCustomEndView() instanceof OCheckBoxLayout) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OCheckBoxLayout) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    @Nullable
    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OTextView) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    @Nullable
    public final OCheckMark getEndMark() {
        if ((getCustomEndView() instanceof OCheckMark) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OCheckMark) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
    L10:
        return null;
    }

    @Nullable
    public final OSwitch getEndSwitch() {
        if ((getCustomEndView() instanceof OSwitch) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OSwitch) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
    L10:
        return null;
    }

    @NotNull
    public final ImageView getIconView() {
        return null;
    }

    public final boolean getShowCardBg() {
        return this.b;
    }

    @Nullable
    public final OCheckBoxLayout getStartCheckBox() {
        if ((getCustomStartView() instanceof OCheckBoxLayout) == false) goto L10;
        View r1 = getCustomStartView();
        if (r1 == null) goto L9;
        return (OCheckBoxLayout) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    @Nullable
    public final CharSequence getSubTitle() {
        throw null;
    }

    @NotNull
    public final OTextView getSubTitleView() {
        return null;
    }

    @NotNull
    public final OSwipeLayout getSwipeLayout() {
        return null;
    }

    @Nullable
    public final View getSwipeView() {
        throw null;
    }

    @NotNull
    public final ImageView getTailIconView() {
        return null;
    }

    @Nullable
    public final CharSequence getTitle() {
        throw null;
    }

    @NotNull
    public final LinearLayout getTitleContainer() {
        return null;
    }

    @NotNull
    public final OTextView getTitleView() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    public final void setBgColor(int r1) {
        throw null;
    }

    public final void setCardPosition(int r1) {
        this.e = r1;
        throw null;
    }

    public final void setCardType(int r4) {
        this.f = r4;
        if (r4 == 0) goto L11;
        if (r4 != 1) goto L6;
        b.b("Resources.getSystem()", 1, 4);
        throw null;
    L6:
        if (r4 != 2) goto L8;
        throw null;
    L8:
        throw null;
    L11:
        b.b("Resources.getSystem()", 1, 4);
        throw null;
    }

    public final void setContentChecked(boolean r4) {
        if (r4 == true) goto L5;
        throw null;
    L5:
        if (this.c.isStateful() == false) goto L8;
        this.c.getColorForState(FrameLayout.PRESSED_STATE_SET, getResources().getColor(R.color.oui_state_overlay_pressed));
        throw null;
    L8:
        getResources().getColor(R.color.oui_state_overlay_pressed);
        throw null;
    }

    public final void setContentColor(int r2) {
        ColorStateList r3 = ColorStateList.valueOf(r2);
        Intrinsics.e(r3, "ColorStateList.valueOf(color)");
        this.c = r3;
        throw null;
    }

    public final void setCustomEndView(@Nullable View r1) {
        throw null;
    }

    public final void setCustomStartView(@Nullable View r1) {
        throw null;
    }

    public final void setDefaultCustomEndView(int r1) {
        throw null;
    }

    public final void setDefaultCustomStartView(int r1) {
        throw null;
    }

    public final void setDefaultTailIcon(int r2) {
        if (r2 != 0) goto L5;
        setTailIcon(getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_arrow));
        return;
    L5:
        if (r2 != 1) goto L9;
        setTailIcon(getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_chevron));
        return;
    }

    public final void setEnableSwipe(boolean r1) {
        throw null;
    }

    public final void setEnableSwipeDivider(boolean r1) {
        throw null;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        throw null;
    }

    public final void setEndDetailText(@Nullable CharSequence r2) {
        setDefaultCustomEndView(3);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r1 = getCustomEndView();
        if (r1 == null) goto L8;
        ((OTextView) r1).setText(r2);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void setIcon(int r1) {
        if (r1 == 0) goto L5;
        throw null;
    L5:
        throw null;
    }

    public final void setOnContentClickListener(@Nullable View.OnClickListener r1) {
        throw null;
    }

    public final void setOnContentLongClickListener(@Nullable View.OnLongClickListener r1) {
        throw null;
    }

    public final void setShowCardBg(boolean r2) {
        this.b = r2;
        if (r2 == false) goto L6;
        int r3 = 12;
    L5:
        b.b("Resources.getSystem()", 1, r3);
        throw null;
    L6:
        r3 = 20;
        goto L5
    }

    public final void setSubTitle(@Nullable CharSequence r1) {
        throw null;
    }

    public final void setSwipeView(@Nullable View r1) {
        throw null;
    }

    public final void setTailIcon(@Nullable Drawable r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        throw null;
    }

    public final void setTitle(@Nullable CharSequence r1) {
        throw null;
    }

    public final void setCustomEndView(int r1) {
        throw null;
    }

    public final void setCustomStartView(int r1) {
        throw null;
    }

    public final void setSwipeView(int r1) {
        throw null;
    }

    public final void setTailIcon(int r1) {
        if (r1 == 0) goto L5;
        throw null;
    L5:
        throw null;
    }

    public final void setContentColor(@NotNull ColorStateList r2) {
        Intrinsics.f(r2, TypedValues.Custom.S_COLOR);
        this.c = r2;
        throw null;
    }

    public final void setIcon(@Nullable Drawable r1) {
        r1.getClass();
        throw null;
    }
}
