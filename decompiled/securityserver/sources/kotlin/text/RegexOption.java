package kotlin.text;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum RegexOption extends Enum<RegexOption> implements FlagEnum {
    public static final /* synthetic */ RegexOption[] c = null;
    public final int b;

    static {
        c = new RegexOption[]{new RegexOption("IGNORE_CASE", 0, 2), new RegexOption("MULTILINE", 1, 8), new RegexOption("LITERAL", 2, 16), new RegexOption("UNIX_LINES", 3, 1), new RegexOption("COMMENTS", 4, 4), new RegexOption("DOT_MATCHES_ALL", 5, 32), new RegexOption("CANON_EQ", 6, 128)};
    }

    public RegexOption(String r1, int r2, int r3) {
        super(r1, r2);
        this.b = r3;
    }

    public static RegexOption valueOf(String r1) {
        return (RegexOption) Enum.valueOf(RegexOption.class, r1);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) c.clone();
    }

    @Override // kotlin.text.FlagEnum
    public final int getValue() {
        return this.b;
    }
}
