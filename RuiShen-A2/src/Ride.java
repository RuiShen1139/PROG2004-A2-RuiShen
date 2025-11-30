import java.util.Queue;
import java.util.LinkedList;

public class Ride implements RideInterface{
    // 3个实例变量
    private String rideName;      // 设施名称（如 "Roller Coaster"、"Ferris Wheel"）
    private int maxCapacity;      // 最大容量（单周期最多可载人数，如 20）
    private Employee rideOperator;// 操作员（Employee 类型，控制设施是否可运行）

    private Queue<Visitor> waitingLine = new LinkedList<>();

    // 1. 无参构造器（默认构造器）
    public Ride() {}

    // 2. 带参构造器（初始化所有实例变量）
    public Ride(String rideName, int maxCapacity, Employee rideOperator) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.rideOperator = rideOperator;
    }

    public Queue<Visitor> getWaitingLine(){ return waitingLine; }

    // 3. Getter 方法：获取设施属性
    public String getRideName() {
        return rideName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    // 4. Setter 方法：修改设施属性（含简单校验）
    public void setRideName(String rideName) {
        if (rideName != null && !rideName.trim().isEmpty()) {
            this.rideName = rideName;
        } else {
            System.out.println("游乐设施名称不可为空！");
        }
    }

    public void setMaxCapacity(int maxCapacity) {
        // 简单校验：最大容量至少 1 人（不能为 0 或负数）
        if (maxCapacity >= 1) {
            this.maxCapacity = maxCapacity;
        } else {
            System.out.println("最大容量至少为 1 人！");
        }
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
        // 可扩展：设置操作员时，自动关联设施（如 operator.setManagedRide(this.rideName)）
        if (rideOperator != null) {
            rideOperator.setManagedRide(this.rideName);
        }
    }
//添加游客到队列
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor); // Queue 安全添加方法
            System.out.println("成功添加游客【" + visitor.getName() + "】到【" + rideName + "】等待队列");
        } else {
            System.out.println("添加失败：游客信息为空");
        }
    }

//移除队首游客
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (waitingLine.isEmpty()) {
            System.out.println("移除失败：【" + rideName + "】等待队列为空");
            return;
        }
        Visitor removed = waitingLine.poll(); // 移除并返回队首
        System.out.println("从【" + rideName + "】队列移除游客【" + removed.getName() + "】");
    }

//打印队列中所有游客
    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("【" + rideName + "】等待队列为空");
            return;
        }
        System.out.println("\n【" + rideName + "】等待队列（共" + waitingLine.size() + "人）：");
        int index = 1;
        for (Visitor v : waitingLine) {
            System.out.println(index + ". 姓名：" + v.getName() + " | 门票ID：" + v.getVisitorTicketId() + " | 年龄：" + v.getAge());
            index++;
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addVisitorToHistory'");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkVisitorFromHistory'");
    }

    @Override
    public int numberOfVisitors() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numberOfVisitors'");
    }

    @Override
    public void printRideHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printRideHistory'");
    }

    @Override
    public void runOneCycle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runOneCycle'");
    }
}