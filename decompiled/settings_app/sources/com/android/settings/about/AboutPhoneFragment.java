package com.android.settings.about;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.android.settings.Constants;
import com.android.settings.DeviceNameDialogWrapper;
import com.android.settings.EventType;
import com.android.settings.LawInfoActivity;
import com.android.settings.R;
import com.android.settings.SettingsUncaughtExceptionHandler;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.FeedbackLauncher;
import org.apache.commons.io.IOUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: AboutPhoneFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/settings/about/AboutPhoneFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "deviceNameListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "headerBg", "Lcom/obric/oui/layout/OUIFrameLayout;", "mData", "", "Lcom/android/settings/about/AboutItem;", "productNameSubTv", "Lcom/obric/oui/text/OTextView;", "productNameTv", "updateBtn", "Landroid/view/View;", "editDeviceName", "", "initView", "onDestroy", "onEvent", "event", "Lcom/android/settings/EventType$OTABadgeUpdateEvent;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "showBugReportDialog", "showUpdateBtn", "show", "", "updateOsVersionText", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AboutPhoneFragment extends BaseFragment {
    private OCardListItem deviceNameListItem;
    private OUIFrameLayout headerBg;
    private final List<AboutItem> mData;
    private OTextView productNameSubTv;
    private OTextView productNameTv;
    private View updateBtn;

    public static /* synthetic */ void $r8$lambda$0Vkm9mrg_gUaxufloDGY3q0TkYY(AboutPhoneFragment r0, View r1) {
        mData$lambda$17$lambda$16(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$9bDddt-JwdTawtG4g936hLL-eWg, reason: not valid java name */
    public static /* synthetic */ void m216$r8$lambda$9bDddtJwdTawtG4g936hLLeWg(AboutPhoneFragment r0, View r1) {
        mData$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$AYYgFlrzMs8eyoWSxhZnXIP8voI(AboutPhoneFragment r0, View r1) {
        initView$lambda$24$lambda$23(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ky-N4e9UszV2ECFXcVr2x0JDCKk, reason: not valid java name */
    public static /* synthetic */ void m217$r8$lambda$KyN4e9UszV2ECFXcVr2x0JDCKk(AboutPhoneFragment r0, View r1) {
        mData$lambda$1$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$NQm3PZlsF9YcCTL_Y_ltGNm7-8o, reason: not valid java name */
    public static /* synthetic */ void m218$r8$lambda$NQm3PZlsF9YcCTL_Y_ltGNm78o(AboutPhoneFragment r0, View r1) {
        mData$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ float $r8$lambda$SQhTV0cTfIDIgc9ktjsFM3Yh_Qg(AboutPhoneFragment r0, float r1) {
        return showUpdateBtn$lambda$31$lambda$30(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Z68FSUtk0xJFOGkopWSBueGKWZo(AboutPhoneFragment r0, View r1) {
        mData$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$kkVkQGaKXr1GwdX1q3TJS7kNkzA(AboutPhoneFragment r0, DialogInterface r1, int r2) {
        showBugReportDialog$lambda$29(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$npShI5l7y5raI3pBwGfC3IumxFg(AboutPhoneFragment r0, View r1) {
        mData$lambda$20$lambda$19(r0, r1);
    }

    public void com_android_settings_about_AboutPhoneFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_about_AboutPhoneFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_about_AboutPhoneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventType.OTABadgeUpdateEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_about_AboutPhoneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AboutPhoneFragment() {
        super(R.layout.about_settings_new);
        AboutItem[] r0 = new AboutItem[14];
        AboutItem r1 = new AboutItem();
        r1.setName(ResourceUtils.getString(R.string.about_device_name));
        r1.setValue(DeviceUtils.INSTANCE.getDeviceName());
        r1.setEndIconRes(R.drawable.icon_down);
        r1.setClickListener(new AboutPhoneFragment$$ExternalSyntheticLambda3(this));
        r1.setCardPosition(0);
        Unit r3 = Unit.INSTANCE;
        r0[0] = r1;
        r0[1] = new DividerItem();
        AboutItem r2 = new AboutItem();
        r2.setName(ResourceUtils.getString(R.string.model_number));
        r2.setValue(Build.MODEL + DeviceUtils.INSTANCE.getMsvSuffix());
        r2.setCardPosition(1);
        Unit r4 = Unit.INSTANCE;
        r0[2] = r2;
        AboutItem r5 = new AboutItem();
        r5.setName(ResourceUtils.getString(R.string.cpu_info));
        r5.setValue(DeviceUtils.INSTANCE.getCpuString());
        Unit r6 = Unit.INSTANCE;
        r0[3] = r5;
        AboutItem r7 = new AboutItem();
        r7.setName(ResourceUtils.getString(R.string.mem_info));
        long r8 = 1000;
        r7.setValue((((DeviceUtils.INSTANCE.getMemInfoKBSize() / r8) / r8) + 1) + " GB");
        Unit r9 = Unit.INSTANCE;
        r0[4] = r7;
        AboutItem r10 = new AboutItem();
        r10.setName(ResourceUtils.getString(R.string.storage_capacity));
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m1508constructorimpl(DeviceUtils.INSTANCE.getUsedStorageSize() + IOUtils.DIR_SEPARATOR_UNIX + Utils.getStorageVersion());     // Catch: Throwable -> L5
    L8:
        if (Result.m1511exceptionOrNullimpl(r12) == null) goto L11;
        r12 = Utils.getStorageVersion();
        Intrinsics.checkNotNullExpressionValue(r12, "getStorageVersion(...)");
    L11:
        r10.setValue((String) r12);
        r10.setEndIconRes(R.drawable.ic_arrow_forward_list_item);
        r10.setClickListener(new AboutPhoneFragment$$ExternalSyntheticLambda4(this));
        Unit r13 = Unit.INSTANCE;
        r0[5] = r10;
        AboutItem r14 = new AboutItem();
        r14.setName(ResourceUtils.getString(R.string.about_screen));
        StringBuilder r15 = new StringBuilder();
        StringCompanionObject r16 = StringCompanionObject.INSTANCE;
        String r17 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(DeviceUtils.INSTANCE.getPhysicsScreenSize())}, 1));
        Intrinsics.checkNotNullExpressionValue(r17, "format(...)");
        r14.setValue(r15.append(r17).append(TokenParser.SP).append(ResourceUtils.getString(R.string.inches)).append("，2800×1260").toString());
        Unit r18 = Unit.INSTANCE;
        r0[6] = r14;
        AboutItem r19 = new AboutItem();
        r19.setName(ResourceUtils.getString(R.string.battery_power));
        r19.setValue(DeviceUtils.INSTANCE.getBatteryCapacityFromSystemFile() + " mAh " + ResourceUtils.getString(R.string.battery_typical_value));
        r19.setCardPosition(3);
        Unit r20 = Unit.INSTANCE;
        r0[7] = r19;
        r0[8] = new DividerItem();
        AboutItem r21 = new AboutItem();
        r21.setName(ResourceUtils.getString(R.string.about_item_title_device_status));
        r21.setEndIconRes(R.drawable.ic_arrow_forward_list_item);
        r21.setClickListener(new AboutPhoneFragment$$ExternalSyntheticLambda5(this));
        r21.setCardPosition(1);
        Unit r22 = Unit.INSTANCE;
        r0[9] = r21;
        AboutItem r23 = new AboutItem();
        r23.setName(ResourceUtils.getString(R.string.about_item_title_law_info));
        r23.setEndIconRes(R.drawable.ic_arrow_forward_list_item);
        r23.setClickListener(new AboutPhoneFragment$$ExternalSyntheticLambda6(this));
        Unit r24 = Unit.INSTANCE;
        r0[10] = r23;
        AboutItem r25 = new AboutItem();
        r25.setName(ResourceUtils.getString(R.string.about_official_warranty));
        r25.setEndIconRes(R.drawable.ic_arrow_forward_list_item);
        r25.setClickListener(new AboutPhoneFragment$$ExternalSyntheticLambda7(this));
        r25.setCardPosition(3);
        Unit r26 = Unit.INSTANCE;
        r0[11] = r25;
        r0[12] = new DividerItem();
        AboutItem r27 = new AboutItem();
        r27.setName(ResourceUtils.getString(R.string.about_user_feedback));
        r27.setEndIconRes(R.drawable.ic_arrow_forward_list_item);
        r27.setCardPosition(0);
        r27.setClickListener(new AboutPhoneFragment$$ExternalSyntheticLambda8(this));
        Unit r28 = Unit.INSTANCE;
        r0[13] = r27;
        this.mData = CollectionsKt.mutableListOf(r0);
        return;
    L5:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r12 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final void mData$lambda$1$lambda$0(AboutPhoneFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.editDeviceName();
    }

    private static final void mData$lambda$9$lambda$8(AboutPhoneFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent();
        Integer r0 = r2.mTitleResId;
        if (r0 == null) goto L5;
        r4.putExtra("back_text_id", r0.intValue());
    L5:
        r4.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        r4.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.storage.StorageActivity");
        r4.setAction("android.intent.action.MAIN");
        r4.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r4.putExtra("back_text_res_name", "settings_application");
        Utils.startActivity(r2.getActivity(), r4);
    }

    private static final void mData$lambda$13$lambda$12(AboutPhoneFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent(r2.mContext, DeviceStatusActivity.class);
        Utils.startActivity(r2._mActivity, r4);
    }

    private static final void mData$lambda$15$lambda$14(AboutPhoneFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Utils.startActivity(r2._mActivity, new Intent(r2.mContext, LawInfoActivity.class));
    }

    private static final void mData$lambda$17$lambda$16(AboutPhoneFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        BaseFragment.start$default(r2, GuaranteeFragment.class, null, 2, null);
    }

    private static final void mData$lambda$20$lambda$19(AboutPhoneFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Bundle r4 = new Bundle();
        r4.putInt("activity", 0);
        r4.putBoolean("start_from_setting", true);
        if (FeedbackLauncher.startFeedback(r2.mContext, r4) == true) goto L6;
        r2.showBugReportDialog();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        initView();
        EventBus.getDefault().register(this);
    }

    private final void initView() {
        this.headerBg = (OUIFrameLayout) findViewById(R.id.header_bg);
        this.productNameTv = (OTextView) findViewById(R.id.tv_product_name);
        this.productNameSubTv = (OTextView) findViewById(R.id.tv_product_name_sub);
        View r1 = findViewById(R.id.update_btn);
        r1.setOnClickListener(new AboutPhoneFragment$$ExternalSyntheticLambda1(this));
        this.updateBtn = r1;
        updateOsVersionText();
        ((TextView) findViewById(R.id.os_model_tv)).setText(Build.MODEL + DeviceUtils.INSTANCE.getMsvSuffix());
        LinearLayout r2 = (LinearLayout) findViewByIdNullable(R.id.item_container);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getResources().getConfiguration().fontScale > 1.0f) goto L7;
        boolean r3 = true;
    L8:
        boolean r5 = Intrinsics.areEqual(r2.getResources().getConfiguration().locale.getLanguage(), "zh");
        boolean r6 = Intrinsics.areEqual(r2.getResources().getConfiguration().locale.getLanguage(), "en");
        Iterator<T> r7 = this.mData.iterator();
        int r8 = 0;
    L10:
        if (r7.hasNext() == false) goto L40;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        AboutItem r11 = (AboutItem) r9;
        if ((r11 instanceof DividerItem) == false) goto L17;
        View r12 = new View(r2.getContext());
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.INSTANCE.dp2px(16)));
        r2.addView(r12);
    L35:
        r8 = r10;
        goto L10
    L17:
        Context r13 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r13, "getContext(...)");
        OCardListItem r14 = new OCardListItem(r13, null, 0, 6, null);
        OCardListItem.setCardPosition$default(r14, r11.getCardPosition(), false, 2, null);
        r14.setCardType(0);
        r14.setTitle(r11.getName());
        r14.setDefaultTailIcon(0);
        if (Intrinsics.areEqual(ResourceUtils.getString(R.string.cpu_info), r11.getName()) == false) goto L23;
        if (r3 == false) goto L23;
        if (r5 == false) goto L23;
        r14.setEndDetailText(r11.getValue(), OUnitExtensionKt.dp2px(200));
    L27:
        r14.showCustomEnd(true);
        if (r11.getClickListener() != null) goto L30;
        r14.showTailIcon(false);
    L32:
        if (Intrinsics.areEqual(r11.getName(), ResourceUtils.getString(R.string.about_device_name)) == false) goto L34;
        this.deviceNameListItem = r14;
    L34:
        r2.addView(r14);
        goto L35
    L30:
        r14.showTailIcon(true);
        r14.setOnContentClickListener(r11.getClickListener());
    L23:
        if (Intrinsics.areEqual(ResourceUtils.getString(R.string.cpu_info), r11.getName()) == false) goto L26;
        if (r6 == false) goto L26;
        r14.setEndDetailText(r11.getValue(), OUnitExtensionKt.dp2px(152));
    L26:
        OCardListItem.setEndDetailText$default(r14, r11.getValue(), 0, 2, null);
        goto L27
    L40:
        return;
    L7:
        r3 = false;
        goto L8
    }

    private static final void initView$lambda$24$lambda$23(AboutPhoneFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent();
        Integer r0 = r2.mTitleResId;
        if (r0 == null) goto L5;
        r4.putExtra("back_text_id", r0.intValue());
    L5:
        r4.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        r4.setClassName("com.obric.updater", "com.obric.updater.UpdatesCheck");
        r4.setAction("android.intent.action.MAIN");
        r4.addFlags(268435456);
        Utils.startActivity(r2.getActivity(), r4);
    }

    private final void updateOsVersionText() {
        String r0 = DeviceUtils.INSTANCE.getShortOSVersion();
        TextView r1 = (TextView) findViewById(R.id.os_version_tv);
        if (Intrinsics.areEqual(StringsKt.substringBefore$default(r0, ".", null, 2, null), "1") == false) goto L13;
        OUIFrameLayout r2 = this.headerBg;
        if (r2 == null) goto L7;
        r2.setBackgroundResource(R.drawable.about_phone_header_bg_1);
    L7:
        r1.setTextColor(getResources().getColor(R.color.os_name_tv_color_v1));
        OTextView r3 = this.productNameTv;
        if (r3 == null) goto L10;
        r3.setTextColor(getResources().getColor(R.color.os_name_tv_color_v1));
    L10:
        OTextView r4 = this.productNameSubTv;
        if (r4 == null) goto L22;
        r4.setTextColor(getResources().getColor(R.color.os_name_tv_color_v1));
    L22:
        r1.setText("v" + r0);
        return;
    L13:
        OUIFrameLayout r5 = this.headerBg;
        if (r5 == null) goto L16;
        r5.setBackgroundResource(R.drawable.about_phone_header_bg);
    L16:
        r1.setTextColor(getResources().getColor(R.color.os_name_tv_color_v2));
        OTextView r6 = this.productNameTv;
        if (r6 == null) goto L19;
        r6.setTextColor(getResources().getColor(R.color.os_name_tv_color_v2));
    L19:
        OTextView r7 = this.productNameSubTv;
        if (r7 == null) goto L22;
        r7.setTextColor(getResources().getColor(R.color.os_name_tv_color_v2));
        goto L22
    }

    private final void editDeviceName() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "editDeviceName, fragmentActivity is null, return");
        return;
    L6:
        new DeviceNameDialogWrapper(r0).setDeviceName(DeviceUtils.INSTANCE.getDeviceName()).setListItem(this.deviceNameListItem).show();
    }

    private final void showBugReportDialog() {
        new AlertDialog.Builder(getActivity()).setTitle(R.string.about_user_feedback).setMessage(R.string.bugreport_message).setPositiveButton(R.string.okay, new AboutPhoneFragment$$ExternalSyntheticLambda2(this)).setNegativeButton(R.string.cancel, null).create().show();
    }

    private static final void showBugReportDialog$lambda$29(AboutPhoneFragment r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        SystemProperties.set("ctl.start", "bugreport");
        SettingsUncaughtExceptionHandler.getInstance(r0.getActivity()).reportLogs();
    }

    private final void showUpdateBtn(boolean r7) {
        View r0 = this.updateBtn;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("updateBtn");
        r0 = null;
    L6:
        if (r0.getVisibility() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r7 != r1) goto L11;
        return;
    L11:
        ConstraintLayout r2 = (ConstraintLayout) findViewById(R.id.constraint_root_view);
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(r2);
        if (r7 == true) goto L14;
        r3.connect(R.id.logo_img, 4, R.id.header_bg, 4);
    L15:
        ConstraintLayout r4 = r2;
        AutoTransition r5 = new AutoTransition();
        if (r7 == true) goto L18;
        r5.setInterpolator(new AboutPhoneFragment$$ExternalSyntheticLambda0(this));
    L18:
        TransitionManager.beginDelayedTransition(r4, r5);
        r3.applyTo(r2);
        return;
    L14:
        r3.setVisibility(R.id.update_btn, 0);
        r3.connect(R.id.logo_img, 4, R.id.update_btn, 3);
        goto L15
    L8:
        r1 = false;
        goto L9
    }

    private static final float showUpdateBtn$lambda$31$lambda$30(AboutPhoneFragment r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        View r0 = r5.updateBtn;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("updateBtn");
        r0 = null;
    L5:
        r0.setAlpha(1.0f - r6);
        if (r6 != 1.0f) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L18;
        View r3 = r5.updateBtn;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("updateBtn");
        r3 = null;
    L13:
        r3.setVisibility(8);
        View r7 = r5.updateBtn;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("updateBtn");
    L17:
        r1.setAlpha(1.0f);
        goto L18
    L16:
        r1 = r7;
    L18:
        return r6;
    L8:
        r2 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_about_AboutPhoneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AboutPhoneFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_about_AboutPhoneFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_AboutPhoneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AboutPhoneFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_about_AboutPhoneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_AboutPhoneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AboutPhoneFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_about_AboutPhoneFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
