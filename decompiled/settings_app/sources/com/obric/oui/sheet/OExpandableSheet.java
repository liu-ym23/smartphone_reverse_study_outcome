package com.obric.oui.sheet;

import android.app.Dialog;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.common.oui.R;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: OExpandableSheet.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/OExpandableSheet;", "Lcom/obric/oui/sheet/OSheet;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OExpandableSheet extends OSheet {
    public void com_obric_oui_sheet_OExpandableSheet__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_obric_oui_sheet_OExpandableSheet__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_obric_oui_sheet_OExpandableSheet_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_obric_oui_sheet_OExpandableSheet_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OExpandableSheet() {
    }

    @Override // com.obric.oui.sheet.OSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        OBottomSheetDialog r3 = new OBottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme);
        r3.setDismissWithAnimation(false);
        r3.getBehavior().setSkipCollapsed(true);
        r3.getBehavior().setFitToContents(true);
        r3.setIs69Expandable(true);
        return r3;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_obric_oui_sheet_OExpandableSheet_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OExpandableSheet r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_obric_oui_sheet_OExpandableSheet__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_obric_oui_sheet_OExpandableSheet_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OExpandableSheet r2) {
        String r0 = r2.getClass().getName();
        com_obric_oui_sheet_OExpandableSheet_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_obric_oui_sheet_OExpandableSheet_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OExpandableSheet r2) {
        String r0 = r2.getClass().getName();
        r2.com_obric_oui_sheet_OExpandableSheet__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
