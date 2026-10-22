package com.obric.security.mainpage.block;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.android.calendar.privacy.GrantUtil;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.utils.BatteryUtil;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.security.battertpower.BatteryPowerActivityViewModel;
import com.obric.security.battertpower.PowerAdvisorService;
import com.obric.security.battertpower.healthandcharge.HealthAndChargeActivity;
import com.obric.security.mainpage.block.depend.IHolderBlockDepend;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.obric.security.mainpage.delegate.data.KeyFeatureModel;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import obric.util.DisplayHelper;

/* JADX INFO: compiled from: BatteryOptBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020*H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/obric/security/mainpage/block/BatteryOptBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "batteryInfoReceiver", "Landroid/content/BroadcastReceiver;", "firstResume", "", "handlerCallback", "Landroid/os/Handler$Callback;", "holderDepend", "Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "getHolderDepend", "()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "holderDepend$delegate", "Lkotlin/properties/ReadOnlyProperty;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "isCharging", PushLog.KEY_LABEL, "Lcom/obric/oui/text/OTextView;", "mainHandler", "Landroid/os/Handler;", "title", "getTitle", "()Lcom/obric/oui/text/OTextView;", "setTitle", "(Lcom/obric/oui/text/OTextView;)V", "bindModel", "", "model", "isPowerMode", "context", "Landroid/content/Context;", "layoutResource", "", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "remainTimeUpdate", HealthAndChargeActivity.BATTERY_PERCENTAGE, "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BatteryOptBlock extends UIBlock<KeyFeatureData, KeyFeatureModel> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final BroadcastReceiver batteryInfoReceiver;
    private boolean firstResume;
    private final Handler.Callback handlerCallback;
    private final ReadOnlyProperty holderDepend$delegate;
    private ImageView icon;
    private boolean isCharging;
    private OTextView label;
    private Handler mainHandler;
    private OTextView title;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(BatteryOptBlock.class, "holderDepend", "getHolderDepend()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", 0))};
    }

    private final IHolderBlockDepend getHolderDepend() {
        return (IHolderBlockDepend) this.holderDepend$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return R.layout.key_feature_item_block;
    }

    public BatteryOptBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.holderDepend$delegate = new BatteryOptBlock$$special$$inlined$findDepend$1(this);
        this.firstResume = true;
        this.handlerCallback = new BatteryOptBlock$handlerCallback$1(this);
        this.batteryInfoReceiver = new BatteryOptBlock$batteryInfoReceiver$1(this);
    }

    public static final /* synthetic */ boolean access$getFirstResume$p(BatteryOptBlock r0) {
        return r0.firstResume;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(BatteryOptBlock r0) {
        return r0.mainHandler;
    }

    public static final /* synthetic */ boolean access$isCharging$p(BatteryOptBlock r0) {
        return r0.isCharging;
    }

    public static final /* synthetic */ void access$remainTimeUpdate(BatteryOptBlock r0, int r1) {
        r0.remainTimeUpdate(r1);
    }

    public static final /* synthetic */ void access$setCharging$p(BatteryOptBlock r0, boolean r1) {
        r0.isCharging = r1;
    }

    public static final /* synthetic */ void access$setFirstResume$p(BatteryOptBlock r0, boolean r1) {
        r0.firstResume = r1;
    }

    public static final /* synthetic */ void access$setMainHandler$p(BatteryOptBlock r0, Handler r1) {
        r0.mainHandler = r1;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public /* bridge */ /* synthetic */ void bindModel(IBlockModel r1) {
        bindModel((KeyFeatureModel) r1);
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final void setIcon(ImageView r1) {
        this.icon = r1;
    }

    public final OTextView getTitle() {
        return this.title;
    }

    public final void setTitle(OTextView r1) {
        this.title = r1;
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(final View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.icon = (ImageView) r5.findViewById(R.id.icon);
        this.title = (OTextView) r5.findViewById(R.id.title);
        this.label = (OTextView) r5.findViewById(R.id.label);
        ImageView r0 = this.icon;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.setImageDrawable(AppCompatResources.getDrawable(r0.getContext(), R.drawable.battery_opt));
    L5:
        OTextView r1 = this.title;
        View r2 = null;
        if (r1 == null) goto L13;
        if (r1 == null) goto L11;
        Context r3 = r1.getContext();
        if (r3 == null) goto L11;
        String r4 = r3.getString(R.string.power_optimization);
    L12:
        r1.setText(r4);
    L11:
        r4 = null;
    L13:
        this.mainHandler = new Handler(Looper.getMainLooper(), this.handlerCallback);
        if ((r5 instanceof OUILinearLayout) == false) goto L17;
        r2 = r5;
    L17:
        OUILinearLayout r6 = (OUILinearLayout) r2;
        if (r6 == null) goto L20;
        r6.setRadius(DisplayHelper.dpToPx(16));
    L20:
        r5.setOnClickListener(new AnonymousClass1(r5));
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
        ImageView r0 = this.icon;
        Context r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L6:
        PreferenceMgr r3 = PreferenceMgr.getInstance(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "PreferenceMgr.getInstance(icon?.context)");
        if (r3.isAllowed() == true) goto L13;
        ImageView r4 = this.icon;
        if (r4 == null) goto L12;
        r1 = r4.getContext();
    L12:
        if (PreferenceMgr.getInstance(r1).getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L13;
        return;
    L13:
        ImageView r5 = this.icon;
        if (r5 == null) goto L20;
        Context r6 = r5.getContext();
        if (r6 == null) goto L21;
        r6.registerReceiver(this.batteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        super.onPause();
        ImageView r0 = this.icon;
        Context r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L6:
        PreferenceMgr r3 = PreferenceMgr.getInstance(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "PreferenceMgr.getInstance(icon?.context)");
        if (r3.isAllowed() == true) goto L13;
        ImageView r4 = this.icon;
        if (r4 == null) goto L12;
        r1 = r4.getContext();
    L12:
        if (PreferenceMgr.getInstance(r1).getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L13;
        return;
    L13:
        ImageView r5 = this.icon;
        if (r5 == null) goto L20;
        Context r6 = r5.getContext();
        if (r6 == null) goto L21;
        r6.unregisterReceiver(this.batteryInfoReceiver);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void remainTimeUpdate(int r9) {
        ImageView r0 = this.icon;
        String r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L7:
        if (isPowerMode(r2) == false) goto L15;
        long r4 = PowerAdvisorService.computePowerSavingModeBatteryTimeRemaining() / ((long) 1000000);
        if (r4 >= 60) goto L21;
        ImageView r3 = this.icon;
        if (r3 == null) goto L13;
        Context r5 = r3.getContext();
    L14:
        r4 = ((BatteryUtil.getBatteryTimeRemainingMs(r5) / ((long) 1000)) * ((long) 16)) / ((long) 15);
        goto L21
    L13:
        r5 = null;
    L21:
        if (r4 < 60) goto L25;
        OTextView r8 = this.label;
        if (r8 == null) goto L34;
        r8.setText(SecurityCenterApplication.getApplication().getString(R.string.remaining) + BatteryPowerActivityViewModel.Companion.formatDurationForCharacters(r4));
        return;
    L34:
        return;
    L25:
        OTextView r6 = this.label;
        if (r6 == null) goto L36;
        StringBuilder r7 = new StringBuilder();
        OTextView r10 = this.title;
        if (r10 == null) goto L32;
        Context r11 = r10.getContext();
        if (r11 == null) goto L32;
        r1 = r11.getString(R.string.current_battery_level);
    L32:
        r6.setText(r7.append(r1).append(" ").append(String.valueOf(r9)).append("%").toString());
        return;
    L36:
        return;
    L15:
        ImageView r12 = this.icon;
        if (r12 == null) goto L18;
        Context r13 = r12.getContext();
    L19:
        r4 = BatteryUtil.getBatteryTimeRemainingMs(r13) / ((long) 1000);
        goto L21
    L18:
        r13 = null;
        goto L19
    L5:
        r2 = null;
        goto L7
    }

    public final boolean isPowerMode(Context r2) {
        if (r2 == null) goto L4;
        ContentResolver r1 = r2.getContentResolver();
    L6:
        if (Settings.Global.getInt(r1, "low_power", 0) == 0) goto L9;
        return true;
    L9:
        return false;
    L4:
        r1 = null;
        goto L6
    }

    public void bindModel(KeyFeatureModel r1) {
        super.bindModel(r1);
    }
}
