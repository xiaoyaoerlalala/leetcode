package com.houyao;

public class Topic2 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);
    }

    /**
     * 就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1l1l1 和 l2l2l2 的表头开始相加。由于每位数字都应当处于 0…90 \ldots 90…9 的范围内，我们计算两个数字的和时可能会出现 “溢出”。例如，5+7=125 + 7 = 125+7=12。在这种情况下，我们会将当前位的数值设置为 222，并将进位 carry=1carry = 1carry=1 带入下一次迭代。进位 carrycarrycarry 必定是 000 或 111，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9+9+1=199 + 9 + 1 = 199+9+1=19。
     *
     * 伪代码如下：
     *
     *     将当前结点初始化为返回列表的哑结点。
     *     将进位 carrycarrycarry 初始化为 000。
     *     将 ppp 和 qqq 分别初始化为列表 l1l1l1 和 l2l2l2 的头部。
     *     遍历列表 l1l1l1 和 l2l2l2 直至到达它们的尾端。
     *         将 xxx 设为结点 ppp 的值。如果 ppp 已经到达 l1l1l1 的末尾，则将其值设置为 000。
     *         将 yyy 设为结点 qqq 的值。如果 qqq 已经到达 l2l2l2 的末尾，则将其值设置为 000。
     *         设定 sum=x+y+carrysum = x + y + carrysum=x+y+carry。
     *         更新进位的值，carry=sum/10carry = sum / 10carry=sum/10。
     *         创建一个数值为 (sum mod 10)(sum \bmod 10)(summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     *         同时，将 ppp 和 qqq 前进到下一个结点。
     *     检查 carry=1carry = 1carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 111 的新结点。
     *     返回哑结点的下一个结点。
     *
     * 请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
     *
     * 请特别注意以下情况：
     * 测试用例 	说明
     * l1=[0,1]，l2=[0,1,2] 	当一个列表比另一个列表长时
     * l1=[]，l2=[0,1] 	当一个列表为空时，即出现空列表
     * l1=[9,9]，l2=[1] 	求和运算最后可能出现额外的进位，这一点很容易被遗忘
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
