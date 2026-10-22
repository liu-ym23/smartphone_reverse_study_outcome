package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long f203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final float f204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final long f205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final CharSequence f207l;
    final long m;
    List<CustomAction> n;
    final long o;
    final Bundle p;
    private Object q;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f208f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final CharSequence f209g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f210h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Bundle f211i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Object f212j;

        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            public CustomAction a(Parcel r1) {
                return new CustomAction(r1);
            }

            public CustomAction[] b(int r1) {
                return new CustomAction[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ CustomAction createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ CustomAction[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        CustomAction(Parcel r2) {
            this.f208f = r2.readString();
            this.f209g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
            this.f210h = r2.readInt();
            this.f211i = r2.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String r1, CharSequence r2, int r3, Bundle r4) {
            this.f208f = r1;
            this.f209g = r2;
            this.f210h = r3;
            this.f211i = r4;
        }

        public static CustomAction b(Object r5) {
            if (r5 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            CustomAction r0 = new CustomAction(e.a.a(r5), e.a.d(r5), e.a.c(r5), e.a.b(r5));
            r0.f212j = r5;
            return r0;
        L10:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f209g + ", mIcon=" + this.f210h + ", mExtras=" + this.f211i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeString(this.f208f);
            TextUtils.writeToParcel(this.f209g, r2, r3);
            r2.writeInt(this.f210h);
            r2.writeBundle(this.f211i);
        }
    }

    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        public PlaybackStateCompat a(Parcel r1) {
            return new PlaybackStateCompat(r1);
        }

        public PlaybackStateCompat[] b(int r1) {
            return new PlaybackStateCompat[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PlaybackStateCompat createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PlaybackStateCompat[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    PlaybackStateCompat(int r4, long r5, long r7, float r9, long r10, int r12, CharSequence r13, long r14, List<CustomAction> r16, long r17, Bundle r19) {
        this.f201f = r4;
        this.f202g = r5;
        this.f203h = r7;
        this.f204i = r9;
        this.f205j = r10;
        this.f206k = r12;
        this.f207l = r13;
        this.m = r14;
        this.n = new ArrayList(r16);
        this.o = r17;
        this.p = r19;
    }

    PlaybackStateCompat(Parcel r3) {
        this.f201f = r3.readInt();
        this.f202g = r3.readLong();
        this.f204i = r3.readFloat();
        this.m = r3.readLong();
        this.f203h = r3.readLong();
        this.f205j = r3.readLong();
        this.f207l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.n = r3.createTypedArrayList(CustomAction.CREATOR);
        this.o = r3.readLong();
        this.p = r3.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f206k = r3.readInt();
    }

    public static PlaybackStateCompat b(Object r23) {
        int r1 = Build.VERSION.SDK_INT;
        Bundle r2 = null;
        if (r23 != null) goto L5;
    L19:
        return null;
    L5:
        if (r1 < 21) goto L19;
        List<Object> r3 = e.d(r23);
        if (r3 == null) goto L13;
        ArrayList r4 = new ArrayList(r3.size());
        Iterator<Object> r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(CustomAction.b(r5.next()));
        goto L10
    L12:
        ArrayList r19 = r4;
    L15:
        if (r1 < 22) goto L17;
        r2 = f.a(r23);
    L17:
        PlaybackStateCompat r6 = new PlaybackStateCompat(e.i(r23), e.h(r23), e.c(r23), e.g(r23), e.a(r23), 0, e.e(r23), e.f(r23), r19, e.b(r23), r2);
        r6.q = r23;
        return r6;
    L13:
        r19 = null;
        goto L15
    }

    public static int d(long r2) {
        if (r2 != 4) goto L7;
        return 126;
    L7:
        if (r2 != 2) goto L11;
        return 127;
    L11:
        if (r2 != 32) goto L15;
        return 87;
    L15:
        if (r2 != 16) goto L19;
        return 88;
    L19:
        if (r2 != 1) goto L23;
        return 86;
    L23:
        if (r2 != 64) goto L27;
        return 90;
    L27:
        if (r2 != 8) goto L31;
        return 89;
    L31:
        if (r2 != 512) goto L34;
        return 85;
    L34:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f201f + ", position=" + this.f202g + ", buffered position=" + this.f203h + ", speed=" + this.f204i + ", updated=" + this.m + ", actions=" + this.f205j + ", error code=" + this.f206k + ", error message=" + this.f207l + ", custom actions=" + this.n + ", active item id=" + this.o + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.f201f);
        r3.writeLong(this.f202g);
        r3.writeFloat(this.f204i);
        r3.writeLong(this.m);
        r3.writeLong(this.f203h);
        r3.writeLong(this.f205j);
        TextUtils.writeToParcel(this.f207l, r3, r4);
        r3.writeTypedList(this.n);
        r3.writeLong(this.o);
        r3.writeBundle(this.p);
        r3.writeInt(this.f206k);
    }
}
