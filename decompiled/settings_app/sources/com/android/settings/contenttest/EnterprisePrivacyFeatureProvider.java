package com.android.settings.contenttest;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public interface EnterprisePrivacyFeatureProvider {
    CharSequence getDeviceOwnerDisclosure();

    String getDeviceOwnerOrganizationName();

    String getImeLabelIfOwnerSet();

    Date getLastBugReportRequestTime();

    Date getLastNetworkLogRetrievalTime();

    Date getLastSecurityLogRetrievalTime();

    int getMaximumFailedPasswordsBeforeWipeInCurrentUser();

    int getMaximumFailedPasswordsBeforeWipeInManagedProfile();

    int getNumberOfActiveDeviceAdminsForCurrentUserAndManagedProfile();

    int getNumberOfOwnerInstalledCaCertsForCurrentUser();

    int getNumberOfOwnerInstalledCaCertsForManagedProfile();

    boolean hasDeviceOwner();

    boolean hasWorkPolicyInfo();

    boolean isAlwaysOnVpnSetInCurrentUser();

    boolean isAlwaysOnVpnSetInManagedProfile();

    boolean isInCompMode();

    boolean isNetworkLoggingEnabled();

    boolean isSecurityLoggingEnabled();

    boolean showParentalControls();

    boolean showWorkPolicyInfo(Context r1);
}
