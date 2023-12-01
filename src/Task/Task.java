package Task;

import java.util.Arrays;
import java.util.Objects;

public class Task {
    protected int id = -1;
    protected String name;
    protected String status;
    protected String[] statuses = {"NEW", "DONE", "IN_PROGRESS"};

    public Task(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public void setStatuses(String[] statuses) {
        this.statuses = statuses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(status, task.status) && Arrays.equals(statuses, task.statuses);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, status);
        result = 31 * result + Arrays.hashCode(statuses);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +

                '}';
    }
}

