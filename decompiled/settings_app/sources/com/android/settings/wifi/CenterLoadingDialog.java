package com.android.settings.wifi;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.icu.lang.UCharacter;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.settings.databinding.CenterLoadingLayoutBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: CenterLoadingDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/android/settings/wifi/CenterLoadingDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "title", "", "message", "actionText", "icon", "", "actionClick", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CenterLoadingDialog extends Dialog {
    /* JADX INFO: renamed from: $r8$lambda$fDXWWBmFEwow27jC2b2-HOxaaow, reason: not valid java name */
    public static /* synthetic */ void m666$r8$lambda$fDXWWBmFEwow27jC2b2HOxaaow(Function0 r0, CenterLoadingDialog r1, View r2) {
        _init_$lambda$0(r0, r1, r2);
    }

    public /* synthetic */ CenterLoadingDialog(Context r8, String r9, String r10, String r11, int r12, Function0 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = -1;
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }

    public CenterLoadingDialog(Context r3, String r4, String r5, String r6, int r7, final Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r8, "actionClick");
        super(r3);
        CenterLoadingLayoutBinding r9 = CenterLoadingLayoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r9, "inflate(...)");
        setContentView(r9.getRoot());
        r9.mainTitle.setText(r4);
        String r10 = r5;
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        r9.message.setText(r10);
        r9.message.setVisibility(0);
    L11:
        String r11 = r6;
        if (r11 != null) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == true) goto L21;
        r9.actionBtn.setVisibility(0);
        r9.actionBtn.setText(r11);
        r9.actionBtn.setOnClickListener(new CenterLoadingDialog$$ExternalSyntheticLambda0(r8, this));
    L21:
        if (r7 == (-1)) goto L23;
        r9.loadingView.setVisibility(4);
        ImageView r13 = r9.mainIcon;
        r13.setVisibility(0);
        r13.setImageResource(r7);
    L23:
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window r2 = getWindow();
        if (r2 == null) goto L26;
        r2.setBackgroundDrawable(new ColorDrawable(0));
    L26:
        ConstraintLayout r14 = r9.getRoot();
        Intrinsics.checkNotNullExpressionValue(r14, "getRoot(...)");
        ConstraintLayout r15 = r14;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L31;
        r16.width = MathKt.roundToInt(TypedValue.applyDimension(1, UCharacter.UnicodeBlock.ZANABAZAR_SQUARE_ID, Resources.getSystem().getDisplayMetrics()));
        r15.setLayoutParams(r16);
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        if (r11.length() == 0) goto L17;
        r12 = false;
        goto L18
    L5:
        if (r10.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final void _init_$lambda$0(Function0 r0, CenterLoadingDialog r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$actionClick");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke();
        r1.dismiss();
    }
}
