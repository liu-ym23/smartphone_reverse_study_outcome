package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter implements MenuPresenter {
    private int id;
    private MenuBuilder menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState() {
        }

        SavedState(@NonNull Parcel r2) {
            this.selectedItemId = r2.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) r2.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            r1.writeInt(this.selectedItemId);
            r1.writeParcelable(this.badgeSavedStates, 0);
        }
    }

    public NavigationBarPresenter() {
        this.updateSuspended = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@Nullable MenuBuilder r1, @Nullable MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@Nullable MenuBuilder r1, @Nullable MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.id;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup r1) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r1, @NonNull MenuBuilder r2) {
        this.menu = r2;
        this.menuView.initialize(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@Nullable MenuBuilder r1, boolean r2) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@NonNull Parcelable r3) {
        if ((r3 instanceof SavedState) == false) goto L6;
        SavedState r4 = (SavedState) r3;
        this.menuView.tryRestoreSelectedItemId(r4.selectedItemId);
        SparseArray<BadgeDrawable> r5 = BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), r4.badgeSavedStates);
        this.menuView.setBadgeDrawables(r5);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState();
        r0.selectedItemId = this.menuView.getSelectedItemId();
        r0.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return r0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@Nullable SubMenuBuilder r1) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@Nullable MenuPresenter.Callback r1) {
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public void setMenuView(@NonNull NavigationBarMenuView r1) {
        this.menuView = r1;
    }

    public void setUpdateSuspended(boolean r1) {
        this.updateSuspended = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r2) {
        if (this.updateSuspended == false) goto L5;
        return;
    L5:
        NavigationBarMenuView r1 = this.menuView;
        if (r2 == false) goto L8;
        r1.buildMenuView();
        return;
    L8:
        r1.updateMenuView();
    }
}
