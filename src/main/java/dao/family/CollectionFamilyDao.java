package dao.family;

import family.Family;
import family.Pet;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDAO {
    private final List<Family> familyDB = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return  familyDB;
    }

    public void displayAllFamilies() {
        System.out.println(familyDB.toString());
    }

    public void getFamiliesBiggerThan() { }
    public void getFamiliesLessThan () { }
    public void countFamiliesWithMemberNumber() { }
    public void createNewFamily () { }
    public void deleteFamilyByIndex(int index) {
        deleteFamily(index);
    }

    public void bornChild() { }
    public void adoptChild () { }
    public void deleteAllChildrenOlderThen() { }
    public int count() {
        return familyDB.size();
    }

    public Family getFamilyById(int idx) {
        return getFamilyByIndex(idx);
    }

    public Pet getPets() {
        return new Pet();
    }

    public Pet addPets() {
        return new Pet();
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        return false;
    }

    @Override
    public void saveFamily(Family f) {

    }
}
