package com.bytedance.apm.doctor;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.monitor.util.thread.AsyncTaskManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DoctorManager {
    private final String TYPE;
    private boolean mHasChangedEncrypt;
    private boolean mIsEncrypt;
    private List<ApmListener> mList;

    public interface ApmListener {
        void onDataEvent(int r1, String r2, JSONObject r3);

        void onEvent(String r1, String r2);
    }

    public static class Holder {
        private static final DoctorManager INSTANCE = null;

        static {
            INSTANCE = new DoctorManager(null);
        }

        private Holder() {
        }

        public static /* synthetic */ DoctorManager access$100() {
            return INSTANCE;
        }
    }

    public /* synthetic */ DoctorManager(AnonymousClass1 r1) {
        this();
    }

    public static DoctorManager getInstance() {
        return Holder.access$100();
    }

    public boolean isEncrypt() {
        return this.mIsEncrypt;
    }

    public boolean isEncryptSet() {
        return this.mHasChangedEncrypt;
    }

    public void onDataEvent(final String r4, final JSONObject r5) {
        if (ListUtils.isEmpty(this.mList) == true) goto L8;
        if (r5 == null) goto L9;
        final ArrayList r0 = new ArrayList(this.mList);
        AsyncTaskManager.getInstance().post(new AnonymousClass2(this, r5, r4, r0));
        return;
    L9:
        return;
    }

    public void onEvent(final String r4, final String r5) {
        if (ListUtils.isEmpty(this.mList) == false) goto L5;
        return;
    L5:
        final ArrayList r0 = new ArrayList(this.mList);
        AsyncTaskManager.getInstance().post(new AnonymousClass1(this, r0, r4, r5));
    }

    public void registerApmListener(ApmListener r1) {
        if (r1 == null) goto L5;
        this.mList.add(r1);
        return;
    }

    public void setEncrypt(boolean r2) {
        this.mHasChangedEncrypt = true;
        this.mIsEncrypt = r2;
    }

    private DoctorManager() {
        this.TYPE = "doctor";
        this.mList = new ArrayList();
        this.mHasChangedEncrypt = false;
    }
}
