public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("=== PROG2004 A2 主题公园管理系统 ===");
        // 调用 Part3 演示方法
        AssignmentTwo test = new AssignmentTwo();
        test.partThree();
    }

    // Part3 演示
    public void partThree() {
        System.out.println("\n=== Part3: 等待队列管理测试 ===");
        // 1. 创建操作员
        Employee operator = new Employee(
            "Zhang San",    // 姓名
            30,             // 年龄
            "ID123456",     // 身份证号
            "EMP001",       // 员工ID
            "Roller Coaster"// 负责设施
        );

        // 2. 创建游乐设施
        Ride rollerCoaster = new Ride("Roller Coaster", 20, operator);

        // 3. 添加 5 个游客到队列
        Visitor v1 = new Visitor("Li Si", 25, "ID654321", "VIS001", "2025-12-01");
        Visitor v2 = new Visitor("Wang Wu", 18, "ID112233", "VIS002", "2025-12-01");
        Visitor v3 = new Visitor("Zhao Liu", 35, "ID332211", "VIS003", "2025-12-01");
        Visitor v4 = new Visitor("Chen Qi", 22, "ID445566", "VIS004", "2025-12-01");
        Visitor v5 = new Visitor("Han Ba", 28, "ID665544", "VIS005", "2025-12-01");

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 4. 打印队列
        rollerCoaster.printQueue();

        // 5. 移除 1 个游客
        System.out.println("\n=== 执行移除操作 ===");
        rollerCoaster.removeVisitorFromQueue(null);

        // 6. 再次打印队列（验证移除结果）
        rollerCoaster.printQueue();
    }

    // 其余 part 方法暂时空实现
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}