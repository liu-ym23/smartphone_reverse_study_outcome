package com.android.settings.bluetooth.codec;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.codec.utils.BluetoothCodecHelper;
import com.android.settings.databinding.BluetoothCodecSettingsLayoutBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: BluetoothCodecSampleRateSettingsFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u001a\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/settings/bluetooth/codec/BluetoothCodecSampleRateSettingsFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "bluetoothCodecHelper", "Lcom/android/settings/bluetooth/codec/utils/BluetoothCodecHelper;", "callback", "com/android/settings/bluetooth/codec/BluetoothCodecSampleRateSettingsFragment$callback$1", "Lcom/android/settings/bluetooth/codec/BluetoothCodecSampleRateSettingsFragment$callback$1;", "itemViewList", "", "Lcom/obric/oui/lisitem/OCardListItem;", "mHasInitViewBefore", "", "viewBinding", "Lcom/android/settings/databinding/BluetoothCodecSettingsLayoutBinding;", "initViews", "", "supportedSampleRates", "", "", "currentSampleRate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onItemClick", "sampleRate", "onViewCreated", "view", "updateViews", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BluetoothCodecSampleRateSettingsFragment extends BaseFragment {
    private BluetoothCodecHelper bluetoothCodecHelper;
    private final BluetoothCodecSampleRateSettingsFragment$callback$1 callback;
    private final List<OCardListItem> itemViewList;
    private boolean mHasInitViewBefore;
    private BluetoothCodecSettingsLayoutBinding viewBinding;

    public static /* synthetic */ void $r8$lambda$aYeDme7gTsTMa37AHZR3wGsE4vo(int r0, BluetoothCodecSampleRateSettingsFragment r1, List r2, int r3, View r4) {
        initViews$lambda$5$lambda$4$lambda$3(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$yciwCZ750O3chPe-XG3xYyWyfTk, reason: not valid java name */
    public static /* synthetic */ void m379$r8$lambda$yciwCZ750O3chPeXG3xYyWyfTk(BluetoothCodecSampleRateSettingsFragment r0, View r1) {
        onViewCreated$lambda$0(r0, r1);
    }

    public void com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.settings.bluetooth.codec.BluetoothCodecSampleRateSettingsFragment$callback$1] */
    public BluetoothCodecSampleRateSettingsFragment() {
        this.itemViewList = new ArrayList();
        this.callback = new BluetoothCodecSampleRateSettingsFragment$callback$1(this);
    }

    public static final /* synthetic */ BluetoothCodecHelper access$getBluetoothCodecHelper$p(BluetoothCodecSampleRateSettingsFragment r0) {
        return r0.bluetoothCodecHelper;
    }

    public static final /* synthetic */ boolean access$getMHasInitViewBefore$p(BluetoothCodecSampleRateSettingsFragment r0) {
        return r0.mHasInitViewBefore;
    }

    public static final /* synthetic */ String access$getTAG$p(BluetoothCodecSampleRateSettingsFragment r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$initViews(BluetoothCodecSampleRateSettingsFragment r0, List r1, int r2) {
        r0.initViews(r1, r2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        BluetoothCodecSettingsLayoutBinding r4 = BluetoothCodecSettingsLayoutBinding.inflate(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.viewBinding = r4;
        BluetoothCodecSettingsLayoutBinding r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(r4.pageContainer);
        BluetoothCodecSettingsLayoutBinding r0 = this.viewBinding;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L10:
        return r5.getRoot();
    L8:
        r5 = r0;
        goto L10
    }

    private static final void onViewCreated$lambda$0(BluetoothCodecSampleRateSettingsFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        BluetoothCodecSettingsLayoutBinding r9 = this.viewBinding;
        BluetoothCodecSettingsLayoutBinding r10 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L5:
        r9.titleBar.setCenterTitle(R.string.bluetooth_select_a2dp_codec_sample_rate);
        BluetoothCodecSettingsLayoutBinding r11 = this.viewBinding;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        OFloatingTitleBar r0 = r10.titleBar;
        Intrinsics.checkNotNullExpressionValue(r0, "titleBar");
        OFloatingTitleBar.addStartAction$default(r0, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null).setOnClickListener(new BluetoothCodecSampleRateSettingsFragment$$ExternalSyntheticLambda1(this));
        Context r12 = getContext();
        if (r12 != null) goto L15;
        OLog.e(this.TAG, "onViewCreated, context is null");
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L17;
        r6.onBackPressed();
        return;
    L17:
        return;
    L15:
        BluetoothCodecHelper r13 = new BluetoothCodecHelper(this.TAG, r12, this.callback);
        this.bluetoothCodecHelper = r13;
        r13.connect();
        return;
    L8:
        r10 = r11;
        goto L9
    }

    private final void initViews(final List<Integer> r19, int r20) {
        Context r8 = getContext();
        if (r8 != null) goto L8;
        OLog.e(this.TAG, "initViews, context is null");
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L39;
        r0.onBackPressed();
        return;
    L39:
        return;
    L8:
        this.mHasInitViewBefore = true;
        BluetoothCodecSettingsLayoutBinding r2 = this.viewBinding;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L11:
        r2.pageContainer.removeAllViews();
        this.itemViewList.clear();
        Iterator<T> r12 = r19.iterator();
        final int r14 = 0;
    L13:
        if (r12.hasNext() == false) goto L35;
        Object r3 = r12.next();
        int r15 = r14 + 1;
        if (r14 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        final int r7 = ((Number) r3).intValue();
        OCardListItem r6 = new OCardListItem(r8, null, 0, 6, null);
        r6.setDefaultCustomEndView(2);
        r6.setTitle(BluetoothCodecHelper.Companion.sampleRateToString$default(BluetoothCodecHelper.Companion, r8, r7, false, 4, null));
        if (r7 != r20) goto L20;
        boolean r4 = true;
    L21:
        r6.showCustomEnd(r4);
        r6.setOnContentClickListener(new BluetoothCodecSampleRateSettingsFragment$$ExternalSyntheticLambda0(r14, this, r19, r7));
        if (r19.size() != 1) goto L24;
        BluetoothCodecSettingsLayoutBinding r5 = null;
        OCardListItem.setCardPosition$default(r6, 0, false, 2, null);
    L31:
        this.itemViewList.add(r6);
        BluetoothCodecSettingsLayoutBinding r9 = this.viewBinding;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = r5;
    L34:
        r9.pageContainer.addView(r6);
        r14 = r15;
        goto L13
    L24:
        r5 = null;
        if (r14 != 0) goto L28;
        OCardListItem.setCardPosition$default(r6, 1, false, 2, null);
        goto L31
    L28:
        if (r14 != (r19.size() - 1)) goto L30;
        OCardListItem.setCardPosition$default(r6, 3, false, 2, null);
        goto L31
    L30:
        OCardListItem.setCardPosition$default(r6, 2, false, 2, null);
        goto L31
    L20:
        r4 = false;
        goto L21
    }

    private static final void initViews$lambda$5$lambda$4$lambda$3(int r0, BluetoothCodecSampleRateSettingsFragment r1, List r2, int r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$supportedSampleRates");
        if (r0 != 0) goto L5;
        r1.onItemClick(((Number) CollectionsKt.last(r2)).intValue());
        return;
    L5:
        r1.onItemClick(r3);
    }

    private final void updateViews(int r10) {
        Context r6 = getContext();
        if (r6 != null) goto L8;
        OLog.e(this.TAG, "updateViews, context is null");
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L14;
        r9.onBackPressed();
        return;
    L14:
        return;
    L8:
        Iterator<T> r11 = this.itemViewList.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        OCardListItem r7 = (OCardListItem) r11.next();
        r7.showCustomEnd(Intrinsics.areEqual(r7.getTitle(), BluetoothCodecHelper.Companion.sampleRateToString$default(BluetoothCodecHelper.Companion, r6, r10, false, 4, null)));
        goto L10
    }

    private final void onItemClick(int r4) {
        OLog.d(this.TAG, "onItemClick: " + r4);
        BluetoothCodecHelper r3 = this.bluetoothCodecHelper;
        if (r3 == null) goto L6;
        r3.setSampleRate(r4);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BluetoothCodecHelper r0 = this.bluetoothCodecHelper;
        if (r0 == null) goto L6;
        r0.disconnect();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BluetoothCodecSampleRateSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BluetoothCodecSampleRateSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BluetoothCodecSampleRateSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_codec_BluetoothCodecSampleRateSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
