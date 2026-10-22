package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.ApplicationStatus;

/* JADX INFO: loaded from: classes5.dex */
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    private boolean mDestroyed;

    public RegistrationPolicyApplicationStatus() {
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    protected void init(NetworkChangeNotifierAutoDetect r1) {
        super.init(r1);
        ApplicationStatus.registerApplicationStateListener(this);
        onApplicationStateChange(0);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    protected void destroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        ApplicationStatus.unregisterApplicationStateListener(this);
        this.mDestroyed = true;
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
    public void onApplicationStateChange(int r1) {
        if (ApplicationStatus.hasVisibleActivities() == false) goto L5;
        register();
        return;
    L5:
        unregister();
    }
}
