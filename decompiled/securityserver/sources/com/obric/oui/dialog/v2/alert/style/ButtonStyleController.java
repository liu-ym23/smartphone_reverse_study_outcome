package com.obric.oui.dialog.v2.alert.style;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class ButtonStyleController implements StyleController {

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface ButtonStyle {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @Deprecated
    public static final enum TextColorType extends Enum<TextColorType> {
        public static final /* synthetic */ TextColorType[] b = null;

        static {
            b = new TextColorType[]{new TextColorType("TextReverse", 0), new TextColorType("TextReverse2", 1), new TextColorType("Negative", 2)};
        }

        public static TextColorType valueOf(String r1) {
            return (TextColorType) Enum.valueOf(TextColorType.class, r1);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) b.clone();
        }
    }
}
