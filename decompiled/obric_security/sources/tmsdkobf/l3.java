package tmsdkobf;

import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class l3 extends f6 {
    public l3() {
    }

    @Override // tmsdkobf.f6
    public String a(int r2) {
        String r1 = j3.a(TMSDKContext.getApplicaionContext(), m9.e().h().getString("key_gd", ""));
        r8.a("shark_CustomDataMigration", "guid:[" + r1 + "]");
        return r1;
    }

    @Override // tmsdkobf.f6
    public String b(int r2) {
        String r1 = j3.a(TMSDKContext.getApplicaionContext(), m9.e().h().getString("key_vd", ""));
        r8.a("shark_CustomDataMigration", "vid:[" + r1 + "]");
        return r1;
    }
}
