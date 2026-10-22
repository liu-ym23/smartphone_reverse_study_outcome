package tmsdkobf;

import androidx.room.RoomDatabase;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedanceos.clearmemory.RunningProcessesView;
import com.obric.netdetect.Modules.HttpProbe.HttpProbeResult;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.utils.AnimTokens;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f373a = false;
    public static List b;

    static {
        b = new ArrayList();
    }

    public static void a() {
        if (f373a == false) goto L5;
        return;
    L5:
        monitor-enter(ng.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f373a == true) goto L12;
        int r4 = 0;
        int[] r2 = {994, 993, 992, 991, 990, 979, 978, 977, 976, 975, 974, 973, 972, 971, 970, 955, 954, 953, 952, 951, 943, 941, 939, 938, 937, 936, 935, 934, 933, 932, 931, 930, 919, 917, 916, 915, 914, 913, 912, 911, 8988, 909, 908, 906, 903, 902, 901, 898, 897, 896, 895, 894, 893, 892, 891, 888, 887, 886, 883, 881, 879, 878, 877, 876, 875, 874, 873, 872, 871, 870, 859, 858, 857, 856, 855, 854, 853, 852, 851, 839, 838, 837, 836, 835, 834, 833, 832, 831, 830, 827, 826, 825, 818, 817, 816, 8982, 813, 812, 799, 798, 797, 796, 795, 794, 793, 792, 791, 790, 779, 778, 777, 776, 775, 774, 773, 772, 771, 770, 769, 768, 766, 763, 762, 760, 759, 758, 757, 756, 755, 754, 753, 752, 751, 750, 746, 745, 744, 743, 739, 738, 737, 736, 735, 734, 731, 730, 728, 724, 722, 719, 718, 717, 716, 715, 714, 713, 712, 711, 710, 701, 692, 691, 668, 663, 662, 660, 635, 634, 633, 632, 631, HttpProbeResult.FAILED_RESPONSE_CODE, 598, 597, 596, 595, 594, 593, 592, 591, RunningProcessesView.ViewHolder.NAME_MAX_WIDTH, 579, 578, 577, 576, 575, 574, 573, 572, 571, 570, 566, 565, 564, 563, 562, 561, 559, 558, 557, 556, 555, 553, 552, 551, AnimTokens.OUI_ANIMATION_DURATION_LONG_3, 546, 543, 539, 538, 537, 536, 535, 534, 533, 532, 531, 530, 527, 523, 519, 518, 517, 516, 515, 514, 513, 512, 511, 510, 483, 482, 479, 478, 477, 476, 475, 474, 473, 472, 471, RunningProcessesView.ViewHolder.NAME_MAX_WIDTH_PERSIST, 469, 468, 467, 464, 459, 458, 457, 456, 455, 454, 453, 452, 451, 8986, 439, 438, 437, 436, 435, 434, 433, 432, 431, 429, 427, 421, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 418, 417, 416, 415, 24, 413, 412, 411, 410, 398, 396, 395, 394, 393, 392, 391, 379, 378, 377, 376, 375, 374, 373, 372, 371, 370, 359, 358, 357, 356, 355, 354, 353, AnimTokens.OUI_ANIMATION_DURATION_MEDIUM_3, 349, 335, 319, 318, 317, 316, 315, 314, 313, 312, 311, 310, 29, 28, 27, 25, 352, 351, 23, 22, 21, 20, 10, 995, 996, 997, 998, RoomDatabase.MAX_BIND_PARAMETER_CNT, 5125, 9712, 235, 237, 7572, 7578, 247, 245, 293, 298, 447, 554, 414, AbstractDialog.HORIZONTAL_MAX_WIDTH, 910};     // Catch: Throwable -> L14
    L9:
        if (r4 >= 346) goto L11;
        b.add("0" + r2[r4]);     // Catch: Throwable -> L14
        r4 = r4 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        f373a = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(ng.class);     // Catch: Throwable -> L14
    }

    public static String a(String r4) {
        String r5 = ma.a(r4);
        if (r5 != null) goto L5;
    L16:
        return null;
    L5:
        if (r5.length() < 7) goto L16;
        a();
        Iterator r1 = b.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) r1.next();
        if (r5.startsWith(r2) == false) goto L9;
        if (r5.length() != (r2.length() + 5)) goto L16;
        return r5.substring(r2.length());
    }
}
