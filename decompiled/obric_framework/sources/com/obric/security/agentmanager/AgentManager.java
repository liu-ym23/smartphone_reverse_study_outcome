package com.obric.security.agentmanager;

import android.app.ObricActivityTaskManager;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.obric.security.robots.RobotsProtocolHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import system.bytedance.hardware.agentmanager.AgentInfoResponse;
import system.bytedance.hardware.agentmanager.IAgentManagerService;
import system.bytedance.hardware.agentmanager.RegisterRequest;
import system.bytedance.hardware.agentmanager.RegisterResponse;
import vendor.bytedance.hardware.agentmanager.RegisterList;

/* JADX INFO: loaded from: classes.dex */
public class AgentManager {
    private static final String TAG = null;
    private static volatile AgentManager mAgentManager;

    static {
        TAG = AgentManager.class.getSimpleName();
    }

    private AgentManager() {
    }

    public static AgentManager getInstance() {
        if (mAgentManager != null) goto L15;
        monitor-enter(AgentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mAgentManager != null) goto L9;
        mAgentManager = new AgentManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AgentManager.class);     // Catch: Throwable -> L11
    L15:
        return mAgentManager;
    }

    private RegisterRequest buildRegisterRequest(Bundle bundle) {
        String agentName = bundle.getString(AgentManagerConst.AGENT_NAME, null);
        if (agentName != null) goto L5;
    L24:
        Log.e(TAG, "Invalid input params: agentName is null or invalid length");
        return null;
    L5:
        if (agentName.length() > 64) goto L24;
        int agentType = bundle.getInt(AgentManagerConst.AGENT_TYPE, -1);
        if (agentType != (-1)) goto L11;
        Log.e(TAG, "Invalid input params: agentType is invalid");
        return null;
    L11:
        String challenge = bundle.getString("challenge", null);
        if (challenge != null) goto L14;
    L22:
        Log.e(TAG, "Invalid input params: challenge is null or invalid length");
        return null;
    L14:
        if (challenge.length() > 64) goto L22;
        ArrayList<String> requestPermissionsList = bundle.getStringArrayList(AgentManagerConst.REQUEST_PERMISSION);
        if (requestPermissionsList != null) goto L20;
        Log.e(TAG, "Invalid input params: requestPermissions is null or empty");
        return null;
    L20:
        RegisterRequest req = new RegisterRequest();
        req.agentName = agentName;
        req.agentType = agentType;
        req.challenge = challenge;
        req.requestedPermissions = (String[]) requestPermissionsList.toArray(new String[0]);
        return req;
    }

    private AgentRegRes buildAgentRegRes(RegisterRequest req, RegisterResponse res) {
        if (res != null) goto L6;
        Log.e(TAG, "Invalid input params: res is null");
        return new AgentRegRes(AgentManagerErrCode.AGENT_ERR_UNKNOWN, null);
    L6:
        int resultCode = res.status;
        if (resultCode == 0) goto L10;
        Log.e(TAG, "registerAgent failed: resultCode = " + resultCode);
        return new AgentRegRes(resultCode, null);
    L10:
        AgentProof agentProof = new AgentProof(res.agentUuid, res.agent, res.agentHash, res.deviceStatus, res.certChain, res.signature);
        return new AgentRegRes(resultCode, agentProof);
    }

    private void notifyAgentInfoUpdated(RegisterRequest req, RegisterResponse res) {
        Bundle updateBundle = new Bundle();
        updateBundle.putString("package_sha256", res.packageHash);
        updateBundle.putString(AgentManagerConst.AGENT_UUID, res.agentUuid);
        updateBundle.putString(AgentManagerConst.AGENT_NAME, req.agentName);
        updateBundle.putString("package_name", res.packageName);
        updateBundle.putInt("uid", res.uid);
        boolean updateSuccess = ObricActivityTaskManager.updateAgentInfo(updateBundle);
        if (updateSuccess == true) goto L6;
        Log.w(TAG, "Failed to update agent info to ObricActivityTaskManager");
        return;
    }

    public AgentRegRes registerAgent(Context context, Bundle bundle) {
        if (context == null) goto L25;
        if (bundle == null) goto L25;
        RegisterRequest req = buildRegisterRequest(bundle);
        if (req != null) goto L10;
        Log.e(TAG, "Invalid input params: bundle is invalid");
        return new AgentRegRes(AgentManagerErrCode.AGENT_ERR_INVALID_PARAM, null);
    L10:
        IAgentManagerService service = AgentManagerUtils.getAgentManagerService();
        if (service != null) goto L14;
        Log.e(TAG, "Service not ready!");
        return new AgentRegRes(AgentManagerErrCode.AGENT_ERR_SERVICE_NOT_READY, null);
    L14:
        RegisterResponse res = null;
        res = service.registerAgent(req);     // Catch: RemoteException -> L17
    L19:
        if (res == null) goto L24;
        if (res.status != 0) goto L24;
        notifyAgentInfoUpdated(req, res);
    L24:
        return buildAgentRegRes(req, res);
    L17:
        e = move-exception;
        Log.e(TAG, "registerAgent failed: " + e.getMessage());
    L25:
        Log.e(TAG, "Invalid input params: context or bundle is null");
        return new AgentRegRes(AgentManagerErrCode.AGENT_ERR_INVALID_PARAM, null);
    }

    public List<String> listRegisteredAgents() {
        IAgentManagerService service = AgentManagerUtils.getAgentManagerService();
        if (service != null) goto L6;
        Log.e(TAG, "Service not ready!");
        return null;
    L6:
        RegisterList agentList = null;
        agentList = service.listRegisteredAgents();     // Catch: RemoteException -> L9
    L11:
        if (agentList != null) goto L13;
    L19:
        return null;
    L13:
        if (agentList.status != 0) goto L19;
        if (agentList.agentUuids == null) goto L19;
        return Arrays.asList(agentList.agentUuids);
    L9:
        e = move-exception;
        Log.e(TAG, "listRegisteredAgents failed", e);
        goto L11
    }

    public String getAgentInfo(String agentUuid) {
        if (RobotsProtocolHelper.isRobotsEnabled() == true) goto L6;
        Log.d(TAG, "getAgentInfo: robots protocol disabled");
        return null;
    L6:
        if (agentUuid != null) goto L8;
    L26:
        Log.e(TAG, "Invalid input params: agentUuid is invalid");
        return null;
    L8:
        if (agentUuid.isEmpty() == true) goto L26;
        IAgentManagerService service = AgentManagerUtils.getAgentManagerService();
        if (service != null) goto L14;
        Log.e(TAG, "Service not ready!");
        return null;
    L14:
        AgentInfoResponse res = null;
        res = service.getAgentInfo(agentUuid);     // Catch: RemoteException -> L17
    L19:
        if (res != null) goto L21;
    L25:
        return null;
    L21:
        if (res.status != 0) goto L25;
        return res.agentInfoJson;
    L17:
        e = move-exception;
        Log.e(TAG, "getAgentInfo failed: " + e.getMessage());
        goto L19
    }
}
