package com.android.server.pm;

import android.os.SystemProperties;
import android.util.Slog;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;
import com.obric.app.ObricAssistUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricInstallPackageHelperImpl implements IObricInstallPackageHelper {
    private static final boolean ENABLE_FORBID_INSTALL = false;
    private static final List<String> FORBIDDEN_INSTALL_PACKAGES = null;
    private static final String TAG = "ObricInstallPackageHelperImpl";
    private final InstallPackageHelper mBase;

    public ObricInstallPackageHelperImpl(InstallPackageHelper base) {
        this.mBase = base;
    }

    static {
        ENABLE_FORBID_INSTALL = SystemProperties.getBoolean("persist.sys.forbid_install", true);
        FORBIDDEN_INSTALL_PACKAGES = Arrays.asList(new String[]{"com.larus.nova.dorag"});
    }

    public boolean deletePackageForAssist(String packageName, ParsedPackage parsedPackage) {
        if (ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA.equals(packageName) == true) goto L6;
        return false;
    L6:
        PackageManagerServiceUtils.logCriticalInfo(5, "System package enabled, only for assist package; name: " + parsedPackage.getPackageName() + "; version: " + parsedPackage.getLongVersionCode() + "; path: " + parsedPackage.getPath());
        PackageFreezer freezer = this.mBase.mPm.freezePackage(parsedPackage.getPackageName(), -1, "scanPackageInternalLI", 13, null);
        this.mBase.mDeletePackageHelper.deletePackageLIF(parsedPackage.getPackageName(), null, true, this.mBase.mPm.mUserManager.getUserIds(), 0, new PackageRemovedInfo(), false);     // Catch: Throwable -> L12
        if (freezer == null) goto L10;
        freezer.close();
    L10:
        this.mBase.mPm.getObricExt().setPendingClearAppData(ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA);
        return true;
    L12:
        th = move-exception;
        if (freezer == null) goto L24;
        freezer.close();     // Catch: Throwable -> L17
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L24:
        throw th;
    }

    public void checkAssistInstallRestriction(ParsedPackage parsedPackage) throws PrepareFailure {
        if (ENABLE_FORBID_INSTALL == true) goto L5;
        return;
    L5:
        String pkgName = parsedPackage.getPackageName();
        if (FORBIDDEN_INSTALL_PACKAGES.contains(pkgName) == true) goto L25;
        if (ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA.equals(pkgName) == true) goto L10;
        return;
    L10:
        Iterator r1 = parsedPackage.getServices().iterator();
    L12:
        if (r1.hasNext() == false) goto L22;
        ParsedService service = (ParsedService) r1.next();
        Iterator r6 = service.getIntents().iterator();
    L15:
        if (r6.hasNext() == false) goto L12;
        ParsedIntentInfo intentInfo = (ParsedIntentInfo) r6.next();
        if (intentInfo.getIntentFilter().hasAction(ObricAssistUtils.getAssistantServiceName()) == false) goto L15;
        Slog.d(TAG, " install assistant allowed");
        return;
    L22:
        Slog.w(TAG, "forbid install non assistant pkg");
        throw new PrepareFailure(-115, "Installing " + pkgName + " is not allowed assistant");
    L25:
        throw new PrepareFailure(-115, "Installing " + pkgName + " is not allowed");
    }
}
