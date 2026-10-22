package com.android.settings.devicecredential;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.overlay.SurveyFeatureProvider;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnResume;

/* JADX INFO: loaded from: classes2.dex */
public class SurveyMixin implements LifecycleObserver, OnResume {
    private Fragment mFragment;
    private String mName;

    public SurveyMixin(Fragment r1, String r2) {
        this.mName = r2;
        this.mFragment = r1;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnResume
    public void onResume() {
        FragmentActivity r0 = this.mFragment.getActivity();
        if (r0 == null) goto L8;
        SurveyFeatureProvider r1 = FeatureFactory.getFeatureFactory().getSurveyFeatureProvider(r0);
        if (r1 == null) goto L9;
        r1.sendActivityIfAvailable(this.mName);
        return;
    L9:
        return;
    }
}
