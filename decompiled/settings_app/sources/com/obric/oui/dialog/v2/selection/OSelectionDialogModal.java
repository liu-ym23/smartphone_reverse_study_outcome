package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.base.OBaseDialogModal;
import com.obric.oui.text.OTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSelectionDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001/B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020*J\u0012\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001e\u0010\u001b¨\u00060"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionDialogModal;", "Lcom/obric/oui/dialog/base/OBaseDialogModal;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/selection/OSelectionDialogModal$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/selection/OSelectionDialogModal$Modifier;)V", "bodyContainerView", "Landroid/view/ViewGroup;", "getBodyContainerView", "()Landroid/view/ViewGroup;", "bodyContainerView$delegate", "Lkotlin/Lazy;", "buttonContainerView", "getButtonContainerView", "buttonContainerView$delegate", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "positiveButton", "getPositiveButton", "positiveButton$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initBody", "", "initButtons", "setContainerView", "view", "Landroid/view/View;", "setSubtitleText", "message", "", "setTitleText", "title", "show", "parent", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionDialogModal extends OBaseDialogModal {
    private final Lazy bodyContainerView$delegate;
    private final Lazy buttonContainerView$delegate;
    private final Modifier modifier;
    private final Lazy negativeButton$delegate;
    private final Lazy positiveButton$delegate;
    private final Lazy subtitleTextView$delegate;
    private final Lazy titleTextView$delegate;

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BT\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fR.\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionDialogModal$Modifier;", "", "title", "", "subtitle", "bodyCustomizer", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "Landroid/view/View;", "positiveButton", "Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;", "negativeButton", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;)V", "getBodyCustomizer", "()Lkotlin/jvm/functions/Function1;", "getNegativeButton", "()Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;", "getPositiveButton", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Modifier {
        private final Function1<ViewGroup, View> bodyCustomizer;
        private final OBaseDialogModal.ButtonConfig negativeButton;
        private final OBaseDialogModal.ButtonConfig positiveButton;
        private final CharSequence subtitle;
        private final CharSequence title;

        /* JADX WARN: Multi-variable type inference failed */
        public Modifier(CharSequence r2, CharSequence r3, Function1<? super ViewGroup, ? extends View> r4, OBaseDialogModal.ButtonConfig r5, OBaseDialogModal.ButtonConfig r6) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, "subtitle");
            this.title = r2;
            this.subtitle = r3;
            this.bodyCustomizer = r4;
            this.positiveButton = r5;
            this.negativeButton = r6;
        }

        public /* synthetic */ Modifier(CharSequence r8, CharSequence r9, Function1 r10, OBaseDialogModal.ButtonConfig r11, OBaseDialogModal.ButtonConfig r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 4) == 0) goto L5;
            Function1 r4 = null;
        L7:
            if ((r13 & 8) == 0) goto L9;
            OBaseDialogModal.ButtonConfig r5 = null;
        L11:
            if ((r13 & 16) == 0) goto L13;
            OBaseDialogModal.ButtonConfig r6 = null;
        L14:
            this(r8, r9, r4, r5, r6);
            return;
        L13:
            r6 = r12;
            goto L14
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        public final Function1<ViewGroup, View> getBodyCustomizer() {
            return this.bodyCustomizer;
        }

        public final OBaseDialogModal.ButtonConfig getPositiveButton() {
            return this.positiveButton;
        }

        public final OBaseDialogModal.ButtonConfig getNegativeButton() {
            return this.negativeButton;
        }
    }

    public static /* synthetic */ void $r8$lambda$7fDzo4BY6EttGrNAJIKpk9eu9nY(OSelectionDialogModal r0) {
        m1179show$lambda12(r0);
    }

    public static /* synthetic */ void $r8$lambda$_6it7L83R_pwNq6LB7y7XAUiXZU(Function0 r0, OSelectionDialogModal r1, View r2) {
        m1178initButtons$lambda8$lambda7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$d_T2e4VRVXVgZxIHsJMF5xF7CIQ(Function0 r0, OSelectionDialogModal r1, View r2) {
        m1177initButtons$lambda10$lambda9(r0, r1, r2);
    }

    public OSelectionDialogModal(Context r2, Modifier r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "modifier");
        super(r2);
        this.modifier = r3;
        this.titleTextView$delegate = LazyKt.lazy(new OSelectionDialogModal$titleTextView$2(this));
        this.subtitleTextView$delegate = LazyKt.lazy(new OSelectionDialogModal$subtitleTextView$2(this));
        this.bodyContainerView$delegate = LazyKt.lazy(new OSelectionDialogModal$bodyContainerView$2(this));
        this.buttonContainerView$delegate = LazyKt.lazy(new OSelectionDialogModal$buttonContainerView$2(this));
        this.positiveButton$delegate = LazyKt.lazy(new OSelectionDialogModal$positiveButton$2(this));
        this.negativeButton$delegate = LazyKt.lazy(new OSelectionDialogModal$negativeButton$2(this));
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r3.getTitle());
        setSubtitleText(r3.getSubtitle());
        initBody();
        initButtons();
    }

    public final OTextView getTitleTextView() {
        Object r1 = this.titleTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-titleTextView>(...)");
        return (OTextView) r1;
    }

    public final OTextView getSubtitleTextView() {
        Object r1 = this.subtitleTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-subtitleTextView>(...)");
        return (OTextView) r1;
    }

    private final ViewGroup getBodyContainerView() {
        Object r1 = this.bodyContainerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-bodyContainerView>(...)");
        return (ViewGroup) r1;
    }

    private final ViewGroup getButtonContainerView() {
        Object r1 = this.buttonContainerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-buttonContainerView>(...)");
        return (ViewGroup) r1;
    }

    public final OButton getPositiveButton() {
        Object r1 = this.positiveButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-positiveButton>(...)");
        return (OButton) r1;
    }

    public final OButton getNegativeButton() {
        Object r1 = this.negativeButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-negativeButton>(...)");
        return (OButton) r1;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R.layout.o_selection_dialog;
    }

    public final void setTitleText(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "title");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L13;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r4 = getSubtitleTextView().getLayoutParams();
        if (r4 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r4).topMargin = 0;
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        OTextView r1 = getTitleTextView();
        r1.setVisibility(0);
        r1.setText(r5);
        ViewGroup.LayoutParams r6 = getSubtitleTextView().getLayoutParams();
        if (r6 == null) goto L18;
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        ((ViewGroup.MarginLayoutParams) r6).topMargin = OUnitExtensionKt.cdp(r7, 8);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r0 = false;
        goto L7
    }

    public final void setSubtitleText(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        getSubtitleTextView().setVisibility(8);
        return;
    L8:
        OTextView r2 = getSubtitleTextView();
        r2.setVisibility(0);
        r2.setText(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setContainerView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r2);
    }

    private final void initBody() {
        Function1<ViewGroup, View> r0 = this.modifier.getBodyCustomizer();
        if (r0 == null) goto L7;
        View r1 = r0.invoke(getBodyContainerView());
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r1);
        return;
    }

    private final void initButtons() {
        if (this.modifier.getPositiveButton() != null) goto L8;
        if (this.modifier.getNegativeButton() != null) goto L8;
        getButtonContainerView().setVisibility(8);
        return;
    L8:
        if (this.modifier.getPositiveButton() == null) goto L17;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText(this.modifier.getPositiveButton().getText());
        final Function0<Unit> r0 = this.modifier.getPositiveButton().getOnClick();
        if (r0 == null) goto L13;
        getPositiveButton().setOnClickListener(new OSelectionDialogModal$$ExternalSyntheticLambda0(r0, this));
    L13:
        Function1<OButton, Unit> r1 = this.modifier.getPositiveButton().getCustomizer();
        if (r1 == null) goto L19;
        r1.invoke(getPositiveButton());
    L19:
        if (this.modifier.getNegativeButton() == null) goto L28;
        getNegativeButton().setVisibility(0);
        getNegativeButton().setText(this.modifier.getNegativeButton().getText());
        final Function0<Unit> r2 = this.modifier.getNegativeButton().getOnClick();
        if (r2 == null) goto L24;
        getNegativeButton().setOnClickListener(new OSelectionDialogModal$$ExternalSyntheticLambda1(r2, this));
    L24:
        Function1<OButton, Unit> r3 = this.modifier.getNegativeButton().getCustomizer();
        if (r3 == null) goto L32;
        r3.invoke(getNegativeButton());
        return;
    L32:
        return;
    L28:
        getNegativeButton().setVisibility(8);
        return;
    L17:
        getPositiveButton().setVisibility(8);
        goto L19
    }

    /* JADX INFO: renamed from: initButtons$lambda-8$lambda-7, reason: not valid java name */
    private static final void m1178initButtons$lambda8$lambda7(Function0 r0, OSelectionDialogModal r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$click");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke();
        if (r1.isAutoDismiss() == false) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-10$lambda-9, reason: not valid java name */
    private static final void m1177initButtons$lambda10$lambda9(Function0 r0, OSelectionDialogModal r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$click");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke();
        if (r1.isAutoDismiss() == false) goto L6;
        r1.dismiss();
        return;
    }

    @Override // com.obric.oui.dialog.base.OBaseDialogModal, com.obric.oui.dialog.base.AbstractDialogModal
    public void show(ViewGroup r2) {
        if (getShowAnimRunning() == false) goto L5;
        return;
    L5:
        super.show(r2);
        getBodyContainerView().post(new OSelectionDialogModal$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: show$lambda-12, reason: not valid java name */
    private static final void m1179show$lambda12(OSelectionDialogModal r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        ViewGroup r0 = r4.getBodyContainerView();
        ViewGroup.LayoutParams r1 = r4.getBodyContainerView().getLayoutParams();
        if (r4.getMaxRootViewHeightGap() <= 0) goto L5;
        int r2 = r4.getBodyContainerView().getMeasuredHeight() - r4.getMaxRootViewHeightGap();
    L6:
        r1.height = r2;
        r0.setLayoutParams(r1);
        r4.getBodyContainerView().requestLayout();
        return;
    L5:
        r2 = -2;
        goto L6
    }
}
