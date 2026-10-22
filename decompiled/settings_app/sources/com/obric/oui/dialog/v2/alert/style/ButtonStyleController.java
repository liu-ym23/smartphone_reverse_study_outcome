package com.obric.oui.dialog.v2.alert.style;

import android.content.DialogInterface;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ButtonStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \u00162\u00020\u0001:\u0003\u0015\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J(\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J(\u0010\u0011\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J0\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "()V", "getNegativeButton", "Landroid/view/View;", "getNeutralButton", "getPositiveButton", "setCustomNegativeButton", "", "view", "setNegativeButton", "text", "", "listener", "Landroid/content/DialogInterface$OnClickListener;", "textColorType", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "setNeutralButton", "setPositiveButton", "positiveButtonWarning", "", "ButtonStyle", "Companion", "TextColorType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ButtonStyleController implements StyleController {
    public static final Companion Companion = null;
    public static final int HORIZONTAL = 0;
    public static final int PRIMARY = 2;
    public static final int VERTICAL = 1;

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$ButtonStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStyle {
    }

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$Companion;", "", "()V", "HORIZONTAL", "", "PRIMARY", "VERTICAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(message = "待废弃")
    public static final enum TextColorType extends Enum<TextColorType> {
        private static final /* synthetic */ TextColorType[] $VALUES = null;
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        private static final /* synthetic */ TextColorType[] $values() {
            return new TextColorType[]{TextReverse, TextReverse2, Negative};
        }

        public static TextColorType valueOf(String r1) {
            return (TextColorType) Enum.valueOf(TextColorType.class, r1);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) $VALUES.clone();
        }

        private TextColorType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            TextReverse = new TextColorType("TextReverse", 0);
            TextReverse2 = new TextColorType("TextReverse2", 1);
            Negative = new TextColorType("Negative", 2);
            $VALUES = $values();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract View getNegativeButton();

    public abstract View getNeutralButton();

    public abstract View getPositiveButton();

    public abstract void setCustomNegativeButton(View r1);

    public abstract void setNegativeButton(CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3);

    public abstract void setNeutralButton(CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3);

    public abstract void setPositiveButton(CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, boolean r4);

    public ButtonStyleController() {
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToDialog(AbstractDialog r1) {
        StyleController.DefaultImpls.attachToDialog(this, r1);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToHost(AlertDialogHost r1) {
        StyleController.DefaultImpls.attachToHost(this, r1);
    }

    public static /* synthetic */ void setPositiveButton$default(ButtonStyleController r0, CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.setPositiveButton(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPositiveButton");
    }

    public static /* synthetic */ void setNegativeButton$default(ButtonStyleController r0, CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.setNegativeButton(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNegativeButton");
    }

    public static /* synthetic */ void setNeutralButton$default(ButtonStyleController r0, CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.setNeutralButton(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNeutralButton");
    }
}
