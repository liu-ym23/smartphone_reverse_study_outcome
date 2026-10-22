package com.bytedanceos.numberassistant.xysdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class XySdkParserItem implements Parcelable {
    public static final Parcelable.Creator<XySdkParserItem> CREATOR = null;
    public long msgId;
    public String sign;
    public int status;
    public int type;
    public ArrayList<UrlItem> urlItems;

    public static class UrlItem implements Parcelable {
        public static final Parcelable.Creator<UrlItem> CREATOR = null;
        public int endIndex;
        public String instruct;
        public boolean isWarningUrl;
        public int startIndex;
        public String text;
        public int type;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public UrlItem() {
        }

        public UrlItem(Parcel in) {
            this.text = in.readString();
            this.type = in.readInt();
            this.startIndex = in.readInt();
            this.endIndex = in.readInt();
            boolean r1 = true;
            if (in.readInt() == 1) goto L6;
            r1 = false;
        L6:
            this.isWarningUrl = r1;
            this.instruct = in.readString();
        }

        public String toString() {
            return "text=" + this.text + ", type=" + this.type + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", isWarningUrl=" + this.isWarningUrl + ", instruct=" + this.instruct;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.text);
            r1.writeInt(this.type);
            r1.writeInt(this.startIndex);
            r1.writeInt(this.endIndex);
            r1.writeInt(this.isWarningUrl ? 1 : 0);
            r1.writeString(this.instruct);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XySdkParserItem() {
        this.type = -2016;
        this.status = -2016;
        this.sign = "";
        this.urlItems = new ArrayList();
    }

    public XySdkParserItem(Parcel in) {
        this.type = -2016;
        this.status = -2016;
        this.sign = "";
        this.urlItems = new ArrayList();
        this.type = in.readInt();
        this.msgId = in.readLong();
        this.status = in.readInt();
        this.sign = in.readString();
        this.urlItems = in.readArrayList(UrlItem.class.getClassLoader());
    }

    public String toString() {
        return "type=" + this.type + ", msgId=" + this.msgId + ", status=" + this.status + ", sign=" + this.sign + ", urlItems=" + this.urlItems.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeLong(this.msgId);
        dest.writeInt(this.status);
        dest.writeString(this.sign);
        dest.writeList(this.urlItems);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
