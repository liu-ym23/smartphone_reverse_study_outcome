package tmsdk.common.module.update;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CheckResult implements Parcelable {
    public static final Parcelable.Creator<CheckResult> CREATOR = null;
    public String mMessage;
    public String mTitle;
    public List<UpdateInfo> mUpdateInfoList;

    class a implements Parcelable.Creator {
        a() {
        }

        public CheckResult a(Parcel r1) {
            return new CheckResult(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public CheckResult[] a(int r1) {
            return new CheckResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CheckResult() {
    }

    public CheckResult(Parcel r1) {
        a(r1);
    }

    private void a(Parcel r2) {
        this.mTitle = r2.readString();
        this.mMessage = r2.readString();
        ArrayList r0 = new ArrayList();
        this.mUpdateInfoList = r0;
        r2.readList(r0, getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mTitle);
        r1.writeString(this.mMessage);
        r1.writeList(this.mUpdateInfoList);
    }
}
