package com.sakuray.code.practice.pattern.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：
 *   组合模式定义了如何将容器对象和叶子对象进行递归组合，使得客户在使用的过程中无须进行区分，可以对他们进行一致的处理。
 *   组合模式组合多个对象形成树形结构以表示“整体-部分”的结构层次。
 *   它也模糊了简单元素(叶子对象)和复杂元素(容器对象)的概念，使得客户能够像处理简单元素一样来处理复杂元素，从而使客户程序能够与复杂元素的内部结构解耦。
 * 模式结构：
 *   1.Component ：组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。声明一个接口用于访问和管理Component子部件。 
	 2.Leaf：叶子对象。叶子结点没有子结点。 
	 3.Composite：容器对象，定义有枝节点行为，用来存储子部件，在Component接口中实现与子部件有关操作，如增加(add)和删除(remove)等。
 * 适用场景：
 *   1、需要表示一个对象整体或部分层次，在具有整体和部分的层次结构中，希望通过一种方式忽略整体与部分的差异，可以一致地对待它们。
     2、让客户能够忽略不同对象层次的变化，客户端可以针对抽象构件编程，无须关心对象层次结构的细节。
 * 个人理解：
 *   组合模式就是将容器和元素组合，其具有相同的父类，父类抽象展示方法，达到容器和元素的展示方法相同的目的。
 */
public class CombinationPattern {

	// Component
	public abstract class File {
		String name;

		public File(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public abstract void display();
	}
	
	public class Folder extends File {
		
		private List<File> files;

		public Folder(String name) {
			super(name);
			files = new ArrayList<File>();
		}

		@Override
		public void display() {
			for(File file : files) {
				file.display();
			}
		}
		
		public void add(File file) {
			files.add(file);
		}
		
		public void remove(File file) {
			files.remove(file);
		}
	}
	
	public class TextFile extends File {

		public TextFile(String name) {
			super(name);
		}

		@Override
		public void display() {
			System.out.println("这是文本文件，文件名：" + super.getName());
		}
		
	}
	
	public class ImagerFile extends File {

		public ImagerFile(String name) {
			super(name);
		}

		@Override
		public void display() {
			System.out.println("这是图像文件，文件名：" + super.getName());
		}
		
	}
	
	public class VideoFile extends File {

		public VideoFile(String name) {
			super(name);
		}

		@Override
		public void display() {
			System.out.println("这是影像文件，文件名：" + super.getName());
		}
		
	}
	
	public static void main(String[] args) {
		CombinationPattern pattern = new CombinationPattern();
		Folder all = pattern.new Folder("总文件夹");
		TextFile aText = pattern.new TextFile("a.txt");
		ImagerFile bImager = pattern.new ImagerFile("b.jpg");
		Folder cFolder = pattern.new Folder("c文件夹");
		
		all.add(aText);
		all.add(bImager);
		all.add(cFolder);
		
		TextFile cText = pattern.new TextFile("c_1.txt");
        ImagerFile cImage = pattern.new ImagerFile("c_1.jpg");
        VideoFile cVideo = pattern.new VideoFile("c_1.rmvb");
        
        cFolder.add(cText);
        cFolder.add(cImage);
        cFolder.add(cVideo);
        
        // 遍历总文件夹
        all.display();
        System.out.println("-----------------------");
        //遍历C文件夹
        cFolder.display();
        //将c_1.txt删除
        cFolder.remove(cText);
        System.out.println("-----------------------");
        cFolder.display();
        System.out.println("-----------------------");
        all.display();
	}
}
