package android.content;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class ObricIntentImpl implements IObricIntent {
    public Intent mIntent;
    private int mObricFlags;

    public ObricIntentImpl(Intent intent) {
        this.mIntent = intent;
    }

    public void copy(IObricIntent obricIntent) {
        if ((obricIntent instanceof ObricIntentImpl) == false) goto L6;
        this.mObricFlags = ((ObricIntentImpl) obricIntent).mObricFlags;
        return;
    }

    public int getObricFlags() {
        return this.mObricFlags;
    }

    public void readFromParcel(Parcel in) {
        this.mObricFlags = in.readInt();
    }

    public void writeToParcel(Parcel dest) {
        dest.writeInt(this.mObricFlags);
    }

    public void removeObricFlags(int flags) {
        this.mObricFlags &= ~flags;
    }

    public void addObricFlags(int flags) {
        this.mObricFlags |= flags;
    }
}
