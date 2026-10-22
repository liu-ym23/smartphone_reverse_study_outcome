package androidx.constraintlayout.core.state;

import androidx.core.location.LocationRequestCompat;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Registry {
    private static final Registry sRegistry = null;
    private HashMap<String, RegistryCallback> mCallbacks;

    static {
        sRegistry = new Registry();
    }

    public Registry() {
        this.mCallbacks = new HashMap();
    }

    public static Registry getInstance() {
        return sRegistry;
    }

    public String currentContent(String r1) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.currentMotionScene();
    }

    public String currentLayoutInformation(String r1) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.currentLayoutInformation();
    }

    public long getLastModified(String r1) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 != null) goto L5;
        return LocationRequestCompat.PASSIVE_INTERVAL;
    L5:
        return r0.getLastModified();
    }

    public Set<String> getLayoutList() {
        return this.mCallbacks.keySet();
    }

    public void register(String r1, RegistryCallback r2) {
        this.mCallbacks.put(r1, r2);
    }

    public void setDrawDebug(String r1, int r2) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 == null) goto L6;
        r0.setDrawDebug(r2);
        return;
    }

    public void setLayoutInformationMode(String r1, int r2) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 == null) goto L6;
        r0.setLayoutInformationMode(r2);
        return;
    }

    public void unregister(String r1, RegistryCallback r2) {
        this.mCallbacks.remove(r1);
    }

    public void updateContent(String r1, String r2) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 == null) goto L6;
        r0.onNewMotionScene(r2);
        return;
    }

    public void updateDimensions(String r1, int r2, int r3) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 == null) goto L6;
        r0.onDimensions(r2, r3);
        return;
    }

    public void updateProgress(String r1, float r2) {
        RegistryCallback r0 = this.mCallbacks.get(r1);
        if (r0 == null) goto L6;
        r0.onProgress(r2);
        return;
    }
}
