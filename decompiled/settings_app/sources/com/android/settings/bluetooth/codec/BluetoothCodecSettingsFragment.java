package com.android.settings.bluetooth.codec;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothCodecStatus;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.BluetoothUtils;
import com.android.settings.databinding.BluetoothCodecSettingsLayoutBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: BluetoothCodecSettingsFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\u001a\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/settings/bluetooth/codec/BluetoothCodecSettingsFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "bluetoothA2dp", "Landroid/bluetooth/BluetoothA2dp;", SliceBroadcastRelay.EXTRA_RECEIVER, "com/android/settings/bluetooth/codec/BluetoothCodecSettingsFragment$receiver$1", "Lcom/android/settings/bluetooth/codec/BluetoothCodecSettingsFragment$receiver$1;", "viewBinding", "Lcom/android/settings/databinding/BluetoothCodecSettingsLayoutBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onItemClick", "codecConfig", "Landroid/bluetooth/BluetoothCodecConfig;", "device", "Landroid/bluetooth/BluetoothDevice;", "onViewCreated", "view", "setupList", "a2dp", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BluetoothCodecSettingsFragment extends BaseFragment {
    private BluetoothA2dp bluetoothA2dp;
    private final BluetoothCodecSettingsFragment$receiver$1 receiver;
    private BluetoothCodecSettingsLayoutBinding viewBinding;

    /* JADX INFO: renamed from: $r8$lambda$E-UnM-lirLHycyb2boUF4XzCRBA, reason: not valid java name */
    public static /* synthetic */ void m380$r8$lambda$EUnMlirLHycyb2boUF4XzCRBA(BluetoothCodecSettingsFragment r0, View r1) {
        onViewCreated$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vNWDQmj-6rSfiEbpTsOUcJk6Bg8, reason: not valid java name */
    public static /* synthetic */ void m381$r8$lambda$vNWDQmj6rSfiEbpTsOUcJk6Bg8(BluetoothCodecSettingsFragment r0, BluetoothCodecConfig r1, BluetoothDevice r2, View r3) {
        setupList$lambda$4$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    public void com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.bluetooth.codec.BluetoothCodecSettingsFragment$receiver$1] */
    public BluetoothCodecSettingsFragment() {
        this.receiver = new BluetoothCodecSettingsFragment$receiver$1(this);
    }

    public static final /* synthetic */ BluetoothA2dp access$getBluetoothA2dp$p(BluetoothCodecSettingsFragment r0) {
        return r0.bluetoothA2dp;
    }

    public static final /* synthetic */ void access$setBluetoothA2dp$p(BluetoothCodecSettingsFragment r0, BluetoothA2dp r1) {
        r0.bluetoothA2dp = r1;
    }

    public static final /* synthetic */ void access$setupList(BluetoothCodecSettingsFragment r0, BluetoothA2dp r1) {
        r0.setupList(r1);
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
    L9:
        RelativeLayout r6 = r5.getRoot();
        Intrinsics.checkNotNullExpressionValue(r6, "getRoot(...)");
        return r6;
    L8:
        r5 = r0;
        goto L9
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        BluetoothCodecSettingsLayoutBinding r9 = this.viewBinding;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L5:
        OFloatingTitleBar r0 = r9.titleBar;
        Intrinsics.checkNotNullExpressionValue(r0, "titleBar");
        OFloatingTitleBar.addStartAction$default(r0, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null).setOnClickListener(new BluetoothCodecSettingsFragment$$ExternalSyntheticLambda1(this));
        Context r10 = getContext();
        if (r10 != null) goto L8;
        return;
    L8:
        BluetoothAdapter r1 = BluetoothAdapter.getDefaultAdapter();
        if (r1 == null) goto L11;
        r1.getProfileProxy(r10, new AnonymousClass2(this), 2);
    L11:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r10, this.receiver, new IntentFilter("android.bluetooth.a2dp.profile.action.CODEC_CONFIG_CHANGED"), null, null);
    }

    private static final void onViewCreated$lambda$0(BluetoothCodecSettingsFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }

    private final void setupList(BluetoothA2dp r20) {
        Context r7 = getContext();
        if (r7 != null) goto L5;
        return;
    L5:
        final BluetoothDevice r8 = BluetoothUtils.getA2dpActiveDevice();
        if (r8 != null) goto L8;
        return;
    L8:
        BluetoothCodecSettingsLayoutBinding r2 = this.viewBinding;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L11:
        r2.pageContainer.removeAllViews();
        BluetoothCodecStatus r3 = r20.getCodecStatus(r8);
        if (r3 == null) goto L14;
        List<BluetoothCodecConfig> r4 = r3.getCodecsSelectableCapabilities();
    L15:
        if (r4 != null) goto L17;
        return;
    L17:
        List r5 = CollectionsKt.sortedWith(r4, new BluetoothCodecSettingsFragment$setupList$$inlined$sortedBy$1());
        BluetoothCodecStatus r1 = r20.getCodecStatus(r8);
        if (r1 == null) goto L20;
        BluetoothCodecConfig r11 = r1.getCodecConfig();
    L21:
        int r12 = r5.size();
        Iterator r13 = r5.iterator();
        int r15 = 0;
    L23:
        if (r13.hasNext() == false) goto L47;
        Object r6 = r13.next();
        int r16 = r15 + 1;
        if (r15 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        final BluetoothCodecConfig r9 = (BluetoothCodecConfig) r6;
        OCardListItem r10 = new OCardListItem(r7, null, 0, 6, null);
        r10.setDefaultCustomEndView(2);
        r10.setTitle(BluetoothCodecConfig.getCodecName(r9.getCodecType()));
        if (r11 != null) goto L30;
    L32:
        boolean r14 = false;
    L33:
        r10.showCustomEnd(r14);
        r10.setOnContentClickListener(new BluetoothCodecSettingsFragment$$ExternalSyntheticLambda0(this, r9, r8));
        if (r12 != 1) goto L36;
        BluetoothCodecSettingsLayoutBinding r17 = null;
        OCardListItem.setCardPosition$default(r10, 0, false, 2, null);
    L43:
        BluetoothCodecSettingsLayoutBinding r18 = this.viewBinding;
        if (r18 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = r17;
    L46:
        r18.pageContainer.addView(r10);
        r15 = r16;
        goto L23
    L36:
        r17 = null;
        if (r15 != 0) goto L40;
        OCardListItem.setCardPosition$default(r10, 1, false, 2, null);
        goto L43
    L40:
        if (r15 != (r12 - 1)) goto L42;
        OCardListItem.setCardPosition$default(r10, 3, false, 2, null);
        goto L43
    L42:
        OCardListItem.setCardPosition$default(r10, 2, false, 2, null);
        goto L43
    L30:
        if (r11.getCodecType() != r9.getCodecType()) goto L32;
        r14 = true;
        goto L33
    L47:
        return;
    L20:
        r11 = null;
        goto L21
    L14:
        r4 = null;
        goto L15
    }

    private static final void setupList$lambda$4$lambda$3$lambda$2(BluetoothCodecSettingsFragment r0, BluetoothCodecConfig r1, BluetoothDevice r2, View r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$config");
        Intrinsics.checkNotNullParameter(r2, "$activeDevice");
        r0.onItemClick(r1, r2);
    }

    private final void onItemClick(BluetoothCodecConfig r4, BluetoothDevice r5) {
        BluetoothCodecConfig r6 = new BluetoothCodecConfig.Builder().setCodecType(r4.getCodecType()).setCodecPriority(1000000).build();
        Intrinsics.checkNotNullExpressionValue(r6, "build(...)");
        OLog.d(this.TAG, "onItemClick: " + r6);
        BluetoothA2dp r3 = this.bluetoothA2dp;
        if (r3 == null) goto L6;
        r3.setCodecConfigPreference(r5, r6);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Context r0 = getContext();
        if (r0 == null) goto L6;
        r0.unregisterReceiver(this.receiver);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BluetoothCodecSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BluetoothCodecSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BluetoothCodecSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_codec_BluetoothCodecSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
