package com.bytedanceos.security.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: UpdateButtonView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/security/widget/UpdateButtonView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionButton", "Lcom/obric/oui/button/OButton;", "loadingView", "Lcom/obric/oui/progress/ODownloadProgressView;", "setOnClickListener", "", "l", "Landroid/view/View$OnClickListener;", "setText", "text", "", "resId", "showDisabledState", "showLoadingState", "showNormalState", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateButtonView extends LinearLayout {
    private static final Companion Companion = null;

    @Deprecated
    private static final float DISABLED_ALPHA = 0.3f;

    @Deprecated
    private static final long FAKE_LOADING_DURATION_MS = 2000;
    private HashMap _$_findViewCache;
    private final OButton actionButton;
    private final ODownloadProgressView loadingView;

    /* JADX INFO: compiled from: UpdateButtonView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/security/widget/UpdateButtonView$Companion;", "", "()V", "DISABLED_ALPHA", "", "FAKE_LOADING_DURATION_MS", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public UpdateButtonView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public UpdateButtonView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public /* synthetic */ UpdateButtonView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        AttributeSet r6 = (AttributeSet) null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public UpdateButtonView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        ViewGroup.LayoutParams r16 = getLayoutParams();
        if (r16 != null) goto L5;
        r16 = new ViewGroup.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())));
    L5:
        setLayoutParams(r16);
        setOrientation(0);
        setGravity(17);
        setMinimumWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 52, Resources.getSystem().getDisplayMetrics())));
        float r3 = 12;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), 0);
        setBackground(ContextCompat.getDrawable(r13, R.drawable.safe_check_update_button_bg));
        setClickable(false);
        setFocusable(false);
        ODownloadProgressView r4 = new ODownloadProgressView(r13);
        float r5 = 16;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())));
        r6.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        Unit r1 = Unit.INSTANCE;
        r4.setLayoutParams(r6);
        r4.setVisibility(8);
        r4.setClickable(false);
        r4.setFocusable(false);
        Unit r2 = Unit.INSTANCE;
        this.loadingView = r4;
        OButton r7 = new OButton(r13, r14, 0, 0, null, 28, null);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Drawable r0 = (Drawable) null;
        r7.setBackground(null);
        r7.setPadding(0, 0, 0, 0);
        r7.setMinWidth(0);
        r7.setMinimumWidth(0);
        r7.setMinHeight(0);
        r7.setMinimumHeight(0);
        r7.setIncludeFontPadding(false);
        r7.setGravity(17);
        r7.setText(r13.getString(R.string.update));
        r7.setTextSize(2, 14.0f);
        r7.setTextColor(ContextCompat.getColor(r13, R.color.oui_text_1));
        Unit r17 = Unit.INSTANCE;
        this.actionButton = r7;
        addView(r4);
        addView(r7);
    }

    public final void setText(CharSequence r1) {
        this.actionButton.setText(r1);
    }

    public final void setText(int r1) {
        this.actionButton.setText(r1);
    }

    public final void showLoadingState() {
        this.actionButton.setText(getContext().getString(R.string.updating));
        this.actionButton.setEnabled(false);
        this.actionButton.setClickable(false);
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), 0);
        this.loadingView.setVisibility(0);
        this.loadingView.setCurrentState(0);
        this.actionButton.setAlpha(1.0f);
    }

    public final void showDisabledState() {
        this.actionButton.setEnabled(false);
        this.actionButton.setClickable(false);
        float r0 = 12;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), 0);
        this.loadingView.setCurrentState(10);
        this.loadingView.setVisibility(8);
        this.actionButton.setAlpha(0.3f);
    }

    public final void showNormalState() {
        this.actionButton.setText(getContext().getString(R.string.update));
        this.actionButton.setEnabled(true);
        this.actionButton.setClickable(true);
        float r0 = 12;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), 0);
        this.loadingView.setCurrentState(10);
        this.loadingView.setVisibility(8);
        this.actionButton.setAlpha(1.0f);
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener r3) {
        this.actionButton.setOnClickListener(new AnonymousClass1(this, r3));
    }
}
