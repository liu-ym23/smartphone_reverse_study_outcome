package com.android.settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.view.View;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.TimePickerDialog;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: DozeModeActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020#H\u0016J\u001a\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J,\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020#01H\u0002J\b\u00102\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001b\u0010\u0010\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\nR\u001b\u0010\u0013\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0014\u0010\nR\u001b\u0010\u0016\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR\u001b\u0010\u0019\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\nR!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\u001f\u0010 ¨\u00063"}, d2 = {"Lcom/android/settings/DozeModeFragment;", "Lcom/android/settings/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "()V", "mContentObserver", "com/android/settings/DozeModeFragment$mContentObserver$1", "Lcom/android/settings/DozeModeFragment$mContentObserver$1;", "mModeAllDay", "Lcom/obric/oui/lisitem/OCardListItem;", "getMModeAllDay", "()Lcom/obric/oui/lisitem/OCardListItem;", "mModeAllDay$delegate", "Lkotlin/Lazy;", "mModeLowPowerConsume", "getMModeLowPowerConsume", "mModeLowPowerConsume$delegate", "mModeOff", "getMModeOff", "mModeOff$delegate", "mModeScheduled", "getMModeScheduled", "mModeScheduled$delegate", "mScheduleEnd", "getMScheduleEnd", "mScheduleEnd$delegate", "mScheduleStart", "getMScheduleStart", "mScheduleStart$delegate", "mScheduleViews", "", "Landroid/view/View;", "getMScheduleViews", "()Ljava/util/List;", "mScheduleViews$delegate", "onClick", "", "view", "onDestroyView", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "setDisplayPolicy", "policy", "", "showTimePicker", "titleRes", "currentTimeInMillis", "", "callback", "Lkotlin/Function1;", "updateViewStates", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DozeModeFragment extends BaseFragment implements View.OnClickListener {
    private final DozeModeFragment$mContentObserver$1 mContentObserver;
    private final Lazy mModeAllDay$delegate;
    private final Lazy mModeLowPowerConsume$delegate;
    private final Lazy mModeOff$delegate;
    private final Lazy mModeScheduled$delegate;
    private final Lazy mScheduleEnd$delegate;
    private final Lazy mScheduleStart$delegate;
    private final Lazy mScheduleViews$delegate;

    public static /* synthetic */ void $r8$lambda$eQrfYOxXgYTu2vfe855DzkOqr6Q(Function1 r0, int r1, int r2) {
        showTimePicker$lambda$1(r0, r1, r2);
    }

    public void com_android_settings_DozeModeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_DozeModeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DozeModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DozeModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public static final /* synthetic */ OCardListItem access$getMScheduleEnd(DozeModeFragment r0) {
        return r0.getMScheduleEnd();
    }

    public static final /* synthetic */ OCardListItem access$getMScheduleStart(DozeModeFragment r0) {
        return r0.getMScheduleStart();
    }

    public static final /* synthetic */ void access$updateViewStates(DozeModeFragment r0) {
        r0.updateViewStates();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settings.DozeModeFragment$mContentObserver$1] */
    public DozeModeFragment() {
        super(R.layout.doze_mode);
        this.mModeOff$delegate = LazyKt.lazy(new DozeModeFragment$mModeOff$2(this));
        this.mModeLowPowerConsume$delegate = LazyKt.lazy(new DozeModeFragment$mModeLowPowerConsume$2(this));
        this.mModeAllDay$delegate = LazyKt.lazy(new DozeModeFragment$mModeAllDay$2(this));
        this.mModeScheduled$delegate = LazyKt.lazy(new DozeModeFragment$mModeScheduled$2(this));
        this.mScheduleStart$delegate = LazyKt.lazy(new DozeModeFragment$mScheduleStart$2(this));
        this.mScheduleEnd$delegate = LazyKt.lazy(new DozeModeFragment$mScheduleEnd$2(this));
        this.mScheduleViews$delegate = LazyKt.lazy(new DozeModeFragment$mScheduleViews$2(this));
        final Handler r0 = new Handler(Looper.getMainLooper());
        this.mContentObserver = new DozeModeFragment$mContentObserver$1(this, r0);
    }

    private final OCardListItem getMModeOff() {
        return (OCardListItem) this.mModeOff$delegate.getValue();
    }

    private final OCardListItem getMModeLowPowerConsume() {
        return (OCardListItem) this.mModeLowPowerConsume$delegate.getValue();
    }

    private final OCardListItem getMModeAllDay() {
        return (OCardListItem) this.mModeAllDay$delegate.getValue();
    }

    private final OCardListItem getMModeScheduled() {
        return (OCardListItem) this.mModeScheduled$delegate.getValue();
    }

    private final OCardListItem getMScheduleStart() {
        return (OCardListItem) this.mScheduleStart$delegate.getValue();
    }

    private final OCardListItem getMScheduleEnd() {
        return (OCardListItem) this.mScheduleEnd$delegate.getValue();
    }

    private final List<View> getMScheduleViews() {
        return (List) this.mScheduleViews$delegate.getValue();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        DozeModeFragment r5 = this;
        getMModeOff().setOnContentClickListener(r5);
        getMModeLowPowerConsume().setOnContentClickListener(r5);
        getMModeAllDay().setOnContentClickListener(r5);
        getMModeScheduled().setOnContentClickListener(r5);
        getMScheduleStart().setOnContentClickListener(r5);
        getMScheduleEnd().setOnContentClickListener(r5);
        updateViewStates();
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor(DozeModeUtils.KEY_OBRIC_AOD_DISPLAY_POLICY), false, this.mContentObserver);
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor(DozeModeUtils.KEY_OBRIC_AOD_SCHEDULED_START), false, this.mContentObserver);
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor(DozeModeUtils.KEY_OBRIC_AOD_SCHEDULED_END), false, this.mContentObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        getContentResolver().unregisterContentObserver(this.mContentObserver);
        super.onDestroyView();
    }

    private final void updateViewStates() {
        int r0 = DozeModeUtils.INSTANCE.getAODDisplayPolicy$app_neridaCnRelease(this.mContext);
        OCardListItem r1 = getMModeOff();
        if (r0 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        r1.showCustomEnd(r2);
        OCardListItem r3 = getMModeLowPowerConsume();
        if (r0 != 0) goto L9;
        boolean r4 = true;
    L10:
        r3.showCustomEnd(r4);
        OCardListItem r5 = getMModeAllDay();
        if (r0 != 1) goto L13;
        boolean r6 = true;
    L14:
        r5.showCustomEnd(r6);
        OCardListItem r7 = getMModeScheduled();
        if (r0 != 2) goto L17;
        boolean r8 = true;
    L18:
        r7.showCustomEnd(r8);
        Iterator<T> r9 = getMScheduleViews().iterator();
    L20:
        if (r9.hasNext() == false) goto L26;
        View r10 = (View) r9.next();
        if (r0 != 2) goto L24;
        boolean r11 = true;
    L25:
        ViewExtensionsKt.setVisibility(r10, r11);
        goto L20
    L24:
        r11 = false;
        goto L25
    L26:
        OCardListItemUtils.setCustomEndTipTextView(getMScheduleStart(), DozeModeUtils.INSTANCE.getAODScheduledStartTime$app_neridaCnRelease(this.mContext));
        OCardListItemUtils.setCustomEndTipTextView(getMScheduleEnd(), DozeModeUtils.INSTANCE.getAODScheduledEndTime$app_neridaCnRelease(this.mContext));
        return;
    L17:
        r8 = false;
        goto L18
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private final void setDisplayPolicy(int r5) {
        getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("doze_always_on"), false, this.mContentObserver);
        android.provider.Settings.Global.putInt(getContentResolver(), DozeModeUtils.KEY_OBRIC_AOD_DISPLAY_POLICY, r5);
    }

    private final void showTimePicker(int r11, long r12, final Function1<? super Long, Unit> r14) {
        long r0 = r12 / ((long) LibUtil.HOUR);
        long r13 = (r12 / ((long) 60000)) % ((long) 60);
        new TimePickerDialog(getActivity(), this.mContext.getString(r11), new DozeModeFragment$$ExternalSyntheticLambda0(r14), (int) r0, (int) r13, DateFormat.is24HourFormat(this.mContext)).show();
    }

    private static final void showTimePicker$lambda$1(Function1 r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "$callback");
        r2.invoke(Long.valueOf(((long) (((r3 * 60) * 60) + (r4 * 60))) * 1000));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (Intrinsics.areEqual(r4, getMModeOff().getContentContainer()) == false) goto L6;
        setDisplayPolicy(-1);
        return;
    L6:
        if (Intrinsics.areEqual(r4, getMModeLowPowerConsume().getContentContainer()) == false) goto L9;
        setDisplayPolicy(0);
        return;
    L9:
        if (Intrinsics.areEqual(r4, getMModeAllDay().getContentContainer()) == false) goto L12;
        setDisplayPolicy(1);
        return;
    L12:
        if (Intrinsics.areEqual(r4, getMModeScheduled().getContentContainer()) == false) goto L15;
        setDisplayPolicy(2);
        return;
    L15:
        if (Intrinsics.areEqual(r4, getMScheduleStart().getContentContainer()) == false) goto L18;
        showTimePicker(R.string.obric_doze_display_policy_scheduled_start, android.provider.Settings.Global.getLong(getContentResolver(), DozeModeUtils.KEY_OBRIC_AOD_SCHEDULED_START, DozeModeUtils.DEFAULT_AOD_SCHEDULED_START), new AnonymousClass1(this));
        return;
    L18:
        if (Intrinsics.areEqual(r4, getMScheduleEnd().getContentContainer()) == false) goto L26;
        showTimePicker(R.string.obric_doze_display_policy_scheduled_end, android.provider.Settings.Global.getLong(getContentResolver(), DozeModeUtils.KEY_OBRIC_AOD_SCHEDULED_END, DozeModeUtils.DEFAULT_AOD_SCHEDULED_END), new AnonymousClass2(this));
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DozeModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DozeModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DozeModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DozeModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DozeModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DozeModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DozeModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DozeModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DozeModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
