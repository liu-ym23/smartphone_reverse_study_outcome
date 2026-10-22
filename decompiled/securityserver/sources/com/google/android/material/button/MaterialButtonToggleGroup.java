package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final int DEF_STYLE_RES = 0;
    private static final String LOG_TAG = "MaterialButtonToggleGroup";

    @IdRes
    private int checkedId;
    private final CheckedStateTracker checkedStateTracker;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private final LinkedHashSet<OnButtonCheckedListener> onButtonCheckedListeners;
    private final List<CornerData> originalCornerData;
    private final PressedStateTracker pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    public class CheckedStateTracker implements MaterialButton.OnCheckedChangeListener {
        final /* synthetic */ MaterialButtonToggleGroup this$0;

        private CheckedStateTracker(MaterialButtonToggleGroup r1) {
            this.this$0 = r1;
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull MaterialButton r3, boolean r4) {
            if (MaterialButtonToggleGroup.access$300(this.this$0) == false) goto L6;
            return;
        L6:
            if (MaterialButtonToggleGroup.access$400(this.this$0) == false) goto L13;
            MaterialButtonToggleGroup r0 = this.this$0;
            if (r4 == false) goto L10;
            int r1 = r3.getId();
        L11:
            MaterialButtonToggleGroup.access$502(r0, r1);
            goto L13
        L10:
            r1 = -1;
        L13:
            if (MaterialButtonToggleGroup.access$600(this.this$0, r3.getId(), r4) == false) goto L15;
            MaterialButtonToggleGroup.access$700(this.this$0, r3.getId(), r3.isChecked());
        L15:
            this.this$0.invalidate();
        }

        public /* synthetic */ CheckedStateTracker(MaterialButtonToggleGroup r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static class CornerData {
        private static final CornerSize noCorner = null;
        CornerSize bottomLeft;
        CornerSize bottomRight;
        CornerSize topLeft;
        CornerSize topRight;

        static {
            noCorner = new AbsoluteCornerSize(0.0f);
        }

        public CornerData(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
            this.topLeft = r1;
            this.topRight = r3;
            this.bottomRight = r4;
            this.bottomLeft = r2;
        }

        public static CornerData bottom(CornerData r3) {
            CornerSize r1 = noCorner;
            return new CornerData(r1, r3.bottomLeft, r1, r3.bottomRight);
        }

        public static CornerData end(CornerData r0, View r1) {
            if (ViewUtils.isLayoutRtl(r1) == false) goto L6;
            return left(r0);
        L6:
            return right(r0);
        }

        public static CornerData left(CornerData r3) {
            CornerSize r1 = r3.topLeft;
            CornerSize r4 = r3.bottomLeft;
            CornerSize r2 = noCorner;
            return new CornerData(r1, r4, r2, r2);
        }

        public static CornerData right(CornerData r3) {
            CornerSize r1 = noCorner;
            return new CornerData(r1, r1, r3.topRight, r3.bottomRight);
        }

        public static CornerData start(CornerData r0, View r1) {
            if (ViewUtils.isLayoutRtl(r1) == false) goto L6;
            return right(r0);
        L6:
            return left(r0);
        }

        public static CornerData top(CornerData r3) {
            CornerSize r1 = r3.topLeft;
            CornerSize r2 = noCorner;
            return new CornerData(r1, r2, r3.topRight, r2);
        }
    }

    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup r1, @IdRes int r2, boolean r3);
    }

    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        final /* synthetic */ MaterialButtonToggleGroup this$0;

        private PressedStateTracker(MaterialButtonToggleGroup r1) {
            this.this$0 = r1;
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(@NonNull MaterialButton r1, boolean r2) {
            this.this$0.invalidate();
        }

        public /* synthetic */ PressedStateTracker(MaterialButtonToggleGroup r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    }

    public MaterialButtonToggleGroup(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ int access$200(MaterialButtonToggleGroup r0, View r1) {
        return r0.getIndexWithinVisibleButtons(r1);
    }

    public static /* synthetic */ boolean access$300(MaterialButtonToggleGroup r0) {
        return r0.skipCheckedStateTracker;
    }

    public static /* synthetic */ boolean access$400(MaterialButtonToggleGroup r0) {
        return r0.singleSelection;
    }

    public static /* synthetic */ int access$502(MaterialButtonToggleGroup r0, int r1) {
        r0.checkedId = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$600(MaterialButtonToggleGroup r0, int r1, boolean r2) {
        return r0.updateCheckedStates(r1, r2);
    }

    public static /* synthetic */ void access$700(MaterialButtonToggleGroup r0, int r1, boolean r2) {
        r0.dispatchOnButtonChecked(r1, r2);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int r0 = getFirstVisibleChildIndex();
        if (r0 != (-1)) goto L5;
        return;
    L5:
        int r1 = r0 + 1;
    L7:
        if (r1 >= getChildCount()) goto L13;
        MaterialButton r2 = getChildButton(r1);
        int r3 = Math.min(r2.getStrokeWidth(), getChildButton(r1 - 1).getStrokeWidth());
        LinearLayout.LayoutParams r4 = buildLayoutParams(r2);
        if (getOrientation() != 0) goto L11;
        MarginLayoutParamsCompat.setMarginEnd(r4, 0);
        MarginLayoutParamsCompat.setMarginStart(r4, -r3);
    L12:
        r2.setLayoutParams(r4);
        r1 = r1 + 1;
        goto L7
    L11:
        r4.bottomMargin = 0;
        r4.topMargin = -r3;
        goto L12
    L13:
        resetChildMargins(r0);
    }

    @NonNull
    private LinearLayout.LayoutParams buildLayoutParams(@NonNull View r2) {
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        if ((r1 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return (LinearLayout.LayoutParams) r1;
    L7:
        return new LinearLayout.LayoutParams(r1.width, r1.height);
    }

    private void checkForced(int r2) {
        setCheckedStateForView(r2, true);
        updateCheckedStates(r2, true);
        setCheckedId(r2);
    }

    private void dispatchOnButtonChecked(@IdRes int r3, boolean r4) {
        Iterator<OnButtonCheckedListener> r0 = this.onButtonCheckedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onButtonChecked(this, r3, r4);
        goto L4
    }

    private MaterialButton getChildButton(int r1) {
        return (MaterialButton) getChildAt(r1);
    }

    private int getFirstVisibleChildIndex() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (isChildVisible(r1) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private int getIndexWithinVisibleButtons(@Nullable View r5) {
        if ((r5 instanceof MaterialButton) == true) goto L5;
        return -1;
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r0 >= getChildCount()) goto L17;
        if (getChildAt(r0) == r5) goto L10;
        if ((getChildAt(r0) instanceof MaterialButton) == false) goto L16;
        if (isChildVisible(r0) == false) goto L16;
        r2 = r2 + 1;
    L16:
        r0 = r0 + 1;
        goto L7
    L10:
        return r2;
    L17:
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (isChildVisible(r0) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    @Nullable
    private CornerData getNewCornerData(int r3, int r4, int r5) {
        CornerData r0 = this.originalCornerData.get(r3);
        if (r4 != r5) goto L6;
        return r0;
    L6:
        if (getOrientation() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r3 != r4) goto L14;
        if (r1 == false) goto L13;
        return CornerData.start(r0, this);
    L13:
        return CornerData.top(r0);
    L14:
        if (r3 != r5) goto L19;
        if (r1 == false) goto L18;
        return CornerData.end(r0, this);
    L18:
        return CornerData.bottom(r0);
    L19:
        return null;
    L8:
        r1 = false;
        goto L9
    }

    private int getVisibleButtonCount() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= getChildCount()) goto L11;
        if ((getChildAt(r0) instanceof MaterialButton) == false) goto L10;
        if (isChildVisible(r0) == false) goto L10;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    private boolean isChildVisible(int r1) {
        if (getChildAt(r1).getVisibility() == 8) goto L5;
        return true;
    L5:
        return false;
    }

    private void resetChildMargins(int r3) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (r3 == (-1)) goto L14;
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) getChildButton(r3).getLayoutParams();
        if (getOrientation() != 1) goto L11;
        r4.topMargin = 0;
        r4.bottomMargin = 0;
        return;
    L11:
        MarginLayoutParamsCompat.setMarginEnd(r4, 0);
        MarginLayoutParamsCompat.setMarginStart(r4, 0);
        r4.leftMargin = 0;
        r4.rightMargin = 0;
        return;
    }

    private void setCheckedId(int r2) {
        this.checkedId = r2;
        dispatchOnButtonChecked(r2, true);
    }

    private void setCheckedStateForView(@IdRes int r2, boolean r3) {
        View r4 = findViewById(r2);
        if ((r4 instanceof MaterialButton) == false) goto L6;
        this.skipCheckedStateTracker = true;
        ((MaterialButton) r4).setChecked(r3);
        this.skipCheckedStateTracker = false;
        return;
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton r2) {
        if (r2.getId() != (-1)) goto L6;
        r2.setId(ViewCompat.generateViewId());
        return;
    }

    private void setupButtonChild(@NonNull MaterialButton r3) {
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.setCheckable(true);
        r3.addOnCheckedChangeListener(this.checkedStateTracker);
        r3.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        r3.setShouldDrawSurfaceColorStroke(true);
    }

    private static void updateBuilderWithCornerData(ShapeAppearanceModel.Builder r1, @Nullable CornerData r2) {
        if (r2 != null) goto L5;
        r1.setAllCornerSizes(0.0f);
        return;
    L5:
        r1.setTopLeftCornerSize(r2.topLeft).setBottomLeftCornerSize(r2.bottomLeft).setTopRightCornerSize(r2.topRight).setBottomRightCornerSize(r2.bottomRight);
    }

    private boolean updateCheckedStates(int r5, boolean r6) {
        List<Integer> r0 = getCheckedButtonIds();
        if (this.selectionRequired == true) goto L5;
    L8:
        if (r6 == true) goto L10;
    L15:
        return true;
    L10:
        if (this.singleSelection == false) goto L15;
        r0.remove(Integer.valueOf(r5));
        Iterator<Integer> r7 = r0.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        int r8 = r7.next().intValue();
        setCheckedStateForView(r8, false);
        dispatchOnButtonChecked(r8, false);
        goto L13
    L5:
        if (r0.isEmpty() == false) goto L8;
        setCheckedStateForView(r5, true);
        this.checkedId = r5;
        return false;
    }

    private void updateChildOrder() {
        TreeMap r0 = new TreeMap(this.childOrderComparator);
        int r1 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.put(getChildButton(r3), Integer.valueOf(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        this.childOrder = (Integer[]) r0.values().toArray(new Integer[0]);
    }

    public void addOnButtonCheckedListener(@NonNull OnButtonCheckedListener r1) {
        this.onButtonCheckedListeners.add(r1);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if ((r5 instanceof MaterialButton) == true) goto L6;
        Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
        return;
    L6:
        super.addView(r5, r6, r7);
        MaterialButton r8 = (MaterialButton) r5;
        setGeneratedIdIfNeeded(r8);
        setupButtonChild(r8);
        if (r8.isChecked() == false) goto L9;
        updateCheckedStates(r8.getId(), true);
        setCheckedId(r8.getId());
    L9:
        ShapeAppearanceModel r9 = r8.getShapeAppearanceModel();
        this.originalCornerData.add(new CornerData(r9.getTopLeftCornerSize(), r9.getBottomLeftCornerSize(), r9.getTopRightCornerSize(), r9.getBottomRightCornerSize()));
        ViewCompat.setAccessibilityDelegate(r8, new AnonymousClass2(this));
    }

    public void check(@IdRes int r2) {
        if (r2 != this.checkedId) goto L5;
        return;
    L5:
        checkForced(r2);
    }

    public void clearChecked() {
        this.skipCheckedStateTracker = true;
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L6;
        MaterialButton r2 = getChildButton(r1);
        r2.setChecked(false);
        dispatchOnButtonChecked(r2.getId(), false);
        r1 = r1 + 1;
        goto L4
    L6:
        this.skipCheckedStateTracker = false;
        setCheckedId(-1);
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas r1) {
        updateChildOrder();
        super.dispatchDraw(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.singleSelection == true) goto L7;
        return -1;
    L7:
        return this.checkedId;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L9;
        MaterialButton r2 = getChildButton(r1);
        if (r2.isChecked() == false) goto L8;
        r0.add(Integer.valueOf(r2.getId()));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r1, int r2) {
        Integer[] r0 = this.childOrder;
        if (r0 != null) goto L5;
    L9:
        Log.w(LOG_TAG, "Child order wasn't updated");
        return r2;
    L5:
        if (r2 >= r0.length) goto L9;
        return r0[r2].intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.checkedId;
        if (r0 == (-1)) goto L6;
        checkForced(r0);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.wrap(r4);
        int r0 = getVisibleButtonCount();
        if (isSingleSelection() == false) goto L5;
        int r3 = 1;
    L6:
        r5.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, r0, false, r3));
        return;
    L5:
        r3 = 2;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(r1, r2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        if ((r3 instanceof MaterialButton) == false) goto L5;
        MaterialButton r0 = (MaterialButton) r3;
        r0.removeOnCheckedChangeListener(this.checkedStateTracker);
        r0.setOnPressedChangeListenerInternal(null);
    L5:
        int r4 = indexOfChild(r3);
        if (r4 < 0) goto L8;
        this.originalCornerData.remove(r4);
    L8:
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(@NonNull OnButtonCheckedListener r1) {
        this.onButtonCheckedListeners.remove(r1);
    }

    public void setSelectionRequired(boolean r1) {
        this.selectionRequired = r1;
    }

    public void setSingleSelection(boolean r2) {
        if (this.singleSelection == r2) goto L6;
        this.singleSelection = r2;
        clearChecked();
        return;
    }

    public void uncheck(@IdRes int r3) {
        setCheckedStateForView(r3, false);
        updateCheckedStates(r3, false);
        this.checkedId = -1;
        dispatchOnButtonChecked(r3, false);
    }

    @VisibleForTesting
    public void updateChildShapes() {
        int r0 = getChildCount();
        int r1 = getFirstVisibleChildIndex();
        int r2 = getLastVisibleChildIndex();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L9;
        MaterialButton r4 = getChildButton(r3);
        if (r4.getVisibility() == 8) goto L8;
        ShapeAppearanceModel.Builder r5 = r4.getShapeAppearanceModel().toBuilder();
        updateBuilderWithCornerData(r5, getNewCornerData(r3, r1, r2));
        r4.setShapeAppearanceModel(r5.build());
    L8:
        r3 = r3 + 1;
        goto L3
    }

    public MaterialButtonToggleGroup(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(@NonNull Context r7, @Nullable AttributeSet r8, int r9) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r7, r8, r9, r4), r8, r9);
        this.originalCornerData = new ArrayList();
        AnonymousClass1 r0 = null;
        this.checkedStateTracker = new CheckedStateTracker(this, r0);
        this.pressedStateTracker = new PressedStateTracker(this, r0);
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new AnonymousClass1(this);
        this.skipCheckedStateTracker = false;
        TypedArray r10 = ThemeEnforcement.obtainStyledAttributes(getContext(), r8, R.styleable.MaterialButtonToggleGroup, r9, r4, new int[0]);
        setSingleSelection(r10.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.checkedId = r10.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = r10.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        r10.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(@BoolRes int r2) {
        setSingleSelection(getResources().getBoolean(r2));
    }
}
