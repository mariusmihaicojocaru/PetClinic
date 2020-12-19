package Repository;

import Connection.HibernateUtils;
import Model.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PetRepository {

    public Pet addPet(Pet pet) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.save (pet);
            transaction.commit ();
            session.close ();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback ();
            }e.printStackTrace ();
        }
        return pet;
    }

    public List<Pet> getAllPets(){

        Session session = HibernateUtils.getSessionFactory().openSession ();

        List<Pet> pets = session.createQuery("from Pet", Pet.class).list ();

        for(Pet pet : pets){
            System.out.println (pet.toString ());
        }

        session.close();

        return pets;
    }

    public Pet getPetById(int id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Pet pet = session.find(Pet.class, id);
        return pet;
    }

    public void updatePet(Pet pet){

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.update (pet);
            transaction.commit ();
            session.close ();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback ();
            }e.printStackTrace ();
        }
    }

    public void deletePet(Pet pet){

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.delete (pet);
            transaction.commit ();
            session.close ();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback ();
            }e.printStackTrace ();
        }
    }

    public void deleteAll(){
        Session session = HibernateUtils.getSessionFactory ().openSession ();
        Transaction transaction = session.beginTransaction ();
        String hql = "DELETE FROM Pet";
        Query deletePets = session.createQuery(hql);
        deletePets.executeUpdate();
        transaction.commit ();
        session.close();
    }

}
