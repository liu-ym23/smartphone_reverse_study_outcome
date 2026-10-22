package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes.dex */
public class CdnConnectionClassManager extends ConnectionClassManager {

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.connectionclass.CdnConnectionClassManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CdnConnectionClassManaagerHolder {
        public static final CdnConnectionClassManager instance = null;

        static {
            instance = new CdnConnectionClassManager(null);
        }

        private CdnConnectionClassManaagerHolder() {
        }
    }

    public /* synthetic */ CdnConnectionClassManager(AnonymousClass1 r1) {
        this();
    }

    public static CdnConnectionClassManager getInstance() {
        return CdnConnectionClassManaagerHolder.instance;
    }

    private CdnConnectionClassManager() {
    }
}
