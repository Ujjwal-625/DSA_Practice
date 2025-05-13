import java.util.ArrayList;
import java.util.List;

    class TaskManager {
         List<List<Integer>> newTasks;
    public TaskManager(List<List<Integer>> tasks) {
        this.newTasks = tasks;
    }
    
    public void add(int userId, int taskId, int priority) {
        List<Integer> task = new ArrayList<>();
        task.add(userId);
        task.add(taskId);
        task.add(priority);
        newTasks.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        for (List<Integer> task : newTasks) {
            if (task.get(1) == taskId) {
                task.set(2, newPriority); 
                return;
            }
        }
    }
    
    public void rmv(int taskId) {
        for (int i = 0; i < newTasks.size(); i++) {
        if (newTasks.get(i).get(1) == taskId) {
            newTasks.remove(i);
            return;
        }
    }
        
    }
    
    public int execTop() {
         int topTaskId = -1;
        int topPriority = -1;
        int userId = -1;

        for (List<Integer> task : newTasks) {
            int taskPriority = task.get(2);
            int taskId = task.get(1);

            if (taskPriority > topPriority || (taskPriority == topPriority && taskId > topTaskId)) {
                topPriority = taskPriority;
                topTaskId = taskId;
                userId = task.get(0);
            }
        }

        if (topTaskId == -1) {
            return -1;
        }
        rmv(topTaskId);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
