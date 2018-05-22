package com.sakuray.code.practice.pattern.behave;
/**
 * 命令模式
 *   命令模式将请求封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。命令模式支持可撤销的操作。
 *   命令模式可以对发送者额接受者完全解耦，发送者也接收者之间并没有直接的联系，发送者只需要知道如何发送请求，
 *   不需要关心请求是如何完成了。这就是命令模式，命令模式将方法调用给封装起来了。
 *   命令模式的本质就在于将命令进行封装，将发出命令的责任和执行命令的责任分开，是的发送者只需要知道如何发送命令即可，不需要命令是如何实现的，甚至命令执行是否成功都不需要理会。
 *   同时命令模式使得请求也变成了一个对象，它像其他对象一样可以被存储和传递。
 * 基本结构：
 *   Command: 抽象命令类
     ConcreteCommand: 具体命令类
     Invoker: 调用者
     Receiver: 接收者
     Client:客户类
 * 模式使用场景：
 *   1.系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
     2.系统需要在不同的时间指定请求、将请求排队和执行请求。
     3.系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作。
     4.系统需要将一组操作组合在一起，即支持宏命令。
      个人理解：
          一个抽象命令约束，所有具体命令都受其约束
          一个命令控制器，里面有许多命令，选择哪个方法，就执行那个具体命令的约束方法，
          命令可以关联具体的执行者，影响执行者的方法
 *
 */
//打个比方，电视遥控器，我们只需要知道按那个按钮能够打开电视、关闭电视和换台即可，
//并不需要知道是怎么开电视、关电视和换台的。对于这种情况，我们可以采用命令模式来进行设计。
public class CommandPattern {
	
	// Command命令接口，为所有的命令声明一个接口。所有的命令都应该实现它
    public interface Command {
        public void execute(int i); // 带撤销功能参数
    }
    
    // 电视机类:Television
    public class Television {
        public void open() {
            System.out.println("打开电视机......");
        }
        
        public void close() {
            System.out.println("关闭电视机......");
        }
        
        public void changeChannel(int i) {
            System.out.println("切换电视频道......现在频道是："+i);
        }
    }
    
    // 遥控器类:controller
    public class Controller {
        private Command openTVCommand;
        private Command closeTVCommand;
        private Command changeChannelCommand;
        
        public int nowChannel = 0; // 当前频道
        public int priorChannel;    // 前一个频道，用于执行返回操作
        
        public Controller(Command openTVCommand, Command closeTVCommand,
                Command changeChannelCommand) {
            this.openTVCommand = openTVCommand;
            this.closeTVCommand = closeTVCommand;
            this.changeChannelCommand = changeChannelCommand;
        }
        
        public void open() {
            openTVCommand.execute(0);
        }
        
        public void close() {
            closeTVCommand.execute(0);
        }
        
        // 换频道：只在当前频道递增
        public void change() {
            priorChannel = nowChannel;
            nowChannel++;
            changeChannelCommand.execute(nowChannel);
        }
        
        // 频道返回
        public void ChannelUndo() {
            changeChannelCommand.execute(priorChannel);
            int tempChannel;
            tempChannel = priorChannel;
            priorChannel = nowChannel;
            nowChannel = tempChannel;
        }
    }
    
    // 遥控器的三个按钮指令
    public class OpenTvCommand implements Command {
        
        private Television tv;
        
        public OpenTvCommand() {
            tv = new Television();
        }
        
        @Override
        public void execute(int i) {
            tv.open();
        }
        
    }
    
    public class ChangeChannelCommand implements Command {
        
        private Television tv;
        
        public ChangeChannelCommand() {
            tv = new Television();
        }
        
        @Override
        public void execute(int i) {
            tv.changeChannel(i);
        }
    }
    
    public class CloseTvCommand implements Command {
        
        private Television tv;
        
        public CloseTvCommand() {
            tv = new Television();
        }
        
        @Override
        public void execute(int i) {
            tv.close();
        }
        
    }
    
    public static void main(String[] args) {
        Command openCommand,closeCommand,changeCommand;
        openCommand = new CommandPattern().new OpenTvCommand();
        closeCommand = new CommandPattern().new CloseTvCommand();
        changeCommand = new CommandPattern().new ChangeChannelCommand();
        Controller control = new CommandPattern().new Controller(openCommand, closeCommand, changeCommand);
        control.open();
        control.change();
        control.change();
        control.ChannelUndo();
        control.ChannelUndo();
        control.ChannelUndo();
        control.close();
    }
}
