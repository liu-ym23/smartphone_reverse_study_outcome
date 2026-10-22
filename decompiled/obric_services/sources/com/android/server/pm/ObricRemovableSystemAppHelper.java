package com.android.server.pm;

import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricRemovableSystemAppHelper {
    private static final Set<String> mRemovableSysAppSet = null;

    static {
        mRemovableSysAppSet = Set.of(ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA);
    }

    public ObricRemovableSystemAppHelper(PackageManagerService base) {
        buildRemovableSystemAppSet();
    }

    private void buildRemovableSystemAppSet() {
    }

    public static Set<String> getRemovableSysApp() {
        return mRemovableSysAppSet;
    }

    public static boolean isRemovableSysApp(String pkgName) {
        return getRemovableSysApp().contains(pkgName);
    }
}
