package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    public static final int NO_TEXT_APPEARANCE_SET = 0;
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    NavigationMenuAdapter adapter;
    private MenuPresenter.Callback callback;

    @Px
    int dividerInsetEnd;

    @Px
    int dividerInsetStart;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;
    private int id;
    boolean isBehindStatusBar;
    Drawable itemBackground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    private int itemMaxLines;

    @Px
    int itemVerticalPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View.OnClickListener onClickListener;
    private int overScrollMode;
    int paddingSeparator;
    private int paddingTopDefault;

    @Nullable
    ColorStateList subheaderColor;

    @Px
    int subheaderInsetEnd;

    @Px
    int subheaderInsetStart;
    int subheaderTextAppearance;
    int textAppearance;
    ColorStateList textColor;

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View r1) {
            super(r1);
        }
    }

    private class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private MenuItemImpl checkedItem;
        private final ArrayList<NavigationMenuItem> items;
        final /* synthetic */ NavigationMenuPresenter this$0;
        private boolean updateSuspended;

        NavigationMenuAdapter(NavigationMenuPresenter r1) {
            this.this$0 = r1;
            this.items = new ArrayList();
            prepareMenuItems();
        }

        private void appendTransparentIconIfMissing(int r3, int r4) {
        L2:
            if (r3 >= r4) goto L4;
            ((NavigationMenuTextItem) this.items.get(r3)).needsEmptyIcon = true;
            r3 = r3 + 1;
            goto L2
        }

        private void prepareMenuItems() {
            if (this.updateSuspended == false) goto L5;
            return;
        L5:
            boolean r1 = true;
            this.updateSuspended = true;
            this.items.clear();
            this.items.add(new NavigationMenuHeaderItem());
            int r2 = -1;
            int r3 = this.this$0.menu.getVisibleItems().size();
            int r5 = 0;
            boolean r6 = false;
            int r7 = 0;
        L6:
            if (r5 >= r3) goto L51;
            MenuItemImpl r8 = this.this$0.menu.getVisibleItems().get(r5);
            if (r8.isChecked() == false) goto L11;
            setCheckedItem(r8);
        L11:
            if (r8.isCheckable() == false) goto L14;
            r8.setExclusiveCheckable(false);
        L14:
            if (r8.hasSubMenu() == false) goto L37;
            SubMenu r9 = r8.getSubMenu();
            if (r9.hasVisibleItems() == false) goto L50;
            if (r5 == 0) goto L19;
            this.items.add(new NavigationMenuSeparatorItem(this.this$0.paddingSeparator, 0));
        L19:
            this.items.add(new NavigationMenuTextItem(r8));
            int r10 = this.items.size();
            int r11 = r9.size();
            int r12 = 0;
            boolean r13 = false;
        L20:
            if (r12 >= r11) goto L35;
            MenuItemImpl r14 = (MenuItemImpl) r9.getItem(r12);
            if (r14.isVisible() == false) goto L34;
            if (r13 == true) goto L28;
            if (r14.getIcon() == null) goto L28;
            r13 = r1;
        L28:
            if (r14.isCheckable() == false) goto L31;
            r14.setExclusiveCheckable(false);
        L31:
            if (r8.isChecked() == false) goto L33;
            setCheckedItem(r8);
        L33:
            this.items.add(new NavigationMenuTextItem(r14));
        L34:
            r12 = r12 + 1;
            r1 = true;
            goto L20
        L35:
            if (r13 == false) goto L50;
            appendTransparentIconIfMissing(r10, this.items.size());
        L50:
            r5 = r5 + 1;
            r1 = true;
            goto L6
        L37:
            int r4 = r8.getGroupId();
            if (r4 == r2) goto L45;
            r7 = this.items.size();
            if (r8.getIcon() == null) goto L42;
            r6 = true;
        L43:
            if (r5 == 0) goto L49;
            r7 = r7 + 1;
            ArrayList<NavigationMenuItem> r15 = this.items;
            int r16 = this.this$0.paddingSeparator;
            r15.add(new NavigationMenuSeparatorItem(r16, r16));
        L49:
            NavigationMenuTextItem r17 = new NavigationMenuTextItem(r8);
            r17.needsEmptyIcon = r6;
            this.items.add(r17);
            r2 = r4;
            goto L50
        L42:
            r6 = false;
            goto L43
        L45:
            if (r6 == true) goto L49;
            if (r8.getIcon() == null) goto L49;
            appendTransparentIconIfMissing(r7, this.items.size());
            r6 = true;
            goto L49
        L51:
            this.updateSuspended = false;
        }

        @NonNull
        public Bundle createInstanceState() {
            Bundle r0 = new Bundle();
            MenuItemImpl r1 = this.checkedItem;
            if (r1 == null) goto L5;
            r0.putInt(STATE_CHECKED_ITEM, r1.getItemId());
        L5:
            SparseArray<? extends Parcelable> r2 = new SparseArray();
            int r3 = 0;
            int r4 = this.items.size();
        L6:
            if (r3 >= r4) goto L16;
            NavigationMenuItem r5 = this.items.get(r3);
            if ((r5 instanceof NavigationMenuTextItem) == false) goto L15;
            MenuItemImpl r6 = ((NavigationMenuTextItem) r5).getMenuItem();
            if (r6 == null) goto L12;
            View r7 = r6.getActionView();
        L13:
            if (r7 == null) goto L15;
            ParcelableSparseArray r8 = new ParcelableSparseArray();
            r7.saveHierarchyState(r8);
            r2.put(r6.getItemId(), r8);
            goto L15
        L12:
            r7 = null;
        L15:
            r3 = r3 + 1;
            goto L6
        L16:
            r0.putSparseParcelableArray(STATE_ACTION_VIEWS, r2);
            return r0;
        }

        public MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r1) {
            NavigationMenuItem r0 = this.items.get(r1);
            if ((r0 instanceof NavigationMenuSeparatorItem) == false) goto L7;
            return 2;
        L7:
            if ((r0 instanceof NavigationMenuHeaderItem) == false) goto L11;
            return 3;
        L11:
            if ((r0 instanceof NavigationMenuTextItem) == false) goto L19;
            if (((NavigationMenuTextItem) r0).getMenuItem().hasSubMenu() == false) goto L16;
            return 1;
        L16:
            return 0;
        L19:
            throw new RuntimeException("Unknown item type.");
        }

        int getRowCount() {
            int r1 = 0;
            if (this.this$0.headerLayout.getChildCount() != 0) goto L5;
            int r0 = 0;
        L7:
            if (r1 >= this.this$0.adapter.getItemCount()) goto L12;
            if (this.this$0.adapter.getItemViewType(r1) != 0) goto L11;
            r0 = r0 + 1;
        L11:
            r1 = r1 + 1;
            goto L7
        L12:
            return r0;
        L5:
            r0 = 1;
            goto L7
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((ViewHolder) r1, r2);
        }

        public void onBindViewHolder(@NonNull ViewHolder r4, int r5) {
            int r0 = getItemViewType(r5);
            if (r0 != 0) goto L5;
            NavigationMenuItemView r6 = (NavigationMenuItemView) r4.itemView;
            r6.setIconTintList(this.this$0.iconTintList);
            int r1 = this.this$0.textAppearance;
            if (r1 == 0) goto L19;
            r6.setTextAppearance(r1);
        L19:
            ColorStateList r2 = this.this$0.textColor;
            if (r2 == null) goto L22;
            r6.setTextColor(r2);
        L22:
            Drawable r3 = this.this$0.itemBackground;
            if (r3 == null) goto L25;
            Drawable r7 = r3.getConstantState().newDrawable();
        L26:
            ViewCompat.setBackground(r6, r7);
            NavigationMenuTextItem r8 = (NavigationMenuTextItem) this.items.get(r5);
            r6.setNeedsEmptyIcon(r8.needsEmptyIcon);
            NavigationMenuPresenter r9 = this.this$0;
            int r10 = r9.itemHorizontalPadding;
            int r11 = r9.itemVerticalPadding;
            r6.setPadding(r10, r11, r10, r11);
            r6.setIconPadding(this.this$0.itemIconPadding);
            NavigationMenuPresenter r12 = this.this$0;
            if (r12.hasCustomItemIconSize == false) goto L29;
            r6.setIconSize(r12.itemIconSize);
        L29:
            r6.setMaxLines(NavigationMenuPresenter.access$000(this.this$0));
            r6.initialize(r8.getMenuItem(), 0);
            return;
        L25:
            r7 = null;
            goto L26
        L5:
            if (r0 != 1) goto L7;
            TextView r13 = (TextView) r4.itemView;
            r13.setText(((NavigationMenuTextItem) this.items.get(r5)).getMenuItem().getTitle());
            int r14 = this.this$0.subheaderTextAppearance;
            if (r14 == 0) goto L13;
            TextViewCompat.setTextAppearance(r13, r14);
        L13:
            r13.setPadding(this.this$0.subheaderInsetStart, r13.getPaddingTop(), this.this$0.subheaderInsetEnd, r13.getPaddingBottom());
            ColorStateList r15 = this.this$0.subheaderColor;
            if (r15 == null) goto L32;
            r13.setTextColor(r15);
            return;
        L32:
            return;
        L7:
            if (r0 != 2) goto L34;
            NavigationMenuSeparatorItem r16 = (NavigationMenuSeparatorItem) this.items.get(r5);
            r4.itemView.setPadding(this.this$0.dividerInsetStart, r16.getPaddingTop(), this.this$0.dividerInsetEnd, r16.getPaddingBottom());
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return onCreateViewHolder(r1, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            if (r3 != 0) goto L4;
            NavigationMenuPresenter r1 = this.this$0;
            return new NormalViewHolder(r1.layoutInflater, r2, r1.onClickListener);
        L4:
            if (r3 == 1) goto L16;
            if (r3 == 2) goto L14;
            if (r3 == 3) goto L12;
            return null;
        L12:
            return new HeaderViewHolder(this.this$0.headerLayout);
        L14:
            return new SeparatorViewHolder(this.this$0.layoutInflater, r2);
        L16:
            return new SubheaderViewHolder(this.this$0.layoutInflater, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r1) {
            onViewRecycled((ViewHolder) r1);
        }

        public void onViewRecycled(ViewHolder r1) {
            if ((r1 instanceof NormalViewHolder) == false) goto L6;
            ((NavigationMenuItemView) r1.itemView).recycle();
            return;
        }

        public void restoreInstanceState(@NonNull Bundle r7) {
            int r1 = 0;
            int r0 = r7.getInt(STATE_CHECKED_ITEM, 0);
            if (r0 == 0) goto L15;
            this.updateSuspended = true;
            int r2 = this.items.size();
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L14;
            NavigationMenuItem r4 = this.items.get(r3);
            if ((r4 instanceof NavigationMenuTextItem) == false) goto L13;
            MenuItemImpl r5 = ((NavigationMenuTextItem) r4).getMenuItem();
            if (r5 == null) goto L13;
            if (r5.getItemId() != r0) goto L13;
            setCheckedItem(r5);
        L13:
            r3 = r3 + 1;
        L14:
            this.updateSuspended = false;
            prepareMenuItems();
        L15:
            SparseArray r8 = r7.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (r8 == null) goto L33;
            int r6 = this.items.size();
        L18:
            if (r1 >= r6) goto L45;
            NavigationMenuItem r9 = this.items.get(r1);
            if ((r9 instanceof NavigationMenuTextItem) == false) goto L32;
            MenuItemImpl r10 = ((NavigationMenuTextItem) r9).getMenuItem();
            if (r10 == null) goto L32;
            View r11 = r10.getActionView();
            if (r11 == null) goto L32;
            ParcelableSparseArray r12 = (ParcelableSparseArray) r8.get(r10.getItemId());
            if (r12 == null) goto L32;
            r11.restoreHierarchyState(r12);
        L32:
            r1 = r1 + 1;
            goto L18
        L45:
            return;
        }

        public void setCheckedItem(@NonNull MenuItemImpl r3) {
            if (this.checkedItem != r3) goto L5;
            return;
        L5:
            if (r3.isCheckable() == false) goto L13;
            MenuItemImpl r0 = this.checkedItem;
            if (r0 == null) goto L10;
            r0.setChecked(false);
        L10:
            this.checkedItem = r3;
            r3.setChecked(true);
            return;
        }

        public void setUpdateSuspended(boolean r1) {
            this.updateSuspended = r1;
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }
    }

    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    private interface NavigationMenuItem {
    }

    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int r1, int r2) {
            this.paddingTop = r1;
            this.paddingBottom = r2;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }
    }

    private static class NavigationMenuTextItem implements NavigationMenuItem {
        private final MenuItemImpl menuItem;
        boolean needsEmptyIcon;

        NavigationMenuTextItem(MenuItemImpl r1) {
            this.menuItem = r1;
        }

        public MenuItemImpl getMenuItem() {
            return this.menuItem;
        }
    }

    private class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        final /* synthetic */ NavigationMenuPresenter this$0;

        NavigationMenuViewAccessibilityDelegate(@NonNull NavigationMenuPresenter r1, RecyclerView r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r1, @NonNull AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            r2.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.this$0.adapter.getRowCount(), 0, false));
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater r3, ViewGroup r4, View.OnClickListener r5) {
            super(r3.inflate(R.layout.design_navigation_item, r4, false));
            this.itemView.setOnClickListener(r5);
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater r3, ViewGroup r4) {
            super(r3.inflate(R.layout.design_navigation_item_separator, r4, false));
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater r3, ViewGroup r4) {
            super(r3.inflate(R.layout.design_navigation_item_subheader, r4, false));
        }
    }

    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r1) {
            super(r1);
        }
    }

    public NavigationMenuPresenter() {
        this.subheaderTextAppearance = 0;
        this.textAppearance = 0;
        this.isBehindStatusBar = true;
        this.overScrollMode = -1;
        this.onClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ int access$000(NavigationMenuPresenter r0) {
        return r0.itemMaxLines;
    }

    private void updateTopPadding() {
        if (this.headerLayout.getChildCount() == 0) goto L5;
    L7:
        int r0 = 0;
    L8:
        NavigationMenuView r3 = this.menuView;
        r3.setPadding(0, r0, 0, r3.getPaddingBottom());
        return;
    L5:
        if (this.isBehindStatusBar == false) goto L7;
        r0 = this.paddingTopDefault;
        goto L8
    }

    public void addHeaderView(@NonNull View r2) {
        this.headerLayout.addView(r2);
        NavigationMenuView r1 = this.menuView;
        r1.setPadding(0, 0, 0, r1.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat r5) {
        int r0 = r5.getSystemWindowInsetTop();
        if (this.paddingTopDefault == r0) goto L5;
        this.paddingTopDefault = r0;
        updateTopPadding();
    L5:
        NavigationMenuView r1 = this.menuView;
        r1.setPadding(0, r1.getPaddingTop(), 0, r5.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, r5);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int r1) {
        return this.headerLayout.getChildAt(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.id;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.itemVerticalPadding;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r4) {
        if (this.menuView != null) goto L12;
        NavigationMenuView r5 = (NavigationMenuView) this.layoutInflater.inflate(R.layout.design_navigation_menu, r4, false);
        this.menuView = r5;
        r5.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this, this.menuView));
        if (this.adapter != null) goto L7;
        this.adapter = new NavigationMenuAdapter(this);
    L7:
        int r6 = this.overScrollMode;
        if (r6 == (-1)) goto L10;
        this.menuView.setOverScrollMode(r6);
    L10:
        this.headerLayout = (LinearLayout) this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false);
        this.menuView.setAdapter(this.adapter);
    L12:
        return this.menuView;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.subheaderInsetEnd;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.subheaderInsetStart;
    }

    public View inflateHeaderView(@LayoutRes int r4) {
        View r5 = this.layoutInflater.inflate(r4, this.headerLayout, false);
        addHeaderView(r5);
        return r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r2, @NonNull MenuBuilder r3) {
        this.layoutInflater = LayoutInflater.from(r2);
        this.menu = r3;
        this.paddingSeparator = r2.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        MenuPresenter.Callback r0 = this.callback;
        if (r0 == null) goto L6;
        r0.onCloseMenu(r1, r2);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof Bundle) == false) goto L14;
        Bundle r4 = (Bundle) r3;
        SparseArray<Parcelable> r0 = r4.getSparseParcelableArray("android:menu:list");
        if (r0 == null) goto L7;
        this.menuView.restoreHierarchyState(r0);
    L7:
        Bundle r1 = r4.getBundle(STATE_ADAPTER);
        if (r1 == null) goto L10;
        this.adapter.restoreInstanceState(r1);
    L10:
        SparseArray r5 = r4.getSparseParcelableArray(STATE_HEADER);
        if (r5 == null) goto L15;
        this.headerLayout.restoreHierarchyState(r5);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        if (this.menuView == null) goto L5;
        SparseArray<Parcelable> r1 = new SparseArray();
        this.menuView.saveHierarchyState(r1);
        r0.putSparseParcelableArray("android:menu:list", r1);
    L5:
        NavigationMenuAdapter r2 = this.adapter;
        if (r2 == null) goto L9;
        r0.putBundle(STATE_ADAPTER, r2.createInstanceState());
    L9:
        if (this.headerLayout == null) goto L11;
        SparseArray<? extends Parcelable> r3 = new SparseArray();
        this.headerLayout.saveHierarchyState(r3);
        r0.putSparseParcelableArray(STATE_HEADER, r3);
    L11:
        return r0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r1) {
        return false;
    }

    public void removeHeaderView(@NonNull View r3) {
        this.headerLayout.removeView(r3);
        if (this.headerLayout.getChildCount() != 0) goto L6;
        NavigationMenuView r4 = this.menuView;
        r4.setPadding(0, this.paddingTopDefault, 0, r4.getPaddingBottom());
        return;
    }

    public void setBehindStatusBar(boolean r2) {
        if (this.isBehindStatusBar == r2) goto L6;
        this.isBehindStatusBar = r2;
        updateTopPadding();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r1) {
        this.callback = r1;
    }

    public void setCheckedItem(@NonNull MenuItemImpl r1) {
        this.adapter.setCheckedItem(r1);
    }

    public void setDividerInsetEnd(@Px int r1) {
        this.dividerInsetEnd = r1;
        updateMenuView(false);
    }

    public void setDividerInsetStart(@Px int r1) {
        this.dividerInsetStart = r1;
        updateMenuView(false);
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public void setItemBackground(@Nullable Drawable r1) {
        this.itemBackground = r1;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int r1) {
        this.itemHorizontalPadding = r1;
        updateMenuView(false);
    }

    public void setItemIconPadding(int r1) {
        this.itemIconPadding = r1;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int r2) {
        if (this.itemIconSize == r2) goto L6;
        this.itemIconSize = r2;
        this.hasCustomItemIconSize = true;
        updateMenuView(false);
        return;
    }

    public void setItemIconTintList(@Nullable ColorStateList r1) {
        this.iconTintList = r1;
        updateMenuView(false);
    }

    public void setItemMaxLines(int r1) {
        this.itemMaxLines = r1;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int r1) {
        this.textAppearance = r1;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList r1) {
        this.textColor = r1;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(@Px int r1) {
        this.itemVerticalPadding = r1;
        updateMenuView(false);
    }

    public void setOverScrollMode(int r1) {
        this.overScrollMode = r1;
        NavigationMenuView r0 = this.menuView;
        if (r0 == null) goto L6;
        r0.setOverScrollMode(r1);
        return;
    }

    public void setSubheaderColor(@Nullable ColorStateList r1) {
        this.subheaderColor = r1;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(@Px int r1) {
        this.subheaderInsetEnd = r1;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(@Px int r1) {
        this.subheaderInsetStart = r1;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(@StyleRes int r1) {
        this.subheaderTextAppearance = r1;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean r1) {
        NavigationMenuAdapter r0 = this.adapter;
        if (r0 == null) goto L6;
        r0.setUpdateSuspended(r1);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r1) {
        NavigationMenuAdapter r0 = this.adapter;
        if (r0 == null) goto L6;
        r0.update();
        return;
    }
}
