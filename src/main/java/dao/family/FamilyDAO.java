package dao.family;

import family.Family;
import java.util.List;

public interface FamilyDAO {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);

    void saveFamily(Family f);

    default boolean deleteFamily(Family f) {
        int index = getAllFamilies().indexOf(f);

        return deleteFamily(index);
    }

}
