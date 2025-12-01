import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;

public class Ride implements RideInterface {
    // 原有变量（保留）：设施名称、最大容量、操作员、等待队列
    private String rideName;
    private int maxCapacity;
    private Employee rideOperator;
    private Queue<Visitor> waitingLine = new LinkedList<>();

    // 用 LinkedList 存储骑行历史
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    // 原有构造器、getter/setter
    public Ride() {}

    public Ride(String rideName, int maxCapacity, Employee rideOperator) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.rideOperator = rideOperator;
    }

    // rideHistory 的 getter（用于演示时查看历史记录）
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    //排序骑行历史
    public void sortRideHistory(VisitorComparator comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println("排序失败：【" + rideName + "】骑行历史为空");
            return;
        }
        if (comparator == null) {
            System.out.println("排序失败：比较器（Comparator）为空");
            return;
        }
    //调用 Collections.sort ，传入历史记录列表和比较器
    Collections.sort(rideHistory,comparator);
    System.out.println("【" + rideName + "】骑行历史已按「年龄升序→门票ID升序」排序完成");
    }

    // ==================== 1. 实现 addVisitorToHistory（添加游客到历史）====================
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor); // LinkedList 的 add 方法添加到末尾
            System.out.println("游客【" + visitor.getName() + "】（门票ID：" + visitor.getVisitorTicketId() + "）已添加到【" + rideName + "】骑行历史");
        } else {
            System.out.println("添加失败：游客信息为空");
        }
    }

    // ==================== 2. 实现 checkVisitorFromHistory（检查游客是否在历史）====================
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("检查失败：游客信息为空");
            return false;
        }
        // 用 Iterator 遍历历史记录（避免 ConcurrentModificationException）
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor historyVisitor = iterator.next();
            // 按“姓名+门票ID”双重校验（避免同名游客误判）
            if (historyVisitor.getName().equals(visitor.getName()) 
                && historyVisitor.getVisitorTicketId().equals(visitor.getVisitorTicketId())) {
                System.out.println("游客【" + visitor.getName() + "】（门票ID：" + visitor.getVisitorTicketId() + "）在【" + rideName + "】骑行历史中");
                return true;
            }
        }
        System.out.println("游客【" + visitor.getName() + "】（门票ID：" + visitor.getVisitorTicketId() + "）不在【" + rideName + "】骑行历史中");
        return false;
    }

    // ==================== 3. 实现 numberOfVisitors（统计历史游客数量）====================
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("【" + rideName + "】骑行历史共有 " + count + " 名游客");
        return count;
    }

    // ==================== 4. 实现 printRideHistory（打印历史记录，必须用 Iterator）====================
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("【" + rideName + "】骑行历史为空");
            return;
        }
        System.out.println("\n【" + rideName + "】骑行历史详情（共" + rideHistory.size() + "人）：");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". 姓名：" + visitor.getName() 
                + " | 年龄：" + visitor.getAge() 
                + " | 门票ID：" + visitor.getVisitorTicketId() 
                + " | 访问日期：" + visitor.getVisitDate());
            index++;
        }
    }

    // 其他方法（队列操作、运行周期）暂时保留之前的空实现，后续完善
    @Override
    public void addVisitorToQueue(Visitor visitor) { /* 阶段4已实现 */ }
    @Override
    public void removeVisitorFromQueue(Visitor visitor) { /* 阶段4已实现 */ }
    @Override
    public void printQueue() { /* 阶段4已实现 */ }
    @Override
    public void runOneCycle() { /* 后续阶段实现 */ }
}