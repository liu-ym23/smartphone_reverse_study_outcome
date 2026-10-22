package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialogModal;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractDialogModalBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010AJ\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016J\r\u0010B\u001a\u00028\u0000H&¢\u0006\u0002\u0010AJ\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010D\u001a\u00020\bJ\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010F\u001a\u00020!J\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010H\u001a\u00020)J\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010J\u001a\u00020!J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010L\u001a\u00020\u0015H\u0016J3\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010N\u001a\u00020\u001b2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010QJ\"\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020\u000e2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010/H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010:\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001c\u0010=\u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%¨\u0006T"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModalBuilder;", "M", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getCancelListener$OUI_standardRelease", "()Landroid/content/DialogInterface$OnCancelListener;", "setCancelListener$OUI_standardRelease", "(Landroid/content/DialogInterface$OnCancelListener;)V", "cancelable", "", "getCancelable$OUI_standardRelease", "()Z", "setCancelable$OUI_standardRelease", "(Z)V", "closeIconColor", "Lkotlin/Pair;", "", "getCloseIconColor$OUI_standardRelease", "()Lkotlin/Pair;", "setCloseIconColor$OUI_standardRelease", "(Lkotlin/Pair;)V", "closeIconStyle", "Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "getCloseIconStyle$OUI_standardRelease", "()Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "setCloseIconStyle$OUI_standardRelease", "(Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;)V", "completeShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getCompleteShowListener$OUI_standardRelease", "()Landroid/content/DialogInterface$OnShowListener;", "setCompleteShowListener$OUI_standardRelease", "(Landroid/content/DialogInterface$OnShowListener;)V", "getContext", "()Landroid/content/Context;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener$OUI_standardRelease", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener$OUI_standardRelease", "(Landroid/content/DialogInterface$OnDismissListener;)V", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "getOnCloseClickListener$OUI_standardRelease", "()Landroid/view/View$OnClickListener;", "setOnCloseClickListener$OUI_standardRelease", "(Landroid/view/View$OnClickListener;)V", "rootFixedHeightPx", "getRootFixedHeightPx$OUI_standardRelease", "()Ljava/lang/Integer;", "setRootFixedHeightPx$OUI_standardRelease", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "showCloseIcon", "getShowCloseIcon$OUI_standardRelease", "setShowCloseIcon$OUI_standardRelease", "showListener", "getShowListener$OUI_standardRelease", "setShowListener$OUI_standardRelease", "build", "()Lcom/obric/oui/dialog/base/AbstractDialogModal;", "createModal", "onCancel", "onCancelListener", "onCompleteShow", "onCompleteShowListener", "onDismiss", "onDismissListener", "onShow", "onShowListener", "rootFixedHeight", "heightPx", "setCloseIconStyle", "style", "iconColor", "iconBgColor", "(Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/oui/dialog/base/AbstractDialogModalBuilder;", "enabled", "listener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractDialogModalBuilder<M extends AbstractDialogModal> {
    private DialogInterface.OnCancelListener cancelListener;
    private boolean cancelable;
    private Pair<Integer, Integer> closeIconColor;
    private AbstractDialogModal.CloseIconStyle closeIconStyle;
    private DialogInterface.OnShowListener completeShowListener;
    private final Context context;
    private DialogInterface.OnDismissListener dismissListener;
    private View.OnClickListener onCloseClickListener;
    private Integer rootFixedHeightPx;
    private boolean showCloseIcon;
    private DialogInterface.OnShowListener showListener;

    public abstract M createModal();

    public final AbstractDialogModalBuilder<M> setCloseIconStyle(AbstractDialogModal.CloseIconStyle r8) {
        Intrinsics.checkNotNullParameter(r8, "style");
        return setCloseIconStyle$default(this, r8, null, null, 6, null);
    }

    public final AbstractDialogModalBuilder<M> setCloseIconStyle(AbstractDialogModal.CloseIconStyle r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "style");
        return setCloseIconStyle$default(this, r8, r9, null, 4, null);
    }

    public AbstractDialogModalBuilder(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.cancelable = true;
        this.closeIconStyle = AbstractDialogModal.CloseIconStyle.DARK;
        this.closeIconColor = TuplesKt.to(null, null);
    }

    protected final Context getContext() {
        return this.context;
    }

    public final DialogInterface.OnDismissListener getDismissListener$OUI_standardRelease() {
        return this.dismissListener;
    }

    public final void setDismissListener$OUI_standardRelease(DialogInterface.OnDismissListener r1) {
        this.dismissListener = r1;
    }

    public final DialogInterface.OnCancelListener getCancelListener$OUI_standardRelease() {
        return this.cancelListener;
    }

    public final void setCancelListener$OUI_standardRelease(DialogInterface.OnCancelListener r1) {
        this.cancelListener = r1;
    }

    public final DialogInterface.OnShowListener getShowListener$OUI_standardRelease() {
        return this.showListener;
    }

    public final void setShowListener$OUI_standardRelease(DialogInterface.OnShowListener r1) {
        this.showListener = r1;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener$OUI_standardRelease() {
        return this.completeShowListener;
    }

    public final void setCompleteShowListener$OUI_standardRelease(DialogInterface.OnShowListener r1) {
        this.completeShowListener = r1;
    }

    public final View.OnClickListener getOnCloseClickListener$OUI_standardRelease() {
        return this.onCloseClickListener;
    }

    public final void setOnCloseClickListener$OUI_standardRelease(View.OnClickListener r1) {
        this.onCloseClickListener = r1;
    }

    public final boolean getCancelable$OUI_standardRelease() {
        return this.cancelable;
    }

    public final void setCancelable$OUI_standardRelease(boolean r1) {
        this.cancelable = r1;
    }

    public final boolean getShowCloseIcon$OUI_standardRelease() {
        return this.showCloseIcon;
    }

    public final void setShowCloseIcon$OUI_standardRelease(boolean r1) {
        this.showCloseIcon = r1;
    }

    public final AbstractDialogModal.CloseIconStyle getCloseIconStyle$OUI_standardRelease() {
        return this.closeIconStyle;
    }

    public final void setCloseIconStyle$OUI_standardRelease(AbstractDialogModal.CloseIconStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.closeIconStyle = r2;
    }

    public final Pair<Integer, Integer> getCloseIconColor$OUI_standardRelease() {
        return this.closeIconColor;
    }

    public final void setCloseIconColor$OUI_standardRelease(Pair<Integer, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.closeIconColor = r2;
    }

    public final Integer getRootFixedHeightPx$OUI_standardRelease() {
        return this.rootFixedHeightPx;
    }

    public final void setRootFixedHeightPx$OUI_standardRelease(Integer r1) {
        this.rootFixedHeightPx = r1;
    }

    public static /* synthetic */ AbstractDialogModalBuilder cancelable$default(AbstractDialogModalBuilder r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = true;
    L7:
        return r0.cancelable(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelable");
    }

    public AbstractDialogModalBuilder<M> cancelable(boolean r1) {
        this.cancelable = r1;
        return this;
    }

    public static /* synthetic */ AbstractDialogModalBuilder showCloseIcon$default(AbstractDialogModalBuilder r0, boolean r1, View.OnClickListener r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.showCloseIcon(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCloseIcon");
    }

    public AbstractDialogModalBuilder<M> showCloseIcon(boolean r1, View.OnClickListener r2) {
        this.showCloseIcon = r1;
        this.onCloseClickListener = r2;
        return this;
    }

    public final AbstractDialogModalBuilder<M> onDismiss(DialogInterface.OnDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onDismissListener");
        this.dismissListener = r2;
        return this;
    }

    public final AbstractDialogModalBuilder<M> onCancel(DialogInterface.OnCancelListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onCancelListener");
        this.cancelListener = r2;
        return this;
    }

    public final AbstractDialogModalBuilder<M> onShow(DialogInterface.OnShowListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onShowListener");
        this.showListener = r2;
        return this;
    }

    public final AbstractDialogModalBuilder<M> onCompleteShow(DialogInterface.OnShowListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onCompleteShowListener");
        this.completeShowListener = r2;
        return this;
    }

    public AbstractDialogModalBuilder<M> rootFixedHeight(int r2) {
        Integer r3 = Integer.valueOf(r2);
        if (r3.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        this.rootFixedHeightPx = r3;
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ AbstractDialogModalBuilder setCloseIconStyle$default(AbstractDialogModalBuilder r1, AbstractDialogModal.CloseIconStyle r2, Integer r3, Integer r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L10;
        r4 = null;
    L10:
        return r1.setCloseIconStyle(r2, r3, r4);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconStyle");
    }

    public final AbstractDialogModalBuilder<M> setCloseIconStyle(AbstractDialogModal.CloseIconStyle r2, Integer r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "style");
        this.closeIconStyle = r2;
        this.closeIconColor = TuplesKt.to(r3, r4);
        return this;
    }

    public M build() {
        M r0 = (M) createModal();
        r0.setCompleteShowListener(this.completeShowListener);
        r0.setRootFixedHeight(this.rootFixedHeightPx);
        r0.setCloseIconEnabled(this.showCloseIcon, this.onCloseClickListener);
        r0.setCancelable(this.cancelable);
        r0.applyCloseIconStyle(this.closeIconStyle, this.closeIconColor.getFirst(), this.closeIconColor.getSecond());
        r0.setOnShowListener(this.showListener);
        r0.setOnDismissListener(this.dismissListener);
        r0.setOnCancelListener(this.cancelListener);
        return r0;
    }
}
