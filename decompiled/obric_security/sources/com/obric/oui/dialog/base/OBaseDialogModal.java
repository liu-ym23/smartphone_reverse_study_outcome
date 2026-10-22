package com.obric.oui.dialog.base;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBaseDialogModal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialogModal;", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isDismissing", "", "()Z", "setDismissing", "(Z)V", "dismiss", "", "originDismiss", InvokeHistoryActivity.PREF_SHOW, "parent", "Landroid/view/ViewGroup;", "ButtonConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OBaseDialogModal extends AbstractDialogModal {
    private boolean isDismissing;

    /* JADX INFO: compiled from: OBaseDialogModal.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\nR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;", "", "text", "", "onClick", "Lkotlin/Function0;", "", "customizer", "Lkotlin/Function1;", "Lcom/obric/oui/button/OButton;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getCustomizer", "()Lkotlin/jvm/functions/Function1;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getText", "()Ljava/lang/String;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OBaseDialogModal(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false, false);
    }

    protected final boolean isDismissing() {
        return this.isDismissing;
    }

    protected final void setDismissing(boolean r1) {
        this.isDismissing = r1;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public void show(ViewGroup r2) {
        this.isDismissing = false;
        super.show(r2);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal, android.content.DialogInterface
    public void dismiss() {
        if (this.isDismissing == false) goto L5;
        return;
    L5:
        this.isDismissing = true;
        super.dismiss();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    protected void originDismiss() {
        this.isDismissing = false;
        super.originDismiss();
    }
}
