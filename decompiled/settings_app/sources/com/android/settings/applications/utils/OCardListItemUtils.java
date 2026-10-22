package com.android.settings.applications.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.utils.DisplayUtils;
import com.android.settings.utils.UIUtils;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public class OCardListItemUtils {
    public OCardListItemUtils() {
    }

    public static void initCardItemInAdapter(Adapter r3, OCardListItem r4, int r5) {
        if (r3 == null) goto L16;
        if (r4 == null) goto L17;
        if (r5 < 0) goto L21;
        r4.setCardType(0);
        if (r3.getCount() <= 1) goto L14;
        if (r5 != 0) goto L11;
        r4.setCardPosition(1);
        return;
    L11:
        if (r5 != (r3.getCount() - 1)) goto L13;
        r4.setCardPosition(3);
        return;
    L13:
        r4.setCardPosition(2);
        return;
    L14:
        r4.setCardPosition(0);
        return;
    L21:
        return;
    L17:
        return;
    }

    public static void initCardItemInAdapter(OCardListItem r2, int r3, int r4) {
        if (r2 == null) goto L15;
        if (r4 < 0) goto L19;
        r2.setCardType(0);
        if (r3 <= 1) goto L13;
        if (r4 != 0) goto L10;
        r2.setCardPosition(1);
        return;
    L10:
        if (r4 != (r3 - 1)) goto L12;
        r2.setCardPosition(3);
        return;
    L12:
        r2.setCardPosition(2);
        return;
    L13:
        r2.setCardPosition(0);
        return;
    L19:
        return;
    }

    public static void setTitle(OCardListItem r0, CharSequence r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.setTitle(r1);
        r0.showTitle(true);
    }

    public static void setIcon(OCardListItem r2, Drawable r3) {
        r2.getIconView().setOutlineProvider(null);
        setIcon(r2, r3, -1);
    }

    public static void setIcon(OCardListItem r3, Drawable r4, int r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L7;
        r3.showIcon(false);
        return;
    L7:
        r3.setAppIcon(r4);
        r3.showIcon(true);
        FrameLayout r6 = (FrameLayout) r3.findViewById(R.id.icon_container);
        if (r6 == null) goto L15;
        if (r5 <= 0) goto L16;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
        float r0 = r5;
        r7 = new LinearLayout.LayoutParams(View.MeasureSpec.makeMeasureSpec((int) DisplayUtils.dip2px(r0), 1073741824), View.MeasureSpec.makeMeasureSpec((int) DisplayUtils.dip2px(r0), 1073741824));
    L13:
        float r8 = r5;
        r7.height = (int) DisplayUtils.dip2px(r8);
        r7.width = (int) DisplayUtils.dip2px(r8);
        r6.setLayoutParams(r7);
        return;
    L16:
        return;
    }

    public static void setIconBadge(OCardListItem r5, int r6, int r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 > 0) goto L6;
        return;
    L6:
        r5.showIcon(true);
        ImageView r1 = (ImageView) r5.findViewById(R.id.icon);
        if (r1 == null) goto L33;
        Drawable r2 = r1.getDrawable();
        Drawable r8 = r5.getContext().getDrawable(r6);
        if (r8 != null) goto L12;
        return;
    L12:
        if (r2 == null) goto L14;
        Drawable[] r3 = {r2, r8};
    L15:
        LayerDrawable r9 = new LayerDrawable(r3);
        int r10 = r3.length - 1;
        r9.setLayerGravity(r10, 8388693);
        if (r7 <= 0) goto L31;
        int r11 = (int) DisplayUtils.dip2px(r7);
        int r0 = (int) DisplayUtils.dip2px(28.0f);
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        if (r4 != null) goto L20;
    L24:
        int r12 = r0;
    L25:
        if (r2 == null) goto L30;
        int r13 = r2.getIntrinsicWidth();
        int r14 = r2.getIntrinsicHeight();
        if (r13 <= 0) goto L30;
        if (r14 <= 0) goto L30;
        r11 = (int) (r11 * Math.min(r13 / r0, r14 / r12));
    L30:
        r9.setLayerWidth(r10, r11);
        r9.setLayerHeight(r10, r11);
        goto L31
    L20:
        if (r4.width <= 0) goto L24;
        if (r4.height <= 0) goto L24;
        r0 = r4.width;
        r12 = r4.height;
    L31:
        r1.setImageDrawable(r9);
        return;
    L14:
        r3 = new Drawable[]{r8};
        goto L15
    }

    public static void setChecked(OCardListItem r1, boolean r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getCustomEndView() != null) goto L7;
        return;
    L7:
        if ((r1.getCustomEndView() instanceof OSwitch) == false) goto L12;
        ((OSwitch) r1.getCustomEndView()).setChecked(r2);
        return;
    }

    public static void setMark(OCardListItem r1, boolean r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getCustomEndView() != null) goto L7;
        return;
    L7:
        if ((r1.getCustomEndView() instanceof OCheckMark) == false) goto L12;
        ((OCheckMark) r1.getCustomEndView()).setChecked(r2);
        return;
    }

    public static void setEnabled(OCardListItem r0, boolean r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.setEnabled(r1);
    }

    public static void setContentContainerEnabled(OCardListItem r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        OUICardConstraintLayout r0 = r2.getContentContainer();
        if (r3 == false) goto L7;
        float r1 = 1.0f;
    L8:
        r0.setAlpha(r1);
        r2.getContentContainer().setClickable(r3);
        return;
    L7:
        r1 = 0.3f;
        goto L8
    }

    public static void setEndSwitchEnabled(OCardListItem r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        OUICardConstraintLayout r0 = r2.getContentContainer();
        if (r3 == false) goto L7;
        float r1 = 1.0f;
    L8:
        r0.setAlpha(r1);
        if (r2.getEndSwitch() == null) goto L12;
        r2.getEndSwitch().setClickable(r3);
        return;
    L12:
        return;
    L7:
        r1 = 0.3f;
        goto L8
    }

    public static void setOnCheckedChangeListener(OCardListItem r1, CompoundButton.OnCheckedChangeListener r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getCustomEndView() != null) goto L7;
        return;
    L7:
        if ((r1.getCustomEndView() instanceof OSwitch) == false) goto L12;
        ((OSwitch) r1.getCustomEndView()).setOnCheckedChangeListener(r2);
        return;
    }

    public static OSwitch getSwitchView(OCardListItem r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.getCustomEndView() != null) goto L8;
    L12:
        return null;
    L8:
        if ((r2.getCustomEndView() instanceof OSwitch) == false) goto L12;
        return (OSwitch) r2.getCustomEndView();
    }

    public static void setTrailingText(OCardListItem r2, CharSequence r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (UIUtils.isChangeDisplay(r2.getContext()) == false) goto L7;
        r2.setEndDetailText(r3, UIUtils.dp2px(r2.getContext(), 151));
    L8:
        r2.showCustomEnd(true);
        return;
    L7:
        r2.setEndDetailText(r3);
        goto L8
    }

    public static void setTrailingMultiText(OCardListItem r2, CharSequence r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getCustomEndView() != null) goto L7;
        return;
    L7:
        if ((r2.getCustomEndView() instanceof OTextView) == false) goto L12;
        r2.setEndDetailText(r3);
        OTextView r4 = (OTextView) r2.getCustomEndView();
        r2.setCardType(0);
        r4.setMaxWidth(UIUtils.INSTANCE.dp2px(181));
        r4.setMaxLines(Integer.MAX_VALUE);
        r4.setVisibility(0);
        r4.setGravity(5);
        return;
    }

    public static View getContentView(OCardListItem r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.findViewById(R.id.content_container);
    }

    public static View getCardView(OCardListItem r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getCardContainer();
    }

    public static void setSubTitleString(OCardListItem r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.showSubTitle(true);
        r1.setSubTitle(r2);
    }

    public static boolean isChecked(OCardListItem r1) {
        OSwitch r0 = getSwitchView(r1);
        if (getSwitchView(r1) != null) goto L7;
        return false;
    L7:
        return r0.isChecked();
    }

    public static boolean isEnabled(OCardListItem r0) {
        return r0.isEnabled();
    }

    public static OCardListItem findCardRoot(View r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        ViewParent r2 = r1.getParent();
    L6:
        if (r2 == null) goto L11;
        if ((r2 instanceof OCardListItem) == true) goto L11;
        r2 = r2.getParent();
    L11:
        return (OCardListItem) r2;
    }

    public static void setCustomEndImageView(OCardListItem r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.setDefaultCustomEndView(2);
        r1.showCustomEnd(true);
    }

    public static TextView setCustomEndTipTextView(OCardListItem r1, String r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.getEndDetail() != null) goto L8;
        r1.setDefaultCustomEndView(3);
    L8:
        OTextView r0 = r1.getEndDetail();
        r1.setEndDetailText(r2);
        r1.showCustomEnd(true);
        return r0;
    }

    public static void setDefaultCustomStartView(OCardListItem r1, int r2, String r3, int r4) {
        if (r1 != null) goto L13;
        return;
    L13:
        r1.setCustomStartView(r2);     // Catch: Exception -> L12
        View r5 = r1.getCustomStartView();     // Catch: Exception -> L12
        if (r5 == null) goto L15;
        ((OTextView) r5.findViewById(R.id.custom_start_title)).setText(r3);     // Catch: Exception -> L12
        ImageView r6 = (ImageView) r5.findViewById(R.id.custom_start_image);     // Catch: Exception -> L12
        if (r4 != (-1)) goto L9;
        r6.setVisibility(8);     // Catch: Exception -> L12
    L10:
        r1.showCustomStart(true);     // Catch: Exception -> L12
        return;
    L9:
        r6.setImageResource(r4);     // Catch: Exception -> L12
        goto L10
    L15:
        return;
    }

    public static void setDefaultCustomTitleView(OCardListItem r1, int r2, String r3, int r4) {
        if (r1 != null) goto L14;
        return;
    L14:
        r1.setCustomTitleView(r2, 0);     // Catch: Exception -> L13
        View r5 = r1.getCustomTitleView(0);     // Catch: Exception -> L13
        if (r5 == null) goto L16;
        ((OTextView) r5.findViewById(R.id.custom_start_title)).setText(r3);     // Catch: Exception -> L13
        ImageView r6 = (ImageView) r5.findViewById(R.id.custom_start_image);     // Catch: Exception -> L13
        if (r4 != (-1)) goto L10;
        r6.setVisibility(8);     // Catch: Exception -> L13
    L11:
        r1.showCustomStart(true);     // Catch: Exception -> L13
        return;
    L10:
        r6.setImageResource(r4);     // Catch: Exception -> L13
        goto L11
    L16:
        return;
    }

    public static void updateGroupContainer(ViewGroup r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = r7.getChildCount();
        OCardListItem r2 = null;
        int r4 = 0;
        OCardListItem r3 = null;
    L5:
        if (r4 >= r0) goto L15;
        View r5 = r7.getChildAt(r4);
        if ((r5 instanceof OCardListItem) == false) goto L14;
        OCardListItem r6 = (OCardListItem) r5;
        if (r5.getVisibility() != 0) goto L14;
        if (r3 != null) goto L13;
        r3 = r6;
    L13:
        r6.setCardPosition(2);
        r2 = r6;
    L14:
        r4 = r4 + 1;
        goto L5
    L15:
        if (r2 != r3) goto L19;
        if (r3 == null) goto L19;
        r3.setCardPosition(0);
        return;
    L19:
        if (r3 == null) goto L21;
        r3.setCardPosition(1);
    L21:
        if (r2 == null) goto L28;
        r2.setCardPosition(3);
        return;
    }

    public static void updateGroupContainer(OCardListItem[] r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.length == 0) goto L28;
        int r0 = r7.length;
        OCardListItem r2 = null;
        int r4 = 0;
        OCardListItem r3 = null;
    L7:
        if (r4 >= r0) goto L14;
        OCardListItem r5 = r7[r4];
        if (r5.getVisibility() != 0) goto L13;
        if (r3 != null) goto L12;
        r3 = r5;
    L12:
        r5.setCardPosition(2);
        r2 = r5;
    L13:
        r4 = r4 + 1;
        goto L7
    L14:
        if (r2 != r3) goto L18;
        if (r3 == null) goto L18;
        r3.setCardPosition(0);
        return;
    L18:
        if (r3 == null) goto L20;
        r3.setCardPosition(1);
    L20:
        if (r2 == null) goto L27;
        r2.setCardPosition(3);
        return;
    L27:
        return;
    }

    public static void setTitleRightDrawable(OCardListItem r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        Drawable r3 = r1.getContext().getDrawable(r2);
        r1.getTitleView().setCompoundDrawablesWithIntrinsicBounds(null, null, r3, null);
    }

    public static String getTrailingText(OCardListItem r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.getCustomEndView() != null) goto L8;
    L12:
        return null;
    L8:
        if ((r2.getCustomEndView() instanceof OTextView) == false) goto L12;
        return ((OTextView) r2.getCustomEndView()).getText().toString();
    }
}
