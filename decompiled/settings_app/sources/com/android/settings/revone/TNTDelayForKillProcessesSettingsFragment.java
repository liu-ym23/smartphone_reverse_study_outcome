package com.android.settings.revone;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class TNTDelayForKillProcessesSettingsFragment extends BaseFragment {
    private static final long DELAY_DEFAULT = 0;
    private static final String DELAY_FOR_KILL_PROCS = "delay_for_kill_processes";
    private static final String TAG = "DelayForKillProcessesSettingsFragment";
    private BaseAdapter mAdapter;
    private ContentResolver mContentResolver;
    private int mCurrentIndex;
    private boolean mDialogConfirmed;
    private int mLastIndex;
    private String[] mOptions;
    private ListView mOptionsList;
    private int mSelected;
    private long[] mValues;
    private AlertDialog mWarningDialog;

    private class OptionsAdapter extends BaseAdapter {
        private String[] mOptions;
        final /* synthetic */ TNTDelayForKillProcessesSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public OptionsAdapter(TNTDelayForKillProcessesSettingsFragment r1, String[] r2) {
            this.this$0 = r1;
            this.mOptions = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mOptions.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
            r3 = View.inflate(this.this$0.getActivity(), R.layout.list_content_item_check, null);
            SettingItemCheck r5 = (SettingItemCheck) r3.findViewById(R.id.item_check);
            r3.setTag(r5);
        L5:
            Utils.setItemBgStyle(r5, getCount(), r2);
            r5.setTitle(TNTDelayForKillProcessesSettingsFragment.access$900(this.this$0)[r2]);
            if (r2 != TNTDelayForKillProcessesSettingsFragment.access$100(this.this$0)) goto L8;
            boolean r1 = true;
        L9:
            r5.setChecked(r1);
            return r3;
        L8:
            r1 = false;
            goto L9
        L4:
            r5 = (SettingItemCheck) r3.getTag();
            goto L5
        }
    }

    public void com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TNTDelayForKillProcessesSettingsFragment() {
    }

    static /* synthetic */ int access$000(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mLastIndex;
    }

    static /* synthetic */ int access$002(TNTDelayForKillProcessesSettingsFragment r0, int r1) {
        r0.mLastIndex = r1;
        return r1;
    }

    static /* synthetic */ int access$100(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$102(TNTDelayForKillProcessesSettingsFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$200(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ void access$300(TNTDelayForKillProcessesSettingsFragment r0) {
        r0.showWarningDialog();
    }

    static /* synthetic */ boolean access$400(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mDialogConfirmed;
    }

    static /* synthetic */ boolean access$402(TNTDelayForKillProcessesSettingsFragment r0, boolean r1) {
        r0.mDialogConfirmed = r1;
        return r1;
    }

    static /* synthetic */ long[] access$500(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mValues;
    }

    static /* synthetic */ ContentResolver access$600(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mContentResolver;
    }

    static /* synthetic */ AlertDialog access$702(TNTDelayForKillProcessesSettingsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ int access$800(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mSelected;
    }

    static /* synthetic */ String[] access$900(TNTDelayForKillProcessesSettingsFragment r0) {
        return r0.mOptions;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.revone_delay_for_kill_processes_settings_layout, r3, false);
        this.mContentResolver = getContentResolver();
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list_defer_time);
        this.mOptions = getEntries(R.array.revone_delay_for_kill_processes_entries);
        getValues(R.array.revone_delay_for_kill_processes_values);
        this.mCurrentIndex = getCurrentIndex();
        View r5 = Utils.inflateListTransparentHeader(getActivity(), this.mOptionsList, false);
        this.mOptionsList.addHeaderView(r5);
        addFooterView();
        OptionsAdapter r6 = new OptionsAdapter(this, this.mOptions);
        this.mAdapter = r6;
        this.mOptionsList.setAdapter(r6);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        Utils.setListViewIgnoreAccessibilityItemCount(this.mOptionsList, 1);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog r0 = this.mWarningDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private String[] getEntries(int r1) {
        return this.mContext.getResources().getStringArray(r1);
    }

    private void getValues(int r5) {
        int[] r6 = this.mContext.getResources().getIntArray(r5);
        int r0 = 0;
        if (r6 != null) goto L6;
        this.mValues = new long[]{0};
        return;
    L6:
        this.mValues = new long[r6.length];
    L8:
        if (r0 >= r6.length) goto L10;
        this.mValues[r0] = r6[r0];
        r0 = r0 + 1;
        goto L8
    }

    private int getCurrentIndex() {
        this.mSelected = 0;
        long r1 = Settings.Global.getLong(this.mContentResolver, DELAY_FOR_KILL_PROCS, 0);
        OLog.d(TAG, "getCurrentIndex, time = " + r1);
        int r3 = 0;
    L3:
        long[] r4 = this.mValues;
        if (r3 >= r4.length) goto L10;
        if (r4[r3] == r1) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        this.mSelected = r3;
        return r3;
    L10:
        return 0;
    }

    private void addFooterView() {
        TextView r0 = new TextView(this.mContext);
        r0.setTextAppearance(R.style.SettingItemTipsStyle);
        r0.setText(R.string.delay_for_kill_processes_item_tips);
        this.mOptionsList.addFooterView(r0);
    }

    private void showWarningDialog() {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(TAG, "showWarningDialog, activity is null, return");
        return;
    L11:
        this.mDialogConfirmed = false;
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.delay_for_kill_processes_settings_title).setMessage(R.string.delay_for_kill_processes_dialog_content).setNegativeButton(android.R.string.cancel, null).setPositiveButton(android.R.string.ok, new AnonymousClass3(this)).setOnDismissListener(new AnonymousClass2(this)).setCancelable(false);
        AlertDialog r3 = r2.create();
        this.mWarningDialog = r3;
        r3.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TNTDelayForKillProcessesSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TNTDelayForKillProcessesSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TNTDelayForKillProcessesSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTDelayForKillProcessesSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
