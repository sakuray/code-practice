package com.sakuray.code.practice.offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class _25_复杂链表的复制 {


    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode head = pHead;
        while(pHead != null) {
            RandomListNode clone = new RandomListNode(pHead.label);
            clone.next = pHead.next;
            pHead.next = clone;
            pHead = clone.next;
        }
        pHead = head;
        while(pHead != null) {
            if(pHead.random != null) {
                pHead.next.random = pHead.random.next;
            }
            pHead = pHead.next.next;
        }
        pHead = head;
        RandomListNode clone;
        RandomListNode begin = head.next;
        while(pHead != null) {
            clone = pHead.next;
            pHead.next = clone.next;
            pHead = pHead.next;
            if(pHead != null) {
                clone.next = pHead.next;
            }
        }
        return begin;
    }


    public RandomListNode Clone_S(RandomListNode pHead) {
        RandomListNode p=pHead;
        RandomListNode t=pHead;
        while(p!=null){
            RandomListNode q=new RandomListNode(p.label);
            q.next=p.next;
            p.next=q;
            p=q.next;
        }
        while(t!=null){
            RandomListNode q=t.next;
            if(t.random!=null)
                q.random=t.random.next;
            t=q.next;

        }
        RandomListNode s=new RandomListNode(0);
        RandomListNode s1=s;
        while(pHead!=null){
            RandomListNode  q=pHead.next;
            pHead.next=q.next;
            q.next=s.next;
            s.next=q;
            s=s.next;
            pHead=pHead.next;


        }
        return s1.next;

    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
