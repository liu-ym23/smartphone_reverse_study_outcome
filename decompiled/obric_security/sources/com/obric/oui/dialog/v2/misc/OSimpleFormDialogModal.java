package com.obric.oui.dialog.v2.misc;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.base.OBaseDialogModal;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OPhoneInputLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSimpleFormDialogModal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 >2\u00020\u0001:\u0003>?@B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u000e\u00106\u001a\u0002042\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u0002042\u0006\u0010:\u001a\u000208J\u0012\u0010;\u001a\u0002042\b\u0010<\u001a\u0004\u0018\u00010=H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b'\u0010$R\u001b\u0010)\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b/\u0010,¨\u0006A"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal;", "Lcom/obric/oui/dialog/base/OBaseDialogModal;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "bodyContainer$delegate", "Lkotlin/Lazy;", "footerContainer", "getFooterContainer", "footerContainer$delegate", "inputView1", "Lcom/obric/oui/forms/OInputLayout;", "getInputView1", "()Lcom/obric/oui/forms/OInputLayout;", "setInputView1", "(Lcom/obric/oui/forms/OInputLayout;)V", "inputView1Container", "getInputView1Container", "inputView1Container$delegate", "inputView2", "getInputView2", "setInputView2", "inputView2Container", "getInputView2Container", "inputView2Container$delegate", "getModifier", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "positiveButton", "getPositiveButton", "positiveButton$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initButtons", "", "initInputViews", "setSubtitleText", "message", "", "setTitleText", "title", InvokeHistoryActivity.PREF_SHOW, "parent", "Landroid/view/ViewGroup;", "Companion", "InputViewConfig", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSimpleFormDialogModal extends OBaseDialogModal {
    public static final Companion Companion = null;
    private static final String TAG = "OSimpleFormDialogModal";
    private final Lazy bodyContainer$delegate;
    private final Lazy footerContainer$delegate;
    private OInputLayout inputView1;
    private final Lazy inputView1Container$delegate;
    private OInputLayout inputView2;
    private final Lazy inputView2Container$delegate;
    private final Modifier modifier;
    private final Lazy negativeButton$delegate;
    private final Lazy positiveButton$delegate;
    private final Lazy subtitleTextView$delegate;
    private final Lazy titleTextView$delegate;

    /* JADX INFO: compiled from: OSimpleFormDialogModal.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialogModal.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\u0010\tR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;", "", "visible", "", "isPhoneInput", "customizer", "Lkotlin/Function1;", "Lcom/obric/oui/forms/OInputLayout;", "", "(ZZLkotlin/jvm/functions/Function1;)V", "getCustomizer", "()Lkotlin/jvm/functions/Function1;", "()Z", "getVisible", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* JADX INFO: compiled from: OSimpleFormDialogModal.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;", "", "title", "", "subtitle", "inputView1", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;", "inputView2", "positiveButton", "Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;", "negativeButton", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;)V", "getInputView1", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;", "getInputView2", "getNegativeButton", "()Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;", "getPositiveButton", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Modifier {
        private final InputViewConfig inputView1;
        private final InputViewConfig inputView2;
        private final OBaseDialogModal.ButtonConfig negativeButton;
        private final OBaseDialogModal.ButtonConfig positiveButton;
        private final CharSequence subtitle;
        private final CharSequence title;

        public Modifier(CharSequence r2, CharSequence r3, InputViewConfig r4, InputViewConfig r5, OBaseDialogModal.ButtonConfig r6, OBaseDialogModal.ButtonConfig r7) {
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

        public /* synthetic */ Modifier(CharSequence r10, CharSequence r11, InputViewConfig r12, InputViewConfig r13, OBaseDialogModal.ButtonConfig r14, OBaseDialogModal.ButtonConfig r15, int r16, DefaultConstructorMarker r17) {
            if ((r16 & 16) == 0) goto L5;
            OBaseDialogModal.ButtonConfig r7 = null;
        L7:
            if ((r16 & 32) == 0) goto L9;
            OBaseDialogModal.ButtonConfig r8 = null;
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

        public final OBaseDialogModal.ButtonConfig getPositiveButton() {
            return this.positiveButton;
        }

        public final OBaseDialogModal.ButtonConfig getNegativeButton() {
            return this.negativeButton;
        }
    }

    public static /* synthetic */ void $r8$lambda$KPuS9HQ9wMmOo3QvB7l9RelALFY(Function0 r0, OSimpleFormDialogModal r1, View r2) {
        m308initButtons$lambda13$lambda12(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$bFz_x3znkfzb6Ff4fPyZ_lGnhoY(Function0 r0, OSimpleFormDialogModal r1, View r2) {
        m307initButtons$lambda11$lambda10(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$tpkARFmJiplh1m-S5TsB3lH7z50, reason: not valid java name */
    public static /* synthetic */ void m306$r8$lambda$tpkARFmJiplh1mS5TsB3lH7z50(OSimpleFormDialogModal r0) {
        m310show$lambda15(r0);
    }

    public static /* synthetic */ void $r8$lambda$yhm7RrJpai1VdVzhB8cOtppEtVA(OSimpleFormDialogModal r0) {
        m309show$lambda14(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public OSimpleFormDialogModal(Context r2, Modifier r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "modifier");
        super(r2);
        this.modifier = r3;
        this.titleTextView$delegate = LazyKt.lazy(new OSimpleFormDialogModal$titleTextView$2(this));
        this.subtitleTextView$delegate = LazyKt.lazy(new OSimpleFormDialogModal$subtitleTextView$2(this));
        this.negativeButton$delegate = LazyKt.lazy(new OSimpleFormDialogModal$negativeButton$2(this));
        this.positiveButton$delegate = LazyKt.lazy(new OSimpleFormDialogModal$positiveButton$2(this));
        this.bodyContainer$delegate = LazyKt.lazy(new OSimpleFormDialogModal$bodyContainer$2(this));
        this.footerContainer$delegate = LazyKt.lazy(new OSimpleFormDialogModal$footerContainer$2(this));
        this.inputView1Container$delegate = LazyKt.lazy(new OSimpleFormDialogModal$inputView1Container$2(this));
        this.inputView2Container$delegate = LazyKt.lazy(new OSimpleFormDialogModal$inputView2Container$2(this));
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r3.getTitle());
        setSubtitleText(r3.getSubtitle());
        initInputViews();
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

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
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
        if (this.modifier.getPositiveButton() == null) goto L17;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText(this.modifier.getPositiveButton().getText());
        final Function0<Unit> r0 = this.modifier.getPositiveButton().getOnClick();
        if (r0 == null) goto L13;
        getPositiveButton().setOnClickListener(new OSimpleFormDialogModal$$ExternalSyntheticLambda0(r0, this));
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
        getNegativeButton().setOnClickListener(new OSimpleFormDialogModal$$ExternalSyntheticLambda1(r2, this));
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

    /* JADX INFO: renamed from: initButtons$lambda-11$lambda-10, reason: not valid java name */
    private static final void m307initButtons$lambda11$lambda10(Function0 r0, OSimpleFormDialogModal r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$click");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke();
        if (r1.isAutoDismiss() == false) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-13$lambda-12, reason: not valid java name */
    private static final void m308initButtons$lambda13$lambda12(Function0 r0, OSimpleFormDialogModal r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$click");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke();
        if (r1.isAutoDismiss() == false) goto L6;
        r1.dismiss();
        return;
    }

    @Override // com.obric.oui.dialog.base.OBaseDialogModal, com.obric.oui.dialog.base.AbstractDialogModal
    public void show(ViewGroup r4) {
        super.show(r4);
        getSubtitleTextView().postDelayed(new OSimpleFormDialogModal$$ExternalSyntheticLambda2(this), 1000);
        OInputLayout r5 = this.inputView1;
        if (r5 == null) goto L7;
        r5.postDelayed(new OSimpleFormDialogModal$$ExternalSyntheticLambda3(this), 100);
        return;
    }

    /* JADX INFO: renamed from: show$lambda-14, reason: not valid java name */
    private static final void m309show$lambda14(OSimpleFormDialogModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Layout r0 = r1.getSubtitleTextView().getLayout();
        if (r0 == null) goto L6;
        r0.getLineCount();
    L6:
        r1.getSubtitleTextView().getMaxLines();
    }

    /* JADX INFO: renamed from: show$lambda-15, reason: not valid java name */
    private static final void m310show$lambda15(OSimpleFormDialogModal r2) {
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
        L.e(TAG, "show, requestFocus failed", e);
    }
}
