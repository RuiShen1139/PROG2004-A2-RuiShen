public class Employee extends Person {
    // 2个专属实例变量
    private String employeeId;   // 员工ID（公园内唯一标识，如 EMP001）
    private String managedRide;  // 负责的游乐设施（如 "Roller Coaster"）

    // 1. 无参构造器（默认构造器）
    public Employee() {
        // 隐式调用父类 Person 的无参构造器（super()）
    }

    // 2. 带参构造器（初始化父类属性+子类专属属性）
    public Employee(String name, int age, String idCard, String employeeId, String managedRide) {
        super(name, age, idCard);  // 调用父类 Person 的带参构造器，初始化通用属性
        this.employeeId = employeeId;  // 初始化子类专属属性
        this.managedRide = managedRide;
    }

    // 3. Getter 方法：获取员工专属变量
    public String getEmployeeId() {
        return employeeId;
    }

    public String getManagedRide() {
        return managedRide;
    }

    // 4. Setter 方法：修改员工专属变量（含简单校验）
    public void setEmployeeId(String employeeId) {
        if (employeeId != null && employeeId.startsWith("EMP")) {  // 员工ID以 EMP 开头
            this.employeeId = employeeId;
        } else {
            System.out.println("员工ID格式错误（需以 EMP 开头，如 EMP001）！");
        }
    }

    public void setManagedRide(String managedRide) {
        if (managedRide != null && !managedRide.trim().isEmpty()) {
            this.managedRide = managedRide;
        } else {
            System.out.println("负责的游乐设施不可为空！");
        }
    }
}