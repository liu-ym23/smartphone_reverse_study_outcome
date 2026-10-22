package androidx.slice;

import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: loaded from: classes.dex */
public final class Slice implements VersionedParcelable {
    private static final String HINTS = "hints";
    private static final String ITEMS = "items";
    private static final String SPEC_REVISION = "revision";
    private static final String SPEC_TYPE = "type";
    private static final String URI = "uri";
    String[] mHints;
    SliceItem[] mItems;
    SliceSpec mSpec;
    String mUri;

    public static class Builder {
        private int mChildId;
        private ArrayList<String> mHints;
        private ArrayList<SliceItem> mItems;
        private SliceSpec mSpec;
        private final Uri mUri;

        public Builder(Uri r2) {
            this.mItems = new ArrayList();
            this.mHints = new ArrayList();
            this.mUri = r2;
        }

        public Builder(Builder r2) {
            this.mItems = new ArrayList();
            this.mHints = new ArrayList();
            this.mUri = r2.getChildUri();
        }

        private Uri getChildUri() {
            Uri.Builder r0 = this.mUri.buildUpon().appendPath("_gen");
            int r1 = this.mChildId;
            this.mChildId = r1 + 1;
            return r0.appendPath(String.valueOf(r1)).build();
        }

        public Builder setSpec(SliceSpec r1) {
            this.mSpec = r1;
            return this;
        }

        public Builder addHints(String... r2) {
            this.mHints.addAll(Arrays.asList(r2));
            return this;
        }

        public Builder addHints(List<String> r2) {
            return addHints((String[]) r2.toArray(new String[r2.size()]));
        }

        public Builder addSubSlice(Slice r2) {
            Preconditions.checkNotNull(r2);
            return addSubSlice(r2, null);
        }

        public Builder addSubSlice(Slice r5, String r6) {
            Preconditions.checkNotNull(r5);
            this.mItems.add(new SliceItem(r5, "slice", r6, (String[]) r5.getHints().toArray(new String[r5.getHints().size()])));
            return this;
        }

        public Builder addAction(PendingIntent r9, Slice r10, String r11) {
            Preconditions.checkNotNull(r9);
            Preconditions.checkNotNull(r10);
            String[] r6 = (String[]) r10.getHints().toArray(new String[r10.getHints().size()]);
            this.mItems.add(new SliceItem(r9, r10, "action", r11, r6));
            return this;
        }

        public Builder addAction(SliceItem.ActionHandler r9, Slice r10, String r11) {
            Preconditions.checkNotNull(r10);
            String[] r6 = (String[]) r10.getHints().toArray(new String[r10.getHints().size()]);
            this.mItems.add(new SliceItem(r9, r10, "action", r11, r6));
            return this;
        }

        public Builder addText(CharSequence r4, String r5, String... r6) {
            this.mItems.add(new SliceItem(r4, "text", r5, r6));
            return this;
        }

        public Builder addText(CharSequence r2, String r3, List<String> r4) {
            return addText(r2, r3, (String[]) r4.toArray(new String[r4.size()]));
        }

        public Builder addIcon(IconCompat r4, String r5, String... r6) {
            Preconditions.checkNotNull(r4);
            if (Slice.isValidIcon(r4) == false) goto L5;
            this.mItems.add(new SliceItem(r4, SlardarSettingsConsts.SETTING_IMAGE, r5, r6));
        L5:
            return this;
        }

        public Builder addIcon(IconCompat r2, String r3, List<String> r4) {
            Preconditions.checkNotNull(r2);
            if (Slice.isValidIcon(r2) == true) goto L5;
            return this;
        L5:
            return addIcon(r2, r3, (String[]) r4.toArray(new String[r4.size()]));
        }

        public Builder addRemoteInput(RemoteInput r2, String r3, List<String> r4) {
            Preconditions.checkNotNull(r2);
            return addRemoteInput(r2, r3, (String[]) r4.toArray(new String[r4.size()]));
        }

        public Builder addRemoteInput(RemoteInput r4, String r5, String... r6) {
            Preconditions.checkNotNull(r4);
            this.mItems.add(new SliceItem(r4, "input", r5, r6));
            return this;
        }

        public Builder addInt(int r4, String r5, String... r6) {
            this.mItems.add(new SliceItem(Integer.valueOf(r4), "int", r5, r6));
            return this;
        }

        public Builder addInt(int r2, String r3, List<String> r4) {
            return addInt(r2, r3, (String[]) r4.toArray(new String[r4.size()]));
        }

        public Builder addLong(long r3, String r5, String... r6) {
            this.mItems.add(new SliceItem(Long.valueOf(r3), WsChannelMultiProcessSharedProvider.LONG_TYPE, r5, r6));
            return this;
        }

        public Builder addLong(long r2, String r4, List<String> r5) {
            return addLong(r2, r4, (String[]) r5.toArray(new String[r5.size()]));
        }

        @Deprecated
        public Builder addTimestamp(long r3, String r5, String... r6) {
            this.mItems.add(new SliceItem(Long.valueOf(r3), WsChannelMultiProcessSharedProvider.LONG_TYPE, r5, r6));
            return this;
        }

        public Builder addTimestamp(long r2, String r4, List<String> r5) {
            return addTimestamp(r2, r4, (String[]) r5.toArray(new String[r5.size()]));
        }

        public Builder addItem(SliceItem r2) {
            this.mItems.add(r2);
            return this;
        }

        public Slice build() {
            ArrayList<SliceItem> r1 = this.mItems;
            ArrayList<String> r2 = this.mHints;
            return new Slice(r1, (String[]) r2.toArray(new String[r2.size()]), this.mUri, this.mSpec);
        }
    }

    public @interface SliceHint {
    }

    Slice(ArrayList<SliceItem> r3, String[] r4, Uri r5, SliceSpec r6) {
        this.mItems = new SliceItem[0];
        String[] r0 = new String[0];
        this.mHints = r4;
        this.mItems = (SliceItem[]) r3.toArray(new SliceItem[r3.size()]);
        this.mUri = r5.toString();
        this.mSpec = r6;
    }

    public Slice() {
        this.mItems = new SliceItem[0];
        this.mHints = new String[0];
    }

    public Slice(Bundle r6) {
        int r0 = 0;
        this.mItems = new SliceItem[0];
        this.mHints = new String[0];
        this.mHints = r6.getStringArray(HINTS);
        Parcelable[] r1 = r6.getParcelableArray(ITEMS);
        this.mItems = new SliceItem[r1.length];
    L3:
        SliceItem[] r2 = this.mItems;
        if (r0 >= r2.length) goto L9;
        if ((r1[r0] instanceof Bundle) == false) goto L8;
        r2[r0] = new SliceItem((Bundle) r1[r0]);
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        this.mUri = r6.getParcelable("uri").toString();
        if (r6.containsKey("type") == false) goto L12;
        SliceSpec r3 = new SliceSpec(r6.getString("type"), r6.getInt(SPEC_REVISION));
    L13:
        this.mSpec = r3;
        return;
    L12:
        r3 = null;
        goto L13
    }

    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putStringArray(HINTS, this.mHints);
        Parcelable[] r1 = new Parcelable[this.mItems.length];
        int r2 = 0;
    L3:
        SliceItem[] r3 = this.mItems;
        if (r2 >= r3.length) goto L6;
        r1[r2] = r3[r2].toBundle();
        r2 = r2 + 1;
        goto L3
    L6:
        r0.putParcelableArray(ITEMS, r1);
        r0.putParcelable("uri", Uri.parse(this.mUri));
        SliceSpec r4 = this.mSpec;
        if (r4 == null) goto L9;
        r0.putString("type", r4.getType());
        r0.putInt(SPEC_REVISION, this.mSpec.getRevision());
    L9:
        return r0;
    }

    public SliceSpec getSpec() {
        return this.mSpec;
    }

    public Uri getUri() {
        return Uri.parse(this.mUri);
    }

    public List<SliceItem> getItems() {
        return Arrays.asList(this.mItems);
    }

    public List<String> getHints() {
        return Arrays.asList(this.mHints);
    }

    public boolean hasHint(String r1) {
        return ArrayUtils.contains(this.mHints, r1);
    }

    public String toString() {
        return toString("");
    }

    public String toString(String r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r6);
        r0.append("Slice ");
        String[] r1 = this.mHints;
        if (r1.length <= 0) goto L5;
        appendHints(r0, r1);
        r0.append(TokenParser.SP);
    L5:
        r0.append('[');
        r0.append(this.mUri);
        r0.append("] {\n");
        String r2 = r6 + BytedanceJustifyTextView.TWO_BLANK;
        int r3 = 0;
    L6:
        SliceItem[] r4 = this.mItems;
        if (r3 >= r4.length) goto L9;
        r0.append(r4[r3].toString(r2));
        r3 = r3 + 1;
        goto L6
    L9:
        r0.append(r6);
        r0.append('}');
        return r0.toString();
    }

    public static void appendHints(StringBuilder r3, String[] r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length == 0) goto L13;
        r3.append('(');
        int r0 = r4.length - 1;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        r3.append(r4[r1]);
        r3.append(", ");
        r1 = r1 + 1;
        goto L7
    L9:
        r3.append(r4[r0]);
        r3.append(")");
        return;
    }

    public static Slice bindSlice(Context r0, Uri r1, Set<SliceSpec> r2) {
        return callBindSlice(r0, r1, r2);
    }

    private static Slice callBindSlice(Context r1, Uri r2, Set<SliceSpec> r3) {
        return SliceConvert.wrap(((android.app.slice.SliceManager) r1.getSystemService(android.app.slice.SliceManager.class)).bindSlice(r2, SliceConvert.unwrap(r3)), r1);
    }

    static boolean isValidIcon(IconCompat r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.mType == 2) goto L8;
        return true;
    L8:
        if (r3.getResId() == 0) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Failed to add icon, invalid resource id: " + r3.getResId());
    }
}
