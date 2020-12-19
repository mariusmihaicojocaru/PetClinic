package Repository;

import Connection.HibernateUtils;
import Model.Consult;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ConsultRepository {

    public Consult addConsult (Consult consult) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.save(consult);
            transaction.commit ();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback ();
            }
            e.printStackTrace ();
        }
        return consult;
    }

    public List<Consult> viewAllConsults() {

        Session session = HibernateUtils.getSessionFactory ().openSession ();

        List<Consult> consultList = session.createQuery ("from Consult", Consult.class).list ();

        for (Consult consult : consultList) {
            System.out.println (consult.toString ());
        }
        session.close ();

        return consultList;
    }

    public Consult getConsultById(int id){
        Session session = HibernateUtils.getSessionFactory ().openSession ();

        Consult consult = session.find (Consult.class, id);

        session.close();

        return consult;
    }

    public void updateConsult (Consult consult) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.update(consult);
            transaction.commit ();
            session.close ();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback ();
            }e.printStackTrace ();
        }
    }

    public void deleteConsult (Consult consult) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory ().openSession ();
            transaction = session.beginTransaction ();
            session.delete (consult);
            transaction.commit ();
            session.close ();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback ();
            }
            e.printStackTrace ();
        }
    }
}
