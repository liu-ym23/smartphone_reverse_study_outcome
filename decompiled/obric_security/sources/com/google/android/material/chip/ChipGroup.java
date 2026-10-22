package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int DEF_STYLE_RES = 0;
    private int checkedId;
    private final CheckedStateTracker checkedStateTracker;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private OnCheckedChangeListener onCheckedChangeListener;
    private PassThroughHierarchyChangeListener passThroughListener;
    private boolean protectFromCheckedChange;
    private boolean selectionRequired;
    private boolean singleSelection;

    /* JADX INFO: renamed from: com.google.android.material.chip.ChipGroup$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ ChipGroup this$0;

        private CheckedStateTracker(ChipGroup r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CheckedStateTracker(ChipGroup r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton r4, boolean r5) {
            if (ChipGroup.access$300(this.this$0) == false) goto L6;
            return;
        L6:
            if (this.this$0.getCheckedChipIds().isEmpty() == true) goto L8;
        L11:
            int r6 = r4.getId();
            if (r5 == false) goto L22;
            if (ChipGroup.access$700(this.this$0) != (-1)) goto L16;
        L20:
            ChipGroup.access$900(this.this$0, r6);
            return;
        L16:
            if (ChipGroup.access$700(this.this$0) == r6) goto L20;
            if (ChipGroup.access$800(this.this$0) == false) goto L20;
            ChipGroup r7 = this.this$0;
            ChipGroup.access$500(r7, ChipGroup.access$700(r7), false);
            goto L20
        L22:
            if (ChipGroup.access$700(this.this$0) != r6) goto L26;
            ChipGroup.access$900(this.this$0, -1);
            return;
        L26:
            return;
        L8:
            if (ChipGroup.access$400(this.this$0) == false) goto L11;
            ChipGroup.access$500(this.this$0, r4.getId(), true);
            ChipGroup.access$600(this.this$0, r4.getId(), false);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup r1, int r2);
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
        final /* synthetic */ ChipGroup this$0;

        private PassThroughHierarchyChangeListener(ChipGroup r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PassThroughHierarchyChangeListener(ChipGroup r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ ViewGroup.OnHierarchyChangeListener access$202(PassThroughHierarchyChangeListener r0, ViewGroup.OnHierarchyChangeListener r1) {
            r0.onHierarchyChangeListener = r1;
            return r1;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r4, View r5) {
            if (r4 == this.this$0) goto L5;
        L13:
            ViewGroup.OnHierarchyChangeListener r3 = this.onHierarchyChangeListener;
            if (r3 == null) goto L17;
            r3.onChildViewAdded(r4, r5);
            return;
        L17:
            return;
        L5:
            if ((r5 instanceof Chip) == false) goto L13;
            if (r5.getId() != (-1)) goto L9;
            r5.setId(ViewCompat.generateViewId());
        L9:
            Chip r0 = (Chip) r5;
            if (r0.isChecked() == false) goto L12;
            ((ChipGroup) r4).check(r0.getId());
        L12:
            r0.setOnCheckedChangeListenerInternal(ChipGroup.access$1000(this.this$0));
            goto L13
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r3, View r4) {
            if (r3 == this.this$0) goto L5;
        L7:
            ViewGroup.OnHierarchyChangeListener r2 = this.onHierarchyChangeListener;
            if (r2 == null) goto L11;
            r2.onChildViewRemoved(r3, r4);
            return;
        L11:
            return;
        L5:
            if ((r4 instanceof Chip) == false) goto L7;
            ((Chip) r4).setOnCheckedChangeListenerInternal(null);
            goto L7
        }
    }

    static /* synthetic */ CheckedStateTracker access$1000(ChipGroup r0) {
        return r0.checkedStateTracker;
    }

    static /* synthetic */ boolean access$300(ChipGroup r0) {
        return r0.protectFromCheckedChange;
    }

    static /* synthetic */ boolean access$400(ChipGroup r0) {
        return r0.selectionRequired;
    }

    static /* synthetic */ void access$500(ChipGroup r0, int r1, boolean r2) {
        r0.setCheckedStateForView(r1, r2);
    }

    static /* synthetic */ void access$600(ChipGroup r0, int r1, boolean r2) {
        r0.setCheckedId(r1, r2);
    }

    static /* synthetic */ int access$700(ChipGroup r0) {
        return r0.checkedId;
    }

    static /* synthetic */ boolean access$800(ChipGroup r0) {
        return r0.singleSelection;
    }

    static /* synthetic */ void access$900(ChipGroup r0, int r1) {
        r0.setCheckedId(r1);
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ChipGroup;
    }

    public ChipGroup(Context r2) {
        this(r2, null);
    }

    public ChipGroup(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.chipGroupStyle);
    }

    public ChipGroup(Context r8, AttributeSet r9, int r10) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r8, r9, r10, r4), r9, r10);
        AnonymousClass1 r0 = null;
        this.checkedStateTracker = new CheckedStateTracker(this, r0);
        this.passThroughListener = new PassThroughHierarchyChangeListener(this, r0);
        this.checkedId = -1;
        this.protectFromCheckedChange = false;
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(getContext(), r9, R.styleable.ChipGroup, r10, r4, new int[0]);
        int r12 = r11.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(r11.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, r12));
        setChipSpacingVertical(r11.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, r12));
        setSingleLine(r11.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(r11.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(r11.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        int r13 = r11.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        if (r13 == (-1)) goto L5;
        this.checkedId = r13;
    L5:
        r11.recycle();
        super.setOnHierarchyChangeListener(this.passThroughListener);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.wrap(r4);
        if (isSingleLine() == false) goto L5;
        int r0 = getChipCount();
    L6:
        int r1 = getRowCount();
        if (isSingleSelection() == false) goto L9;
        int r3 = 1;
    L10:
        r5.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r1, r0, false, r3));
        return;
    L9:
        r3 = 2;
        goto L10
    L5:
        r0 = -1;
        goto L6
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        if (super.checkLayoutParams(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r1) {
        PassThroughHierarchyChangeListener.access$202(this.passThroughListener, r1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.checkedId;
        if (r0 == (-1)) goto L6;
        setCheckedStateForView(r0, true);
        setCheckedId(this.checkedId);
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        if ((r4 instanceof Chip) == false) goto L12;
        Chip r0 = (Chip) r4;
        if (r0.isChecked() == false) goto L12;
        int r1 = this.checkedId;
        if (r1 != (-1)) goto L9;
    L11:
        setCheckedId(r0.getId());
        goto L12
    L9:
        if (this.singleSelection == false) goto L11;
        setCheckedStateForView(r1, false);
    L12:
        super.addView(r4, r5, r6);
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable r1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable r1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerHorizontal(int r1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r1) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void check(int r4) {
        int r0 = this.checkedId;
        if (r4 != r0) goto L6;
        return;
    L6:
        if (r0 != (-1)) goto L8;
    L10:
        if (r4 == (-1)) goto L12;
        setCheckedStateForView(r4, true);
    L12:
        setCheckedId(r4);
        return;
    L8:
        if (this.singleSelection == false) goto L10;
        setCheckedStateForView(r0, false);
        goto L10
    }

    public int getCheckedChipId() {
        if (this.singleSelection == true) goto L7;
        return -1;
    L7:
        return this.checkedId;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L13;
        View r2 = getChildAt(r1);
        if ((r2 instanceof Chip) == false) goto L12;
        if (((Chip) r2).isChecked() == false) goto L12;
        r0.add(Integer.valueOf(r2.getId()));
        if (this.singleSelection == false) goto L12;
        return r0;
    L12:
        r1 = r1 + 1;
        goto L4
    L13:
        return r0;
    }

    public void clearCheck() {
        this.protectFromCheckedChange = true;
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L9;
        View r2 = getChildAt(r1);
        if ((r2 instanceof Chip) == false) goto L8;
        ((Chip) r2).setChecked(false);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        this.protectFromCheckedChange = false;
        setCheckedId(-1);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener r1) {
        this.onCheckedChangeListener = r1;
    }

    private void setCheckedId(int r2) {
        setCheckedId(r2, true);
    }

    private void setCheckedId(int r3, boolean r4) {
        this.checkedId = r3;
        OnCheckedChangeListener r0 = this.onCheckedChangeListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.singleSelection == false) goto L10;
        if (r4 == false) goto L11;
        r0.onCheckedChanged(this, r3);
        return;
    L11:
        return;
    }

    private void setCheckedStateForView(int r2, boolean r3) {
        View r4 = findViewById(r2);
        if ((r4 instanceof Chip) == false) goto L6;
        this.protectFromCheckedChange = true;
        ((Chip) r4).setChecked(r3);
        this.protectFromCheckedChange = false;
        return;
    }

    private int getChipCount() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= getChildCount()) goto L9;
        if ((getChildAt(r0) instanceof Chip) == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    int getIndexOfChip(View r5) {
        if ((r5 instanceof Chip) == true) goto L5;
        return -1;
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r0 >= getChildCount()) goto L15;
        if ((getChildAt(r0) instanceof Chip) == false) goto L14;
        if (((Chip) getChildAt(r0)) == r5) goto L12;
        r2 = r2 + 1;
        goto L14
    L12:
        return r2;
    L14:
        r0 = r0 + 1;
        goto L7
    L15:
        return -1;
    }

    public void setChipSpacing(int r1) {
        setChipSpacingHorizontal(r1);
        setChipSpacingVertical(r1);
    }

    public void setChipSpacingResource(int r2) {
        setChipSpacing(getResources().getDimensionPixelOffset(r2));
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public void setChipSpacingHorizontal(int r2) {
        if (this.chipSpacingHorizontal == r2) goto L6;
        this.chipSpacingHorizontal = r2;
        setItemSpacing(r2);
        requestLayout();
        return;
    }

    public void setChipSpacingHorizontalResource(int r2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r2));
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public void setChipSpacingVertical(int r2) {
        if (this.chipSpacingVertical == r2) goto L6;
        this.chipSpacingVertical = r2;
        setLineSpacing(r2);
        requestLayout();
        return;
    }

    public void setChipSpacingVerticalResource(int r2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r2));
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean r1) {
        super.setSingleLine(r1);
    }

    public void setSingleLine(int r2) {
        setSingleLine(getResources().getBoolean(r2));
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void setSingleSelection(boolean r2) {
        if (this.singleSelection == r2) goto L6;
        this.singleSelection = r2;
        clearCheck();
        return;
    }

    public void setSingleSelection(int r2) {
        setSingleSelection(getResources().getBoolean(r2));
    }

    public void setSelectionRequired(boolean r1) {
        this.selectionRequired = r1;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }
}
