package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.base.AbstractDialogModal;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import com.obric.oui.utils.KtExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAlertDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u0004\u0018\u00010\u0014J\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010'\u001a\u0004\u0018\u00010%J\b\u0010(\u001a\u0004\u0018\u00010\"J\b\u0010)\u001a\u0004\u0018\u00010\u0014J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\"J\u0010\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\"J\u0010\u00101\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\"J\u000e\u00102\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\fJ\u0012\u00103\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/OAlertDialogModal;", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "context", "Landroid/content/Context;", "withHeightMatchParent", "", "(Landroid/content/Context;Z)V", "bannderPanel", "Landroid/widget/FrameLayout;", "bodyPanel", "bodyStyleController", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "buttonPanel", "buttonStyleController", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "headerPanel", "Landroid/view/ViewGroup;", "iconPanel", "messageTextView", "Landroid/widget/TextView;", "tagName", "", "titleTextView", "topImageStyleController", "allowMoreThanTwoLinesMessage", "", "getBannerSlot", "getBodySlot", "getButtonSlot", "getIconSlot", "getLayout", "", "getMessageStr", "", "getMessageView", "getNegativeButton", "Landroid/view/View;", "getNeutralButton", "getPositiveButton", "getTitleStr", "getTitleView", "setBodyStyleController", "controller", "setButtonStyleController", "setMessage", "message", "setOnlyTitleText", "title", "setTitleText", "setTopImageStyleController", "show", "parent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OAlertDialogModal extends AbstractDialogModal implements DialogContainer {
    private final FrameLayout bannderPanel;
    private final FrameLayout bodyPanel;
    private StyleController bodyStyleController;
    private final FrameLayout buttonPanel;
    private ButtonStyleController buttonStyleController;
    private final ViewGroup headerPanel;
    private final FrameLayout iconPanel;
    private TextView messageTextView;
    private final String tagName;
    private TextView titleTextView;
    private StyleController topImageStyleController;

    public static /* synthetic */ void $r8$lambda$36EAq5VMGAxVappcZyyeqiry_sI(OAlertDialogModal r0) {
        m1153show$lambda8(r0);
    }

    public /* synthetic */ OAlertDialogModal(Context r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public OAlertDialogModal(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false, r3);
        this.tagName = "OAlertDialogModal";
        View r4 = findViewById(R.id.bannerPanel);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.bannerPanel)");
        this.bannderPanel = (FrameLayout) r4;
        View r5 = findViewById(R.id.iconPanel);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.iconPanel)");
        this.iconPanel = (FrameLayout) r5;
        View r6 = findViewById(R.id.header_container);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.header_container)");
        this.headerPanel = (ViewGroup) r6;
        TextView r7 = (TextView) findViewById(R.id.textTitle);
        this.titleTextView = r7;
        if (r7 == null) goto L6;
        r7.setIncludeFontPadding(true);
    L6:
        TextView r8 = (TextView) findViewById(R.id.textSubTitle);
        this.messageTextView = r8;
        if (r8 == null) goto L10;
        r8.setIncludeFontPadding(true);
    L10:
        View r9 = findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.button_container)");
        this.buttonPanel = (FrameLayout) r9;
        View r10 = findViewById(R.id.body_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.body_container)");
        this.bodyPanel = (FrameLayout) r10;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R.layout.o_alert_dialog_v2;
    }

    public final void setTopImageStyleController(StyleController r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        this.topImageStyleController = r3;
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r3.attachToParent(r0, this);
    }

    public final void setTitleText(CharSequence r6) {
        boolean r0 = TextUtils.isEmpty(r6);
        TextView r1 = this.titleTextView;
        int r3 = 0;
        if (r1 == null) goto L9;
        if (r0 == false) goto L7;
        int r4 = 8;
    L8:
        r1.setVisibility(r4);
        r1.setText(r6);
        r1.setPadding(0, 0, 0, 0);
        goto L9
    L7:
        r4 = 0;
    L9:
        TextView r5 = this.messageTextView;
        if (r5 == null) goto L22;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 == null) goto L21;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r0 == true) goto L18;
        Context r9 = r5.getContext();
        Intrinsics.checkNotNullExpressionValue(r9, "it.context");
        r3 = OUnitExtensionKt.cdp(r9, 8);
    L18:
        r8.topMargin = r3;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setOnlyTitleText(CharSequence r5) {
        if (r5 == null) goto L9;
        TextView r4 = this.titleTextView;
        if (r4 == null) goto L10;
        r4.setVisibility(0);
        r4.setText(r5);
        Context r6 = r4.getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "tv.context");
        int r7 = OUnitExtensionKt.cdp(r6, 19);
        Context r3 = r4.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "tv.context");
        r4.setPadding(0, r7, 0, OUnitExtensionKt.cdp(r3, 19));
        return;
    L10:
        return;
    }

    public final void setMessage(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        TextView r0 = this.messageTextView;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        r0.setText(r3);
    L6:
        TextView r2 = this.messageTextView;
        if (r2 == null) goto L11;
        r2.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void allowMoreThanTwoLinesMessage() {
        TextView r1 = this.messageTextView;
        if (r1 == null) goto L7;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void setButtonStyleController(ButtonStyleController r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        this.buttonStyleController = r3;
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r3.attachToParent(r0, this);
        r3.attachToHost(this);
    }

    public final void setBodyStyleController(StyleController r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        this.bodyStyleController = r4;
        FrameLayout r0 = this.bodyPanel;
        if (getMatchParentHeight() == false) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = 0;
        r0.setLayoutParams(r1);
    L5:
        r0.setVisibility(0);
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        r4.attachToParent(r2, this);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public void show(ViewGroup r4) {
        super.show(r4);
        StyleController r5 = this.topImageStyleController;
        if (r5 == null) goto L6;
        r5.attachToHost(this);
    L6:
        StyleController r6 = this.bodyStyleController;
        if (r6 == null) goto L10;
        r6.attachToHost(this);
    L10:
        ButtonStyleController r7 = this.buttonStyleController;
        if (r7 == null) goto L14;
        r7.attachToHost(this);
    L14:
        TextView r8 = this.messageTextView;
        if (r8 == null) goto L19;
        r8.postDelayed(new OAlertDialogModal$$ExternalSyntheticLambda0(this), 1000);
        return;
    }

    /* JADX INFO: renamed from: show$lambda-8, reason: not valid java name */
    private static final void m1153show$lambda8(OAlertDialogModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        TextView r0 = r1.messageTextView;
        if (r0 == null) goto L9;
        Layout r2 = r0.getLayout();
        if (r2 == null) goto L9;
        r2.getLineCount();
    L9:
        TextView r3 = r1.messageTextView;
        if (r3 == null) goto L14;
        r3.getMaxLines();
        return;
    }

    public final CharSequence getTitleStr() {
        TextView r0 = this.titleTextView;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final CharSequence getMessageStr() {
        TextView r0 = this.messageTextView;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final TextView getTitleView() {
        return this.titleTextView;
    }

    public final TextView getMessageView() {
        return this.messageTextView;
    }

    public final View getPositiveButton() {
        KtExt r0 = KtExt.INSTANCE;
        ButtonStyleController r1 = this.buttonStyleController;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getPositiveButton();
    }

    public final View getNegativeButton() {
        KtExt r0 = KtExt.INSTANCE;
        ButtonStyleController r1 = this.buttonStyleController;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getNegativeButton();
    }

    public final View getNeutralButton() {
        KtExt r0 = KtExt.INSTANCE;
        ButtonStyleController r1 = this.buttonStyleController;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getNeutralButton();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getBannerSlot() {
        return this.bannderPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getIconSlot() {
        return this.iconPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getBodySlot() {
        return this.bodyPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getButtonSlot() {
        return this.buttonPanel;
    }
}
