package week7Assigment;

import java.io.IOException;
import java.util.Scanner;

public class Testing {
	binaryTree BTree = new binaryTree();
	Scanner c = new Scanner(System.in);
	
	public void Testermenu() {
		DisplayTestermenu();
		int b=0;
		 b = c.nextInt();
		try {
			switch (b) {
			case 1:
				numadd();
				break;
			case 2:
				numdelete();
				break;
				
			case 3: 
				numdprint();
				break;
			}

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			Testermenu();
		}
	}

	public void add1num() {
		
		System.out.println(" Adding one number ");
		System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
		BTree.addTree( "iteam 1 ", 5 , 1 );
		BTree.preOrderPrint(BTree.getroot());
	}
public void add2num() {
		
		System.out.println(" Adding two number ");
		System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
		BTree.addTree( "iteam 1 ", 5 , 1 );
		BTree.addTree( "iteam 2 ", 6 , 1 );
		BTree.preOrderPrint(BTree.getroot());
	}
public void add3num() {
	
	System.out.println(" Adding three number ");
	System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
	BTree.addTree( "iteam 1 ", 5 , 1 );
	BTree.addTree( "iteam 2 ", 6 , 1 );
	BTree.addTree( "iteam 3 ", 3 , 1 );
	BTree.preOrderPrint(BTree.getroot());
}
public void add4num() {
	
	System.out.println(" Adding four number ");
	System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
	BTree.addTree( "iteam 1 ", 5 , 1 );
	BTree.addTree( "iteam 2 ", 6 , 1 );
	BTree.addTree( "iteam 3 ", 3 , 1 );
	BTree.addTree( "iteam 4 ", 4 , 1 );
	BTree.preOrderPrint(BTree.getroot());
}
public void add5num() {
	
	System.out.println(" Adding five number ");
	System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
	BTree.addTree( "iteam 1 ", 5 , 1 );
	BTree.addTree( "iteam 2 ", 6 , 1 );
	BTree.addTree( "iteam 3 ", 3 , 1 );
	BTree.addTree( "iteam 4 ", 4 , 1 );
	BTree.addTree( "iteam 5 ", 1 , 1 );
	BTree.preOrderPrint(BTree.getroot());
}
public void dup() {
	
	System.out.println(" Adding five number ");
	System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
	BTree.addTree( "iteam 1 ", 5 , 1 );
	BTree.addTree( "Milk ", 5 , 1 );
	BTree.addTree( "iteam 2 ", 6 , 1 );
	BTree.addTree( "iteam 3 ", 3 , 1 );
	BTree.addTree( "iteam 4 ", 4 , 1 );
	BTree.addTree( "iteam 5 ", 1 , 1 );
	BTree.preOrderPrint(BTree.getroot());
}
public void dup1() {
	
	System.out.println(" Adding five number ");
	System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
	BTree.addTree( "iteam 1 ", 5 , 1 );
	BTree.addTree( "iteam 1 ", 5 , 1 );
	BTree.addTree( "iteam 2 ", 6 , 1 );
	BTree.addTree( "iteam 3 ", 3 , 1 );
	BTree.addTree( "iteam 4 ", 4 , 1 );
	BTree.addTree( "iteam 5 ", 1 , 1 );
	BTree.preOrderPrint(BTree.getroot());
}

	
	public void DisplayTestermenu() {
		System.out.println("Please select what you want to do");
		System.out.println("---------------------------------");
		System.out.println("1:Adding numbers to the binary tree Test");
		System.out.println("---------------------------------");
		System.out.println("2:Deleting numbers from a binary tree");
		System.out.println("---------------------------------");
		System.out.println("3:Print the trees in their different order.");
	}
	public void numaddDisplay() {
		System.out.println("Please select what you want to do");
		System.out.println("---------------------------------");
		System.out.println("1:Add one number to the tree");
		System.out.println("---------------------------------");
		System.out.println("2:Add two numbers to the tree");
		System.out.println("---------------------------------");
		System.out.println("3:Add three numbers to the tree");
		System.out.println("---------------------------------");
		System.out.println("4:Add four numbers to the tree");
		System.out.println("---------------------------------");
		System.out.println("5:Add five numbers to the tree");
		System.out.println("---------------------------------");
		System.out.println("6:Add One duplicate to the tree");
		System.out.println("---------------------------------");
		System.out.println("7:Add Add an iteam with a different name but the same ID");
	}
	public void numdeleteDisplay() {
		System.out.println("Please select what you want to do");
		System.out.println("---------------------------------");
		System.out.println("1:Delete the root from the tree");
		System.out.println("---------------------------------");
		System.out.println("2:Delete a leaf from the tree");
		System.out.println("---------------------------------");
		System.out.println("3:Delete a node with one child from the tree");
		System.out.println("---------------------------------");
		System.out.println("4:Delete a node with two children from the tree");
		System.out.println("---------------------------------");
		System.out.println("5:Delete a duplicate from the tree");
		System.out.println("---------------------------------");
		System.out.println("6:Delete an iteam that doesnt exist ");
		System.out.println("---------------------------------");
	}
	
		
		public void numadd() {
			numaddDisplay();
			int l=0;
			Scanner c = new Scanner(System.in);
			 l = c.nextInt();
			try {
				switch (l) {
				case 1:
					add1num();
					Testermenu();
					break;
				case 2:
					add2num();
					Testermenu();
					break;
				case 3:
					add3num();
					Testermenu();
					break;
				case 4:
					add4num();
					Testermenu();
					break;
				case 5:
					add5num();
					Testermenu();
					break;
				case 6:
					dup();
					Testermenu();
					break;
				case 7:
					dup();
					Testermenu();
					break;
				}

			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				Testermenu();
			}
		}
		public void numdelete() {
			numdeleteDisplay();
			int l=0;
			Scanner c = new Scanner(System.in);
			 l = c.nextInt();
			try {
				switch (l) {
				case 1:
					delete1num();
					Testermenu();
					break;
				case 2:
					delete2num();
					Testermenu();
					break;
				case 3:
					delete3num();
					Testermenu();
					break;
				case 4:
					delete4num();
					Testermenu();
					break;
				case 5:
					delete5num();
					add5num();
					Testermenu();
					break;
				case 6:
					delete6num();
					Testermenu();
					break;
				}

			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				Testermenu();
			}
		}	
	
		public void delete1num() {
			int p = 5;
			System.out.println(" Deleting the root from the tree ");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			BTree.addTree( "iteam 1 ", 5 , 1 );
			BTree.addTree( "iteam 2 ", 6 , 1 );
			BTree.addTree( "iteam 3 ", 3 , 1 );
			BTree.addTree( "iteam 4 ", 4 , 1 );
			BTree.addTree( "iteam 5 ", 1 , 1 );
			BTree.preOrderPrint(BTree.getroot());
			BTree.searchRoot(p,BTree.getroot());
			BTree.deleteroot1(p);
			BTree.preOrderPrint(BTree.getroot());
		}
		public void delete2num() {
			int p = 1;
			System.out.println(" Deleting the leaf from the tree ");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			BTree.addTree( "iteam 1 ", 5 , 1 );
			BTree.addTree( "iteam 2 ", 6 , 1 );
			BTree.addTree( "iteam 3 ", 3 , 1 );
			BTree.addTree( "iteam 4 ", 4 , 1 );
			BTree.addTree( "iteam 5 ", 1 , 1 );
			BTree.preOrderPrint(BTree.getroot());
			BTree.searchRoot(p,BTree.getroot());
			BTree.deleteroot1(p);
			BTree.preOrderPrint(BTree.getroot());
		}
		public void delete3num() {
			int p = 3;
			System.out.println(" Deleting the node with one child from the tree ");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			BTree.addTree( "iteam 1 ", 5 , 1 );
			BTree.addTree( "iteam 2 ", 6 , 1 );
			BTree.addTree( "iteam 3 ", 3 , 1 );
			BTree.addTree( "iteam 4 ", 4 , 1 );
			BTree.addTree( "iteam 5 ", 1 , 1 );
			BTree.preOrderPrint(BTree.getroot());
			BTree.searchRoot(p,BTree.getroot());
			BTree.deleteroot1(p);
			BTree.preOrderPrint(BTree.getroot());
		}
		public void delete4num() {
			int p = 3;
			System.out.println(" Deleting the node with two children from the tree ");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			BTree.addTree( "iteam 1 ", 5 , 1 );
			BTree.addTree( "iteam 2 ", 6 , 1 );
			BTree.addTree( "iteam 3 ", 3 , 1 );
			BTree.addTree( "iteam 4 ", 4 , 1 );
			BTree.addTree( "iteam 5 ", 1 , 1 );
			BTree.addTree( "iteam 5 ", 2 , 1 );
			BTree.addTree( "iteam 5 ", 0 , 1 );
			BTree.preOrderPrint(BTree.getroot());
			BTree.searchRoot(p,BTree.getroot());
			BTree.deleteroot1(p);
			BTree.preOrderPrint(BTree.getroot());
		}
		public void delete5num() {
			int p = 4;
			binaryTree  tr = new binaryTree();
			System.out.println(" Deleting deleting a duplicate from the tree ");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			tr.addTree( "iteam 1 ", 5 , 1 );
			tr.addTree( "iteam 2 ", 6 , 1 );
			tr.addTree( "iteam 3 ", 3 , 1 );
			tr.addTree( "iteam 4 ", 4 , 1 );
			tr.addTree( "iteam 4 ", 4 , 1 );
			tr.addTree( "iteam 5 ", 1 , 1 );
			tr.addTree( "iteam 5 ", 2 , 1 );
			tr.addTree( "iteam 5 ", 0 , 1 );
			tr.preOrderPrint(tr.getroot());
			tr.searchRoot(p,tr.getroot());
			tr.deleteroot1(p);
			tr.preOrderPrint(tr.getroot());
		}
		public void delete6num() {
			int p = 12;
			binaryTree  tr = new binaryTree();
			System.out.println(" Deleting an iteam that doesnt exist ");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			tr.addTree( "iteam 1 ", 5 , 1 );
			tr.addTree( "iteam 2 ", 6 , 1 );
			tr.addTree( "iteam 3 ", 3 , 1 );
			tr.addTree( "iteam 4 ", 4 , 1 );
			tr.addTree( "iteam 5 ", 1 , 1 );
			tr.addTree( "iteam 5 ", 2 , 1 );
			tr.addTree( "iteam 5 ", 0 , 1 );
			tr.preOrderPrint(tr.getroot());
			tr.searchRoot(p,tr.getroot());
			tr.deleteroot1(p);
			tr.preOrderPrint(tr.getroot());
			tr.preOrderPrint(tr.getroot());
		}
		
		public void numdprint() {
			numPrintDisplay();
			int l=0;
			Scanner c = new Scanner(System.in);
			 l = c.nextInt();
			try {
				switch (l) {
				case 1:
					preord();
					Testermenu();
					break;
				case 2:
					postord();
					Testermenu();
					break;
				case 3:
					inord();
					Testermenu();
					break;
			
				}

			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				Testermenu();
			}
		}
		
		
		public void preord() {
			binaryTree b = new binaryTree();
			System.out.println(" Preorder print");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			b.addTree( "iteam 1 ", 5 , 1 );
			b.addTree( "iteam 2 ", 6 , 1 );
			b.addTree( "iteam 3 ", 3 , 1 );
			b.addTree( "iteam 4 ", 4 , 1 );
			b.addTree( "iteam 5 ", 1 , 1 );
			b.preOrderPrint(b.getroot());
		}
		public void postord() {
			binaryTree c = new binaryTree();
			System.out.println(" Postorder print");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			c.addTree( "iteam 1 ", 5 , 1 );
			c.addTree( "iteam 2 ", 6 , 1 );
			c.addTree( "iteam 3 ", 3 , 1 );
			c.addTree( "iteam 4 ", 4 , 1 );
			c.addTree( "iteam 5 ", 1 , 1 );
			c.postOrderPrint(c.getroot());
		}
		public void inord() {
			binaryTree d = new binaryTree();
			System.out.println(" Inorder print");
			System.out.println("Name	" + "	 	ID	" + "	Price	"+"     Amount	");
			d.addTree( "iteam 1 ", 5 , 1 );
			d.addTree( "iteam 2 ", 6 , 1 );
			d.addTree( "iteam 3 ", 3 , 1 );
			d.addTree( "iteam 4 ", 4 , 1 );
			d.addTree( "iteam 5 ", 1 , 1 );
			d.inOrderPrint(d.getroot());
		}
		
		public void numPrintDisplay() {
			System.out.println("Please select what you want to do");
			System.out.println("---------------------------------");
			System.out.println("1:Preorder print");
			System.out.println("---------------------------------");
			System.out.println("2:Postorder print");
			System.out.println("---------------------------------");
			System.out.println("3:Inorder print");
			System.out.println("---------------------------------");
		}

}
