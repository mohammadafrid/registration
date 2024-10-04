package com.api;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class A {
    public static void main(String[] args) {

//        List<Employee> data = Arrays.asList(new Employee(1, "Afrid", 5000),
//                new Employee(2, "Hareesh", 8000),
//                new Employee(3, "Aravind", 9000));
//
//        List<Employee> highsal = data.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toList());
//
//        for(Employee emp : highsal)
//        {
//            System.out.println(emp.getId());
//            System.out.println(emp.getName());
//            System.out.println(emp.getSalary());
//        }

//        List<Integer> num = Arrays.asList(38, 48, 01, 78, 21);
//        int total = num.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(total);
//
//        List<Integer> nu = Arrays.asList(5, 7,98, 10, 76, 51, 25);
//        Optional<Integer> maxnum = nu.stream().max(Integer::compareTo);
//        System.out.println(maxnum.get());
//
//
//
//
        //creating an arrayList
        List<Integer> numList = Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3);
        //stream->collect->group by element                                                     (x,y) -> x+y
        Map<Integer, List<Integer>> numCollect = numList.stream().collect(Collectors.groupingBy(x -> x));
        //key -> value
        //integer -> list of integer values
        //1 -> [1,1,1] .  when x = 1;
        //2 -> [2,2,2] .  when x = 2;
        //3 -> [3,3,3] .  when x = 3;
        numCollect.forEach((key,value)-> System.out.println(key +":"+value));

        //grouping id age sal
//        Map<Integer, List<Employee>> groupedEmployeeMap = employeeList.stream().collect(Collectors.groupingBy(x->x.getSal()));

//        System.out.println(groupedEmployeeMap);




//        Map<Integer,List<Integer>> map = new HashMap<>();
////        map.put("age",22);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
//        list.add(1);
//
//        map.put(1,list);
//
//        System.out.println(map);
    }
}
