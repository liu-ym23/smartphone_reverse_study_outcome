package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.AgentConstants;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.ViewExtensionsKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonStyleController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u0001:\u0003)*+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0006\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u0004\u0018\u00010\fJ\b\u0010\u0017\u001a\u0004\u0018\u00010\fJ\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0010J&\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J&\u0010#\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J.\u0010$\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0012H\u0002J\u0016\u0010(\u001a\u00020\u0012*\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "customButtonViewContainer", "Landroid/widget/FrameLayout;", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "negativeButton", "Lcom/obric/oui/button/OButton;", "neutralButton", "positiveButton", "rootView", "Landroid/view/View;", "attachToDialog", "", "attachToParent", "parent", "cancelCountDown", "getNegativeButton", "getNeutralButton", "getPositiveButton", AgentConstants.ON_START, "setCustomNegativeButton", "view", "setNegativeButton", "text", "", "listener", "Landroid/content/DialogInterface$OnClickListener;", "textColorType", "Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "setNeutralButton", "setPositiveButton", "positiveButtonBgPrimary", "", "tryDismiss", "setTextColor", "ButtonStyle", "Companion", "TextColorType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ButtonStyleController implements StyleController {
    public static final Companion Companion = null;
    public static final int HORIZONTAL = 0;
    public static final int PRIMARY = 2;
    public static final int VERTICAL = 1;
    private final Context context;
    private FrameLayout customButtonViewContainer;
    private OAlertDialog dialog;
    private OButton negativeButton;
    private OButton neutralButton;
    private OButton positiveButton;
    private View rootView;
    private final int style;

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$ButtonStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStyle {
    }

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$Companion;", "", "()V", "HORIZONTAL", "", "PRIMARY", "VERTICAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TextColorType.values().length];
            r0[TextColorType.Negative.ordinal()] = 1;
            r0[TextColorType.TextReverse.ordinal()] = 2;
            r0[TextColorType.TextReverse2.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$5cZyZljx50zDD2gpDCS9RtYBShg(ButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        m256setPositiveButton$lambda2$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ltFs0ab1LFiGQUg5Apgb2lMQmHU(ButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        m255setNeutralButton$lambda8$lambda7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$t9PXxlvXa69qhRZB9lBVLSXnha0(ButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        m254setNegativeButton$lambda5$lambda4(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public final void cancelCountDown() {
    }

    public final void onStart() {
    }

    public ButtonStyleController(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.style = r3;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r5, FrameLayout r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "parent");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r1 = this.style;
        if (r1 != 0) goto L5;
        int r2 = R.layout.o_dialog_button_horizontal;
    L9:
        View r7 = LayoutInflater.from(r5).inflate(r2, r6, false);
        r6.addView(r7, r0);
        this.rootView = r7;
        if (r7 == null) goto L13;
        r7.setVisibility(8);
    L13:
        this.positiveButton = (OButton) r7.findViewById(R.id.actionPositive);
        this.negativeButton = (OButton) r7.findViewById(R.id.actionNegative);
        this.neutralButton = (OButton) r7.findViewById(R.id.actionNeutral);
        this.customButtonViewContainer = (FrameLayout) r7.findViewById(R.id.custom_container);
        return;
    L5:
        if (r1 == 1) goto L7;
        r2 = R.layout.o_dialog_button_primary;
        goto L9
    L7:
        r2 = R.layout.o_dialog_button_vertical;
        goto L9
    }

    public static /* synthetic */ void setPositiveButton$default(ButtonStyleController r0, CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.setPositiveButton(r1, r2, r3, r4);
    }

    public final void setPositiveButton(CharSequence r4, final DialogInterface.OnClickListener r5, TextColorType r6, boolean r7) {
        OButton r0 = this.positiveButton;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.rootView;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        if (r7 == false) goto L15;
        r0.setBackgroundTintList(ContextCompat.getColorStateList(this.context, R.color.oui_red_6));
        r0.setTextColor(ContextCompat.getColor(this.context, R.color.white));
    L15:
        r0.setText(r4);
        setTextColor(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new ButtonStyleController$$ExternalSyntheticLambda2(this, r5));
    }

    /* JADX INFO: renamed from: setPositiveButton$lambda-2$lambda-1, reason: not valid java name */
    private static final void m256setPositiveButton$lambda2$lambda1(ButtonStyleController r1, DialogInterface.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OAlertDialog r4 = r1.dialog;
        if (r4 == null) goto L10;
        if (r2 == null) goto L8;
        r2.onClick(r4, -1);
    L8:
        r1.tryDismiss();
        return;
    }

    public static /* synthetic */ void setNegativeButton$default(ButtonStyleController r0, CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.setNegativeButton(r1, r2, r3);
    }

    public final void setNegativeButton(CharSequence r4, final DialogInterface.OnClickListener r5, TextColorType r6) {
        OButton r0 = this.negativeButton;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.rootView;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r4);
        setTextColor(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new ButtonStyleController$$ExternalSyntheticLambda0(this, r5));
    }

    /* JADX INFO: renamed from: setNegativeButton$lambda-5$lambda-4, reason: not valid java name */
    private static final void m254setNegativeButton$lambda5$lambda4(ButtonStyleController r1, DialogInterface.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OAlertDialog r4 = r1.dialog;
        if (r4 == null) goto L10;
        if (r2 == null) goto L8;
        r2.onClick(r4, -2);
    L8:
        r1.tryDismiss();
        return;
    }

    public static /* synthetic */ void setNeutralButton$default(ButtonStyleController r0, CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.setNeutralButton(r1, r2, r3);
    }

    public final void setNeutralButton(CharSequence r4, final DialogInterface.OnClickListener r5, TextColorType r6) {
        OButton r0 = this.neutralButton;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.rootView;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r4);
        setTextColor(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new ButtonStyleController$$ExternalSyntheticLambda1(this, r5));
    }

    /* JADX INFO: renamed from: setNeutralButton$lambda-8$lambda-7, reason: not valid java name */
    private static final void m255setNeutralButton$lambda8$lambda7(ButtonStyleController r1, DialogInterface.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OAlertDialog r4 = r1.dialog;
        if (r4 == null) goto L10;
        if (r2 == null) goto L8;
        r2.onClick(r4, -3);
    L8:
        r1.tryDismiss();
        return;
    }

    public final void setCustomNegativeButton(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (this.style == 2) goto L5;
        return;
    L5:
        if (this.customButtonViewContainer == null) goto L20;
        View r0 = this.rootView;
        if (r0 == null) goto L10;
        r0.setVisibility(0);
    L10:
        FrameLayout r1 = this.customButtonViewContainer;
        if (r1 == null) goto L14;
        r1.addView(r3);
    L14:
        FrameLayout r2 = this.customButtonViewContainer;
        if (r2 == null) goto L21;
        ViewExtensionsKt.makeVisible(r2);
        return;
    L21:
        return;
    }

    public final OButton getPositiveButton() {
        return this.positiveButton;
    }

    public final OButton getNegativeButton() {
        return this.negativeButton;
    }

    public final OButton getNeutralButton() {
        return this.neutralButton;
    }

    private final void setTextColor(OButton r1, TextColorType r2) {
        if (r2 == null) goto L16;
        int r0 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r0 != 1) goto L6;
        int r3 = R.color.Negative;
    L14:
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), r3));
        return;
    L6:
        if (r0 != 2) goto L8;
        r3 = R.color.TextReverse;
        goto L14
    L8:
        if (r0 != 3) goto L11;
        r3 = R.color.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.dialog = r2;
    }

    private final void tryDismiss() {
        OAlertDialog r0 = this.dialog;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        OAlertDialog r2 = this.dialog;
        if (r2 == null) goto L15;
        r2.dismiss();
        return;
    L15:
        return;
    L6:
        if (r0.isAutoDismiss() == true) goto L8;
        r1 = true;
        goto L8
    }
}
