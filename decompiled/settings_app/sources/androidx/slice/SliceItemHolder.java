package androidx.slice;

import android.app.PendingIntent;
import android.os.Parcelable;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import androidx.core.util.Pair;
import androidx.versionedparcelable.VersionedParcelable;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;

/* JADX INFO: loaded from: classes.dex */
public class SliceItemHolder implements VersionedParcelable {
    int mInt;
    long mLong;
    Parcelable mParcelable;
    String mStr;
    VersionedParcelable mVersionedParcelable;

    public SliceItemHolder() {
    }

    public SliceItemHolder(String r4, Object r5, boolean r6) {
        r4.hashCode();
        byte r2 = -1;
        switch(r4.hashCode()) {
            case -1422950858: goto L30;
            case 104431: goto L26;
            case 3327612: goto L22;
            case 3556653: goto L18;
            case 100313435: goto L14;
            case 100358090: goto L10;
            case 109526418: goto L6;
            default: goto L33;
        };
    L33:
        switch(r2) {
            case 0: goto L47;
            case 1: goto L46;
            case 2: goto L45;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L35;
            case 6: goto L39;
            default: goto L63;
        };
    L35:
        if (r6 == true) goto L38;
        this.mParcelable = (Parcelable) r5;
        return;
    L38:
        throw new IllegalArgumentException("Cannot write RemoteInput to stream");
    L39:
        this.mVersionedParcelable = (VersionedParcelable) r5;
        return;
    L45:
        this.mLong = ((Long) r5).longValue();
        return;
    L46:
        this.mInt = ((Integer) r5).intValue();
        return;
    L47:
        Pair r7 = (Pair) r5;
        if ((r7.first instanceof PendingIntent) == false) goto L53;
        if (r6 == true) goto L52;
        this.mParcelable = (Parcelable) r7.first;
    L54:
        this.mVersionedParcelable = (VersionedParcelable) r7.second;
        return;
    L52:
        throw new IllegalArgumentException("Cannot write PendingIntent to stream");
    L53:
        if (r6 == true) goto L54;
        throw new IllegalArgumentException("Cannot write callback to parcel");
    L63:
        return;
    L41:
        if ((r5 instanceof Spanned) == false) goto L43;
        String r8 = HtmlCompat.toHtml((Spanned) r5, 0);
    L44:
        this.mStr = r8;
        return;
    L43:
        r8 = (String) r5;
        goto L44
    L6:
        if (r4.equals("slice") == false) goto L33;
        r2 = 6;
        goto L33
    L10:
        if (r4.equals("input") == false) goto L33;
        r2 = 5;
        goto L33
    L14:
        if (r4.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L33;
        r2 = 4;
        goto L33
    L18:
        if (r4.equals("text") == false) goto L33;
        r2 = 3;
        goto L33
    L22:
        if (r4.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L33;
        r2 = 2;
        goto L33
    L26:
        if (r4.equals("int") == false) goto L33;
        r2 = 1;
        goto L33
    L30:
        if (r4.equals("action") == false) goto L33;
        r2 = 0;
        goto L33
    }

    public Object getObj(String r4) {
        r4.hashCode();
        byte r2 = -1;
        switch(r4.hashCode()) {
            case -1422950858: goto L30;
            case 104431: goto L26;
            case 3327612: goto L22;
            case 3556653: goto L18;
            case 100313435: goto L14;
            case 100358090: goto L10;
            case 109526418: goto L6;
            default: goto L33;
        };
    L33:
        switch(r2) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L39;
            default: goto L35;
        };
    L40:
        String r5 = this.mStr;
        if (r5 != null) goto L43;
        return "";
    L43:
        if (r5.length() != 0) goto L46;
        return "";
    L46:
        return HtmlCompat.fromHtml(this.mStr, 0);
    L35:
        throw new IllegalArgumentException("Unrecognized format " + r4);
    L37:
        return this.mParcelable;
    L39:
        return this.mVersionedParcelable;
    L50:
        return Long.valueOf(this.mLong);
    L52:
        return Integer.valueOf(this.mInt);
    L54:
        return new Pair(this.mParcelable, (Slice) this.mVersionedParcelable);
    L6:
        if (r4.equals("slice") == false) goto L33;
        r2 = 6;
        goto L33
    L10:
        if (r4.equals("input") == false) goto L33;
        r2 = 5;
        goto L33
    L14:
        if (r4.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L33;
        r2 = 4;
        goto L33
    L18:
        if (r4.equals("text") == false) goto L33;
        r2 = 3;
        goto L33
    L22:
        if (r4.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L33;
        r2 = 2;
        goto L33
    L26:
        if (r4.equals("int") == false) goto L33;
        r2 = 1;
        goto L33
    L30:
        if (r4.equals("action") == false) goto L33;
        r2 = 0;
        goto L33
    }
}
