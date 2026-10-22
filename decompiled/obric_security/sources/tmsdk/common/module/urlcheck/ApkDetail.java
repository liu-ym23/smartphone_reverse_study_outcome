package tmsdk.common.module.urlcheck;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class ApkDetail implements Parcelable {
    public static Parcelable.Creator<ApkDetail> CREATOR;
    public String apkName;
    public String apkPackage;
    public String certMD5;
    public String description;
    public String developer;
    public int downloadCount;
    public String iconUrl;
    public ArrayList<String> imageUrls;
    public boolean isInSoftwareDB;
    public int official;
    public ArrayList<String> sensitivePermissions;
    public long size;
    public String source;
    public int versionCode;
    public String versionName;
    public String virsusDescription;
    public String virsusName;

    class a implements Parcelable.Creator {
        a() {
        }

        public ApkDetail a(Parcel r3) {
            ApkDetail r2 = new ApkDetail();
            r2.apkPackage = r3.readString();
            r2.apkName = r3.readString();
            r2.iconUrl = r3.readString();
            r2.versionCode = r3.readInt();
            r2.versionName = r3.readString();
            r2.size = r3.readLong();
            r2.official = r3.readInt();
            r2.developer = r3.readString();
            r2.certMD5 = r3.readString();
            if (r3.readInt() == 0) goto L5;
            boolean r0 = true;
        L6:
            r2.isInSoftwareDB = r0;
            r2.description = r3.readString();
            if (r2.imageUrls != null) goto L9;
            r2.imageUrls = new ArrayList();
        L9:
            r3.readStringList(r2.imageUrls);
            r2.downloadCount = r3.readInt();
            r2.source = r3.readString();
            if (r2.sensitivePermissions != null) goto L12;
            r2.sensitivePermissions = new ArrayList();
        L12:
            r3.readStringList(r2.sensitivePermissions);
            r2.virsusName = r3.readString();
            r2.virsusDescription = r3.readString();
            return r2;
        L5:
            r0 = false;
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

        public ApkDetail[] a(int r1) {
            return new ApkDetail[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ApkDetail() {
        this.apkPackage = "";
        this.apkName = "";
        this.iconUrl = "";
        this.versionCode = 0;
        this.versionName = "";
        this.size = 0;
        this.official = 0;
        this.developer = "";
        this.certMD5 = "";
        this.isInSoftwareDB = false;
        this.description = "";
        this.imageUrls = null;
        this.downloadCount = 0;
        this.source = "";
        this.sensitivePermissions = null;
        this.virsusName = "";
        this.virsusDescription = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.apkPackage);
        r3.writeString(this.apkName);
        r3.writeString(this.iconUrl);
        r3.writeInt(this.versionCode);
        r3.writeString(this.versionName);
        r3.writeLong(this.size);
        r3.writeInt(this.official);
        r3.writeString(this.developer);
        r3.writeString(this.certMD5);
        r3.writeInt(this.isInSoftwareDB ? 1 : 0);
        r3.writeString(this.description);
        r3.writeStringList(this.imageUrls);
        r3.writeInt(this.downloadCount);
        r3.writeString(this.source);
        r3.writeStringList(this.sensitivePermissions);
        r3.writeString(this.virsusName);
        r3.writeString(this.virsusDescription);
    }
}
