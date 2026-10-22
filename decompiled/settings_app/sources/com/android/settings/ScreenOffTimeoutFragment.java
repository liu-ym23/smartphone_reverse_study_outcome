package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenOffTimeoutFragment extends BaseFragment {
    private static final String TAG = "ScreenOffTimeoutFragment";
    private static final int UPDATE_DAILY_TIME = 100;
    private BaseAdapter mAdapter;
    private int mCurrentIndex;
    protected Handler mHandler;
    private float mOptionTitleMaxWidth;
    private String[] mOptions;
    private ListView mOptionsList;
    private ContentObserver mRevoneScreenOffTimeOut;
    private OCardListItem mStayAwake;
    private String[] mValues;

    /* JADX INFO: renamed from: com.android.settings.ScreenOffTimeoutFragment$2, reason: invalid class name */
    class AnonymousClass2 extends ContentObserver {
        final /* synthetic */ ScreenOffTimeoutFragment this$0;

        AnonymousClass2(ScreenOffTimeoutFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            this.this$0.mHandler.postDelayed(new ScreenOffTimeoutFragment$2$$ExternalSyntheticLambda0(this), 100);
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-android-settings-ScreenOffTimeoutFragment$2, reason: not valid java name */
        /* synthetic */ void m199xc527acf0() {
            ScreenOffTimeoutFragment r0 = this.this$0;
            ScreenOffTimeoutFragment.access$202(r0, ScreenOffTimeoutFragment.access$500(r0));
            ScreenOffTimeoutFragment.access$400(this.this$0).notifyDataSetChanged();
        }
    }

    private class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ ScreenOffTimeoutFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private OptionsAdapter(ScreenOffTimeoutFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OptionsAdapter(ScreenOffTimeoutFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScreenOffTimeoutFragment.access$100(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            r5 = View.inflate(this.this$0.getActivity(), R.layout.card_list_item_check_oui, null);
            OCardListItem r7 = (OCardListItem) r5.findViewById(R.id.item_check);
            r5.setTag(r7);
        L5:
            r7.setTitle(ScreenOffTimeoutFragment.access$100(this.this$0)[r4]);
            if (r4 != ScreenOffTimeoutFragment.access$200(this.this$0)) goto L8;
            r7.setDefaultCustomEndView(2);
            r7.showCustomEnd(true);
        L9:
            if (r4 != 0) goto L12;
            r7.setCardPosition(1);
        L15:
            r7.setOnContentClickListener(new AnonymousClass1(this, r4));
            return r5;
        L12:
            if (r4 != (getCount() - 1)) goto L14;
            r7.setCardPosition(3);
            goto L15
        L14:
            r7.setCardPosition(2);
            goto L15
        L8:
            r7.showCustomEnd(false);
            goto L9
        L4:
            r7 = (OCardListItem) r5.getTag();
            goto L5
        }
    }

    public void com_android_settings_ScreenOffTimeoutFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ScreenOffTimeoutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ScreenOffTimeoutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ String[] access$100(ScreenOffTimeoutFragment r0) {
        return r0.mOptions;
    }

    static /* synthetic */ int access$200(ScreenOffTimeoutFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$202(ScreenOffTimeoutFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ String[] access$300(ScreenOffTimeoutFragment r0) {
        return r0.mValues;
    }

    static /* synthetic */ BaseAdapter access$400(ScreenOffTimeoutFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$500(ScreenOffTimeoutFragment r0) {
        return r0.getCurrentTimeOutIndex();
    }

    public ScreenOffTimeoutFragment() {
        super(R.layout.screen_off_timeout_layout);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRevoneScreenOffTimeOut = new AnonymousClass2(this, null);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        this.mOptions = getEntries(R.array.screen_timeout_entries, R.array.screen_timeout_values);
        this.mValues = getValues(R.array.screen_timeout_values);
        this.mCurrentIndex = getCurrentTimeOutIndex();
        setupLockAfterScreenOffTimeoutForPolicyAdmin();
        Utils.inflateListTransparentHeader(getActivity(), this.mOptionsList, false);
        addFooterView();
        OptionsAdapter r6 = new OptionsAdapter(this, null);
        this.mAdapter = r6;
        this.mOptionsList.setAdapter(r6);
        int r7 = getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_mark).getIntrinsicWidth();
        DisplayMetrics r8 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(r8);
        this.mOptionTitleMaxWidth = (r8.widthPixels - (r8.density * 93.0f)) - r7;
        Utils.setListViewIgnoreAccessibilityItemCount(this.mOptionsList, 1);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mOptionsList);
        this.mOptionsList.setClipToPadding(false);
        this.mOptionsList.setClipChildren(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void updateViews() {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "stay_on_while_plugged_in", 0) == 0) goto L5;
        r2 = true;
    L5:
        ((OSwitch) this.mStayAwake.getCustomEndView()).setChecked(r2);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void com_android_settings_ScreenOffTimeoutFragment__onResume$___twin___() {
        super.onResume();
        registerContentReceiver();
    }

    private void setupLockAfterScreenOffTimeoutForPolicyAdmin() {
        final long r0 = ((DevicePolicyManager) getActivity().getSystemService("device_policy")).getMaximumTimeToLock(null);
        long r2 = Long.parseLong(this.mValues[this.mCurrentIndex]);
        if (r0 <= 0) goto L18;
        String[] r1 = (String[]) Arrays.stream(this.mValues).filter(new ScreenOffTimeoutFragment$$ExternalSyntheticLambda0(r0)).toArray(new ScreenOffTimeoutFragment$$ExternalSyntheticLambda1());
        this.mValues = r1;
        this.mOptions = (String[]) Arrays.copyOf(this.mOptions, r1.length);
        int r3 = -1;
        int r4 = 0;
    L5:
        String[] r5 = this.mValues;
        if (r4 >= r5.length) goto L11;
        if (r2 < Long.parseLong(r5[r4])) goto L10;
        r3 = r4;
    L10:
        r4 = r4 + 1;
        goto L5
    L11:
        if (r3 < 0) goto L13;
        this.mCurrentIndex = r3;
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT, Integer.parseInt(this.mValues[this.mCurrentIndex]));
        return;
    L13:
        this.mCurrentIndex = 0;
        return;
    }

    static /* synthetic */ boolean lambda$setupLockAfterScreenOffTimeoutForPolicyAdmin$0(long r2, String r4) {
        if (Long.parseLong(r4) > r2) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ String[] lambda$setupLockAfterScreenOffTimeoutForPolicyAdmin$1(int r0) {
        return new String[r0];
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unRegisterContentReceiver();
    }

    private String[] getEntries(int r3, int r4) {
        String[] r5 = this.mContext.getResources().getStringArray(r3);
        String[] r2 = this.mContext.getResources().getStringArray(r4);
        if (r5.length != r2.length) goto L9;
        String[] r6 = (String[]) Arrays.copyOf(r5, r5.length - 1);
        if (r2[0].equals("15000") == true) goto L7;
        return r6;
    L7:
        return (String[]) Arrays.copyOfRange(r6, 1, r6.length);
    L9:
        throw new IllegalArgumentException("entries len=" + r5.length + " but values len=" + r2.length);
    }

    private String[] getValues(int r3) {
        String[] r2 = this.mContext.getResources().getStringArray(r3);
        String[] r4 = (String[]) Arrays.copyOf(r2, r2.length - 1);
        if (r4[0].equals("15000") == true) goto L5;
        return r4;
    L5:
        return (String[]) Arrays.copyOfRange(r4, 1, r4.length);
    }

    private int getCurrentTimeOutIndex() {
        int r0 = android.provider.Settings.System.getInt(this.mContext.getContentResolver(), PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT, 60000);
        int r1 = 0;
        int r2 = 0;
    L3:
        String[] r3 = this.mValues;
        if (r1 >= r3.length) goto L9;
        if (r0 < Long.parseLong(r3[r1])) goto L8;
        r2 = r1;
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        return r2;
    }

    private void addFooterView() {
        View r0 = LayoutInflater.from(getActivity()).inflate(R.layout.screenoff_timeout_settings_footer_view, null);
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.stay_awake_switch);
        this.mStayAwake = r1;
        r1.getContentContainer().setClickable(false);
        ((OSwitch) this.mStayAwake.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass1(this));
        this.mOptionsList.addFooterView(r0);
    }

    private void registerContentReceiver() {
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor(PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT), true, this.mRevoneScreenOffTimeOut);
    }

    private void unRegisterContentReceiver() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mRevoneScreenOffTimeOut);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ScreenOffTimeoutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScreenOffTimeoutFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenOffTimeoutFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenOffTimeoutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScreenOffTimeoutFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ScreenOffTimeoutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenOffTimeoutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScreenOffTimeoutFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenOffTimeoutFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
