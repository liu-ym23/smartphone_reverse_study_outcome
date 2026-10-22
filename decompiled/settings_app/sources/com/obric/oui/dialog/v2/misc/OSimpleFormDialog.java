package com.obric.oui.dialog.v2.misc;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OPhoneInputLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSimpleFormDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\b\u0017\u0018\u0000 B2\u00020\u0001:\u0003BCDB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000204H\u0002J\b\u0010:\u001a\u000204H\u0002J\b\u0010;\u001a\u000204H\u0014J\b\u0010<\u001a\u000204H\u0014J\u000e\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020?R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b)\u0010$R\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b1\u0010.¨\u0006E"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "Lcom/obric/oui/dialog/base/OBaseDialog;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "bodyContainer$delegate", "Lkotlin/Lazy;", "footerContainer", "getFooterContainer", "footerContainer$delegate", "inputView1", "Lcom/obric/oui/forms/OInputLayout;", "getInputView1", "()Lcom/obric/oui/forms/OInputLayout;", "setInputView1", "(Lcom/obric/oui/forms/OInputLayout;)V", "inputView1Container", "getInputView1Container", "inputView1Container$delegate", "inputView2", "getInputView2", "setInputView2", "inputView2Container", "getInputView2Container", "inputView2Container$delegate", "getModifier", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "pendingDismissTask", "Ljava/lang/Runnable;", "positiveButton", "getPositiveButton", "positiveButton$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "dismiss", "", "getHeightChangeAnimContainer", "Landroid/view/View;", "getLayout", "", "initButtons", "initInputViews", "onStart", "onStop", "setSubtitleText", "message", "", "setTitleText", "title", "Companion", "InputViewConfig", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSimpleFormDialog extends OBaseDialog {
    public static final Companion Companion = null;
    private static final String TAG = "OSimpleFormDialog";
    private final Lazy bodyContainer$delegate;
    private final Lazy footerContainer$delegate;
    private OInputLayout inputView1;
    private final Lazy inputView1Container$delegate;
    private OInputLayout inputView2;
    private final Lazy inputView2Container$delegate;
    private final Modifier modifier;
    private final Lazy negativeButton$delegate;
    private final Runnable pendingDismissTask;
    private final Lazy positiveButton$delegate;
    private final Lazy subtitleTextView$delegate;
    private final Lazy titleTextView$delegate;

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\u0010\tR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$InputViewConfig;", "", "visible", "", "isPhoneInput", "customizer", "Lkotlin/Function1;", "Lcom/obric/oui/forms/OInputLayout;", "", "(ZZLkotlin/jvm/functions/Function1;)V", "getCustomizer", "()Lkotlin/jvm/functions/Function1;", "()Z", "getVisible", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InputViewConfig {
        private final Function1<OInputLayout, Unit> customizer;
        private final boolean isPhoneInput;
        private final boolean visible;

        /* JADX WARN: Multi-variable type inference failed */
        public InputViewConfig(boolean r1, boolean r2, Function1<? super OInputLayout, Unit> r3) {
            this.visible = r1;
            this.isPhoneInput = r2;
            this.customizer = r3;
        }

        public /* synthetic */ InputViewConfig(boolean r1, boolean r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = null;
        L8:
            this(r1, r2, r3);
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public final boolean isPhoneInput() {
            return this.isPhoneInput;
        }

        public final Function1<OInputLayout, Unit> getCustomizer() {
            return this.customizer;
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;", "", "title", "", "subtitle", "inputView1", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$InputViewConfig;", "inputView2", "positiveButton", "Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "negativeButton", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$InputViewConfig;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$InputViewConfig;Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;)V", "getInputView1", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$InputViewConfig;", "getInputView2", "getNegativeButton", "()Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "getPositiveButton", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Modifier {
        private final InputViewConfig inputView1;
        private final InputViewConfig inputView2;
        private final OBaseDialog.ButtonConfig negativeButton;
        private final OBaseDialog.ButtonConfig positiveButton;
        private final CharSequence subtitle;
        private final CharSequence title;

        public Modifier(CharSequence r2, CharSequence r3, InputViewConfig r4, InputViewConfig r5, OBaseDialog.ButtonConfig r6, OBaseDialog.ButtonConfig r7) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, "subtitle");
            Intrinsics.checkNotNullParameter(r4, "inputView1");
            Intrinsics.checkNotNullParameter(r5, "inputView2");
            this.title = r2;
            this.subtitle = r3;
            this.inputView1 = r4;
            this.inputView2 = r5;
            this.positiveButton = r6;
            this.negativeButton = r7;
        }

        public /* synthetic */ Modifier(CharSequence r10, CharSequence r11, InputViewConfig r12, InputViewConfig r13, OBaseDialog.ButtonConfig r14, OBaseDialog.ButtonConfig r15, int r16, DefaultConstructorMarker r17) {
            if ((r16 & 16) == 0) goto L5;
            OBaseDialog.ButtonConfig r7 = null;
        L7:
            if ((r16 & 32) == 0) goto L9;
            OBaseDialog.ButtonConfig r8 = null;
        L10:
            this(r10, r11, r12, r13, r7, r8);
            return;
        L9:
            r8 = r15;
            goto L10
        L5:
            r7 = r14;
            goto L7
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        public final InputViewConfig getInputView1() {
            return this.inputView1;
        }

        public final InputViewConfig getInputView2() {
            return this.inputView2;
        }

        public final OBaseDialog.ButtonConfig getPositiveButton() {
            return this.positiveButton;
        }

        public final OBaseDialog.ButtonConfig getNegativeButton() {
            return this.negativeButton;
        }
    }

    public static /* synthetic */ void $r8$lambda$0GUFMXRdzdlF_qtr8fICmH6PJyI(OSimpleFormDialog r0, View r1) {
        m1160initButtons$lambda12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FOCmORUgBJGlXnXBwo8ccgPnic8(OSimpleFormDialog r0) {
        m1162onStart$lambda14(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Lsf7fCAX5SCKkY-crm63JLfT8yI, reason: not valid java name */
    public static /* synthetic */ void m1157$r8$lambda$Lsf7fCAX5SCKkYcrm63JLfT8yI(OSimpleFormDialog r0) {
        m1161onStart$lambda13(r0);
    }

    public static /* synthetic */ void $r8$lambda$WF1fR0Q93MHD6AIHLELeaISSs9s(OSimpleFormDialog r0) {
        m1163pendingDismissTask$lambda0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$vAF36aXmGmSDMdPHXZRH-_uEq2w, reason: not valid java name */
    public static /* synthetic */ void m1158$r8$lambda$vAF36aXmGmSDMdPHXZRH_uEq2w(OSimpleFormDialog r0, View r1) {
        m1159initButtons$lambda11(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public OSimpleFormDialog(Context r3, Modifier r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "modifier");
        super(r3);
        this.modifier = r4;
        this.titleTextView$delegate = LazyKt.lazy(new OSimpleFormDialog$titleTextView$2(this));
        this.subtitleTextView$delegate = LazyKt.lazy(new OSimpleFormDialog$subtitleTextView$2(this));
        this.negativeButton$delegate = LazyKt.lazy(new OSimpleFormDialog$negativeButton$2(this));
        this.positiveButton$delegate = LazyKt.lazy(new OSimpleFormDialog$positiveButton$2(this));
        this.bodyContainer$delegate = LazyKt.lazy(new OSimpleFormDialog$bodyContainer$2(this));
        this.footerContainer$delegate = LazyKt.lazy(new OSimpleFormDialog$footerContainer$2(this));
        this.inputView1Container$delegate = LazyKt.lazy(new OSimpleFormDialog$inputView1Container$2(this));
        this.inputView2Container$delegate = LazyKt.lazy(new OSimpleFormDialog$inputView2Container$2(this));
        this.pendingDismissTask = new OSimpleFormDialog$$ExternalSyntheticLambda2(this);
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r4.getTitle());
        setSubtitleText(r4.getSubtitle());
        initInputViews();
        initButtons();
        setFixedWindowHeightPx(Integer.valueOf((int) (OUnitExtensionKt.getScreenHeight(r3) * 0.65f)));
        setEnableLayoutHeightChangeAnim(true);
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

    public final OButton getNegativeButton() {
        Object r1 = this.negativeButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-negativeButton>(...)");
        return (OButton) r1;
    }

    public final OButton getPositiveButton() {
        Object r1 = this.positiveButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-positiveButton>(...)");
        return (OButton) r1;
    }

    private final FrameLayout getBodyContainer() {
        Object r1 = this.bodyContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-bodyContainer>(...)");
        return (FrameLayout) r1;
    }

    protected final FrameLayout getFooterContainer() {
        Object r1 = this.footerContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-footerContainer>(...)");
        return (FrameLayout) r1;
    }

    protected final FrameLayout getInputView1Container() {
        Object r1 = this.inputView1Container$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-inputView1Container>(...)");
        return (FrameLayout) r1;
    }

    protected final FrameLayout getInputView2Container() {
        Object r1 = this.inputView2Container$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-inputView2Container>(...)");
        return (FrameLayout) r1;
    }

    /* JADX INFO: renamed from: pendingDismissTask$lambda-0, reason: not valid java name */
    private static final void m1163pendingDismissTask$lambda0(OSimpleFormDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.setDismissing(false);
        super.dismiss();
    }

    public final OInputLayout getInputView1() {
        return this.inputView1;
    }

    public final void setInputView1(OInputLayout r1) {
        this.inputView1 = r1;
    }

    public final OInputLayout getInputView2() {
        return this.inputView2;
    }

    public final void setInputView2(OInputLayout r1) {
        this.inputView2 = r1;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return R.layout.o_simple_form_dialog;
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
        OTextView r6 = getSubtitleTextView();
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = OUnitExtensionKt.vdp(r6, 8);
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

    private final void initInputViews() {
        if (this.modifier.getInputView1().getVisible() == true) goto L5;
        OInputLayout r0 = this.inputView1;
        if (r0 == null) goto L23;
        r0.setVisibility(8);
    L23:
        if (this.modifier.getInputView2().getVisible() == true) goto L25;
        OInputLayout r11 = this.inputView2;
        if (r11 == null) goto L45;
        r11.setVisibility(8);
        return;
    L45:
        return;
    L25:
        if (getInputView2Container().getChildCount() != 0) goto L27;
        boolean r1 = true;
    L28:
        if (r1 == true) goto L30;
    L34:
        OInputLayout r2 = this.inputView2;
        Intrinsics.checkNotNull(r2);
        r2.setVisibility(0);
        Function1<OInputLayout, Unit> r3 = this.modifier.getInputView2().getCustomizer();
        if (r3 == null) goto L44;
        OInputLayout r12 = this.inputView2;
        Intrinsics.checkNotNull(r12);
        r3.invoke(r12);
        return;
    L44:
        return;
    L30:
        if (this.modifier.getInputView2().isPhoneInput() == false) goto L32;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        OPhoneInputLayout r4 = new OPhoneInputLayout(r6, null, 0, 6, null);
        r4.showInputBackground(true);
        r4.showLabel(false);
        r4.showClear(true);
        OPhoneInputLayout r5 = r4;
    L33:
        this.inputView2 = r5;
        getInputView2Container().removeAllViews();
        getInputView2Container().addView(this.inputView2);
        goto L34
    L32:
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r5 = new OInputLayout(r7, null, 0, 6, null);
        r5.showInputBackground(true);
        r5.showLabel(false);
        r5.showClear(true);
        goto L33
    L27:
        r1 = false;
        goto L28
    L5:
        if (getInputView1Container().getChildCount() != 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L10;
    L14:
        OInputLayout r9 = this.inputView1;
        Intrinsics.checkNotNull(r9);
        r9.setVisibility(0);
        Function1<OInputLayout, Unit> r10 = this.modifier.getInputView1().getCustomizer();
        if (r10 == null) goto L23;
        OInputLayout r13 = this.inputView1;
        Intrinsics.checkNotNull(r13);
        r10.invoke(r13);
        goto L23
    L10:
        if (this.modifier.getInputView1().isPhoneInput() == false) goto L12;
        Context r14 = getContext();
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        OPhoneInputLayout r15 = new OPhoneInputLayout(r14, null, 0, 6, null);
        r15.showInputBackground(true);
        r15.showLabel(false);
        r15.showClear(true);
        OPhoneInputLayout r16 = r15;
    L13:
        this.inputView1 = r16;
        getInputView1Container().removeAllViews();
        getInputView1Container().addView(this.inputView1);
        goto L14
    L12:
        Context r17 = getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        r16 = new OInputLayout(r17, null, 0, 6, null);
        r16.showInputBackground(true);
        r16.showLabel(false);
        r16.showClear(true);
        goto L13
    L7:
        r8 = false;
        goto L8
    }

    private final void initButtons() {
        if (this.modifier.getPositiveButton() != null) goto L8;
        if (this.modifier.getNegativeButton() != null) goto L8;
        getFooterContainer().setVisibility(8);
        return;
    L8:
        if (this.modifier.getPositiveButton() == null) goto L16;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText(this.modifier.getPositiveButton().getText());
        if (this.modifier.getPositiveButton().getOnClick() == null) goto L12;
        getPositiveButton().setOnClickListener(new OSimpleFormDialog$$ExternalSyntheticLambda3(this));
    L12:
        Function1<OButton, Unit> r0 = this.modifier.getPositiveButton().getCustomizer();
        if (r0 == null) goto L18;
        r0.invoke(getPositiveButton());
    L18:
        if (this.modifier.getNegativeButton() == null) goto L26;
        getNegativeButton().setVisibility(0);
        getNegativeButton().setText(this.modifier.getNegativeButton().getText());
        if (this.modifier.getNegativeButton().getOnClick() == null) goto L22;
        getNegativeButton().setOnClickListener(new OSimpleFormDialog$$ExternalSyntheticLambda4(this));
    L22:
        Function1<OButton, Unit> r1 = this.modifier.getNegativeButton().getCustomizer();
        if (r1 == null) goto L30;
        r1.invoke(getNegativeButton());
        return;
    L30:
        return;
    L26:
        getNegativeButton().setVisibility(8);
        return;
    L16:
        getPositiveButton().setVisibility(8);
        goto L18
    }

    /* JADX INFO: renamed from: initButtons$lambda-11, reason: not valid java name */
    private static final void m1159initButtons$lambda11(OSimpleFormDialog r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.modifier.getPositiveButton().getOnClick().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-12, reason: not valid java name */
    private static final void m1160initButtons$lambda12(OSimpleFormDialog r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.modifier.getNegativeButton().getOnClick().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.obric.oui.dialog.base.OBaseDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        getSubtitleTextView().postDelayed(new OSimpleFormDialog$$ExternalSyntheticLambda0(this), 1000);
        OInputLayout r0 = this.inputView1;
        if (r0 == null) goto L7;
        r0.postDelayed(new OSimpleFormDialog$$ExternalSyntheticLambda1(this), 100);
        return;
    }

    /* JADX INFO: renamed from: onStart$lambda-13, reason: not valid java name */
    private static final void m1161onStart$lambda13(OSimpleFormDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Layout r0 = r1.getSubtitleTextView().getLayout();
        if (r0 == null) goto L6;
        r0.getLineCount();
    L6:
        r1.getSubtitleTextView().getMaxLines();
    }

    /* JADX INFO: renamed from: onStart$lambda-14, reason: not valid java name */
    private static final void m1162onStart$lambda14(OSimpleFormDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        OInputLayout r3 = r2.inputView1;     // Catch: Exception -> L11
        if (r3 == null) goto L16;
        OEditText r4 = r3.getVInput();     // Catch: Exception -> L11
        if (r4 == null) goto L17;
        r4.requestFocus();     // Catch: Exception -> L11
        return;
    L17:
        return;
    L16:
        return;
    L11:
        e = move-exception;
        L.e(TAG, "onStart, requestFocus failed", e);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        getBodyContainer().removeCallbacks(this.pendingDismissTask);
    }

    @Override // com.obric.oui.dialog.base.OBaseDialog, com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isDismissing() == false) goto L7;
        L.d(TAG, "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L7:
        if (getInsetsBaseYOffsetPx() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        super.dismiss();
        return;
    L13:
        setDismissing(true);
        OInputLayout r1 = this.inputView1;
        if (r1 == null) goto L17;
        r1.clearFocus();
    L17:
        OInputLayout r2 = this.inputView2;
        if (r2 == null) goto L21;
        r2.clearFocus();
    L21:
        getBodyContainer().postDelayed(this.pendingDismissTask, 100);
        return;
    L9:
        r0 = false;
        goto L10
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    protected View getHeightChangeAnimContainer() {
        return getBodyContainer();
    }
}
