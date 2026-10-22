package com.android.settings.users;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.settings.applications.PickApplicationActivity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UserFeatureProviderImpl implements UserFeatureProvider {
    UserManager mUm;

    public UserFeatureProviderImpl(Context r2) {
        this.mUm = (UserManager) r2.getSystemService(PickApplicationActivity.EXTRA_USER);
    }

    @Override // com.android.settings.users.UserFeatureProvider
    public List<UserHandle> getUserProfiles() {
        return this.mUm.getUserProfiles();
    }
}
