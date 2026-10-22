package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import com.obric.common.oui.R;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OButtonGroup.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u00011B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u0007J,\u0010#\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0016J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010+\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\fH\u0016J\u0016\u0010.\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\fJ\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/button/OButtonGroup;", "Lcom/obric/oui/button/OShadowFrame;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", PerfConsts.KEY_CURRENT_CAPACITY, "isPrimary", "", "itemContainer", "Landroid/view/ViewGroup;", "itemMargin", "minWidth", "singleItemSuppressPressEffectApplied", "singleItemView", "Landroid/view/View;", "addItemView", "layoutRes", "", "itemView", "layoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", Utils.INTENT_KEY_INDEX, "applySingleItemPressEffectSuppression", "view", "checkVisibility", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getItemCount", "getItemViewAt", "initContent", "contentView", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "removeAllItemViews", "removeItemView", "removeItemViewAt", "restoreSingleItemViewState", "setEnabled", "enabled", "setItemEnabled", "setWidthMin", "updateSingleItemDelegateMode", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonGroup extends OShadowFrame {
    public static final Companion Companion = null;
    private static final int DEFAULT_CAPACITY = 5;
    private static final String TAG = "OButtonGroup";
    private int capacity;
    private boolean isPrimary;
    private ViewGroup itemContainer;
    private int itemMargin;
    private int minWidth;
    private boolean singleItemSuppressPressEffectApplied;
    private View singleItemView;

    /* JADX INFO: compiled from: OButtonGroup.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$Companion;", "", "()V", "DEFAULT_CAPACITY", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OButtonGroup(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OButtonGroup(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OButtonGroup(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OButtonGroup(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
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

    public OButtonGroup(Context r8, AttributeSet r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, 0, 8, null);
        this.capacity = 5;
        int[] r12 = R.styleable.OButtonGroup;
        Intrinsics.checkNotNullExpressionValue(r12, TAG);
        TypedArray r13 = r8.obtainStyledAttributes(r9, r12, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.minWidth = r13.getDimensionPixelSize(R.styleable.OButtonGroup_oui_widgetMinWidth, 0);
        this.itemMargin = r13.getDimensionPixelSize(R.styleable.OButtonGroup_oui_widgetInnerItemMargin, 0);
        this.capacity = r13.getDimensionPixelSize(R.styleable.OButtonGroup_oui_OButtonGroupCapacity, 5);
        r13.recycle();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void initContent(Context r2, FrameLayout r3, AttributeSet r4, TypedArray r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "contentView");
        if (r5 != null) goto L5;
        return;
    L5:
        r3.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r0 = new LinearLayout(r2);
        r0.setOrientation(0);
        r0.setGravity(17);
        LinearLayout r1 = r0;
        this.itemContainer = r1;
        r3.addView(r1);
        setWidthMin(this.minWidth);
        getContentView().setWidthMin(this.minWidth);
        updateSingleItemDelegateMode();
        checkVisibility();
        if (getEnableMaterial() == false) goto L9;
        initMaterials(r2, r5);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        getLayoutHelper().setWidthMin(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        boolean r1 = false;
        if (getItemCount() != 1) goto L5;
        boolean r0 = true;
    L6:
        boolean r3 = super.dispatchTouchEvent(r7);
        if (r0 == false) goto L28;
        int r2 = r7.getActionMasked();
        if (r2 == 0) goto L27;
        if (r2 != 1) goto L12;
    L26:
        getContentView().setPressed(false);
        goto L28
    L12:
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L26;
    L17:
        if (r7.getX() >= 0.0f) goto L19;
    L25:
        getContentView().setPressed(r1);
        goto L28
    L19:
        if (r7.getX() >= getWidth()) goto L25;
        if (r7.getY() < 0.0f) goto L25;
        if (r7.getY() >= getHeight()) goto L25;
        r1 = true;
        goto L25
    L27:
        getContentView().setPressed(true);
    L28:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public final View addItemView(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        View r5 = LayoutInflater.from(r3).inflate(r4, null, false);
        Intrinsics.checkNotNullExpressionValue(r5, "itemView");
        addItemView(r5, new ViewGroup.MarginLayoutParams(-2, -2));
        return r5;
    }

    public final void addItemView(View r2, ViewGroup.MarginLayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        addItemView(r2, r3, -1);
    }

    public final void addItemView(View r4, ViewGroup.MarginLayoutParams r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "layoutParams");
        ViewGroup r0 = this.itemContainer;
        if (r0 != null) goto L6;
        L.e(TAG, "itemContainer is null");
        return;
    L6:
        Intrinsics.checkNotNull(r0);
        int r1 = r0.getChildCount();
        int r2 = this.capacity;
        if (r1 < r2) goto L10;
        L.w(TAG, Intrinsics.stringPlus("itemContainer is full, capacity: ", Integer.valueOf(r2)));
        return;
    L10:
        if (r6 < 0) goto L13;
        ViewGroup r3 = this.itemContainer;
        Intrinsics.checkNotNull(r3);
        if (r6 > r3.getChildCount()) goto L13;
    L14:
        ViewGroup r7 = this.itemContainer;
        Intrinsics.checkNotNull(r7);
        if (r7.getChildCount() <= 0) goto L25;
        if (r6 <= 0) goto L18;
        r5.setMarginStart(this.itemMargin);
    L26:
        ViewGroup r8 = this.itemContainer;
        Intrinsics.checkNotNull(r8);
        r8.addView(r4, r6, r5);
        updateSingleItemDelegateMode();
        checkVisibility();
        return;
    L18:
        r5.setMarginStart(0);
        ViewGroup r9 = this.itemContainer;
        Intrinsics.checkNotNull(r9);
        View r10 = r9.getChildAt(0);
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L22:
        if (r12 == null) goto L26;
        r12.setMarginStart(this.itemMargin);
        r10.setLayoutParams(r12);
        goto L26
    L21:
        r12 = null;
        goto L22
    L25:
        r5.setMarginStart(0);
    L13:
        ViewGroup r13 = this.itemContainer;
        Intrinsics.checkNotNull(r13);
        r6 = r13.getChildCount();
        goto L14
    }

    public final void removeItemView() {
        ViewGroup r0 = this.itemContainer;
        if (r0 != null) goto L6;
        L.e(TAG, "itemContainer is null");
        return;
    L6:
        Intrinsics.checkNotNull(r0);
        if (r0.getChildCount() != 0) goto L10;
        L.w(TAG, "itemContainer is empty");
        return;
    L10:
        ViewGroup r1 = this.itemContainer;
        Intrinsics.checkNotNull(r1);
        removeItemViewAt(r1.getChildCount() - 1);
    }

    public final void removeItemViewAt(int r4) {
        ViewGroup r0 = this.itemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 < 0) goto L22;
        Intrinsics.checkNotNull(r0);
        if (r4 >= r0.getChildCount()) goto L23;
        ViewGroup r1 = this.itemContainer;
        Intrinsics.checkNotNull(r1);
        r1.removeViewAt(r4);
        if (r4 != 0) goto L20;
        ViewGroup r5 = this.itemContainer;
        Intrinsics.checkNotNull(r5);
        if (r5.getChildCount() <= 0) goto L20;
        ViewGroup r6 = this.itemContainer;
        Intrinsics.checkNotNull(r6);
        View r7 = r6.getChildAt(0);
        ViewGroup.LayoutParams r2 = r7.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L17:
        if (r3 == null) goto L20;
        r3.setMarginStart(0);
        r7.setLayoutParams(r3);
        goto L20
    L16:
        r3 = null;
    L20:
        updateSingleItemDelegateMode();
        checkVisibility();
        return;
    L23:
        return;
    }

    public final void removeAllItemViews() {
        ViewGroup r0 = this.itemContainer;
        if (r0 != null) goto L6;
        L.e(TAG, "itemContainer is null");
        return;
    L6:
        Intrinsics.checkNotNull(r0);
        r0.removeAllViews();
        updateSingleItemDelegateMode();
        checkVisibility();
    }

    public final int getItemCount() {
        ViewGroup r0 = this.itemContainer;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getChildCount();
    }

    public final View getItemViewAt(int r1) {
        ViewGroup r0 = this.itemContainer;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getChildAt(r1);
    }

    public final void setItemEnabled(int r3, boolean r4) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 <= (getItemCount() - 1)) goto L7;
        return;
    L7:
        if (isEnabled() == true) goto L11;
        if (r4 == false) goto L11;
        return;
    L11:
        if (getItemCount() > 1) goto L15;
        if (r3 != 0) goto L15;
        setEnabled(r4);
        return;
    L15:
        View r5 = getItemViewAt(r3);
        if (r5 == null) goto L18;
        r5.setEnabled(r4);
    L18:
        updateSingleItemDelegateMode();
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        ViewGroup r0 = this.itemContainer;
        if (r0 == null) goto L9;
        r0.setEnabled(r3);
        Iterator<View> r1 = ViewGroupKt.getChildren(r0).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().setEnabled(r3);
    L9:
        updateSingleItemDelegateMode();
    }

    private final void checkVisibility() {
        if (getItemCount() != 0) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
    }

    private final void updateSingleItemDelegateMode() {
        ViewGroup r0 = this.itemContainer;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getChildCount() != 1) goto L11;
        View r1 = r0.getChildAt(0);
        if (this.singleItemView == r1) goto L10;
        restoreSingleItemViewState();
        this.singleItemView = r1;
    L10:
        Intrinsics.checkNotNullExpressionValue(r1, "only");
        applySingleItemPressEffectSuppression(r1);
        getContentView().setChangeAlphaWhenPress(isEnabled());
        return;
    L11:
        getContentView().setChangeAlphaWhenPress(false);
        restoreSingleItemViewState();
    }

    private final void restoreSingleItemViewState() {
        KeyEvent.Callback r0 = this.singleItemView;
        if (r0 != null) goto L5;
    L13:
        this.singleItemView = null;
        this.singleItemSuppressPressEffectApplied = false;
        return;
    L5:
        if (this.singleItemSuppressPressEffectApplied == false) goto L13;
        if ((r0 instanceof IOUIAlpha) == false) goto L9;
        IOUIAlpha r1 = (IOUIAlpha) r0;
    L10:
        if (r1 == null) goto L13;
        r1.setChangeAlphaWhenPress(true);
        goto L13
    L9:
        r1 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void applySingleItemPressEffectSuppression(View r2) {
        if ((r2 instanceof IOUIAlpha) == false) goto L5;
        IOUIAlpha r3 = (IOUIAlpha) r2;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        r3.setChangeAlphaWhenPress(false);
        this.singleItemSuppressPressEffectApplied = true;
        return;
    L5:
        r3 = null;
        goto L6
    }
}
