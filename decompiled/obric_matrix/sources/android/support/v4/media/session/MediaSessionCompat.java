package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaControllerCompat f189a;

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MediaDescriptionCompat f190f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f191g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Object f192h;

        static class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            public QueueItem a(Parcel r1) {
                return new QueueItem(r1);
            }

            public QueueItem[] b(int r1) {
                return new QueueItem[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueueItem createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueueItem[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        QueueItem(Parcel r3) {
            this.f190f = MediaDescriptionCompat.CREATOR.createFromParcel(r3);
            this.f191g = r3.readLong();
        }

        private QueueItem(Object r3, MediaDescriptionCompat r4, long r5) {
            if (r4 == null) goto L11;
            if (r5 == (-1)) goto L9;
            this.f190f = r4;
            this.f191g = r5;
            this.f192h = r3;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }

        public static QueueItem b(Object r4) {
            if (r4 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return null;
        L7:
            return new QueueItem(r4, MediaDescriptionCompat.b(d.a.a(r4)), d.a.b(r4));
        }

        public static List<QueueItem> d(List<?> r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L14;
            ArrayList r0 = new ArrayList();
            Iterator<?> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            r0.add(b(r3.next()));
            goto L8
        L10:
            return r0;
        L14:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f190f + ", Id=" + this.f191g + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            this.f190f.writeToParcel(r3, r4);
            r3.writeLong(this.f191g);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ResultReceiver f193f;

        static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            public ResultReceiverWrapper a(Parcel r1) {
                return new ResultReceiverWrapper(r1);
            }

            public ResultReceiverWrapper[] b(int r1) {
                return new ResultReceiverWrapper[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ResultReceiverWrapper createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ResultReceiverWrapper[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        ResultReceiverWrapper(Parcel r2) {
            this.f193f = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            this.f193f.writeToParcel(r1, r2);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f194f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private b f195g;

        static class a implements Parcelable.Creator<Token> {
            a() {
            }

            public Token a(Parcel r2) {
                if (Build.VERSION.SDK_INT < 21) goto L5;
                Object r1 = r2.readParcelable(null);
            L7:
                return new Token(r1);
            L5:
                r1 = r2.readStrongBinder();
                goto L7
            }

            public Token[] b(int r1) {
                return new Token[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Token createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Token[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        Token(Object r2) {
            this(r2, null, null);
        }

        Token(Object r2, b r3) {
            this(r2, r3, null);
        }

        Token(Object r1, b r2, Bundle r3) {
            this.f194f = r1;
            this.f195g = r2;
        }

        public static Token b(Object r1) {
            return d(r1, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token d(Object r2, b r3) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L9;
            d.a(r2);
            return new Token(r2, r3);
        L9:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public b e() {
            return this.f195g;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Token) == true) goto L8;
            return false;
        L8:
            Token r5 = (Token) r4;
            Object r3 = this.f194f;
            if (r3 == null) goto L11;
            Object r6 = r5.f194f;
            if (r6 != null) goto L19;
            return false;
        L19:
            return r3.equals(r6);
        L11:
            if (r5.f194f != null) goto L14;
            return true;
        L14:
            return false;
        }

        public Object f() {
            return this.f194f;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void g(b r1) {
            this.f195g = r1;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void h(Bundle r1) {
        }

        public int hashCode() {
            Object r0 = this.f194f;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            int r0 = Build.VERSION.SDK_INT;
            Object r2 = this.f194f;
            if (r0 < 21) goto L5;
            r3.writeParcelable((Parcelable) r2, r4);
            return;
        L5:
            r3.writeStrongBinder((IBinder) r2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void a(@Nullable Bundle r1) {
        if (r1 == null) goto L5;
        r1.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    public MediaControllerCompat b() {
        return this.f189a;
    }
}
