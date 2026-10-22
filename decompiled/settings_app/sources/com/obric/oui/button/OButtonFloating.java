package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OButtonFloating.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J,\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001a\u001a\u00020\u00112\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/oui/button/OButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "textView", "Lcom/obric/oui/text/OBaseTextView;", "getTextView", "()Lcom/obric/oui/text/OBaseTextView;", "setTextView", "(Lcom/obric/oui/text/OBaseTextView;)V", "applyDynamicTheme", "", "themeStyle", "getTitleView", "Landroid/widget/TextView;", "initContent", "contentView", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "setTitle", "text", "", "textRes", "updateUIOnEnableChanged", IndexDatabaseHelper.IndexColumns.ENABLED, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OButtonFloating extends OShadowFrame {
    public OBaseTextView textView;

    public OButtonFloating(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OButtonFloating(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OButtonFloating(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OButtonFloating(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public OButtonFloating(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
    }

    public final OBaseTextView getTextView() {
        OBaseTextView r0 = this.textView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        return null;
    }

    public final void setTextView(OBaseTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textView = r2;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void initContent(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contentView");
        if (r13 != null) goto L5;
        return;
    L5:
        CharSequence r14 = r13.getText(R.styleable.OShadowFrame_oui_widgetText);
        int r0 = r13.getResourceId(R.styleable.OShadowFrame_oui_widgetTextStyle, R.style.Button_2_Medium);
        int r1 = r13.getColor(R.styleable.OShadowFrame_oui_widgetTextColor, getResources().getColor(R.color.oui_basic_text_1, null));
        OBaseTextView r8 = new OBaseTextView(r10, null, 0, 6, null);
        r8.setTextAppearance(r0);
        r8.setTextColor(r1);
        r8.setText(r14);
        r8.setSingleLine();
        r8.setIncludeFontPadding(false);
        r8.setGravity(17);
        setTextView(r8);
        OBaseTextView r2 = getTextView();
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        Unit r15 = Unit.INSTANCE;
        r11.addView(r2, r3);
        if (getMaterialApplied() == false) goto L9;
        initMaterials(r10, r13);
        return;
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r1) {
        super.applyDynamicTheme(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame
    protected void updateUIOnEnableChanged(boolean r1) {
        super.updateUIOnEnableChanged(r1);
        if (r1 == false) goto L5;
        getTextView().setAlpha(1.0f);
        return;
    L5:
        getTextView().setAlpha(0.3f);
    }

    public final TextView getTitleView() {
        return getTextView();
    }

    public final void setTitle(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        getTextView().setText(r2);
    }

    public final void setTitle(int r1) {
        getTextView().setText(r1);
    }
}
