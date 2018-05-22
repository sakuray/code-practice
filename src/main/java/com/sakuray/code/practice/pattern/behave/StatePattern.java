package com.sakuray.code.practice.pattern.behave;

/**
 * 状态模式:
 *   在很多情况下，一个对象的行为取决于它的一个或多个变化的属性，这些属性我们称之为状态，这个对象称之为状态对象。
 *   对于状态对象而言，它的行为依赖于它的状态，比如你要预订房间，那么只有当该房间为空闲时你才能预订，你想入住该房间也只有当你预订了该房间或者该房间为空闲时。
 *   对于这样的一个对象，当它在于外部事件产生互动的时候，其内部状态就会发生改变，从而使得他的行为也随之发生改变。
 *   所谓状态模式就是允许对象在内部状态发生改变时改变它的行为，对象看起来好像修改了它的类。
 * 模式结构：
 *   Context: 环境类。可以包括一些内部状态。 
     State: 抽象状态类。State定义了一个所有具体状态的共同接口，任何状态都实现这个相同的接口，这样一来，状态之间就可以互相转换了。 
     ConcreteState: 具体状态类。具体状态类，用于处理来自Context的请求，每一个ConcreteState都提供了它对自己请求的实现，所以，当Context改变状态时行为也会跟着改变。
      适用场景：
     1、对象的行为依赖于它的状态（属性）并且可以根据它的状态改变而改变它的相关行为。 
     2、代码中包含大量与对象状态有关的条件语句
      个人体会：
          状态模式中原事物持有一个状态，这个状态下执行该状态下相应的方法，取代了if else的判断状态再选择执行的任务。因为状态本身是知道的，不需要进行判断。
 */
public class StatePattern {

	// 状态接口
	public interface State {
		// 预定房间
		public void bookRoom();
		// 退订房间
		public void unsubscribeRoom();
		// 入住
		public void checkInRoom();
		// 退房
		public void checkOutRoom();
	}
	
	public class Room {
		State freeTimeState;	// 空闲
		State checkInState;		// 入住
		State bookedState;		// 预定
		
		State state;
		
		public Room() {
			freeTimeState = new FreeTimeState(this);
			checkInState = new CheckInState(this);
			bookedState = new BookedState(this);
			
			state = freeTimeState;
		}
		
		public void bookRoom() {
			state.bookRoom();
		}
		
		public void unsubscribeRoom() {
			state.unsubscribeRoom();
		}
		
		public void checkInRoom() {
			state.checkInRoom();
		}
		
		public void checkOutRoom() {
			state.checkOutRoom();
		}
		
		public String toString() {
			return "该房间的状态是：" + getState().getClass().getName();
		}

		public State getFreeTimeState() {
			return freeTimeState;
		}

		public void setFreeTimeState(State freeTimeState) {
			this.freeTimeState = freeTimeState;
		}

		public State getCheckInState() {
			return checkInState;
		}

		public void setCheckInState(State checkInState) {
			this.checkInState = checkInState;
		}

		public State getBookedState() {
			return bookedState;
		}

		public void setBookedState(State bookedState) {
			this.bookedState = bookedState;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}
	}
	
	public class FreeTimeState implements State {
		
		Room hotelManagement;
		public FreeTimeState(Room hotelManagement) {
			this.hotelManagement = hotelManagement;
		}

		@Override
		public void bookRoom() {
			System.out.println("您已经成功预订了...");
	        hotelManagement.setState(hotelManagement.getBookedState());   //状态变成已经预订
		}

		@Override
		public void unsubscribeRoom() {
			//不需要做操作
		}

		@Override
		public void checkInRoom() {
			System.out.println("您已经成功入住了...");
			hotelManagement.setState(hotelManagement.getCheckInState()); // 状态变成已经入住
		}

		@Override
		public void checkOutRoom() {
			//不需要做操作
		}
	}
	
	public class BookedState implements State {
		Room hotelManagement;
		public BookedState(Room hotelManagement) {
			this.hotelManagement = hotelManagement;
		}

		@Override
		public void bookRoom() {
			System.out.println("该房间已经给预定了...");
		}

		@Override
		public void unsubscribeRoom() {
			System.out.println("退订成功,欢迎下次光临...");
	        hotelManagement.setState(hotelManagement.getFreeTimeState());   //变成空闲状态
		}

		@Override
		public void checkInRoom() {
			System.out.println("入住成功..."); 
		}

		@Override
		public void checkOutRoom() {
			// 不需要做操作
		}
	}
	
	public class CheckInState implements State {
		Room hotelManagement;
		public CheckInState(Room hotelManagement) {
			this.hotelManagement = hotelManagement;
		}

		@Override
		public void bookRoom() {
			System.out.println("该房间已经入住了...");			
		}

		@Override
		public void unsubscribeRoom() {
			//不需要做操作
		}

		@Override
		public void checkInRoom() {
			System.out.println("该房间已经入住了...");
		}

		@Override
		public void checkOutRoom() {
			System.out.println("退房成功....");
			hotelManagement.setState(hotelManagement.getFreeTimeState()); // 状态变成空闲
		}
	}
	
	public static void main(String[] args) {
		Room[] rooms = new Room[2];
		for(int i = 0; i < rooms.length; i++) {
			rooms[i] = new StatePattern().new Room();
		}
		
		rooms[0].bookRoom();
		rooms[0].checkInRoom();
		rooms[0].bookRoom();
		System.out.println(rooms[0]);
		System.out.println("---------------------------");
        
        //第二间房
        rooms[1].checkInRoom();
        rooms[1].bookRoom();
        rooms[1].checkOutRoom();
        rooms[1].bookRoom();
        System.out.println(rooms[1]);
	}
}
