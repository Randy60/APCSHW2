public class Tester{
    public static void main(String[]args){
	MyLinkedList pop = new MyLinkedList();
	pop.add(1);
	pop.add('b');
	pop.add(1, "Carl");
	pop.set(1, "Caaaaaaaarrrlll");
	System.out.println(pop.get(1));
    }
}