package com.obric.oui.panel.header;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OAttributes;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.SimpleColorFilter;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.divider.ODivider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u000fJ\b\u0010\"\u001a\u00020\u000fH\u0016J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020$2\b\b\u0001\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u0005J+\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00100J\u0016\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00072\u0006\u00101\u001a\u00020(J\u0010\u00102\u001a\u00020$2\b\b\u0001\u0010'\u001a\u00020(J\u0016\u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020(J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\nJ\r\u0010=\u001a\u00020$H\u0000¢\u0006\u0002\b>J+\u0010?\u001a\u00020$2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010(2\u0006\u0010B\u001a\u00020\n¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020$H\u0007J\b\u0010E\u001a\u00020$H\u0007J\b\u0010F\u001a\u00020$H\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelDefaultHeader;", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "context", "Landroid/content/Context;", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "title", "", "(Landroid/content/Context;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;)V", "useAutoSwitchTheme", "", "(Landroid/content/Context;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;Z)V", "dividerView", "Lcom/obric/oui/divider/ODivider;", "grabberView", "Landroid/view/View;", "ivBack", "Landroid/widget/ImageView;", "ivClose", "Landroidx/appcompat/widget/AppCompatImageView;", "mainContentView", "rootView", "titleOnPad", "", "getTitleOnPad", "()Ljava/lang/String;", "setTitleOnPad", "(Ljava/lang/String;)V", "tvTitle", "Landroid/widget/TextView;", "getBackView", "getCloseView", "getGrabberView", "getMainContentView", "getView", "hideBackBtn", "", "removeBottomConstraint", "setHeaderBackgroundColor", "color", "", "setOnCloseClickListener", "listener", "setTitle", "charSequence", "drawable", "Landroid/graphics/drawable/Drawable;", "isBold", "(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;)V", "gravity", "setTitleColor", "setTitleSize", PerfConsts.PERF_DISK_FILE_SIZE, "", "unit", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "showBackBtn", "showDivider", InvokeHistoryActivity.PREF_SHOW, "showGrabberView", "showGrabberView$OUI_standardRelease", "switchIconStyle", "iconColor", "iconBgColor", "needBg", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "switchToBlackIconStyle", "switchToPadIconStyle", "switchToWhiteIconStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BasicPanelDefaultHeader extends BasicPanelHeader {
    private final ODivider dividerView;
    private final View grabberView;
    private final ImageView ivBack;
    private final AppCompatImageView ivClose;
    private final View mainContentView;
    private final View rootView;
    private String titleOnPad;
    private final TextView tvTitle;

    public /* synthetic */ BasicPanelDefaultHeader(Context r2, View.OnClickListener r3, CharSequence r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ ImageView access$getIvBack$p(BasicPanelDefaultHeader r0) {
        return r0.ivBack;
    }

    public static final /* synthetic */ AppCompatImageView access$getIvClose$p(BasicPanelDefaultHeader r0) {
        return r0.ivClose;
    }

    public static final /* synthetic */ View access$getRootView$p(BasicPanelDefaultHeader r0) {
        return r0.rootView;
    }

    public BasicPanelDefaultHeader(Context r9, View.OnClickListener r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r12, 0, 4, null);
        final View r13 = View.inflate(BasicPanelHeader.generateThemedContext$default(this, r9, false, 2, null), R.layout.o_basic_panel_normal_header, null);
        Intrinsics.checkNotNullExpressionValue(r13, "inflate(generateThemedCo…anel_normal_header, null)");
        this.rootView = r13;
        int r14 = OAttributes.INSTANCE.resolveDimension(getThemedContext(), R.attr.oui_PanelDefaultHeaderHeight, R.dimen.oui_panel_default_header_height);
        r13.setBackgroundColor(0);
        View r2 = r13.findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(r2, "rootView.findViewById(R.id.iv_close)");
        this.ivClose = (AppCompatImageView) r2;
        View r3 = r13.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r3, "rootView.findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r3;
        View r4 = r13.findViewById(R.id.iv_back);
        Intrinsics.checkNotNullExpressionValue(r4, "rootView.findViewById(R.id.iv_back)");
        this.ivBack = (ImageView) r4;
        View r5 = r13.findViewById(R.id.divider);
        Intrinsics.checkNotNullExpressionValue(r5, "rootView.findViewById(R.id.divider)");
        this.dividerView = (ODivider) r5;
        View r6 = r13.findViewById(R.id.grabber);
        Intrinsics.checkNotNullExpressionValue(r6, "rootView.findViewById(R.id.grabber)");
        this.grabberView = r6;
        View r7 = r13.findViewById(R.id.main_view);
        Intrinsics.checkNotNullExpressionValue(r7, "rootView.findViewById(R.id.main_view)");
        this.mainContentView = r7;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L16;
        r8.height = r14;
        r7.setLayoutParams(r8);
        if (r10 == null) goto L8;
        setOnCloseClickListener(r10);
    L8:
        if (TextUtils.isEmpty(r11) == true) goto L11;
        Intrinsics.checkNotNull(r11);
        setTitle$default(this, r11, null, null, 6, null);
    L11:
        if (ViewCompat.isAttachedToWindow(r13) == false) goto L13;
        int r15 = OUnitExtensionKt.vdp(r13, 44);
        ViewExtensionsKt.increaseHitAreaForViews(access$getRootView$p(this), r15, r15, new View[]{access$getIvBack$p(this), access$getIvClose$p(this)});
        return;
    L13:
        r13.addOnAttachStateChangeListener(new BasicPanelDefaultHeader$special$$inlined$doOnAttach$1(r13, this));
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public /* synthetic */ BasicPanelDefaultHeader(Context r2, View.OnClickListener r3, CharSequence r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public BasicPanelDefaultHeader(Context r2, View.OnClickListener r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, false);
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public void setTitleOnPad(String r1) {
        this.titleOnPad = r1;
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public String getTitleOnPad() {
        return this.tvTitle.getText().toString();
    }

    public final View getGrabberView() {
        return this.grabberView;
    }

    public final void showGrabberView$OUI_standardRelease() {
        AppCompatImageView r0 = this.ivClose;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        r2.setMarginEnd(OUnitExtensionKt.vdp(this.ivClose, 16));
        r0.setLayoutParams(r2);
        ViewExtensionsKt.makeVisible(this.grabberView);
        View r3 = this.mainContentView;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L9;
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        ConstraintLayout.LayoutParams r6 = r5;
        r6.constrainedHeight = true;
        r6.height = getThemedContext().getResources().getDimensionPixelSize(R.dimen.oui_panel_default_header_height_when_grabber);
        r3.setLayoutParams(r5);
        removeBottomConstraint();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void removeBottomConstraint() {
        ConstraintSet r0 = new ConstraintSet();
        r0.clone((ConstraintLayout) this.mainContentView);
        r0.clear(this.ivBack.getId(), 4);
        r0.clear(this.tvTitle.getId(), 4);
        r0.clear(this.ivClose.getId(), 4);
        r0.applyTo((ConstraintLayout) this.mainContentView);
    }

    public final AppCompatImageView getCloseView() {
        return this.ivClose;
    }

    public final ImageView getBackView() {
        return this.ivBack;
    }

    public final View getMainContentView() {
        return this.mainContentView;
    }

    public final void setOnCloseClickListener(View.OnClickListener r4) {
        AppCompatImageView r0 = this.ivClose;
        ViewExtensionsKt.expandTouchArea(r0, OUnitExtensionKt.vdp(r0, 44));
        this.ivClose.setOnClickListener(r4);
    }

    public static /* synthetic */ void setTitle$default(BasicPanelDefaultHeader r0, CharSequence r1, Drawable r2, Boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        r0.setTitle(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitle");
    }

    public final void setTitle(CharSequence r2, Drawable r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "charSequence");
        this.tvTitle.setText(r2);
        if (r3 == null) goto L6;
        r3.setBounds(0, 0, 70, 70);
    L6:
        this.tvTitle.setCompoundDrawables(r3, null, null, null);
        if (Intrinsics.areEqual(r4, true) == false) goto L10;
        this.tvTitle.setTypeface(Typeface.defaultFromStyle(1));
        return;
    }

    public final void setTitle(CharSequence r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "charSequence");
        setTitle$default(this, r8, null, null, 6, null);
        this.tvTitle.setGravity(r9);
    }

    public final void setTitleSize(float r1, int r2) {
        this.tvTitle.setTextSize(r2, r1);
    }

    public final void setTitleColor(int r1) {
        this.tvTitle.setTextColor(r1);
    }

    public final void setHeaderBackgroundColor(int r1) {
        this.rootView.setBackgroundColor(r1);
    }

    public final void hideBackBtn() {
        ViewExtensionsKt.makeInvisible(this.ivBack);
        this.ivBack.setOnClickListener(null);
    }

    public final void setTypeface(Typeface r2) {
        Intrinsics.checkNotNullParameter(r2, "typeface");
        this.tvTitle.setTypeface(r2);
    }

    public final void showBackBtn(View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ViewExtensionsKt.makeVisible(this.ivBack);
        this.tvTitle.setGravity(17);
        this.ivBack.setOnClickListener(r3);
    }

    @Deprecated(message = "use switchIconStyle instead", replaceWith = @ReplaceWith(expression = "switchIconStyle(iconColor, bgColor, needBg)", imports = {}))
    public final void switchToWhiteIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(ContextCompat.getColor(getThemedContext(), R.color.ConstTextInverse));
        Drawable r1 = ContextCompat.getDrawable(getThemedContext(), R.drawable.o_basic_panel_normal_header_close_bg_light);
        SimpleColorFilter r2 = r0;
        this.ivBack.setColorFilter(r2);
        this.ivClose.setColorFilter(r2);
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }

    @Deprecated(message = "use switchIconStyle instead", replaceWith = @ReplaceWith(expression = "switchIconStyle(iconColor, bgColor, needBg)", imports = {}))
    public final void switchToBlackIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(ContextCompat.getColor(getThemedContext(), R.color.TextReverse));
        Drawable r1 = ContextCompat.getDrawable(getThemedContext(), R.drawable.o_basic_panel_normal_header_close_bg_dark);
        SimpleColorFilter r2 = r0;
        this.ivBack.setColorFilter(r2);
        this.ivClose.setColorFilter(r2);
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }

    @Deprecated(message = "use switchIconStyle instead", replaceWith = @ReplaceWith(expression = "switchIconStyle(iconColor, bgColor, needBg)", imports = {}))
    public final void switchToPadIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(ContextCompat.getColor(getThemedContext(), R.color.TextReverse));
        SimpleColorFilter r1 = r0;
        this.ivBack.setColorFilter(r1);
        this.ivClose.setColorFilter(r1);
        Drawable r2 = (Drawable) null;
        this.ivBack.setBackground(null);
        this.ivClose.setBackground(null);
    }

    public static /* synthetic */ void switchIconStyle$default(BasicPanelDefaultHeader r1, Integer r2, Integer r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        r1.switchIconStyle(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchIconStyle");
    }

    public final void switchIconStyle(Integer r2, Integer r3, boolean r4) {
        if (r2 == null) goto L5;
        int r5 = r2.intValue();
        ColorStateList r6 = ContextCompat.getColorStateList(getThemedContext(), r5);
        this.ivBack.setImageTintList(r6);
        this.ivClose.setImageTintList(r6);
    L5:
        Drawable r7 = null;
        if (r4 == true) goto L9;
        this.ivBack.setBackground(null);
        this.ivClose.setBackground(null);
        return;
    L9:
        if (r3 == null) goto L17;
        int r8 = r3.intValue();
        ColorStateList r9 = ContextCompat.getColorStateList(getThemedContext(), r8);
        Drawable r10 = ContextCompat.getDrawable(getThemedContext(), R.drawable.o_icon_bg);
        if (r10 == null) goto L15;
        ((GradientDrawable) r10).setColor(r9);
        r7 = r10;
    L15:
        this.ivBack.setBackground(r7);
        this.ivClose.setBackground(r7);
        return;
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public View getView() {
        return this.rootView;
    }

    public final void showDivider(boolean r1) {
        ViewExtensionsKt.makeVisible(this.dividerView);
    }
}
