package com.obric.matrix.location.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.matrix.location.f;
import com.obric.matrix.r.c.c;

/* JADX INFO: loaded from: classes2.dex */
public class LocationService extends Service {
    public LocationService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        if (r1 == null) goto L9;
        String r4 = r1.getAction();
        if (r4 == null) goto L9;
        if (r4.equals("obric.intent.action.location.LOCATION_ALARM") == false) goto L9;
        c.j("LocationService", "onStartCommand: action: obric.intent.action.location.LOCATION_ALARM");
        f.o().v();
    L9:
        return 1;
    }
}
