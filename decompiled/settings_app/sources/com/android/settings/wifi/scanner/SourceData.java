package com.android.settings.wifi.scanner;

import android.graphics.Bitmap;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SourceData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/android/settings/wifi/scanner/SourceData;", "", "type", "Lcom/android/settings/wifi/scanner/SourceData$Type;", SlardarSettingsConsts.SETTING_IMAGE, "Landroid/graphics/Bitmap;", "(Lcom/android/settings/wifi/scanner/SourceData$Type;Landroid/graphics/Bitmap;)V", "getImage", "()Landroid/graphics/Bitmap;", "getType", "()Lcom/android/settings/wifi/scanner/SourceData$Type;", "toString", "", "Type", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SourceData {
    private final Bitmap image;
    private final Type type;

    /* JADX INFO: compiled from: SourceData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/settings/wifi/scanner/SourceData$Type;", "", "(Ljava/lang/String;I)V", "FROM_CAMERA", "FROM_GALLERY", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FROM_CAMERA = null;
        public static final Type FROM_GALLERY = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{FROM_CAMERA, FROM_GALLERY};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FROM_CAMERA = new Type("FROM_CAMERA", 0);
            FROM_GALLERY = new Type("FROM_GALLERY", 1);
            Type[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }
    }

    public SourceData(Type r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, SlardarSettingsConsts.SETTING_IMAGE);
        this.type = r2;
        this.image = r3;
    }

    public final Bitmap getImage() {
        return this.image;
    }

    public final Type getType() {
        return this.type;
    }

    public String toString() {
        return "SourceData(type=" + this.type + ')';
    }
}
