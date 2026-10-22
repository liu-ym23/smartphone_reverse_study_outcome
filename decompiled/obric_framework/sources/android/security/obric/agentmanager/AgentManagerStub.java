package android.security.obric.agentmanager;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AgentManagerStub {
    private static final String IMPL_CLASS_NAME = "com.obric.security.agentmanager.AgentManager";
    private static final String METHOD_GET_AGENT_INFO = "getAgentInfo";
    private static final String METHOD_GET_INSTANCE = "getInstance";
    private static final String METHOD_LIST_REGISTERED_AGENTS = "listRegisteredAgents";
    private static final String TAG = "AgentManagerStub";
    private static volatile AgentManagerStub sInstance;
    private Object mAgentManager;
    private Class<?> mClazz;

    private AgentManagerStub() {
    }

    public static AgentManagerStub getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(AgentManagerStub.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AgentManagerStub();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AgentManagerStub.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void init() {
        if (this.mAgentManager != null) goto L5;
    L11:
        this.mClazz = Class.forName(IMPL_CLASS_NAME);     // Catch: Exception -> L8
        Method getInstanceMethod = this.mClazz.getDeclaredMethod(METHOD_GET_INSTANCE, new Class[0]);     // Catch: Exception -> L8
        getInstanceMethod.setAccessible(true);     // Catch: Exception -> L8
        this.mAgentManager = getInstanceMethod.invoke(null, new Object[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "init failed", e);
        return;
    L5:
        if (this.mClazz == null) goto L11;
    }

    public String getAgentInfo(String agentUuid) {
        init();
        if (this.mClazz != null) goto L5;
    L12:
        return null;
    L5:
        if (this.mAgentManager == null) goto L12;
        Method getAgentInfoMethod = this.mClazz.getDeclaredMethod(METHOD_GET_AGENT_INFO, new Class[]{String.class});     // Catch: Exception -> L9
        getAgentInfoMethod.setAccessible(true);     // Catch: Exception -> L9
        return (String) getAgentInfoMethod.invoke(this.mAgentManager, new Object[]{agentUuid});
    L9:
        e = move-exception;
        Log.e(TAG, "getAgentInfo failed", e);
        return null;
    }

    public List<String> listRegisteredAgents() {
        init();
        if (this.mClazz != null) goto L5;
    L12:
        return null;
    L5:
        if (this.mAgentManager == null) goto L12;
        Method listRegisteredAgentsMethod = this.mClazz.getDeclaredMethod(METHOD_LIST_REGISTERED_AGENTS, new Class[0]);     // Catch: Exception -> L9
        listRegisteredAgentsMethod.setAccessible(true);     // Catch: Exception -> L9
        return (List) listRegisteredAgentsMethod.invoke(this.mAgentManager, new Object[0]);
    L9:
        e = move-exception;
        Log.e(TAG, "listRegisteredAgents failed", e);
        return null;
    }
}
