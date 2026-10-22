package tmsdkobf;

import java.io.File;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jb f498a;
    public int b;
    public int c;

    public s3() {
    }

    public String a() {
        return TMSDKContext.getApplicaionContext().getDir("dex", 0).getAbsolutePath();
    }

    public String b() {
        return this.f498a.f286a + "_" + this.f498a.b + "_" + this.f498a.c + ".dat";
    }

    public String c() {
        return TMSDKContext.getApplicaionContext().getFilesDir().getAbsolutePath() + File.separator + this.f498a.f286a + "_" + this.f498a.b + "_" + this.f498a.c;
    }

    public String toString() {
        String r0 = "op:[" + this.b + "]status:[" + this.c + "]";
        if (this.f498a != null) goto L5;
        return r0;
    L5:
        return r0 + "id:[" + this.f498a.f286a + "]ver:[" + this.f498a.b + "]ver_nest:[" + this.f498a.c + "]runtype:[" + this.f498a.d + "]size:[" + this.f498a.f + "]md5:[" + this.f498a.g + "]url:[" + this.f498a.h + "]";
    }
}
