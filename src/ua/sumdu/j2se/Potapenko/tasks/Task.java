package ua.sumdu.j2se.Potapenko.tasks;

public class Task {
    private String title;
    private Boolean active;
    private int time;
    private int start;
    private int end;
    private int interval;
    private int current;

    public Task() {}
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        this.active = false;
    }
    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.active = false;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean isActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public int getTime() {
        if (interval != 0) {
            return start;
        }
        return time;
    }
    public void setTime(int time) {
        if (interval != 0) {
            start = 0;
            end = 0;
            interval = 0;
        }
        this.time = time;
    }
    public int getStartTime() {
        if (interval == 0) {
            return time;
        }
        return start;
    }
    public int getEndTime() {
        if (interval == 0) {
            return time;
        }
        return end;
    }
    public int getRepeatInterval() {
        if (interval == 0) {
            return 0;
        }
        return interval;
    }
    public void setTime(int start, int end, int interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.time = 0;
    }
    public boolean isRepeated () {
        return interval != 0;
    }
    public int nextTimeAfter(int current){
        if(time!=0 && active){
            if(current>=time){
                return -1;
            }else{
                return time;
            }
        }else if(interval!=0 && active){
            if(current>=end){
                return -1;
            }else if(current < start){
                return start;
            }
            for(int i=0; i!=(end-start)/interval; i++){
                if(current>=start+interval*i && current<start+interval*(i+1)){
                    return start+interval*(i+1);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Task obj1 = new Task();
        Task obj2 = new Task();
        obj1.setTime(1, 10, 2);
        System.out.println(obj1.getStartTime());
        System.out.println(obj1.getEndTime());
        System.out.println(obj1.getRepeatInterval());
        obj1.setTitle("Non-active-non-static");
        System.out.println(obj1.isActive());
        System.out.println(obj1.isRepeated());
        System.out.println(obj1.getTitle());
        obj1.setActive(true);
        System.out.println(obj1.nextTimeAfter(3));
        obj2.setTime(12);
        obj2.setTitle("Active-static");
        System.out.println(obj2.isActive());
        System.out.println(obj2.isRepeated());
        System.out.println(obj2.getTitle());
        obj2.setActive(true);
        System.out.println(obj2.isActive());
        System.out.println(obj2.nextTimeAfter(3));
    }
}

