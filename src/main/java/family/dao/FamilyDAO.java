package family.dao;

import family.Family;

import java.util.List;

public interface FamilyDAO {
    List<Family> getAllFamilies();
    Family getFamilyByIndex (int index);
    boolean deleteFamily  (Family family);
    boolean deleteFamily  (int index);
    void saveFamily  (Family family);
}
