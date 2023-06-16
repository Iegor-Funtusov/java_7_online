package ua.com.alevel.dictionary;

import java.util.*;

public class DictionaryOverview {

    private Map<Student, String> hashMap = new HashMap<>();
    private Map<Student, String> linkedHashMap = new LinkedHashMap<>();
    private Map<Student, String> treeMap = new TreeMap<>();

    private Set<Student> hashSet = new HashSet<>();
    private Set<Student> linkedHashSet = new LinkedHashSet<>();
    private Set<Student> treeSet = new TreeSet<>();

//    private List<Object>[] lists = new List[16];
//    int[] ints = new int[10];

    public void start() {
        add();
    }

    private void add() {

        String id = UUID.randomUUID().toString();

        Student student = new Student();
        student.setId(id);
        student.setFirstName("F1");
        student.setLastName("L2");
        student.setAge(20);

        Student student1 = new Student();
        student1.setId(id);
        student1.setFirstName("F1");
        student1.setLastName("L2");
        student1.setAge(21);

        Student student2 = new Student();
        student2.setId(id);
        student2.setFirstName("F1");
        student2.setLastName("L1");
        student2.setAge(21);

        System.out.println("student = " + student.hashCode());
        System.out.println("student1 = " + student1.hashCode());
        System.out.println("equals = " + student.equals(student1));
        System.out.println("hashCode = " + (student.hashCode() == student1.hashCode()));


        hashMap.put(student, "student");
        hashMap.put(student1, "student1");
        hashMap.put(student2, "student2");

        linkedHashMap.put(student, "student");
        linkedHashMap.put(student1, "student1");
        linkedHashMap.put(student2, "student2");

        String value = hashMap.get(student1);
        System.out.println("value = " + value);

        treeMap.put(student, "student");
        treeMap.put(student1, "student1");
        treeMap.put(student2, "student2");


        hashSet.add(student);
        hashSet.add(student1);
        hashSet.add(student2);


        hashMap.forEach((k, v) -> {
            System.out.println("k = " + k + ", v = " + v);
        });

        System.out.println();

        linkedHashMap.forEach((k, v) -> {
            System.out.println("k = " + k + ", v = " + v);
        });

        System.out.println();

        treeMap.forEach((k, v) -> {
            System.out.println("k = " + k + ", v = " + v);
        });
    }
}
