package com.android.settings.sensor;

import android.content.Context;
import com.qualcomm.qcnvitems.QcNvItems;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class QcnvApi {
    private QcNvItems mNv;

    public QcnvApi(Context r2) {
        this.mNv = new QcNvItems(r2.getApplicationContext());
    }

    public void set_g_sensor(int r1, int r2, int r3) throws IOException {
        this.mNv.set_g_sensor(r1, r2, r3);
    }
}
