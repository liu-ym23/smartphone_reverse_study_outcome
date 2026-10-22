package com.android.settings.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.settings.SettingsApplication;
import com.android.settings.base.BaseFragment;
import com.android.settings.revone.TabletDpiSettingsFragment;
import com.obric.oui.common.util.OContextExtensionKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: UIUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH\u0007J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0004J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0007J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0014\u0010$\u001a\u00020\u0010*\u00020%2\u0006\u0010\u0011\u001a\u00020&H\u0007J\f\u0010'\u001a\u00020\u0010*\u00020(H\u0007J\u0014\u0010'\u001a\u00020\u0010*\u00020(2\u0006\u0010\u0011\u001a\u00020)H\u0007J\f\u0010'\u001a\u00020\u0010*\u00020%H\u0007J\u001c\u0010'\u001a\u00020\u0010*\u00020%2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020+H\u0007J$\u0010'\u001a\u00020\u0010*\u00020%2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000bH\u0007J\u001c\u0010'\u001a\u00020\u0010*\u00020%2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020)H\u0007J\u0014\u0010'\u001a\u00020\u0010*\u00020%2\u0006\u0010\u0011\u001a\u00020&H\u0007J\u001c\u0010'\u001a\u00020\u0010*\u00020%2\u0006\u0010\u0011\u001a\u00020&2\u0006\u0010-\u001a\u00020\u000bH\u0007J\u0014\u0010.\u001a\u00020\u0010*\u00020(2\u0006\u0010/\u001a\u00020\tH\u0007J\u0014\u00100\u001a\u00020\u0010*\u0002012\u0006\u00102\u001a\u00020\u000bH\u0007J\u000e\u00103\u001a\u00020\u0010*\u0004\u0018\u00010\tH\u0007J\u0016\u00103\u001a\u00020\u0010*\u0004\u0018\u00010\t2\u0006\u00104\u001a\u00020\u000bH\u0007J\u000e\u00105\u001a\u00020\u0010*\u0004\u0018\u00010\tH\u0007J2\u00106\u001a\u00020\u0010*\u00020\t2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000b2\b\b\u0002\u0010:\u001a\u00020\u000bJ4\u0010;\u001a\u00020\u0010*\u00020\t2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000b2\b\b\u0002\u0010:\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/android/settings/utils/UIUtils;", "", "()V", "N1_BASELINE_DENSITY", "", "buildNoScaledContext", "Landroid/content/Context;", "context", "buildNoScaledView", "Landroid/view/View;", "layoutId", "", "dp2mm", TabletDpiSettingsFragment.UNIT, "dp2px", "expandTouchArea", "", "view", "extraPadding", "fixLongTextTagUI", "listItemSettings", "Lcom/obric/oui/lisitem/OCardListItem;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "isChangeDisplay", "", "mm2PxHorizontal", "mm", "mm2PxVertical", "px2dp", "pxValue", "updateVerticalLayoutParams", "alignView", "verticalMm2px", "fitMaskSmallTitle", "Lcom/android/settings/base/BaseFragment;", "Landroid/widget/ScrollView;", "fitMaskTitle", "Landroid/view/ViewGroup;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "rootView", "Landroid/widget/ListView;", "marginTop", "topMargin", "fitMaskTitleInCommon", "contentView", "fixLongTextUi", "Lcom/obric/oui/lisitem/OListItemSettings;", "viewWidthDp", "setUpBottomPaddingOnApplyWindowInsets", "bottomPadding", "setUpFakeStatusBarOnApplyWindowInsets", "updateMargin", "left", "top", "right", "bottom", "updatePadding", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UIUtils {
    public static final UIUtils INSTANCE = null;
    public static final float N1_BASELINE_DENSITY = 3.5f;

    public static /* synthetic */ void $r8$lambda$0QGHgmN8nb6WA3exFrx4OPa6mgc(View r0, int r1, int r2, int r3, int r4, View r5) {
        expandTouchArea$lambda$5$lambda$4(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ WindowInsetsCompat $r8$lambda$IZcTkOAGWuEKmyWGWn1wnVq1sUs(View r0, WindowInsetsCompat r1) {
        return setUpFakeStatusBarOnApplyWindowInsets$lambda$11(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat $r8$lambda$MsQ8c7SahU2cak36F_c6YSnPapo(int r0, View r1, WindowInsetsCompat r2) {
        return setUpBottomPaddingOnApplyWindowInsets$lambda$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$NFSU7fILFsxXzBYq8TRIOT-dYZo, reason: not valid java name */
    public static /* synthetic */ void m626$r8$lambda$NFSU7fILFsxXzBYq8TRIOTdYZo(int r0, View r1) {
        expandTouchArea$lambda$5(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat $r8$lambda$lG86MOrcfcGXtaXZ9F59sQTdOWs(View r0, WindowInsetsCompat r1) {
        return setUpBottomPaddingOnApplyWindowInsets$lambda$6(r0, r1);
    }

    static {
        INSTANCE = new UIUtils();
    }

    private UIUtils() {
    }

    public static /* synthetic */ void updateMargin$default(UIUtils r7, View r8, int r9, int r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        int r3 = -1;
    L7:
        if ((r13 & 2) == 0) goto L9;
        int r4 = -1;
    L11:
        if ((r13 & 4) == 0) goto L13;
        int r5 = -1;
    L15:
        if ((r13 & 8) == 0) goto L17;
        int r6 = -1;
    L18:
        r7.updateMargin(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public final void updateMargin(View r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r1;
    L6:
        if (r7 != null) goto L9;
        return;
    L9:
        if (r3 == (-1)) goto L11;
        r7.leftMargin = r3;
    L11:
        if (r4 == (-1)) goto L13;
        r7.topMargin = r4;
    L13:
        if (r5 == (-1)) goto L15;
        r7.rightMargin = r5;
    L15:
        if (r6 == (-1)) goto L17;
        r7.bottomMargin = r6;
    L17:
        r2.setLayoutParams(r7);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static /* synthetic */ void updatePadding$default(View r1, int r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = -1;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = -1;
    L14:
        updatePadding(r1, r2, r3, r4, r5);
    }

    @JvmStatic
    public static final void updatePadding(View r1, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != (-1)) goto L6;
        r2 = r1.getPaddingLeft();
    L6:
        if (r3 != (-1)) goto L9;
        r3 = r1.getPaddingTop();
    L9:
        if (r4 != (-1)) goto L12;
        r4 = r1.getPaddingRight();
    L12:
        if (r5 != (-1)) goto L15;
        r5 = r1.getPaddingBottom();
    L15:
        r1.setPadding(r2, r3, r4, r5);
    }

    public final int dp2px(int r1) {
        return (int) ((r1 * SettingsApplication.getApplication().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int px2dp(float r1) {
        return MathKt.roundToInt(r1 / SettingsApplication.getApplication().getResources().getDisplayMetrics().density);
    }

    @JvmStatic
    public static final void fixLongTextUi(OListItemSettings r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.getSettingsTrailingView().setLayoutParams(new FrameLayout.LayoutParams(INSTANCE.dp2px(r4), -2));
        TextView r5 = r3.getSettingsTrailingView().getTextView();
        r5.setGravity(8388629);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.width = 0;
        r5.setLayoutParams(r6);
    }

    @JvmStatic
    public static final void fixLongTextTagUI(final OCardListItem r2, final Drawable r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "listItemSettings");
        Intrinsics.checkNotNullParameter(r3, "drawable");
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((r4 instanceof Activity) == false) goto L5;
        Activity r5 = (Activity) r4;
    L6:
        if (r5 == null) goto L13;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L14;
        final View r7 = r6.getDecorView();
        if (r7 == null) goto L15;
        r7.getViewTreeObserver().addOnPreDrawListener(new UIUtils$fixLongTextTagUI$1$1(r7, r2, r3));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @JvmStatic
    public static final void updateVerticalLayoutParams(View r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "alignView");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.topToTop = r3.getId();
        r1.bottomToBottom = r3.getId();
        r2.setLayoutParams(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final void expandTouchArea(final View r1, final int r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        r1.post(new UIUtils$$ExternalSyntheticLambda0(r2, r1));
    }

    private static final void expandTouchArea$lambda$5(int r8, final View r9) {
        Intrinsics.checkNotNullParameter(r9, "$view");
        final int r6 = INSTANCE.dp2px(r8);
        Object r10 = r9.getParent();
        if ((r10 instanceof View) == false) goto L5;
        View r11 = (View) r10;
    L6:
        if (r11 == null) goto L9;
        final View r7 = r11;
        r11.post(new UIUtils$$ExternalSyntheticLambda1(r9, r6, r6, r6, r6, r7));
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private static final void expandTouchArea$lambda$5$lambda$4(View r2, int r3, int r4, int r5, int r6, View r7) {
        Intrinsics.checkNotNullParameter(r2, "$view");
        Rect r0 = new Rect();
        r2.setEnabled(true);
        r2.getHitRect(r0);
        r0.left -= r3;
        r0.right += r4;
        r0.top -= r5;
        r0.bottom += r6;
        r7.setTouchDelegate(new TouchDelegate(r0, r2));
    }

    @JvmStatic
    public static final void setUpBottomPaddingOnApplyWindowInsets(final View r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        ViewCompat.setOnApplyWindowInsetsListener(r8, new UIUtils$$ExternalSyntheticLambda3());
        if (ViewCompat.isAttachedToWindow(r8) == false) goto L7;
        updatePadding$default(r8, 0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())), 7, null);
        return;
    L7:
        r8.addOnAttachStateChangeListener(new UIUtils$setUpBottomPaddingOnApplyWindowInsets$$inlined$doOnAttach$1(r8, r8));
    }

    @JvmStatic
    public static final void setUpBottomPaddingOnApplyWindowInsets(final View r8, final int r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        ViewCompat.setOnApplyWindowInsetsListener(r8, new UIUtils$$ExternalSyntheticLambda2(r9));
        if (ViewCompat.isAttachedToWindow(r8) == false) goto L7;
        updatePadding$default(r8, 0, 0, 0, r9, 7, null);
        return;
    L7:
        r8.addOnAttachStateChangeListener(new UIUtils$setUpBottomPaddingOnApplyWindowInsets$$inlined$doOnAttach$2(r8, r8, r9));
    }

    private static final WindowInsetsCompat setUpBottomPaddingOnApplyWindowInsets$lambda$8(int r8, View r9, WindowInsetsCompat r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "insets");
        updatePadding$default(r9, 0, 0, 0, r8, 7, null);
        return r10;
    }

    @JvmStatic
    public static final void setUpFakeStatusBarOnApplyWindowInsets(final View r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Context r0 = r6.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
        Activity r1 = OContextExtensionKt.getActivity(r0);
        if (r1 != null) goto L7;
        return;
    L7:
        ViewGroup r2 = (ViewGroup) r1.findViewById(R.id.content);
        int r3 = 0;
        ViewGroup r4 = null;
        if (r2 == null) goto L10;
        View r5 = r2.getChildAt(0);
    L12:
        if ((r5 instanceof ViewGroup) == false) goto L14;
        r4 = (ViewGroup) r5;
    L14:
        if (r4 == null) goto L23;
        int r7 = r4.getChildCount();
    L16:
        if (r3 >= r7) goto L23;
        View r8 = r4.getChildAt(r3);
        if (r8.getId() != com.android.settings.R.id.fake_status_bar) goto L22;
        if (Intrinsics.areEqual(r8, r6) == true) goto L22;
        return;
    L22:
        r3 = r3 + 1;
    L23:
        ViewCompat.setOnApplyWindowInsetsListener(r6, new UIUtils$$ExternalSyntheticLambda4());
        if (ViewCompat.isAttachedToWindow(r6) == false) goto L26;
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        r9.height = r6.getRootWindowInsets().getInsets(WindowInsetsCompat.Type.statusBars()).top;
        r6.setLayoutParams(r9);
        return;
    L26:
        r6.addOnAttachStateChangeListener(new UIUtils$setUpFakeStatusBarOnApplyWindowInsets$$inlined$doOnAttach$1(r6, r6));
        return;
    L10:
        r5 = null;
        goto L12
    }

    private static final WindowInsetsCompat setUpFakeStatusBarOnApplyWindowInsets$lambda$11(View r2, WindowInsetsCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "insets");
        if (r2.isAttachedToWindow() == false) goto L5;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.height = r3.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        r2.setLayoutParams(r0);
    L5:
        return r3;
    }

    @JvmStatic
    public static final void fitMaskTitle(BaseFragment r4, ScrollView r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "view");
        View r0 = r5.getChildAt(0);
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        OFloatingTitleBar r3 = (OFloatingTitleBar) r4.findViewById(com.android.settings.R.id.view_title);
        r3.setFitsSystemWindows(true);
        r3.requestApplyInsets();
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        r2 = (ViewGroup.MarginLayoutParams) r6;
    L11:
        if (r2 == null) goto L13;
        r2.topMargin = (int) r4.getResources().getDimension(com.android.settings.R.dimen.mask_padding_top);
        r1.setLayoutParams(r2);
    L13:
        r5.requestLayout();
        return;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final void fitMaskSmallTitle(BaseFragment r6, ScrollView r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "view");
        View r1 = r7.getChildAt(0);
        ViewGroup.MarginLayoutParams r3 = null;
        if ((r1 instanceof ViewGroup) == false) goto L5;
        ViewGroup r2 = (ViewGroup) r1;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        OFloatingTitleBar r8 = (OFloatingTitleBar) r6.findViewById(com.android.settings.R.id.view_title);
        r8.setFitsSystemWindows(true);
        r8.requestApplyInsets();
        if ((r2 instanceof LinearLayout) == false) goto L11;
        View r9 = new View(r7.getContext());
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 104, Resources.getSystem().getDisplayMetrics()))));
        ((LinearLayout) r2).addView(r9, 0);
    L16:
        r7.requestLayout();
        return;
    L11:
        ViewGroup.LayoutParams r10 = r2.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r3 = (ViewGroup.MarginLayoutParams) r10;
    L14:
        if (r3 == null) goto L16;
        r3.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 104, Resources.getSystem().getDisplayMetrics()));
        r2.setLayoutParams(r3);
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void fitMaskTitle(BaseFragment r2, ScrollView r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "view");
        View r5 = r3.getChildAt(0);
        ViewGroup.MarginLayoutParams r1 = null;
        if ((r5 instanceof ViewGroup) == false) goto L5;
        ViewGroup r6 = (ViewGroup) r5;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        OFloatingTitleBar r7 = (OFloatingTitleBar) r2.findViewById(com.android.settings.R.id.view_title);
        r7.setFitsSystemWindows(true);
        r7.requestApplyInsets();
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        r1 = (ViewGroup.MarginLayoutParams) r8;
    L11:
        if (r1 == null) goto L14;
        r1.topMargin = r4;
        r6.setLayoutParams(r1);
        return;
    L14:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @JvmStatic
    public static final void fitMaskTitle(BaseFragment r2, View r3, RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "view");
        OFloatingTitleBar r5 = (OFloatingTitleBar) r3.findViewById(com.android.settings.R.id.view_title);
        r5.setFitsSystemWindows(true);
        r5.requestApplyInsets();
        r4.addItemDecoration(new TopSpaceDecoration(MathKt.roundToInt(TypedValue.applyDimension(1, 112, Resources.getSystem().getDisplayMetrics()))));
    }

    @JvmStatic
    public static final void fitMaskTitle(BaseFragment r3, View r4, ListView r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "view");
        OFloatingTitleBar r6 = (OFloatingTitleBar) r4.findViewById(com.android.settings.R.id.view_title);
        r6.setFitsSystemWindows(true);
        r6.requestApplyInsets();
        View r7 = new View(r3.getContext());
        r7.setLayoutParams(new AbsListView.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 112, Resources.getSystem().getDisplayMetrics()))));
        r5.addHeaderView(r7);
    }

    @JvmStatic
    public static final void fitMaskTitle(BaseFragment r1, View r2, ListView r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "view");
        OFloatingTitleBar r5 = (OFloatingTitleBar) r2.findViewById(com.android.settings.R.id.view_title);
        r5.setFitsSystemWindows(true);
        r5.requestApplyInsets();
        View r6 = new View(r1.getContext());
        r6.setLayoutParams(new AbsListView.LayoutParams(-1, r4));
        r3.addHeaderView(r6);
    }

    @JvmStatic
    public static final void fitMaskTitle(BaseFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OFloatingTitleBar r2 = (OFloatingTitleBar) r1.findViewById(com.android.settings.R.id.view_title);
        r2.setFitsSystemWindows(true);
        r2.requestApplyInsets();
    }

    @JvmStatic
    public static final void fitMaskTitle(ViewGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OFloatingTitleBar r2 = (OFloatingTitleBar) r1.getRootView().findViewById(com.android.settings.R.id.view_title);
        r2.setFitsSystemWindows(true);
        r2.requestApplyInsets();
    }

    @JvmStatic
    public static final void fitMaskTitle(ViewGroup r3, RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "view");
        OFloatingTitleBar r5 = (OFloatingTitleBar) r3.getRootView().findViewById(com.android.settings.R.id.view_title);
        r5.setFitsSystemWindows(true);
        r5.requestApplyInsets();
        r4.addItemDecoration(new TopSpaceDecoration(MathKt.roundToInt(TypedValue.applyDimension(1, 112, Resources.getSystem().getDisplayMetrics()))));
    }

    @JvmStatic
    public static final void fitMaskTitleInCommon(ViewGroup r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "contentView");
        OFloatingTitleBar r5 = (OFloatingTitleBar) r3.findViewById(com.android.settings.R.id.view_title);
        r5.setFitsSystemWindows(true);
        r5.requestApplyInsets();
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L6:
        if (r7 == null) goto L9;
        r7.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 112, Resources.getSystem().getDisplayMetrics()));
        r4.setLayoutParams(r7);
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @JvmStatic
    public static final float dp2mm(int r4) {
        DisplayMetrics r0 = INSTANCE.getDisplayMetrics();
        boolean r1 = true;
        float r5 = TypedValue.applyDimension(1, r4, r0);
        float r2 = r0.xdpi;
        if (r2 == 0.0f) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return (r5 / r2) * 25.4f;
    }

    @JvmStatic
    public static final float verticalMm2px(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return (r2 * INSTANCE.getDisplayMetrics(r1).ydpi) * 0.03937008f;
    }

    @JvmStatic
    public static final float mm2PxVertical(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        DisplayMetrics r0 = INSTANCE.getDisplayMetrics(r2);
        if (DeviceBrand.isNubia() == false) goto L6;
        r3 = r3 * (r2.getResources().getDisplayMetrics().density / 3.5f);
    L6:
        return (r3 * r0.ydpi) * 0.03937008f;
    }

    @JvmStatic
    public static final float mm2PxHorizontal(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        DisplayMetrics r0 = INSTANCE.getDisplayMetrics(r2);
        if (DeviceBrand.isNubia() == false) goto L6;
        r3 = r3 * (r2.getResources().getDisplayMetrics().density / 3.5f);
    L6:
        return (r3 * r0.xdpi) * 0.03937008f;
    }

    private final DisplayMetrics getDisplayMetrics() {
        DisplayMetrics r1 = SettingsApplication.getApplication().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(r1, "getDisplayMetrics(...)");
        return r1;
    }

    private final DisplayMetrics getDisplayMetrics(Context r1) {
        DisplayMetrics r0 = r1.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(r0, "getDisplayMetrics(...)");
        return r0;
    }

    @JvmStatic
    public static final Context buildNoScaledContext(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Resources r0 = r8.getResources();
        DisplayMetrics r1 = r0.getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(r1, "getDisplayMetrics(...)");
        Configuration r2 = r0.getConfiguration();
        if (r1.widthPixels != 1260) goto L7;
        if (r1.densityDpi == 560) goto L7;
    L15:
        Configuration r3 = new Configuration(r2);
        if (r1.widthPixels != 1260) goto L18;
        r3.densityDpi = 560;
    L19:
        r3.fontScale = 1.0f;
        Context r9 = r8.createConfigurationContext(r3);
        Intrinsics.checkNotNull(r9);
        return r9;
    L18:
        r3.densityDpi = 480;
    L7:
        if (r1.widthPixels != 1080) goto L11;
        if (r1.densityDpi != 480) goto L15;
    L11:
        if (r2.fontScale != 1.0f) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L15;
        return r8;
    L13:
        r4 = false;
        goto L14
    }

    @JvmStatic
    public static final View buildNoScaledView(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = LayoutInflater.from(buildNoScaledContext(r2)).inflate(r3, null, false);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        return r4;
    }

    @JvmStatic
    public static final int dp2px(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return (int) ((r2 * r1.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @JvmStatic
    public static final boolean isChangeDisplay(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Resources r5 = r4.getResources();
        DisplayMetrics r0 = r5.getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(r0, "getDisplayMetrics(...)");
        Configuration r6 = r5.getConfiguration();
        if (r0.widthPixels != 1260) goto L7;
        if (r0.densityDpi == 560) goto L7;
        return true;
    L7:
        if (r0.widthPixels != 1080) goto L11;
        if (r0.densityDpi == 480) goto L11;
        return true;
    L11:
        if (r6.fontScale != 1.0f) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == true) goto L17;
        return true;
    L17:
        return false;
    L13:
        r7 = false;
        goto L14
    }

    private static final WindowInsetsCompat setUpBottomPaddingOnApplyWindowInsets$lambda$6(View r8, WindowInsetsCompat r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "insets");
        updatePadding$default(r8, 0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())), 7, null);
        return r9;
    }
}
