package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OInsetTitleBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020+H\u0014J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0007H\u0016J.\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001022\b\u00104\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u000102J&\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007J&\u00106\u001a\u00020+2\u0006\u00101\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\"\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\rR\"\u0010(\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\r¨\u0006:"}, d2 = {"Lcom/obric/oui/sheet/OInsetTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroid/widget/ImageView;", "endButton0", "getEndButton0", "()Landroid/widget/ImageView;", "endButton1", "getEndButton1", "mEnd0Color", "getMEnd0Color", "()I", "setMEnd0Color", "(I)V", "mEnd1Color", "getMEnd1Color", "setMEnd1Color", "mLine", "Landroid/view/View;", "mRightAction", "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mStart0Color", "getMStart0Color", "setMStart0Color", "mStart1Color", "getMStart1Color", "setMStart1Color", "startButton0", "getStartButton0", "startButton1", "getStartButton1", "init", "", "initAttrs", "onAttachedToWindow", "setDividerLineBackground", "color", "setDrawables", "start0", "Landroid/graphics/drawable/Drawable;", "start1", "end0", "end1", "setTint", "showDividerLine", InvokeHistoryActivity.PREF_SHOW, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInsetTitleBar extends OTitleBar {
    private ImageView endButton0;
    private ImageView endButton1;
    private int mEnd0Color;
    private int mEnd1Color;
    private View mLine;
    public FrameLayout mRightAction;
    private int mStart0Color;
    private int mStart1Color;
    private ImageView startButton0;
    private ImageView startButton1;

    public OInsetTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OInsetTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OInsetTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OInsetTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        init(r2);
        if (r3 == null) goto L6;
        initAttrs(r3);
        return;
    }

    public final ImageView getStartButton0() {
        return this.startButton0;
    }

    public final ImageView getStartButton1() {
        return this.startButton1;
    }

    public final ImageView getEndButton1() {
        return this.endButton1;
    }

    public final ImageView getEndButton0() {
        return this.endButton0;
    }

    public final FrameLayout getMRightAction() {
        FrameLayout r0 = this.mRightAction;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightAction");
        return null;
    }

    public final void setMRightAction(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mRightAction = r2;
    }

    private final void init(Context r3) {
        OTitleBar.inflate(r3, R.layout.o_view_inset_title_bar, this);
        this.startButton0 = (ImageView) findViewById(R.id.iv_start_0);
        this.startButton1 = (ImageView) findViewById(R.id.iv_start_1);
        this.endButton0 = (ImageView) findViewById(R.id.iv_end_0);
        this.endButton1 = (ImageView) findViewById(R.id.iv_end_1);
        this.mTitleView = (TextView) findViewById(R.id.title);
        View r4 = findViewById(R.id.fl_right_container);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.fl_right_container)");
        setMRightAction((FrameLayout) r4);
        this.mLine = findViewById(R.id.line);
    }

    private final void initAttrs(AttributeSet r5) {
        TypedArray r6 = getContext().getTheme().obtainStyledAttributes(r5, R.styleable.OCompoundTitleBar, 0, 0);
        setTitle(r6.getString(R.styleable.OCompoundTitleBar_oui_centerText));     // Catch: Throwable -> L6
        setTitleColor(r6.getColor(R.styleable.OCompoundTitleBar_oui_centerTextColor, ContextCompat.getColor(getContext(), R.color.TextPrimary)));     // Catch: Throwable -> L6
        setTitleSizePixel(r6.getDimension(R.styleable.OCompoundTitleBar_oui_centerTextSize, OUnitExtensionKt.dp2px(17)));     // Catch: Throwable -> L6
        int r0 = r6.getColor(R.styleable.OCompoundTitleBar_oui_dividerColor, ContextCompat.getColor(getContext(), R.color.LinePrimary));     // Catch: Throwable -> L6
        showDividerLine(r6.getBoolean(R.styleable.OCompoundTitleBar_oui_dividerVisible, false));     // Catch: Throwable -> L6
        setDividerLineBackground(r0);     // Catch: Throwable -> L6
        r6.recycle();
        return;
    L6:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    public final int getMStart0Color() {
        return this.mStart0Color;
    }

    public final void setMStart0Color(int r1) {
        this.mStart0Color = r1;
    }

    public final int getMStart1Color() {
        return this.mStart1Color;
    }

    public final void setMStart1Color(int r1) {
        this.mStart1Color = r1;
    }

    public final int getMEnd0Color() {
        return this.mEnd0Color;
    }

    public final void setMEnd0Color(int r1) {
        this.mEnd0Color = r1;
    }

    public final int getMEnd1Color() {
        return this.mEnd1Color;
    }

    public final void setMEnd1Color(int r1) {
        this.mEnd1Color = r1;
    }

    public final void setTint(int r2, int r3, int r4, int r5) {
        this.mStart0Color = r2;
        this.mStart1Color = r3;
        this.mEnd0Color = r4;
        this.mEnd1Color = r5;
        ImageView r0 = this.startButton0;
        if (r0 == null) goto L6;
        r0.setColorFilter(r2);
    L6:
        ImageView r6 = this.startButton1;
        if (r6 == null) goto L10;
        r6.setColorFilter(r3);
    L10:
        ImageView r7 = this.endButton0;
        if (r7 == null) goto L14;
        r7.setColorFilter(r4);
    L14:
        ImageView r1 = this.endButton1;
        if (r1 == null) goto L19;
        r1.setColorFilter(r5);
        return;
    }

    public final void setDrawables(int r3, int r4, int r5, int r6) {
        Drawable r0 = null;
        if (r3 == 0) goto L5;
        Drawable r7 = ContextCompat.getDrawable(getContext(), r3);
    L6:
        if (r4 == 0) goto L8;
        Drawable r8 = ContextCompat.getDrawable(getContext(), r4);
    L9:
        if (r5 == 0) goto L11;
        Drawable r9 = ContextCompat.getDrawable(getContext(), r5);
    L12:
        if (r6 == 0) goto L14;
        r0 = ContextCompat.getDrawable(getContext(), r6);
    L14:
        setDrawables(r7, r8, r9, r0);
        return;
    L11:
        r9 = null;
        goto L12
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public final void setDrawables(Drawable r5, Drawable r6, Drawable r7, Drawable r8) {
        if (r5 != null) goto L12;
        ImageView r3 = this.startButton0;
        if (r3 == null) goto L8;
        r3.setVisibility(4);
    L8:
        ImageView r4 = this.startButton0;
        if (r4 == null) goto L16;
        r4.setOnClickListener(null);
    L16:
        ImageView r9 = this.startButton0;
        if (r9 == null) goto L20;
        r9.setImageDrawable(r5);
    L20:
        if (r6 != null) goto L29;
        ImageView r10 = this.startButton1;
        if (r10 == null) goto L25;
        r10.setVisibility(4);
    L25:
        ImageView r11 = this.startButton1;
        if (r11 == null) goto L33;
        r11.setOnClickListener(null);
    L33:
        ImageView r12 = this.startButton1;
        if (r12 == null) goto L37;
        r12.setImageDrawable(r6);
    L37:
        if (r7 != null) goto L46;
        ImageView r13 = this.endButton0;
        if (r13 == null) goto L42;
        r13.setVisibility(4);
    L42:
        ImageView r14 = this.endButton0;
        if (r14 == null) goto L50;
        r14.setOnClickListener(null);
    L50:
        ImageView r15 = this.endButton0;
        if (r15 == null) goto L54;
        r15.setImageDrawable(r7);
    L54:
        if (r8 != null) goto L63;
        ImageView r16 = this.endButton1;
        if (r16 == null) goto L59;
        r16.setVisibility(4);
    L59:
        ImageView r17 = this.endButton1;
        if (r17 == null) goto L67;
        r17.setOnClickListener(null);
    L67:
        ImageView r18 = this.endButton1;
        if (r18 == null) goto L72;
        r18.setImageDrawable(r8);
        return;
    L72:
        return;
    L63:
        ImageView r19 = this.endButton1;
        if (r19 == null) goto L67;
        r19.setVisibility(0);
        goto L67
    L46:
        ImageView r20 = this.endButton0;
        if (r20 == null) goto L50;
        r20.setVisibility(0);
        goto L50
    L29:
        ImageView r21 = this.startButton1;
        if (r21 == null) goto L33;
        r21.setVisibility(0);
        goto L33
    L12:
        ImageView r22 = this.startButton0;
        if (r22 == null) goto L16;
        r22.setVisibility(0);
        goto L16
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void showDividerLine(boolean r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView r0 = this.startButton0;
        if (r0 == null) goto L6;
        ViewExtensionsKt.expandTouchArea$default(r0, OUnitExtensionKt.dp2px(40), OUnitExtensionKt.dp2px(44), false, 4, null);
    L6:
        ImageView r1 = this.startButton1;
        if (r1 == null) goto L10;
        ViewExtensionsKt.expandTouchArea$default(r1, OUnitExtensionKt.dp2px(40), OUnitExtensionKt.dp2px(44), false, 4, null);
    L10:
        ImageView r2 = this.endButton0;
        if (r2 == null) goto L14;
        ViewExtensionsKt.expandTouchArea$default(r2, OUnitExtensionKt.dp2px(40), OUnitExtensionKt.dp2px(44), false, 4, null);
    L14:
        ImageView r9 = this.endButton1;
        if (r9 == null) goto L19;
        ViewExtensionsKt.expandTouchArea$default(r9, OUnitExtensionKt.dp2px(40), OUnitExtensionKt.dp2px(44), false, 4, null);
        return;
    }
}
