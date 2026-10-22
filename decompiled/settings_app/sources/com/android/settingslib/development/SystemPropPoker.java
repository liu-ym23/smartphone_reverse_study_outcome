package com.android.settingslib.development;

import android.os.AsyncTask;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class SystemPropPoker {
    private static final String TAG = "SystemPropPoker";
    private static final SystemPropPoker sInstance = null;
    private boolean mBlockPokes;

    public static class PokerTask extends AsyncTask<Void, Void, Void> {
        public PokerTask() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        String[] listServices() {
            return ServiceManager.listServices();
        }

        IBinder checkService(String r1) {
            return ServiceManager.checkService(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r11) {
            String[] r12 = listServices();
            if (r12 != null) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(SystemPropPoker.TAG, "There are no services, how odd");
            return null;
        L6:
            int r2 = r12.length;
            int r4 = 0;
        L7:
            if (r4 >= r2) goto L17;
            String r5 = r12[r4];
            IBinder r6 = checkService(r5);
            if (r6 == null) goto L16;
            Parcel r7 = Parcel.obtain();
            r6.transact(1599295570, r7, null, 0);     // Catch: Exception -> L13 RemoteException -> L18
        L13:
            e = move-exception;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(SystemPropPoker.TAG, "Someone wrote a bad service '" + r5 + "' that doesn't like to be poked", e);
        L15:
            r7.recycle();
        L16:
            r4 = r4 + 1;
            goto L7
        L17:
            return null;
        }
    }

    static {
        sInstance = new SystemPropPoker();
    }

    private SystemPropPoker() {
        this.mBlockPokes = false;
    }

    public static SystemPropPoker getInstance() {
        return sInstance;
    }

    public void blockPokes() {
        this.mBlockPokes = true;
    }

    public void unblockPokes() {
        this.mBlockPokes = false;
    }

    public void poke() {
        if (this.mBlockPokes == true) goto L6;
        createPokerTask().execute(new Void[0]);
        return;
    }

    PokerTask createPokerTask() {
        return new PokerTask();
    }
}
