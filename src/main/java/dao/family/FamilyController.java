package dao.family;

import family.Family;

import java.util.List;

public class FamilyController {
    private final FamilyService family = new FamilyService();

    public List<Family> getAllFamilies() {
        return family.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return family.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return family.deleteFamily(index);
    }


    public void saveFamily(Family f) {
        family.saveFamily(f);
    }
}

