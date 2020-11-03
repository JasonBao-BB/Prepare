package 学生排序;

import java.util.*;

public class SortStudents {
    public static void main(String[] args) {

        Student[] students = new Student[5];
        students[0] = new Student("huib", 23);
        students[1] = new Student("huih", 4567);
        students[2] = new Student("shu", 1123);
        students[3] = new Student("fwi", 34);
        students[4] = new Student("suh", 1425);

//        for (int i = 0; i < students.length; i++){
//            students[i] = new Student("Bob"+i, 1000+i);
//        }

        //插入排序
//        for(int i = 0; i < students.length; i++) {
//            int min = i;
//            for(int j = i+1; j < students.length; j++) {
//                if(students[min].getId() > students[j].getId()) {
//                    min = j;
//                }
//            }
//            Student temp = students[i];
//            students[i] = students[min];
//            students[min] = temp;
//        }

        //快速排序
        //用Pivot作为基准排序，比Pivot小在左边，比Pivot大在右边
        //使用递归循环
//        quicksort(students, 0, students.length-1);

        //merge sort
        mergesort(students, 0, students.length-1, new Student[students.length]);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getId());
        }

//        List<Student> list = new ArrayList<>();
//        for (int i = 0; i < 9; i++){
//            list.add(new Student("Bob"+i, 1000+i));
//        }
//
//        System.out.println(students.length);
//        System.out.println(list.size());


//
//        Comparator studentComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getId() - o1.getId();
//            }
//        };
//
//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return 0;
//            }
//        });
//
//        for(Student student : list) {
//            System.out.println(student.getName());
//        }
    }

    public static void quicksort(Student[] students, int start, int end){
        if(start >= end) {
            return;
        }

        int left = start;
        int right = end;
        Student pivot = students[left];

        while(left <= right) {
            while (left <= right && students[left].getId() < pivot.getId()) left++;
            while (left <= right && students[right].getId() > pivot.getId()) right--;

            if (left <= right) {
                Student temp = students[left];
                students[left] = students[right];
                students[right] = temp;

                left++;
                right--;
            }
        }

        quicksort(students, start, right);
        quicksort(students, left, end);
    }

    public static void mergesort(Student[] students, int start, int end, Student[] temp){
        if(start >= end) return;

        int mid = start + (end - start)/2;

        mergesort(students, start, mid, temp);
        mergesort(students, mid+1, end, temp);

        merge(students, start, mid, end, temp);
    }

    public static void merge(Student[] students, int start, int mid, int end, Student[] temp){
        int left = start;
        int right = mid+1;
        int index = start;

        while (left <= mid && right <= end) {
            if(students[left].getId() < students[right].getId()) {
                temp[index++] = students[left++];
            } else {
                temp[index++] = students[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = students[left++];
        }

        while (right <= end) {
            temp[index++] = students[right++];
        }

        for(int i = start; i <= end; i++) {
            students[i] = temp[i];
        }
    }


}
