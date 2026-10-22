package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.config.CommonEventConfig;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CommonEventConfigManager implements CommonEventConfigService {
    private static final String BASE_KEY_ALLOW_SERVICE_NAME = "allow_service_name";
    private volatile CommonEventConfig config;

    static /* synthetic */ void access$000(CommonEventConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    public CommonEventConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.commonevent.config.CommonEventConfigService
    public CommonEventConfig getConfig() {
        return this.config;
    }

    private void parseConfig(JSONObject r7, boolean r8) {
        JSONObject r9 = r7.optJSONObject("custom_event_settings");
        if (r9 == null) goto L29;
        JSONObject r10 = r9.optJSONObject("allow_service_name");
        HashSet r0 = new HashSet();
        if (r10 == null) goto L10;
        Iterator<String> r11 = r10.keys();
    L8:
        if (r11.hasNext() == false) goto L10;
        r0.add(r11.next());
    L10:
        HashSet r12 = new HashSet();
        JSONObject r1 = r9.optJSONObject("allow_log_type");
        if (r1 == null) goto L18;
        Iterator<String> r2 = r1.keys();
    L14:
        if (r2.hasNext() == false) goto L18;
        String r3 = r2.next();
        if (r1.optInt(r3) != 1) goto L14;
        r12.add(r3);
    L18:
        this.config = new CommonEventConfig(r0, r12);
        if (ApmContext.isDebugMode() == false) goto L21;
        Logger.d(ConfigConstants.LOG_TAG, "received customEventSettings=" + r9);
        Logger.d(ConfigConstants.LOG_TAG, "parsed CommonEventConfig=" + this.config);
    L21:
        CommonEventDeliverer.updateConfig(getConfig());
        return;
    }
}
