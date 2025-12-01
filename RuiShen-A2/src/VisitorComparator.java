import java.util.Comparator;

/**
 * 游客排序比较器
 * 排序规则：先按年龄升序，年龄相同则按门票ID升序
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 先按年龄比较（升序：年龄小的在前）
        if (v1.getAge() != v2.getAge()) {
            return v1.getAge() - v2.getAge(); // 正数：v1 年龄大，放后面；负数：v1 年龄小，放前面
        }
        // 年龄相同，按门票ID比较（字符串字典序升序，如 VIS006 < VIS007）
        return v1.getVisitorTicketId().compareTo(v2.getVisitorTicketId());
    }
}