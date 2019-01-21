/**
 * The test methods.
 * @author fatihselimyakar
 * @version 1.0.0
 */
public class CollectionTest{
    /*
    * The main test six different issue that is String and Integer
    * HashSet,ArrayList and LinkedList
    */
    public static void main(String[]args){
        try{
            System.out.println("****TESTING 'ArrayList' FOR STRING****");
            //ARRAYLIST methodS TEST
            ArrayList<String> sample=new ArrayList<String>();//add() method test
            sample.add("one");
            sample.add("one");
            sample.add("two");
            sample.add("three");
            sample.add("for");
            sample.add("eight");

            ArrayList<String> sample2=new ArrayList<String>();
            sample2.add("three");
            sample2.add("for");
            sample2.add("seven");
            sample2.add("eight");

            System.out.println("Sample1:");
            sample.print();
            System.out.println("\nSample2:");
            sample2.print();
            System.out.println("\nAfter the addAll():");
            sample.addAll(sample2);
            sample.print();
            System.out.println("\nafter the removeAll() added sample and sample2:");
            sample.removeAll(sample2);
            sample.print();
            System.out.println("\nremove() 'two' to sample1, contains() for 'two', size():");
            sample.remove("two");
            sample.print();
            System.out.print("\nContains() 'one'?:");
            System.out.println(sample.contains("one"));
            System.out.print("Sample1 size:");
            System.out.println(sample.size());
            System.out.print("ContainsAll() for itself:");
            System.out.println(sample.containsAll(sample));
            System.out.print("Random Access the index[0]:");
            System.out.println(sample.randomAccess(0));
            System.out.println("RetainAll() last sample1 and sample2:");
            sample.retainAll(sample2);//All element in sample have sample2 because of this the resılt is same "sample"
            sample.print();
            System.out.println("\nClear the sample1 and isEmpty():");
            sample.clear();
            System.out.println(sample.isEmpty());


            System.out.println("\n****TESTING 'ArrayList' FOR INT****");
            ArrayList<Integer> sample3=new ArrayList<Integer>();//add() method test
            sample3.add(1);
            sample3.add(2);
            sample3.add(3);
            sample3.add(4);

            ArrayList<Integer> sample4=new ArrayList<Integer>();
            sample4.add(3);
            sample4.add(4);
            sample4.add(5);
            sample4.add(6);
            sample4.add(7);

            System.out.println("Sample3:");
            sample3.print();
            System.out.println("\nSample4:");
            sample4.print();
            System.out.println("\nAfter the addAll():");
            sample3.addAll(sample4);
            sample3.print();
            System.out.println("\nafter the removeAll() added sample3 and sample4:");
            sample3.removeAll(sample4);
            sample3.print();
            System.out.println("\nremove() '1' to sample3, contains() for '1', size():");
            sample3.remove(1);
            sample3.print();
            System.out.print("\nContains() '1'?:");
            System.out.println(sample3.contains(1));
            System.out.print("Sample3 size:");
            System.out.println(sample3.size());
            System.out.print("ContainsAll() for itself:");
            System.out.println(sample3.containsAll(sample3));
            System.out.print("Random Access the index[0]:");
            System.out.println(sample3.randomAccess(0));
            System.out.println("RetainAll() last sample3 and sample4:");
            sample3.retainAll(sample4);//All element in sample have sample2 because of this the resılt is same "sample"
            sample3.print();
            System.out.println("\nClear the sample3 and isEmpty():");
            sample3.clear();
            System.out.println(sample3.isEmpty());

            System.out.println("\n****TESTING 'HashSet' FOR INT****");
            HashSet<Integer> sample5=new HashSet<Integer>();
            sample5.add(3);
            sample5.add(5);
            sample5.add(7);
            sample5.add(2);
            sample5.add(20);

            HashSet<Integer> sample6=new HashSet<Integer>();
            sample6.add(5);
            sample6.add(2);

            System.out.println("Sample5:");
            sample5.print();
            System.out.println("\nSample6:");
            sample6.print();
            System.out.println("\nAfter the addAll():");
            sample5.addAll(sample6);
            sample5.print();
            System.out.println("\nafter the removeAll() added sample5 and sample6:");
            sample5.removeAll(sample6);
            sample5.print();
            System.out.println("\nremove() '3' to sample5 and contains() for '3' and size():");
            sample5.remove(3);
            sample5.print();
            System.out.print("\nContains() '3'?:");
            System.out.println(sample5.contains(3));
            System.out.print("Sample5 size:");
            System.out.println(sample5.size());
            System.out.print("ContainsAll() for itself:");
            System.out.println(sample5.containsAll(sample5));
            System.out.println("RetainAll() last sample5 and sample6:");
            sample5.retainAll(sample6);//All element in sample have sample2 because of this the resılt is same "sample"
            sample5.print();
            System.out.println("\nClear the sample5 and isEmpty():");
            sample5.clear();
            System.out.println(sample5.isEmpty());


            System.out.println("\n****TESTING 'HashSet' FOR STRING****");
            HashSet<String> sample7=new HashSet<String>();
            sample7.add("one");
            sample7.add("two");
            sample7.add("three");

            HashSet<String> sample8=new HashSet<String>();
            sample8.add("three");
            sample8.add("for");
            sample8.add("five");

            System.out.println("Sample7:");
            sample7.print();
            System.out.println("\nSample8:");
            sample8.print();
            System.out.println("\nAfter the addAll():");
            sample7.addAll(sample8);
            sample7.print();
            System.out.println("\nafter the removeAll() added sample7 and sample8:");
            sample7.removeAll(sample8);
            sample7.print();
            System.out.println("\nremove() 'one' to sample7 and contains() for 'one' and size():");
            sample7.remove("one");
            sample7.print();
            System.out.print("\nContains() 'one'?:");
            System.out.println(sample7.contains("one"));
            System.out.print("Sample7 size:");
            System.out.println(sample7.size());
            System.out.print("ContainsAll() for itself:");
            System.out.println(sample7.containsAll(sample7));
            System.out.println("RetainAll() last sample7 and sample8:");
            sample7.retainAll(sample8);//All element in sample have sample2 because of this the resılt is same "sample"
            sample7.print();
            System.out.println("\nClear the sample7 and isEmpty():");
            sample7.clear();
            System.out.println(sample7.isEmpty());

            System.out.println("\n****TESTING 'LinkedList' FOR INT****");
            LinkedList<Integer> sample9=new LinkedList<Integer>();
            sample9.add(-1);
            sample9.add(1);
            sample9.add(2);
            sample9.add(3);
            sample9.offer(4);
            sample9.offer(5);

            LinkedList<Integer> sample10=new LinkedList<Integer>();
            sample10.add(4);
            sample10.add(5);
            sample10.add(6);
            sample10.add(7);

            System.out.println("Sample9:");
            sample9.print();
            System.out.println("\nSample10:");
            sample10.print();
            System.out.print("\nelement() method for sample9:");
            System.out.print(sample9.element());
            System.out.print("\npoll() method for sample9:");
            System.out.println(sample9.poll());
            System.out.println("After the poll method:");
            sample9.print();
            System.out.println("\nAfter the addAll():");
            sample9.addAll(sample10);
            sample9.print();
            System.out.println("\nafter the removeAll() added sample9 and sample10:");
            sample9.removeAll(sample10);
            sample9.print();
            System.out.println("\nremove() '3' to sample9 and contains() for '3' and size():");
            sample9.remove(3);
            sample9.print();
            System.out.print("\nContains() '3'?:");
            System.out.println(sample9.contains(3));
            System.out.print("Sample9 size:");
            System.out.println(sample9.size());
            System.out.print("ContainsAll() for itself:");
            System.out.println(sample9.containsAll(sample9));
            System.out.println("RetainAll() last sample9 and sample10:");
            sample9.retainAll(sample10);//All element in sample have sample2 because of this the resılt is same "sample"
            sample9.print();
            System.out.println("\nClear the sample9 and isEmpty():");
            sample9.clear();
            System.out.println(sample9.isEmpty());


            System.out.println("\n****TESTING 'LinkedList' FOR STRING****");
            LinkedList<String> sample11=new LinkedList<String>();
            sample11.add("one");
            sample11.offer("two");
            sample11.add("three");

            LinkedList<String> sample12=new LinkedList<String>();
            sample12.add("three");
            sample12.offer("for");
            sample12.add("five");

            System.out.println("Sample11:");
            sample11.print();
            System.out.println("\nSample12:");
            sample12.print();
            System.out.print("\nelement() method for sample11:");
            System.out.print(sample11.element());
            System.out.print("\npoll() method for sample11:");
            System.out.println(sample11.poll());
            System.out.println("After the poll method:");
            sample11.print();
            System.out.println("\nAfter the addAll():");
            sample11.addAll(sample12);
            sample11.print();
            System.out.println("\nafter the removeAll() added sample11 and sample12:");
            sample11.removeAll(sample12);
            sample11.print();
            System.out.println("\nremove() 'two' to sample9 and contains() for 'two' and size():");
            sample11.remove("two");
            sample11.print();
            System.out.print("\nContains() 'one'?:");
            System.out.println(sample11.contains("one"));
            System.out.print("Sample11 size:");
            System.out.println(sample11.size());
            System.out.print("ContainsAll() for itself:");
            System.out.println(sample11.containsAll(sample11));
            System.out.println("RetainAll() last sample11 and sample12:");
            sample11.retainAll(sample12);//All element in sample have sample2 because of this the resılt is same "sample"
            sample11.print();
            System.out.println("\nClear the sample11 and isEmpty():");
            sample11.clear();
            System.out.println(sample11.isEmpty());




        }
        catch(MyException err){
            System.out.printf("%s",err.what());
        }


    }
}
