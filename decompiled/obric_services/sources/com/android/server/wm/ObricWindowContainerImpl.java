package com.android.server.wm;

/* JADX INFO: loaded from: classes.dex */
public class ObricWindowContainerImpl implements IObricWindowContainer {
    private final WindowContainer mBase;

    public ObricWindowContainerImpl(WindowContainer base) {
        this.mBase = base;
    }

    public boolean inObricVirtualDisplay() {
        if (this.mBase.getDisplayContent() != null) goto L11;
        if (this.mBase.asDisplayContent() != null) goto L7;
        return false;
    L7:
        return this.mBase.asDisplayContent().getDisplay().getObricExt().isObricVirtualDisplay();
    L11:
        return this.mBase.getDisplayContent().getDisplay().getObricExt().isObricVirtualDisplay();
    }

    public DisplayContent getTopFocusedDisplayContent(int displayId) {
        if ((this.mBase instanceof RootWindowContainer) == false) goto L12;
        RootWindowContainer root = this.mBase;
        final DisplayContent[] dc = {root.getDisplayContent(displayId)};
        if (root.mWindowManager.getObricExt().shouldDispatchToAutoDisplay() == false) goto L8;
        root.forAllDisplays(new ObricWindowContainerImpl$$ExternalSyntheticLambda0(dc));
    L8:
        if (dc[0] == null) goto L11;
        return dc[0];
    L11:
        return root.getDisplayContent(0);
    L12:
        return null;
    }

    static /* synthetic */ void lambda$getTopFocusedDisplayContent$0(DisplayContent[] dc, DisplayContent candidate) {
        if (candidate.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L6;
        dc[0] = candidate;
        return;
    }
}
