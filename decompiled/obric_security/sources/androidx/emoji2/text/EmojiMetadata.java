package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = null;
    private volatile int mHasGlyph;
    private final int mIndex;
    private final MetadataRepo mMetadataRepo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    static {
        sMetadataItem = new ThreadLocal();
    }

    EmojiMetadata(MetadataRepo r2, int r3) {
        this.mHasGlyph = 0;
        this.mMetadataRepo = r2;
        this.mIndex = r3;
    }

    public void draw(Canvas r10, float r11, float r12, Paint r13) {
        Typeface r0 = this.mMetadataRepo.getTypeface();
        Typeface r1 = r13.getTypeface();
        r13.setTypeface(r0);
        int r4 = this.mIndex * 2;
        r10.drawText(this.mMetadataRepo.getEmojiCharArray(), r4, 2, r11, r12, r13);
        r13.setTypeface(r1);
    }

    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> r0 = sMetadataItem;
        MetadataItem r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = new MetadataItem();
        r0.set(r1);
    L5:
        this.mMetadataRepo.getMetadataList().list(r1, this.mIndex);
        return r1;
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getWidth() {
        return getMetadataItem().width();
    }

    public short getHeight() {
        return getMetadataItem().height();
    }

    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    public int getHasGlyph() {
        return this.mHasGlyph;
    }

    public void resetHasGlyphCache() {
        this.mHasGlyph = 0;
    }

    public void setHasGlyph(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 2;
    L5:
        this.mHasGlyph = r2;
        return;
    L4:
        r2 = 1;
        goto L5
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    public int getCodepointAt(int r1) {
        return getMetadataItem().codepoints(r1);
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append(", id:");
        r0.append(Integer.toHexString(getId()));
        r0.append(", codepoints:");
        int r1 = getCodepointsLength();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(Integer.toHexString(getCodepointAt(r2)));
        r0.append(" ");
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
