package tmsdk.common.module.update;

import android.os.Parcel;
import android.os.Parcelable;
import tmsdkobf.a0;

/* JADX INFO: loaded from: classes5.dex */
public class UpdateInfo extends a0 implements Parcelable {
    public static final Parcelable.Creator<UpdateInfo> CREATOR = null;
    public String checkSum;
    public Object data1;
    public Object data2;
    public String downNetName;
    public int downSize;
    public byte downType;
    public int downnetType;
    public int errorCode;
    public String errorMsg;
    public String fileName;
    public int fileSize;
    public long flag;
    public int mFileID;
    public int rssi;
    public int sdcardStatus;
    public byte success;
    public int timestamp;
    public int type;
    public String url;

    class a implements Parcelable.Creator {
        a() {
        }

        public UpdateInfo a(Parcel r1) {
            return new UpdateInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public UpdateInfo[] a(int r1) {
            return new UpdateInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public UpdateInfo() {
        this.checkSum = "";
        this.timestamp = -1;
        this.success = 1;
        this.downSize = -1;
        this.errorCode = 0;
        this.downnetType = 0;
        this.downNetName = "";
        this.errorMsg = "";
        this.rssi = -1;
        this.sdcardStatus = -1;
        this.fileSize = 0;
        this.mFileID = 0;
    }

    private void a(Parcel r3) {
        this.id = r3.readInt();
        this.flag = r3.readLong();
        this.type = r3.readInt();
        this.url = r3.readString();
        this.fileName = r3.readString();
        this.checkSum = r3.readString();
        this.timestamp = r3.readInt();
        this.success = r3.readByte();
        this.downSize = r3.readInt();
        this.downType = r3.readByte();
        this.errorCode = r3.readInt();
        this.downnetType = r3.readInt();
        this.downNetName = r3.readString();
        this.errorMsg = r3.readString();
        this.rssi = r3.readInt();
        this.sdcardStatus = r3.readInt();
        this.fileSize = r3.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.id);
        r3.writeLong(this.flag);
        r3.writeInt(this.type);
        r3.writeString(this.url);
        r3.writeString(this.fileName);
        r3.writeString(this.checkSum);
        r3.writeInt(this.timestamp);
        r3.writeByte(this.success);
        r3.writeInt(this.downSize);
        r3.writeByte(this.downType);
        r3.writeInt(this.errorCode);
        r3.writeInt(this.downnetType);
        r3.writeString(this.downNetName);
        r3.writeString(this.errorMsg);
        r3.writeInt(this.rssi);
        r3.writeInt(this.sdcardStatus);
        r3.writeInt(this.fileSize);
    }

    public UpdateInfo(Parcel r4) {
        this.checkSum = "";
        this.timestamp = -1;
        this.success = 1;
        this.downSize = -1;
        this.errorCode = 0;
        this.downnetType = 0;
        this.downNetName = "";
        this.errorMsg = "";
        this.rssi = -1;
        this.sdcardStatus = -1;
        this.fileSize = 0;
        this.mFileID = 0;
        a(r4);
    }
}
