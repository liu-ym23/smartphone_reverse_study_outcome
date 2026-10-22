package com.android.server.wm;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.ArraySet;
import android.view.InsetsSource;
import android.view.InsetsState;
import android.view.WindowInsets;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricDisplayPolicyImpl implements IObricDisplayPolicy {
    private static final int AUTO_IME_HEIGHT = 58;
    private static final int AUTO_IME_HEIGHT_SPECIAL = 600;
    private static final Set<String> packagesNeedImeHeight = null;
    private DisplayPolicy mBase;
    private Context mContext;
    private DisplayContent mDisplayContent;
    private int mFixStatusBarHeight;
    private Handler mHandler;
    private boolean mIsAutoImeShowing;

    static {
        packagesNeedImeHeight = new ArraySet(Set.of("com.taobao.taobao"));
    }

    public ObricDisplayPolicyImpl(DisplayPolicy base) {
        this.mIsAutoImeShowing = false;
        this.mBase = base;
    }

    public void onInit(DisplayContent displayContent, Context context, Handler handler) {
        this.mDisplayContent = displayContent;
        this.mHandler = handler;
        this.mContext = context;
        Resources res = this.mContext.getResources();
        this.mFixStatusBarHeight = res.getDimensionPixelSize(17106424);
        this.mDisplayContent.getObricExt().syncObricDisplayOverride();
    }

    public boolean checkAllowShowToastWhenLocked(WindowState win, boolean allowShowWhenLocked) {
        return win.getObricExt().shouldShowWhenLocked();
    }

    public boolean isAutoImeShowing() {
        return this.mIsAutoImeShowing;
    }

    public boolean setAutoImeShowing(boolean autoImeShowing) {
        if (this.mIsAutoImeShowing == autoImeShowing) goto L5;
        boolean change = true;
    L6:
        this.mIsAutoImeShowing = autoImeShowing;
        return change;
    L5:
        change = false;
        goto L6
    }

    public DisplayPolicy.DecorInsets.Info getDecorInsetsInfo(int rotation, int w, int h) {
        if (this.mBase.mDisplayContent.getObricExtWindowContainer().inObricVirtualDisplay() == true) goto L5;
        return null;
    L5:
        return this.mBase.mDisplayContent.mWmService.mRoot.getDisplayContent(0).getDisplayPolicy().getDecorInsetsInfo(rotation, w, h);
    }

    public void adjustImeInAuto(InsetsTarget caller, int changedTypes) {
        if (this.mDisplayContent.getObricExtWindowContainer().inObricVirtualDisplay() == true) goto L5;
        return;
    L5:
        if ((WindowInsets.Type.ime() & changedTypes) == 0) goto L12;
        boolean requestedVisible = caller.isRequestedVisible(WindowInsets.Type.ime());
        if (requestedVisible == false) goto L9;
        this.mDisplayContent.mWmService.getObricExt().getLocalService().showImeInAuto(caller.getWindowToken(), this.mDisplayContent.mDisplayId);
        return;
    L9:
        this.mDisplayContent.mWmService.getObricExt().getLocalService().hideImeInAuto(caller.getWindowToken(), this.mDisplayContent.mDisplayId);
        return;
    }

    public void adjustInsetsForWindow(WindowState target, InsetsState state) {
        if (this.mBase.mDisplayContent.getObricExtWindowContainer().inObricVirtualDisplay() == true) goto L6;
        return;
    L6:
        if (target.getDisplayContent().getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L16;
        state.getOrCreateSource(InsetsSource.ID_OBRIC_VIRTUAL_DISPLAY_STATUS, WindowInsets.Type.statusBars()).setFrame(0, 0, this.mDisplayContent.getWindowConfiguration().getBounds().width(), this.mFixStatusBarHeight);
        if (this.mIsAutoImeShowing == false) goto L14;
        state.getOrCreateSource(InsetsSource.ID_OBRIC_VIRTUAL_DISPLAY_IME, WindowInsets.Type.ime()).setFrame(0, this.mDisplayContent.getWindowConfiguration().getBounds().height() - 58, 1, this.mDisplayContent.getWindowConfiguration().getBounds().height()).setVisible(true);
        if (packagesNeedImeHeight.contains(target.getOwningPackage()) == true) goto L12;
        return;
    L12:
        if (target.getName().contains("PopupWindow") == false) goto L18;
        state.getOrCreateSource(InsetsSource.ID_OBRIC_VIRTUAL_DISPLAY_IME, WindowInsets.Type.ime()).setFrame(0, this.mDisplayContent.getWindowConfiguration().getBounds().height() - 600, 1, this.mDisplayContent.getWindowConfiguration().getBounds().height()).setVisible(true);
        return;
    L18:
        return;
    L14:
        state.removeSource(InsetsSource.ID_OBRIC_VIRTUAL_DISPLAY_IME);
        return;
    }
}
