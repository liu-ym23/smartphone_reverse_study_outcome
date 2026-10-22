package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class BaseMenuPresenter implements MenuPresenter {
    private MenuPresenter.Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public BaseMenuPresenter(Context r1, int r2, int r3) {
        this.mSystemContext = r1;
        this.mSystemInflater = LayoutInflater.from(r1);
        this.mMenuLayoutRes = r2;
        this.mItemLayoutRes = r3;
    }

    protected void addItemView(View r2, int r3) {
        ViewGroup r0 = (ViewGroup) r2.getParent();
        if (r0 == null) goto L5;
        r0.removeView(r2);
    L5:
        ((ViewGroup) this.mMenuView).addView(r2, r3);
    }

    public abstract void bindItemView(MenuItemImpl r1, MenuView.ItemView r2);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup r3) {
        return (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, r3, false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    protected boolean filterLeftoverView(ViewGroup r1, int r2) {
        r1.removeViewAt(r2);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public MenuPresenter.Callback getCallback() {
        return this.mCallback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getItemView(MenuItemImpl r2, View r3, ViewGroup r4) {
        if ((r3 instanceof MenuView.ItemView) == false) goto L5;
        MenuView.ItemView r5 = (MenuView.ItemView) r3;
    L6:
        bindItemView(r2, r5);
        return (View) r5;
    L5:
        r5 = createItemView(r4);
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r4) {
        if (this.mMenuView != null) goto L6;
        MenuView r5 = (MenuView) this.mSystemInflater.inflate(this.mMenuLayoutRes, r4, false);
        this.mMenuView = r5;
        r5.initialize(this.mMenu);
        updateMenuView(true);
    L6:
        return this.mMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r1, MenuBuilder r2) {
        this.mContext = r1;
        this.mInflater = LayoutInflater.from(r1);
        this.mMenu = r2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        MenuPresenter.Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onCloseMenu(r1, r2);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r2) {
        MenuPresenter.Callback r0 = this.mCallback;
        MenuBuilder r3 = r2;
        if (r0 == null) goto L9;
        if (r2 != null) goto L8;
        r3 = this.mMenu;
    L8:
        return r0.onOpenSubMenu(r3);
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r1) {
        this.mCallback = r1;
    }

    public void setId(int r1) {
        this.mId = r1;
    }

    public boolean shouldIncludeItem(int r1, MenuItemImpl r2) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        ViewGroup r11 = (ViewGroup) this.mMenuView;
        if (r11 != null) goto L5;
        return;
    L5:
        MenuBuilder r0 = this.mMenu;
        int r1 = 0;
        if (r0 == null) goto L24;
        r0.flagActionItems();
        ArrayList<MenuItemImpl> r2 = this.mMenu.getVisibleItems();
        int r3 = r2.size();
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r3) goto L22;
        MenuItemImpl r6 = r2.get(r4);
        if (shouldIncludeItem(r5, r6) == false) goto L21;
        View r7 = r11.getChildAt(r5);
        if ((r7 instanceof MenuView.ItemView) == false) goto L14;
        MenuItemImpl r8 = ((MenuView.ItemView) r7).getItemData();
    L15:
        View r9 = getItemView(r6, r7, r11);
        if (r6 == r8) goto L18;
        r9.setPressed(false);
        r9.jumpDrawablesToCurrentState();
    L18:
        if (r9 == r7) goto L20;
        addItemView(r9, r5);
    L20:
        r5 = r5 + 1;
        goto L21
    L14:
        r8 = null;
    L21:
        r4 = r4 + 1;
        goto L8
    L22:
        r1 = r5;
    L24:
        if (r1 >= r11.getChildCount()) goto L28;
        if (filterLeftoverView(r11, r1) == true) goto L24;
        r1 = r1 + 1;
        goto L24
    }
}
