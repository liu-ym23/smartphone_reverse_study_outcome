package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.IApplicationThread;
import android.util.Slog;
import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;
import com.obric.internal.app.ObricAssistUtils;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObricActivityStarterImpl implements IObricActivityStarter {
    private static final String TAG = "ObricActivityStarterImpl";
    private final ActivityStarter mBase;
    private ActivityTaskManagerService mService;

    public static /* synthetic */ void $r8$lambda$SloAPugOh88rqZ2UKW8iUtNCZdY(ObricActivityStarterImpl r0, ActivityRecord r1, LaunchParamsController.LaunchParams r2, ActivityOptions[] r3, DisplayContent r4) {
        r0.lambda$adjustLaunchParams$0(r1, r2, r3, r4);
    }

    public ObricActivityStarterImpl(ActivityStarter activityStarter) {
        this.mBase = activityStarter;
    }

    public void setService(ActivityTaskManagerService service) {
        this.mService = service;
    }

    public boolean blockAppLaunch(DisplayContent displayContent, String packageName) {
        if (displayContent.getObricExtWindowContainer().inObricVirtualDisplay() == true) goto L5;
        return false;
    L5:
        if (this.mService.getObricExt().isAppBlockedByAuto(packageName) == false) goto L10;
        this.mService.mRootWindowContainer.mWindowManager.getObricExt().onAutoBlacklistAppOpen(packageName);
        return true;
    L10:
        return false;
    }

    public boolean recycleTask(Task reusedTask, LaunchParamsController.LaunchParams launchParams) {
        if (launchParams != null) goto L4;
        return false;
    L4:
        if (launchParams.mPreferredTaskDisplayArea != null) goto L6;
        return false;
    L6:
        if (launchParams.mPreferredTaskDisplayArea.getDisplayContent() != null) goto L8;
        return false;
    L8:
        if (launchParams.mPreferredTaskDisplayArea.getDisplayContent().getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L20;
        if (reusedTask != null) goto L11;
        return false;
    L11:
        if (reusedTask.getDisplayId() == 0) goto L13;
        return false;
    L13:
        if (reusedTask.isVisible() == false) goto L23;
        this.mService.mWindowManager.getObricExt().reportErrorToListener(-1, 4);
        Slog.e(TAG, "Attempted to start a visible task on display 0");
        return true;
    L23:
        return false;
    L20:
        return false;
    }

    private boolean isOAutoVDPlayerTopActivity(ActivityRecord r) {
        if (Objects.equals(r.packageName, ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA) == true) goto L5;
        return false;
    L5:
        DisplayContent defaultDc = this.mService.mRootWindowContainer.getDisplayContent(0);
        if (defaultDc != null) goto L8;
        return false;
    L8:
        ActivityRecord topActivity = defaultDc.getTopActivity(true, true);
        if (topActivity != null) goto L11;
        return false;
    L11:
        if (Objects.equals(topActivity.mActivityComponent.getClassName(), "com.obric.autoaction.vdplayer.VDPlayerStubActivity") == true) goto L13;
        return false;
    L13:
        return true;
    }

    private DisplayContent resolveTargetDisplayContent(LaunchParamsController.LaunchParams launchParams, ActivityOptions options) {
        if (launchParams == null) goto L9;
        if (launchParams.mPreferredTaskDisplayArea == null) goto L9;
        DisplayContent displayContent = launchParams.mPreferredTaskDisplayArea.getDisplayContent();
        if (displayContent == null) goto L9;
        return displayContent;
    L9:
        if (options == null) goto L11;
        int launchDisplayId = options.getLaunchDisplayId();
    L12:
        if (launchDisplayId != (-1)) goto L16;
        return null;
    L16:
        return this.mService.mRootWindowContainer.getDisplayContent(launchDisplayId);
    L11:
        launchDisplayId = -1;
        goto L12
    }

    private void cleanupStaleAutoActionSecondaryHomeIfNeeded(LaunchParamsController.LaunchParams launchParams, ActivityRecord r, ActivityOptions options) {
        if (r != null) goto L4;
        return;
    L4:
        if (r.isActivityTypeHome() == true) goto L6;
        return;
    L6:
        if (ObricAssistUtils.isSecondaryHomeIntent(r.intent) == false) goto L26;
        DisplayContent targetDisplay = resolveTargetDisplayContent(launchParams, options);
        if (targetDisplay != null) goto L11;
        return;
    L11:
        if (targetDisplay.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L24;
        int targetDisplayId = targetDisplay.getDisplayId();
        if (targetDisplayId != 0) goto L16;
        return;
    L16:
        if (targetDisplayId == (-1)) goto L23;
        this.mService.getObricExt().cleanupStaleAutoActionSecondaryHomeExceptDisplay(targetDisplayId);
        return;
    L23:
        return;
    L24:
        return;
    }

    public ActivityOptions adjustLaunchParams(final LaunchParamsController.LaunchParams launchParams, final ActivityRecord r, ActivityOptions options) {
        if (options != null) goto L4;
    L9:
        final ActivityOptions[] adjustedOptions = {options};
        this.mService.mRootWindowContainer.forAllDisplays(new ObricActivityStarterImpl$$ExternalSyntheticLambda0(this, r, launchParams, adjustedOptions));
        cleanupStaleAutoActionSecondaryHomeIfNeeded(launchParams, r, adjustedOptions[0]);
        return adjustedOptions[0];
    L4:
        if (options.getLaunchDisplayId() == (-1)) goto L9;
        if (Objects.equals(r.packageName, ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA) == false) goto L9;
        Slog.d(TAG, " the package has set the displayid");
        return options;
    }

    private /* synthetic */ void lambda$adjustLaunchParams$0(ActivityRecord r, LaunchParamsController.LaunchParams launchParams, ActivityOptions[] adjustedOptions, DisplayContent dc) {
        if (dc.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L21;
        ActivityRecord ac = dc.getTopActivity(true, true);
        if (ac != null) goto L7;
        return;
    L7:
        if (ac.getActivityType() != 2) goto L9;
        return;
    L9:
        if (ac.packageName != null) goto L11;
        return;
    L11:
        if (Objects.equals(ac.packageName, r.launchedFromPackage) == true) goto L13;
        return;
    L13:
        if (this.mService.mWindowManager.getObricExt().isPackageVisibleOnDisplay(ac.packageName, 0) == true) goto L15;
    L16:
        launchParams.mPreferredTaskDisplayArea = dc.getDefaultTaskDisplayArea();
        if (adjustedOptions[0] == null) goto L19;
        adjustedOptions[0].setLaunchDisplayId(dc.getDisplayId());
        return;
    L19:
        adjustedOptions[0] = ActivityOptions.makeBasic().setLaunchDisplayId(dc.getDisplayId());
        return;
    L15:
        if (isOAutoVDPlayerTopActivity(ac) == true) goto L16;
        return;
    }

    public boolean shouldBlockAutoVirtualDisplayLaunch(int callingUid, ActivityOptions options, ActivityRecord sourceRecord, IApplicationThread caller) {
        if (caller != null) goto L5;
        return false;
    L5:
        WindowProcessController callerApp = this.mService.getProcessController(caller);
        if (callerApp != null) goto L8;
        return false;
    L8:
        if (options == null) goto L10;
        ActivityOptions checkedOptions = options;
    L11:
        ArrayList<ActivityRecord> activities = callerApp.getActivities();
        TaskDisplayArea srcTda = getVisibleActivityDisplayArea(activities);
        if (srcTda == null) goto L14;
        int srcDisplayId = srcTda.getDisplayId();
    L15:
        if (sourceRecord == null) goto L17;
        srcDisplayId = sourceRecord.getDisplayId();
    L17:
        int launchDisplayId = checkedOptions.getLaunchDisplayId();
        int autoDisplayId = this.mService.mWindowManager.getObricExt().getAutoDisplayId();
        if (autoDisplayId == 0) goto L25;
        if (launchDisplayId != autoDisplayId) goto L25;
        if (srcDisplayId == autoDisplayId) goto L25;
        if (ObricPermissionCheckHelper.isSystemApp(this.mService.getUiContext(), callingUid) == true) goto L25;
        Slog.w(TAG, "Blocking background activity launch to oAuto virtual display " + autoDisplayId + " from non-system uid " + callingUid + ", srcDisplayId: " + srcDisplayId);
        return true;
    L25:
        return false;
    L14:
        srcDisplayId = -1;
        goto L15
    L10:
        checkedOptions = BackgroundActivityStartController.ACTIVITY_OPTIONS_SYSTEM_DEFINED;
        goto L11
    }

    TaskDisplayArea getVisibleActivityDisplayArea(ArrayList<ActivityRecord> activities) {
        if (activities.isEmpty() == false) goto L5;
        return null;
    L5:
        int index = 0;
    L7:
        if (index >= activities.size()) goto L15;
        ActivityRecord activity = activities.get(index);
        if (activity.isVisible() == false) goto L14;
        if (activity.getDisplayArea() == null) goto L14;
        return activity.getDisplayArea();
    L14:
        index = index + 1;
        goto L7
    L15:
        return null;
    }
}
