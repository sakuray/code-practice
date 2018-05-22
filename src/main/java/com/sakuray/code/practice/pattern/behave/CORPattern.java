package com.sakuray.code.practice.pattern.behave;

/**
 * COR(Chain of Responsibility)
 * 职责链模式
 *   对于这将请求一级一级地往上传递直到处理请求为止的设计模式就是职责链模式。
 *   学生申请请假，且必须要有相关人员的签字，三天一下，辅导员签字、三到七天系主任签字，一个星期以上院长签字，更多？校长。
 *   在这个链上，学生是申请者，其余的都是请求处理者。职责链可以将请求的处理者组织成一条链，并且将请求沿着链传递，如果某个请求处理者能够处理请求则处理，否则将该请求交由上级处理。
 *   职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了，这就是职责链的设计动机。
 * 基本结构
 *   Handler: 抽象处理者。定义了一个处理请求的方法。所有的处理者都必须实现该抽象类。 
     ConcreteHandler: 具体处理者。处理它所负责的请求，同时也可以访问它的后继者。如果它能够处理该请求则处理，否则将请求传递到它的后继者。 
     Client: 客户类。
 * 模式适用场景
 *   1、有多个对象可以处理同一个请求，具体哪个对象处理该请求由运行时刻自动确定。
     2、在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
     3、可动态指定一组对象处理请求。
      个人理解：
          一件事情，里面有该事情的具体参数，
          一个处理事情的执行者链，里面都指向了下一个执行者
          执行者接收到事情，根据其参数决定是否自己执行，不是自己执行的就传给下一个执行者
 */
public class CORPattern {
	
	// 请假条
    public class LeaveNode {
        private int number; // 请假天数
        private String person;  // 请假人
        
        public LeaveNode(String person,int number) {
            this.number = number;
            this.person = person;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }
        
    }
    
    // 抽象处理者：Leader
    public abstract class Leader {
        public String name;    // 姓名
        protected Leader successor; // 后继者
        
        public Leader(String name) {
            this.name = name;
        }
        
        public void setSuccessor(Leader successor) {
            this.successor = successor;
        }
        
        public abstract void handleRequest(LeaveNode leaveNode);
    }
    
    // 四个具体处理者
    // 辅导员
    public class Instructor extends Leader {

        public Instructor(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveNode leaveNode) {
            if(leaveNode.getNumber() <= 3) {    //小于3天的假期辅导员审批
                System.out.println("辅导员" + name + "审批" + leaveNode.getPerson() + 
                        "同学的请假条，请假天数为" + leaveNode.getNumber() + "天。");
            } else {    // 否则传递给系主任
                if(this.successor !=null) {
                    this.successor.handleRequest(leaveNode);
                }
            }
        }
        
    }
    
    // 系主任
    public class DepartmentHead extends Leader {

        public DepartmentHead(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveNode leaveNode) {
            if(leaveNode.getNumber() <= 7) {    // 小于7天系主任审批
                System.out.println("系主任" + name + "审批" + leaveNode.getPerson() + 
                        "同学的请假条，请假天数为" + leaveNode.getNumber() + "天。");
            } else {    // 否则传递给院长
                if(this.successor != null) {
                    this.successor.handleRequest(leaveNode);
                }
            }
        }
    }
    
    // 院长
    public class Dead extends Leader {

        public Dead(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveNode leaveNode) {
            if(leaveNode.getNumber() <= 10) {    // 小于10天院长审批
                System.out.println("院长" + name + "审批" + leaveNode.getPerson() + 
                        "同学的请假条，请假天数为" + leaveNode.getNumber() + "天。");
            } else {    // 否则传递给校长
                if(this.successor != null) {
                    this.successor.handleRequest(leaveNode);
                }
            }
        }
    }
    
    // 校长
    public class President extends Leader {

        public President(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveNode leaveNode) {
            if(leaveNode.getNumber() <= 15) {    // 小于10天院长审批
                System.out.println("校长" + name + "审批" + leaveNode.getPerson() + 
                        "同学的请假条，请假天数为" + leaveNode.getNumber() + "天。");
            } else {    // 否则传递给校长
                System.out.println("请假天数超过15天，不批准...");
            }
        }
    }
    
    public static void main(String[] args) {
        Leader instructor = new CORPattern().new Instructor("张三");
        Leader departmentHead = new CORPattern().new DepartmentHead("李四");
        Leader dean = new CORPattern().new Dead("王五");
        Leader president = new CORPattern().new President("赵六");
        
        instructor.setSuccessor(departmentHead);
        departmentHead.setSuccessor(dean);
        dean.setSuccessor(president);
        
        // 请假3天的请假条
        LeaveNode leaveNode1 = new CORPattern().new LeaveNode("路人甲", 3);
        instructor.handleRequest(leaveNode1);
        
        // 请假5天的请假条
        LeaveNode leaveNoden = new CORPattern().new LeaveNode("XXX", 5);
        instructor.handleRequest(leaveNoden);
        
        // 请假9天的请假条
        LeaveNode leaveNode2 = new CORPattern().new LeaveNode("炮灰乙", 9);
        instructor.handleRequest(leaveNode2);
        
        // 请假15天的请假条
        LeaveNode leaveNode3 = new CORPattern().new LeaveNode("群众丙", 15);
        instructor.handleRequest(leaveNode3);
        
        // 请假20天的请假条
        LeaveNode leaveNode4 = new CORPattern().new LeaveNode("龙套丁", 20);
        instructor.handleRequest(leaveNode4);
    }

}
