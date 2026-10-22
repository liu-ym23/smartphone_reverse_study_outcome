package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.text.OTextView;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OFormItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/forms/OFormItem;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vInput", "Lcom/obric/oui/forms/OInputView;", "vLabel", "Lcom/obric/oui/text/OTextView;", "getInputView", "getLabelView", "initViews", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFormItem extends LinearLayoutCompat {
    private final OInputView vInput;
    private final OTextView vLabel;

    public OFormItem(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OFormItem(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OFormItem(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OFormItem(Context r17, AttributeSet r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r19);
        OTextView r15 = new OTextView(new ContextThemeWrapper(r17, R.style.Label_L), null, 0, null, 14, null);
        this.vLabel = r15;
        OInputView r8 = new OInputView(r17, null, 0, 6, null);
        this.vInput = r8;
        setGravity(16);
        TypedArray r1 = r17.obtainStyledAttributes(r18, androidx.appcompat.R.styleable.LinearLayoutCompat, r19, 0);
        int r2 = r1.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (r2 < 0) goto L5;
        setGravity(r2);
    L5:
        r1.recycle();
        addView(r15);
        addView(r8);
        initViews();
    }

    private final void initViews() {
        this.vInput.setShowLabel(false);
        OTextView r0 = this.vLabel;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L21;
        LinearLayoutCompat.LayoutParams r2 = (LinearLayoutCompat.LayoutParams) r1;
        LinearLayoutCompat.LayoutParams r3 = r2;
        if (getOrientation() != 0) goto L7;
        int r4 = OUnitExtensionKt.vdp(this, 72);
    L8:
        r3.width = r4;
        r3.height = -2;
        r0.setLayoutParams(r2);
        this.vLabel.setText(PushLog.KEY_LABEL);
        this.vInput.setHint("hint");
        OInputView r5 = this.vInput;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L19;
        LinearLayoutCompat.LayoutParams r7 = (LinearLayoutCompat.LayoutParams) r6;
        LinearLayoutCompat.LayoutParams r8 = r7;
        r8.weight = 1.0f;
        r8.width = -1;
        r8.height = -2;
        if (getOrientation() != 1) goto L14;
        r8.topMargin = OUnitExtensionKt.vdp(this, 8);
    L16:
        r5.setLayoutParams(r7);
        return;
    L14:
        if (getOrientation() != 0) goto L16;
        OFormItem r9 = this;
        r8.setMarginStart(OUnitExtensionKt.vdp(r9, 12));
        r8.leftMargin = OUnitExtensionKt.vdp(r9, 12);
        goto L16
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    L7:
        r4 = -1;
        goto L8
    L21:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    }

    public final OTextView getLabelView() {
        return this.vLabel;
    }

    public final OInputView getInputView() {
        return this.vInput;
    }
}
