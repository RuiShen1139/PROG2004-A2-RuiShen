public interface RideInterface {
    // ====================等待队列操作====================
    /**
     * 添加游客到等待队列
     * @param visitor 待添加的游客对象（Visitor 类型）
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * 从等待队列移除游客（按 FIFO 规则，移除队首游客）
     * @param visitor （可选）待移除的游客对象，本作业按 FIFO 移除，参数可忽略
     */
    void removeVisitorFromQueue(Visitor visitor);

    /**
     * 打印等待队列中所有游客的详细信息（姓名、门票ID等）
     */
    void printQueue();

    // ====================骑行历史操作====================
    /**
     * 将已完成骑行的游客添加到骑行历史记录
     * @param visitor 已骑行的游客对象
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * 检查指定游客是否在骑行历史记录中
     * @param visitor 待检查的游客对象
     * @return true：在历史中；false：不在历史中
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * 获取骑行历史记录中的游客总数
     * @return 游客总数（int 类型）
     */
    int numberOfVisitors();

    /**
     * 打印骑行历史记录中所有游客的详细信息（必须用 Iterator，Part4 要求）
     */
    void printRideHistory();

    // ====================骑行周期运行====================
    /**
     * 运行游乐设施的一个周期
     * 逻辑：检查是否有操作员→检查是否有等待游客→按最大载客量转移游客到历史记录→更新运行次数
     */
    void runOneCycle();
}