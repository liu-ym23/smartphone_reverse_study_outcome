package com.obric.server.security;

import android.content.Context;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public interface IObricSecurityPlugin {

    public interface Creator {
        IObricSecurityPlugin createPlugin(Context r1);

        String getPermission();

        boolean isEnable();
    }

    IBinder asBinder();

    void onStart();

    void onStop();
}
