package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {
    private Handler mHandler;
    private PreferenceGroup mPreferenceGroup;
    private List<PreferenceResourceDescriptor> mPreferenceResourceDescriptors;
    private List<Preference> mPreferences;
    private Runnable mSyncRunnable;
    private List<Preference> mVisiblePreferences;

    private static class PreferenceResourceDescriptor {
        String mClassName;
        int mLayoutResId;
        int mWidgetLayoutResId;

        PreferenceResourceDescriptor(Preference r2) {
            this.mClassName = r2.getClass().getName();
            this.mLayoutResId = r2.getLayoutResource();
            this.mWidgetLayoutResId = r2.getWidgetLayoutResource();
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof PreferenceResourceDescriptor) == true) goto L5;
            return false;
        L5:
            PreferenceResourceDescriptor r5 = (PreferenceResourceDescriptor) r4;
            if (this.mLayoutResId == r5.mLayoutResId) goto L8;
            return false;
        L8:
            if (this.mWidgetLayoutResId == r5.mWidgetLayoutResId) goto L10;
            return false;
        L10:
            if (TextUtils.equals(this.mClassName, r5.mClassName) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public int hashCode() {
            return ((((527 + this.mLayoutResId) * 31) + this.mWidgetLayoutResId) * 31) + this.mClassName.hashCode();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((PreferenceViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public PreferenceGroupAdapter(PreferenceGroup r2) {
        this.mSyncRunnable = new AnonymousClass1(this);
        this.mPreferenceGroup = r2;
        this.mHandler = new Handler();
        this.mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.mPreferences = new ArrayList();
        this.mVisiblePreferences = new ArrayList();
        this.mPreferenceResourceDescriptors = new ArrayList();
        PreferenceGroup r3 = this.mPreferenceGroup;
        if ((r3 instanceof PreferenceScreen) == false) goto L5;
        setHasStableIds(((PreferenceScreen) r3).shouldUseGeneratedIds());
    L6:
        updatePreferences();
        return;
    L5:
        setHasStableIds(true);
        goto L6
    }

    void updatePreferences() {
        Iterator<Preference> r0 = this.mPreferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setOnPreferenceChangeInternalListener(null);
        goto L4
    L6:
        ArrayList r1 = new ArrayList(this.mPreferences.size());
        this.mPreferences = r1;
        flattenPreferenceGroup(r1, this.mPreferenceGroup);
        final List<Preference> r2 = this.mVisiblePreferences;
        final List<Preference> r3 = createVisiblePreferencesList(this.mPreferenceGroup);
        this.mVisiblePreferences = r3;
        PreferenceManager r4 = this.mPreferenceGroup.getPreferenceManager();
        if (r4 != null) goto L9;
    L11:
        notifyDataSetChanged();
    L12:
        Iterator<Preference> r5 = this.mPreferences.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        r5.next().clearWasDetached();
        goto L14
    L16:
        return;
    L9:
        if (r4.getPreferenceComparisonCallback() == null) goto L11;
        final PreferenceManager.PreferenceComparisonCallback r6 = r4.getPreferenceComparisonCallback();
        DiffUtil.calculateDiff(new AnonymousClass2(this, r2, r3, r6)).dispatchUpdatesTo(this);
        goto L12
    }

    private void flattenPreferenceGroup(List<Preference> r6, PreferenceGroup r7) {
        r7.sortPreferences();
        int r0 = r7.getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        Preference r2 = r7.getPreference(r1);
        r6.add(r2);
        PreferenceResourceDescriptor r3 = new PreferenceResourceDescriptor(r2);
        if (this.mPreferenceResourceDescriptors.contains(r3) == true) goto L8;
        this.mPreferenceResourceDescriptors.add(r3);
    L8:
        if ((r2 instanceof PreferenceGroup) == false) goto L12;
        PreferenceGroup r4 = (PreferenceGroup) r2;
        if (r4.isOnSameScreenAsChildren() == false) goto L12;
        flattenPreferenceGroup(r6, r4);
    L12:
        r2.setOnPreferenceChangeInternalListener(this);
        r1 = r1 + 1;
        goto L3
    }

    private List<Preference> createVisiblePreferencesList(PreferenceGroup r9) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        int r2 = r9.getPreferenceCount();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L40;
        Preference r5 = r9.getPreference(r3);
        if (r5.isVisible() == false) goto L38;
        if (isGroupExpandable(r9) == true) goto L10;
    L13:
        r0.add(r5);
    L15:
        if ((r5 instanceof PreferenceGroup) == true) goto L17;
        r4 = r4 + 1;
        goto L38
    L17:
        PreferenceGroup r6 = (PreferenceGroup) r5;
        if (r6.isOnSameScreenAsChildren() == false) goto L38;
        if (isGroupExpandable(r9) == true) goto L23;
    L27:
        Iterator<Preference> r7 = createVisiblePreferencesList(r6).iterator();
    L29:
        if (r7.hasNext() == false) goto L38;
        Preference r8 = r7.next();
        if (isGroupExpandable(r9) == true) goto L33;
    L36:
        r0.add(r8);
    L37:
        r4 = r4 + 1;
        goto L29
    L33:
        if (r4 < r9.getInitialExpandedChildrenCount()) goto L36;
        r1.add(r8);
        goto L37
    L23:
        if (isGroupExpandable(r6) == false) goto L27;
        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
    L10:
        if (r4 < r9.getInitialExpandedChildrenCount()) goto L13;
        r1.add(r5);
    L38:
        r3 = r3 + 1;
        goto L3
    L40:
        if (isGroupExpandable(r9) == true) goto L42;
    L44:
        return r0;
    L42:
        if (r4 <= r9.getInitialExpandedChildrenCount()) goto L44;
        r0.add(createExpandButton(r9, r1));
        goto L44
    }

    private ExpandButton createExpandButton(final PreferenceGroup r5, List<Preference> r6) {
        ExpandButton r0 = new ExpandButton(r5.getContext(), r6, r5.getId());
        r0.setOnPreferenceClickListener(new AnonymousClass3(this, r5));
        return r0;
    }

    private boolean isGroupExpandable(PreferenceGroup r1) {
        if (r1.getInitialExpandedChildrenCount() == Integer.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public Preference getItem(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < getItemCount()) goto L7;
        return null;
    L7:
        return this.mVisiblePreferences.get(r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mVisiblePreferences.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r2) {
        if (hasStableIds() == true) goto L7;
        return -1;
    L7:
        return getItem(r2).getId();
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceChange(Preference r3) {
        int r0 = this.mVisiblePreferences.indexOf(r3);
        if (r0 == (-1)) goto L6;
        notifyItemChanged(r0, r3);
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceHierarchyChange(Preference r2) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceVisibilityChange(Preference r1) {
        onPreferenceHierarchyChange(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r3) {
        PreferenceResourceDescriptor r0 = new PreferenceResourceDescriptor(getItem(r3));
        int r4 = this.mPreferenceResourceDescriptors.indexOf(r0);
        if (r4 == (-1)) goto L5;
        return r4;
    L5:
        int r5 = this.mPreferenceResourceDescriptors.size();
        this.mPreferenceResourceDescriptors.add(r0);
        return r5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PreferenceViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        PreferenceResourceDescriptor r3 = this.mPreferenceResourceDescriptors.get(r5);
        LayoutInflater r6 = LayoutInflater.from(r4.getContext());
        TypedArray r0 = r4.getContext().obtainStyledAttributes(null, R.styleable.BackgroundStyle);
        Drawable r1 = r0.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (r1 != null) goto L5;
        r1 = AppCompatResources.getDrawable(r4.getContext(), android.R.drawable.list_selector_background);
    L5:
        r0.recycle();
        View r7 = r6.inflate(r3.mLayoutResId, r4, false);
        if (r7.getBackground() != null) goto L8;
        ViewCompat.setBackground(r7, r1);
    L8:
        ViewGroup r2 = (ViewGroup) r7.findViewById(android.R.id.widget_frame);
        if (r2 == null) goto L15;
        if (r3.mWidgetLayoutResId == 0) goto L13;
        r6.inflate(r3.mWidgetLayoutResId, r2);
        goto L15
    L13:
        r2.setVisibility(8);
    L15:
        return new PreferenceViewHolder(r7);
    }

    public void onBindViewHolder(PreferenceViewHolder r1, int r2) {
        getItem(r2).onBindViewHolder(r1);
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(String r4) {
        int r0 = this.mVisiblePreferences.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (TextUtils.equals(r4, this.mVisiblePreferences.get(r1).getKey()) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(Preference r4) {
        int r0 = this.mVisiblePreferences.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Preference r2 = this.mVisiblePreferences.get(r1);
        if (r2 == null) goto L9;
        if (r2.equals(r4) == false) goto L9;
        return r1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return -1;
    }
}
