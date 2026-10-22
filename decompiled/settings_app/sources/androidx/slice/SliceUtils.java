package androidx.slice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Pair;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceHints;
import androidx.slice.core.SliceQuery;
import androidx.slice.widget.ListContent;
import androidx.slice.widget.ShortcutContent;
import androidx.versionedparcelable.ParcelUtils;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SliceUtils {
    public static final int LOADING_ALL = 0;
    public static final int LOADING_COMPLETE = 2;
    public static final int LOADING_PARTIAL = 1;

    public static class SerializeOptions {
        public static final int MODE_CONVERT = 2;
        public static final int MODE_REMOVE = 1;
        public static final int MODE_THROW = 0;
        private int mActionMode;
        private Bitmap.CompressFormat mFormat;
        private int mImageMode;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mQuality;

        public SerializeOptions() {
            this.mActionMode = 0;
            this.mImageMode = 0;
            this.mMaxWidth = 1000;
            this.mMaxHeight = 1000;
            this.mFormat = Bitmap.CompressFormat.PNG;
            this.mQuality = 100;
        }

        public void checkThrow(String r3) {
            r3.hashCode();
            byte r1 = -1;
            switch(r3.hashCode()) {
                case -1422950858: goto L14;
                case 100313435: goto L10;
                case 100358090: goto L6;
                default: goto L17;
            };
        L17:
            switch(r1) {
                case 0: goto L23;
                case 1: goto L20;
                case 2: goto L23;
                default: goto L18;
            };
        L18:
            return;
        L20:
            if (this.mImageMode == 0) goto L26;
            return;
        L26:
            throw new IllegalArgumentException(r3 + " cannot be serialized");
        L23:
            if (this.mActionMode == 0) goto L26;
            return;
        L6:
            if (r3.equals("input") == false) goto L17;
            r1 = 2;
            goto L17
        L10:
            if (r3.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L17;
            r1 = 1;
            goto L17
        L14:
            if (r3.equals("action") == false) goto L17;
            r1 = 0;
            goto L17
        }

        public int getActionMode() {
            return this.mActionMode;
        }

        public int getImageMode() {
            return this.mImageMode;
        }

        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        public Bitmap.CompressFormat getFormat() {
            return this.mFormat;
        }

        public int getQuality() {
            return this.mQuality;
        }

        public SerializeOptions setActionMode(int r1) {
            this.mActionMode = r1;
            return this;
        }

        public SerializeOptions setImageMode(int r1) {
            this.mImageMode = r1;
            return this;
        }

        public SerializeOptions setMaxImageWidth(int r1) {
            this.mMaxWidth = r1;
            return this;
        }

        public SerializeOptions setMaxImageHeight(int r1) {
            this.mMaxHeight = r1;
            return this;
        }

        public SerializeOptions setImageConversionFormat(Bitmap.CompressFormat r1, int r2) {
            this.mFormat = r1;
            this.mQuality = r2;
            return this;
        }
    }

    public interface SliceActionListener {
        void onSliceAction(Uri r1, Context r2, Intent r3);
    }

    public static class SliceParseException extends Exception {
        public SliceParseException(String r1, Throwable r2) {
            super(r1, r2);
        }

        public SliceParseException(String r1) {
            super(r1);
        }
    }

    private SliceUtils() {
    }

    public static Slice stripSlice(Slice r6, int r7, boolean r8) {
        ListContent r9 = new ListContent(null, r6, null, 0, 0);
        if (r9.isValid() == false) goto L23;
        Slice.Builder r0 = copyMetadata(r6);
        if (r7 != 1) goto L7;
        r0.addItem(r9.getHeaderItem());
        List<SliceAction> r10 = r9.getSliceActions();
        if (r10 == null) goto L21;
        if (r10.size() <= 0) goto L21;
        Slice.Builder r11 = new Slice.Builder(r0);
        Iterator<SliceAction> r12 = r10.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        SliceAction r13 = r12.next();
        SliceActionImpl r14 = (SliceActionImpl) r13;
        r11.addSubSlice(r14.buildSlice(new Slice.Builder(r11).addHints(new String[]{"actions"})));
        goto L17
    L19:
        r0.addSubSlice(r11.addHints(new String[]{"actions"}).build());
    L21:
        return r0.build();
    L7:
        if (r7 == 3) goto L10;
        return r6;
    L10:
        return new ShortcutContent(r9).buildSlice(r0);
    L23:
        return r6;
    }

    private static Slice.Builder copyMetadata(Slice r8) {
        Slice.Builder r0 = new Slice.Builder(r8.getUri());
        SliceItem r4 = SliceQuery.findTopLevelItem(r8, WsChannelMultiProcessSharedProvider.LONG_TYPE, "ttl", null, null);
        if (r4 == null) goto L5;
        r0.addLong(r4.getLong(), SliceHints.SUBTYPE_MILLIS, new String[]{"ttl"});
    L5:
        SliceItem r1 = SliceQuery.findTopLevelItem(r8, WsChannelMultiProcessSharedProvider.LONG_TYPE, "last_updated", null, null);
        if (r1 == null) goto L8;
        r0.addLong(r1.getLong(), SliceHints.SUBTYPE_MILLIS, new String[]{"last_updated"});
    L8:
        SliceItem r5 = SliceQuery.findTopLevelItem(r8, "int", "color", null, null);
        if (r5 == null) goto L11;
        r0.addInt(r5.getInt(), "color", new String[0]);
    L11:
        SliceItem r2 = SliceQuery.findTopLevelItem(r8, "int", "layout_direction", null, null);
        if (r2 == null) goto L14;
        r0.addInt(r2.getInt(), "layout_direction", new String[0]);
    L14:
        List<String> r3 = getSliceKeywords(r8);
        if (r3 != null) goto L17;
    L23:
        List<String> r9 = r8.getHints();
        if (r9.size() <= 0) goto L26;
        r0.addHints(r9);
    L26:
        return r0;
    L17:
        if (r3.size() <= 0) goto L23;
        Slice.Builder r6 = new Slice.Builder(r0);
        Iterator<String> r7 = r3.iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        r6.addText(r7.next(), null, new String[0]);
        goto L20
    L22:
        r0.addSubSlice(r6.addHints(new String[]{"keywords"}).build());
        goto L23
    }

    public static void serializeSlice(Slice r0, Context r1, OutputStream r2, String r3, SerializeOptions r4) throws IOException, IllegalArgumentException {
        serializeSlice(r0, r1, r2, r4);
    }

    public static void serializeSlice(Slice r0, Context r1, OutputStream r2, SerializeOptions r3) throws IllegalArgumentException {
        ParcelUtils.toOutputStream(convert(r1, r0, r3), r2);
    }

    public static Slice convert(Context r6, Slice r7, SerializeOptions r8) {
        Slice.Builder r0 = new Slice.Builder(r7.getUri());
        r0.setSpec(r7.getSpec());
        r0.addHints(r7.getHints());
        Iterator<SliceItem> r9 = r7.getItems().iterator();
    L4:
        if (r9.hasNext() == false) goto L60;
        SliceItem r1 = r9.next();
        String r2 = r1.getFormat();
        r2.hashCode();
        byte r5 = -1;
        switch(r2.hashCode()) {
            case -1422950858: goto L33;
            case 104431: goto L29;
            case 3327612: goto L25;
            case 3556653: goto L21;
            case 100313435: goto L17;
            case 100358090: goto L13;
            case 109526418: goto L9;
            default: goto L36;
        };
    L36:
        switch(r5) {
            case 0: goto L52;
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L49;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            default: goto L4;
        };
    L38:
        r0.addSubSlice(convert(r6, r1.getSlice(), r8), r1.getSubType());
        goto L4
    L40:
        if (r8.getActionMode() != 0) goto L4;
        r0.addRemoteInput(r1.getRemoteInput(), r1.getSubType(), r1.getHints());
        goto L4
    L42:
        int r3 = r8.getImageMode();
        if (r3 == 0) goto L48;
        if (r3 != 2) goto L4;
        r0.addIcon(convert(r6, r1.getIcon(), r8), r1.getSubType(), r1.getHints());
        goto L4
    L48:
        throw new IllegalArgumentException("Cannot serialize icon");
    L49:
        r0.addText(r1.getText(), r1.getSubType(), r1.getHints());
        goto L4
    L50:
        r0.addLong(r1.getLong(), r1.getSubType(), r1.getHints());
        goto L4
    L51:
        r0.addInt(r1.getInt(), r1.getSubType(), r1.getHints());
        goto L4
    L52:
        int r4 = r8.getActionMode();
        if (r4 == 0) goto L58;
        if (r4 != 2) goto L4;
        r0.addAction(new AnonymousClass1(), convert(r6, r1.getSlice(), r8), r1.getSubType());
        goto L4
    L58:
        throw new IllegalArgumentException("Cannot serialize action");
    L9:
        if (r2.equals("slice") == false) goto L36;
        r5 = 6;
        goto L36
    L13:
        if (r2.equals("input") == false) goto L36;
        r5 = 5;
        goto L36
    L17:
        if (r2.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L36;
        r5 = 4;
        goto L36
    L21:
        if (r2.equals("text") == false) goto L36;
        r5 = 3;
        goto L36
    L25:
        if (r2.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L36;
        r5 = 2;
        goto L36
    L29:
        if (r2.equals("int") == false) goto L36;
        r5 = 1;
        goto L36
    L33:
        if (r2.equals("action") == false) goto L36;
        r5 = 0;
        goto L36
    L60:
        return r0.build();
    }

    public static IconCompat convert(Context r2, IconCompat r3, SerializeOptions r4) {
        if (r3.getType() == 2) goto L6;
        byte[] r5 = SliceXml.convertToBytes(r3, r2, r4);
        return IconCompat.createWithData(r5, 0, r5.length);
    L6:
        return r3;
    }

    public static Slice parseSlice(Context r2, InputStream r3, String r4, final SliceActionListener r5) throws IOException, SliceParseException {
        BufferedInputStream r0 = new BufferedInputStream(r3);
        String r6 = Slice.class.getName();
        r0.mark(r6.length() + 4);
        boolean r7 = doesStreamStartWith(r6, r0);
        r0.reset();
        if (r7 == false) goto L7;
        Slice r8 = (Slice) ParcelUtils.fromInputStream(r0);
        setActionsAndUpdateIcons(r8, new AnonymousClass2(r5), r2);
        return r8;
    L7:
        return SliceXml.parseSlice(r2, r0, r4, r5);
    }

    private static void setActionsAndUpdateIcons(Slice r4, SliceItem.ActionHandler r5, Context r6) {
        Iterator<SliceItem> r7 = r4.getItems().iterator();
    L4:
        if (r7.hasNext() == false) goto L25;
        SliceItem r0 = r7.next();
        String r1 = r0.getFormat();
        r1.hashCode();
        byte r3 = -1;
        switch(r1.hashCode()) {
            case -1422950858: goto L17;
            case 100313435: goto L13;
            case 109526418: goto L9;
            default: goto L20;
        };
    L20:
        switch(r3) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            default: goto L4;
        };
    L22:
        setActionsAndUpdateIcons(r0.getSlice(), r5, r6);
        goto L4
    L23:
        r0.getIcon().checkResource(r6);
        goto L4
    L24:
        r0.mObj = new Pair(r5, ((Pair) r0.mObj).second);
        setActionsAndUpdateIcons(r0.getSlice(), r5, r6);
        goto L4
    L9:
        if (r1.equals("slice") == false) goto L20;
        r3 = 2;
        goto L20
    L13:
        if (r1.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L20;
        r3 = 1;
        goto L20
    L17:
        if (r1.equals("action") == false) goto L20;
        r3 = 0;
        goto L20
    }

    private static boolean doesStreamStartWith(String r4, BufferedInputStream r5) {
        byte[] r6 = r4.getBytes(Charset.forName("UTF-16"));
        int r0 = r6.length;
        byte[] r1 = new byte[r0];
    L11:
        return false;
    L4:
        if (r5.read(r1, 0, 4) >= 0) goto L7;
        return false;
    L7:
        if (r5.read(r1, 0, r0) >= 0) goto L9;
        return false;
    L9:
        return Arrays.equals(r1, r6);
    }

    public static int getLoadingState(Slice r3) {
        if (SliceQuery.find(r3, null, "partial", null) == null) goto L5;
        boolean r0 = true;
    L7:
        if (r3.getItems().size() != 0) goto L9;
        return 0;
    L9:
        if (r0 == false) goto L11;
        return 1;
    L11:
        return 2;
    L5:
        r0 = false;
        goto L7
    }

    public static List<SliceItem> getSliceActions(Slice r4) {
        SliceItem r5 = SliceQuery.find(r4, "slice", "actions", null);
        String[] r1 = {"actions", UserDictionaryAddWordContents.EXTRA_SHORTCUT};
        if (r5 != null) goto L5;
        return null;
    L5:
        return SliceQuery.findAll(r5, "slice", r1, null);
    }

    public static List<String> getSliceKeywords(Slice r4) {
        SliceItem r5 = SliceQuery.find(r4, "slice", "keywords", null);
        if (r5 == null) goto L14;
        List<SliceItem> r6 = SliceQuery.findAll(r5, "text");
        if (r6 == null) goto L14;
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= r6.size()) goto L13;
        String r2 = (String) r6.get(r1).getText();
        if (TextUtils.isEmpty(r2) == true) goto L12;
        r0.add(r2);
    L12:
        r1 = r1 + 1;
        goto L8
    L13:
        return r0;
    L14:
        return null;
    }
}
