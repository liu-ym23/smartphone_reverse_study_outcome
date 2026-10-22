package com.obric.server.security;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import com.obric.security.IObricSecurityPluginService;
import com.obric.server.security.audit.SecurityAuditServicePlugin;
import com.obric.server.security.broadcast.ObricSecurityBroadcast;
import com.obric.server.security.guard.ObricSecurityGuardPlugin;
import com.obric.server.security.guard.ObricSecurityGuardUtils;
import com.obric.server.security.keymanager.ObricKeyManagerService;
import com.obric.server.security.securityconfig.SecurityConfigServicePlugin;
import com.obric.server.security.utils.GlobalContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityServiceProxy {
    private static final int AUDIT_PLUGIN_CODE = 5;
    private static final int BEHAVIOR_RECORD_PLUGIN_CODE = 3;
    private static final int BROADCAST_PLUGIN_CODE = 1;
    private static final int KEY_MANAGER_PLUGIN_CODE = 2;
    private static final Object LOCK = null;
    private static final int SECURITY_CONFIG_PLUGIN_CODE = 6;
    private static final int SECURITY_GUARD_PLUGIN_CODE = 4;
    private static final String TAG = "ObricSecurityServiceProxy";
    private static volatile ObricSecurityServiceProxy sInstance;
    private static Map<Integer, PluginInfo> sPluginMap;
    private final Context mContext;

    public class ObricSecurityPluginService extends IObricSecurityPluginService.Stub {
        final /* synthetic */ ObricSecurityServiceProxy this$0;

        public ObricSecurityPluginService(ObricSecurityServiceProxy this$0) {
            this.this$0 = this$0;
        }

        public IBinder querySecurityPlugin(int pluginCode) throws RemoteException {
            Map r0 = ObricSecurityServiceProxy.m88$$Nest$sfgetsPluginMap();
            monitor-enter(r0);
            PluginInfo pluginInfo = (PluginInfo) ObricSecurityServiceProxy.m88$$Nest$sfgetsPluginMap().getOrDefault(Integer.valueOf(pluginCode), null);     // Catch: Throwable -> L22
            monitor-exit(r0);     // Catch: Throwable -> L22
            if (pluginInfo == null) goto L20;
            IObricSecurityPlugin plugin = pluginInfo.plugin;
            String permission = pluginInfo.creator.getPermission();
            if (TextUtils.isEmpty(permission) == true) goto L11;
            ObricSecurityServiceProxy.m87$$Nest$fgetmContext(this.this$0).enforceCallingPermission(permission, "need request " + permission);
        L11:
            if (pluginCode != ObricSecurityServiceProxy.AUDIT_PLUGIN_CODE) goto L13;
            boolean allowNonPlatformForAudit = true;
        L14:
            if (allowNonPlatformForAudit == false) goto L16;
        L17:
            if (plugin == null) goto L20;
            return plugin.asBinder();
        L16:
            if (ObricSecurityGuardUtils.isSystemOrPlatformApp(ObricSecurityServiceProxy.m87$$Nest$fgetmContext(this.this$0)) == false) goto L20;
        L13:
            allowNonPlatformForAudit = false;
        L20:
            Log.e(ObricSecurityServiceProxy.TAG, "plugin code miss plugin, or lack of platform sign.");
            return null;
        L22:
            th = move-exception;
            throw th;
        }
    }

    private static class PluginInfo {
        private final Set<Integer> VALID_START_FLAGS;
        private final Set<Integer> VALID_START_TIME;
        IObricSecurityPlugin.Creator creator;
        IObricSecurityPlugin plugin;
        int pluginCode;
        int startFlag;
        int startSequence;
        int startTime;

        static class PluginComparator implements Comparator<PluginInfo> {
            PluginComparator() {
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(PluginInfo r1, PluginInfo r2) {
                return compare2(r1, r2);
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(PluginInfo o1, PluginInfo o2) {
                return o1.startSequence - o2.startSequence;
            }
        }

        PluginInfo(int startFlag, int startSequence, int startTime, IObricSecurityPlugin.Creator creator) {
            int r1 = 0;
            this.VALID_START_FLAGS = new HashSet(Arrays.asList(new Integer[]{0, Integer.valueOf(ObricSecurityServiceProxy.BROADCAST_PLUGIN_CODE)}));
            int r2 = 500;
            this.VALID_START_TIME = new HashSet(Arrays.asList(new Integer[]{100, 200, 480, 500, 520, 550, 600, 1000}));
            if (this.VALID_START_FLAGS.contains(Integer.valueOf(startFlag)) == false) goto L5;
            r1 = startFlag;
        L5:
            this.startFlag = r1;
            this.startSequence = startSequence;
            if (this.VALID_START_TIME.contains(Integer.valueOf(startTime)) == false) goto L8;
            r2 = startTime;
        L8:
            this.startTime = r2;
            this.creator = creator;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m87$$Nest$fgetmContext(ObricSecurityServiceProxy r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsPluginMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m88$$Nest$sfgetsPluginMap() {
        return sPluginMap;
    }

    static {
        LOCK = new Object();
        sPluginMap = new HashMap();
    }

    private ObricSecurityServiceProxy(Context context) {
        Log.i(TAG, "ObricSecurityServiceProxy enter");
        this.mContext = context;
        GlobalContext.setContext(context);
    }

    public static ObricSecurityServiceProxy getInstance(Context context) {
        if (sInstance != null) goto L15;
        Object r0 = LOCK;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ObricSecurityServiceProxy(context);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void onStart() {
        ServiceManager.addService("ObricSecurityService", new ObricSecurityPluginService(this));
        registerPlugin();
        Log.i(TAG, "register obric security service.");
    }

    public void onBootPhase(int phase) {
        Log.i(TAG, "obric security service onBootPhase: " + phase);
        startServicePlugin(phase);
    }

    private void registerPlugin() {
        Map<Integer, PluginInfo> r1 = sPluginMap;     // Catch: Throwable -> L25
        monitor-enter(r1);     // Catch: Throwable -> L25
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25 Throwable -> L25
    L6:
        if (ObricSecurityBroadcast.CREATOR.isEnable() == false) goto L9;
        sPluginMap.put(Integer.valueOf(BROADCAST_PLUGIN_CODE), new PluginInfo(0, BROADCAST_PLUGIN_CODE, 200, ObricSecurityBroadcast.CREATOR));     // Catch: Throwable -> L22
    L9:
        if (ObricKeyManagerService.CREATOR.isEnable() == false) goto L12;
        sPluginMap.put(Integer.valueOf(KEY_MANAGER_PLUGIN_CODE), new PluginInfo(0, BROADCAST_PLUGIN_CODE, 500, ObricKeyManagerService.CREATOR));     // Catch: Throwable -> L22
    L12:
        if (ObricSecurityGuardPlugin.CREATOR.isEnable() == false) goto L15;
        sPluginMap.put(Integer.valueOf(SECURITY_GUARD_PLUGIN_CODE), new PluginInfo(0, BROADCAST_PLUGIN_CODE, 500, ObricSecurityGuardPlugin.CREATOR));     // Catch: Throwable -> L22
    L15:
        if (SecurityAuditServicePlugin.CREATOR.isEnable() == false) goto L18;
        sPluginMap.put(Integer.valueOf(AUDIT_PLUGIN_CODE), new PluginInfo(0, BROADCAST_PLUGIN_CODE, 500, SecurityAuditServicePlugin.CREATOR));     // Catch: Throwable -> L22
    L18:
        if (SecurityConfigServicePlugin.CREATOR.isEnable() == false) goto L20;
        sPluginMap.put(Integer.valueOf(SECURITY_CONFIG_PLUGIN_CODE), new PluginInfo(0, BROADCAST_PLUGIN_CODE, 500, SecurityConfigServicePlugin.CREATOR));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L25:
        e = move-exception;
        Log.e(TAG, "registerPlugin failed, id: -1");
        Log.e(TAG, "registerPlugin occur exception.", e);
    }

    private void startServicePlugin(int phase) {
        List<PluginInfo> pluginInfoList = new ArrayList();
        Map<Integer, PluginInfo> r1 = sPluginMap;
        monitor-enter(r1);
        Iterator<Integer> r2 = sPluginMap.keySet().iterator();     // Catch: Throwable -> L21
    L6:
        if (r2.hasNext() == false) goto L15;
        int num = r2.next().intValue();     // Catch: Throwable -> L21
        PluginInfo pluginInfo = sPluginMap.get(Integer.valueOf(num));     // Catch: Throwable -> L21
        if (pluginInfo == null) goto L6;
        if (pluginInfo.startFlag != 0) goto L6;
        if (pluginInfo.startTime != phase) goto L6;
        pluginInfo.pluginCode = num;     // Catch: Throwable -> L21
        pluginInfoList.add(pluginInfo);     // Catch: Throwable -> L21
        goto L6
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L21
        pluginInfoList.sort(new PluginInfo.PluginComparator());
        Iterator<PluginInfo> r3 = pluginInfoList.iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        PluginInfo pluginInfo2 = r3.next();
        IObricSecurityPlugin plugin = pluginInfo2.creator.createPlugin(this.mContext);
        plugin.onStart();
        pluginInfo2.plugin = plugin;
        goto L18
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
