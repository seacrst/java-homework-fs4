package family.dao;

import family.Family;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> familyDB = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return familyDB;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return familyDB.get(index);
    }

    @Override
    public boolean deleteFamily(Family family) {
        return deleteFamily(familyDB.indexOf(family));
    }

    @Override
    public boolean deleteFamily(int index) {
        Family family = getFamilyByIndex(index);
        familyDB.remove(index);

        return familyDB.contains(family);
    }

    @Override
    public void saveFamily(Family family) {
        familyDB = familyDB.stream().filter(fam -> !fam.equals(family)).collect(Collectors.toList());
        familyDB.add(family);
    }
}
