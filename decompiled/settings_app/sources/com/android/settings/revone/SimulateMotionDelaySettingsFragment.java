package com.android.settings.revone;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.SimulateMotionDelaySubTestView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.editor.SimpleEditor;

/* JADX INFO: loaded from: classes2.dex */
public class SimulateMotionDelaySettingsFragment extends BaseFragment {
    private static final int DEFAULT_RANDOM_DEFER_INPUT = 1;
    private static final int DEFAULT_RUNNING_TEST = -1;
    private static final int MAX_SUB_TEST_COUNT = 5;
    private static final int MAX_SUB_TEST_COUNT_LESS = 4;
    private static final String MOTION_DELAY_TEST_COMMIT_COUNT = "motion_delay_test_commit_count";
    private static final String TAG = "SmdSettingsFragment";
    private static final String TIME_MIN_MAX_DEFER_INPUT = "time_min_max_defer_input";
    public static int USER_NAME_MAX_LENGTH = 16;
    private Button mBtnCommit;
    private Button mBtnStartTest;
    private int mCommitCount;
    private AlertDialog mCompleteDialog;
    private LinearLayout mContentContainer;
    private ContentResolver mContentResolver;
    private int mCurrentTest;
    private boolean mDialogConfirmed;
    private boolean mIsLessTest;
    private int[] mLessTestIndex;
    private ScrollView mMainScrollView;
    private int[] mMaxDelay;
    private int[] mMinDelay;
    private int[] mMoreTestIndex;
    private ResultInfo[] mResultList;
    private AlertDialog mRetestDialog;
    private List<SimulateMotionDelaySubTestView> mSubTestList;
    private SimulateMotionDelaySubTestView.onSubTestViewListener mSubTestViewListener;
    private int mTestCount;
    private boolean mTestStarted;
    private String mUserName;
    private AlertDialog mWarningDialog;

    private class ResultInfo {
        private String mBadCaseResult;
        private int mFeelResult;
        private int mIndex;
        private int mInputTimes;
        final /* synthetic */ SimulateMotionDelaySettingsFragment this$0;

        static /* synthetic */ int access$2900(ResultInfo r0) {
            return r0.mFeelResult;
        }

        static /* synthetic */ String access$3000(ResultInfo r0) {
            return r0.mBadCaseResult;
        }

        static /* synthetic */ int access$3100(ResultInfo r0) {
            return r0.mInputTimes;
        }

        ResultInfo(SimulateMotionDelaySettingsFragment r1, int r2) {
            this.this$0 = r1;
            this.mIndex = r2 + 1;
            this.mFeelResult = 0;
            this.mBadCaseResult = "";
            this.mInputTimes = 0;
        }

        ResultInfo(SimulateMotionDelaySettingsFragment r1, int r2, int r3, String r4, int r5) {
            this.this$0 = r1;
            this.mIndex = r2 + 1;
            this.mFeelResult = r3;
            this.mBadCaseResult = r4;
            this.mInputTimes = r5;
        }

        public String toString() {
            return "ResultInfo: index : " + this.mIndex + ", feel : " + this.mFeelResult + ", badCase : " + this.mBadCaseResult + ", input times : " + this.mInputTimes;
        }
    }

    static {
    }

    public void com_android_settings_revone_SimulateMotionDelaySettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_SimulateMotionDelaySettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_SimulateMotionDelaySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_SimulateMotionDelaySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SimulateMotionDelaySettingsFragment() {
        this.mDialogConfirmed = false;
        this.mTestStarted = false;
        this.mCurrentTest = -1;
        this.mTestCount = 0;
        this.mUserName = "";
        this.mIsLessTest = false;
        this.mLessTestIndex = new int[]{2, 1, 0, 3};
        this.mMoreTestIndex = new int[]{2, 3, 4, 1, 0};
        this.mMinDelay = new int[]{30, 50, 70, 90, 100};
        this.mMaxDelay = new int[]{40, 60, 80, 100, 120};
        this.mSubTestViewListener = new AnonymousClass1(this);
    }

    static /* synthetic */ boolean access$000(SimulateMotionDelaySettingsFragment r0) {
        return r0.mIsLessTest;
    }

    static /* synthetic */ boolean access$002(SimulateMotionDelaySettingsFragment r0, boolean r1) {
        r0.mIsLessTest = r1;
        return r1;
    }

    static /* synthetic */ void access$100(SimulateMotionDelaySettingsFragment r0) {
        r0.showCommitView();
    }

    static /* synthetic */ void access$1000(SimulateMotionDelaySettingsFragment r0) {
        r0.stopCurrentTest();
    }

    static /* synthetic */ void access$1100(SimulateMotionDelaySettingsFragment r0, int r1) {
        r0.setMotionDelay(r1);
    }

    static /* synthetic */ ScrollView access$1200(SimulateMotionDelaySettingsFragment r0) {
        return r0.mMainScrollView;
    }

    static /* synthetic */ Button access$1300(SimulateMotionDelaySettingsFragment r0) {
        return r0.mBtnStartTest;
    }

    static /* synthetic */ boolean access$1402(SimulateMotionDelaySettingsFragment r0, boolean r1) {
        r0.mTestStarted = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1500(SimulateMotionDelaySettingsFragment r0) {
        return r0.mDialogConfirmed;
    }

    static /* synthetic */ boolean access$1502(SimulateMotionDelaySettingsFragment r0, boolean r1) {
        r0.mDialogConfirmed = r1;
        return r1;
    }

    static /* synthetic */ AlertDialog access$1602(SimulateMotionDelaySettingsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ Button access$1700(SimulateMotionDelaySettingsFragment r0) {
        return r0.mBtnCommit;
    }

    static /* synthetic */ String access$1800(SimulateMotionDelaySettingsFragment r0) {
        return r0.mUserName;
    }

    static /* synthetic */ String access$1802(SimulateMotionDelaySettingsFragment r0, String r1) {
        r0.mUserName = r1;
        return r1;
    }

    static /* synthetic */ void access$1900(SimulateMotionDelaySettingsFragment r0) {
        r0.showCompleteDialog();
    }

    static /* synthetic */ void access$200(SimulateMotionDelaySettingsFragment r0) {
        r0.scrollViewToBottom();
    }

    static /* synthetic */ void access$2000(SimulateMotionDelaySettingsFragment r0) {
        r0.resetMotionDelay();
    }

    static /* synthetic */ int access$2100(SimulateMotionDelaySettingsFragment r0) {
        return r0.mCommitCount;
    }

    static /* synthetic */ int access$2108(SimulateMotionDelaySettingsFragment r2) {
        int r0 = r2.mCommitCount;
        r2.mCommitCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ SharedPreferences access$2200(SimulateMotionDelaySettingsFragment r0, String r1, int r2) {
        return r0.getSharedPreferences(r1, r2);
    }

    static /* synthetic */ void access$2300(SimulateMotionDelaySettingsFragment r0) {
        r0.commitAllMessage();
    }

    static /* synthetic */ AlertDialog access$2402(SimulateMotionDelaySettingsFragment r0, AlertDialog r1) {
        r0.mCompleteDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$2500(SimulateMotionDelaySettingsFragment r0) {
        r0.showRetestDialog();
    }

    static /* synthetic */ AlertDialog access$2602(SimulateMotionDelaySettingsFragment r0, AlertDialog r1) {
        r0.mRetestDialog = r1;
        return r1;
    }

    static /* synthetic */ LinearLayout access$2700(SimulateMotionDelaySettingsFragment r0) {
        return r0.mContentContainer;
    }

    static /* synthetic */ void access$2800(SimulateMotionDelaySettingsFragment r0) {
        r0.initViews();
    }

    static /* synthetic */ int access$300(SimulateMotionDelaySettingsFragment r0) {
        return r0.mTestCount;
    }

    static /* synthetic */ int access$302(SimulateMotionDelaySettingsFragment r0, int r1) {
        r0.mTestCount = r1;
        return r1;
    }

    static /* synthetic */ int access$400(SimulateMotionDelaySettingsFragment r0, int r1) {
        return r0.getNextTestIndex(r1);
    }

    static /* synthetic */ void access$500(SimulateMotionDelaySettingsFragment r0, boolean r1, int r2) {
        r0.addNewSubTest(r1, r2);
    }

    static /* synthetic */ ResultInfo[] access$600(SimulateMotionDelaySettingsFragment r0) {
        return r0.mResultList;
    }

    static /* synthetic */ void access$700(SimulateMotionDelaySettingsFragment r0) {
        r0.printAllResult();
    }

    static /* synthetic */ int access$800(SimulateMotionDelaySettingsFragment r0) {
        return r0.mCurrentTest;
    }

    static /* synthetic */ int access$802(SimulateMotionDelaySettingsFragment r0, int r1) {
        r0.mCurrentTest = r1;
        return r1;
    }

    static /* synthetic */ List access$900(SimulateMotionDelaySettingsFragment r0) {
        return r0.mSubTestList;
    }

    private void scrollViewToBottom() {
        this.mMainScrollView.postDelayed(new AnonymousClass2(this), 10);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        OLog.e(TAG, "onCreateView");
        this.mRootView = r2.inflate(R.layout.revone_simulate_motion_delay_settings_layout, r3, false);
        this.mContentResolver = getContentResolver();
        resetMotionDelay();
        this.mCommitCount = getSharedPreferences("development", 0).getInt(MOTION_DELAY_TEST_COMMIT_COUNT, 0);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        OLog.e(TAG, "onViewCreated");
        super.onViewCreated(r3, r4);
        initViews();
    }

    private void initViews() {
        OLog.e(TAG, "Init views.");
        this.mMainScrollView = (ScrollView) findViewByIdNullable(R.id.page_scrollview);
        this.mContentContainer = (LinearLayout) findViewByIdNullable(R.id.main_content_container);
        this.mSubTestList = new ArrayList();
        this.mResultList = new ResultInfo[5];
        Button r0 = (Button) findViewByIdNullable(R.id.btn_start_test);
        this.mBtnStartTest = r0;
        r0.setVisibility(0);
        this.mBtnStartTest.setOnClickListener(new AnonymousClass3(this));
    }

    private void addNewSubTest(boolean r12, int r13) {
        OLog.e(TAG, "Add new subTest, testIndex = " + r13 + ", should start : " + r12 + ", current test count :" + this.mTestCount);
        if (this.mIsLessTest == false) goto L5;
        int r0 = 4;
    L7:
        if (this.mTestCount >= r0) goto L17;
        SimulateMotionDelaySubTestView r1 = (SimulateMotionDelaySubTestView) requireActivity().getLayoutInflater().inflate(R.layout.revone_simulate_motion_delay_sub_test_view, this.mContentContainer, false);
        int r6 = this.mTestCount;
        SimulateMotionDelaySubTestView.onSubTestViewListener r8 = this.mSubTestViewListener;
        if ((r6 + 1) != r0) goto L11;
        boolean r10 = true;
    L12:
        r1.initViews(r6, r13, r8, r12, r10);
        this.mSubTestList.add(r1);
        this.mContentContainer.addView(r1);
        if (r12 == false) goto L15;
        this.mCurrentTest = this.mTestCount;
        r1.startSubTest();
        setMotionDelay(r13);
    L15:
        this.mTestCount++;
        return;
    L11:
        r10 = false;
        goto L12
    L17:
        return;
    L5:
        r0 = 5;
        goto L7
    }

    private int getNextTestIndex(int r2) {
        if (this.mIsLessTest == false) goto L7;
        return this.mLessTestIndex[r2 + 1];
    L7:
        return this.mMoreTestIndex[r2 + 1];
    }

    private void setMotionDelay(int r3) {
        String r4 = this.mMinDelay[r3] + ":" + this.mMaxDelay[r3] + ":1";
        OLog.e(TAG, "setMotionDelay value: " + r4);
        Settings.Global.putString(this.mContentResolver, TIME_MIN_MAX_DEFER_INPUT, r4);
    }

    private void resetMotionDelay() {
        Settings.Global.putString(this.mContentResolver, TIME_MIN_MAX_DEFER_INPUT, "0:0:0");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        OLog.e(TAG, "onDestroy");
        super.onDestroy();
        stopCurrentTest();
        resetMotionDelay();
    }

    private void stopCurrentTest() {
        if (this.mCurrentTest >= this.mSubTestList.size()) goto L10;
        int r0 = this.mCurrentTest;
        if (r0 <= (-1)) goto L11;
        SimulateMotionDelaySubTestView r2 = this.mSubTestList.get(r0);
        if (r2 == null) goto L12;
        r2.stopTest();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        if (shouldFinish() == true) goto L5;
        showWarningDialog(false);
        return true;
    L5:
        return super.onBackPressedSupport();
    }

    public boolean shouldFinish() {
        OLog.e(TAG, "Should finish now? mDialogConfirmed = " + this.mDialogConfirmed + ", mTestStarted = " + this.mTestStarted);
        if (this.mDialogConfirmed == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mTestStarted == false) goto L8;
        return false;
    }

    public void showWarningDialog(final boolean r6) {
        OLog.e(TAG, "Show warningDialog.");
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L8:
        final FragmentActivity r1 = getActivity();
        if (r1 != null) goto L12;
        OLog.e(TAG, "showWarningDialog, activity is null, return");
        return;
    L12:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.motion_delay_settings_title).setMessage(R.string.motion_delay_settings_exit_dialog).setNegativeButton(android.R.string.cancel, null).setPositiveButton(android.R.string.ok, new AnonymousClass5(this)).setOnDismissListener(new AnonymousClass4(this, r6, r1)).setCancelable(false);
        AlertDialog r7 = r2.create();
        this.mWarningDialog = r7;
        r7.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L8;
        OLog.e(TAG, "WarningDialog is showing.");
    }

    private void showCommitView() {
        OLog.e(TAG, "Show commitView.");
        View r0 = requireActivity().getLayoutInflater().inflate(R.layout.revone_simulate_motion_delay_commit_view, this.mContentContainer, false);
        this.mContentContainer.addView(r0);
        final SimpleEditor r1 = (SimpleEditor) r0.findViewById(R.id.commit_edit);
        r1.getEditText().setFilters(new InputFilter[]{new Utf8ByteLengthFilter(USER_NAME_MAX_LENGTH)});
        if (TextUtils.isEmpty(this.mUserName) == true) goto L5;
        r1.getEditText().setText(this.mUserName);
    L5:
        r1.getEditText().addTextChangedListener(new AnonymousClass6(this));
        Button r2 = (Button) NullSafe.nonNull(r0.findViewById(R.id.btn_commit));
        this.mBtnCommit = r2;
        r2.setEnabled(!TextUtils.isEmpty(this.mUserName));
        this.mBtnCommit.setOnClickListener(new AnonymousClass7(this, r1));
    }

    private void showCompleteDialog() {
        OLog.e(TAG, "Show completeDialog.");
        AlertDialog r0 = this.mCompleteDialog;
        if (r0 != null) goto L5;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(TAG, "showCompleteDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.motion_delay_complete_dialog_title).setMessage(R.string.motion_delay_complete_dialog_message).setNegativeButton(R.string.done, null).setPositiveButton(R.string.motion_delay_retest_dialog_title, new AnonymousClass9(this)).setOnDismissListener(new AnonymousClass8(this));
        AlertDialog r3 = r2.create();
        this.mCompleteDialog = r3;
        r3.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void showRetestDialog() {
        OLog.e(TAG, "Show retestDialog.");
        AlertDialog r0 = this.mRetestDialog;
        if (r0 != null) goto L5;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(TAG, "showRetestDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.motion_delay_retest_dialog_title).setMessage(R.string.motion_delay_retest_dialog_message).setNegativeButton(android.R.string.cancel, null).setPositiveButton(R.string.motion_delay_retest_dialog_title, new AnonymousClass11(this)).setOnDismissListener(new AnonymousClass10(this)).setCancelable(false);
        AlertDialog r3 = r2.create();
        this.mRetestDialog = r3;
        r3.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    public static String getImei(Context r2) {
        String r3 = Utils.getDeviceIMEI();
        OLog.w(TAG, "getDeviceId imei= " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L6:
        return "000000000000000";
    L5:
        if (Pattern.matches("0+", r3) == true) goto L6;
        return r3;
    }

    private void printAllResult() {
        String r0 = "IMEI = " + getImei(this.mContext) + "， userName = " + this.mUserName + "\n";
        int r2 = 0;
    L3:
        ResultInfo[] r3 = this.mResultList;
        if (r2 >= r3.length) goto L10;
        if (r3[r2] == null) goto L8;
        r0 = r0 + this.mResultList[r2].toString() + "\n";
    L9:
        r2 = r2 + 1;
        goto L3
    L8:
        r0 = r0 + new ResultInfo(this, r2).toString() + "\n";
        goto L9
    L10:
        OLog.e(TAG, r0 + "commit count = " + this.mCommitCount);
    }

    private void commitAllMessage() {
        if (this.mResultList.length != 0) goto L5;
        return;
    L5:
        AsyncTask.execute(new AnonymousClass12(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_SimulateMotionDelaySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SimulateMotionDelaySettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_SimulateMotionDelaySettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_SimulateMotionDelaySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SimulateMotionDelaySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_SimulateMotionDelaySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_SimulateMotionDelaySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SimulateMotionDelaySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_SimulateMotionDelaySettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
