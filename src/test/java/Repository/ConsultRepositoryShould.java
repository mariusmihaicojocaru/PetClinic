package Repository;

import Model.Consult;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultRepositoryShould {

    ConsultRepository consultRepository = new ConsultRepository ();

    @Test
    public void addConsult(){
        Consult consult1 = buildConsult();
        consult1.setConsultId(25);
        consultRepository.addConsult(consult1);

        Consult consult2 = consultRepository.getConsultById(consult1.getConsultId());

        assertEquals(consult1.getConsultId (), consult2.getConsultId ());

        consultRepository.deleteConsult(consult1);
    }

    @Test
    public void viewAllConsults(){
        Consult consult1 = buildConsult();
        consultRepository.addConsult(consult1);

        List<Consult> consultList = consultRepository.viewAllConsults();

        assertEquals(1, consultRepository.viewAllConsults().size());
        assertConsult(consult1, consultList.get(0));

        consultRepository.deleteConsult(consult1);
        consultList.clear();
    }

    @Test
    public void getConsultById(){
        Consult consult1 = buildConsult();
        consultRepository.addConsult(consult1);

        List<Consult> consultList = consultRepository.viewAllConsults ();

        assertEquals(1, consultList.size());
        assertConsult(consult1, consultList.get(0));

        consultRepository.deleteConsult(consult1);
        consultList.clear();
    }

    @Test
    public void deleteConsult(){
        Consult consult1 = buildConsult();
        Consult consult2 = consultRepository.addConsult(consult1);

        consultRepository.deleteConsult(consult1);

        assertNull(consultRepository.getConsultById(consult2.getConsultId ()));
    }

    @Test
    public void updateConsult(){
        Consult consult1 = buildConsult();
        Consult consult2 = consultRepository.addConsult(consult1);
        consult2.setDescription ("new description");

        consultRepository.updateConsult(consult2);

        Consult updatedConsult = consultRepository.getConsultById (consult2.getConsultId());
        assertEquals("new description", updatedConsult.getDescription());

        consultRepository.deleteConsult(consult2);
    }

    private void assertConsult(Consult firstConsult, Consult secondConsult){
        DateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        assertEquals(df.format(firstConsult.getDate()), df.format(secondConsult.getDate()));
        assertEquals(firstConsult.getDescription(), secondConsult.getDescription());
        assertEquals(firstConsult.getConsultId(), secondConsult.getConsultId());
    }

    private Consult buildConsult(){
        Consult consult = new Consult();
        consult.setDate(new Date());
        consult.setDescription("description");

        return consult;
    }

}