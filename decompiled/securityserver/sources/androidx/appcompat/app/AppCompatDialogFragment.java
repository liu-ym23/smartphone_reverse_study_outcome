package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle r2) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog r3, int r4) {
        if ((r3 instanceof AppCompatDialog) == false) goto L13;
        AppCompatDialog r2 = (AppCompatDialog) r3;
        if (r4 != 1) goto L7;
    L12:
        r2.supportRequestWindowFeature(1);
        return;
    L7:
        if (r4 == 2) goto L12;
        if (r4 != 3) goto L16;
        r3.getWindow().addFlags(24);
        goto L12
    L16:
        return;
    L13:
        super.setupDialog(r3, r4);
    }
}
