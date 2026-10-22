package com.obric.oui.dialog.base;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.apm.constant.AgentConstants;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBaseDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b'\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0004J\b\u0010\u0012\u001a\u00020\u000eH\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialog;", "Lcom/obric/oui/dialog/base/AbstractDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isDismissing", "", "()Z", "setDismissing", "(Z)V", "useNewDialogAnim", "getUseNewDialogAnim", "setUseNewDialogAnim", "dismiss", "", AgentConstants.ON_START, "originDismiss", "performEnterAnimation", "performExitAnimation", "ButtonConfig", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OBaseDialog extends AbstractDialog {
    public static final Companion Companion = null;
    private static final String TAG = "BaseDialog";
    private boolean isDismissing;
    private boolean useNewDialogAnim;

    /* JADX INFO: compiled from: OBaseDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\nR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "", "text", "", "onClick", "Lkotlin/Function0;", "", "customizer", "Lkotlin/Function1;", "Lcom/obric/oui/button/OButton;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getCustomizer", "()Lkotlin/jvm/functions/Function1;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getText", "()Ljava/lang/String;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ButtonConfig {
        private final Function1<OButton, Unit> customizer;
        private final Function0<Unit> onClick;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public ButtonConfig(String r2, Function0<Unit> r3, Function1<? super OButton, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.text = r2;
            this.onClick = r3;
            this.customizer = r4;
        }

        public /* synthetic */ ButtonConfig(String r1, Function0 r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }

        public final String getText() {
            return this.text;
        }

        public final Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final Function1<OButton, Unit> getCustomizer() {
            return this.customizer;
        }
    }

    /* JADX INFO: compiled from: OBaseDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialog$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$qgHI4QevAF3s02sJ4oQs8VZAX6g(OBaseDialog r0) {
        m283performEnterAnimation$lambda1(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OBaseDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false, false);
        this.useNewDialogAnim = true;
    }

    protected final boolean getUseNewDialogAnim() {
        return this.useNewDialogAnim;
    }

    protected final void setUseNewDialogAnim(boolean r1) {
        this.useNewDialogAnim = r1;
    }

    protected final boolean isDismissing() {
        return this.isDismissing;
    }

    protected final void setDismissing(boolean r1) {
        this.isDismissing = r1;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.isDismissing = false;
        performEnterAnimation();
    }

    protected final void performExitAnimation() {
        ViewPropertySpringAnimator<View> r0 = DialogAnimStyle.INSTANCE.dialogBottomHide(getRootView(), getWindow(), !getAdaptWindowDim(), this.useNewDialogAnim);
        ViewPropertySpringAnimator.setListener$default(r0, null, new OBaseDialog$performExitAnimation$1$1(this), new OBaseDialog$performExitAnimation$1$2(this), 1, null);
        r0.start();
    }

    protected final void performEnterAnimation() {
        getRootView().post(new OBaseDialog$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-1, reason: not valid java name */
    private static final void m283performEnterAnimation$lambda1(final OBaseDialog r7) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        DialogAnimStyle r1 = DialogAnimStyle.INSTANCE;
        View r2 = r7.getRootView();
        Window r3 = r7.getWindow();
        boolean r4 = !r7.getAdaptWindowDim();
        Context r0 = r7.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        ViewPropertySpringAnimator.setListener$default(r1.dialogBottomShow(r2, r3, r4, r7.getTargetWindowDimAmount(r0), r7.useNewDialogAnim).start(), null, new OBaseDialog$performEnterAnimation$1$1(r7), new OBaseDialog$performEnterAnimation$1$2(r7), 1, null);
    }

    public void originDismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        L.e(TAG, "origin Dismiss exception!", e);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.isDismissing == false) goto L6;
        L.d(TAG, "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L6:
        this.isDismissing = true;
        performExitAnimation();
    }
}
