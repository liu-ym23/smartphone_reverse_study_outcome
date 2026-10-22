package com.obric.securitycenter.nodisturb.sms.keyword;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import com.obric.oui.indicator.IndicatorExternalsKt;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.securitycenter.nodisturb.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: InputDialogWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010'\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018RL\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000b¨\u0006("}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/InputDialogWrapper;", "", "context", "Landroid/content/Context;", "title", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "hint", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "inputText", "getInputText", "setInputText", "onNegativeClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnNegativeClick", "()Lkotlin/jvm/functions/Function1;", "setOnNegativeClick", "(Lkotlin/jvm/functions/Function1;)V", "onPositiveClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "text", "getOnPositiveClick", "()Lkotlin/jvm/functions/Function2;", "setOnPositiveClick", "(Lkotlin/jvm/functions/Function2;)V", "subtitle", "getSubtitle", "setSubtitle", "getTitle", InvokeHistoryActivity.PREF_SHOW, "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputDialogWrapper {
    private final Context context;
    private String hint;
    private String inputText;
    private Function1<? super View, Unit> onNegativeClick;
    private Function2<? super View, ? super String, Unit> onPositiveClick;
    private String subtitle;
    private final String title;

    /* JADX INFO: renamed from: $r8$lambda$-hr2r9pXw2MpzdVEpflV3Xo1NVg, reason: not valid java name */
    public static /* synthetic */ void m616$r8$lambda$hr2r9pXw2MpzdVEpflV3Xo1NVg(InputDialogWrapper r0, OInputView r1, OInsetSheet r2, View r3) {
        show$lambda$14$lambda$10$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$aSJDP1_bC73nNj3IxLxxB9K0nMw(InputDialogWrapper r0, OInsetSheet r1, View r2) {
        show$lambda$14$lambda$10$lambda$7$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$i8xOsCsx7aFBBKugETdN5sCwoGU(OSelectionPanelBtnView r0, TextView r1, int r2, KeyEvent r3) {
        return show$lambda$14$lambda$11(r0, r1, r2, r3);
    }

    public InputDialogWrapper(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "title");
        this.context = r2;
        this.title = r3;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getHint() {
        return this.hint;
    }

    public final void setHint(String r1) {
        this.hint = r1;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setSubtitle(String r1) {
        this.subtitle = r1;
    }

    public final String getInputText() {
        return this.inputText;
    }

    public final void setInputText(String r1) {
        this.inputText = r1;
    }

    public final Function1<View, Unit> getOnNegativeClick() {
        return this.onNegativeClick;
    }

    public final void setOnNegativeClick(Function1<? super View, Unit> r1) {
        this.onNegativeClick = r1;
    }

    public final Function2<View, String, Unit> getOnPositiveClick() {
        return this.onPositiveClick;
    }

    public final void setOnPositiveClick(Function2<? super View, ? super String, Unit> r1) {
        this.onPositiveClick = r1;
    }

    public final void show() {
        final OInsetSheet r0 = new OInsetSheet(this.context);
        r0.setRootWidth(OInsetSheet.PanelWidth.BOARD_WIDTH);
        Context r3 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        OCTitleBar r1 = new OCTitleBar(r3, null, 0, 6, null);
        r1.setTitleText(this.title);
        r1.setShowLeftBack(false);
        r0.setHeaderView(r1);
        View r2 = r0.getLayoutInflater().inflate(R.layout.edit_dialog_layout, null);
        final OInputView r4 = (OInputView) r2.findViewById(R.id.input_view);
        OTextView r5 = (OTextView) r2.findViewById(R.id.subtitle);
        String r6 = this.subtitle;
        if (r6 == null) goto L7;
        if (r5 == null) goto L7;
        r5.setText(r6);
    L7:
        String r7 = this.hint;
        if (r7 == null) goto L11;
        if (r4 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r4, "inputView");
        this.hint = r7;
    L11:
        String r8 = this.inputText;
        if (r8 == null) goto L17;
        if (r4 == null) goto L17;
        OEditText r9 = r4.getVInput();
        if (r9 == null) goto L17;
        r9.setText(r8);
        r9.setSelection(r8.length());
    L17:
        Context r10 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        final OSelectionPanelBtnView r11 = new OSelectionPanelBtnView(r10, null, 2, null);
        OButton r12 = r11.getBtnNegative();
        r12.setText(r12.getContext().getString(R.string.cancel));
        r12.setOnClickListener(new InputDialogWrapper$$ExternalSyntheticLambda0(this, r0));
        OButton r13 = r11.getBtnPositive();
        r13.setText(r13.getContext().getString(R.string.confirm));
        r13.setOnClickListener(new InputDialogWrapper$$ExternalSyntheticLambda1(this, r4, r0));
        r11.getBtnPositive().setEnabled(false);
        r0.setFooterView(r11);
        if (r4 == null) goto L22;
        OEditText r14 = r4.getVInput();
        if (r14 == null) goto L22;
        r14.addTextChangedListener(new InputDialogWrapper$show$oInsetSheet$1$4(r11));
    L22:
        if (r4 == null) goto L26;
        OEditText r15 = r4.getVInput();
        if (r15 == null) goto L26;
        r15.setOnEditorActionListener(new InputDialogWrapper$$ExternalSyntheticLambda2(r11));
    L26:
        r0.setContainerView(r2);
        Intrinsics.checkNotNullExpressionValue(r2, "show$lambda$14$lambda$12");
        IndicatorExternalsKt.setMarginBottom(r2, MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        IndicatorExternalsKt.setHorizontalMargin(r2, MathKt.roundToInt(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics())));
        if (r4 == null) goto L35;
        OEditText r16 = r4.getVInput();
        if (r16 == null) goto L35;
        OEditText r17 = r16;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L34;
        r18.height = MathKt.roundToInt(TypedValue.applyDimension(1, 80, Resources.getSystem().getDisplayMetrics()));
        r17.setLayoutParams(r18);
        goto L35
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L35:
        if (r4 == null) goto L37;
        r4.requestFocus();
    L37:
        r0.show();
        Window r19 = r0.getWindow();
        if (r19 == null) goto L41;
        r19.setSoftInputMode(5);
        return;
    }

    private static final void show$lambda$14$lambda$10$lambda$7$lambda$6(InputDialogWrapper r1, OInsetSheet r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$this_apply");
        Function1<? super View, Unit> r4 = r1.onNegativeClick;
        if (r4 == null) goto L5;
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r4.invoke(r3);
    L5:
        r2.dismiss();
    }

    private static final void show$lambda$14$lambda$10$lambda$9$lambda$8(InputDialogWrapper r1, OInputView r2, OInsetSheet r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        Function2<? super View, ? super String, Unit> r5 = r1.onPositiveClick;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r4, "it");
        if (r2 == null) goto L9;
        OEditText r6 = r2.getVInput();
        if (r6 == null) goto L9;
        Editable r7 = r6.getText();
    L10:
        String r8 = String.valueOf(r7);
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        r5.invoke(r4, r8);
    L9:
        r7 = null;
    L14:
        r3.dismiss();
    }

    private static final boolean show$lambda$14$lambda$11(OSelectionPanelBtnView r0, TextView r1, int r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r0, "$footerView");
        if (r2 != 6) goto L6;
        r0.getBtnPositive().performClick();
        return true;
    L6:
        return false;
    }
}
