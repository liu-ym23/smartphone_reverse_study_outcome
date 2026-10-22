package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    /* JADX INFO: renamed from: com.bumptech.glide.load.ImageHeaderParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType = null;

        static {
            int[] r0 = new int[ImageType.values().length];
            $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType = r0;
            r0[ImageType.WEBP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[ImageType.WEBP_A.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[ImageType.ANIMATED_WEBP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType ANIMATED_AVIF = null;
        public static final ImageType ANIMATED_WEBP = null;
        public static final ImageType AVIF = null;
        public static final ImageType GIF = null;
        public static final ImageType JPEG = null;
        public static final ImageType PNG = null;
        public static final ImageType PNG_A = null;
        public static final ImageType RAW = null;
        public static final ImageType UNKNOWN = null;
        public static final ImageType WEBP = null;
        public static final ImageType WEBP_A = null;
        private final boolean hasAlpha;

        private static /* synthetic */ ImageType[] $values() {
            return new ImageType[]{GIF, JPEG, RAW, PNG_A, PNG, WEBP_A, WEBP, ANIMATED_WEBP, AVIF, ANIMATED_AVIF, UNKNOWN};
        }

        public static ImageType valueOf(String r1) {
            return (ImageType) Enum.valueOf(ImageType.class, r1);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        static {
            GIF = new ImageType("GIF", 0, true);
            JPEG = new ImageType("JPEG", 1, false);
            RAW = new ImageType("RAW", 2, false);
            PNG_A = new ImageType("PNG_A", 3, true);
            PNG = new ImageType("PNG", 4, false);
            WEBP_A = new ImageType("WEBP_A", 5, true);
            WEBP = new ImageType("WEBP", 6, false);
            ANIMATED_WEBP = new ImageType("ANIMATED_WEBP", 7, true);
            AVIF = new ImageType("AVIF", 8, true);
            ANIMATED_AVIF = new ImageType("ANIMATED_AVIF", 9, true);
            UNKNOWN = new ImageType(NetworkStackConstant.UNKNOWN_TYPE, 10, false);
            $VALUES = $values();
        }

        private ImageType(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.hasAlpha = r3;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean isWebp() {
            int r2 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[ordinal()];
            if (r2 != 1) goto L5;
        L10:
            return true;
        L5:
            if (r2 == 2) goto L10;
            if (r2 == 3) goto L10;
            return false;
        }
    }

    int getOrientation(InputStream r1, ArrayPool r2) throws IOException;

    int getOrientation(ByteBuffer r1, ArrayPool r2) throws IOException;

    ImageType getType(InputStream r1) throws IOException;

    ImageType getType(ByteBuffer r1) throws IOException;
}
