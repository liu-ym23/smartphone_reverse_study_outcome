package androidx.slice;

import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Pair;
import androidx.slice.core.SliceHints;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: loaded from: classes.dex */
public final class SliceItem extends CustomVersionedParcelable {
    private static final String FORMAT = "format";
    private static final String HINTS = "hints";
    private static final String OBJ = "obj";
    private static final String OBJ_2 = "obj_2";
    private static final String SUBTYPE = "subtype";
    String mFormat;
    protected String[] mHints;
    SliceItemHolder mHolder;
    Object mObj;
    String mSubType;

    public interface ActionHandler {
        void onAction(SliceItem r1, Context r2, Intent r3);
    }

    public @interface SliceType {
    }

    public SliceItem(Object r2, String r3, String r4, String[] r5) {
        String[] r0 = new String[0];
        this.mHints = r5;
        this.mFormat = r3;
        this.mSubType = r4;
        this.mObj = r2;
    }

    public SliceItem(Object r2, String r3, String r4, List<String> r5) {
        this(r2, r3, r4, (String[]) r5.toArray(new String[r5.size()]));
    }

    public SliceItem() {
        this.mHints = new String[0];
    }

    public SliceItem(PendingIntent r2, Slice r3, String r4, String r5, String[] r6) {
        this(new Pair(r2, r3), r4, r5, r6);
    }

    public SliceItem(ActionHandler r2, Slice r3, String r4, String r5, String[] r6) {
        this(new Pair(r2, r3), r4, r5, r6);
    }

    public List<String> getHints() {
        return Arrays.asList(this.mHints);
    }

    public void addHint(String r3) {
        this.mHints = (String[]) ArrayUtils.appendElement(String.class, this.mHints, r3);
    }

    public String getFormat() {
        return this.mFormat;
    }

    public String getSubType() {
        return this.mSubType;
    }

    public CharSequence getText() {
        return (CharSequence) this.mObj;
    }

    public IconCompat getIcon() {
        return (IconCompat) this.mObj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PendingIntent getAction() {
        F r1 = ((Pair) this.mObj).first;
        if ((r1 instanceof PendingIntent) == true) goto L5;
        return null;
    L5:
        return (PendingIntent) r1;
    }

    public void fireAction(Context r1, Intent r2) throws PendingIntent.CanceledException {
        fireActionInternal(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean fireActionInternal(Context r9, Intent r10) throws PendingIntent.CanceledException {
        F r0 = ((Pair) this.mObj).first;
        if ((r0 instanceof PendingIntent) == false) goto L6;
        ((PendingIntent) r0).send(r9, 0, r10, null, null);
        return false;
    L6:
        ((ActionHandler) r0).onAction(this, r9, r10);
        return true;
    }

    public RemoteInput getRemoteInput() {
        return (RemoteInput) this.mObj;
    }

    public int getInt() {
        return ((Integer) this.mObj).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Slice getSlice() {
        if ("action".equals(getFormat()) == false) goto L7;
        return (Slice) ((Pair) this.mObj).second;
    L7:
        return (Slice) this.mObj;
    }

    public long getLong() {
        return ((Long) this.mObj).longValue();
    }

    public long getTimestamp() {
        return ((Long) this.mObj).longValue();
    }

    public boolean hasHint(String r1) {
        return ArrayUtils.contains(this.mHints, r1);
    }

    public SliceItem(Bundle r2) {
        this.mHints = new String[0];
        this.mHints = r2.getStringArray(HINTS);
        this.mFormat = r2.getString("format");
        this.mSubType = r2.getString(SUBTYPE);
        this.mObj = readObj(this.mFormat, r2);
    }

    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putStringArray(HINTS, this.mHints);
        r0.putString("format", this.mFormat);
        r0.putString(SUBTYPE, this.mSubType);
        writeObj(r0, this.mObj, this.mFormat);
        return r0;
    }

    public boolean hasHints(String[] r7) {
        if (r7 != null) goto L5;
        return true;
    L5:
        int r1 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L13;
        String r4 = r7[r3];
        if (TextUtils.isEmpty(r4) == true) goto L12;
        if (ArrayUtils.contains(this.mHints, r4) == true) goto L12;
        return false;
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return true;
    }

    public boolean hasAnyHints(String... r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (ArrayUtils.contains(this.mHints, r6[r2]) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeObj(Bundle r3, Object r4, String r5) {
        r5.hashCode();
        byte r1 = -1;
        switch(r5.hashCode()) {
            case -1422950858: goto L30;
            case 104431: goto L26;
            case 3327612: goto L22;
            case 3556653: goto L18;
            case 100313435: goto L14;
            case 100358090: goto L10;
            case 109526418: goto L6;
            default: goto L34;
        };
    L6:
        if (r5.equals("slice") == false) goto L34;
        r1 = 6;
        goto L34
    L10:
        if (r5.equals("input") == false) goto L34;
        r1 = 5;
        goto L34
    L14:
        if (r5.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L34;
        r1 = 4;
        goto L34
    L18:
        if (r5.equals("text") == false) goto L34;
        r1 = 3;
        goto L34
    L22:
        if (r5.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L34;
        r1 = 2;
        goto L34
    L26:
        if (r5.equals("int") == false) goto L34;
        r1 = 1;
        goto L34
    L30:
        if (r5.equals("action") == false) goto L34;
        r1 = 0;
    L34:
        switch(r1) {
            case 0: goto L42;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            default: goto L50;
        };
    L36:
        r3.putParcelable(OBJ, ((Slice) r4).toBundle());
        return;
    L37:
        r3.putParcelable(OBJ, (Parcelable) r4);
        return;
    L38:
        r3.putBundle(OBJ, ((IconCompat) r4).toBundle());
        return;
    L39:
        r3.putCharSequence(OBJ, (CharSequence) r4);
        return;
    L40:
        r3.putLong(OBJ, ((Long) this.mObj).longValue());
        return;
    L41:
        r3.putInt(OBJ, ((Integer) this.mObj).intValue());
        return;
    L42:
        Pair r6 = (Pair) r4;
        r3.putParcelable(OBJ, (PendingIntent) r6.first);
        r3.putBundle(OBJ_2, ((Slice) r6.second).toBundle());
        return;
    }

    private static Object readObj(String r3, Bundle r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1422950858: goto L30;
            case 104431: goto L26;
            case 3327612: goto L22;
            case 3556653: goto L18;
            case 100313435: goto L14;
            case 100358090: goto L10;
            case 109526418: goto L6;
            default: goto L34;
        };
    L6:
        if (r3.equals("slice") == false) goto L34;
        r1 = 6;
        goto L34
    L10:
        if (r3.equals("input") == false) goto L34;
        r1 = 5;
        goto L34
    L14:
        if (r3.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L34;
        r1 = 4;
        goto L34
    L18:
        if (r3.equals("text") == false) goto L34;
        r1 = 3;
        goto L34
    L22:
        if (r3.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L34;
        r1 = 2;
        goto L34
    L26:
        if (r3.equals("int") == false) goto L34;
        r1 = 1;
        goto L34
    L30:
        if (r3.equals("action") == false) goto L34;
        r1 = 0;
    L34:
        switch(r1) {
            case 0: goto L50;
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            default: goto L36;
        };
    L36:
        throw new RuntimeException("Unsupported type " + r3);
    L38:
        return new Slice(r4.getBundle(OBJ));
    L40:
        return r4.getParcelable(OBJ);
    L42:
        return IconCompat.createFromBundle(r4.getBundle(OBJ));
    L44:
        return r4.getCharSequence(OBJ);
    L46:
        return Long.valueOf(r4.getLong(OBJ));
    L48:
        return Integer.valueOf(r4.getInt(OBJ));
    L50:
        return new Pair(r4.getParcelable(OBJ), new Slice(r4.getBundle(OBJ_2)));
    }

    public static String typeToString(String r2) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
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
        switch(r1) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L35;
        };
    L36:
        return "Slice";
    L38:
        return "RemoteInput";
    L40:
        return "Image";
    L42:
        return "Text";
    L44:
        return "Long";
    L46:
        return "Int";
    L48:
        return "Action";
    L35:
        return "Unrecognized format: " + r2;
    L6:
        if (r2.equals("slice") == false) goto L33;
        r1 = 6;
        goto L33
    L10:
        if (r2.equals("input") == false) goto L33;
        r1 = 5;
        goto L33
    L14:
        if (r2.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L33;
        r1 = 4;
        goto L33
    L18:
        if (r2.equals("text") == false) goto L33;
        r1 = 3;
        goto L33
    L22:
        if (r2.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L33;
        r1 = 2;
        goto L33
    L26:
        if (r2.equals("int") == false) goto L33;
        r1 = 1;
        goto L33
    L30:
        if (r2.equals("action") == false) goto L33;
        r1 = 0;
        goto L33
    }

    public String toString() {
        return toString("");
    }

    public String toString(String r12) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r12);
        r0.append(getFormat());
        if (getSubType() == null) goto L5;
        r0.append('<');
        r0.append(getSubType());
        r0.append('>');
    L5:
        r0.append(TokenParser.SP);
        String[] r2 = this.mHints;
        if (r2.length <= 0) goto L8;
        Slice.appendHints(r0, r2);
        r0.append(TokenParser.SP);
    L8:
        String r1 = r12 + BytedanceJustifyTextView.TWO_BLANK;
        String r3 = getFormat();
        r3.hashCode();
        byte r9 = -1;
        switch(r3.hashCode()) {
            case -1422950858: goto L32;
            case 104431: goto L28;
            case 3327612: goto L24;
            case 3556653: goto L20;
            case 100313435: goto L16;
            case 109526418: goto L12;
            default: goto L36;
        };
    L12:
        if (r3.equals("slice") == false) goto L36;
        r9 = 5;
        goto L36
    L16:
        if (r3.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L36;
        r9 = 4;
        goto L36
    L20:
        if (r3.equals("text") == false) goto L36;
        r9 = 3;
        goto L36
    L24:
        if (r3.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L36;
        r9 = 2;
        goto L36
    L28:
        if (r3.equals("int") == false) goto L36;
        r9 = 1;
        goto L36
    L32:
        if (r3.equals("action") == false) goto L36;
        r9 = 0;
    L36:
        switch(r9) {
            case 0: goto L55;
            case 1: goto L49;
            case 2: goto L42;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            default: goto L37;
        };
    L37:
        r0.append(typeToString(getFormat()));
    L56:
        r0.append("\n");
        return r0.toString();
    L38:
        r0.append("{\n");
        r0.append(getSlice().toString(r1));
        r0.append('\n').append(r12).append('}');
        goto L56
    L39:
        r0.append(getIcon());
        goto L56
    L40:
        r0.append('\"').append(getText()).append('\"');
        goto L56
    L55:
        r0.append('[').append(((Pair) this.mObj).first).append("] ");
        r0.append("{\n");
        r0.append(getSlice().toString(r1));
        r0.append('\n').append(r12).append('}');
        goto L56
    L42:
        if (SliceHints.SUBTYPE_MILLIS.equals(getSubType()) == true) goto L44;
        r0.append(getLong()).append('L');
        goto L56
    L44:
        if (getLong() != (-1)) goto L46;
        r0.append("INFINITY");
        goto L56
    L46:
        r0.append(DateUtils.getRelativeTimeSpanString(getLong(), Calendar.getInstance().getTimeInMillis(), 1000, 262144));
        goto L56
    L49:
        if ("color".equals(getSubType()) == false) goto L52;
        int r11 = getInt();
        r0.append(String.format("a=0x%02x r=0x%02x g=0x%02x b=0x%02x", new Object[]{Integer.valueOf(Color.alpha(r11)), Integer.valueOf(Color.red(r11)), Integer.valueOf(Color.green(r11)), Integer.valueOf(Color.blue(r11))}));
        goto L56
    L52:
        if ("layout_direction".equals(getSubType()) == false) goto L54;
        r0.append(layoutDirectionToString(getInt()));
        goto L56
    L54:
        r0.append(getInt());
        goto L56
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean r4) {
        this.mHolder = new SliceItemHolder(this.mFormat, this.mObj, r4);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mObj = this.mHolder.getObj(this.mFormat);
        this.mHolder = null;
    }

    private static String layoutDirectionToString(int r1) {
        if (r1 != 0) goto L4;
        return "LTR";
    L4:
        if (r1 != 1) goto L6;
        return "RTL";
    L6:
        if (r1 != 2) goto L8;
        return "INHERIT";
    L8:
        if (r1 != 3) goto L10;
        return "LOCALE";
    L10:
        return Integer.toString(r1);
    }
}
