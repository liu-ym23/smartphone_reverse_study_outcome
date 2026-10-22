package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.common.util.ODrawableHelperKt;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.VectorBreaker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OCheckBox.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u001d\b\u0016\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0003FGHB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010&\u001a\u00020'H\u0002J$\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020'H\u0014J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\nH\u0016J0\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0014J\u0018\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0014J\b\u00107\u001a\u00020\rH\u0016J\u000e\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\rJ\u0010\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020\rH\u0016J\u000e\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020\rJ\u0010\u0010>\u001a\u00020'2\b\u0010?\u001a\u0004\u0018\u00010\"J\u0010\u0010@\u001a\u00020'2\b\u0010?\u001a\u0004\u0018\u00010$J\u0010\u0010A\u001a\u00020'2\b\b\u0001\u0010B\u001a\u00020\nJ\b\u0010C\u001a\u00020'H\u0002J\b\u0010D\u001a\u00020'H\u0002J\b\u0010E\u001a\u00020'H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptForCSR", "", "alwaysLight", "broadcasting", "buttonDrawable", "Landroid/graphics/drawable/Drawable;", "checkedColorFilter", "Landroid/graphics/ColorFilter;", "value", "checkedState", "getCheckedState$annotations", "()V", "getCheckedState", "()I", "setCheckedState", "(I)V", "colorChecked", "colorPrimary", "colorStyle", "colorUnchecked", "iconSize", "onCheckedChangeListener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "onCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "uncheckedColorFilter", "createColorFilter", "", "init", "isChecked", "onAttachedToWindow", "onCreateDrawableState", "", "extraSpace", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performClick", "setAlwaysLight", "light", "setChecked", "checked", "setEnableExpandTouchRect", "enableExpand", "setOnCheckedChangeListener", "listener", "setOnCheckedStateChangedListener", "setPrimaryColor", "color", "syncButtonCheckState", "syncDrawableStyle", "toggle", "Companion", "OnCheckedChangeListener", "OnCheckedStateChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCheckBox extends AppCompatImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int COLOR_DEFAULT = 0;
    public static final int COLOR_ON_IMAGE = 1;
    public static final Companion Companion = null;
    private static final int[] INDETERMINATE_STATE_SET = null;
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;
    private boolean adaptForCSR;
    private boolean alwaysLight;
    private boolean broadcasting;
    private Drawable buttonDrawable;
    private ColorFilter checkedColorFilter;
    private int checkedState;
    private int colorChecked;
    private int colorPrimary;
    private int colorStyle;
    private int colorUnchecked;
    private int iconSize;
    private OnCheckedChangeListener onCheckedChangeListener;
    private OnCheckedStateChangedListener onCheckedStateChangedListener;
    private ColorFilter uncheckedColorFilter;

    /* JADX INFO: compiled from: OCheckBox.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$Companion;", "", "()V", "CHECKED_STATE_SET", "", "COLOR_DEFAULT", "", "COLOR_ON_IMAGE", "INDETERMINATE_STATE_SET", "STATE_CHECKED", "STATE_INDETERMINATE", "STATE_UNCHECKED", "CheckedState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: OCheckBox.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$Companion$CheckedState;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface CheckedState {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OCheckBox.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "", "onCheckedChanged", "", "buttonView", "Lcom/obric/oui/checkbox/OCheckBox;", "isChecked", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCheckedChangeListener {
        void onCheckedChanged(OCheckBox r1, boolean r2);
    }

    /* JADX INFO: compiled from: OCheckBox.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "", "onCheckedStateChangedListener", "", "buttonView", "Lcom/obric/oui/checkbox/OCheckBox;", "state", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCheckedStateChangedListener {
        void onCheckedStateChangedListener(OCheckBox r1, int r2);
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    static {
        Companion = new Companion(null);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        INDETERMINATE_STATE_SET = new int[]{com.obric.common.oui.R.attr.oui_state_indeterminate};
    }

    public final int getCheckedState() {
        return this.checkedState;
    }

    public final void setCheckedState(int r2) {
        if (this.checkedState == r2) goto L19;
        this.checkedState = r2;
        syncButtonCheckState();
        refreshDrawableState();
        if (this.broadcasting == false) goto L7;
        return;
    L7:
        this.broadcasting = true;
        OnCheckedStateChangedListener r3 = this.onCheckedStateChangedListener;
        if (r3 == null) goto L12;
        r3.onCheckedStateChangedListener(this, this.checkedState);
    L12:
        if (this.checkedState == 2) goto L17;
        OnCheckedChangeListener r4 = this.onCheckedChangeListener;
        if (r4 == null) goto L17;
        r4.onCheckedChanged(this, isChecked());
    L17:
        this.broadcasting = false;
        return;
    }

    public OCheckBox(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        this.iconSize = OUnitExtensionKt.vdp(this, 18);
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r8, null, 0, 4, null);
    }

    public OCheckBox(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "attrs");
        super(r8, r9);
        this.iconSize = OUnitExtensionKt.vdp(this, 18);
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r8, r9, 0, 4, null);
    }

    public OCheckBox(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        super(r3, r4, r5);
        this.iconSize = OUnitExtensionKt.vdp(this, 18);
        this.colorPrimary = -1;
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init(r3, r4, r5);
    }

    static /* synthetic */ void init$default(OCheckBox r0, Context r1, AttributeSet r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = com.obric.common.oui.R.attr.OCheckBoxStyle;
    L6:
        r0.init(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    private final void init(Context r3, AttributeSet r4, int r5) {
        TypedArray r6 = r3.obtainStyledAttributes(r4, com.obric.common.oui.R.styleable.OCheckBox, r5, 0);
        Intrinsics.checkNotNullExpressionValue(r6, "context.obtainStyledAttr…heckBox, defStyleAttr, 0)");
        this.colorStyle = r6.getInt(com.obric.common.oui.R.styleable.OCheckBox_oui_checkBoxColorStyle, 0);
        this.adaptForCSR = r6.getBoolean(com.obric.common.oui.R.styleable.ORadio_oui_adapt_for_csr, true);
        this.colorPrimary = r6.getColor(com.obric.common.oui.R.styleable.OCheckBox_oui_checkBoxPrimaryColor, -1);
        this.colorChecked = r6.getColor(com.obric.common.oui.R.styleable.OCheckBox_oui_checkBoxCheckedColor, -1);
        this.colorUnchecked = r6.getColor(com.obric.common.oui.R.styleable.OCheckBox_oui_checkBoxUncheckedColor, -1);
        Drawable r7 = r6.getDrawable(com.obric.common.oui.R.styleable.OCheckBox_oui_checkBoxButton);
        if (r7 != null) goto L5;
        r7 = null;
    L5:
        this.buttonDrawable = r7;
        this.alwaysLight = r6.getBoolean(com.obric.common.oui.R.styleable.OCheckBox_oui_checkBoxAlwaysLight, false);
        if (r6.hasValue(com.obric.common.oui.R.styleable.OCheckBox_oui_checkedState) == false) goto L8;
        setCheckedState(r6.getInt(com.obric.common.oui.R.styleable.OCheckBox_oui_checkedState, 0));
    L8:
        r6.recycle();
        createColorFilter();
        Drawable r8 = this.buttonDrawable;
        if (r8 != null) goto L11;
        syncDrawableStyle();
    L12:
        setBackground(null);
        syncButtonCheckState();
        setClickable(true);
        return;
    L11:
        setImageDrawable(r8);
        goto L12
    }

    public final void setPrimaryColor(int r1) {
        this.colorPrimary = r1;
        syncDrawableStyle();
        invalidate();
    }

    public final void setAlwaysLight(boolean r1) {
        this.alwaysLight = r1;
        syncDrawableStyle();
        invalidate();
    }

    public final void setEnableExpandTouchRect(boolean r1) {
        this.adaptForCSR = r1;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824);
        super.onMeasure(r3, r3);
    }

    private final void syncDrawableStyle() {
        boolean r0 = this.alwaysLight;
        if (r0 == false) goto L5;
        Drawable r1 = getResources().getDrawable(com.obric.common.oui.R.drawable.o_checkbox_circle_always_light, null);
    L11:
        this.buttonDrawable = r1;
        if (this.colorPrimary != (-1)) goto L14;
    L20:
        setImageDrawable(this.buttonDrawable);
        return;
    L14:
        if ((r1 instanceof StateListDrawable) == false) goto L20;
        VectorBreaker r2 = VectorBreaker.INSTANCE;
        Drawable r3 = this.buttonDrawable;
        if (r3 == null) goto L19;
        r2.setPathColor((StateListDrawable) r3, "primary_shape", this.colorPrimary);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
    L5:
        if (r0 == false) goto L7;
        r1 = getResources().getDrawable(com.obric.common.oui.R.drawable.o_checkbox_circle, null);
        goto L11
    L7:
        if (this.colorStyle != 1) goto L9;
        r1 = getResources().getDrawable(com.obric.common.oui.R.drawable.o_checkbox_circle_on_image, null);
        goto L11
    L9:
        r1 = getResources().getDrawable(com.obric.common.oui.R.drawable.o_checkbox_circle, null);
        goto L11
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (this.checkedState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean r0 = super.performClick();
        if (r0 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        VibratorSmt.vibrateEffectWithHapticPlayer(getContext(), 1);
    L8:
        return r0;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        setCheckedState(r1 ? 1 : 0);
    }

    public final void setOnCheckedStateChangedListener(OnCheckedStateChangedListener r1) {
        this.onCheckedStateChangedListener = r1;
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener r1) {
        this.onCheckedChangeListener = r1;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r3) {
        int[] r4 = super.onCreateDrawableState(r3 + 2);
        if (this.checkedState != 2) goto L6;
        AppCompatImageView.mergeDrawableStates(r4, INDETERMINATE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r4, CHECKED_STATE_SET);
    L8:
        return r4;
    }

    private final void syncButtonCheckState() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L6;
        r0.clearColorFilter();
    L6:
        createColorFilter();
        Drawable r1 = getDrawable();
        if (r1 != null) goto L10;
        return;
    L10:
        if (isChecked() == false) goto L12;
        ColorFilter r2 = this.checkedColorFilter;
    L13:
        r1.setColorFilter(r2);
        return;
    L12:
        r2 = this.uncheckedColorFilter;
        goto L13
    }

    private final void createColorFilter() {
        int r0 = this.colorChecked;
        if (r0 == (-1)) goto L6;
        this.checkedColorFilter = ODrawableHelperKt.createTintBlackColorFilter(r0);
    L6:
        if (this.colorUnchecked == (-1)) goto L9;
        this.uncheckedColorFilter = new PorterDuffColorFilter(this.colorUnchecked, PorterDuff.Mode.SRC_IN);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        OCheckBox r1 = this;
        ViewExtensionsKt.expandTouchArea(r1, OUnitExtensionKt.vdp(r1, 44));
        return;
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
