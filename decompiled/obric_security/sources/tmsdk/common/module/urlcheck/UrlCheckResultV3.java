package tmsdk.common.module.urlcheck;

import android.os.Parcel;
import android.os.Parcelable;
import tmsdkobf.cd;
import tmsdkobf.fg;
import tmsdkobf.k;

/* JADX INFO: loaded from: classes5.dex */
public class UrlCheckResultV3 implements Parcelable {
    public static Parcelable.Creator<UrlCheckResultV3> CREATOR;
    public ApkDetail apkDetail;
    public int level;
    public int linkType;
    public int mErrCode;
    public int riskType;
    public String url;
    public WebPageDetail webPageDetail;

    class a implements Parcelable.Creator {
        a() {
        }

        public UrlCheckResultV3 a(Parcel r2) {
            UrlCheckResultV3 r1 = new UrlCheckResultV3(null);
            r1.url = r2.readString();
            r1.level = r2.readInt();
            r1.linkType = r2.readInt();
            r1.riskType = r2.readInt();
            if (r1.linkType != 0) goto L5;
            r1.webPageDetail = (WebPageDetail) r2.readParcelable(WebPageDetail.class.getClassLoader());
        L6:
            r1.mErrCode = r2.readInt();
            return r1;
        L5:
            r1.apkDetail = (ApkDetail) r2.readParcelable(ApkDetail.class.getClassLoader());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public UrlCheckResultV3[] a(int r1) {
            return new UrlCheckResultV3[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    private UrlCheckResultV3() {
        this.level = -1;
        this.linkType = -1;
        this.riskType = -1;
        this.webPageDetail = null;
        this.apkDetail = null;
        this.mErrCode = 0;
    }

    /* synthetic */ UrlCheckResultV3(UrlCheckResultV3IA r1) {
        this();
    }

    private ApkDetail a(k r3) {
        ApkDetail r2 = new ApkDetail();
        r2.apkName = r3.b;
        r2.apkPackage = r3.f296a;
        r2.iconUrl = r3.c;
        r2.versionCode = r3.d;
        r2.versionName = r3.e;
        r2.size = r3.f;
        r2.official = r3.g;
        r2.developer = r3.h;
        r2.certMD5 = r3.i;
        r2.isInSoftwareDB = r3.j;
        r2.description = r3.k;
        r2.imageUrls = r3.l;
        r2.downloadCount = r3.m;
        r2.source = r3.n;
        r2.sensitivePermissions = r3.o;
        r2.virsusName = r3.p;
        r2.virsusDescription = r3.q;
        return r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.url);
        r2.writeInt(this.level);
        r2.writeInt(this.linkType);
        r2.writeInt(this.riskType);
        if (this.linkType != 0) goto L5;
        Parcelable r4 = this.webPageDetail;
    L6:
        r2.writeParcelable(r4, 0);
        r2.writeInt(this.mErrCode);
        return;
    L5:
        r4 = this.apkDetail;
        goto L6
    }

    public UrlCheckResultV3(int r2) {
        this.level = -1;
        this.linkType = -1;
        this.riskType = -1;
        this.webPageDetail = null;
        this.apkDetail = null;
        this.mErrCode = r2;
    }

    private WebPageDetail a(fg r3) {
        WebPageDetail r2 = new WebPageDetail();
        r2.title = r3.f203a;
        r2.description = r3.b;
        r2.webIconUrl = r3.c;
        r2.screenshotUrl = r3.d;
        r2.maliceType = r3.e;
        r2.maliceTitle = r3.f;
        r2.maliceBody = r3.g;
        r2.flawName = r3.h;
        return r2;
    }

    public UrlCheckResultV3(String r2, cd r3) {
        this.level = -1;
        this.linkType = -1;
        this.riskType = -1;
        this.webPageDetail = null;
        this.apkDetail = null;
        this.mErrCode = 0;
        this.url = r2;
        this.level = r3.b;
        this.linkType = r3.c;
        this.riskType = r3.d;
        fg r4 = r3.e;
        if (r4 == null) goto L5;
        this.webPageDetail = a(r4);
    L5:
        k r5 = r3.f;
        if (r5 == null) goto L9;
        this.apkDetail = a(r5);
        return;
    }
}
