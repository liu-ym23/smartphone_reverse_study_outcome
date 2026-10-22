package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<TabInfo> mTabs;

    static class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context r1) {
            this.mContext = r1;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String r1) {
            View r2 = new View(this.mContext);
            r2.setMinimumWidth(0);
            r2.setMinimumHeight(0);
            return r2;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String curTab;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r1) {
            super(r1);
            this.curTab = r1.readString();
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @NonNull
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.curTab);
        }
    }

    static final class TabInfo {

        @Nullable
        final Bundle args;

        @NonNull
        final Class<?> clss;
        Fragment fragment;

        @NonNull
        final String tag;

        TabInfo(@NonNull String r1, @NonNull Class<?> r2, @Nullable Bundle r3) {
            this.tag = r1;
            this.clss = r2;
            this.args = r3;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r3) {
        super(r3, null);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r3, null);
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r2, @Nullable AttributeSet r3) {
        super(r2, r3);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r2, r3);
    }

    @Nullable
    private FragmentTransaction doTabChanged(@Nullable String r4, @Nullable FragmentTransaction r5) {
        TabInfo r6 = getTabInfoForTag(r4);
        if (this.mLastTab == r6) goto L17;
        if (r5 != null) goto L6;
        r5 = this.mFragmentManager.beginTransaction();
    L6:
        TabInfo r0 = this.mLastTab;
        if (r0 == null) goto L11;
        Fragment r1 = r0.fragment;
        if (r1 == null) goto L11;
        r5.detach(r1);
    L11:
        if (r6 == null) goto L16;
        Fragment r2 = r6.fragment;
        if (r2 != null) goto L15;
        Fragment r3 = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), r6.clss.getName());
        r6.fragment = r3;
        r3.setArguments(r6.args);
        r5.add(this.mContainerId, r6.fragment, r6.tag);
        goto L16
    L15:
        r5.attach(r2);
    L16:
        this.mLastTab = r6;
    L17:
        return r5;
    }

    private void ensureContent() {
        if (this.mRealTabContent != null) goto L9;
        FrameLayout r0 = (FrameLayout) findViewById(this.mContainerId);
        this.mRealTabContent = r0;
        if (r0 == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
    }

    private void ensureHierarchy(Context r8) {
        if (findViewById(R.id.tabs) != null) goto L6;
        LinearLayout r1 = new LinearLayout(r8);
        r1.setOrientation(1);
        addView(r1, new FrameLayout.LayoutParams(-1, -1));
        TabWidget r2 = new TabWidget(r8);
        r2.setId(R.id.tabs);
        r2.setOrientation(0);
        r1.addView(r2, new LinearLayout.LayoutParams(-1, -2, 0.0f));
        FrameLayout r3 = new FrameLayout(r8);
        r3.setId(R.id.tabcontent);
        r1.addView(r3, new LinearLayout.LayoutParams(0, 0, 0.0f));
        FrameLayout r4 = new FrameLayout(r8);
        this.mRealTabContent = r4;
        r4.setId(this.mContainerId);
        r1.addView(r4, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return;
    }

    @Nullable
    private TabInfo getTabInfoForTag(String r5) {
        int r0 = this.mTabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        TabInfo r2 = this.mTabs.get(r1);
        if (r2.tag.equals(r5) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    private void initFragmentTabHost(Context r4, AttributeSet r5) {
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{R.attr.inflatedId}, 0, 0);
        this.mContainerId = r6.getResourceId(0, 0);
        r6.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec r3, @NonNull Class<?> r4, @Nullable Bundle r5) {
        r3.setContent(new DummyTabFactory(this.mContext));
        String r0 = r3.getTag();
        TabInfo r1 = new TabInfo(r0, r4, r5);
        if (this.mAttached == false) goto L9;
        Fragment r6 = this.mFragmentManager.findFragmentByTag(r0);
        r1.fragment = r6;
        if (r6 == null) goto L9;
        if (r6.isDetached() == true) goto L9;
        FragmentTransaction r7 = this.mFragmentManager.beginTransaction();
        r7.detach(r1.fragment);
        r7.commit();
    L9:
        this.mTabs.add(r1);
        addTab(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r0 = getCurrentTabTag();
        int r1 = this.mTabs.size();
        FragmentTransaction r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        TabInfo r4 = this.mTabs.get(r3);
        Fragment r5 = this.mFragmentManager.findFragmentByTag(r4.tag);
        r4.fragment = r5;
        if (r5 == null) goto L14;
        if (r5.isDetached() == true) goto L14;
        if (r4.tag.equals(r0) == false) goto L11;
        this.mLastTab = r4;
        goto L14
    L11:
        if (r2 != null) goto L13;
        r2 = this.mFragmentManager.beginTransaction();
    L13:
        r2.detach(r4.fragment);
    L14:
        r3 = r3 + 1;
        goto L3
    L15:
        this.mAttached = true;
        FragmentTransaction r6 = doTabChanged(r0, r2);
        if (r6 == null) goto L24;
        r6.commit();
        this.mFragmentManager.executePendingTransactions();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setCurrentTabByTag(r3.curTab);
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.curTab = getCurrentTabTag();
        return r1;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String r2) {
        if (this.mAttached == false) goto L7;
        FragmentTransaction r0 = doTabChanged(r2, null);
        if (r0 == null) goto L7;
        r0.commit();
    L7:
        TabHost.OnTabChangeListener r1 = this.mOnTabChangeListener;
        if (r1 == null) goto L11;
        r1.onTabChanged(r2);
        return;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener r1) {
        this.mOnTabChangeListener = r1;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context r1, @NonNull FragmentManager r2) {
        ensureHierarchy(r1);
        super.setup();
        this.mContext = r1;
        this.mFragmentManager = r2;
        ensureContent();
    }

    @Deprecated
    public void setup(@NonNull Context r1, @NonNull FragmentManager r2, int r3) {
        ensureHierarchy(r1);
        super.setup();
        this.mContext = r1;
        this.mFragmentManager = r2;
        this.mContainerId = r3;
        ensureContent();
        this.mRealTabContent.setId(r3);
        if (getId() != (-1)) goto L6;
        setId(R.id.tabhost);
        return;
    }
}
