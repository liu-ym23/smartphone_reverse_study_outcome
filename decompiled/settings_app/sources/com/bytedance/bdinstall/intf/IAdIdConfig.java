package com.bytedance.bdinstall.intf;

import com.bytedance.bdinstall.util.RomUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface IAdIdConfig {

    public static class AdIdConfig implements IAdIdConfig {
        @Override // com.bytedance.bdinstall.intf.IAdIdConfig
        public long getAdIdWaitTime() {
            return 100;
        }

        public AdIdConfig() {
        }

        @Override // com.bytedance.bdinstall.intf.IAdIdConfig
        public boolean enablePrefetchAdId() {
            return !RomUtils.isMeizu();
        }
    }

    boolean enablePrefetchAdId();

    long getAdIdWaitTime();
}
