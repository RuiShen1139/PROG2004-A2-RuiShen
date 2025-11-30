public class Ride {
    // 3个实例变量
    private String rideName;      // 设施名称（如 "Roller Coaster"、"Ferris Wheel"）
    private int maxCapacity;      // 最大容量（单周期最多可载人数，如 20）
    private Employee rideOperator;// 操作员（Employee 类型，控制设施是否可运行）

    // 1. 无参构造器（默认构造器）
    public Ride() {}

    // 2. 带参构造器（初始化所有实例变量）
    public Ride(String rideName, int maxCapacity, Employee rideOperator) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.rideOperator = rideOperator;
    }

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
}