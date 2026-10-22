package com.obric.securitycenter.nodisturb;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.obric.securitycenter.nodisturb.setting.slot.InterceptSettingSlotFactory;
import com.obric.slot.SlotHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterceptSettingActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/securitycenter/nodisturb/InterceptSettingActivity;", "Lcom/obric/securitycenter/nodisturb/BaseActivity;", "()V", "slotHost", "Lcom/obric/slot/SlotHost;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "scene", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InterceptSettingActivity extends BaseActivity {
    private SlotHost slotHost;

    @Override // com.obric.securitycenter.nodisturb.BaseActivity
    public String scene() {
        return "intercept_setting_page";
    }

    public InterceptSettingActivity() {
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.intercept_settings_layout);
        initTitleBar(false, false);
        SlotHost r5 = new SlotHost();
        View r0 = findViewById(R.id.intercept_rules_container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById<ViewGroup>(…ntercept_rules_container)");
        InterceptSettingActivity r2 = this;
        r5.addSlot((ViewGroup) r0, InterceptSettingSlotFactory.INSTANCE.createInterceptRuleGroup(r2));
        View r1 = findViewById(R.id.number_management_container);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById<ViewGroup>(…ber_management_container)");
        r5.addSlot((ViewGroup) r1, InterceptSettingSlotFactory.INSTANCE.createNumberManagementGroup(r2));
        this.slotHost = r5;
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        SlotHost r0 = this.slotHost;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slotHost");
        r0 = null;
    L5:
        r0.refresh();
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        SlotHost r0 = this.slotHost;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slotHost");
        r0 = null;
    L5:
        r0.destroy();
        super.onDestroy();
    }
}
