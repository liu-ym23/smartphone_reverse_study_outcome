package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = null;
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    public static final class Builder {
        private Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private IntentSender mIntentSender;

        public Builder(IntentSender r1) {
            this.mIntentSender = r1;
        }

        public Builder(PendingIntent r1) {
            this(r1.getIntentSender());
        }

        public Builder setFillInIntent(Intent r1) {
            this.mFillInIntent = r1;
            return this;
        }

        public Builder setFlags(int r1, int r2) {
            this.mFlagsValues = r1;
            this.mFlagsMask = r2;
            return this;
        }

        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    IntentSenderRequest(IntentSender r1, Intent r2, int r3, int r4) {
        this.mIntentSender = r1;
        this.mFillInIntent = r2;
        this.mFlagsMask = r3;
        this.mFlagsValues = r4;
    }

    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    IntentSenderRequest(Parcel r2) {
        this.mIntentSender = (IntentSender) r2.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent) r2.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = r2.readInt();
        this.mFlagsValues = r2.readInt();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mIntentSender, r3);
        r2.writeParcelable(this.mFillInIntent, r3);
        r2.writeInt(this.mFlagsMask);
        r2.writeInt(this.mFlagsValues);
    }
}
