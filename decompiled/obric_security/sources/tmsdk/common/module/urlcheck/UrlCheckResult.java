package tmsdk.common.module.urlcheck;

import android.os.Parcel;
import android.os.Parcelable;
import tmsdkobf.qf;

/* JADX INFO: loaded from: classes5.dex */
public class UrlCheckResult implements Parcelable {
    public static Parcelable.Creator<UrlCheckResult> CREATOR = null;
    public static final int EVIL_CHEAT1 = 1;
    public static final int EVIL_CHEAT2 = 2;
    public static final int EVIL_FAULTSALES = 3;
    public static final int EVIL_ILLEGALCONTENT = 8;
    public static final int EVIL_LOTTERYWEB = 5;
    public static final int EVIL_MALICEFILE = 4;
    public static final int EVIL_NET_ERROR = -1;
    public static final int EVIL_NOEVIL = 0;
    public static final int EVIL_RISKWEB = 7;
    public static final int EVIL_SEXYWEB = 6;
    public static final int RESULT_HARM = 3;
    public static final int RESULT_NET_ERROR = -1;
    public static final int RESULT_REGULAR = 0;
    public static final int RESULT_SHADINESS = 2;
    public static final int RESULT_UNKNOWN = Integer.MAX_VALUE;
    public int mBlockLevel;
    public int mErrCode;
    public int mEvilTag;
    public int mEvilType;
    public String mUrl;
    public int mainHarmId;
    public int result;

    class a implements Parcelable.Creator {
        a() {
        }

        public UrlCheckResult a(Parcel r2) {
            UrlCheckResult r1 = new UrlCheckResult();
            r1.mUrl = r2.readString();
            r1.mainHarmId = r2.readInt();
            r1.result = r2.readInt();
            r1.mErrCode = r2.readInt();
            r1.mEvilType = r2.readInt();
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public UrlCheckResult[] a(int r1) {
            return new UrlCheckResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public UrlCheckResult() {
        this.mainHarmId = Integer.MAX_VALUE;
        this.result = Integer.MAX_VALUE;
        this.mErrCode = 0;
        this.mEvilType = 0;
        this.mEvilTag = 0;
        this.mBlockLevel = 0;
    }

    public static void responseToRes(UrlCheckResult r3, qf r4) {
        r3.mUrl = r4.f443a;
        int r0 = r4.b;
        r3.mainHarmId = r0;
        if (r0 != 13) goto L5;
        r3.mainHarmId = 0;
    L5:
        int r1 = r4.f;
        r3.result = r1;
        if (r1 != 1) goto L8;
        r3.result = 0;
    L8:
        r3.mEvilType = r4.b();
        r3.mEvilTag = r4.c();
        r3.mBlockLevel = r4.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mUrl);
        r1.writeInt(this.mainHarmId);
        r1.writeInt(this.result);
        r1.writeInt(this.mErrCode);
        r1.writeInt(this.mEvilType);
        r1.writeInt(this.mEvilTag);
        r1.writeInt(this.mBlockLevel);
    }

    public UrlCheckResult(int r2) {
        this.mainHarmId = Integer.MAX_VALUE;
        this.result = Integer.MAX_VALUE;
        this.mEvilType = 0;
        this.mEvilTag = 0;
        this.mBlockLevel = 0;
        this.mErrCode = r2;
    }

    public UrlCheckResult(String r2, int r3, int r4, int r5, int r6) {
        this.mainHarmId = Integer.MAX_VALUE;
        this.mErrCode = 0;
        this.mUrl = r2;
        this.result = r3;
        this.mEvilType = r4;
        this.mEvilTag = r5;
        this.mBlockLevel = r6;
    }

    public UrlCheckResult(qf r4) {
        this.mainHarmId = Integer.MAX_VALUE;
        this.result = Integer.MAX_VALUE;
        this.mErrCode = 0;
        this.mEvilType = 0;
        this.mEvilTag = 0;
        this.mBlockLevel = 0;
        this.mUrl = r4.f443a;
        int r1 = r4.b;
        this.mainHarmId = r1;
        if (r1 != 13) goto L5;
        this.mainHarmId = 0;
    L5:
        int r2 = r4.f;
        this.result = r2;
        if (r2 != 1) goto L8;
        this.result = 0;
    L8:
        this.mEvilType = r4.b();
        this.mEvilTag = r4.c();
        this.mBlockLevel = r4.a();
    }
}
