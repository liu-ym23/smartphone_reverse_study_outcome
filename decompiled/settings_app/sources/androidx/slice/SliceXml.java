package androidx.slice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.graphics.drawable.IconCompat;
import com.android.settingslib.SliceBroadcastRelay;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.librarian.LibrarianImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class SliceXml {
    private static final String ATTR_FORMAT = "format";
    private static final String ATTR_HINTS = "hints";
    private static final String ATTR_ICON_PACKAGE = "pkg";
    private static final String ATTR_ICON_RES_TYPE = "resType";
    private static final String ATTR_ICON_TYPE = "iconType";
    private static final String ATTR_SUBTYPE = "subtype";
    private static final String ATTR_URI = "uri";
    private static final String ICON_TYPE_DEFAULT = "def";
    private static final String ICON_TYPE_RES = "res";
    private static final String ICON_TYPE_URI = "uri";
    private static final String NAMESPACE = null;
    private static final String TAG_ACTION = "action";
    private static final String TAG_ITEM = "item";
    private static final String TAG_SLICE = "slice";

    static {
    }

    public static Slice parseSlice(Context r3, InputStream r4, String r5, SliceUtils.SliceActionListener r6) throws IOException, SliceUtils.SliceParseException {
        XmlPullParser r0 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: XmlPullParserException -> L15
        r0.setInput(r4, r5);     // Catch: XmlPullParserException -> L15
        int r7 = r0.getDepth();     // Catch: XmlPullParserException -> L15
        Slice r8 = null;
    L3:
        int r1 = r0.next();     // Catch: XmlPullParserException -> L15
        if (r1 == 1) goto L14;
        if (r1 != 3) goto L10;
        if (r0.getDepth() <= r7) goto L14;
    L10:
        if (r1 != 2) goto L3;
        r8 = parseSlice(r3, r0, r6);     // Catch: XmlPullParserException -> L15
    L14:
        return r8;
    L15:
        e = move-exception;
        throw new IOException("Unable to init XML Serialization", e);
    }

    private static Slice parseSlice(Context r4, XmlPullParser r5, SliceUtils.SliceActionListener r6) throws IOException, XmlPullParserException, SliceUtils.SliceParseException {
        if ("slice".equals(r5.getName()) == false) goto L5;
    L9:
        int r0 = r5.getDepth();
        String r1 = NAMESPACE;
        Slice.Builder r3 = new Slice.Builder(Uri.parse(r5.getAttributeValue(r1, SliceBroadcastRelay.EXTRA_URI)));
        r3.addHints(hints(r5.getAttributeValue(r1, ATTR_HINTS)));
    L10:
        int r2 = r5.next();
        if (r2 == 1) goto L22;
        if (r2 != 3) goto L17;
        if (r5.getDepth() <= r0) goto L22;
    L17:
        if (r2 != 2) goto L10;
        if (TAG_ITEM.equals(r5.getName()) == false) goto L10;
        parseItem(r4, r3, r5, r6);
    L22:
        return r3.build();
    L5:
        if (TAG_ACTION.equals(r5.getName()) == true) goto L9;
        throw new IOException("Unexpected tag " + r5.getName());
    }

    private static void parseItem(Context r17, Slice.Builder r18, XmlPullParser r19, final SliceUtils.SliceActionListener r20) throws IOException, XmlPullParserException, SliceUtils.SliceParseException {
        int r4 = r19.getDepth();
        String r5 = NAMESPACE;
        String r6 = r19.getAttributeValue(r5, "format");
        String r7 = r19.getAttributeValue(r5, ATTR_SUBTYPE);
        String r8 = r19.getAttributeValue(r5, ATTR_HINTS);
        String r9 = r19.getAttributeValue(r5, ATTR_ICON_TYPE);
        String r10 = r19.getAttributeValue(r5, "pkg");
        String r11 = r19.getAttributeValue(r5, ATTR_ICON_RES_TYPE);
        String[] r12 = hints(r8);
    L3:
        int r13 = r19.next();
        if (r13 == 1) goto L63;
        if (r13 != 3) goto L10;
        if (r19.getDepth() > r4) goto L10;
        return;
    L10:
        if (r13 == 4) goto L11;
        if (r13 != 2) goto L59;
        if ("slice".equals(r19.getName()) == false) goto L59;
        r18.addSubSlice(parseSlice(r17, r19, r20), r7);
    L59:
        if (r13 != 2) goto L3;
        if (TAG_ACTION.equals(r19.getName()) == false) goto L3;
        r18.addAction(new AnonymousClass1(r20), parseSlice(r17, r19, r20), r7);
        goto L3
    L11:
        r6.hashCode();
        byte r16 = -1;
        switch(r6.hashCode()) {
            case 104431: goto L31;
            case 3327612: goto L27;
            case 3556653: goto L23;
            case 100313435: goto L19;
            case 100358090: goto L15;
            default: goto L34;
        };
    L34:
        switch(r16) {
            case 0: goto L54;
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L37;
            case 4: goto L3;
            default: goto L36;
        };
    L36:
        throw new IllegalArgumentException("Unrecognized format " + r6);
    L37:
        r9.hashCode();
        if (r9.equals(ICON_TYPE_RES) == false) goto L40;
        String r14 = r19.getText();
        int r15 = r17.getPackageManager().getResourcesForApplication(r10).getIdentifier(r14, r11, r10);     // Catch: PackageManager.NameNotFoundException -> L49
        if (r15 == 0) goto L48;
        r18.addIcon(IconCompat.createWithResource(r17.createPackageContext(r10, 0), r15), r7, r12);     // Catch: PackageManager.NameNotFoundException -> L49
        goto L3
    L48:
        throw new SliceUtils.SliceParseException("Cannot find resource " + r10 + ":" + r11 + LibrarianImpl.Constants.SEPARATOR + r14);     // Catch: PackageManager.NameNotFoundException -> L49
    L49:
        e = move-exception;
        throw new SliceUtils.SliceParseException("Invalid icon package " + r10, e);
    L40:
        if (r9.equals(SliceBroadcastRelay.EXTRA_URI) == false) goto L41;
        r18.addIcon(IconCompat.createWithContentUri(r19.getText()), r7, r12);
        goto L3
    L41:
        byte[] r110 = Base64.decode(r19.getText(), 2);
        r18.addIcon(IconCompat.createWithBitmap(BitmapFactory.decodeByteArray(r110, 0, r110.length)), r7, r12);
        goto L3
    L52:
        r18.addText(Html.fromHtml(r19.getText()), r7, r12);
        goto L3
    L53:
        r18.addLong(Long.parseLong(r19.getText()), r7, r12);
        goto L3
    L54:
        r18.addInt(Integer.parseInt(r19.getText()), r7, r12);
        goto L3
    L15:
        if (r6.equals("input") == false) goto L34;
        r16 = 4;
        goto L34
    L19:
        if (r6.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L34;
        r16 = 3;
        goto L34
    L23:
        if (r6.equals("text") == false) goto L34;
        r16 = 2;
        goto L34
    L27:
        if (r6.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L34;
        r16 = 1;
        goto L34
    L31:
        if (r6.equals("int") == false) goto L34;
        r16 = 0;
        goto L34
    }

    private static String[] hints(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return new String[0];
    L6:
        return r1.split(",");
    }

    public static void serializeSlice(Slice r7, Context r8, OutputStream r9, String r10, SliceUtils.SerializeOptions r11) throws IOException {
        XmlSerializer r0 = XmlPullParserFactory.newInstance().newSerializer();     // Catch: XmlPullParserException -> L4
        r0.setOutput(r9, r10);     // Catch: XmlPullParserException -> L4
        r0.startDocument(r10, null);     // Catch: XmlPullParserException -> L4
        serialize(r7, r8, r11, r0, false, null);     // Catch: XmlPullParserException -> L4
        r0.endDocument();     // Catch: XmlPullParserException -> L4
        r0.flush();     // Catch: XmlPullParserException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException("Unable to init XML Serialization", e);
    }

    private static void serialize(Slice r5, Context r6, SliceUtils.SerializeOptions r7, XmlSerializer r8, boolean r9, String r10) throws IOException {
        String r0 = NAMESPACE;
        String r1 = TAG_ACTION;
        if (r9 == false) goto L5;
        String r3 = TAG_ACTION;
    L6:
        r8.startTag(r0, r3);
        r8.attribute(r0, SliceBroadcastRelay.EXTRA_URI, r5.getUri().toString());
        if (r10 == null) goto L10;
        r8.attribute(r0, ATTR_SUBTYPE, r10);
    L10:
        if (r5.getHints().isEmpty() == true) goto L12;
        r8.attribute(r0, ATTR_HINTS, hintStr(r5.getHints()));
    L12:
        Iterator<SliceItem> r11 = r5.getItems().iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        serialize(r11.next(), r6, r7, r8);
        goto L14
    L16:
        String r12 = NAMESPACE;
        if (r9 == true) goto L20;
        r1 = "slice";
    L20:
        r8.endTag(r12, r1);
        return;
    L5:
        r3 = "slice";
        goto L6
    }

    private static void serialize(SliceItem r12, Context r13, SliceUtils.SerializeOptions r14, XmlSerializer r15) throws IOException {
        String r0 = r12.getFormat();
        r14.checkThrow(r0);
        String r1 = NAMESPACE;
        r15.startTag(r1, TAG_ITEM);
        r15.attribute(r1, "format", r0);
        if (r12.getSubType() == null) goto L6;
        r15.attribute(r1, ATTR_SUBTYPE, r12.getSubType());
    L6:
        if (r12.getHints().isEmpty() == true) goto L8;
        r15.attribute(r1, ATTR_HINTS, hintStr(r12.getHints()));
    L8:
        r0.hashCode();
        byte r6 = -1;
        switch(r0.hashCode()) {
            case -1422950858: goto L36;
            case 104431: goto L32;
            case 3327612: goto L28;
            case 3556653: goto L24;
            case 100313435: goto L20;
            case 100358090: goto L16;
            case 109526418: goto L12;
            default: goto L39;
        };
    L39:
        switch(r6) {
            case 0: goto L66;
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L60;
            case 4: goto L44;
            case 5: goto L70;
            case 6: goto L42;
            default: goto L41;
        };
    L42:
        serialize(r12.getSlice(), r13, r14, r15, false, r12.getSubType());
        goto L70
    L63:
        r15.text(String.valueOf(r12.getLong()));
        goto L70
    L64:
        r15.text(String.valueOf(r12.getInt()));
    L70:
        r15.endTag(r1, TAG_ITEM);
        return;
    L41:
        throw new IllegalArgumentException("Unrecognized format " + r0);
    L44:
        if (r14.getImageMode() != 2) goto L55;
        IconCompat r16 = r12.getIcon();
        int r2 = r16.getType();
        if (r2 == 2) goto L53;
        if (r2 == 4) goto L50;
        serializeIcon(r15, r16, r13, r14);
        goto L70
    L50:
        if ("file".equals(r16.getUri().getScheme()) == false) goto L52;
        serializeFileIcon(r15, r16, r13);
        goto L70
    L52:
        serializeIcon(r15, r16, r13, r14);
        goto L70
    L53:
        serializeResIcon(r15, r16, r13);
        goto L70
    L55:
        if (r14.getImageMode() != 0) goto L70;
        throw new IllegalArgumentException("Slice contains an image " + r12);
    L60:
        if ((r12.getText() instanceof Spanned) == false) goto L62;
        r15.text(Html.toHtml((Spanned) r12.getText()));
        goto L70
    L62:
        r15.text(String.valueOf(r12.getText()));
        goto L70
    L66:
        if (r14.getActionMode() != 2) goto L69;
        serialize(r12.getSlice(), r13, r14, r15, true, r12.getSubType());
        goto L70
    L69:
        if (r14.getActionMode() != 0) goto L70;
        throw new IllegalArgumentException("Slice contains an action " + r12);
    L12:
        if (r0.equals("slice") == false) goto L39;
        r6 = 6;
        goto L39
    L16:
        if (r0.equals("input") == false) goto L39;
        r6 = 5;
        goto L39
    L20:
        if (r0.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L39;
        r6 = 4;
        goto L39
    L24:
        if (r0.equals("text") == false) goto L39;
        r6 = 3;
        goto L39
    L28:
        if (r0.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L39;
        r6 = 2;
        goto L39
    L32:
        if (r0.equals("int") == false) goto L39;
        r6 = 1;
        goto L39
    L36:
        if (r0.equals(TAG_ACTION) == false) goto L39;
        r6 = 0;
        goto L39
    }

    private static void serializeResIcon(XmlSerializer r3, IconCompat r4, Context r5) throws IOException {
        Resources r6 = r5.getPackageManager().getResourcesForApplication(r4.getResPackage());     // Catch: PackageManager.NameNotFoundException -> L4
        int r7 = r4.getResId();     // Catch: PackageManager.NameNotFoundException -> L4
        String r0 = NAMESPACE;     // Catch: PackageManager.NameNotFoundException -> L4
        r3.attribute(r0, ATTR_ICON_TYPE, ICON_TYPE_RES);     // Catch: PackageManager.NameNotFoundException -> L4
        r3.attribute(r0, "pkg", r6.getResourcePackageName(r7));     // Catch: PackageManager.NameNotFoundException -> L4
        r3.attribute(r0, ATTR_ICON_RES_TYPE, r6.getResourceTypeName(r7));     // Catch: PackageManager.NameNotFoundException -> L4
        r3.text(r6.getResourceEntryName(r7));     // Catch: PackageManager.NameNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Slice contains invalid icon", e);
    }

    private static void serializeFileIcon(XmlSerializer r2, IconCompat r3, Context r4) throws IOException {
        r2.attribute(NAMESPACE, ATTR_ICON_TYPE, SliceBroadcastRelay.EXTRA_URI);
        r2.text(r3.getUri().toString());
    }

    private static void serializeIcon(XmlSerializer r1, IconCompat r2, Context r3, SliceUtils.SerializeOptions r4) throws IOException {
        byte[] r5 = convertToBytes(r2, r3, r4);
        r1.attribute(NAMESPACE, ATTR_ICON_TYPE, ICON_TYPE_DEFAULT);
        r1.text(new String(Base64.encode(r5, 2), StandardCharsets.UTF_8));
    }

    public static byte[] convertToBytes(IconCompat r5, Context r6, SliceUtils.SerializeOptions r7) {
        Drawable r8 = r5.loadDrawable(r6);
        int r9 = r8.getIntrinsicWidth();
        int r0 = r8.getIntrinsicHeight();
        if (r9 <= r7.getMaxWidth()) goto L6;
        r0 = (int) (((double) (r7.getMaxWidth() * r0)) / ((double) r9));
        r9 = r7.getMaxWidth();
    L6:
        if (r0 <= r7.getMaxHeight()) goto L8;
        r9 = (int) (((double) (r7.getMaxHeight() * r9)) / ((double) r0));
        r0 = r7.getMaxHeight();
    L8:
        Bitmap r10 = Bitmap.createBitmap(r9, r0, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r10);
        r8.setBounds(0, 0, r1.getWidth(), r1.getHeight());
        r8.draw(r1);
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        r10.compress(r7.getFormat(), r7.getQuality(), r11);
        r10.recycle();
        return r11.toByteArray();
    }

    private static String hintStr(List<String> r1) {
        return TextUtils.join(",", r1);
    }

    private SliceXml() {
    }
}
