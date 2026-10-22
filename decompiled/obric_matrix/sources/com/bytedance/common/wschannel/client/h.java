package com.bytedance.common.wschannel.client;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;

/* JADX INFO: loaded from: classes.dex */
public class h extends b {
    public h(@NonNull c.a r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r1, com.bytedance.common.wschannel.model.a r2) {
        r1.setExtrasClassLoader(ServiceConnectEvent.class.getClassLoader());
        ServiceConnectEvent r3 = (ServiceConnectEvent) r1.getParcelableExtra("service");
        this.f3500a.d(r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
