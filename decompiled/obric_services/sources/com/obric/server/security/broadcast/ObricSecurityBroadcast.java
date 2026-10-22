package com.obric.server.security.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import com.obric.server.security.IObricSecurityPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityBroadcast implements IObricSecurityPlugin {
    public static final IObricSecurityPlugin.Creator CREATOR = null;
    private static final String TAG = "ObricSecurityBroadcast";
    private static final Map<String, List<IObricSecurityBroadcastPlugin>> sPlugins = null;
    private final Context mContext;

    private static class SecurityBroadcastReceiver extends BroadcastReceiver {
        /* synthetic */ SecurityBroadcastReceiver(ObricSecurityBroadcastIA r1) {
            this();
        }

        private SecurityBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i(ObricSecurityBroadcast.TAG, "intent: " + intent.getAction());
            List<IObricSecurityBroadcastPlugin> plugins = (List) ObricSecurityBroadcast.m94$$Nest$sfgetsPlugins().getOrDefault(intent.getAction(), new ArrayList());
            Iterator<IObricSecurityBroadcastPlugin> r1 = plugins.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            IObricSecurityBroadcastPlugin plugin = r1.next();
            plugin.onReceive(context, intent);
            goto L4
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsPlugins, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m94$$Nest$sfgetsPlugins() {
        return sPlugins;
    }

    static {
        CREATOR = new AnonymousClass1();
        sPlugins = new HashMap();
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStart() {
        registerBroadcast();
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStop() {
    }

    public ObricSecurityBroadcast(Context context) {
        this.mContext = context;
    }

    public static boolean registerPlugin(String pluginName, List<String> broadcastActions, IObricSecurityBroadcastPlugin plugin) {
        Iterator<String> r1 = broadcastActions.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L8;
        String action = r1.next();     // Catch: Throwable -> L10
        sPlugins.computeIfAbsent(action, new ObricSecurityBroadcast$$ExternalSyntheticLambda0()).add(plugin);     // Catch: Throwable -> L10
        goto L5
    L8:
        Log.i(TAG, "register plugin " + pluginName);
        Log.i(TAG, "splugin: " + sPlugins);
        return true;
    L10:
        e = move-exception;
        Log.e(TAG, pluginName + " registerPlugin failed, " + e.getMessage());
        return false;
    }

    static /* synthetic */ List lambda$registerPlugin$0(String k) {
        return new ArrayList();
    }

    private void registerBroadcast() {
        IntentFilter packageFilter = new IntentFilter();     // Catch: Exception -> L4
        packageFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");     // Catch: Exception -> L4
        packageFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");     // Catch: Exception -> L4
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");     // Catch: Exception -> L4
        packageFilter.addDataScheme("package");     // Catch: Exception -> L4
        IntentFilter systemFilter = new IntentFilter();     // Catch: Exception -> L4
        systemFilter.addAction("android.intent.action.ACTION_SHUTDOWN");     // Catch: Exception -> L4
        SecurityBroadcastReceiver receiver = new SecurityBroadcastReceiver(null);     // Catch: Exception -> L4
        this.mContext.registerReceiver(receiver, packageFilter);     // Catch: Exception -> L4
        this.mContext.registerReceiver(receiver, systemFilter);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "registerBroadcast occur exception, " + e.getMessage());
    }
}
