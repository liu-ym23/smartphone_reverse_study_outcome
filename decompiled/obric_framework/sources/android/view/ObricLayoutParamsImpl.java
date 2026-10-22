package android.view;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class ObricLayoutParamsImpl implements IObricLayoutParams {
    private WindowManager.LayoutParams mBase;
    private int privateFlags;

    public ObricLayoutParamsImpl(WindowManager.LayoutParams base) {
        this.mBase = base;
    }

    public void init(Parcel in) {
        this.privateFlags = in.readInt();
    }

    public void writeToParcel(Parcel out, int parcelableFlags) {
        out.writeInt(this.privateFlags);
    }

    public int copyFrom(IObricLayoutParams o) {
        if ((o instanceof ObricLayoutParamsImpl) == false) goto L7;
        this.privateFlags = ((ObricLayoutParamsImpl) o).privateFlags;
        return 0;
    L7:
        return 0;
    }

    public void addPrivateFlag(int flag) {
        this.privateFlags |= flag;
    }

    public void clearPrivateFlag(int flag) {
        this.privateFlags &= ~flag;
    }

    public int getPrivateFlags() {
        return this.privateFlags;
    }
}
