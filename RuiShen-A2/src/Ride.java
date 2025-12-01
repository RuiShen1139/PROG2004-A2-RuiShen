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
    public Ride(String rideName, int maxCapacity, Employee rideOperator) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.rideOperator = rideOperator;
    }

    // 获取设施名称（getter 方法，Part5 调用需此方法）
    public String getRideName() {
        return rideName;
    }
    
    // rideHistory 的 getter
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

    // 周期相关变量（Part5 核心）
    private int maxRider;     // 单周期最大载客量（作业要求：至少1人，不同设施可配置）
    private int numOfCycles = 0; // 运行次数（默认0，每运行一次+1）

    // 带参构造器（添加 maxRider 参数，初始化单周期载客量）
    public Ride(String rideName, int maxCapacity, Employee rideOperator, int maxRider) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.rideOperator = rideOperator;
        this.maxRider = maxRider; // 初始化单周期载客量
    }

    // maxRider 和 numOfCycles 的 getter/setter
    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) { // 校验：单周期至少1人
            this.maxRider = maxRider;
        } else {
            System.out.println("❌ 单周期载客量必须至少为1人");
        }
    }

    public int getNumOfCycles() {
        return numOfCycles;
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
    // ==================== 实现 runOneCycle====================
    @Override
    public void runOneCycle() {
        System.out.println("\n=== 【" + rideName + "】准备运行一个周期 ===");
        // 1. 校验：是否有操作员（作业要求：无操作员不能运行）
        if (rideOperator == null) {
            System.out.println("❌ 运行失败：【" + rideName + "】无操作员，无法启动");
            return;
        }
        // 2. 校验：等待队列是否为空（无游客不能运行）
        if (waitingLine.isEmpty()) {
            System.out.println("❌ 运行失败：【" + rideName + "】等待队列为空，无游客可载");
            return;
        }
        // 3. 按 maxRider 转移游客：从队列移除→添加到历史
        int transferredCount = 0; // 本次转移的游客数
        while (!waitingLine.isEmpty() && transferredCount < maxRider) {
            Visitor visitor = waitingLine.poll(); // 移除队首游客（FIFO）
            addVisitorToHistory(visitor); // 添加到历史（复用 Part4A 的方法）
            transferredCount++;
        }
        // 4. 更新运行次数
        numOfCycles++;
        // 5. 输出运行结果
        System.out.println("✅ 【" + rideName + "】第 " + numOfCycles + " 个周期运行完成");
        System.out.println("📊 本次周期转移 " + transferredCount + " 名游客（单周期最大载客：" + maxRider + "）");
        System.out.println("📋 等待队列剩余游客数：" + waitingLine.size());
        System.out.println("📋 骑行历史总游客数：" + rideHistory.size());
    }

    // 其他方法（队列操作、运行周期）暂时保留之前的空实现，后续完善
    @Override
    public void addVisitorToQueue(Visitor visitor) { /* 阶段4已实现 */ }
    @Override
    public void removeVisitorFromQueue(Visitor visitor) { /* 阶段4已实现 */ }
    @Override
    public void printQueue() { /* 阶段4已实现 */ }
}