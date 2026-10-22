package com.android.settings;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.RegisterUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.FloatingActionButton;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SettingsPreferenceFragment23 extends PreferenceFragmentCompat implements DialogCreatable {
    private static final int DELAY_HIGHLIGHT_DURATION_MILLIS = 600;
    private static final String SAVE_HIGHLIGHTED_KEY = "android:preference_highlighted";
    private String TAG;
    private HighlightablePreferenceGroupAdapter mAdapter;
    private boolean mBytedanceStyle;
    private ContentResolver mContentResolver;
    private RecyclerView.Adapter mCurrentRootAdapter;
    private RecyclerView.AdapterDataObserver mDataSetObserver;
    private SettingsDialogFragment mDialogFragment;
    private View mEmptyView;
    private FloatingActionButton mFloatingActionButton;
    private String mHelpUri;
    private Drawable mHighlightDrawable;
    private boolean mIsDataSetObserverRegistered;
    private LinearLayoutManager mLayoutManager;
    protected ViewGroup mPinnedHeaderFrameLayout;
    private boolean mPreferenceHighlighted;
    private String mPreferenceKey;

    public static class HighlightablePreferenceGroupAdapter extends PreferenceGroupAdapter {
        private int mHighlightPosition;
        private RecyclerView mRecyclerView;

        static /* synthetic */ void access$400(HighlightablePreferenceGroupAdapter r0) {
            r0.notifyDataSetChangedSafely();
        }

        @Override // androidx.preference.PreferenceGroupAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((PreferenceViewHolder) r1, r2);
        }

        public HighlightablePreferenceGroupAdapter(PreferenceGroup r1) {
            super(r1);
            this.mHighlightPosition = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView r1) {
            super.onAttachedToRecyclerView(r1);
            this.mRecyclerView = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView r2) {
            if (this.mRecyclerView != r2) goto L5;
            this.mRecyclerView = null;
        L5:
            super.onDetachedFromRecyclerView(r2);
        }

        public void highlight(int r1) {
            this.mHighlightPosition = r1;
            notifyDataSetChangedSafely();
        }

        private void notifyDataSetChangedSafely() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
        L10:
            notifyDataSetChanged();
            return;
        L5:
            if (r0.isComputingLayout() == false) goto L7;
        L8:
            this.mRecyclerView.post(new AnonymousClass1(this));
            return;
        L7:
            if (this.mRecyclerView.getScrollState() == 0) goto L10;
            goto L8
        }

        @Override // androidx.preference.PreferenceGroupAdapter
        public void onBindViewHolder(PreferenceViewHolder r2, int r3) {
            super.onBindViewHolder(r2, r3);
            if (r3 != this.mHighlightPosition) goto L8;
            View r4 = r2.itemView;
            if (r4.getBackground() == null) goto L9;
            getHighlightDrawableStatic(r4).setHotspot(r4.getWidth() / 2, r4.getHeight() / 2);
            r4.setPressed(true);
            r4.setPressed(false);
            return;
        L9:
            return;
        }

        private Drawable getHighlightDrawableStatic(View r2) {
            Drawable r1 = r2.getContext().getDrawable(R.drawable.preference_highlight);
            r2.setBackground(r1);
            return r1;
        }
    }

    public static class SettingsDialogFragment extends DialogFragment {
        private static final String KEY_DIALOG_ID = "key_dialog_id";
        private static final String KEY_PARENT_FRAGMENT_ID = "key_parent_fragment_id";
        private int mDialogId;
        private DialogInterface.OnCancelListener mOnCancelListener;
        private DialogInterface.OnDismissListener mOnDismissListener;
        private Fragment mParentFragment;

        public void com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
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
            if ((r1 instanceof SettingsPreferenceFragment23) == false) goto L9;
            ((SettingsPreferenceFragment23) r1).onDialogShowing();
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
            if ((r0 instanceof SettingsPreferenceFragment23) == false) goto L18;
            SettingsPreferenceFragment23.access$302((SettingsPreferenceFragment23) r0, this);
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
            if ((r0 instanceof SettingsPreferenceFragment23) == true) goto L5;
            return;
        L5:
            if (SettingsPreferenceFragment23.access$300((SettingsPreferenceFragment23) r0) != this) goto L9;
            SettingsPreferenceFragment23.access$302((SettingsPreferenceFragment23) this.mParentFragment, null);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SettingsDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SettingsDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SettingsDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_SettingsPreferenceFragment23$SettingsDialogFragment__onResume$___twin___();
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

    @Override // com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r1) {
        return null;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    public void onDialogShowing() {
    }

    public SettingsPreferenceFragment23() {
        this.TAG = getClass().getSimpleName();
        this.mBytedanceStyle = false;
        this.mPreferenceHighlighted = false;
        this.mIsDataSetObserverRegistered = false;
        this.mDataSetObserver = new AnonymousClass1(this);
    }

    static /* synthetic */ HighlightablePreferenceGroupAdapter access$000(SettingsPreferenceFragment23 r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ SettingsDialogFragment access$300(SettingsPreferenceFragment23 r0) {
        return r0.mDialogFragment;
    }

    static /* synthetic */ SettingsDialogFragment access$302(SettingsPreferenceFragment23 r0, SettingsDialogFragment r1) {
        r0.mDialogFragment = r1;
        return r1;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L5;
        this.mPreferenceHighlighted = r2.getBoolean(SAVE_HIGHLIGHTED_KEY);
    L5:
        int r3 = getHelpResource();
        if (r3 == 0) goto L9;
        this.mHelpUri = getResources().getString(r3);
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = super.onCreateView(r1, r2, r3);
        this.mPinnedHeaderFrameLayout = (ViewGroup) r4.findViewById(R.id.pinned_header);
        this.mFloatingActionButton = (FloatingActionButton) r4.findViewById(R.id.fab);
        return r4;
    }

    public FloatingActionButton getFloatingActionButton() {
        return this.mFloatingActionButton;
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
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        if (TextUtils.isEmpty(this.mHelpUri) == true) goto L5;
        setHasOptionsMenu(true);
    L5:
        RecyclerView r3 = getListView();
        if (this.mBytedanceStyle == false) goto L10;
        if (r3 == null) goto L11;
        UIUtils.updatePadding(r3, 0, ResourceUtils.getResources().getDimensionPixelSize(R.dimen.top_gap), 0, 0);
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        unregisterObserverIfNeeded();
    }

    public void showLoadingWhenEmpty() {
        setEmptyView(getView().findViewById(R.id.loading_container));
    }

    public void registerObserverIfNeeded() {
        if (this.mIsDataSetObserverRegistered == true) goto L12;
        RecyclerView.Adapter r0 = this.mCurrentRootAdapter;
        if (r0 == null) goto L7;
        r0.unregisterAdapterDataObserver(this.mDataSetObserver);
    L7:
        RecyclerView.Adapter r1 = getListView().getAdapter();
        this.mCurrentRootAdapter = r1;
        if (r1 == null) goto L10;
        r1.registerAdapterDataObserver(this.mDataSetObserver);
    L10:
        this.mIsDataSetObserverRegistered = true;
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

    private Drawable getHighlightDrawable() {
        if (this.mHighlightDrawable != null) goto L6;
        this.mHighlightDrawable = getActivity().getDrawable(R.drawable.preference_highlight);
    L6:
        return this.mHighlightDrawable;
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

    public void setEmptyView(View r3) {
        View r0 = this.mEmptyView;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.mEmptyView = r3;
        updateEmptyView();
    }

    private void updateEmptyView() {
        if (this.mEmptyView != null) goto L5;
        return;
    L5:
        int r1 = 0;
        if (getPreferenceScreen() == null) goto L12;
        View r0 = this.mEmptyView;
        if (getPreferenceScreen().getPreferenceCount() <= 0) goto L11;
        r1 = 8;
    L11:
        r0.setVisibility(r1);
        return;
    L12:
        this.mEmptyView.setVisibility(0);
    }

    public void setBytedanceStyle(boolean r1) {
        this.mBytedanceStyle = r1;
    }

    protected void removePreference(String r1) {
        Preference r2 = findPreference(r1);
        if (r2 == null) goto L6;
        getPreferenceScreen().removePreference(r2);
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
        return getActivity().getSystemService(r1);
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

    protected boolean hasNextButton() {
        return ((ButtonBarHandler) getActivity()).hasNextButton();
    }

    protected Button getNextButton() {
        return ((ButtonBarHandler) getActivity()).getNextButton();
    }

    protected void updateNextButton(boolean r1) {
        ((ButtonBarHandler) getActivity()).updateNextButton(r1);
    }

    protected void updateBottomLine(boolean r1) {
        KeyEventDispatcher.Component r0 = getActivity();
        if (r0 == null) goto L6;
        ((ButtonBarHandler) r0).updateBottomLine(r1);
        return;
    }

    public void finish() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.onBackPressed();
        return;
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

    public void unregisterReceiver(BroadcastReceiver r2) {
        RegisterUtils.unRegisterBroadcastReceiverSafely(this.TAG, getActivity(), r2);
    }
}
