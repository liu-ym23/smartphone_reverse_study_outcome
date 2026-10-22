package androidx.activity.result;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = null;

    @Nullable
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;

    @NonNull
    private final IntentSender mIntentSender;

    public static final class Builder {
        private Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private IntentSender mIntentSender;

        public Builder(@NonNull PendingIntent r1) {
            this(r1.getIntentSender());
        }

        public Builder(@NonNull IntentSender r1) {
            this.mIntentSender = r1;
        }

        @NonNull
        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }

        @NonNull
        public Builder setFillInIntent(@Nullable Intent r1) {
            this.mFillInIntent = r1;
            return this;
        }

        @NonNull
        public Builder setFlags(int r1, int r2) {
            this.mFlagsValues = r1;
            this.mFlagsMask = r2;
            return this;
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    IntentSenderRequest(@NonNull IntentSender r1, @Nullable Intent r2, int r3, int r4) {
        this.mIntentSender = r1;
        this.mFillInIntent = r2;
        this.mFlagsMask = r3;
        this.mFlagsValues = r4;
    }

    IntentSenderRequest(@NonNull Parcel r2) {
        this.mIntentSender = (IntentSender) r2.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent) r2.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = r2.readInt();
        this.mFlagsValues = r2.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    @NonNull
    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r2, int r3) {
        r2.writeParcelable(this.mIntentSender, r3);
        r2.writeParcelable(this.mFillInIntent, r3);
        r2.writeInt(this.mFlagsMask);
        r2.writeInt(this.mFlagsValues);
    }
}
