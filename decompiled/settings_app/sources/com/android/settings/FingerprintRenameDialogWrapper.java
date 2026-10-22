package com.android.settings;

import android.content.Context;
import android.hardware.fingerprint.Fingerprint;
import android.text.InputFilter;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OInputLayout;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintRenameDialogWrapper {
    private final Context mContext;
    private Fingerprint mFingerprint;
    private final BaseFragment mFragment;
    private OInputLayout mInputText;
    private OSimpleFormDialog mOInsetSheet;
    private OButton mPositiveBtn;
    private PostCallback mPostCallback;

    public interface PostCallback {
        void postExec();
    }

    static /* synthetic */ OInputLayout access$000(FingerprintRenameDialogWrapper r0) {
        return r0.mInputText;
    }

    static /* synthetic */ Fingerprint access$100(FingerprintRenameDialogWrapper r0) {
        return r0.mFingerprint;
    }

    static /* synthetic */ Context access$200(FingerprintRenameDialogWrapper r0) {
        return r0.mContext;
    }

    static /* synthetic */ PostCallback access$300(FingerprintRenameDialogWrapper r0) {
        return r0.mPostCallback;
    }

    static /* synthetic */ OSimpleFormDialog access$400(FingerprintRenameDialogWrapper r0) {
        return r0.mOInsetSheet;
    }

    public FingerprintRenameDialogWrapper(BaseFragment r1, Fingerprint r2) {
        this.mFragment = r1;
        this.mContext = r1._mActivity;
        this.mFingerprint = r2;
    }

    public FingerprintRenameDialogWrapper setPostCallback(PostCallback r1) {
        this.mPostCallback = r1;
        return this;
    }

    public void show() {
        if (this.mOInsetSheet != null) goto L5;
        ODialogUtils r1 = ODialogUtils.INSTANCE;
        Context r2 = this.mContext;
        this.mOInsetSheet = r1.getMiscDialog(r2, r2.getString(R.string.user_rename), "", this.mContext.getString(R.string.save), this.mContext.getString(R.string.cancel), "", "", false, new AnonymousClass1(this), new AnonymousClass2(this));
    L5:
        this.mInputText = ODialogUtils.INSTANCE.getInputView(this.mOInsetSheet);
        ODialogUtils.INSTANCE.initInputView(this.mOInsetSheet, this.mFingerprint.getName());
        this.mInputText.showClear(true);
        if (this.mFingerprint.getName() == null) goto L8;
        this.mInputText.getVInput().setText(this.mFingerprint.getName());
        this.mInputText.getVInput().setSelection(this.mFingerprint.getName().length());
    L8:
        this.mInputText.getVInput().setSelectAllOnFocus(true);
        this.mInputText.getVInput().setFilters(new InputFilter[]{new Utf8ByteLengthFilter(Utils.DEVICE_NAME_MAX_LENGTH)});
        this.mInputText.getVInput().addTextChangedListener(new AnonymousClass3(this));
        this.mOInsetSheet.show();
    }
}
