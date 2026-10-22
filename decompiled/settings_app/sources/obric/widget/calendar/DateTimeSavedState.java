package obric.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;

/* JADX INFO: loaded from: classes5.dex */
public class DateTimeSavedState extends Preference.BaseSavedState {
    public static final Parcelable.Creator<DateTimeSavedState> CREATOR = null;
    private long mCurrentMills;
    private long mMaxMills;
    private long mMinMills;

    public DateTimeSavedState(Parcelable superState, long minMills, long currentMills, long maxMills) {
        super(superState);
        this.mMinMills = minMills;
        this.mCurrentMills = currentMills;
        this.mMaxMills = maxMills;
    }

    public long getMinMills() {
        return this.mMinMills;
    }

    public long getMaxMills() {
        return this.mMaxMills;
    }

    public long getCurrentMills() {
        return this.mCurrentMills;
    }

    public DateTimeSavedState(Parcel in) {
        super(in);
        this.mCurrentMills = 0;
        this.mMinMills = 0;
        this.mMaxMills = 0;
        this.mMinMills = in.readLong();
        this.mCurrentMills = in.readLong();
        this.mMaxMills = in.readLong();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.mMinMills);
        dest.writeLong(this.mCurrentMills);
        dest.writeLong(this.mMaxMills);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
