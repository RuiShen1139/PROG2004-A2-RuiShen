
public abstract class Person {
    // 3个实例变量
    private String name;    // 姓名（通用）
    private int age;        // 年龄（通用）
    private String idCard;  // 身份证号（通用，唯一标识）

    // 1. 无参构造器（默认构造器，必须提供）
    public Person() {}

    // 2. 带参构造器（初始化所有实例变量，方便创建对象）
    public Person(String name, int age, String idCard) {
        this.name = name;   // this 指向当前对象的变量
        this.age = age;
        this.idCard = idCard;
    }

    // 3. Getter 方法：获取私有变量的值（外部无法直接访问 private 变量）
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIdCard() {
        return idCard;
    }

    // 4. Setter 方法：修改私有变量的值（控制变量修改逻辑，如年龄不能为负）
    public void setName(String name) {
        // 简单校验：姓名不为空
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("姓名不可为空！");
        }
    }

    public void setAge(int age) {
        // 简单校验：年龄在 0-150 之间
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("年龄必须在 0-150 之间！");
        }
    }

    public void setIdCard(String idCard) {
        // 简单校验：身份证号不为空（可扩展正则校验格式）
        if (idCard != null && !idCard.trim().isEmpty()) {
            this.idCard = idCard;
        } else {
            System.out.println("身份证号不可为空！");
        }
    }
}