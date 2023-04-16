package family.services;

import family.Family;
import family.Human;
import family.Pet;
import family.dao.CollectionFamilyDAO;
import java.util.List;

public class FamilyService {

    private final CollectionFamilyDAO collection = new CollectionFamilyDAO();
    public List<Family> getAllFamilies () {
        return  collection.getAllFamilies();
    }
    public void displayAllFamilies() {
        getAllFamilies().forEach(System.out::println);
    }

    public void createNewFamily(Human father, Human mother) {
        Family family = new Family(father, mother);
        collection.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return collection.deleteFamily(index);
    }
    public int count() {
        return getAllFamilies().size();
    }
    public Family getFamilyById(int index) {
        return collection.getFamilyByIndex(index);
    }

    public List<Pet> getPets(int familyIndex) {
        return collection.getFamilyByIndex(familyIndex).getPets().stream().toList();
    }
    public void addPet(int familyIndex, Pet pet) {
        collection.getFamilyByIndex(familyIndex).getPets().add(pet);
    }





}
