package com.bytedance.apm6.hub;

import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.hub.config.CommonEventConfigManager;
import com.bytedance.apm6.hub.config.CpuOnlineConfigManager;
import com.bytedance.apm6.hub.config.FluencyConfigManager;
import com.bytedance.apm6.hub.config.MemoryConfigManager;
import com.bytedance.apm6.hub.config.SlardarHandlerConfigManager;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApmAdapter implements ApmContextAdapter {
    public ApmAdapter() {
    }

    public CommonEventConfigService createCommonEventConfigService() {
        return new CommonEventConfigManager();
    }

    public CpuOnlineConfigManager createCpuConfigService() {
        return new CpuOnlineConfigManager();
    }

    public IDeviceInfoService createDeviceInfoService() {
        return null;
    }

    public abstract EncryptService createEncryptRequestServiceImpl();

    public abstract IEncrypt createEncryptServiceImpl();

    public FluencyConfigManager createFluencyConfigService() {
        return new FluencyConfigManager();
    }

    public abstract IHttpService createHttpService();

    public IMapsCollectService createMapsCollectService() {
        return null;
    }

    public MemoryConfigService createMemoryConfigService() {
        return new MemoryConfigManager();
    }

    public SlardarHandlerConfigService createSlardarHandlerConfigService() {
        return new SlardarHandlerConfigManager(getOutsideConfig());
    }

    public SlardarResponseService createSlardarResponseService() {
        return null;
    }

    @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
    public JSONObject getDynamicHeaderExtras() {
        return null;
    }

    public long getInternalComponentInitDelayMills() {
        return 0;
    }

    @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
    public Map<String, String> getParamsExtras() {
        return null;
    }

    @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
    public JSONObject getStableHeaderExtras() {
        return null;
    }
}
