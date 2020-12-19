package Repository;

import Connection.HibernateUtils;
import Model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VeterinarianRepository {

    public void addVeterinarian(Veterinarian veterinarian){
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.save (veterinarian);
            transaction.commit ();
            session.close ();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback ();
            }e.printStackTrace ();
        }
    }

    public List<Veterinarian> seeAllVeterinarians(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Veterinarian> veterinarians = session.createQuery("from Veterinarian", Veterinarian.class).list();

        for(Veterinarian veterinarian : veterinarians){
            System.out.println (veterinarian.toString ());
        }

        session.close();

        return veterinarians;
    }

    public Veterinarian getVeterinarianById(int id){

    Session session = HibernateUtils.getSessionFactory().openSession();

    Veterinarian veterinarian = session.find(Veterinarian.class, id);

    session.close();

    return veterinarian;

    }

    public void updateVeterinarian(Veterinarian veterinarian){

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.update(veterinarian);
            transaction.commit ();
            session.close ();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback ();
            }e.printStackTrace ();
        }
    }

    public void deleteVeterinarian(Veterinarian veterinarian){

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.delete (veterinarian);
            transaction.commit ();
            session.close ();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback ();
            }e.printStackTrace ();
        }
    }

}
