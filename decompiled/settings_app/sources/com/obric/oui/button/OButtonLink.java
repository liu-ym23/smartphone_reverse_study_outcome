package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.ColorUtils;
import com.obric.common.oui.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OButtonLink.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/button/OButtonLink;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "arrowView", "Landroid/widget/ImageView;", "pressOverlayColor", "textView", "Lcom/obric/oui/text/OBaseTextView;", "getAnimatedOverlayColor", "fraction", "", "initView", "", "onPressAlphaChange", "alpha", "updateContentColorOnPress", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonLink extends OUILinearLayout {
    private static final float ALPHA_ON_PRESS = 0.7f;
    public static final Companion Companion = null;
    private static final String TAG = "OButtonLink";
    private ImageView arrowView;
    private final int pressOverlayColor;
    private OBaseTextView textView;

    /* JADX INFO: compiled from: OButtonLink.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/button/OButtonLink$Companion;", "", "()V", "ALPHA_ON_PRESS", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OButtonLink(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OButtonLink(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OButtonLink(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OButtonLink(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
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

    public OButtonLink(Context r8, AttributeSet r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, null, 8, null);
        this.pressOverlayColor = r8.getResources().getColor(R.color.oui_state_overlay_pressed_on_color);
        initView(r8, r9);
    }

    private final void initView(Context r18, AttributeSet r19) {
        TypedArray r8 = r18.obtainStyledAttributes(r19, R.styleable.OButtonLink);
        Intrinsics.checkNotNullExpressionValue(r8, "context.obtainStyledAttr… R.styleable.OButtonLink)");
        String r9 = r8.getString(R.styleable.OButtonLink_oui_widgetText);
        int r10 = r8.getResourceId(R.styleable.OButtonLink_oui_widgetTextStyle, R.style.Button_1_Medium);
        Drawable r11 = null;
        int r12 = r8.getColor(R.styleable.OButtonLink_oui_widgetTextColor, getResources().getColor(R.color.oui_accent_7_fg, null));
        boolean r14 = r8.getBoolean(R.styleable.OButtonLink_oui_buttonLinkShowArrow, false);
        Drawable r15 = r8.getDrawable(R.styleable.OButtonLink_oui_buttonLinkArrowDrawable);
        setOrientation(0);
        OBaseTextView r6 = new OBaseTextView(r18, null, 0, 6, null);
        r6.setSingleLine();
        r6.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r6.setTextAppearance(r10);
        r6.setTextColor(r12);
        r6.setText(r9);
        r6.setIncludeFontPadding(false);
        r6.setGravity(17);
        this.textView = r6;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.weight = 1.0f;
        Unit r3 = Unit.INSTANCE;
        addView(r6, r1);
        if (r14 == false) goto L12;
        AppCompatImageView r2 = new AppCompatImageView(r18);
        if (r15 == null) goto L11;
        Drawable r4 = r15.mutate();
        if (r4 == null) goto L11;
        r4.setTint(r12);
        r11 = r4;
    L11:
        r2.setImageDrawable(r11);
        AppCompatImageView r5 = r2;
        this.arrowView = r5;
        addView(r5, new LinearLayout.LayoutParams(-2, -2));
    L12:
        r8.recycle();
        setOverridePressColor(0);
        refreshColors(TAG);
        setChangeAlphaWhenPress(true);
        setClickable(true);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r3) {
        updateContentColorOnPress(RangesKt.coerceIn(r3 / 255.0f, 0.0f, 1.0f));
    }

    private final void updateContentColorOnPress(float r5) {
        int r0 = getAnimatedOverlayColor(r5);
        OBaseTextView r1 = null;
        if (r5 <= 0.0f) goto L5;
        PorterDuffColorFilter r6 = new PorterDuffColorFilter(r0, PorterDuff.Mode.SRC_ATOP);
    L6:
        OBaseTextView r2 = this.textView;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r2 = null;
    L9:
        PorterDuffColorFilter r3 = r6;
        r2.getPaint().setColorFilter(r3);
        OBaseTextView r4 = this.textView;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L13:
        r1.invalidate();
        if (r6 == null) goto L19;
        ImageView r7 = this.arrowView;
        if (r7 == null) goto L25;
        r7.setColorFilter(r3);
        return;
    L25:
        return;
    L19:
        ImageView r8 = this.arrowView;
        if (r8 == null) goto L26;
        r8.clearColorFilter();
        return;
    L26:
        return;
    L12:
        r1 = r4;
        goto L13
    L5:
        PorterDuffColorFilter r9 = (PorterDuffColorFilter) null;
        r6 = null;
        goto L6
    }

    private final int getAnimatedOverlayColor(float r3) {
        return ColorUtils.setAlphaComponent(this.pressOverlayColor, RangesKt.coerceIn(MathKt.roundToInt(r3 * Color.alpha(this.pressOverlayColor)), 0, 255));
    }
}
