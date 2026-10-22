package kotlin.reflect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KParameter extends KAnnotatedElement {

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final enum Kind extends Enum<Kind> {
        public static final /* synthetic */ Kind[] b = null;

        static {
            b = new Kind[]{new Kind("INSTANCE", 0), new Kind("EXTENSION_RECEIVER", 1), new Kind("VALUE", 2)};
        }

        public static Kind valueOf(String r1) {
            return (Kind) Enum.valueOf(Kind.class, r1);
        }

        public static Kind[] values() {
            return (Kind[]) b.clone();
        }
    }
}
