package com.android.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BandMode extends LifeHookActivity2 {
    private static final String[] BAND_NAMES = null;
    private static final boolean DBG = false;
    private static final int EVENT_BAND_SCAN_COMPLETED = 100;
    private static final int EVENT_BAND_SELECTION_DONE = 200;
    private static final String LOG_TAG = "phone";
    private ListView mBandList;
    private ArrayAdapter mBandListAdapter;
    private AdapterView.OnItemClickListener mBandSelectionHandler;
    private Handler mHandler;
    private Phone mPhone;
    private DialogInterface mProgressPanel;
    private BandListItem mTargetBand;

    private static class BandListItem {
        private int mBandMode;

        public BandListItem(int r1) {
            this.mBandMode = r1;
        }

        public int getBand() {
            return this.mBandMode;
        }

        public String toString() {
            if (this.mBandMode < BandMode.access$300().length) goto L7;
            return "Band mode " + this.mBandMode;
        L7:
            return BandMode.access$300()[this.mBandMode];
        }
    }

    public void com_android_settings_BandMode__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_BandMode__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_BandMode__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_BandMode__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_BandMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_BandMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_BandMode_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_BandMode_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_BandMode_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public BandMode() {
        this.mTargetBand = null;
        this.mPhone = null;
        this.mBandSelectionHandler = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
    }

    static /* synthetic */ BandListItem access$000(BandMode r0) {
        return r0.mTargetBand;
    }

    static /* synthetic */ BandListItem access$002(BandMode r0, BandListItem r1) {
        r0.mTargetBand = r1;
        return r1;
    }

    static /* synthetic */ Handler access$100(BandMode r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Phone access$200(BandMode r0) {
        return r0.mPhone;
    }

    static /* synthetic */ String[] access$300() {
        return BAND_NAMES;
    }

    static /* synthetic */ void access$400(BandMode r0, AsyncResult r1) {
        r0.bandListLoaded(r1);
    }

    static /* synthetic */ void access$500(BandMode r0, Throwable r1) {
        r0.displayBandSelectionResult(r1);
    }

    static {
        BAND_NAMES = new String[]{"Automatic", "Europe", "United States", "Japan", "Australia", "Australia 2", "Cellular 800", "PCS", "Class 3 (JTACS)", "Class 4 (Korea-PCS)", "Class 5", "Class 6 (IMT2000)", "Class 7 (700Mhz-Upper)", "Class 8 (1800Mhz-Upper)", "Class 9 (900Mhz)", "Class 10 (800Mhz-Secondary)", "Class 11 (Europe PAMR 400Mhz)", "Class 15 (US-AWS)", "Class 16 (US-2500Mhz)"};
    }

    public void com_android_settings_BandMode__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        requestWindowFeature(5);
        setContentView(R.layout.band_mode);
        setTitle(getString(R.string.band_mode_title));
        getWindow().setLayout(-1, -2);
        this.mPhone = PhoneFactory.getDefaultPhone();
        this.mBandList = (ListView) findViewById(R.id.band);
        ArrayAdapter r4 = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        this.mBandListAdapter = r4;
        this.mBandList.setAdapter(r4);
        this.mBandList.setOnItemClickListener(this.mBandSelectionHandler);
        loadBandList();
    }

    private void loadBandList() {
        String r0 = getString(R.string.band_mode_loading);
        this.mProgressPanel = new AlertDialog.Builder(this, getResources().getInteger(R.integer.dialog_style_id)).setMessage(r0).show();
        Message r1 = this.mHandler.obtainMessage(100);
        this.mPhone.queryAvailableBandMode(r1);
    }

    private void bandListLoaded(AsyncResult r7) {
        DialogInterface r0 = this.mProgressPanel;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        clearList();
        int r1 = 0;
        if (r7.result == null) goto L16;
        int[] r8 = (int[]) r7.result;
        if (r8.length != 0) goto L11;
        Log.w("phone", "No Supported Band Modes");
        Log.wtf("phone", "No Supported Band Modes");
        return;
    L11:
        int r2 = r8[0];
        if (r2 <= 0) goto L16;
        boolean r3 = true;
        int r4 = 1;
    L14:
        if (r4 > r2) goto L17;
        this.mBandListAdapter.add(new BandListItem(r8[r4]));
        r4 = r4 + 1;
    L17:
        if (r3 == false) goto L19;
    L21:
        this.mBandList.requestFocus();
        return;
    L19:
        if (r1 >= 19) goto L21;
        this.mBandListAdapter.add(new BandListItem(r1));
        r1 = r1 + 1;
    L16:
        r3 = false;
        goto L17
    }

    private void displayBandSelectionResult(Throwable r4) {
        String r0 = getString(R.string.band_mode_set) + " [" + this.mTargetBand.toString() + "] ";
        if (r4 == null) goto L5;
        String r5 = r0 + getString(R.string.band_mode_failed);
    L6:
        this.mProgressPanel = new AlertDialog.Builder(this, getResources().getInteger(R.integer.dialog_style_id)).setMessage(r5).setPositiveButton(android.R.string.ok, null).show();
        return;
    L5:
        r5 = r0 + getString(R.string.band_mode_succeeded);
        goto L6
    }

    private void clearList() {
    L3:
        if (this.mBandListAdapter.getCount() <= 0) goto L5;
        ArrayAdapter r0 = this.mBandListAdapter;
        r0.remove(r0.getItem(0));
        goto L3
    }

    private void log(String r2) {
        Log.d("phone", "[BandsList] " + r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_BandMode_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BandMode r1) {
        com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(BandMode r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BandMode r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_BandMode__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_BatchedActivityLancet_onResume(BandMode r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_BandMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(BandMode r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        BandMode r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(BandMode r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_BandMode__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_BatchedActivityLancet_onStop(BandMode r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_BandMode_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onResume(BandMode r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BandMode r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_BandMode__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(BandMode r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onPause(BandMode r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BandMode r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_BandMode__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(BandMode r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        BandMode r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_BandMode_com_obric_hook_lancet_PrivacyHookActivity2_onStop(BandMode r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BandMode r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_BandMode__onStop$___twin___();
    }
}
