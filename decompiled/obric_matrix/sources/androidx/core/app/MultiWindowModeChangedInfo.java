package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class MultiWindowModeChangedInfo {
    private final boolean mIsInMultiWindowMode;
    private final Configuration mNewConfig;

    public MultiWindowModeChangedInfo(boolean r1) {
        this.mIsInMultiWindowMode = r1;
        this.mNewConfig = null;
    }

    @RequiresApi(26)
    public MultiWindowModeChangedInfo(boolean r1, @NonNull Configuration r2) {
        this.mIsInMultiWindowMode = r1;
        this.mNewConfig = r2;
    }

    @NonNull
    @RequiresApi(26)
    public Configuration getNewConfig() {
        Configuration r1 = this.mNewConfig;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }

    public boolean isInMultiWindowMode() {
        return this.mIsInMultiWindowMode;
    }
}
