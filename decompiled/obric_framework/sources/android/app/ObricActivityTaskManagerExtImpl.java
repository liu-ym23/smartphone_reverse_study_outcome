package android.app;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class ObricActivityTaskManagerExtImpl implements IObricActivityTaskManagerExt {
    private static final String TAG = "ObricActivityTaskManagerExtImpl";

    public ObricActivityTaskManagerExtImpl() {
    }

    public boolean registerAppSwitchListener(IObricAppSwitchListener listener) {
        return ActivityTaskManager.getService().getIObricExt().registerAppSwitchListener(listener);
    L5:
        return false;
    }

    public boolean unregisterAppSwitchListener(IObricAppSwitchListener listener) {
        return ActivityTaskManager.getService().getIObricExt().unregisterAppSwitchListener(listener);
    L5:
        return false;
    }

    public boolean updateAgentInfo(Bundle bundle) {
        return ActivityTaskManager.getService().getIObricExt().updateAgentInfo(bundle);
    L5:
        return false;
    }

    public void reportClickViewTreeRecord(String eventId, String fingerprint, Bundle record, AssistStructure structure) {
        ActivityTaskManager.getService().getIObricExt().reportClickViewTreeRecord(eventId, fingerprint, record, structure);     // Catch: RemoteException -> L4
        return;
    }
}
