package com.obric.security.agentmanager;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import system.bytedance.hardware.agentmanager.IAgentManagerService;

/* JADX INFO: loaded from: classes.dex */
public class AgentManagerUtils {
    private static final String AGENT_MANAGER_SERVICE_NAME = "system.bytedance.hardware.agentmanager.IAgentManagerService/default";
    public static final String TAG = null;
    private static volatile IAgentManagerService agentManagerServiceBinder;
    private static final IBinder.DeathRecipient deathRecipient = null;

    /* JADX INFO: renamed from: -$$Nest$sfgetagentManagerServiceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAgentManagerService m56$$Nest$sfgetagentManagerServiceBinder() {
        return agentManagerServiceBinder;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetdeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder.DeathRecipient m57$$Nest$sfgetdeathRecipient() {
        return deathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputagentManagerServiceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m58$$Nest$sfputagentManagerServiceBinder(IAgentManagerService r0) {
        agentManagerServiceBinder = r0;
    }

    public AgentManagerUtils() {
    }

    static {
        TAG = AgentManagerUtils.class.getSimpleName();
        deathRecipient = new AnonymousClass1();
    }

    public static IAgentManagerService getAgentManagerService() {
        if (agentManagerServiceBinder != null) goto L21;
        monitor-enter(AgentManagerUtils.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (agentManagerServiceBinder != null) goto L10;
        agentManagerServiceBinder = IAgentManagerService.Stub.asInterface(ServiceManager.getService(AGENT_MANAGER_SERVICE_NAME));     // Catch: Throwable -> L17
    L10:
        if (agentManagerServiceBinder != null) goto L22;
    L15:
        monitor-exit(AgentManagerUtils.class);     // Catch: Throwable -> L17
        goto L21
    L22:
        agentManagerServiceBinder.asBinder().linkToDeath(deathRecipient, 0);     // Catch: RemoteException -> L13 Throwable -> L17
    L13:
        e = move-exception;
        Log.e(TAG, "Failed to link to death: " + e.getMessage());     // Catch: Throwable -> L17
        agentManagerServiceBinder = null;     // Catch: Throwable -> L17
    L21:
        return agentManagerServiceBinder;
    }
}
