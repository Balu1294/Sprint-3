package Task;

import java.util.ArrayList;
import java.util.Objects;

public class EpicTask extends Task {
    public EpicTask(int id, String name, String status) {
        super(id, name, status);
    }

    public ArrayList<Integer> subIds = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EpicTask epicTask = (EpicTask) o;
        return Objects.equals(subIds, epicTask.subIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subIds);
    }
}
