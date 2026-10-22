package com.bytedanceos.security.debug;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;

/* JADX INFO: compiled from: SettingsManageActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e¸\u0006\u0000"}, d2 = {"com/bytedanceos/security/debug/SettingsManageActivity$onCreate$1$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsManageActivity$onCreate$$inlined$apply$lambda$1 implements TextWatcher {
    final /* synthetic */ SettingsManageActivity this$0;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    SettingsManageActivity$onCreate$$inlined$apply$lambda$1(SettingsManageActivity r1) {
        this.this$0 = r1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        SettingsManageActivity r0 = this.this$0;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        SettingsManageActivity.access$applySearch(r0, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
