import Task.EpicTask;
import Task.SimpleTask;
import Task.SubTask;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        SimpleTask simpleTask1 = new SimpleTask(-1, "'Настроить часы'", "'NEW'");
        SimpleTask simpleTask2 = new SimpleTask(-1, "'Покормить кота'", "'NEW'");
        SubTask subTask1 = new SubTask(-1, "'Молоко'", "'NEW'");
        SubTask subTask2 = new SubTask(-1, "'Хлеб'", "'IN_PROGRESS'");
        SubTask subTask3 = new SubTask(-1, "'Домыть вилки'", "'NEW'");
        EpicTask epicTask1 = new EpicTask(-1, "'Покупки'", "'NEW'");
        EpicTask epicTask2 = new EpicTask(-1, "'Помыть посуду'", "'NEW'");
        ManagerTask managerTask = new ManagerTask();

        managerTask.create(simpleTask1);
        managerTask.create(simpleTask2);
        managerTask.create(epicTask1);
        managerTask.create(epicTask2);
        managerTask.create(subTask1);
        managerTask.create(subTask2);
        managerTask.create(subTask3);

        epicTask1.subIds.add(subTask1.getId());
        epicTask1.subIds.add(subTask2.getId());
        epicTask2.subIds.add(subTask3.getId());

        HashMap<Integer, SimpleTask> simpleTasks = managerTask.getSimpleTasks();
        for (Integer key : simpleTasks.keySet()) {
            SimpleTask task = simpleTasks.get(key);
            System.out.println(managerTask.outListTasks(task));
        }
        System.out.println();

        HashMap<Integer, EpicTask> epicTasks = managerTask.getEpicTasks();
        for (Integer key : epicTasks.keySet()) {
            EpicTask task = epicTasks.get(key);
            System.out.println(managerTask.outListTasks(task));
            managerTask.outSubTasksofEpic(task);
            System.out.println();
        }



        System.out.println(managerTask.update(simpleTask1));
        System.out.println(managerTask.update(simpleTask2));
        System.out.println();
        System.out.println(managerTask.update(subTask1));
        System.out.println(managerTask.update(subTask2));
        System.out.println(managerTask.update(subTask3));
        System.out.println();
        System.out.println(managerTask.update(epicTask1));
        System.out.println(managerTask.update(epicTask2));

        managerTask.removeSimpleTask(1);
        managerTask.removeEpicTask(7);
    }
}