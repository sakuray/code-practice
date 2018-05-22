package com.sakuray.code.practice.pattern.behave;

/**
 * 备忘录模式：
 *   备忘录模式是一种给我们的软件提供后悔药的机制，通过它可以使系统恢复到某一特定的历史状态。 
 *   所谓备忘录模式就是在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态。
          备忘录模式将要保存的细节给封装在备忘录中，就是那天要改变保存的细节也不会影响到客户端。
 * 模式结构：
 * 	 Originator: 原发器。负责创建一个备忘录，用以记录当前对象的内部状态，通过也可以使用它来利用备忘录恢复内部状态。
 * 				  同时原发器还可以根据需要决定Memento存储Originator的那些内部状态。
     Memento: 备忘录。用于存储Originator的内部状态，并且可以防止Originator以外的对象访问Memento。在备忘录Memento中有两个接口，其中Caretaker只能看到备忘录中的窄接口，它只能将备忘录传递给其他对象。
     		  Originator可以看到宽接口，允许它访问返回到先前状态的所有数据。
     Caretaker: 负责人。负责保存好备忘录，不能对备忘录的内容进行操作和访问，只能够将备忘录传递给其他对象。
      使用场景：
     1、 需要保存一个对象在某一个时刻的状态或部分状态。
     2、 如果用一个接口来让其他对象得到这些状态，将会暴露对象的实现细节并破坏对象的封装性，
     	一个对象不希望外界直接访问其内部状态，通过负责人可以间接访问其内部状态。
      个人理解：
          三个对象，一个状态产生者，一个备忘录，要保存产生者的相关状态。产生者能生成一个备忘录保存状态，用一个备忘录还原状态。负责人用于维持备忘录，不干涉备忘录的内容，只持有。
 */
public class MementoPattern {

	// Originator 游戏角色
	public class Role {
		private int bloodFlow;
		private int magicPoint;
		public Role(int bloodFlow, int magicPoint) {
			this.bloodFlow = bloodFlow;
			this.magicPoint = magicPoint;
		}
		public int getBloodFlow() {
			return bloodFlow;
		}
		public void setBloodFlow(int bloodFlow) {
			this.bloodFlow = bloodFlow;
		}
		public int getMagicPoint() {
			return magicPoint;
		}
		public void setMagicPoint(int magicPoint) {
			this.magicPoint = magicPoint;
		}
		public void display() {
			System.out.println("用户当前状态：");
			System.out.println("血量："+getBloodFlow() + ";蓝量："+getMagicPoint());
		}
		// 存档
		public Memento saveMemento() {
			return new Memento(getBloodFlow(), getMagicPoint());
		}
		// 回档
		public void restoreMemento(Memento memento) {
			this.bloodFlow = memento.getBloodFlow();
			this.magicPoint = memento.getMagicPoint();
		}
	}
	
	// 备忘录
	public class Memento {
		private int bloodFlow;
		private int magicPoint;
		public Memento(int bloodFlow, int magicPoint) {
			this.bloodFlow = bloodFlow;
			this.magicPoint = magicPoint;
		}
		public int getBloodFlow() {
			return bloodFlow;
		}
		public void setBloodFlow(int bloodFlow) {
			this.bloodFlow = bloodFlow;
		}
		public int getMagicPoint() {
			return magicPoint;
		}
		public void setMagicPoint(int magicPoint) {
			this.magicPoint = magicPoint;
		}
	}
	
	// 负责人：Caretaker
	public class Caretaker {
		Memento memento;

		public Memento getMemento() {
			return memento;
		}

		public void setMemento(Memento memento) {
			this.memento = memento;
		}
	}
	
	public static void main(String[] args) {
		// 打BOSS之前：血、蓝全满
		Role role = new MementoPattern().new Role(100, 100);
		System.out.println("----------大战BOSS之前----------");
		role.display();
		// 存档
		Caretaker caretaker = new MementoPattern().new Caretaker();
		caretaker.memento = role.saveMemento();
		// 大战BOSS
		role.setBloodFlow(20);
		role.setMagicPoint(20);
		System.out.println("----------大战BOSS----------");
		role.display();
		// 回档
		role.restoreMemento(caretaker.getMemento());
		System.out.println("----------恢复----------");
		role.display();
	}
}
