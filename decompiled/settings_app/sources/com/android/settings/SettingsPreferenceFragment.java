package com.android.settings;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.applications.LayoutPreference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.RegisterUtils;
import com.android.settings.widget.FloatingActionButton;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SettingsPreferenceFragment extends InstrumentedPreferenceFragment implements DialogCreatable {
    private static final int DELAY_HIGHLIGHT_DURATION_MILLIS = 600;
    public static final String HELP_URI_RESOURCE_KEY = "help_uri_resource";
    private static final int ORDER_FIRST = -1;
    private static final int ORDER_LAST = 2147483646;
    private static final String SAVE_HIGHLIGHTED_KEY = "android:preference_highlighted";
    private String TAG;
    private HighlightablePreferenceGroupAdapter mAdapter;
    private boolean mAnimationAllowed;
    private ViewGroup mButtonBar;
    private ContentResolver mContentResolver;
    private RecyclerView.Adapter mCurrentRootAdapter;
    private RecyclerView.AdapterDataObserver mDataSetObserver;
    private SettingsDialogFragment mDialogFragment;
    private View mEmptyView;
    private FloatingActionButton mFloatingActionButton;
    private LayoutPreference mFooter;
    private LayoutPreference mHeader;
    private String mHelpUri;
    private boolean mIsDataSetObserverRegistered;
    private LinearLayoutManager mLayoutManager;
    private ViewGroup mPinnedHeaderFrameLayout;
    private ArrayMap<String, Preference> mPreferenceCache;
    private boolean mPreferenceHighlighted;
    private String mPreferenceKey;

    public static class HighlightablePreferenceGroupAdapter extends PreferenceGroupAdapter {
        private int mHighlightPosition;

        @Override // androidx.preference.PreferenceGroupAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((PreferenceViewHolder) r1, r2);
        }

        public HighlightablePreferenceGroupAdapter(PreferenceGroup r1) {
            super(r1);
            this.mHighlightPosition = -1;
        }

        public void highlight(int r1) {
            this.mHighlightPosition = r1;
            notifyDataSetChanged();
        }

        @Override // androidx.preference.PreferenceGroupAdapter
        public void onBindViewHolder(PreferenceViewHolder r3, int r4) {
            super.onBindViewHolder(r3, r4);
            if (r4 != this.mHighlightPosition) goto L9;
            View r5 = r3.itemView;
            if (r5.getBackground() == null) goto L7;
            r5.getBackground().setHotspot(r5.getWidth() / 2, r5.getHeight() / 2);
        L7:
            r5.setPressed(true);
            r5.setPressed(false);
            this.mHighlightPosition = -1;
            return;
        }
    }

    public static class SettingsDialogFragment extends DialogFragment {
        private static final String KEY_DIALOG_ID = "key_dialog_id";
        private static final String KEY_PARENT_FRAGMENT_ID = "key_parent_fragment_id";
        private int mDialogId;
        private DialogInterface.OnCancelListener mOnCancelListener;
        private DialogInterface.OnDismissListener mOnDismissListener;
        private Fragment mParentFragment;

        public void com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        static /* synthetic */ DialogInterface.OnCancelListener access$102(SettingsDialogFragment r0, DialogInterface.OnCancelListener r1) {
            r0.mOnCancelListener = r1;
            return r1;
        }

        static /* synthetic */ DialogInterface.OnDismissListener access$202(SettingsDialogFragment r0, DialogInterface.OnDismissListener r1) {
            r0.mOnDismissListener = r1;
            return r1;
        }

        public SettingsDialogFragment() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SettingsDialogFragment(DialogCreatable r1, int r2) {
            this.mDialogId = r2;
            if ((r1 instanceof Fragment) == false) goto L7;
            this.mParentFragment = (Fragment) r1;
            return;
        L7:
            throw new IllegalArgumentException("fragment argument must be an instance of " + Fragment.class.getName());
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r3) {
            super.onSaveInstanceState(r3);
            if (this.mParentFragment == null) goto L6;
            r3.putInt(KEY_DIALOG_ID, this.mDialogId);
            r3.putInt(KEY_PARENT_FRAGMENT_ID, this.mParentFragment.getId());
            return;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            super.onStart();
            Fragment r1 = this.mParentFragment;
            if (r1 != null) goto L5;
            return;
        L5:
            if ((r1 instanceof SettingsPreferenceFragment) == false) goto L9;
            ((SettingsPreferenceFragment) r1).onDialogShowing();
            return;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            if (r3 == null) goto L18;
            this.mDialogId = r3.getInt(KEY_DIALOG_ID, 0);
            this.mParentFragment = getParentFragment();
            int r4 = r3.getInt(KEY_PARENT_FRAGMENT_ID, -1);
            if (this.mParentFragment != null) goto L6;
            this.mParentFragment = getFragmentManager().findFragmentById(r4);
        L6:
            Fragment r0 = this.mParentFragment;
            if ((r0 instanceof DialogCreatable) == true) goto L15;
            StringBuilder r1 = new StringBuilder();
            Fragment r2 = this.mParentFragment;
            if (r2 == null) goto L11;
            Object r5 = r2.getClass().getName();
        L13:
            throw new IllegalArgumentException(r1.append(r5).append(" must implement ").append(DialogCreatable.class.getName()).toString());
        L11:
            r5 = Integer.valueOf(r4);
            goto L13
        L15:
            if ((r0 instanceof SettingsPreferenceFragment) == false) goto L18;
            SettingsPreferenceFragment.access$302((SettingsPreferenceFragment) r0, this);
        L18:
            return ((DialogCreatable) this.mParentFragment).onCreateDialog(this.mDialogId);
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            super.onCancel(r1);
            DialogInterface.OnCancelListener r0 = this.mOnCancelListener;
            if (r0 == null) goto L6;
            r0.onCancel(r1);
            return;
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface r1) {
            super.onDismiss(r1);
            DialogInterface.OnDismissListener r0 = this.mOnDismissListener;
            if (r0 == null) goto L6;
            r0.onDismiss(r1);
            return;
        }

        public int getDialogId() {
            return this.mDialogId;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onDetach() {
            super.onDetach();
            Fragment r0 = this.mParentFragment;
            if ((r0 instanceof SettingsPreferenceFragment) == true) goto L5;
            return;
        L5:
            if (SettingsPreferenceFragment.access$300((SettingsPreferenceFragment) r0) != this) goto L9;
            SettingsPreferenceFragment.access$302((SettingsPreferenceFragment) this.mParentFragment, null);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SettingsDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SettingsDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SettingsDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_SettingsPreferenceFragment$SettingsDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    protected int getHelpResource() {
        return R.string.help_uri_default;
    }

    public Dialog onCreateDialog(int r1) {
        return null;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    public void onDialogShowing() {
    }

    public SettingsPreferenceFragment() {
        this.TAG = getClass().getSimpleName();
        this.mPreferenceHighlighted = false;
        this.mIsDataSetObserverRegistered = false;
        this.mDataSetObserver = new AnonymousClass1(this);
    }

    static /* synthetic */ HighlightablePreferenceGroupAdapter access$000(SettingsPreferenceFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ SettingsDialogFragment access$300(SettingsPreferenceFragment r0) {
        return r0.mDialogFragment;
    }

    static /* synthetic */ SettingsDialogFragment access$302(SettingsPreferenceFragment r0, SettingsDialogFragment r1) {
        r0.mDialogFragment = r1;
        return r1;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (r3 == null) goto L5;
        this.mPreferenceHighlighted = r3.getBoolean(SAVE_HIGHLIGHTED_KEY);
    L5:
        Bundle r4 = getArguments();
        if (r4 != null) goto L8;
    L10:
        int r5 = getHelpResource();
    L11:
        if (r5 == 0) goto L14;
        this.mHelpUri = getResources().getString(r5);
        return;
    L14:
        return;
    L8:
        if (r4.containsKey(HELP_URI_RESOURCE_KEY) == false) goto L10;
        r5 = r4.getInt(HELP_URI_RESOURCE_KEY);
        goto L11
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = super.onCreateView(r1, r2, r3);
        this.mPinnedHeaderFrameLayout = (ViewGroup) r4.findViewById(R.id.pinned_header);
        this.mFloatingActionButton = (FloatingActionButton) r4.findViewById(R.id.fab);
        this.mButtonBar = (ViewGroup) r4.findViewById(R.id.button_bar);
        return r4;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void addPreferencesFromResource(int r1) {
        super.addPreferencesFromResource(r1);
        checkAvailablePrefs(getPreferenceScreen());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkAvailablePrefs(PreferenceGroup r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r5.getPreferenceCount()) goto L16;
        Preference r1 = r5.getPreference(r0);
        if ((r1 instanceof SelfAvailablePreference) == false) goto L13;
        if (((SelfAvailablePreference) r1).isAvailable(getContext()) == true) goto L13;
        r5.removePreference(r1);
    L15:
        r0 = r0 + 1;
    L13:
        if ((r1 instanceof PreferenceGroup) == false) goto L15;
        checkAvailablePrefs((PreferenceGroup) r1);
        goto L15
    }

    public FloatingActionButton getFloatingActionButton() {
        return this.mFloatingActionButton;
    }

    public ViewGroup getButtonBar() {
        return this.mButtonBar;
    }

    public View setPinnedHeaderView(int r4) {
        View r5 = getActivity().getLayoutInflater().inflate(r4, this.mPinnedHeaderFrameLayout, false);
        setPinnedHeaderView(r5);
        return r5;
    }

    public void setPinnedHeaderView(View r2) {
        this.mPinnedHeaderFrameLayout.addView(r2);
        this.mPinnedHeaderFrameLayout.setVisibility(0);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putBoolean(SAVE_HIGHLIGHTED_KEY, this.mPreferenceHighlighted);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        setHasOptionsMenu(true);
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        this.mPreferenceKey = r0.getString(SettingsActivity.EXTRA_FRAGMENT_ARG_KEY);
        highlightPreferenceIfNeeded();
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    protected void onBindPreferences() {
        registerObserverIfNeeded();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    protected void onUnbindPreferences() {
        unregisterObserverIfNeeded();
    }

    public void showLoadingWhenEmpty() {
        setEmptyView(getView().findViewById(R.id.loading_container));
    }

    public void setLoading(boolean r3, boolean r4) {
        Utils.handleLoadingContainer(getView().findViewById(R.id.loading_container), getListView(), !r3, r4);
    }

    public void registerObserverIfNeeded() {
        if (this.mIsDataSetObserverRegistered == true) goto L9;
        RecyclerView.Adapter r0 = this.mCurrentRootAdapter;
        if (r0 == null) goto L7;
        r0.unregisterAdapterDataObserver(this.mDataSetObserver);
    L7:
        RecyclerView.Adapter r1 = getListView().getAdapter();
        this.mCurrentRootAdapter = r1;
        r1.registerAdapterDataObserver(this.mDataSetObserver);
        this.mIsDataSetObserverRegistered = true;
        onDataSetChanged();
        return;
    }

    public void unregisterObserverIfNeeded() {
        if (this.mIsDataSetObserverRegistered == false) goto L9;
        RecyclerView.Adapter r0 = this.mCurrentRootAdapter;
        if (r0 == null) goto L7;
        r0.unregisterAdapterDataObserver(this.mDataSetObserver);
        this.mCurrentRootAdapter = null;
    L7:
        this.mIsDataSetObserverRegistered = false;
        return;
    }

    public void highlightPreferenceIfNeeded() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (this.mPreferenceHighlighted == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.mPreferenceKey) == true) goto L12;
        highlightPreference(this.mPreferenceKey);
        return;
    }

    protected void onDataSetChanged() {
        highlightPreferenceIfNeeded();
        updateEmptyView();
    }

    public LayoutPreference getHeaderView() {
        return this.mHeader;
    }

    public LayoutPreference getFooterView() {
        return this.mFooter;
    }

    protected void setHeaderView(int r3) {
        LayoutPreference r0 = new LayoutPreference(getPrefContext(), r3);
        this.mHeader = r0;
        addPreferenceToTop(r0);
    }

    protected void setHeaderView(View r3) {
        LayoutPreference r0 = new LayoutPreference(getPrefContext(), r3);
        this.mHeader = r0;
        addPreferenceToTop(r0);
    }

    private void addPreferenceToTop(LayoutPreference r2) {
        r2.setOrder(-1);
        if (getPreferenceScreen() == null) goto L6;
        getPreferenceScreen().addPreference(r2);
        return;
    }

    protected void setFooterView(int r3) {
        if (r3 == 0) goto L4;
        LayoutPreference r0 = new LayoutPreference(getPrefContext(), r3);
    L5:
        setFooterView(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    protected void setFooterView(View r3) {
        if (r3 == null) goto L4;
        LayoutPreference r0 = new LayoutPreference(getPrefContext(), r3);
    L5:
        setFooterView(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    private void setFooterView(LayoutPreference r3) {
        if (getPreferenceScreen() != null) goto L5;
    L7:
        if (r3 == null) goto L11;
        this.mFooter = r3;
        r3.setOrder(ORDER_LAST);
        if (getPreferenceScreen() == null) goto L13;
        getPreferenceScreen().addPreference(this.mFooter);
        return;
    L13:
        return;
    L11:
        this.mFooter = null;
        return;
    L5:
        if (this.mFooter == null) goto L7;
        getPreferenceScreen().removePreference(this.mFooter);
        goto L7
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void setPreferenceScreen(PreferenceScreen r2) {
        if (r2 != null) goto L4;
    L6:
        super.setPreferenceScreen(r2);
        if (r2 == null) goto L15;
        LayoutPreference r0 = this.mHeader;
        if (r0 == null) goto L11;
        r2.addPreference(r0);
    L11:
        LayoutPreference r1 = this.mFooter;
        if (r1 == null) goto L16;
        r2.addPreference(r1);
        return;
    L16:
        return;
    L15:
        return;
    L4:
        if (r2.isAttached() == true) goto L6;
        r2.setShouldUseGeneratedIds(this.mAnimationAllowed);
        goto L6
    }

    private void updateEmptyView() {
        if (this.mEmptyView != null) goto L5;
        return;
    L5:
        int r1 = 0;
        if (getPreferenceScreen() == null) goto L24;
        int r0 = getPreferenceScreen().getPreferenceCount();
        boolean r3 = true;
        if (this.mHeader == null) goto L10;
        int r2 = 1;
    L11:
        int r4 = r0 - r2;
        if (this.mFooter == null) goto L14;
        int r5 = 1;
    L16:
        if ((r4 - r5) <= 0) goto L19;
        r3 = false;
    L19:
        View r6 = this.mEmptyView;
        if (r3 == true) goto L23;
        r1 = 8;
    L23:
        r6.setVisibility(r1);
        return;
    L14:
        r5 = 0;
        goto L16
    L10:
        r2 = 0;
        goto L11
    L24:
        this.mEmptyView.setVisibility(0);
    }

    public void setEmptyView(View r3) {
        View r0 = this.mEmptyView;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.mEmptyView = r3;
        updateEmptyView();
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    private int canUseListViewForHighLighting(String r4) {
        if (getListView() != null) goto L5;
        return -1;
    L5:
        RecyclerView.Adapter r0 = getListView().getAdapter();
        if (r0 != null) goto L8;
    L11:
        return -1;
    L8:
        if ((r0 instanceof PreferenceGroupAdapter) == false) goto L11;
        return findListPositionFromKey((PreferenceGroupAdapter) r0, r4);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        LinearLayoutManager r0 = new LinearLayoutManager(getContext());
        this.mLayoutManager = r0;
        return r0;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    protected RecyclerView.Adapter onCreateAdapter(PreferenceScreen r2) {
        HighlightablePreferenceGroupAdapter r0 = new HighlightablePreferenceGroupAdapter(r2);
        this.mAdapter = r0;
        return r0;
    }

    protected void setAnimationAllowed(boolean r1) {
        this.mAnimationAllowed = r1;
    }

    protected void cacheRemoveAllPrefs(PreferenceGroup r6) {
        this.mPreferenceCache = new ArrayMap();
        int r0 = r6.getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Preference r2 = r6.getPreference(r1);
        if (TextUtils.isEmpty(r2.getKey()) == true) goto L8;
        this.mPreferenceCache.put(r2.getKey(), r2);
    L8:
        r1 = r1 + 1;
        goto L3
    }

    protected Preference getCachedPreference(String r1) {
        ArrayMap<String, Preference> r0 = this.mPreferenceCache;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.remove(r1);
    }

    protected void removeCachedPrefs(PreferenceGroup r2) {
        Iterator<Preference> r1 = this.mPreferenceCache.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.removePreference(r1.next());
        goto L4
    }

    protected int getCachedCount() {
        return this.mPreferenceCache.size();
    }

    private void highlightPreference(String r3) {
        final int r4 = canUseListViewForHighLighting(r3);
        if (r4 < 0) goto L6;
        this.mPreferenceHighlighted = true;
        this.mLayoutManager.scrollToPosition(r4);
        getView().postDelayed(new AnonymousClass2(this, r4), 600);
        return;
    }

    private int findListPositionFromKey(PreferenceGroupAdapter r3, String r4) {
        int r2 = r3.getItemCount();
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L10;
        String r1 = r3.getItem(r0).getKey();
        if (r1 == null) goto L9;
        if (r1.equals(r4) == false) goto L9;
        return r0;
    L9:
        r0 = r0 + 1;
        goto L3
    L10:
        return -1;
    }

    protected void removePreference(String r1) {
        Preference r2 = findPreference(r1);
        if (r2 == null) goto L6;
        getPreferenceScreen().removePreference(r2);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        if (this.mHelpUri != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L9;
        com.android.settingslib.HelpUtils.prepareHelpMenuItem(getActivity(), r2, this.mHelpUri, getClass().getName());
        return;
    }

    public final void finishFragment() {
        getActivity().onBackPressed();
    }

    protected ContentResolver getContentResolver() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        this.mContentResolver = r0.getContentResolver();
    L6:
        return this.mContentResolver;
    }

    protected Object getSystemService(String r1) {
        return ((FragmentActivity) NullSafe.nonNull(getActivity())).getSystemService(r1);
    }

    protected PackageManager getPackageManager() {
        return getActivity().getPackageManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        if (isRemoving() == false) goto L7;
        SettingsDialogFragment r0 = this.mDialogFragment;
        if (r0 == null) goto L7;
        r0.dismiss();
        this.mDialogFragment = null;
    L7:
        super.onDetach();
    }

    protected void showDialog(int r3) {
        if (this.mDialogFragment == null) goto L5;
        OLog.e(this.TAG, "Old dialog fragment not null!");
    L5:
        SettingsDialogFragment r0 = new SettingsDialogFragment(this, r3);
        this.mDialogFragment = r0;
        r0.show(getChildFragmentManager(), Integer.toString(r3));
    }

    protected void removeDialog(int r2) {
        SettingsDialogFragment r0 = this.mDialogFragment;
        if (r0 != null) goto L5;
    L7:
        this.mDialogFragment = null;
        return;
    L5:
        if (r0.getDialogId() != r2) goto L7;
        this.mDialogFragment.dismiss();
        goto L7
    }

    protected void removeDialog(int r1, boolean r2) {
        if (r2 == false) goto L9;
        SettingsDialogFragment r3 = this.mDialogFragment;
        if (r3 != null) goto L6;
    L8:
        this.mDialogFragment = null;
        return;
    L6:
        if (r3.getDialogId() != r1) goto L8;
        getFragmentManager().beginTransaction().remove(this.mDialogFragment).commitAllowingStateLoss();
        goto L8
    L9:
        removeDialog(r1);
    }

    protected void setOnCancelListener(DialogInterface.OnCancelListener r1) {
        SettingsDialogFragment r0 = this.mDialogFragment;
        if (r0 == null) goto L6;
        SettingsDialogFragment.access$102(r0, r1);
        return;
    }

    protected void setOnDismissListener(DialogInterface.OnDismissListener r1) {
        SettingsDialogFragment r0 = this.mDialogFragment;
        if (r0 == null) goto L6;
        SettingsDialogFragment.access$202(r0, r1);
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(Preference r3) {
        if (r3.getKey() != null) goto L6;
        r3.setKey(UUID.randomUUID().toString());
    L6:
        if ((r3 instanceof CustomListPreference) == false) goto L9;
        DialogFragment r4 = CustomListPreference.CustomListPreferenceDialogFragment.newInstance(r3.getKey());
    L14:
        r4.setTargetFragment(this, 0);
        r4.show(getFragmentManager(), "dialog_preference");
        onDialogShowing();
        return;
    L9:
        if ((r3 instanceof CustomDialogPreference) == false) goto L12;
        r4 = CustomDialogPreference.CustomPreferenceDialogFragment.newInstance(r3.getKey());
        goto L14
    L12:
        if ((r3 instanceof CustomEditTextPreference) == false) goto L16;
        r4 = CustomEditTextPreference.CustomPreferenceDialogFragment.newInstance(r3.getKey());
        goto L14
    L16:
        super.onDisplayPreferenceDialog(r3);
    }

    protected boolean hasNextButton() {
        return ((ButtonBarHandler) getActivity()).hasNextButton();
    }

    protected Button getNextButton() {
        return ((ButtonBarHandler) getActivity()).getNextButton();
    }

    public void finish() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.onBackPressed();
        return;
    }

    protected Intent getIntent() {
        if (getActivity() != null) goto L7;
        return null;
    L7:
        return getActivity().getIntent();
    }

    protected void setResult(int r2, Intent r3) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        getActivity().setResult(r2, r3);
    }

    protected void setResult(int r2) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        getActivity().setResult(r2);
    }

    protected final Context getPrefContext() {
        return getPreferenceManager().getContext();
    }

    public boolean startFragment(Fragment r10, String r11, int r12, int r13, Bundle r14) {
        FragmentActivity r0 = getActivity();
        if ((r0 instanceof SettingsActivity) == false) goto L6;
        ((SettingsActivity) r0).startPreferencePanel(r11, r14, r12, null, r10, r13);
        return true;
    L6:
        OLog.w(this.TAG, "Parent isn't SettingsActivity nor PreferenceActivity, thus there's no way to launch the given Fragment (name: " + r11 + ", requestCode: " + r13 + ")");
        return false;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void startActivity(Intent r3) {
        r3.putExtra(Constants.EXTRA_OUTER, false);
        super.startActivity(r3);
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void startActivityForResult(Intent r3, int r4) {
        r3.putExtra(Constants.EXTRA_OUTER, false);
        super.startActivityForResult(r3, r4);
    }

    public void unregisterReceiver(BroadcastReceiver r2) {
        RegisterUtils.unRegisterBroadcastReceiverSafely(this.TAG, getActivity(), r2);
    }
}
