package com.android.settings.bluetooth;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.android.settings.databinding.ProfileDisconnectDialogBinding;
import com.android.settings.utils.ResourceUtils;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileDisconnectDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/android/settings/bluetooth/ProfileDisconnectDialog;", "Lcom/obric/oui/sheet/OInsetSheet;", "context", "Landroid/content/Context;", "profileName", "", "from", "onNativeBtnClick", "Lkotlin/Function0;", "", "onPositiveBtnClick", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ProfileDisconnectDialog extends OInsetSheet {
    public ProfileDisconnectDialog(Context r3, String r4, String r5, final Function0<Unit> r6, final Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "profileName");
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r6, "onNativeBtnClick");
        Intrinsics.checkNotNullParameter(r7, "onPositiveBtnClick");
        super(r3);
        ProfileDisconnectDialogBinding r0 = ProfileDisconnectDialogBinding.inflate(LayoutInflater.from(r3));
        Intrinsics.checkNotNullExpressionValue(r0, "inflate(...)");
        r0.desName.setText(r4);
        r0.desName2.setText(r5);
        setContainerView(r0.getRoot());
        setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OSelectionPanelBtnView r8 = new OSelectionPanelBtnView(r3, null, 2, null);
        r8.getBtnNegative().setText(ResourceUtils.getString(R.string.cancel));
        r8.getBtnNegative().setOnClickListener(new ProfileDisconnectDialog$$ExternalSyntheticLambda0(this, r6));
        r8.getBtnPositive().setText(ResourceUtils.getString(R.string.ok));
        r8.getBtnPositive().setOnClickListener(new ProfileDisconnectDialog$$ExternalSyntheticLambda1(this, r7));
        setFooterView(r8);
    }

    static final void lambda$3$lambda$1(ProfileDisconnectDialog r0, Function0 r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$onNativeBtnClick");
        r0.dismiss();
        r1.invoke();
    }

    static final void lambda$3$lambda$2(ProfileDisconnectDialog r0, Function0 r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$onPositiveBtnClick");
        r0.dismiss();
        r1.invoke();
    }
}
