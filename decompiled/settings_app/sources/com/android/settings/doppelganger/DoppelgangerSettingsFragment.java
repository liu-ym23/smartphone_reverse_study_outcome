package com.android.settings.doppelganger;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.StatusDialogUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DoppelgangerSettingsFragment extends BaseFragment {
    public static final boolean DEBUG = false;
    private static final int DOUBLE_APP_FLAG = 10;
    static final String ENABLED_APP_DOPPELGANGER = "enabled_app_doppelganger";
    private static final int SHOW_CREATE_DIALOG = 10;
    private static final int SHOW_LOADING_VIEW = 11;
    private static final String TAG = "DoppelgangerManagerFragment";
    private static final int VERIFY_PASSWORD = 1;
    private boolean isBytedanceLauncher;
    private View mCloseContainer;
    private LinearLayout mCloseListContainer;
    private Pair<ApplicationsState.AppEntry, Boolean> mCurSelected;
    private CompoundButton mCurrentSelectButton;
    private DataLoader mDataLoader;
    private OAlertDialog mDisableDialog;
    private View mDoppelDescView;
    private Set<String> mDoppelgangerApps;
    private DoppelgangerManagerHelper mDoppelgangerHelper;
    private OAlertDialog mEnableDialog;
    private Handler mHandler;
    private CompoundButton.OnCheckedChangeListener mListener;
    private View mLoaderView;
    private View mOpenContainer;
    private LinearLayout mOpenListContainer;
    private Dialog mProgressDialog;
    private OToast mToast;
    private List<ApplicationsState.AppEntry> mTotalEntries;
    private Set<String> recommendApp;

    /* JADX INFO: renamed from: com.android.settings.doppelganger.DoppelgangerSettingsFragment$2, reason: invalid class name */
    class AnonymousClass2 implements DoppelgangerManagerHelper.DoppelgangerListener {
        final /* synthetic */ DoppelgangerSettingsFragment this$0;

        AnonymousClass2(DoppelgangerSettingsFragment r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settings.doppelganger.DoppelgangerManagerHelper.DoppelgangerListener
        public void onDoppelgangerApp(final String r3, final int r4) {
            if (DoppelgangerSettingsFragment.access$200(this.this$0, r3) == true) goto L5;
            return;
        L5:
            this.this$0.requireActivity().runOnUiThread(new AnonymousClass1(this, r3, r4));
        }
    }

    private class DataLoader implements ApplicationsState.Callbacks {
        private boolean mResumed;
        private final ApplicationsState.Session mSession;
        final /* synthetic */ DoppelgangerSettingsFragment this$0;

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r1) {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
        }

        static /* synthetic */ ApplicationsState.Session access$1400(DataLoader r0) {
            return r0.mSession;
        }

        public DataLoader(DoppelgangerSettingsFragment r1, ApplicationsState r2) {
            this.this$0 = r1;
            this.mSession = r2.newSession(this);
        }

        public void resume() {
            if (this.mResumed == true) goto L5;
            this.mResumed = true;
            this.mSession.resume(false);
        L5:
            rebuild();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.doppelganger.DoppelgangerSettingsFragment$DataLoader$1] */
        private void rebuild() {
            new AnonymousClass1(this).execute(new Void[0]);
        }

        public void pause() {
            if (this.mResumed == false) goto L6;
            this.mResumed = false;
            this.mSession.pause();
            return;
        }

        public void destory() {
            ApplicationsState.Session r0 = this.mSession;
            if (r0 == null) goto L6;
            r0.release();
            return;
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            rebuild();
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r4) {
            if (r4 == null) goto L8;
            OLog.i(DoppelgangerSettingsFragment.TAG, "onRebuildComplete apps.size() == " + r4.size());
            if (r4.size() <= 0) goto L6;
            this.this$0.findViewByIdNullable(R.id.empty_view).setVisibility(8);
        L6:
            DoppelgangerSettingsFragment.access$100(this.this$0).setVisibility(8);
            DoppelgangerSettingsFragment.access$1502(this.this$0, r4);
            this.this$0.notifyDoppelgangerDataChanged();
            return;
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
            this.this$0.notifyDoppelgangerDataChanged();
        }
    }

    public void com_android_settings_doppelganger_DoppelgangerSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_doppelganger_DoppelgangerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_doppelganger_DoppelgangerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DoppelgangerSettingsFragment() {
        this.mTotalEntries = new ArrayList();
        this.isBytedanceLauncher = false;
        this.mHandler = new AnonymousClass1(this);
        this.mListener = new AnonymousClass7(this);
    }

    static /* synthetic */ void access$000(DoppelgangerSettingsFragment r0, boolean r1) {
        r0.showProgressDialog(r1);
    }

    static /* synthetic */ View access$100(DoppelgangerSettingsFragment r0) {
        return r0.mLoaderView;
    }

    static /* synthetic */ void access$1000(DoppelgangerSettingsFragment r0, String r1, int r2) {
        r0.showToast(r1, r2);
    }

    static /* synthetic */ DoppelgangerManagerHelper access$1100(DoppelgangerSettingsFragment r0) {
        return r0.mDoppelgangerHelper;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$1200(DoppelgangerSettingsFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ Set access$1300(DoppelgangerSettingsFragment r0) {
        return r0.recommendApp;
    }

    static /* synthetic */ List access$1500(DoppelgangerSettingsFragment r0) {
        return r0.mTotalEntries;
    }

    static /* synthetic */ List access$1502(DoppelgangerSettingsFragment r0, List r1) {
        r0.mTotalEntries = r1;
        return r1;
    }

    static /* synthetic */ void access$1600(DoppelgangerSettingsFragment r0, ApplicationsState.AppEntry r1, CompoundButton r2) {
        r0.showEnableDialog(r1, r2);
    }

    static /* synthetic */ void access$1700(DoppelgangerSettingsFragment r0, ApplicationsState.AppEntry r1, CompoundButton r2) {
        r0.showDisableDialog(r1, r2);
    }

    static /* synthetic */ boolean access$200(DoppelgangerSettingsFragment r0, String r1) {
        return r0.isInWhiteList(r1);
    }

    static /* synthetic */ Handler access$300(DoppelgangerSettingsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Dialog access$400(DoppelgangerSettingsFragment r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ Dialog access$402(DoppelgangerSettingsFragment r0, Dialog r1) {
        r0.mProgressDialog = r1;
        return r1;
    }

    static /* synthetic */ OAlertDialog access$500(DoppelgangerSettingsFragment r0) {
        return r0.mDisableDialog;
    }

    static /* synthetic */ OAlertDialog access$502(DoppelgangerSettingsFragment r0, OAlertDialog r1) {
        r0.mDisableDialog = r1;
        return r1;
    }

    static /* synthetic */ OAlertDialog access$600(DoppelgangerSettingsFragment r0) {
        return r0.mEnableDialog;
    }

    static /* synthetic */ OAlertDialog access$602(DoppelgangerSettingsFragment r0, OAlertDialog r1) {
        r0.mEnableDialog = r1;
        return r1;
    }

    static /* synthetic */ Set access$700(DoppelgangerSettingsFragment r0) {
        return r0.mDoppelgangerApps;
    }

    static /* synthetic */ Set access$702(DoppelgangerSettingsFragment r0, Set r1) {
        r0.mDoppelgangerApps = r1;
        return r1;
    }

    static /* synthetic */ Pair access$800(DoppelgangerSettingsFragment r0) {
        return r0.mCurSelected;
    }

    static /* synthetic */ Pair access$802(DoppelgangerSettingsFragment r0, Pair r1) {
        r0.mCurSelected = r1;
        return r1;
    }

    static /* synthetic */ CompoundButton access$902(DoppelgangerSettingsFragment r0, CompoundButton r1) {
        r0.mCurrentSelectButton = r1;
        return r1;
    }

    static {
        DEBUG = Build.IS_USERDEBUG;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.doppelganger_layout, r4, false);
        this.mOpenContainer = findViewByIdNullable(R.id.open_container);
        this.mOpenListContainer = (LinearLayout) findViewByIdNullable(R.id.open_list_container);
        this.mCloseContainer = findViewByIdNullable(R.id.close_container);
        this.mDoppelDescView = findViewByIdNullable(R.id.doppelganger_desc);
        this.mCloseListContainer = (LinearLayout) findViewByIdNullable(R.id.close_list_container);
        this.mDataLoader = new DataLoader(this, ApplicationsState.getInstance(requireActivity().getApplication(), false));
        this.mLoaderView = findViewByIdNullable(R.id.loading_container);
        this.mDoppelgangerHelper = new DoppelgangerManagerHelper(this.mContext, new AnonymousClass2(this));
        String[] r6 = Utils.getDoppelgangerAppArray(this.mContext);
        HashSet r7 = new HashSet(r6.length);
        this.recommendApp = r7;
        Collections.addAll(r7, r6);
        OLog.i(TAG, "recommendApp.size: " + this.recommendApp.size());
        this.mHandler.sendEmptyMessageDelayed(11, 250);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) this.mRootView.findViewById(R.id.page_container));
        return this.mRootView;
    }

    private void showToast(String r7, int r8) {
        OLog.d(TAG, "showToast1: " + r8);
        if (r8 != 0) goto L5;
        String r3 = getString(R.string.doppelganger_error);
    L21:
        OToast r9 = this.mToast;
        if (r9 == null) goto L24;
        r9.cancel();
    L24:
        this.mToast = ToastUtils.show(this._mActivity, r3);
        OLog.d(TAG, "showToast2: " + r8);
        return;
    L5:
        if (r8 == 1) goto L17;
        r3 = "";
        if (r8 != 2) goto L21;
        Iterator<ApplicationsState.AppEntry> r2 = this.mTotalEntries.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        ApplicationsState.AppEntry r4 = r2.next();
        if (r4.info.packageName.equals(r7) == false) goto L11;
        r3 = r4.label;
        goto L11
    L15:
        r3 = getString(R.string.disable_app_doppelganger_success_toast, new Object[]{r3});
        goto L21
    L17:
        if (this.isBytedanceLauncher == false) goto L19;
        r3 = getString(R.string.enable_app_doppelganger_success_toast);
        goto L21
    L19:
        r3 = getString(R.string.enable_app_doppelganger_success_not_bytedance_launcher_toast);
        goto L21
    }

    private void showProgressDialog(boolean r5) {
        OLog.i(TAG, "showProgressDialog enable: " + r5);
        if (isAdded() == true) goto L5;
        return;
    L5:
        Activity r0 = this._mActivity;
        if (r5 == false) goto L8;
        int r2 = R.string.enable_app_doppelganger_dlg_msg;
    L9:
        StatusDialog r1 = StatusDialogUtils.createStatusDialog(r0, getString(r2), "");
        this.mProgressDialog = r1;
        r1.show();
        this.mProgressDialog.setCancelable(false);
        OLog.i(TAG, "showProgressDialog enable3: " + r5);
        return;
    L8:
        r2 = R.string.disable_app_doppelganger_dlg_msg;
        goto L9
    }

    private void showDisableDialog(ApplicationsState.AppEntry r8, final CompoundButton r9) {
        final boolean[] r1 = {false};
        DialogInterface.OnClickListener r3 = new AnonymousClass3(this, r1, r9);
        OAlertDialog r10 = new OAlertDialogBuilder(requireActivity()).horizontalButton().title(R.string.disable_app_doppelganger_dlg_title).message(getString(R.string.disable_app_doppelganger_dlg_message, new Object[]{r8.label, r8.label})).positiveButton(getString(R.string.okay), r3).negativeButton(R.string.cancel, r3).build();
        this.mDisableDialog = r10;
        r10.show();
        this.mDisableDialog.setOnDismissListener(new AnonymousClass4(this, r1, r9));
    }

    private void showEnableDialog(final ApplicationsState.AppEntry r4, final CompoundButton r5) {
        final boolean[] r0 = {false};
        DialogInterface.OnClickListener r1 = new AnonymousClass5(this, r0, r4, r5);
        OAlertDialog r6 = new OAlertDialogBuilder(requireActivity()).horizontalButton().title(R.string.dlg_title_notice).message(getString(R.string.enable_app_doppelganger_dlg_message)).positiveButton(getString(R.string.okay), r1).negativeButton(R.string.cancel, r1).build();
        this.mEnableDialog = r6;
        r6.show();
        this.mEnableDialog.setOnDismissListener(new AnonymousClass6(this, r0, r5));
    }

    public void com_android_settings_doppelganger_DoppelgangerSettingsFragment__onResume$___twin___() {
        super.onResume();
        if (Utils.isThirdPartHome(this.mContext) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.isBytedanceLauncher = r0;
        this.mDataLoader.resume();
        return;
    L5:
        if (Utils.isBytedanceLauncher(this.mContext) == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mDataLoader.pause();
        OAlertDialog r0 = this.mDisableDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r1 = this.mEnableDialog;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isShowing() == false) goto L14;
        this.mEnableDialog.dismiss();
        return;
    L14:
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDisableDialog.dismiss();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 1) goto L5;
        return;
    L5:
        if (r2 == RESULT_OK) goto L7;
        this.mCurSelected = null;
        this.mCurrentSelectButton = null;
        return;
    L7:
        if (this.mCurSelected.first == null) goto L12;
        showDisableDialog((ApplicationsState.AppEntry) this.mCurSelected.first, this.mCurrentSelectButton);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mDoppelgangerHelper.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        DataLoader r0 = this.mDataLoader;
        if (r0 == null) goto L5;
        r0.destory();
    L5:
        super.onDestroyView();
    }

    private List<ApplicationsState.AppEntry> filterDatas(boolean r6) {
        List<ApplicationsState.AppEntry> r0 = this.mTotalEntries;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() < 1) goto L34;
        ArrayList r1 = new ArrayList();
        Iterator<ApplicationsState.AppEntry> r2 = this.mTotalEntries.iterator();
    L9:
        if (r2.hasNext() == false) goto L21;
        ApplicationsState.AppEntry r3 = r2.next();
        if (r6 == true) goto L13;
    L14:
        if (r6 == true) goto L9;
        if (this.mDoppelgangerApps.contains(r3.info.packageName) == true) goto L9;
    L18:
        if (UserHandle.getUserId(r3.info.uid) == 10) goto L9;
        r1.add(r3);
        goto L9
    L13:
        if (this.mDoppelgangerApps.contains(r3.info.packageName) == true) goto L18;
    L21:
        return r1;
    L34:
        return null;
    }

    private boolean isInWhiteList(String r2) {
        if (r2 == null) goto L10;
        Set<String> r0 = this.recommendApp;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.isEmpty() == false) goto L9;
        return false;
    L9:
        return this.recommendApp.contains(r2);
    L10:
        return false;
    }

    public void notifyDoppelgangerDataChanged() {
        OLog.i(TAG, "notifyDoppelgangerDataChanged");
        List<ApplicationsState.AppEntry> r1 = filterDatas(false);
        if (r1 != null) goto L5;
    L7:
        this.mCloseContainer.setVisibility(8);
        boolean r2 = true;
    L8:
        List<ApplicationsState.AppEntry> r3 = filterDatas(true);
        if (r3 != null) goto L11;
    L13:
        this.mOpenContainer.setVisibility(8);
    L14:
        if (r2 == false) goto L16;
        this.mDoppelDescView.setVisibility(8);
        return;
    L16:
        this.mDoppelDescView.setVisibility(0);
        return;
    L11:
        if (r3.size() <= 0) goto L13;
        this.mOpenContainer.setVisibility(0);
        showDoppelgangerItems(this.mOpenListContainer, r3);
        r2 = false;
        goto L14
    L5:
        if (r1.size() <= 0) goto L7;
        this.mCloseContainer.setVisibility(0);
        showDoppelgangerItems(this.mCloseListContainer, r1);
        r2 = false;
        goto L8
    }

    private void showDoppelgangerItems(LinearLayout r10, List<ApplicationsState.AppEntry> r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.removeAllViews();
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.size() < 1) goto L36;
        r11.size();
        OCardListItem r0 = null;
        OCardListItem r3 = null;
        int r4 = 0;
    L11:
        if (r4 >= r11.size()) goto L27;
        ApplicationsState.AppEntry r1 = r11.get(r4);
        OCardListItem r5 = new OCardListItem(this.mContext);
        r5.setDefaultCustomEndView(1);
        if (r1.icon == null) goto L23;
        r5.showDivider(false);
        r5.setAppIcon(r1.icon);
        r5.showIcon(true);
        r5.showCustomEnd(true);
        r5.setTitle(r1.mLabelEntry.label);
        View r6 = r5.getCustomEndView();
        if ((r6 instanceof OSwitch) == false) goto L23;
        r6.setTag(r1);
        Pair<ApplicationsState.AppEntry, Boolean> r7 = this.mCurSelected;
        if (r7 != null) goto L19;
    L21:
        r6.setEnabled(true);
        ((OSwitch) r6).setChecked(this.mDoppelgangerApps.contains(r1.info.packageName));
    L22:
        ((OSwitch) r6).setOnCheckedChangeListener(this.mListener);
        goto L23
    L19:
        if (r7.first != r1) goto L21;
        r6.setEnabled(false);
        ((OSwitch) r6).setChecked(((Boolean) this.mCurSelected.second).booleanValue());
    L23:
        r10.addView(r5);
        r5.setCardPosition(2);
        if (r3 != null) goto L26;
        r3 = r5;
    L26:
        r4 = r4 + 1;
        r0 = r5;
        goto L11
    L27:
        if (r0 != r3) goto L30;
        r3.setCardPosition(0);
        return;
    L30:
        r3.setCardPosition(1);
        r0.setCardPosition(3);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean dispatchTouchEvent(MotionEvent r1) {
        if (this.mCurSelected == null) goto L6;
        return true;
    L6:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_doppelganger_DoppelgangerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DoppelgangerSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_doppelganger_DoppelgangerSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_doppelganger_DoppelgangerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DoppelgangerSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_doppelganger_DoppelgangerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_doppelganger_DoppelgangerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DoppelgangerSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_doppelganger_DoppelgangerSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
