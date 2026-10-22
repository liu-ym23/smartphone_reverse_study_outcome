package com.android.settings.scheduledpower;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.scheduledpower.utils.ScheduledPowerUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.TimePickerDialog;
import com.android.settingslib.drawer.EntriesProvider;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: ScheduledPowerOnAndOffFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J,\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150)H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u001b\u0010\u0011\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\b¨\u0006+"}, d2 = {"Lcom/android/settings/scheduledpower/ScheduledPowerOnAndOffFragment;", "Lcom/android/settings/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()V", "mScheduledPowerOffItem", "Lcom/obric/oui/lisitem/OCardListItem;", "getMScheduledPowerOffItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "mScheduledPowerOffItem$delegate", "Lkotlin/Lazy;", "mScheduledPowerOnItem", "getMScheduledPowerOnItem", "mScheduledPowerOnItem$delegate", "mShutdownItem", "getMShutdownItem", "mShutdownItem$delegate", "mStartupTimeItem", "getMStartupTimeItem", "mStartupTimeItem$delegate", EntriesProvider.METHOD_ON_CHECKED_CHANGED, "", "buttonView", "Landroid/widget/CompoundButton;", EntriesProvider.METHOD_IS_CHECKED, "", "onClick", "v", "Landroid/view/View;", "onResume", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateRestored", "showTimePicker", "titleRes", "", "currentTimeInMillis", "", "onTimeSetCallback", "Lkotlin/Function1;", "updateViewStatus", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduledPowerOnAndOffFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private final Lazy mScheduledPowerOffItem$delegate;
    private final Lazy mScheduledPowerOnItem$delegate;
    private final Lazy mShutdownItem$delegate;
    private final Lazy mStartupTimeItem$delegate;

    public static /* synthetic */ void $r8$lambda$EKjQKVWMAZ4Cn3wljjnX9HsjbCQ(ScheduledPowerOnAndOffFragment r0, View r1) {
        onViewCreated$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$KqPf9P3OEPwa9_T1ByGvz5qVUl0(ScheduledPowerOnAndOffFragment r0, View r1) {
        onViewCreated$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$l4O0ajCPgZKC78X9Xo8sIZxf9Zw(Function1 r0, int r1, int r2) {
        showTimePicker$lambda$2(r0, r1, r2);
    }

    public void com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ScheduledPowerOnAndOffFragment() {
        super(R.layout.scheduled_power_on_and_off_fragment_layout);
        this.mScheduledPowerOnItem$delegate = LazyKt.lazy(new ScheduledPowerOnAndOffFragment$mScheduledPowerOnItem$2(this));
        this.mStartupTimeItem$delegate = LazyKt.lazy(new ScheduledPowerOnAndOffFragment$mStartupTimeItem$2(this));
        this.mScheduledPowerOffItem$delegate = LazyKt.lazy(new ScheduledPowerOnAndOffFragment$mScheduledPowerOffItem$2(this));
        this.mShutdownItem$delegate = LazyKt.lazy(new ScheduledPowerOnAndOffFragment$mShutdownItem$2(this));
    }

    public static final /* synthetic */ OCardListItem access$getMShutdownItem(ScheduledPowerOnAndOffFragment r0) {
        return r0.getMShutdownItem();
    }

    public static final /* synthetic */ OCardListItem access$getMStartupTimeItem(ScheduledPowerOnAndOffFragment r0) {
        return r0.getMStartupTimeItem();
    }

    private final OCardListItem getMScheduledPowerOnItem() {
        return (OCardListItem) this.mScheduledPowerOnItem$delegate.getValue();
    }

    private final OCardListItem getMStartupTimeItem() {
        return (OCardListItem) this.mStartupTimeItem$delegate.getValue();
    }

    private final OCardListItem getMScheduledPowerOffItem() {
        return (OCardListItem) this.mScheduledPowerOffItem$delegate.getValue();
    }

    private final OCardListItem getMShutdownItem() {
        return (OCardListItem) this.mShutdownItem$delegate.getValue();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        updateViewStatus();
        getMStartupTimeItem().setOnContentClickListener(new ScheduledPowerOnAndOffFragment$$ExternalSyntheticLambda1(this));
        getMShutdownItem().setOnContentClickListener(new ScheduledPowerOnAndOffFragment$$ExternalSyntheticLambda2(this));
    }

    private static final void onViewCreated$lambda$0(ScheduledPowerOnAndOffFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClick(r0.getMStartupTimeItem());
    }

    private static final void onViewCreated$lambda$1(ScheduledPowerOnAndOffFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClick(r0.getMShutdownItem());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        OSwitch r3 = getMScheduledPowerOnItem().getEndSwitch();
        if (r3 == null) goto L5;
        r3.setOnCheckedChangeListener(this);
    L5:
        OSwitch r4 = getMScheduledPowerOffItem().getEndSwitch();
        if (r4 == null) goto L9;
        r4.setOnCheckedChangeListener(this);
        return;
    }

    public void com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment__onResume$___twin___() {
        super.onResume();
        updateViewStatus();
        ScheduledPowerUtils.sendStartupEvent(this.mContext, ScheduledPowerUtils.isScheduledPowerOnOpen(this.mContext));
        ScheduledPowerUtils.sendShutdownEvent(this.mContext, ScheduledPowerUtils.isScheduledPowerOffOpen(this.mContext));
    }

    private final void updateViewStatus() {
        boolean r0 = ScheduledPowerUtils.isScheduledPowerOnOpen(this.mContext);
        OCardListItem.setCardPosition$default(getMScheduledPowerOnItem(), r0 ? 1 : 0, false, 2, null);
        OSwitch r1 = getMScheduledPowerOnItem().getEndSwitch();
        if (r1 == null) goto L6;
        r1.setChecked(r0);
    L6:
        OCardListItem r2 = getMStartupTimeItem();
        int r5 = 8;
        if (r0 == false) goto L9;
        int r3 = 0;
    L10:
        r2.setVisibility(r3);
        OCardListItem.setEndDetailText$default(getMStartupTimeItem(), ScheduledPowerUtils.formatClockTime(ScheduledPowerUtils.getStartupTime(this.mContext)), 0, 2, null);
        boolean r4 = ScheduledPowerUtils.isScheduledPowerOffOpen(this.mContext);
        OCardListItem.setCardPosition$default(getMScheduledPowerOffItem(), r4 ? 1 : 0, false, 2, null);
        OSwitch r6 = getMScheduledPowerOffItem().getEndSwitch();
        if (r6 == null) goto L14;
        r6.setChecked(r4);
    L14:
        OCardListItem r7 = getMShutdownItem();
        if (r4 == false) goto L17;
        r5 = 0;
    L17:
        r7.setVisibility(r5);
        OCardListItem.setEndDetailText$default(getMShutdownItem(), ScheduledPowerUtils.formatClockTime(ScheduledPowerUtils.getShutdownTime(this.mContext)), 0, 2, null);
        return;
    L9:
        r3 = 8;
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (Intrinsics.areEqual(r4, getMStartupTimeItem()) == false) goto L6;
        showTimePicker(R.string.title_startup_time, ScheduledPowerUtils.getStartupTime(this.mContext), new AnonymousClass1(this));
        return;
    L6:
        if (Intrinsics.areEqual(r4, getMShutdownItem()) == false) goto L10;
        showTimePicker(R.string.title_shutdown_time, ScheduledPowerUtils.getShutdownTime(this.mContext), new AnonymousClass2(this));
        return;
    }

    private final void showTimePicker(int r12, long r13, final Function1<? super Long, Unit> r15) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "showTimePicker, activity is null, return");
        return;
    L6:
        long r1 = r13 / ((long) LibUtil.HOUR);
        new TimePickerDialog(r0, this.mContext.getString(r12), new ScheduledPowerOnAndOffFragment$$ExternalSyntheticLambda0(r15), (int) r1, (int) ((r13 / ((long) 60000)) % ((long) 60)), DateFormat.is24HourFormat(this.mContext)).show();
    }

    private static final void showTimePicker$lambda$2(Function1 r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "$onTimeSetCallback");
        r2.invoke(Long.valueOf(((long) (((r3 * 60) * 60) + (r4 * 60))) * 1000));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "buttonView");
        int r1 = 8;
        if (Intrinsics.areEqual(r6, getMScheduledPowerOnItem().getEndSwitch()) == false) goto L9;
        OCardListItem.setCardPosition$default(getMScheduledPowerOnItem(), r7 ? 1 : 0, false, 2, null);
        ScheduledPowerUtils.updateScheduledPowerOnStatus(this.mContext, r7);
        OCardListItem r8 = getMStartupTimeItem();
        if (r7 == false) goto L7;
        r1 = 0;
    L7:
        r8.setVisibility(r1);
        ScheduledPowerUtils.sendStartupEvent(this.mContext, ScheduledPowerUtils.isScheduledPowerOnOpen(this.mContext));
        return;
    L9:
        if (Intrinsics.areEqual(r6, getMScheduledPowerOffItem().getEndSwitch()) == false) goto L16;
        OCardListItem.setCardPosition$default(getMScheduledPowerOffItem(), r7 ? 1 : 0, false, 2, null);
        ScheduledPowerUtils.updateScheduledPowerOffStatus(this.mContext, r7);
        OCardListItem r9 = getMShutdownItem();
        if (r7 == false) goto L13;
        r1 = 0;
    L13:
        r9.setVisibility(r1);
        ScheduledPowerUtils.sendShutdownEvent(this.mContext, ScheduledPowerUtils.isScheduledPowerOffOpen(this.mContext));
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScheduledPowerOnAndOffFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScheduledPowerOnAndOffFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScheduledPowerOnAndOffFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_scheduledpower_ScheduledPowerOnAndOffFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
