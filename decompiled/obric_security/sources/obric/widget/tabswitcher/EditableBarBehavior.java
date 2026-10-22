package obric.widget.tabswitcher;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.List;
import obric.widget.BottomBarItemView;
import obric.widget.tabswitcher.model.ITabManager;
import obric.widget.tabswitcher.model.Tab;
import obric.widget.tabswitcher.model.TabBrick;

/* JADX INFO: loaded from: classes5.dex */
public class EditableBarBehavior extends PickPutBehavior {
    private static final int EDITABLE_TAB_SIZE = 5;
    private List<View> children;
    private ViewGroup mContainer;
    private final boolean mMoreTab;
    private final Resources mResources;
    private ITabManager mTabManager;
    private List<Tab> mTabs;
    private List<Rect> rects;

    private class MyTabBrick implements TabBrick {
        final Bitmap drawable;
        final int drawableOffsetX;
        final int index;
        final Rect rect;
        final Tab tab;
        final /* synthetic */ EditableBarBehavior this$0;

        MyTabBrick(final EditableBarBehavior this$0, Rect rect, Tab tab, int index, boolean isMoreTab) {
            this.this$0 = this$0;
            this.rect = rect;
            this.tab = tab;
            this.index = index;
            if (isMoreTab == false) goto L5;
            int r3 = tab.getMoreTabDrawableResId();
        L6:
            Bitmap r1 = ((BitmapDrawable) EditableBarBehavior.access$100(this$0).getDrawable(r3).getCurrent()).getBitmap();
            this.drawable = r1;
            this.drawableOffsetX = (rect.width() - r1.getWidth()) / 2;
            return;
        L5:
            r3 = tab.getDrawableResId();
            goto L6
        }

        @Override // obric.widget.tabswitcher.model.TabBrick
        public Rect getRect() {
            return this.rect;
        }

        @Override // obric.widget.tabswitcher.model.TabBrick
        public Tab getTab() {
            return this.tab;
        }

        @Override // obric.widget.tabswitcher.model.TabBrick
        public Bitmap getDrawable() {
            return this.drawable;
        }

        @Override // obric.widget.tabswitcher.model.TabBrick
        public int getDrawableOffsetX() {
            return this.drawableOffsetX;
        }

        @Override // obric.widget.tabswitcher.model.TabBrick
        public int getIndex() {
            return this.index;
        }
    }

    @Override // obric.widget.tabswitcher.Putable
    public TabBrick arouse(float rawX, float rawY) {
        return null;
    }

    @Override // obric.widget.tabswitcher.Putable
    public void disarouse(TabBrick tabBrick) {
    }

    static /* synthetic */ List access$002(EditableBarBehavior r0, List r1) {
        r0.rects = r1;
        return r1;
    }

    static /* synthetic */ Resources access$100(EditableBarBehavior r0) {
        return r0.mResources;
    }

    EditableBarBehavior(ViewGroup container, ITabManager manager, boolean moreTab) {
        this.mContainer = container;
        this.mResources = container.getResources();
        this.mTabManager = manager;
        this.mMoreTab = moreTab;
        initChildren();
        reset();
        this.mContainer.addOnLayoutChangeListener(new AnonymousClass1(this));
    }

    private void initTabs() {
        if (this.mMoreTab == false) goto L5;
        this.mTabs = this.mTabManager.getMoreTabs();
        return;
    L5:
        this.mTabs = this.mTabManager.getTabs();
    }

    private void initChildren() {
        this.children = new ArrayList(this.mContainer.getChildCount());
        int r0 = 0;
    L4:
        if (r0 >= this.mContainer.getChildCount()) goto L6;
        this.children.add(this.mContainer.getChildAt(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // obric.widget.tabswitcher.PickPutBehavior
    public void reset() {
        this.mTabManager.init();
        initTabs();
    }

    @Override // obric.widget.tabswitcher.Pickable
    public TabBrick pick(float rawX, float rawY) {
        MyTabBrick r1 = findTab(rawX, rawY);
        if (r1 == null) goto L5;
        this.children.get(r1.getIndex()).setVisibility(4);
    L5:
        return r1;
    }

    @Override // obric.widget.tabswitcher.Putable
    public void put(int putState, TabBrick tabBrick, float rawX, float rawY) {
        int r6 = findIndex(rawX, rawY);
        if (r6 < 0) goto L25;
        View r7 = this.children.get(r6);
        if ((r7 instanceof RadioButton) == false) goto L15;
        RadioButton r0 = (RadioButton) r7;
        if (putState != 0) goto L9;
        r7.setVisibility(4);
        return;
    L9:
        Tab r4 = tabBrick.getTab();
        r0.setText(r4.getTextResId());
        if (this.mMoreTab == false) goto L12;
        int r5 = r4.getMoreTabDrawableResId();
    L13:
        r0.setCompoundDrawablesWithIntrinsicBounds(0, r5, 0, 0);
        r0.setVisibility(0);
        r0.setId(r4.getId());
        replaceTabList(r6, r4);
        return;
    L12:
        r5 = r4.getDrawableResId();
        goto L13
    L15:
        if ((r7 instanceof BottomBarItemView) == false) goto L28;
        BottomBarItemView r1 = (BottomBarItemView) r7;
        if (putState != 0) goto L19;
        r7.setVisibility(4);
        return;
    L19:
        Tab r8 = tabBrick.getTab();
        r1.setText(r1.getContext().getResources().getString(r8.getTextResId()));
        if (this.mMoreTab == false) goto L22;
        int r9 = r8.getMoreTabDrawableResId();
    L23:
        r1.setDrawableResource(r9);
        r1.setVisibility(0);
        r1.setId(r8.getId());
        replaceTabList(r6, r8);
        return;
    L22:
        r9 = r8.getDrawableResId();
        goto L23
    L28:
        return;
    }

    private void replaceTabList(int index, Tab tab) {
        Tab r2 = this.mTabs.set(index, tab);
        this.mTabManager.replaceTabList(tab, r2);
    }

    @Override // obric.widget.tabswitcher.Pickable, obric.widget.tabswitcher.Putable
    public TabBrick peek(float rawX, float rawY) {
        return findTab(rawX, rawY);
    }

    @Override // obric.widget.tabswitcher.Pickable
    public void cancelPick(TabBrick tabBrick) {
        if ((tabBrick instanceof MyTabBrick) == false) goto L6;
        int r2 = ((MyTabBrick) tabBrick).getIndex();
        this.children.get(r2).setVisibility(0);
        return;
    }

    @Override // obric.widget.tabswitcher.Pickable
    public void update(TabBrick tabBrick, float rawX, float rawY) {
        int r5 = findIndex(rawX, rawY);
        if (r5 < 0) goto L19;
        View r6 = this.children.get(r5);
        if ((r6 instanceof RadioButton) == false) goto L12;
        RadioButton r7 = (RadioButton) r6;
        Tab r4 = tabBrick.getTab();
        r7.setText(r4.getTextResId());
        if (this.mMoreTab == false) goto L9;
        int r0 = r4.getMoreTabDrawableResId();
    L10:
        r7.setCompoundDrawablesWithIntrinsicBounds(0, r0, 0, 0);
        r7.setVisibility(0);
        r7.setId(r4.getId());
        this.mTabs.set(r5, r4);
        return;
    L9:
        r0 = r4.getDrawableResId();
        goto L10
    L12:
        if ((r6 instanceof BottomBarItemView) == false) goto L21;
        BottomBarItemView r8 = (BottomBarItemView) r6;
        Tab r9 = tabBrick.getTab();
        r8.setText(r8.getContext().getResources().getString(r9.getTextResId()));
        if (this.mMoreTab == false) goto L16;
        int r1 = r9.getMoreTabDrawableResId();
    L17:
        r8.setDrawableResource(r1);
        r8.setVisibility(0);
        r8.setId(r9.getId());
        this.mTabs.set(r5, r9);
        return;
    L16:
        r1 = r9.getDrawableResId();
        goto L17
    L21:
        return;
    }

    private MyTabBrick findTab(float rawX, float rawY) {
        initRects();
        int r0 = 0;
    L4:
        if (r0 >= this.rects.size()) goto L9;
        if (this.rects.get(r0).contains((int) rawX, (int) rawY) == true) goto L10;
        r0 = r0 + 1;
    L10:
        int r5 = r0;
        if (r5 < 0) goto L16;
        Tab r4 = this.mTabs.get(r5);
        if (r4.switchable() == true) goto L15;
        return null;
    L15:
        return new MyTabBrick(this, this.rects.get(r5), r4, r5, this.mMoreTab);
    L16:
        return null;
    L9:
        r0 = -1;
        goto L10
    }

    private int findIndex(float rawX, float rawY) {
        initRects();
        int r0 = 0;
    L4:
        if (r0 >= this.rects.size()) goto L9;
        if (this.rects.get(r0).contains((int) rawX, (int) rawY) == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        return r0;
    L9:
        return -1;
    }

    private void initRects() {
        if (this.rects != null) goto L7;
        int r0 = this.children.size();
        this.rects = new ArrayList(r0);
        int[] r1 = new int[2];
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L9;
        View r4 = this.children.get(r3);
        int r5 = r4.getMeasuredWidth();
        int r6 = r4.getMeasuredHeight();
        Rect r7 = new Rect();
        r4.getLocationOnScreen(r1);
        r7.left = r1[0];
        r7.right = r1[0] + r5;
        r7.top = r1[1];
        r7.bottom = r1[1] + r6;
        this.rects.add(r7);
        r3 = r3 + 1;
        goto L5
    L9:
        return;
    }
}
