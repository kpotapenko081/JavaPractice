package ua.sumdu.j2se.Potapenko.tasks;

public class ArrayTaskList{
    Task[] task = new Task[0];
    public void add(Task task) {
        int count = this.task.length;
        Task[] task1 = new Task[count + 1];
        System.arraycopy(this.task, 0, task1, 0, count);
        task1[count] = task;
        this.task = task1;
        task1=null;
    }
    public boolean remove(Task task) {
        for (int i = 0; i < this.task.length; i++) {
            if (this.task[i] == task) {
                for (int k = i; k < this.task.length - 1; k++) {
                    this.task[k] = this.task[k + 1];
                }
                int count = this.task.length-1;
                Task[] task1 = new Task[count];
                System.arraycopy(this.task, 0, task1, 0, count);
                this.task = null;
                this.task = task1;
                task1=null;
                return true;
            }
        }
        return false;
    }
    public int size() {
        return this.task.length;
    }
    public Task getTask(int index) {
        return this.task[index];
    }
    public  ArrayTaskList incoming(int from, int to){
        ArrayTaskList a = new ArrayTaskList();
        ArrayTaskList b = new ArrayTaskList();
        for(int i = 0; i < a.size(); i++){
            if( (a.getTask(i).getTime() >= from && a.getTask(i).getTime() <= to) || !(a.getTask(i).getStartTime() >= from && a.getTask(i).getEndTime() > to)){
                b.add(a.getTask(i));
            }
        }
        return b;
    }

    public static void main(String[] args){
        Task obj1 = new Task();
        Task obj2 = new Task();
        Task obj3 = new Task();
        Task obj4 = new Task();
        Task obj5 = new Task();

        obj1.setTitle("Task1");
        obj1.setTime(12, 22, 2);
        obj2.setTitle("Task2");
        obj2.setTime(12);
        obj3.setTitle("Task3");
        obj3.setTime(8);
        obj4.setTitle("Task4");
        obj4.setTime(15, 20, 3);
        obj5.setTitle("Task5");
        obj5.setTime(33);

        ArrayTaskList a = new ArrayTaskList();
        a.add(obj1);
        a.add(obj2);
        a.add(obj3);
        a.add(obj4);
        a.add(obj5);

        System.out.println(a.incoming(9, 25));
    }
}

