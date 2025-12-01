public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("=== PROG2004 A2 主题公园管理系统 ===");
        // 调用 Part3 演示方法
        AssignmentTwo test = new AssignmentTwo();
        test.partFive();
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

    // Part4A 演示：骑行历史管理（添加、检查、统计、打印）
    public void partFourA() {
        System.out.println("\n=== Part4A: 骑行历史管理测试 ===");
        // 1. 创建操作员和游乐设施
        Employee operator = new Employee(
            "Li Ming",    // 姓名
            28,           // 年龄
            "440101199701011234",  // 身份证号
            "EMP002",     // 员工ID
            "Thunderstorm"// 负责设施
        );
        Ride thunderstorm = new Ride("Thunderstorm", 15, operator);

        // 2. 创建 5 个游客（作业要求：至少5个）
        Visitor v1 = new Visitor("Wu Jiu", 21, "440101200301015678", "VIS006", "2025-12-01");
        Visitor v2 = new Visitor("Zheng Shi", 32, "440101199301018901", "VIS007", "2025-12-01");
        Visitor v3 = new Visitor("Xu ShiYi", 24, "440101200101012345", "VIS008", "2025-12-01");
        Visitor v4 = new Visitor("He ShiEr", 27, "440101199801016789", "VIS009", "2025-12-01");
        Visitor v5 = new Visitor("Gao ShiSan", 19, "440101200601013456", "VIS010", "2025-12-01");

        // 3. 添加游客到历史记录
        System.out.println("\n=== 步骤1：添加 5 个游客到历史 ===");
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);

        // 4. 检查游客是否在历史（存在的游客 v1 + 不存在的游客 vTest）
        System.out.println("\n=== 步骤2：检查游客是否在历史 ===");
        thunderstorm.checkVisitorFromHistory(v1); // 存在
        Visitor vTest = new Visitor("Test", 0, "123456", "VIS999", "2025-12-01");
        thunderstorm.checkVisitorFromHistory(vTest); // 不存在

        // 5. 统计历史游客数量
        System.out.println("\n=== 步骤3：统计历史游客数量 ===");
        thunderstorm.numberOfVisitors();

        // 6. 打印历史记录（用 Iterator 遍历）
        System.out.println("\n=== 步骤4：打印骑行历史详情 ===");
        thunderstorm.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n===Part4B:骑行历史排序测试===");
        //创建操作员，游乐设备，比较器
        Employee operator = new Employee("Wang Xiao", 26, "440101199901014567", "EMP003", "Ferris Wheel");
        Ride ferrisWheel = new Ride("Ferris Wheel", 10, operator);
        VisitorComparator comparator = new VisitorComparator();

        //添加5个无序游客
        System.out.println("\n=== 步骤1：添加 5 个无序游客到历史 ===");
        Visitor v1 = new Visitor("A", 25, "ID1", "VIS015", "2025-12-01"); // 年龄25，门票ID015
        Visitor v2 = new Visitor("B", 20, "ID2", "VIS012", "2025-12-01"); // 年龄20，门票ID012
        Visitor v3 = new Visitor("C", 25, "ID3", "VIS013", "2025-12-01"); // 年龄25，门票ID013（比v1小）
        Visitor v4 = new Visitor("D", 30, "ID4", "VIS014", "2025-12-01"); // 年龄30，门票ID014
        Visitor v5 = new Visitor("E", 20, "ID5", "VIS011", "2025-12-01"); // 年龄20，门票ID011（最小）
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        //打印排序前历史
        System.out.println("\n=== 步骤2：排序前的骑行历史 ===");
        ferrisWheel.printRideHistory();
        //执行排序
        System.out.println("\n=== 步骤3：执行排序（年龄升序→门票ID升序）===");
        ferrisWheel.sortRideHistory(comparator);

        //打印排序后的历史（验证结果）
        System.out.println("\n=== 步骤4：排序后的骑行历史 ===");
        ferrisWheel.printRideHistory();
    }

    // Part5 演示：运行骑行周期（队列→历史转移）
    public void partFive() {
        System.out.println("\n=== Part5: 骑行周期运行测试 ===");
        // 1. 创建操作员（负责 Water Slide）
        Employee operator = new Employee("Zhao Da", 32, "440101199301017890", "EMP004", "Water Slide");

        // 2. 创建游乐设施（单周期最大载客 3 人，Part5 核心配置）
        Ride waterSlide = new Ride("Water Slide", 25, operator, 3);

        // 3. 添加 10 个游客到等待队列（作业要求：至少10个）
        System.out.println("\n=== 步骤1：添加 10 个游客到等待队列 ===");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor(
                "Visitor" + i,          // 姓名
                18 + i,                 // 年龄（19-28岁）
                "ID" + (1000 + i),       // 身份证号
                "VIS" + (100 + i),       // 门票ID
                "2025-12-01"             // 访问日期
            );
            waterSlide.addVisitorToQueue(visitor);
        }

        // 4. 打印运行前的队列
        System.out.println("\n=== 步骤2：运行前的等待队列 ===");
        waterSlide.printQueue();

        // 5. 运行一个周期
        System.out.println("\n=== 步骤3：运行一个周期（单周期最大载客 3 人）===");
        waterSlide.runOneCycle();

        // 6. 打印运行后的队列和历史
        System.out.println("\n=== 步骤4：运行后的等待队列（剩余 7 人）===");
        waterSlide.printQueue();
        System.out.println("\n=== 步骤5：运行后的骑行历史（新增 3 人）===");
        waterSlide.printRideHistory();
        System.out.println("\n=== 步骤6：当前总运行周期数 ===");
        System.out.println("【" + waterSlide.getRideName() + "】已运行 " + waterSlide.getNumOfCycles() + " 个周期");
    }

    // 其余 part 方法暂时空实现
    public void partSix() {}
    public void partSeven() {}
}