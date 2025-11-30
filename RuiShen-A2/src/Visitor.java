public class Visitor extends Person {
    // 2个专属实例变量
    private String visitorTicketId;  // 门票ID（入园唯一标识，如 VIS001）
    private String visitDate;        // 访问日期（格式：yyyy-MM-dd，如 2025-12-01）

    // 1. 无参构造器（默认构造器）
    public Visitor() {
        // 隐式调用父类 Person 的无参构造器
    }

    // 2. 带参构造器（初始化父类属性+子类专属属性）
    public Visitor(String name, int age, String idCard, String visitorTicketId, String visitDate) {
        super(name, age, idCard);  // 调用父类带参构造器
        this.visitorTicketId = visitorTicketId;
        this.visitDate = visitDate;
    }

    // 3. Getter 方法：获取游客专属变量
    public String getVisitorTicketId() {
        return visitorTicketId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    // 4. Setter 方法：修改游客专属变量（含简单校验）
    public void setVisitorTicketId(String visitorTicketId) {
        if (visitorTicketId != null && visitorTicketId.startsWith("VIS")) {  // 门票ID以 VIS 开头
            this.visitorTicketId = visitorTicketId;
        } else {
            System.out.println("门票ID格式错误（需以 VIS 开头，如 VIS001）！");
        }
    }

    public void setVisitDate(String visitDate) {
        // 简单校验：日期不为空（可扩展正则校验 yyyy-MM-dd 格式）
        if (visitDate != null && !visitDate.trim().isEmpty()) {
            this.visitDate = visitDate;
        } else {
            System.out.println("访问日期不可为空（格式：yyyy-MM-dd）！");
        }
    }
}