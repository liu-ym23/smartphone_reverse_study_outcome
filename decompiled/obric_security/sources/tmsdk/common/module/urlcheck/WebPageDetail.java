package tmsdk.common.module.urlcheck;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class WebPageDetail implements Parcelable {
    public static Parcelable.Creator<WebPageDetail> CREATOR;
    public String description;
    public String flawName;
    public String maliceBody;
    public String maliceTitle;
    public long maliceType;
    public String screenshotUrl;
    public String title;
    public String webIconUrl;

    class a implements Parcelable.Creator {
        a() {
        }

        public WebPageDetail a(Parcel r3) {
            WebPageDetail r2 = new WebPageDetail();
            r2.title = r3.readString();
            r2.description = r3.readString();
            r2.webIconUrl = r3.readString();
            r2.screenshotUrl = r3.readString();
            r2.maliceType = r3.readLong();
            r2.maliceTitle = r3.readString();
            r2.maliceBody = r3.readString();
            r2.flawName = r3.readString();
            return r2;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public WebPageDetail[] a(int r1) {
            return new WebPageDetail[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public WebPageDetail() {
        this.title = "";
        this.description = "";
        this.webIconUrl = "";
        this.screenshotUrl = "";
        this.maliceType = 0;
        this.maliceTitle = "";
        this.maliceBody = "";
        this.flawName = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.title);
        r3.writeString(this.description);
        r3.writeString(this.webIconUrl);
        r3.writeString(this.screenshotUrl);
        r3.writeLong(this.maliceType);
        r3.writeString(this.maliceTitle);
        r3.writeString(this.maliceBody);
        r3.writeString(this.flawName);
    }
}
