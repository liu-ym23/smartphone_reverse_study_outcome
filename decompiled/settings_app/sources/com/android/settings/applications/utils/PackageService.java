package com.android.settings.applications.utils;

import com.android.settings.applications.AppStateBaseBridge;
import com.android.settingslib.applications.ApplicationsState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PackageUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/android/settings/applications/utils/PackageService;", "", "appbridge", "Lcom/android/settings/applications/AppStateBaseBridge;", "session", "Lcom/android/settingslib/applications/ApplicationsState$Session;", "Lcom/android/settingslib/applications/ApplicationsState;", "(Lcom/android/settings/applications/AppStateBaseBridge;Lcom/android/settingslib/applications/ApplicationsState$Session;)V", "getAppbridge", "()Lcom/android/settings/applications/AppStateBaseBridge;", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "getSession", "()Lcom/android/settingslib/applications/ApplicationsState$Session;", "onClear", "", "pause", "reset", "resume", "setIsUpdating", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PackageService {
    private final AppStateBaseBridge appbridge;
    private boolean isUpdating;
    private final ApplicationsState.Session session;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageService() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public PackageService(AppStateBaseBridge r1, ApplicationsState.Session r2) {
        this.appbridge = r1;
        this.session = r2;
    }

    public /* synthetic */ PackageService(AppStateBaseBridge r2, ApplicationsState.Session r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final AppStateBaseBridge getAppbridge() {
        return this.appbridge;
    }

    public final ApplicationsState.Session getSession() {
        return this.session;
    }

    public final boolean isUpdating() {
        return this.isUpdating;
    }

    public final void setUpdating(boolean r1) {
        this.isUpdating = r1;
    }

    public final void resume() {
        AppStateBaseBridge r0 = this.appbridge;
        if (r0 == null) goto L5;
        r0.resume();
    L5:
        ApplicationsState.Session r1 = this.session;
        if (r1 == null) goto L9;
        r1.onResume();
        return;
    }

    public final void pause() {
        AppStateBaseBridge r0 = this.appbridge;
        if (r0 == null) goto L5;
        r0.pause();
    L5:
        ApplicationsState.Session r1 = this.session;
        if (r1 == null) goto L9;
        r1.onPause();
        return;
    }

    public final void onClear() {
        AppStateBaseBridge r0 = this.appbridge;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        ApplicationsState.Session r1 = this.session;
        if (r1 == null) goto L9;
        r1.onDestroy();
        return;
    }

    public final void reset() {
        this.isUpdating = false;
    }

    public final void setIsUpdating(boolean r1) {
        this.isUpdating = r1;
    }
}
