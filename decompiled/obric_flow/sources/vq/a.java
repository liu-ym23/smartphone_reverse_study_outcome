package vq;

import com.obric.oui.avatar.OAvatar;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22649a = null;

    static {
        int[] r5 = new int[OAvatar.AvatarSize.values().length];
        r5[OAvatar.AvatarSize.DP_24.ordinal()] = 1;
        r5[OAvatar.AvatarSize.DP_32.ordinal()] = 2;
        r5[OAvatar.AvatarSize.DP_40.ordinal()] = 3;
        r5[OAvatar.AvatarSize.DP_48.ordinal()] = 4;
        r5[OAvatar.AvatarSize.DP_56.ordinal()] = 5;
        r5[OAvatar.AvatarSize.DP_64.ordinal()] = 6;
        r5[OAvatar.AvatarSize.DP_72.ordinal()] = 7;
        f22649a = r5;
        int[] r10 = new int[OAvatar.IconType.values().length];
        r10[OAvatar.IconType.LOGO.ordinal()] = 1;
        r10[OAvatar.IconType.ONLINE.ordinal()] = 2;
    }
}
