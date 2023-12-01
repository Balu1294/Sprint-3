import Task.EpicTask;
import Task.SimpleTask;
import Task.SubTask;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagerTask {
    private HashMap<Integer, SimpleTask> simpleTasks = new HashMap<>();
    private HashMap<Integer, EpicTask> epicTasks = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private int nextId = 1;

    public HashMap<Integer, SimpleTask> getSimpleTasks() {
        return simpleTasks;
    }

    public HashMap<Integer, EpicTask> getEpicTasks() {
        return epicTasks;
    }

    public HashMap<Integer, SubTask> getSubTasks() {
        return subTasks;
    }

    // Создать задачу
    public void create(SimpleTask task) {
        task.setId(nextId);
        simpleTasks.put(task.getId(), task);
        nextId++;
    }

    public void create(EpicTask task) {
        task.setId(nextId);
        epicTasks.put(task.getId(), task);
        nextId++;
    }

    public void create(SubTask task) {
        task.setId(nextId);
        subTasks.put(task.getId(), task);
        nextId++;
    }

    //    Получение списка задач
    public String outListTasks(SimpleTask task) {
        String outTask = String.format("ID Simple задачи - %d. Задача - %s. Статус задачи - %s.",
                task.getId(), task.getName(), task.getStatus());
        return outTask;
    }

    public String outListTasks(EpicTask task) {
        String outTask = String.format("ID Epic задачи - %d. Задача - %s. Статус задачи - %s.",
                task.getId(), task.getName(), task.getStatus());
        return outTask;
    }

    public String outListTasks(SubTask task) {
        String outTask = String.format("ID Epic задачи - %d. Задача - %s. Статус задачи - %s.",
                task.getId(), task.getName(), task.getStatus());
        return outTask;
    }

    //    Удаление всеx задач
    public void clearAllSimpleTasks() {
        simpleTasks.clear();
        System.out.println("Все Simple задачи удалены.");
    }

    public void clearAllEpicTasks() {
        epicTasks.clear();
        System.out.println("Все Epic задачи удалены.");
    }

    public void clearAllSubTasks() {
        subTasks.clear();
        System.out.println("Все Sub задачи удалены.");
    }

    // Получение задач по идентификатору
    public String outSimpleForId(int id) {
        for (Integer key : simpleTasks.keySet()) {
            if (key == id) {
                SimpleTask task = simpleTasks.get(key);
                String outTask = String.format("ID Simple задачи - %d. Задача - %s. Статус задачи - %s.",
                        task.getId(), task.getName(), task.getStatus());
                return outTask;
            }
        }
        return "Такого ID не зарегистрировано";
    }

    public String outEpicForId(int id) {
        for (Integer key : epicTasks.keySet()) {
            if (key == id) {
                EpicTask task = epicTasks.get(key);
                String outTask = String.format("ID Epic задачи - %d. Задача - %s. Статус задачи - %s.",
                        task.getId(), task.getName(), task.getStatus());
                return outTask;
            }
        }
        return "Такого ID не зарегистрировано";
    }

    public String outSubTaskForId(int id) {
        for (Integer key : subTasks.keySet()) {
            if (key == id) {
                SubTask task = subTasks.get(key);
                String outTask = String.format("ID Sub задачи - %d. Задача - %s. Статус задачи - %s.",
                        task.getId(), task.getName(), task.getStatus());
                return outTask;
            }
        }
        return "Такого ID не зарегистрировано";
    }

    //    Удаление по идентификатору
    public void removeSimpleTask(int id) {
        simpleTasks.remove(id);
        String remove = "Simple задача с ID " + id + " удалена.";
        System.out.println(remove);
    }

    public void removeEpicTask(int id) {
        simpleTasks.remove(id);
        String remove = "Epic задача с ID " + id + " удалена.";
        System.out.println(remove);
    }

    public void removeSubTask(int id) {
        simpleTasks.remove(id);
        String remove = "Sub задача с ID " + id + " удалена.";
        System.out.println(remove);
    }

    //    Обновление задачи
    public String update(SimpleTask task) {
        String[] status = task.getStatuses();
        SimpleTask updateTask = new SimpleTask(task.getId(), task.getName(), status[2]);
        simpleTasks.put(task.getId(), updateTask);
        String outStatus = String.format("Simple задача с ID %d обновилась до статуса %s",
                task.getId(), updateTask.getStatus());
        return outStatus;
    }

    public String update(EpicTask task) {
        ArrayList<Integer> statusNew = new ArrayList<>();
        ArrayList<Integer> statusDone = new ArrayList<>();
        String[] status = task.getStatuses();
        String outStatus = String.format("Epic задача с ID %d обновилась до статуса %s",
                task.getId(), task.getStatus());

        if (task.subIds == null) {
            task.setStatus(status[0]);
            outStatus = String.format("Epic задача с ID %d обновилась до статуса %s",
                    task.getId(), task.getStatus());
            return outStatus;
        }

        for (Integer subId : task.subIds) {
            SubTask subTask = subTasks.get(subId);
            if (subTask.getStatus().equals(status[0])) {
                statusNew.add(subId);
            } else if (subTask.getStatus().equals(status[1])) {
                statusDone.add(subId);
            } else {
                task.setStatus(status[2]);
                outStatus = String.format("Epic задача с ID %d обновилась до статуса %s",
                        task.getId(), task.getStatus());
                return outStatus;
            }
        }

        if (task.subIds.size() == statusNew.size()) {
            task.setStatus(status[0]);
            outStatus = String.format("Epic задача с ID %d обновилась до статуса %s",
                    task.getId(), task.getStatus());
            return outStatus;
        } else if (task.subIds.size() == statusDone.size()) {
            task.setStatus(status[1]);
            outStatus = String.format("Epic задача с ID %d обновилась до статуса %s",
                    task.getId(), task.getStatus());
        }
        return outStatus;
    }

    public String update(SubTask task) {
        String[] status = task.getStatuses();
        SubTask updateTask = new SubTask(task.getId(), task.getName(), status[1]);
        subTasks.put(task.getId(), updateTask);
        String outStatus = String.format("Sub задача с ID %d обновилась до статуса %s",
                task.getId(), updateTask.getStatus());
        return outStatus;
    }

    public void outSubTasksofEpic(EpicTask task) {
        ArrayList<Integer> subTasksOfEpic = task.subIds;
        for (Integer subTask : subTasksOfEpic) {
            SubTask subTaskOut = subTasks.get(subTask);
            String text = String.format("Подзадача эпика %s: ID задачи - %d. Задача - %s. Статус задачи - %s.",
                    task.getName(), subTaskOut.getId(), subTaskOut.getName(), subTaskOut.getStatus());
            System.out.println(text);
        }
    }
}
