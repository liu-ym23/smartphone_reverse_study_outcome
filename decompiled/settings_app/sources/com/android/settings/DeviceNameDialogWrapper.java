package com.android.settings;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.TextView;
import com.android.settings.about.DeviceUtils;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceNameDialogWrapper {
    private final Context mContext;
    private String mDeviceName;
    private OInputLayout mInputText;
    private OListItemSettings mListItem;
    private OCardListItem mListItem2;
    private OSimpleFormDialog mOInsetSheet;

    static /* synthetic */ OSimpleFormDialog access$000(DeviceNameDialogWrapper r0) {
        return r0.mOInsetSheet;
    }

    public DeviceNameDialogWrapper(Context r1) {
        this.mContext = r1;
    }

    public DeviceNameDialogWrapper setDeviceName(String r1) {
        this.mDeviceName = r1;
        return this;
    }

    public DeviceNameDialogWrapper setListItem(OListItemSettings r1) {
        this.mListItem = r1;
        return this;
    }

    public DeviceNameDialogWrapper setListItem(OCardListItem r1) {
        this.mListItem2 = r1;
        return this;
    }

    public void show() {
        if (this.mOInsetSheet != null) goto L5;
        this.mOInsetSheet = new OSimpleFormDialog(this.mContext, new OSimpleFormDialog.Modifier(this.mContext.getString(R.string.device_name_new), "", new OSimpleFormDialog.InputViewConfig(true, false, new DeviceNameDialogWrapper$$ExternalSyntheticLambda0(this)), new OSimpleFormDialog.InputViewConfig(false, false, new DeviceNameDialogWrapper$$ExternalSyntheticLambda1()), new OBaseDialog.ButtonConfig(this.mContext.getString(R.string.save), new DeviceNameDialogWrapper$$ExternalSyntheticLambda2(this), null), new OBaseDialog.ButtonConfig(this.mContext.getString(R.string.cancel), new DeviceNameDialogWrapper$$ExternalSyntheticLambda3(this), null)));
    L5:
        String r0 = this.mDeviceName;
        if (r0 == null) goto L8;
        this.mInputText.setText(r0);
        this.mInputText.getVInput().setSelection(this.mDeviceName.length());
    L8:
        this.mInputText.getVInput().setSelectAllOnFocus(true);
        this.mInputText.getVInput().setFilters(new InputFilter[]{new Utf8ByteLengthFilter(Utils.DEVICE_NAME_MAX_LENGTH)});
        this.mInputText.getVInput().addTextChangedListener(new AnonymousClass1(this));
        this.mInputText.getVInput().requestFocus();
        this.mInputText.getVInput().setOnEditorActionListener(new DeviceNameDialogWrapper$$ExternalSyntheticLambda4(this));
        this.mOInsetSheet.show();
        Window r12 = this.mOInsetSheet.getWindow();
        if (r12 == null) goto L12;
        r12.setSoftInputMode(5);
        return;
    }

    /* JADX INFO: renamed from: lambda$show$0$com-android-settings-DeviceNameDialogWrapper, reason: not valid java name */
    /* synthetic */ Unit m126lambda$show$0$comandroidsettingsDeviceNameDialogWrapper(OInputLayout r2) {
        this.mInputText = r2;
        r2.setHint(this.mContext.getString(R.string.device_name_tips));
        r2.showClear(true);
        r2.setMaxLines(1);
        r2.setEllipsize(TextUtils.TruncateAt.END);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Unit lambda$show$1(OInputLayout r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$show$2$com-android-settings-DeviceNameDialogWrapper, reason: not valid java name */
    /* synthetic */ Unit m127lambda$show$2$comandroidsettingsDeviceNameDialogWrapper() {
        String r0 = this.mInputText.getText().toString().trim();
        DeviceUtils.INSTANCE.changeDeviceName(r0);
        OListItemSettings r1 = this.mListItem;
        if (r1 == null) goto L5;
        r1.setTrailingText(r0);
    L5:
        OCardListItem r2 = this.mListItem2;
        if (r2 == null) goto L8;
        r2.setEndDetailText(r0);
    L8:
        this.mOInsetSheet.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$show$3$com-android-settings-DeviceNameDialogWrapper, reason: not valid java name */
    /* synthetic */ Unit m128lambda$show$3$comandroidsettingsDeviceNameDialogWrapper() {
        this.mOInsetSheet.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$show$4$com-android-settings-DeviceNameDialogWrapper, reason: not valid java name */
    /* synthetic */ boolean m129lambda$show$4$comandroidsettingsDeviceNameDialogWrapper(TextView r1, int r2, KeyEvent r3) {
        if (r2 == 6) goto L5;
        return false;
    L5:
        if (this.mOInsetSheet.getPositiveButton().isEnabled() == false) goto L10;
        this.mOInsetSheet.getPositiveButton().performClick();
        return true;
    L10:
        return false;
    }
}
