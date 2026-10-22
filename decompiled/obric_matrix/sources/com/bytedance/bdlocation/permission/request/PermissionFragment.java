package com.bytedance.bdlocation.permission.request;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(23)
public class PermissionFragment extends Fragment {
    Permissions.Callback mCallback;

    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public void onCreate(@Nullable Bundle r2) {
        super.onCreate(r2);
        requestPermissions(getArguments().getStringArray("permissions"), 1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int r1, @NonNull String[] r2, @NonNull int[] r3) {
        super.onRequestPermissionsResult(r1, r2, r3);
        Permissions.Callback r4 = this.mCallback;
        if (r4 == null) goto L5;
        r4.onRequestPermissionResult(r2, r3);
    L5:
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }
}
